package uk.gov.co.test.ui.data.v9.applicants

import uk.gov.co.test.ui.pages.v9.CandidateDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.{generatePreferredFirstName, generateRandomFirstName, generateRandomLastName, generatedEmail}

case class CandidateData(candidateDetails: CandidateDetails)

object REGISTERED_CANDIDATE
    extends CandidateDetails(
      "Jon",
      "Jones",
      "Bones",
      "jon.jones@example.com",
      "qwertygh123",
      true,
      true
    )

object MAIN_REGISTER_CANDIDATE
    extends CandidateDetails(
      firstname = generateRandomFirstName(),
      lastname = generateRandomLastName(),
      preferredFirstName = generatePreferredFirstName(),
      email = generatedEmail(),
      "password123!",
      false,
      true
    )
