package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.test.ogd.{OGD_APPLICATION_DATA, OGD_FORM_DATA, OGD_LONG_FORM_DATA, OGD_SHORT_FORM_DATA}
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object OgdFlow extends CivilServiceJobsBasePage {

  def ogdFlow(): Unit = {
    fillShortFormDetails(OGD_SHORT_FORM_DATA)
    fillLongFormDetails(OGD_LONG_FORM_DATA)
    PreSiftEvaluationFlow(OGD_APPLICATION_DATA)
    SiftEvaluationFlow(OGD_APPLICATION_DATA)
    completeAllInterviews(OGD_APPLICATION_DATA)
    moveAndAcceptOffer()
//    fillPecFormDetailsOnly(OGD_FORM_DATA)
  }
}
