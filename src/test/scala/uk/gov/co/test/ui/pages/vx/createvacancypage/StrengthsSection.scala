package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.vacancyFormId
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

  def selectStrengthsAssessed(successProfilesDetails: SuccessProfilesDetails): Unit = {
    scrollToElement(By.id(strengthsSectionId))
    val strength = successProfilesDetails.strengthsSection
    selectStrengthsRequired(successProfilesDetails)
    strength.map(_.strengthsAssessed).get match {
      case 1 => strengthsRequired(successProfilesDetails, 1)
      case 2 => strengthsRequired(successProfilesDetails, 2)
      case 3 => strengthsRequired(successProfilesDetails, 3)
      case 4 => strengthsRequired(successProfilesDetails, 4)
      case 5 => strengthsRequired(successProfilesDetails, 5)
      case 6 => strengthsRequired(successProfilesDetails, 6)
      case 7 => strengthsRequired(successProfilesDetails, 7)
      case 8 => strengthsRequired(successProfilesDetails, 8)
    }
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

  private def strengthsRequired(successProfilesDetails: SuccessProfilesDetails, strengthRequired: Int): Unit =
    strengths.take(strengthRequired).foreach { f =>
      f(successProfilesDetails)
    }
}
