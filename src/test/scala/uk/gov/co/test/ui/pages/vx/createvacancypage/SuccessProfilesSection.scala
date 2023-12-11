package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.AbilitiesSection.selectAbilitiesProfile
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId
import uk.gov.co.test.ui.pages.vx.createvacancypage.BehavioursSection.selectBehavioursProfiles
import uk.gov.co.test.ui.pages.vx.createvacancypage.ExperienceSection.selectExperiencesRequired
import uk.gov.co.test.ui.pages.vx.createvacancypage.StrengthsSection.selectStrengthsAssessed
import uk.gov.co.test.ui.pages.vx.createvacancypage.TechnicalSkillsSection.selectTechnicalSkills
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXAbilitiesRequired, vXBehavioursRequired, vXExperiencesRequired, vXStrengthsRequired, vXTechSkillsRequired}

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

  def abilitiesId       = s"${vacancyFormId}_datafield_154245_1_1_12685"
  def behavioursId      = s"${vacancyFormId}_datafield_154245_1_1_12686"
  def experienceId      = s"${vacancyFormId}_datafield_154245_1_1_12687"
  def strengthsId       = s"${vacancyFormId}_datafield_154245_1_1_12689"
  def technicalSkillsId = s"${vacancyFormId}_datafield_154245_1_1_12688"

  private def whichSuccessProfiles(successProfilesDetails: SuccessProfilesDetails): Unit = {
    if (successProfilesDetails.abilities) {
      vXAbilitiesRequired = successProfilesDetails.abilities
      checkbox(abilitiesId).select()
      selectAbilitiesProfile(successProfilesDetails)
    }
    if (successProfilesDetails.behaviours) {
      vXBehavioursRequired = successProfilesDetails.behaviours
      checkbox(behavioursId).select()
      selectBehavioursProfiles(successProfilesDetails)
    }
    if (successProfilesDetails.experience) {
      vXExperiencesRequired = successProfilesDetails.experience
      checkbox(experienceId).select()
      selectExperiencesRequired(successProfilesDetails)
    }
    if (successProfilesDetails.strengths) {
      vXStrengthsRequired = successProfilesDetails.strengths
      checkbox(strengthsId).select()
      selectStrengthsAssessed(successProfilesDetails)
    }
    if (successProfilesDetails.technicalSkills) {
      vXTechSkillsRequired = successProfilesDetails.technicalSkills
      checkbox(technicalSkillsId).select()
      selectTechnicalSkills(successProfilesDetails)
    }
  }

  private val successProfiles: Seq[SuccessProfilesDetails => Unit] = Seq(
    whichSuccessProfiles
  )

  def successProfilesSection(newVacancyDetails: NewVacancyDetails): Unit =
    successProfiles.foreach { f =>
      f(newVacancyDetails.successProfilesDetails)
    }
}
