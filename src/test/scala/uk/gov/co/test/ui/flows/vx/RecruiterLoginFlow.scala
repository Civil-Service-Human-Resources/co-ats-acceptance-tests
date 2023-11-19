package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.data.vx.RecruiterDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

object RecruiterLoginFlow extends VacancyBasePage {

  private val login: Seq[RecruiterDetails => Unit] = Seq(
    enterUsername,
    enterPassword
  )

  def fillRecruiterDetails(recruiterDetails: RecruiterDetails): Unit = {
    login.foreach { f =>
      f(recruiterDetails)
    }
    loginProcess()
  }
}
