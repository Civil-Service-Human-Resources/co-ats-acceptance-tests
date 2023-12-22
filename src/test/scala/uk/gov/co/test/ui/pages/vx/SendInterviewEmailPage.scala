package uk.gov.co.test.ui.pages.vx

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{applicationId, randomFirstName, randomLastName, vXJobInfoDepartment, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, interviewNotBookedBarId, inviteToInterviewOneBarId, scheduleInterviewBarId, scheduleOfflineInterviewBarId, withdrawBarId}
import uk.gov.co.test.ui.specs.TestData.eventually

object SendInterviewEmailPage extends VacancyBasePage {

  private lazy val sendEmailToCandidatePageTitle = s"$randomFirstName $randomLastName : Civil Service Jobs - GOV.UK"
  private lazy val sendEmailHeaderPath           = ".//*[@class='brand_main_title_left']"
  private lazy val correspondenceId              = "select2-invite_form_correspondence-container"
  private lazy val sendInviteId                  = "invite_form_form_submit"
  private lazy val interviewOneInvitedOptionId   = "select2-invite_form_correspondence-results"

  private def sendEmailPageCheck(): Unit =
    eventually(onPage(sendEmailToCandidatePageTitle))

  private def selectCorrespondence(interviewNo: String = "Interview 1 - Invited"): Unit = {
    waitForVisibilityOfElementById(correspondenceId).click()
    waitForVisibilityOfElementById(interviewOneInvitedOptionId).click()
  }

  private def confirmCandidateSummaryAfterEmail(): Unit = {
    checkCandidateSummary("1") shouldEqual applicationId
    checkCandidateSummary("2") shouldEqual randomFirstName
    checkCandidateSummary("3") shouldEqual randomLastName
    checkCandidateSummary("4") shouldEqual "Interview 1 - invited"
    checkCandidateSummary("5") shouldEqual vacancyId
    checkCandidateSummary("6") shouldEqual vacancyName
    checkCandidateSummary("7") shouldEqual vXJobInfoDepartment
    checkCandidateSummary("8") shouldEqual "External - Non Civil Servant / External"
  }

  def interviewOneInvitedStatus(): Unit = {
    checkForNewStatus(vacancyStatusPath, "Interview 1 - invited")
    availableBarItems(
      List(scheduleInterviewBarId, scheduleOfflineInterviewBarId, interviewNotBookedBarId, withdrawBarId)
    )
  }

  def inviteToInterviewEmailPage(): Unit = {
    clickOn(inviteToInterviewOneBarId)
    sendEmailPageCheck()
    waitForVisibilityOfElementByPath(sendEmailHeaderPath).getText shouldEqual s"$randomFirstName $randomLastName"
    selectCorrespondence()
    clickOn(sendInviteId)
    confirmCandidateSummaryAfterEmail()
    interviewOneInvitedStatus()
  }
}
