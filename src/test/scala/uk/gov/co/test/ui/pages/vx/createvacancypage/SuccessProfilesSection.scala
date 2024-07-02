package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAbilitiesRequired, vXBehaviourApplicationRequired, vXBehaviourInterviewRequired, vXBehavioursRequired, vXCvScoreRange, vXDesirablePastExperience, vXExperiencesRequired, vXFullQualification, vXHowManyBehaviours, vXHowManySkills, vXHowManyStrengths, vXJobHistory, vXLanguagesMandatory, vXLicencesMandatory, vXListOfChosenBehaviours, vXListOfSkillsApplicationRequired, vXListOfSkillsInterviewRequired, vXListOfStrengths, vXListOfTechSkills, vXListOfTechSkillsDescription, vXMembershipsMandatory, vXPersonalStatementNameBlind, vXPreviousExperiences, vXCvAttachment, vXProvideNameBlindCv, vXQualificationsMandatory, vXSpecificLanguages, vXSpecificLicences, vXSpecificMemberships, vXSpecificPastExperience, vXSpecificQualifications, vXStatementGuidance, vXStatementGuidanceText, vXStatementScoreRange, vXStatementWordLimit, vXStrengthsRequired, vXTechSkillsRequired, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.clearScores
import uk.gov.co.test.ui.pages.vx.createvacancypage.AbilitiesSection.selectAbilities
import uk.gov.co.test.ui.pages.vx.createvacancypage.BehavioursSection.selectBehaviours
import uk.gov.co.test.ui.pages.vx.createvacancypage.ExperienceSection.selectExperiences
import uk.gov.co.test.ui.pages.vx.createvacancypage.StrengthsSection.selectStrengths
import uk.gov.co.test.ui.pages.vx.createvacancypage.TechnicalSkillsSection.selectTechnicalSkills

case class SuccessProfilesDetails(
  abilities: Boolean,
  behaviours: Boolean,
  experience: Boolean,
  strengths: Boolean,
  technicalSkills: Boolean,
  abilitiesSection: Option[AbilitiesDetails] = None,
  behavioursSection: Option[BehavioursDetails] = None,
  experienceSection: Option[ExperienceDetails] = None,
  strengthsSection: Option[StrengthsDetails] = None,
  techSkillsSection: Option[TechSkillsDetails] = None
)

object SuccessProfilesSection extends VacancyBasePage {

  def abilitiesId                 = s"${vacancyFormId}_datafield_154245_1_1_12685"
  def behavioursId                = s"${vacancyFormId}_datafield_154245_1_1_12686"
  def experienceId                = s"${vacancyFormId}_datafield_154245_1_1_12687"
  def strengthsId                 = s"${vacancyFormId}_datafield_154245_1_1_12689"
  def technicalSkillsId           = s"${vacancyFormId}_datafield_154245_1_1_12688"
  private lazy val checkLabelPath = ".//input[@checked='checked']"

  private def checkboxCheck(successRequired: Boolean, checkId: String): Unit =
    if (!successRequired && waitForVisibilityOfElementById(checkId).isSelected) {
      waitForVisibilityOfElementById(checkId).click()
    }

  private def abilitiesRequired(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXAbilitiesRequired = successProfilesDetails.abilities
    if (vXAbilitiesRequired) {
      checkbox(abilitiesId).select()
      selectAbilities(successProfilesDetails)
    } else checkboxCheck(vXAbilitiesRequired, abilitiesId)
  }

  private def behavioursRequired(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXBehavioursRequired = successProfilesDetails.behaviours
    vXHowManyBehaviours = 0
    vXListOfChosenBehaviours.clear()
    vXBehaviourApplicationRequired.clear()
    vXBehaviourInterviewRequired.clear()
    if (vXBehavioursRequired) {
      checkbox(behavioursId).select()
      selectBehaviours(successProfilesDetails)
    } else checkboxCheck(vXBehavioursRequired, behavioursId)
  }

  private def experiencesRequired(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXExperiencesRequired = successProfilesDetails.experience
    vXProvideNameBlindCv = false
    vXCvAttachment = false
    vXCvScoreRange = ""
    vXJobHistory = false
    vXFullQualification = false
    vXPreviousExperiences = false
    vXPersonalStatementNameBlind = false
    vXStatementScoreRange = ""
    vXStatementWordLimit = 0
    vXStatementGuidance = false
    vXStatementGuidanceText = ""
    vXDesirablePastExperience = false
    vXSpecificPastExperience = ""
    vXLicencesMandatory = false
    vXSpecificLicences = ""
    vXMembershipsMandatory = false
    vXSpecificMemberships = ""
    vXLanguagesMandatory = false
    vXSpecificLanguages = ""
    vXQualificationsMandatory = false
    vXSpecificQualifications = ""
    if (vXExperiencesRequired) {
      checkbox(experienceId).select()
      selectExperiences(successProfilesDetails)
    } else checkboxCheck(vXExperiencesRequired, experienceId)
  }

  private def strengthsRequired(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXStrengthsRequired = successProfilesDetails.strengths
    vXHowManyStrengths = 0
    vXListOfStrengths.clear()
    if (vXStrengthsRequired) {
      checkbox(strengthsId).select()
      selectStrengths(successProfilesDetails)
    } else checkboxCheck(vXStrengthsRequired, strengthsId)
  }

  private def techSkillsRequired(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXTechSkillsRequired = successProfilesDetails.technicalSkills
    vXHowManySkills = 0
    vXListOfTechSkills.clear()
    vXListOfTechSkillsDescription.clear()
    vXListOfSkillsApplicationRequired.clear()
    vXListOfSkillsInterviewRequired.clear()
    if (vXTechSkillsRequired) {
      checkbox(technicalSkillsId).select()
      selectTechnicalSkills(successProfilesDetails)
    } else checkboxCheck(vXTechSkillsRequired, technicalSkillsId)
  }

  private def whichSuccessProfiles(successProfilesDetails: SuccessProfilesDetails): Unit = {
    clearScores()
    abilitiesRequired(successProfilesDetails)
    experiencesRequired(successProfilesDetails)
    behavioursRequired(successProfilesDetails)
    techSkillsRequired(successProfilesDetails)
    strengthsRequired(successProfilesDetails)
  }

  private val successProfiles: Seq[SuccessProfilesDetails => Unit] = Seq(
    whichSuccessProfiles
  )

  def successProfilesSection(newVacancyDetails: NewVacancyDetails): Unit =
    successProfiles.foreach { f =>
      f(newVacancyDetails.successProfilesDetails)
    }
}
