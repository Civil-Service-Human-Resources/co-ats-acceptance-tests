package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.WebElement
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXUploadAttachmentRequired, vXCandidateInstructions}

case class UploadDocumentsDetails(
  documentLocation: String
)

object UploadDocumentsPage extends CivilServiceJobsBasePage {

  def uploadDocumentsPageTitle = "Upload documents - Civil Service Jobs - GOV.UK"
  def uploadDocumentsId        = s"${formId}_datafield_22309_1_1"
  def instructionsTextPath     = ".//*[@class='hform_lbl_text']"

  private def uploadDocumentsPageCheck(): Unit =
    eventually(onPage(uploadDocumentsPageTitle))

  private def confirmInstructions(): Unit = {
    uploadDocumentsPageCheck()
    val v9Instruction = waitForVisibilityOfElementByPath(instructionsTextPath).getText
    v9Instruction shouldEqual vXCandidateInstructions
  }

  def importFilesPath: String = "/src/test/resource/import/"

  private def uploadCandidateDocuments(uploadDocumentsDetails: UploadDocumentsDetails): Unit = {
    val getCurrentDirectory     = new java.io.File(".").getCanonicalPath
    val filePath                = getCurrentDirectory.concat(importFilesPath).concat(uploadDocumentsDetails.documentLocation)
    val fileElement: WebElement = id(uploadDocumentsId).findElement.get.underlying
    fileElement.sendKeys(filePath)
  }

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
