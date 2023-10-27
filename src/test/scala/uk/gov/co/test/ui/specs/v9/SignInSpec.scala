package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9
import uk.gov.co.test.ui.utils.REGISTERED_CANDIDATE

class SignInSpec extends BaseFeatureSpec {
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
  }
}
