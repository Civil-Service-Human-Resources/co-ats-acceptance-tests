package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually

case class VacancyDetails(template: String)

object CreateNewVacancyPage extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"

  def templateSelect: WebElement = waitForVisibilityOfElementByPath(
    "//*[@id='select2-edit_opp_form_template_id-container']"
  )
  def enterTemplate: WebElement  = waitForVisibilityOfElementByPath(".//input[@class='select2-search__field']")
  def newVacancy: WebElement     = waitForVisibilityOfElementByPathLast(
    ".//a[contains(@href,'recruiter/opportunities/vacancy/create')]"
  )
  def vacancySection: WebElement = waitForVisibilityOfElementByPathLast("//*[@id='lm-vacancies']/h3/a")

  def selectTemplate(vacancy: VacancyDetails): Unit = {
    templateSelect.click()
    enterTemplate.sendKeys(vacancy.template)
    enterTemplate.sendKeys(Keys.ENTER)
  }

  def createNewVacancy(): Unit = {
    if (newVacancy.getText == "Create New Vacancy") newVacancy.click()
    else {
      vacancySection.click()
      newVacancy.click()
    }
    eventually(pageTitle shouldEqual createVacancyTitle)
  }
}
