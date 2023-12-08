package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXAnyAdditionalQuestions, vXHowManyQuestions, vXQuestionOne, vXQuestionThree, vXQuestionTwo}

case class RoleQuestionsDetails(
  roleSpecificAnswerOne: String,
  roleSpecificAnswerTwo: String,
  roleSpecificAnswerThree: String
)

object RoleSpecificQuestionsPage extends CivilServiceJobsBasePage {

  private lazy val roleSpecificQuestionPageTitle = "Role specific questions - Civil Service Jobs - GOV.UK"
  def v9QuestionOnePath                          = s".//*[@id='${formId}_field_que_82664_1']/span[1]"
  def v9QuestionTwoPath                          = s".//*[@id='${formId}_field_que_82671_1']/span[1]"
  def v9QuestionThreePath                        = s".//*[@id='${formId}_field_que_82678_1']/span[1]"
  def answerOneInputId                           = s"${formId}_datafield_82664_1_1"
  def answerTwoInputId                           = s"${formId}_datafield_82671_1_1"
  def answerThreeInputId                         = s"${formId}_datafield_82678_1_1"

  private def roleQuestionsPageCheck(): Unit =
    eventually(onPage(roleSpecificQuestionPageTitle))

  private def enterAnswerOne(roleQuestionsDetails: RoleQuestionsDetails): Unit = {
    val answerOne = waitForVisibilityOfElementByPath(v9QuestionOnePath).getText
    answerOne shouldEqual vXQuestionOne
    enterDetails(answerOneInputId, roleQuestionsDetails.roleSpecificAnswerOne)
  }

  private def enterAnswerTwo(roleQuestionsDetails: RoleQuestionsDetails): Unit = {
    val answerTwo = waitForVisibilityOfElementByPath(v9QuestionTwoPath).getText
    answerTwo shouldEqual vXQuestionTwo
    enterDetails(answerTwoInputId, roleQuestionsDetails.roleSpecificAnswerTwo)
  }

  private def enterAnswerThree(roleQuestionsDetails: RoleQuestionsDetails): Unit = {
    val answerThree = waitForVisibilityOfElementByPath(v9QuestionThreePath).getText
    answerThree shouldEqual vXQuestionThree
    enterDetails(answerThreeInputId, roleQuestionsDetails.roleSpecificAnswerThree)
  }

  private val questions: Seq[RoleQuestionsDetails => Unit] = Seq(
    enterAnswerOne,
    enterAnswerTwo,
    enterAnswerThree
  )

  def roleQuestionsPage(longFormDetails: LongFormDetails): Unit =
    if (vXAnyAdditionalQuestions) {
      roleQuestionsPageCheck()
      questions.take(vXHowManyQuestions).foreach { f =>
        f(longFormDetails.roleQuestionsDetails)
      }
      clickOn(pageContinue)
    }
}
