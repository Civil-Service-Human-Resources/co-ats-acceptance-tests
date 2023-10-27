package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.navigateToCreateAccountPage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{accountCreatedSuccess1, accountCreatedSuccess2, accountCreatedSuccessMessage1, accountCreatedSuccessMessage2, candidateDisplayName}
import uk.gov.co.test.ui.pages.v9.SignInPage.candidateFullName
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9
import uk.gov.co.test.ui.utils.REGISTER_CANDIDATE

class RegisterCandidateSpec extends BaseFeatureSpec {
  Feature("Register Candidate On Civil Service Jobs") {
    Scenario("A Candidate Creates An Account On Civil Service Jobs", RunInV9) {
      Given("A candidate navigates to the creates an account page")
      val newCandidate = REGISTER_CANDIDATE
      navigateToCreateAccountPage()

      When("The candidate enters their details for new account")
      RegisterCandidateFlow.fillCandidateDetails(newCandidate)

      Then("The candidate is able to create a new account")
      accountCreatedSuccess1() shouldEqual accountCreatedSuccessMessage1
      accountCreatedSuccess2() shouldEqual accountCreatedSuccessMessage2
      candidateDisplayName()   shouldEqual candidateFullName(newCandidate)
    }
  }
}
