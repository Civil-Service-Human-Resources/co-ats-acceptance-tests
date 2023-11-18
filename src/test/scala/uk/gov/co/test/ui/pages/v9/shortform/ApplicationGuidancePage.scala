package uk.gov.co.test.ui.pages.v9.shortform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CSJobsBasePage

case class AppGuidanceDetails(
  confirmAppGuidance: Boolean
)

object ApplicationGuidancePage extends CSJobsBasePage {

  private lazy val appGuidanceTitle = "Application Guidance - Civil Service Jobs - GOV.UK"
  private lazy val appDeadline      = "The deadline is 11:55PM on 22 November 2023."
  val returnBackToSearchResultsPath = ".//a[@title='Return to search results']"
  val formIdPath                    = ".//form[@onsubmit='return submit_form()']"
  var formId: String                = ""

  private def confirmApplicationGuidance(appGuidanceDetails: AppGuidanceDetails): Unit = {
    eventually(onPage(appGuidanceTitle))
    if (!vXSearchCookiesById().isEmpty) vXAcceptAllCookies()
    extractAppFormId()
    if (appGuidanceDetails.confirmAppGuidance) {
      scrollToElement(By.id(pageContinue))
      clickOn(pageContinue)
    }
  }

  private def extractAppFormId(): String = {
    val formClass = driver.findElement(By.xpath(formIdPath))
    formId = formClass.getAttribute("id")
    formId
  }

  private val appGuidance: Seq[AppGuidanceDetails => Unit] = Seq(
    confirmApplicationGuidance
  )

  def appGuidancePage(shortFormDetails: ShortFormDetails): Unit =
    appGuidance.foreach { f =>
      f(shortFormDetails.appGuidanceDetails)
    }
}
