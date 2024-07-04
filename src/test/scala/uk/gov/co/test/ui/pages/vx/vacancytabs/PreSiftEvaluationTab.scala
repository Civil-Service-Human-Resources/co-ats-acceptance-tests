package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCvAttachment, vXPersonalStatement, vXPreSiftRequired, vacancyFormId}
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.applicationBeingReviewedPreSiftState
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, confirmCandidateSummary, navigateToApplicationSummary, preSiftEvaluationFormBarId, progressBarAfterPreSiftId, rejectBarAfterPreSiftId, withdrawBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class PreSiftDetails(
  cvAssessmentScore: String,
  cvAssessmentComments: String,
  personalStatementScore: String,
  personalStatementComments: String,
  preSiftAssessmentScore: String,
  preSiftAssessmentComments: String,
  outcomeRecommendation: String,
  outcomeOverallComments: String
)

object PreSiftEvaluationTab extends VacancyBasePage {

  private lazy val preSiftEvaluationTabPath = ".//span[@class='main-label' and text() = 'Pre-Sift Evaluation']"
  private lazy val preSiftStatus            = "Pre-sift actions required"
  private lazy val preSiftCompleteStatus    = "Pre-sift complete"
  def cvAssessmentScoreId                   = s"select2-${vacancyFormId}_datafield_45355_1_1-container"
  def personalStatementScoreId              = s"select2-${vacancyFormId}_datafield_45381_1_1-container"
  def preSiftAssessmentScoreId              = s"select2-${vacancyFormId}_datafield_137899_1_1-container"
  def outcomeRecommendationId               = s"select2-${vacancyFormId}_datafield_45407_1_1-container"
  def cvAssessmentCommentsId                = s"${vacancyFormId}_datafield_45358_1_1"
  def personalStatementCommentsId           = s"${vacancyFormId}_datafield_45384_1_1"
  def preSiftAssessmentCommentsId           = s"${vacancyFormId}_datafield_137903_1_1"
  def outcomeOverallCommentsId              = s"${vacancyFormId}_datafield_45410_1_1"
  def declarationId                         = s"${vacancyFormId}_label_45440_1"

  def completePreSiftEvaluationForm(): Unit = {
    checkVacancyStatus(preSiftStatus)
    moveVacancyOnViaTopBar(preSiftEvaluationFormBarId, preSiftEvaluationTabPath)
  }

  private def completeCvAssessment(preSiftDetails: PreSiftDetails): Unit = {
    waitForVisibilityOfElementById(cvAssessmentScoreId).click()
    action().moveToElement(waitForDropdownOption(preSiftDetails.cvAssessmentScore)).perform()
    waitForDropdownOption(preSiftDetails.cvAssessmentScore).click()
    enterValue(cvAssessmentCommentsId, preSiftDetails.cvAssessmentComments)
  }

  private def completePersonalStatement(preSiftDetails: PreSiftDetails): Unit = {
    scrollToElement(By.id(personalStatementScoreId))
    waitForVisibilityOfElementById(personalStatementScoreId).click()
    action().moveToElement(waitForDropdownOption(preSiftDetails.personalStatementScore)).perform()
    waitForDropdownOption(preSiftDetails.personalStatementScore).click()
    enterValue(personalStatementCommentsId, preSiftDetails.personalStatementComments)
  }

  private def completePreSiftAssessment(preSiftDetails: PreSiftDetails): Unit = {
    waitForVisibilityOfElementById(preSiftAssessmentScoreId).click()
    action().moveToElement(waitForDropdownOption(preSiftDetails.preSiftAssessmentScore)).perform()
    waitForDropdownOption(preSiftDetails.preSiftAssessmentScore).click()
    enterValue(preSiftAssessmentCommentsId, preSiftDetails.preSiftAssessmentComments)
  }

  private def completeOutcome(preSiftDetails: PreSiftDetails): Unit = {
    scrollToElement(By.id(outcomeRecommendationId))
    waitForVisibilityOfElementById(outcomeRecommendationId).click()
    action().moveToElement(waitForDropdownOption(preSiftDetails.outcomeRecommendation)).perform()
    waitForDropdownOption(preSiftDetails.outcomeRecommendation).click()
    enterValue(outcomeOverallCommentsId, preSiftDetails.outcomeOverallComments)
  }

  private def preSiftCompletion(): Unit = {
    checkForNewValuePath(vacancyStatusPath, "Pre-sift complete")
    availableBarItems(List(progressBarAfterPreSiftId, rejectBarAfterPreSiftId, withdrawBarId))
  }

  private val preSift: Seq[PreSiftDetails => Unit] = Seq(
    completeCvAssessment,
    completePersonalStatement,
    completePreSiftAssessment,
    completeOutcome
  )

  def PreSiftEvaluationFlow(applicationDetails: ApplicationDetails): Unit = {
    navigateToApplicationSummary()
    if (vXPreSiftRequired) {
      confirmCandidateSummary(preSiftStatus, Some("restricted"))
      completePreSiftEvaluationForm()
      preSift.foreach { f =>
        f(applicationDetails.preSiftDetails)
      }
      waitForVisibilityOfElementById(
        declarationId
      ).getText shouldEqual "Declaration\nBy submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant."
      clickOn(submitForm)
      preSiftCompletion()
      confirmCandidateSummary(preSiftCompleteStatus, Some("restricted"))
      applicationBeingReviewedPreSiftState()
    }
  }
}
