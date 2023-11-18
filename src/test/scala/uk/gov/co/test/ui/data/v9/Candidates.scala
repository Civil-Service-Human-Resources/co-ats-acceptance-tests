package uk.gov.co.test.ui.data.v9

import uk.gov.co.test.ui.pages.v9.CandidateDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.{randomEmail, randomFirstName, randomLastName}

case class CandidateData(candidateDetails: CandidateDetails)

object REGISTERED_CANDIDATE
    extends CandidateDetails("Tony", "Ferguson", "tony.ferguson@example.com", "qwertygh123", true, true)

object REGISTER_CANDIDATE
    extends CandidateDetails(
      s"$randomFirstName",
      s"$randomLastName",
      s"$randomEmail",
      "password123!",
      false,
      true
    )
