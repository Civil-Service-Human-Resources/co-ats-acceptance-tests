package uk.gov.co.test.ui.pages.vx

import uk.gov.co.test.ui.data.TestData.eventually
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{applicationId, preferredFirstName, randomFirstName, randomLastName, vXInterviewNumber, vXJobInfoDepartment, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.invitedForInterviewState
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{availableBarItems, confirmCandidateSummary, interviewNotBookedBarId, inviteToI1BarId, inviteToI2BarId, inviteToI3BarId, scheduleI1BarId, scheduleOfflineI1BarId, searchApplicationId, withdrawAtInterviewBarId}

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

  private def selectCorrespondence(): Unit = {
    waitForVisibilityOfElementById(correspondenceId).click()
    vXInterviewNumber.head match {
      case "1" => selectActionLocator("Interview 1 - Invited")
      case "2" => selectActionLocator("Interview 2 - Invited")
      case "3" => selectActionLocator("Interview 3 - Invited")
    }
  }

  private def checkEmailContents(): Unit = {
    val inviteState = vXInterviewNumber.head match {
      case "1" => "a telephone interview"
      case "2" => "an assessment"
      case "3" => "a video interview"
    }
    waitForVisibilityOfElementById(emailSubjectId).isDisplayed
    waitForVisibilityOfElementById(emailPreviewId).click()
    waitForVisibilityOfElementById(emailPreviewContentId).getText shouldEqual s"""Dear $preferredFirstName,
                                                                                         |$vacancyId: $vacancyName
                                                                                         |Congratulations, you've been invited to attend $inviteState.
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

  private def interviewOneVXInvitedStatus(): Unit = {
    val sendStatus = s"Interview ${vXInterviewNumber.head} - invited"
    checkForNewValuePath(vacancyStatusPath, sendStatus)
    availableBarItems(
      List(
        scheduleI1BarId,
        scheduleOfflineI1BarId,
        interviewNotBookedBarId,
        withdrawAtInterviewBarId
      )
    )
  }

  private def inviteToInterview(): Unit =
    vXInterviewNumber.head match {
      case "1" => waitForVisibilityOfElementById(inviteToI1BarId).click()
      case "2" => waitForVisibilityOfElementById(inviteToI2BarId).click()
      case "3" => waitForVisibilityOfElementById(inviteToI3BarId).click()
    }

  private def confirmVXCandidateSummary(): Unit = {
    val candidateStatus = s"Interview ${vXInterviewNumber.head} - invited"
    confirmCandidateSummary(candidateStatus)
  }

  def inviteToInterviewEmailFlow(): Unit = {
    searchApplicationId(applicationId)
    inviteToInterview()
    sendEmailPageCheck()
    checkAutoSelect()
    checkSendEmail()
    selectCorrespondence()
    checkEmailContents()
    addEmailAttachments()
    waitForVisibilityOfElementById(sendInviteId).click()
    confirmVXCandidateSummary()
    interviewOneVXInvitedStatus()
    invitedForInterviewState()
  }
}
