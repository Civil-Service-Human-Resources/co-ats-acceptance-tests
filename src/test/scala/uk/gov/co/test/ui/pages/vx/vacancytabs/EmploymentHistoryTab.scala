package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.data.vx.ApplicationSummaryDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{v9EmployedWithin3Years, v9FirstEmployerFromDate, v9FirstEmployerName}
import uk.gov.co.test.ui.pages.v9.longform.UploadDocumentsPage.importFilesPath
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.employmentHistoryBarId
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class HistoryDetails(
                           directHmrcPayeAccess: Boolean,
                           historyCheckStarted: LocalDate,
                           eehcEvidence: String,
                           requireInfoToComplete: Boolean,
                           requireFurtherReferences: Boolean,
                           sentCheckToGrs: Boolean,
                           dateCheckSentToGrs: LocalDate,
                           receivedGrsHistoryCheck: Boolean,
                           dateHistoryCheckReceived: LocalDate,
                           historyCheckOutcome: Boolean,
                           checkOutcome: String,
                           dateCheckCompleted: LocalDate,
                           dateInfoRequested: LocalDate,
                           dateInfoReceived: LocalDate,
                           riskAssessmentComments: String,
                           dateBF: LocalDate,
                           internalNotes: String
)

object EmploymentHistoryTab extends VacancyBasePage {

  private lazy val employmentHistoryTabPath = ".//span[@class='main-label' and text() = 'Employment history form']"
  def directHmrcPayeSectionId               = s"${vacancyFormId}_field_77927_1"
  def everBeenEmployedId                    = s"${vacancyFormId}_label_146612_1"
  def employerOneNameId                     = s"${vacancyFormId}_label_146618_1"
  def employerOneDateFromId                 = s"${vacancyFormId}_label_146621_1"
  def employerOneDateToId                   = s"${vacancyFormId}_label_146624_1"
  def directHmrcPayeAccessYesId             = s"${vacancyFormId}_datafield_77927_1_1_1"
  def directHmrcPayeAccessNoId              = s"${vacancyFormId}_datafield_77927_1_1_2"
  def historyCheckStartedDayId              = s"${vacancyFormId}_datafield_179442_1_1--DAY"
  def historyCheckStartedMonthId            = s"${vacancyFormId}_datafield_179442_1_1--MONTH"
  def historyCheckStartedYearId             = s"${vacancyFormId}_datafield_179442_1_1--YEAR"
  def checkSentToGrsDayId                   = s"${vacancyFormId}_datafield_97391_1_1--DAY"
  def checkSentToGrsMonthId                 = s"${vacancyFormId}_datafield_97391_1_1--MONTH"
  def checkSentToGrsYearId                  = s"${vacancyFormId}_datafield_97391_1_1--YEAR"
  def uploadEehcEvidenceId                  = s"${vacancyFormId}_datafield_77939_1_1"
  def furtherInfoRequiredYesId              = s"${vacancyFormId}_datafield_179445_1_1_1"
  def furtherInfoRequiredNoId               = s"${vacancyFormId}_datafield_179445_1_1_2"
  def receivedHistoryCheckYesId             = s"${vacancyFormId}_datafield_97387_1_1_1"
  def receivedHistoryCheckNoId              = s"${vacancyFormId}_datafield_97387_1_1_2"
  def historyCheckPassedId                  = s"${vacancyFormId}_datafield_79523_1_1_15197"
  def referToRiskAssessmentId               = s"${vacancyFormId}_datafield_79523_1_1_15285"
  def riskAssessmentCommentsInputId         = s"${vacancyFormId}_datafield_179579_1_1"
  def internalNotesInputId                  = s"${vacancyFormId}_datafield_77943_1_1"
  def sentCheckForGrsYesId                  = s"${vacancyFormId}_datafield_97383_1_1_1"
  def sentCheckForGrsNoId                   = s"${vacancyFormId}_datafield_97383_1_1_2"
  def historySearchOutcomeYesId             = s"${vacancyFormId}_datafield_179531_1_1_1"
  def historySearchOutcomeNoId              = s"${vacancyFormId}_datafield_179531_1_1_2"
  def additionalInfoReceivedYesId           = s"${vacancyFormId}_datafield_179732_1_1_1"
  def additionalInfoReceivedNoId            = s"${vacancyFormId}_datafield_179732_1_1_2"
  def checkReceivedDayId                    = s"${vacancyFormId}_datafield_97395_1_1--DAY"
  def checkReceivedMonthId                  = s"${vacancyFormId}_datafield_97395_1_1--MONTH"
  def checkReceivedYearId                   = s"${vacancyFormId}_datafield_97395_1_1--YEAR"
  def bFDateDayId                           = s"${vacancyFormId}_datafield_179512_1_1--DAY"
  def bFDateMonthId                         = s"${vacancyFormId}_datafield_179512_1_1--MONTH"
  def bFDateYearId                          = s"${vacancyFormId}_datafield_179512_1_1--YEAR"
  def checkOutcomeCompletedDayId            = s"${vacancyFormId}_datafield_77931_1_1--DAY"
  def checkOutcomeCompletedMonthId          = s"${vacancyFormId}_datafield_77931_1_1--MONTH"
  def checkOutcomeCompletedYearId           = s"${vacancyFormId}_datafield_77931_1_1--YEAR"
  def additionalInfoRequestedDayId          = s"${vacancyFormId}_datafield_179728_1_1--DAY"
  def additionalInfoRequestedMonthId        = s"${vacancyFormId}_datafield_179728_1_1--MONTH"
  def additionalInfoRequestedYearId         = s"${vacancyFormId}_datafield_179728_1_1--YEAR"
  def additionalInfoReceivedDayId           = s"${vacancyFormId}_datafield_179548_1_1--DAY"
  def additionalInfoReceivedMonthId         = s"${vacancyFormId}_datafield_179548_1_1--MONTH"
  def additionalInfoReceivedYearId          = s"${vacancyFormId}_datafield_179548_1_1--YEAR"
  def furtherReferencesRequiredYesId        = s"${vacancyFormId}_datafield_179495_1_1_1"
  def furtherReferencesRequiredNoId         = s"${vacancyFormId}_datafield_179495_1_1_2"
  def automatedRefereeContactTextId         = s"${vacancyFormId}_label_98302_1"

  def completeVXEmploymentHistory(): Unit = {
    checkVacancyStatus("Pre Employment Checks")
    moveVacancyOnViaTopBar(employmentHistoryBarId, employmentHistoryTabPath)
    val anyEmployment3Years = if (v9EmployedWithin3Years) "Yes" else "No"
    waitForVisibilityOfElementById(everBeenEmployedId).getText    should endWith(s"$anyEmployment3Years")
    waitForVisibilityOfElementById(employerOneNameId).getText     should endWith(v9FirstEmployerName)
    waitForVisibilityOfElementById(employerOneDateFromId).getText should endWith(
      s"${formatEmploymentDate(v9FirstEmployerFromDate)}"
    )
    //TODO Uncomment once issue is fixed and it appears
//    waitForVisibilityOfElementById(employerOneDateToId).getText should endWith(
//      s"${formatEmploymentDate(v9FirstEmployerToDate)}"
//    )
  }

  private def selectDirectHmrcPayeAccess(historyDetails: HistoryDetails): Unit = {
    scrollToElement(By.id(directHmrcPayeSectionId))
    if (historyDetails.directHmrcPayeAccess) {
      clickOnRadioButton(directHmrcPayeAccessYesId)
      enterDateHistoryCheckStarted(historyDetails)
      uploadEehcEvidence(historyDetails)
    } else {
      clickOnRadioButton(directHmrcPayeAccessNoId)
      selectSentCheckForGrs(historyDetails)
    }
  }

  private def selectSentCheckForGrs(historyDetails: HistoryDetails): Unit =
    if (historyDetails.sentCheckToGrs) {
      clickOnRadioButton(sentCheckForGrsYesId)
      enterDateCheckSentToGrs(historyDetails)
      selectReceivedHistoryCheck(historyDetails)
    } else clickOnRadioButton(sentCheckForGrsNoId)

  private def selectReceivedHistoryCheck(historyDetails: HistoryDetails): Unit =
    if (historyDetails.receivedGrsHistoryCheck) {
      clickOnRadioButton(receivedHistoryCheckYesId)
      enterDateCheckReceivedFromGrs(historyDetails)
      uploadEehcEvidence(historyDetails)
    } else radioClick(receivedHistoryCheckNoId)

  def formattedDate(atDate: LocalDate): String = {
    val formatter     = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formattedDate = atDate.format(formatter)
    formattedDate
  }

  private def enterDateHistoryCheckStarted(historyDetails: HistoryDetails): Unit =
    enterDateFields(
      formattedDate(historyDetails.historyCheckStarted),
      historyCheckStartedDayId,
      historyCheckStartedMonthId,
      historyCheckStartedYearId
    )

  private def enterDateCheckSentToGrs(historyDetails: HistoryDetails): Unit =
    enterDateFields(
      formattedDate(historyDetails.dateCheckSentToGrs),
      checkSentToGrsDayId,
      checkSentToGrsMonthId,
      checkSentToGrsYearId
    )

  private def enterDateCheckCompleted(historyDetails: HistoryDetails): Unit =
    enterDateFields(
      formattedDate(historyDetails.dateCheckCompleted),
      checkOutcomeCompletedDayId,
      checkOutcomeCompletedMonthId,
      checkOutcomeCompletedYearId
    )

  private def enterDateCheckReceivedFromGrs(historyDetails: HistoryDetails): Unit =
    enterDateFields(
      formattedDate(historyDetails.dateHistoryCheckReceived),
      checkReceivedDayId,
      checkReceivedMonthId,
      checkReceivedYearId
    )

  private def enterDateAdditionalInfoReceived(historyDetails: HistoryDetails): Unit =
    enterDateFields(
      formattedDate(historyDetails.dateInfoReceived),
      additionalInfoReceivedDayId,
      additionalInfoReceivedMonthId,
      additionalInfoReceivedYearId
    )

  private def enterDateAdditionalInfoRequested(historyDetails: HistoryDetails): Unit =
    enterDateFields(
      formattedDate(historyDetails.dateInfoRequested),
      additionalInfoRequestedDayId,
      additionalInfoRequestedMonthId,
      additionalInfoRequestedYearId
    )

  private def enterDateBF(historyDetails: HistoryDetails): Unit =
    enterDateFields(
      formattedDate(historyDetails.dateBF),
      bFDateDayId,
      bFDateMonthId,
      bFDateYearId
    )

  def formatEmploymentDate(dateToFormat: String): String = {
    val formatter1    = DateTimeFormatter.ofPattern("d/MM/uuuu")
    val formatter2    = DateTimeFormatter.ofPattern("d MMMM yyyy")
    val formattedDate = LocalDate.parse(dateToFormat, formatter1)
    formattedDate.format(formatter2)
  }

  def extractTabFormId(): String = {
    val formId = waitForVisibilityOfElementByPath(".//form[@class='form-horizontal']")
    vacancyFormId = formId.getAttribute("id")
    vacancyFormId
  }

  private def uploadEehcEvidence(historyDetails: HistoryDetails): Unit =
    if (historyDetails.sentCheckToGrs || historyDetails.directHmrcPayeAccess) {
      val getCurrentDirectory     = new java.io.File(".").getCanonicalPath
      val filePath                = getCurrentDirectory.concat(importFilesPath).concat(historyDetails.eehcEvidence)
      val fileElement: WebElement = id(uploadEehcEvidenceId).findElement.get.underlying
      fileElement.sendKeys(filePath)
      selectFurtherInfoRequired(historyDetails)
    }

  private def selectFurtherInfoRequired(historyDetails: HistoryDetails): Unit =
    if (historyDetails.requireInfoToComplete) {
      clickOnRadioButton(furtherInfoRequiredYesId)
      waitForVisibilityOfElementById(
        automatedRefereeContactTextId
      ).getText shouldEqual "Candidate referees will be contacted automatically if they’ve consented, if you select that references are required and this is the first time you are requesting them. To re-request references check consent has been provided and use the Issue/Reissue reference buttons after this form is submitted"
      requireFurtherReferences(historyDetails)
      selectHistoryCheckOutcome(historyDetails)
    } else {
      clickOnRadioButton(furtherInfoRequiredNoId)
      selectCheckOutcome(historyDetails)
    }

  private def requireFurtherReferences(historyDetails: HistoryDetails): Unit =
    if (historyDetails.requireFurtherReferences) {
      clickOnRadioButton(furtherReferencesRequiredYesId)
    } else {
      clickOnRadioButton(furtherReferencesRequiredNoId)
    }

  private def selectHistoryCheckOutcome(historyDetails: HistoryDetails): Unit =
    if (historyDetails.historyCheckOutcome) {
      clickOnRadioButton(historySearchOutcomeYesId)
      enterDateCheckCompleted(historyDetails)
      selectCheckOutcome(historyDetails)
    } else {
      clickOnRadioButton(historySearchOutcomeNoId)
      enterDateAdditionalInfoRequested(historyDetails)
      selectAdditionalInfoReceived(historyDetails)
    }

  private def selectCheckOutcome(historyDetails: HistoryDetails): Unit =
    if (
      historyDetails.historyCheckOutcome || !historyDetails.requireInfoToComplete || historyDetails.receivedGrsHistoryCheck
    ) {
      val outcome = historyDetails.checkOutcome
      outcome match {
        case "Passed"                   =>
          clickOnRadioButton(historyCheckPassedId)
        case "Refer to risk assessment" =>
          clickOnRadioButton(referToRiskAssessmentId)
          enterText(riskAssessmentCommentsInputId, historyDetails.riskAssessmentComments)
      }
    }

  private def enterInternalNotes(historyDetails: HistoryDetails): Unit =
    enterText(internalNotesInputId, historyDetails.internalNotes)

  private def selectAdditionalInfoReceived(historyDetails: HistoryDetails): Unit =
    if (historyDetails.historyCheckOutcome) {
      clickOnRadioButton(additionalInfoReceivedYesId)
      enterDateAdditionalInfoReceived(historyDetails)
      selectCheckOutcome(historyDetails)
    } else {
      clickOnRadioButton(additionalInfoReceivedNoId)
      enterDateBF(historyDetails)
    }

  private val history: Seq[HistoryDetails => Unit] = Seq(
    selectDirectHmrcPayeAccess,
    enterInternalNotes
  )

  def EmploymentHistoryVXFlow(applicationSummaryDetails: ApplicationSummaryDetails): Unit = {
    completeVXEmploymentHistory()
    history.foreach { f =>
      f(applicationSummaryDetails.historyDetails)
    }
    clickOn(submitForm)
  }
}
