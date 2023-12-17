package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{v9AdjustmentsForTests, v9ReasonableAdjustments, vXAnyOnlineTests, vacancyName}
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.reviewUpdateValue
import uk.gov.co.test.ui.pages.vx.DashboardPage.{contactEmailVxConfig, switchToV9Test}

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
  val offerDecisionButtonPath       = ".//input[@value='Offer Decision']"
  val feedbackButtonPath            = ".//input[@value='Feedback']"
  val startTestButtonPath           = ".//input[@value='Start Test']"
  val resumeTestButtonPath          = ".//input[@value='Resume Test']"
  val pecStartButtonPath            = ".//input[@value='Begin pre-employment checks']"
  val applicationLinkPath           = ".//a[@title='Applications']"
  val continueApplicationName       = "submit_form"

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
    waitForVisibilityOfElementByPath(advertDetailsButtonPath)

  def withdrawApplicationFunction(): WebElement =
    waitForVisibilityOfElementByPath(withdrawApplicationButtonPath)

  def continueApplicationFunction(): WebElement =
    waitForVisibilityOfElementByPath(continueApplicationButtonPath)

  def feedbackFunction(): WebElement =
    waitForVisibilityOfElementByPath(feedbackButtonPath)

  def offerDecisionFunction(): WebElement =
    waitForVisibilityOfElementByPath(offerDecisionButtonPath)

  def startTestFunction(): WebElement =
    waitForVisibilityOfElementByPath(startTestButtonPath)

  def resumeTestFunction(): WebElement =
    waitForVisibilityOfElementByPath(resumeTestButtonPath)

  def pecStartFunction(): WebElement =
    waitForVisibilityOfElementByPath(pecStartButtonPath)

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

  def confirmShortFormCompletionNoLongForm(): Unit = {
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual "Application status: Application received"
    getApplicationConfirmation shouldEqual "Your application has been received.\nWe’ll email you about your application’s progress, or you can check this in your Application Centre."
  }

  def confirmLongFormCompletion(): Unit = { //TODO check last text doesn't match with confirmLongFormPECCompletion()
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText shouldEqual s"Application For $vacancyName"
    if (vXAnyOnlineTests) {
      if (v9ReasonableAdjustments && v9AdjustmentsForTests) {
        getApplicationState        shouldEqual "Application status: Help with selection process"
        getApplicationConfirmation shouldEqual "Your application has been received.\nYou have indicated that you may need assistance or an adjustment during the selection process.\nWe've noted this and will contact you if we need further information to help us support you.\nWe'll email you updates on the progress of your application or you can check the progress here in your account."
      } else {
        getApplicationState        shouldEqual "Application status: Invited to Civil Service Numerical Test"
        getApplicationConfirmation shouldEqual s"You're now invited to complete the Civil Service Numerical Test.\nThis test must be completed by 12:00AM on 09 January 2024.\nYou’ll need to pass this test in order to progress onto the next stage in your application.\nYou'll receive your results and feedback after you complete your test.\n\nHow to prepare\n\nTo prepare for the test, we strongly recommend that you:\n• Read the test guide (opens in a new window)\n• Take the CSNT Practice test (opens in a new window)\nAnswer the example questions at the beginning of the test.\n\nWhat you need\n\nThe test is not timed, however most people take about an hour to complete it. Although the test works on most devices, we recommend using larger screens (laptop, desktop) over handheld (iPad, mobile phone), and a modern browser. Am I using a modern browser? (opens in a new window) If you don’t have a computer, there are plenty of options - for example your local library.\nYou'll also need:\n• A stable internet connection.\n• A time and place with no interruptions.\nComplete the test alone, with no input from anyone else. Any evidence of receiving help with the tests will be taken seriously and, if found, will lead to your withdrawal from the process.\nPlease contact the Insolvency Service recruitment team at $contactEmailVxConfig if you need further support. They may not be able to help you if you contact them on the final day."
        startTestFunction().isEnabled
      }
    } else {
      getApplicationState        shouldEqual "Application status: Application received"
      getApplicationConfirmation shouldEqual "Your application has been received.\nWe’ll email you about your application’s progress, or you can check this in your Application Centre."
    }
  }

  def confirmLongFormPECCompletion(): Unit = { //TODO check last text confirmLongFormCompletion() on You've on 1st one
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText shouldEqual s"Application For $vacancyName"
    if (vXAnyOnlineTests) {
      if (v9ReasonableAdjustments && v9AdjustmentsForTests) {
        getApplicationState        shouldEqual "Application status: Help with selection process"
        getApplicationConfirmation shouldEqual "Your application has been received.\nYou've indicated that you may need assistance or an adjustment during the selection process.\nWe've noted this and will contact you if we need further information to help us support you.\nWe'll email you updates on the progress of your application or you can check the progress here in your account."
      } else {
        getApplicationState        shouldEqual "Invited to Civil Service Numerical Test"
        getApplicationConfirmation shouldEqual "You're now invited to complete the Civil Service Numerical Test.\nThis test must be completed by 12:00AM on 09 January 2024.\nYou’ll need to pass this test in order to progress onto the next stage in your application.\nYou'll receive your results and feedback after you complete your test.\n\nHow to prepare\n\nTo prepare for the test, we strongly recommend that you:\n• Read the test guide (opens in a new window)\n• Take the CSNT Practice test (opens in a new window)\nAnswer the example questions at the beginning of the test.\n\nWhat you need\n\nThe test is not timed, however most people take about an hour to complete it. Although the test works on most devices, we recommend using larger screens (laptop, desktop) over handheld (iPad, mobile phone), and a modern browser. Am I using a modern browser? (opens in a new window) If you don’t have a computer, there are plenty of options - for example your local library.\nYou'll also need:\n• A stable internet connection.\n• A time and place with no interruptions.\nComplete the test alone, with no input from anyone else. Any evidence of receiving help with the tests will be taken seriously and, if found, will lead to your withdrawal from the process.\nPlease contact the Insolvency Service recruitment team at ryan.hobbs@cabinetoffice.gov.uk if you need further support. They may not be able to help you if you contact them on the final day."
      }
    } else {
      getApplicationState        shouldEqual "Application status: Application received"
      getApplicationConfirmation shouldEqual "Your application has been received.\nWe’ll email you about your application’s progress, or you can check this in your Application Centre."
    }
  }

  def confirmProvisionalOffer(): Unit = {
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    feedbackFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual "Application status: Provisional offer"
    getApplicationConfirmation shouldEqual "Congratulations, we'd like to make you a provisional job offer.\nPlease click \"Offer Decision\" to accept this offer.\nWe'll then conduct some pre-employment checks before we consider making you a formal job offer.\nPlease do not resign from your current employment until you‘ve been made a formal offer.\nYou can see any feedback that's been given by clicking the \"Feedback\" button.\nIf you're no longer interested in this job please withdraw your application."
  }

  def navigateToApplicationsPage(): Unit =
    waitForVisibilityOfElementByPath(applicationLinkPath).click()

  def candidateAcceptsOffer(): Unit = {
    switchToV9Test()
    driver.navigate().to(TestConfiguration.urlHost("vxconfig") + "/vx/lang-en-GB/candidate/application")
    reviewUpdateValue().click()
    confirmProvisionalOffer()
    offerDecisionFunction().click()
  }

  def confirmOfferAccepted(): Unit = {
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    feedbackFunction().isEnabled
    pecStartFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual "Application status: Offer accepted"
    getApplicationConfirmation shouldEqual "We're delighted that you have accepted our job offer.\nAs part of the onboarding process we require additional information."
  }

  def confirmPecSubmission(): Unit = {
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual "Application status: Pre-employment checks"
    getApplicationConfirmation shouldEqual "Great news, you've accepted your provisional offer and your pre-employment checks are underway.\nWe are still checking:\nyour employment history, including any gaps\nwhether you have any convictions\n\n\nWe will send an email notification to you once all pre-employment checks are complete."
  }
}
