package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually

object SearchJobsPage extends CivilServiceJobsBasePage {

  val signInCreateAccountText       = "Sign in or create an account"
  val signInCreateAccountTextWelsh  = "Mewngofnodi neu greu cyfrif"
  val cSSearchJobsTitle             = "Civil Service job search - Civil Service Jobs - GOV.UK"
  val cSJobSearchHeader             = "Civil Service job search"
  val cSJobSearchHeaderWelsh        = "Chwilio am swydd yn y Gwasanaeth Sifil"
  val accountCreatedSuccessMessage1 = "Success"
  val accountCreatedSuccessMessage2 = "Account created"

  def accountCreatedSuccess1(): String =
    waitForElementClickableByTag("h2").getText

  def accountCreatedSuccess2(): String =
    waitForVisibilityOfElement(By.className("csj4-notification-banner__heading")).getText

  def candidateDisplayName(): String =
    waitForVisibilityOfElement(By.className("logindisplayname")).getText

  def navigateToSignInOrCreateAccount(): Unit = {
    pageTitle equals cSSearchJobsTitle
    waitForVisibilityOfElementByPathLast(s".//*[@title='$signInCreateAccountText']").click()
  }

  def enterWhatAndSearch(jobId: String): Unit = {
    val whatField = waitForVisibilityOfElement(By.name("what"))
    whatField.sendKeys(jobId)
    clickOn("search_button")
  }

  def goToJobApply(): Unit = {
    val jobPath = ".//a[text()='OGDGCCO']"
    SearchJobsPage.enterWhatAndSearch("OGDGCCO")
    val job     = waitForVisibilityOfElementByPath(jobPath)
    job.click()
    eventually(onPage("OGDGCCO - Civil Service Jobs - GOV.UK"))
    clickOn("login_button")
    driver.navigate().refresh()
  }
}
