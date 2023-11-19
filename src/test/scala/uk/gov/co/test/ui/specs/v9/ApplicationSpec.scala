package uk.gov.co.test.ui.specs.v9

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.v9.{CANDIDATE_SHORT_FORM_DATA, REGISTERED_CANDIDATE, REGISTER_CANDIDATE}
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn, onPage}
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
      fillNewCandidateDetails(REGISTER_CANDIDATE)

      When("The candidate completes the short form")
      fillShortFormDetails(CANDIDATE_SHORT_FORM_DATA)

      Then("The candidate is able to see their account")
      eventually(onPage("Application Centre - Civil Service Jobs - GOV.UK"))
      driver.findElement(By.xpath(".//input[@value='Advert Details']")).isDisplayed
      driver.findElement(By.xpath(".//input[@value='Withdraw Application']")).isDisplayed
      driver.findElement(By.tagName("b")).getText shouldEqual "Help with selection process"
    }
  }
}
