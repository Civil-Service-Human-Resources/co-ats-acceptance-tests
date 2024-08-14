package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXPecSelfEmploymentCheck, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

import java.time.LocalDate

case class SelfEmploymentDetails(
  selfEmploymentLast3Years: Boolean,
  employmentStartDate: LocalDate,
  employmentEndDate: LocalDate,
  nameOfBusiness: String,
  typeOfBusiness: String,
  haveAccountsClosed: Boolean,
  notClosedAccountsReasons: String,
  accountsClosedAdequately: Boolean,
  statusOfInadequateAccountsDetails: String,
  usedSolicitorOrAccountant: Boolean,
  nameOfCompany: String,
  nameOfSolicitorOrAccountant: String,
  teleNoOfSolicitorOrAccountant: String,
  emailOfSolicitorOrAccountant: String,
  recentSAReturnSatisfactorily: Boolean,
  copyOfReturnSA302: String,
  everVATRegistered: Boolean,
  vatRegistrationNo: String,
  everCeasedTrading: Boolean,
  remainSelfEmployed: Boolean,
  remainSelfEmployedDetails: String,
  anyOtherDetailsCausingConflict: Boolean,
  anyOtherDetailsCausingConflictDetails: String
)

object SelfEmploymentPage extends CivilServiceJobsBasePage {

  private lazy val selfEmploymentPageTitle    = "Self employment - Civil Service Jobs - GOV.UK"
  def selfEmploymentLast3YearsYesId           = s"${pecFormId}_datafield_182053_1_1_1_label"
  def selfEmploymentLast3YearsNoId            = s"${pecFormId}_datafield_182053_1_1_2_label"
  def employmentStartDayId                    = s"${pecFormId}_datafield_80400_1_1--DAY"
  def employmentStartMonthId                  = s"${pecFormId}_datafield_80400_1_1--MONTH"
  def employmentStartYearId                   = s"${pecFormId}_datafield_80400_1_1--YEAR"
  def employmentEndDayId                      = s"${pecFormId}_datafield_80404_1_1--DAY"
  def employmentEndMonthId                    = s"${pecFormId}_datafield_80404_1_1--MONTH"
  def employmentEndYearId                     = s"${pecFormId}_datafield_80404_1_1--YEAR"
  def nameOfBusinessId                        = s"${pecFormId}_datafield_80420_1_1"
  def typeOfBusinessId                        = s"${pecFormId}_datafield_80427_1_1"
  def haveAccountsClosedYesId                 = s"${pecFormId}_datafield_80434_1_1_1_label"
  def haveAccountsClosedNoId                  = s"${pecFormId}_datafield_80434_1_1_2_label"
  def notClosedAccountsReasonsId              = s"${pecFormId}_datafield_182056_1_1"
  def accountsClosedAdequatelyYesId           = s"${pecFormId}_datafield_80438_1_1_1_label"
  def accountsClosedAdequatelyNoId            = s"${pecFormId}_datafield_80438_1_1_2_label"
  def statusOfInadequateAccountsId            = s"${pecFormId}_datafield_80442_1_1"
  def usedSolicitorOrAccountantYesId          = s"${pecFormId}_datafield_80449_1_1_1_label"
  def usedSolicitorOrAccountantNoId           = s"${pecFormId}_datafield_80449_1_1_2_label"
  def nameOfCompanyId                         = s"${pecFormId}_datafield_80453_1_1"
  def nameOfSolicitorOrAccountantId           = s"${pecFormId}_datafield_80460_1_1"
  def teleNoOfSolicitorOrAccountantId         = s"${pecFormId}_datafield_80467_1_1"
  def emailOfSolicitorOrAccountantId          = s"${pecFormId}_datafield_80475_1_1"
  def recentSAReturnSatisfactorilyYesId       = s"${pecFormId}_datafield_80482_1_1_1_label"
  def recentSAReturnSatisfactorilyNoId        = s"${pecFormId}_datafield_80482_1_1_2_label"
  def attachCopyOfReturnSA302Id               = s"${pecFormId}_datafield_94279_1_1"
  def everVATRegisteredYesId                  = s"${pecFormId}_datafield_80486_1_1_1_label"
  def everVATRegisteredNoId                   = s"${pecFormId}_datafield_80486_1_1_2_label"
  def vatRegistrationNoId                     = s"${pecFormId}_datafield_80490_1_1"
  def everCeasedTradingYesId                  = s"${pecFormId}_datafield_80497_1_1_1_label"
  def everCeasedTradingNoId                   = s"${pecFormId}_datafield_80497_1_1_2_label"
  def remainSelfEmployedYesId                 = s"${pecFormId}_datafield_80501_1_1_1_label"
  def remainSelfEmployedNoId                  = s"${pecFormId}_datafield_80501_1_1_2_label"
  def remainSelfEmployedDetailsId             = s"${pecFormId}_datafield_80505_1_1"
  def anyOtherDetailsCausingConflictYesId     = s"${pecFormId}_datafield_80512_1_1_1_label"
  def anyOtherDetailsCausingConflictNoId      = s"${pecFormId}_datafield_80512_1_1_2_label"
  def anyOtherDetailsCausingConflictDetailsId = s"${pecFormId}_datafield_80516_1_1"

  private def selfEmploymentPageCheck(): Unit =
    eventually(onPage(selfEmploymentPageTitle))

  private def selectSelfEmploymentLast3Years(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.selfEmploymentLast3Years) {
      radioSelect(selfEmploymentLast3YearsYesId)
      enterEmploymentStartAndEndDates(selfEmploymentDetails)
      enterNameAndTypeOfBusiness(selfEmploymentDetails)
      selectHaveAccountsClosed(selfEmploymentDetails)
      selectUsedSolicitorOrAccountant(selfEmploymentDetails)
      selectRecentSAReturnSatisfactorily(selfEmploymentDetails)
      selectEverVATRegistered(selfEmploymentDetails)
      selectEverCeasedTrading(selfEmploymentDetails)
      selectRemainSelfEmployed(selfEmploymentDetails)
      selectAnyOtherDetailsCausingConflict(selfEmploymentDetails)
    } else {
      radioSelect(selfEmploymentLast3YearsNoId)
    }

  private def enterEmploymentStartAndEndDates(selfEmploymentDetails: SelfEmploymentDetails): Unit = {
    enterStartOrEndDate(
      formattedDate(selfEmploymentDetails.employmentStartDate),
      employmentStartDayId,
      employmentStartMonthId,
      employmentStartYearId
    )
    enterStartOrEndDate(
      formattedDate(selfEmploymentDetails.employmentEndDate),
      employmentEndDayId,
      employmentEndMonthId,
      employmentEndYearId
    )
  }

  private def enterNameAndTypeOfBusiness(selfEmploymentDetails: SelfEmploymentDetails): Unit = {
    enterDetails(nameOfBusinessId, selfEmploymentDetails.nameOfBusiness)
    enterDetails(typeOfBusinessId, selfEmploymentDetails.typeOfBusiness)
  }

  private def selectHaveAccountsClosed(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.haveAccountsClosed) {
      radioSelect(haveAccountsClosedYesId)
      selectAccountsClosedAdequately(selfEmploymentDetails)
    } else {
      radioSelect(haveAccountsClosedNoId)
      enterDetails(notClosedAccountsReasonsId, selfEmploymentDetails.notClosedAccountsReasons)
    }

  private def selectAccountsClosedAdequately(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.accountsClosedAdequately) {
      radioSelect(accountsClosedAdequatelyYesId)
    } else {
      radioSelect(accountsClosedAdequatelyNoId)
      enterDetails(statusOfInadequateAccountsId, selfEmploymentDetails.statusOfInadequateAccountsDetails)
    }

  private def selectUsedSolicitorOrAccountant(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.usedSolicitorOrAccountant) {
      radioSelect(usedSolicitorOrAccountantYesId)
      enterSolicitorOrAccountantDetails(selfEmploymentDetails)
    } else {
      radioSelect(usedSolicitorOrAccountantNoId)
    }

  private def enterSolicitorOrAccountantDetails(selfEmploymentDetails: SelfEmploymentDetails): Unit = {
    enterDetails(nameOfCompanyId, selfEmploymentDetails.nameOfCompany)
    enterDetails(nameOfSolicitorOrAccountantId, selfEmploymentDetails.nameOfSolicitorOrAccountant)
    enterDetails(teleNoOfSolicitorOrAccountantId, selfEmploymentDetails.teleNoOfSolicitorOrAccountant)
    enterDetails(emailOfSolicitorOrAccountantId, selfEmploymentDetails.emailOfSolicitorOrAccountant)
  }

  private def selectRecentSAReturnSatisfactorily(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.recentSAReturnSatisfactorily) {
      radioSelect(recentSAReturnSatisfactorilyYesId)
      attachCopyOfReturnSA302(selfEmploymentDetails)
    } else {
      radioSelect(recentSAReturnSatisfactorilyNoId)
    }

  private def attachCopyOfReturnSA302(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    attachDocuments(attachCopyOfReturnSA302Id, selfEmploymentDetails.copyOfReturnSA302)

  private def selectEverVATRegistered(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.everVATRegistered) {
      radioSelect(everVATRegisteredYesId)
      enterDetails(vatRegistrationNoId, selfEmploymentDetails.vatRegistrationNo)
    } else {
      radioSelect(everVATRegisteredNoId)
    }

  private def selectEverCeasedTrading(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.everCeasedTrading) radioSelect(everCeasedTradingYesId)
    else radioSelect(everCeasedTradingNoId)

  private def selectRemainSelfEmployed(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.remainSelfEmployed) {
      radioSelect(remainSelfEmployedYesId)
      enterDetails(remainSelfEmployedDetailsId, selfEmploymentDetails.remainSelfEmployedDetails)
    } else radioSelect(remainSelfEmployedNoId)

  private def selectAnyOtherDetailsCausingConflict(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.anyOtherDetailsCausingConflict) {
      radioSelect(anyOtherDetailsCausingConflictYesId)
      enterDetails(anyOtherDetailsCausingConflictDetailsId, selfEmploymentDetails.anyOtherDetailsCausingConflictDetails)
    } else radioSelect(anyOtherDetailsCausingConflictNoId)

  private val selfEmployment: Seq[SelfEmploymentDetails => Unit] = Seq(
    selectSelfEmploymentLast3Years
  )

  def selfEmploymentPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecSelfEmploymentCheck.contains("Not Applicable") &&
      vXPecSelfEmploymentCheck.contains(s"$vXTypeOfCandidate Candidates")
    ) {
      selfEmploymentPageCheck()
      selfEmployment.foreach { f =>
        f(pecFormDetails.selfEmploymentDetails)
      }
      clickOn(pageContinue)
    }
}
