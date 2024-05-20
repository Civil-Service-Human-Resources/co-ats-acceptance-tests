package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9BiometricPassportOrId, v9IdvtDataConsent, v9InDateDrivingLicence, v9SmartphoneAccess}
import uk.gov.co.test.ui.data.test.idvt.IDVT_FORM_DATA
import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_IDVT_01
import uk.gov.co.test.ui.flows.e2e.IdvtFlow.idvtFlow
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class IdvtSpec extends BaseFeatureSpec {
  Feature("Candidate & Recruiter Complete The IDVT Checks") {
    Scenario("VX: A Candidate Completes The IDVT; Full Application Process", RunInVX) {
      Given("candidate registers for new job application")
//      v9IdvtDataConsent = true
//      v9SmartphoneAccess = false
//      v9BiometricPassportOrId = true
//      v9InDateDrivingLicence = true
      extractAllVacancyDetails("9988")
//      fillNewVacancyForm(IDVT_VACANCY_DATA)
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_01)

      When("candidate completes all forms and idvt questions")
      v9IdvtDataConsent = true
      v9SmartphoneAccess = false
      idvtFlow()

      Then("the candidate is able to fully complete the pec form")


    }
  }
}
