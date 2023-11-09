package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.AbilitiesSection.selectAbilitiesProfile
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId
import uk.gov.co.test.ui.pages.vx.createvacancypage.BehavioursSection.selectBehavioursProfile
import uk.gov.co.test.ui.pages.vx.createvacancypage.ExperienceSection.{experiencesSection, provideCV}

case class SuccessProfilesDetails(
  abilities: Boolean,
  behaviours: Boolean,
  experience: Boolean,
  strengths: Boolean,
  technicalSkills: Boolean,
  abilitiesSection: Option[AbilitiesDetails] = None,
  behavioursSection: Option[BehavioursDetails] = None,
  experienceSection: Option[ExperienceDetails] = None
)

object SuccessProfilesSection extends VacancyBasePage {

  private lazy val abilitiesId       = s"${formId}_datafield_154245_1_1_12685"
  private lazy val behavioursId      = s"${formId}_datafield_154245_1_1_12686"
  private lazy val experienceId      = s"${formId}_datafield_154245_1_1_12687"
  private lazy val strengthsId       = s"${formId}_datafield_154245_1_1_12689"
  private lazy val technicalSkillsId = s"${formId}_datafield_154245_1_1_12688"

  private def whichSuccessProfiles(successProfilesDetails: SuccessProfilesDetails): Unit = {
    if (successProfilesDetails.abilities) {
      checkbox(abilitiesId).select()
      selectAbilitiesProfile(successProfilesDetails)
    }
    if (successProfilesDetails.behaviours) {
      checkbox(behavioursId).select()
      selectBehavioursProfile(successProfilesDetails)
    }
    if (successProfilesDetails.experience) {
      checkbox(experienceId).select()
      experiencesSection(successProfilesDetails)
    }
    if (successProfilesDetails.strengths) {
      checkbox(strengthsId).select()
    }
    if (successProfilesDetails.technicalSkills) {
      checkbox(technicalSkillsId).select()
    }
  }

  private val successProfiles: Seq[SuccessProfilesDetails => Unit] = Seq(
    whichSuccessProfiles
  )

  def successProfilesSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    successProfiles.foreach { f =>
      f(newVacancyDetails.successProfilesDetails)
    }
}