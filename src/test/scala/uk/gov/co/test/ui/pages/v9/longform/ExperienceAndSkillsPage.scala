package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.{extractAppFormId, formId}

case class ExperienceAndSkillsDetails(
  haveRelevantSkills: Boolean,
  relevantSkillsDetails: String
)

object DiversityMonitoringPage extends CivilServiceJobsBasePage {

  def experienceAndSkillsTitle     = "Desirable experience and skills - Civil Service Jobs - GOV.UK"
  def haveRelevantSkillsYesId      = s"${formId}_datafield_50626_1_1_1_label"
  def haveRelevantSkillsNoId       = s"${formId}_datafield_50626_1_1_2_label"
  def relevantSkillsDetailsInputId = s"${formId}_datafield_50629_1_1"

  private def experienceAndSkillsPageCheck(): Unit =
    eventually(onPage(experienceAndSkillsTitle))

  private def selectHaveExperienceAndSkills(experienceAndSkillsDetails: ExperienceAndSkillsDetails): Unit =
    if (experienceAndSkillsDetails.haveRelevantSkills) {
      radioSelect(haveRelevantSkillsYesId)
      enterDetails(relevantSkillsDetailsInputId, experienceAndSkillsDetails.relevantSkillsDetails)
    } else radioSelect(haveRelevantSkillsNoId)

  private val experienceAndSkills: Seq[ExperienceAndSkillsDetails => Unit] = Seq(
    selectHaveExperienceAndSkills
  )

  def experienceAndSkillsPage(longFormDetails: LongFormDetails): Unit = {
    experienceAndSkillsPageCheck()
    formId = extractAppFormId()
    println(s"LONG FORM FORM ID: $formId")
    experienceAndSkills.foreach { f =>
      f(longFormDetails.experienceAndSkillsDetails)
    }
    clickOn(pageContinue)
  }
}
