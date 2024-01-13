package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.data.TestData.eventually
import uk.gov.co.test.ui.data.vx.ApplicationDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXApplicationClosingDate, vXApplicationLiveDate, vXInterviewID, vXInterviewNumber, vXInterviewRoom, vXInterviewScheduleTitle, vXSlotOneFinishTime, vXSlotOneStartTime, vXSlotTwoFinishTime, vXSlotTwoStartTime, vacancyId, vacancyName}

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import scala.collection.mutable
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

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
  private lazy val calenderScheduleNoTitleId     = "No Title_description"
  private lazy val allCalenderSlotsPath          = ".//*[@class='streams-slot ']"
  private lazy val taggedVacanciesTabPath        = ".//span[@class='main-label' and text() = 'Tagged Vacancies']"
  private lazy val createdSlotsTabPath           = ".//span[@class='main-label' and text() = 'Created Slots']"
  private lazy val detailsTabPath                = ".//span[@class='main-label' and text() = 'Details']"
  private lazy val interviewIDId                 = "details_form_id"
  private lazy val addTaggedVacancyId            = "but_add_opportunity"
  private lazy val removeSelectedVacancyId       = "but_remove_opportunity"
  private lazy val noRecordsPath                 = ".//*[@id='DataTables_Table_1']/tbody/tr/td"
  private lazy val addTaggedVacancyHeaderId      = "ui-id-1"
  private lazy val filterVacancyResultsId        = "vacancy_Full_List-main-filter"
  private lazy val addSelectedVacanciesId        = "add_opp_dlg-ok"
  private lazy val displayingResultsT3Path       = ".//*[@id='DataTables_Table_3']/tbody/tr/td[1]"
  private lazy val displayingResultsT1Path       = ".//*[@id='DataTables_Table_1']/tbody/tr/td[1]"
  private lazy val displayingResultsITPath       = "//*[@id='itinerary_list_wrapper']/div[1]/div[1]/span[2]"
  private lazy val createdSlotsPagePath          = "//*[@id='itinerary_list']/tbody//tr[@tabindex='-1']"
  private lazy val appLiveDate                   = changeDateFormat(vXApplicationLiveDate, "short")
  private lazy val appClosingDate                = changeDateFormat(vXApplicationClosingDate, "short")

  def enterScheduleValue(inputId: String, value: String): Unit = {
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
    enterScheduleValue(slotDurationId, calenderScheduleDetails.slotDuration.toString)

  private def enterCandidatesPerSlot(calenderScheduleDetails: CalenderScheduleDetails): Unit =
    enterScheduleValue(candidatesPerSlotId, calenderScheduleDetails.candidatesPerSlot.toString)

  private def checkAddMultipleSlots(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val schedule = calenderScheduleDetails
    if (schedule.addMultipleSlots) {
      waitForVisibilityOfElementById(addMultipleSlotsId).click()
      enterScheduleValue(noOfConsecutiveSlotsId, schedule.noOfConsecutiveSlots.toString)
      enterScheduleValue(slotSpacingId, schedule.slotSpacing.toString)
    }
  }

  private def enterInterviewRoom(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    vXInterviewRoom = calenderScheduleDetails.interviewRoom.format(vXInterviewNumber.head)
    enterScheduleValue(interviewRoomId, vXInterviewRoom)
  }

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
    clickOn(createSlotId)
  }

  private def expectedCalenderTitle(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val schedule      = calenderScheduleDetails
    val expectedTitle =
      s"Of ${schedule.noOfConsecutiveSlots} slots ${schedule.noOfConsecutiveSlots} need interviewers and 0 are fully booked."
    checkForNewValueId(calenderScheduleNoTitleId, expectedTitle)
  }

  private def confirmSlotsOnCalender(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val createdSlots = driver.findElements(By.xpath(allCalenderSlotsPath)).size()
    createdSlots shouldEqual calenderScheduleDetails.noOfConsecutiveSlots
  }

  private def confirmSlotText(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    val formatter     = DateTimeFormatter.ofPattern("hh:mm a")
    val schedule      = calenderScheduleDetails
    val (_hour, _min) = splitTime(calenderScheduleDetails.slotStartTime)
    vXSlotOneStartTime = LocalTime
      .of(_hour.toInt, _min.toInt)
      .format(formatter)
      .replaceFirst("^0*", "")
      .toLowerCase
    vXSlotOneFinishTime = LocalTime
      .of(_hour.toInt, _min.toInt)
      .plusMinutes(schedule.slotDuration)
      .format(formatter)
      .replaceFirst("^0*", "")
      .toLowerCase
    vXSlotTwoStartTime = LocalTime
      .of(_hour.toInt, _min.toInt)
      .plusMinutes(schedule.slotDuration)
      .plusMinutes(schedule.slotSpacing)
      .format(formatter)
      .replaceFirst("^0*", "")
      .toLowerCase
    vXSlotTwoFinishTime = LocalTime
      .of(_hour.toInt, _min.toInt)
      .plusMinutes(schedule.slotDuration)
      .plusMinutes(schedule.slotSpacing)
      .plusMinutes(schedule.slotDuration)
      .format(formatter)
      .replaceFirst("^0*", "")
      .toLowerCase

    val roomLocation = schedule.interviewRoom.format(vXInterviewNumber.head)

    waitForVisibilityOfElementByPath(createdFirstSlotPath).getText shouldEqual
      s"""$roomLocation: $vXSlotOneStartTime to $vXSlotOneFinishTime
         |$vXSlotOneStartTime to $vXSlotOneFinishTime
         |Room/Site : $roomLocation
         |Panel Members/Administrators ( 0 of 1 ) :
         |Candidate ( 0 of 1 ) :""".stripMargin

    waitForVisibilityOfElementByPath(createdSecondSlotPath).getText shouldEqual
      s"""$roomLocation: $vXSlotTwoStartTime to $vXSlotTwoFinishTime
         |$vXSlotTwoStartTime to $vXSlotTwoFinishTime
         |Room/Site : $roomLocation
         |Panel Members/Administrators ( 0 of 1 ) :
         |Candidate ( 0 of 1 ) :""".stripMargin
  }

  def tableArea(tableNo: String): WebElement =
    xpath(s"//*[@id='$tableNo']/tbody").element.underlying

  def summaryRows(tableNo: String = "DataTables_Table_3"): mutable.Buffer[WebElement] =
    tableArea(tableNo).findElements(By.xpath("//tr[@tabindex='-1']")).asScala

  def firstRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[1]"))

  def secondRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[2]"))

  def thirdRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[3]"))

  def fourthRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[4]"))

  def fifthRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[5]"))

  def selectedVacancyValues(tableNo: String = "DataTables_Table_3"): (String, String, String, WebElement) = {
    var _title: String        = ""
    var _liveDate: String     = ""
    var _closingDate: String  = ""
    var _isActive: WebElement = null
    val rows                  = summaryRows(tableNo)
    breakable(
      for (row <- rows) {
        val q = firstRowItem(row)
        if (q.getText == vacancyId) {
          _title = secondRowItem(row).getText
          _liveDate = thirdRowItem(row).getText
          _closingDate = fourthRowItem(row).getText
          _isActive = fifthRowItem(row)
          break()
        }
      }
    )
    (_title, _liveDate, _closingDate, _isActive)
  }

  private def isVacancyActive(tableId: String = "DataTables_Table_3"): String = {
    val active = s"//*[@id='$tableId']/tbody/tr/td[5]/span"
    waitForVisibilityOfElementByPath(active).getAttribute("aria-label")
  }

  private def checkCreatedSlots(): Unit = {
    waitForVisibilityOfElementByPath(createdSlotsTabPath).click()
    checkForNewValuePath(displayingResultsITPath, "Displaying 2 results")
    driver.findElements(By.xpath(createdSlotsPagePath)).size() shouldEqual 2
  }

  private def extractInterviewID(): Unit = {
    waitForVisibilityOfElementByPath(detailsTabPath).click()
    vXInterviewID = waitForVisibilityOfElementById(interviewIDId).getText
  }

  def removeTaggedVacancyToSlots(): Unit = {
    waitForVisibilityOfElementByPath(taggedVacanciesTabPath).click()
    val rows = summaryRows("DataTables_Table_1")
    for (row <- rows) {
      val q = firstRowItem(row)
      if (q.getText == vacancyId) {
        firstRowItem(row).click()
      }
    }
    waitForVisibilityOfElementById(removeSelectedVacancyId).click()
    waitForVisibilityOfElementByPath(noRecordsPath).getText shouldEqual "No records"
  }

  private def tagSelectedVacancy(): Unit = {
    waitForVisibilityOfElementByPath(taggedVacanciesTabPath).click()
    waitForVisibilityOfElementById(addTaggedVacancyId).click()
    waitForVisibilityOfElementById(addTaggedVacancyHeaderId).getText shouldEqual "Add Selected Vacancies"
    enterScheduleValue(filterVacancyResultsId, vacancyId)
    checkForNewValuePath(displayingResultsT3Path, vacancyId)
    val (_title, _liveDate, _closingDate, _isActive) = selectedVacancyValues()
    _title  shouldEqual vacancyName
    _liveDate    should startWith(appLiveDate)
    _closingDate should startWith(appClosingDate)
    _isActive.isDisplayed
    if (isVacancyActive() == "Set to TRUE") {
      clickOn(_isActive)
      clickOn(addSelectedVacanciesId)
    }
  }

  private def confirmTaggedVacancy(): Unit = {
    checkForNewValuePath(displayingResultsT1Path, vacancyId)
    val addVacancyTable                              = "DataTables_Table_1"
    val (_title, _liveDate, _closingDate, _isActive) = selectedVacancyValues(addVacancyTable)
    _title                           shouldEqual vacancyName
    _liveDate                             should startWith(appLiveDate)
    _closingDate                          should startWith(appClosingDate)
    _isActive.isDisplayed
    isVacancyActive(addVacancyTable) shouldEqual "Set to TRUE"
  }

  private def validateCalenderSchedule(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    expectedCalenderTitle(calenderScheduleDetails)
    confirmSlotsOnCalender(calenderScheduleDetails)
    confirmSlotText(calenderScheduleDetails)
  }

  private def tagAndConfirmSlots(): Unit = {
    extractInterviewID()
    checkCreatedSlots()
    tagSelectedVacancy()
    confirmTaggedVacancy()
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
    tagAndConfirmSlots()
  }
}
