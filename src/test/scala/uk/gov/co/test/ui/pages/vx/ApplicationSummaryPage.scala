package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.applicationId
import uk.gov.co.test.ui.pages.vx.DashboardPage.matchCriteria
import uk.gov.co.test.ui.specs.TestData.eventually

object ApplicationSummaryPage extends VacancyBasePage {

  val dashboardPageTitle          = "Home : Civil Service Jobs - GOV.UK"
  val applicationSummaryPageTitle = "Application Summary : Civil Service Jobs - GOV.UK"
  val searchApplicationPath       = ".//*[@class='textlabel' and text() = 'Search Applications']"
  val searchPath                  = "selected_option"
  val searchInput                 = "search_input"
  val matchingOption              = "matching_options"
  val searchForId                 = "search_button"
  val appIdPath                   = ".//*[@class='app_id']"
  val preSiftEvaluationFormBarId  = "process_rule_but_468"
  val completeSiftBarId           = "process_rule_but_18"
  val progressBarId               = "process_rule_but_657"
  val provisionalOfferOnlineBarId = "process_rule_but_3176"
  val employmentHistoryBarId      = "process_rule_but_744"
  val conditionalOfferBarId       = "process_rule_but_1024"
  val withdrawApplicationBarId    = "process_rule_but_570"
  val updateApplicantBarId        = "process_rule_but_2008"
  val emailVacancyHolderBarId     = "process_rule_but_2032"
  val progressBarAfterPreSiftId   = "process_rule_but_155"
  val rejectBarAfterPreSiftId     = "process_rule_but_154"
  val withdrawBarId               = "process_rule_but_509"
  val crcBarId                    = "process_rule_but_776"
  val allBarItemsId               = "process_rules_bar"
  val preSiftActionButtonsPath    = ".//*[@aria-label='Action Buttons']"
  val siftEvaluationTabPath       = ".//span[@class='main-label' and text() = 'Sift evaluation']"
  val commentsTabPath             = ".//span[@class='main-label' and text() = 'Comments']"
  val vacancyAppliedDatePath      = ".//*[@id='collapse_panel']/span[2]"
  var appSummaryFormId            = ""
  def outcomeId                   = s"select2-${appSummaryFormId}_datafield_66487_1_1-container"

  private def dashboardPageCheck(): Unit =
    eventually(onPage(dashboardPageTitle))

  def searchForApplication(applicationId: String): Unit = {
    dashboardPageCheck()
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
    Thread.sleep(10000)
    waitForVisibilityOfElementByPath(vacancyStatusPath).getText shouldEqual s"StatusPre-sift complete"
    availableBarItems(List(progressBarAfterPreSiftId, rejectBarAfterPreSiftId, withdrawBarId))
    waitForVisibilityOfElementById(progressBarAfterPreSiftId).click()
  }

  def availableBarItems(expectedBarItems: List[String]): Unit = {
    val actualBarItems = waitForVisibilityOfElementById(allBarItemsId).findElements(By.tagName("li"))
    if (actualBarItems.size() == expectedBarItems.size) {
      for (barItem <- expectedBarItems)
        driver.findElement(By.id(barItem)).isDisplayed
    }
  }
}
