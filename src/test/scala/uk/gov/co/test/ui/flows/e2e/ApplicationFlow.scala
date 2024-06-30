package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.test.idvt.{IDVT_APPLICATION_DATA, IDVT_FORM_DATA, IDVT_LONG_FORM_DATA, IDVT_SHORT_FORM_DATA}
import uk.gov.co.test.ui.data.test.reserve.{RESERVE_APPLICATION_DATA, RESERVE_LONG_FORM_DATA, RESERVE_SHORT_FORM_DATA}
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object FullApplicationFlow extends CivilServiceJobsBasePage {

  def idvtFlow(): Unit = {
    fillShortFormDetails(IDVT_SHORT_FORM_DATA)
    fillLongFormDetails(IDVT_LONG_FORM_DATA)
    PreSiftEvaluationFlow(IDVT_APPLICATION_DATA)
    SiftEvaluationFlow(IDVT_APPLICATION_DATA)
    completeAllInterviews(IDVT_APPLICATION_DATA)
    moveAndAcceptOffer()
    fillPecFormDetailsOnly(IDVT_FORM_DATA)
  }

  def fillFullApplicationDetails(shortFormDetails: ShortFormDetails, longFormDetails: LongFormDetails, applicationDetails: ApplicationDetails, pecFormDetails: PecFormDetails): Unit = {
    fillShortFormDetails(shortFormDetails)
    fillLongFormDetails(longFormDetails)
    PreSiftEvaluationFlow(applicationDetails)
    SiftEvaluationFlow(applicationDetails)
    completeAllInterviews(applicationDetails)
    moveAndAcceptOffer()
    fillPecFormDetailsOnly(pecFormDetails)
  }

  def reserveListFlow(): Unit = {
    fillShortFormDetails(RESERVE_SHORT_FORM_DATA)
    fillLongFormDetails(RESERVE_LONG_FORM_DATA)
    PreSiftEvaluationFlow(RESERVE_APPLICATION_DATA)
    SiftEvaluationFlow(RESERVE_APPLICATION_DATA)
    completeAllInterviews(RESERVE_APPLICATION_DATA)
  }
}
