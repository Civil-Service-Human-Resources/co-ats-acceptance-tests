package uk.gov.co.test.ui.pages.v9.shortform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.v9RunInWelsh
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.{navigateToApplicationsPage, reviewUpdateValue}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage

case class AppGuidanceDetails(
  confirmAppGuidance: Boolean
)

object ApplicationGuidancePage extends CivilServiceJobsBasePage {

  private lazy val appGuidanceTitle      = "Application Guidance - Civil Service Jobs - GOV.UK"
  private lazy val welshAppGuidanceTitle = "Canllaw Gwneud Cais - Civil Service Jobs - GOV.UK"
  private lazy val findCSJobsTitle       = "Welcome to our recruitment portal - Civil Service Jobs - GOV.UK"
  private lazy val appDeadline           = "The deadline is 11:55PM on 22 November 2023."
  val returnBackToSearchResultsPath      = ".//a[@title='Return to search results']"
//  val formIdPath                    = ".//form[@onsubmit='return submit_form()']"
  val formIdPath                         = ".//form[@enctype='multipart/form-data']"
  var shortFormId: String                = ""

  private def confirmApplicationGuidance(appGuidanceDetails: AppGuidanceDetails): Unit = {
    if (driver.getTitle != findCSJobsTitle) {
      if (v9RunInWelsh) eventually(onPage(welshAppGuidanceTitle)) else eventually(onPage(appGuidanceTitle))
    } else {
      navigateToApplicationsPage()
      reviewUpdateValue().click()
      if (v9RunInWelsh) eventually(onPage(welshAppGuidanceTitle)) else eventually(onPage(appGuidanceTitle))
    }
    if (vXSearchCookiesById().isDisplayed) {
      vXAcceptAllCookies()
    }
    if (appGuidanceDetails.confirmAppGuidance) {
      scrollToElement(By.id(pageContinue))
      clickOn(pageContinue)
    }
  }

  def extractAppFormId(): String = {
    val formClass = driver.findElement(By.xpath(formIdPath))
    formClass.getAttribute("id")
  }

  private val appGuidance: Seq[AppGuidanceDetails => Unit] = Seq(
    confirmApplicationGuidance
  )

  def appGuidancePage(shortFormDetails: ShortFormDetails): Unit = {
    appGuidance.foreach { f =>
      f(shortFormDetails.appGuidanceDetails)
    }
    shortFormId = extractAppFormId()
  }
}
