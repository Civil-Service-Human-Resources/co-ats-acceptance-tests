package uk.gov.co.test.ui.pages.v9.longform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.data.MasterVacancyDetails.vXExperiencesRequired
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.TechnicalSkillsPage.{checkForTotalValueId, techSkillTwoWordLimitId}
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.extractAppFormId

case class ExperienceAndSkillsDetails(
  haveRelevantSkills: Boolean,
  relevantSkillsDetails: String
)

object DiversityMonitoringPage extends CivilServiceJobsBasePage {

  def experienceAndSkillsTitle     = "Desirable experience and skills - Civil Service Jobs - GOV.UK"
  def haveRelevantSkillsYesId      = s"${longFormId}_datafield_50626_1_1_1_label"
  def haveRelevantSkillsNoId       = s"${longFormId}_datafield_50626_1_1_2_label"
  def relevantSkillsDetailsInputId = s"${longFormId}_datafield_50629_1_1"
  def relevantSkillsWordLimitId = s"${longFormId}_datafield_50629_1_1_counter_node"
  var longFormId                   = ""

  private def experienceAndSkillsPageCheck(): Unit =
    eventually(onPage(experienceAndSkillsTitle))

  private def selectHaveExperienceAndSkills(experienceAndSkillsDetails: ExperienceAndSkillsDetails): Unit =
    if (experienceAndSkillsDetails.haveRelevantSkills) {
      radioSelect(haveRelevantSkillsYesId)
      enterDetails(relevantSkillsDetailsInputId, experienceAndSkillsDetails.relevantSkillsDetails)
      checkForTotalValueId(relevantSkillsWordLimitId, "Maximum Word Count 250 of  250 words")
    } else radioSelect(haveRelevantSkillsNoId)

  private val experienceAndSkills: Seq[ExperienceAndSkillsDetails => Unit] = Seq(
    selectHaveExperienceAndSkills
  )

  def experienceAndSkillsPage(longFormDetails: LongFormDetails): Unit = {
    if (vXExperiencesRequired) {
      experienceAndSkillsPageCheck()
      longFormId = extractAppFormId()
      experienceAndSkills.foreach { f =>
        f(longFormDetails.experienceAndSkillsDetails)
      }
      clickOn(pageContinue)
    }
    longFormId = extractAppFormId()
  }
}
