package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.confirmPecSubmissionState
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.employmentHistoryFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object FullPecFlow extends CivilServiceJobsBasePage {

  def completeFullPecFlow(): Unit = {
    PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
    SiftEvaluationFlow(MASTER_APPLICATION_DATA)
    completeAllInterviews(MASTER_APPLICATION_DATA)
    moveAndAcceptOffer()
    fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA)
    confirmPecSubmissionState()
    employmentHistoryFlow(MASTER_APPLICATION_DATA)
  }
}
