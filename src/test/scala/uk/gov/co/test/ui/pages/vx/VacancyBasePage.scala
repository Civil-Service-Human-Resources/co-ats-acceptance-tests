package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.conf.TestConfiguration.readProperty
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.pages.BasePage

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

}
