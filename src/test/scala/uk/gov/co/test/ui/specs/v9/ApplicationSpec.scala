package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.data.v9.{CANDIDATE_APPLICATION_DATA, REGISTERED_CANDIDATE, REGISTER_CANDIDATE}
import uk.gov.co.test.ui.flows.v9.ApplicationFlow.fillApplicationDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillCandidateDetails
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.navigateToCreateAccountPage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn}
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.goToJobApply
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Candidate Login To Civil Service Jobs") {
    Scenario("A Registered Candidate Logs In To Civil Service Jobs", RunInV9) {
      Given("A candidate navigates to the sign in page")
      val registeredApplicant = REGISTERED_CANDIDATE
      navigateToSignInOrCreateAccount()

      When("The candidate signs into their cs jobs account")
      candidateSignIn(registeredApplicant)

      Then("The candidate is able to see their account")
      candidateDisplayName() shouldEqual candidateFullName(registeredApplicant)
    }

    Scenario("A Newly Registered Candidate Applies For A Job", RunInV9) {
      Given("A candidate registers a new account")
      val newCandidate = REGISTER_CANDIDATE
      navigateToCreateAccountPage()
      fillCandidateDetails(newCandidate)
      goToJobApply()

      When("The candidate completes the short form")
      val candidateDetails = CANDIDATE_APPLICATION_DATA
      fillApplicationDetails(candidateDetails)

      Then("The candidate is able to see their account")
    }
  }
}
