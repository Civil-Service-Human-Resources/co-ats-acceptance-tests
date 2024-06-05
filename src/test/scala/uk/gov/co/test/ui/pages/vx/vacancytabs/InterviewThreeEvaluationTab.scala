package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomFirstName, randomLastName, vXBehavioursRequired, vXHowManyBehaviours, vXHowManySkills, vXHowManyStrengths, vXInterviewThreeOutcome, vXListOfChosenBehaviours, vXListOfStrengths, vXListOfTechSkills, vXStrengthsRequired, vXTechSkillsRequired, vacancyFormId}
import uk.gov.co.test.ui.data.vx.application.{ApplicationDetails, AssessmentOutcome, Outcome}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.applicationStateAfterInterview
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeI3EvaluationBarId, interviewEvaluation, noShowI3BarId, withdrawAtInterviewBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

case class InterviewThreeDetails(
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
  uploadDocs: String,
  declarationStatement: String
)

object InterviewThreeEvaluationTab extends VacancyBasePage {

  private lazy val interviewThreeEvaluationTabPath =
    ".//span[@class='main-label' and text() = 'Interview 3 Evaluation']"
  var vXI3BehavioursTotalScore: ListBuffer[Int]    = ListBuffer()
  var vXI3TechSkillsTotalScore: ListBuffer[Int]    = ListBuffer()
  var vXI3StrengthsTotalScore: ListBuffer[Int]     = ListBuffer()
  var vXI3AssessmentsTotalScore: ListBuffer[Int]   = ListBuffer()
  var vXI3ExperienceScore: Int                     = 93
  def interviewThreeEvaluationHeaderId             = s"${vacancyFormId}_label_23523_1"
  def behaviourAssessmentHeaderId                  = s"${vacancyFormId}_label_23527_1"
  def behaviourScoringGuideId                      = s"${vacancyFormId}_label_23525_1"
  def behaviourOneTitleId                          = s"${vacancyFormId}_label_23529_1"
  def behaviourOneScoreId                          = s"select2-${vacancyFormId}_datafield_24288_1_1-container"
  def behaviourOneCommentsId                       = s"${vacancyFormId}_datafield_24282_1_1"
  def behaviourTwoTitleId                          = s"${vacancyFormId}_label_24291_1"
  def behaviourTwoScoreId                          = s"select2-${vacancyFormId}_datafield_24299_1_1-container"
  def behaviourTwoCommentsId                       = s"${vacancyFormId}_datafield_24293_1_1"
  def behaviourThreeTitleId                        = s"${vacancyFormId}_label_23531_1"
  def behaviourThreeScoreId                        = s"select2-${vacancyFormId}_datafield_24451_1_1-container"
  def behaviourThreeCommentsId                     = s"${vacancyFormId}_datafield_24445_1_1"
  def behaviourFourTitleId                         = s"${vacancyFormId}_label_23533_1"
  def behaviourFourScoreId                         = s"select2-${vacancyFormId}_datafield_24460_1_1-container"
  def behaviourFourCommentsId                      = s"${vacancyFormId}_datafield_24454_1_1"
  def behaviourFiveTitleId                         = s"${vacancyFormId}_label_23535_1"
  def behaviourFiveScoreId                         = s"select2-${vacancyFormId}_datafield_24469_1_1-container"
  def behaviourFiveCommentsId                      = s"${vacancyFormId}_datafield_24463_1_1"
  def behaviourSixTitleId                          = s"${vacancyFormId}_label_23537_1"
  def behaviourSixScoreId                          = s"select2-${vacancyFormId}_datafield_24478_1_1-container"
  def behaviourSixCommentsId                       = s"${vacancyFormId}_datafield_24472_1_1"
  def behaviourSevenTitleId                        = s"${vacancyFormId}_label_23539_1"
  def behaviourSevenScoreId                        = s"select2-${vacancyFormId}_datafield_24487_1_1-container"
  def behaviourSevenCommentsId                     = s"${vacancyFormId}_datafield_24481_1_1"
  def behaviourEightTitleId                        = s"${vacancyFormId}_label_23541_1"
  def behaviourEightScoreId                        = s"select2-${vacancyFormId}_datafield_24496_1_1-container"
  def behaviourEightCommentsId                     = s"${vacancyFormId}_datafield_24490_1_1"
  def behaviourTotalScoreId                        = s"${vacancyFormId}_field_27590_1"
  def techSkillsHeaderId                           = s"${vacancyFormId}_label_69217_1"
  def techSkillsScoringGuideId                     = s"${vacancyFormId}_label_201221_1"
  def techSkillOneTitleId                          = s"${vacancyFormId}_label_68442_1"
  def techSkillOneScoreId                          = s"select2-${vacancyFormId}_datafield_68417_1_1-container"
  def techSkillOneCommentsId                       = s"${vacancyFormId}_datafield_68369_1_1"
  def techSkillTwoTitleId                          = s"${vacancyFormId}_label_68445_1"
  def techSkillTwoScoreId                          = s"select2-${vacancyFormId}_datafield_68420_1_1-container"
  def techSkillTwoCommentsId                       = s"${vacancyFormId}_datafield_68375_1_1"
  def techSkillThreeTitleId                        = s"${vacancyFormId}_label_68448_1"
  def techSkillThreeScoreId                        = s"select2-${vacancyFormId}_datafield_68423_1_1-container"
  def techSkillThreeCommentsId                     = s"${vacancyFormId}_datafield_68381_1_1"
  def techSkillFourTitleId                         = s"${vacancyFormId}_label_68451_1"
  def techSkillFourScoreId                         = s"select2-${vacancyFormId}_datafield_68426_1_1-container"
  def techSkillFourCommentsId                      = s"${vacancyFormId}_datafield_68387_1_1"
  def techSkillFiveTitleId                         = s"${vacancyFormId}_label_68457_1"
  def techSkillFiveScoreId                         = s"select2-${vacancyFormId}_datafield_68429_1_1-container"
  def techSkillFiveCommentsId                      = s"${vacancyFormId}_datafield_68393_1_1"
  def techSkillSixTitleId                          = s"${vacancyFormId}_label_68454_1"
  def techSkillSixScoreId                          = s"select2-${vacancyFormId}_datafield_68432_1_1-container"
  def techSkillSixCommentsId                       = s"${vacancyFormId}_datafield_68399_1_1"
  def techSkillSevenTitleId                        = s"${vacancyFormId}_label_68460_1"
  def techSkillSevenScoreId                        = s"select2-${vacancyFormId}_datafield_68435_1_1-container"
  def techSkillSevenCommentsId                     = s"${vacancyFormId}_datafield_68405_1_1"
  def techSkillEightTitleId                        = s"${vacancyFormId}_label_68463_1"
  def techSkillEightScoreId                        = s"select2-${vacancyFormId}_datafield_68438_1_1-container"
  def techSkillEightCommentsId                     = s"${vacancyFormId}_datafield_68411_1_1"
  def techSkillTotalScoreId                        = s"${vacancyFormId}_field_69188_1"
  def strengthsHeaderId                            = s"${vacancyFormId}_label_46821_1"
  def strengthScoringGuideId                       = s"${vacancyFormId}_label_46818_1"
  def strengthOneTitleId                           = s"${vacancyFormId}_label_117954_1"
  def strengthOneScoreId                           = s"select2-${vacancyFormId}_datafield_46585_1_1-container"
  def strengthOneCommentsId                        = s"${vacancyFormId}_datafield_46537_1_1"
  def strengthTwoTitleId                           = s"${vacancyFormId}_label_117958_1"
  def strengthTwoScoreId                           = s"select2-${vacancyFormId}_datafield_46588_1_1-container"
  def strengthTwoCommentsId                        = s"${vacancyFormId}_datafield_46543_1_1"
  def strengthThreeTitleId                         = s"${vacancyFormId}_label_117962_1"
  def strengthThreeScoreId                         = s"select2-${vacancyFormId}_datafield_46591_1_1-container"
  def strengthThreeCommentsId                      = s"${vacancyFormId}_datafield_46549_1_1"
  def strengthFourTitleId                          = s"${vacancyFormId}_label_117966_1"
  def strengthFourScoreId                          = s"select2-${vacancyFormId}_datafield_46594_1_1-container"
  def strengthFourCommentsId                       = s"${vacancyFormId}_datafield_46555_1_1"
  def strengthFiveTitleId                          = s"${vacancyFormId}_label_117970_1"
  def strengthFiveScoreId                          = s"select2-${vacancyFormId}_datafield_46597_1_1-container"
  def strengthFiveCommentsId                       = s"${vacancyFormId}_datafield_46561_1_1"
  def strengthSixTitleId                           = s"${vacancyFormId}_label_117974_1"
  def strengthSixScoreId                           = s"select2-${vacancyFormId}_datafield_46600_1_1-container"
  def strengthSixCommentsId                        = s"${vacancyFormId}_datafield_46567_1_1"
  def strengthSevenTitleId                         = s"${vacancyFormId}_label_117978_1"
  def strengthSevenScoreId                         = s"select2-${vacancyFormId}_datafield_46603_1_1-container"
  def strengthSevenCommentsId                      = s"${vacancyFormId}_datafield_46573_1_1"
  def strengthEightTitleId                         = s"${vacancyFormId}_label_117982_1"
  def strengthEightScoreId                         = s"select2-${vacancyFormId}_datafield_46606_1_1-container"
  def strengthEightCommentsId                      = s"${vacancyFormId}_datafield_46579_1_1"
  def strengthTotalScoreId                         = s"${vacancyFormId}_field_71720_1"
  def assessmentHeaderId                           = s"${vacancyFormId}_label_47577_1"
  def assessmentInfoId                             = s"${vacancyFormId}_label_116207_1"
  def assessmentsHowManyId                         = s"select2-${vacancyFormId}_datafield_71658_1_1-container"
  def assessmentOneNameId                          = s"${vacancyFormId}_datafield_47621_1_1"
  def assessmentOneScoreId                         = s"select2-${vacancyFormId}_datafield_47643_1_1-container"
  def assessmentOneCommentsId                      = s"${vacancyFormId}_datafield_47607_1_1"
  def assessmentTwoNameId                          = s"${vacancyFormId}_datafield_47627_1_1"
  def assessmentTwoScoreId                         = s"select2-${vacancyFormId}_datafield_47647_1_1-container"
  def assessmentTwoCommentsId                      = s"${vacancyFormId}_datafield_47614_1_1"
  def assessmentThreeNameId                        = s"${vacancyFormId}_datafield_47633_1_1"
  def assessmentThreeScoreId                       = s"select2-${vacancyFormId}_datafield_47639_1_1-container"
  def assessmentThreeCommentsId                    = s"${vacancyFormId}_datafield_47600_1_1"
  def assessmentFourNameId                         = s"${vacancyFormId}_datafield_47651_1_1"
  def assessmentFourScoreId                        = s"select2-${vacancyFormId}_datafield_47657_1_1-container"
  def assessmentFourCommentsId                     = s"${vacancyFormId}_datafield_47660_1_1"
  def assessmentFiveNameId                         = s"${vacancyFormId}_datafield_47666_1_1"
  def assessmentFiveScoreId                        = s"select2-${vacancyFormId}_datafield_47672_1_1-container"
  def assessmentFiveCommentsId                     = s"${vacancyFormId}_datafield_47675_1_1"
  def assessmentSixNameId                          = s"${vacancyFormId}_datafield_47681_1_1"
  def assessmentSixScoreId                         = s"select2-${vacancyFormId}_datafield_47687_1_1-container"
  def assessmentSixCommentsId                      = s"${vacancyFormId}_datafield_47690_1_1"
  def experienceTitleId                            = s"${vacancyFormId}_label_108203_1"
  def experienceScoreId                            = s"select2-${vacancyFormId}_datafield_108325_1_1-container"
  def experienceDescriptionId                      = s"${vacancyFormId}_datafield_108213_1_1"
  def overallScoreTitleId                          = s"${vacancyFormId}_label_23545_1"
  def overallScoreTitlePath                        = s".//*[@id='${vacancyFormId}_label_23545_1']/span/strong"
  def overallScoreId                               = s"${vacancyFormId}_datafield_27738_1_1"
  def overallOverrideScoreId                       = s"${vacancyFormId}_datafield_116088_1_1"
  def outcomeTitleId                               = s"${vacancyFormId}_label_23547_1"
  def outcomeId                                    = s"select2-${vacancyFormId}_datafield_38858_1_1-container"
  def outcomeCommentsId                            = s"${vacancyFormId}_datafield_24596_1_1"
  def uploadIDTitleId                              = s"${vacancyFormId}_label_56060_1"
  def uploadIDId                                   = s"${vacancyFormId}_datafield_56037_1_1"
  def declarationStatementId                       = s"${vacancyFormId}_label_23549_1"

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
    moveVacancyOnViaTopBar(completeI3EvaluationBarId, interviewThreeEvaluationTabPath)
    availableBarItems(List(completeI3EvaluationBarId, noShowI3BarId, withdrawAtInterviewBarId))
    waitForVisibilityOfElementById(interviewThreeEvaluationHeaderId).getText should endWith("Interview 3 Evaluation")
  }

  private def enterBehaviourOneOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    waitForVisibilityOfElementById(
      behaviourAssessmentHeaderId
    ).getText                                                  shouldEqual "Behaviour Assessment" //TODO different to I2
    waitForVisibilityOfElementById(behaviourScoringGuideId).getText should include(interviewThreeDetails.scoringGuide)
    enterOutcome(
      behaviourOneTitleId,
      vXListOfChosenBehaviours.head,
      behaviourOneScoreId,
      interviewThreeDetails.behaviourOne.score,
      behaviourOneCommentsId,
      interviewThreeDetails.behaviourOne.comment
    )
    vXI3BehavioursTotalScore.clear()
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourOne.score
  }

  private def enterBehaviourTwoOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      behaviourTwoTitleId,
      vXListOfChosenBehaviours(1),
      behaviourTwoScoreId,
      interviewThreeDetails.behaviourTwo.score,
      behaviourTwoCommentsId,
      interviewThreeDetails.behaviourTwo.comment
    )
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourTwo.score
  }

  private def enterBehaviourThreeOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      behaviourThreeTitleId,
      vXListOfChosenBehaviours(2),
      behaviourThreeScoreId,
      interviewThreeDetails.behaviourThree.score,
      behaviourThreeCommentsId,
      interviewThreeDetails.behaviourThree.comment
    )
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourThree.score
  }

  private def enterBehaviourFourOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    scrollToElement(By.id(behaviourFourTitleId))
    enterOutcome(
      behaviourFourTitleId,
      vXListOfChosenBehaviours(3),
      behaviourFourScoreId,
      interviewThreeDetails.behaviourFour.score,
      behaviourFourCommentsId,
      interviewThreeDetails.behaviourFour.comment
    )
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourFour.score
  }

  private def enterBehaviourFiveOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      behaviourFiveTitleId,
      vXListOfChosenBehaviours(4),
      behaviourFiveScoreId,
      interviewThreeDetails.behaviourFive.score,
      behaviourFiveCommentsId,
      interviewThreeDetails.behaviourFive.comment
    )
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourFive.score
  }

  private def enterBehaviourSixOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    scrollToElement(By.id(behaviourSixTitleId))
    enterOutcome(
      behaviourSixTitleId,
      vXListOfChosenBehaviours(5),
      behaviourSixScoreId,
      interviewThreeDetails.behaviourSix.score,
      behaviourSixCommentsId,
      interviewThreeDetails.behaviourSix.comment
    )
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourSix.score
  }

  private def enterBehaviourSevenOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      behaviourSevenTitleId,
      vXListOfChosenBehaviours(6),
      behaviourSevenScoreId,
      interviewThreeDetails.behaviourSeven.score,
      behaviourSevenCommentsId,
      interviewThreeDetails.behaviourSeven.comment //TODO Not optional as star denotes mandatory?
    )
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourSeven.score
  }

  private def enterBehaviourEightOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      behaviourEightTitleId,
      vXListOfChosenBehaviours(7),
      behaviourEightScoreId,
      interviewThreeDetails.behaviourEight.score,
      behaviourEightCommentsId,
      interviewThreeDetails.behaviourEight.comment
    )
    vXI3BehavioursTotalScore += interviewThreeDetails.behaviourEight.score
  }

  private def totalScore(runningScore: ListBuffer[Int]): Int = {
    var score = 0
    runningScore.foreach(score += _)
    score
  }

  private val behaviourOutcome: Seq[InterviewThreeDetails => Unit] = Seq(
    enterBehaviourOneOutcome,
    enterBehaviourTwoOutcome,
    enterBehaviourThreeOutcome,
    enterBehaviourFourOutcome,
    enterBehaviourFiveOutcome,
    enterBehaviourSixOutcome,
    enterBehaviourSevenOutcome,
    enterBehaviourEightOutcome
  )

  private def behavioursOutcome(interviewThreeDetails: InterviewThreeDetails): Unit =
    if (vXBehavioursRequired) {
      behaviourOutcome.take(vXHowManyBehaviours).foreach { f =>
        f(interviewThreeDetails)
      }
      waitForVisibilityOfElementById(
        behaviourTotalScoreId
      ).getText shouldEqual s"Behaviour Total Score  \n${totalScore(vXI3BehavioursTotalScore)}" //TODO I2 is different, no Pascal Case
    }

  private def enterTechSkillOneOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    scrollToElement(By.id(techSkillsHeaderId))
    waitForVisibilityOfElementById(
      techSkillsHeaderId
    ).getText                                                   shouldEqual "Technical Skills" //TODO I2 different, no Pascal Case
    waitForVisibilityOfElementById(techSkillsScoringGuideId).getText should include(interviewThreeDetails.scoringGuide)
    enterOutcome(
      techSkillOneTitleId,
      vXListOfTechSkills.head,
      techSkillOneScoreId,
      interviewThreeDetails.techSkillOne.score,
      techSkillOneCommentsId,
      interviewThreeDetails.techSkillOne.comment
    )
    vXI3TechSkillsTotalScore.clear()
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillOne.score
  }

  private def enterTechSkillTwoOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      techSkillTwoTitleId,
      vXListOfTechSkills(1),
      techSkillTwoScoreId,
      interviewThreeDetails.techSkillTwo.score,
      techSkillTwoCommentsId,
      interviewThreeDetails.techSkillTwo.comment
    )
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillTwo.score
  }

  private def enterTechSkillThreeOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      techSkillThreeTitleId,
      vXListOfTechSkills(2),
      techSkillThreeScoreId,
      interviewThreeDetails.techSkillThree.score,
      techSkillThreeCommentsId,
      interviewThreeDetails.techSkillThree.comment
    )
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillThree.score
  }

  private def enterTechSkillFourOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      techSkillFourTitleId,
      vXListOfTechSkills(3),
      techSkillFourScoreId,
      interviewThreeDetails.techSkillFour.score,
      techSkillFourCommentsId,
      interviewThreeDetails.techSkillFour.comment
    )
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillFour.score
  }

  private def enterTechSkillFiveOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      techSkillFiveTitleId,
      vXListOfTechSkills(4),
      techSkillFiveScoreId,
      interviewThreeDetails.techSkillFive.score,
      techSkillFiveCommentsId,
      interviewThreeDetails.techSkillFive.comment
    )
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillFive.score
  }

  private def enterTechSkillSixOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      techSkillSixTitleId,
      vXListOfTechSkills(5),
      techSkillSixScoreId,
      interviewThreeDetails.techSkillSix.score,
      techSkillSixCommentsId,
      interviewThreeDetails.techSkillSix.comment
    )
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillSix.score
  }

  private def enterTechSkillSevenOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      techSkillSevenTitleId,
      vXListOfTechSkills(6),
      techSkillSevenScoreId,
      interviewThreeDetails.techSkillSeven.score,
      techSkillSevenCommentsId,
      interviewThreeDetails.techSkillSeven.comment
    )
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillSeven.score
  }

  private def enterTechSkillEightOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      techSkillEightTitleId,
      vXListOfTechSkills(7),
      techSkillEightScoreId,
      interviewThreeDetails.techSkillEight.score,
      techSkillEightCommentsId,
      interviewThreeDetails.techSkillEight.comment
    )
    vXI3TechSkillsTotalScore += interviewThreeDetails.techSkillEight.score
  }

  private val skillOutcome: Seq[InterviewThreeDetails => Unit] = Seq(
    enterTechSkillOneOutcome,
    enterTechSkillTwoOutcome,
    enterTechSkillThreeOutcome,
    enterTechSkillFourOutcome,
    enterTechSkillFiveOutcome,
    enterTechSkillSixOutcome,
    enterTechSkillSevenOutcome,
    enterTechSkillEightOutcome
  )

  private def techSkillOutcome(interviewThreeDetails: InterviewThreeDetails): Unit =
    if (vXTechSkillsRequired) {
      skillOutcome.take(vXHowManySkills).foreach { f =>
        f(interviewThreeDetails)
      }
      waitForVisibilityOfElementById(
        techSkillTotalScoreId
      ).getText shouldEqual s"Technical Skill Overall Score  \n${totalScore(vXI3TechSkillsTotalScore)}" //TODO I2 different wording case
    }

  private def enterStrengthOneOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    scrollToElement(By.id(strengthsHeaderId))
    waitForVisibilityOfElementById(strengthsHeaderId).getText shouldEqual "Strength assessment"
    waitForVisibilityOfElementById(strengthScoringGuideId).getText should include(
      interviewThreeDetails.strengthScoringGuide
    )
    enterOutcome(
      strengthOneTitleId,
      s"Strength 1  \n${vXListOfStrengths.head}",
      strengthOneScoreId,
      interviewThreeDetails.strengthOne.score,
      strengthOneCommentsId,
      interviewThreeDetails.strengthOne.comment
    )
    vXI3StrengthsTotalScore.clear()
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthOne.score
  }

  private def enterStrengthTwoOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      strengthTwoTitleId,
      s"Strength 2  \n${vXListOfStrengths(1)}",
      strengthTwoScoreId,
      interviewThreeDetails.strengthTwo.score,
      strengthTwoCommentsId,
      interviewThreeDetails.strengthTwo.comment
    )
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthTwo.score
  }

  private def enterStrengthThreeOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      strengthThreeTitleId,
      s"Strength 3  \n${vXListOfStrengths(2)}",
      strengthThreeScoreId,
      interviewThreeDetails.strengthThree.score,
      strengthThreeCommentsId,
      interviewThreeDetails.strengthThree.comment
    )
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthThree.score
  }

  private def enterStrengthFourOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      strengthFourTitleId,
      s"Strength 4  \n${vXListOfStrengths(3)}",
      strengthFourScoreId,
      interviewThreeDetails.strengthFour.score,
      strengthFourCommentsId,
      interviewThreeDetails.strengthFour.comment
    )
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthFour.score
  }

  private def enterStrengthFiveOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      strengthFiveTitleId,
      s"Strength 5  \n${vXListOfStrengths(4)}",
      strengthFiveScoreId,
      interviewThreeDetails.strengthFive.score,
      strengthFiveCommentsId,
      interviewThreeDetails.strengthFive.comment
    )
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthFive.score
  }

  private def enterStrengthSixOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      strengthSixTitleId,
      s"Strength 6  \n${vXListOfStrengths(5)}",
      strengthSixScoreId,
      interviewThreeDetails.strengthSix.score,
      strengthSixCommentsId,
      interviewThreeDetails.strengthSix.comment
    )
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthSix.score
  }

  private def enterStrengthSevenOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      strengthSevenTitleId,
      s"Strength 7  \n${vXListOfStrengths(6)}",
      strengthSevenScoreId,
      interviewThreeDetails.strengthSeven.score,
      strengthSevenCommentsId,
      interviewThreeDetails.strengthSeven.comment
    )
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthSeven.score
  }

  private def enterStrengthEightOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      strengthEightTitleId,
      s"Strength 8  \n${vXListOfStrengths(7)}",
      strengthEightScoreId,
      interviewThreeDetails.strengthEight.score,
      strengthEightCommentsId,
      interviewThreeDetails.strengthEight.comment
    )
    vXI3StrengthsTotalScore += interviewThreeDetails.strengthEight.score
  }

  private val strengths: Seq[InterviewThreeDetails => Unit] = Seq(
    enterStrengthOneOutcome,
    enterStrengthTwoOutcome,
    enterStrengthThreeOutcome,
    enterStrengthFourOutcome,
    enterStrengthFiveOutcome,
    enterStrengthSixOutcome,
    enterStrengthSevenOutcome,
    enterStrengthEightOutcome
  )

  private def strengthsOutcome(interviewThreeDetails: InterviewThreeDetails): Unit =
    if (vXStrengthsRequired) {
      strengths.take(vXHowManyStrengths).foreach { f =>
        f(interviewThreeDetails)
      }
      waitForVisibilityOfElementById(
        strengthTotalScoreId
      ).getText shouldEqual s"Strengths Total Score  \n${totalScore(vXI3StrengthsTotalScore)}" //TODO I2 has different casing
    }

  private def howManyAssessments(interviewThreeDetails: InterviewThreeDetails): Unit = {
    waitForVisibilityOfElementById(assessmentsHowManyId).click()
    action().moveToElement(waitForDropdownOption(interviewThreeDetails.additionalAssessments)).perform()
    waitForDropdownOption(interviewThreeDetails.additionalAssessments).click()
  }

  private def enterAssessmentOneOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    waitForVisibilityOfElementById(assessmentHeaderId).getText shouldEqual "Additional assessments"
    waitForVisibilityOfElementById(
      assessmentInfoId
    ).getText                                                       should endWith("Additional assessment names, scores and comments will be visible to the applicant")
    enterAssessmentOutcome(
      assessmentOneNameId,
      interviewThreeDetails.assessmentOne.name,
      assessmentOneScoreId,
      interviewThreeDetails.assessmentOne.score,
      assessmentOneCommentsId,
      interviewThreeDetails.assessmentOne.comment
    )
    vXI3AssessmentsTotalScore.clear()
    vXI3AssessmentsTotalScore += interviewThreeDetails.assessmentOne.score
  }

  private def enterAssessmentTwoOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterAssessmentOutcome(
      assessmentTwoNameId,
      interviewThreeDetails.assessmentTwo.name,
      assessmentTwoScoreId,
      interviewThreeDetails.assessmentTwo.score,
      assessmentTwoCommentsId,
      interviewThreeDetails.assessmentTwo.comment
    )
    vXI3AssessmentsTotalScore += interviewThreeDetails.assessmentTwo.score
  }

  private def enterAssessmentThreeOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterAssessmentOutcome(
      assessmentThreeNameId,
      interviewThreeDetails.assessmentThree.name,
      assessmentThreeScoreId,
      interviewThreeDetails.assessmentThree.score,
      assessmentThreeCommentsId,
      interviewThreeDetails.assessmentThree.comment
    )
    vXI3AssessmentsTotalScore += interviewThreeDetails.assessmentThree.score
  }

  private def enterAssessmentFourOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFourNameId,
      interviewThreeDetails.assessmentFour.name,
      assessmentFourScoreId,
      interviewThreeDetails.assessmentFour.score,
      assessmentFourCommentsId,
      interviewThreeDetails.assessmentFour.comment
    )
    vXI3AssessmentsTotalScore += interviewThreeDetails.assessmentFour.score
  }

  private def enterAssessmentFiveOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterAssessmentOutcome(
      assessmentFiveNameId,
      interviewThreeDetails.assessmentFive.name,
      assessmentFiveScoreId,
      interviewThreeDetails.assessmentFive.score,
      assessmentFiveCommentsId,
      interviewThreeDetails.assessmentFive.comment
    )
    vXI3AssessmentsTotalScore += interviewThreeDetails.assessmentFive.score
  }

  private def enterAssessmentSixOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterAssessmentOutcome(
      assessmentSixNameId,
      interviewThreeDetails.assessmentSix.name,
      assessmentSixScoreId,
      interviewThreeDetails.assessmentSix.score,
      assessmentSixCommentsId,
      interviewThreeDetails.assessmentSix.comment
    )
    vXI3AssessmentsTotalScore += interviewThreeDetails.assessmentSix.score
  }

  private val assessments: Seq[InterviewThreeDetails => Unit] = Seq(
    enterAssessmentOneOutcome,
    enterAssessmentTwoOutcome,
    enterAssessmentThreeOutcome,
    enterAssessmentFourOutcome,
    enterAssessmentFiveOutcome,
    enterAssessmentSixOutcome
  )

  private def assessmentsOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    howManyAssessments(interviewThreeDetails)
    assessments.take(interviewThreeDetails.additionalAssessments.toInt).foreach { f =>
      f(interviewThreeDetails)
    }
    totalScore(vXI3AssessmentsTotalScore)
  }

  private def enterExperienceOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    enterOutcome(
      experienceTitleId,
      "Experience", //TODO this is different in I2, "Experience assessment"
      experienceScoreId,
      interviewThreeDetails.experience.score,
      experienceDescriptionId,
      interviewThreeDetails.experience.comment
    )
    vXI3ExperienceScore = interviewThreeDetails.experience.score
  }

  private def checkOverallScore(interviewThreeDetails: InterviewThreeDetails): Unit = {
    waitForVisibilityOfElementByPath(overallScoreTitlePath).getText should endWith(
      "Overall Score"
    ) //TODO this is different in I2, in Pascal Case and space
    if (interviewThreeDetails.overrideScore) {
      enterValue(overallOverrideScoreId, interviewThreeDetails.overallOverrideScore.toString)
    }
    val overallScore = totalScore(vXI3BehavioursTotalScore) + totalScore(vXI3TechSkillsTotalScore) + totalScore(
      vXI3StrengthsTotalScore
    ) + totalScore(vXI3AssessmentsTotalScore) + vXI3ExperienceScore
    waitForVisibilityOfElementById(overallScoreId).getAttribute("value") shouldEqual s"$overallScore"
  }

  private def enterOutcome(interviewThreeDetails: InterviewThreeDetails): Unit = {
    vXInterviewThreeOutcome = interviewThreeDetails.finalOutcome
    waitForVisibilityOfElementById(outcomeTitleId).getText shouldEqual "Outcome"
    waitForVisibilityOfElementById(outcomeId).click()
    action().moveToElement(waitForDropdownOption(vXInterviewThreeOutcome)).perform()
    waitForDropdownOption(vXInterviewThreeOutcome).click()
    enterValue(outcomeCommentsId, s"Autotest - I3 - $randomFirstName $randomLastName overall performed very well!")
  }

  private def uploadDocuments(interviewThreeDetails: InterviewThreeDetails): Unit = {
    waitForVisibilityOfElementById(uploadIDTitleId).getText shouldEqual "Candidate identity documents"
    attachDocuments(uploadIDId, interviewThreeDetails.uploadDocs)
    waitForVisibilityOfElementById(
      declarationStatementId
    ).getText                                               shouldEqual interviewThreeDetails.declarationStatement
  }

  private val evaluation: Seq[InterviewThreeDetails => Unit] = Seq(
    behavioursOutcome,
    techSkillOutcome,
    strengthsOutcome,
    assessmentsOutcome,
    enterExperienceOutcome,
    checkOverallScore,
    enterOutcome,
    uploadDocuments
  )

  def interviewThreeEvaluationFlow(applicationDetails: ApplicationDetails): Unit = {
    moveInterviewScheduleForm()
    evaluation.foreach { f =>
      f(applicationDetails.interviewThreeDetails)
    }
    clickOn(submitForm)
    interviewEvaluation()
    applicationStateAfterInterview(applicationDetails)
  }
}
