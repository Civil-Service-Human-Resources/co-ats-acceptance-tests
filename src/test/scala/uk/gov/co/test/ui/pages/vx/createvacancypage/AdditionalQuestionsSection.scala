package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class AdditionalQuestionsDetails(
  anyAdditionalQuestions: Boolean,
  howManyQuestions: Int,
  questionOne: String,
  questionTwo: String,
  questionThree: String
)

object AdditionalQuestionsSection extends VacancyBasePage {

  def moreQuestionsSectionId   = s"${formId}_section_56149_col_0"
  def additionalQuestionsYesId = s"${formId}_datafield_56152_1_1_1"
  def additionalQuestionsNoId  = s"${formId}_datafield_56152_1_1_2"
  def oneQuestionId            = s"${formId}_datafield_56156_1_1_14804"
  def twoQuestionId            = s"${formId}_datafield_56156_1_1_14805"
  def threeQuestionId          = s"${formId}_datafield_56156_1_1_14806"
  def questionOneInput         = s"${formId}_datafield_56159_1_1_en-GB"
  def questionTwoInput         = s"${formId}_datafield_56165_1_1_en-GB"
  def questionThreeInput       = s"${formId}_datafield_56171_1_1_en-GB"
  var vXAnyAdditionalQuestions = true
  var vXHowManyQuestions       = 3
  var vXQuestionOne            = "Autotest - Question 1"
  var vXQuestionTwo            = "Autotest - Question 2"
  var vXQuestionThree          = "Autotest - Question 3"

  private def selectMoreQuestions(additionalQuestionsDetails: AdditionalQuestionsDetails): Unit = {
    scrollToElement(By.id(moreQuestionsSectionId))
    vXAnyAdditionalQuestions = additionalQuestionsDetails.anyAdditionalQuestions
    if (vXAnyAdditionalQuestions) clickOnRadioButton(additionalQuestionsYesId)
    else clickOnRadioButton(additionalQuestionsNoId)
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
    selectMoreQuestions(additionalQuestionsDetails)
    if (additionalQuestionsDetails.anyAdditionalQuestions) {
      selectHowManyQuestions(additionalQuestionsDetails)
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

  def additionalQuestionsSection(newVacancyDetails: NewVacancyDetails): Unit =
    questions.foreach { f =>
      f(newVacancyDetails.additionalQuestionsDetails)
    }

}
