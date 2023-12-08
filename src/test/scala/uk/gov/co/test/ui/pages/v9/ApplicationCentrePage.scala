package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vacancyName

object ApplicationCentrePage extends CivilServiceJobsBasePage {

  val applicationCentreTitle        = "Application Centre - Civil Service Jobs - GOV.UK"
  val shortFormCompletionText       = "Thank you for submitting the first section of your application."
  val shortFormCompletionTextId     = "//*[@id='main-content']/div/div[3]/p[1]"
  val completeNextSectionText       = "You can now complete the second section, where you must provide supporting evidence."
  val completeNextSectionTextId     = "//*[@id='main-content']/div/div[3]/p[3]"
  val applicationForVacancyTextPath = ".//*[@class='section app-heading']"
  val completionTextPath            = ".//*[@class='app-status-desc']"
  val applicationStatePath          = ".//*[@id='main-content']/div/div[1]/h3"
  val advertDetailsButtonPath       = ".//input[@value='Advert Details']"
  val withdrawApplicationButtonPath = ".//input[@value='Withdraw Application']"
  val continueApplicationButtonPath = ".//input[@value='Continue application']"

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
    driver.findElement(By.xpath(advertDetailsButtonPath))

  def withdrawApplicationFunction(): WebElement =
    driver.findElement(By.xpath(withdrawApplicationButtonPath))

  def continueApplicationFunction(): WebElement =
    driver.findElement(By.xpath(continueApplicationButtonPath))

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

  def confirmLongFormCompletion(): Unit = { //TODO check last text doesn't match with confirmLongFormPECCompletion()
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual "Application status: Help with selection process"
    getApplicationConfirmation shouldEqual "Your application has been received.\nYou have indicated that you may need assistance or an adjustment during the selection process.\nWe've noted this and will contact you if we need further information to help us support you.\nWe'll email you updates on the progress of your application or you can check the progress here in your account."
  }

  def confirmLongFormPECCompletion(): Unit = { //TODO check last text confirmLongFormCompletion()
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual "Application status: Help with selection process"
    getApplicationConfirmation shouldEqual "Your application has been received.\nYou've indicated that you may need assistance or an adjustment during the selection process.\nWe've noted this and will contact you if we need further information to help us support you.\nWe'll email you updates on the progress of your application or you can check the progress here in your account."
  }
}
