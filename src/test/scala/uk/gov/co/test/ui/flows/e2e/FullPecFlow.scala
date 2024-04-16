package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.application.APPLICATION_DATA
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.confirmPecSubmissionState
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.EmploymentHistoryVXFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object FullPecFlow extends CivilServiceJobsBasePage {

  def completeFullPecFlow(): Unit = {
    fillShortFormDetails(MASTER_SHORT_FORM_DATA)
    fillLongFormDetails(MASTER_LONG_FORM_DATA)
    PreSiftEvaluationFlow(APPLICATION_DATA)
    SiftEvaluationFlow(APPLICATION_DATA)
    completeAllInterviews(APPLICATION_DATA)
    moveAndAcceptOffer()
    fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA)
    confirmPecSubmissionState()
    EmploymentHistoryVXFlow(APPLICATION_DATA)
  }
}
