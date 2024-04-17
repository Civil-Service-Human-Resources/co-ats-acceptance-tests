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

object REGISTER_CANDIDATE_MENU_OGD
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_1
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_2
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_3
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_4
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_5
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_6
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_7
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_8
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_9
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_10
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_11
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_12
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_13
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_14
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_15
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_16
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_17
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_18
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_19
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_20
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_21
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_22
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_23
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_24
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_25
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )

object REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_26
    extends CandidateDetails(
      firstname = s"$randomFirstName",
      lastname = s"$randomLastName",
      preferredFirstName = s"$preferredFirstName",
      email = s"$randomEmail",
      s"$passwordCandidate",
      false,
      true
    )
