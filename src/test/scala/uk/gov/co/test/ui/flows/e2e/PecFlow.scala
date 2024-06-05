package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{candidateAcceptsOffer, confirmOfferAcceptedState, confirmPecSubmissionState, confirmShortFormCompletionNoLongForm}
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.extractApplicationId
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.ProvisionalOfferPage.offerDecisionFlow
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{navigateToApplicationSummary, progressApplicationToOffer}
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.{EmploymentHistoryVXFlow, completeVXEmploymentHistory}

object PecFlow extends CivilServiceJobsBasePage {

  private val pecFlow: Seq[Unit] = Seq(
    fillShortFormDetails(MASTER_SHORT_FORM_DATA),
    confirmShortFormCompletionNoLongForm(),
    extractApplicationId(),
    navigateToApplicationSummary(),
    progressApplicationToOffer(),
    candidateAcceptsOffer(),
    offerDecisionFlow("Accept"),
    confirmOfferAcceptedState(),
    fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA),
    confirmPecSubmissionState(),
    navigateToApplicationSummary(),
    completeVXEmploymentHistory(),
    EmploymentHistoryVXFlow(MASTER_APPLICATION_DATA)
  )

  def completePecFlow(): Unit =
    pecFlow.foreach { f =>
      f
    }

}
