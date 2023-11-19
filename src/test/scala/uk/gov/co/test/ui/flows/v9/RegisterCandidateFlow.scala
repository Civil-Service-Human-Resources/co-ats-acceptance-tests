package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.pages.v9.CreateAccountPage.{enterConfirmEmail, enterConfirmPassword, enterEmail, enterFirstName, enterLastName, enterPassword, navigateToCreateAccountPage, registerNewAccount, selectEmployeeType, selectTermsAndConditions}
import uk.gov.co.test.ui.pages.v9.{CandidateDetails, CivilServiceJobsBasePage}

object RegisterCandidateFlow extends CivilServiceJobsBasePage {

  private val fields: Seq[CandidateDetails => Unit] = Seq(
    enterFirstName,
    enterLastName,
    enterEmail,
    enterConfirmEmail,
    enterPassword,
    enterConfirmPassword,
    selectEmployeeType,
    selectTermsAndConditions
  )

  def fillNewCandidateDetails(user: CandidateDetails): Unit = {
    navigateToCreateAccountPage()
    fields.foreach { f =>
      f(user)
    }
    registerNewAccount()
  }
}
