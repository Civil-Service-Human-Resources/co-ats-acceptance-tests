package uk.gov.co.test.ui.specs.v9

import org.scalatest.Ignore
import uk.gov.co.test.ui.data.v9.applicants.{REGISTERED_CANDIDATE, REGISTER_CANDIDATE_ONE}
import uk.gov.co.test.ui.flows.v9.GenerateNewCandidates.createMultipleCandidates
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.applicationCentrePageTitle
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{accountCreatedSuccess1, accountCreatedSuccess2, accountCreatedSuccessMessage1, accountCreatedSuccessMessage2, candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn, editAccountDetails, onPage}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class RegisterCandidateSpec extends BaseFeatureSpec {
  Feature("Register Candidate On Civil Service Jobs") {
    Scenario("A Registered Candidate Logs In To Civil Service Jobs", RunInV9) {
      Given("A candidate navigates to the sign in page")
      navigateToSignInOrCreateAccount()

      When("The candidate signs into their cs jobs account")
      candidateSignIn(REGISTERED_CANDIDATE)

      Then("The candidate is able to see their account")
      candidateDisplayName() shouldEqual candidateFullName(REGISTERED_CANDIDATE)
    }

    Scenario("A Candidate Creates An Account On Civil Service Jobs", RunInV9) {
      Given("the candidate enters their details for new account")
      fillNewCandidateDetails(REGISTER_CANDIDATE_ONE)

      When("the candidate navigates to the edit account details page")
      accountCreatedSuccess1() shouldEqual accountCreatedSuccessMessage1
      accountCreatedSuccess2() shouldEqual accountCreatedSuccessMessage2
      candidateDisplayName()   shouldEqual candidateFullName(REGISTER_CANDIDATE_ONE)
      editAccountDetails().click()

      Then("the candidate is able to edit their account")
      onPage(applicationCentrePageTitle)
    }

    Scenario("Create Candidate Accounts", RunInV9) {
      createMultipleCandidates(3)
    }
  }
}
