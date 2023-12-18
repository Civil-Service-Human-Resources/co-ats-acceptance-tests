package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.ApplicationSummaryDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXBehavioursRequired, vXHowManyBehaviours, vXHowManySkills, vXListOfChosenBehaviours, vXListOfTechSkills, vXTechSkillsRequired}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeSiftBarId, siftEvaluation, withdrawBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

import scala.collection.mutable.ListBuffer

case class Outcome(score: Int, comment: Option[String] = None)

case class SiftDetails(

)

object ScheduleOfflineInterviewPage extends VacancyBasePage {

  private lazy val offlineInterviewPageTitle      = "Generate Communication : Schedule offline interview : Civil Service Jobs - GOV.UK"
  def siftEvaluationHeaderId                  = s"${vacancyFormId}_label_153018_1"

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
      enterText(commentsId, comment.get)
    }
  }

  private def moveSiftEvaluationForm(): Unit = {
    checkVacancyStatus("Sift application")
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
      ).getText shouldEqual s"Behaviour total score\n  ${totalScore(vXBehavioursTotalScore)}"
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
      ).getText shouldEqual s"Technical skill total score\n  ${totalScore(vXTechSkillsTotalScore)}"
    }

  private def enterCVAssessmentOutcome(siftDetails: SiftDetails): Unit = {
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

  private def enterPersonalStatementOutcome(siftDetails: SiftDetails): Unit = {
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
    enterText(overallCommentsId, siftDetails.overallScoreComments)
    val overallScore = totalScore(vXBehavioursTotalScore) + totalScore(
      vXTechSkillsTotalScore
    ) + vXCVAssessmentScore + vXPersonalStatementScore
    waitForVisibilityOfElementById(overallScoreId).getText shouldEqual s"Overall score\n  $overallScore"
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

  def SiftEvaluationFlow(applicationSummaryDetails: ApplicationSummaryDetails): Unit = {
    moveSiftEvaluationForm()
    sift.foreach { f =>
      f(applicationSummaryDetails.siftDetails)
    }
    clickOn(submitForm)
    siftEvaluation()
    println("DOne")
  }
}
