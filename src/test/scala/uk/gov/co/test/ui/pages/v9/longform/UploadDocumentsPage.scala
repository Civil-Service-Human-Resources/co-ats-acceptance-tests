package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCandidateInstructions, vXUploadAttachmentRequired}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.longFormId

case class UploadDocumentsDetails(
  documentLocation: String
)

object UploadDocumentsPage extends CivilServiceJobsBasePage {

  def uploadDocumentsPageTitle = "Upload documents - Civil Service Jobs - GOV.UK"
  def uploadDocumentsId        = s"${longFormId}_datafield_22309_1_1"
  def instructionsTextPath     = ".//*[@class='hform_lbl_text']"

  private def uploadDocumentsPageCheck(): Unit =
    eventually(onPage(uploadDocumentsPageTitle))

  private def confirmInstructions(): Unit = {
    uploadDocumentsPageCheck()
    val v9Instruction = waitForVisibilityOfElementByPath(instructionsTextPath).getText
    v9Instruction shouldEqual """Autotest - Instructions for candidate 
                                |Documents must be uploaded in .doc, .docx or .pdf file format, with a maximum file size of 512 KB.
                                |Once you have attached a file, you will be able to remove and attach another as many times as required before you submit your application.""".stripMargin
  }

  private def uploadCandidateDocuments(uploadDocumentsDetails: UploadDocumentsDetails): Unit =
    attachDocuments(uploadDocumentsId, uploadDocumentsDetails.documentLocation)

  private val document: Seq[UploadDocumentsDetails => Unit] = Seq(
    uploadCandidateDocuments
  )

  def uploadDocumentsPage(longFormDetails: LongFormDetails): Unit =
    if (vXUploadAttachmentRequired) {
      confirmInstructions()
      document.foreach { f =>
        f(longFormDetails.uploadDocumentsDetails)
      }
      clickOn(pageContinue)
    }
}
