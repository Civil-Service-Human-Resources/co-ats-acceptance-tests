package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecNsv}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class NsvDetails(
  surnameAtBirth: String,
  anyOtherSurname: Option[String] = None,
  anyOtherSurnameTwo: Option[String] = None,
  anyOtherForename: Option[String] = None,
  anyOtherForenameTwo: Option[String] = None,
  townOfBirth: String,
  countryOfBirth: String,
  holdImmigrationRefNo: Boolean,
  immigrationRefNo: String,
  addressLineOne: String,
  addressLineTwo: Option[String] = None,
  townCity: String,
  postcode: String,
  county: String,
  country: String,
  addressDateFrom: String,
  addAnotherInstance: Boolean,
  formerGovPoliceService: Boolean,
  govDeptName: String,
  jobTitle: String,
  serviceStartDate: String,
  serviceEndDate: Option[String] = None,
  contractType: String,
  holdSecurityClearance: Boolean,
  clearanceHeld: String,
  clearanceStartDate: String,
  clearanceExpiryDate: String,
  orgWhereClearanceHeld: String,
  securityClearanceInfo: Option[String] = None
)

object NationalSecurityVettingPage extends CivilServiceJobsBasePage {

  private lazy val nsvPageTitle         = "National Security Vetting - Civil Service Jobs - GOV.UK"
  private lazy val addAnotherInstanceId = ".//input[@value='Add another instance']"
  private lazy val removeEmployerId     = ".//input[@value='Remove Employer']"

  def surnameAtBirthId            = s"${pecFormId}_datafield_79921_1_1"
  def anyOtherSurnameId           = s"${pecFormId}_datafield_79928_1_1"
  def anyOtherSurnameTwoId        = s"${pecFormId}_datafield_107904_1_1"
  def anyOtherForenameId          = s"${pecFormId}_datafield_79935_1_1"
  def anyOtherForenameTwoId       = s"${pecFormId}_datafield_107897_1_1"
  def townOfBirthId               = s"${pecFormId}_datafield_79942_1_1"
  def countryOfBirthId            = s"${pecFormId}_datafield_79949_1_1"
  def immigrationRefNumberYesId   = s"${pecFormId}_datafield_126345_1_1_1_label"
  def immigrationRefNumberNoId    = s"${pecFormId}_datafield_126345_1_1_2_label"
  def immigrationRefNumberId      = s"${pecFormId}_datafield_126349_1_1"
  def addressLineOneId            = s"${pecFormId}_datafield_122536_1_1"
  def addressLineTwoId            = s"${pecFormId}_datafield_122543_1_1"
  def townCityId                  = s"${pecFormId}_datafield_122550_1_1"
  def postcodeId                  = s"${pecFormId}_datafield_122568_1_1"
  def countyId                    = s"${pecFormId}_datafield_122557_1_1"
  def countryId                   = s"${pecFormId}_datafield_122564_1_1"
  def dateFromDayId               = s"${pecFormId}_datafield_122575_1_1--DAY"
  def dateFromMonthId             = s"${pecFormId}_datafield_122575_1_1--MONTH"
  def dateFromYearId              = s"${pecFormId}_datafield_122575_1_1--YEAR"
  def formerGovPoliceServiceYesId = s"${pecFormId}_datafield_79960_1_1_1_label"
  def formerGovPoliceServiceNoId  = s"${pecFormId}_datafield_79960_1_1_2_label"
  def govDeptNameId               = s"${pecFormId}_datafield_79964_1_1"
  def jobTitleId                  = s"${pecFormId}_datafield_107940_1_1"
  def serviceStartDateDayId       = s"${pecFormId}_datafield_79971_1_1--DAY"
  def serviceStartDateMonthId     = s"${pecFormId}_datafield_79971_1_1--MONTH"
  def serviceStartDateYearId      = s"${pecFormId}_datafield_79971_1_1--YEAR"
  def serviceEndDateDayId         = s"${pecFormId}_datafield_79975_1_1--DAY"
  def serviceEndDateMonthId       = s"${pecFormId}_datafield_79975_1_1--MONTH"
  def serviceEndDateYearId        = s"${pecFormId}_datafield_79975_1_1--YEAR"
  def contractTypeCasualId        = s"${pecFormId}_datafield_107972_1_1_17255_label"
  def contractTypeContractorId    = s"${pecFormId}_datafield_107972_1_1_17256_label"
  def contractTypeAgencyId        = s"${pecFormId}_datafield_107972_1_1_17259_label"
  def contractTypeSecondmentId    = s"${pecFormId}_datafield_107972_1_1_17258_label"
  def contractTypePermanentId     = s"${pecFormId}_datafield_107972_1_1_17257_label"
  def clearanceDetailsYesId       = s"${pecFormId}_datafield_79979_1_1_1_label"
  def clearanceDetailsNoId        = s"${pecFormId}_datafield_79979_1_1_2_label"
  def counterTerroristCheckId     = s"${pecFormId}_datafield_79983_1_1_15206_label"
  def securityCheckId             = s"${pecFormId}_datafield_79983_1_1_15207_label"
  def developedVettingId          = s"${pecFormId}_datafield_79983_1_1_15209_label"
  def enhancedDevelopedVettingId  = s"${pecFormId}_datafield_79983_1_1_15210_label"
  def clearanceStartDateDayId     = s"${pecFormId}_datafield_108107_1_1--DAY"
  def clearanceStartDateMonthId   = s"${pecFormId}_datafield_108107_1_1--MONTH"
  def clearanceStartDateYearId    = s"${pecFormId}_datafield_108107_1_1--YEAR"
  def clearanceExpiryDateDayId    = s"${pecFormId}_datafield_79988_1_1--DAY"
  def clearanceExpiryDateMonthId  = s"${pecFormId}_datafield_79988_1_1--MONTH"
  def clearanceExpiryDateYearId   = s"${pecFormId}_datafield_79988_1_1--YEAR"
  def orgWhereClearanceHeldId     = s"${pecFormId}_datafield_79992_1_1"
  def securityClearanceInfoId     = s"${pecFormId}_datafield_126356_1_1"

  private def nsvPageCheck(): Unit =
    eventually(onPage(nsvPageTitle))

  private def enterSurnameAtBirth(nsvDetails: NsvDetails): Unit =
    enterDetails(surnameAtBirthId, nsvDetails.surnameAtBirth)

  private def enterAnyOtherSurname(nsvDetails: NsvDetails): Unit =
    enterDetails(anyOtherSurnameId, nsvDetails.anyOtherSurname.get)

  private def enterAnyOtherSurnameTwo(nsvDetails: NsvDetails): Unit =
    enterDetails(anyOtherSurnameTwoId, nsvDetails.anyOtherSurnameTwo.get)

  private def enterAnyOtherForename(nsvDetails: NsvDetails): Unit =
    enterDetails(anyOtherForenameId, nsvDetails.anyOtherForename.get)

  private def enterAnyOtherForenameTwo(nsvDetails: NsvDetails): Unit =
    enterDetails(anyOtherForenameTwoId, nsvDetails.anyOtherForenameTwo.get)

  private def enterTownOfBirth(nsvDetails: NsvDetails): Unit =
    enterDetails(townOfBirthId, nsvDetails.townOfBirth)

  private def enterCountryOfBirth(nsvDetails: NsvDetails): Unit =
    enterDetails(countryOfBirthId, nsvDetails.countryOfBirth)

  private def selectHoldImmigrationRefNumber(nsvDetails: NsvDetails): Unit =
    if (nsvDetails.holdImmigrationRefNo) {
      radioSelect(immigrationRefNumberYesId)
      enterDetails(immigrationRefNumberId, nsvDetails.immigrationRefNo)
    } else {
      radioSelect(immigrationRefNumberNoId)
    }

  private def enterDate(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (day, month, year) = splitDate(date)
    enterDate(dayId, day)
    enterDate(monthId, month)
    enterDate(yearId, year)
  }

  private def enterResidencyDetails(nsvDetails: NsvDetails): Unit = {
    enterDetails(addressLineOneId, nsvDetails.addressLineOne)
    enterDetails(addressLineTwoId, nsvDetails.addressLineTwo.get)
    enterDetails(townCityId, nsvDetails.townCity)
    enterDetails(postcodeId, nsvDetails.postcode)
    enterDetails(countyId, nsvDetails.county)
    selectDropdownOption(countryId, nsvDetails.country)
    enterDate(
      nsvDetails.addressDateFrom,
      dateFromDayId,
      dateFromMonthId,
      dateFromYearId
    )
  }

  private def selectFormerGovPoliceService(nsvDetails: NsvDetails): Unit =
    if (nsvDetails.formerGovPoliceService) {
      radioSelect(formerGovPoliceServiceYesId)
      enterDetails(govDeptNameId, nsvDetails.govDeptName)
      enterDetails(jobTitleId, nsvDetails.jobTitle)
      enterDate(
        nsvDetails.serviceStartDate,
        serviceStartDateDayId,
        serviceStartDateMonthId,
        serviceStartDateYearId
      )
      enterDate(
        nsvDetails.serviceEndDate.get,
        serviceEndDateDayId,
        serviceEndDateMonthId,
        serviceStartDateYearId
      )
      selectContractType(nsvDetails)
    } else {
      radioSelect(formerGovPoliceServiceNoId)
    }

  private def selectContractType(nsvDetails: NsvDetails): Unit =
    nsvDetails.contractType match {
      case "Casual"     => radioSelect(contractTypeCasualId)
      case "Contractor" => radioSelect(contractTypeContractorId)
      case "Agency"     => radioSelect(contractTypeAgencyId)
      case "Secondment" => radioSelect(contractTypeSecondmentId)
      case "Permanent"  => radioSelect(contractTypePermanentId)
    }

  private def selectSecurityClearance(nsvDetails: NsvDetails): Unit =
    if (nsvDetails.holdSecurityClearance) {
      radioSelect(clearanceDetailsYesId)
      selectLevelOfClearanceHeld(nsvDetails)
      enterDate(
        nsvDetails.clearanceStartDate,
        clearanceStartDateDayId,
        clearanceStartDateMonthId,
        clearanceStartDateYearId
      )
      enterDate(
        nsvDetails.clearanceExpiryDate,
        clearanceExpiryDateDayId,
        clearanceExpiryDateMonthId,
        clearanceExpiryDateYearId
      )
      enterDetails(orgWhereClearanceHeldId, nsvDetails.orgWhereClearanceHeld)
      enterDetails(securityClearanceInfoId, nsvDetails.securityClearanceInfo.get)
    } else {
      radioSelect(clearanceDetailsNoId)
    }

  private def selectLevelOfClearanceHeld(nsvDetails: NsvDetails): Unit =
    nsvDetails.clearanceHeld match {
      case "Counter Terrorist Check"    => radioSelect(counterTerroristCheckId)
      case "Security Check"             => radioSelect(securityCheckId)
      case "Developed Vetting"          => radioSelect(developedVettingId)
      case "Enhanced Developed Vetting" => radioSelect(enhancedDevelopedVettingId)
    }

  private val nsv: Seq[NsvDetails => Unit] = Seq(
    enterSurnameAtBirth,
    enterAnyOtherSurname,
    enterAnyOtherSurnameTwo,
    enterAnyOtherForename,
    enterAnyOtherForenameTwo,
    enterTownOfBirth,
    enterCountryOfBirth,
    selectHoldImmigrationRefNumber,
    enterResidencyDetails,
    selectFormerGovPoliceService,
    selectSecurityClearance
  )

  def nationalSecurityVettingPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecNsv.contains("Not Applicable") &&
      vXPecNsv.contains(s"$vXApproach Candidates")
    ) {
      nsvPageCheck()
      nsv.foreach { f =>
        f(pecFormDetails.nsvDetails)
      }
      clickOn(pageContinue)
    }
}
