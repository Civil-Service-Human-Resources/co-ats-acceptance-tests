package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.{APPLICATION_DATA, RESERVE_APPLICATION_DATA}
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object ReserveListFlow extends CivilServiceJobsBasePage {

  def reserveListFlow(): Unit = {
    fillShortFormDetails(MASTER_SHORT_FORM_DATA)
    fillLongFormDetails(MASTER_LONG_FORM_DATA)
    PreSiftEvaluationFlow(APPLICATION_DATA)
    SiftEvaluationFlow(APPLICATION_DATA)
    completeAllInterviews(RESERVE_APPLICATION_DATA)
  }
}
