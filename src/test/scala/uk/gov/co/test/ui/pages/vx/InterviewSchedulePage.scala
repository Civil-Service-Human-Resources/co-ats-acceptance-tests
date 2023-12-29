package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.data.TestData.eventually
import uk.gov.co.test.ui.data.vx.ApplicationDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXInstructionsForCandidates, vXInterviewDate, vXInterviewLocation, vXInterviewLongDate, vXInterviewNumber, vXInterviewScheduleTitle, vXInterviewShortDate}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, confirmCandidateSummary, inviteToI1BarId, inviteToI2BarId, inviteToI3BarId, scheduleOfflineI1BarId, scheduleOfflineI2BarId, scheduleOfflineI3BarId, withdrawAtInterviewBarId}
import uk.gov.co.test.ui.pages.vx.createvacancypage.AdvertSection.switchBack

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class InterviewScheduleDetails(
  useCopyFrom: Boolean,
  copyFrom: Option[String] = None,
  copyFromTemplate: String,
  copyFromInterviewSchedule: String,
  interviewTitle: String,
  addWelshTitle: Boolean,
  welshInterviewTitle: String,
  daysAfterCurrentDate: Int,
  interviewRound: String,
  assignCoordinator: Boolean,
  coordinator: String,
  internalNotes: String,
  addWelshInternalNotes: Boolean,
  welshInternalNotes: String,
  instructionsForCandidate: String,
  addWelshInstructionsForCandidate: Boolean,
  welshInstructionsForCandidate: String,
  interviewLocation: String,
  preventCandidateRescheduling: Boolean,
  minAlterationNotice: Int,
  timezone: String,
  candidateTimeFormat: String,
  inviteEmailTemplate: String,
  bookedEmailTemplate: String,
  includeCVInICal: Boolean
)

object InterviewSchedulePage extends VacancyBasePage {

  private lazy val createInterviewSchedulePageTitle      = "Create Interview Schedule : Civil Service Jobs - GOV.UK"
  private lazy val createScheduleTitlePath               = ".//*[@id='page_navbar']/div/span"
  private lazy val createInterviewSchedulePath           = ".//a[contains(@href,'recruiter/interviews/create_interview')]"
  private lazy val viewInterviewSchedulePath             = "//*[@id='lm-interviews']/ul/li[2]/a"
  private lazy val interviewsSectionPath                 = ".//*[@id='lm-interviews']/h3/a"
  private lazy val copyFromId                            = "select2-details_form_populate_from-container"
  private lazy val copyFromTemplateId                    = "select2-details_form_template_id-container"
  private lazy val copyFromInterviewScheduleId           = "select2-details_form_copy_int_id-container"
  private lazy val interviewTitleId                      = "details_form_title_en-GB"
  private lazy val welshInterviewTitleId                 = "details_form_title_button"
  private lazy val welshInterviewTitleInputId            = "details_form_title_cy"
  private lazy val welshInterviewTitleUpdateId           = "lbledit_details_form_title-update"
  private lazy val dateId                                = "details_form_day"
  private lazy val interviewRoundId                      = "select2-details_form_action_group-container"
  private lazy val coordinatorId                         = "select2-details_form_coordinator-container"
  private lazy val internalNotesIFrameId                 = "details_form_description_en-GB_ifr"
  private lazy val internalNotesId                       = "tinymce"
  private lazy val welshInternalNotesIFrameId            = "details_form_description_cy_ifr"
  private lazy val welshInternalNotesId                  = "details_form_description_button"
  private lazy val welshInternalNotesUpdateId            = "lbledit_details_form_description-update"
  private lazy val instructionsForCandidateIFrameId      = "details_form_candidate_description_en-GB_ifr"
  private lazy val instructionsForCandidateId            = "tinymce"
  private lazy val welshInstructionsForCandidateId       = "details_form_candidate_description_button"
  private lazy val welshInstructionsForCandidateIFrameId = "details_form_candidate_description_cy_ifr"
  private lazy val welshInstructionsForCandidateUpdateId = "lbledit_details_form_candidate_description-update"
  private lazy val interviewLocationId                   = "details_form_master_location_id"
  private lazy val preventCandidateReschedulingId        = "details_form_prevent_candidate_reschedule"
  private lazy val minAlterationNoticeId                 = "details_form_min_alteration_notice"
  private lazy val timezoneId                            = "select2-details_form_time_zone-container"
  private lazy val candidateTimeFormatId                 = "select2-details_form_timeformat_id-container"
  private lazy val inviteEmailTemplateId                 = "select2-details_form_email_invite_id-container"
  private lazy val bookedEmailTemplateId                 = "select2-details_form_email_confirm_id-container"
  private lazy val includeCandidateCVInICalsId           = "details_form_ical_attach_candidate_cv"
  private lazy val createId                              = "details_form_form_submit"
  private lazy val interviewId                           = ".//th[@aria-label='Interview ID: activate to sort column descending']"

  private def createSchedule: WebElement        = waitForVisibilityOfElementByPathLast(createInterviewSchedulePath)
  private def viewInterviewSchedule: WebElement = waitForVisibilityOfElementByPathLast(viewInterviewSchedulePath)
  private def interviewsSection: WebElement     = waitForVisibilityOfElementByPathLast(interviewsSectionPath)
  private def interviewDate(): TextField        = textField(dateId)
  private def interviewLocation(): TextField    = textField(interviewLocationId)

  private def createInterviewSchedulePageCheck(): Unit =
    eventually(onPage(createInterviewSchedulePageTitle))

  private def checkInterviewStatus(): Unit = {
    val newStatus = s"Selected for Interview ${vXInterviewNumber.head}"
    confirmCandidateSummary(newStatus)
    checkForNewValuePath(vacancyStatusPath, newStatus)
    vXInterviewNumber.head match {
      case "1" => availableBarItems(List(inviteToI1BarId, scheduleOfflineI1BarId, withdrawAtInterviewBarId))
      case "2" => availableBarItems(List(inviteToI2BarId, scheduleOfflineI2BarId, withdrawAtInterviewBarId))
      case "3" => availableBarItems(List(inviteToI3BarId, scheduleOfflineI3BarId, withdrawAtInterviewBarId))
    }
  }

  private def createInterviewSchedule(): Unit = {
    val scheduleTitle = "Create Interview Schedule"
    if (createSchedule.getText == scheduleTitle) createSchedule.click()
    else {
      interviewsSection.click()
      createSchedule.click()
    }
    createInterviewSchedulePageCheck()
    waitForVisibilityOfElementByPath(createScheduleTitlePath).getText shouldEqual scheduleTitle
  }

  def untagVacancy(): Unit = {
    val viewSchedule  = "View Interview Schedule"
    if (viewInterviewSchedule.getText == viewSchedule) viewInterviewSchedule.click()
    else {
      interviewsSection.click()
      viewInterviewSchedule.click()
    }
    waitForVisibilityOfElementByPath(".//*[@class='column1 sorting sorting_asc']").click()
    waitForVisibilityOfElementByPath(".//tr[@tabindex='-1'][1]").click()
    waitForVisibilityOfElementByPath(".//a[text()='Edit']").click()
    waitForVisibilityOfElementByPath(".//span[@class='main-label' and text() = 'Tagged Vacancies']").click()
    val taggedVacancy = driver.findElements(By.xpath(".//tr[@tabindex='-1'][1]"))
    if (taggedVacancy.size() == 1) {
      waitForVisibilityOfElementByPath(".//tr[@tabindex='-1'][1]").click()
      waitForVisibilityOfElementById("but_remove_opportunity").click()
    }
  }

  def selectCopyFrom(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails
    if (schedule.useCopyFrom) {
      selectDropdownOption(copyFromId, schedule.copyFrom.get)
      schedule.copyFrom.get match {
        case "Copy From Template"           => selectDropdownOption(copyFromTemplateId, schedule.copyFromTemplate)
        case "Copy From Interview Schedule" =>
          selectOptionFromList(
            schedule.copyFromInterviewSchedule,
            copyFromInterviewScheduleId,
            schedule.copyFromInterviewSchedule
          )
      }
    }
  }

  private def enterInterviewTitle(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails
    vXInterviewScheduleTitle = schedule.interviewTitle.format(vXInterviewNumber.head)
    enterValue(interviewTitleId, vXInterviewScheduleTitle)
    addWelshTranslation(
      schedule.addWelshTitle,
      welshInterviewTitleId,
      welshInterviewTitleInputId,
      schedule.welshInterviewTitle,
      welshInterviewTitleUpdateId
    )
  }

  private def selectInterviewDate(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails
    interviewDate().value = interviewScheduleDate(schedule.daysAfterCurrentDate + vXInterviewNumber.head.toInt)
  }

  def interviewScheduleDate(days: Int): String = {
    val formatter  = DateTimeFormatter.ofPattern("dd/MM/uuuu")
    val formatter2 = DateTimeFormatter.ofPattern("d MMMM uuuu")
    val formatter3 = DateTimeFormatter.ofPattern("d MMM uuuu")
    val now        = LocalDate.now()
    val addDays    = now.plusDays(days)
    vXInterviewLongDate = addDays.format(formatter2)
    vXInterviewShortDate = addDays.format(formatter3)
    vXInterviewDate = addDays.format(formatter)
    vXInterviewDate
  }

  def selectInterviewRound(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails.interviewRound.format(vXInterviewNumber.head)
    selectDropdownOption(interviewRoundId, schedule)
  }

  private def selectCoordinator(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails
    if (schedule.assignCoordinator) {
      selectOptionFromList(schedule.coordinator, coordinatorId, s" $contactNameVxConfig - ${schedule.coordinator}")
    }
  }

  private def enterInternalNotes(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule    = interviewScheduleDetails
    val switchFrame = driver.switchTo().frame(internalNotesIFrameId)
    val notesArea   = switchFrame.findElement(By.id(internalNotesId))
    notesArea.clear()
    notesArea.sendKeys(schedule.internalNotes.format(vXInterviewNumber.head))
    switchBack()
    addWelshTranslationIFrame(
      schedule.addWelshTitle,
      welshInternalNotesId,
      welshInternalNotesIFrameId,
      internalNotesId,
      schedule.welshInterviewTitle,
      welshInternalNotesUpdateId
    )
  }

  private def enterInstructionsForCandidate(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule    = interviewScheduleDetails
    vXInstructionsForCandidates = schedule.instructionsForCandidate.format(vXInterviewNumber.head)
    val switchFrame = driver.switchTo().frame(instructionsForCandidateIFrameId)
    val notesArea   = switchFrame.findElement(By.id(instructionsForCandidateId))
    notesArea.clear()
    notesArea.sendKeys(vXInstructionsForCandidates)
    switchBack()
    addWelshTranslationIFrame(
      schedule.addWelshInstructionsForCandidate,
      welshInstructionsForCandidateId,
      welshInstructionsForCandidateIFrameId,
      instructionsForCandidateId,
      schedule.welshInstructionsForCandidate,
      welshInstructionsForCandidateUpdateId
    )
  }

  private def selectInterviewLocation(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails
    vXInterviewLocation = schedule.interviewLocation
    interviewLocation().value = vXInterviewLocation
  }

  private def checkPreventCandidateRescheduling(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val reschedule   = interviewScheduleDetails.preventCandidateRescheduling
    val rescheduling = waitForVisibilityOfElementById(preventCandidateReschedulingId)
    if ((reschedule && !rescheduling.isSelected) || (!reschedule && rescheduling.isSelected)) {
      checkbox(preventCandidateReschedulingId).select()
    }
  }

  private def enterMinAlterationNotice(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails
    enterValue(minAlterationNoticeId, schedule.minAlterationNotice.toString)
  }

  private def selectTimezone(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule = interviewScheduleDetails
    val zone     = waitForVisibilityOfElementById(timezoneId)
    if (zone.getText != schedule.timezone) {
      zone.click()
      selectOption(generalInput, schedule.timezone)
    }
  }

  def selectCandidateTimeFormat(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val schedule   = interviewScheduleDetails
    val timeFormat = waitForVisibilityOfElementById(candidateTimeFormatId)
    if (timeFormat.getText != schedule.candidateTimeFormat) {
      timeFormat.click()
      action().moveToElement(waitForDropdownOption(schedule.candidateTimeFormat)).perform()
      waitForDropdownOption(schedule.candidateTimeFormat).click()
    }
  }

  def selectInviteEmailTemplate(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val emailTemplate = interviewScheduleDetails.inviteEmailTemplate.format(vXInterviewNumber.head)
    selectDropdownOption(inviteEmailTemplateId, emailTemplate)
  }

  def selectBookedEmailTemplate(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val bookedEmail = interviewScheduleDetails.bookedEmailTemplate.format(vXInterviewNumber.head)
    selectDropdownOption(bookedEmailTemplateId, bookedEmail)
  }

  private def checkCandidateCVInICals(interviewScheduleDetails: InterviewScheduleDetails): Unit = {
    val includeCVInICal   = interviewScheduleDetails.includeCVInICal
    val includeCVInICalId = waitForVisibilityOfElementById(includeCandidateCVInICalsId)
    if ((!includeCVInICal && includeCVInICalId.isSelected) || (includeCVInICal && !includeCVInICalId.isSelected)) {
      includeCVInICalId.click()
    }
  }

  private val schedule: Seq[InterviewScheduleDetails => Unit] = Seq(
    selectCopyFrom,
    enterInterviewTitle,
    selectInterviewDate,
    selectInterviewRound,
    selectCoordinator,
    enterInternalNotes,
    enterInstructionsForCandidate,
    selectInterviewLocation,
    checkPreventCandidateRescheduling,
    enterMinAlterationNotice,
    selectTimezone,
    selectCandidateTimeFormat,
    selectInviteEmailTemplate,
    selectBookedEmailTemplate,
    checkCandidateCVInICals
  )

  def interviewSchedulePage(applicationDetails: ApplicationDetails): Unit = {
    checkInterviewStatus()
    createInterviewSchedule()
    schedule.foreach { f =>
      f(applicationDetails.interviewScheduleDetails)
    }
    clickOn(createId)
  }
}
