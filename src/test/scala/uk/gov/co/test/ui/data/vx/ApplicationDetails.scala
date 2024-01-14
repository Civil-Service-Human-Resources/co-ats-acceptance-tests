package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.pages.vx.vacancytabs._
import uk.gov.co.test.ui.pages.vx.{CalenderScheduleDetails, InterviewScheduleDetails}

case class Outcome(score: Int, comment: Option[String] = None)
case class AssessmentOutcome(name: String, score: Int, comment: Option[String] = None)

case class ApplicationDetails(
  historyDetails: HistoryDetails,
  preSiftDetails: PreSiftDetails,
  siftDetails: SiftDetails,
  interviewScheduleDetails: InterviewScheduleDetails,
  calenderScheduleDetails: CalenderScheduleDetails,
  interviewOneDetails: InterviewOneDetails,
  interviewTwoDetails: InterviewTwoDetails,
  interviewThreeDetails: InterviewThreeDetails,
  interviewFourDetails: InterviewFourDetails
)
