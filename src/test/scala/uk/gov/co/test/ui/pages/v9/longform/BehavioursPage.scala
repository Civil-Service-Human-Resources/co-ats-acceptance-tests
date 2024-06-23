package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXBehaviourApplicationRequired, vXBehavioursRequired, vXHowManyBehaviours, vXListOfChosenBehaviours}
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.longFormId

case class BehavioursDetails(
  behaviourText: String
)

object BehavioursPage extends CivilServiceJobsBasePage {

  private lazy val behavioursPageTitle = "Behaviours - Civil Service Jobs - GOV.UK"
  def behaviourInfoId                  = s"${longFormId}_label_22281_1"
  def behaviourOneHeaderId             = s"${longFormId}_field_que_22232_1"
  def behaviourOneInputId              = s"${longFormId}_datafield_22232_1_1"
  def behaviourOneWordLimitId          = s"${longFormId}_datafield_22232_1_1_counter_node"
  def behaviourTwoHeaderId             = s"${longFormId}_field_que_22238_1"
  def behaviourTwoInputId              = s"${longFormId}_datafield_22238_1_1"
  def behaviourTwoWordLimitId          = s"${longFormId}_datafield_22238_1_1_counter_node"
  def behaviourThreeHeaderId           = s"${longFormId}_field_que_22244_1"
  def behaviourThreeInputId            = s"${longFormId}_datafield_22244_1_1"
  def behaviourThreeWordLimitId        = s"${longFormId}_datafield_22244_1_1_counter_node"
  def behaviourFourHeaderId            = s"${longFormId}_field_que_22250_1"
  def behaviourFourInputId             = s"${longFormId}_datafield_22250_1_1"
  def behaviourFourWordLimitId         = s"${longFormId}_datafield_22250_1_1_counter_node"
  def behaviourFiveHeaderId            = s"${longFormId}_field_que_22256_1"
  def behaviourFiveInputId             = s"${longFormId}_datafield_22256_1_1"
  def behaviourFiveWordLimitId         = s"${longFormId}_datafield_22256_1_1_counter_node"
  def behaviourSixHeaderId             = s"${longFormId}_field_que_22262_1"
  def behaviourSixInputId              = s"${longFormId}_datafield_22262_1_1"
  def behaviourSixWordLimitId          = s"${longFormId}_datafield_22262_1_1_counter_node"
  def behaviourSevenHeaderId           = s"${longFormId}_field_que_22268_1"
  def behaviourSevenInputId            = s"${longFormId}_datafield_22268_1_1"
  def behaviourSevenWordLimitId        = s"${longFormId}_datafield_22268_1_1_counter_node"
  def behaviourEightHeaderId           = s"${longFormId}_field_que_22274_1"
  def behaviourEightInputId            = s"${longFormId}_datafield_22274_1_1"
  def behaviourEightWordLimitId        = s"${longFormId}_datafield_22274_1_1_counter_node"
  private lazy val v9HowManyBehaviours = ".//*[@data-type='LARGETEXT']"

  private def behavioursPageCheck(): Unit = {
    eventually(onPage(behavioursPageTitle))
    waitForVisibilityOfElementById(
      behaviourInfoId
    ).getText shouldEqual s"Provide statements describing your skills and experience regarding each stated behaviour.\nStructure your example as Situation, Task, Action, and Result.\nFind out more about Success Profiles and Behaviours (opens in a new window).\nEach answer should not exceed 250 words."
  }

  private def confirmBehavioursRequired(): Unit = {
    behavioursPageCheck()
    val behaviourInputs        = driver.findElements(By.xpath(v9HowManyBehaviours))
    val howManyBehavioursShown = vXBehaviourApplicationRequired.groupBy(identity).view.mapValues(_.size)(true)
    behaviourInputs.size() shouldEqual howManyBehavioursShown
  }

  private def checkAndEnterBehaviourOne(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.headOption.get
    val applicationRequired = vXBehaviourApplicationRequired.headOption.get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourOneHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourOneInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourOneWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private def checkAndEnterBehaviourTwo(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.lift(1).get
    val applicationRequired = vXBehaviourApplicationRequired.lift(1).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourTwoHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourTwoInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourTwoWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private def checkAndEnterBehaviourThree(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.lift(2).get
    val applicationRequired = vXBehaviourApplicationRequired.lift(2).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourThreeHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourThreeInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourThreeWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private def checkAndEnterBehaviourFour(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.lift(3).get
    val applicationRequired = vXBehaviourApplicationRequired.lift(3).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourFourHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourFourInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourFourWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private def checkAndEnterBehaviourFive(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.lift(4).get
    val applicationRequired = vXBehaviourApplicationRequired.lift(4).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourFiveHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourFiveInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourFiveWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private def checkAndEnterBehaviourSix(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.lift(5).get
    val applicationRequired = vXBehaviourApplicationRequired.lift(5).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourSixHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourSixInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourSixWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private def checkAndEnterBehaviourSeven(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.lift(6).get
    val applicationRequired = vXBehaviourApplicationRequired.lift(6).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourSevenHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourSevenInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourSevenWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private def checkAndEnterBehaviourEight(behavioursDetails: BehavioursDetails): Unit = {
    val expectedHeader      = vXListOfChosenBehaviours.lift(7).get
    val applicationRequired = vXBehaviourApplicationRequired.lift(7).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(behaviourEightHeaderId).getText
      expectedHeader shouldEqual actualHeader
      enterDetails(behaviourEightInputId, behavioursDetails.behaviourText)
      eventually(
        waitForVisibilityOfElementById(
          behaviourEightWordLimitId
        ).getText    shouldEqual "Maximum Word Count 250 of  250 words"
      )
    }
  }

  private val behaviours: Seq[BehavioursDetails => Unit] = Seq(
    checkAndEnterBehaviourOne,
    checkAndEnterBehaviourTwo,
    checkAndEnterBehaviourThree,
    checkAndEnterBehaviourFour,
    checkAndEnterBehaviourFive,
    checkAndEnterBehaviourSix,
    checkAndEnterBehaviourSeven,
    checkAndEnterBehaviourEight
  )

  def behavioursPage(longFormDetails: LongFormDetails): Unit =
    if (vXBehavioursRequired) {
      confirmBehavioursRequired()
      behaviours.take(vXHowManyBehaviours).foreach { f =>
        f(longFormDetails.behavioursDetails)
      }
      clickOn(pageContinue)
    }
}
