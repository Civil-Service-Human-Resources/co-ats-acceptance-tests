package uk.gov.co.test.ui.pages.vx.vacancytabs

import uk.gov.co.test.ui.data.vx.ApplicationSummaryDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXBehavioursRequired, vXBehavioursTotalScore, vXHowManyBehaviours, vXHowManySkills, vXListOfChosenBehaviours, vXListOfTechSkills, vXTechSkillsRequired}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeSiftBarId, withdrawBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

case class Outcome(score: Int, comment: String)

case class SiftDetails(
  scoringGuide: String,
  behaviourOne: Option[Outcome] = None,
  behaviourTwo: Option[Outcome] = None,
  behaviourThree: Option[Outcome] = None,
  behaviourFour: Option[Outcome] = None,
  behaviourFive: Option[Outcome] = None,
  behaviourSix: Option[Outcome] = None,
  behaviourSeven: Option[Outcome] = None,
  behaviourEight: Option[Outcome] = None,
  techSkillOne: Option[Outcome] = None,
  techSkillTwo: Option[Outcome] = None,
  techSkillThree: Option[Outcome] = None,
  techSkillFour: Option[Outcome] = None,
  techSkillFive: Option[Outcome] = None,
  techSkillSix: Option[Outcome] = None,
  techSkillSeven: Option[Outcome] = None,
  techSkillEight: Option[Outcome] = None
)

object SiftEvaluationTab extends VacancyBasePage {

  private lazy val siftEvaluationTabPath = ".//span[@class='main-label' and text() = 'Sift evaluation']"
  def siftEvaluationHeaderId             = s"${vacancyFormId}_label_153018_1"
  def behaviourAssessmentHeaderId        = s"${vacancyFormId}_label_65762_1"
  def behaviourScoringGuideId            = s"${vacancyFormId}_label_153583_1"
  def behaviourOneTitleId                = s"${vacancyFormId}_label_65988_1"
  def behaviourOneScoreId                = s"select2-${vacancyFormId}_datafield_65874_1_1-container"
  def behaviourOneCommentsId             = s"${vacancyFormId}_datafield_65818_1_1"
  def behaviourTwoTitleId                = s"${vacancyFormId}_label_65991_1"
  def behaviourTwoScoreId                = s"select2-${vacancyFormId}_datafield_65878_1_1-container"
  def behaviourTwoCommentsId             = s"${vacancyFormId}_datafield_65825_1_1"
  def behaviourThreeTitleId              = s"${vacancyFormId}_label_65994_1"
  def behaviourThreeScoreId              = s"select2-${vacancyFormId}_datafield_65882_1_1-container"
  def behaviourThreeCommentsId           = s"${vacancyFormId}_datafield_65832_1_1"
  def behaviourFourTitleId               = s"${vacancyFormId}_label_65997_1"
  def behaviourFourScoreId               = s"select2-${vacancyFormId}_datafield_65886_1_1-container"
  def behaviourFourCommentsId            = s"${vacancyFormId}_datafield_65839_1_1"
  def behaviourFiveTitleId               = s"${vacancyFormId}_label_66000_1"
  def behaviourFiveScoreId               = s"select2-${vacancyFormId}_datafield_65890_1_1-container"
  def behaviourFiveCommentsId            = s"${vacancyFormId}_datafield_65846_1_1"
  def behaviourSixTitleId                = s"${vacancyFormId}_label_66003_1"
  def behaviourSixScoreId                = s"select2-${vacancyFormId}_datafield_65894_1_1-container"
  def behaviourSixCommentsId             = s"${vacancyFormId}_datafield_65853_1_1"
  def behaviourSevenTitleId              = s"${vacancyFormId}_label_66006_1"
  def behaviourSevenScoreId              = s"select2-${vacancyFormId}_datafield_65898_1_1-container"
  def behaviourSevenCommentsId           = s"${vacancyFormId}_datafield_65860_1_1"
  def behaviourEightTitleId              = s"${vacancyFormId}_label_66009_1"
  def behaviourEightScoreId              = s"select2-${vacancyFormId}_datafield_65902_1_1-container"
  def behaviourEightCommentsId           = s"${vacancyFormId}_datafield_65867_1_1"
  def behaviourTotalScoreId              = s"${vacancyFormId}_datafield_65906_1_1"
  def techSkillsHeaderId                 = s"${vacancyFormId}_label_66915_1"
  def techSkillsScoringGuideId           = s"${vacancyFormId}_label_153588_1"

  def techSkillOneTitleId    = s"${vacancyFormId}_label_66597_1"
  def techSkillOneScoreId    = s"select2-${vacancyFormId}_datafield_66573_1_1-container"
  def techSkillOneCommentsId = s"${vacancyFormId}_datafield_66525_1_1"

  def enterOutcome(
    titleId: String,
    expectedTitle: String,
    scoreId: String,
    score: Int,
    commentsId: String,
    comment: String
  ): Unit = {
    waitForVisibilityOfElementById(titleId).getText shouldEqual expectedTitle
    waitForVisibilityOfElementById(scoreId).click()
    action().moveToElement(waitForDropdownOption(score.toString)).perform()
    waitForDropdownOption(score.toString).click()
    enterText(commentsId, comment)
  }

  private def moveSiftEvaluationForm(): Unit = {
    checkVacancyStatus("Sift application")
    moveVacancyOnViaTopBar(completeSiftBarId, siftEvaluationTabPath)
    availableBarItems(List(completeSiftBarId, withdrawBarId))
    waitForVisibilityOfElementById(siftEvaluationHeaderId).getText should endWith("Sift Evaluation")
  }

  private def enterBehaviourOneOutcome(siftDetails: SiftDetails): Unit = {
    waitForVisibilityOfElementById(behaviourAssessmentHeaderId).getText shouldEqual "Behaviour assessment"
    waitForVisibilityOfElementById(behaviourScoringGuideId).getText     shouldEqual siftDetails.scoringGuide
    enterOutcome(
      behaviourOneTitleId,
      vXListOfChosenBehaviours.head,
      behaviourOneScoreId,
      siftDetails.behaviourOne.map(_.score).get,
      behaviourOneCommentsId,
      siftDetails.behaviourOne.map(_.comment).get
    )
    vXBehavioursTotalScore.clear()
    vXBehavioursTotalScore ++ siftDetails.behaviourOne.map(_.score)
    println(vXBehavioursTotalScore)
  }

  private def enterBehaviourTwoOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourTwoTitleId,
      vXListOfChosenBehaviours(1),
      behaviourTwoScoreId,
      siftDetails.behaviourTwo.map(_.score).get,
      behaviourTwoCommentsId,
      siftDetails.behaviourTwo.map(_.comment).get
    )
    vXBehavioursTotalScore ++ siftDetails.behaviourTwo.map(_.score)
    println(vXBehavioursTotalScore)
  }

  private def enterBehaviourThreeOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourThreeTitleId,
      vXListOfChosenBehaviours(2),
      behaviourThreeScoreId,
      siftDetails.behaviourThree.map(_.score).get,
      behaviourThreeCommentsId,
      siftDetails.behaviourThree.map(_.comment).get
    )
    vXBehavioursTotalScore ++ siftDetails.behaviourThree.map(_.score)
    println(vXBehavioursTotalScore)
  }

  private def enterBehaviourFourOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourFourTitleId,
      vXListOfChosenBehaviours(3),
      behaviourFourScoreId,
      siftDetails.behaviourFour.map(_.score).get,
      behaviourFourCommentsId,
      siftDetails.behaviourFour.map(_.comment).get
    )
    vXBehavioursTotalScore ++ siftDetails.behaviourFour.map(_.score)
    println(vXBehavioursTotalScore)
  }

  private def enterBehaviourFiveOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourFiveTitleId,
      vXListOfChosenBehaviours(4),
      behaviourFiveScoreId,
      siftDetails.behaviourFive.map(_.score).get,
      behaviourFiveCommentsId,
      siftDetails.behaviourFive.map(_.comment).get
    )
    vXBehavioursTotalScore ++ siftDetails.behaviourFive.map(_.score)
    println(vXBehavioursTotalScore)
  }

  private def enterBehaviourSixOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourSixTitleId,
      vXListOfChosenBehaviours(5),
      behaviourSixScoreId,
      siftDetails.behaviourSix.map(_.score).get,
      behaviourSixCommentsId,
      siftDetails.behaviourSix.map(_.comment).get
    )
    vXBehavioursTotalScore ++== siftDetails.behaviourSix.map(_.score)
    println(vXBehavioursTotalScore)
  }

  private def enterBehaviourSevenOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourSevenTitleId,
      vXListOfChosenBehaviours(6),
      behaviourSevenScoreId,
      siftDetails.behaviourSeven.map(_.score).get,
      behaviourSevenCommentsId,
      siftDetails.behaviourSeven.map(_.comment).get
    )
    vXBehavioursTotalScore ++ siftDetails.behaviourSeven.map(_.score)
    println(vXBehavioursTotalScore)
  }

  private def enterBehaviourEightOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      behaviourEightTitleId,
      vXListOfChosenBehaviours(7),
      behaviourEightScoreId,
      siftDetails.behaviourEight.map(_.score).get,
      behaviourEightCommentsId,
      siftDetails.behaviourEight.map(_.comment).get
    )
    vXBehavioursTotalScore ++ siftDetails.behaviourEight.map(_.score)
    println(vXBehavioursTotalScore)
  }

//  private def totalScoreForBehaviour(siftDetails: SiftDetails): Int = {
//    val totalScore = siftDetails.
//  }

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

  private def behavioursOutcome(siftDetails: SiftDetails): Unit = {
    if (vXBehavioursRequired) {
      behaviourOutcome.take(vXHowManyBehaviours).foreach { f =>
        f(siftDetails)
      }
      waitForVisibilityOfElementById(behaviourTotalScoreId).getText.toInt shouldEqual vXBehavioursTotalScore
    }
  }

  private def enterTechSkillOneOutcome(siftDetails: SiftDetails): Unit = {
    waitForVisibilityOfElementById(techSkillsHeaderId).getText       shouldEqual "Technical skills"
    waitForVisibilityOfElementById(techSkillsScoringGuideId).getText shouldEqual siftDetails.scoringGuide
    enterOutcome(
      techSkillOneTitleId,
      vXListOfTechSkills.head,
      techSkillOneScoreId,
      siftDetails.techSkillOne.map(_.score).get,
      techSkillOneCommentsId,
      siftDetails.techSkillOne.map(_.comment).get
    )
  }

  private val skillOutcome: Seq[SiftDetails => Unit] = Seq(
    enterTechSkillOneOutcome
  )

  private def techSkillOutcome(siftDetails: SiftDetails): Unit =
    if (vXTechSkillsRequired) {
      skillOutcome.take(vXHowManySkills).foreach { f =>
        f(siftDetails)
      }
    }

  private val sift: Seq[SiftDetails => Unit] = Seq(
    behavioursOutcome,
    techSkillOutcome
  )

  def SiftEvaluationFlow(applicationSummaryDetails: ApplicationSummaryDetails): Unit = {
    moveSiftEvaluationForm()
    sift.foreach { f =>
      f(applicationSummaryDetails.siftDetails)
    }
    clickOn(submitForm)
//    preSiftCompletion()
  }
}
