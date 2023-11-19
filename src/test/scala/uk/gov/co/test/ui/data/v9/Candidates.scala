package uk.gov.co.test.ui.data.v9

import uk.gov.co.test.ui.pages.v9.CandidateDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.{generateRandomFirstName, generateRandomLastName, randomEmail, randomFirstName, randomLastName}

case class CandidateData(candidateDetails: CandidateDetails)

object REGISTERED_CANDIDATE
    extends CandidateDetails("Tony", "Ferguson", "tony.ferguson@example.com", "qwertygh123", true, true)


object REGISTER_CANDIDATE
  extends CandidateDetails(
    firstname = generateRandomFirstName(),
    lastname = generateRandomLastName(),
    email = s"${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com",
    "password123!",
    false,
    true
  )


object REGISTER_CANDIDATE_1
    extends CandidateDetails(
      firstname = generateRandomFirstName(),
      lastname = generateRandomLastName(),
      email = s"${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com",
      "password123!",
      false,
      true
    )

object REGISTER_CANDIDATE_2
  extends CandidateDetails(
    firstname = generateRandomFirstName(),
    lastname = generateRandomLastName(),
    email = s"${randomFirstName.toLowerCase}.${randomLastName.toLowerCase}@example.com",
    password = "password123!",
    isEmployeeExistingPublicSector = false,
    agreeTermsAndConditions = true
  )
