package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.data.v9.applicants.MAIN_REGISTER_CANDIDATE
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.applicationCentrePageTitle
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{accountCreatedSuccess1, accountCreatedSuccess2, accountCreatedSuccessMessage1, accountCreatedSuccessMessage2, candidateDisplayName}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, editAccountDetails, onPage}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class RegisterCandidateSpec extends BaseFeatureSpec {
  Feature("Register Candidate On Civil Service Jobs") {
    Scenario("A Candidate Creates An Account On Civil Service Jobs", RunInV9) {
      Given("the candidate enters their details for new account")
      fillNewCandidateDetails(MAIN_REGISTER_CANDIDATE)

      When("the candidate navigates to the edit account details page")
      accountCreatedSuccess1() shouldEqual accountCreatedSuccessMessage1
      accountCreatedSuccess2() shouldEqual accountCreatedSuccessMessage2
      candidateDisplayName()   shouldEqual candidateFullName(MAIN_REGISTER_CANDIDATE)
      editAccountDetails().click()

      Then("the candidate is able to edit their account")
      onPage(applicationCentrePageTitle)
    }
  }
}
