package uk.gov.co.test.ui.pages.vx

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyName

object DashboardPage extends VacancyBasePage {

  val dashboardPageTitle   = "Home : Civil Service Jobs - GOV.UK"
  val createNewVacancyPath = ".//*[@class='textlabel' and text() = 'Create new vacancy']"
  val searchVacanciesPath  = ".//*[@class='textlabel' and text() = 'Search Vacancies']"
  val searchPath           = "selected_option"
  val searchInput          = "search_input"
  val matchingOption       = "matching_options"
  val matchedOption        = ".//li[@class='qs_option active']/a/span[1]"
  val searchForVacancy     = "search_button"
  val appIdPath            = ".//*[@class='app_id']"
  var vacancyId            = ""

  private def dashboardPageCheck(): Unit =
    eventually(onPage(dashboardPageTitle))

  private def newVacancyAppId(): String = {
    vacancyId = waitForVisibilityOfElementByPath(appIdPath).getText
    vacancyId
  }

  def searchOn(): Unit = {
    waitForVisibilityOfElementByPath(".//a[@aria-label='Preview advert Details Summary']").isDisplayed
    onPage(s"${vacancyName} : Civil Service Jobs - GOV.UK")
    newVacancyAppId()
    waitForVisibilityOfElementById(searchPath).click()
    waitForVisibilityOfElementByPath(searchVacanciesPath).click()
    waitForVisibilityOfElementById(searchInput).sendKeys(vacancyId)
    matchCriteria("Exact Match")
    clickOn(searchForVacancy)
  }

  def matchCriteria(criteria: String): Unit =
    while (waitForVisibilityOfElementByPath(matchedOption).getText != criteria)
      clickOn(matchingOption)

}
