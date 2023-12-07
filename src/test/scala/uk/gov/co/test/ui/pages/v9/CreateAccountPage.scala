package uk.gov.co.test.ui.pages.v9

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.navigateToSignInOrCreateAccount
import uk.gov.co.test.ui.pages.v9.SignInPage.{checkV9Logout, createAnAccount}

case class CandidateDetails(
  firstname: String,
  lastname: String,
  preferredFirstName: String,
  email: String,
  password: String,
  isEmployeeExistingPublicSector: Boolean,
  agreeTermsAndConditions: Boolean
)

object CreateAccountPage extends CivilServiceJobsBasePage {

  val createAccountTitle        = "Create an account - Civil Service Jobs - GOV.UK"
  val createAccountHeader       = "Create an account"
  val existingPublicBody        = "Are you a civil servant or an employee of a public body?"
  val existingPublicBodyMessage =
    "Some public bodies are accredited by the Civil Service \nCommission allowing their employees to view vacancies \nadvertised to civil servants" //TODO maybe different on different browsers
  val agreeTerms                = "I agree to terms and conditions "

  def firstName(): TextField              = textField("ID_firstname")
  def lastName(): TextField               = textField("ID_lastname")
  def email(): EmailField                 = emailField("ID_email")
  def confirmEmail(): EmailField          = emailField("ID_reemail")
  def createPassword(): PasswordField     = pwdField("ID_password")
  def confirmPassword(): PasswordField    = pwdField("ID_repassword")
  def employeePublicBody(): Boolean       = clickOnRadioButton("id_is_cs_user_yes")
  def nonEmployeePublicBody(): Boolean    = clickOnRadioButton("id_is_cs_user_no")
  def agreeTermsAndConditions(): Checkbox = checkbox("agree")
  def recapClick(): Checkbox              = checkbox("recaptcha-checkbox-border")

  def navigateToCreateAccountPage(): Unit = {
    checkV9Logout()
    navigateToSignInOrCreateAccount()
    clickOn(createAnAccount())
    eventually(onPage(createAccountTitle))
  }

  def enterFirstName(user: CandidateDetails): Unit =
    firstName().value = user.firstname

  def enterLastName(user: CandidateDetails): Unit =
    lastName().value = user.lastname

  def enterEmail(user: CandidateDetails): Unit =
    email().value = user.email.toLowerCase

  def enterConfirmEmail(user: CandidateDetails): Unit =
    confirmEmail().value = user.email.toLowerCase

  def enterPassword(user: CandidateDetails): Unit =
    createPassword().value = user.password

  def enterConfirmPassword(user: CandidateDetails): Unit =
    confirmPassword().value = user.password

  def selectEmployeeType(user: CandidateDetails): Unit =
    if (user.isEmployeeExistingPublicSector) employeePublicBody() else nonEmployeePublicBody()

  def selectTermsAndConditions(user: CandidateDetails): Unit =
    if (user.agreeTermsAndConditions) agreeTermsAndConditions().select()
    else println("Unable to create account without agreeing on T&Cs")

  def registerNewAccount(): Unit =
    clickOn("update")

  def enterFirstNameLoop(fn: String): Unit    = firstName().value = fn
  def enterLastNameLoop(ln: String): Unit     = lastName().value = ln
  def enterEmailLoop(e: String): Unit         = email().value = e
  def enterConfirmEmailLoop(ce: String): Unit = confirmEmail().value = ce
  def enterPasswordLoop(): Unit               = createPassword().value = passwordCandidate
  def enterConfirmPasswordLoop(): Unit        = confirmPassword().value = passwordCandidate
  def selectEmployeeTypeLoop(): Unit          = nonEmployeePublicBody()
  def selectTermsAndConditionsLoop(): Unit    = agreeTermsAndConditions().select()

}
