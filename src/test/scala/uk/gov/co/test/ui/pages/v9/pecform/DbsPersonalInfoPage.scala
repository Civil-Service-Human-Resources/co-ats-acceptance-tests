package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomEmail, vXCrcCheckProvider, vXCrcLevel}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class DbsPersonalInfoDetails(
  title: String,
  firstName: String,
  haveMiddleName: Boolean,
  firstMiddleName: String,
  lastName: String,
  lastNameAtBirth: String,
  dob: String,
  otherNames: Boolean,
  townOfBirth: String,
  countryOfBirth: String,
  mobileTeleNo: String,
  gender: String,
  haveNino: Boolean,
  nino: String,
  havePassport: Boolean,
  passportNumber: String,
  passportCountryIssue: String,
  passportDob: String,
  passportIssueDate: String,
  haveDrivingLicence: Boolean,
  drivingLicenceNumber: String,
  drivingLicenceDob: String,
  drivingLicenceType: String,
  drivingLicenceValidFromDate: String,
  drivingLicenceCountryIssue: String,
  previousDbsCheck: Boolean,
  previousDbsProfileId: String,
  receiveCopyOfCert: Boolean,
  receiveCopyOfCertCurrentAddress: Boolean,
  haveConvictions: Boolean
)

object DbsPersonalInfoPage extends CivilServiceJobsBasePage {

  private lazy val dbsPersonalInfoPageTitle = "DBS - Personal Information - Civil Service Jobs - GOV.UK"
  def dbsTitleId                            = s"${pecFormId}_datafield_54761_1_1"
  def firstNameId                           = s"${pecFormId}_datafield_120720_1_1"
  def haveMiddleNameYesId                   = s"${pecFormId}_datafield_116033_1_1_1_label"
  def haveMiddleNameNoId                    = s"${pecFormId}_datafield_116033_1_1_2_label"
  def firstMiddleNameId                     = s"${pecFormId}_datafield_56819_1_1"
  def lastNameId                            = s"${pecFormId}_datafield_120741_1_1"
  def lastNameAtBirthId                     = s"${pecFormId}_datafield_185693_1_1"
  def dobDayId                              = s"${pecFormId}_datafield_54654_1_1--DAY"
  def dobMonthId                            = s"${pecFormId}_datafield_54654_1_1--MONTH"
  def dobYearId                             = s"${pecFormId}_datafield_54654_1_1--YEAR"
  def otherNamesYesId                       = s"${pecFormId}_datafield_54636_1_1_1_label"
  def otherNamesNoId                        = s"${pecFormId}_datafield_54636_1_1_2_label"
  def emailAddressId                        = s"${pecFormId}_datafield_54538_1_1"
  def townOfBirthId                         = s"${pecFormId}_datafield_54639_1_1"
  def countryOfBirthId                      = s"${pecFormId}_datafield_54645_1_1"
  def mobileTeleNoId                        = s"${pecFormId}_datafield_54648_1_1"
  def genderMaleId                          = s"${pecFormId}_datafield_54657_1_1_14556_label"
  def genderFemaleId                        = s"${pecFormId}_datafield_54657_1_1_14557_label"
  def ninoYesId                             = s"${pecFormId}_datafield_54660_1_1_1_label"
  def ninoNoId                              = s"${pecFormId}_datafield_54660_1_1_2_label"
  def ninoInputId                           = s"${pecFormId}_datafield_54663_1_1"
  def passportYesId                         = s"${pecFormId}_datafield_54669_1_1_1_label"
  def passportNoId                          = s"${pecFormId}_datafield_54669_1_1_2_label"
  def passportNumberId                      = s"${pecFormId}_datafield_54672_1_1"
  def passportCountryIssueId                = s"${pecFormId}_datafield_54678_1_1"
  def passportDobDayId                      = s"${pecFormId}_datafield_185714_1_1--DAY"
  def passportDobMonthId                    = s"${pecFormId}_datafield_185714_1_1--MONTH"
  def passportDobYearId                     = s"${pecFormId}_datafield_185714_1_1--YEAR"
  def passportIssueDayId                    = s"${pecFormId}_datafield_185717_1_1--DAY"
  def passportIssueMonthId                  = s"${pecFormId}_datafield_185717_1_1--MONTH"
  def passportIssueYearId                   = s"${pecFormId}_datafield_185717_1_1--YEAR"
  def drivingLicenceYesId                   = s"${pecFormId}_datafield_54681_1_1_1_label"
  def drivingLicenceNoId                    = s"${pecFormId}_datafield_54681_1_1_2_label"
  def drivingLicenceNumberId                = s"${pecFormId}_datafield_54684_1_1"
  def drivingLicenceDobDayId                = s"${pecFormId}_datafield_185763_1_1--DAY"
  def drivingLicenceDobMonthId              = s"${pecFormId}_datafield_185763_1_1--MONTH"
  def drivingLicenceDobYearId               = s"${pecFormId}_datafield_185763_1_1--YEAR"
  def drivingLicenceTypeId                  = s"${pecFormId}_datafield_185769_1_1"
  def drivingLicenceValidDayId              = s"${pecFormId}_datafield_185766_1_1--DAY"
  def drivingLicenceValidMonthId            = s"${pecFormId}_datafield_185766_1_1--MONTH"
  def drivingLicenceValidYearId             = s"${pecFormId}_datafield_185766_1_1--YEAR"
  def drivingLicenceCountryIssueId          = s"${pecFormId}_datafield_185772_1_1"
  def convictionsYesId                      = s"${pecFormId}_datafield_54690_1_1_1_label"
  def convictionsNoId                       = s"${pecFormId}_datafield_54690_1_1_2_label"
  def previousDbsCheckYesId                 = s"${pecFormId}_datafield_56574_1_1_1_label"
  def previousDbsCheckNoId                  = s"${pecFormId}_datafield_56574_1_1_2_label"
  def previousDbsProfileId                  = s"${pecFormId}_datafield_56578_1_1"
  def receiveCopyOfCertificateYesId         = s"${pecFormId}_datafield_54708_1_1_1_label"
  def receiveCopyOfCertificateNoId          = s"${pecFormId}_datafield_54708_1_1_2_label"
  def sendCertificateCurrentAddressYesId    = s"${pecFormId}_datafield_54711_1_1_1_label"
  def sendCertificateCurrentAddressNoId     = s"${pecFormId}_datafield_54711_1_1_2_label"

  private def dbsPersonalInfoPageCheck(): Unit =
    eventually(onPage(dbsPersonalInfoPageTitle))

  private def selectTitle(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    selectDropdownOption(dbsTitleId, dbsPersonalInfoDetails.title)

  private def enterFirstName(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    enterDetails(firstNameId, dbsPersonalInfoDetails.firstName)

  private def selectMiddleName(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (dbsPersonalInfoDetails.haveMiddleName) {
      radioSelect(haveMiddleNameYesId)
      enterDetails(firstMiddleNameId, dbsPersonalInfoDetails.firstMiddleName)
    } else radioSelect(haveMiddleNameNoId)

  private def enterLastName(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    enterDetails(lastNameId, dbsPersonalInfoDetails.lastName)

  private def enterLastNameAtBirth(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (vXCrcLevel == "Standard" || vXCrcLevel == "Enhanced") {
      enterDetails(lastNameAtBirthId, dbsPersonalInfoDetails.lastNameAtBirth)
    }

  private def enterDate(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (day, month, year) = splitDate(date)
    enterDate(dayId, day)
    enterDate(monthId, month)
    enterDate(yearId, year)
  }

  private def enterDob(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    enterDate(dbsPersonalInfoDetails.dob, dobDayId, dobMonthId, dobYearId)

  private def selectOtherNames(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (dbsPersonalInfoDetails.otherNames) {
      radioSelect(otherNamesYesId)
    } else radioSelect(otherNamesNoId)

  private def checkEmail(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit = {
    val personalEmail = waitForVisibilityOfElementById(emailAddressId).getAttribute("value")
    personalEmail shouldEqual randomEmail
  }

  private def enterTownOfBirth(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    enterDetails(townOfBirthId, dbsPersonalInfoDetails.townOfBirth)

  private def enterCountryOfBirth(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    selectDropdownOption(countryOfBirthId, dbsPersonalInfoDetails.countryOfBirth)

  private def enterMobileTeleNo(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    enterDetails(mobileTeleNoId, dbsPersonalInfoDetails.mobileTeleNo)

  private def selectGender(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (dbsPersonalInfoDetails.gender == "Male") {
      radioSelect(genderMaleId)
    } else radioSelect(genderFemaleId)

  private def selectHaveNino(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (dbsPersonalInfoDetails.haveNino) {
      radioSelect(ninoYesId)
      enterDetails(ninoInputId, dbsPersonalInfoDetails.nino)
    } else {
      radioSelect(ninoNoId)
    }

  private def selectHavePassport(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (dbsPersonalInfoDetails.havePassport) {
      radioSelect(passportYesId)
      enterDetails(passportNumberId, dbsPersonalInfoDetails.passportNumber)
      selectDropdownOption(passportCountryIssueId, dbsPersonalInfoDetails.passportCountryIssue)
      enterDate(dbsPersonalInfoDetails.passportDob, passportDobDayId, passportDobMonthId, passportDobYearId)
      enterDate(dbsPersonalInfoDetails.passportIssueDate, passportIssueDayId, passportIssueMonthId, passportIssueYearId)
    } else {
      radioSelect(passportNoId)
    }

  private def selectHaveDrivingLicence(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (dbsPersonalInfoDetails.haveDrivingLicence) {
      radioSelect(drivingLicenceYesId)
      enterDetails(drivingLicenceNumberId, dbsPersonalInfoDetails.drivingLicenceNumber)
      enterDate(
        dbsPersonalInfoDetails.drivingLicenceDob,
        drivingLicenceDobDayId,
        drivingLicenceDobMonthId,
        drivingLicenceDobYearId
      )
      selectDropdownOption(drivingLicenceTypeId, dbsPersonalInfoDetails.drivingLicenceType)
      enterDate(
        dbsPersonalInfoDetails.drivingLicenceValidFromDate,
        drivingLicenceValidDayId,
        drivingLicenceValidMonthId,
        drivingLicenceValidYearId
      )
      selectDropdownOption(drivingLicenceCountryIssueId, dbsPersonalInfoDetails.drivingLicenceCountryIssue)
    } else {
      radioSelect(drivingLicenceNoId)
    }

  private def selectPreviousDbsCheck(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (vXCrcLevel == "Basic" && vXCrcCheckProvider.contains("DBS")) {
      if (dbsPersonalInfoDetails.previousDbsCheck) {
        radioSelect(previousDbsCheckYesId)
        enterDetails(previousDbsProfileId, dbsPersonalInfoDetails.previousDbsProfileId)
      } else {
        radioSelect(previousDbsCheckNoId)
      }
    }

  private def selectReceiveCopyOfCertificate(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (vXCrcLevel == "Basic" && vXCrcCheckProvider.contains("DBS")) {
      if (dbsPersonalInfoDetails.receiveCopyOfCert) {
        radioSelect(receiveCopyOfCertificateYesId)
        selectSendCertificateCurrentAddress(dbsPersonalInfoDetails)
      } else {
        radioSelect(receiveCopyOfCertificateNoId)
      }
    }

  private def selectSendCertificateCurrentAddress(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (dbsPersonalInfoDetails.receiveCopyOfCertCurrentAddress) {
      radioSelect(sendCertificateCurrentAddressYesId)
    } else {
      radioSelect(sendCertificateCurrentAddressNoId)
    }

  private def selectHaveConvictions(dbsPersonalInfoDetails: DbsPersonalInfoDetails): Unit =
    if (vXCrcLevel == "Standard" || vXCrcLevel == "Enhanced") {
      if (dbsPersonalInfoDetails.haveConvictions) {
        radioSelect(convictionsYesId)
      } else {
        radioSelect(convictionsNoId)
      }
    }

  private val personalInfo: Seq[DbsPersonalInfoDetails => Unit] = Seq(
    selectTitle,
    enterFirstName,
    selectMiddleName,
    enterLastName,
    enterLastNameAtBirth,
    enterDob,
    selectOtherNames,
    checkEmail,
    enterTownOfBirth,
    enterCountryOfBirth,
    enterMobileTeleNo,
    selectGender,
    selectHaveNino,
    selectHavePassport,
    selectHaveDrivingLicence,
    selectPreviousDbsCheck,
    selectReceiveCopyOfCertificate,
    selectHaveConvictions
  )

  def dbsPersonalInfoPage(pecFormDetails: PecFormDetails): Unit =
    if (vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) {
      dbsPersonalInfoPageCheck()
      personalInfo.foreach { f =>
        f(pecFormDetails.dbsPersonalInfoDetails)
      }
      clickOn(pageContinue)
    }
}
