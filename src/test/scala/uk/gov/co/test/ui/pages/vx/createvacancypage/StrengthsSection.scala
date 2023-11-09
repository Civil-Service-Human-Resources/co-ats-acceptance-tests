package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

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

  private lazy val strengthsSectionId      = s"${formId}_section_52615_col_0"
  private lazy val noOfStrengthsAssessedId = s"select2-${formId}_datafield_117504_1_1-container"
  private lazy val strengthOneId           = s"select2-${formId}_datafield_117508_1_1-container"
  private lazy val strengthTwoId           = s"select2-${formId}_datafield_117512_1_1-container"
  private lazy val strengthThreeId         = s"select2-${formId}_datafield_117516_1_1-container"
  private lazy val strengthFourId          = s"select2-${formId}_datafield_117520_1_1-container"
  private lazy val strengthFiveId          = s"select2-${formId}_datafield_117524_1_1-container"
  private lazy val strengthSixId           = s"select2-${formId}_datafield_117528_1_1-container"
  private lazy val strengthSevenId         = s"select2-${formId}_datafield_117532_1_1-container"
  private lazy val strengthEightId         = s"select2-${formId}_datafield_117536_1_1-container"

  private def selectStrengthsAssessed(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strengths = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(noOfStrengthsAssessedId).click()
    selectOption(generalInput, strengths.map(_.strengthsAssessed).get.toString)
  }

  private def selectStrengthOne(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthOneId).click()
    selectOption(generalInput, strength.map(_.strengthOne).get)
  }

  private def selectStrengthTwo(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthTwoId).click()
    selectOption(generalInput, strength.map(_.strengthTwo).get)
  }

  private def selectStrengthThree(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthThreeId).click()
    selectOption(generalInput, strength.map(_.strengthThree).get)
  }

  private def selectStrengthFour(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthFourId).click()
    selectOption(generalInput, strength.map(_.strengthFour).get)
  }

  private def selectStrengthFive(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthFiveId).click()
    selectOption(generalInput, strength.map(_.strengthFive).get)
  }

  private def selectStrengthSix(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthSixId).click()
    selectOption(generalInput, strength.map(_.strengthSix).get)
  }

  private def selectStrengthSeven(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthSevenId).click()
    selectOption(generalInput, strength.map(_.strengthSeven).get)
  }

  private def selectStrengthEight(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val strength = successProfilesDetails.strengthsSection
    waitForVisibilityOfElementById(strengthEightId).click()
    selectOption(generalInput, strength.map(_.strengthEight).get)
  }

  private def selectStrengths(successProfilesDetails: SuccessProfilesDetails): Unit = {
    scrollToElement(By.id(strengthsSectionId))
    val strength = successProfilesDetails.strengthsSection
    selectStrengthsAssessed(successProfilesDetails)
    strength.map(_.strengthsAssessed).get match {
      case 1 =>
        selectStrengthOne(successProfilesDetails)
      case 2 =>
        selectStrengthOne(successProfilesDetails)
        selectStrengthTwo(successProfilesDetails)
      case 3 =>
        selectStrengthOne(successProfilesDetails)
        selectStrengthTwo(successProfilesDetails)
        selectStrengthThree(successProfilesDetails)
      case 4 =>
        selectStrengthOne(successProfilesDetails)
        selectStrengthTwo(successProfilesDetails)
        selectStrengthThree(successProfilesDetails)
        selectStrengthFour(successProfilesDetails)
      case 5 =>
        selectStrengthOne(successProfilesDetails)
        selectStrengthTwo(successProfilesDetails)
        selectStrengthThree(successProfilesDetails)
        selectStrengthFour(successProfilesDetails)
        selectStrengthFive(successProfilesDetails)
      case 6 =>
        selectStrengthOne(successProfilesDetails)
        selectStrengthTwo(successProfilesDetails)
        selectStrengthThree(successProfilesDetails)
        selectStrengthFour(successProfilesDetails)
        selectStrengthFive(successProfilesDetails)
        selectStrengthSix(successProfilesDetails)
      case 7 =>
        selectStrengthOne(successProfilesDetails)
        selectStrengthTwo(successProfilesDetails)
        selectStrengthThree(successProfilesDetails)
        selectStrengthFour(successProfilesDetails)
        selectStrengthFive(successProfilesDetails)
        selectStrengthSix(successProfilesDetails)
        selectStrengthSeven(successProfilesDetails)
      case 8 =>
        selectStrengthOne(successProfilesDetails)
        selectStrengthTwo(successProfilesDetails)
        selectStrengthThree(successProfilesDetails)
        selectStrengthFour(successProfilesDetails)
        selectStrengthFive(successProfilesDetails)
        selectStrengthSix(successProfilesDetails)
        selectStrengthSeven(successProfilesDetails)
        selectStrengthEight(successProfilesDetails)
    }
  }

  private val strengths: Seq[SuccessProfilesDetails => Unit] = Seq(
    selectStrengths
  )

  def strengthsSection(successProfilesDetails: SuccessProfilesDetails): Unit =
    strengths.foreach { f =>
      f(successProfilesDetails)
    }
}
