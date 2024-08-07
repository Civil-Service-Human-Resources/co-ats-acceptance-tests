package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9CivilServant, v9HomeDepartment, v9RunInWelsh, vXExperiencesRequired, vXJobInfoDepartment, vXLanguagesMandatory, vXLicencesMandatory, vXMembershipsMandatory, vXQualificationsMandatory, vXRejectNationalityReq, vXRejectNoRightToRemain, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.shortFormId

case class EligibilityDetails(
  currentCivilServant: Boolean,
  nationalityReqMet: Boolean,
  rightToRemain: Boolean,
  membershipsRequirements: Boolean,
  languageRequirements: Boolean,
  qualificationsRequirements: String,
  licenceRequirements: String
)

object EligibilityPage extends CivilServiceJobsBasePage {

  private lazy val eligibilityTitle       = "Eligibility - Civil Service Jobs - GOV.UK"
  private lazy val welshEligibilityTitle  = "Cymhwyster - Civil Service Jobs - GOV.UK"
  val eligibilityPageTracker              = ".//a[@aria-label='Section Header: Eligibility  Item completed']"
  def currentCivilServantYesId            = s"${shortFormId}_datafield_87767_1_1_1_label"
  def currentCivilServantNoId             = s"${shortFormId}_datafield_87767_1_1_2_label"
  def homeDepartmentSelectId              = s"${shortFormId}_datafield_177937_1_1"
  def nationalityReqMetYesId              = s"${shortFormId}_datafield_44636_1_1_1_label"
  def nationalityReqMetNoId               = s"${shortFormId}_datafield_44636_1_1_2_label"
  def rightToRemainYesId                  = s"${shortFormId}_datafield_44639_1_1_1_label"
  def rightToRemainNoId                   = s"${shortFormId}_datafield_44639_1_1_2_label"
  def membershipsRequiredYesId            = s"${shortFormId}_datafield_97606_1_1_1_label"
  def membershipsRequiredNoId             = s"${shortFormId}_datafield_97606_1_1_2_label"
  def languageRequirementsYesId           = s"${shortFormId}_datafield_26892_1_1_1_label"
  def languageRequirementsNoId            = s"${shortFormId}_datafield_26892_1_1_2_label"
  def qualificationsRequirementsYesId     = s"${shortFormId}_datafield_22331_1_1_798_label"
  def qualificationsRequirementsNoId      = s"${shortFormId}_datafield_22331_1_1_799_label"
  def qualificationsRequirementsSimilarId = s"${shortFormId}_datafield_22331_1_1_800_label"
  def licenceRequirementsYesId            = s"${shortFormId}_datafield_26731_1_1_798_label"
  def licenceRequirementsNoId             = s"${shortFormId}_datafield_26731_1_1_799_label"
  def licenceRequirementsSimilarId        = s"${shortFormId}_datafield_26731_1_1_800_label"

  def eligibilityPageCheck(): Unit =
    if (v9RunInWelsh) eventually(onPage(welshEligibilityTitle)) else eventually(onPage(eligibilityTitle))

  private def currentCivilServantOrCSCEmployed(eligibilityDetails: EligibilityDetails): Unit = {
    eligibilityPageCheck()
    val isCivilService = eligibilityDetails.currentCivilServant
    if (v9HomeDepartment.isEmpty) v9CivilServant = false else v9CivilServant = true
    if (isCivilService || v9CivilServant) {
      radioSelect(currentCivilServantYesId)
      if (v9HomeDepartment.isEmpty) {
        if (!v9RunInWelsh) {
          selectDropdownOption(homeDepartmentSelectId, "Animal and Plant Health Agency")
          v9HomeDepartment = "Animal and Plant Health Agency"
        } else {
          selectDropdownOption(homeDepartmentSelectId, "Asiantaeth Iechyd Anifeiliaid a Phlanhigion")
          v9HomeDepartment = "Asiantaeth Iechyd Anifeiliaid a Phlanhigion"
        }
      } else {
        selectDropdownOption(homeDepartmentSelectId, v9HomeDepartment)
        if (vXJobInfoDepartment == v9HomeDepartment) vXTypeOfCandidate = "Internal"
      }
    } else {
      radioSelect(currentCivilServantNoId)
      vXTypeOfCandidate = "External"
    }
  }

  private def selectNationalityReqMet(eligibilityDetails: EligibilityDetails): Unit =
    if (vXRejectNationalityReq) {
      if (eligibilityDetails.nationalityReqMet) radioSelect(nationalityReqMetYesId)
      else radioSelect(nationalityReqMetNoId)
    }

  private def selectRightToRemain(eligibilityDetails: EligibilityDetails): Unit =
    if (vXRejectNoRightToRemain) {
      if (eligibilityDetails.rightToRemain) radioSelect(rightToRemainYesId)
      else radioSelect(rightToRemainNoId)
    }

  private def selectMembershipsRequirements(eligibilityDetails: EligibilityDetails): Unit =
    if (vXMembershipsMandatory && vXExperiencesRequired) {
      if (eligibilityDetails.membershipsRequirements) radioSelect(membershipsRequiredYesId)
      else radioSelect(membershipsRequiredNoId)
    }

  private def selectLanguageRequirements(eligibilityDetails: EligibilityDetails): Unit =
    if (vXLanguagesMandatory && vXExperiencesRequired) {
      if (eligibilityDetails.languageRequirements) radioSelect(languageRequirementsYesId)
      else radioSelect(languageRequirementsNoId)
    }

  private def selectQualificationsRequirements(eligibilityDetails: EligibilityDetails): Unit =
    if (vXQualificationsMandatory && vXExperiencesRequired) {
      eligibilityDetails.qualificationsRequirements match {
        case "Yes"                     => radioSelect(qualificationsRequirementsYesId)
        case "No"                      => radioSelect(qualificationsRequirementsNoId)
        case "Similar equivalent held" => radioSelect(qualificationsRequirementsSimilarId)
        case _                         => throw new IllegalStateException("Valid search option needs to be set")
      }
    }

  private def selectLicenceRequirements(eligibilityDetails: EligibilityDetails): Unit =
    if (vXLicencesMandatory && vXExperiencesRequired) {
      eligibilityDetails.licenceRequirements match {
        case "Yes"                     => radioSelect(licenceRequirementsYesId)
        case "No"                      => radioSelect(licenceRequirementsNoId)
        case "Similar equivalent held" => radioSelect(licenceRequirementsSimilarId)
        case _                         => throw new IllegalStateException("Valid search option needs to be set")
      }
    }

  private val eligibility: Seq[EligibilityDetails => Unit] = Seq(
    currentCivilServantOrCSCEmployed,
    selectNationalityReqMet,
    selectRightToRemain,
    selectMembershipsRequirements,
    selectLanguageRequirements,
    selectQualificationsRequirements,
    selectLicenceRequirements
  )

  def eligibilityPage(shortFormDetails: ShortFormDetails): Unit = {
    eligibility.foreach { f =>
      f(shortFormDetails.eligibilityDetails)
    }
    clickOn(pageContinue)
  }
}
