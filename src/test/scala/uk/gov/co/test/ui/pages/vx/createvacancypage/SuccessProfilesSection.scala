package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.AbilitiesSection.selectAbilitiesProfile
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId
import uk.gov.co.test.ui.pages.vx.createvacancypage.BehavioursSection.selectBehavioursProfiles
import uk.gov.co.test.ui.pages.vx.createvacancypage.ExperienceSection.experiencesRequired
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

  private lazy val abilitiesId       = s"${formId}_datafield_154245_1_1_12685"
  private lazy val behavioursId      = s"${formId}_datafield_154245_1_1_12686"
  private lazy val experienceId      = s"${formId}_datafield_154245_1_1_12687"
  private lazy val strengthsId       = s"${formId}_datafield_154245_1_1_12689"
  private lazy val technicalSkillsId = s"${formId}_datafield_154245_1_1_12688"
  var experiences = ""

  private def whichSuccessProfiles(successProfilesDetails: SuccessProfilesDetails): Unit = {
    if (successProfilesDetails.abilities) {
      checkbox(abilitiesId).select()
      selectAbilitiesProfile(successProfilesDetails)
    }
    if (successProfilesDetails.behaviours) {
      checkbox(behavioursId).select()
      selectBehavioursProfiles(successProfilesDetails)
    }
    if (successProfilesDetails.experience) {
      experiences = successProfilesDetails.experience.toString
      checkbox(experienceId).select()
      experiencesRequired(successProfilesDetails)
    }
    if (successProfilesDetails.strengths) {
      checkbox(strengthsId).select()
      selectStrengthsAssessed(successProfilesDetails)
    }
    if (successProfilesDetails.technicalSkills) {
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
