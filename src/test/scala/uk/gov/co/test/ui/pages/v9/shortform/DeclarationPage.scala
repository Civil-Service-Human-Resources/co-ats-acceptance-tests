package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.v9RunInWelsh
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.shortFormId

case class DeclarationDetails(
  acceptTermsAndConditions: Boolean
)

object DeclarationPage extends CivilServiceJobsBasePage {

  private lazy val declarationTitle   = "Declaration - Civil Service Jobs - GOV.UK"
  private lazy val welshDeclarationTitle   = "Datganiad - Civil Service Jobs - GOV.UK"
  def declarationTermsAndConditionsId = s"${shortFormId}_datafield_22499_1_1_804_label"

  private def declarationPageCheck(): Unit =
    if (v9RunInWelsh) eventually(onPage(welshDeclarationTitle)) else eventually(onPage(declarationTitle))

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
