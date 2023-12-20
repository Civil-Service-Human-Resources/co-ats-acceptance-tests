package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{civilServant, homeDepartment, vacancyName}

object ProvisionalOfferPage extends CivilServiceJobsBasePage {

  val provisionalOfferPageTitle  = "Provisional Offer - Civil Service Jobs - GOV.UK"
  def congratsMessageId          = s"${offerDecisionFormId}_label_28793_1"
  def offerDecisionOptionId      = s"${offerDecisionFormId}_datafield_56084_1_1"
  def isCivilServantYesId        = s"${offerDecisionFormId}_datafield_183007_1_1_1_label"
  def isCivilServantNoId         = s"${offerDecisionFormId}_datafield_183007_1_1_2_label"
  def homeDepartmentId           = s"${offerDecisionFormId}_datafield_182930_1_1"
  def reasonForDeclineId         = s"${offerDecisionFormId}_datafield_36538_1_1"
  def declinedOtherReasonInputId = s"${offerDecisionFormId}_datafield_28826_1_1"
  def discussOfferInputId        = s"${offerDecisionFormId}_datafield_56114_1_1"
  var offerDecisionFormId        = ""

  private def provisionalOfferPageCheck(): Unit =
    eventually(onPage(provisionalOfferPageTitle))

  def confirmCongratsMessage(): Unit = {
    provisionalOfferPageCheck()
    extractOfferDecisionFormId()
    waitForVisibilityOfElementById(
      congratsMessageId
    ).getText shouldEqual s"Congratulations, following recent communication we are pleased to offer you the position of $vacancyName, subject to satisfactory completion of pre-employment checks.\nPlease do not resign from your current employment until you‘ve been made a formal offer."
  }

  private def extractOfferDecisionFormId(): String = {
    offerDecisionFormId = driver.findElement(By.xpath(".//form[@class='form-horizontal eform']")).getAttribute("id")
    offerDecisionFormId
  }

  private def selectOfferDecision(decision: String): Unit =
    selectDropdownOption(offerDecisionOptionId, decision)

  private def acceptOffer(): Unit =
    if (civilServant) {
      radioSelect(isCivilServantYesId)
      selectDropdownOption(homeDepartmentId, homeDepartment)
    } else radioSelect(isCivilServantNoId)

  private def declineOffer(): Unit = {
    selectDropdownOption(reasonForDeclineId, "Other")
    enterDetails(declinedOtherReasonInputId, "Autotest - decline offer")
  }

  private def discussOffer(): Unit =
    enterDetails(discussOfferInputId, "Autotest - discuss offer")

  def offerDecisionFlow(decision: String): Unit = {
    confirmCongratsMessage()
    selectOfferDecision(decision)
    decision match {
      case "Accept"              => acceptOffer()
      case "Decline"             => declineOffer()
      case "I'd like to discuss" => discussOffer()
    }
    clickOn(submitForm)
  }
}
