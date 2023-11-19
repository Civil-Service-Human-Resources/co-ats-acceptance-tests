package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId

case class DeclarationDetails(
  acceptTermsAndConditions: Boolean
)

object DeclarationPage extends CivilServiceJobsBasePage {

  private lazy val declarationTitle   = "Declaration - Civil Service Jobs - GOV.UK"
  def declarationTermsAndConditionsId = s"${formId}_datafield_22499_1_1_804_label"
  val shortFormSubmission             = "submit_button"

  private def declarationPageCheck(): Unit =
    eventually(onPage(declarationTitle))

  private def acceptDeclarationTermsAndConditions(declarationDetails: DeclarationDetails): Unit =
    if (declarationDetails.acceptTermsAndConditions) clickOn(declarationTermsAndConditionsId)

  private val declaration: Seq[DeclarationDetails => Unit] = Seq(
    acceptDeclarationTermsAndConditions
  )

  def declarationPage(shortFormDetails: ShortFormDetails): Unit = {
    declarationPageCheck()
    declaration.foreach { f =>
      f(shortFormDetails.declarationDetails)
    }
  }
}
