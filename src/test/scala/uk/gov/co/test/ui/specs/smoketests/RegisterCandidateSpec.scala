package uk.gov.co.test.ui.specs.smoketests

import uk.gov.co.test.ui.data.v9.applicants.{REGISTERED_CANDIDATE, REGISTER_CANDIDATE}
import uk.gov.co.test.ui.flows.v9.DacAudit24TestCandidates.createDacTestCandidates
import uk.gov.co.test.ui.flows.v9.GenerateNewCandidates.createMultipleCandidates
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.applicationCentrePageTitle
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{accountCreatedSuccess1, accountCreatedSuccess2, accountCreatedSuccessMessage1, accountCreatedSuccessMessage2, candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn, editAccountDetails, onPage}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class RegisterCandidateSpec extends BaseFeatureSpec {
  Feature("Registration Of Candidates On Civil Service Jobs") {
    Scenario("V9: A Registered Candidate Logs In To Civil Service Jobs", RunInV9) {
      Given("A registered candidate navigates to the sign in page")
      navigateToSignInOrCreateAccount()

      When("The candidate signs into their cs jobs account")
      candidateSignIn(REGISTERED_CANDIDATE)

      Then("The candidate is able to see their account")
      candidateDisplayName() shouldEqual candidateFullName(REGISTERED_CANDIDATE)
    }

    Scenario("V9: A Candidate Creates An Account On Civil Service Jobs", RunInV9) {
      Given("candidate newly registers their details")
      fillNewCandidateDetails(REGISTER_CANDIDATE)

      When("candidate confirms the account has been created")
      accountCreatedSuccess1() shouldEqual accountCreatedSuccessMessage1
      accountCreatedSuccess2() shouldEqual accountCreatedSuccessMessage2
      candidateDisplayName()   shouldEqual candidateFullName(REGISTER_CANDIDATE)

      Then("the candidate navigates to the edit account details page")
      editAccountDetails().click()
      onPage(applicationCentrePageTitle)
    }

    Scenario("V9: Create Multiple Candidate Accounts", RunInV9) {
      createMultipleCandidates(5)
    }

    Scenario("VX: Create DAC Candidate Accounts For All Requests", RunInV9) {
      createDacTestCandidates(1, "0000", 2)
      createDacTestCandidates(2, "10349", 2)
      createDacTestCandidates(3, "10350", 2)
      createDacTestCandidates(4, "10348", 2)
      createDacTestCandidates(5, "0000", 2)
      createDacTestCandidates(6, "10349", 2)
      createDacTestCandidates(7, "10350", 2)
      createDacTestCandidates(8, "10350", 2)
    }
  }
}
