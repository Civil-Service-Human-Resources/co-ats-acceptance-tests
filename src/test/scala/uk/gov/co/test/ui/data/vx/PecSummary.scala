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
      true,
      historyCheckStarted = LocalDate.now(),
      "Test-T&Cs.pdf",
      false,
      true,
      true,
      LocalDate.now().minusDays(2),
      false,
      LocalDate.now().minusDays(1),
      true,
      "Passed",
      LocalDate.now(),
      LocalDate.now().minusDays(2),
      LocalDate.now(),
      "Autotest - mandatory risk assessment comments",
      LocalDate.now(),
      "Autotest - internal notes (optional)"
    )
