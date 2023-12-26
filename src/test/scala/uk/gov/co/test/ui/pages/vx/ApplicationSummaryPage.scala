package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.TestData.eventually
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{applicationId, randomFirstName, randomLastName, vXJobInfoDepartment, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.vx.DashboardPage.matchCriteria

object ApplicationSummaryPage extends VacancyBasePage {

  val dashboardPageTitle                     = "Home : Civil Service Jobs - GOV.UK"
  val applicationSummaryPageTitle            = "Application Summary : Civil Service Jobs - GOV.UK"
  val searchApplicationPath                  = ".//*[@class='textlabel' and text() = 'Search Applications']"
  val searchPath                             = "selected_option"
  val searchInput                            = "search_input"
  val matchingOption                         = "matching_options"
  val searchForId                            = "search_button"
  val appIdPath                              = ".//*[@class='app_id']"
  val preSiftEvaluationFormBarId             = "process_rule_but_468"
  val completeSiftBarId                      = "process_rule_but_18"
  val progressBarId                          = "process_rule_but_657"
  val provisionalOfferOnlineBarId            = "process_rule_but_3176"
  val employmentHistoryBarId                 = "process_rule_but_744"
  val conditionalOfferBarId                  = "process_rule_but_1024"
  val withdrawApplicationBarId               = "process_rule_but_570"
  val updateApplicantBarId                   = "process_rule_but_2008"
  val emailVacancyHolderBarId                = "process_rule_but_2032"
  val progressBarAfterPreSiftId              = "process_rule_but_155"
  val rejectBarAfterPreSiftId                = "process_rule_but_154"
  val withdrawBarId                          = "process_rule_but_509"
  val crcBarId                               = "process_rule_but_776"
  val inviteToInterviewOneBarId              = "process_rule_but_162"
  val scheduleOfflineInterviewBarId          = "process_rule_but_488"
  val interviewNotBookedBarId                = "process_rule_but_484"
  val scheduleInterviewBarId                 = "process_rule_but_23"
  val completeInterviewEvaluationBarId       = "process_rule_but_579"
  val noShowBarId                            = "process_rule_but_25"
  val uploadIDEditFeedbackBarId              = "process_rule_but_1462"
  val progressAfterEvaluationBarId           = "process_rule_but_703"
  val withdrawApplicationAtInterviewOneBarId = "process_rule_but_511"
  val allBarItemsId                          = "process_rules_bar"
  val preSiftActionButtonsPath               = ".//*[@aria-label='Action Buttons']"
  val siftEvaluationTabPath                  = ".//span[@class='main-label' and text() = 'Sift evaluation']"
  val commentsTabPath                        = ".//span[@class='main-label' and text() = 'Comments']"
  val summaryTabPath                        = ".//span[@class='main-label' and text() = 'Summary']"
  val vacancyAppliedDatePath                 = ".//*[@id='collapse_panel']/span[2]"
  var appSummaryFormId                       = ""
  def outcomeId                              = s"select2-${appSummaryFormId}_datafield_66487_1_1-container"
  val messageIcon                            = ".//*[@class='msg_icon']"

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

  def progressApplicationToOffer(): Unit = {
    waitForVisibilityOfElementById(progressBarId).click()
    waitForVisibilityOfElementById(provisionalOfferOnlineBarId).click()
  }

  def siftCompletion(): Unit = {
    val completeSift = waitForVisibilityOfElementById(completeSiftBarId)
    availableBarItems(List(progressBarAfterPreSiftId, withdrawBarId))
    checkVacancyStatus("Sift application")
    completeSift.click()
    waitForVisibilityOfElementByPath(siftEvaluationTabPath).isEnabled
    extractTabFormId()
//    selectOutcome("Progress")
//    clickOn("submit_button")
  }

  def preSiftCompletion(): Unit = {
    checkForNewStatus(vacancyStatusPath, "Pre-sift complete")
    availableBarItems(List(progressBarAfterPreSiftId, rejectBarAfterPreSiftId, withdrawBarId))
    waitForVisibilityOfElementById(progressBarAfterPreSiftId).click()
  }

  def siftEvaluation(): Unit = {
    checkForNewStatus(vacancyStatusPath, "Sift Evaluation – Feedback Captured (Not Issued)")
    availableBarItems(List(progressBarId, withdrawBarId))
    waitForVisibilityOfElementById(progressBarId).click()
  }

  def interviewOneEvaluation(): Unit = {
    val newStatus = "Interview 1 - Feedback Captured (Not Issued)"
    checkForNewStatus(vacancyStatusPath, newStatus)
    availableBarItems(List(progressAfterEvaluationBarId, uploadIDEditFeedbackBarId, withdrawApplicationAtInterviewOneBarId))
    confirmCandidateSummary(newStatus)
    waitForVisibilityOfElementById(progressAfterEvaluationBarId).click()
  }

  def availableBarItems(expectedBarItems: List[String]): Unit = {
    val actualBarItems = waitForVisibilityOfElementById(allBarItemsId).findElements(By.tagName("li"))
    if (actualBarItems.size() == expectedBarItems.size) {
      for (barItem <- expectedBarItems)
        driver.findElement(By.id(barItem)).isDisplayed
    }
  }

  def interviewOneScheduled(): Unit = {
    val newStatus = "Interview 1 - scheduled"
    changeSystem("recruiter")
    checkForNewStatus(vacancyStatusPath, newStatus)
    availableBarItems(List(completeInterviewEvaluationBarId, noShowBarId, withdrawApplicationAtInterviewOneBarId))
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
    checkCandidateSummary("8") shouldEqual (if (dataLevel.isDefined && dataLevel.get == "restricted") "Restricted Data"
                                            else "External - Non Civil Servant / External")
  }
}
