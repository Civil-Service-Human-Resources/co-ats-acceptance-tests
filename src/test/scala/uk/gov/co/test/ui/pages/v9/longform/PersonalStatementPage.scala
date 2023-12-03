package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.pages.vx.createvacancypage.ExperienceSection.vXGuidanceText

case class StatementDetails(
  personalStatement: String,
  detailsRemoved: Boolean
)

object PersonalStatementPage extends CivilServiceJobsBasePage {

  private lazy val personalStatementPageTitle = "Personal statement - Civil Service Jobs - GOV.UK"
  def personalStatementInputId                = s"${formId}_datafield_72097_1_1"
  def personalDetailsRemovedId                = s"${formId}_datafield_89060_1_1_15120_label"
  def guidanceTextPath                        = s".//*[@id='${formId}_label_75927_1']/p[5]/strong"

  private def personalStatementPageCheck(): Unit =
    eventually(onPage(personalStatementPageTitle))

  private def enterStatement(statementDetails: StatementDetails): Unit =
    enterDetails(personalStatementInputId, statementDetails.personalStatement)

  private def selectDetailsRemoved(statementDetails: StatementDetails): Unit =
    if (statementDetails.detailsRemoved) radioSelect(personalDetailsRemovedId)

  private def confirmGuidanceText(): Unit = {
    val v9GuidanceText = waitForVisibilityOfElementByPath(guidanceTextPath).getText
    v9GuidanceText shouldEqual vXGuidanceText
//    v9GuidanceText shouldEqual "Autotest - Enter guidance text for the candidate" // TODO remove
  }

  private val statement: Seq[StatementDetails => Unit] = Seq(
    enterStatement,
    selectDetailsRemoved
  )

  def personalStatementPage(longFormDetails: LongFormDetails): Unit = {
    personalStatementPageCheck()
    confirmGuidanceText()
    statement.foreach { f =>
      f(longFormDetails.statementDetails)
    }
    clickOn(pageContinue)
  }
}
