package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.conf.TestConfiguration.readProperty
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApplicationClosingDate, vacancyId}
import uk.gov.co.test.ui.data.vx.recruiters.{RECRUITER, RecruiterDetails}
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.checkV9LogoutState
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.BasePage
import uk.gov.co.test.ui.pages.v9.SignInPage.{navigateToV9Test, v9AcceptAllCookies, v9SearchCookiesById}
import uk.gov.co.test.ui.pages.vx.DashboardPage.searchOn
import uk.gov.co.test.ui.pages.vx.createvacancypage.AdvertSection.switchBack
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.extractTabFormId
import uk.gov.co.test.ui.pages.vx.vacancytabs.ExternalPostingsTab.addExternalPosting
import uk.gov.co.test.ui.pages.vx.vacancytabs.SummaryTab.confirmAndActivateVacancy

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util
import scala.collection.mutable.ListBuffer

trait VacancyBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String           = TestConfiguration.url("vxconfig")
  val vxConfigTitle         = "Oleeo vX Login : CSR"
  val vxConfigHomePageTitle = "Home : Civil Service Jobs - GOV.UK"

  val contactNameVxConfig: String  = readProperty("services.vxconfig.admin.contact_name")
  val contactEmailVxConfig: String = readProperty("services.vxconfig.admin.contact_email")
  val usernameVxConfig: String     = readProperty("services.vxconfig.admin.username")
  val passwordVxConfig: String     = readProperty("services.vxconfig.admin.password")
  val v9RefereeEmail: String       = readProperty("services.v9test.admin.referee_email")
  val getOs: String                = System.getProperty("os.name").toLowerCase
  val loginButtonPath: String      = "*//button[@id='login-button']"
  val logoutButtonPath: String     = ".//a[@class='logout_button']"
  val userProfilePath: String      = "//*[@class='user_link']"
  lazy val generalInput            = "//input[@class='select2-search__field']"
  val applicationCentrePageTitle   = "Your account details - Civil Service Jobs - GOV.UK"
  val vacancyStatusPath            = ".//*[@id='collapse_panel']//span[1]"
  val submitForm                   = "submit_button"

  def candidateSummaryId(noEle: String)        = s"candidate_summary_entry_cand_summary_col_$noEle"
  def findUsernameField: util.List[WebElement] = driver.findElements(By.id("user"))
  def username(): TextField                    = textField("user")
  def password(): PasswordField                = pwdField("password")

  def navigateToVxConfigLogin(): Unit = {
    go to url
    eventually(onPage(vxConfigTitle))
  }

  def enterUsername(recruiterDetails: RecruiterDetails): Unit =
    username().value = recruiterDetails.username

  def enterPassword(recruiterDetails: RecruiterDetails): Unit =
    password().value = recruiterDetails.password

  def vxLogin(): Unit =
    waitForElementToBeClickableByPath(loginButtonPath).click()

  def userProfile(): WebElement = waitForElementToBeClickableByPath(userProfilePath)

  def logoutVX(): Unit = {
    userProfile().click()
    waitForElementClickableByPath(logoutButtonPath).click()
    eventually(onPage(vxConfigTitle))
  }

  def getAssessSectionText(sectionTextId: String): String = {
    scrollToElement(By.id(sectionTextId))
    val assessment     = waitForVisibilityOfElementById(sectionTextId)
    val onlineTestText = assessment.getText
    onlineTestText
  }

  def waitForDropdownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$option']")

  def waitForDropdownOptionByText(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@role='option' and text()='$option']")

  def waitForDropdownHistoryOptionByText(id: String): WebElement =
    waitForVisibilityOfElementByPath(s".//*[@id='$id']")

  def selectActionLocator(value: String): Unit = {
    action().moveToElement(waitForDropdownOptionByText(value)).perform()
    waitForDropdownOptionByText(value).click()
  }

  def splitDate(closingDate: String): (String, String, String) = {
    val date   = closingDate
    val parts  = date.split("/")
    val _day   = parts(0).replaceFirst("^0*", "")
    val _month = parts(1).replaceFirst("^0*", "")
    val _year  = parts(2)
    (_day, _month, _year)
  }

  def enterDateFields(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (_day, _month, _year) = splitDate(date)
    enterDate(dayId, _day)
    enterDate(monthId, _month)
    enterDate(yearId, _year)
  }

  def enterDate(id: String, value: String): Unit = {
    val dateValue = new Select(waitForVisibilityOfElementById(id))
    dateValue.selectByValue(value)
  }

  def enterStartTime(timeId: String, value: String): Unit = {
    val selectOption = waitForVisibilityOfElementById(timeId)
    selectOption.click()
    selectOption.sendKeys(value)
  }

  def enterTimeFields(time: String, hourId: String, minId: String): Unit = {
    val (_hour, _min) = splitStartTime(time)
    enterStartTime(hourId, _hour)
    enterStartTime(minId, _min)
  }

  def splitStartTime(timeField: String): (String, String) = {
    val time  = timeField
    val parts = time.split(":")
    val _hour = parts(0)
    val _min  = parts(1)
    (_hour, _min)
  }

  def groupTestsDeadlineDate(days: Int): String = {
    val formatter         = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formatToLocalDate = LocalDate.parse(vXApplicationClosingDate, formatter)
    val minusDays         = formatToLocalDate.minusDays(days)
    val groupTestDeadline = minusDays.format(formatter)
    groupTestDeadline
  }

  def selectOptionFromList(value: String, id: String, listValues: String): Unit = {
    waitForVisibilityOfElementById(id).click()
    val enterOption = waitForVisibilityOfElementByPath(generalInput)
    enterOption.clear()
    enterOption.sendKeys(value)
    action().moveToElement(waitForDropdownOptionByText(listValues)).perform()
    waitForDropdownOptionByText(listValues).click()
  }

  def enterValue(inputId: String, text: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
    enterOption.clear()
    enterOption.sendKeys(text)
    enterOption.sendKeys(Keys.ENTER)
  }

  def clearField(inputId: String): Unit = {
    val candidateInput = waitForVisibilityOfElementByPath(s".//textarea[@aria-describedby='$inputId']")
    candidateInput.sendKeys(Keys.BACK_SPACE)
  }

  def selectTypeOfRoles(roles: String, inputId: String): Unit = {
    val candidateInput = waitForVisibilityOfElementByPath(s".//textarea[@aria-describedby='$inputId']")
    candidateInput.sendKeys(roles)
    waitForDropdownOptionByText(roles).click()
  }

  def enterRoles(value: List[String], inputId: String): Unit = {
    clearField(inputId)
    for (role <- value)
      selectTypeOfRoles(role, inputId)
  }

  def enterTypeRoles(value: ListBuffer[String], inputId: String): Unit = {
    clearField(inputId)
    for (role <- value)
      selectTypeOfRoles(role, inputId)
  }

  def addWelshTranslation(
    addWelsh: Boolean,
    addTranslation: String,
    welshInput: String,
    welsh: String,
    updateId: String
  ): Unit =
    if (addWelsh) {
      clickOn(addTranslation)
      val field = waitForVisibilityOfElementById(welshInput)
      field.sendKeys(welsh)
      clickOn(updateId)
    }

  def addWelshTranslationIFrame(
    addWelsh: Boolean,
    addTranslation: String,
    welshInputIFrame: String,
    welshInput: String,
    welsh: String,
    updateId: String
  ): Unit =
    if (addWelsh) {
      clickOn(addTranslation)
      val switchFrame = driver.switchTo().frame(welshInputIFrame)
      val area        = switchFrame.findElement(By.id(welshInput))
      area.clear()
      area.sendKeys(welsh)
      switchBack()
      clickOn(updateId)
    }

  def activateAndPostVacancy(): Unit = {
    searchOn()
    confirmAndActivateVacancy()
    addExternalPosting()
    println(s"Vacancy ID: $vacancyId")
  }

  def repostVacancy(): Unit = {}

  def switchToVXConfig(): Unit = {
    switchToOtherWindow
    loginWithRecruiterDetails(RECRUITER)
  }

  def switchToV9Test(): Unit = {
    switchToOtherWindow
    navigateToV9Test()
    if (!v9SearchCookiesById().isEmpty) v9AcceptAllCookies()
    checkV9LogoutState()
  }

  def checkVacancyStatus(expectedStatus: String): Unit = {
    val status = waitForVisibilityOfElementByPath(vacancyStatusPath)
    status.isDisplayed
    status.getText shouldEqual s"Status$expectedStatus"
  }

  def moveVacancyOnViaTopBar(barId: String, tabPath: String): Unit = {
    clickOn(barId)
    waitForVisibilityOfElementByPath(tabPath).isSelected
    extractTabFormId()
  }

  def moveVacancyOnAndSendEmail(barId: String, tabPath: String, sendEMail: String): Unit = {
    clickOn(barId)
    waitForVisibilityOfElementByPath(tabPath).isDisplayed
    waitForVisibilityOfElementById(sendEMail).click()
  }

  def selectDropdownOption(selectId: String, selectOption: String): Unit = {
    waitForVisibilityOfElementById(selectId).click()
    action().moveToElement(waitForDropdownOption(selectOption)).perform()
    waitForDropdownOption(selectOption).click()
  }

  def splitTime(givenTime: String): (String, String) = {
    val time  = givenTime
    val parts = time.split(":")
    val _hour = parts(0)
    val _min  = parts(1)
    (_hour, _min)
  }

  def enterTime(id: String, value: String): Unit = {
    val timeValue = new Select(waitForVisibilityOfElementById(id))
    timeValue.selectByVisibleText(value)
  }

  def changeDateFormat(dateToFormat: String, formatStyle: String): String = {
    val formatter1 = DateTimeFormatter.ofPattern("d MMMM yyyy")
    val formatter2 = DateTimeFormatter.ofPattern("dd/MM/uuuu")
    val formatter3 = DateTimeFormatter.ofPattern("d MMM yyyy")
    if (formatStyle == "short") {
      val formattedDate = LocalDate.parse(dateToFormat, formatter1)
      formattedDate.format(formatter2)
    } else if (formatStyle == "long") {
      val formattedDate = LocalDate.parse(dateToFormat, formatter2)
      formattedDate.format(formatter1)
    } else {
      val formattedDate = LocalDate.parse(dateToFormat, formatter2)
      formattedDate.format(formatter3)
    }
  }

  def deleteTextFromField(fieldId: WebElement): Unit =
    if (fieldId.getText.nonEmpty) {
      if (!getOs.contains("mac")) {
        fieldId.sendKeys(Keys.CONTROL, "a")
      } else {
        fieldId.sendKeys(Keys.COMMAND, "a")
      }
      fieldId.sendKeys(Keys.BACK_SPACE)
    }
}
