package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

object NenPnFlow extends CivilServiceJobsBasePage {

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
}
