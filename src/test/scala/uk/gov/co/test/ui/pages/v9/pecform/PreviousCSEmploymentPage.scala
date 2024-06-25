package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecPreviousCivilEmploymentCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class PreviousCSEmploymentDetails(
  previousCSEmployment: Boolean
)

object PreviousCSEmploymentPage extends CivilServiceJobsBasePage {

  private lazy val previousCSEmploymentPageTitle = "Previous Civil Service Employment - Civil Service Jobs - GOV.UK"
  def previousCSEmploymentYesId                  = s"${pecFormId}_datafield_81036_1_1_1_label"
  def previousCSEmploymentNoId                   = s"${pecFormId}_datafield_81036_1_1_2_label"

  private def previousCSEmploymentPageCheck(): Unit =
    eventually(onPage(previousCSEmploymentPageTitle))

  private def selectPreviousCSEmployment(previousCSEmploymentDetails: PreviousCSEmploymentDetails): Unit =
    if (previousCSEmploymentDetails.previousCSEmployment) {
      radioSelect(previousCSEmploymentYesId)
    } else {
      radioSelect(previousCSEmploymentNoId)
    }

  private val previousCSEmployment: Seq[PreviousCSEmploymentDetails => Unit] = Seq(
    selectPreviousCSEmployment
  )

  def previousCSEmploymentPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecPreviousCivilEmploymentCheck.contains("Not Applicable") &&
      vXPecPreviousCivilEmploymentCheck.contains(s"$vXApproach Candidates")
    ) {
      previousCSEmploymentPageCheck()
      previousCSEmployment.foreach { f =>
        f(pecFormDetails.previousCSEmploymentDetails)
      }
      clickOn(pageContinue)
    }
}
