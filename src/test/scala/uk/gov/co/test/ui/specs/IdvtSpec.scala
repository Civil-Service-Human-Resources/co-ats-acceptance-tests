package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9EussStatus, v9IdvtDataConsent, v9RtwBritishCitizen, v9RtwHoldPassport, v9SmartphoneAccess}
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.IdvtFlow.idvtFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmPecRtwAndDbsAnyState, confirmPecRtwOnlyCrcNoneNotApplicable, confirmPecRtwOnlyAndDBSEnhancedStartCheck, confirmPecRtwOnlyStartCheckState, confirmPecRtwOnlyState, confirmTrustIdQrCode}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{digitalIdentityCheckInProgress, invitedToDigitalIdentityCheck, manualIdCheck, manualIdCheckWithIdvt, rtwCheckAvailable, rtwCheckAvailableWithIdvt}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class IdvtSpec extends BaseFeatureSpec {
  Feature("IDVT Checks - IDVT: RTW Only") {
    Scenario("VX: (IDVT: RTW Only; CRC: None) - No Passport", RunInVX) {
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

    Scenario("VX: (IDVT: RTW Only; CRC: None) - No Consent", RunInVX) {
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

    Scenario("VX: (IDVT: RTW Only; CRC: None) - No Smartphone", RunInVX) {
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

    Scenario("VX: (IDVT: RTW Only; CRC: None) - Start IDVT Check", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9922")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_04)

      When("candidate completes pec form with rtw completed")
      idvtFlow()

      Then("the application is at idvt checks position")
      confirmPecRtwOnlyStartCheckState()
      invitedToDigitalIdentityCheck()
    }

    Scenario("VX: (IDVT: RTW Only; CRC: None and Not Applicable) - Share Code & Manual ID Check", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9988")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_05)

      When("candidate completes pec form and enters rtw share code & uploads id")
      v9RtwBritishCitizen = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwOnlyCrcNoneNotApplicable()
      manualIdCheck()
      rtwCheckAvailable()
      confirmPecRtwOnlyState()
    }

    Scenario("VX: (IDVT: RTW Only; CRC: None) - No Digital RTW Available", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9922")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_06)

      When("candidate completes pec form and enters rtw euss status")
      v9EussStatus = "I did not apply for the EU Settlement Scheme"
      v9RtwBritishCitizen = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwOnlyState()
      rtwCheckAvailable()
    }
  }

  Feature("IDVT Checks - IDVT: RTW Only; CRC: DBS Any)") {
    Scenario("VX: (IDVT: RTW Only; CRC: DBS Basic) - No Passport", RunInVX) {
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

    Scenario("VX: (IDVT: RTW Only; CRC: DBS Basic) - No Consent", RunInVX) {
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

    Scenario("VX: (IDVT: RTW Only; CRC: DBS Basic) - No Smartphone", RunInVX) {
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

    Scenario("VX: (IDVT: RTW Only; CRC: DBS Enhanced) - Manual ID Check And Start IDVT Check", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("10038")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_10)

      When("candidate completes pec form with rtw completed")
      idvtFlow()

      Then("the application is at idvt checks with manual id checks")
      confirmPecRtwOnlyCrcNoneNotApplicable()
      manualIdCheckWithIdvt()
      rtwCheckAvailableWithIdvt()
      confirmPecRtwAndDbsAnyState()
      invitedToDigitalIdentityCheck()
      confirmPecRtwOnlyAndDBSEnhancedStartCheck()

      And("trustId QR code is displayed and idvt in progress")
      confirmTrustIdQrCode()
      digitalIdentityCheckInProgress()
    }

    Scenario("VX: (IDVT: RTW Only; CRC: None and Not Applicable) - Share Code", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("10040")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_11)

      When("candidate completes pec form and enters rtw share code")
      v9RtwBritishCitizen = false
      idvtFlow()

      Then("the application is at rtw checks position")
      rtwCheckAvailable()
      confirmPecRtwOnlyState()
    }

    Scenario("VX: (IDVT: RTW Only; CRC: DBS Enhanced) - No Digital RTW Available", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("10038")
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_12)

      When("candidate completes pec form and enters rtw euss status")
      v9EussStatus = "I did not apply for the EU Settlement Scheme"
      v9RtwBritishCitizen = false
      idvtFlow()

      Then("the application is at rtw checks position")
      confirmPecRtwOnlyCrcNoneNotApplicable()
      rtwCheckAvailable()
    }
  }
}
