package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecHealthRefCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class HealthDeclarationDetails(
  needAdjustmentsForWork: Boolean,
  healthIssuesInPast: Boolean,
  healthIssuesAffectingJobAdvert: Boolean,
  ongoingTreatmentsOrInvestigations: Boolean,
  healthIssuesCausedByWorkMayAffectNow: Boolean,
  healthRelatedAbsence: Boolean,
  discussAnyHealthIssues: Boolean
)

object HealthDeclarationPage extends CivilServiceJobsBasePage {

  private lazy val healthDeclarationPageTitle   = "Health Declaration - Civil Service Jobs - GOV.UK"
  def needAdjustmentsForWorkYesId               = s"${pecFormId}_datafield_78770_1_1_1_label"
  def needAdjustmentsForWorkNoId                = s"${pecFormId}_datafield_78770_1_1_2_label"
  def healthIssuesInPastYesId                   = s"${pecFormId}_datafield_78783_1_1_1_label"
  def healthIssuesInPastNoId                    = s"${pecFormId}_datafield_78783_1_1_2_label"
  def healthIssuesAffectingJobAdvertYesId       = s"${pecFormId}_datafield_78796_1_1_1_label"
  def healthIssuesAffectingJobAdvertNoId        = s"${pecFormId}_datafield_78796_1_1_2_label"
  def ongoingTreatmentsOrInvestigationsYesId    = s"${pecFormId}_datafield_78809_1_1_1_label"
  def ongoingTreatmentsOrInvestigationsNoId     = s"${pecFormId}_datafield_78809_1_1_2_label"
  def healthIssuesCausedByWorkMayAffectNowYesId = s"${pecFormId}_datafield_78822_1_1_1_label"
  def healthIssuesCausedByWorkMayAffectNowNoId  = s"${pecFormId}_datafield_78822_1_1_2_label"
  def healthRelatedAbsenceYesId                 = s"${pecFormId}_datafield_78832_1_1_1_label"
  def healthRelatedAbsenceNoId                  = s"${pecFormId}_datafield_78832_1_1_2_label"
  def discussHealthIssuesYesId                  = s"${pecFormId}_datafield_78843_1_1_1_label"
  def discussHealthIssuesNoId                   = s"${pecFormId}_datafield_78843_1_1_2_label"

  private def healthDeclarationPageCheck(): Unit =
    eventually(onPage(healthDeclarationPageTitle))

  private def selectNeedAdjustmentsForWork(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.needAdjustmentsForWork) {
      radioSelect(needAdjustmentsForWorkYesId)
    } else {
      radioSelect(needAdjustmentsForWorkNoId)
    }

  private def selectHealthIssuesInPast(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.healthIssuesInPast) {
      radioSelect(healthIssuesInPastYesId)
    } else {
      radioSelect(healthIssuesInPastNoId)
    }

  private def selectHealthIssuesAffectingJobAdvert(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.healthIssuesAffectingJobAdvert) {
      radioSelect(healthIssuesAffectingJobAdvertYesId)
    } else {
      radioSelect(healthIssuesAffectingJobAdvertNoId)
    }

  private def selectOngoingTreatmentsOrInvestigations(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.ongoingTreatmentsOrInvestigations) {
      radioSelect(ongoingTreatmentsOrInvestigationsYesId)
    } else {
      radioSelect(ongoingTreatmentsOrInvestigationsNoId)
    }

  private def selectHealthIssuesCausedByWorkMayAffectNow(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.healthIssuesCausedByWorkMayAffectNow) {
      radioSelect(healthIssuesCausedByWorkMayAffectNowYesId)
    } else {
      radioSelect(healthIssuesCausedByWorkMayAffectNowNoId)
    }

  private def selectHealthRelatedAbsence(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.healthRelatedAbsence) {
      radioSelect(healthRelatedAbsenceYesId)
    } else {
      radioSelect(healthRelatedAbsenceNoId)
    }

  private def selectDiscussHealthIssues(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.discussAnyHealthIssues) {
      radioSelect(discussHealthIssuesYesId)
    } else {
      radioSelect(discussHealthIssuesNoId)
    }

  private val health: Seq[HealthDeclarationDetails => Unit] = Seq(
    selectNeedAdjustmentsForWork,
    selectHealthIssuesInPast,
    selectHealthIssuesAffectingJobAdvert,
    selectOngoingTreatmentsOrInvestigations,
    selectHealthIssuesCausedByWorkMayAffectNow,
    selectHealthRelatedAbsence,
    selectDiscussHealthIssues
  )

  def healthDeclarationPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecHealthRefCheck.contains("Not Applicable") &&
      vXPecHealthRefCheck.contains(s"$vXApproach Candidates")
    ) {
      healthDeclarationPageCheck()
      health.foreach { f =>
        f(pecFormDetails.healthDeclarationDetails)
      }
      clickOn(pageContinue)
    }
}
