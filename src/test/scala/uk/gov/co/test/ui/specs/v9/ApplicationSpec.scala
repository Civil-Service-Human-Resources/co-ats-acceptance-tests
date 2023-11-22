package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.data.v9.applicants.{REGISTERED_CANDIDATE, REGISTER_CANDIDATE_1, REGISTER_CANDIDATE_2}
import uk.gov.co.test.ui.data.v9.shortform.{CANDIDATE_SHORT_FORM_DATA_1, CANDIDATE_SHORT_FORM_DATA_2}
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{advertDetailsFunction, applicationCentreTitle, helpWithSelectionText, onPage, withdrawApplicationFunction}
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn}
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

    Scenario("A Newly Registered Candidate No.1 Applies For A Job", RunInV9) {
      Given("A candidate no.1 registers a new account")
      fillNewCandidateDetails(REGISTER_CANDIDATE_1)

      When("The candidate no.1 completes the short form")
      fillShortFormDetails(CANDIDATE_SHORT_FORM_DATA_1)

      Then("The candidate no.1 is able to see their account")
      eventually(onPage(applicationCentreTitle))
      advertDetailsFunction().isDisplayed
      withdrawApplicationFunction().isDisplayed
      helpWithSelectionText() shouldEqual "Help with selection process"
    }

    Scenario("A Newly Registered Candidate No.2 Applies For A Job", RunInV9) {
      Given("A candidate no.2 registers a new account")
      fillNewCandidateDetails(REGISTER_CANDIDATE_2)

      When("The candidate no.2 completes the short form")
      fillShortFormDetails(CANDIDATE_SHORT_FORM_DATA_2)

      Then("The candidate no.2 is able to see their account")
      eventually(onPage(applicationCentreTitle))
      advertDetailsFunction().isDisplayed
      withdrawApplicationFunction().isDisplayed
      helpWithSelectionText() shouldEqual "Help with selection process"
    }
  }
}
