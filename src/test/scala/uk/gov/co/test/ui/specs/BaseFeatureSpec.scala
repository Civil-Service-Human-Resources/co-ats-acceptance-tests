package uk.gov.co.test.ui.specs

import org.openqa.selenium.WebDriver
import org.scalatest._
import org.scalatest.concurrent.Eventually
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.selenium.WebBrowser
import uk.gov.co.test.ui.data.vx.RECRUITER
import uk.gov.co.test.ui.driver.BrowserDriver
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.{checkV9Logout, generateCandidateDetails, navigateToV9Test, v9AcceptAllCookies, v9SearchCookiesById}
import uk.gov.co.test.ui.utils.SingletonScreenshotReport
import uk.gov.co.test.ui.webdriver.SingletonDriver

import scala.util.Try

trait BaseFeatureSpec
    extends AnyFeatureSpec
    with GivenWhenThen
    with BeforeAndAfterAll
    with BeforeAndAfterEachTestData
    with OneInstancePerTest
    with Matchers
    with WebBrowser
    with BrowserDriver
    with Eventually {

  override protected def beforeEach(testData: TestData): Unit =
    if (testData.name.contains("V9")) {
      generateCandidateDetails()
      navigateToV9Test()
      if (!v9SearchCookiesById().isEmpty) {
        v9AcceptAllCookies()
      }
    } else if (testData.name.contains("VX")) {
      generateCandidateDetails()
      loginWithRecruiterDetails(RECRUITER)
    } else throw new IllegalStateException("Change test name in order to start up correct system")

  override protected def afterEach(testData: TestData): Unit =
    if (testData.name.contains("Candidate")) {
      checkV9Logout()
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
