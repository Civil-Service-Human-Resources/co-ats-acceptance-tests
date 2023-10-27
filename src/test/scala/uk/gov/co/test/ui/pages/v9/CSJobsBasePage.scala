package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.matchers.should.Matchers
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.pages.BasePage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.cSSearchJobsTitle

trait CSJobsBasePage extends Matchers with BasePage with BrowserDriver {

  val url: String                     = "https://csrtesting.wcn.co.uk/csr/jobs.cgi"
  val acceptAdditionalCookies: String = "accept_all_cookies_button"

  def back(): Unit = clickOn("back-link")

  def acceptAllCookies(): Unit =
    click on acceptAdditionalCookies

  def navigateToV9Test(): Unit = {
    go to url
    eventually(pageTitle shouldEqual cSSearchJobsTitle)
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

}
