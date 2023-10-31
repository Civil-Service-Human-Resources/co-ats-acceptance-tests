package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class VacancyDetails(
  template: String,
  vacancyTitle: String,
  addDaysForClosingDate: Long,
  businessArea: String,
  typeOfRole: String
)

object CreateNewVacancyPage extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"
  var formId: String     = ""

  private lazy val businessAreaElement = s"select2-${formId}_datafield_155221_1_1-container"
  private lazy val inputValue          = ".//input[@class='select2-search__field']"
  private lazy val typeOfRoleElement   = s"select2-${formId}_datafield_155369_1_1-container"
  private lazy val typeOfRoleInput     = s".//*[@aria-describedby='$typeOfRoleElement']"

  def extractFormId(): String = {
    val formClass = driver.findElement(By.className("opp_form_bd"))
    formId = formClass.getAttribute("id")
    formId
  }

  def displayWelshVersion(): WebElement =
    waitForVisibilityOfElementByPath(".//input[@name='datafield_179408_1_1']")

//  def businessAreaField(): TextField = textField(businessAreaInput)
//  def typeOfRole(): TextField        = textField(businessAreaInput)

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

  def selectClosingDate(vacancyDetails: VacancyDetails): Unit =
    closingDate().value = appClosingDate(vacancyDetails)

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

  def waitForTemplateLoad(): Unit = {
    displayWelshVersion()
    extractFormId()
  }

  def selectBusinessArea(vacancyDetails: VacancyDetails): Unit = {
    waitForTemplateLoad()
    scrollToElement(By.id(businessAreaElement))
    clickOn(businessAreaElement)
    val input = driver.findElement(By.xpath(inputValue))
    input.sendKeys(vacancyDetails.businessArea)
    input.sendKeys(Keys.ENTER)
  }

  def selectTypeOfRole(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.xpath(typeOfRoleInput))
    driver.findElement(By.xpath(typeOfRoleInput)).click()
    val input = driver.findElement(By.xpath(typeOfRoleInput))
    input.sendKeys(vacancyDetails.typeOfRole)
    input.sendKeys(Keys.ENTER)
  }
}
