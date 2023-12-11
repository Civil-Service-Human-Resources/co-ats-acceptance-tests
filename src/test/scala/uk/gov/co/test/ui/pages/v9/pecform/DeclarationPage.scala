package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class DeclarationDetails(
  acceptLongFormTAndCs: Boolean
)

object DeclarationPage extends CivilServiceJobsBasePage {

  private lazy val declarationTitle   = "Declaration - Civil Service Jobs - GOV.UK"
  def declarationTermsAndConditionsId = s"${pecFormId}_datafield_22499_1_1_804_label"
  val submitButtonPath                = ".//input[@value='Submit']"
  val pecFormSubmission               = "submit_button"

  private def declarationPageCheck(): Unit =
    eventually(onPage(declarationTitle))

  private def acceptDeclarationTermsAndConditions(declarationDetails: DeclarationDetails): Unit = {
//    val submitButton = driver.findElement(By.xpath(submitButtonPath))
//    if (submitButton.isDisplayed && !submitButton.isEnabled) {
//      if (declarationDetails.acceptLongFormTAndCs) {
//        clickOn(declarationTermsAndConditionsId)
//      } else throw new IllegalStateException("You must accept longform terms and condition to proceed!")
//    } else throw new IllegalStateException("Submit button should be available before accepting terms & conditions!")
  }

  private val declaration: Seq[DeclarationDetails => Unit] = Seq(
    acceptDeclarationTermsAndConditions
  )

  def declarationPage(pecFormDetails: PecFormDetails): Unit = {
    declarationPageCheck()
    declaration.foreach { f =>
      f(pecFormDetails.declarationDetails)
    }
  }
}
