package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{preferredFirstName, preferredTeleNumber, randomFirstName, randomLastName, vXJobGradeEquivalent, vXJobGrades, vXJobInfoDepartment, vXProfession, vXTypeOfRole, vacancyFormId, vacancyId, vacancyName}
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.completePostingNoticeFormBarId
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.collection.mutable.ListBuffer

case class PostingNoticeDetails(
  costCentre: String,
  sopOrg: String,
  sopPosition: String,
  businessUnit: String,
  currentStaffNo: String,
  nino: String,
  startDate: LocalDate,
  startTime: String,
  premOfficeAddress: String,
  dualLocation: Boolean,
  secondLocation: String,
  employmentType: String,
  reasonForHire: String,
  keyResponsibilities: String,
  contractEndDate: LocalDate,
  typeOfTransfer: String,
  workingPattern: ListBuffer[String],
  weeklyWorkingHours: String,
  monHours: String,
  tuesHours: String,
  wedHours: String,
  thursHours: String,
  friHours: String,
  satHours: String,
  sunHours: String,
  payZone: ListBuffer[String],
  annualSalary: String,
  negotiatedSalary: Boolean,
  negotiatedSalaryDate: LocalDate,
  allowancesRequired: Boolean,
  allowancesNameAndAccount: String,
  modernisedTAndCs: Boolean,
  conflictsOfInterest: Boolean,
  lineManagersFullName: String,
  lineManagersTeleNo: String,
  lineManagersEmail: String,
  lineManagersStaffNo: String
)

object PostingNoticeTab extends VacancyBasePage {

  private lazy val postingNoticeTabPath = ".//span[@class='main-label' and text() = 'Posting Notice']"
  def postingNoticeHeaderId             = s"${vacancyFormId}_label_95978_1"
  def postingNoticeInfoId               = s"${vacancyFormId}_label_140312_1"
  def pnVacancyInfoHeaderId             = s"${vacancyFormId}_label_146441_1"
  def vacancyRefId                      = s"${vacancyFormId}_label_81806_1"
  def vacancyTitleId                    = s"${vacancyFormId}_label_81811_1"
  def vacancyDeptId                     = s"${vacancyFormId}_label_81816_1"
  def costCentreId                      = s"${vacancyFormId}_datafield_81783_1_1"
  def sopOrgId                          = s"${vacancyFormId}_datafield_142426_1_1"
  def sopPositionId                     = s"${vacancyFormId}_datafield_142433_1_1"
  def businessUnitId                    = s"${vacancyFormId}_datafield_81790_1_1"
  def newEntrantHeaderId                = s"${vacancyFormId}_label_146486_1"
  def forenameId                        = s"${vacancyFormId}_label_84065_1"
  def preferredNameId                   = s"${vacancyFormId}_label_143080_1"
  def surnameId                         = s"${vacancyFormId}_label_84070_1"
  def preferredContactNumberId          = s"${vacancyFormId}_label_84098_1"
  def currentStaffNumberId              = s"${vacancyFormId}_datafield_84137_1_1"
  def ninoId                            = s"${vacancyFormId}_datafield_138484_1_1"
  def postingInfoHeaderId               = s"${vacancyFormId}_label_146489_1"
  def startDateDayId                    = s"${vacancyFormId}_datafield_84212_1_1--DAY"
  def startDateMonthId                  = s"${vacancyFormId}_datafield_84212_1_1--MONTH"
  def startDateYearId                   = s"${vacancyFormId}_datafield_84212_1_1--YEAR"
  def startTimeHourId                   = s"${vacancyFormId}_datafield_100590_1_1--HOUR"
  def startTimeMinuteId                 = s"${vacancyFormId}_datafield_100590_1_1--MIN"
  def premOfficeAddressId               = s"${vacancyFormId}_datafield_84222_1_1"
  def dualLocationYesId                 = s"${vacancyFormId}_datafield_138531_1_1_1"
  def dualLocationNoId                  = s"${vacancyFormId}_datafield_138531_1_1_2"
  def secondLocationId                  = s"${vacancyFormId}_datafield_138535_1_1"
  def employmentTypeId                  = s"select2-${vacancyFormId}_datafield_207774_1_1-container"
  def reasonForHireTextId               = s"${vacancyFormId}_field_que_176626_1"
  def keyResponsibilitiesTextId         = s"${vacancyFormId}_field_que_183658_1"
  def contractEndDateTextId             = s"${vacancyFormId}_field_que_84301_1"
  def reasonForHireId                   = s"select2-${vacancyFormId}_datafield_176626_1_1-container"
  def keyResponsibilitiesId             = s"${vacancyFormId}_datafield_183658_1_1"
  def contractEndDateDayId              = s"${vacancyFormId}_datafield_84301_1_1--DAY"
  def contractEndDateMonthId            = s"${vacancyFormId}_datafield_84301_1_1--MONTH"
  def contractEndDateYearId             = s"${vacancyFormId}_datafield_84301_1_1--YEAR"
  def levelTransferId                   = s"${vacancyFormId}_datafield_84425_1_1_15263"
  def promotionId                       = s"${vacancyFormId}_datafield_84425_1_1_15264"
  def regradeId                         = s"${vacancyFormId}_datafield_84425_1_1_41895"
  def tempCoverId                       = s"${vacancyFormId}_datafield_84425_1_1_41956"
  def gradeId                           = s"${vacancyFormId}_label_121705_1"
  def equivalentGradeId                 = s"${vacancyFormId}_label_121709_1"
  def jobCategoryId                     = s"${vacancyFormId}_label_121450_1"
  def professionId                      = s"${vacancyFormId}_label_121454_1"
  def workingPatternId                  = s"select2-${vacancyFormId}_datafield_91816_1_1-container"
  def weeklyWorkingHoursId              = s"${vacancyFormId}_datafield_84293_1_1"
  def hoursWorkedMonId                  = s"${vacancyFormId}_datafield_84306_1_1"
  def hoursWorkedTuesId                 = s"${vacancyFormId}_datafield_84314_1_1"
  def hoursWorkedWedId                  = s"${vacancyFormId}_datafield_84322_1_1"
  def hoursWorkedThursId                = s"${vacancyFormId}_datafield_84330_1_1"
  def hoursWorkedFriId                  = s"${vacancyFormId}_datafield_84338_1_1"
  def hoursWorkedSatId                  = s"${vacancyFormId}_datafield_84346_1_1"
  def hoursWorkedSunId                  = s"${vacancyFormId}_datafield_84361_1_1"
  def payZoneId                         = s"select2-${vacancyFormId}_datafield_84369_1_1-container"
  def annualSalaryId                    = s"${vacancyFormId}_datafield_84374_1_1"
  def negotiatedSalaryYesId             = s"${vacancyFormId}_datafield_91821_1_1_1"
  def negotiatedSalaryNoId              = s"${vacancyFormId}_datafield_91821_1_1_2"
  def negotiatedSalaryDateDayId         = s"${vacancyFormId}_datafield_84382_1_1--DAY"
  def negotiatedSalaryDateMonthId       = s"${vacancyFormId}_datafield_84382_1_1--MONTH"
  def negotiatedSalaryDateYearId        = s"${vacancyFormId}_datafield_84382_1_1--YEAR"
  def allowancesRequiredYesId           = s"${vacancyFormId}_datafield_91838_1_1_1"
  def allowancesRequiredNoId            = s"${vacancyFormId}_datafield_91838_1_1_2"
  def allowancesNameAndAccountId        = s"${vacancyFormId}_datafield_84387_1_1"
  def modernisedTAndCsYesId             = s"${vacancyFormId}_datafield_84395_1_1_1"
  def modernisedTAndCsNoId              = s"${vacancyFormId}_datafield_84395_1_1_2"
  def conflictsOfInterestYesId          = s"${vacancyFormId}_datafield_207868_1_1_1"
  def conflictsOfInterestNoId           = s"${vacancyFormId}_datafield_207868_1_1_2"
  def lineManagerDetailsHeaderId        = s"${vacancyFormId}_label_146492_1"
  def lineManagersFullNameId            = s"${vacancyFormId}_datafield_84237_1_1"
  def lineManagersTelNoId               = s"${vacancyFormId}_datafield_84245_1_1"
  def lineManagersEmailId               = s"${vacancyFormId}_datafield_84253_1_1"
  def lineManagersStaffNoId             = s"${vacancyFormId}_datafield_84261_1_1"

  def enterPostingNoticeForm(): Unit = {
    checkVacancyStatus("Posting Notice Requested")
    moveVacancyOnViaTopBar(completePostingNoticeFormBarId, postingNoticeTabPath)
    waitForVisibilityOfElementById(postingNoticeHeaderId).getText shouldEqual "Posting Notice"
    waitForVisibilityOfElementById(
      postingNoticeInfoId
    ).getText                                                     shouldEqual "This form must be completed in full - changes cannot be saved unless all mandatory fields are complete."
  }

  def enterPnValue(inputId: String, text: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
    enterOption.clear()
    enterOption.sendKeys(text)
  }

  private def vacancyInfoSection(postingNoticeDetails: PostingNoticeDetails): Unit = {
    waitForVisibilityOfElementById(pnVacancyInfoHeaderId).getText shouldEqual "Vacancy Information"
    waitForVisibilityOfElementById(vacancyRefId).getText               should endWith(vacancyId)
    waitForVisibilityOfElementById(vacancyTitleId).getText             should endWith(vacancyName)
    waitForVisibilityOfElementById(vacancyDeptId).getText              should endWith(vXJobInfoDepartment)
    enterPnValue(costCentreId, postingNoticeDetails.costCentre)
    enterPnValue(sopOrgId, postingNoticeDetails.sopOrg)
    enterPnValue(sopPositionId, postingNoticeDetails.sopPosition)
    enterPnValue(businessUnitId, postingNoticeDetails.businessUnit)
  }

  private def newEntrantInfoSection(postingNoticeDetails: PostingNoticeDetails): Unit = {
    waitForVisibilityOfElementById(newEntrantHeaderId).getText  shouldEqual "New Entrant Information"
    waitForVisibilityOfElementById(forenameId).getText               should endWith(randomFirstName)
    waitForVisibilityOfElementById(preferredNameId).getText          should endWith(preferredFirstName)
    waitForVisibilityOfElementById(surnameId).getText                should endWith(randomLastName)
    waitForVisibilityOfElementById(preferredContactNumberId).getText should endWith(preferredTeleNumber)
    enterPnValue(currentStaffNumberId, postingNoticeDetails.currentStaffNo)
    enterPnValue(ninoId, postingNoticeDetails.nino)
  }

  private def postingInfoSection(postingNoticeDetails: PostingNoticeDetails): Unit = {
    waitForVisibilityOfElementById(postingInfoHeaderId).getText shouldEqual "Posting Information"
    enterStartDate(postingNoticeDetails)
    enterStartTimeFirstDay(postingNoticeDetails)
    enterPnValue(premOfficeAddressId, postingNoticeDetails.premOfficeAddress)
    selectDualLocation(postingNoticeDetails)
    selectEmploymentType(postingNoticeDetails)
    selectTypeOfTransfer(postingNoticeDetails)
    waitForVisibilityOfElementById(gradeId).getText                  should endWith(vXJobGrades.mkString(", "))
    waitForVisibilityOfElementById(equivalentGradeId).getText        should endWith(vXJobGradeEquivalent)
    waitForVisibilityOfElementById(jobCategoryId).getText            should endWith(vXTypeOfRole.mkString(", "))
    waitForVisibilityOfElementById(professionId).getText             should endWith(vXProfession)
    selectWorkingPattern(postingNoticeDetails)
    enterPnValue(weeklyWorkingHoursId, postingNoticeDetails.weeklyWorkingHours)
    enterPnValue(hoursWorkedMonId, postingNoticeDetails.monHours)
    enterPnValue(hoursWorkedTuesId, postingNoticeDetails.tuesHours)
    enterPnValue(hoursWorkedWedId, postingNoticeDetails.wedHours)
    enterPnValue(hoursWorkedThursId, postingNoticeDetails.thursHours)
    enterPnValue(hoursWorkedFriId, postingNoticeDetails.friHours)
    enterPnValue(hoursWorkedSatId, postingNoticeDetails.satHours)
    enterPnValue(hoursWorkedSunId, postingNoticeDetails.sunHours)
    selectPayZone(postingNoticeDetails)
    enterPnValue(annualSalaryId, postingNoticeDetails.annualSalary)
    selectNegotiatedSalary(postingNoticeDetails)
    selectAllowancesRequired(postingNoticeDetails)
    selectModernisedTAndCs(postingNoticeDetails)
    selectConflictsOfInterest(postingNoticeDetails)
  }

  private def lineManagerDetailsSection(postingNoticeDetails: PostingNoticeDetails): Unit = {
    waitForVisibilityOfElementById(lineManagerDetailsHeaderId).getText shouldEqual "Line Manager Details"
    enterPnValue(lineManagersFullNameId, postingNoticeDetails.lineManagersFullName)
    enterPnValue(lineManagersTelNoId, postingNoticeDetails.lineManagersTeleNo)
    enterPnValue(lineManagersEmailId, postingNoticeDetails.lineManagersEmail)
    enterPnValue(lineManagersStaffNoId, postingNoticeDetails.lineManagersStaffNo)
  }

  private def enterStartDate(postingNoticeDetails: PostingNoticeDetails): Unit =
    enterDateFields(
      formattedDate(postingNoticeDetails.startDate),
      startDateDayId,
      startDateMonthId,
      startDateYearId
    )

  private def enterStartTimeFirstDay(postingNoticeDetails: PostingNoticeDetails): Unit =
    enterTimeFields(postingNoticeDetails.startTime, startTimeHourId, startTimeMinuteId)

  def formattedDate(atDate: LocalDate): String = {
    val formatter     = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formattedDate = atDate.format(formatter)
    formattedDate
  }

  private def selectDualLocation(postingNoticeDetails: PostingNoticeDetails): Unit =
    if (postingNoticeDetails.dualLocation) {
      clickOnRadioButton(dualLocationYesId)
      enterPnValue(secondLocationId, postingNoticeDetails.secondLocation)
    } else {
      clickOnRadioButton(dualLocationNoId)
    }

  private def selectEmploymentType(postingNoticeDetails: PostingNoticeDetails): Unit = {
    val employmentType = postingNoticeDetails.employmentType
    waitForVisibilityOfElementById(employmentTypeId).click()
    selectOption(generalInput, employmentType)
    if (
      employmentType == "Temporary" ||
      employmentType == "Fixed Term Appointment" ||
      employmentType == "Temporary (Not fair and open)" ||
      employmentType == "Short notice appointment" ||
      employmentType == "Loan" ||
      employmentType == "Secondment" ||
      employmentType == "Internship"
    ) {
      selectReasonForHire(postingNoticeDetails)
      enterPnValue(keyResponsibilitiesId, postingNoticeDetails.keyResponsibilities)
      enterContractEndDate(postingNoticeDetails)
    }
  }

  def selectReasonForHire(postingNoticeDetails: PostingNoticeDetails): Unit = {
    waitForVisibilityOfElementById(reasonForHireId).click()
    action().moveToElement(waitForDropdownOption(postingNoticeDetails.reasonForHire)).perform()
    waitForDropdownOption(postingNoticeDetails.reasonForHire).click()
  }

  private def enterContractEndDate(postingNoticeDetails: PostingNoticeDetails): Unit =
    enterDateFields(
      formattedDate(postingNoticeDetails.contractEndDate),
      contractEndDateDayId,
      contractEndDateMonthId,
      contractEndDateYearId
    )

  private def selectTypeOfTransfer(postingNoticeDetails: PostingNoticeDetails): Unit =
    postingNoticeDetails.typeOfTransfer match {
      case "Level Transfer"  => checkbox(levelTransferId).select()
      case "Promotion"       => checkbox(promotionId).select()
      case "Regrade"         => checkbox(regradeId).select()
      case "Temporary cover" => checkbox(tempCoverId).select()
    }

  private def selectWorkingPattern(postingNoticeDetails: PostingNoticeDetails): Unit = {
    scrollToElement(By.id(workingPatternId))
    enterTypeRoles(postingNoticeDetails.workingPattern, workingPatternId)
  }

  private def selectPayZone(postingNoticeDetails: PostingNoticeDetails): Unit = {
    scrollToElement(By.id(payZoneId))
    enterTypeRoles(postingNoticeDetails.payZone, payZoneId)
  }

  private def selectNegotiatedSalary(postingNoticeDetails: PostingNoticeDetails): Unit =
    if (postingNoticeDetails.negotiatedSalary) {
      clickOnRadioButton(negotiatedSalaryYesId)
      enterNegotiatedSalaryDate(postingNoticeDetails)
    } else {
      clickOnRadioButton(negotiatedSalaryNoId)
    }

  private def enterNegotiatedSalaryDate(postingNoticeDetails: PostingNoticeDetails): Unit =
    enterDateFields(
      formattedDate(postingNoticeDetails.negotiatedSalaryDate),
      negotiatedSalaryDateDayId,
      negotiatedSalaryDateMonthId,
      negotiatedSalaryDateYearId
    )

  private def selectAllowancesRequired(postingNoticeDetails: PostingNoticeDetails): Unit =
    if (postingNoticeDetails.allowancesRequired) {
      clickOnRadioButton(allowancesRequiredYesId)
      enterPnValue(allowancesNameAndAccountId, postingNoticeDetails.allowancesNameAndAccount)
    } else {
      clickOnRadioButton(allowancesRequiredNoId)
    }

  private def selectModernisedTAndCs(postingNoticeDetails: PostingNoticeDetails): Unit =
    if (postingNoticeDetails.modernisedTAndCs) clickOnRadioButton(modernisedTAndCsYesId)
    else clickOnRadioButton(modernisedTAndCsNoId)

  private def selectConflictsOfInterest(postingNoticeDetails: PostingNoticeDetails): Unit =
    if (postingNoticeDetails.conflictsOfInterest) clickOnRadioButton(conflictsOfInterestYesId)
    else clickOnRadioButton(conflictsOfInterestNoId)

  private val postingNotice: Seq[PostingNoticeDetails => Unit] = Seq(
    vacancyInfoSection,
    newEntrantInfoSection,
    postingInfoSection,
    lineManagerDetailsSection
  )

  def postingNoticeFlow(applicationDetails: ApplicationDetails): Unit = {
    enterPostingNoticeForm()
    postingNotice.foreach { f =>
      f(applicationDetails.postingNoticeDetails)
    }
    clickOn(submitForm)
  }
}
