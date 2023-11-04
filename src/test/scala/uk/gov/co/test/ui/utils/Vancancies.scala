package uk.gov.co.test.ui.utils

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{passwordVxConfig, usernameVxConfig, vacancyEmailVxConfig}
import uk.gov.co.test.ui.pages.vx.createvacancypage._
import uk.gov.co.test.ui.pages.vx.{RecruiterDetails, VacancyDetails}

object RECRUITERS extends RecruiterDetails(s"$usernameVxConfig", s"$passwordVxConfig")

object GRS_VACANCY
    extends VacancyDetails(
      "Department for Environment, Food and Rural Affairs - Apply online",
      "GCQA OGD DEFRA (CORE)",
      32,
      "DEFRA - COO - Commercial",
      "Analytical",
      "Other",
      "1",
      "Internal",
      true,
      true,
      "Autotest",
      "Autotest",
      true,
      "6 Months",
      "Remote (anywhere in the UK)",
      "SK1 3BX",
      "Manchester",
      "North West",
      "Germany",
      false,
      false,
      "Permanent",
      "Full-time",
      "Administrative Assistant",
      "GBP (£)",
      25000,
      false,
      "Autotest",
      "Autotest",
      "Autotest",
      "Autotest",
      "Automation Tester",
      s"$vacancyEmailVxConfig",
      "Automation Tester",
      s"$vacancyEmailVxConfig",
      s"$vacancyEmailVxConfig"
    )

case class NewVacancyDetails(
  basicDetails: BasicDetails,
  jobInfoDetails: JobInfoDetails,
  approachDetails: ApproachDetails,
  approvalDetails: ApprovalDetails,
  reserveListDetails: ReserveListDetails,
  locationsDetails: LocationsDetails
)
object VACANCY_DATA
    extends NewVacancyDetails(
      VACANCY_BASIC_DETAILS,
      VACANCY_JOB_INFORMATION,
      VACANCY_APPROACH,
      VACANCY_APPROVAL,
      VACANCY_RESERVE_LIST,
      VACANCY_LOCATIONS
    )

object VACANCY_BASIC_DETAILS
    extends BasicDetails(
      "Department for Environment, Food and Rural Affairs - Apply online",
      "GCQA OGD DEFRA (CORE)",
      32
    )
object VACANCY_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Department for Environment, Food and Rural Affairs - Apply online",
      "DEFRA - COO - Commercial",
      "Autotest - Business area detail",
      "Analytical",
      "Other",
      "1"
    )
object VACANCY_APPROACH
    extends ApproachDetails(
      "Internal",
      true,
      "Autotest - Eligibility statement"
    )
object VACANCY_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre"
    )

object VACANCY_RESERVE_LIST
    extends ReserveListDetails(
      true,
      "6 Months"
    )

object VACANCY_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "SK1 3BX",
      "Manchester",
      "North West",
      "Germany",
      "Newcastle, Liverpool, Cardiff",
      true,
      true,
      "All communities",
      true,
      "2",
      "London"
    )
