package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.pages.vx.vacancytabs.{HistoryDetails, PreSiftDetails}

import java.time.LocalDate

case class ApplicationSummaryDetails(
  historyDetails: HistoryDetails,
  preSiftDetails: PreSiftDetails
)

object APPLICATION_SUMMARY_DATA
    extends ApplicationSummaryDetails(
      APPLICATION_EMPLOYMENT_HISTORY,
      APPLICATION_PRE_SIFT_EVALUATION
    )

object APPLICATION_EMPLOYMENT_HISTORY
    extends HistoryDetails(
      false,
      historyCheckStarted = LocalDate.now(),
      "Test-T&Cs.pdf",
      true,
      true,
      true,
      dateCheckSentToGrs = LocalDate.now().minusDays(1),
      true,
      dateHistoryCheckReceived = LocalDate.now().minusDays(1),
      false,
      "Passed",
      dateCheckCompleted = LocalDate.now(),
      dateInfoRequested = LocalDate.now().minusDays(2),
      dateInfoReceived = LocalDate.now(),
      "Autotest - mandatory risk assessment comments",
      dateBF = LocalDate.now(),
      internalNotes = "Autotest - internal notes (optional)"
    )

object APPLICATION_PRE_SIFT_EVALUATION
    extends PreSiftDetails(
      "A",
      "Autotest - CV assessment comments",
      "B",
      "Autotest - Personal statement comments",
      "C",
      "Autotest - Pre-sift comments",
      "Progress",
      "Autotest - Overall comments"
    )
