package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_IDVT_01
import uk.gov.co.test.ui.flows.e2e.IdvtFlow.idvtFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class IdvtSpec extends BaseFeatureSpec {
  Feature("Candidate & Recruiter Complete The IDVT Checks") {
    Scenario("VX: A Candidate Completes The IDVT; Full Application Process", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9989")
//      fillNewVacancyForm(IDVT_VACANCY_DATA)
      fillNewCandidateDetails(REGISTER_CANDIDATE_IDVT_01)

      When("candidate completes all forms and idvt questions")
      idvtFlow()

      Then("the candidate is able to fully complete the pec form")

    }
  }
}
