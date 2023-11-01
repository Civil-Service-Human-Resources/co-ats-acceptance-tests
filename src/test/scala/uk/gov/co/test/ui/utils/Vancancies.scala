package uk.gov.co.test.ui.utils

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{passwordVxConfig, usernameVxConfig}
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
      "External",
      true,
      "Autotest",
      false,
      "Remote (anywhere in the UK)",
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
      "Gulam Choudhury",
      "gulam.choudhury@digital.cabinet-office.gov.uk",
      "Gulam Choudhury",
      "gulam.choudhury@digital.cabinet-office.gov.uk",
      "gulam.choudhury@digital.cabinet-office.gov.uk"
    )
