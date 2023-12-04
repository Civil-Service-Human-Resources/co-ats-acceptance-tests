package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.pages.vx.createvacancypage.BehavioursSection.{howManyAssessed, listOfChosenBehaviours}
import uk.gov.co.test.ui.pages.vx.createvacancypage.SuccessProfilesSection.behavioursRequired

case class BehavioursDetails(
  changingAndImprovingText: String,
  communicatingAndInfluencingText: String,
  deliveringAtPaceText: String,
  developingSelfAndOthersText: String,
  leadershipText: String,
  makingEffectiveDecisionsText: String,
  managingAQualityServiceText: String,
  workingTogetherText: String
)

object BehavioursPage extends CivilServiceJobsBasePage {

  private lazy val behavioursPageTitle   = "Behaviours - Civil Service Jobs - GOV.UK"
  def changingAndImprovingInputId        = s"${formId}_datafield_22232_1_1"
  def communicatingAndInfluencingInputId = s"${formId}_datafield_22238_1_1"
  def deliveringAtPaceInputId            = s"${formId}_datafield_22244_1_1"
  def developingSelfAndOthersInputId     = s"${formId}_datafield_22250_1_1"
  def leadershipInputId                  = s"${formId}_datafield_22256_1_1"
  def makingEffectiveDecisionsInputId    = s"${formId}_datafield_22262_1_1"
  def managingAQualityServiceInputId     = s"${formId}_datafield_22268_1_1"
  def workingTogetherInputId             = s"${formId}_datafield_22274_1_1"
  private lazy val v9HowManyBehaviours   = ".//*[@data-type='LARGETEXT']"
//  var listOfChosenBehaviours: mutable.Seq[String] = ListBuffer( // TODO remove once section completed
//    "Changing and Improving",
//    "Communicating and Influencing",
//    "Delivering at Pace",
//    "Developing Self and Others",
//    "Leadership",
//    "Making Effective Decisions",
//    "Managing a Quality Service",
//    "Working Together"
//  )

  private def behavioursPageCheck(): Unit =
    eventually(onPage(behavioursPageTitle))

  private def confirmBehavioursRequired(): Unit = {
    behavioursPageCheck()
    val behaviourInputs = driver.findElements(By.xpath(v9HowManyBehaviours))
    behaviourInputs.size() shouldEqual howManyAssessed.toInt
//    behaviourInputs.size() shouldEqual 8 // TODO remove once section completed
  }

  private def enterChangingAndImproving(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Changing and Improving")) {
      enterDetails(changingAndImprovingInputId, behavioursDetails.changingAndImprovingText)
    }

  private def enterCommunicatingAndInfluencing(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Communicating and Influencing")) {
      enterDetails(communicatingAndInfluencingInputId, behavioursDetails.communicatingAndInfluencingText)
    }

  private def enterDeliveringAtPace(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Delivering at Pace")) {
      enterDetails(deliveringAtPaceInputId, behavioursDetails.deliveringAtPaceText)
    }

  private def enterDevelopingSelfAndOthers(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Developing Self and Others")) {
      enterDetails(developingSelfAndOthersInputId, behavioursDetails.developingSelfAndOthersText)
    }

  private def enterLeadership(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Leadership")) {
      enterDetails(leadershipInputId, behavioursDetails.leadershipText)
    }

  private def enterMakingEffectiveDecisions(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Making Effective Decisions")) {
      enterDetails(makingEffectiveDecisionsInputId, behavioursDetails.makingEffectiveDecisionsText)
    }

  private def enterManagingAQualityService(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Managing a Quality Service")) {
      enterDetails(managingAQualityServiceInputId, behavioursDetails.managingAQualityServiceText)
    }

  private def enterWorkingTogether(behavioursDetails: BehavioursDetails): Unit =
    if (listOfChosenBehaviours.contains("Working Together")) {
      enterDetails(workingTogetherInputId, behavioursDetails.workingTogetherText)
    }

  private val behaviours: Seq[BehavioursDetails => Unit] = Seq(
    enterChangingAndImproving,
    enterCommunicatingAndInfluencing,
    enterDeliveringAtPace,
    enterDevelopingSelfAndOthers,
    enterLeadership,
    enterMakingEffectiveDecisions,
    enterManagingAQualityService,
    enterWorkingTogether
  )

  def behavioursPage(longFormDetails: LongFormDetails): Unit =
    if (behavioursRequired.toBoolean) {
      confirmBehavioursRequired()
      behaviours.foreach { f =>
        f(longFormDetails.behavioursDetails)
      }
      clickOn(pageContinue)
    }
}
