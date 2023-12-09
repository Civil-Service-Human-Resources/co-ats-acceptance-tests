package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.pecStartFunction
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.EmploymentHistoryPage.employmentHistoryPage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.yourDetailsPage

object PecFormFlow extends CivilServiceJobsBasePage {

  private val pecForm: Seq[PecFormDetails => Unit] = Seq(
    yourDetailsPage,
    employmentHistoryPage
  )

  def fillPecFormDetails(pecFormDetails: PecFormDetails): Unit = {
    pecForm.foreach { f =>
      f(pecFormDetails)
    }
    clickOn(submitForm)
  }

  def fillPecFormDetailsOnly(pecFormDetails: PecFormDetails): Unit = {
    pecStartFunction().click()
    pecForm.foreach { f =>
      f(pecFormDetails)
    }
    clickOn(submitForm)
  }
}
