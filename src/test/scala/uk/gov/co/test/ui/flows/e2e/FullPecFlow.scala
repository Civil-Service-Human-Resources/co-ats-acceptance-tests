package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.SHORT_FORM_DATA_PEC
import uk.gov.co.test.ui.data.vx.APPLICATION_DATA
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.applicationId
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{applicationBeingReviewedState, candidateAcceptsOffer, confirmOfferAccepted, confirmPecSubmission, interviewSlotBookedState, invitedForInterviewState}
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.extractApplicationId
import uk.gov.co.test.ui.pages.v9.BookedInterviewPage.confirmBookingSlot
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.ProvisionalOfferPage.offerDecisionFlow
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{interviewOneScheduled, navigateToApplicationSummary, progressApplicationToOffer, searchApplicationId}
import uk.gov.co.test.ui.pages.vx.CalenderSchedulePage.calenderSchedulePage
import uk.gov.co.test.ui.pages.vx.InterviewSchedulePage.interviewSchedulePage
import uk.gov.co.test.ui.pages.vx.SendInterviewEmailPage.inviteToInterviewEmailFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.{EmploymentHistoryVXFlow, completeVXEmploymentHistory}
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object FullPecFlow extends CivilServiceJobsBasePage {

  private val fullPecFlow: Seq[Unit] = Seq(
    fillShortFormDetails(SHORT_FORM_DATA_PEC),
    fillLongFormDetails(MASTER_LONG_FORM_DATA),
    extractApplicationId(),
    navigateToApplicationSummary(),
    PreSiftEvaluationFlow(APPLICATION_DATA),
    SiftEvaluationFlow(APPLICATION_DATA),
    interviewSchedulePage(APPLICATION_DATA),
    calenderSchedulePage(APPLICATION_DATA),
    applicationBeingReviewedState(),
    switchToOtherWindow,
    searchApplicationId(applicationId),
    inviteToInterviewEmailFlow(),
    invitedForInterviewState(),
    confirmBookingSlot(),
    interviewSlotBookedState(),
    interviewOneScheduled(),
    println("So far..."),
    //TODO more flows here before progressing to offer!
    progressApplicationToOffer(),
    candidateAcceptsOffer(),
    offerDecisionFlow("Accept"),
    confirmOfferAccepted(),
    fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA),
    confirmPecSubmission(),
    navigateToApplicationSummary(),
    completeVXEmploymentHistory(),
    EmploymentHistoryVXFlow(APPLICATION_DATA)
  )

  def completeFullPecFlow(): Unit =
    fullPecFlow.foreach { f =>
      f
    }

}
