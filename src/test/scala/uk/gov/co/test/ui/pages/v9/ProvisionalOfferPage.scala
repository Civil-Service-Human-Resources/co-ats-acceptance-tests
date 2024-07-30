package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9CivilServant, v9HomeDepartment, v9RunInWelsh, vacancyName}

object ProvisionalOfferPage extends CivilServiceJobsBasePage {

  val provisionalOfferPageTitle      = "Provisional Offer - Civil Service Jobs - GOV.UK"
  val welshProvisionalOfferPageTitle = "Cynnig Dros Dro - Civil Service Jobs - GOV.UK"
  def congratsMessageId              = s"${offerDecisionFormId}_label_28793_1"
  def offerDecisionOptionId          = s"${offerDecisionFormId}_datafield_56084_1_1"
  def isCivilServantYesId            = s"${offerDecisionFormId}_datafield_183007_1_1_1_label"
  def isCivilServantNoId             = s"${offerDecisionFormId}_datafield_183007_1_1_2_label"
  def homeDepartmentId               = s"${offerDecisionFormId}_datafield_182930_1_1"
  def reasonForDeclineId             = s"${offerDecisionFormId}_datafield_36538_1_1"
  def declinedOtherReasonInputId     = s"${offerDecisionFormId}_datafield_28826_1_1"
  def discussOfferInputId            = s"${offerDecisionFormId}_datafield_56114_1_1"
  var offerDecisionFormId            = ""

  private def provisionalOfferPageCheck(): Unit =
    if (v9RunInWelsh) eventually(onPage(welshProvisionalOfferPageTitle))
    else eventually(onPage(provisionalOfferPageTitle))

  def confirmCongratsMessage(): Unit = {
    provisionalOfferPageCheck()
    extractOfferDecisionFormId()
    val congratsMessage = waitForVisibilityOfElementById(congratsMessageId).getText
    if (v9RunInWelsh) {
//      congratsMessage shouldEqual
//        s"""Llongyfarchiadau, yn dilyn cyfathrebiad diweddar, rydym yn falch o gynnig safle $vacancyName i chi, yn amodol ar gwblhau gwiriadau cyn cyflogaeth yn foddhaol.
//           |Peidiwch ag ymddiswyddo o’ch cyflogaeth bresennol hyd nes y byddwch wedi cael cynnig ffurfiol.""".stripMargin
    } else {
      congratsMessage shouldEqual
        s"""Congratulations, following recent communication we are pleased to offer you the position of $vacancyName, subject to satisfactory completion of pre-employment checks.
           |Please do not resign from your current employment until you‘ve been made a formal offer.""".stripMargin
    }
  }

  private def extractOfferDecisionFormId(): String = {
    offerDecisionFormId = driver.findElement(By.xpath(".//form[@class='form-horizontal eform']")).getAttribute("id")
    offerDecisionFormId
  }

  private def selectOfferDecision(decision: String): Unit =
    selectDropdownOption(offerDecisionOptionId, decision)

//  private def acceptOffer(): Unit =
//    if (v9CivilServant) {
//      radioSelect(isCivilServantYesId)
//      if (v9HomeDepartment.isEmpty) {
//        if (v9RunInWelsh) {
//          selectDropdownOption(homeDepartmentId, "Asiantaeth Iechyd Anifeiliaid a Phlanhigion")
//          v9HomeDepartment = "Asiantaeth Iechyd Anifeiliaid a Phlanhigion"
//        } else {
//          selectDropdownOption(homeDepartmentId, "Animal and Plant Health Agency")
//          v9HomeDepartment = "Animal and Plant Health Agency"
//        }
//      } else {
//        selectDropdownOption(homeDepartmentId, v9HomeDepartment)
//      }
//    } else radioSelect(isCivilServantNoId)

  private def acceptOffer(): Unit =
    if (v9CivilServant) {
      radioSelect(isCivilServantYesId)
      if (v9HomeDepartment.isEmpty) {
        if (!v9RunInWelsh) {
          selectDropdownOption(homeDepartmentId, "Animal and Plant Health Agency")
          v9HomeDepartment = "Animal and Plant Health Agency"
        } else {
          selectDropdownOption(homeDepartmentId, "Asiantaeth Iechyd Anifeiliaid a Phlanhigion")
          v9HomeDepartment = "Asiantaeth Iechyd Anifeiliaid a Phlanhigion"
        }
      } else {
        selectDropdownOption(homeDepartmentId, v9HomeDepartment)
      }
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
      case "Derbyn"              => acceptOffer()
      case "Decline"             => declineOffer()
      case "I'd like to discuss" => discussOffer()
    }
    clickOn(submitForm)
  }
}
