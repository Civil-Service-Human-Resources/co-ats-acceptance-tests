package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, Keys, WebDriver}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9RunInWelsh, vacancyId, vacancyName}
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
  val changeToWelsh                 = ".//*[@title='Cymraeg']"
  val changeToEnglish               = ".//*[@title='English']"
  val applyForJob                   = ".//*[@name='login_button']"

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

  def errorSearchForVacancyFlow(jobId: String, searchPathway: String, jobDetailsPath: String): Unit = {
    val wait = new WebDriverWait(driver, 210, 1000)
    wait.until { (d: WebDriver) =>
      println("Vacancy search resulted in 'Cannot view job' error pathway!")
      d.navigate().refresh()
      goTo(url)
      eventually(onPage(civilServiceJobsPageTitle))
      enterSearchCriteria(jobId, searchPathway)
      searchForVacancyFlow(jobId, searchPathway)
      val title = waitForElementClickableByPath(jobDetailsPath)
      title.click()
      waitForVisibilityOfElementByTag("h1").getText != "Cannot view job"
    }
  }

  def checkForNewVacancy(jobId: String, jobTitle: String, searchPathway: String): Unit = {
    val jobDetailsPath: String = s".//a[text()='$jobTitle']"
    searchForVacancyFlow(jobId, searchPathway)
    val title                  = waitForElementClickableByPath(jobDetailsPath)
    title.click()
    if (driver.findElement(By.tagName("h1")).getText == "Cannot view job") {
      errorSearchForVacancyFlow(jobId, searchPathway, jobDetailsPath)
    }
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

  def jobSearchToCheckPensionDetails(): Unit = {
    navigateToV9
    waitForVisibilityOfElementByPath(navigateToHomeSearchPath).click()
    eventually(onPage(civilServiceJobsPageTitle))
    enterSearchCriteria(vacancyId, "what")
    checkForNewVacancy(vacancyId, vacancyName, "what")
    eventually(onPage(s"$vacancyName - Civil Service Jobs - GOV.UK"))
  }

  def jobSearchAndApplyFlow(jobTitle: String, jobId: String, searchPathway: String): Unit = {
    waitForVisibilityOfElementByPath(navigateToHomeSearchPath).click()
    eventually(onPage(civilServiceJobsPageTitle))
    enterSearchCriteria(jobId, searchPathway)
    checkForNewVacancy(jobId, jobTitle, searchPathway)
    eventually(onPage(s"$jobTitle - Civil Service Jobs - GOV.UK"))
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(changeToWelsh).click()
    waitForVisibilityOfElementByPath(applyForJob).click()
    driver.navigate().refresh()
    extractApplicationInfo()
  }
}
