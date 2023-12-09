package uk.gov.co.test.ui.pages.vx

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

  def searchVacancy(): Unit = {
    switchToVXConfig()
    searchForApplication(applicationId)
  }
}
