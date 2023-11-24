package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId
import uk.gov.co.test.ui.pages.vx.createvacancypage.ExperienceSection.{languagesMandatory, licencesMandatory, membershipsMandatory, qualificationsMandatory}
import uk.gov.co.test.ui.pages.vx.createvacancypage.SuccessProfilesSection.experiences

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

  private lazy val campaignIDId                 = s"${formId}_datafield_74351_1_1"
  private lazy val probationCompleteYesId       = s"${formId}_datafield_61145_1_1_1"
  private lazy val probationCompleteNoId        = s"${formId}_datafield_61145_1_1_2"
  private lazy val promotionApplyYesId          = s"${formId}_datafield_61177_1_1_1"
  private lazy val promotionApplyNoId           = s"${formId}_datafield_61177_1_1_2"
  private lazy val misconductLiveYesId          = s"${formId}_datafield_61149_1_1_1"
  private lazy val misconductLiveNoId           = s"${formId}_datafield_61149_1_1_2"
  private lazy val performancePoorYesId         = s"${formId}_datafield_61185_1_1_1"
  private lazy val performancePoorNoId          = s"${formId}_datafield_61185_1_1_2"
  private lazy val attendancePoorYesId          = s"${formId}_datafield_61181_1_1_1"
  private lazy val attendancePoorNoId           = s"${formId}_datafield_61181_1_1_2"
  private lazy val nationalityRequirementsYesId = s"${formId}_datafield_61153_1_1_1"
  private lazy val nationalityRequirementsNoId  = s"${formId}_datafield_61153_1_1_2"
  private lazy val rightToRemainUKYesId         = s"${formId}_datafield_61193_1_1_1"
  private lazy val rightToRemainUKNoId          = s"${formId}_datafield_61193_1_1_2"
  private lazy val licencesNotHeldYesId         = s"${formId}_datafield_61161_1_1_1"
  private lazy val licencesNotHeldNoId          = s"${formId}_datafield_61161_1_1_2"
  private lazy val membershipsNotHeldYesId      = s"${formId}_datafield_61165_1_1_1"
  private lazy val membershipsNotHeldNoId       = s"${formId}_datafield_61165_1_1_2"
  private lazy val languagesSkillsYesId         = s"${formId}_datafield_61169_1_1_1"
  private lazy val languagesSkillsNoId          = s"${formId}_datafield_61169_1_1_2"
  private lazy val qualificationsHeldYesId      = s"${formId}_datafield_61157_1_1_1"
  private lazy val qualificationsHeldNoId       = s"${formId}_datafield_61157_1_1_2"
  private lazy val preSiftRequiredYesId         = s"${formId}_datafield_62541_1_1_1"
  private lazy val preSiftRequiredNoId          = s"${formId}_datafield_62541_1_1_2"
  private lazy val uploadAttachmentYesId        = s"${formId}_datafield_61333_1_1_1"
  private lazy val uploadAttachmentNoId         = s"${formId}_datafield_61333_1_1_2"
  private lazy val candidateInstructionsInputId = s"${formId}_datafield_61355_1_1_en-GB"

  private def enterCampaignID(criteriaDetails: CriteriaDetails): Unit = {
    scrollToElement(By.id(campaignIDId))
    selectOptionWithId(campaignIDId, criteriaDetails.campaignID.get)
  }

  private def selectRejectIfProbationIncomplete(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.probationIncomplete) clickOnRadioButton(probationCompleteYesId)
    else clickOnRadioButton(probationCompleteNoId)

  private def selectRejectIfApplyingOnPromotion(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.promotionApply) clickOnRadioButton(promotionApplyYesId)
    else clickOnRadioButton(promotionApplyNoId)

  private def selectRejectIfMisconductIsLive(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.misconductLive) clickOnRadioButton(misconductLiveYesId)
    else clickOnRadioButton(misconductLiveNoId)

  private def selectRejectIfPerformanceReview(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.performanceReview) clickOnRadioButton(performancePoorYesId)
    else clickOnRadioButton(performancePoorNoId)

  private def selectRejectIfAttendancePoor(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.attendancePoor) clickOnRadioButton(attendancePoorYesId)
    else clickOnRadioButton(attendancePoorNoId)

  private def selectRejectIfNoMeetNationality(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.nationalityRequirements) clickOnRadioButton(nationalityRequirementsYesId)
    else clickOnRadioButton(nationalityRequirementsNoId)

  private def selectRejectIfNoRightToRemain(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.rightToRemainUK) clickOnRadioButton(rightToRemainUKYesId)
    else clickOnRadioButton(rightToRemainUKNoId)

  private def selectRejectIfLicencesNotHeld(criteriaDetails: CriteriaDetails): Unit =
    if (licencesMandatory != "") {
      if (licencesMandatory.toBoolean && experiences.toBoolean) {
        if (criteriaDetails.licencesNotHeld) clickOnRadioButton(licencesNotHeldYesId)
        else clickOnRadioButton(licencesNotHeldNoId)
      }
    }

  private def selectRejectIfMembershipsNotHeld(criteriaDetails: CriteriaDetails): Unit =
    if (membershipsMandatory != "") {
      if (membershipsMandatory.toBoolean && experiences.toBoolean) {
        if (criteriaDetails.membershipsNotHeld) clickOnRadioButton(membershipsNotHeldYesId)
        else clickOnRadioButton(membershipsNotHeldNoId)
      }
    }

  private def selectRejectIfLanguageSkillsNotHeld(criteriaDetails: CriteriaDetails): Unit =
    if (languagesMandatory != "") {
      if (languagesMandatory.toBoolean && experiences.toBoolean) {
        if (criteriaDetails.languagesSkillsNotHeld) clickOnRadioButton(languagesSkillsYesId)
        else clickOnRadioButton(languagesSkillsNoId)
      }
    }

  private def selectRejectIfQualificationsNotHeld(criteriaDetails: CriteriaDetails): Unit =
    if (qualificationsMandatory != "") {
      if (qualificationsMandatory.toBoolean && experiences.toBoolean) {
        if (criteriaDetails.qualificationsHeld) clickOnRadioButton(qualificationsHeldYesId)
        else clickOnRadioButton(qualificationsHeldNoId)
      }
    }

  private def selectIsPreSiftRequired(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.preSiftRequired) clickOnRadioButton(preSiftRequiredYesId)
    else clickOnRadioButton(preSiftRequiredNoId)

  private def selectRequiredCandidateUploadAttachment(criteriaDetails: CriteriaDetails): Unit =
    if (criteriaDetails.uploadAttachment) {
      clickOnRadioButton(uploadAttachmentYesId)
      selectOptionWithId(candidateInstructionsInputId, criteriaDetails.candidateInstructions)
    } else clickOnRadioButton(uploadAttachmentNoId)

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
