package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.test.reserve.{RESERVE_APPLICATION_DATA, RESERVE_LONG_FORM_DATA, RESERVE_SHORT_FORM_DATA}
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object ReserveListFlow extends CivilServiceJobsBasePage {

  def reserveListFlow(): Unit = {
    fillShortFormDetails(RESERVE_SHORT_FORM_DATA)
    fillLongFormDetails(RESERVE_LONG_FORM_DATA)
    PreSiftEvaluationFlow(RESERVE_APPLICATION_DATA)
    SiftEvaluationFlow(RESERVE_APPLICATION_DATA)
    completeAllInterviews(RESERVE_APPLICATION_DATA)
  }
}
