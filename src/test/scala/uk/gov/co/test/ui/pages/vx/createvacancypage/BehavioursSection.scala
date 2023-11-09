package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

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

  private lazy val behavioursId             = s"${formId}_datafield_154245_1_1_12686"
  private lazy val behavioursSectionId      = s"${formId}_section_60310_col_0"
  private lazy val howManyBehavioursId      = s"select2-${formId}_datafield_60326_1_1-container"
  private lazy val successProfilesSectionId = s"${formId}_section_154224_col_0"
  private lazy val assessBehavioursId       = s"${formId}_label_130493_1"
  private lazy val behavioursOneId          = s"select2-${formId}_datafield_60342_1_1-container"
  private lazy val behavioursTwoId          = s"select2-${formId}_datafield_60356_1_1-container"
  private lazy val behavioursThreeId        = s"select2-${formId}_datafield_60370_1_1-container"
  private lazy val behavioursFourId         = s"select2-${formId}_datafield_60384_1_1-container"
  private lazy val behavioursFiveId         = s"select2-${formId}_datafield_60398_1_1-container"
  private lazy val behavioursSixId          = s"select2-${formId}_datafield_60412_1_1-container"
  private lazy val behavioursSevenId        = s"select2-${formId}_datafield_60426_1_1-container"
  private lazy val behavioursEightId        = s"select2-${formId}_datafield_60440_1_1-container"
  private lazy val generalInput             = "//input[@class='select2-search__field']"
  private lazy val applicationOneId         = s"${formId}_datafield_60338_1_1_12683"
  private lazy val applicationTwoId         = s"${formId}_datafield_60352_1_1_12683"
  private lazy val applicationThreeId       = s"${formId}_datafield_60366_1_1_12683"
  private lazy val applicationFourId        = s"${formId}_datafield_60380_1_1_12683"
  private lazy val applicationFiveId        = s"${formId}_datafield_60394_1_1_12683"
  private lazy val applicationSixId         = s"${formId}_datafield_60408_1_1_12683"
  private lazy val applicationSevenId       = s"${formId}_datafield_60422_1_1_12683"
  private lazy val applicationEightId       = s"${formId}_datafield_60436_1_1_12683"
  private lazy val interviewOneId           = s"${formId}_datafield_60338_1_1_12684"
  private lazy val interviewTwoId           = s"${formId}_datafield_60352_1_1_12684"
  private lazy val interviewThreeId         = s"${formId}_datafield_60366_1_1_12684"
  private lazy val interviewFourId          = s"${formId}_datafield_60380_1_1_12684"
  private lazy val interviewFiveId          = s"${formId}_datafield_60394_1_1_12684"
  private lazy val interviewSixId           = s"${formId}_datafield_60408_1_1_12684"
  private lazy val interviewSevenId         = s"${formId}_datafield_60422_1_1_12684"
  private lazy val interviewEightId         = s"${formId}_datafield_60436_1_1_12684"

  def selectBehavioursProfile(successProfilesDetails: SuccessProfilesDetails): Unit = {
    scrollToElement(By.id(successProfilesSectionId))
    val behaviour = successProfilesDetails.behavioursSection
    if (successProfilesDetails.behaviours) {
      checkbox(behavioursId).select()
      getAssessSectionText(assessBehavioursId) shouldBe behaviour
        .map(_.assessBehaviours)
        .get
      selectHowManyBehaviours(behaviour.map(_.howManyAssessed).get)
      behaviour.map(_.howManyAssessed).get match {
        case 1 =>
          selectBehaviourOne(successProfilesDetails)
        case 2 =>
          selectBehaviourOne(successProfilesDetails)
          selectBehaviourTwo(successProfilesDetails)
        case 3 =>
          selectBehaviourOne(successProfilesDetails)
          selectBehaviourTwo(successProfilesDetails)
          selectBehaviourThree(successProfilesDetails)
        case 4 =>
          selectBehaviourOne(successProfilesDetails)
          selectBehaviourTwo(successProfilesDetails)
          selectBehaviourThree(successProfilesDetails)
          selectBehaviourFour(successProfilesDetails)
        case 5 =>
          selectBehaviourOne(successProfilesDetails)
          selectBehaviourTwo(successProfilesDetails)
          selectBehaviourThree(successProfilesDetails)
          selectBehaviourFour(successProfilesDetails)
          selectBehaviourFive(successProfilesDetails)
        case 6 =>
          selectBehaviourOne(successProfilesDetails)
          selectBehaviourTwo(successProfilesDetails)
          selectBehaviourThree(successProfilesDetails)
          selectBehaviourFour(successProfilesDetails)
          selectBehaviourFive(successProfilesDetails)
          selectBehaviourSix(successProfilesDetails)
        case 7 =>
          selectBehaviourOne(successProfilesDetails)
          selectBehaviourTwo(successProfilesDetails)
          selectBehaviourThree(successProfilesDetails)
          selectBehaviourFour(successProfilesDetails)
          selectBehaviourFive(successProfilesDetails)
          selectBehaviourSix(successProfilesDetails)
          selectBehaviourSeven(successProfilesDetails)
        case 8 =>
          selectBehaviourOne(successProfilesDetails)
          selectBehaviourTwo(successProfilesDetails)
          selectBehaviourThree(successProfilesDetails)
          selectBehaviourFour(successProfilesDetails)
          selectBehaviourFive(successProfilesDetails)
          selectBehaviourSix(successProfilesDetails)
          selectBehaviourSeven(successProfilesDetails)
          selectBehaviourEight(successProfilesDetails)
      }
    }
  }

  private def selectBehaviourOne(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursOneId))
    waitForVisibilityOfElementById(behavioursOneId).click()
    selectOption(generalInput, behaviour.map(_.behaviourOne.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourOne.map(_.stageApplication).get).get) checkbox(applicationOneId).select()
    if (behaviour.map(_.behaviourOne.map(_.stageInterview).get).get) checkbox(interviewOneId).select()
  }

  private def selectBehaviourTwo(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursTwoId))
    waitForVisibilityOfElementById(behavioursTwoId).click()
    selectOption(generalInput, behaviour.map(_.behaviourTwo.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourTwo.map(_.stageApplication).get).get) checkbox(applicationTwoId).select()
    if (behaviour.map(_.behaviourTwo.map(_.stageInterview).get).get) checkbox(interviewTwoId).select()
  }

  private def selectBehaviourThree(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursThreeId))
    waitForVisibilityOfElementById(behavioursThreeId).click()
    selectOption(generalInput, behaviour.map(_.behaviourThree.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourThree.map(_.stageApplication).get).get) checkbox(applicationThreeId).select()
    if (behaviour.map(_.behaviourThree.map(_.stageInterview).get).get) checkbox(interviewThreeId).select()
  }

  private def selectBehaviourFour(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursFourId))
    waitForVisibilityOfElementById(behavioursFourId).click()
    selectOption(generalInput, behaviour.map(_.behaviourFour.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourFour.map(_.stageApplication).get).get) checkbox(applicationFourId).select()
    if (behaviour.map(_.behaviourFour.map(_.stageInterview).get).get) checkbox(interviewFourId).select()
  }

  private def selectBehaviourFive(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursFiveId))
    waitForVisibilityOfElementById(behavioursFiveId).click()
    selectOption(generalInput, behaviour.map(_.behaviourFive.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourFive.map(_.stageApplication).get).get) checkbox(applicationFiveId).select()
    if (behaviour.map(_.behaviourFive.map(_.stageInterview).get).get) checkbox(interviewFiveId).select()
  }

  private def selectBehaviourSix(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursSixId))
    waitForVisibilityOfElementById(behavioursSixId).click()
    selectOption(generalInput, behaviour.map(_.behaviourSix.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourSix.map(_.stageApplication).get).get) checkbox(applicationSixId).select()
    if (behaviour.map(_.behaviourSix.map(_.stageInterview).get).get) checkbox(interviewSixId).select()
  }

  private def selectBehaviourSeven(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursSevenId))
    waitForVisibilityOfElementById(behavioursSevenId).click()
    selectOption(generalInput, behaviour.map(_.behaviourSeven.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourSeven.map(_.stageApplication).get).get) checkbox(applicationSevenId).select()
    if (behaviour.map(_.behaviourSeven.map(_.stageInterview).get).get) checkbox(interviewSevenId).select()
  }

  private def selectBehaviourEight(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val behaviour = successProfilesDetails.behavioursSection
    scrollToElement(By.id(behavioursEightId))
    waitForVisibilityOfElementById(behavioursEightId).click()
    selectOption(generalInput, behaviour.map(_.behaviourEight.map(_.chosenBehaviour).get).get)
    if (behaviour.map(_.behaviourEight.map(_.stageApplication).get).get) checkbox(applicationEightId).select()
    if (behaviour.map(_.behaviourEight.map(_.stageInterview).get).get) checkbox(interviewEightId).select()
  }

  private def selectHowManyBehaviours(howMany: Int): Unit = {
    scrollToElement(By.id(behavioursSectionId))
    waitForVisibilityOfElementById(howManyBehavioursId).click()
    selectOption(generalInput, howMany.toString)
  }
}
