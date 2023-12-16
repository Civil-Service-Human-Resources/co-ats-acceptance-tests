package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.ApplicationSummaryDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXBehavioursRequired, vXHowManyBehaviours, vXHowManySkills, vXListOfChosenBehaviours, vXListOfTechSkills, vXTechSkillsRequired}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, completeSiftBarId, withdrawBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

import scala.collection.mutable.ListBuffer

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

  private lazy val siftEvaluationTabPath      = ".//span[@class='main-label' and text() = 'Sift evaluation']"
  var vXBehavioursTotalScore: ListBuffer[Int] = ListBuffer()
  var vXTechSkillsTotalScore: ListBuffer[Int] = ListBuffer()
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
  def behaviourTotalScoreId                   = s"${vacancyFormId}_datafield_65906_1_1"
  def techSkillsHeaderId                      = s"${vacancyFormId}_label_66915_1"
  def techSkillsScoringGuideId                = s"${vacancyFormId}_label_153588_1"
  def techSkillOneTitleId                     = s"${vacancyFormId}_label_66597_1"
  def techSkillOneScoreId                     = s"select2-${vacancyFormId}_datafield_66573_1_1-container"
  def techSkillOneCommentsId                  = s"${vacancyFormId}_datafield_66525_1_1"
  def techSkillTwoTitleId = s"${vacancyFormId}_label_66600_1"
  def techSkillTwoScoreId = s"select2-${vacancyFormId}_datafield_66576_1_1-container"
  def techSkillTwoCommentsId = s"${vacancyFormId}_datafield_66531_1_1"
  def techSkillThreeTitleId = s"${vacancyFormId}_label_66603_1"
  def techSkillThreeScoreId = s"select2-${vacancyFormId}_datafield_66579_1_1-container"
  def techSkillThreeCommentsId = s"${vacancyFormId}_datafield_66537_1_1"
  def techSkillFourTitleId = s"${vacancyFormId}_label_66606_1"
  def techSkillFourScoreId = s"select2-${vacancyFormId}_datafield_66582_1_1-container"
  def techSkillFourCommentsId = s"${vacancyFormId}_datafield_66543_1_1"
  def techSkillFiveTitleId = s"${vacancyFormId}_label_66609_1"
  def techSkillFiveScoreId = s"select2-${vacancyFormId}_datafield_66585_1_1-container"
  def techSkillFiveCommentsId = s"${vacancyFormId}_datafield_66549_1_1"
  def techSkillSixTitleId = s"${vacancyFormId}_label_66612_1"
  def techSkillSixScoreId = s"select2-${vacancyFormId}_datafield_66588_1_1-container"
  def techSkillSixCommentsId = s"${vacancyFormId}_datafield_66555_1_1"
  def techSkillSevenTitleId = s"${vacancyFormId}_label_66615_1"
  def techSkillSevenScoreId = s"select2-${vacancyFormId}_datafield_66591_1_1-container"
  def techSkillSevenCommentsId = s"${vacancyFormId}_datafield_66561_1_1"
  def techSkillEightTitleId = s"${vacancyFormId}_label_66618_1"
  def techSkillEightScoreId = s"select2-${vacancyFormId}_datafield_66594_1_1-container"
  def techSkillEightCommentsId = s"${vacancyFormId}_datafield_66567_1_1"

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
//     waitForVisibilityOfElementById(behaviourScoringGuideId).getText     shouldEqual siftDetails.scoringGuide
    enterOutcome(
      behaviourOneTitleId,
      vXListOfChosenBehaviours.head,
      behaviourOneScoreId,
      siftDetails.behaviourOne.map(_.score).get,
      behaviourOneCommentsId,
      siftDetails.behaviourOne.map(_.comment).get
    )
    vXBehavioursTotalScore.clear()
    vXBehavioursTotalScore += siftDetails.behaviourOne.map(_.score).get
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
    vXBehavioursTotalScore += siftDetails.behaviourTwo.map(_.score).get
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
    vXBehavioursTotalScore += siftDetails.behaviourThree.map(_.score).get
  }

  private def enterBehaviourFourOutcome(siftDetails: SiftDetails): Unit = {
    scrollToElement(By.id(behaviourFourTitleId))
    enterOutcome(
      behaviourFourTitleId,
      vXListOfChosenBehaviours(3),
      behaviourFourScoreId,
      siftDetails.behaviourFour.map(_.score).get,
      behaviourFourCommentsId,
      siftDetails.behaviourFour.map(_.comment).get
    )
    vXBehavioursTotalScore += siftDetails.behaviourFour.map(_.score).get
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
    vXBehavioursTotalScore += siftDetails.behaviourFive.map(_.score).get
  }

  private def enterBehaviourSixOutcome(siftDetails: SiftDetails): Unit = {
    scrollToElement(By.id(behaviourSixTitleId))
    enterOutcome(
      behaviourSixTitleId,
      vXListOfChosenBehaviours(5),
      behaviourSixScoreId,
      siftDetails.behaviourSix.map(_.score).get,
      behaviourSixCommentsId,
      siftDetails.behaviourSix.map(_.comment).get
    )
    vXBehavioursTotalScore += siftDetails.behaviourSix.map(_.score).get
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
    vXBehavioursTotalScore += siftDetails.behaviourSeven.map(_.score).get
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
    vXBehavioursTotalScore += siftDetails.behaviourEight.map(_.score).get
  }

  private def totalScoreForBehaviour(): Int = {
    var score = 0
    vXBehavioursTotalScore.foreach(score += _)
    println(score)
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
      waitForVisibilityOfElementById(behaviourTotalScoreId).getText.toInt shouldEqual totalScoreForBehaviour()
    }

  private def enterTechSkillOneOutcome(siftDetails: SiftDetails): Unit = {
    scrollToElement(By.id(techSkillsHeaderId))
    waitForVisibilityOfElementById(techSkillsHeaderId).getText shouldEqual "Technical skills"
//    waitForVisibilityOfElementById(techSkillsScoringGuideId).getText shouldEqual siftDetails.scoringGuide
    enterOutcome(
      techSkillOneTitleId,
      vXListOfTechSkills.head,
      techSkillOneScoreId,
      siftDetails.techSkillOne.map(_.score).get,
      techSkillOneCommentsId,
      siftDetails.techSkillOne.map(_.comment).get
    )
    vXTechSkillsTotalScore.clear()
    vXTechSkillsTotalScore += siftDetails.techSkillOne.map(_.score).get
  }

  private def enterTechSkillTwoOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillTwoTitleId,
      vXListOfTechSkills(1),
      techSkillTwoScoreId,
      siftDetails.techSkillTwo.map(_.score).get,
      techSkillTwoCommentsId,
      siftDetails.techSkillTwo.map(_.comment).get
    )
    vXTechSkillsTotalScore += siftDetails.techSkillTwo.map(_.score).get
  }

  private def enterTechSkillThreeOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillThreeTitleId,
      vXListOfTechSkills(2),
      techSkillThreeScoreId,
      siftDetails.techSkillThree.map(_.score).get,
      techSkillThreeCommentsId,
      siftDetails.techSkillThree.map(_.comment).get
    )
    vXTechSkillsTotalScore += siftDetails.techSkillThree.map(_.score).get
  }

  private def enterTechSkillFourOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillFourTitleId,
      vXListOfTechSkills(3),
      techSkillFourScoreId,
      siftDetails.techSkillFour.map(_.score).get,
      techSkillFourCommentsId,
      siftDetails.techSkillFour.map(_.comment).get
    )
    vXTechSkillsTotalScore += siftDetails.techSkillFour.map(_.score).get
  }

  private def enterTechSkillFiveOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillFiveTitleId,
      vXListOfTechSkills(4),
      techSkillFiveScoreId,
      siftDetails.techSkillFive.map(_.score).get,
      techSkillFiveCommentsId,
      siftDetails.techSkillFive.map(_.comment).get
    )
    vXTechSkillsTotalScore += siftDetails.techSkillFive.map(_.score).get
  }

  private def enterTechSkillSixOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillSixTitleId,
      vXListOfTechSkills(5),
      techSkillSixScoreId,
      siftDetails.techSkillSix.map(_.score).get,
      techSkillSixCommentsId,
      siftDetails.techSkillSix.map(_.comment).get
    )
    vXTechSkillsTotalScore += siftDetails.techSkillSix.map(_.score).get
  }

  private def enterTechSkillSevenOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillSevenTitleId,
      vXListOfTechSkills(6),
      techSkillSevenScoreId,
      siftDetails.techSkillSeven.map(_.score).get,
      techSkillSevenCommentsId,
      siftDetails.techSkillSeven.map(_.comment).get
    )
    vXTechSkillsTotalScore += siftDetails.techSkillSeven.map(_.score).get
  }

  private def enterTechSkillEightOutcome(siftDetails: SiftDetails): Unit = {
    enterOutcome(
      techSkillEightTitleId,
      vXListOfTechSkills(7),
      techSkillEightScoreId,
      siftDetails.techSkillEight.map(_.score).get,
      techSkillEightCommentsId,
      siftDetails.techSkillEight.map(_.comment).get
    )
    vXTechSkillsTotalScore += siftDetails.techSkillEight.map(_.score).get
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
