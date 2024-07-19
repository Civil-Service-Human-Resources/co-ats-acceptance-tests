package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecPensionsCheck, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class PensionDetails(
  pensionInfoHeader: String,
  pensionInfo: String,
  everBeenPensionMember: String,
  nameOfEmployerPensionHeld: String,
  memberScheme: String,
  leaveDate: String,
  whyDidYouLeave: String,
  earlyExitReservedRights: Boolean,
  receivingCSPayments: Boolean,
  transferCSPension: Boolean,
  pensionTransferDetails: String,
  nameOfEmployerLatestPension: String,
  whatSchemeMemberOf: String,
  schemeNPA: String,
  schemeMemberNo: String,
  membershipStart: String,
  membershipFinish: String,
  refundReceived: Boolean,
  paymentReceived: Option[Boolean] = None,
  transferToOtherPension: Option[Boolean] = None,
  schemeTransferredTo: Option[String] = None,
  offeredEnrolmentDate: Boolean,
  enrolmentDate: String,
  offeredFullProtection: Boolean,
  anyOtherPensionsAfter: Boolean
)

object PensionQuestionnairePage extends CivilServiceJobsBasePage {

  private lazy val pensionPageTitle = "Pension Questionnaire - Civil Service Jobs - GOV.UK"
  def pensionInfoHeaderId           = s"${pecFormId}_label_85749_1"
  def pensionMemberCSArrangementsId = s"${pecFormId}_datafield_85753_1_1_15258_label"
  def pensionMemberByAnalogyId      = s"${pecFormId}_datafield_85753_1_1_15259_label"
  def pensionMemberOtherId          = s"${pecFormId}_datafield_85753_1_1_15260_label"
  def pensionMemberNoneId           = s"${pecFormId}_datafield_85753_1_1_15261_label"
  def pensionInfoId                 = ".//span[@class='hform_lbl_text']"
  def nameOfPreviousEmployerId      = s"${pecFormId}_datafield_83307_1_1"
  def schemeAlphaId                 = s"${pecFormId}_datafield_83314_1_1_15262_label"
  def schemeClassicId               = s"${pecFormId}_datafield_83314_1_1_888_label"
  def schemeClassicPlusId           = s"${pecFormId}_datafield_83314_1_1_890_label"
  def schemeNuvosId                 = s"${pecFormId}_datafield_83314_1_1_892_label"
  def schemePartnershipAfterId      = s"${pecFormId}_datafield_83314_1_1_893_label"
  def schemePartnershipBeforeId     = s"${pecFormId}_datafield_83314_1_1_891_label"
  def schemePremiumId               = s"${pecFormId}_datafield_83314_1_1_889_label"
  def whyDidYouLeaveId              = s"${pecFormId}_datafield_83322_1_1"
  def leaveDateDayId                = s"${pecFormId}_datafield_83318_1_1--DAY"
  def leaveDateMonthId              = s"${pecFormId}_datafield_83318_1_1--MONTH"
  def leaveDateYearId               = s"${pecFormId}_datafield_83318_1_1--YEAR"
  def earlyExitRightsYesId          = s"${pecFormId}_datafield_83326_1_1_1_label"
  def earlyExitRightsNoId           = s"${pecFormId}_datafield_83326_1_1_2_label"
  def receivingCSPaymentsYesId      = s"${pecFormId}_datafield_83330_1_1_1_label"
  def receivingCSPaymentsNoId       = s"${pecFormId}_datafield_83330_1_1_2_label"
  def transferCSPensionYesId        = s"${pecFormId}_datafield_83335_1_1_1_label"
  def transferCSPensionNoId         = s"${pecFormId}_datafield_83335_1_1_2_label"
  def transferCSPensionDetailsId    = s"${pecFormId}_datafield_83339_1_1"
  def nameOfEmployerLatestPensionId = s"${pecFormId}_datafield_83852_1_1"
  def whatSchemeMemberOfId          = s"${pecFormId}_datafield_83859_1_1"
  def schemeNPAId                   = s"${pecFormId}_datafield_83866_1_1"
  def schemeMemberNoId              = s"${pecFormId}_datafield_83873_1_1"
  def membershipStartDayId          = s"${pecFormId}_datafield_83880_1_1--DAY"
  def membershipStartMonthId        = s"${pecFormId}_datafield_83880_1_1--MONTH"
  def membershipStartYearId         = s"${pecFormId}_datafield_83880_1_1--YEAR"
  def membershipFinishDayId         = s"${pecFormId}_datafield_83884_1_1--DAY"
  def membershipFinishMonthId       = s"${pecFormId}_datafield_83884_1_1--MONTH"
  def membershipFinishYearId        = s"${pecFormId}_datafield_83884_1_1--YEAR"
  def refundReceivedYesId           = s"${pecFormId}_datafield_83888_1_1_1_label"
  def refundReceivedNoId            = s"${pecFormId}_datafield_83888_1_1_2_label"
  def paymentReceivedYesId          = s"${pecFormId}_datafield_83989_1_1_1_label"
  def paymentReceivedNoId           = s"${pecFormId}_datafield_83989_1_1_2_label"
  def transferToOtherPensionYesId   = s"${pecFormId}_datafield_83896_1_1_1_label"
  def transferToOtherPensionNoId    = s"${pecFormId}_datafield_83896_1_1_2_label"
  def schemeTransferredToId         = s"${pecFormId}_datafield_83900_1_1"
  def offeredEnrolmentDateYesId     = s"${pecFormId}_datafield_83907_1_1_1_label"
  def offeredEnrolmentDateNoId      = s"${pecFormId}_datafield_83907_1_1_2_label"
  def enrolmentDateDayId            = s"${pecFormId}_datafield_83915_1_1--DAY"
  def enrolmentDateMonthId          = s"${pecFormId}_datafield_83915_1_1--MONTH"
  def enrolmentDateYearId           = s"${pecFormId}_datafield_83915_1_1--YEAR"
  def offeredFullProtectionYesId    = s"${pecFormId}_datafield_83911_1_1_1_label"
  def offeredFullProtectionNoId     = s"${pecFormId}_datafield_83911_1_1_2_label"
  def anyOtherPensionsAfterYesId    = s"${pecFormId}_datafield_85769_1_1_1_label"
  def anyOtherPensionsAfterNoId     = s"${pecFormId}_datafield_85769_1_1_2_label"

  private def pensionPageCheck(pensionDetails: PensionDetails): Unit = {
    eventually(onPage(pensionPageTitle))
    pensionInfoCheck(pensionDetails)
  }

  private def pensionInfoCheck(pensionDetails: PensionDetails): Unit = {
    waitForVisibilityOfElementById(pensionInfoHeaderId).getText shouldEqual (pensionDetails.pensionInfoHeader)
    waitForVisibilityOfElementByPath(pensionInfoId).getText     shouldEqual (pensionDetails.pensionInfo)
  }

  private def enterDate(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (day, month, year) = splitDate(date)
    enterDate(dayId, day)
    enterDate(monthId, month)
    enterDate(yearId, year)
  }

  private def enterWhatDateDidYouLeave(pensionDetails: PensionDetails): Unit =
    enterDate(pensionDetails.leaveDate, leaveDateDayId, leaveDateMonthId, leaveDateYearId)

  private def selectWhyDidYouLeave(pensionDetails: PensionDetails): Unit =
    selectDropdownOption(whyDidYouLeaveId, pensionDetails.whyDidYouLeave)

  private def selectEarlyExitReservedRights(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.earlyExitReservedRights) {
      radioSelect(earlyExitRightsYesId)
    } else radioSelect(earlyExitRightsNoId)

  private def selectReceivingCSPayments(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.receivingCSPayments) {
      radioSelect(receivingCSPaymentsYesId)
    } else radioSelect(receivingCSPaymentsNoId)

  private def selectTransferCSPension(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.transferCSPension) {
      radioSelect(transferCSPensionYesId)
      enterTransferCSPensionDetails(pensionDetails)
    } else radioSelect(transferCSPensionNoId)

  private def selectEverBeenPensionMemberFlow(pensionDetails: PensionDetails): Unit =
    pensionDetails.everBeenPensionMember match {
      case "Civil Service Pension arrangements"                     =>
        radioSelect(pensionMemberCSArrangementsId)
        civilServicePensionFlow(pensionDetails)
      case "By-analogy* Civil Service Pension arrangements"         =>
        radioSelect(pensionMemberByAnalogyId)
        civilServicePensionFlow(pensionDetails)
      case "Other public service pension - Post 31 March 2007"      =>
        radioSelect(pensionMemberOtherId)
        otherPublicPensionFlow(pensionDetails)
      case "No - I have never been a public service pension member" =>
        radioSelect(pensionMemberNoneId)
    }

  private def selectWhatMemberScheme(pensionDetails: PensionDetails): Unit =
    pensionDetails.memberScheme match {
      case "Alpha"                                    => radioSelect(schemeAlphaId)
      case "Classic"                                  => radioSelect(schemeClassicId)
      case "Classic plus"                             => radioSelect(schemeClassicPlusId)
      case "Nuvos"                                    => radioSelect(schemeNuvosId)
      case "Partnership (Joined after 30 July 2007)"  => radioSelect(schemePartnershipAfterId)
      case "Partnership (Joined before 30 July 2007)" => radioSelect(schemePartnershipBeforeId)
      case "Premium"                                  => radioSelect(schemePremiumId)
    }

  private def enterNameOfEmployer(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.everBeenPensionMember != "No - I have never been a public service pension member") {
      enterDetails(nameOfPreviousEmployerId, pensionDetails.nameOfEmployerPensionHeld)
    }

  private def enterTransferCSPensionDetails(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.transferCSPension) {
      enterDetails(transferCSPensionDetailsId, pensionDetails.pensionTransferDetails)
    }

  private def enterNameOfEmployerLatestPension(pensionDetails: PensionDetails): Unit =
    enterDetails(nameOfEmployerLatestPensionId, pensionDetails.nameOfEmployerPensionHeld)

  private def enterWhatSchemeMemberOf(pensionDetails: PensionDetails): Unit =
    enterDetails(whatSchemeMemberOfId, pensionDetails.whatSchemeMemberOf)

  private def enterSchemeNPA(pensionDetails: PensionDetails): Unit =
    enterDetails(schemeNPAId, pensionDetails.schemeNPA)

  private def enterSchemeMemberNo(pensionDetails: PensionDetails): Unit =
    enterDetails(schemeMemberNoId, pensionDetails.schemeMemberNo)

  private def enterMembershipStart(pensionDetails: PensionDetails): Unit =
    enterDate(pensionDetails.membershipStart, membershipStartDayId, membershipStartMonthId, membershipStartYearId)

  private def enterMembershipFinish(pensionDetails: PensionDetails): Unit =
    enterDate(pensionDetails.membershipFinish, membershipFinishDayId, membershipFinishMonthId, membershipFinishYearId)

  private def selectRefundReceived(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.refundReceived) {
      radioSelect(refundReceivedYesId)
    } else radioSelect(refundReceivedNoId)

  private def selectPaymentReceived(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.paymentReceived.get) {
      radioSelect(paymentReceivedYesId)
    } else radioSelect(paymentReceivedNoId)

  private def selectTransferToOtherPension(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.transferToOtherPension.get) {
      radioSelect(transferToOtherPensionYesId)
      enterSchemeTransferredTo(pensionDetails)
    } else radioSelect(transferToOtherPensionNoId)

  private def enterSchemeTransferredTo(pensionDetails: PensionDetails): Unit =
    enterDetails(schemeTransferredToId, pensionDetails.schemeTransferredTo.get)

  private def selectOfferedEnrolmentDate(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.offeredEnrolmentDate) {
      radioSelect(offeredEnrolmentDateYesId)
      enterEnrolmentDate(pensionDetails)
    } else radioSelect(offeredEnrolmentDateNoId)

  private def enterEnrolmentDate(pensionDetails: PensionDetails): Unit =
    enterDate(pensionDetails.enrolmentDate, enrolmentDateDayId, enrolmentDateMonthId, enrolmentDateYearId)

  private def selectOfferedFullProtection(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.offeredFullProtection) {
      radioSelect(offeredFullProtectionYesId)
    } else radioSelect(offeredFullProtectionNoId)

  private def selectAnyOtherPensionsAfter(pensionDetails: PensionDetails): Unit =
    if (pensionDetails.anyOtherPensionsAfter) {
      radioSelect(anyOtherPensionsAfterYesId)
    } else radioSelect(anyOtherPensionsAfterNoId)

  private val csPension: Seq[PensionDetails => Unit] = Seq(
    enterNameOfEmployer,
    selectWhatMemberScheme,
    enterWhatDateDidYouLeave,
    selectWhyDidYouLeave,
    selectEarlyExitReservedRights,
    selectReceivingCSPayments,
    selectTransferCSPension
  )

  private val otherPension: Seq[PensionDetails => Unit] = Seq(
    enterNameOfEmployerLatestPension,
    enterWhatSchemeMemberOf,
    enterSchemeNPA,
    enterSchemeMemberNo,
    enterMembershipStart,
    enterMembershipFinish,
    selectRefundReceived,
    selectPaymentReceived,
    selectTransferToOtherPension,
    selectOfferedEnrolmentDate,
    selectOfferedFullProtection,
    selectAnyOtherPensionsAfter
  )

  def civilServicePensionFlow(pensionDetails: PensionDetails): Unit =
    csPension.foreach { f =>
      f(pensionDetails)
    }

  def otherPublicPensionFlow(pensionDetails: PensionDetails): Unit =
    otherPension.foreach { f =>
      f(pensionDetails)
    }

  private val pension: Seq[PensionDetails => Unit] = Seq(
    pensionPageCheck,
    selectEverBeenPensionMemberFlow
  )

  def pensionQuestionnairePage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecPensionsCheck.contains("Not Applicable") &&
      vXPecPensionsCheck.contains(s"$vXTypeOfCandidate Candidates")
    ) {
      pension.foreach { f =>
        f(pecFormDetails.pensionDetails)
      }
      clickOn(pageContinue)
    }
}
