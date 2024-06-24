package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecBankruptcyCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class BankruptcyDetails(
  undischargedBankrupt: Boolean,
  bankruptcyStatus: String,
  insolvent: Boolean,
  insolvencyStatus: String,
  receivingOrderOnProperty: Boolean,
  receivingOrderOnPropertyInfo: String,
  penaltyForLateFiling: Boolean,
  penaltyForLateFilingInfo: String
)

object BankruptcyDetailsPage extends CivilServiceJobsBasePage {

  private lazy val bankruptcyDetailsPageTitle = "Bankruptcy Details - Civil Service Jobs - GOV.UK"
  def undischargedBankruptYesId               = s"${pecFormId}_datafield_79628_1_1_1_label"
  def undischargedBankruptNoId                = s"${pecFormId}_datafield_79628_1_1_2_label"
  def bankruptcyStatusInputId                 = s"${pecFormId}_datafield_79632_1_1"
  def insolventYesId                          = s"${pecFormId}_datafield_79639_1_1_1_label"
  def insolventNoId                           = s"${pecFormId}_datafield_79639_1_1_2_label"
  def insolvencyStatusInputId                 = s"${pecFormId}_datafield_79643_1_1"
  def receivingOrderOnPropertyYesId           = s"${pecFormId}_datafield_79650_1_1_1_label"
  def receivingOrderOnPropertyNoId            = s"${pecFormId}_datafield_79650_1_1_2_label"
  def receivingOrderOnPropertyInputId         = s"${pecFormId}_datafield_79654_1_1"
  def penaltyForLateFilingYesId               = s"${pecFormId}_datafield_79661_1_1_1_label"
  def penaltyForLateFilingNoId                = s"${pecFormId}_datafield_79661_1_1_2_label"
  def penaltyForLateFilingInputId             = s"${pecFormId}_datafield_79665_1_1"

  private def bankruptcyDetailsPageCheck(): Unit =
    eventually(onPage(bankruptcyDetailsPageTitle))

  private def selectUndischargedBankrupt(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.undischargedBankrupt) {
      radioSelect(undischargedBankruptYesId)
      enterDetails(bankruptcyStatusInputId, bankruptcyDetails.bankruptcyStatus)
    } else {
      radioSelect(undischargedBankruptNoId)
    }

  private def selectInsolvent(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.insolvent) {
      radioSelect(insolventYesId)
      enterDetails(insolvencyStatusInputId, bankruptcyDetails.insolvencyStatus)
    } else {
      radioSelect(insolventNoId)
    }

  private def selectReceivingOrderOnProperty(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.receivingOrderOnProperty) {
      radioSelect(receivingOrderOnPropertyYesId)
      enterDetails(receivingOrderOnPropertyInputId, bankruptcyDetails.receivingOrderOnPropertyInfo)
    } else {
      radioSelect(receivingOrderOnPropertyNoId)
    }

  private def selectPenaltyForLateFiling(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.penaltyForLateFiling) {
      radioSelect(penaltyForLateFilingYesId)
      enterDetails(penaltyForLateFilingInputId, bankruptcyDetails.penaltyForLateFilingInfo)
    } else {
      radioSelect(penaltyForLateFilingNoId)
    }

  private val bankruptcy: Seq[BankruptcyDetails => Unit] = Seq(
    selectUndischargedBankrupt,
    selectInsolvent,
    selectReceivingOrderOnProperty,
    selectPenaltyForLateFiling
  )

  def bankruptcyDetailsPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecBankruptcyCheck.contains("Not Applicable") &&
      vXPecBankruptcyCheck.contains(s"$vXApproach Candidates")
    ) {
      bankruptcyDetailsPageCheck()
      bankruptcy.foreach { f =>
        f(pecFormDetails.bankruptcyDetails)
      }
      clickOn(pageContinue)
    }
}
