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
  def instructionsTextOneId                      = s"${pecFormId}_label_181836_1"
  def instructionsTextTwoId                          = s"${pecFormId}_label_181858_1"
  def instructionsTextThreeId                          = s"${pecFormId}_label_181682_1"
  def uploadDocOneId                          = s"${pecFormId}_datafield_159126_1_1"


  private def identityDocPageCheck(): Unit =
    eventually(onPage(uploadIdentityDocPageTitle))

  private def confirmUploadInstructions(): Unit = {
    val v9PecInstructionOne = waitForVisibilityOfElementById(instructionsTextOneId).getText
    val v9PecInstructionTwo = waitForVisibilityOfElementById(instructionsTextTwoId).getText
    val v9PecInstructionThree = waitForVisibilityOfElementById(instructionsTextThreeId).getText
    v9PecInstructionOne shouldEqual s"We need to check your identity documents to verify your identity.\nThe documents you need to provide:\n$vXDetailsForUploadIdentityDocs"
    v9PecInstructionTwo shouldEqual "One of the documents you provide must contain your current address. This could be your UK driving licence, a utility bill, your Council Tax statement or a bank statement. The document needs to be original and dated within the last 3 months."
    v9PecInstructionThree shouldEqual "When you take copies of your documents, you need to make sure that:\nyou have not covered any part of the document\nall 4 edges of the document are in your photo\nyou can clearly see all the text and images in the document\nthere's no shine on the document from a light or window\nYour files need to be in JPG, PDF, Word (doc, docx) or ODF (Open Office) format.\nThe total size of attached files needs to be less than 5 megabytes (5 MB)."
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
