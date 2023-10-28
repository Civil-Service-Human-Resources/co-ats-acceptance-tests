package uk.gov.co.test.ui.specs

import org.openqa.selenium.WebDriver
import org.scalatest._
import org.scalatest.concurrent.Eventually
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{logoutVX, navigateToVxConfigLogin}
import uk.gov.co.test.ui.pages.v9.SignInPage.{acceptAllCookies, navigateToV9Test, searchCookiesById, signOutProcess}
import uk.gov.co.test.ui.utils.SingletonScreenshotReport
import uk.gov.co.test.ui.webdriver.SingletonDriver

import scala.util.Try

trait BaseFeatureSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with BeforeAndAfterAll
    with BeforeAndAfterEachTestData
    with Matchers
    with WebBrowser
    with BrowserDriver
    with Eventually {

  override protected def beforeEach(testData: TestData): Unit =
    if (testData.name.contains("Candidate")) {
      navigateToV9Test()
      if (!searchCookiesById().isEmpty) {
        acceptAllCookies()
      }
    } else {
      navigateToVxConfigLogin()
    }

  override protected def afterEach(testData: TestData): Unit =
    if (testData.name.contains("Candidate")) {
      signOutProcess()
    } else {
      logoutVX()
    }

  override def afterAll(): Unit = {
    Runtime.getRuntime addShutdownHook new Thread {
      override def run(): Unit =
        Try(SingletonDriver.closeInstance())
    }
    SingletonScreenshotReport.publishReport()
  }

  override def withFixture(test: NoArgTest): Outcome =
    super.withFixture(test) match {
      case f: Failed    =>
        SingletonScreenshotReport.takeScreenshot(driver, test.name)
        f
      case otherOutcome => otherOutcome
    }

  def isSystemError()(implicit driver: WebDriver): Boolean =
    find(cssSelector("h1")).get.text == "System error"

  def hasValidationErrors()(implicit driver: WebDriver): Boolean =
    findAll(cssSelector("div[class=field] > div[class=error]")).exists { error: Element => error.isDisplayed }
}
