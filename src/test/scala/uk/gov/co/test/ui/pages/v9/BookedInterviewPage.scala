package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{WebDriver, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXInstructionsForCandidates, vXInterviewLocation, vXInterviewRoom, vXInterviewScheduleTitle, vXSlotOneStartTime}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.scheduleInterviewFunction

object BookedInterviewPage extends CivilServiceJobsBasePage {

  private lazy val bookedInterviewPageTitle    = "Booked Interviews - Civil Service Jobs - GOV.UK"
  private lazy val interviewOneTitleId         = "interview_schedule_title"
  private lazy val instructionsForCandidateCss = "#main-content > div > div > div:nth-child(3) > p"
  private lazy val interviewOneDateTimeId      = "itinerary"
  private lazy val specificInterviewOneSlotId  = s"//option[contains(text(),'${vXSlotOneStartTime}')]"
  private lazy val bookSlotId  = "book_interview_button"
  private lazy val confirmBookSlotTitleTag  = "h2"
  private lazy val candidateInstructionsHeaderPath  = ".//*[@class='interview_cand_description']"
  private lazy val interviewLocationPath  = ".//*[@class='interview_location']"
  private lazy val anotherLocationPath  = "(//p)[9]"

  private def bookedInterviewPageCheck(): Unit =
    eventually(onPage(bookedInterviewPageTitle))

  def confirmInterviewOneDateTime(): Unit = {

    bookedInterviewPageCheck()
    waitForVisibilityOfElementById(
      interviewOneTitleId
    ).getText                                                          shouldEqual s"$vXInterviewScheduleTitle $vXInterviewLocation"
    waitForVisibilityOfElementCss(instructionsForCandidateCss).getText shouldEqual vXInstructionsForCandidates
  }

  def selectInterviewOneDateTime(): Unit = {
    scheduleInterviewFunction().click()
    confirmInterviewOneDateTime()
    waitForVisibilityOfElementById(interviewOneDateTimeId).click()
    waitForVisibilityOfElementByPath(specificInterviewOneSlotId).click()
    clickOn(bookSlotId)
    waitForVisibilityOfElementByTag("h1").getText shouldEqual "Booked Interviews"
    waitForVisibilityOfElementByTag(confirmBookSlotTitleTag).getText shouldEqual s"$vXInterviewScheduleTitle"
    waitForVisibilityOfElementByPath(candidateInstructionsHeaderPath).getText shouldEqual s"$vXInstructionsForCandidates"
    waitForVisibilityOfElementByPath(interviewLocationPath).getText shouldEqual s"Interview Location: $vXInterviewLocation"
    waitForVisibilityOfElementByPath(anotherLocationPath).getText shouldEqual s"Location: - $vXInterviewRoom"
  }
}
