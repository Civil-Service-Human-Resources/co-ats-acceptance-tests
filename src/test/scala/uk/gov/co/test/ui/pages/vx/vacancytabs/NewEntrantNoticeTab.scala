package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{preferredFirstName, randomEmail, randomFirstName, randomLastName, vXJobGradeEquivalent, vXJobGrades, vXJobInfoDepartment, vXProfession, vXTypeOfRole, vacancyFormId, vacancyId, vacancyName}
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.extractApplicationId
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{completeNewEntrantFormBarId, finaliseNenBarId, firstDayArrangementsAfterPnBarId, onboardingCompleteNen, onboardingFinaliseNen, passChecksBarId, requestUpdatedNenBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractTabFormId
import uk.gov.co.test.ui.pages.vx.vacancytabs.PostingNoticeTab.waitForVisibilityOfElementById

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.collection.mutable.ListBuffer

case class NewEntrantNoticeDetails(
  costCentre: String,
  sopOrg: String,
  sopPosition: String,
  businessUnit: String,
  newEntrantType: String,
  isPromotion: Boolean,
  fairAndOpenRecruitment: Boolean,
  permittedExemptionApplies: String,
  startDate: LocalDate,
  startTime: String,
  premOfficeAddress: String,
  dualLocation: Boolean,
  secondLocation: String,
  employmentType: String,
  isApprenticeship: Boolean,
  percentageOfSalary: String,
  apprenticeshipContractLength: String,
  contractEndDate: LocalDate,
  reasonForHire: String,
  keyResponsibilities: String,
  workingPattern: String,
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
  ogdEntryDate: LocalDate,
  lineManagersFullName: String,
  lineManagersTeleCode: String,
  lineManagersTeleNo: String,
  lineManagersEmail: String,
  lineManagersStaffNo: String
)

object NewEntrantNoticeTab extends VacancyBasePage {

  private lazy val emailChecksClearPath    = ".//span[@title='Generate Communication : VH - Checks Clear']"
  val newEntrantNoticeTabPath = ".//span[@class='main-label' and text() = 'New Entrant Notification']"
  def correspondenceSendId                 = "correspondence_form_form_submit"
  def newEntrantNotificationHeaderId       = s"${vacancyFormId}_label_146446_1"
  def newEntrantNoticeInfoId               = s"${vacancyFormId}_label_140309_1"
  def nenVacancyInfoHeaderId               = s"${vacancyFormId}_label_146441_1"
  def newEntrantTypeExternalId             = s"${vacancyFormId}_datafield_90537_1_1_15217"
  def newEntrantTypeOgdId                  = s"${vacancyFormId}_datafield_90537_1_1_15218"
  def newEntrantTypeNdpbId                 = s"${vacancyFormId}_datafield_90537_1_1_17678"
  def isPromotionYesId                     = s"${vacancyFormId}_datafield_82063_1_1_1"
  def isPromotionNoId                      = s"${vacancyFormId}_datafield_82063_1_1_2"
  def fairAndOpenRecruitmentYesId          = s"${vacancyFormId}_datafield_82067_1_1_1"
  def fairAndOpenRecruitmentNoId           = s"${vacancyFormId}_datafield_82067_1_1_2"
  def permittedExemptionAppliesId          = s"select2-${vacancyFormId}_datafield_126910_1_1-container"
  def vacancyRefId                         = s"${vacancyFormId}_label_81806_1"
  def vacancyTitleId                       = s"${vacancyFormId}_label_81811_1"
  def vacancyDeptId                        = s"${vacancyFormId}_label_81816_1"
  def costCentreId                         = s"${vacancyFormId}_datafield_81783_1_1"
  def sopOrgId                             = s"${vacancyFormId}_datafield_142426_1_1"
  def sopPositionId                        = s"${vacancyFormId}_datafield_142433_1_1"
  def businessUnitId                       = s"${vacancyFormId}_datafield_81790_1_1"
  def ogdInfoHeaderId                      = s"${vacancyFormId}_label_146456_1"
  def forenameId                           = s"${vacancyFormId}_label_81827_1"
  def preferredNameId                      = s"${vacancyFormId}_label_143054_1"
  def surnameId                            = s"${vacancyFormId}_label_81832_1"
  def preferredEmailId                     = s"${vacancyFormId}_label_90477_1"
  def postingInfoHeaderId                  = s"${vacancyFormId}_label_146451_1"
  def startDateDayId                       = s"${vacancyFormId}_datafield_82079_1_1--DAY"
  def startDateMonthId                     = s"${vacancyFormId}_datafield_82079_1_1--MONTH"
  def startDateYearId                      = s"${vacancyFormId}_datafield_82079_1_1--YEAR"
  def startTimeHourId                      = s"${vacancyFormId}_datafield_90543_1_1--HOUR"
  def startTimeMinuteId                    = s"${vacancyFormId}_datafield_90543_1_1--MIN"
  def premOfficeAddressId                  = s"${vacancyFormId}_datafield_82091_1_1"
  def dualLocationYesId                    = s"${vacancyFormId}_datafield_138406_1_1_1"
  def dualLocationNoId                     = s"${vacancyFormId}_datafield_138406_1_1_2"
  def secondLocationId                     = s"${vacancyFormId}_datafield_138410_1_1"
  def employmentTypeId                     = s"select2-${vacancyFormId}_datafield_207496_1_1-container"
  def isApprenticeshipYesId                = s"${vacancyFormId}_datafield_167828_1_1_1"
  def isApprenticeshipNoId                 = s"${vacancyFormId}_datafield_167828_1_1_2"
  def percentageOfSalary90Id               = s"${vacancyFormId}_datafield_207537_1_1_54032"
  def percentageOfSalary100Id              = s"${vacancyFormId}_datafield_207537_1_1_54033"
  def apprenticeshipContractLengthId       = s"select2-${vacancyFormId}_datafield_207541_1_1-container"
  def reasonForHireTextId                  = s"${vacancyFormId}_field_que_176626_1"
  def keyResponsibilitiesTextId            = s"${vacancyFormId}_field_que_183658_1"
  def contractEndDateTextId                = s"${vacancyFormId}_field_que_84301_1"
  def reasonForHireId                      = s"select2-${vacancyFormId}_datafield_176595_1_1-container"
  def keyResponsibilitiesId                = s"${vacancyFormId}_datafield_183634_1_1"
  def contractEndDateDayId                 = s"${vacancyFormId}_datafield_82167_1_1--DAY"
  def contractEndDateMonthId               = s"${vacancyFormId}_datafield_82167_1_1--MONTH"
  def contractEndDateYearId                = s"${vacancyFormId}_datafield_82167_1_1--YEAR"
  def promotionId                          = s"${vacancyFormId}_datafield_84425_1_1_15264"
  def regradeId                            = s"${vacancyFormId}_datafield_84425_1_1_41895"
  def tempCoverId                          = s"${vacancyFormId}_datafield_84425_1_1_41956"
  def gradeId                              = s"${vacancyFormId}_label_82083_1"
  def equivalentGradeId                    = s"${vacancyFormId}_label_121700_1"
  def jobCategoryId                        = s"${vacancyFormId}_label_121444_1"
  def professionId                         = s"${vacancyFormId}_label_121440_1"
  def ogdEntryDateDayId                    = s"${vacancyFormId}_datafield_82481_1_1--DAY"
  def ogdEntryDateMonthId                  = s"${vacancyFormId}_datafield_82481_1_1--MONTH"
  def ogdEntryDateYearId                   = s"${vacancyFormId}_datafield_82481_1_1--YEAR"
  def workingPatternFullTimeId             = s"${vacancyFormId}_datafield_90896_1_1_3979"
  def workingPatternPartTimeId             = s"${vacancyFormId}_datafield_90896_1_1_3981"
  def workingPatternAnnualisedHrsId        = s"${vacancyFormId}_datafield_90896_1_1_45109"
  def workingPatternCompressedHrsId        = s"${vacancyFormId}_datafield_90896_1_1_17679"
  def workingPatternFlexibleWorkingId      = s"${vacancyFormId}_datafield_90896_1_1_3978"
  def workingPatternHomeworkingId          = s"${vacancyFormId}_datafield_90896_1_1_3982"
  def workingPatternJobShareId             = s"${vacancyFormId}_datafield_90896_1_1_3980"
  def workingPatternPartYearId             = s"${vacancyFormId}_datafield_90896_1_1_17680"
  def workingPatternShiftWorkingId         = s"${vacancyFormId}_datafield_90896_1_1_17681"
  def workingPatternTermTimeWorkingId      = s"${vacancyFormId}_datafield_90896_1_1_45782"
  def weeklyWorkingHoursId                 = s"${vacancyFormId}_datafield_82151_1_1"
  def hoursWorkedMonId                     = s"${vacancyFormId}_datafield_82190_1_1"
  def hoursWorkedTuesId                    = s"${vacancyFormId}_datafield_82197_1_1"
  def hoursWorkedWedId                     = s"${vacancyFormId}_datafield_82204_1_1"
  def hoursWorkedThursId                   = s"${vacancyFormId}_datafield_82211_1_1"
  def hoursWorkedFriId                     = s"${vacancyFormId}_datafield_82218_1_1"
  def hoursWorkedSatId                     = s"${vacancyFormId}_datafield_82225_1_1"
  def hoursWorkedSunId                     = s"${vacancyFormId}_datafield_82232_1_1"
  def payZoneId                            = s"select2-${vacancyFormId}_datafield_82248_1_1-container"
  def annualSalaryId                       = s"${vacancyFormId}_datafield_82252_1_1"
  def negotiatedSalaryYesId                = s"${vacancyFormId}_datafield_121647_1_1_1"
  def negotiatedSalaryNoId                 = s"${vacancyFormId}_datafield_121647_1_1_2"
  def negotiatedSalaryDateDayId            = s"${vacancyFormId}_datafield_82259_1_1--DAY"
  def negotiatedSalaryDateMonthId          = s"${vacancyFormId}_datafield_82259_1_1--MONTH"
  def negotiatedSalaryDateYearId           = s"${vacancyFormId}_datafield_82259_1_1--YEAR"
  def allowancesRequiredYesId              = s"${vacancyFormId}_datafield_121650_1_1_1"
  def allowancesRequiredNoId               = s"${vacancyFormId}_datafield_121650_1_1_2"
  def allowancesNameAndAccountId           = s"${vacancyFormId}_datafield_82263_1_1"
  def modernisedTAndCsYesId                = s"${vacancyFormId}_datafield_82270_1_1_1"
  def modernisedTAndCsNoId                 = s"${vacancyFormId}_datafield_82270_1_1_2"
  def conflictsOfInterestYesId             = s"${vacancyFormId}_datafield_207596_1_1_1"
  def conflictsOfInterestNoId              = s"${vacancyFormId}_datafield_207596_1_1_2"
  def lineManagerDetailsHeaderId           = s"${vacancyFormId}_label_146463_1"
  def lineManagersFullNameId               = s"${vacancyFormId}_datafield_82098_1_1"
  def lineManagersTelNoCodeId              = s"select2-${vacancyFormId}_datafield_82105_1_1--DIAL_CODE-container"
  def lineManagersTelNoId                  = s"${vacancyFormId}_datafield_82105_1_1"
  def lineManagersEmailId                  = s"${vacancyFormId}_datafield_82112_1_1"
  def lineManagersStaffNoId                = s"${vacancyFormId}_datafield_82119_1_1"
  def completedById                        = s"${vacancyFormId}_label_95871_1"
  def dateAndTimeUpdatedId                 = s"${vacancyFormId}_label_95885_1"

  def enterNewEntrantNoticeForm(): Unit = {
    checkVacancyStatus("Checks Complete – Decision Required")
    moveVacancyOnAndSendEmail(passChecksBarId, emailChecksClearPath, correspondenceSendId)
    onboardingCompleteNen()
    moveVacancyOnViaTopBar(completeNewEntrantFormBarId, newEntrantNoticeTabPath)
    waitForVisibilityOfElementById(newEntrantNotificationHeaderId).getText shouldEqual "New Entrant Notification"
    waitForVisibilityOfElementById(
      newEntrantNoticeInfoId
    ).getText                                                              shouldEqual "This form must be completed in full - changes cannot be saved unless all mandatory fields are complete."
  }

  def enterNenValue(inputId: String, text: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
    enterOption.clear()
    enterOption.sendKeys(text)
  }

  private def vacancyInfoSection(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    waitForVisibilityOfElementById(nenVacancyInfoHeaderId).getText shouldEqual "Vacancy Information"
    waitForVisibilityOfElementById(vacancyRefId).getText                should endWith(vacancyId)
    waitForVisibilityOfElementById(vacancyTitleId).getText              should endWith(vacancyName)
    waitForVisibilityOfElementById(vacancyDeptId).getText               should endWith(vXJobInfoDepartment)
    enterNenValue(costCentreId, newEntrantNoticeDetails.costCentre)
    enterNenValue(sopOrgId, newEntrantNoticeDetails.sopOrg)
    enterNenValue(sopPositionId, newEntrantNoticeDetails.sopPosition)
    enterNenValue(businessUnitId, newEntrantNoticeDetails.businessUnit)
  }

  private def newEntrantInfoSection(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    waitForVisibilityOfElementById(newEntrantNotificationHeaderId).getText shouldEqual "New Entrant Notification"
    waitForVisibilityOfElementById(forenameId).getText                          should endWith(randomFirstName)
    waitForVisibilityOfElementById(preferredNameId).getText                     should endWith(preferredFirstName)
    waitForVisibilityOfElementById(surnameId).getText                           should endWith(randomLastName)
    waitForVisibilityOfElementById(preferredEmailId).getText                    should endWith(randomEmail)
  }

  private def postingInfoSection(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    waitForVisibilityOfElementById(postingInfoHeaderId).getText shouldEqual "Posting Information"
    selectNewEntrantType(newEntrantNoticeDetails)
    selectFairAndOpenRecruitment(newEntrantNoticeDetails)
    enterStartDate(newEntrantNoticeDetails)
    enterStartTimeFirstDay(newEntrantNoticeDetails)
    waitForVisibilityOfElementById(gradeId).getText                  should endWith(vXJobGrades.mkString(", "))
    waitForVisibilityOfElementById(equivalentGradeId).getText        should endWith(vXJobGradeEquivalent)
    waitForVisibilityOfElementById(jobCategoryId).getText            should endWith(vXTypeOfRole.mkString(", "))
    waitForVisibilityOfElementById(professionId).getText             should endWith(vXProfession)
    enterNenValue(premOfficeAddressId, newEntrantNoticeDetails.premOfficeAddress)
    selectDualLocation(newEntrantNoticeDetails)
    selectEmploymentType(newEntrantNoticeDetails)
    selectIsApprenticeship(newEntrantNoticeDetails)
    selectWorkingPattern(newEntrantNoticeDetails)
    enterNenValue(weeklyWorkingHoursId, newEntrantNoticeDetails.weeklyWorkingHours)
    enterNenValue(hoursWorkedMonId, newEntrantNoticeDetails.monHours)
    enterNenValue(hoursWorkedTuesId, newEntrantNoticeDetails.tuesHours)
    enterNenValue(hoursWorkedWedId, newEntrantNoticeDetails.wedHours)
    enterNenValue(hoursWorkedThursId, newEntrantNoticeDetails.thursHours)
    enterNenValue(hoursWorkedFriId, newEntrantNoticeDetails.friHours)
    enterNenValue(hoursWorkedSatId, newEntrantNoticeDetails.satHours)
    enterNenValue(hoursWorkedSunId, newEntrantNoticeDetails.sunHours)
    selectPayZone(newEntrantNoticeDetails)
    enterNenValue(annualSalaryId, newEntrantNoticeDetails.annualSalary)
    selectNegotiatedSalary(newEntrantNoticeDetails)
    selectAllowancesRequired(newEntrantNoticeDetails)
    selectModernisedTAndCs(newEntrantNoticeDetails)
    selectConflictsOfInterest(newEntrantNoticeDetails)
  }

  private def otherGovernmentDeptInfoSection(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.newEntrantType == "OGD") {
      waitForVisibilityOfElementById(ogdInfoHeaderId).getText shouldEqual "Other Government Department Info"
      enterOgdEntryDate(newEntrantNoticeDetails)
    }

  private def lineManagerDetailsSection(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    waitForVisibilityOfElementById(lineManagerDetailsHeaderId).getText shouldEqual "Line Manager Details"
    enterNenValue(lineManagersFullNameId, newEntrantNoticeDetails.lineManagersFullName)
    waitForVisibilityOfElementById(lineManagersTelNoCodeId).click()
    selectOption(generalInput, newEntrantNoticeDetails.lineManagersTeleCode)
    enterNenValue(lineManagersTelNoId, newEntrantNoticeDetails.lineManagersTeleNo)
    enterNenValue(lineManagersEmailId, newEntrantNoticeDetails.lineManagersEmail)
    enterNenValue(lineManagersStaffNoId, newEntrantNoticeDetails.lineManagersStaffNo)
  }

  private def timeRecord(): Unit = {
    waitForVisibilityOfElementById(submitForm)
    scrollToElement(By.id(submitForm))
    extractTabFormId()
    waitForVisibilityOfElementById(completedById).getText   should endWith("Automation ServiceAcc")
    waitForVisibilityOfElementById(dateAndTimeUpdatedId).getText should startWith("Date and time last updated")
    clickOn(submitForm)
  }

  private def selectNewEntrantType(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    newEntrantNoticeDetails.newEntrantType match {
      case "External" =>
        clickOnRadioButton(newEntrantTypeExternalId)
      case "OGD"      =>
        clickOnRadioButton(newEntrantTypeOgdId)
        selectIsPromotion(newEntrantNoticeDetails)
      case "NDPB"     =>
        clickOnRadioButton(newEntrantTypeNdpbId)
    }

  private def selectIsPromotion(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.isPromotion) {
      clickOnRadioButton(isPromotionYesId)
    } else {
      clickOnRadioButton(isPromotionNoId)
    }

  private def selectFairAndOpenRecruitment(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.fairAndOpenRecruitment) {
      clickOnRadioButton(fairAndOpenRecruitmentYesId)
    } else {
      clickOnRadioButton(fairAndOpenRecruitmentNoId)
      selectPermittedExemptionApplies(newEntrantNoticeDetails)
    }

  private def selectPermittedExemptionApplies(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    val exemption = newEntrantNoticeDetails.permittedExemptionApplies
    waitForVisibilityOfElementById(permittedExemptionAppliesId).click()
    selectOption(generalInput, exemption)
  }

  private def enterStartDate(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    enterDateFields(
      formattedDate(newEntrantNoticeDetails.startDate),
      startDateDayId,
      startDateMonthId,
      startDateYearId
    )

  private def enterStartTimeFirstDay(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    enterTimeFields(newEntrantNoticeDetails.startTime, startTimeHourId, startTimeMinuteId)

  def formattedDate(atDate: LocalDate): String = {
    val formatter     = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formattedDate = atDate.format(formatter)
    formattedDate
  }

  private def selectDualLocation(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.dualLocation) {
      clickOnRadioButton(dualLocationYesId)
      enterNenValue(secondLocationId, newEntrantNoticeDetails.secondLocation)
    } else {
      clickOnRadioButton(dualLocationNoId)
    }

  private def selectEmploymentType(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    val employmentType = newEntrantNoticeDetails.employmentType
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
      enterContractEndDate(newEntrantNoticeDetails)
      selectReasonForHire(newEntrantNoticeDetails)
      enterNenValue(keyResponsibilitiesId, newEntrantNoticeDetails.keyResponsibilities)
    }
  }

  private def enterOgdEntryDate(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    enterDateFields(
      formattedDate(newEntrantNoticeDetails.ogdEntryDate),
      ogdEntryDateDayId,
      ogdEntryDateMonthId,
      ogdEntryDateYearId
    )

  private def selectIsApprenticeship(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.isApprenticeship) {
      clickOnRadioButton(isApprenticeshipYesId)
      selectPercentageOfSalary(newEntrantNoticeDetails)
      selectApprenticeshipContractLength(newEntrantNoticeDetails)
    } else {
      clickOnRadioButton(isApprenticeshipNoId)
    }

  private def selectPercentageOfSalary(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    newEntrantNoticeDetails.percentageOfSalary match {
      case "90%"  => clickOnRadioButton(percentageOfSalary90Id)
      case "100%" => clickOnRadioButton(percentageOfSalary100Id)
    }

  private def selectApprenticeshipContractLength(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    val length = newEntrantNoticeDetails.apprenticeshipContractLength
    waitForVisibilityOfElementById(apprenticeshipContractLengthId).click()
    selectOption(generalInput, length)
  }

  def selectReasonForHire(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    waitForVisibilityOfElementById(reasonForHireId).click()
    action().moveToElement(waitForDropdownOption(newEntrantNoticeDetails.reasonForHire)).perform()
    waitForDropdownOption(newEntrantNoticeDetails.reasonForHire).click()
  }

  private def enterContractEndDate(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    enterDateFields(
      formattedDate(newEntrantNoticeDetails.contractEndDate),
      contractEndDateDayId,
      contractEndDateMonthId,
      contractEndDateYearId
    )

  private def selectWorkingPattern(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    newEntrantNoticeDetails.workingPattern match {
      case "Full-time"         => clickOnRadioButton(workingPatternFullTimeId)
      case "Part-time"         => clickOnRadioButton(workingPatternPartTimeId)
      case "Annualised hours"  => clickOnRadioButton(workingPatternAnnualisedHrsId)
      case "Compressed Hours"  => clickOnRadioButton(workingPatternCompressedHrsId)
      case "Flexible working"  => clickOnRadioButton(workingPatternFlexibleWorkingId)
      case "Homeworking"       => clickOnRadioButton(workingPatternHomeworkingId)
      case "Job share"         => clickOnRadioButton(workingPatternJobShareId)
      case "Part Year"         => clickOnRadioButton(workingPatternPartYearId)
      case "Shift Working"     => clickOnRadioButton(workingPatternShiftWorkingId)
      case "Term time working" => clickOnRadioButton(workingPatternTermTimeWorkingId)
    }

  private def selectPayZone(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit = {
    scrollToElement(By.id(payZoneId))
    enterTypeRoles(newEntrantNoticeDetails.payZone, payZoneId)
  }

  private def selectNegotiatedSalary(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.negotiatedSalary) {
      clickOnRadioButton(negotiatedSalaryYesId)
      enterNegotiatedSalaryDate(newEntrantNoticeDetails)
    } else {
      clickOnRadioButton(negotiatedSalaryNoId)
    }

  private def enterNegotiatedSalaryDate(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    enterDateFields(
      formattedDate(newEntrantNoticeDetails.negotiatedSalaryDate),
      negotiatedSalaryDateDayId,
      negotiatedSalaryDateMonthId,
      negotiatedSalaryDateYearId
    )

  private def selectAllowancesRequired(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.allowancesRequired) {
      clickOnRadioButton(allowancesRequiredYesId)
      enterNenValue(allowancesNameAndAccountId, newEntrantNoticeDetails.allowancesNameAndAccount)
    } else {
      clickOnRadioButton(allowancesRequiredNoId)
    }

  private def selectModernisedTAndCs(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.modernisedTAndCs) clickOnRadioButton(modernisedTAndCsYesId)
    else clickOnRadioButton(modernisedTAndCsNoId)

  private def selectConflictsOfInterest(newEntrantNoticeDetails: NewEntrantNoticeDetails): Unit =
    if (newEntrantNoticeDetails.conflictsOfInterest) clickOnRadioButton(conflictsOfInterestYesId)
    else clickOnRadioButton(conflictsOfInterestNoId)

  private val nen: Seq[NewEntrantNoticeDetails => Unit] = Seq(
    vacancyInfoSection,
    newEntrantInfoSection,
    postingInfoSection,
    otherGovernmentDeptInfoSection,
    lineManagerDetailsSection
  )

  def newEntrantNoticeFlow(applicationDetails: ApplicationDetails): Unit = {
    enterNewEntrantNoticeForm()
    nen.foreach { f =>
      f(applicationDetails.newEntrantNoticeDetails)
    }
    clickOn(submitForm)
    if (waitForVisibilityOfElementById(requestUpdatedNenBarId).isDisplayed) onboardingFinaliseNen()
    waitForVisibilityOfElementById(finaliseNenBarId).click()
    timeRecord()
  }
}
