package uk.gov.co.test.ui.utils

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{passwordVxConfig, usernameVxConfig, vacancyEmailVxConfig}
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
