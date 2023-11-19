package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually

object SearchJobsPage extends CivilServiceJobsBasePage {

  val civilServiceJobsPageTitle     = "Civil Service job search - Civil Service Jobs - GOV.UK"
  val signInCreateAccountText       = "Sign in or create an account"
  val cSJobSearchHeader             = "Civil Service job search"
  val accountCreatedSuccessMessage1 = "Success"
  val accountCreatedSuccessMessage2 = "Account created"
  val navigateToHomeSearchPath      = ".//a[@title='Search for jobs']"

  def accountCreatedSuccess1(): String =
    waitForElementClickableByTag("h2").getText

  def accountCreatedSuccess2(): String =
    waitForVisibilityOfElement(By.className("csj4-notification-banner__heading")).getText

  def candidateDisplayName(): String =
    waitForVisibilityOfElement(By.className("logindisplayname")).getText

  def navigateToSignInOrCreateAccount(): Unit = {
    onPage(civilServiceJobsPageTitle)
    waitForVisibilityOfElementByPathLast(s".//*[@title='$signInCreateAccountText']").click()
  }

  def useSearchFields(searchCriteria: String, searchPathway: String): Unit = {
    val searchField = waitForVisibilityOfElement(By.name(searchPathway))
    searchField.sendKeys(searchCriteria)
  }

  def enterSearchCriteria(searchCriteria: String, searchPathway: String): Unit = {
    if (searchPathway.nonEmpty) {
      searchPathway match {
        case "what"  => useSearchFields(searchCriteria, searchPathway)
        case "where" => useSearchFields(searchCriteria, searchPathway)
        case _       => throw new IllegalStateException("Valid search option needs to be either 'What' or 'Where'")
      }
    }
    clickOn("search_button")
  }

  def selectJobDetails(jobTitle: String): Unit = {
    val jobDetailsPath = s".//a[text()='$jobTitle']"
    val title          = waitForVisibilityOfElementByPath(jobDetailsPath)
    title.click()
  }

  def jobSearchAndApplyFlow(searchCriteria: String, searchPathway: String): Unit = {
    waitForVisibilityOfElementByPath(navigateToHomeSearchPath).click()
    onPage(civilServiceJobsPageTitle)
    enterSearchCriteria(searchCriteria, searchPathway)
    selectJobDetails(searchCriteria)
    eventually(onPage(s"$searchCriteria - Civil Service Jobs - GOV.UK"))
    clickOn("login_button")
    driver.navigate().refresh()
  }
}
