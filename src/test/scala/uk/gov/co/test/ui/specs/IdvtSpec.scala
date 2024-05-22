package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9EussStatus, v9IdvtDataConsent, v9RtwBritishCitizen, v9RtwHoldPassport, v9SmartphoneAccess}
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.IdvtFlow.idvtFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmPecRtwAndDbsAnyState, confirmPecRtwBeforeManualIdCheckState, confirmPecRtwOnlyAndDBSEnhancedStartCheck, confirmPecRtwOnlyStartCheckState, confirmPecRtwOnlyState, confirmTrustIdQrCode}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{digitalIdentityCheckInProgress, invitedToDigitalIdentityCheck, manualIdCheck, manualIdCheckWithIdvt, rtwCheckAvailable, rtwCheckAvailableWithIdvt}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class IdvtSpec extends BaseFeatureSpec {
  Feature("Candidate & Recruiter IDVT Checks - RTW Only (IDVT: RTW)") {
    Scenario("VX: RTW Only (IDVT: RTW) - No Passport", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9922")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_01)

      When("candidate completes pec form with rtw no passport")
      v9RtwHoldPassport = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwOnlyState()
      rtwCheckAvailable()
    }

    Scenario("VX: RTW Only (IDVT: RTW) - No Consent", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9922")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_02)

      When("candidate completes pec form with rtw no consent")
      v9IdvtDataConsent = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwOnlyState()
      rtwCheckAvailable()
    }

    Scenario("VX: RTW Only (IDVT: RTW) - No Smartphone", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9922")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_03)

      When("candidate completes pec form with rtw no smartphone")
      v9SmartphoneAccess = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwOnlyState()
      rtwCheckAvailable()
    }

    Scenario("VX: RTW Only (IDVT: RTW) - Start IDVT Check", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9922")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_04)

      When("candidate completes pec form with rtw completed")
      idvtFlow()

      Then("the application is at idvt checks position")
      confirmPecRtwOnlyStartCheckState()
      invitedToDigitalIdentityCheck()
    }

    Scenario("VX: RTW Only (IDVT: RTW) - Share Code & Manual ID Check", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9988")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_05)

      When("candidate completes pec form and enters rtw share code & uploads id")
      v9RtwBritishCitizen = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwBeforeManualIdCheckState()
      manualIdCheck()
      rtwCheckAvailable()
      confirmPecRtwOnlyState()
    }

    Scenario("VX: RTW Only (IDVT: RTW) - No Digital RTW Available", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9922")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_06)

      When("candidate completes pec form and enters rtw euss status")
      v9EussStatus = "What is your European Union Settlement Scheme (EUSS) status?"
      v9RtwBritishCitizen = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwOnlyState()
      rtwCheckAvailable()
    }
  }

  Feature("Candidate & Recruiter IDVT Checks - RTW Only (IDVT: RTW & DBS)") {
    Scenario("VX: RTW Only (IDVT: RTW & DBS Basic) - No Passport", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("10036")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_07)

      When("candidate completes pec form with rtw no passport")
      v9RtwHoldPassport = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwAndDbsAnyState()
      rtwCheckAvailable()
    }

    Scenario("VX: RTW Only (IDVT: RTW & DBS Basic) - No Consent", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("10036")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_08)

      When("candidate completes pec form with rtw no consent")
      v9IdvtDataConsent = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwAndDbsAnyState()
      rtwCheckAvailable()
    }

    Scenario("VX: RTW Only (IDVT: RTW & DBS Basic) - No Smartphone", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("10036")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_09)

      When("candidate completes pec form with rtw no smartphone")
      v9SmartphoneAccess = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwAndDbsAnyState()
      rtwCheckAvailable()
    }

    Scenario("VX: RTW Only (IDVT: RTW & DBS Enhanced) - Manual ID Check And Start IDVT Check", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("10038")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_10)

      When("candidate completes pec form with rtw completed")
      idvtFlow()

      Then("the application is at idvt checks position")
      confirmPecRtwBeforeManualIdCheckState()
      manualIdCheckWithIdvt()
      rtwCheckAvailableWithIdvt()
      confirmPecRtwAndDbsAnyState()
      invitedToDigitalIdentityCheck()
      confirmPecRtwOnlyAndDBSEnhancedStartCheck()

      And("trustId QR code is displayed and idvt in progress")
      confirmTrustIdQrCode()
      digitalIdentityCheckInProgress()
    }

//    Scenario("VX: RTW Only (IDVT: RTW & DBS Enhanced) - Share Code & Manual ID Check", RunInVX) {
//      Given("candidate registers for new job application")
//      extractAllVacancyDetails("10029")
//      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_10)
//
//      When("candidate completes pec form and enters rtw share code & uploads id")
//      v9RtwBritishCitizen = false
//      idvtFlow()
//
//      Then("the application is at rtw checks position")
//      confirmPecRtwBeforeManualIdCheckState()
//      manualIdCheck()
//      rtwCheckAvailable()
//      confirmPecRtwOnlyState()
//    }

    //rtw only with rtw idvt setting>manual ID check>share code given
//    Scenario("VX: A Candidate Completes The IDVT; Full Application Process", RunInVX) {
//      Given("candidate registers for new job application")
//      v9IdvtDataConsent = true
//      //      v9SmartphoneAccess = false
//      //      v9BiometricPassportOrId = true
//      //      v9InDateDrivingLicence = true
//      extractAllVacancyDetails("9922")
//      //      fillNewVacancyForm(IDVT_VACANCY_DATA)
//      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_01)
//
//      When("candidate completes all forms and idvt questions")
//      v9RtwHoldPassport = false
//      idvtFlow()
//
//      Then("the candidate is able to fully complete the pec form")
//      confirmPecRtwBeforeManualIdCheckState()
//      manualIdCheck()
//      rtwCheckAvailable()
//      confirmPecRtwOnlyState()
//    }
  }
}
