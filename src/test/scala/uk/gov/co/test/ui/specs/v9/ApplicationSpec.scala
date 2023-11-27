package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.data.v9.applicants.MAIN_REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.v9.shortform.MAIN_CANDIDATE_SHORT_FORM_DATA
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetailsOnly
import uk.gov.co.test.ui.pages.vx.DashboardPage.confirmShortFormCompletion
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Candidate Login To Civil Service Jobs") {
    Scenario("A Newly Registered Candidate No.2 Applies For A Job", RunInV9) {
      Given("A candidate registers a new account")
      fillNewCandidateDetails(MAIN_REGISTER_CANDIDATE)

      When("The candidate completes the short form")
      fillShortFormDetailsOnly(MAIN_CANDIDATE_SHORT_FORM_DATA)

      Then("The candidate is able to see their account")
      confirmShortFormCompletion()
    }
  }
}
