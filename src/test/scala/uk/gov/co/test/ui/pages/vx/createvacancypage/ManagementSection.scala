package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXGreatForVeterans, vXGrsVacancy, vXJobInfoDepartment, vXProfile, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

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
  def grsPecBauId                    = s"${vacancyFormId}_datafield_118309_1_1_17449"
  def grsPecCrAndHistoryId           = s"${vacancyFormId}_datafield_118309_1_1_53369"
  def grsPecEmploymentHistoryId      = s"${vacancyFormId}_datafield_118309_1_1_53368"
  def grsPecFullPecChecksId          = s"${vacancyFormId}_datafield_118309_1_1_53367"
  def grsPecMenuId                   = s"${vacancyFormId}_datafield_118309_1_1_17450"
  def grsPecEUExitId                 = s"${vacancyFormId}_datafield_118309_1_1_17451"
  def grsToSiftYesId                 = s"${vacancyFormId}_datafield_142798_1_1_1"
  def grsToSiftNoId                  = s"${vacancyFormId}_datafield_142798_1_1_2"
  def managedByGrsYesId              = s"${vacancyFormId}_datafield_141868_1_1_1"
  def managedByGrsNoId               = s"${vacancyFormId}_datafield_141868_1_1_2"
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
    if (vXApproach == "External") {
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

  private def selectManagedByGrs(managementDetails: ManagementDetails): Unit =
    if (managementDetails.grsVacancy) clickOnRadioButton(managedByGrsYesId)
    else clickOnRadioButton(managedByGrsNoId)

  private def grsQuestions(managementDetails: ManagementDetails): Unit = {
    grsRecruitmentStageType(managementDetails)
    selectGrsPecCheckingType(managementDetails)
    selectGrsToSift(managementDetails)
    selectGrsToAssessAndInterview(managementDetails)
  }

  private def grsVacancy(managementDetails: ManagementDetails): Unit =
    if (
      vXJobInfoDepartment == "Foreign, Commonwealth & Development Office" ||
      vXJobInfoDepartment == "Food Standards Agency" ||
      vXJobInfoDepartment == "Commission for Tertiary Education and Research" ||
      vXJobInfoDepartment == "Disclosure & Barring Service" ||
      vXJobInfoDepartment == "Government Legal Department" ||
      vXJobInfoDepartment == "HM Treasury" ||
      vXJobInfoDepartment == "HM Revenue and Customs" ||
      vXJobInfoDepartment == "Consumer Scotland" ||
      vXJobInfoDepartment == "Environmental Standards Scotland" ||
      vXJobInfoDepartment == "Government Commercial Function" ||
      vXJobInfoDepartment == "Central Digital and Data Office" ||
      vXJobInfoDepartment == "Government Digital Service" ||
      vXJobInfoDepartment == "Office for Environmental Protection"
    ) {
      selectManagedByGrs(managementDetails)
      vXGrsVacancy = managementDetails.grsVacancy
      if (vXGrsVacancy) grsQuestions(managementDetails)
    } else if (
      vXJobInfoDepartment == "Department of Health and Social Care" ||
      vXJobInfoDepartment == "Department for Business and Trade" ||
      vXJobInfoDepartment == "Department for Work and Pensions" ||
      vXJobInfoDepartment == "Forestry Commission" ||
      vXJobInfoDepartment == "Home Office" ||
      vXJobInfoDepartment == "Insolvency Service" ||
      vXJobInfoDepartment == "UK Space Agency" ||
      vXJobInfoDepartment == "Valuation Office Agency" ||
      vXJobInfoDepartment == "Animal and Plant Health Agency" ||
      vXJobInfoDepartment == "Centre for Environment, Fisheries and Aquaculture Science" ||
      vXJobInfoDepartment == "Marine Management Organisation" ||
      vXJobInfoDepartment == "Rural Payments Agency" ||
      vXJobInfoDepartment == "Veterinary Medicines Directorate" ||
      vXJobInfoDepartment == "Independent Inquiry into Child Sexual Abuse" ||
      vXJobInfoDepartment == "National Crime Agency" ||
      vXJobInfoDepartment == "His Majesty's Inspectorate of Constabulary and Fire & Rescue Services" ||
      vXJobInfoDepartment == "Government Operational Research Service" ||
      vXJobInfoDepartment == "Department for Business, Energy & Industrial Strategy" ||
      vXJobInfoDepartment == "Department for Transport" ||
      vXJobInfoDepartment == "Driver and Vehicle Licensing Agency" ||
      vXJobInfoDepartment == "Driver and Vehicle Standards Agency" ||
      vXJobInfoDepartment == "Vehicle Certification Agency" ||
      vXJobInfoDepartment == "Maritime and Coastguard Agency" ||
      vXJobInfoDepartment == "Student Loans Company" ||
      vXJobInfoDepartment == "Government Property Agency" ||
      vXJobInfoDepartment == "Institute for Apprenticeships and Technical Education" ||
      vXJobInfoDepartment == "Government Office for Science" ||
      vXJobInfoDepartment == "Charity Commission" ||
      vXJobInfoDepartment == "Cabinet Office" ||
      vXJobInfoDepartment == "Trade Remedies Authority" ||
      vXJobInfoDepartment == "Fast Stream and Emerging Talent" ||
      vXJobInfoDepartment == "Building Digital UK (BDUK)" ||
      vXJobInfoDepartment == "Active Travel England" ||
      vXJobInfoDepartment == "Department for Energy Security & Net Zero" ||
      vXJobInfoDepartment == "Department for Science, Innovation and Technology"
    ) {
      vXGrsVacancy = true
      grsQuestions(managementDetails)
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
      case "BAU"                                    => clickOnRadioButton(grsPecBauId)
      case "Criminal record and employment history" => clickOnRadioButton(grsPecCrAndHistoryId)
      case "Employment history only"                => clickOnRadioButton(grsPecEmploymentHistoryId)
      case "Full pre-employment checks"             => clickOnRadioButton(grsPecFullPecChecksId)
      case "Menu"                                   => clickOnRadioButton(grsPecMenuId)
      case _                                        => throw new IllegalStateException("GRS pecking checking type does not exist!")
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
    grsVacancy,
    selectLinkToProject,
    enterComplaintsProcess
  )

  def managementSection(newVacancyDetails: NewVacancyDetails): Unit = {
    if (vXProfile != "Vacancy Holder 1") {
      management.foreach { f =>
        f(newVacancyDetails.managementDetails)
      }
    }
    enterVacancyComments(newVacancyDetails.managementDetails)
  }
}
