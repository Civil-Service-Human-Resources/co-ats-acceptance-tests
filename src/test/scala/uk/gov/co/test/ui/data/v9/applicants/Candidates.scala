package uk.gov.co.test.ui.data.v9.applicants

import uk.gov.co.test.ui.data.MasterVacancyDetails.{preferredFirstName, randomEmail, randomFirstName, randomLastName}
import uk.gov.co.test.ui.pages.v9.CandidateDetails
import uk.gov.co.test.ui.pages.v9.SignInPage.passwordCandidate

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

object REGISTER_CANDIDATE
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object MASTER_REGISTER_CANDIDATE
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object MASTER_REGISTER_CANDIDATE_3_MONTHS
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object MASTER_REGISTER_CANDIDATE_6_MONTHS
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object MASTER_REGISTER_CANDIDATE_12_MONTHS
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object MASTER_REGISTER_CANDIDATE_18_MONTHS
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object MASTER_REGISTER_CANDIDATE_21_MONTHS
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_PEC
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )
