package uk.gov.co.test.ui.pages.vx

import uk.gov.co.test.ui.data.vx.ApplicationDetails
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vXInterviewScheduleTitle
import uk.gov.co.test.ui.specs.TestData.eventually

case class CalenderScheduleDetails(
)

object CalenderSchedulePage extends VacancyBasePage {

  private lazy val calenderSchedulePageTitle     = "Interview Schedule : Civil Service Jobs - GOV.UK"
  private lazy val calenderScheduleHeaderPath    = ".//*[@class='brand_main_title_left']"
  private lazy val calenderScheduleSubHeaderPath = ".//span[@class='navbar-brand-sub-text']"
  private lazy val addSlotPath                   = ".//*[text()='Add Slot']"
  private lazy val createSlotHeaderId            = "ui-id-17"
  private lazy val createSlotId                  = "create_slot_form_popup-submit"

  private def calenderScheduleTitleChecks(): Unit = {
    eventually(onPage(calenderSchedulePageTitle))
    waitForVisibilityOfElementByPath(calenderScheduleHeaderPath).getText    shouldEqual "Interview Schedule"
    waitForVisibilityOfElementByPath(calenderScheduleSubHeaderPath).getText shouldEqual vXInterviewScheduleTitle
  }

  private def createSlot(calenderScheduleDetails: CalenderScheduleDetails): Unit = {
    waitForVisibilityOfElementByPath(addSlotPath).click()
    waitForVisibilityOfElementById(createSlotHeaderId).getText shouldEqual "Create Slot"
    clickOn(createSlotId)
  }

  private val calender: Seq[CalenderScheduleDetails => Unit] = Seq(
    createSlot
  )

  def calenderSchedulePage(applicationDetails: ApplicationDetails): Unit = {
    calenderScheduleTitleChecks()
    calender.foreach { f =>
      f(applicationDetails.calenderScheduleDetails)
    }
  }
}
