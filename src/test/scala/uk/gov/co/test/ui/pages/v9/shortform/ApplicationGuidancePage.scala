package uk.gov.co.test.ui.pages.v9.shortform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ApplicationDetails
import uk.gov.co.test.ui.pages.v9.{CSJobsBasePage, SearchJobsPage}

case class ShortFormDetails(
  confirmAppGuidance: Boolean
)

object ApplicationGuidancePage extends CSJobsBasePage {

  private lazy val appGuidanceTitle = "Application Guidance - Civil Service Jobs - GOV.UK"
  private lazy val appDeadline      = "The deadline is 11:55PM on 22 November 2023."
  val returnBackToSearchResultsPath = ".//a[@title='Return to search results']"
  val formIdPath                    = ".//form[@onsubmit='return submit_form()']"
  var formId: String                = ""

  private def confirmApplicationGuidance(shortFormDetails: ShortFormDetails): Unit = {
    eventually(onPage(appGuidanceTitle))
    if (!vXSearchCookiesById().isEmpty) vXAcceptAllCookies()
    extractAppFormId()
  }

  private def extractAppFormId(): String = {
    val formClass = driver.findElement(By.xpath(formIdPath))
    formId = formClass.getAttribute("id")
    formId
  }

  def goToJobApply(): Unit = {
    val jobPath = ".//a[text()='OGDGCCO']"
    SearchJobsPage.enterWhatAndSearch("OGDGCCO")
    val job     = waitForVisibilityOfElementByPath(jobPath)
    job.click()
    eventually(onPage("OGDGCCO - Civil Service Jobs - GOV.UK"))
    clickOn("login_button")
    driver.navigate().refresh()
  }

  private val appGuidance: Seq[ShortFormDetails => Unit] = Seq(
    confirmApplicationGuidance
  )

  def appGuidancePage(applicationDetails: ApplicationDetails): Unit = {
    appGuidance.foreach { f =>
      f(applicationDetails.shortFormDetails)
    }
    if (applicationDetails.shortFormDetails.confirmAppGuidance) {
      scrollToElement(By.id(pageContinue))
      clickOn(pageContinue)
    }
  }
}
