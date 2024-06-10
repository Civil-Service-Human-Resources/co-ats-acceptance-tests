package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecBankruptcyCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class BankruptcyDetails(
  undischargedBankrupt: Boolean,
  insolvent: Boolean,
  receivingOrderOnProperty: Boolean,
  penaltyForLateFiling: Boolean
)

object BankruptcyDetailsPage extends CivilServiceJobsBasePage {

  private lazy val bankruptcyDetailsPageTitle = "Bankruptcy Details - Civil Service Jobs - GOV.UK"
  def undischargedBankruptYesId               = s"${pecFormId}_datafield_79628_1_1_1_label"
  def undischargedBankruptNoId                = s"${pecFormId}_datafield_79628_1_1_2_label"
  def insolventYesId                          = s"${pecFormId}_datafield_79639_1_1_1_label"
  def insolventNoId                           = s"${pecFormId}_datafield_79639_1_1_2_label"
  def receivingOrderOnPropertyYesId           = s"${pecFormId}_datafield_79650_1_1_1_label"
  def receivingOrderOnPropertyNoId            = s"${pecFormId}_datafield_79650_1_1_2_label"
  def penaltyForLateFilingYesId               = s"${pecFormId}_datafield_79661_1_1_1_label"
  def penaltyForLateFilingNoId                = s"${pecFormId}_datafield_79661_1_1_2_label"

  private def bankruptcyDetailsPageCheck(): Unit =
    eventually(onPage(bankruptcyDetailsPageTitle))

  private def selectUndischargedBankrupt(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.undischargedBankrupt) {
      radioSelect(undischargedBankruptYesId)
    } else {
      radioSelect(undischargedBankruptNoId)
    }

  private def selectInsolvent(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.insolvent) {
      radioSelect(insolventYesId)
    } else {
      radioSelect(insolventNoId)
    }

  private def selectReceivingOrderOnProperty(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.receivingOrderOnProperty) {
      radioSelect(receivingOrderOnPropertyYesId)
    } else {
      radioSelect(receivingOrderOnPropertyNoId)
    }

  private def selectPenaltyForLateFiling(bankruptcyDetails: BankruptcyDetails): Unit =
    if (bankruptcyDetails.penaltyForLateFiling) {
      radioSelect(penaltyForLateFilingYesId)
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
