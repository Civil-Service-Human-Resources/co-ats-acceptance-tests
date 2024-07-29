package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, Keys, WebDriver}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.v9RunInWelsh
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.extractApplicationInfo

object SearchJobsPage extends CivilServiceJobsBasePage {

  val civilServiceJobsPageTitle     = "Civil Service job search - Civil Service Jobs - GOV.UK"
//  val signInCreateAccountText       = "Sign in or create an account"
  val signInCreateAccountText       = "Sign in to your account"
  val cSJobSearchHeader             = "Civil Service job search"
  val accountCreatedSuccessMessage1 = "Success"
  val accountCreatedSuccessMessage2 = "Account created"
  val navigateToHomeSearchPath      = ".//a[@title='Search for jobs']"
  val searchForJobsId               = "search_button"

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

  def useSearchFields(jobId: String, searchPathway: String): Unit = {
    val searchField = waitForVisibilityOfElement(By.name(searchPathway))
    if (searchField.getText.nonEmpty) {
      if (!getOs.contains("mac")) {
        searchField.sendKeys(Keys.CONTROL, "a")
      } else {
        searchField.sendKeys(Keys.COMMAND, "a")
      }
      searchField.sendKeys(Keys.BACK_SPACE)
    }
    searchField.sendKeys(jobId)
  }

  def searchForVacancyFlow(jobId: String, searchPathway: String): Unit = {
    val oneResultReturnedPageTitle = s"1 Job found with job reference $jobId - Civil Service Jobs - GOV.UK"
    val wait                       = new WebDriverWait(driver, 210, 1000)
    wait.until { (d: WebDriver) =>
      driver.navigate().refresh()
      enterSearchCriteria(jobId, searchPathway)
      d.getTitle.equals(oneResultReturnedPageTitle)
    }
  }

  def checkForNewVacancy(jobId: String, jobTitle: String, searchPathway: String): Unit = {
    val jobDetailsPath: String = s".//a[text()='$jobTitle']"
    searchForVacancyFlow(jobId, searchPathway)
    if (waitForVisibilityOfElementByTag("h1").getText == "Cannot view job") {
      waitForVisibilityOfElementByPath(navigateToHomeSearchPath).click()
      waitForVisibilityOfElementByTag("h1").getText shouldEqual cSJobSearchHeader
      searchForVacancyFlow(jobId, searchPathway)
      println("Vacancy search resulted in 'Cannot view job' error!")
    } else {
      println(s"waitForVisibilityOfElementByTag(h1).getText is: ${waitForVisibilityOfElementByTag("h1").getText}")
    }
    val title                  = waitForElementClickableByPath(jobDetailsPath)
    title.click()
  }

  def enterSearchCriteria(jobId: String, searchPathway: String): Unit = {
    if (searchPathway.nonEmpty) {
      searchPathway match {
        case "what"  => useSearchFields(jobId, searchPathway)
        case "where" => useSearchFields(jobId, searchPathway)
        case _       => throw new IllegalStateException("Valid search option needs to be either 'what' or 'where'")
      }
    }
    clickOn(searchForJobsId)
  }

  def jobSearchAndApplyFlow(jobTitle: String, jobId: String, searchPathway: String): Unit = {
    waitForVisibilityOfElementByPath(navigateToHomeSearchPath).click()
    eventually(onPage(civilServiceJobsPageTitle))
    enterSearchCriteria(jobId, searchPathway)
    checkForNewVacancy(jobId, jobTitle, searchPathway)
    eventually(onPage(s"$jobTitle - Civil Service Jobs - GOV.UK"))
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(".//*[@title='Cymraeg']").click()
    waitForVisibilityOfElementByPath(".//*[@name='login_button']").click()
    driver.navigate().refresh()
    extractApplicationInfo()
  }
}
