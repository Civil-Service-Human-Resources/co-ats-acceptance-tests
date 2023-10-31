package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class VacancyDetails(template: String, vacancyTitle: String, addDaysForClosingDate: Long)

object CreateNewVacancyPage extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"

  def title(): TextField       = textField("title")
  def closingDate(): TextField = textField("edit_opp_form_pcd")

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

  def enterVacancyTitle(vacancyDetails: VacancyDetails): Unit =
    title().value = vacancyDetails.vacancyTitle

  def selectClosingDate(vacancyDetails: VacancyDetails): Unit = {
    closingDate().value = appClosingDate(vacancyDetails)
    println("Hello")
  }

  def createNewVacancy(): Unit = {
    if (newVacancy.getText == "Create New Vacancy") newVacancy.click()
    else {
      vacancySection.click()
      newVacancy.click()
    }
    eventually(onPage(createVacancyTitle))
  }

  def appClosingDate(vacancyDetails: VacancyDetails): String = {
    val formatter   = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val now         = LocalDate.now()
    val addDays     = now.plusDays(vacancyDetails.addDaysForClosingDate)
    val closingDate = addDays.format(formatter)
    closingDate
  }
}
