package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.pages.BasePage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.cSSearchJobsTitle
import uk.gov.co.test.ui.pages.v9.SignInPage.signOut

import java.util
import scala.util.Random

trait CSJobsBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String                     = TestConfiguration.url("v9test")
  val acceptAdditionalCookies: String = "accept_all_cookies_button"
  val randomLastName: String          = randomnessName()

  def randomnessName(): String = {
    val randomLastName = Iterator.continually(Random.nextPrintableChar()).filter(_.isLetter).take(10).mkString
    val autoLastName   = s"Test-$randomLastName"
    autoLastName
  }

  def back(): Unit = clickOn("back-link")

  def acceptAllCookies(): Unit =
    click on acceptAdditionalCookies

  def searchCookiesById(): util.List[WebElement] =
    driver.findElements(By.id(acceptAdditionalCookies))

  def navigateToV9Test(): Unit = {
    go to url
    eventually(onPage(cSSearchJobsTitle))
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

  def signOutProcess(): Unit = {
    signOut().click()
    eventually(pageTitle shouldEqual cSSearchJobsTitle)
  }

}
