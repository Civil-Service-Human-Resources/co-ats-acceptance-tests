package uk.gov.co.test.ui.flows.e2e

import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.SHORT_FORM_DATA_PEC
import uk.gov.co.test.ui.data.vx.APPLICATION_SUMMARY_DATA
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{candidateAcceptsOffer, confirmOfferAccepted, confirmPecSubmission, confirmShortFormCompletionNoLongForm}
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.extractApplicationId
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.ProvisionalOfferPage.offerDecisionFlow
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{navigateToApplicationSummary, progressApplicationToOffer}
import uk.gov.co.test.ui.pages.vx.vacancytabs.EmploymentHistoryTab.{EmploymentHistoryVXFlow, completeVXEmploymentHistory}

object PecFlow extends CivilServiceJobsBasePage {

  private val pecFlow: Seq[Unit] = Seq(
    fillShortFormDetails(SHORT_FORM_DATA_PEC),
    confirmShortFormCompletionNoLongForm(),
    extractApplicationId(),
    navigateToApplicationSummary(),
    progressApplicationToOffer(),
    candidateAcceptsOffer(),
    offerDecisionFlow("Accept"),
    confirmOfferAccepted(),
    fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA),
    confirmPecSubmission(),
    navigateToApplicationSummary(),
    completeVXEmploymentHistory(),
    EmploymentHistoryVXFlow(APPLICATION_SUMMARY_DATA)
  )

  def completePecFlow(): Unit =
    pecFlow.foreach { f =>
      f
    }

}