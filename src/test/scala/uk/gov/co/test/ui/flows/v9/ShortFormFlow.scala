package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{candidateApproach, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.jobSearchAndApplyFlow
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.appGuidancePage
import uk.gov.co.test.ui.pages.v9.shortform.DeclarationPage.{declarationPage, shortFormSubmission}
import uk.gov.co.test.ui.pages.v9.shortform.DiversityMonitoringPage.diversityMonitoringPage
import uk.gov.co.test.ui.pages.v9.shortform.EligibilityPage.eligibilityPage
import uk.gov.co.test.ui.pages.v9.shortform.PersonalInfoPage.personalInfoPage

object ShortFormFlow extends CivilServiceJobsBasePage {

  private val shortForm: Seq[ShortFormDetails => Unit] = Seq(
    appGuidancePage,
    eligibilityPage,
    personalInfoPage,
    diversityMonitoringPage,
    declarationPage
  )

  def fillShortFormDetails(shortFormDetails: ShortFormDetails): Unit =
    if (candidateApproach == "External" || candidateApproach == "Pre-release") {
      jobSearchAndApplyFlow(vacancyName, vacancyId, "what")
      shortForm.foreach { f =>
        f(shortFormDetails)
      }
      clickOn(shortFormSubmission)
    } else println(s"Vacancy is not open for '$candidateApproach' candidates!")

  def fillShortFormDetailsOnly(shortFormDetails: ShortFormDetails): Unit = {
    jobSearchAndApplyFlow(vacancyName, vacancyId, "what")
    shortForm.foreach { f =>
      f(shortFormDetails)
    }
    clickOn(shortFormSubmission)
  }
}
