package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.applicationId
import uk.gov.co.test.ui.pages.vx.DashboardPage.matchCriteria
import uk.gov.co.test.ui.specs.TestData.eventually

object ApplicationSummaryPage extends VacancyBasePage {

  val dashboardPageTitle               = "Home : Civil Service Jobs - GOV.UK"
  val applicationSummaryPageTitle      = "Application Summary : Civil Service Jobs - GOV.UK"
  val searchApplicationPath            = ".//*[@class='textlabel' and text() = 'Search Applications']"
  val searchPath                       = "selected_option"
  val searchInput                      = "search_input"
  val matchingOption                   = "matching_options"
  val searchForId                      = "search_button"
  val appIdPath                        = ".//*[@class='app_id']"
  val completeSiftButtonPath           = "process_rule_but_18"
  val progressButtonPath               = "process_rule_but_657"
  val provisionalOfferOnlineButtonPath = "process_rule_but_3176"
  val siftEvaluationTabPath            = ".//span[@class='main-label' and text() = 'Sift evaluation']"
  val commentsTabPath                  = ".//span[@class='main-label' and text() = 'Comments']"
  def outcomeId                        = s"select2-${appSummaryFormId}_datafield_66487_1_1-container"
  var appSummaryFormId                 = ""

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
    waitForVisibilityOfElementById(completeSiftButtonPath).click()
    waitForVisibilityOfElementByPath(siftEvaluationTabPath).isEnabled
    extractTabFormId()
    selectOutcome("Progress")
    clickOn("submit_button")
    waitForVisibilityOfElementById(progressButtonPath).click()
    waitForVisibilityOfElementById(provisionalOfferOnlineButtonPath).click()
  }
}
