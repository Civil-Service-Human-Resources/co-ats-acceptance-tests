package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.test.nameblind._
import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_NAME_BLIND
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.fillFullApplicationDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.weAreCheckingYourApplicationState
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class NonNameBlindSpec extends BaseFeatureSpec {
  Feature("Recruiter & Candidate Complete Full Application Process For Non Name Blind Vacancy") {
    Scenario("VX: All Forms; Master Application Process", RunInVX) {
      Given("new non name-blind vacancy is created and posted")
      fillNewVacancyForm(NON_NAME_BLIND_VACANCY_DATA)
//      extractAllVacancyDetails("10323")

      When("recruiter & new candidate complete the full application")
      fillNewCandidateDetails(REGISTER_CANDIDATE_NAME_BLIND)
      fillFullApplicationDetails(
        NON_NAME_BLIND_SHORT_FORM_DATA,
        NON_NAME_BLIND_LONG_FORM_DATA,
        NON_NAME_BLIND_APPLICATION_DATA,
        NON_NAME_BLIND_PEC_FORM_DATA
      )

      Then("the candidate is notified of application checks")
      weAreCheckingYourApplicationState()
    }
  }
}
