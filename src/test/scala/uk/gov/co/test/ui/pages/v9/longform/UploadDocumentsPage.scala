package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAttachmentRequired, vXCvAttachment, vXExperiencesRequired, vXPersonalStatement}
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.longFormId

case class UploadDocumentsDetails(
  documentLocation: String
)

object UploadDocumentsPage extends CivilServiceJobsBasePage {

  def uploadDocumentsPageTitle      = "Upload documents - Civil Service Jobs - GOV.UK"
  def uploadCvInstructionsId        = s"${longFormId}_field_que_22286_1"
  def uploadCvId                    = s"${longFormId}_datafield_22286_1_1"
  def uploadStatementId             = s"${longFormId}_datafield_22306_1_1"
  def uploadStatementInstructionsId = s"${longFormId}_field_que_22306_1"
  def uploadDocumentsId             = s"${longFormId}_datafield_22309_1_1"
  def uploadDocumentsInstructionsId = s"${longFormId}_field_que_22309_1"

  private def uploadDocumentsPageCheck(): Unit =
    eventually(onPage(uploadDocumentsPageTitle))

  private def uploadCv(uploadDocumentsDetails: UploadDocumentsDetails): Unit =
    if (vXExperiencesRequired && vXCvAttachment) {
      val v9CvInstruction = waitForVisibilityOfElementById(uploadCvInstructionsId).getText
      v9CvInstruction shouldEqual
        """This application form requires you to attach your CV.
          |Your CV must be uploaded in .doc, .docx or .pdf file format, with a maximum file size of 5 MB.
          |Once you have attached a file, you will be able to remove and attach another as many times as required before you submit your application.
          |File upload field, to activate press space bar""".stripMargin
      attachDocuments(uploadCvId, uploadDocumentsDetails.documentLocation)
    }

  private def uploadPersonalStatement(uploadDocumentsDetails: UploadDocumentsDetails): Unit =
    if (vXExperiencesRequired && vXPersonalStatement) {
      val v9StatementInstruction = waitForVisibilityOfElementById(uploadStatementInstructionsId).getText
      v9StatementInstruction shouldEqual
        """This application form requires you to attach your personal statement
          |Your personal statement must be uploaded in.doc, .docx or .pdf file format, with a maximum file size of 5 MB.
          |Once you have attached a file, you will be able to remove and attach another as many times as required before you submit your application.
          |
          |File upload field, to activate press space bar""".stripMargin
      attachDocuments(uploadStatementId, uploadDocumentsDetails.documentLocation)
    }

  private def uploadCandidateDocuments(uploadDocumentsDetails: UploadDocumentsDetails): Unit =
    if (vXAttachmentRequired) {
      val v9DocumentInstruction = waitForVisibilityOfElementById(uploadDocumentsInstructionsId).getText
      v9DocumentInstruction shouldEqual
        """ Documents must be uploaded in .doc, .docx or .pdf file format, with a maximum file size of 5 MB.
          |Once you have attached a file, you will be able to remove and attach another as many times as required before you submit your application.
          |File upload field, to activate press space bar""".stripMargin
      attachDocuments(uploadDocumentsId, uploadDocumentsDetails.documentLocation)
    }

  private val document: Seq[UploadDocumentsDetails => Unit] = Seq(
    uploadCv,
    uploadPersonalStatement,
    uploadCandidateDocuments
  )

  def uploadDocumentsPage(longFormDetails: LongFormDetails): Unit =
    if (vXAttachmentRequired || vXCvAttachment || vXPersonalStatement) {
      uploadDocumentsPageCheck()
      document.foreach { f =>
        f(longFormDetails.uploadDocumentsDetails)
      }
      clickOn(pageContinue)
    }
}
