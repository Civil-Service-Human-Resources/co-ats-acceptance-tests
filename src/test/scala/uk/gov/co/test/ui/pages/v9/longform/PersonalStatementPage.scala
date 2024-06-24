package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXExperiencesRequired, vXGuidanceText, vXSpecifyGuidance, vXStatementWordLimit}
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.longFormId

case class StatementDetails(
  personalStatement250Words: String,
  personalStatement500Words: String,
  personalStatement750Words: String,
  detailsRemoved: Boolean
)

object PersonalStatementPage extends CivilServiceJobsBasePage {

  private lazy val personalStatementPageTitle = "Personal statement - Civil Service Jobs - GOV.UK"
  def personalStatement250InputId             = s"${longFormId}_datafield_72097_1_1"
  def personalStatement250WordLimitId         = s"${longFormId}_datafield_72097_1_1_counter_node"
  def personalStatement500InputId             = s"${longFormId}_datafield_72117_1_1"
  def personalStatement500WordLimitId         = s"${longFormId}_datafield_72117_1_1_counter_node"
  def personalStatement750InputId             = s"${longFormId}_datafield_72158_1_1"
  def personalStatement750WordLimitId         = s"${longFormId}_datafield_72158_1_1_counter_node"
  def personalDetailsRemovedId                = s"${longFormId}_datafield_89060_1_1_15120_label"
  def guidanceTextPath                        = s".//*[@id='${longFormId}_label_75927_1']/p[5]/strong"

  private def personalStatementPageCheck(): Unit =
    eventually(onPage(personalStatementPageTitle))

  private def enterStatement(statementDetails: StatementDetails): Unit =
    vXStatementWordLimit match {
      case 250 =>
        enterDetails(personalStatement250InputId, statementDetails.personalStatement250Words)
        checkForTotalValueId(personalStatement250WordLimitId, "Maximum Word Count 250 of  250 words")
      case 500 =>
        enterDetails(personalStatement500InputId, statementDetails.personalStatement500Words)
        checkForTotalValueId(personalStatement500WordLimitId, "Maximum Word Count 500 of  500 words")
      case 750 =>
        enterDetails(personalStatement750InputId, statementDetails.personalStatement750Words)
        checkForTotalValueId(personalStatement750WordLimitId, "Maximum Word Count 750 of  750 words")
      case _   =>
        throw new IllegalStateException("The word limit inputId hasn't been set!")
    }

  private def selectDetailsRemoved(statementDetails: StatementDetails): Unit =
    if (statementDetails.detailsRemoved) radioSelect(personalDetailsRemovedId)

  private def confirmGuidanceText(): Unit =
    if (vXSpecifyGuidance) {
      val v9GuidanceText = waitForVisibilityOfElementByPath(guidanceTextPath).getText
      v9GuidanceText shouldEqual vXGuidanceText
    }

  private val statement: Seq[StatementDetails => Unit] = Seq(
    enterStatement,
    selectDetailsRemoved
  )

  def personalStatementPage(longFormDetails: LongFormDetails): Unit =
    if (vXExperiencesRequired) {
      personalStatementPageCheck()
      confirmGuidanceText()
      statement.foreach { f =>
        f(longFormDetails.statementDetails)
      }
      clickOn(pageContinue)
    }
}
