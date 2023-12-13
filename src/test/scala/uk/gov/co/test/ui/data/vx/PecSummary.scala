package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryDetails

import java.time.LocalDate

case class ApplicationSummaryDetails(
  historyDetails: HistoryDetails
)

object PEC_SUMMARY_DATA
    extends ApplicationSummaryDetails(
      PEC_EMPLOYMENT_HISTORY
    )

object PEC_EMPLOYMENT_HISTORY
    extends HistoryDetails(
      false,
      historyCheckStarted = LocalDate.now(),
      "Test-T&Cs.pdf",
      true,
      true,
      true,
      dateCheckSentToGrs = LocalDate.now().minusYears(1),
      true,
      dateReceivedHistoryCheck = LocalDate.now().minusDays(1),
      false,
      "Passed",
      dateCheckCompleted = LocalDate.now(),
      dateInfoRequested = LocalDate.now().minusDays(2),
      dateInfoReceived = LocalDate.now(),
      "Autotest - mandatory risk assessment comments",
      dateBF = LocalDate.now(),
      internalNotes = "Autotest - internal notes (optional)"
    )
