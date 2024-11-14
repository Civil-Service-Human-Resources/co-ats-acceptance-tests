package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXPecPreviousCivilEmploymentCheck, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

import java.time.LocalDate

case class PreviousCSEmploymentDetails(
  previousCSEmployment: Boolean,
  everDismissedFromCS: Boolean,
  dismissalDate: LocalDate,
  deptDismissedFrom: String,
  reasonForDismissal: String,
  dismissalDetails: Option[String] = None
)

object PreviousCSEmploymentPage extends CivilServiceJobsBasePage {

  private lazy val previousCSEmploymentPageTitle = "Previous Civil Service employment - Civil Service Jobs - GOV.UK"
  def previousCSEmploymentYesId                  = s"${pecFormId}_datafield_81036_1_1_1_label"
  def previousCSEmploymentNoId                   = s"${pecFormId}_datafield_81036_1_1_2_label"
  def everDismissedFromCSYesId                   = s"${pecFormId}_datafield_81040_1_1_1_label"
  def everDismissedFromCSNoId                    = s"${pecFormId}_datafield_81040_1_1_2_label"
  def dismissalDateDayId                         = s"${pecFormId}_datafield_81044_1_1--DAY"
  def dismissalDateMonthId                       = s"${pecFormId}_datafield_81044_1_1--MONTH"
  def dismissalDateYearId                        = s"${pecFormId}_datafield_81044_1_1--YEAR"
  def deptDismissedFromId                        = s"${pecFormId}_datafield_81048_1_1"
  def reasonForDismissalId                       = s"${pecFormId}_datafield_81055_1_1"
  def dismissalDetailsId                         = s"${pecFormId}_datafield_81062_1_1"

  private def previousCSEmploymentPageCheck(): Unit =
    eventually(onPage(previousCSEmploymentPageTitle))

  private def selectPreviousCSEmployment(previousCSEmploymentDetails: PreviousCSEmploymentDetails): Unit =
    if (previousCSEmploymentDetails.previousCSEmployment) {
      radioSelect(previousCSEmploymentYesId)
      selectEverDismissedFromCS(previousCSEmploymentDetails)
    } else {
      radioSelect(previousCSEmploymentNoId)
    }

  private def selectEverDismissedFromCS(previousCSEmploymentDetails: PreviousCSEmploymentDetails): Unit =
    if (previousCSEmploymentDetails.everDismissedFromCS) {
      radioSelect(everDismissedFromCSYesId)
      enterDismissalDate(previousCSEmploymentDetails)
      enterDetails(deptDismissedFromId, previousCSEmploymentDetails.deptDismissedFrom)
      enterDetails(reasonForDismissalId, previousCSEmploymentDetails.reasonForDismissal)
      enterDetails(dismissalDetailsId, previousCSEmploymentDetails.dismissalDetails.get)
    } else {
      radioSelect(everDismissedFromCSNoId)
    }

  private def enterDismissalDate(previousCSEmploymentDetails: PreviousCSEmploymentDetails): Unit =
    enterStartOrEndDate(
      formattedDate(previousCSEmploymentDetails.dismissalDate),
      dismissalDateDayId,
      dismissalDateMonthId,
      dismissalDateYearId
    )

  private val previousCSEmployment: Seq[PreviousCSEmploymentDetails => Unit] = Seq(
    selectPreviousCSEmployment
  )

  def previousCSEmploymentPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecPreviousCivilEmploymentCheck.contains("Not Applicable") &&
      vXPecPreviousCivilEmploymentCheck.contains(s"$vXTypeOfCandidate Candidates")
    ) {
      previousCSEmploymentPageCheck()
      previousCSEmployment.foreach { f =>
        f(pecFormDetails.previousCSEmploymentDetails)
      }
      clickOn(pageContinue)
    }
}
