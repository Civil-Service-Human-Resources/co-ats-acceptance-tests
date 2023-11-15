package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.conf.TestConfiguration.readProperty
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.pages.BasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.applicationClosingDate

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class RecruiterDetails(
  username: String,
  password: String
)

trait VacancyBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String              = TestConfiguration.url("vxconfig")
  val vxConfigTitle            = "Oleeo vX Login : CSR"
  val vxConfigHomePageTitle    = "Home : Civil Service Jobs - GOV.UK"
  val nameVxConfig: String     = readProperty("services.vxconfig.admin.contact_name")
  val emailVxConfig: String    = readProperty("services.vxconfig.admin.contact_email")
  val usernameVxConfig: String = readProperty("services.vxconfig.admin.username")
  val passwordVxConfig: String = readProperty("services.vxconfig.admin.password")
  val getOs: String            = System.getProperty("os.name").toLowerCase
  lazy val generalInput        = "//input[@class='select2-search__field']"

  def username(): TextField     = textField("user")
  def password(): PasswordField = pwdField("password")

  def navigateToVxConfigLogin(): Unit = {
    go to url
    eventually(onPage(vxConfigTitle))
  }

  def enterUsername(recruiterDetails: RecruiterDetails): Unit =
    username().value = recruiterDetails.username

  def enterPassword(recruiterDetails: RecruiterDetails): Unit =
    password().value = recruiterDetails.password

  def loginProcess(): Unit =
    waitForElementToBeClickableByPath("*//button[@id='login-button']").click()

  def userProfile(): WebElement = waitForElementToBeClickableByPath(
    "//*[@class='user_link']"
  )

  def logoutVX(): Unit = {
    userProfile().click()
    waitForElementClickableByPath(".//a[@class='logout_button']").click()
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

  def enterTestDeadline(deadline: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (day, month, year) = splitDate(deadline)
    enterDate(dayId, day)
    enterDate(monthId, month)
    enterDate(yearId, year)
  }

  def groupTestsDeadlineDate(days: Int): String = {
    val formatter         = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formatToLocalDate = LocalDate.parse(applicationClosingDate, formatter)
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

}
