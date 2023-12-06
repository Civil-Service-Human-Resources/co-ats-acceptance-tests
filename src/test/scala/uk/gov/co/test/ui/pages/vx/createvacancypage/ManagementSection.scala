package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.ApproachSection.candidateApproach
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class ManagementDetails(
  greatWorkForVeterans: Boolean,
  prisonLeavers: Boolean,
  prisonLeaversNotSuitable: String,
  removeCSRPrinciples: Boolean,
  assignTo: Option[String] = None,
  assignTo2: Option[String] = None,
  grsJobStageType: String,
  grsPecCheckingType: String,
  grsToSift: Boolean,
  grsToAssessAndInterview: Boolean,
  linkToProject: Option[Boolean] = None,
  projectName: Option[String] = None,
  deptComplaintsProcess: Option[String] = None,
  vacancyComments: Option[String] = None
)

object ManagementSection extends VacancyBasePage {

  private lazy val managementSectionId            = s"${formId}_section_100276_col_0"
  private lazy val greatWorkForVeteransYesId      = s"${formId}_datafield_138150_1_1_1"
  private lazy val greatWorkForVeteransNoId       = s"${formId}_datafield_138150_1_1_2"
  private lazy val prisonLeaversYesId             = s"${formId}_datafield_176958_1_1_1"
  private lazy val prisonLeaversNoId              = s"${formId}_datafield_176958_1_1_2"
  private lazy val prisonLeaversLevelOfSecurityId = s"${formId}_datafield_176961_1_1_47616"
  private lazy val prisonLeaversNatureOfRoleId    = s"${formId}_datafield_176961_1_1_47617"
  private lazy val prisonLeaversReservedPostId    = s"${formId}_datafield_176961_1_1_47615"
  private lazy val prisonLeaversOtherId           = s"${formId}_datafield_176961_1_1_47618"
  private lazy val removePrinciplesYesId          = s"${formId}_datafield_100287_1_1_1"
  private lazy val removePrinciplesNoId           = s"${formId}_datafield_100287_1_1_2"
  private lazy val assignToId                     = s"select2-${formId}_datafield_101084_1_1-container"
  private lazy val assignTo2Id                    = s"select2-${formId}_datafield_168380_1_1-container"
  private lazy val grsJobStageTypeId              = s"select2-${formId}_datafield_104968_1_1-container"
  private lazy val grsPecMenuId                   = s"${formId}_datafield_118309_1_1_17450"
  private lazy val grsPecEUExitId                 = s"${formId}_datafield_118309_1_1_17451"
  private lazy val grsPecBauId                    = s"${formId}_datafield_118309_1_1_17449"
  private lazy val grsToSiftYesId                 = s"${formId}_datafield_142798_1_1_1"
  private lazy val grsToSiftNoId                  = s"${formId}_datafield_142798_1_1_2"
  private lazy val grsToAssessAndInterviewYesId   = s"${formId}_datafield_142802_1_1_1"
  private lazy val grsToAssessAndInterviewNoId    = s"${formId}_datafield_142802_1_1_2"
  private lazy val linkToProjectYesId             = s"${formId}_datafield_105092_1_1_1"
  private lazy val linkToProjectNoId              = s"${formId}_datafield_105092_1_1_2"
  private lazy val projectNameInputId             = s"${formId}_datafield_104972_1_1"
  private lazy val complaintsProcessInputId       = s"${formId}_datafield_179305_1_1_en-GB"
  private lazy val vacancyCommentsInputId         = s"${formId}_datafield_100298_1_1"
  var greatForVeterans: Boolean                   = true

  private def selectVeteransAndPrisonLeaversPosition(managementDetails: ManagementDetails): Unit = {
    scrollToElement(By.id(managementSectionId))
    greatForVeterans = managementDetails.greatWorkForVeterans
    if (candidateApproach == "External") {
      if (greatForVeterans) {
        clickOnRadioButton(greatWorkForVeteransYesId)
      } else {
        clickOnRadioButton(greatWorkForVeteransNoId)
      }
      selectPrisonLeavers(managementDetails)
    }
  }

  private def selectPrisonLeavers(managementDetails: ManagementDetails): Unit =
    if (managementDetails.greatWorkForVeterans) clickOnRadioButton(prisonLeaversYesId)
    else {
      clickOnRadioButton(prisonLeaversNoId)
      managementDetails.prisonLeaversNotSuitable match {
        case "Level of security"  => clickOnRadioButton(prisonLeaversLevelOfSecurityId)
        case "Nature of the role" => clickOnRadioButton(prisonLeaversNatureOfRoleId)
        case "Reserved post"      => clickOnRadioButton(prisonLeaversReservedPostId)
        case "Other"              => clickOnRadioButton(prisonLeaversOtherId)
        case _                    => throw new IllegalStateException("Valid search option needs to be entered")
      }
    }

  private def selectRemoveCSRPrinciples(managementDetails: ManagementDetails): Unit =
    if (managementDetails.removeCSRPrinciples) clickOnRadioButton(removePrinciplesYesId)
    else clickOnRadioButton(removePrinciplesNoId)

  private def enterAssignTo(managementDetails: ManagementDetails): Unit = {
    val username = managementDetails.assignTo.get
    selectOptionFromList(username, assignToId, s" $contactNameVxConfig - $username")
  }

  private def enterAssignTo2(managementDetails: ManagementDetails): Unit = {
    val username2 = managementDetails.assignTo2.get
    selectOptionFromList(username2, assignTo2Id, s" $contactNameVxConfig - $username2")
  }

  private def grsRecruitmentStageType(managementDetails: ManagementDetails): Unit = {
    val stageType = managementDetails.grsJobStageType
    if (
      stageType == "Business As Usual (BAU)" ||
      stageType == "Digital" ||
      stageType == "Expression of Interest" ||
      stageType == "Fast Path" ||
      stageType == "Menu" ||
      stageType == "PEC and Onboarding Only (BAU)" ||
      stageType == "PEC and Onboarding Only (EU Exit Priority)" ||
      stageType == "Rolling Campaign" ||
      stageType == "SCS" ||
      stageType == "SCS - Cross government campaign"
    ) {
      waitForVisibilityOfElementById(grsJobStageTypeId).click()
      selectOption(generalInput, stageType)
    }
  }

  private def selectGrsPecCheckingType(managementDetails: ManagementDetails): Unit =
    managementDetails.grsPecCheckingType match {
      case "Menu"    => clickOnRadioButton(grsPecMenuId)
      case "EU Exit" => clickOnRadioButton(grsPecEUExitId)
      case "BAU"     => clickOnRadioButton(grsPecBauId)
    }

  private def selectGrsToSift(managementDetails: ManagementDetails): Unit =
    if (managementDetails.grsToSift) clickOnRadioButton(grsToSiftYesId)
    else clickOnRadioButton(grsToSiftNoId)

  private def selectGrsToAssessAndInterview(managementDetails: ManagementDetails): Unit =
    if (managementDetails.grsToAssessAndInterview) clickOnRadioButton(grsToAssessAndInterviewYesId)
    else clickOnRadioButton(grsToAssessAndInterviewNoId)

  private def selectLinkToProject(managementDetails: ManagementDetails): Unit =
    if (managementDetails.linkToProject.get) {
      clickOnRadioButton(linkToProjectYesId)
      enterText(projectNameInputId, managementDetails.projectName.get)
    } else clickOnRadioButton(linkToProjectNoId)

  private def enterComplaintsProcess(managementDetails: ManagementDetails): Unit =
    enterText(complaintsProcessInputId, managementDetails.deptComplaintsProcess.get)

  private def enterVacancyComments(managementDetails: ManagementDetails): Unit =
    enterText(vacancyCommentsInputId, managementDetails.vacancyComments.get)

  private val management: Seq[ManagementDetails => Unit] = Seq(
    selectVeteransAndPrisonLeaversPosition,
    selectRemoveCSRPrinciples,
    enterAssignTo,
    enterAssignTo2,
    grsRecruitmentStageType,
    selectGrsPecCheckingType,
    selectGrsToSift,
    selectGrsToAssessAndInterview,
    selectLinkToProject,
    enterComplaintsProcess,
    enterVacancyComments
  )

  def managementSection(newVacancyDetails: NewVacancyDetails): Unit =
    management.foreach { f =>
      f(newVacancyDetails.managementDetails)
    }
}
