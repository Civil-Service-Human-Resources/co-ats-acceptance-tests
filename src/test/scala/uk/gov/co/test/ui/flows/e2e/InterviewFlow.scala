package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXInterviewExpectedRounds, vXInterviewNumber}
import uk.gov.co.test.ui.data.vx.{APPLICATION_DATA, ApplicationDetails}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.interviewSlotBookedState
import uk.gov.co.test.ui.pages.v9.BookedInterviewPage.confirmBookingSlot
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.interviewScheduled
import uk.gov.co.test.ui.pages.vx.CalenderSchedulePage.calenderSchedulePage
import uk.gov.co.test.ui.pages.vx.InterviewSchedulePage.{interviewSchedulePage, untagVacancy}
import uk.gov.co.test.ui.pages.vx.SendInterviewEmailPage.inviteToInterviewEmailFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.InterviewFourEvaluationTab.interviewFourEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.InterviewOneEvaluationTab.interviewOneEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.InterviewThreeEvaluationTab.interviewThreeEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.InterviewTwoEvaluationTab.interviewTwoEvaluationFlow

object InterviewFlow extends CivilServiceJobsBasePage {

  private def interviewProcess(): Unit = {
    interviewSchedulePage(APPLICATION_DATA)
    calenderSchedulePage(APPLICATION_DATA)
    inviteToInterviewEmailFlow() //check function inside
    confirmBookingSlot()
    interviewSlotBookedState()
    interviewScheduled()
    interviewEvaluations(APPLICATION_DATA)
  }

  def completeAllInterviews(): Unit =
    if (vXInterviewExpectedRounds != "No interviews") {
      1 to vXInterviewExpectedRounds.toInt foreach { _ =>
        interviewProcess()
        changeSystem("recruiter")
        vXInterviewNumber.remove(0)
      }
    }

  private def interviewEvaluations(applicationDetails: ApplicationDetails): Unit =
    vXInterviewNumber.head match {
      case "1" => interviewOneEvaluationFlow(applicationDetails)
      case "2" => interviewTwoEvaluationFlow(applicationDetails)
      case "3" => interviewThreeEvaluationFlow(applicationDetails)
      case "4" => interviewFourEvaluationFlow(applicationDetails)
    }

  def untagVacancies(vacancyToUntag: String): Unit =
    for (i <- 1 to 50) untagVacancy(i, vacancyToUntag)
}
