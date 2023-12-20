package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys, WebElement}
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXAppConvertedClosingDate, vXApplicationClosingDate, vXApplicationClosingTime, vXApplicationLiveDate, vXApplicationLiveTime, vXConvertedClosingDateTime, vXConvertedLiveDateTime, vacancyName}
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.specs.TestData.eventually

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class BasicDetails(
  template: String,
  vacancyTitle: String,
  addWelshTitle: Boolean,
  welshTitle: String,
  closingDate: Int
)

object BasicDetailsSection extends VacancyBasePage {

  val displayWelshPath      = ".//input[@name='datafield_179408_1_1']"
  val createVacancyTitle    = "Create New Vacancy : Civil Service Jobs - GOV.UK"
  val newVacancyPath        = ".//a[contains(@href,'recruiter/opportunities/vacancy/create')]"
  val vacancySectionPath    = "//*[@id='lm-vacancies']/h3/a"
  val closingDateId         = "edit_opp_form_pcd"
  val liveHourPath          = ".//select[@id='edit_opp_form_pld_hh']//option[@selected='selected']"
  val closingHourPath       = ".//select[@id='edit_opp_form_pcd_hh']//option[@selected='selected']"
  val liveMinutePath        = ".//select[@id='edit_opp_form_pld_mm']//option[@selected='selected']"
  val closingMinutePath     = ".//select[@id='edit_opp_form_pcd_mm']//option[@selected='selected']"
  val selectTemplatePath    = "//*[@id='select2-edit_opp_form_template_id-container']"
  val enterTemplatePath     = ".//input[@class='select2-search__field']"
  val extractFormClass      = "opp_form_bd"
  val addWelshTranslationId = "edit_opp_form_title_button"
  val welshTitleInput       = "edit_opp_form_title_cy"
  val updateWelshId         = "lbledit_edit_opp_form_title-update"
  var vacancyFormId: String = ""

  def newVacancy: WebElement     = waitForVisibilityOfElementByPathLast(newVacancyPath)
  def vacancySection: WebElement = waitForVisibilityOfElementByPathLast(vacancySectionPath)

  def createNewVacancy(): Unit = {
    if (newVacancy.getText == "Create New Vacancy") newVacancy.click()
    else {
      vacancySection.click()
      newVacancy.click()
    }
    eventually(onPage(createVacancyTitle))
  }

  private def displayWelshVersion(): WebElement =
    waitForVisibilityOfElementByPath(displayWelshPath)

  private def title(): TextField       = textField("title")
  private def closingDate(): TextField = textField(closingDateId)

  private def templateSelect: WebElement = waitForVisibilityOfElementByPath(selectTemplatePath)
  private def enterTemplate: WebElement  = waitForVisibilityOfElementByPath(enterTemplatePath)

  private def selectTemplate(basicDetails: BasicDetails): Unit = {
    templateSelect.click()
    enterTemplate.sendKeys(basicDetails.template)
    enterTemplate.sendKeys(Keys.ENTER)
  }

  private def enterVacancyTitle(basicDetails: BasicDetails): Unit = {
    vacancyName = basicDetails.vacancyTitle
    title().value = vacancyName
    addWelshTranslation(
      basicDetails.addWelshTitle,
      addWelshTranslationId,
      welshTitleInput,
      basicDetails.welshTitle,
      updateWelshId
    )
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
    vXConvertedLiveDateTime = s"$vXApplicationLiveDate at $vXApplicationLiveTime GMT"
    vXConvertedClosingDateTime = s"$vXAppConvertedClosingDate at $vXApplicationClosingTime GMT"
  }

  def appClosingDate(days: Int): String = {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val now       = LocalDate.now()
    val addDays   = now.plusDays(days)
    vXApplicationClosingDate = addDays.format(formatter)
    vXApplicationClosingDate
  }

  def covertLiveDate(): String = {
    val formatter  = DateTimeFormatter.ofPattern("d MMMM yyyy")
    val dateFormat = LocalDate.now()
    vXApplicationLiveDate = dateFormat.format(formatter)
    vXApplicationLiveDate
  }

  def covertClosingDate(days: Int): String = {
    val formatter  = DateTimeFormatter.ofPattern("d MMMM yyyy")
    val dateFormat = LocalDate.now().plusDays(days)
    vXAppConvertedClosingDate = dateFormat.format(formatter)
    vXAppConvertedClosingDate
  }

  def appClosingTime(): String = {
    val hourClosing   = waitForVisibilityOfElementByPath(closingHourPath).getText
    val minuteClosing = waitForVisibilityOfElementByPath(closingMinutePath).getText
    vXApplicationClosingTime = s"$hourClosing:$minuteClosing:00"
    vXApplicationClosingTime
  }

  def appLiveTime(): String = {
    val hourlive   = waitForVisibilityOfElementByPath(liveHourPath).getText
    val minuteLive = waitForVisibilityOfElementByPath(liveMinutePath).getText
    vXApplicationLiveTime = s"$hourlive:$minuteLive:00"
    vXApplicationLiveTime
  }

  private def extractFormId(): String = {
    waitForTemplateLoad()
    val formClass = driver.findElement(By.className(extractFormClass))
    vacancyFormId = formClass.getAttribute("id")
    vacancyFormId
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
