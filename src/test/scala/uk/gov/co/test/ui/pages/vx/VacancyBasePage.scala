package uk.gov.co.test.ui.pages.vx

import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.pages.BasePage

case class RecruiterDetails(
  username: String,
  password: String
)

trait VacancyBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String           = ""
  val vxConfigUrl: String   = "https://cshr-config.tal.net/vx/lang-en-GB/ats/login"
  val vxConfigTitle         = "Oleeo vX Login : CSR"
  val vxConfigHomePageTitle = "Home : Civil Service Jobs - GOV.UK"

  def username(): TextField     = textField("user")
  def password(): PasswordField = pwdField("password")

  def navigateToVxConfigLogin(): Unit = {
    go to vxConfigUrl
    eventually(pageTitle shouldEqual vxConfigTitle)
//    eventually(onPage(vxConfigTitle))
  }

  def enterUsername(recruiterDetails: RecruiterDetails): Unit =
    username().value = recruiterDetails.username

  def enterPassword(recruiterDetails: RecruiterDetails): Unit =
    password().value = recruiterDetails.password

  def loginProcess(): Unit =
    waitForElementToBeClickableByPath("*//button[@id='login-button']").click()

}
