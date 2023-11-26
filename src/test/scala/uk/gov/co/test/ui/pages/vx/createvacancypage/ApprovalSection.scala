package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class ApprovalDetails(
  approval: Boolean,
  budgetaryAuthInfo: String,
  costCentre: String
)

object ApprovalSection extends VacancyBasePage {

  private lazy val budgetaryInfoId         = s"${formId}_datafield_154500_1_1"
  private lazy val costCentreId            = s"${formId}_datafield_154493_1_1"
  private lazy val approvalId              = s"${formId}_field_154507_1"
  private lazy val approvalYesId           = s"${formId}_datafield_154507_1_1_1"
  private lazy val approvalNoId            = s"${formId}_datafield_154507_1_1_2"
  private lazy val uploadApprovalFileOneId = s"${formId}_datafield_154489_1_1"

  private def budgetaryInfo(info: String): Unit = {
    val field = waitForVisibilityOfElementById(budgetaryInfoId)
    field.sendKeys(info)
  }

  private def costCentre(centre: String): Unit = {
    val field = waitForVisibilityOfElementById(costCentreId)
    field.sendKeys(centre)
  }

  private def selectApproval(approvalDetails: ApprovalDetails): Unit = {
    scrollToElement(By.id(approvalId))
    if (approvalDetails.approval) {
      clickOnRadioButton(approvalYesId)
      budgetaryInfo(approvalDetails.budgetaryAuthInfo)
    } else {
      clickOnRadioButton(approvalNoId)
    }
    costCentre(approvalDetails.costCentre)
    uploadApprovalFile("CSJ-T&Cs.docx")
  }

  def importFilesPath : String = "/src/test/resource/import/"

  private def uploadApprovalFile(fileName : String): Unit = {
    val getCurrentDirectory = new java.io.File(".").getCanonicalPath
    val filePath = getCurrentDirectory.concat(importFilesPath).concat(fileName)
    val fileElement: WebElement = id(uploadApprovalFileOneId).findElement.get.underlying
    fileElement.sendKeys(filePath)
  }

  private val approval: Seq[ApprovalDetails => Unit] = Seq(
    selectApproval
  )

  def approvalSection(newVacancyDetails: NewVacancyDetails): Unit =
    approval.foreach { f =>
      f(newVacancyDetails.approvalDetails)
    }
}
