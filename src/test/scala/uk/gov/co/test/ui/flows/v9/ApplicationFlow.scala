package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.v9.ApplicationDetails
import uk.gov.co.test.ui.pages.v9.CSJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.appGuidancePage
import uk.gov.co.test.ui.pages.v9.shortform.DiversityMonitoringPage.diversityMonitoringPage
import uk.gov.co.test.ui.pages.v9.shortform.EligibilityPage.eligibilityPage
import uk.gov.co.test.ui.pages.v9.shortform.PersonalInfoPage.personalInfoPage

object ApplicationFlow extends CSJobsBasePage {

  private val application: Seq[ApplicationDetails => Unit] = Seq(
    appGuidancePage,
    eligibilityPage,
    personalInfoPage,
    diversityMonitoringPage
  )

  def fillApplicationDetails(applicationDetails: ApplicationDetails): Unit = {
    application.foreach { f =>
      f(applicationDetails)
    }
    println("Candidate Done!")
  }
}
