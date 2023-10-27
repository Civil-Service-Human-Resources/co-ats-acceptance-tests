package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.pages.v9.CreateAccountPage.{createNewAccount, enterConfirmEmail, enterConfirmPassword, enterEmail, enterFirstName, enterLastName, enterPassword, selectEmployeeType, selectTermsAndConditions}
import uk.gov.co.test.ui.pages.v9.{CSJobsBasePage, CandidateDetails}

object RegisterCandidateFlow extends CSJobsBasePage {

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

  def fillCandidateDetails(user: CandidateDetails): Unit = {
    fields.foreach { f =>
      f(user)
    }
    createNewAccount()
  }
}
