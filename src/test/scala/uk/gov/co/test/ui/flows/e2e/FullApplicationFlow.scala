package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.MasterVacancyDetails.vXInterviewOneOutcome
import uk.gov.co.test.ui.data.test.idvt.{IDVT_APPLICATION_DATA, IDVT_LONG_FORM_DATA, IDVT_PEC_FORM_DATA, IDVT_SHORT_FORM_DATA}
import uk.gov.co.test.ui.data.test.ogd.{OGD_APPLICATION_DATA, OGD_LONG_FORM_DATA, OGD_SHORT_FORM_DATA}
import uk.gov.co.test.ui.data.test.reserve.{RESERVE_APPLICATION_DATA, RESERVE_LONG_FORM_DATA, RESERVE_SHORT_FORM_DATA}
import uk.gov.co.test.ui.data.v9.longform.{LongFormDetails, MASTER_LONG_FORM_DATA}
import uk.gov.co.test.ui.data.v9.pecform.{MASTER_PEC_FORM_DATA, PecFormDetails}
import uk.gov.co.test.ui.data.v9.shortform.{MASTER_SHORT_FORM_DATA, ShortFormDetails}
import uk.gov.co.test.ui.data.vx.application.{ApplicationDetails, MASTER_APPLICATION_DATA}
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.confirmPecSubmissionState
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.employmentHistoryFlow
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
    fillPecFormDetailsOnly(IDVT_PEC_FORM_DATA)
  }

  def fillFullApplicationDetails(
    shortFormDetails: ShortFormDetails,
    longFormDetails: LongFormDetails,
    applicationDetails: ApplicationDetails,
    pecFormDetails: PecFormDetails
  ): Unit = {
    fillShortFormDetails(shortFormDetails)
    fillLongFormDetails(longFormDetails)
    PreSiftEvaluationFlow(applicationDetails)
    SiftEvaluationFlow(applicationDetails)
    completeAllInterviews(applicationDetails)
    moveAndAcceptOffer()
    fillPecFormDetailsOnly(pecFormDetails)
  }

  def reserveListFlow(): Unit = {
    fillShortFormDetails(MASTER_SHORT_FORM_DATA)
    fillLongFormDetails(MASTER_LONG_FORM_DATA)
    PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
    SiftEvaluationFlow(MASTER_APPLICATION_DATA)
    vXInterviewOneOutcome = "Hold"
    completeAllInterviews(MASTER_APPLICATION_DATA)
  }

  def nenPnFlow(
    shortFormDetails: ShortFormDetails,
    longFormDetails: LongFormDetails,
    applicationDetails: ApplicationDetails
  ): Unit = {
    fillShortFormDetails(shortFormDetails)
    fillLongFormDetails(longFormDetails)
    PreSiftEvaluationFlow(applicationDetails)
    SiftEvaluationFlow(applicationDetails)
    completeAllInterviews(applicationDetails)
    moveAndAcceptOffer()
  }

  def completeFullPecFlow(): Unit = {
    PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
    SiftEvaluationFlow(MASTER_APPLICATION_DATA)
    completeAllInterviews(MASTER_APPLICATION_DATA)
    moveAndAcceptOffer()
    fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA)
    confirmPecSubmissionState()
    employmentHistoryFlow(MASTER_APPLICATION_DATA)
  }

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
