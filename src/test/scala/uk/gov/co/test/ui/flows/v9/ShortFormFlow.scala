package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{candidateApproach, vXAnyOnlineTests, vXHowManyQuestions, vXHowManySkills, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmShortFormCompletion, confirmShortFormCompletionNoLongForm}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.jobSearchAndApplyFlow
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.appGuidancePage
import uk.gov.co.test.ui.pages.v9.shortform.DeclarationPage.declarationPage
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

  def fillShortFormDetails(
    shortFormDetails: ShortFormDetails,
    vName: Option[String] = None,
    vId: Option[String] = None
  ): Unit = {
    if (candidateApproach == "External" || candidateApproach == "Pre-release") {
      if (vName.isDefined) { vacancyName = vName.get }
      if (vId.isDefined) { vacancyId = vId.get }
      jobSearchAndApplyFlow(vacancyName, vacancyId, "what")
      shortForm.foreach { f =>
        f(shortFormDetails)
      }
      clickOn(submitForm)
    } else println(s"Vacancy is not open for '$candidateApproach' candidates!")
    if (vXHowManySkills > 0 || vXAnyOnlineTests || vXHowManyQuestions > 0) {
      confirmShortFormCompletion()
    } else confirmShortFormCompletionNoLongForm()
  }

  //  def fillShortFormDetailsOnly(shortFormDetails: ShortFormDetails): Unit = {
//    jobSearchAndApplyFlow(vacancyName, vacancyId, "what")
//    shortForm.foreach { f =>
//      f(shortFormDetails)
//    }
//    clickOn(submitForm)
//  }
}
