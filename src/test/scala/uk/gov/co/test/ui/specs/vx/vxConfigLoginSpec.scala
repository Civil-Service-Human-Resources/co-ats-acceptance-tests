package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.vx.RECRUITER
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.vxConfigHomePageTitle
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.onPage
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class vxConfigLoginSpec extends BaseFeatureSpec {
  Feature("Recruiter Login To VX Config System") {
    Scenario("An Existing Recruiter Logs In VX Config", RunInVX) {
      Given("A recruiter navigates to the login page")
      val registeredRecruiter = RECRUITER

      When("The recruiter logins into their vx config account")
      loginWithRecruiterDetails(registeredRecruiter)

      Then("The recruiter is able to see their account")
      eventually(onPage(vxConfigHomePageTitle))
    }
  }
}
