package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{randomFirstName, vXInstructionsForCandidates, vXInterviewLocation, vXInterviewRoom, vXInterviewScheduleTitle, vXSlotOneStartTime}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.scheduleInterviewFunction

import scala.collection.mutable
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

object BookedInterviewPage extends CivilServiceJobsBasePage {

  private lazy val bookedInterviewPageTitle        = "Booked Interviews - Civil Service Jobs - GOV.UK"
  private lazy val interviewOneTitleId             = "interview_schedule_title"
  private lazy val interviewOneDateTimeId          = "itinerary"
  private lazy val specificInterviewOneSlotId      = s"//option[contains(text(),'$vXSlotOneStartTime')]"
  private lazy val bookSlotId                      = "book_interview_button"
  private lazy val confirmBookSlotTitleTag         = "h2"
  private lazy val candidateInstructionsHeaderPath = ".//*[@class='interview_cand_description']"
  private lazy val interviewLocationPath           = ".//*[@class='interview_location']"
  private lazy val anotherLocationPath             = "(//p)[9]"
  private lazy val candidateInstructionsPath       = "(//p)[6]"
  private lazy val interviewSlotsSectionPath       = ".//*[@class='interview_schedule_details']"

  private def bookedInterviewPageCheck(): Unit =
    eventually(onPage(bookedInterviewPageTitle))

  def confirmInterviewOneDateTime(): Unit = {
    bookedInterviewPageCheck()
    waitForVisibilityOfElementById(
      interviewOneTitleId
    ).getText                                                           shouldEqual s"$vXInterviewScheduleTitle $vXInterviewLocation"
    waitForVisibilityOfElementByPath(candidateInstructionsPath).getText shouldEqual vXInstructionsForCandidates
  }

  def selectInterviewOneDateTime(): Unit = {
    scheduleInterviewFunction().click()

    val (_slotTitle, _instructions, _slotSelection, _slotOne, _slotTwo, _bookSlot) = slotSectionValues()
    _slotTitle    shouldEqual s"$vXInterviewScheduleTitle $vXInterviewLocation"
    _instructions shouldEqual vXInstructionsForCandidates

    val selection = new Select(_slotSelection)
    selection.selectByVisibleText(_slotTwo.getText)

    _bookSlot.click()

    confirmInterviewOneDateTime()
    waitForVisibilityOfElementById(interviewOneDateTimeId).click()
    waitForVisibilityOfElementByPath(specificInterviewOneSlotId).click()
    clickOn(bookSlotId)
    waitForVisibilityOfElementByTag("h1").getText                    shouldEqual "Booked Interviews"
    waitForVisibilityOfElementByTag(confirmBookSlotTitleTag).getText shouldEqual s"$vXInterviewScheduleTitle"
    waitForVisibilityOfElementByPath(
      candidateInstructionsHeaderPath
    ).getText                                                        shouldEqual s"$vXInstructionsForCandidates"
    waitForVisibilityOfElementByPath(
      interviewLocationPath
    ).getText                                                        shouldEqual s"Interview Location: $vXInterviewLocation"
    waitForVisibilityOfElementByPath(anotherLocationPath).getText    shouldEqual s"Location: - $vXInterviewRoom"
  }

  def availableSlots(): mutable.Buffer[WebElement] =
    driver.findElements(By.xpath("//*[@class='interview_schedule_details']")).asScala

  def firstSectionItem(sectionItem: WebElement): WebElement =
    sectionItem.findElement(By.id("interview_schedule_title"))

  def secondSectionItem(sectionItem: WebElement): WebElement =
    sectionItem.findElement(By.tagName("p"))

  def thirdSectionItem(sectionItem: WebElement): WebElement =
    sectionItem.findElement(By.xpath("//*[@id='itinerary']"))

  def forthSectionItem(sectionItem: WebElement): WebElement =
    sectionItem.findElement(By.xpath("//option[contains(text(),'09:00')]"))

  def fifthSectionItem(sectionItem: WebElement): WebElement =
    sectionItem.findElement(By.xpath("//option[contains(text(),'11:00')]"))

  def sixthSectionItem(sectionItem: WebElement): WebElement =
    sectionItem.findElement(By.xpath("//input[@name='book_interview_button']"))

  def slotSectionValues(): (String, String, WebElement, WebElement, WebElement, WebElement) = {
    var _slotTitle: String         = ""
    var _instructions: String      = ""
    var _slotSelection: WebElement = null
    var _slotOne: WebElement       = null
    var _slotTwo: WebElement       = null
    var _bookSlot: WebElement      = null
    val subSections                = availableSlots()
    breakable(
      for (section <- subSections) {
        val q = firstSectionItem(section)
        if (q.getText.contains(randomFirstName)) {
          _slotTitle = firstSectionItem(section).getText
          _instructions = secondSectionItem(section).getText
          _slotSelection = thirdSectionItem(section)
          _slotOne = forthSectionItem(section)
          _slotTwo = fifthSectionItem(section)
          _bookSlot = sixthSectionItem(section)
          break()
        }
      }
    )
    (_slotTitle, _instructions, _slotSelection, _slotOne, _slotTwo, _bookSlot)
  }
}
