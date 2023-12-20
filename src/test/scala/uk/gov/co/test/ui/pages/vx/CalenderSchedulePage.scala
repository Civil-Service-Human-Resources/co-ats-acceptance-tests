package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.ApplicationDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vXInterviewScheduleTitle
import uk.gov.co.test.ui.specs.TestData.eventually

import java.time.LocalTime

case class CalenderScheduleDetails(
  slotStartTime: String,
  slotDuration: Int,
  candidatesPerSlot: Int,
  addMultipleSlots: Boolean,
  noOfConsecutiveSlots: Int,
  slotSpacing: Int,
  interviewRoom: String,
  sendInterviewerICal: Option[Boolean] = None,
  panelMembers: Option[String] = None
)

object CalenderSchedulePage extends VacancyBasePage {

  private lazy val calenderSchedulePageTitle     = "Interview Schedule : Civil Service Jobs - GOV.UK"
  private lazy val calenderScheduleHeaderPath    = ".//*[@class='brand_main_title_left']"
  private lazy val calenderScheduleSubHeaderPath = ".//span[@class='navbar-brand-sub-text']"
  private lazy val addSlotPath                   = ".//*[text()='Add Slot']"
  private lazy val createSlotHeaderId            = "ui-id-17"
  private lazy val slotStartHourId               = "create_slot_form_time_hh"
  private lazy val slotStartMinId                = "create_slot_form_time_mm"
  private lazy val slotDurationId                = "create_slot_form_duration"
  private lazy val candidatesPerSlotId           = "create_slot_form_candidates"
  private lazy val addMultipleSlotsId            = "create_slot_form_multiple_slots"
  private lazy val noOfConsecutiveSlotsId        = "create_slot_form_slot_count"
  private lazy val slotSpacingId                 = "create_slot_form_slot_gap"
  private lazy val interviewRoomId               = "create_slot_form_location_text_en-GB"
  private lazy val sendInterviewerICalId         = "create_slot_form_sendical"
  private lazy val createSlotId                  = "create_slot_form_popup-submit"
  private lazy val createdFirstSlotPath          = ".//*[@class='streams-slot '][1]"
  private lazy val createdSecondSlotPath         = ".//*[@class='streams-slot '][2]"
  private lazy val taggedVacanciesTabPath        = ".//span[@class='main-label' and text() = 'Tagged Vacancies']"
  private lazy val calenderScheduleNoTitleId     = "No Title_description"
  private lazy val allCalenderSlotsPath          = ".//*[@class='streams-slot ']"

  def enterSlotValue(inputId: String, value: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
    enterOption.clear()
    enterOption.sendKeys(value)
  }

  private def calenderScheduleTitleChecks(): Unit = {
    eventually(onPage(calenderSchedulePageTitle))
    waitForVisibilityOfElementByPath(calenderScheduleHeaderPath).getText    shouldEqual "Interview Schedule"
    waitForVisibilityOfElementByPath(calenderScheduleSubHeaderPath).getText shouldEqual vXInterviewScheduleTitle
  }

  private def createSlot(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    waitForVisibilityOfElementByPath(addSlotPath).click()
    waitForVisibilityOfElementById(createSlotHeaderId).getText shouldEqual "Create Slot"
  }

  private def enterSlotStartTime(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val requiredTime  = calenderScheduleDetails
    val (_hour, _min) = splitTime(requiredTime.slotStartTime)
    enterTime(slotStartHourId, _hour)
    enterTime(slotStartMinId, _min)
  }

  private def enterSlotDuration(calenderScheduleDetails: CalenderScheduleDetails): Unit =
    enterSlotValue(slotDurationId, calenderScheduleDetails.slotDuration.toString)

  private def enterCandidatesPerSlot(calenderScheduleDetails: CalenderScheduleDetails): Unit =
    enterSlotValue(candidatesPerSlotId, calenderScheduleDetails.candidatesPerSlot.toString)

  private def checkAddMultipleSlots(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val schedule = calenderScheduleDetails
    if (schedule.addMultipleSlots) {
      waitForVisibilityOfElementById(addMultipleSlotsId).click()
      enterSlotValue(noOfConsecutiveSlotsId, schedule.noOfConsecutiveSlots.toString)
      enterSlotValue(slotSpacingId, schedule.slotSpacing.toString)
    }
  }

  private def enterInterviewRoom(calenderScheduleDetails: CalenderScheduleDetails): Unit =
    enterSlotValue(interviewRoomId, calenderScheduleDetails.interviewRoom)

  private def checkSendInterviewerICalNow(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val schedule = calenderScheduleDetails
    if (schedule.sendInterviewerICal.get) {
      waitForVisibilityOfElementById(sendInterviewerICalId).click()
    }
  }

  private def enterPanelMembers(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val schedule = calenderScheduleDetails
    if (schedule.panelMembers.isDefined) {
      val enterOption = waitForVisibilityOfElementByPath(generalInput)
      enterOption.clear()
      enterOption.sendKeys(schedule.panelMembers.get)
      action().moveToElement(waitForDropdownOptionByText(schedule.panelMembers.get)).perform()
      waitForDropdownOptionByText(schedule.panelMembers.get).click()
    }
  }

  private def expectedCalenderTitle(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val schedule      = calenderScheduleDetails
    val expectedTitle =
      s"Of ${schedule.noOfConsecutiveSlots} slots ${schedule.noOfConsecutiveSlots} need interviewers and 0 are fully booked."
    checkForNewValue(calenderScheduleNoTitleId, expectedTitle)
  }

  private def createdSlots(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val createdSlots = driver.findElements(By.xpath(allCalenderSlotsPath)).size()
    createdSlots shouldEqual calenderScheduleDetails.noOfConsecutiveSlots
  }

  private def createdSlotText(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val schedule          = calenderScheduleDetails
    val (_hour, _min)     = splitTime(calenderScheduleDetails.slotStartTime)
    val slotOneStartTime  = schedule.slotStartTime.replaceFirst("^0*", "")
    val slotOneFinishTime = LocalTime.of(_hour.toInt, _min.toInt).plusMinutes(schedule.slotDuration)
    val slotTwoStartTime  = slotOneFinishTime.plusMinutes(schedule.slotSpacing)
    val slotTwoFinishTime = slotTwoStartTime.plusMinutes(schedule.slotDuration)

    waitForVisibilityOfElementByPath(createdFirstSlotPath).getText shouldEqual
      s"""${schedule.interviewRoom}: $slotOneStartTime am to $slotOneFinishTime am
         |$slotOneStartTime am to $slotOneFinishTime am
         |Room/Site : ${schedule.interviewRoom}
         |Panel Members/Administrators ( 0 of 1 ) :
         |Candidate ( 0 of 1 ) :""".stripMargin

    waitForVisibilityOfElementByPath(createdSecondSlotPath).getText shouldEqual
      s"""${schedule.interviewRoom}: $slotTwoStartTime am to $slotTwoFinishTime pm
         |$slotTwoStartTime am to $slotTwoFinishTime pm
         |Room/Site : ${schedule.interviewRoom}
         |Panel Members/Administrators ( 0 of 1 ) :
         |Candidate ( 0 of 1 ) :""".stripMargin
  }

  private def validateCalenderSchedule(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    clickOn(createSlotId)
    expectedCalenderTitle(calenderScheduleDetails)
    createdSlots(calenderScheduleDetails)
    createdSlotText(calenderScheduleDetails)
  }

  private val calender: Seq[CalenderScheduleDetails => Unit] = Seq(
    createSlot,
    enterSlotStartTime,
    enterSlotDuration,
    enterCandidatesPerSlot,
    checkAddMultipleSlots,
    enterInterviewRoom,
    checkSendInterviewerICalNow,
    enterPanelMembers,
    validateCalenderSchedule
  )

  def calenderSchedulePage(applicationDetails: ApplicationDetails): Unit = {
    calenderScheduleTitleChecks()
    calender.foreach { f =>
      f(applicationDetails.calenderScheduleDetails)
    }
    println("Done!")
  }
}
