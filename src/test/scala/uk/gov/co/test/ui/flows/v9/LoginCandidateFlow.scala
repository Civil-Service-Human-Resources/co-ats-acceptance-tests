package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.{enterPassword, enterUsername}
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.navigateToSignInOrCreateAccount

object LoginCandidateFlow extends CivilServiceJobsBasePage {

  private val fields: Seq[Unit] = Seq(
    enterUsername(),
    enterPassword()
  )

  def loginNewCandidate(): Unit = {
    navigateToV9Test()
    navigateToSignInOrCreateAccount()
    fields.foreach { f =>
      f
    }
    clickOn("login_button")
  }
}
