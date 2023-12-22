package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.ApplicationDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{applicationId, vXJobInfoDepartment, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{preSiftCompletion, preSiftEvaluationFormBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

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
    checkVacancyStatus("Pre-sift actions required")
    moveVacancyOnViaTopBar(preSiftEvaluationFormBarId, preSiftEvaluationTabPath)
  }

  private def confirmCandidateSummary(): Unit = {
    waitForVisibilityOfElementById(candidateSummaryId("1")).getText shouldEqual applicationId
    waitForVisibilityOfElementById(candidateSummaryId("2")).getText shouldEqual "Restricted Data"
    waitForVisibilityOfElementById(candidateSummaryId("3")).getText shouldEqual "Restricted Data"
    waitForVisibilityOfElementById(candidateSummaryId("4")).getText shouldEqual "Pre-sift actions required"
    waitForVisibilityOfElementById(candidateSummaryId("5")).getText shouldEqual vacancyId
    waitForVisibilityOfElementById(candidateSummaryId("6")).getText shouldEqual vacancyName
    waitForVisibilityOfElementById(candidateSummaryId("7")).getText shouldEqual vXJobInfoDepartment
    waitForVisibilityOfElementById(candidateSummaryId("8")).getText shouldEqual "Restricted Data"
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

  private val preSift: Seq[PreSiftDetails => Unit] = Seq(
    completeCvAssessment,
    completePersonalStatement,
    completePreSiftAssessment,
    completeOutcome
  )

  def PreSiftEvaluationFlow(applicationDetails: ApplicationDetails): Unit = {
    confirmCandidateSummary()
    completePreSiftEvaluationForm()
    preSift.foreach { f =>
      f(applicationDetails.preSiftDetails)
    }
    waitForVisibilityOfElementById(
      declarationId
    ).getText shouldEqual "Declaration\nBy submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant."
    clickOn(submitForm)
    preSiftCompletion()
  }
}
