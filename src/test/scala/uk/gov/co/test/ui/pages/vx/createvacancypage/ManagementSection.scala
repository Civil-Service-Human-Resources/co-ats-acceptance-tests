package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class ManagementDetails(
  removeCSRPrinciples: Boolean,
  assignTo: Option[String] = None,
  assignTo2: Option[String] = None
)

object ManagementSection extends VacancyBasePage {

  private lazy val managementSectionId   = s"${formId}_section_100276_col_0"
  private lazy val removePrinciplesYesId = s"${formId}_datafield_100287_1_1_1"
  private lazy val removePrinciplesNoId  = s"${formId}_datafield_100287_1_1_2"
  private lazy val assignToId            = s"select2-${formId}_datafield_101084_1_1-container"
  private lazy val assignTo2Id           = s"select2-${formId}_datafield_168380_1_1-container"
  private lazy val assignment            = s" $nameVxConfig - $emailVxConfig"
  private lazy val grsJobStageType       = s"select2-${formId}_datafield_104968_1_1-container"

  def selectRemoveCSRPrinciples(managementDetails: ManagementDetails): Unit = {
    scrollToElement(By.id(managementSectionId))
    if (managementDetails.removeCSRPrinciples) clickOnRadioButton(removePrinciplesYesId)
    else clickOnRadioButton(removePrinciplesNoId)
  }

  def enterAssignTo(managementDetails: ManagementDetails): Unit =
    selectOptionFromList(managementDetails.assignTo.get, assignToId, assignment)

  def enterAssignTo2(managementDetails: ManagementDetails): Unit =
    selectOptionFromList(managementDetails.assignTo2.get, assignTo2Id, assignment)

  private val management: Seq[ManagementDetails => Unit] = Seq(
    selectRemoveCSRPrinciples,
    enterAssignTo,
    enterAssignTo2
  )

  def managementSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    management.foreach { f =>
      f(newVacancyDetails.managementDetails)
    }
}