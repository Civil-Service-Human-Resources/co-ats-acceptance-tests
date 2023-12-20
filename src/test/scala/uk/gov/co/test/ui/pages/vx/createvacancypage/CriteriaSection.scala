package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXAttendancePoor, vXCandidateInstructions, vXExperiencesRequired, vXLanguagesMandatory, vXLicencesMandatory, vXMembershipsMandatory, vXMisconductLive, vXNationalityRequirements, vXPerformanceReview, vXProbationIncomplete, vXPromotionApply, vXQualificationsMandatory, vXRightToRemainUK, vXUploadAttachmentRequired}
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

case class CriteriaDetails(
  campaignID: Option[String] = None,
  probationIncomplete: Boolean,
  promotionApply: Boolean,
  misconductLive: Boolean,
  performanceReview: Boolean,
  attendancePoor: Boolean,
  nationalityRequirements: Boolean,
  rightToRemainUK: Boolean,
  licencesNotHeld: Boolean,
  membershipsNotHeld: Boolean,
  languagesSkillsNotHeld: Boolean,
  qualificationsHeld: Boolean,
  preSiftRequired: Boolean,
  uploadAttachment: Boolean,
  candidateInstructions: String
)

object CriteriaSection extends VacancyBasePage {

  def campaignIDId                 = s"${vacancyFormId}_datafield_74351_1_1"
  def probationCompleteYesId       = s"${vacancyFormId}_datafield_61145_1_1_1"
  def probationCompleteNoId        = s"${vacancyFormId}_datafield_61145_1_1_2"
  def promotionApplyYesId          = s"${vacancyFormId}_datafield_61177_1_1_1"
  def promotionApplyNoId           = s"${vacancyFormId}_datafield_61177_1_1_2"
  def misconductLiveYesId          = s"${vacancyFormId}_datafield_61149_1_1_1"
  def misconductLiveNoId           = s"${vacancyFormId}_datafield_61149_1_1_2"
  def performancePoorYesId         = s"${vacancyFormId}_datafield_61185_1_1_1"
  def performancePoorNoId          = s"${vacancyFormId}_datafield_61185_1_1_2"
  def attendancePoorYesId          = s"${vacancyFormId}_datafield_61181_1_1_1"
  def attendancePoorNoId           = s"${vacancyFormId}_datafield_61181_1_1_2"
  def nationalityRequirementsYesId = s"${vacancyFormId}_datafield_61153_1_1_1"
  def nationalityRequirementsNoId  = s"${vacancyFormId}_datafield_61153_1_1_2"
  def rightToRemainUKYesId         = s"${vacancyFormId}_datafield_61193_1_1_1"
  def rightToRemainUKNoId          = s"${vacancyFormId}_datafield_61193_1_1_2"
  def licencesNotHeldYesId         = s"${vacancyFormId}_datafield_61161_1_1_1"
  def licencesNotHeldNoId          = s"${vacancyFormId}_datafield_61161_1_1_2"
  def membershipsNotHeldYesId      = s"${vacancyFormId}_datafield_61165_1_1_1"
  def membershipsNotHeldNoId       = s"${vacancyFormId}_datafield_61165_1_1_2"
  def languagesSkillsYesId         = s"${vacancyFormId}_datafield_61169_1_1_1"
  def languagesSkillsNoId          = s"${vacancyFormId}_datafield_61169_1_1_2"
  def qualificationsHeldYesId      = s"${vacancyFormId}_datafield_61157_1_1_1"
  def qualificationsHeldNoId       = s"${vacancyFormId}_datafield_61157_1_1_2"
  def preSiftRequiredYesId         = s"${vacancyFormId}_datafield_62541_1_1_1"
  def preSiftRequiredNoId          = s"${vacancyFormId}_datafield_62541_1_1_2"
  def uploadAttachmentYesId        = s"${vacancyFormId}_datafield_61333_1_1_1"
  def uploadAttachmentNoId         = s"${vacancyFormId}_datafield_61333_1_1_2"
  def candidateInstructionsInputId = s"${vacancyFormId}_datafield_61355_1_1_en-GB"

  private def enterCampaignID(criteriaDetails: CriteriaDetails): Unit = {
    scrollToElement(By.id(campaignIDId))
    selectOptionWithId(campaignIDId, criteriaDetails.campaignID.get)
  }

  private def selectRejectIfProbationIncomplete(criteriaDetails: CriteriaDetails): Unit = {
    vXProbationIncomplete = criteriaDetails.probationIncomplete
    if (vXProbationIncomplete) clickOnRadioButton(probationCompleteYesId)
    else clickOnRadioButton(probationCompleteNoId)
  }

  private def selectRejectIfApplyingOnPromotion(criteriaDetails: CriteriaDetails): Unit = {
    vXPromotionApply = criteriaDetails.promotionApply
    if (vXPromotionApply) clickOnRadioButton(promotionApplyYesId)
    else clickOnRadioButton(promotionApplyNoId)
  }

  private def selectRejectIfMisconductIsLive(criteriaDetails: CriteriaDetails): Unit = {
    vXMisconductLive = criteriaDetails.misconductLive
    if (vXMisconductLive) clickOnRadioButton(misconductLiveYesId)
    else clickOnRadioButton(misconductLiveNoId)
  }

  private def selectRejectIfPerformanceReview(criteriaDetails: CriteriaDetails): Unit = {
    vXPerformanceReview = criteriaDetails.performanceReview
    if (vXPerformanceReview) clickOnRadioButton(performancePoorYesId)
    else clickOnRadioButton(performancePoorNoId)
  }

  private def selectRejectIfAttendancePoor(criteriaDetails: CriteriaDetails): Unit = {
    vXAttendancePoor = criteriaDetails.attendancePoor
    if (vXAttendancePoor) clickOnRadioButton(attendancePoorYesId)
    else clickOnRadioButton(attendancePoorNoId)
  }

  private def selectRejectIfNoMeetNationality(criteriaDetails: CriteriaDetails): Unit = {
    vXNationalityRequirements = criteriaDetails.nationalityRequirements
    if (vXNationalityRequirements) clickOnRadioButton(nationalityRequirementsYesId)
    else clickOnRadioButton(nationalityRequirementsNoId)
  }

  private def selectRejectIfNoRightToRemain(criteriaDetails: CriteriaDetails): Unit = {
    vXRightToRemainUK = criteriaDetails.rightToRemainUK
    if (vXRightToRemainUK) clickOnRadioButton(rightToRemainUKYesId)
    else clickOnRadioButton(rightToRemainUKNoId)
  }

  private def selectRejectIfLicencesNotHeld(criteriaDetails: CriteriaDetails): Unit = {
    vXLicencesMandatory = criteriaDetails.licencesNotHeld
    if (vXLicencesMandatory && vXExperiencesRequired) {
      if (vXLicencesMandatory) clickOnRadioButton(licencesNotHeldYesId)
      else clickOnRadioButton(licencesNotHeldNoId)
    }
  }

  private def selectRejectIfMembershipsNotHeld(criteriaDetails: CriteriaDetails): Unit = {
    vXMembershipsMandatory = criteriaDetails.membershipsNotHeld
    if (vXMembershipsMandatory && vXExperiencesRequired) {
      if (vXMembershipsMandatory) clickOnRadioButton(membershipsNotHeldYesId)
      else clickOnRadioButton(membershipsNotHeldNoId)
    }
  }

  private def selectRejectIfLanguageSkillsNotHeld(criteriaDetails: CriteriaDetails): Unit = {
    vXLanguagesMandatory = criteriaDetails.languagesSkillsNotHeld
    if (vXLanguagesMandatory && vXExperiencesRequired) {
      if (vXLanguagesMandatory) clickOnRadioButton(languagesSkillsYesId)
      else clickOnRadioButton(languagesSkillsNoId)
    }
  }

  private def selectRejectIfQualificationsNotHeld(criteriaDetails: CriteriaDetails): Unit = {
    vXQualificationsMandatory = criteriaDetails.qualificationsHeld
    if (vXQualificationsMandatory && vXExperiencesRequired) {
      if (vXQualificationsMandatory) clickOnRadioButton(qualificationsHeldYesId)
      else clickOnRadioButton(qualificationsHeldNoId)
    }
  }

  private def selectIsPreSiftRequired(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.preSiftRequired) clickOnRadioButton(preSiftRequiredYesId)
    else clickOnRadioButton(preSiftRequiredNoId)

  private def selectRequiredCandidateUploadAttachment(criteriaDetails: CriteriaDetails): Unit = {
    vXUploadAttachmentRequired = criteriaDetails.uploadAttachment
    vXCandidateInstructions = criteriaDetails.candidateInstructions
    if (vXUploadAttachmentRequired) {
      clickOnRadioButton(uploadAttachmentYesId)
      selectOptionWithId(candidateInstructionsInputId, vXCandidateInstructions)
    } else clickOnRadioButton(uploadAttachmentNoId)
  }

  private val criteria: Seq[CriteriaDetails => Unit] = Seq(
    enterCampaignID,
    selectRejectIfProbationIncomplete,
    selectRejectIfApplyingOnPromotion,
    selectRejectIfMisconductIsLive,
    selectRejectIfPerformanceReview,
    selectRejectIfAttendancePoor,
    selectRejectIfNoMeetNationality,
    selectRejectIfNoRightToRemain,
    selectRejectIfLicencesNotHeld,
    selectRejectIfMembershipsNotHeld,
    selectRejectIfLanguageSkillsNotHeld,
    selectRejectIfQualificationsNotHeld,
    selectIsPreSiftRequired,
    selectRequiredCandidateUploadAttachment
  )

  def criteriaSection(newVacancyDetails: NewVacancyDetails): Unit =
    criteria.foreach { f =>
      f(newVacancyDetails.criteriaDetails)
    }

}
