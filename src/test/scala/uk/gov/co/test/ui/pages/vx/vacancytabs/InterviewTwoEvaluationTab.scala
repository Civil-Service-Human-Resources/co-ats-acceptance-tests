package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXBehavioursRequired, vXHowManyBehaviours, vXHowManySkills, vXHowManyStrengths, vXInterviewTwoOutcome, vXListOfChosenBehaviours, vXListOfStrengths, vXListOfTechSkills, vXStrengthsRequired, vXTechSkillsRequired, vacancyFormId}
import uk.gov.co.test.ui.data.vx.{ApplicationDetails, AssessmentOutcome, Outcome}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.applicationStateAfterInterview
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeI2EvaluationBarId, interviewEvaluation, noShowI2BarId, withdrawAtInterviewBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

case class InterviewTwoDetails(
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
  strengthScoringGuide: String,
  strengthOne: Outcome,
  strengthTwo: Outcome,
  strengthThree: Outcome,
  strengthFour: Outcome,
  strengthFive: Outcome,
  strengthSix: Outcome,
  strengthSeven: Outcome,
  strengthEight: Outcome,
  additionalAssessments: String,
  assessmentOne: AssessmentOutcome,
  assessmentTwo: AssessmentOutcome,
  assessmentThree: AssessmentOutcome,
  assessmentFour: AssessmentOutcome,
  assessmentFive: AssessmentOutcome,
  assessmentSix: AssessmentOutcome,
  experience: Outcome,
  overrideScore: Boolean,
  overallOverrideScore: Int,
  finalOutcome: String,
  finalOutcomeComments: String,
  uploadDocs: String,
  declarationStatement: String
)

object InterviewTwoEvaluationTab extends VacancyBasePage {

  private lazy val interviewTwoEvaluationTabPath = ".//span[@class='main-label' and text() = 'Interview 2 Evaluation']"
  var vXI2BehavioursTotalScore: ListBuffer[Int]  = ListBuffer()
  var vXI2TechSkillsTotalScore: ListBuffer[Int]  = ListBuffer()
  var vXI2StrengthsTotalScore: ListBuffer[Int]   = ListBuffer()
  var vXI2AssessmentsTotalScore: ListBuffer[Int] = ListBuffer()
  var vXI2ExperienceScore: Int                   = 92
  def interviewTwoEvaluationHeaderId             = s"${vacancyFormId}_label_153356_1"
  def behaviourAssessmentHeaderId                = s"${vacancyFormId}_label_23497_1"
  def behaviourScoringGuideId                    = s"${vacancyFormId}_label_153869_1"
  def behaviourOneTitleId                        = s"${vacancyFormId}_label_23499_1"
  def behaviourOneScoreId                        = s"select2-${vacancyFormId}_datafield_24302_1_1-container"
  def behaviourOneCommentsId                     = s"${vacancyFormId}_datafield_24334_1_1"
  def behaviourTwoTitleId                        = s"${vacancyFormId}_label_23501_1"
  def behaviourTwoScoreId                        = s"select2-${vacancyFormId}_datafield_24305_1_1-container"
  def behaviourTwoCommentsId                     = s"${vacancyFormId}_datafield_24340_1_1"
  def behaviourThreeTitleId                      = s"${vacancyFormId}_label_23503_1"
  def behaviourThreeScoreId                      = s"select2-${vacancyFormId}_datafield_24308_1_1-container"
  def behaviourThreeCommentsId                   = s"${vacancyFormId}_datafield_24346_1_1"
  def behaviourFourTitleId                       = s"${vacancyFormId}_label_23505_1"
  def behaviourFourScoreId                       = s"select2-${vacancyFormId}_datafield_24319_1_1-container"
  def behaviourFourCommentsId                    = s"${vacancyFormId}_datafield_24352_1_1"
  def behaviourFiveTitleId                       = s"${vacancyFormId}_label_23507_1"
  def behaviourFiveScoreId                       = s"select2-${vacancyFormId}_datafield_24322_1_1-container"
  def behaviourFiveCommentsId                    = s"${vacancyFormId}_datafield_24358_1_1"
  def behaviourSixTitleId                        = s"${vacancyFormId}_label_23509_1"
  def behaviourSixScoreId                        = s"select2-${vacancyFormId}_datafield_24325_1_1-container"
  def behaviourSixCommentsId                     = s"${vacancyFormId}_datafield_24364_1_1"
  def behaviourSevenTitleId                      = s"${vacancyFormId}_label_23511_1"
  def behaviourSevenScoreId                      = s"select2-${vacancyFormId}_datafield_24328_1_1-container"
  def behaviourSevenCommentsId                   = s"${vacancyFormId}_datafield_24370_1_1"
  def behaviourEightTitleId                      = s"${vacancyFormId}_label_23513_1"
  def behaviourEightScoreId                      = s"select2-${vacancyFormId}_datafield_24331_1_1-container"
  def behaviourEightCommentsId                   = s"${vacancyFormId}_datafield_24376_1_1"
  def behaviourTotalScoreId                      = s"${vacancyFormId}_field_27688_1"
  def techSkillsHeaderId                         = s"${vacancyFormId}_label_69181_1"
  def techSkillsScoringGuideId                   = s"${vacancyFormId}_label_153872_1"
  def techSkillOneTitleId                        = s"${vacancyFormId}_label_68034_1"
  def techSkillOneScoreId                        = s"select2-${vacancyFormId}_datafield_68009_1_1-container"
  def techSkillOneCommentsId                     = s"${vacancyFormId}_datafield_67961_1_1"
  def techSkillTwoTitleId                        = s"${vacancyFormId}_label_68037_1"
  def techSkillTwoScoreId                        = s"select2-${vacancyFormId}_datafield_68012_1_1-container"
  def techSkillTwoCommentsId                     = s"${vacancyFormId}_datafield_67967_1_1"
  def techSkillThreeTitleId                      = s"${vacancyFormId}_label_68040_1"
  def techSkillThreeScoreId                      = s"select2-${vacancyFormId}_datafield_68015_1_1-container"
  def techSkillThreeCommentsId                   = s"${vacancyFormId}_datafield_67973_1_1"
  def techSkillFourTitleId                       = s"${vacancyFormId}_label_68043_1"
  def techSkillFourScoreId                       = s"select2-${vacancyFormId}_datafield_68018_1_1-container"
  def techSkillFourCommentsId                    = s"${vacancyFormId}_datafield_67979_1_1"
  def techSkillFiveTitleId                       = s"${vacancyFormId}_label_68046_1"
  def techSkillFiveScoreId                       = s"select2-${vacancyFormId}_datafield_68021_1_1-container"
  def techSkillFiveCommentsId                    = s"${vacancyFormId}_datafield_67985_1_1"
  def techSkillSixTitleId                        = s"${vacancyFormId}_label_68049_1"
  def techSkillSixScoreId                        = s"select2-${vacancyFormId}_datafield_68024_1_1-container"
  def techSkillSixCommentsId                     = s"${vacancyFormId}_datafield_67991_1_1"
  def techSkillSevenTitleId                      = s"${vacancyFormId}_label_68052_1"
  def techSkillSevenScoreId                      = s"select2-${vacancyFormId}_datafield_68027_1_1-container"
  def techSkillSevenCommentsId                   = s"${vacancyFormId}_datafield_67997_1_1"
  def techSkillEightTitleId                      = s"${vacancyFormId}_label_68055_1"
  def techSkillEightScoreId                      = s"select2-${vacancyFormId}_datafield_68030_1_1-container"
  def techSkillEightCommentsId                   = s"${vacancyFormId}_datafield_68003_1_1"
  def techSkillTotalScoreId                      = s"${vacancyFormId}_field_68346_1"
  def strengthsHeaderId                          = s"${vacancyFormId}_label_46156_1"
  def strengthScoringGuideId                     = s"${vacancyFormId}_label_46469_1"
  def strengthOneTitleId                         = s"${vacancyFormId}_label_117836_1"
  def strengthOneScoreId                         = s"select2-${vacancyFormId}_datafield_46095_1_1-container"
  def strengthOneCommentsId                      = s"${vacancyFormId}_datafield_46047_1_1"
  def strengthTwoTitleId                         = s"${vacancyFormId}_label_117840_1"
  def strengthTwoScoreId                         = s"select2-${vacancyFormId}_datafield_46098_1_1-container"
  def strengthTwoCommentsId                      = s"${vacancyFormId}_datafield_46053_1_1"
  def strengthThreeTitleId                       = s"${vacancyFormId}_label_117847_1"
  def strengthThreeScoreId                       = s"select2-${vacancyFormId}_datafield_46101_1_1-container"
  def strengthThreeCommentsId                    = s"${vacancyFormId}_datafield_46059_1_1"
  def strengthFourTitleId                        = s"${vacancyFormId}_label_117853_1"
  def strengthFourScoreId                        = s"select2-${vacancyFormId}_datafield_46104_1_1-container"
  def strengthFourCommentsId                     = s"${vacancyFormId}_datafield_46065_1_1"
  def strengthFiveTitleId                        = s"${vacancyFormId}_label_117857_1"
  def strengthFiveScoreId                        = s"select2-${vacancyFormId}_datafield_46107_1_1-container"
  def strengthFiveCommentsId                     = s"${vacancyFormId}_datafield_46071_1_1"
  def strengthSixTitleId                         = s"${vacancyFormId}_label_117861_1"
  def strengthSixScoreId                         = s"select2-${vacancyFormId}_datafield_46110_1_1-container"
  def strengthSixCommentsId                      = s"${vacancyFormId}_datafield_46077_1_1"
  def strengthSevenTitleId                       = s"${vacancyFormId}_label_117865_1"
  def strengthSevenScoreId                       = s"select2-${vacancyFormId}_datafield_46113_1_1-container"
  def strengthSevenCommentsId                    = s"${vacancyFormId}_datafield_46083_1_1"
  def strengthEightTitleId                       = s"${vacancyFormId}_label_117869_1"
  def strengthEightScoreId                       = s"select2-${vacancyFormId}_datafield_46116_1_1-container"
  def strengthEightCommentsId                    = s"${vacancyFormId}_datafield_46089_1_1"
  def strengthTotalScoreId                       = s"${vacancyFormId}_field_71703_1"
  def assessmentHeaderId                         = s"${vacancyFormId}_label_47351_1"
  def assessmentInfoId                           = s"${vacancyFormId}_label_116181_1"
  def assessmentsHowManyId                       = s"select2-${vacancyFormId}_datafield_71654_1_1-container"
  def assessmentOneNameId                        = s"${vacancyFormId}_datafield_47140_1_1"
  def assessmentOneScoreId                       = s"select2-${vacancyFormId}_datafield_47100_1_1-container"
  def assessmentOneCommentsId                    = s"${vacancyFormId}_datafield_47079_1_1"
  def assessmentTwoNameId                        = s"${vacancyFormId}_datafield_47146_1_1"
  def assessmentTwoScoreId                       = s"select2-${vacancyFormId}_datafield_47104_1_1-container"
  def assessmentTwoCommentsId                    = s"${vacancyFormId}_datafield_47086_1_1"
  def assessmentThreeNameId                      = s"${vacancyFormId}_datafield_47152_1_1"
  def assessmentThreeScoreId                     = s"select2-${vacancyFormId}_datafield_47108_1_1-container"
  def assessmentThreeCommentsId                  = s"${vacancyFormId}_datafield_47093_1_1"
  def assessmentFourNameId                       = s"${vacancyFormId}_datafield_47158_1_1"
  def assessmentFourScoreId                      = s"select2-${vacancyFormId}_datafield_47112_1_1-container"
  def assessmentFourCommentsId                   = s"${vacancyFormId}_datafield_47115_1_1"
  def assessmentFiveNameId                       = s"${vacancyFormId}_datafield_47164_1_1"
  def assessmentFiveScoreId                      = s"select2-${vacancyFormId}_datafield_47121_1_1-container"
  def assessmentFiveCommentsId                   = s"${vacancyFormId}_datafield_47124_1_1"
  def assessmentSixNameId                        = s"${vacancyFormId}_datafield_47170_1_1"
  def assessmentSixScoreId                       = s"select2-${vacancyFormId}_datafield_47130_1_1-container"
  def assessmentSixCommentsId                    = s"${vacancyFormId}_datafield_47133_1_1"
  def experienceTitleId                          = s"${vacancyFormId}_label_108185_1"
  def experienceScoreId                          = s"select2-${vacancyFormId}_datafield_108320_1_1-container"
  def experienceDescriptionId                    = s"${vacancyFormId}_datafield_108195_1_1"
  def overallScoreTitleId                        = s"${vacancyFormId}_label_23517_1"
  def overallScoreId                             = s"${vacancyFormId}_datafield_24412_1_1"
  def overallOverrideScoreId                     = s"${vacancyFormId}_datafield_116081_1_1"
  def outcomeTitleId                             = s"${vacancyFormId}_label_49508_1"
  def outcomeId                                  = s"select2-${vacancyFormId}_datafield_49770_1_1-container"
  def outcomeCommentsId                          = s"${vacancyFormId}_datafield_49764_1_1"
  def uploadIDTitleId                            = s"${vacancyFormId}_label_56057_1"
  def uploadIDId                                 = s"${vacancyFormId}_datafield_56027_1_1"
  def declarationStatementId                     = s"${vacancyFormId}_label_49825_1"

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

  def enterAssessmentOutcome(
    nameId: String,
    assessmentName: String,
    scoreId: String,
    score: Int,
    commentsId: String,
    comment: Option[String] = None
  ): Unit = {
    waitForVisibilityOfElementById(nameId).sendKeys(assessmentName)
    waitForVisibilityOfElementById(scoreId).click()
    action().moveToElement(waitForDropdownOption(score.toString)).perform()
    waitForDropdownOption(score.toString).click()
    if (comment.isDefined) {
      enterValue(commentsId, comment.get)
    }
  }

  private def moveInterviewScheduleForm(): Unit = {
    moveVacancyOnViaTopBar(completeI2EvaluationBarId, interviewTwoEvaluationTabPath)
    availableBarItems(List(completeI2EvaluationBarId, noShowI2BarId, withdrawAtInterviewBarId))
    waitForVisibilityOfElementById(interviewTwoEvaluationHeaderId).getText should endWith("Interview 2 Evaluation")
  }

  private def enterBehaviourOneOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    waitForVisibilityOfElementById(behaviourAssessmentHeaderId).getText shouldEqual "Behaviour assessment"
    waitForVisibilityOfElementById(behaviourScoringGuideId).getText          should include(interviewTwoDetails.scoringGuide)
    enterOutcome(
      behaviourOneTitleId,
      vXListOfChosenBehaviours.head,
      behaviourOneScoreId,
      interviewTwoDetails.behaviourOne.score,
      behaviourOneCommentsId,
      interviewTwoDetails.behaviourOne.comment
    )
    vXI2BehavioursTotalScore.clear()
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourOne.score
  }

  private def enterBehaviourTwoOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      behaviourTwoTitleId,
      vXListOfChosenBehaviours(1),
      behaviourTwoScoreId,
      interviewTwoDetails.behaviourTwo.score,
      behaviourTwoCommentsId,
      interviewTwoDetails.behaviourTwo.comment
    )
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourTwo.score
  }

  private def enterBehaviourThreeOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      behaviourThreeTitleId,
      vXListOfChosenBehaviours(2),
      behaviourThreeScoreId,
      interviewTwoDetails.behaviourThree.score,
      behaviourThreeCommentsId,
      interviewTwoDetails.behaviourThree.comment
    )
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourThree.score
  }

  private def enterBehaviourFourOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    scrollToElement(By.id(behaviourFourTitleId))
    enterOutcome(
      behaviourFourTitleId,
      vXListOfChosenBehaviours(3),
      behaviourFourScoreId,
      interviewTwoDetails.behaviourFour.score,
      behaviourFourCommentsId,
      interviewTwoDetails.behaviourFour.comment
    )
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourFour.score
  }

  private def enterBehaviourFiveOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      behaviourFiveTitleId,
      vXListOfChosenBehaviours(4),
      behaviourFiveScoreId,
      interviewTwoDetails.behaviourFive.score,
      behaviourFiveCommentsId,
      interviewTwoDetails.behaviourFive.comment
    )
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourFive.score
  }

  private def enterBehaviourSixOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    scrollToElement(By.id(behaviourSixTitleId))
    enterOutcome(
      behaviourSixTitleId,
      vXListOfChosenBehaviours(5),
      behaviourSixScoreId,
      interviewTwoDetails.behaviourSix.score,
      behaviourSixCommentsId,
      interviewTwoDetails.behaviourSix.comment
    )
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourSix.score
  }

  private def enterBehaviourSevenOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      behaviourSevenTitleId,
      vXListOfChosenBehaviours(6),
      behaviourSevenScoreId,
      interviewTwoDetails.behaviourSeven.score,
      behaviourSevenCommentsId,
      interviewTwoDetails.behaviourSeven.comment
    )
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourSeven.score
  }

  private def enterBehaviourEightOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      behaviourEightTitleId,
      vXListOfChosenBehaviours(7),
      behaviourEightScoreId,
      interviewTwoDetails.behaviourEight.score,
      behaviourEightCommentsId,
      interviewTwoDetails.behaviourEight.comment
    )
    vXI2BehavioursTotalScore += interviewTwoDetails.behaviourEight.score
  }

  private def totalScore(runningScore: ListBuffer[Int]): Int = {
    var score = 0
    runningScore.foreach(score += _)
    score
  }

  private val behaviourOutcome: Seq[InterviewTwoDetails => Unit] = Seq(
    enterBehaviourOneOutcome,
    enterBehaviourTwoOutcome,
    enterBehaviourThreeOutcome,
    enterBehaviourFourOutcome,
    enterBehaviourFiveOutcome,
    enterBehaviourSixOutcome,
    enterBehaviourSevenOutcome,
    enterBehaviourEightOutcome
  )

  private def behavioursOutcome(interviewTwoDetails: InterviewTwoDetails): Unit =
    if (vXBehavioursRequired) {
      behaviourOutcome.take(vXHowManyBehaviours).foreach { f =>
        f(interviewTwoDetails)
      }
      waitForVisibilityOfElementById(
        behaviourTotalScoreId
      ).getText shouldEqual s"Behaviour total score\n  ${totalScore(vXI2BehavioursTotalScore)}"
    }

  private def enterTechSkillOneOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    scrollToElement(By.id(techSkillsHeaderId))
    waitForVisibilityOfElementById(techSkillsHeaderId).getText  shouldEqual "Technical skill assessment"
    waitForVisibilityOfElementById(techSkillsScoringGuideId).getText should include(interviewTwoDetails.scoringGuide)
    enterOutcome(
      techSkillOneTitleId,
      vXListOfTechSkills.head,
      techSkillOneScoreId,
      interviewTwoDetails.techSkillOne.score,
      techSkillOneCommentsId,
      interviewTwoDetails.techSkillOne.comment
    )
    vXI2TechSkillsTotalScore.clear()
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillOne.score
  }

  private def enterTechSkillTwoOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      techSkillTwoTitleId,
      vXListOfTechSkills(1),
      techSkillTwoScoreId,
      interviewTwoDetails.techSkillTwo.score,
      techSkillTwoCommentsId,
      interviewTwoDetails.techSkillTwo.comment
    )
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillTwo.score
  }

  private def enterTechSkillThreeOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      techSkillThreeTitleId,
      vXListOfTechSkills(2),
      techSkillThreeScoreId,
      interviewTwoDetails.techSkillThree.score,
      techSkillThreeCommentsId,
      interviewTwoDetails.techSkillThree.comment
    )
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillThree.score
  }

  private def enterTechSkillFourOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      techSkillFourTitleId,
      vXListOfTechSkills(3),
      techSkillFourScoreId,
      interviewTwoDetails.techSkillFour.score,
      techSkillFourCommentsId,
      interviewTwoDetails.techSkillFour.comment
    )
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillFour.score
  }

  private def enterTechSkillFiveOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      techSkillFiveTitleId,
      vXListOfTechSkills(4),
      techSkillFiveScoreId,
      interviewTwoDetails.techSkillFive.score,
      techSkillFiveCommentsId,
      interviewTwoDetails.techSkillFive.comment
    )
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillFive.score
  }

  private def enterTechSkillSixOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      techSkillSixTitleId,
      vXListOfTechSkills(5),
      techSkillSixScoreId,
      interviewTwoDetails.techSkillSix.score,
      techSkillSixCommentsId,
      interviewTwoDetails.techSkillSix.comment
    )
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillSix.score
  }

  private def enterTechSkillSevenOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      techSkillSevenTitleId,
      vXListOfTechSkills(6),
      techSkillSevenScoreId,
      interviewTwoDetails.techSkillSeven.score,
      techSkillSevenCommentsId,
      interviewTwoDetails.techSkillSeven.comment
    )
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillSeven.score
  }

  private def enterTechSkillEightOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      techSkillEightTitleId,
      vXListOfTechSkills(7),
      techSkillEightScoreId,
      interviewTwoDetails.techSkillEight.score,
      techSkillEightCommentsId,
      interviewTwoDetails.techSkillEight.comment
    )
    vXI2TechSkillsTotalScore += interviewTwoDetails.techSkillEight.score
  }

  private val skillOutcome: Seq[InterviewTwoDetails => Unit] = Seq(
    enterTechSkillOneOutcome,
    enterTechSkillTwoOutcome,
    enterTechSkillThreeOutcome,
    enterTechSkillFourOutcome,
    enterTechSkillFiveOutcome,
    enterTechSkillSixOutcome,
    enterTechSkillSevenOutcome,
    enterTechSkillEightOutcome
  )

  private def techSkillOutcome(interviewTwoDetails: InterviewTwoDetails): Unit =
    if (vXTechSkillsRequired) {
      skillOutcome.take(vXHowManySkills).foreach { f =>
        f(interviewTwoDetails)
      }
      waitForVisibilityOfElementById(
        techSkillTotalScoreId
      ).getText shouldEqual s"Technical skill overall score\n  ${totalScore(vXI2TechSkillsTotalScore)}"
    }

  private def enterStrengthOneOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    scrollToElement(By.id(strengthsHeaderId))
    waitForVisibilityOfElementById(strengthsHeaderId).getText shouldEqual "Strength assessment"
    waitForVisibilityOfElementById(strengthScoringGuideId).getText should include(
      interviewTwoDetails.strengthScoringGuide
    )
    enterOutcome(
      strengthOneTitleId,
      s"Strength 1  \n${vXListOfStrengths.head}",
      strengthOneScoreId,
      interviewTwoDetails.strengthOne.score,
      strengthOneCommentsId,
      interviewTwoDetails.strengthOne.comment
    )
    vXI2StrengthsTotalScore.clear()
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthOne.score
  }

  private def enterStrengthTwoOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      strengthTwoTitleId,
      s"Strength 2  \n${vXListOfStrengths(1)}",
      strengthTwoScoreId,
      interviewTwoDetails.strengthTwo.score,
      strengthTwoCommentsId,
      interviewTwoDetails.strengthTwo.comment
    )
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthTwo.score
  }

  private def enterStrengthThreeOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      strengthThreeTitleId,
      s"Strength 3  \n${vXListOfStrengths(2)}",
      strengthThreeScoreId,
      interviewTwoDetails.strengthThree.score,
      strengthThreeCommentsId,
      interviewTwoDetails.strengthThree.comment
    )
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthThree.score
  }

  private def enterStrengthFourOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      strengthFourTitleId,
      s"Strength 4  \n${vXListOfStrengths(3)}",
      strengthFourScoreId,
      interviewTwoDetails.strengthFour.score,
      strengthFourCommentsId,
      interviewTwoDetails.strengthFour.comment
    )
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthFour.score
  }

  private def enterStrengthFiveOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      strengthFiveTitleId,
      s"Strength 5  \n${vXListOfStrengths(4)}",
      strengthFiveScoreId,
      interviewTwoDetails.strengthFive.score,
      strengthFiveCommentsId,
      interviewTwoDetails.strengthFive.comment
    )
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthFive.score
  }

  private def enterStrengthSixOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      strengthSixTitleId,
      s"Strength 6  \n${vXListOfStrengths(5)}",
      strengthSixScoreId,
      interviewTwoDetails.strengthSix.score,
      strengthSixCommentsId,
      interviewTwoDetails.strengthSix.comment
    )
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthSix.score
  }

  private def enterStrengthSevenOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      strengthSevenTitleId,
      s"Strength 7  \n${vXListOfStrengths(6)}",
      strengthSevenScoreId,
      interviewTwoDetails.strengthSeven.score,
      strengthSevenCommentsId,
      interviewTwoDetails.strengthSeven.comment
    )
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthSeven.score
  }

  private def enterStrengthEightOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      strengthEightTitleId,
      s"Strength 8  \n${vXListOfStrengths(7)}",
      strengthEightScoreId,
      interviewTwoDetails.strengthEight.score,
      strengthEightCommentsId,
      interviewTwoDetails.strengthEight.comment
    )
    vXI2StrengthsTotalScore += interviewTwoDetails.strengthEight.score
  }

  private val strengths: Seq[InterviewTwoDetails => Unit] = Seq(
    enterStrengthOneOutcome,
    enterStrengthTwoOutcome,
    enterStrengthThreeOutcome,
    enterStrengthFourOutcome,
    enterStrengthFiveOutcome,
    enterStrengthSixOutcome,
    enterStrengthSevenOutcome,
    enterStrengthEightOutcome
  )

  private def strengthsOutcome(interviewTwoDetails: InterviewTwoDetails): Unit =
    if (vXStrengthsRequired) {
      strengths.take(vXHowManyStrengths).foreach { f =>
        f(interviewTwoDetails)
      }
      waitForVisibilityOfElementById(
        strengthTotalScoreId
      ).getText shouldEqual s"Strengths total score\n  ${totalScore(vXI2StrengthsTotalScore)}"
    }

  private def howManyAssessments(interviewTwoDetails: InterviewTwoDetails): Unit = {
    waitForVisibilityOfElementById(assessmentsHowManyId).click()
    action().moveToElement(waitForDropdownOption(interviewTwoDetails.additionalAssessments)).perform()
    waitForDropdownOption(interviewTwoDetails.additionalAssessments).click()
  }

  private def enterAssessmentOneOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    waitForVisibilityOfElementById(assessmentHeaderId).getText shouldEqual "Additional assessments"
    waitForVisibilityOfElementById(
      assessmentInfoId
    ).getText                                                       should endWith("Additional assessment names, scores and comments will be visible to the applicant")
    enterAssessmentOutcome(
      assessmentOneNameId,
      interviewTwoDetails.assessmentOne.name,
      assessmentOneScoreId,
      interviewTwoDetails.assessmentOne.score,
      assessmentOneCommentsId,
      interviewTwoDetails.assessmentOne.comment
    )
    vXI2AssessmentsTotalScore.clear()
    vXI2AssessmentsTotalScore += interviewTwoDetails.assessmentOne.score
  }

  private def enterAssessmentTwoOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterAssessmentOutcome(
      assessmentTwoNameId,
      interviewTwoDetails.assessmentTwo.name,
      assessmentTwoScoreId,
      interviewTwoDetails.assessmentTwo.score,
      assessmentTwoCommentsId,
      interviewTwoDetails.assessmentTwo.comment
    )
    vXI2AssessmentsTotalScore += interviewTwoDetails.assessmentTwo.score
  }

  private def enterAssessmentThreeOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterAssessmentOutcome(
      assessmentThreeNameId,
      interviewTwoDetails.assessmentThree.name,
      assessmentThreeScoreId,
      interviewTwoDetails.assessmentThree.score,
      assessmentThreeCommentsId,
      interviewTwoDetails.assessmentThree.comment
    )
    vXI2AssessmentsTotalScore += interviewTwoDetails.assessmentThree.score
  }

  private def enterAssessmentFourOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFourNameId,
      interviewTwoDetails.assessmentFour.name,
      assessmentFourScoreId,
      interviewTwoDetails.assessmentFour.score,
      assessmentFourCommentsId,
      interviewTwoDetails.assessmentFour.comment
    )
    vXI2AssessmentsTotalScore += interviewTwoDetails.assessmentFour.score
  }

  private def enterAssessmentFiveOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFiveNameId,
      interviewTwoDetails.assessmentFive.name,
      assessmentFiveScoreId,
      interviewTwoDetails.assessmentFive.score,
      assessmentFiveCommentsId,
      interviewTwoDetails.assessmentFive.comment
    )
    vXI2AssessmentsTotalScore += interviewTwoDetails.assessmentFive.score
  }

  private def enterAssessmentSixOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterAssessmentOutcome(
      assessmentSixNameId,
      interviewTwoDetails.assessmentSix.name,
      assessmentSixScoreId,
      interviewTwoDetails.assessmentSix.score,
      assessmentSixCommentsId,
      interviewTwoDetails.assessmentSix.comment
    )
    vXI2AssessmentsTotalScore += interviewTwoDetails.assessmentSix.score
  }

  private val assessments: Seq[InterviewTwoDetails => Unit] = Seq(
    enterAssessmentOneOutcome,
    enterAssessmentTwoOutcome,
    enterAssessmentThreeOutcome,
    enterAssessmentFourOutcome,
    enterAssessmentFiveOutcome,
    enterAssessmentSixOutcome
  )

  private def assessmentsOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    howManyAssessments(interviewTwoDetails)
    assessments.take(interviewTwoDetails.additionalAssessments.toInt).foreach { f =>
      f(interviewTwoDetails)
    }
    totalScore(vXI2AssessmentsTotalScore)
  }

  private def enterExperienceOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    enterOutcome(
      experienceTitleId,
      "Experience assessment", //TODO this is different in I1, just "Experience"
      experienceScoreId,
      interviewTwoDetails.experience.score,
      experienceDescriptionId,
      interviewTwoDetails.experience.comment
    )
    vXI2ExperienceScore = interviewTwoDetails.experience.score
  }

  private def checkOverallScore(interviewTwoDetails: InterviewTwoDetails): Unit = {
    waitForVisibilityOfElementById(
      overallScoreTitleId
    ).getText shouldEqual "Overall score" //TODO this is different in I1, in Pascal Case
    if (interviewTwoDetails.overrideScore) {
      enterValue(overallOverrideScoreId, interviewTwoDetails.overallOverrideScore.toString)
    }
    val overallScore = totalScore(vXI2BehavioursTotalScore) + totalScore(vXI2TechSkillsTotalScore) + totalScore(
      vXI2StrengthsTotalScore
    ) + totalScore(vXI2AssessmentsTotalScore) + vXI2ExperienceScore
    waitForVisibilityOfElementById(overallScoreId).getAttribute("value") shouldEqual s"$overallScore"
  }

  private def enterOutcome(interviewTwoDetails: InterviewTwoDetails): Unit = {
    vXInterviewTwoOutcome = interviewTwoDetails.finalOutcome
    waitForVisibilityOfElementById(outcomeTitleId).getText shouldEqual "Outcome"
    waitForVisibilityOfElementById(outcomeId).click()
    action().moveToElement(waitForDropdownOption(vXInterviewTwoOutcome)).perform()
    waitForDropdownOption(vXInterviewTwoOutcome).click()
    enterValue(outcomeCommentsId, interviewTwoDetails.finalOutcomeComments)
  }

  private def uploadDocuments(interviewTwoDetails: InterviewTwoDetails): Unit = {
    waitForVisibilityOfElementById(uploadIDTitleId).getText        shouldEqual "Candidate identity documents"
    attachDocuments(uploadIDId, interviewTwoDetails.uploadDocs)
    waitForVisibilityOfElementById(declarationStatementId).getText shouldEqual interviewTwoDetails.declarationStatement
  }

  private val evaluation: Seq[InterviewTwoDetails => Unit] = Seq(
    behavioursOutcome,
    techSkillOutcome,
    strengthsOutcome,
    assessmentsOutcome,
    enterExperienceOutcome,
    checkOverallScore,
    enterOutcome,
    uploadDocuments
  )

  def interviewTwoEvaluationFlow(applicationDetails: ApplicationDetails): Unit = {
    moveInterviewScheduleForm()
    evaluation.foreach { f =>
      f(applicationDetails.interviewTwoDetails)
    }
    clickOn(submitForm)
    interviewEvaluation()
    applicationStateAfterInterview(applicationDetails)
//    applicationBeingReviewedAfterInterviewState()
  }
}
