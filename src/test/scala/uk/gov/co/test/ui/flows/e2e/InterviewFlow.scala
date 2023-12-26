package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.vx.APPLICATION_DATA
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.applicationId
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{applicationBeingReviewedState, interviewOneSlotBookedState, invitedForInterviewOneState}
import uk.gov.co.test.ui.pages.v9.BookedInterviewPage.confirmBookingSlot
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{interviewOneScheduled, searchApplicationId}
import uk.gov.co.test.ui.pages.vx.CalenderSchedulePage.calenderSchedulePage
import uk.gov.co.test.ui.pages.vx.InterviewSchedulePage.interviewSchedulePage
import uk.gov.co.test.ui.pages.vx.SendInterviewEmailPage.inviteToInterviewEmailFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.InterviewOneEvaluationTab.interviewOneEvaluationFlow

object InterviewFlow extends CivilServiceJobsBasePage {

  private val interview: Seq[Unit] = Seq(
    interviewSchedulePage(APPLICATION_DATA),
    calenderSchedulePage(APPLICATION_DATA),
    applicationBeingReviewedState(),
    switchToOtherWindow,
    searchApplicationId(applicationId),
    inviteToInterviewEmailFlow(),
    invitedForInterviewOneState(),
    confirmBookingSlot(),
    interviewOneSlotBookedState(),
    interviewOneScheduled(),
    interviewOneEvaluationFlow(APPLICATION_DATA),
    println("So far...")
  )

  def completeInterviewProcess(): Unit =
    interview.foreach { f =>
      f
    }
}
