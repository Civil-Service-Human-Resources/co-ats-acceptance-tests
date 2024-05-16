package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCandidateUploadIdentityDocs, vXDetailsForUploadIdentityDocs}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class IdentityDocDetails(
  identityDoc: String
)

object UploadIdentityDocsPage extends CivilServiceJobsBasePage {

  private lazy val uploadIdentityDocPageTitle = "Upload identity documents - Civil Service Jobs - GOV.UK"
  def instructionsTextId                      = s"${pecFormId}_label_181836_1"
  def uploadDocOneId                          = s"${pecFormId}_datafield_159126_1_1"

  private def identityDocPageCheck(): Unit =
    eventually(onPage(uploadIdentityDocPageTitle))

  private def confirmUploadInstructions(): Unit = {
    val v9PecInstruction = waitForVisibilityOfElementById(instructionsTextId).getText
    v9PecInstruction shouldEqual s"We need to check your identity documents to verify your identity.\nThe documents you need to provide:\n$vXDetailsForUploadIdentityDocs"
  }

  private def uploadIdentityDocuments(identityDocDetails: IdentityDocDetails): Unit = {
    confirmUploadInstructions()
    attachDocuments(uploadDocOneId, identityDocDetails.identityDoc)
  }

  private val identity: Seq[IdentityDocDetails => Unit] = Seq(
    uploadIdentityDocuments
  )

  def uploadIdentityDocPage(pecFormDetails: PecFormDetails): Unit =
    if (vXCandidateUploadIdentityDocs) {
      identityDocPageCheck()
      identity.foreach { f =>
        f(pecFormDetails.identityDocDetails)
      }
      clickOn(pageContinue)
    }
}
