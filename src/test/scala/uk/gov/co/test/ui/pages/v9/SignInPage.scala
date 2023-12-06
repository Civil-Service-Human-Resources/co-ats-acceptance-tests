package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.WebElement

object SignInPage extends CivilServiceJobsBasePage {

  val cSJobsTitle = "Sign in - Civil Service Jobs - GOV.UK"

  val cSJobsEmailErrorMessage    =
    "Email address - Either the email address and/or your password you have entered is incorrect"
  val cSJobsPasswordErrorMessage =
    "Password - Either the email address and/or your password you have entered is incorrect"

  def email(): EmailField       = emailField("ID_username")
  def password(): PasswordField = pwdField("ID_password_login_window")

  def candidateFullName(user: CandidateDetails): String =
    s"${user.firstname} ${user.lastname}"

  def signIn(): WebElement = waitForElementToBeClickableByPath(
    "//*[@id='login_button']"
  )

  def signOut(): WebElement = waitForElementToBeClickableByPath(
    "//*[@title='Sign out']"
  )

  def editAccountDetails(): WebElement = waitForElementToBeClickableByPath(
    "//*[@title='Edit your account details']"
  )

  def createAnAccount(): WebElement = waitForElementToBeClickableByPath(
    "//*[@id='login_form']/div[2]/p[2]/a"
  )

  def fillInUserDetails(user: CandidateDetails): Unit = {
    email().value = user.email.toLowerCase
    password().value = user.password
  }

  def candidateSignIn(user: CandidateDetails): Unit = {
    fillInUserDetails(user)
    signIn().click()
  }
}
