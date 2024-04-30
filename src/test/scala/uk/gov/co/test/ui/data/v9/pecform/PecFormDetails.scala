package uk.gov.co.test.ui.data.v9.pecform

import uk.gov.co.test.ui.pages.v9.pecform._

case class PecFormDetails(
  yourDetails: YourDetails,
  rtwDetails: RtwDetails,
  employmentHistoryDetails: EmploymentHistoryDetails,
  verifyingHistoryDetails: VerifyingHistoryDetails,
  pensionDetails: PensionDetails,
  overseasDetails: OverseasDetails,
  declarationDetails: DeclarationDetails
)
