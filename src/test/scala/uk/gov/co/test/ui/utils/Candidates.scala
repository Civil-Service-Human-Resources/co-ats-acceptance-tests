package uk.gov.co.test.ui.utils

import uk.gov.co.test.ui.pages.v9.CandidateDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.randomLastName

case class CandidateData(candidateDetails: CandidateDetails)

object REGISTERED_CANDIDATE
    extends CandidateDetails("Tony", "Ferguson", "tony.ferguson@example.com", "qwertygh123", true, true)
object REGISTER_CANDIDATE
    extends CandidateDetails(
      "Auto",
      s"$randomLastName",
      s"auto.$randomLastName@atsexample.com",
      "password123!",
      false,
      true
    )
