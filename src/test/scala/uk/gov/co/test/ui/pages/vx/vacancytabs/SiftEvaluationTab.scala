package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAnyOnlineTests, vXBehavioursRequired, vXExperiencesRequired, vXHowManyBehaviours, vXHowManySkills, vXInterviewExpectedRounds, vXListOfChosenBehaviours, vXListOfTechSkills, vXPreSiftRequired, vXTechSkillsRequired, vacancyFormId}
import uk.gov.co.test.ui.data.vx.application.{ApplicationDetails, Outcome}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{applicationBeingReviewedState, successfulAtSiftState}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeSiftBarId, confirmCandidateSummary, progressBarAfterPreSiftId, siftEvaluation, withdrawBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

case class SiftDetails(
  scoringGuide: String,
  behaviourOne: Outcome,
  behaviourTwo: Outcome,
  behaviourThree: Outcome,
  behaviourFour: Outcome,
  behaviourFive: Outcome,
  behaviourSix: Outcome,
  behaviourSeven: Outcome,
  behaviourEight: Outcome,
  techSkillOne: Outcome,
  techSkillTwo: Outcome,
  techSkillThree: Outcome,
  techSkillFour: Outcome,
  techSkillFive: Outcome,
  techSkillSix: Outcome,
  techSkillSeven: Outcome,
  techSkillEight: Outcome,
  cvAssessment: Outcome,
  personalStatement: Outcome,
  overallScoreComments: String,
  finalOutcome: String,
  declarationStatement: String
)

object SiftEvaluationTab extends VacancyBasePage {

  private lazy val siftEvaluationTabPath      = ".//span[@class='main-label' and text() = 'Sift evaluation']"
  val siftEvaluationStatus                    = "Sift application"
  var vXBehavioursTotalScore: ListBuffer[Int] = ListBuffer()
  var vXTechSkillsTotalScore: ListBuffer[Int] = ListBuffer()
  var vXCVAssessmentScore: Int                = 0
  var vXPersonalStatementScore: Int           = 0
  def siftEvaluationHeaderId                  = s"${vacancyFormId}_label_153018_1"
  def behaviourAssessmentHeaderId             = s"${vacancyFormId}_label_65762_1"
  def behaviourScoringGuideId                 = s"${vacancyFormId}_label_153583_1"
  def behaviourOneTitleId                     = s"${vacancyFormId}_label_65988_1"
  def behaviourOneScoreId                     = s"select2-${vacancyFormId}_datafield_65874_1_1-container"
  def behaviourOneCommentsId                  = s"${vacancyFormId}_datafield_65818_1_1"
  def behaviourTwoTitleId                     = s"${vacancyFormId}_label_65991_1"
  def behaviourTwoScoreId                     = s"select2-${vacancyFormId}_datafield_65878_1_1-container"
  def behaviourTwoCommentsId                  = s"${vacancyFormId}_datafield_65825_1_1"
  def behaviourThreeTitleId                   = s"${vacancyFormId}_label_65994_1"
  def behaviourThreeScoreId                   = s"select2-${vacancyFormId}_datafield_65882_1_1-container"
  def behaviourThreeCommentsId                = s"${vacancyFormId}_datafield_65832_1_1"
  def behaviourFourTitleId                    = s"${vacancyFormId}_label_65997_1"
  def behaviourFourScoreId                    = s"select2-${vacancyFormId}_datafield_65886_1_1-container"
  def behaviourFourCommentsId                 = s"${vacancyFormId}_datafield_65839_1_1"
  def behaviourFiveTitleId                    = s"${vacancyFormId}_label_66000_1"
  def behaviourFiveScoreId                    = s"select2-${vacancyFormId}_datafield_65890_1_1-container"
  def behaviourFiveCommentsId                 = s"${vacancyFormId}_datafield_65846_1_1"
  def behaviourSixTitleId                     = s"${vacancyFormId}_label_66003_1"
  def behaviourSixScoreId                     = s"select2-${vacancyFormId}_datafield_65894_1_1-container"
  def behaviourSixCommentsId                  = s"${vacancyFormId}_datafield_65853_1_1"
  def behaviourSevenTitleId                   = s"${vacancyFormId}_label_66006_1"
  def behaviourSevenScoreId                   = s"select2-${vacancyFormId}_datafield_65898_1_1-container"
  def behaviourSevenCommentsId                = s"${vacancyFormId}_datafield_65860_1_1"
  def behaviourEightTitleId                   = s"${vacancyFormId}_label_66009_1"
  def behaviourEightScoreId                   = s"select2-${vacancyFormId}_datafield_65902_1_1-container"
  def behaviourEightCommentsId                = s"${vacancyFormId}_datafield_65867_1_1"
  def behaviourTotalScoreId                   = s"${vacancyFormId}_field_65906_1"
  def techSkillsHeaderId                      = s"${vacancyFormId}_label_66915_1"
  def techSkillsScoringGuideId                = s"${vacancyFormId}_label_153588_1"
  def techSkillOneTitleId                     = s"${vacancyFormId}_label_66597_1"
  def techSkillOneScoreId                     = s"select2-${vacancyFormId}_datafield_66573_1_1-container"
  def techSkillOneCommentsId                  = s"${vacancyFormId}_datafield_66525_1_1"
  def techSkillTwoTitleId                     = s"${vacancyFormId}_label_66600_1"
  def techSkillTwoScoreId                     = s"select2-${vacancyFormId}_datafield_66576_1_1-container"
  def techSkillTwoCommentsId                  = s"${vacancyFormId}_datafield_66531_1_1"
  def techSkillThreeTitleId                   = s"${vacancyFormId}_label_66603_1"
  def techSkillThreeScoreId                   = s"select2-${vacancyFormId}_datafield_66579_1_1-container"
  def techSkillThreeCommentsId                = s"${vacancyFormId}_datafield_66537_1_1"
  def techSkillFourTitleId                    = s"${vacancyFormId}_label_66606_1"
  def techSkillFourScoreId                    = s"select2-${vacancyFormId}_datafield_66582_1_1-container"
  def techSkillFourCommentsId                 = s"${vacancyFormId}_datafield_66543_1_1"
  def techSkillFiveTitleId                    = s"${vacancyFormId}_label_66609_1"
  def techSkillFiveScoreId                    = s"select2-${vacancyFormId}_datafield_66585_1_1-container"
  def techSkillFiveCommentsId                 = s"${vacancyFormId}_datafield_66549_1_1"
  def techSkillSixTitleId                     = s"${vacancyFormId}_label_66612_1"
  def techSkillSixScoreId                     = s"select2-${vacancyFormId}_datafield_66588_1_1-container"
  def techSkillSixCommentsId                  = s"${vacancyFormId}_datafield_66555_1_1"
  def techSkillSevenTitleId                   = s"${vacancyFormId}_label_66615_1"
  def techSkillSevenScoreId                   = s"select2-${vacancyFormId}_datafield_66591_1_1-container"
  def techSkillSevenCommentsId                = s"${vacancyFormId}_datafield_66561_1_1"
  def techSkillEightTitleId                   = s"${vacancyFormId}_label_66618_1"
  def techSkillEightScoreId                   = s"select2-${vacancyFormId}_datafield_66594_1_1-container"
  def techSkillEightCommentsId                = s"${vacancyFormId}_datafield_66567_1_1"
  def techSkillTotalScoreId                   = s"${vacancyFormId}_field_66891_1"
  def cvAssessmentTitleId                     = s"${vacancyFormId}_label_66191_1"
  def cvAssessmentScoreId                     = s"select2-${vacancyFormId}_datafield_109033_1_1-container"
  def cvAssessmentCommentsId                  = s"${vacancyFormId}_datafield_66204_1_1"
  def personalStatementTitleId                = s"${vacancyFormId}_label_66211_1"
  def personalStatementScoreId                = s"select2-${vacancyFormId}_datafield_187935_1_1-container"
  def personalStatementCommentsId             = s"${vacancyFormId}_datafield_66223_1_1"
  def overallScoreTitleId                     = s"${vacancyFormId}_label_66230_1"
  def overallScoreId                          = s"${vacancyFormId}_field_66238_1"
  def overallCommentsId                       = s"${vacancyFormId}_datafield_66491_1_1"
  def outcomeTitleId                          = s"${vacancyFormId}_label_66483_1"
  def outcomeId                               = s"select2-${vacancyFormId}_datafield_66487_1_1-container"
  def declarationStatementId                  = s"${vacancyFormId}_label_66498_1"

  def enterOutcome(
    titleId: String,
    expectedTitle: String,
    scoreId: String,
    score: Int,
    commentsId: String,
    comment: Option[String] = None
  ): Unit = {
    waitForVisibilityOfElementById(titleId).getText shouldEqual expectedTitle
    waitForVisibilityOfElementById(scoreId).click()
    action().moveToElement(waitForDropdownOption(score.toString)).perform()
    waitForDropdownOption(score.toString).click()
    if (comment.isDefined) {
      enterValue(commentsId, comment.get)
    }
  }

  private def moveSiftEvaluationForm(): Unit = {
    if (vXPreSiftRequired) waitForVisibilityOfElementById(progressBarAfterPreSiftId).click()
    checkForNewValuePath(vacancyStatusPath, siftEvaluationStatus)
    confirmCandidateSummary(siftEvaluationStatus, Some("restricted"))
    moveVacancyOnViaTopBar(completeSiftBarId, siftEvaluationTabPath)
    availableBarItems(List(completeSiftBarId, withdrawBarId))
    waitForVisibilityOfElementById(siftEvaluationHeaderId).getText should endWith("Sift Evaluation")
  }

  private def enterBehaviourOneOutcome(siftDetails: SiftDetails): Unit = {
    waitForVisibilityOfElementById(behaviourAssessmentHeaderId).getText shouldEqual "Behaviour assessment"
    waitForVisibilityOfElementById(behaviourScoringGuideId).getText          should include(siftDetails.scoringGuide)
    enterOutcome(
      behaviourOneTitleId,
      vXListOfChosenBehaviours.head,
      behaviourOneScoreId,
      siftDetails.behaviourOne.score,
      behaviourOneCommentsId,
      siftDetails.behaviourOne.comment
    )
    vXBehavioursTotalScore.clear()
    vXBehavioursTotalScore += siftDetails.behaviourOne.score
  }

  private def enterBehaviourTwoOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourTwoTitleId,
      vXListOfChosenBehaviours(1),
      behaviourTwoScoreId,
      siftDetails.behaviourTwo.score,
      behaviourTwoCommentsId,
      siftDetails.behaviourTwo.comment
    )
    vXBehavioursTotalScore += siftDetails.behaviourTwo.score
  }

  private def enterBehaviourThreeOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourThreeTitleId,
      vXListOfChosenBehaviours(2),
      behaviourThreeScoreId,
      siftDetails.behaviourThree.score,
      behaviourThreeCommentsId,
      siftDetails.behaviourThree.comment
    )
    vXBehavioursTotalScore += siftDetails.behaviourThree.score
  }

  private def enterBehaviourFourOutcome(siftDetails: SiftDetails): Unit = {
    scrollToElement(By.id(behaviourFourTitleId))
    enterOutcome(
      behaviourFourTitleId,
      vXListOfChosenBehaviours(3),
      behaviourFourScoreId,
      siftDetails.behaviourFour.score,
      behaviourFourCommentsId,
      siftDetails.behaviourFour.comment
    )
    vXBehavioursTotalScore += siftDetails.behaviourFour.score
  }

  private def enterBehaviourFiveOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourFiveTitleId,
      vXListOfChosenBehaviours(4),
      behaviourFiveScoreId,
      siftDetails.behaviourFive.score,
      behaviourFiveCommentsId,
      siftDetails.behaviourFive.comment
    )
    vXBehavioursTotalScore += siftDetails.behaviourFive.score
  }

  private def enterBehaviourSixOutcome(siftDetails: SiftDetails): Unit = {
    scrollToElement(By.id(behaviourSixTitleId))
    enterOutcome(
      behaviourSixTitleId,
      vXListOfChosenBehaviours(5),
      behaviourSixScoreId,
      siftDetails.behaviourSix.score,
      behaviourSixCommentsId,
      siftDetails.behaviourSix.comment
    )
    vXBehavioursTotalScore += siftDetails.behaviourSix.score
  }

  private def enterBehaviourSevenOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourSevenTitleId,
      vXListOfChosenBehaviours(6),
      behaviourSevenScoreId,
      siftDetails.behaviourSeven.score,
      behaviourSevenCommentsId,
      siftDetails.behaviourSeven.comment
    )
    vXBehavioursTotalScore += siftDetails.behaviourSeven.score
  }

  private def enterBehaviourEightOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourEightTitleId,
      vXListOfChosenBehaviours(7),
      behaviourEightScoreId,
      siftDetails.behaviourEight.score,
      behaviourEightCommentsId,
      siftDetails.behaviourEight.comment
    )
    vXBehavioursTotalScore += siftDetails.behaviourEight.score
  }

  private def totalScore(runningScore: ListBuffer[Int]): Int = {
    var score = 0
    runningScore.foreach(score += _)
    score
  }

  private val behaviourOutcome: Seq[SiftDetails => Unit] = Seq(
    enterBehaviourOneOutcome,
    enterBehaviourTwoOutcome,
    enterBehaviourThreeOutcome,
    enterBehaviourFourOutcome,
    enterBehaviourFiveOutcome,
    enterBehaviourSixOutcome,
    enterBehaviourSevenOutcome,
    enterBehaviourEightOutcome
  )

  private def behavioursOutcome(siftDetails: SiftDetails): Unit =
    if (vXBehavioursRequired) {
      behaviourOutcome.take(vXHowManyBehaviours).foreach { f =>
        f(siftDetails)
      }
      waitForVisibilityOfElementById(
        behaviourTotalScoreId
      ).getText should endWith(s"${totalScore(vXBehavioursTotalScore)}")
//      ).getText shouldEqual s"Behaviour total score\n  ${totalScore(vXBehavioursTotalScore)}"
    }

  private def enterTechSkillOneOutcome(siftDetails: SiftDetails): Unit = {
    scrollToElement(By.id(techSkillsHeaderId))
    waitForVisibilityOfElementById(techSkillsHeaderId).getText  shouldEqual "Technical skills"
    waitForVisibilityOfElementById(techSkillsScoringGuideId).getText should include(siftDetails.scoringGuide)
    enterOutcome(
      techSkillOneTitleId,
      vXListOfTechSkills.head,
      techSkillOneScoreId,
      siftDetails.techSkillOne.score,
      techSkillOneCommentsId,
      siftDetails.techSkillOne.comment
    )
    vXTechSkillsTotalScore.clear()
    vXTechSkillsTotalScore += siftDetails.techSkillOne.score
  }

  private def enterTechSkillTwoOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillTwoTitleId,
      vXListOfTechSkills(1),
      techSkillTwoScoreId,
      siftDetails.techSkillTwo.score,
      techSkillTwoCommentsId,
      siftDetails.techSkillTwo.comment
    )
    vXTechSkillsTotalScore += siftDetails.techSkillTwo.score
  }

  private def enterTechSkillThreeOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillThreeTitleId,
      vXListOfTechSkills(2),
      techSkillThreeScoreId,
      siftDetails.techSkillThree.score,
      techSkillThreeCommentsId,
      siftDetails.techSkillThree.comment
    )
    vXTechSkillsTotalScore += siftDetails.techSkillThree.score
  }

  private def enterTechSkillFourOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillFourTitleId,
      vXListOfTechSkills(3),
      techSkillFourScoreId,
      siftDetails.techSkillFour.score,
      techSkillFourCommentsId,
      siftDetails.techSkillFour.comment
    )
    vXTechSkillsTotalScore += siftDetails.techSkillFour.score
  }

  private def enterTechSkillFiveOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillFiveTitleId,
      vXListOfTechSkills(4),
      techSkillFiveScoreId,
      siftDetails.techSkillFive.score,
      techSkillFiveCommentsId,
      siftDetails.techSkillFive.comment
    )
    vXTechSkillsTotalScore += siftDetails.techSkillFive.score
  }

  private def enterTechSkillSixOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillSixTitleId,
      vXListOfTechSkills(5),
      techSkillSixScoreId,
      siftDetails.techSkillSix.score,
      techSkillSixCommentsId,
      siftDetails.techSkillSix.comment
    )
    vXTechSkillsTotalScore += siftDetails.techSkillSix.score
  }

  private def enterTechSkillSevenOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillSevenTitleId,
      vXListOfTechSkills(6),
      techSkillSevenScoreId,
      siftDetails.techSkillSeven.score,
      techSkillSevenCommentsId,
      siftDetails.techSkillSeven.comment
    )
    vXTechSkillsTotalScore += siftDetails.techSkillSeven.score
  }

  private def enterTechSkillEightOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillEightTitleId,
      vXListOfTechSkills(7),
      techSkillEightScoreId,
      siftDetails.techSkillEight.score,
      techSkillEightCommentsId,
      siftDetails.techSkillEight.comment
    )
    vXTechSkillsTotalScore += siftDetails.techSkillEight.score
  }

  private val skillOutcome: Seq[SiftDetails => Unit] = Seq(
    enterTechSkillOneOutcome,
    enterTechSkillTwoOutcome,
    enterTechSkillThreeOutcome,
    enterTechSkillFourOutcome,
    enterTechSkillFiveOutcome,
    enterTechSkillSixOutcome,
    enterTechSkillSevenOutcome,
    enterTechSkillEightOutcome
  )

  private def techSkillOutcome(siftDetails: SiftDetails): Unit =
    if (vXTechSkillsRequired) {
      skillOutcome.take(vXHowManySkills).foreach { f =>
        f(siftDetails)
      }
      waitForVisibilityOfElementById(
        techSkillTotalScoreId
      ).getText shouldEqual s"Technical skill total score  \n${totalScore(vXTechSkillsTotalScore)}"
    }

  private def enterCVAssessmentOutcome(siftDetails: SiftDetails): Unit =
    if (vXExperiencesRequired) {
      enterOutcome(
        cvAssessmentTitleId,
        "CV assessment",
        cvAssessmentScoreId,
        siftDetails.cvAssessment.score,
        cvAssessmentCommentsId,
        siftDetails.cvAssessment.comment
      )
      vXCVAssessmentScore = siftDetails.cvAssessment.score
    }

  private def enterPersonalStatementOutcome(siftDetails: SiftDetails): Unit =
    if (vXExperiencesRequired) {
      enterOutcome(
        personalStatementTitleId,
        "Personal statement",
        personalStatementScoreId,
        siftDetails.personalStatement.score,
        personalStatementCommentsId,
        siftDetails.personalStatement.comment
      )
      vXPersonalStatementScore = siftDetails.personalStatement.score
    }

  private def enterOverallScore(siftDetails: SiftDetails): Unit = {
    waitForVisibilityOfElementById(overallScoreTitleId).getText shouldEqual "Overall score"
    enterValue(overallCommentsId, siftDetails.overallScoreComments)
    val overallScore = totalScore(vXBehavioursTotalScore) + totalScore(
      vXTechSkillsTotalScore
    ) + vXCVAssessmentScore + vXPersonalStatementScore
//    waitForVisibilityOfElementById(overallScoreId).getText shouldEqual s"Overall score  \n $overallScore"
    waitForVisibilityOfElementById(overallScoreId).getText should endWith(s"$overallScore")
  }

  private def enterOutcome(siftDetails: SiftDetails): Unit = {
    waitForVisibilityOfElementById(outcomeTitleId).getText         shouldEqual "Outcome"
    waitForVisibilityOfElementById(outcomeId).click()
    action().moveToElement(waitForDropdownOption(siftDetails.finalOutcome)).perform()
    waitForDropdownOption(siftDetails.finalOutcome).click()
    waitForVisibilityOfElementById(declarationStatementId).getText shouldEqual siftDetails.declarationStatement
  }

  private val sift: Seq[SiftDetails => Unit] = Seq(
    behavioursOutcome,
    techSkillOutcome,
    enterCVAssessmentOutcome,
    enterPersonalStatementOutcome,
    enterOverallScore,
    enterOutcome
  )

  def SiftEvaluationFlow(applicationDetails: ApplicationDetails): Unit = {
    moveSiftEvaluationForm()
    sift.foreach { f =>
      f(applicationDetails.siftDetails)
    }
    clickOn(submitForm)
    siftEvaluation()
    if (vXAnyOnlineTests || vXInterviewExpectedRounds == "No interviews") {
      successfulAtSiftState()
    } else {
      applicationBeingReviewedState()
    }
  }
}
