package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXPecHealthRefCheck, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class HealthDeclarationDetails(
  needAdjustmentsForWork: Boolean,
  anyAdjustmentsDetails: String,
  healthIssuesInPast: Boolean,
  healthIssuesDetails: String,
  conditionsAffectingJobAdvert: Boolean,
  conditionsAffectingJobAdvertDetails: String,
  ongoingInvestigations: Boolean,
  ongoingInvestigationsDetails: String,
  currentHealthIssuesMayAffectNewRole: Boolean,
  currentHealthIssuesMayAffectNewRoleDetails: String,
  healthRelatedAbsence: Boolean,
  healthRelatedAbsenceDetails: String,
  discussAnyHealthIssues: Boolean,
  discussAnyHealthIssuesDetails: String
)

object HealthDeclarationPage extends CivilServiceJobsBasePage {

  private lazy val healthDeclarationPageTitle      = "Health Declaration - Civil Service Jobs - GOV.UK"
  def needAdjustmentsForWorkYesId                  = s"${pecFormId}_datafield_78770_1_1_1_label"
  def needAdjustmentsForWorkNoId                   = s"${pecFormId}_datafield_78770_1_1_2_label"
  def anyAdjustmentsDetailsId                      = s"${pecFormId}_datafield_78774_1_1"
  def healthIssuesInPastYesId                      = s"${pecFormId}_datafield_78783_1_1_1_label"
  def healthIssuesInPastNoId                       = s"${pecFormId}_datafield_78783_1_1_2_label"
  def healthIssuesDetailsId                        = s"${pecFormId}_datafield_78787_1_1"
  def conditionsAffectingJobAdvertYesId            = s"${pecFormId}_datafield_78796_1_1_1_label"
  def conditionsAffectingJobAdvertNoId             = s"${pecFormId}_datafield_78796_1_1_2_label"
  def conditionsAffectingJobAdvertDetailsId        = s"${pecFormId}_datafield_78800_1_1"
  def ongoingInvestigationsYesId                   = s"${pecFormId}_datafield_78809_1_1_1_label"
  def ongoingInvestigationsNoId                    = s"${pecFormId}_datafield_78809_1_1_2_label"
  def ongoingInvestigationsDetailsId               = s"${pecFormId}_datafield_78813_1_1"
  def currentHealthIssuesAffectNewRoleYesId        = s"${pecFormId}_datafield_78822_1_1_1_label"
  def currentHealthIssuesMayAffectNewRoleNoId      = s"${pecFormId}_datafield_78822_1_1_2_label"
  def currentHealthIssuesMayAffectNewRoleDetailsId = s"${pecFormId}_datafield_78826_1_1"
  def healthRelatedAbsenceYesId                    = s"${pecFormId}_datafield_78832_1_1_1_label"
  def healthRelatedAbsenceNoId                     = s"${pecFormId}_datafield_78832_1_1_2_label"
  def healthRelatedAbsenceDetailsId                = s"${pecFormId}_datafield_78836_1_1"
  def discussHealthIssuesYesId                     = s"${pecFormId}_datafield_78843_1_1_1_label"
  def discussHealthIssuesNoId                      = s"${pecFormId}_datafield_78843_1_1_2_label"
  def discussHealthIssuesDetailsId                 = s"${pecFormId}_datafield_78847_1_1"

  private def healthDeclarationPageCheck(): Unit =
    eventually(onPage(healthDeclarationPageTitle))

  private def selectNeedAdjustmentsForWork(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.needAdjustmentsForWork) {
      radioSelect(needAdjustmentsForWorkYesId)
      enterDetails(anyAdjustmentsDetailsId, healthDeclarationDetails.anyAdjustmentsDetails)
    } else {
      radioSelect(needAdjustmentsForWorkNoId)
    }

  private def selectHealthIssuesInPast(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.healthIssuesInPast) {
      radioSelect(healthIssuesInPastYesId)
      enterDetails(healthIssuesDetailsId, healthDeclarationDetails.healthIssuesDetails)
    } else {
      radioSelect(healthIssuesInPastNoId)
    }

  private def selectConditionsAffectingJobAdvert(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.conditionsAffectingJobAdvert) {
      radioSelect(conditionsAffectingJobAdvertYesId)
      enterDetails(conditionsAffectingJobAdvertDetailsId, healthDeclarationDetails.conditionsAffectingJobAdvertDetails)
    } else {
      radioSelect(conditionsAffectingJobAdvertNoId)
    }

  private def selectOngoingInvestigations(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.ongoingInvestigations) {
      radioSelect(ongoingInvestigationsYesId)
      enterDetails(ongoingInvestigationsDetailsId, healthDeclarationDetails.ongoingInvestigationsDetails)
    } else {
      radioSelect(ongoingInvestigationsNoId)
    }

  private def selectCurrentHealthIssuesMayAffectNewRole(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.currentHealthIssuesMayAffectNewRole) {
      radioSelect(currentHealthIssuesAffectNewRoleYesId)
      enterDetails(
        currentHealthIssuesMayAffectNewRoleDetailsId,
        healthDeclarationDetails.currentHealthIssuesMayAffectNewRoleDetails
      )
    } else {
      radioSelect(currentHealthIssuesMayAffectNewRoleNoId)
    }

  private def selectHealthRelatedAbsence(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.healthRelatedAbsence) {
      radioSelect(healthRelatedAbsenceYesId)
      enterDetails(healthRelatedAbsenceDetailsId, healthDeclarationDetails.healthRelatedAbsenceDetails)
    } else {
      radioSelect(healthRelatedAbsenceNoId)
    }

  private def selectDiscussHealthIssues(healthDeclarationDetails: HealthDeclarationDetails): Unit =
    if (healthDeclarationDetails.discussAnyHealthIssues) {
      radioSelect(discussHealthIssuesYesId)
      enterDetails(discussHealthIssuesDetailsId, healthDeclarationDetails.discussAnyHealthIssuesDetails)
    } else {
      radioSelect(discussHealthIssuesNoId)
    }

  private val health: Seq[HealthDeclarationDetails => Unit] = Seq(
    selectNeedAdjustmentsForWork,
    selectHealthIssuesInPast,
    selectConditionsAffectingJobAdvert,
    selectOngoingInvestigations,
    selectCurrentHealthIssuesMayAffectNewRole,
    selectHealthRelatedAbsence,
    selectDiscussHealthIssues
  )

  def healthDeclarationPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecHealthRefCheck.contains("Not Applicable") &&
      vXPecHealthRefCheck.contains(s"$vXTypeOfCandidate Candidates")
    ) {
      healthDeclarationPageCheck()
      health.foreach { f =>
        f(pecFormDetails.healthDeclarationDetails)
      }
      clickOn(pageContinue)
    }
}
