package uk.gov.co.test.ui.pages.v9.shortform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{preferredFirstName, preferredTeleNumber, randomEmail, randomFirstName, randomLastName, v9AdjustmentsForTests, v9CivilServant, v9HomeDepartment, v9ReasonableAdjustments, v9RunInWelsh, vXAnyOnlineTests, vXGreatForVeterans, vXJobGrades, vXJobInfoDepartment, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.shortFormId

case class PersonalInfoDetails(
  preferredTeleNo: String,
  secondaryNo: Option[String] = None,
  applyDCS: Boolean,
  reasonableAdjustments: Boolean,
  reasonableAdjustmentsDetails: String,
  reasonableAdjustmentsForTests: Boolean,
  reasonableAdjustmentsForTestsDetails: String,
  areYouAVeteran: String,
  veteranInitiative: Boolean,
  redeploymentScheme: Option[Boolean] = None
)

object PersonalInfoPage extends CivilServiceJobsBasePage {

  def personalInfoTitle                    = "Personal information - Civil Service Jobs - GOV.UK"
  def welshPersonalInfoTitle               = "Gwybodaeth bersonol - Civil Service Jobs - GOV.UK"
  def firstNameInputId                     = s"${shortFormId}_datafield_11625_1_1"
  def lastNameInputId                      = s"${shortFormId}_datafield_11628_1_1"
  def preferredFirstNameInputId            = s"${shortFormId}_datafield_21495_1_1"
  def modSubstantiveGradeId                = s"${shortFormId}_datafield_44737_1_1"
  def modStaffNumberId                     = s"${shortFormId}_datafield_138820_1_1"
  def preferredTeleNoInputId               = s"${shortFormId}_datafield_11643_1_1"
  def secondaryNoInputId                   = s"${shortFormId}_datafield_11657_1_1"
  def emailInputId                         = s"${shortFormId}_datafield_11631_1_1"
  def applyDCSYesId                        = s"${shortFormId}_datafield_98109_1_1_1_label"
  def applyDCSNoId                         = s"${shortFormId}_datafield_98109_1_1_2_label"
  def reasonableAdjustmentYesId            = s"${shortFormId}_datafield_15904_1_1_1_label"
  def reasonableAdjustmentNoId             = s"${shortFormId}_datafield_15904_1_1_2_label"
  def reasonableAdjustmentDetailsInputId   = s"${shortFormId}_datafield_174746_1_1"
  def redeploymentSchemeId                 = s"${shortFormId}_datafield_175270_1_1_fieldset"
  def redeploymentSchemeYesId              = s"${shortFormId}_datafield_175270_1_1_1_label"
  def redeploymentSchemeNoId               = s"${shortFormId}_datafield_175270_1_1_2_label"
  def reasonableAdjustmentsForTestsYesId   = s"${shortFormId}_datafield_110850_1_1_1_label"
  def reasonableAdjustmentsForTestsNoId    = s"${shortFormId}_datafield_110850_1_1_2_label"
  def reasonableAdjustmentsForTestsInputId = s"${shortFormId}_datafield_174773_1_1"
  def areYouAVeteranYesId                  = s"${shortFormId}_datafield_138183_1_1_729_label"
  def areYouAVeteranNoId                   = s"${shortFormId}_datafield_138183_1_1_730_label"
  def areYouAVeteranNoNotSayId             = s"${shortFormId}_datafield_138183_1_1_731_label"
  def veteranInitiativeYesId               = s"${shortFormId}_datafield_138179_1_1_1_label"
  def veteranInitiativeNoId                = s"${shortFormId}_datafield_138179_1_1_2_label"

  private def personalInfoPageCheck(): Unit =
    if (v9RunInWelsh) eventually(onPage(welshPersonalInfoTitle)) else eventually(onPage(personalInfoTitle))

  private def enterFirstName(personalInfoDetails: PersonalInfoDetails): Unit = {
    personalInfoPageCheck()
    if (extractValue(firstNameInputId).isEmpty) {
      enterDetails(firstNameInputId, randomFirstName)
    } else extractValue(firstNameInputId) shouldEqual randomFirstName
  }

  private def enterLastName(personalInfoDetails: PersonalInfoDetails): Unit              =
    if (extractValue(lastNameInputId).isEmpty) {
      enterDetails(lastNameInputId, randomLastName)
    } else extractValue(lastNameInputId) shouldEqual randomLastName

  private def enterPreferredFirstName(personalInfoDetails: PersonalInfoDetails): Unit    =
    if (extractValue(preferredFirstNameInputId).isEmpty) {
      enterDetails(preferredFirstNameInputId, preferredFirstName)
    } else extractValue(preferredFirstNameInputId) shouldEqual preferredFirstName

  private def selectGradeAndNumberForMOD(personalInfoDetails: PersonalInfoDetails): Unit =
    if (
      v9HomeDepartment == "Ministry of Defence" && vXJobInfoDepartment == "Ministry of Defence" && vXTypeOfCandidate == "Internal"
    ) {
      selectDropdownOption(modSubstantiveGradeId, vXJobGrades.headOption.get)
      enterDetails(modStaffNumberId, "12345")
    }

  private def enterEmail(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(emailInputId).isEmpty) {
      enterDetails(emailInputId, randomEmail)
    } else extractValue(emailInputId) shouldEqual randomEmail

  private def enterPreferredTeleNo(personalInfoDetails: PersonalInfoDetails): Unit = {
    scrollToElement(By.id(preferredTeleNoInputId))
    if (extractValue(preferredTeleNoInputId).isEmpty) {
      preferredTeleNumber = personalInfoDetails.preferredTeleNo
      enterDetails(preferredTeleNoInputId, preferredTeleNumber)
    } else extractValue(preferredTeleNoInputId) shouldEqual preferredTeleNumber
  }

  private def enterSecondaryContactNo(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(secondaryNoInputId).isEmpty)
      enterDetails(secondaryNoInputId, personalInfoDetails.secondaryNo.get)

  private def selectApplyDCS(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.applyDCS) radioSelect(applyDCSYesId)
    else radioSelect(applyDCSNoId)

  private def selectReasonableAdjustments(personalInfoDetails: PersonalInfoDetails): Unit = {
    v9ReasonableAdjustments = personalInfoDetails.reasonableAdjustments
    if (v9ReasonableAdjustments) {
      radioSelect(reasonableAdjustmentYesId)
      enterDetails(reasonableAdjustmentDetailsInputId, personalInfoDetails.reasonableAdjustmentsDetails)
    } else radioSelect(reasonableAdjustmentNoId)
  }

  private def selectReasonableAdjustmentsForTests(personalInfoDetails: PersonalInfoDetails): Unit =
    if (vXAnyOnlineTests) {
      v9AdjustmentsForTests = personalInfoDetails.reasonableAdjustmentsForTests
      if (v9AdjustmentsForTests) {
        radioSelect(reasonableAdjustmentsForTestsYesId)
        enterDetails(
          reasonableAdjustmentsForTestsInputId,
          personalInfoDetails.reasonableAdjustmentsForTestsDetails
        )
      } else radioSelect(reasonableAdjustmentsForTestsNoId)
    }

  private def selectAreYouVeteran(personalInfoDetails: PersonalInfoDetails): Unit =
    if (vXGreatForVeterans && !v9CivilServant) {
      personalInfoDetails.areYouAVeteran match {
        case "Yes"                    =>
          radioSelect(areYouAVeteranYesId)
          if (personalInfoDetails.veteranInitiative) radioSelect(veteranInitiativeYesId)
          else radioSelect(veteranInitiativeNoId)
        case "No"                     => radioSelect(areYouAVeteranNoId)
        case "Prefer not to disclose" => radioSelect(areYouAVeteranNoNotSayId)
        case _                        => throw new IllegalStateException("Valid select option needs to be stated")
      }
    }

  private def enterRedeploymentScheme(personalInfoDetails: PersonalInfoDetails): Unit =
    if (
      v9CivilServant
      &&
//      (vXJobInfoDepartment == "Department for Energy Security & Net Zero" ||
//        vXJobInfoDepartment == "Department for Science, Innovation and Technology" ||
//        vXJobInfoDepartment == "Department for Environment, Food and Rural Affairs" ||
//        vXJobInfoDepartment == "HM Revenue and Customs" ||
//        vXJobInfoDepartment == "Government Equalities Office" ||
//        vXJobInfoDepartment == "Revenue Scotland" ||
//        vXJobInfoDepartment == "Scottish Fiscal Commission" ||
//        vXJobInfoDepartment == "Cabinet Office" ||
//        vXJobInfoDepartment == "Home Office" ||
//        vXJobInfoDepartment == "Transport Scotland")
//      &&
      (v9HomeDepartment == "Department for Energy Security & Net Zero" ||
        v9HomeDepartment == "Attorney General's Office" ||
        v9HomeDepartment == "HM Revenue and Customs" ||
        v9HomeDepartment == "Animal and Plant Health Agency" ||
        v9HomeDepartment == "Asiantaeth Iechyd Anifeiliaid a Phlanhigion" ||
        v9HomeDepartment == "Home Office" ||
        v9HomeDepartment == "Swyddfa Gartref" ||
        v9HomeDepartment == "Department for Science, Innovation and Technology" ||
//        v9HomeDepartment == "Department for Environment, Food and Rural Affairs" ||
        v9HomeDepartment == "Government Equalities Office" ||
        v9HomeDepartment == "Revenue Scotland" ||
        v9HomeDepartment == "Scottish Fiscal Commission" ||
        v9HomeDepartment == "Ministry of Defence" ||
        v9HomeDepartment == "Government Commercial Function" ||
        v9HomeDepartment == "Central Digital and Data Office" ||
        v9HomeDepartment == "Government Digital Services" ||
        v9HomeDepartment == "Government Property Agency" ||
        v9HomeDepartment == "Veterinary Medicines Directorate" ||
        v9HomeDepartment == "Rural Payments Agency" ||
        v9HomeDepartment == "Health and Safety Executive" ||
        v9HomeDepartment == "Department for Work and Pensions" ||
        v9HomeDepartment == "UK Hydrographic Office" ||
        v9HomeDepartment == "Transport Scotland")
    ) {
      scrollToElement(By.id(redeploymentSchemeId))
      if (personalInfoDetails.redeploymentScheme.get) radioSelect(redeploymentSchemeYesId)
      else radioSelect(redeploymentSchemeNoId)
    }

  val redepeploymentDepts = ("Accountant in Bankruptcy\nActive Travel England\nAdvisory, Conciliation and Arbitration Service\nAnimal and Plant Health Agency\nAttorney General's Office\nBuilding Digital UK (BDUK)\nCabinet Office\nCentral Digital and Data Office\nCentre for Environment, Fisheries and Aquaculture Science\nCharity Commission\nCompanies House\nCompetition & Markets Authority\nCriminal Injuries Compensation Authority\nCrown Commercial Service\nCrown Office and Procurator Fiscal Service\nCrown Prosecution Service\nDE&S Deca\nDefence Science and Technology Laboratory\nDepartment for Business and Trade\nDepartment for Business, Energy & Industrial Strategy\nDepartment for Culture, Media and Sport\nDepartment for Education\nDepartment for Environment, Food and Rural Affairs\nDepartment for Levelling Up, Housing and Communities\nDepartment for Transport\nDepartment for Work and Pensions\nDepartment of Health and Social Care\nDisclosure Scotland\nDriver and Vehicle Licensing Agency\nDriver and Vehicle Standards Agency\nEducation and Skills Funding Agency\nEducation Scotland\nESTYN\nFCDO Services\nFood Standards Agency\nFood Standards Scotland\nForeign, Commonwealth & Development Office\nForestry and Land Scotland\nForestry Commission\nForestry Commission - Forest Research\nGCHQ\nGovernment Actuary's Department\nGovernment Commercial Function\nGovernment Digital Service\nGovernment Internal Audit Agency\nGovernment Legal Department\nGovernment Office for Science\nGovernment Operational Research Service\nGovernment Property Agency\nGovernment Statistical Service\nHealth and Safety Executive\nHM Courts and Tribunals Service\nHM Crown Prosecution Service Inspectorate\nHM Government Communications Centre\nHM Land Registry\nHM Prison & Probation Service\nHM Revenue and Customs\nHM Treasury\nHome Office\nInsolvency Service\nInstitute for Apprenticeships and Technical Education\nIntellectual Property Office\nLegal Aid Agency\nMaritime and Coastguard Agency\nMedicines and Healthcare Products Regulatory Agency\nMet Office\nMinistry of Defence\nMinistry of Justice\nNational Crime Agency\nNational Infrastructure Commission\nNational Records of Scotland\nNational Records of Scotland\nNational Savings and Investments\nNorthern Ireland Office\nOffice for Budget Responsibility\nOffice for National Statistics\nOffice for Standards in Education, Children's Services and Skills\nOffice for the Scottish Charity Regulator\nOffice of Qualifications and Examinations Regulation\nOffice of Rail and Road\nOffice of Tax Simplification\nOffice of the Advocate General for Scotland\nOffice of the Public Guardian\nOffice of the Secretary of State for Scotland\nOffice of the Secretary of State for Wales\nOFGEM\nOfwat (Water Services Regulation Authority)\nPlanning Inspectorate\nPublic Health England\nQueen Elizabeth II Conference Centre\nRegisters of Scotland\nRural Payments Agency\nScience and Advice for Scottish Agriculture\nScottish Courts and Tribunals Service\nScottish Forestry\nScottish Government\nScottish Prison Service\nScottish Public Pensions Agency\nSerious Fraud Office\nSocial Security Scotland\nStudent Awards Agency\nThe National Archives\nThe Supreme Court of the United Kingdom\nUK Debt Management Office\nUK Export Finance\nUK Hydrographic Office\nUK Space Agency\nUK Statistics Authority\nValuation Office Agency\nVehicle Certification Agency\nVeterinary Medicines Directorate\nWelsh Government\nWelsh Revenue Authority\nWilton Park")

  private val personalInfo: Seq[PersonalInfoDetails => Unit] = Seq(
    enterFirstName,
    enterLastName,
    enterPreferredFirstName,
    selectGradeAndNumberForMOD,
    enterPreferredTeleNo,
    enterSecondaryContactNo,
    enterEmail,
    selectApplyDCS,
    selectReasonableAdjustments,
    selectReasonableAdjustmentsForTests,
    enterRedeploymentScheme,
    selectAreYouVeteran
  )

  def personalInfoPage(shortFormDetails: ShortFormDetails): Unit = {
    personalInfo.foreach { f =>
      f(shortFormDetails.personalInfoDetails)
    }
    clickOn(pageContinue)
  }
}
