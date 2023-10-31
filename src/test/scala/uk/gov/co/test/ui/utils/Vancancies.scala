package uk.gov.co.test.ui.utils

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{passwordVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.vx.{RecruiterDetails, VacancyDetails}

object RECRUITERS extends RecruiterDetails(s"$usernameVxConfig", s"$passwordVxConfig")

object GRS_VACANCY
    extends VacancyDetails(
      "Department for Environment, Food and Rural Affairs - Apply online",
      "GCQA OGD DEFRA",
      32,
      "DEFRA - COO - Finance",
      "Corporate Finance"
    )
