package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{passwordVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.vx.RecruiterDetails

case class Recruiter(recruiter: Recruiter)

object RECRUITER extends RecruiterDetails(s"$usernameVxConfig", s"$passwordVxConfig")
