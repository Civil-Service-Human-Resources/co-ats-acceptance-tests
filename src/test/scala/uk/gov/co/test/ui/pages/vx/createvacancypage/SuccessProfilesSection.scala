package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAbilitiesRequired, vXBehavioursRequired, vXExperiencesRequired, vXListOfChosenBehaviours, vXStrengthsRequired, vXTechSkillsRequired, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.AbilitiesSection.selectAbilitiesProfile
import uk.gov.co.test.ui.pages.vx.createvacancypage.BehavioursSection.selectBehavioursProfiles
import uk.gov.co.test.ui.pages.vx.createvacancypage.ExperienceSection.selectExperiencesRequired
import uk.gov.co.test.ui.pages.vx.createvacancypage.StrengthsSection.selectStrengthsAssessed
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

  private def whichSuccessProfiles(successProfilesDetails: SuccessProfilesDetails): Unit = {
    if (successProfilesDetails.abilities) {
      vXAbilitiesRequired = successProfilesDetails.abilities
      checkbox(abilitiesId).select()
      selectAbilitiesProfile(successProfilesDetails)
    } else checkboxCheck(vXAbilitiesRequired, abilitiesId)
    if (successProfilesDetails.behaviours) {
      vXBehavioursRequired = successProfilesDetails.behaviours
      checkbox(behavioursId).select()
      selectBehavioursProfiles(successProfilesDetails)
    } else checkboxCheck(vXBehavioursRequired, behavioursId)
    if (successProfilesDetails.experience) {
      vXExperiencesRequired = successProfilesDetails.experience
      checkbox(experienceId).select()
      selectExperiencesRequired(successProfilesDetails)
    } else checkboxCheck(vXExperiencesRequired, experienceId)
    if (successProfilesDetails.strengths) {
      vXStrengthsRequired = successProfilesDetails.strengths
      checkbox(strengthsId).select()
      selectStrengthsAssessed(successProfilesDetails)
    } else checkboxCheck(vXStrengthsRequired, strengthsId)
    if (successProfilesDetails.technicalSkills) {
      vXTechSkillsRequired = successProfilesDetails.technicalSkills
      checkbox(technicalSkillsId).select()
      selectTechnicalSkills(successProfilesDetails)
    } else checkboxCheck(vXTechSkillsRequired, technicalSkillsId)
  }

  private val successProfiles: Seq[SuccessProfilesDetails => Unit] = Seq(
    whichSuccessProfiles
  )

  def successProfilesSection(newVacancyDetails: NewVacancyDetails): Unit =
    successProfiles.foreach { f =>
      f(newVacancyDetails.successProfilesDetails)
    }
}
