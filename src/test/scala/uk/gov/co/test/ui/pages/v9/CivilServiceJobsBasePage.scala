package uk.gov.co.test.ui.pages.v9

import com.github.javafaker.Faker
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.pages.BasePage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.civilServiceJobsPageTitle
import uk.gov.co.test.ui.pages.v9.SignInPage.signOut

import java.util
import scala.util.Random

trait CivilServiceJobsBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String                        = TestConfiguration.url("v9test")
  val civilServiceSignOutPageTitle       = "Civil Service Jobs - Civil Service Jobs - GOV.UK"
  val v9AcceptAdditionalCookies: String  = "accept_all_cookies_button"
  val vXaAcceptAdditionalCookies: String = "cookies-accept-button"
  val pageContinue                       = "continue_button"
  var randomFirstName: String            = ""
  var randomLastName: String             = ""
  var preferredFirstName: String         = ""
  lazy val randomEmail: String           = s"${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com"

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

//  def constructEmailAddress(): String = {
//    var randomEmail: String           = s"${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com"
//  }

//  def randomNames(): (String, String) = {
//    val fake            = new Faker()
//    val randomFirstName = fake.name().firstName()
//    val randomLastName  = fake.name().lastName()
//    (randomFirstName, randomLastName)
//  }

  def generatePreferredFirstName(): String = {
    val fake = new Faker()
    preferredFirstName = fake.name().firstName()
    preferredFirstName
  }

  def back(): Unit = clickOn("back-link")

  def v9AcceptAllCookies(): Unit =
    clickOn(v9AcceptAdditionalCookies)

  def vXAcceptAllCookies(): Unit =
    clickOn(vXaAcceptAdditionalCookies)

  def v9SearchCookiesById(): util.List[WebElement] =
    driver.findElements(By.id(v9AcceptAdditionalCookies))

  def vXSearchCookiesById(): WebElement =
    driver.findElement(By.id(vXaAcceptAdditionalCookies))

  def navigateToV9Test(): Unit = {
    go to url
    eventually(onPage(civilServiceJobsPageTitle))
//    generateCandidateDetails()
  }

  def generateCandidateDetails(): Unit = {
    generateRandomFirstName()
    generateRandomLastName()
    generatePreferredFirstName()
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
}
