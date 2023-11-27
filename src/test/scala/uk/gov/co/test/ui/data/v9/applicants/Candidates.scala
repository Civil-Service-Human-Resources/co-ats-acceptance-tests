package uk.gov.co.test.ui.data.v9.applicants

import uk.gov.co.test.ui.pages.v9.CandidateDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.{generatePreferredFirstName, generateRandomFirstName, generateRandomLastName, generatedEmail, passwordCandidate}

case class CandidateData(candidateDetails: CandidateDetails)

object REGISTERED_CANDIDATE
    extends CandidateDetails(
      "John",
      "Yates",
      "Bones",
      "john.yates@example.com",
      s"$passwordCandidate",
      false,
      true
    )

object MAIN_REGISTER_CANDIDATE
    extends CandidateDetails(
      firstname = generateRandomFirstName(),
      lastname = generateRandomLastName(),
      preferredFirstName = generatePreferredFirstName(),
      email = generatedEmail(),
      s"$passwordCandidate",
      false,
      true
    )
