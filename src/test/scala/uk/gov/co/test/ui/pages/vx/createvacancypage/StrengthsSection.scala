package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXHowManyStrengths, vXListOfStrengths, vacancyFormId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class StrengthsDetails(
  strengthsAssessed: Int,
  strengthOne: String,
  strengthTwo: String,
  strengthThree: String,
  strengthFour: String,
  strengthFive: String,
  strengthSix: String,
  strengthSeven: String,
  strengthEight: String
)

object StrengthsSection extends VacancyBasePage {

  def strengthsSectionId      = s"${vacancyFormId}_section_52615_col_0"
  def noOfStrengthsAssessedId = s"select2-${vacancyFormId}_datafield_117504_1_1-container"
  def strengthOneId           = s"select2-${vacancyFormId}_datafield_117508_1_1-container"
  def strengthTwoId           = s"select2-${vacancyFormId}_datafield_117512_1_1-container"
  def strengthThreeId         = s"select2-${vacancyFormId}_datafield_117516_1_1-container"
  def strengthFourId          = s"select2-${vacancyFormId}_datafield_117520_1_1-container"
  def strengthFiveId          = s"select2-${vacancyFormId}_datafield_117524_1_1-container"
  def strengthSixId           = s"select2-${vacancyFormId}_datafield_117528_1_1-container"
  def strengthSevenId         = s"select2-${vacancyFormId}_datafield_117532_1_1-container"
  def strengthEightId         = s"select2-${vacancyFormId}_datafield_117536_1_1-container"

  private def selectStrengthsRequired(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strengths = successProfilesDetails.strengthsSection
    vXHowManyStrengths = strengths.map(_.strengthsAssessed).get
    waitForVisibilityOfElementById(noOfStrengthsAssessedId).click()
    selectOption(generalInput, vXHowManyStrengths.toString)
  }

  private def selectStrengthOne(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength    = successProfilesDetails.strengthsSection
    val strengthOne = strength.map(_.strengthOne).get
    waitForVisibilityOfElementById(strengthOneId).click()
    selectOption(generalInput, strengthOne)
    vXListOfStrengths += strengthOne
  }

  private def selectStrengthTwo(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength    = successProfilesDetails.strengthsSection
    val strengthTwo = strength.map(_.strengthTwo).get
    waitForVisibilityOfElementById(strengthTwoId).click()
    selectOption(generalInput, strengthTwo)
    vXListOfStrengths += strengthTwo
  }

  private def selectStrengthThree(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength      = successProfilesDetails.strengthsSection
    val strengthThree = strength.map(_.strengthThree).get
    waitForVisibilityOfElementById(strengthThreeId).click()
    selectOption(generalInput, strengthThree)
    vXListOfStrengths += strengthThree
  }

  private def selectStrengthFour(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength     = successProfilesDetails.strengthsSection
    val strengthFour = strength.map(_.strengthFour).get
    waitForVisibilityOfElementById(strengthFourId).click()
    selectOption(generalInput, strengthFour)
    vXListOfStrengths += strengthFour
  }

  private def selectStrengthFive(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength     = successProfilesDetails.strengthsSection
    val strengthFive = strength.map(_.strengthFive).get
    waitForVisibilityOfElementById(strengthFiveId).click()
    selectOption(generalInput, strengthFive)
    vXListOfStrengths += strengthFive
  }

  private def selectStrengthSix(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength    = successProfilesDetails.strengthsSection
    val strengthSix = strength.map(_.strengthSix).get
    waitForVisibilityOfElementById(strengthSixId).click()
    selectOption(generalInput, strengthSix)
    vXListOfStrengths += strengthSix
  }

  private def selectStrengthSeven(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength      = successProfilesDetails.strengthsSection
    val strengthSeven = strength.map(_.strengthSeven).get
    waitForVisibilityOfElementById(strengthSevenId).click()
    selectOption(generalInput, strengthSeven)
    vXListOfStrengths += strengthSeven
  }

  private def selectStrengthEight(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength      = successProfilesDetails.strengthsSection
    val strengthEight = strength.map(_.strengthEight).get
    waitForVisibilityOfElementById(strengthEightId).click()
    selectOption(generalInput, strengthEight)
    vXListOfStrengths += strengthEight
  }

  private val strengths: Seq[SuccessProfilesDetails => Unit] = Seq(
    selectStrengthOne,
    selectStrengthTwo,
    selectStrengthThree,
    selectStrengthFour,
    selectStrengthFive,
    selectStrengthSix,
    selectStrengthSeven,
    selectStrengthEight
  )

  def selectStrengths(successProfilesDetails: SuccessProfilesDetails): Unit = {
    scrollToElement(By.id(strengthsSectionId))
    selectStrengthsRequired(successProfilesDetails)
    strengths.take(vXHowManyStrengths).foreach { f =>
      f(successProfilesDetails)
    }
  }
}
