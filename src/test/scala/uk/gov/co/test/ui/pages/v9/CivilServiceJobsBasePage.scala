package uk.gov.co.test.ui.pages.v9

import com.github.javafaker.Faker
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.conf.TestConfiguration.readProperty
import uk.gov.co.test.ui.data.MasterVacancyDetails.{preferredFirstName, randomEmail, randomFirstName, randomJobPosition, randomLastName, randomPassword}
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.pages.BasePage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.civilServiceJobsPageTitle
import uk.gov.co.test.ui.pages.v9.SignInPage.{searchForSignOut, signOut}

import java.util
import scala.util.Random

trait CivilServiceJobsBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String                       = TestConfiguration.url("v9test")
  val passwordCandidate: String         = readProperty("services.v9test.admin.candidate_password")
  val getOs: String                     = System.getProperty("os.name").toLowerCase
  val civilServiceSignOutPageTitle      = "Civil Service Jobs - Civil Service Jobs - GOV.UK"
  val v9AcceptAdditionalCookies: String = "accept_all_cookies_button"
  val vXAcceptAdditionalCookies: String = "cookies-accept-button"
  val pageContinue                      = "continue_button"
  val continueToLongForm                = "select_manual_form_700"
  val submitForm                        = "submit_button"

  def randomnessName(): String = {
    val randomLastName = Iterator.continually(Random.nextPrintableChar()).filter(_.isLetter).take(10).mkString
    val autoLastName   = s"Test-$randomLastName"
    autoLastName
  }

  def generateRandomFirstName(): String = {
    val fake = new Faker()
    randomFirstName = fake.name().firstName()
    randomFirstName
  }

  def generateRandomLastName(): String = {
    val fake = new Faker()
    randomLastName = fake.name().lastName()
    randomLastName
  }

  def generateRandomPassword(i: Int): String = {
    val fake = new Faker()
    randomPassword = s"${fake.color().name().split("\\s+").map(_.capitalize).mkString("")}${fake.address().state().split("\\s+").map(_.capitalize).mkString("")}${i+11}"
    randomPassword
  }

  def generatedDacTestEmail(): String = {
    randomEmail = s"dac24_${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com"
    randomEmail
  }

  def generatedEmail(): String = {
    randomEmail = s"${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com"
    randomEmail
  }

  def generatePreferredFirstName(): String = {
    val fake = new Faker()
    preferredFirstName = fake.name().firstName()
    preferredFirstName
  }

  def generateRandomJobPosition(): String = {
    val fake = new Faker()
    randomJobPosition = s"${fake.job().field()} ${fake.job().position()}"
    randomJobPosition
  }

  def back(): Unit = clickOn("back-link")

  def v9AcceptAllCookies(): Unit =
    clickOn(v9AcceptAdditionalCookies)

  def vXAcceptAllCookies(): Unit =
    clickOn(vXAcceptAdditionalCookies)

  def v9SearchCookiesById(): util.List[WebElement] =
    driver.findElements(By.id(v9AcceptAdditionalCookies))

  def vXSearchCookiesById(): WebElement =
    driver.findElement(By.id(vXAcceptAdditionalCookies))

  def navigateToV9Test(): Unit = {
    go to url
    eventually(onPage(civilServiceJobsPageTitle))
  }

  def generateCandidateDetails(): Unit = {
    generateRandomFirstName()
    generateRandomLastName()
    generatePreferredFirstName()
    generatedEmail()
  }

  def generateTestCandidateDetails(i: Int): Unit = {
    generateRandomFirstName()
    generateRandomLastName()
//    generatePreferredFirstName()
    generatedDacTestEmail()
    generateRandomPassword(i)
  }

  def generateCandidateDetailsIterator(i: Int): Unit = {
    randomFirstName = s"Autotest$i"
    randomLastName = s"Candidate$i"
    randomEmail = s"${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com"
  }

  def changeLanguage(lang: String): Unit = {
    val langSwitcher = driver.findElement(By.xpath(s".//a[@lang='$lang']"))
    clickOn(langSwitcher)
  }

  def selectedLanguage(LanguageType: Option[String]): Unit =
    LanguageType match {
      case Some("english") => changeLanguage("en")
      case Some("welsh")   => changeLanguage("cy")
      case Some(language)  =>
        throw LanguageSwitcherException(
          s"'language' property '$language' not supported by " +
            s"the civil service job application."
        )
      case None            =>
        throw LanguageSwitcherException("'language' property is not set, this is required if welsh needed")
    }

  case class LanguageSwitcherException(message: String) extends RuntimeException(message)

  def linkUrl(linkText: String): String =
    driver.findElement(By.linkText(linkText)).getAttribute("href")

  def signOutProcess(): Unit =
    signOut().click()

  def goBack(): Unit =
    clickOn("back_button")

  def extractValue(id: String): String =
    waitForVisibilityOfElementById(id).getAttribute("value")

  def selectDropdownOption(id: String, value: String): Unit = {
    scrollToElement(By.id(id))
    waitForVisibilityOfElementById(id).click()
    val dept = new Select(waitForVisibilityOfElementById(id))
    dept.selectByVisibleText(value)
  }

  def selectDropdownOptionByPath(path: String, value: String): Unit = {
    scrollToElement(By.xpath(path))
    waitForVisibilityOfElementByPath(path).click()
    val dept = new Select(waitForVisibilityOfElementByPath(path))
    dept.selectByVisibleText(value)
  }

  def enterDetails(inputId: String, text: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
    enterOption.clear()
    enterOption.sendKeys(text)
    enterOption.sendKeys(Keys.TAB)
  }

  def checkV9LogoutState(): Unit =
    if (!searchForSignOut().isEmpty) {
      signOutProcess()
      if (!searchForSignOut().isEmpty) {
        signOutProcess()
      }
    }

  def splitDate(givenDate: String): (String, String, String) = {
    val date   = givenDate
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
}
