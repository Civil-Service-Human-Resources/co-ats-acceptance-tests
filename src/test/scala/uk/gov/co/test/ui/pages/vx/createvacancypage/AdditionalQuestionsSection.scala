package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAnyAdditionalQuestions, vXHowManyQuestions, vXProfile, vXQuestionOne, vXQuestionThree, vXQuestionTwo, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class AdditionalQuestionsDetails(
  anyAdditionalQuestions: Option[Boolean] = None,
  howManyQuestions: Int,
  questionOne: String,
  questionTwo: String,
  questionThree: String
)

object AdditionalQuestionsSection extends VacancyBasePage {

  def moreQuestionsSectionId   = s"${vacancyFormId}_section_56149_col_0"
  def additionalQuestionsYesId = s"${vacancyFormId}_datafield_56152_1_1_1"
  def additionalQuestionsNoId  = s"${vacancyFormId}_datafield_56152_1_1_2"
  def oneQuestionId            = s"${vacancyFormId}_datafield_56156_1_1_14804"
  def twoQuestionId            = s"${vacancyFormId}_datafield_56156_1_1_14805"
  def threeQuestionId          = s"${vacancyFormId}_datafield_56156_1_1_14806"
  def questionOneInput         = s"${vacancyFormId}_datafield_56159_1_1_en-GB"
  def questionTwoInput         = s"${vacancyFormId}_datafield_56165_1_1_en-GB"
  def questionThreeInput       = s"${vacancyFormId}_datafield_56171_1_1_en-GB"

  private def selectMoreQuestions(additionalQuestionsDetails: AdditionalQuestionsDetails): Unit = {
    scrollToElement(By.id(moreQuestionsSectionId))
    vXAnyAdditionalQuestions = Some(additionalQuestionsDetails.anyAdditionalQuestions).get
    if (vXAnyAdditionalQuestions.get) {
      clickOnRadioButton(additionalQuestionsYesId)
    } else if (!vXAnyAdditionalQuestions.get) {
      clickOnRadioButton(additionalQuestionsNoId)
    } else {
      println("Additional questions section not answered!")
      vXAnyAdditionalQuestions = Some(None.get)
    }
  }

  private def selectHowManyQuestions(additionalQuestionsDetails: AdditionalQuestionsDetails): Unit = {
    vXHowManyQuestions = additionalQuestionsDetails.howManyQuestions
    vXHowManyQuestions match {
      case 1 =>
        clickOnRadioButton(oneQuestionId)
        questionTextFlow(additionalQuestionsDetails, 1)
      case 2 =>
        clickOnRadioButton(twoQuestionId)
        questionTextFlow(additionalQuestionsDetails, 2)
      case 3 =>
        clickOnRadioButton(threeQuestionId)
        questionTextFlow(additionalQuestionsDetails, 3)
    }
  }

  private def moreQuestionsFlow(additionalQuestionsDetails: AdditionalQuestionsDetails): Unit = {
    vXAnyAdditionalQuestions = Some(false)
    vXHowManyQuestions = 0
    vXQuestionOne = ""
    vXQuestionTwo = ""
    vXQuestionThree = ""
    if (vXProfile != "Vacancy Holder 1") {
      selectMoreQuestions(additionalQuestionsDetails)
      if (vXAnyAdditionalQuestions.get) {
        selectHowManyQuestions(additionalQuestionsDetails)
      }
    }
  }

  private def questionOneText(additionalQuestionsDetails: AdditionalQuestionsDetails): Unit = {
    vXQuestionOne = additionalQuestionsDetails.questionOne
    clickOnRadioButton(oneQuestionId)
    selectOptionWithId(questionOneInput, vXQuestionOne)
  }

  private def questionTwoText(additionalQuestionsDetails: AdditionalQuestionsDetails): Unit = {
    vXQuestionTwo = additionalQuestionsDetails.questionTwo
    clickOnRadioButton(twoQuestionId)
    selectOptionWithId(questionTwoInput, vXQuestionTwo)
  }

  private def questionThreeText(additionalQuestionsDetails: AdditionalQuestionsDetails): Unit = {
    vXQuestionThree = additionalQuestionsDetails.questionThree
    clickOnRadioButton(threeQuestionId)
    selectOptionWithId(questionThreeInput, vXQuestionThree)
  }

  private val questionText: Seq[AdditionalQuestionsDetails => Unit] = Seq(
    questionOneText,
    questionTwoText,
    questionThreeText
  )

  private def questionTextFlow(additionalQuestionsDetails: AdditionalQuestionsDetails, take: Int): Unit =
    questionText.take(take).foreach { f =>
      f(additionalQuestionsDetails)
    }

  private val questions: Seq[AdditionalQuestionsDetails => Unit] = Seq(
    moreQuestionsFlow
  )

  def additionalQuestionsSection(newVacancyDetails: NewVacancyDetails): Unit = {
    questions.foreach { f =>
      f(newVacancyDetails.additionalQuestionsDetails)
    }
  }

}
