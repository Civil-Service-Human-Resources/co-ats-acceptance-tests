package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXBehaviourApplicationRequired, vXBehaviourInterviewRequired, vXHowManyBehaviours, vXListOfChosenBehaviours, vacancyFormId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class Behaviours(chosenBehaviour: String, stageApplication: Boolean, stageInterview: Boolean)

case class BehavioursDetails(
  assessBehaviours: String,
  howManyAssessed: Int,
  behaviourOne: Option[Behaviours] = None,
  behaviourTwo: Option[Behaviours] = None,
  behaviourThree: Option[Behaviours] = None,
  behaviourFour: Option[Behaviours] = None,
  behaviourFive: Option[Behaviours] = None,
  behaviourSix: Option[Behaviours] = None,
  behaviourSeven: Option[Behaviours] = None,
  behaviourEight: Option[Behaviours] = None
)

object BehavioursSection extends VacancyBasePage {

  def behavioursId             = s"${vacancyFormId}_datafield_154245_1_1_12686"
  def behavioursSectionId      = s"${vacancyFormId}_section_60310_col_0"
  def howManyBehavioursId      = s"select2-${vacancyFormId}_datafield_60326_1_1-container"
  def successProfilesSectionId = s"${vacancyFormId}_section_154224_col_0"
  def assessBehavioursId       = s"${vacancyFormId}_label_130493_1"
  def behavioursOneId          = s"select2-${vacancyFormId}_datafield_60342_1_1-container"
  def behavioursTwoId          = s"select2-${vacancyFormId}_datafield_60356_1_1-container"
  def behavioursThreeId        = s"select2-${vacancyFormId}_datafield_60370_1_1-container"
  def behavioursFourId         = s"select2-${vacancyFormId}_datafield_60384_1_1-container"
  def behavioursFiveId         = s"select2-${vacancyFormId}_datafield_60398_1_1-container"
  def behavioursSixId          = s"select2-${vacancyFormId}_datafield_60412_1_1-container"
  def behavioursSevenId        = s"select2-${vacancyFormId}_datafield_60426_1_1-container"
  def behavioursEightId        = s"select2-${vacancyFormId}_datafield_60440_1_1-container"
  def applicationOneId         = s"${vacancyFormId}_datafield_60338_1_1_12683"
  def applicationTwoId         = s"${vacancyFormId}_datafield_60352_1_1_12683"
  def applicationThreeId       = s"${vacancyFormId}_datafield_60366_1_1_12683"
  def applicationFourId        = s"${vacancyFormId}_datafield_60380_1_1_12683"
  def applicationFiveId        = s"${vacancyFormId}_datafield_60394_1_1_12683"
  def applicationSixId         = s"${vacancyFormId}_datafield_60408_1_1_12683"
  def applicationSevenId       = s"${vacancyFormId}_datafield_60422_1_1_12683"
  def applicationEightId       = s"${vacancyFormId}_datafield_60436_1_1_12683"
  def interviewOneId           = s"${vacancyFormId}_datafield_60338_1_1_12684"
  def interviewTwoId           = s"${vacancyFormId}_datafield_60352_1_1_12684"
  def interviewThreeId         = s"${vacancyFormId}_datafield_60366_1_1_12684"
  def interviewFourId          = s"${vacancyFormId}_datafield_60380_1_1_12684"
  def interviewFiveId          = s"${vacancyFormId}_datafield_60394_1_1_12684"
  def interviewSixId           = s"${vacancyFormId}_datafield_60408_1_1_12684"
  def interviewSevenId         = s"${vacancyFormId}_datafield_60422_1_1_12684"
  def interviewEightId         = s"${vacancyFormId}_datafield_60436_1_1_12684"

  def selectBehaviours(successProfilesDetails: SuccessProfilesDetails): Unit = {
    scrollToElement(By.id(successProfilesSectionId))
    val behaviour = successProfilesDetails.behavioursSection
    if (successProfilesDetails.behaviours) {
      checkbox(behavioursId).select()
      getAssessSectionText(assessBehavioursId) shouldBe behaviour
        .map(_.assessBehaviours)
        .get
      vXHowManyBehaviours = behaviour.map(_.howManyAssessed).get
      selectHowManyBehaviours(vXHowManyBehaviours)
      vXHowManyBehaviours match {
        case 1 => behavioursSection(successProfilesDetails, 1)
        case 2 => behavioursSection(successProfilesDetails, 2)
        case 3 => behavioursSection(successProfilesDetails, 3)
        case 4 => behavioursSection(successProfilesDetails, 4)
        case 5 => behavioursSection(successProfilesDetails, 5)
        case 6 => behavioursSection(successProfilesDetails, 6)
        case 7 => behavioursSection(successProfilesDetails, 7)
        case 8 => behavioursSection(successProfilesDetails, 8)
      }
    }
  }

  private def checkboxCheck(stageRequired: Boolean, checkId: String): Unit =
    if (!stageRequired && waitForVisibilityOfElementById(checkId).isSelected) {
      waitForVisibilityOfElementById(checkId).click()
    }

  private def selectBehaviourOne(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursOneId))
    waitForVisibilityOfElementById(behavioursOneId).click()
    val chosenBehaviour = behaviour.map(_.behaviourOne.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours.clear()
    vXBehaviourApplicationRequired.clear()
    vXBehaviourInterviewRequired.clear()
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourOne.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.headOption.get) {
      checkbox(applicationOneId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.headOption.get, applicationOneId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourOne.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.headOption.get) {
      checkbox(interviewOneId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.headOption.get, interviewOneId)
  }

  private def selectBehaviourTwo(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursTwoId))
    waitForVisibilityOfElementById(behavioursTwoId).click()
    val chosenBehaviour = behaviour.map(_.behaviourTwo.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourTwo.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.lift(1).get) {
      checkbox(applicationTwoId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.lift(1).get, applicationTwoId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourTwo.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.lift(1).get) {
      checkbox(interviewTwoId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.lift(1).get, interviewTwoId)
  }

  private def selectBehaviourThree(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursThreeId))
    waitForVisibilityOfElementById(behavioursThreeId).click()
    val chosenBehaviour = behaviour.map(_.behaviourThree.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourThree.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.lift(2).get) {
      checkbox(applicationThreeId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.lift(2).get, applicationThreeId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourThree.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.lift(2).get) {
      checkbox(interviewThreeId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.lift(2).get, interviewThreeId)
  }

  private def selectBehaviourFour(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursFourId))
    waitForVisibilityOfElementById(behavioursFourId).click()
    val chosenBehaviour = behaviour.map(_.behaviourFour.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourFour.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.lift(3).get) {
      checkbox(applicationFourId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.lift(3).get, applicationFourId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourFour.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.lift(3).get) {
      checkbox(interviewFourId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.lift(3).get, interviewFourId)
  }

  private def selectBehaviourFive(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursFiveId))
    waitForVisibilityOfElementById(behavioursFiveId).click()
    val chosenBehaviour = behaviour.map(_.behaviourFive.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourFive.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.lift(4).get) {
      checkbox(applicationFiveId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.lift(4).get, applicationFiveId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourFive.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.lift(4).get) {
      checkbox(interviewFiveId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.lift(4).get, interviewFiveId)
  }

  private def selectBehaviourSix(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursSixId))
    waitForVisibilityOfElementById(behavioursSixId).click()
    val chosenBehaviour = behaviour.map(_.behaviourSix.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourSix.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.lift(5).get) {
      checkbox(applicationSixId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.lift(5).get, applicationSixId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourSix.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.lift(5).get) {
      checkbox(interviewSixId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.lift(5).get, interviewSixId)
  }

  private def selectBehaviourSeven(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursSevenId))
    waitForVisibilityOfElementById(behavioursSevenId).click()
    val chosenBehaviour = behaviour.map(_.behaviourSeven.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourSeven.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.lift(6).get) {
      checkbox(applicationSevenId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.lift(6).get, applicationSevenId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourSeven.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.lift(6).get) {
      checkbox(interviewSevenId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.lift(6).get, interviewSevenId)
  }

  private def selectBehaviourEight(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour       = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursEightId))
    waitForVisibilityOfElementById(behavioursEightId).click()
    val chosenBehaviour = behaviour.map(_.behaviourEight.map(_.chosenBehaviour).get).get
    vXListOfChosenBehaviours += chosenBehaviour
    selectOption(generalInput, chosenBehaviour)
    vXBehaviourApplicationRequired += behaviour.map(_.behaviourEight.map(_.stageApplication).get).get
    if (vXBehaviourApplicationRequired.lift(7).get) {
      checkbox(applicationEightId).select()
    } else checkboxCheck(vXBehaviourApplicationRequired.lift(7).get, applicationEightId)
    vXBehaviourInterviewRequired += behaviour.map(_.behaviourEight.map(_.stageInterview).get).get
    if (vXBehaviourInterviewRequired.lift(7).get) {
      checkbox(interviewEightId).select()
    } else checkboxCheck(vXBehaviourInterviewRequired.lift(7).get, interviewEightId)
  }

  private def selectHowManyBehaviours(howMany: Int): Unit = {
    scrollToElement(By.id(behavioursSectionId))
    waitForVisibilityOfElementById(howManyBehavioursId).click()
    selectOption(generalInput, howMany.toString)
  }

  private val behaviours: Seq[SuccessProfilesDetails => Unit] = Seq(
    selectBehaviourOne,
    selectBehaviourTwo,
    selectBehaviourThree,
    selectBehaviourFour,
    selectBehaviourFive,
    selectBehaviourSix,
    selectBehaviourSeven,
    selectBehaviourEight
  )

  private def behavioursSection(successProfilesDetails: SuccessProfilesDetails, behavioursAssessed: Int): Unit =
    behaviours.take(behavioursAssessed).foreach { f =>
      f(successProfilesDetails)
    }
}
