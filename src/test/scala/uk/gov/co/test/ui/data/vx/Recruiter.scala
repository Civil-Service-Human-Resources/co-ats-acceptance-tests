package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{passwordVxConfig, usernameVxConfig}

case class RecruiterDetails(
  username: String,
  password: String
)

object RECRUITER extends RecruiterDetails(s"$usernameVxConfig", s"$passwordVxConfig")
