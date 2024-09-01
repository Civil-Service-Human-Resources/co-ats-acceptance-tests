package uk.gov.co.test.ui.specs.smoketests

import org.scalatest.tagobjects.Retryable
import uk.gov.co.test.ui.data.MasterVacancyDetails.vacancyId
import uk.gov.co.test.ui.data.vx.recruiters.RECRUITER
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.untagVacancies
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.vxConfigHomePageTitle
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.onPage
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllApplyOnlyVacancyDetails
import uk.gov.co.test.ui.specs.BaseFeatureSpec

class RecruiterLoginSpec extends BaseFeatureSpec {
  Feature("Recruiter Login To VX Config System") {
    Scenario("An Existing Recruiter Logs In VX Config", Retryable) {
      Given("A recruiter navigates to the login page")
      val registeredRecruiter = RECRUITER

      When("The recruiter logins into their vx config account")
      loginWithRecruiterDetails(registeredRecruiter)

      Then("The recruiter is able to see their account")
      eventually(onPage(vxConfigHomePageTitle))
    }

    Scenario("VX: A Recruiter Extracts All Vacancy Details", Retryable) {
      extractAllApplyOnlyVacancyDetails(vacancyId)
    }

    Scenario("VX: A Recruiter Untags Vacancy Details", Retryable) {
      untagVacancies("9615")
    }
  }
}
