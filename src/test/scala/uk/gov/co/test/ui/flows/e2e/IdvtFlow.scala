package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.test.idvt.{IDVT_APPLICATION_DATA, IDVT_FORM_DATA, IDVT_LONG_FORM_DATA, IDVT_SHORT_FORM_DATA}
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object IdvtFlow extends CivilServiceJobsBasePage {

  def idvtFlow(): Unit = {
    fillShortFormDetails(IDVT_SHORT_FORM_DATA)
    fillLongFormDetails(IDVT_LONG_FORM_DATA)
    PreSiftEvaluationFlow(IDVT_APPLICATION_DATA)
    SiftEvaluationFlow(IDVT_APPLICATION_DATA)
    completeAllInterviews(IDVT_APPLICATION_DATA)
    moveAndAcceptOffer()
    fillPecFormDetailsOnly(IDVT_FORM_DATA)
  }
}
