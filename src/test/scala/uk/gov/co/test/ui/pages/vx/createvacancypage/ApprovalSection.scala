package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXBudgetaryApproval, vXCostCentre, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class ApprovalDetails(
  approval: Boolean,
  budgetaryAuthInfo: String,
  costCentre: String,
  fileToUpload: String
)

object ApprovalSection extends VacancyBasePage {

  def budgetaryInfoId         = s"${vacancyFormId}_datafield_154500_1_1"
  def costCentreId            = s"${vacancyFormId}_datafield_154493_1_1"
  def approvalId              = s"${vacancyFormId}_field_154507_1"
  def approvalYesId           = s"${vacancyFormId}_datafield_154507_1_1_1"
  def approvalNoId            = s"${vacancyFormId}_datafield_154507_1_1_2"
  def uploadApprovalFileOneId = s"${vacancyFormId}_datafield_154489_1_1"

  private def budgetaryInfo(info: String): Unit = {
    val field = waitForVisibilityOfElementById(budgetaryInfoId)
    field.clear()
    field.sendKeys(info)
  }

  private def costCentre(centre: String): Unit = {
    val field = waitForVisibilityOfElementById(costCentreId)
    field.clear()
    field.sendKeys(centre)
  }

  private def selectApproval(approvalDetails: ApprovalDetails): Unit = {
    scrollToElement(By.id(approvalId))
    vXBudgetaryApproval = approvalDetails.approval
    vXCostCentre = approvalDetails.costCentre
    if (vXBudgetaryApproval) {
      clickOnRadioButton(approvalYesId)
      budgetaryInfo(approvalDetails.budgetaryAuthInfo)
    } else {
      clickOnRadioButton(approvalNoId)
    }
    costCentre(vXCostCentre)
    uploadApprovalFile(approvalDetails.fileToUpload)
  }

  private def uploadApprovalFile(fileName: String): Unit =
    attachDocuments(uploadApprovalFileOneId, fileName)

  private val approval: Seq[ApprovalDetails => Unit] = Seq(
    selectApproval
  )

  def approvalSection(newVacancyDetails: NewVacancyDetails): Unit =
    approval.foreach { f =>
      f(newVacancyDetails.approvalDetails)
    }
}
