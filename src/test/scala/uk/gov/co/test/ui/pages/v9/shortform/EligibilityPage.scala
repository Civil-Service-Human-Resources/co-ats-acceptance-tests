package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{civilServant, vXExperiencesRequired, vXLanguagesMandatory, vXLicencesMandatory, vXMembershipsMandatory, vXQualificationsMandatory, vXNationalityRequirements, vXRightToRemainUK}

case class EligibilityDetails(
  currentCivilServant: Boolean,
  homeDepartment: String,
  nationalityReqMet: Boolean,
  rightToRemain: Boolean,
  membershipsRequirements: Boolean,
  languageRequirements: Boolean,
  qualificationsRequirements: String,
  licenceRequirements: String
)

object EligibilityPage extends CivilServiceJobsBasePage {

  private lazy val eligibilityTitle       = "Eligibility - Civil Service Jobs - GOV.UK"
  def currentCivilServantYesId            = s"${formId}_datafield_87767_1_1_1_label"
  def currentCivilServantNoId             = s"${formId}_datafield_87767_1_1_2_label"
  def homeDepartmentSelectId              = s"${formId}_datafield_177937_1_1"
  def nationalityReqMetYesId              = s"${formId}_datafield_44636_1_1_1_label"
  def nationalityReqMetNoId               = s"${formId}_datafield_44636_1_1_2_label"
  def rightToRemainYesId                  = s"${formId}_datafield_44639_1_1_1_label"
  def rightToRemainNoId                   = s"${formId}_datafield_44639_1_1_2_label"
  def membershipsRequiredYesId            = s"${formId}_datafield_97606_1_1_1_label"
  def membershipsRequiredNoId             = s"${formId}_datafield_97606_1_1_2_label"
  def languageRequirementsYesId           = s"${formId}_datafield_26892_1_1_1_label"
  def languageRequirementsNoId            = s"${formId}_datafield_26892_1_1_2_label"
  def qualificationsRequirementsYesId     = s"${formId}_datafield_22331_1_1_798_label"
  def qualificationsRequirementsNoId      = s"${formId}_datafield_22331_1_1_799_label"
  def qualificationsRequirementsSimilarId = s"${formId}_datafield_22331_1_1_800_label"
  def licenceRequirementsYesId            = s"${formId}_datafield_26731_1_1_798_label"
  def licenceRequirementsNoId             = s"${formId}_datafield_26731_1_1_799_label"
  def licenceRequirementsSimilarId        = s"${formId}_datafield_26731_1_1_800_label"

  private def eligibilityPageCheck(): Unit =
    eventually(onPage(eligibilityTitle))

  private def currentCivilServantOrCSCEmployed(eligibilityDetails: EligibilityDetails): Unit = {
    eligibilityPageCheck()
    civilServant = eligibilityDetails.currentCivilServant
    if (civilServant) {
      radioSelect(currentCivilServantYesId)
      selectDropdownOption(homeDepartmentSelectId, eligibilityDetails.homeDepartment)
    } else radioSelect(currentCivilServantNoId)
  }

  private def selectNationalityReqMet(eligibilityDetails: EligibilityDetails): Unit =
    if (vXNationalityRequirements) {
      if (eligibilityDetails.nationalityReqMet) radioSelect(nationalityReqMetYesId)
      else radioSelect(nationalityReqMetNoId)
    }

  private def selectRightToRemain(eligibilityDetails: EligibilityDetails): Unit =
    if (vXRightToRemainUK) {
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
