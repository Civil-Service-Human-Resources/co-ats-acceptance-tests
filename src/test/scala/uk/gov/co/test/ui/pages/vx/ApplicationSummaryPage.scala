package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{applicationId, randomFirstName, randomLastName, v9CivilServant, v9HomeDepartment, v9PecRequired, vXApproach, vXCandidateUploadIdentityDocs, vXCrcCheckProvider, vXCrcLevel, vXInterviewNumber, vXJobInfoDepartment, vXPecBankruptcyCheck, vXPecCrc, vXPecEmploymentHistoryCheck, vXPecFraudCheck, vXPecGeneralInfo, vXPecHealthRefCheck, vXPecNen, vXPecNsv, vXPecOgdSecurityCheck, vXPecOverseasCheck, vXPecPensionsCheck, vXPecPn, vXPecPreviousCivilEmploymentCheck, vXPecReferenceCheck, vXPecSelfEmploymentCheck, vXRtwChecks, vXTypeOfCandidate, vXUseOnlinePecForms, vXVettingLevel, vacancyId, vacancyName}
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{candidateAcceptsOffer, confirmApplicationUpdateNoPecNen, confirmApplicationUpdateNoPecPn, confirmApplicationUpdateState, confirmOfferAcceptedNoPecFunction, v9ConfirmOfferAcceptedState}
import uk.gov.co.test.ui.pages.v9.ProvisionalOfferPage.offerDecisionFlow
import uk.gov.co.test.ui.pages.vx.DashboardPage.matchCriteria
import uk.gov.co.test.ui.pages.vx.vacancytabs.NewEntrantNoticeTab.{correspondenceSendId, emailChecksClearPath}
import uk.gov.co.test.ui.pages.vx.vacancytabs.OgdSecurityChecksTab.ogdSecurityChecksFlow

object ApplicationSummaryPage extends VacancyBasePage {

  val dashboardPageTitle                    = "Home : Civil Service Jobs - GOV.UK"
  val applicationSummaryPageTitle           = "Application Summary : Civil Service Jobs - GOV.UK"
  val searchApplicationPath                 = ".//*[@class='textlabel' and text() = 'Search Applications']"
  val searchPath                            = "selected_option"
  val searchInput                           = "search_input"
  val matchingOption                        = "matching_options"
  val searchForId                           = "search_button"
  val appIdPath                             = ".//*[@class='app_id']"
  val preSiftEvaluationFormBarId            = "process_rule_but_468"
  val completeSiftBarId                     = "process_rule_but_18"
  val progressBarId                         = "process_rule_but_657"
  val provisionalOfferOnlineBarId           = "process_rule_but_3176"
  val provisionalOfferOnlineReserveBarId    = "process_rule_but_727"
  val provisionalOfferOfflineBarId          = "process_rule_but_725"
  val reserveExpiryListBarId                = "process_rule_but_1347"
  val employmentHistoryBarId                = "process_rule_but_744"
  val conditionalOfferBarId                 = "process_rule_but_1024"
  val updateApplicantBarId                  = "process_rule_but_2008"
  val emailVacancyHolderBarId               = "process_rule_but_2032"
  val progressBarAfterPreSiftId             = "process_rule_but_155"
  val rejectBarAfterPreSiftId               = "process_rule_but_154"
  val withdrawBarId                         = "process_rule_but_509"
  val completeNewEntrantFormBarId           = "process_rule_but_765"
  val withdrawApplicationOnOfferBarId       = "process_rule_but_570"
  val sendNenToHrBarId                      = "process_rule_but_2018"
  val sendNenToHrBarAfterNenId              = "process_rule_but_2012"
  val updateApplicantTypeBarId              = "process_rule_but_2008"
  val inviteCandidateToIdvtBarId            = "process_rule_but_3213"
  val crcBarId                              = "process_rule_but_776"
  val inviteToI1BarId                       = "process_rule_but_162"
  val inviteToI2BarId                       = "process_rule_but_164"
  val inviteToI3BarId                       = "process_rule_but_176"
  val inviteToI4BarId                       = "process_rule_but_192"
  val scheduleOfflineI1BarId                = "process_rule_but_488"
  val scheduleOfflineI2BarId                = "process_rule_but_489"
  val scheduleOfflineI3BarId                = "process_rule_but_490"
  val scheduleOfflineI4BarId                = "process_rule_but_491"
  val interviewNotBookedBarId               = "process_rule_but_484"
  val scheduleI1BarId                       = "process_rule_but_23"
  val completeI1EvaluationBarId             = "process_rule_but_579"
  val completeI2EvaluationBarId             = "process_rule_but_580"
  val completeI3EvaluationBarId             = "process_rule_but_581"
  val completeI4EvaluationBarId             = "process_rule_but_582"
  val noShowI1BarId                         = "process_rule_but_25"
  val noShowI2BarId                         = "process_rule_but_166"
  val noShowI3BarId                         = "process_rule_but_181"
  val noShowI4BarId                         = "process_rule_but_197"
  val uploadIDEditFeedbackBarId             = "process_rule_but_1462"
  val uploadIDOnOfferBarId                  = "process_rule_but_1064"
  val progressI1EvaluationBarId             = "process_rule_but_703"
  val progressI2EvaluationBarId             = "process_rule_but_704"
  val progressI3EvaluationBarId             = "process_rule_but_1085"
  val progressI4EvaluationBarId             = "process_rule_but_1086"
  val withdrawAtInterviewBarId              = "process_rule_but_511"
  val launchFullPecRecruiterFormBarId       = "process_rule_but_731"
  val launchFullPecAfterSecurityChecksBarId = "process_rule_but_1490"
  val completePostingNoticeFormBarId        = "process_rule_but_910"
  val requestUpdatedNenBarId                = "process_rule_but_1608"
  val finaliseNenBarId                      = "process_rule_but_944"
  val completeSecurityChecksFormBarId       = "process_rule_but_1482"
  val firstDayArrangementsBarId             = "process_rule_but_1200"
  val firstDayArrangementsOfflineBarId      = "process_rule_but_991"
  val formalOfferOnlineBarId                = "process_rule_but_526"
  val formalOfferOfflineBarId               = "process_rule_but_766"
  val rtwChecksFormBarId                    = "process_rule_but_733"
  val idvtNotCompletedBarId                 = "process_rule_but_3220"
  val confirmIdDocumentsBarId               = "process_rule_but_2070"
  val furtherIdRequiredBarId                = "process_rule_but_2071"
  val scheduleI2BarId                       = "process_rule_but_34"
  val offerDecisionBarId                    = "process_rule_but_564"
  val requestUpdatedPostingNoticeBarId      = "process_rule_but_1607"
  val firstDayArrangementsAfterPnBarId      = "process_rule_but_911"
  val firstDayArrangementsAfterNenBarId     = "process_rule_but_938"
  val readyToHireBarId                      = "process_rule_but_965"
  val sendPnToHrBarId                       = "process_rule_but_2014"
  val passChecksBarId                       = "process_rule_but_999"
  val failChecksBarId                       = "process_rule_but_750"
  val referToVhForRiskBarId                 = "process_rule_but_751"
  val allBarItemsId                         = "process_rules_bar"
  val preSiftActionButtonsPath              = ".//*[@aria-label='Action Buttons']"
  val siftEvaluationTabPath                 = ".//span[@class='main-label' and text() = 'Sift evaluation']"
  val commentsTabPath                       = ".//span[@class='main-label' and text() = 'Comments']"
  val summaryTabPath                        = ".//span[@class='main-label' and text() = 'Summary']"
  val vacancyAppliedDatePath                = ".//*[@id='collapse_panel']/span[2]"
  var appSummaryFormId                      = ""
  def outcomeId                             = s"select2-${appSummaryFormId}_datafield_66487_1_1-container"
  val messageIcon                           = ".//*[@class='msg_icon']"

  private def dashboardPageCheck(): Unit =
    eventually(onPage(dashboardPageTitle))

  def searchForApplication(applicationId: String): Unit = {
    dashboardPageCheck()
    searchApplicationId(applicationId)
  }

  def searchApplicationId(applicationId: String): Unit = {
    waitForVisibilityOfElementById(searchPath).click()
    waitForVisibilityOfElementByPath(searchApplicationPath).click()
    waitForVisibilityOfElementById(searchInput).sendKeys(applicationId)
    matchCriteria("Exact Match")
    clickOn(searchForId)
    onPage(applicationSummaryPageTitle)
    waitForVisibilityOfElementByPath(appIdPath).getText shouldEqual applicationId
  }

  def navigateToApplicationSummary(): Unit = {
    switchToVXConfig()
    searchForApplication(applicationId)
  }

  private def extractTabFormId(): String = {
    val formClass = driver.findElement(By.xpath(".//form[@class='form-horizontal']"))
    appSummaryFormId = formClass.getAttribute("id")
    appSummaryFormId
  }

  def selectOutcome(outcome: String): Unit = {
    waitForVisibilityOfElementById(outcomeId).click()
    action().moveToElement(waitForDropdownOption(outcome)).perform()
    waitForDropdownOption(outcome).click()
  }

  def moveAndAcceptOffer(): Unit = {
    progressApplicationToOffer()
    candidateAcceptsOffer()
    offerDecisionFlow("Accept")
    vXExtractTypeOfCandidate()

    println(s"1. vXUseOnlinePecForms: $vXUseOnlinePecForms")
    println(s"2. pecFieldsRequired: ${pecFieldsRequired()}")
    println(s"3. v9CivilServant $v9CivilServant")
    println(s"4. vXJobInfoDepartment $vXJobInfoDepartment")
    println(s"5. v9HomeDepartment $v9HomeDepartment")
    println(s"6. vXPecOgdSecurityCheck $vXPecOgdSecurityCheck")
    println(s"7. vXTypeOfCandidate => $vXTypeOfCandidate")

    if (!vXUseOnlinePecForms) {
      confirmApplicationUpdateState()
      agreeStartDate()
    } else if (
      vXUseOnlinePecForms &&
      pecFieldsRequired() &&
      (vXPecPn.contains("Internal Candidates") && (v9CivilServant && vXJobInfoDepartment == v9HomeDepartment))
    ) {
      confirmApplicationUpdateNoPecPn()
      postingNoticeRequested()
    } else if (
      vXUseOnlinePecForms &&
      pecFieldsRequired() &&
      (
        ((!vXPecNsv
          .contains("Not Applicable") && vXPecNsv.contains(s"$vXApproach Candidates")) && vXVettingLevel == "None") &&
          (vXPecNen.contains("External Candidates") || vXPecNen.contains("OGD Candidates") || vXPecNen.contains(
            "NDPB Candidates"
          ) && (vXJobInfoDepartment != v9HomeDepartment)) && !vXPecOgdSecurityCheck
      )
    ) {
      confirmApplicationUpdateNoPecNen()
      checksCompleteDecisionRequired()
      //added these
      checkVacancyStatus("Checks Complete – Decision Required")
      moveVacancyOnAndSendEmail(passChecksBarId, emailChecksClearPath, correspondenceSendId)
    } else if (
      vXUseOnlinePecForms &&
      pecFieldsRequired() &&
      (v9CivilServant && (v9HomeDepartment != vXJobInfoDepartment) && vXPecOgdSecurityCheck && (vXTypeOfCandidate == "OGD")) &&
      ((!vXPecCrc.contains("Not Applicable") && vXPecCrc.contains(s"$vXApproach Candidates") && vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) ||
          (!vXPecNsv.contains("Not Applicable") && vXPecNsv.contains(s"$vXApproach Candidates") && vXVettingLevel != "None")
      )) {
      securityChecksRequired()
      ogdSecurityChecksFlow(MASTER_APPLICATION_DATA)
      inviteCandidateToCompletePecForm()
      v9ConfirmOfferAcceptedState()
    } else {
      v9ConfirmOfferAcceptedState()
      vXProvisionalOfferAccepted()
    }
  }

  def pecFieldsRequired(): Boolean = {
    if (
      vXCandidateUploadIdentityDocs ||
      (!vXRtwChecks.contains("Not Applicable") && vXRtwChecks.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecGeneralInfo.contains("Not Applicable") && vXPecGeneralInfo.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecReferenceCheck
        .contains("Not Applicable") && vXPecReferenceCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecBankruptcyCheck
        .contains("Not Applicable") && vXPecBankruptcyCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecCrc.contains("Not Applicable") && vXPecCrc.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecNsv.contains("Not Applicable") && vXPecNsv.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecEmploymentHistoryCheck
        .contains("Not Applicable") && vXPecEmploymentHistoryCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecHealthRefCheck
        .contains("Not Applicable") && vXPecHealthRefCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecOverseasCheck
        .contains("Not Applicable") && vXPecOverseasCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecPensionsCheck
        .contains("Not Applicable") && vXPecPensionsCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecPreviousCivilEmploymentCheck
        .contains("Not Applicable") && vXPecPreviousCivilEmploymentCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecFraudCheck.contains("Not Applicable") && vXPecFraudCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecSelfEmploymentCheck
        .contains("Not Applicable") && vXPecSelfEmploymentCheck.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecNen.contains("Not Applicable") && vXPecNen.contains(s"$vXTypeOfCandidate Candidates")) ||
      (!vXPecPn.contains("Not Applicable") && vXPecPn.contains(s"$vXTypeOfCandidate Candidates"))
    ) v9PecRequired = true
    else v9PecRequired = false
    v9PecRequired
  }

  def acceptsOfferAgain(): Unit = {
    candidateAcceptsOffer()
    offerDecisionFlow("Accept")
    if (!vXUseOnlinePecForms) {
      confirmApplicationUpdateState()
      agreeStartDate()
    } else if (vXPecCrc.contains("OGD Candidates") || vXPecNsv.contains("OGD Candidates")) {
      confirmOfferAcceptedNoPecFunction()
      securityChecksRequired()
    } else {
      v9ConfirmOfferAcceptedState()
      vXProvisionalOfferAccepted()
    }
  }

  def progressApplicationToOffer(): Unit = {
    val newStatus = "Provisional Offer - Online"
    if (!driver.findElements(By.id(progressBarId)).isEmpty) {
      waitForVisibilityOfElementById(progressBarId).click()
    }
    waitForVisibilityOfElementById(provisionalOfferOnlineBarId).click()
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        offerDecisionBarId,
        uploadIDOnOfferBarId,
        withdrawApplicationOnOfferBarId,
        updateApplicantTypeBarId,
        emailVacancyHolderBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def vXProvisionalOfferAccepted(): Unit = {
    val newStatus = "Provisional Offer Accepted"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        launchFullPecRecruiterFormBarId,
        withdrawApplicationOnOfferBarId,
        uploadIDOnOfferBarId,
        updateApplicantTypeBarId,
        emailVacancyHolderBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def vXExtractTypeOfCandidate(): Unit = {
    changeSystem("recruiter")
    if (!waitForVisibilityOfElementByPath(summaryTabPath).isSelected) {
      waitForVisibilityOfElementByPath(summaryTabPath).click()
      refreshPage()
    }
    setTypeOfCandidate()
  }

  def inviteCandidateToCompletePecForm(): Unit = {
    val newStatus = "Invite candidate to complete PEC form"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        launchFullPecAfterSecurityChecksBarId,
        withdrawApplicationOnOfferBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def postingNoticeRequested(): Unit = {
    val newStatus = "Posting Notice Requested"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        completePostingNoticeFormBarId,
        updateApplicantTypeBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def onboardingFinaliseNen(): Unit = {
    val newStatus = "Onboarding - Finalise NEN"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        requestUpdatedNenBarId,
        finaliseNenBarId,
        withdrawApplicationOnOfferBarId,
        updateApplicantTypeBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def checksCompleteDecisionRequired(): Unit = {
    val newStatus = "Checks Complete – Decision Required"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        passChecksBarId,
        failChecksBarId,
        referToVhForRiskBarId,
        withdrawApplicationOnOfferBarId,
        updateApplicantTypeBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def onboardingCompleteNen(): Unit = {
    val newStatus = "Onboarding - Complete NEN"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        completeNewEntrantFormBarId,
        withdrawApplicationOnOfferBarId,
        updateApplicantTypeBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def postingNoticeCompleted(): Unit = {
    val newStatus = "Posting Notice Form Complete"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        requestUpdatedPostingNoticeBarId,
        firstDayArrangementsAfterPnBarId,
        readyToHireBarId,
        sendPnToHrBarId,
        updateApplicantTypeBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def onboardingNenComplete(): Unit = {
    val newStatus = "Onboarding - NEN Complete"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        firstDayArrangementsAfterNenBarId,
        formalOfferOnlineBarId,
        formalOfferOfflineBarId,
        withdrawApplicationOnOfferBarId,
        sendNenToHrBarAfterNenId,
        updateApplicantTypeBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def securityChecksRequired(): Unit = {
    val newStatus = "Security checks required"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        completeSecurityChecksFormBarId,
        withdrawApplicationOnOfferBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def agreeStartDate(): Unit = {
    val newStatus = "Agree Start Date"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        firstDayArrangementsBarId,
        firstDayArrangementsOfflineBarId,
        formalOfferOnlineBarId,
        withdrawApplicationOnOfferBarId,
        sendNenToHrBarId,
        updateApplicantBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def manualIdCheck(): Unit = {
    val newStatus = "ID verification required"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        confirmIdDocumentsBarId,
        furtherIdRequiredBarId,
        withdrawApplicationOnOfferBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def manualIdCheckWithIdvt(): Unit = {
    val newStatus = "ID verification required"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        confirmIdDocumentsBarId,
        furtherIdRequiredBarId,
        withdrawApplicationOnOfferBarId,
        inviteCandidateToIdvtBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def rtwCheckAvailable(): Unit = {
    val newStatus = "Right to Work Check Available"
    changeSystem("recruiter")
    if (vXCandidateUploadIdentityDocs) {
      if (!driver.findElements(By.id(confirmIdDocumentsBarId)).isEmpty) {
        waitForVisibilityOfElementById(confirmIdDocumentsBarId).click()
      }
    }
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        rtwChecksFormBarId,
        withdrawApplicationOnOfferBarId,
        updateApplicantTypeBarId,
        emailVacancyHolderBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def rtwCheckAvailableWithIdvt(): Unit = {
    val newStatus = "Right to Work Check Available"
    changeSystem("recruiter")
    if (vXCandidateUploadIdentityDocs) {
      if (!driver.findElements(By.id(confirmIdDocumentsBarId)).isEmpty) {
        waitForVisibilityOfElementById(confirmIdDocumentsBarId).click()
      }
    }
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        rtwChecksFormBarId,
        withdrawApplicationOnOfferBarId,
        inviteCandidateToIdvtBarId,
        updateApplicantTypeBarId,
        emailVacancyHolderBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def invitedToDigitalIdentityCheck(): Unit = {
    val newStatus = "Invited to digital identity check"
    changeSystem("recruiter")
    if (vXCandidateUploadIdentityDocs) {
      if (!driver.findElements(By.id(confirmIdDocumentsBarId)).isEmpty) {
        waitForVisibilityOfElementById(confirmIdDocumentsBarId).click()
      }
    }
    if (!driver.findElements(By.id(inviteCandidateToIdvtBarId)).isEmpty) {
      waitForVisibilityOfElementById(inviteCandidateToIdvtBarId).click()
    }
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        idvtNotCompletedBarId,
        withdrawApplicationOnOfferBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def digitalIdentityCheckInProgress(): Unit = {
    val newStatus = "Digital identity check in progress"
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        idvtNotCompletedBarId,
        withdrawApplicationOnOfferBarId
      )
    )
    confirmCandidateSummary(newStatus)
  }

  def siftEvaluation(): Unit = {
    val newStatus = "Sift Evaluation – Feedback Captured (Not Issued)"
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(List(progressBarId, withdrawBarId))
    confirmCandidateSummary(newStatus, Some("restricted"))
    waitForVisibilityOfElementById(progressBarId).click()
  }

  def interviewEvaluation(): Unit = {
    val newStatus = s"Interview ${vXInterviewNumber.head} - Feedback Captured (Not Issued)"
    checkForNewValuePath(vacancyStatusPath, newStatus)
    vXInterviewNumber.head match {
      case "1" =>
        availableBarItems(List(progressI1EvaluationBarId, uploadIDEditFeedbackBarId, withdrawAtInterviewBarId))
        confirmCandidateSummary(newStatus)
        waitForVisibilityOfElementById(progressI1EvaluationBarId).click()
      case "2" =>
        availableBarItems(
          List(progressI2EvaluationBarId, withdrawAtInterviewBarId)
        ) //TODO check to see why no uploadID bar
        confirmCandidateSummary(newStatus)
        waitForVisibilityOfElementById(progressI2EvaluationBarId).click()
      case "3" =>
        availableBarItems(
          List(progressI3EvaluationBarId, withdrawAtInterviewBarId)
        ) //TODO check to see why no uploadID bar
        confirmCandidateSummary(newStatus)
        waitForVisibilityOfElementById(progressI3EvaluationBarId).click()
      case "4" =>
        availableBarItems(
          List(progressI4EvaluationBarId, withdrawAtInterviewBarId)
        ) //TODO check to see why no uploadID bar
        confirmCandidateSummary(newStatus)
        waitForVisibilityOfElementById(progressI4EvaluationBarId).click()
    }
  }

  def reserveExpiryList(): Unit = {
    val newStatus = "Reserve List"
    checkForNewValuePath(vacancyStatusPath, newStatus)
    availableBarItems(
      List(
        provisionalOfferOnlineReserveBarId,
        reserveExpiryListBarId,
        uploadIDOnOfferBarId,
        withdrawApplicationOnOfferBarId
      )
    )
    confirmCandidateSummary(newStatus)
    waitForVisibilityOfElementById(reserveExpiryListBarId).click()
  }

  def availableBarItems(expectedBarItems: List[String]): Unit = {
    val actualBarItems = waitForVisibilityOfElementById(allBarItemsId).findElements(By.tagName("li"))
    if (actualBarItems.size() == expectedBarItems.size) {
      for (barItem <- expectedBarItems)
        driver.findElement(By.id(barItem)).isDisplayed
    }
  }

  def interviewScheduled(): Unit = {
    val newStatus = vXInterviewNumber.head match {
      case "1" => "Interview 1 - scheduled"
      case "2" => "Interview 2 - scheduled"
      case "3" => "Interview 3 - scheduled"
      case "4" => "Interview 4 - scheduled"
    }
    changeSystem("recruiter")
    checkForNewValuePath(vacancyStatusPath, newStatus)
    vXInterviewNumber.head match {
      case "1" => availableBarItems(List(completeI1EvaluationBarId, noShowI1BarId, withdrawAtInterviewBarId))
      case "2" => availableBarItems(List(completeI2EvaluationBarId, noShowI2BarId, withdrawAtInterviewBarId))
      case "3" => availableBarItems(List(completeI3EvaluationBarId, noShowI3BarId, withdrawAtInterviewBarId))
      case "4" => availableBarItems(List(completeI4EvaluationBarId, noShowI4BarId, withdrawAtInterviewBarId))
    }
    confirmCandidateSummary(newStatus)
  }

  private def checkCandidateSummary(eleNo: String): String = {
    val ele = s"candidate_summary_entry_cand_summary_col_$eleNo"
    waitForVisibilityOfElementById(ele).getText
  }

  def confirmCandidateSummary(newStatus: String, dataLevel: Option[String] = None): Unit = {
    if (!waitForVisibilityOfElementByPath(summaryTabPath).isSelected) {
      waitForVisibilityOfElementByPath(summaryTabPath).click()
      refreshPage()
    }
    checkCandidateSummary("1") shouldEqual applicationId
    checkCandidateSummary("2") shouldEqual (if (dataLevel.isDefined && dataLevel.get == "restricted") "Restricted Data"
                                            else randomFirstName)
    checkCandidateSummary("3") shouldEqual (if (dataLevel.isDefined && dataLevel.get == "restricted") "Restricted Data"
                                            else randomLastName)
    checkCandidateSummary("4") shouldEqual newStatus
    checkCandidateSummary("5") shouldEqual vacancyId
    checkCandidateSummary("6") shouldEqual vacancyName
    checkCandidateSummary("7") shouldEqual vXJobInfoDepartment
    checkCandidateSummary("8") shouldEqual
      (
        if (dataLevel.isDefined && dataLevel.get == "restricted") {
          "Restricted Data"
        } else if (
          v9CivilServant && (v9HomeDepartment != vXJobInfoDepartment) && (v9HomeDepartment != "Animal and Plant Health Agency")
        ) {
          "NDPB - Current employee of Accredited NDPB"
        } else if (
          v9CivilServant && (v9HomeDepartment != vXJobInfoDepartment) && (v9HomeDepartment == "Animal and Plant Health Agency")
        ) {
          "OGD - Current employee of another Civil Service Department"
        } else if (v9CivilServant && (v9HomeDepartment == vXJobInfoDepartment)) {
          "Internal - Current employee of advertising department"
        } else {
          "External - Non Civil Servant / External"
        }
      )
    setTypeOfCandidate()
  }

  def setTypeOfCandidate(): Unit = {
    val typeOfCandidate = checkCandidateSummary("8")
    if (typeOfCandidate.startsWith("External")) vXTypeOfCandidate = "External"
    else if (typeOfCandidate.startsWith("OGD")) vXTypeOfCandidate = "OGD"
    else if (typeOfCandidate.startsWith("NDPB")) vXTypeOfCandidate = "NDPB"
    else if (typeOfCandidate.startsWith("Internal")) vXTypeOfCandidate = "Internal"
    else vXTypeOfCandidate = "Restricted Data"
  }
}
