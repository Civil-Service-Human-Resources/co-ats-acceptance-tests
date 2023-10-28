package uk.gov.co.test.ui.utils

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{passwordVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.vx.{RecruiterDetails, VacancyDetails}

object RECRUITERS extends RecruiterDetails(s"$usernameVxConfig", s"$passwordVxConfig")

object VACANCIES extends VacancyDetails("Cabinet Office - apply online")
