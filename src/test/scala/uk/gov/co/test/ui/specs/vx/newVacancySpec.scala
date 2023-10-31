package uk.gov.co.test.ui.specs.vx

import org.openqa.selenium.Keys
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.vxConfigHomePageTitle
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.fillRecruiterDetails
import uk.gov.co.test.ui.pages.vx.CreateNewVacancyPage.{createNewVacancy, enterTemplate, templateSelect}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX
import uk.gov.co.test.ui.utils.RECRUITERS

class newVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A New Vacancy") {
    Scenario("An Existing Recruiter Is Able To Create A New Vacancy", RunInVX) {
      Given("A recruiter logins in to vx config")
      val registeredRecruiter = RECRUITERS
      fillRecruiterDetails(registeredRecruiter)
      eventually(pageTitle shouldEqual vxConfigHomePageTitle)

      When("The recruiter creates a new vacancy")
      val newVacancy = "Cabinet Office - apply online"
      createNewVacancy()
      templateSelect.click()
      enterTemplate.sendKeys(newVacancy)
      enterTemplate.sendKeys(Keys.ENTER)

      Then("The vacancy is successfully created and posted")
    }
  }
}
