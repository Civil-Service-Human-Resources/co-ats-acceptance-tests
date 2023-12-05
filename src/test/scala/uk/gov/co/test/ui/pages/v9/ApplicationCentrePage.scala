package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyName

object ApplicationCentrePage extends CivilServiceJobsBasePage {

  val applicationCentreTitle        = "Application Centre - Civil Service Jobs - GOV.UK"
  val shortFormCompletionText       = "Thank you for submitting the first section of your application."
  val shortFormCompletionTextId     = "//*[@id='main-content']/div/div[3]/p[1]"
  val completeNextSectionText       = "You can now complete the second section, where you must provide supporting evidence."
  val completeNextSectionTextId     = "//*[@id='main-content']/div/div[3]/p[3]"
  val applicationForVacancyTextPath = ".//*[@class='section app-heading']"
  val completionTextPath            = ".//*[@class='app-status-desc']"
  val applicationStatePath          = ".//*[@id='main-content']/div/div[1]/h3"

  private def applicationCentrePageCheck(): Unit =
    eventually(onPage(applicationCentreTitle))

  def applicationForVacancyText: String =
    waitForVisibilityOfElementByPath(applicationForVacancyTextPath).getText

  def getApplicationForValue: String =
    waitForElementClickableByTag("h4").getText

  def getApplicationConfirmation: String =
    waitForVisibilityOfElementByPath(completionTextPath).getText

  def getApplicationState: String =
    waitForVisibilityOfElementByPath(applicationStatePath).getText

  def advertDetailsFunction(): WebElement =
    driver.findElement(By.xpath(".//input[@value='Advert Details']"))

  def withdrawApplicationFunction(): WebElement =
    driver.findElement(By.xpath(".//input[@value='Withdraw Application']"))

  def continueApplicationFunction(): WebElement =
    driver.findElement(By.xpath(".//input[@value='Continue application']"))

  def helpWithSelectionText(): String =
    driver.findElement(By.tagName("b")).getText

  def confirmShortFormCompletion(): Unit = {
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    continueApplicationFunction().isEnabled
    applicationForVacancyText shouldEqual s"Application For $vacancyName"
    getApplicationState       shouldEqual "Application status: Application started"
    getApplicationConfirmation     should include(
      "Thank you for submitting the first section of your application.\nYou can now complete the second section, where you must provide supporting evidence.\nThe deadline is"
    )
  }

}
