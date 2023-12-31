package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{changeSystem, pecStartFunction}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.DeclarationPage.{declarationPage, pecFormSubmission}
import uk.gov.co.test.ui.pages.v9.pecform.EmploymentHistoryPage.employmentHistoryPage
import uk.gov.co.test.ui.pages.v9.pecform.VerifyingHistoryPage.verifyingHistoryPage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.yourDetailsPage

object PecFormFlow extends CivilServiceJobsBasePage {

  private val pecForm: Seq[PecFormDetails => Unit] = Seq(
    yourDetailsPage,
    employmentHistoryPage,
    verifyingHistoryPage,
    declarationPage
  )

  def fillPecFormDetails(pecFormDetails: PecFormDetails): Unit = {
    pecForm.foreach { f =>
      f(pecFormDetails)
    }
    clickOn(pecFormSubmission)
  }

  def fillPecFormDetailsOnly(pecFormDetails: PecFormDetails): Unit = {
    if (currentUrl.contains("recruiter")) {
      changeSystem("candidate")
    }
    pecStartFunction().click()
    pecForm.foreach { f =>
      f(pecFormDetails)
    }
    clickOn(pecFormSubmission)
  }
}
