package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.conf.TestConfiguration.readProperty
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vXApplicationClosingDate
import uk.gov.co.test.ui.data.vx.{RECRUITER, RecruiterDetails}
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.BasePage
import uk.gov.co.test.ui.pages.v9.SignInPage.{navigateToV9Test, v9AcceptAllCookies, v9SearchCookiesById}
import uk.gov.co.test.ui.pages.vx.DashboardPage.searchOn
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.extractTabFormId
import uk.gov.co.test.ui.pages.vx.vacancytabs.ExternalPostingsPage.addExternalPosting
import uk.gov.co.test.ui.pages.vx.vacancytabs.SummaryPage.confirmAndActivateVacancy

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util

trait VacancyBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String                  = TestConfiguration.url("vxconfig")
  val vxConfigTitle                = "Oleeo vX Login : CSR"
  val vxConfigHomePageTitle        = "Home : Civil Service Jobs - GOV.UK"
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
  val vacancyStatusPath            = ".//*[@id='collapse_panel']/span[1]"
  val submitForm                   = "submit_button"

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

  def loginProcess(): Unit =
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

  def enterDate(id: String, value: String): Unit = {
    val dateValue = new Select(waitForVisibilityOfElementById(id))
    dateValue.selectByValue(value)
  }

  def enterDateFields(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (_day, _month, _year) = splitDate(date)
    enterDate(dayId, _day)
    enterDate(monthId, _month)
    enterDate(yearId, _year)
  }

  def groupTestsDeadlineDate(days: Int): String = {
    val formatter         = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formatToLocalDate = LocalDate.parse(vXApplicationClosingDate, formatter)
    val minusDays         = formatToLocalDate.minusDays(days)
    val groupTestDeadline = minusDays.format(formatter)
    groupTestDeadline
  }

  def selectOptionFromList(value: String, id: String, inputPath: String): Unit = {
    waitForVisibilityOfElementById(id).click()
    val enterOption = waitForVisibilityOfElementByPath(generalInput)
    enterOption.sendKeys(value)
    action().moveToElement(waitForDropdownOptionByText(inputPath)).perform()
    waitForDropdownOptionByText(inputPath).click()
  }

  def enterText(inputId: String, text: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
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

  def addWelshTranslation(
    addWelsh: Boolean,
    addTranslation: String,
    welshInput: String,
    welsh: String,
    updateId: String
  ): Unit =
    if (addWelsh) {
      clickOn(addTranslation)
      waitForVisibilityOfElementById(welshInput)
      textField(welshInput).value = welsh
      clickOn(updateId)
    }

  def activateAndPostVacancy(): Unit = {
    searchOn()
    confirmAndActivateVacancy()
    addExternalPosting()
  }

  def switchToCandidatePages(): Unit = {
    openNewTabWithJavascript()
    openNewWindow()
    navigateToV9Test()
    if (!v9SearchCookiesById().isEmpty) v9AcceptAllCookies()
  }

  def switchToVXConfig(): Unit = {
    openAndSaveWindows()
    navigateToVxConfigLogin()
    loginWithRecruiterDetails(RECRUITER)
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

}
