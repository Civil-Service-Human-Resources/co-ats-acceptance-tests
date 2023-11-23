package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class BasicDetails(template: String, vacancyTitle: String, closingDate: Int)

object BasicDetailsSection extends VacancyBasePage {

  val createVacancyTitle              = "Create New Vacancy : Civil Service Jobs - GOV.UK"
  val displayWelshPath                = ".//input[@name='datafield_179408_1_1']"
  val closingDateId                   = "edit_opp_form_pcd"
  val liveHourPath                    = ".//select[@id='edit_opp_form_pld_hh']//option[@selected='selected']"
  val closingHourPath                 = ".//select[@id='edit_opp_form_pcd_hh']//option[@selected='selected']"
  val liveMinutePath                  = ".//select[@id='edit_opp_form_pld_mm']//option[@selected='selected']"
  val closingMinutePath               = ".//select[@id='edit_opp_form_pcd_mm']//option[@selected='selected']"
  val selectTemplatePath              = "//*[@id='select2-edit_opp_form_template_id-container']"
  val enterTemplatePath               = ".//input[@class='select2-search__field']"
  val newVacancyPath                  = ".//a[contains(@href,'recruiter/opportunities/vacancy/create')]"
  val vacancySectionPath              = "//*[@id='lm-vacancies']/h3/a"
  val extractFormClass                = "opp_form_bd"
  var formId: String                  = ""
  var applicationLiveDate: String     = ""
  var applicationLiveTime: String     = ""
  var applicationClosingDate: String  = ""
  var appConvertedClosingDate: String = ""
  var applicationClosingTime: String  = ""
  var convertedLiveDateTime           = ""
  var convertedClosingDateTime        = ""
  var vacancyName                     = ""

  private def displayWelshVersion(): WebElement =
    waitForVisibilityOfElementByPath(displayWelshPath)

  private def title(): TextField       = textField("title")
  private def closingDate(): TextField = textField(closingDateId)

  private def templateSelect: WebElement = waitForVisibilityOfElementByPath(selectTemplatePath)
  private def enterTemplate: WebElement  = waitForVisibilityOfElementByPath(enterTemplatePath)
  private def newVacancy: WebElement     = waitForVisibilityOfElementByPathLast(newVacancyPath)
  private def vacancySection: WebElement = waitForVisibilityOfElementByPathLast(vacancySectionPath)

  private def selectTemplate(basicDetails: BasicDetails): Unit = {
    templateSelect.click()
    enterTemplate.sendKeys(basicDetails.template)
    enterTemplate.sendKeys(Keys.ENTER)
  }

  private def enterVacancyTitle(basicDetails: BasicDetails): Unit = {
    vacancyName = basicDetails.vacancyTitle
    title().value = vacancyName
  }

  private def selectClosingDate(basicDetails: BasicDetails): Unit = {
    closingDate().value = appClosingDate(basicDetails.closingDate)
    runDateTime(basicDetails.closingDate)
  }

  private def runDateTime(days: Int): Unit = {
    covertLiveDate()
    appLiveTime()
    covertClosingDate(days)
    appClosingTime()
    convertedLiveDateTime = s"$applicationLiveDate at $applicationLiveTime GMT"
    convertedClosingDateTime = s"$appConvertedClosingDate at $applicationClosingTime GMT"
  }

  def createNewVacancy(): Unit = {
    if (newVacancy.getText == "Create New Vacancy") newVacancy.click()
    else {
      vacancySection.click()
      newVacancy.click()
    }
    eventually(onPage(createVacancyTitle))
  }

  def appClosingDate(days: Int): String = {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val now       = LocalDate.now()
    val addDays   = now.plusDays(days)
    applicationClosingDate = addDays.format(formatter)
    applicationClosingDate
  }

  def covertLiveDate(): String = {
    val formatter  = DateTimeFormatter.ofPattern("dd MMMM yyyy")
    val dateFormat = LocalDate.now()
    applicationLiveDate = dateFormat.format(formatter)
    applicationLiveDate
  }

  def covertClosingDate(days: Int): String = {
    val formatter  = DateTimeFormatter.ofPattern("dd MMMM yyyy")
    val dateFormat = LocalDate.now().plusDays(days)
    appConvertedClosingDate = dateFormat.format(formatter)
    appConvertedClosingDate
  }

  def appClosingTime(): String = {
    val hourClosing   = waitForVisibilityOfElementByPath(closingHourPath).getText
    val minuteClosing = waitForVisibilityOfElementByPath(closingMinutePath).getText
    applicationClosingTime = s"$hourClosing:$minuteClosing:00"
    applicationClosingTime
  }

  def appLiveTime(): String = {
    val hourlive   = waitForVisibilityOfElementByPath(liveHourPath).getText
    val minuteLive = waitForVisibilityOfElementByPath(liveMinutePath).getText
    applicationLiveTime = s"$hourlive:$minuteLive:00"
    applicationLiveTime
  }

  private def extractFormId(): String = {
    waitForTemplateLoad()
    val formClass = driver.findElement(By.className(extractFormClass))
    formId = formClass.getAttribute("id")
    formId
  }

  private def waitForTemplateLoad(): Unit =
    displayWelshVersion()

  private val basicInfo: Seq[BasicDetails => Unit] = Seq(
    selectTemplate,
    enterVacancyTitle,
    selectClosingDate
  )

  def basicDetailsSection(newVacancyDetails: NewVacancyDetails): Unit = {
    basicInfo.foreach { f =>
      f(newVacancyDetails.basicDetails)
    }
    extractFormId()
  }
}
