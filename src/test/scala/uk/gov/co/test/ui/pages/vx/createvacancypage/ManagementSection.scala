package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{candidateApproach, vXGreatForVeterans, vXGrsVacancy}

case class ManagementDetails(
  greatWorkForVeterans: Boolean,
  prisonLeavers: Boolean,
  prisonLeaversNotSuitable: String,
  removeCSRPrinciples: Boolean,
  assignTo: Option[String] = None,
  assignTo2: Option[String] = None,
  grsVacancy: Boolean,
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

  def managementSectionId            = s"${vacancyFormId}_section_100276_col_0"
  def greatWorkForVeteransYesId      = s"${vacancyFormId}_datafield_138150_1_1_1"
  def greatWorkForVeteransNoId       = s"${vacancyFormId}_datafield_138150_1_1_2"
  def prisonLeaversYesId             = s"${vacancyFormId}_datafield_176958_1_1_1"
  def prisonLeaversNoId              = s"${vacancyFormId}_datafield_176958_1_1_2"
  def prisonLeaversLevelOfSecurityId = s"${vacancyFormId}_datafield_176961_1_1_47616"
  def prisonLeaversNatureOfRoleId    = s"${vacancyFormId}_datafield_176961_1_1_47617"
  def prisonLeaversReservedPostId    = s"${vacancyFormId}_datafield_176961_1_1_47615"
  def prisonLeaversOtherId           = s"${vacancyFormId}_datafield_176961_1_1_47618"
  def removePrinciplesYesId()        = s"${vacancyFormId}_datafield_100287_1_1_1"
  def removePrinciplesNoId()         = s"${vacancyFormId}_datafield_100287_1_1_2"
  def assignToId                     = s"select2-${vacancyFormId}_datafield_101084_1_1-container"
  def assignTo2Id                    = s"select2-${vacancyFormId}_datafield_168380_1_1-container"
  def grsJobStageTypeId              = s"select2-${vacancyFormId}_datafield_104968_1_1-container"
  def grsPecMenuId                   = s"${vacancyFormId}_datafield_118309_1_1_17450"
  def grsPecEUExitId                 = s"${vacancyFormId}_datafield_118309_1_1_17451"
  def grsPecBauId                    = s"${vacancyFormId}_datafield_118309_1_1_17449"
  def grsToSiftYesId                 = s"${vacancyFormId}_datafield_142798_1_1_1"
  def grsToSiftNoId                  = s"${vacancyFormId}_datafield_142798_1_1_2"
  def grsToAssessAndInterviewYesId   = s"${vacancyFormId}_datafield_142802_1_1_1"
  def grsToAssessAndInterviewNoId    = s"${vacancyFormId}_datafield_142802_1_1_2"
  def linkToProjectYesId             = s"${vacancyFormId}_datafield_105092_1_1_1"
  def linkToProjectNoId              = s"${vacancyFormId}_datafield_105092_1_1_2"
  def projectNameInputId             = s"${vacancyFormId}_datafield_104972_1_1"
  def complaintsProcessInputId       = s"${vacancyFormId}_datafield_179305_1_1_en-GB"
  def vacancyCommentsInputId         = s"${vacancyFormId}_datafield_100298_1_1"

  private def selectVeteransAndPrisonLeaversPosition(managementDetails: ManagementDetails): Unit = {
    scrollToElement(By.id(managementSectionId))
    vXGreatForVeterans = managementDetails.greatWorkForVeterans
    if (candidateApproach == "External") {
      if (vXGreatForVeterans) {
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
    if (managementDetails.removeCSRPrinciples) clickOnRadioButton(removePrinciplesYesId())
    else clickOnRadioButton(removePrinciplesNoId())

  private def enterAssignTo(managementDetails: ManagementDetails): Unit = {
    val username = managementDetails.assignTo.get
    selectOptionFromList(username, assignToId, s" $contactNameVxConfig - $username")
  }

  private def enterAssignTo2(managementDetails: ManagementDetails): Unit = {
    val username2 = managementDetails.assignTo2.get
    selectOptionFromList(username2, assignTo2Id, s" $contactNameVxConfig - $username2")
  }

  private def grsQuestions(managementDetails: ManagementDetails): Unit = {
    vXGrsVacancy = managementDetails.grsVacancy
    if (vXGrsVacancy) {
      grsRecruitmentStageType(managementDetails)
      selectGrsPecCheckingType(managementDetails)
      selectGrsToSift(managementDetails)
      selectGrsToAssessAndInterview(managementDetails)
    }
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
      enterValue(projectNameInputId, managementDetails.projectName.get)
    } else clickOnRadioButton(linkToProjectNoId)

  private def enterComplaintsProcess(managementDetails: ManagementDetails): Unit =
    enterValue(complaintsProcessInputId, managementDetails.deptComplaintsProcess.get)

  private def enterVacancyComments(managementDetails: ManagementDetails): Unit =
    enterValue(vacancyCommentsInputId, managementDetails.vacancyComments.get)

  private val management: Seq[ManagementDetails => Unit] = Seq(
    selectVeteransAndPrisonLeaversPosition,
    selectRemoveCSRPrinciples,
    enterAssignTo,
    enterAssignTo2,
    grsQuestions,
    selectLinkToProject,
    enterComplaintsProcess,
    enterVacancyComments
  )

  def managementSection(newVacancyDetails: NewVacancyDetails): Unit =
    management.foreach { f =>
      f(newVacancyDetails.managementDetails)
    }
}
