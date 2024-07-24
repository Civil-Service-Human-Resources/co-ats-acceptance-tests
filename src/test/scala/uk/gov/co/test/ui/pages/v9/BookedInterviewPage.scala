package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomFirstName, randomLastName, vXInstructionsForCandidates, vXInterviewLocation, vXInterviewNumber, vXInterviewRoom, vXInterviewScheduleTitle, vXSlotOneStartTime, vXSlotTwoStartTime}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.scheduleInterviewFunction

import scala.collection.mutable
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

object BookedInterviewPage extends CivilServiceJobsBasePage {

  private lazy val bookedInterviewPageTitle = "Booked Interviews - Civil Service Jobs - GOV.UK"
  private lazy val allBookingSectionsPath   = "//*[@class='interview_schedule_details']"
  private lazy val interviewBookingTitleId  = "interview_schedule_title"
  private lazy val allSlotsSelectionPath    = "//*[@id='itinerary']"
  private lazy val bookSlotId               = "//input[@name='book_interview_button']"

  private def bookedInterviewPageCheck(): Unit =
    eventually(onPage(bookedInterviewPageTitle))

  def confirmBookSlotTitlePath: String = {
    val position = vXInterviewNumber.head.toInt + 1
    val ele      = s"//*[@id='main-content']/div/div[${position.toString}]/h2"
    ele
  }

  def candidateInstructionsHeaderPath: String = {
    val position = vXInterviewNumber.head.toInt + 1
    val ele      = s"//*[@id='main-content']/div/div[${position.toString}]/div"
    ele
  }

  def interviewLocationPath: String = {
    val position = vXInterviewNumber.head.toInt + 1
    val ele      = s"//*[@id='main-content']/div/div[${position.toString}]/p[1]"
    ele
  }

  def anotherLocationPath: String = {
    val position = vXInterviewNumber.head.toInt + 1
    val ele      = s"//*[@id='main-content']/div/div[${position.toString}]/ul/li[2]/p[2]"
    ele
  }

  private def selectInterviewDateTime(): Unit = {
    scheduleInterviewFunction().click()
    bookedInterviewPageCheck()
    val (_slotTitle, _instructions, _slotSelection, _slotOne, _slotTwo, _bookSlot) = slotSectionValues()
    _slotTitle    shouldEqual s"$vXInterviewScheduleTitle $vXInterviewLocation"
    _instructions shouldEqual vXInstructionsForCandidates
    scrollToElement(By.xpath(_slotSelection))
    val selection = new Select(waitForVisibilityOfElementByPath(_slotSelection))
    selection.selectByVisibleText(_slotTwo)
    _bookSlot.click()
  }

  def confirmBookingSlot(): Unit = {
    selectInterviewDateTime()
    waitForVisibilityOfElementByTag("h1").getText                      shouldEqual "Booked Interviews"
    waitForVisibilityOfElementByPath(confirmBookSlotTitlePath).getText shouldEqual s"$vXInterviewScheduleTitle"
    waitForVisibilityOfElementByPath(
      candidateInstructionsHeaderPath
    ).getText                                                          shouldEqual s"$vXInstructionsForCandidates"
    waitForVisibilityOfElementByPath(
      interviewLocationPath
    ).getText                                                          shouldEqual s"Interview Location: $vXInterviewLocation"
    waitForVisibilityOfElementByPath(anotherLocationPath).getText      shouldEqual s"Location: - $vXInterviewRoom"
  }

  def availableSlots(): mutable.Buffer[WebElement] =
    driver.findElements(By.xpath(allBookingSectionsPath)).asScala

  def firstSectionItem(subSection: WebElement): WebElement =
    subSection.findElement(By.id(interviewBookingTitleId))

  def secondSectionItem(subSection: WebElement): WebElement =
    subSection.findElement(By.tagName("p"))

  def thirdSectionItem(instructions: String): String = {
    val slotSelection = s"//p[contains(text(), '$instructions')]//..//select"
    slotSelection
  }

  def fourthSectionItem(subSection: WebElement, instructions: String): WebElement = {
    val slotOneSelectionPath =
      s"//option[contains(text(),'${vXSlotOneStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}')]"
    subSection.findElement(
      By.xpath(s"//p[contains(text(), '$instructions')]//..//select[@id='itinerary']$slotOneSelectionPath")
    )
  }

  def fifthSectionItem(subSection: WebElement, instructions: String): WebElement = {
    val slotTwoSelectionPath =
      s"//*[contains(text(),'${vXSlotTwoStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}')]"
    subSection.findElement(
      By.xpath(s"//p[contains(text(), '$instructions')]//..//select[@id='itinerary']$slotTwoSelectionPath")
    )
  }

  def sixthSectionItem(subSection: WebElement, instructions: String): WebElement =
    subSection.findElement(By.xpath(s"//p[contains(text(), '$instructions')]//..//input[@value='Book Slot']"))

  def slotSectionValues(): (String, String, String, String, String, WebElement) = {
    var _slotTitle: String     = ""
    var _instructions: String  = ""
    var _slotSelection: String = ""
    var _slotOne: String       = ""
    var _slotTwo: String       = ""
    var _bookSlot: WebElement  = null
    val subSections            = availableSlots()
    breakable(
      for (subSection <- subSections) {
        val q = firstSectionItem(subSection)
        if (q.getText.contains(s"$randomFirstName $randomLastName")) {
          _slotTitle = firstSectionItem(subSection).getText
          _instructions = secondSectionItem(subSection).getText
          _slotSelection = thirdSectionItem(_instructions)
          _slotOne = fourthSectionItem(subSection, _instructions).getText
          _slotTwo = fifthSectionItem(subSection, _instructions).getText
          _bookSlot = sixthSectionItem(subSection, _instructions)
          break()
        }
      }
    )
    (_slotTitle, _instructions, _slotSelection, _slotOne, _slotTwo, _bookSlot)
  }
}
