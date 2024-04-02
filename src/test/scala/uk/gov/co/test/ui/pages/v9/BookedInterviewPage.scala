package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomFirstName, vXInstructionsForCandidates, vXInterviewLocation, vXInterviewNumber, vXInterviewRoom, vXInterviewScheduleTitle, vXSlotOneStartTime, vXSlotTwoStartTime}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.scheduleInterviewFunction

import scala.collection.mutable
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

object BookedInterviewPage extends CivilServiceJobsBasePage {

  private lazy val bookedInterviewPageTitle = "Booked Interviews - Civil Service Jobs - GOV.UK"
  private lazy val allBookingSectionsPath   = "//*[@class='interview_schedule_details']"
  private lazy val interviewBookingTitleId  = "interview_schedule_title"
  private lazy val allSlotsSelectionPath    = ".//*[@id='itinerary']"
  private lazy val bookSlotId               = "book_interview_button"
//  private lazy val anotherLocationPath             = "(//p)[9]"
  private lazy val slotOneSelectionPath     =
    s"//*[contains(text(),'${vXSlotOneStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}')]"
  private lazy val slotTwoSelectionPath     =
    s"//*[contains(text(),'${vXSlotTwoStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}')]"

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
    val selection = new Select(_slotSelection)
    selection.selectByVisibleText(_slotTwo.getText)
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

  def thirdSectionItem(subSection: WebElement): WebElement =
    subSection.findElement(By.xpath(allSlotsSelectionPath))

  def fourthSectionItem(subSection: WebElement): WebElement =
    subSection.findElement(By.xpath(slotOneSelectionPath))

  def fifthSectionItem(subSection: WebElement): WebElement =
    subSection.findElement(By.xpath(slotTwoSelectionPath))

  def sixthSectionItem(subSection: WebElement): WebElement =
    subSection.findElement(By.name(bookSlotId))

  def slotSectionValues(): (String, String, WebElement, WebElement, WebElement, WebElement) = {
    var _slotTitle: String         = ""
    var _instructions: String      = ""
    var _slotSelection: WebElement = null
    var _slotOne: WebElement       = null
    var _slotTwo: WebElement       = null
    var _bookSlot: WebElement      = null
    val subSections                = availableSlots()
    breakable(
      for (subSection <- subSections) {
        val q = firstSectionItem(subSection)
        if (q.getText.contains(randomFirstName)) {
          _slotTitle = firstSectionItem(subSection).getText
          _instructions = secondSectionItem(subSection).getText
          _slotSelection = thirdSectionItem(subSection)
          _slotOne = fourthSectionItem(subSection)
          _slotTwo = fifthSectionItem(subSection)
          _bookSlot = sixthSectionItem(subSection)
          break()
        }
      }
    )
    (_slotTitle, _instructions, _slotSelection, _slotOne, _slotTwo, _bookSlot)
  }
}
