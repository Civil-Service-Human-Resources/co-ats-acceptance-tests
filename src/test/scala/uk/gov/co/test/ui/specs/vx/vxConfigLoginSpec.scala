package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.vxConfigHomePageTitle
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.{fillRecruiterDetails, navigateToVxConfigLogin}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX
import uk.gov.co.test.ui.utils.RECRUITERS

class vxConfigLoginSpec extends BaseFeatureSpec {
  Feature("Recruiter Login To VX Config System") {
    Scenario("An Existing Recruiter Logs In VX Config", RunInVX) {
      Given("A recruiter navigates to the login page")
      val registeredRecruiter = RECRUITERS
      navigateToVxConfigLogin()

      When("The recruiter logins into their vx config account")
      fillRecruiterDetails(registeredRecruiter)

      Then("The recruiter is able to see their account")
      eventually(pageTitle shouldEqual vxConfigHomePageTitle)

    }
  }
}
