package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.data.v9.applicants.{MAIN_REGISTER_CANDIDATE, REGISTERED_CANDIDATE}
import uk.gov.co.test.ui.data.v9.shortform.MAIN_CANDIDATE_SHORT_FORM_DATA
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn}
import uk.gov.co.test.ui.pages.vx.DashboardPage.confirmShortFormCompletion
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Candidate Login To Civil Service Jobs") {
    Scenario("A Registered Candidate Logs In To Civil Service Jobs", RunInV9) {
      Given("A candidate navigates to the sign in page")
      navigateToSignInOrCreateAccount()

      When("The candidate signs into their cs jobs account")
      candidateSignIn(REGISTERED_CANDIDATE)

      Then("The candidate is able to see their account")
      candidateDisplayName() shouldEqual candidateFullName(REGISTERED_CANDIDATE)
    }

    Scenario("A Newly Registered Candidate No.2 Applies For A Job", RunInV9) {
      Given("A candidate no.2 registers a new account")
      fillNewCandidateDetails(MAIN_REGISTER_CANDIDATE)

      When("The candidate no.2 completes the short form")
      fillShortFormDetails(MAIN_CANDIDATE_SHORT_FORM_DATA)

      Then("The candidate no.2 is able to see their account")
      confirmShortFormCompletion()
    }
  }
}
