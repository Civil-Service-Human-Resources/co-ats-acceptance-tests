package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{fillVacancyDetails, vxConfigHomePageTitle}
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.{fillRecruiterDetails, navigateToVxConfigLogin}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX
import uk.gov.co.test.ui.utils.{RECRUITERS, VACANCIES}

class newVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A New Vacancy") {
    Scenario("An Existing Recruiter Is Able To Create A New Vacancy", RunInVX) {
      Given("A recruiter logins in to vx config")
      val registeredRecruiter = RECRUITERS
      navigateToVxConfigLogin()
      fillRecruiterDetails(registeredRecruiter)
      eventually(pageTitle shouldEqual vxConfigHomePageTitle)

      When("The recruiter creates a new vacancy")
      val newVacancy = VACANCIES
      fillVacancyDetails(newVacancy)

      Then("The vacancy is successfully created and posted")
    }
  }
}
