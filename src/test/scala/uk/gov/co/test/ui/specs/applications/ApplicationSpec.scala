package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.v9.applicants.MASTER_REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.vx.vacancy.MASTER_VACANCY_DATA
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.fillFullApplicationDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.weAreCheckingYourApplicationState
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Recruiter & Candidate Complete Full Application Process") {
    Scenario("VX: All Forms; Master Application Process", RunInVX) {
      Given("new vacancy is created and posted")
//      fillNewVacancyForm(MASTER_VACANCY_DATA)
      extractAllVacancyDetails("10459")

      When("recruiter & new candidate complete the full application")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      fillFullApplicationDetails()

      Then("the candidate is notified of application checks")
      weAreCheckingYourApplicationState()
    }
  }
}
