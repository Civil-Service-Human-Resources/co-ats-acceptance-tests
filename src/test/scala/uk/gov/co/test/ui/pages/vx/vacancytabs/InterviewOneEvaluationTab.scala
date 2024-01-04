package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXBehavioursRequired, vXHowManyBehaviours, vXHowManySkills, vXHowManyStrengths, vXListOfChosenBehaviours, vXListOfStrengths, vXListOfTechSkills, vXStrengthsRequired, vXTechSkillsRequired}
import uk.gov.co.test.ui.data.vx.{ApplicationDetails, AssessmentOutcome, Outcome}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.applicationBeingReviewedAfterInterviewState
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeI1EvaluationBarId, interviewEvaluation, noShowI1BarId, withdrawAtInterviewBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

import scala.collection.mutable.ListBuffer

case class InterviewOneDetails(
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

object InterviewOneEvaluationTab extends VacancyBasePage {

  private lazy val interviewOneEvaluationTabPath = ".//span[@class='main-label' and text() = 'Interview 1 Evaluation']"
  var vXI1BehavioursTotalScore: ListBuffer[Int]  = ListBuffer()
  var vXI1TechSkillsTotalScore: ListBuffer[Int]  = ListBuffer()
  var vXI1StrengthsTotalScore: ListBuffer[Int]   = ListBuffer()
  var vXI1AssessmentsTotalScore: ListBuffer[Int] = ListBuffer()
  var vXI1ExperienceScore: Int                   = 91
  def interviewOneEvaluationHeaderId             = s"${vacancyFormId}_label_153071_1"
  def interviewTwoEvaluationHeaderId             = s"${vacancyFormId}_label_153356_1"
  def behaviourAssessmentHeaderId                = s"${vacancyFormId}_label_23467_1"
  def behaviourScoringGuideId                    = s"${vacancyFormId}_label_153737_1"
  def behaviourOneTitleId                        = s"${vacancyFormId}_label_23469_1"
  def behaviourOneScoreId                        = s"select2-${vacancyFormId}_datafield_23772_1_1-container"
  def behaviourOneCommentsId                     = s"${vacancyFormId}_datafield_115621_1_1"
  def behaviourTwoTitleId                        = s"${vacancyFormId}_label_23471_1"
  def behaviourTwoScoreId                        = s"select2-${vacancyFormId}_datafield_23775_1_1-container"
  def behaviourTwoCommentsId                     = s"${vacancyFormId}_datafield_23797_1_1"
  def behaviourThreeTitleId                      = s"${vacancyFormId}_label_23473_1"
  def behaviourThreeScoreId                      = s"select2-${vacancyFormId}_datafield_23745_1_1-container"
  def behaviourThreeCommentsId                   = s"${vacancyFormId}_datafield_23804_1_1"
  def behaviourFourTitleId                       = s"${vacancyFormId}_label_23475_1"
  def behaviourFourScoreId                       = s"select2-${vacancyFormId}_datafield_23749_1_1-container"
  def behaviourFourCommentsId                    = s"${vacancyFormId}_datafield_23811_1_1"
  def behaviourFiveTitleId                       = s"${vacancyFormId}_label_23477_1"
  def behaviourFiveScoreId                       = s"select2-${vacancyFormId}_datafield_23753_1_1-container"
  def behaviourFiveCommentsId                    = s"${vacancyFormId}_datafield_23818_1_1"
  def behaviourSixTitleId                        = s"${vacancyFormId}_label_23479_1"
  def behaviourSixScoreId                        = s"select2-${vacancyFormId}_datafield_23761_1_1-container"
  def behaviourSixCommentsId                     = s"${vacancyFormId}_datafield_23825_1_1"
  def behaviourSevenTitleId                      = s"${vacancyFormId}_label_23481_1"
  def behaviourSevenScoreId                      = s"select2-${vacancyFormId}_datafield_23757_1_1-container"
  def behaviourSevenCommentsId                   = s"${vacancyFormId}_datafield_23832_1_1"
  def behaviourEightTitleId                      = s"${vacancyFormId}_label_23483_1"
  def behaviourEightScoreId                      = s"select2-${vacancyFormId}_datafield_23778_1_1-container"
  def behaviourEightCommentsId                   = s"${vacancyFormId}_datafield_23839_1_1"
  def behaviourTotalScoreId                      = s"${vacancyFormId}_field_27661_1"
  def techSkillsHeaderId                         = s"${vacancyFormId}_label_69255_1"
  def techSkillsScoringGuideId                   = s"${vacancyFormId}_label_153734_1"
  def techSkillOneTitleId                        = s"${vacancyFormId}_label_67650_1"
  def techSkillOneScoreId                        = s"select2-${vacancyFormId}_datafield_67625_1_1-container"
  def techSkillOneCommentsId                     = s"${vacancyFormId}_datafield_67577_1_1"
  def techSkillTwoTitleId                        = s"${vacancyFormId}_label_67653_1"
  def techSkillTwoScoreId                        = s"select2-${vacancyFormId}_datafield_67628_1_1-container"
  def techSkillTwoCommentsId                     = s"${vacancyFormId}_datafield_67583_1_1"
  def techSkillThreeTitleId                      = s"${vacancyFormId}_label_67656_1"
  def techSkillThreeScoreId                      = s"select2-${vacancyFormId}_datafield_67631_1_1-container"
  def techSkillThreeCommentsId                   = s"${vacancyFormId}_datafield_67589_1_1"
  def techSkillFourTitleId                       = s"${vacancyFormId}_label_67659_1"
  def techSkillFourScoreId                       = s"select2-${vacancyFormId}_datafield_67634_1_1-container"
  def techSkillFourCommentsId                    = s"${vacancyFormId}_datafield_67595_1_1"
  def techSkillFiveTitleId                       = s"${vacancyFormId}_label_67662_1"
  def techSkillFiveScoreId                       = s"select2-${vacancyFormId}_datafield_67637_1_1-container"
  def techSkillFiveCommentsId                    = s"${vacancyFormId}_datafield_67601_1_1"
  def techSkillSixTitleId                        = s"${vacancyFormId}_label_67665_1"
  def techSkillSixScoreId                        = s"select2-${vacancyFormId}_datafield_67640_1_1-container"
  def techSkillSixCommentsId                     = s"${vacancyFormId}_datafield_67607_1_1"
  def techSkillSevenTitleId                      = s"${vacancyFormId}_label_67668_1"
  def techSkillSevenScoreId                      = s"select2-${vacancyFormId}_datafield_67643_1_1-container"
  def techSkillSevenCommentsId                   = s"${vacancyFormId}_datafield_67613_1_1"
  def techSkillEightTitleId                      = s"${vacancyFormId}_label_67671_1"
  def techSkillEightScoreId                      = s"select2-${vacancyFormId}_datafield_67646_1_1-container"
  def techSkillEightCommentsId                   = s"${vacancyFormId}_datafield_67619_1_1"
  def techSkillTotalScoreId                      = s"${vacancyFormId}_field_67934_1"
  def strengthAssessmentHeaderId                 = s"${vacancyFormId}_label_46041_1"
  def strengthsHeaderId                          = s"${vacancyFormId}_label_46041_1"
  def strengthScoringGuideId                     = s"${vacancyFormId}_label_46472_1"
  def howManyStrengthsAssessedId                 = s"${vacancyFormId}_label_117705_1"
  def strengthOneTitleId                         = s"${vacancyFormId}_label_117665_1"
  def strengthOneScoreId                         = s"select2-${vacancyFormId}_datafield_45577_1_1-container"
  def strengthOneCommentsId                      = s"${vacancyFormId}_datafield_45529_1_1"
  def strengthTwoTitleId                         = s"${vacancyFormId}_label_117668_1"
  def strengthTwoScoreId                         = s"select2-${vacancyFormId}_datafield_45580_1_1-container"
  def strengthTwoCommentsId                      = s"${vacancyFormId}_datafield_45535_1_1"
  def strengthThreeTitleId                       = s"${vacancyFormId}_label_117671_1"
  def strengthThreeScoreId                       = s"select2-${vacancyFormId}_datafield_45583_1_1-container"
  def strengthThreeCommentsId                    = s"${vacancyFormId}_datafield_45541_1_1"
  def strengthFourTitleId                        = s"${vacancyFormId}_label_117674_1"
  def strengthFourScoreId                        = s"select2-${vacancyFormId}_datafield_45586_1_1-container"
  def strengthFourCommentsId                     = s"${vacancyFormId}_datafield_45547_1_1"
  def strengthFiveTitleId                        = s"${vacancyFormId}_label_117677_1"
  def strengthFiveScoreId                        = s"select2-${vacancyFormId}_datafield_45589_1_1-container"
  def strengthFiveCommentsId                     = s"${vacancyFormId}_datafield_45553_1_1"
  def strengthSixTitleId                         = s"${vacancyFormId}_label_117680_1"
  def strengthSixScoreId                         = s"select2-${vacancyFormId}_datafield_45592_1_1-container"
  def strengthSixCommentsId                      = s"${vacancyFormId}_datafield_45559_1_1"
  def strengthSevenTitleId                       = s"${vacancyFormId}_label_117683_1"
  def strengthSevenScoreId                       = s"select2-${vacancyFormId}_datafield_45595_1_1-container"
  def strengthSevenCommentsId                    = s"${vacancyFormId}_datafield_45565_1_1"
  def strengthEightTitleId                       = s"${vacancyFormId}_label_117686_1"
  def strengthEightScoreId                       = s"select2-${vacancyFormId}_datafield_45598_1_1-container"
  def strengthEightCommentsId                    = s"${vacancyFormId}_datafield_45571_1_1"
  def strengthTotalScoreId                       = s"${vacancyFormId}_field_71686_1"
  def assessmentHeaderId                         = s"${vacancyFormId}_label_45839_1"
  def assessmentInfoId                           = s"${vacancyFormId}_label_116152_1"
  def assessmentsHowManyId                       = s"select2-${vacancyFormId}_datafield_70061_1_1-container"
  def assessmentOneNameId                        = s"${vacancyFormId}_datafield_45848_1_1"
  def assessmentOneScoreId                       = s"select2-${vacancyFormId}_datafield_46161_1_1-container"
  def assessmentOneCommentsId                    = s"${vacancyFormId}_datafield_45879_1_1"
  def assessmentTwoNameId                        = s"${vacancyFormId}_datafield_45918_1_1"
  def assessmentTwoScoreId                       = s"select2-${vacancyFormId}_datafield_46165_1_1-container"
  def assessmentTwoCommentsId                    = s"${vacancyFormId}_datafield_45886_1_1"
  def assessmentThreeNameId                      = s"${vacancyFormId}_datafield_45855_1_1"
  def assessmentThreeScoreId                     = s"select2-${vacancyFormId}_datafield_46169_1_1-container"
  def assessmentThreeCommentsId                  = s"${vacancyFormId}_datafield_45893_1_1"
  def assessmentFourNameId                       = s"${vacancyFormId}_datafield_45861_1_1"
  def assessmentFourScoreId                      = s"select2-${vacancyFormId}_datafield_45962_1_1-container"
  def assessmentFourCommentsId                   = s"${vacancyFormId}_datafield_45900_1_1"
  def assessmentFiveNameId                       = s"${vacancyFormId}_datafield_45867_1_1"
  def assessmentFiveScoreId                      = s"select2-${vacancyFormId}_datafield_46173_1_1-container"
  def assessmentFiveCommentsId                   = s"${vacancyFormId}_datafield_45906_1_1"
  def assessmentSixNameId                        = s"${vacancyFormId}_datafield_45873_1_1"
  def assessmentSixScoreId                       = s"select2-${vacancyFormId}_datafield_46176_1_1-container"
  def assessmentSixCommentsId                    = s"${vacancyFormId}_datafield_45912_1_1"
  def experienceTitleId                          = s"${vacancyFormId}_label_108163_1"
  def experienceScoreId                          = s"select2-${vacancyFormId}_datafield_108315_1_1-container"
  def experienceDescriptionId                    = s"${vacancyFormId}_datafield_108156_1_1"
  def overallScoreTitleId                        = s"${vacancyFormId}_label_23487_1"
  def overallScoreId                             = s"${vacancyFormId}_field_24019_1"
  def overallOverrideScoreId                     = s"${vacancyFormId}_datafield_116074_1_1"
  def outcomeTitleId                             = s"${vacancyFormId}_label_23489_1"
  def outcomeId                                  = s"select2-${vacancyFormId}_datafield_38894_1_1-container"
  def outcomeCommentsId                          = s"${vacancyFormId}_datafield_24276_1_1"
  def uploadIDTitleId                            = s"${vacancyFormId}_label_56054_1"
  def uploadIDId                                 = s"${vacancyFormId}_datafield_56016_1_1"
  def declarationStatementId                     = s"${vacancyFormId}_label_23491_1"

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
    moveVacancyOnViaTopBar(completeI1EvaluationBarId, interviewOneEvaluationTabPath)
    availableBarItems(List(completeI1EvaluationBarId, noShowI1BarId, withdrawAtInterviewBarId))
    waitForVisibilityOfElementById(interviewOneEvaluationHeaderId).getText should endWith("Interview 1 Evaluation")
  }

  private def enterBehaviourOneOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    waitForVisibilityOfElementById(behaviourAssessmentHeaderId).getText shouldEqual "Behaviour assessment"
    waitForVisibilityOfElementById(behaviourScoringGuideId).getText          should include(interviewOneDetails.scoringGuide)
    enterOutcome(
      behaviourOneTitleId,
      vXListOfChosenBehaviours.head,
      behaviourOneScoreId,
      interviewOneDetails.behaviourOne.score,
      behaviourOneCommentsId,
      interviewOneDetails.behaviourOne.comment
    )
    vXI1BehavioursTotalScore.clear()
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourOne.score
  }

  private def enterBehaviourTwoOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      behaviourTwoTitleId,
      vXListOfChosenBehaviours(1),
      behaviourTwoScoreId,
      interviewOneDetails.behaviourTwo.score,
      behaviourTwoCommentsId,
      interviewOneDetails.behaviourTwo.comment
    )
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourTwo.score
  }

  private def enterBehaviourThreeOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      behaviourThreeTitleId,
      vXListOfChosenBehaviours(2),
      behaviourThreeScoreId,
      interviewOneDetails.behaviourThree.score,
      behaviourThreeCommentsId,
      interviewOneDetails.behaviourThree.comment
    )
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourThree.score
  }

  private def enterBehaviourFourOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    scrollToElement(By.id(behaviourFourTitleId))
    enterOutcome(
      behaviourFourTitleId,
      vXListOfChosenBehaviours(3),
      behaviourFourScoreId,
      interviewOneDetails.behaviourFour.score,
      behaviourFourCommentsId,
      interviewOneDetails.behaviourFour.comment
    )
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourFour.score
  }

  private def enterBehaviourFiveOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      behaviourFiveTitleId,
      vXListOfChosenBehaviours(4),
      behaviourFiveScoreId,
      interviewOneDetails.behaviourFive.score,
      behaviourFiveCommentsId,
      interviewOneDetails.behaviourFive.comment
    )
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourFive.score
  }

  private def enterBehaviourSixOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    scrollToElement(By.id(behaviourSixTitleId))
    enterOutcome(
      behaviourSixTitleId,
      vXListOfChosenBehaviours(5),
      behaviourSixScoreId,
      interviewOneDetails.behaviourSix.score,
      behaviourSixCommentsId,
      interviewOneDetails.behaviourSix.comment
    )
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourSix.score
  }

  private def enterBehaviourSevenOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      behaviourSevenTitleId,
      vXListOfChosenBehaviours(6),
      behaviourSevenScoreId,
      interviewOneDetails.behaviourSeven.score,
      behaviourSevenCommentsId,
      interviewOneDetails.behaviourSeven.comment
    )
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourSeven.score
  }

  private def enterBehaviourEightOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      behaviourEightTitleId,
      vXListOfChosenBehaviours(7),
      behaviourEightScoreId,
      interviewOneDetails.behaviourEight.score,
      behaviourEightCommentsId,
      interviewOneDetails.behaviourEight.comment
    )
    vXI1BehavioursTotalScore += interviewOneDetails.behaviourEight.score
  }

  private def totalScore(runningScore: ListBuffer[Int]): Int = {
    var score = 0
    runningScore.foreach(score += _)
    score
  }

  private val behaviourOutcome: Seq[InterviewOneDetails => Unit] = Seq(
    enterBehaviourOneOutcome,
    enterBehaviourTwoOutcome,
    enterBehaviourThreeOutcome,
    enterBehaviourFourOutcome,
    enterBehaviourFiveOutcome,
    enterBehaviourSixOutcome,
    enterBehaviourSevenOutcome,
    enterBehaviourEightOutcome
  )

  private def behavioursOutcome(interviewOneDetails: InterviewOneDetails): Unit =
    if (vXBehavioursRequired) {
      behaviourOutcome.take(vXHowManyBehaviours).foreach { f =>
        f(interviewOneDetails)
      }
      waitForVisibilityOfElementById(
        behaviourTotalScoreId
      ).getText shouldEqual s"Behaviour total score\n  ${totalScore(vXI1BehavioursTotalScore)}"
    }

  private def enterTechSkillOneOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    scrollToElement(By.id(techSkillsHeaderId))
    waitForVisibilityOfElementById(techSkillsHeaderId).getText  shouldEqual "Technical Skill assessment"
    waitForVisibilityOfElementById(techSkillsScoringGuideId).getText should include(interviewOneDetails.scoringGuide)
    enterOutcome(
      techSkillOneTitleId,
      vXListOfTechSkills.head,
      techSkillOneScoreId,
      interviewOneDetails.techSkillOne.score,
      techSkillOneCommentsId,
      interviewOneDetails.techSkillOne.comment
    )
    vXI1TechSkillsTotalScore.clear()
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillOne.score
  }

  private def enterTechSkillTwoOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      techSkillTwoTitleId,
      vXListOfTechSkills(1),
      techSkillTwoScoreId,
      interviewOneDetails.techSkillTwo.score,
      techSkillTwoCommentsId,
      interviewOneDetails.techSkillTwo.comment
    )
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillTwo.score
  }

  private def enterTechSkillThreeOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      techSkillThreeTitleId,
      vXListOfTechSkills(2),
      techSkillThreeScoreId,
      interviewOneDetails.techSkillThree.score,
      techSkillThreeCommentsId,
      interviewOneDetails.techSkillThree.comment
    )
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillThree.score
  }

  private def enterTechSkillFourOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      techSkillFourTitleId,
      vXListOfTechSkills(3),
      techSkillFourScoreId,
      interviewOneDetails.techSkillFour.score,
      techSkillFourCommentsId,
      interviewOneDetails.techSkillFour.comment
    )
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillFour.score
  }

  private def enterTechSkillFiveOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      techSkillFiveTitleId,
      vXListOfTechSkills(4),
      techSkillFiveScoreId,
      interviewOneDetails.techSkillFive.score,
      techSkillFiveCommentsId,
      interviewOneDetails.techSkillFive.comment
    )
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillFive.score
  }

  private def enterTechSkillSixOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      techSkillSixTitleId,
      vXListOfTechSkills(5),
      techSkillSixScoreId,
      interviewOneDetails.techSkillSix.score,
      techSkillSixCommentsId,
      interviewOneDetails.techSkillSix.comment
    )
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillSix.score
  }

  private def enterTechSkillSevenOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      techSkillSevenTitleId,
      vXListOfTechSkills(6),
      techSkillSevenScoreId,
      interviewOneDetails.techSkillSeven.score,
      techSkillSevenCommentsId,
      interviewOneDetails.techSkillSeven.comment
    )
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillSeven.score
  }

  private def enterTechSkillEightOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      techSkillEightTitleId,
      vXListOfTechSkills(7),
      techSkillEightScoreId,
      interviewOneDetails.techSkillEight.score,
      techSkillEightCommentsId,
      interviewOneDetails.techSkillEight.comment
    )
    vXI1TechSkillsTotalScore += interviewOneDetails.techSkillEight.score
  }

  private val skillOutcome: Seq[InterviewOneDetails => Unit] = Seq(
    enterTechSkillOneOutcome,
    enterTechSkillTwoOutcome,
    enterTechSkillThreeOutcome,
    enterTechSkillFourOutcome,
    enterTechSkillFiveOutcome,
    enterTechSkillSixOutcome,
    enterTechSkillSevenOutcome,
    enterTechSkillEightOutcome
  )

  private def techSkillOutcome(interviewOneDetails: InterviewOneDetails): Unit =
    if (vXTechSkillsRequired) {
      skillOutcome.take(vXHowManySkills).foreach { f =>
        f(interviewOneDetails)
      }
      waitForVisibilityOfElementById(
        techSkillTotalScoreId
      ).getText shouldEqual s"Technical skill overall score\n  ${totalScore(vXI1TechSkillsTotalScore)}"
    }

  private def enterStrengthOneOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    scrollToElement(By.id(strengthsHeaderId))
    waitForVisibilityOfElementById(strengthsHeaderId).getText shouldEqual "Strength assessment"
    waitForVisibilityOfElementById(strengthScoringGuideId).getText should include(
      interviewOneDetails.strengthScoringGuide
    )
    enterOutcome(
      strengthOneTitleId,
      s"Strength 1  \n${vXListOfStrengths.head}",
      strengthOneScoreId,
      interviewOneDetails.strengthOne.score,
      strengthOneCommentsId,
      interviewOneDetails.strengthOne.comment
    )
    vXI1StrengthsTotalScore.clear()
    vXI1StrengthsTotalScore += interviewOneDetails.strengthOne.score
  }

  private def enterStrengthTwoOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      strengthTwoTitleId,
      s"Strength 2  \n${vXListOfStrengths(1)}",
      strengthTwoScoreId,
      interviewOneDetails.strengthTwo.score,
      strengthTwoCommentsId,
      interviewOneDetails.strengthTwo.comment
    )
    vXI1StrengthsTotalScore += interviewOneDetails.strengthTwo.score
  }

  private def enterStrengthThreeOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      strengthThreeTitleId,
      s"Strength 3  \n${vXListOfStrengths(2)}",
      strengthThreeScoreId,
      interviewOneDetails.strengthThree.score,
      strengthThreeCommentsId,
      interviewOneDetails.strengthThree.comment
    )
    vXI1StrengthsTotalScore += interviewOneDetails.strengthThree.score
  }

  private def enterStrengthFourOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      strengthFourTitleId,
      s"Strength 4  \n${vXListOfStrengths(3)}",
      strengthFourScoreId,
      interviewOneDetails.strengthFour.score,
      strengthFourCommentsId,
      interviewOneDetails.strengthFour.comment
    )
    vXI1StrengthsTotalScore += interviewOneDetails.strengthFour.score
  }

  private def enterStrengthFiveOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      strengthFiveTitleId,
      s"Strength 5  \n${vXListOfStrengths(4)}",
      strengthFiveScoreId,
      interviewOneDetails.strengthFive.score,
      strengthFiveCommentsId,
      interviewOneDetails.strengthFive.comment
    )
    vXI1StrengthsTotalScore += interviewOneDetails.strengthFive.score
  }

  private def enterStrengthSixOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      strengthSixTitleId,
      s"Strength 6  \n${vXListOfStrengths(5)}",
      strengthSixScoreId,
      interviewOneDetails.strengthSix.score,
      strengthSixCommentsId,
      interviewOneDetails.strengthSix.comment
    )
    vXI1StrengthsTotalScore += interviewOneDetails.strengthSix.score
  }

  private def enterStrengthSevenOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      strengthSevenTitleId,
      s"Strength 7  \n${vXListOfStrengths(6)}",
      strengthSevenScoreId,
      interviewOneDetails.strengthSeven.score,
      strengthSevenCommentsId,
      interviewOneDetails.strengthSeven.comment
    )
    vXI1StrengthsTotalScore += interviewOneDetails.strengthSeven.score
  }

  private def enterStrengthEightOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      strengthEightTitleId,
      s"Strength 8  \n${vXListOfStrengths(7)}",
      strengthEightScoreId,
      interviewOneDetails.strengthEight.score,
      strengthEightCommentsId,
      interviewOneDetails.strengthEight.comment
    )
    vXI1StrengthsTotalScore += interviewOneDetails.strengthEight.score
  }

  private val strengths: Seq[InterviewOneDetails => Unit] = Seq(
    enterStrengthOneOutcome,
    enterStrengthTwoOutcome,
    enterStrengthThreeOutcome,
    enterStrengthFourOutcome,
    enterStrengthFiveOutcome,
    enterStrengthSixOutcome,
    enterStrengthSevenOutcome,
    enterStrengthEightOutcome
  )

  private def strengthsOutcome(interviewOneDetails: InterviewOneDetails): Unit =
    if (vXStrengthsRequired) {
      strengths.take(vXHowManyStrengths).foreach { f =>
        f(interviewOneDetails)
      }
      waitForVisibilityOfElementById(
        strengthTotalScoreId
      ).getText shouldEqual s"Strengths total score\n  ${totalScore(vXI1StrengthsTotalScore)}"
    }

  private def howManyAssessments(interviewOneDetails: InterviewOneDetails): Unit = {
    waitForVisibilityOfElementById(assessmentsHowManyId).click()
    action().moveToElement(waitForDropdownOption(interviewOneDetails.additionalAssessments)).perform()
    waitForDropdownOption(interviewOneDetails.additionalAssessments).click()
  }

  private def enterAssessmentOneOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    waitForVisibilityOfElementById(assessmentHeaderId).getText shouldEqual "Additional assessments"
    waitForVisibilityOfElementById(
      assessmentInfoId
    ).getText                                                       should endWith("Additional assessment names, scores and comments will be visible to the applicant")
    enterAssessmentOutcome(
      assessmentOneNameId,
      interviewOneDetails.assessmentOne.name,
      assessmentOneScoreId,
      interviewOneDetails.assessmentOne.score,
      assessmentOneCommentsId,
      interviewOneDetails.assessmentOne.comment
    )
    vXI1AssessmentsTotalScore.clear()
    vXI1AssessmentsTotalScore += interviewOneDetails.assessmentOne.score
  }

  private def enterAssessmentTwoOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterAssessmentOutcome(
      assessmentTwoNameId,
      interviewOneDetails.assessmentTwo.name,
      assessmentTwoScoreId,
      interviewOneDetails.assessmentTwo.score,
      assessmentTwoCommentsId,
      interviewOneDetails.assessmentTwo.comment
    )
    vXI1AssessmentsTotalScore += interviewOneDetails.assessmentTwo.score
  }

  private def enterAssessmentThreeOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterAssessmentOutcome(
      assessmentThreeNameId,
      interviewOneDetails.assessmentThree.name,
      assessmentThreeScoreId,
      interviewOneDetails.assessmentThree.score,
      assessmentThreeCommentsId,
      interviewOneDetails.assessmentThree.comment
    )
    vXI1AssessmentsTotalScore += interviewOneDetails.assessmentThree.score
  }

  private def enterAssessmentFourOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFourNameId,
      interviewOneDetails.assessmentFour.name,
      assessmentFourScoreId,
      interviewOneDetails.assessmentFour.score,
      assessmentFourCommentsId,
      interviewOneDetails.assessmentFour.comment
    )
    vXI1AssessmentsTotalScore += interviewOneDetails.assessmentFour.score
  }

  private def enterAssessmentFiveOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFiveNameId,
      interviewOneDetails.assessmentFive.name,
      assessmentFiveScoreId,
      interviewOneDetails.assessmentFive.score,
      assessmentFiveCommentsId,
      interviewOneDetails.assessmentFive.comment
    )
    vXI1AssessmentsTotalScore += interviewOneDetails.assessmentFive.score
  }

  private def enterAssessmentSixOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterAssessmentOutcome(
      assessmentSixNameId,
      interviewOneDetails.assessmentSix.name,
      assessmentSixScoreId,
      interviewOneDetails.assessmentSix.score,
      assessmentSixCommentsId,
      interviewOneDetails.assessmentSix.comment
    )
    vXI1AssessmentsTotalScore += interviewOneDetails.assessmentSix.score
  }

  private val assessments: Seq[InterviewOneDetails => Unit] = Seq(
    enterAssessmentOneOutcome,
    enterAssessmentTwoOutcome,
    enterAssessmentThreeOutcome,
    enterAssessmentFourOutcome,
    enterAssessmentFiveOutcome,
    enterAssessmentSixOutcome
  )

  private def assessmentsOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    howManyAssessments(interviewOneDetails)
    assessments.take(interviewOneDetails.additionalAssessments.toInt).foreach { f =>
      f(interviewOneDetails)
    }
    totalScore(vXI1AssessmentsTotalScore)
  }

  private def enterExperienceOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    enterOutcome(
      experienceTitleId,
      "Experience",
      experienceScoreId,
      interviewOneDetails.experience.score,
      experienceDescriptionId,
      interviewOneDetails.experience.comment
    )
    vXI1ExperienceScore = interviewOneDetails.experience.score
  }

  private def checkOverallScore(interviewOneDetails: InterviewOneDetails): Unit = {
    waitForVisibilityOfElementById(overallScoreTitleId).getText shouldEqual "Overall Score"
    if (interviewOneDetails.overrideScore) {
      enterValue(overallOverrideScoreId, interviewOneDetails.overallOverrideScore.toString)
    }
    val overallScore = totalScore(vXI1BehavioursTotalScore) + totalScore(vXI1TechSkillsTotalScore) + totalScore(
      vXI1StrengthsTotalScore
    ) + totalScore(vXI1AssessmentsTotalScore) + vXI1ExperienceScore
    waitForVisibilityOfElementById(overallScoreId).getText shouldEqual s"Overall score\n  $overallScore"
  }

  private def enterOutcome(interviewOneDetails: InterviewOneDetails): Unit = {
    waitForVisibilityOfElementById(outcomeTitleId).getText shouldEqual "Outcome"
    waitForVisibilityOfElementById(outcomeId).click()
    action().moveToElement(waitForDropdownOption(interviewOneDetails.finalOutcome)).perform()
    waitForDropdownOption(interviewOneDetails.finalOutcome).click()
    enterValue(outcomeCommentsId, interviewOneDetails.finalOutcomeComments)
  }

  private def uploadDocuments(interviewOneDetails: InterviewOneDetails): Unit = {
    waitForVisibilityOfElementById(uploadIDTitleId).getText        shouldEqual "Candidate identity documents"
    attachDocuments(uploadIDId, interviewOneDetails.uploadDocs)
    waitForVisibilityOfElementById(declarationStatementId).getText shouldEqual interviewOneDetails.declarationStatement
  }

  private val evaluation: Seq[InterviewOneDetails => Unit] = Seq(
    behavioursOutcome,
    techSkillOutcome,
    strengthsOutcome,
    assessmentsOutcome,
    enterExperienceOutcome,
    checkOverallScore,
    enterOutcome,
    uploadDocuments
  )

  def interviewOneEvaluationFlow(applicationDetails: ApplicationDetails): Unit = {
    moveInterviewScheduleForm()
    evaluation.foreach { f =>
      f(applicationDetails.interviewOneDetails)
    }
    clickOn(submitForm)
    interviewEvaluation()
    if (applicationDetails.interviewOneDetails.finalOutcome == "Progress") {
      applicationBeingReviewedAfterInterviewState()
    }
  }
}
