package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class MoreQuestionsDetails(
  additionalQuestions: Boolean,
  howMany: Int,
  questionOne: String,
  questionTwo: String,
  questionThree: String
)

object MoreQuestionsSection extends VacancyBasePage {

  private lazy val moreQuestionsSectionId   = s"${formId}_section_56149_col_0"
  private lazy val additionalQuestionsYesId = s"${formId}_datafield_56152_1_1_1"
  private lazy val additionalQuestionsNoId  = s"${formId}_datafield_56152_1_1_2"
  private lazy val oneQuestionId            = s"${formId}_datafield_56156_1_1_14804"
  private lazy val twoQuestionId            = s"${formId}_datafield_56156_1_1_14805"
  private lazy val threeQuestionId          = s"${formId}_datafield_56156_1_1_14806"
  private lazy val questionOneInput         = s"${formId}_datafield_56159_1_1_en-GB"
  private lazy val questionTwoInput         = s"${formId}_datafield_56165_1_1_en-GB"
  private lazy val questionThreeInput       = s"${formId}_datafield_56171_1_1_en-GB"

  private def selectMoreQuestions(moreQuestionsDetails: MoreQuestionsDetails): Unit = {
    scrollToElement(By.id(moreQuestionsSectionId))
    if (moreQuestionsDetails.additionalQuestions) clickOnRadioButton(additionalQuestionsYesId)
    else clickOnRadioButton(additionalQuestionsNoId)
  }

  private def selectHowManyQuestions(moreQuestionsDetails: MoreQuestionsDetails): Unit =
    moreQuestionsDetails.howMany match {
      case 1 =>
        clickOnRadioButton(oneQuestionId)
        questionTextFlow(moreQuestionsDetails, 1)
      case 2 =>
        clickOnRadioButton(twoQuestionId)
        questionTextFlow(moreQuestionsDetails, 2)
      case 3 =>
        clickOnRadioButton(threeQuestionId)
        questionTextFlow(moreQuestionsDetails, 3)
    }

  private def moreQuestionsFlow(moreQuestionsDetails: MoreQuestionsDetails): Unit = {
    selectMoreQuestions(moreQuestionsDetails)
    if (moreQuestionsDetails.additionalQuestions) {
      selectHowManyQuestions(moreQuestionsDetails)
    }
  }

  private def questionOneText(moreQuestionsDetails: MoreQuestionsDetails): Unit =
    selectOptionWithId(questionOneInput, moreQuestionsDetails.questionOne)

  private def questionTwoText(moreQuestionsDetails: MoreQuestionsDetails): Unit =
    selectOptionWithId(questionTwoInput, moreQuestionsDetails.questionTwo)

  private def questionThreeText(moreQuestionsDetails: MoreQuestionsDetails): Unit =
    selectOptionWithId(questionThreeInput, moreQuestionsDetails.questionThree)

  private val questionText: Seq[MoreQuestionsDetails => Unit] = Seq(
    questionOneText,
    questionTwoText,
    questionThreeText
  )

  private def questionTextFlow(moreQuestionsDetails: MoreQuestionsDetails, take: Int): Unit =
    questionText.take(take).foreach { f =>
      f(moreQuestionsDetails)
    }

  private val questions: Seq[MoreQuestionsDetails => Unit] = Seq(
    moreQuestionsFlow
  )

  def additionalQuestionsSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    questions.foreach { f =>
      f(newVacancyDetails.moreQuestionsDetails)
    }

}