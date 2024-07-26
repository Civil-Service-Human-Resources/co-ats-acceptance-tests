package uk.gov.co.test.ui.flows.v9

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAbilitiesRequired, vXAnyAdditionalQuestions, vXAnyOnlineTests, vXApproach, vXAttachmentRequired, vXBehavioursRequired, vXExperiencesRequired, vXGiveLocationPreference, vXHowManyQuestions, vXNoLongForm, vXStrengthsRequired, vXTechSkillsRequired, vacancyId, vacancyName}
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmShortFormCompletion, confirmShortFormCompletionNoLongForm}
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.{navigateToApplicationCentrePage, navigateToApplicationsPage}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.jobSearchAndApplyFlow
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.appGuidancePage
import uk.gov.co.test.ui.pages.v9.shortform.DeclarationPage.{declarationPage, declarationPageCheck, declarationPageTracker}
import uk.gov.co.test.ui.pages.v9.shortform.DiversityMonitoringPage.diversityMonitoringPage
import uk.gov.co.test.ui.pages.v9.shortform.EligibilityPage.{currentCivilServantYesId, eligibilityPage, eligibilityPageCheck, eligibilityPageTracker, homeDepartmentSelectId}
import uk.gov.co.test.ui.pages.v9.shortform.PersonalInfoPage.{personalInfoPage, personalInfoPageCheck, redeploymentSchemeId, redeploymentSchemeNoId}

object ShortFormFlow extends CivilServiceJobsBasePage {

  private val shortForm: Seq[ShortFormDetails => Unit] = Seq(
    appGuidancePage,
    eligibilityPage,
    personalInfoPage,
    diversityMonitoringPage,
    declarationPage
  )

  def fillShortFormDetails(shortFormDetails: ShortFormDetails): Unit = {
    if (vXApproach == "External" || vXApproach == "Pre-release") {
      jobSearchAndApplyFlow(vacancyName, vacancyId, "what")
      shortForm.foreach { f =>
        f(shortFormDetails)
      }
      clickOn(submitForm)
    } else println(s"Vacancy is not open for '$vXApproach' candidates!")
    if (
      vXAnyOnlineTests ||
      vXHowManyQuestions > 0 ||
      vXAbilitiesRequired ||
      vXBehavioursRequired ||
      vXExperiencesRequired ||
      vXStrengthsRequired ||
      vXTechSkillsRequired ||
      vXGiveLocationPreference ||
      vXAttachmentRequired ||
      vXAnyAdditionalQuestions.get
    ) {
      confirmShortFormCompletion()
      vXNoLongForm = false
    } else {
      confirmShortFormCompletionNoLongForm()
      vXNoLongForm = true
    }
    navigateToApplicationsPage()
    navigateToApplicationCentrePage()
  }

  def checkRedeploymentDepartments(shortFormDetails: ShortFormDetails): Unit = {
    if (vXApproach == "External" || vXApproach == "Pre-release") {
      jobSearchAndApplyFlow(vacancyName, vacancyId, "what")
      shortForm.foreach { f =>
        f(shortFormDetails)
      }
    } else println(s"Vacancy is not open for '$vXApproach' candidates!")
    val amountOfDeptInScheme = shortFormDetails.personalInfoDetails.redeploymentDept.size - 1
    for (i <- 0 to amountOfDeptInScheme) {
      waitForVisibilityOfElementByPath(eligibilityPageTracker).click()
      eligibilityPageCheck()
      radioSelect(currentCivilServantYesId)
      selectDropdownOption(homeDepartmentSelectId, shortFormDetails.personalInfoDetails.redeploymentDept.lift(i).get)
      clickOn(pageContinue)
      personalInfoPageCheck()
      scrollToElement(By.id(redeploymentSchemeId))
      radioSelect(redeploymentSchemeNoId)
      clickOn(pageContinue)
    }
    waitForVisibilityOfElementByPath(declarationPageTracker).click()
    declarationPageCheck()
    clickOn(submitForm)
  }
}
