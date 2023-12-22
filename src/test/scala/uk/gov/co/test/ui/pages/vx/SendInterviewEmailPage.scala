package uk.gov.co.test.ui.pages.vx

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{applicationId, preferredFirstName, randomFirstName, randomLastName, vXJobInfoDepartment, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, interviewNotBookedBarId, inviteToInterviewOneBarId, scheduleInterviewBarId, scheduleOfflineInterviewBarId, withdrawApplicationAtInterviewOneBarId}
import uk.gov.co.test.ui.specs.TestData.eventually

object SendInterviewEmailPage extends VacancyBasePage {

  private lazy val sendEmailToCandidatePageTitle = s"$randomFirstName $randomLastName : Civil Service Jobs - GOV.UK"
  private lazy val sendEmailHeaderPath           = ".//*[@class='brand_main_title_left']"
  private lazy val sendEmailCheckId              = "invite_form_send_email"
  private lazy val autoSelectId                  = "invite_form_select_mode_2"
  private lazy val correspondenceId              = "select2-invite_form_correspondence-container"
  private lazy val sendInviteId                  = "invite_form_form_submit"
  private lazy val emailSubjectId                = "item_invite_form_subject"
  private lazy val emailPreviewId                = "invite_form_preview_but"
  private lazy val emailPreviewContentId         = "preview_div"
  private lazy val emailPreviewContentClosePath  = ".//button[@title='Close']"
  private lazy val addLocalFilePath              = ".//a[text()='Add Local File']"
//  private lazy val addEmailAttachmentsOneId      = "invite_form_attachments-new-file-1"
  private lazy val addEmailAttachmentsOneId      = "invite_form_attachments-new-file-0"

  private def sendEmailPageCheck(): Unit = {
    eventually(onPage(sendEmailToCandidatePageTitle))
    waitForVisibilityOfElementByPath(sendEmailHeaderPath).getText shouldEqual s"$randomFirstName $randomLastName"
  }

  private def checkAutoSelect(): Unit = {
    val autoSelect = waitForVisibilityOfElementById(autoSelectId)
    if (!autoSelect.isSelected) {
      clickOnRadioButton(autoSelectId)
    }
  }

  private def checkSendEmail(): Unit = {
    val sendEmail = waitForVisibilityOfElementById(sendEmailCheckId)
    if (sendEmail.isDisplayed && !sendEmail.isSelected) {
      sendEmail.click()
    }
  }

  private def selectCorrespondence(interviewNo: String = "Interview 1 - Invited"): Unit = {
    waitForVisibilityOfElementById(correspondenceId).click()
    selectActionLocator(interviewNo)
  }

  private def checkEmailContents(): Unit = {
    waitForVisibilityOfElementById(emailSubjectId).isDisplayed
    waitForVisibilityOfElementById(emailPreviewId).click()
    waitForVisibilityOfElementById(emailPreviewContentId).getText shouldEqual s"""Dear $preferredFirstName,
                                                                                         |$vacancyId: $vacancyName
                                                                                         |Congratulations, you've been invited to attend a telephone interview.
                                                                                         |Access your application centre to book your interview time and to review your application.
                                                                                         |To get your preferred time we recommend that you book as early as possible.
                                                                                         |**Enter department specific ID requirements here**
                                                                                         |If you're no longer interested in this position, please withdraw your application.
                                                                                         |
                                                                                         |Kind regards
                                                                                         |
                                                                                         |$vXJobInfoDepartment recruitment team""".stripMargin
    waitForVisibilityOfElementByPath(emailPreviewContentClosePath).click()
  }

  private def addEmailAttachments(): Unit = {
    waitForVisibilityOfElementByPath(addLocalFilePath).click()
    waitForVisibilityOfElementById(addEmailAttachmentsOneId).isDisplayed
    attachDocuments(addEmailAttachmentsOneId, "Test-T&Cs.pdf")
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

  private def interviewOneInvitedStatus(): Unit = {
    checkForNewStatus(vacancyStatusPath, "Interview 1 - invited")
    availableBarItems(
      List(
        scheduleInterviewBarId,
        scheduleOfflineInterviewBarId,
        interviewNotBookedBarId,
        withdrawApplicationAtInterviewOneBarId
      )
    )
  }

  def inviteToInterviewEmailPage(): Unit = {
    clickOn(inviteToInterviewOneBarId)
    sendEmailPageCheck()
    checkAutoSelect()
    checkSendEmail()
    selectCorrespondence()
    checkEmailContents()
    addEmailAttachments()
    waitForVisibilityOfElementById(sendInviteId).click()
    confirmCandidateSummaryAfterEmail()
    interviewOneInvitedStatus()
  }
}
