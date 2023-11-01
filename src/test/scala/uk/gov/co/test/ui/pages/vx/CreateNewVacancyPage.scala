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
  typeOfRole: String,
  profession: String,
  noOfJobs: String,
  approach: String,
  approval: Boolean,
  budgetaryAuthInfo: String,
  reserveList: Boolean,
  locationType: String,
  vacancyInNI: Boolean,
  giveLocationPreference: Boolean,
  contractType: String,
  workingPattern: String,
  jobGrade: String,
  currency: String,
  minSalary: Int,
  offerPension: Boolean,
  jobSummary: String,
  jobDescription: String,
  personSpec: String,
  selectionProcess: String,
  nameOfVacancyContact: String,
  emailOfVacancyContact: String,
  vacancyHolderName: String,
  vacancyHolderEmail: String,
  recruiterEmail: String
)

object CreateNewVacancyPage extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"
  var formId: String     = ""

  private lazy val businessAreaId    = s"select2-${formId}_datafield_155221_1_1-container"
  private lazy val whichProfessionId = s"select2-${formId}_datafield_155435_1_1-container"
  private lazy val noOfJobsId        = s"${formId}_datafield_155332_1_1"
  private lazy val generalInput      = "//input[@class='select2-search__field']"
  private lazy val typeOfRoleId      = s"select2-${formId}_datafield_155369_1_1-container"
  private lazy val typeOfRoleInput   = s".//*[@aria-describedby='$typeOfRoleId']"
  private lazy val approachId        = s"${formId}_field_154380_1"

  def extractFormId(): String = {
    val formClass = driver.findElement(By.className("opp_form_bd"))
    formId = formClass.getAttribute("id")
    formId
  }

  def noOfJobsInput(): TextField = textField(noOfJobsId)

  def businessAreaList(ele: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$ele']")

  def displayWelshVersion(): WebElement =
    waitForVisibilityOfElementByPath(".//input[@name='datafield_179408_1_1']")

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
    scrollToElement(By.id(businessAreaId))
    waitForVisibilityOfElementById(businessAreaId).click()
    selectOption(generalInput, vacancyDetails.businessArea)
  }

  def selectTypeOfRole(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(typeOfRoleId))
    selectOption(typeOfRoleInput, vacancyDetails.typeOfRole)
  }

  def whichProfessionIsJob(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(whichProfessionId))
    waitForVisibilityOfElementById(whichProfessionId).click()
    selectOption(generalInput, vacancyDetails.profession)
  }

  def noOfJobsAvailable(vacancyDetails: VacancyDetails): Unit =
    noOfJobsInput().value = vacancyDetails.noOfJobs

  def selectApproach(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(approachId))
    vacancyDetails.approach match {
      case "Pre-release"       => clickOnRadioButton(s"${formId}_datafield_154380_1_1_12648")
      case "Internal"          => clickOnRadioButton(s"${formId}_datafield_154380_1_1_11773")
      case "Across government" => clickOnRadioButton(s"${formId}_datafield_154380_1_1_12649")
      case "External"          => clickOnRadioButton(s"${formId}_datafield_154380_1_1_11774")
      case _                   => throw new IllegalStateException("Please select valid 'Approach' option")
    }
    println("Done!")
  }
}
