package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXBehavioursRequired, vXHowManyBehaviours, vXHowManySkills, vXHowManyStrengths, vXListOfChosenBehaviours, vXListOfStrengths, vXListOfTechSkills, vXStrengthsRequired, vXTechSkillsRequired}
import uk.gov.co.test.ui.data.vx.{ApplicationDetails, AssessmentOutcome, Outcome}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.successfulAtInterviewState
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeI4EvaluationBarId, interviewEvaluation, noShowI4BarId, withdrawAtInterviewBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

import scala.collection.mutable.ListBuffer

case class InterviewFourDetails(
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

object InterviewFourEvaluationTab extends VacancyBasePage {

  private lazy val interviewFourEvaluationTabPath =
    ".//span[@class='main-label' and text() = 'Interview 4 Evaluation']"
  var vXI4BehavioursTotalScore: ListBuffer[Int]   = ListBuffer()
  var vXI4TechSkillsTotalScore: ListBuffer[Int]   = ListBuffer()
  var vXI4StrengthsTotalScore: ListBuffer[Int]    = ListBuffer()
  var vXI4AssessmentsTotalScore: ListBuffer[Int]  = ListBuffer()
  var vXI4ExperienceScore: Int                    = 93
  def interviewFourEvaluationHeaderId             = s"${vacancyFormId}_label_23551_1"
  def behaviourAssessmentHeaderId                 = s"${vacancyFormId}_label_23555_1"
  def behaviourScoringGuideId                     = s"${vacancyFormId}_label_23553_1"
  def behaviourOneTitleId                         = s"${vacancyFormId}_label_23557_1"
  def behaviourOneScoreId                         = s"select2-${vacancyFormId}_datafield_24749_1_1-container"
  def behaviourOneCommentsId                      = s"${vacancyFormId}_datafield_24743_1_1"
  def behaviourTwoTitleId                         = s"${vacancyFormId}_label_23559_1"
  def behaviourTwoScoreId                         = s"select2-${vacancyFormId}_datafield_24760_1_1-container"
  def behaviourTwoCommentsId                      = s"${vacancyFormId}_datafield_24754_1_1"
  def behaviourThreeTitleId                       = s"${vacancyFormId}_label_23561_1"
  def behaviourThreeScoreId                       = s"select2-${vacancyFormId}_datafield_24771_1_1-container"
  def behaviourThreeCommentsId                    = s"${vacancyFormId}_datafield_24765_1_1"
  def behaviourFourTitleId                        = s"${vacancyFormId}_label_23563_1"
  def behaviourFourScoreId                        = s"select2-${vacancyFormId}_datafield_24782_1_1-container"
  def behaviourFourCommentsId                     = s"${vacancyFormId}_datafield_24776_1_1"
  def behaviourFiveTitleId                        = s"${vacancyFormId}_label_23565_1"
  def behaviourFiveScoreId                        = s"select2-${vacancyFormId}_datafield_24793_1_1-container"
  def behaviourFiveCommentsId                     = s"${vacancyFormId}_datafield_24787_1_1"
  def behaviourSixTitleId                         = s"${vacancyFormId}_label_23567_1"
  def behaviourSixScoreId                         = s"select2-${vacancyFormId}_datafield_24804_1_1-container"
  def behaviourSixCommentsId                      = s"${vacancyFormId}_datafield_24798_1_1"
  def behaviourSevenTitleId                       = s"${vacancyFormId}_label_23569_1"
  def behaviourSevenScoreId                       = s"select2-${vacancyFormId}_datafield_24815_1_1-container"
  def behaviourSevenCommentsId                    = s"${vacancyFormId}_datafield_24809_1_1"
  def behaviourEightTitleId                       = s"${vacancyFormId}_label_23571_1"
  def behaviourEightScoreId                       = s"select2-${vacancyFormId}_datafield_24826_1_1-container"
  def behaviourEightCommentsId                    = s"${vacancyFormId}_datafield_24820_1_1"
  def behaviourTotalScoreId                       = s"${vacancyFormId}_field_27320_1"
  def techSkillsHeaderId                          = s"${vacancyFormId}_label_69224_1"
  def techSkillsScoringGuideId                    = s"${vacancyFormId}_label_201238_1"
  def techSkillOneTitleId                         = s"${vacancyFormId}_label_68842_1"
  def techSkillOneScoreId                         = s"select2-${vacancyFormId}_datafield_68811_1_1-container"
  def techSkillOneCommentsId                      = s"${vacancyFormId}_datafield_68836_1_1"
  def techSkillTwoTitleId                         = s"${vacancyFormId}_label_68845_1"
  def techSkillTwoScoreId                         = s"select2-${vacancyFormId}_datafield_68814_1_1-container"
  def techSkillTwoCommentsId                      = s"${vacancyFormId}_datafield_68769_1_1"
  def techSkillThreeTitleId                       = s"${vacancyFormId}_label_68848_1"
  def techSkillThreeScoreId                       = s"select2-${vacancyFormId}_datafield_68817_1_1-container"
  def techSkillThreeCommentsId                    = s"${vacancyFormId}_datafield_68775_1_1"
  def techSkillFourTitleId                        = s"${vacancyFormId}_label_68851_1"
  def techSkillFourScoreId                        = s"select2-${vacancyFormId}_datafield_68820_1_1-container"
  def techSkillFourCommentsId                     = s"${vacancyFormId}_datafield_68781_1_1"
  def techSkillFiveTitleId                        = s"${vacancyFormId}_label_68854_1"
  def techSkillFiveScoreId                        = s"select2-${vacancyFormId}_datafield_68823_1_1-container"
  def techSkillFiveCommentsId                     = s"${vacancyFormId}_datafield_68787_1_1"
  def techSkillSixTitleId                         = s"${vacancyFormId}_label_68857_1"
  def techSkillSixScoreId                         = s"select2-${vacancyFormId}_datafield_68826_1_1-container"
  def techSkillSixCommentsId                      = s"${vacancyFormId}_datafield_68793_1_1"
  def techSkillSevenTitleId                       = s"${vacancyFormId}_label_68860_1"
  def techSkillSevenScoreId                       = s"select2-${vacancyFormId}_datafield_68829_1_1-container"
  def techSkillSevenCommentsId                    = s"${vacancyFormId}_datafield_68799_1_1"
  def techSkillEightTitleId                       = s"${vacancyFormId}_label_68863_1"
  def techSkillEightScoreId                       = s"select2-${vacancyFormId}_datafield_68832_1_1-container"
  def techSkillEightCommentsId                    = s"${vacancyFormId}_datafield_68805_1_1"
  def techSkillTotalScoreId                       = s"${vacancyFormId}_field_69230_1"
  def strengthsHeaderId                           = s"${vacancyFormId}_label_46910_1"
  def strengthScoringGuideId                      = s"${vacancyFormId}_label_46913_1"
  def strengthOneTitleId                          = s"${vacancyFormId}_label_118111_1"
  def strengthOneScoreId                          = s"select2-${vacancyFormId}_datafield_46875_1_1-container"
  def strengthOneCommentsId                       = s"${vacancyFormId}_datafield_46827_1_1"
  def strengthTwoTitleId                          = s"${vacancyFormId}_label_118083_1"
  def strengthTwoScoreId                          = s"select2-${vacancyFormId}_datafield_46878_1_1-container"
  def strengthTwoCommentsId                       = s"${vacancyFormId}_datafield_46833_1_1"
  def strengthThreeTitleId                        = s"${vacancyFormId}_label_118087_1"
  def strengthThreeScoreId                        = s"select2-${vacancyFormId}_datafield_46881_1_1-container"
  def strengthThreeCommentsId                     = s"${vacancyFormId}_datafield_46839_1_1"
  def strengthFourTitleId                         = s"${vacancyFormId}_label_118091_1"
  def strengthFourScoreId                         = s"select2-${vacancyFormId}_datafield_46884_1_1-container"
  def strengthFourCommentsId                      = s"${vacancyFormId}_datafield_46845_1_1"
  def strengthFiveTitleId                         = s"${vacancyFormId}_label_118095_1"
  def strengthFiveScoreId                         = s"select2-${vacancyFormId}_datafield_46887_1_1-container"
  def strengthFiveCommentsId                      = s"${vacancyFormId}_datafield_46851_1_1"
  def strengthSixTitleId                          = s"${vacancyFormId}_label_118099_1"
  def strengthSixScoreId                          = s"select2-${vacancyFormId}_datafield_46890_1_1-container"
  def strengthSixCommentsId                       = s"${vacancyFormId}_datafield_46857_1_1"
  def strengthSevenTitleId                        = s"${vacancyFormId}_label_118103_1"
  def strengthSevenScoreId                        = s"select2-${vacancyFormId}_datafield_46893_1_1-container"
  def strengthSevenCommentsId                     = s"${vacancyFormId}_datafield_46863_1_1"
  def strengthEightTitleId                        = s"${vacancyFormId}_label_118107_1"
  def strengthEightScoreId                        = s"select2-${vacancyFormId}_datafield_46896_1_1-container"
  def strengthEightCommentsId                     = s"${vacancyFormId}_datafield_46869_1_1"
  def strengthTotalScoreId                        = s"${vacancyFormId}_field_71737_1"
  def assessmentHeaderId                          = s"${vacancyFormId}_label_48304_1"
  def assessmentInfoId                            = s"${vacancyFormId}_label_116233_1"
  def assessmentsHowManyId                        = s"select2-${vacancyFormId}_datafield_71662_1_1-container"
  def assessmentOneNameId                         = s"${vacancyFormId}_datafield_48200_1_1"
  def assessmentOneScoreId                        = s"select2-${vacancyFormId}_datafield_48218_1_1-container"
  def assessmentOneCommentsId                     = s"${vacancyFormId}_datafield_48179_1_1"
  def assessmentTwoNameId                         = s"${vacancyFormId}_datafield_48206_1_1"
  def assessmentTwoScoreId                        = s"select2-${vacancyFormId}_datafield_48222_1_1-container"
  def assessmentTwoCommentsId                     = s"${vacancyFormId}_datafield_48186_1_1"
  def assessmentThreeNameId                       = s"${vacancyFormId}_datafield_48212_1_1"
  def assessmentThreeScoreId                      = s"select2-${vacancyFormId}_datafield_48226_1_1-container"
  def assessmentThreeCommentsId                   = s"${vacancyFormId}_datafield_48193_1_1"
  def assessmentFourNameId                        = s"${vacancyFormId}_datafield_48230_1_1"
  def assessmentFourScoreId                       = s"select2-${vacancyFormId}_datafield_48236_1_1-container"
  def assessmentFourCommentsId                    = s"${vacancyFormId}_datafield_48239_1_1"
  def assessmentFiveNameId                        = s"${vacancyFormId}_datafield_48245_1_1"
  def assessmentFiveScoreId                       = s"select2-${vacancyFormId}_datafield_48251_1_1-container"
  def assessmentFiveCommentsId                    = s"${vacancyFormId}_datafield_48254_1_1"
  def assessmentSixNameId                         = s"${vacancyFormId}_datafield_48260_1_1"
  def assessmentSixScoreId                        = s"select2-${vacancyFormId}_datafield_48266_1_1-container"
  def assessmentSixCommentsId                     = s"${vacancyFormId}_datafield_48269_1_1"
  def experienceTitleId                           = s"${vacancyFormId}_label_108220_1"
  def experienceScoreId                           = s"select2-${vacancyFormId}_datafield_108330_1_1-container"
  def experienceDescriptionId                     = s"${vacancyFormId}_datafield_108230_1_1"
  def overallScoreTitleId                         = s"${vacancyFormId}_label_23575_1"
  def overallScoreTitlePath                          = s".//*[@id='${vacancyFormId}_label_23575_1']/span/strong"
  def overallScoreId                              = s"${vacancyFormId}_datafield_27402_1_1"
  def overallOverrideScoreId                      = s"${vacancyFormId}_datafield_116095_1_1"
  def outcomeTitleId                              = s"${vacancyFormId}_label_23577_1"
  def outcomeId                                   = s"select2-${vacancyFormId}_datafield_38865_1_1-container"
  def outcomeCommentsId                           = s"${vacancyFormId}_datafield_24886_1_1"
  def uploadIDTitleId                             = s"${vacancyFormId}_label_56063_1"
  def uploadIDId                                  = s"${vacancyFormId}_datafield_56047_1_1"
  def declarationStatementId                      = s"${vacancyFormId}_label_23579_1"

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
    moveVacancyOnViaTopBar(completeI4EvaluationBarId, interviewFourEvaluationTabPath)
    availableBarItems(List(completeI4EvaluationBarId, noShowI4BarId, withdrawAtInterviewBarId))
    waitForVisibilityOfElementById(interviewFourEvaluationHeaderId).getText should endWith("Interview 4 Evaluation")
  }

  private def enterBehaviourOneOutcome(interviewFourDetails: InterviewFourDetails): Unit = { // work through 15623-Macey Bins
    waitForVisibilityOfElementById(
      behaviourAssessmentHeaderId
    ).getText                                                  shouldEqual "Behaviour assessment" //TODO different to I3
    waitForVisibilityOfElementById(behaviourScoringGuideId).getText should include(interviewFourDetails.scoringGuide)
    enterOutcome(
      behaviourOneTitleId,
      vXListOfChosenBehaviours.head,
      behaviourOneScoreId,
      interviewFourDetails.behaviourOne.score,
      behaviourOneCommentsId,
      interviewFourDetails.behaviourOne.comment
    )
    vXI4BehavioursTotalScore.clear()
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourOne.score
  }

  private def enterBehaviourTwoOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      behaviourTwoTitleId,
      vXListOfChosenBehaviours(1),
      behaviourTwoScoreId,
      interviewFourDetails.behaviourTwo.score,
      behaviourTwoCommentsId,
      interviewFourDetails.behaviourTwo.comment
    )
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourTwo.score
  }

  private def enterBehaviourThreeOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      behaviourThreeTitleId,
      vXListOfChosenBehaviours(2),
      behaviourThreeScoreId,
      interviewFourDetails.behaviourThree.score,
      behaviourThreeCommentsId,
      interviewFourDetails.behaviourThree.comment
    )
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourThree.score
  }

  private def enterBehaviourFourOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    scrollToElement(By.id(behaviourFourTitleId))
    enterOutcome(
      behaviourFourTitleId,
      vXListOfChosenBehaviours(3),
      behaviourFourScoreId,
      interviewFourDetails.behaviourFour.score,
      behaviourFourCommentsId,
      interviewFourDetails.behaviourFour.comment
    )
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourFour.score
  }

  private def enterBehaviourFiveOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      behaviourFiveTitleId,
      vXListOfChosenBehaviours(4),
      behaviourFiveScoreId,
      interviewFourDetails.behaviourFive.score,
      behaviourFiveCommentsId,
      interviewFourDetails.behaviourFive.comment
    )
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourFive.score
  }

  private def enterBehaviourSixOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    scrollToElement(By.id(behaviourSixTitleId))
    enterOutcome(
      behaviourSixTitleId,
      vXListOfChosenBehaviours(5),
      behaviourSixScoreId,
      interviewFourDetails.behaviourSix.score,
      behaviourSixCommentsId,
      interviewFourDetails.behaviourSix.comment
    )
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourSix.score
  }

  private def enterBehaviourSevenOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      behaviourSevenTitleId,
      vXListOfChosenBehaviours(6),
      behaviourSevenScoreId,
      interviewFourDetails.behaviourSeven.score,
      behaviourSevenCommentsId,
      interviewFourDetails.behaviourSeven.comment //TODO Not optional as star denotes mandatory?
    )
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourSeven.score
  }

  private def enterBehaviourEightOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      behaviourEightTitleId,
      vXListOfChosenBehaviours(7),
      behaviourEightScoreId,
      interviewFourDetails.behaviourEight.score,
      behaviourEightCommentsId,
      interviewFourDetails.behaviourEight.comment
    )
    vXI4BehavioursTotalScore += interviewFourDetails.behaviourEight.score
  }

  private def totalScore(runningScore: ListBuffer[Int]): Int = {
    var score = 0
    runningScore.foreach(score += _)
    score
  }

  private val behaviourOutcome: Seq[InterviewFourDetails => Unit] = Seq(
    enterBehaviourOneOutcome,
    enterBehaviourTwoOutcome,
    enterBehaviourThreeOutcome,
    enterBehaviourFourOutcome,
    enterBehaviourFiveOutcome,
    enterBehaviourSixOutcome,
    enterBehaviourSevenOutcome,
    enterBehaviourEightOutcome
  )

  private def behavioursOutcome(interviewFourDetails: InterviewFourDetails): Unit =
    if (vXBehavioursRequired) {
      behaviourOutcome.take(vXHowManyBehaviours).foreach { f =>
        f(interviewFourDetails)
      }
      waitForVisibilityOfElementById(
        behaviourTotalScoreId
      ).getText shouldEqual s"Behaviour Total Score\n  ${totalScore(vXI4BehavioursTotalScore)}" //TODO I2 is different, no Pascal Case
    }

  private def enterTechSkillOneOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    scrollToElement(By.id(techSkillsHeaderId))
    waitForVisibilityOfElementById(
      techSkillsHeaderId
    ).getText                                                   shouldEqual "Technical Skill assessment" //TODO I3 different, no Pascal Case
    waitForVisibilityOfElementById(techSkillsScoringGuideId).getText should include(interviewFourDetails.scoringGuide)
    enterOutcome(
      techSkillOneTitleId,
      vXListOfTechSkills.head,
      techSkillOneScoreId,
      interviewFourDetails.techSkillOne.score,
      techSkillOneCommentsId,
      interviewFourDetails.techSkillOne.comment
    )
    vXI4TechSkillsTotalScore.clear()
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillOne.score
  }

  private def enterTechSkillTwoOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      techSkillTwoTitleId,
      vXListOfTechSkills(1),
      techSkillTwoScoreId,
      interviewFourDetails.techSkillTwo.score,
      techSkillTwoCommentsId,
      interviewFourDetails.techSkillTwo.comment
    )
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillTwo.score
  }

  private def enterTechSkillThreeOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      techSkillThreeTitleId,
      vXListOfTechSkills(2),
      techSkillThreeScoreId,
      interviewFourDetails.techSkillThree.score,
      techSkillThreeCommentsId,
      interviewFourDetails.techSkillThree.comment
    )
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillThree.score
  }

  private def enterTechSkillFourOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      techSkillFourTitleId,
      vXListOfTechSkills(3),
      techSkillFourScoreId,
      interviewFourDetails.techSkillFour.score,
      techSkillFourCommentsId,
      interviewFourDetails.techSkillFour.comment
    )
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillFour.score
  }

  private def enterTechSkillFiveOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      techSkillFiveTitleId,
      vXListOfTechSkills(4),
      techSkillFiveScoreId,
      interviewFourDetails.techSkillFive.score,
      techSkillFiveCommentsId,
      interviewFourDetails.techSkillFive.comment
    )
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillFive.score
  }

  private def enterTechSkillSixOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      techSkillSixTitleId,
      vXListOfTechSkills(5),
      techSkillSixScoreId,
      interviewFourDetails.techSkillSix.score,
      techSkillSixCommentsId,
      interviewFourDetails.techSkillSix.comment
    )
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillSix.score
  }

  private def enterTechSkillSevenOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      techSkillSevenTitleId,
      vXListOfTechSkills(6),
      techSkillSevenScoreId,
      interviewFourDetails.techSkillSeven.score,
      techSkillSevenCommentsId,
      interviewFourDetails.techSkillSeven.comment
    )
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillSeven.score
  }

  private def enterTechSkillEightOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      techSkillEightTitleId,
      vXListOfTechSkills(7),
      techSkillEightScoreId,
      interviewFourDetails.techSkillEight.score,
      techSkillEightCommentsId,
      interviewFourDetails.techSkillEight.comment
    )
    vXI4TechSkillsTotalScore += interviewFourDetails.techSkillEight.score
  }

  private val skillOutcome: Seq[InterviewFourDetails => Unit] = Seq(
    enterTechSkillOneOutcome,
    enterTechSkillTwoOutcome,
    enterTechSkillThreeOutcome,
    enterTechSkillFourOutcome,
    enterTechSkillFiveOutcome,
    enterTechSkillSixOutcome,
    enterTechSkillSevenOutcome,
    enterTechSkillEightOutcome
  )

  private def techSkillOutcome(interviewFourDetails: InterviewFourDetails): Unit =
    if (vXTechSkillsRequired) {
      skillOutcome.take(vXHowManySkills).foreach { f =>
        f(interviewFourDetails)
      }
      waitForVisibilityOfElementById(
        techSkillTotalScoreId
      ).getText shouldEqual s"Technical skill overall score\n  ${totalScore(vXI4TechSkillsTotalScore)}" //TODO I3 different wording case
    }

  private def enterStrengthOneOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    scrollToElement(By.id(strengthsHeaderId))
    waitForVisibilityOfElementById(strengthsHeaderId).getText shouldEqual "Strength assessment"
    waitForVisibilityOfElementById(strengthScoringGuideId).getText should include(
      interviewFourDetails.strengthScoringGuide
    )
    enterOutcome(
      strengthOneTitleId,
      s"Strength 1  \n${vXListOfStrengths.head}",
      strengthOneScoreId,
      interviewFourDetails.strengthOne.score,
      strengthOneCommentsId,
      interviewFourDetails.strengthOne.comment
    )
    vXI4StrengthsTotalScore.clear()
    vXI4StrengthsTotalScore += interviewFourDetails.strengthOne.score
  }

  private def enterStrengthTwoOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      strengthTwoTitleId,
      s"Strength 2  \n${vXListOfStrengths(1)}",
      strengthTwoScoreId,
      interviewFourDetails.strengthTwo.score,
      strengthTwoCommentsId,
      interviewFourDetails.strengthTwo.comment
    )
    vXI4StrengthsTotalScore += interviewFourDetails.strengthTwo.score
  }

  private def enterStrengthThreeOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      strengthThreeTitleId,
      s"Strength 3  \n${vXListOfStrengths(2)}",
      strengthThreeScoreId,
      interviewFourDetails.strengthThree.score,
      strengthThreeCommentsId,
      interviewFourDetails.strengthThree.comment
    )
    vXI4StrengthsTotalScore += interviewFourDetails.strengthThree.score
  }

  private def enterStrengthFourOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      strengthFourTitleId,
      s"Strength 4  \n${vXListOfStrengths(3)}",
      strengthFourScoreId,
      interviewFourDetails.strengthFour.score,
      strengthFourCommentsId,
      interviewFourDetails.strengthFour.comment
    )
    vXI4StrengthsTotalScore += interviewFourDetails.strengthFour.score
  }

  private def enterStrengthFiveOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      strengthFiveTitleId,
      s"Strength 5  \n${vXListOfStrengths(4)}",
      strengthFiveScoreId,
      interviewFourDetails.strengthFive.score,
      strengthFiveCommentsId,
      interviewFourDetails.strengthFive.comment
    )
    vXI4StrengthsTotalScore += interviewFourDetails.strengthFive.score
  }

  private def enterStrengthSixOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      strengthSixTitleId,
      s"Strength 6  \n${vXListOfStrengths(5)}",
      strengthSixScoreId,
      interviewFourDetails.strengthSix.score,
      strengthSixCommentsId,
      interviewFourDetails.strengthSix.comment
    )
    vXI4StrengthsTotalScore += interviewFourDetails.strengthSix.score
  }

  private def enterStrengthSevenOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      strengthSevenTitleId,
      s"Strength 7  \n${vXListOfStrengths(6)}",
      strengthSevenScoreId,
      interviewFourDetails.strengthSeven.score,
      strengthSevenCommentsId,
      interviewFourDetails.strengthSeven.comment
    )
    vXI4StrengthsTotalScore += interviewFourDetails.strengthSeven.score
  }

  private def enterStrengthEightOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      strengthEightTitleId,
      s"Strength 8  \n${vXListOfStrengths(7)}",
      strengthEightScoreId,
      interviewFourDetails.strengthEight.score,
      strengthEightCommentsId,
      interviewFourDetails.strengthEight.comment
    )
    vXI4StrengthsTotalScore += interviewFourDetails.strengthEight.score
  }

  private val strengths: Seq[InterviewFourDetails => Unit] = Seq(
    enterStrengthOneOutcome,
    enterStrengthTwoOutcome,
    enterStrengthThreeOutcome,
    enterStrengthFourOutcome,
    enterStrengthFiveOutcome,
    enterStrengthSixOutcome,
    enterStrengthSevenOutcome,
    enterStrengthEightOutcome
  )

  private def strengthsOutcome(interviewFourDetails: InterviewFourDetails): Unit =
    if (vXStrengthsRequired) {
      strengths.take(vXHowManyStrengths).foreach { f =>
        f(interviewFourDetails)
      }
      waitForVisibilityOfElementById(
        strengthTotalScoreId
      ).getText shouldEqual s"Strengths total score\n  ${totalScore(vXI4StrengthsTotalScore)}" //TODO I3 has different casing
    }

  private def howManyAssessments(interviewFourDetails: InterviewFourDetails): Unit = {
    waitForVisibilityOfElementById(assessmentsHowManyId).click()
    action().moveToElement(waitForDropdownOption(interviewFourDetails.additionalAssessments)).perform()
    waitForDropdownOption(interviewFourDetails.additionalAssessments).click()
  }

  private def enterAssessmentOneOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    waitForVisibilityOfElementById(assessmentHeaderId).getText shouldEqual "Additional assessments"
    waitForVisibilityOfElementById(
      assessmentInfoId
    ).getText                                                       should endWith("Additional assessment names, scores and comments will be visible to the applicant")
    enterAssessmentOutcome(
      assessmentOneNameId,
      interviewFourDetails.assessmentOne.name,
      assessmentOneScoreId,
      interviewFourDetails.assessmentOne.score,
      assessmentOneCommentsId,
      interviewFourDetails.assessmentOne.comment
    )
    vXI4AssessmentsTotalScore.clear()
    vXI4AssessmentsTotalScore += interviewFourDetails.assessmentOne.score
  }

  private def enterAssessmentTwoOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterAssessmentOutcome(
      assessmentTwoNameId,
      interviewFourDetails.assessmentTwo.name,
      assessmentTwoScoreId,
      interviewFourDetails.assessmentTwo.score,
      assessmentTwoCommentsId,
      interviewFourDetails.assessmentTwo.comment
    )
    vXI4AssessmentsTotalScore += interviewFourDetails.assessmentTwo.score
  }

  private def enterAssessmentThreeOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterAssessmentOutcome(
      assessmentThreeNameId,
      interviewFourDetails.assessmentThree.name,
      assessmentThreeScoreId,
      interviewFourDetails.assessmentThree.score,
      assessmentThreeCommentsId,
      interviewFourDetails.assessmentThree.comment
    )
    vXI4AssessmentsTotalScore += interviewFourDetails.assessmentThree.score
  }

  private def enterAssessmentFourOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFourNameId,
      interviewFourDetails.assessmentFour.name,
      assessmentFourScoreId,
      interviewFourDetails.assessmentFour.score,
      assessmentFourCommentsId,
      interviewFourDetails.assessmentFour.comment
    )
    vXI4AssessmentsTotalScore += interviewFourDetails.assessmentFour.score
  }

  private def enterAssessmentFiveOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFiveNameId,
      interviewFourDetails.assessmentFive.name,
      assessmentFiveScoreId,
      interviewFourDetails.assessmentFive.score,
      assessmentFiveCommentsId,
      interviewFourDetails.assessmentFive.comment
    )
    vXI4AssessmentsTotalScore += interviewFourDetails.assessmentFive.score
  }

  private def enterAssessmentSixOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterAssessmentOutcome(
      assessmentSixNameId,
      interviewFourDetails.assessmentSix.name,
      assessmentSixScoreId,
      interviewFourDetails.assessmentSix.score,
      assessmentSixCommentsId,
      interviewFourDetails.assessmentSix.comment
    )
    vXI4AssessmentsTotalScore += interviewFourDetails.assessmentSix.score
  }

  private val assessments: Seq[InterviewFourDetails => Unit] = Seq(
    enterAssessmentOneOutcome,
    enterAssessmentTwoOutcome,
    enterAssessmentThreeOutcome,
    enterAssessmentFourOutcome,
    enterAssessmentFiveOutcome,
    enterAssessmentSixOutcome
  )

  private def assessmentsOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    howManyAssessments(interviewFourDetails)
    assessments.take(interviewFourDetails.additionalAssessments.toInt).foreach { f =>
      f(interviewFourDetails)
    }
    totalScore(vXI4AssessmentsTotalScore)
  }

  private def enterExperienceOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    enterOutcome(
      experienceTitleId,
      "Experience assessment", //TODO this is different in I3, "Experience assessment"
      experienceScoreId,
      interviewFourDetails.experience.score,
      experienceDescriptionId,
      interviewFourDetails.experience.comment
    )
    vXI4ExperienceScore = interviewFourDetails.experience.score
  }

  private def checkOverallScore(interviewFourDetails: InterviewFourDetails): Unit = {
    waitForVisibilityOfElementByPath(
      overallScoreTitlePath
    ).getText should endWith("Overall score") //TODO this is different in I3, in Pascal Case and space
    if (interviewFourDetails.overrideScore) {
      enterValue(overallOverrideScoreId, interviewFourDetails.overallOverrideScore.toString)
    }
    val overallScore = totalScore(vXI4BehavioursTotalScore) + totalScore(vXI4TechSkillsTotalScore) + totalScore(
      vXI4StrengthsTotalScore
    ) + totalScore(vXI4AssessmentsTotalScore) + vXI4ExperienceScore
    waitForVisibilityOfElementById(overallScoreId).getAttribute("value") shouldEqual s"$overallScore"
  }

  private def enterOutcome(interviewFourDetails: InterviewFourDetails): Unit = {
    waitForVisibilityOfElementById(outcomeTitleId).getText shouldEqual "Outcome"
    waitForVisibilityOfElementById(outcomeId).click()
    action().moveToElement(waitForDropdownOption(interviewFourDetails.finalOutcome)).perform()
    waitForDropdownOption(interviewFourDetails.finalOutcome).click()
    enterValue(outcomeCommentsId, interviewFourDetails.finalOutcomeComments)
  }

  private def uploadDocuments(interviewFourDetails: InterviewFourDetails): Unit = {
    waitForVisibilityOfElementById(uploadIDTitleId).getText shouldEqual "Candidate identity documents"
    attachDocuments(uploadIDId, interviewFourDetails.uploadDocs)
    waitForVisibilityOfElementById(
      declarationStatementId
    ).getText                                               shouldEqual interviewFourDetails.declarationStatement
  }

  private val evaluation: Seq[InterviewFourDetails => Unit] = Seq(
    behavioursOutcome,
    techSkillOutcome,
    strengthsOutcome,
    assessmentsOutcome,
    enterExperienceOutcome,
    checkOverallScore,
    enterOutcome,
    uploadDocuments
  )

  def interviewFourEvaluationFlow(applicationDetails: ApplicationDetails): Unit = {
    moveInterviewScheduleForm()
    evaluation.foreach { f =>
      f(applicationDetails.interviewFourDetails)
    }
    clickOn(submitForm)
    interviewEvaluation()
    successfulAtInterviewState()
  }
}
