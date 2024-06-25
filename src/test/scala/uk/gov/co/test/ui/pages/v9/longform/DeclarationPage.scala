package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.longFormId

case class DeclarationDetails(
  acceptLongFormTAndCs: Boolean
)

object DeclarationPage extends CivilServiceJobsBasePage {

  private lazy val declarationTitle   = "Declaration - Civil Service Jobs - GOV.UK"
  def declarationTermsAndConditionsId = s"${longFormId}_datafield_205967_1_1_804_label"
  val submitButtonPath                = ".//input[@value='Submit']"
  val longFormSubmission              = "submit_button"

  private def declarationPageCheck(): Unit =
    eventually(onPage(declarationTitle))

  private def acceptDeclarationTermsAndConditions(declarationDetails: DeclarationDetails): Unit =
    if (declarationDetails.acceptLongFormTAndCs) {
      clickOn(declarationTermsAndConditionsId)
    } else throw new IllegalStateException("You must accept longform terms and condition to proceed!")

  private val declaration: Seq[DeclarationDetails => Unit] = Seq(
    acceptDeclarationTermsAndConditions
  )

  def declarationPage(longFormDetails: LongFormDetails): Unit = {
    declarationPageCheck()
    declaration.foreach { f =>
      f(longFormDetails.declarationDetails)
    }
  }
}
