package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecWorkplaceMisconductCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class MisconductDetails(
  anyClaimOfMisconduct: Boolean,
  anyClaimOfMisconductEmployerDetails: String,
  currentUnderInvestigation: Boolean,
  currentUnderInvestigationEmployerDetails: String,
  workedInUKPoliceForce: Boolean
)

object WorkplaceMisconductPage extends CivilServiceJobsBasePage {

  private lazy val workplaceMisconductPageTitle = "Workplace misconduct - Civil Service Jobs - GOV.UK"
  def anyClaimOfMisconductYesId                 = s"${pecFormId}_datafield_209790_1_1_1_label"
  def anyClaimOfMisconductNoId                  = s"${pecFormId}_datafield_209790_1_1_2_label"
  def anyClaimOfMisconductEmployerInputId       = s"${pecFormId}_datafield_209793_1_1"
  def currentUnderInvestigationYesId            = s"${pecFormId}_datafield_209799_1_1_1_label"
  def currentUnderInvestigationNoId             = s"${pecFormId}_datafield_209799_1_1_2_label"
  def currentUnderInvestigationEmployerInputId  = s"${pecFormId}_datafield_209802_1_1"
  def workedInUKPoliceForceYesId                = s"${pecFormId}_datafield_209808_1_1_1_label"
  def workedInUKPoliceForceNoId                 = s"${pecFormId}_datafield_209808_1_1_2_label"

  private def workplaceMisconductPageCheck(): Unit =
    eventually(onPage(workplaceMisconductPageTitle))

  private def selectAnyClaimOfMisconduct(misconductDetails: MisconductDetails): Unit =
    if (misconductDetails.anyClaimOfMisconduct) {
      radioSelect(anyClaimOfMisconductYesId)
      enterDetails(anyClaimOfMisconductEmployerInputId, misconductDetails.anyClaimOfMisconductEmployerDetails)
    } else {
      radioSelect(anyClaimOfMisconductNoId)
    }

  private def selectCurrentUnderInvestigation(misconductDetails: MisconductDetails): Unit =
    if (misconductDetails.currentUnderInvestigation) {
      radioSelect(currentUnderInvestigationYesId)
      enterDetails(currentUnderInvestigationEmployerInputId, misconductDetails.currentUnderInvestigationEmployerDetails)
    } else {
      radioSelect(currentUnderInvestigationNoId)
    }

  private def selectWorkedInUKPoliceForce(misconductDetails: MisconductDetails): Unit =
    if (misconductDetails.workedInUKPoliceForce) radioSelect(workedInUKPoliceForceYesId)
    else radioSelect(workedInUKPoliceForceNoId)

  private val misconduct: Seq[MisconductDetails => Unit] = Seq(
    selectAnyClaimOfMisconduct,
    selectCurrentUnderInvestigation,
    selectWorkedInUKPoliceForce
  )

  def workplaceMisconductPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecWorkplaceMisconductCheck.contains("Not Applicable") &&
      vXPecWorkplaceMisconductCheck.contains(s"$vXApproach Candidates")
    ) {
      workplaceMisconductPageCheck()
      misconduct.foreach { f =>
        f(pecFormDetails.misconductDetails)
      }
      clickOn(pageContinue)
    }
}
