package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCrcCheckProvider, vXCrcLevel}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class DeclarationDetails(
  acceptLongFormTAndCs: Boolean,
  acceptDbsTermsOne: Boolean,
  acceptDbsTermsTwo: Boolean,
  acceptDbsTermsThree: Boolean
)

object DeclarationPage extends CivilServiceJobsBasePage {

  private lazy val declarationTitle   = "Declaration - Civil Service Jobs - GOV.UK"
  def declarationTermsAndConditionsId = s"${pecFormId}_datafield_22499_1_1_804_label"
  def dbsTermsOneId                   = s"${pecFormId}_datafield_72275_1_1_15120_label"
  def dbsTermsTwoId                   = s"${pecFormId}_datafield_89002_1_1_15120_label"
  def dbsTermsThreeId                 = s"${pecFormId}_datafield_89006_1_1_15120_label"
  def pecDeclarationTAndCsId          = s"${pecFormId}_datafield_205986_1_1_804_label"
  val pecFormSubmission               = "submit_button"

  private def declarationPageCheck(): Unit =
    eventually(onPage(declarationTitle))

  private def acceptDbsTerms(declarationDetails: DeclarationDetails): Unit =
    if (vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) {
      if (declarationDetails.acceptDbsTermsOne) radioSelect(dbsTermsOneId)
      if (declarationDetails.acceptDbsTermsTwo) radioSelect(dbsTermsTwoId)
      if (declarationDetails.acceptDbsTermsThree) radioSelect(dbsTermsThreeId)
    }

  private def acceptDeclarationTermsAndConditions(declarationDetails: DeclarationDetails): Unit =
    if (declarationDetails.acceptLongFormTAndCs) {
      clickOn(pecDeclarationTAndCsId)
    } else throw new IllegalStateException("You must accept pec form terms and condition to proceed!")

  private val declaration: Seq[DeclarationDetails => Unit] = Seq(
    acceptDbsTerms,
    acceptDeclarationTermsAndConditions
  )

  def declarationPage(pecFormDetails: PecFormDetails): Unit = {
    declarationPageCheck()
    declaration.foreach { f =>
      f(pecFormDetails.declarationDetails)
    }
  }
}
