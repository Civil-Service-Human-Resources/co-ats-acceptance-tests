package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomFirstName, randomLastName, v9AdjustmentsForTests, v9ReasonableAdjustments, v9RunInWelsh, vXAnyOnlineTests, vXInterviewExpectedRounds, vXInterviewFourType, vXInterviewLocation, vXInterviewLongDate, vXInterviewNumber, vXInterviewOneOutcome, vXInterviewOneType, vXInterviewThreeType, vXInterviewTwoType, vXPreSiftRequired, vXSlotTwoStartTime, vacancyName}
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.{confirmStatusOnApplicationPage, reviewUpdateOnApplicationPage}
import uk.gov.co.test.ui.pages.v9.ProvisionalOfferPage.offerDecisionFlow
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.vXExtractTypeOfCandidate
import uk.gov.co.test.ui.pages.vx.DashboardPage.contactEmailVxConfig
import uk.gov.co.test.ui.pages.vx.vacancytabs.ReserveListsTab.reserveExpiryDateMonths

object ApplicationCentrePage extends CivilServiceJobsBasePage {

  val applicationCentreTitle             = "Application Centre - Civil Service Jobs - GOV.UK"
  val welshApplicationCentreTitle        = "Canolfan Ymgeisio - Civil Service Jobs - GOV.UK"
//  val welshApplicationCentreTitle        = "Ceisiadau - Civil Service Jobs - GOV.UK"
  val shortFormCompletionText            = "Thank you for submitting the first section of your application."
  val shortFormCompletionTextId          = "//*[@id='main-content']/div/div[3]/p[1]"
  val completeNextSectionText            = "You can now complete the second section, where you must provide supporting evidence."
  val completeNextSectionTextId          = "//*[@id='main-content']/div/div[3]/p[3]"
  val applicationForVacancyTextPath      = ".//*[@class='section app-heading']"
  val completionTextPath                 = ".//*[@class='app-status-desc']"
  val applicationStatePath               = ".//*[@id='main-content']/div/div[1]/h3"
  val advertDetailsButtonPath            = ".//input[@value='Advert Details']"
  val welshAdvertDetailsButtonPath       = ".//input[@value='Manylion Hysbyseb']"
  val startCheckButtonPath               = ".//input[@value='Start check']"
  val withdrawApplicationButtonPath      = ".//input[@value='Withdraw Application']"
  val welshWithdrawApplicationButtonPath = ".//input[@value='Tynnu cais yn ôl']"
  val continueApplicationButtonPath      = ".//input[@value='Continue application']"
  val offerDecisionButtonPath            = ".//input[@value='Offer Decision']"
  val welshOfferDecisionButtonPath       = ".//input[@value='Penderfyniad Cynnig']"
  val feedbackButtonPath                 = ".//input[@value='Feedback']"
  val welshFeedbackButtonPath            = ".//input[@value='Adborth']"
  val scheduleInterviewButtonPath        = ".//input[@value='Schedule interview']"
  val startTestButtonPath                = ".//input[@value='Start Test']"
  val resumeTestButtonPath               = ".//input[@value='Resume Test']"
  val pecStartButtonPath                 = ".//input[@value='Begin pre-employment checks']"
  val welshPecStartButtonPath            = ".//input[@value='Dechrau gwiriadau cyn-cyflogaeth']"
  val applicationLinkPath                = ".//a[@title='Applications']"
  val continueApplicationName            = "submit_form"

  private def applicationCentrePageCheck(): Unit =
    if (v9RunInWelsh) eventually(onPage(welshApplicationCentreTitle)) else eventually(onPage(applicationCentreTitle))

  def applicationForVacancyText: String =
    waitForVisibilityOfElementByPath(applicationForVacancyTextPath).getText

  def getApplicationForValue: String =
    waitForElementClickableByTag("h4").getText

  def getApplicationConfirmation: String =
    waitForVisibilityOfElementByPath(completionTextPath).getText

  def getApplicationState: String =
    waitForVisibilityOfElementByPath(applicationStatePath).getText

  def advertDetailsFunction(): WebElement =
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(welshAdvertDetailsButtonPath)
    else waitForVisibilityOfElementByPath(advertDetailsButtonPath)

  def scheduleInterviewFunction(): WebElement =
    waitForVisibilityOfElementByPath(scheduleInterviewButtonPath)

  def withdrawApplicationFunction(): WebElement =
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(welshWithdrawApplicationButtonPath)
    else waitForVisibilityOfElementByPath(withdrawApplicationButtonPath)

  def continueApplicationFunction(): WebElement =
    waitForVisibilityOfElementByPath(continueApplicationButtonPath)

  def feedbackFunction(): WebElement =
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(welshFeedbackButtonPath)
    else waitForVisibilityOfElementByPath(feedbackButtonPath)

  def startCheckFunction(): WebElement =
    waitForVisibilityOfElementByPath(startCheckButtonPath)

  def offerDecisionFunction(): WebElement =
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(welshOfferDecisionButtonPath)
    else waitForVisibilityOfElementByPath(offerDecisionButtonPath)

  def startTestFunction(): WebElement =
    waitForVisibilityOfElementByPath(startTestButtonPath)

  def resumeTestFunction(): WebElement =
    waitForVisibilityOfElementByPath(resumeTestButtonPath)

  def pecStartFunction(): WebElement =
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(welshPecStartButtonPath)
    else waitForVisibilityOfElementByPath(pecStartButtonPath)

  def helpWithSelectionText(): String =
    driver.findElement(By.tagName("b")).getText

  def confirmShortFormCompletion(): Unit = {
    applicationCentrePageCheck()
    continueApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText shouldEqual s"Application For $vacancyName"
    getApplicationState       shouldEqual "Application status: Application started"
    getApplicationConfirmation     should include(
      "Thank you for submitting the first section of your application.\nYou can now complete the second section, where you must provide supporting evidence.\nThe deadline is"
    )
  }

  def confirmShortFormCompletionNoLongForm(): Unit = {
    applicationCentrePageCheck()
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    if (v9RunInWelsh) {
      getApplicationState        shouldEqual "Statws cais: Cais wedi'i dderbyn"
      getApplicationConfirmation shouldEqual """Mae eich cais wedi cael ei dderbyn.
                                               |Byddwn yn anfon e-bost atoch am ddatblygiad eich cais, neu gallwch wirio hyn yn eich Canolfan Geisiadau.""".stripMargin
    } else {
      applicationForVacancyText  shouldEqual s"Application For $vacancyName"
      getApplicationState        shouldEqual "Application status: Application received"
      getApplicationConfirmation shouldEqual "Your application has been received.\nWe’ll email you about your application’s progress, or you can check this in your Application Centre."
    }
  }

  def confirmLongFormCompletion(): Unit = { //TODO check last text doesn't match with confirmLongFormPECCompletion()
    reviewUpdateOnApplicationPage()
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
    } else if (vXPreSiftRequired) {
      getApplicationState        shouldEqual "Application status: Application received"
      getApplicationConfirmation shouldEqual """Your application has been received.
                                               |We'll email you updates on the progress of your application or you can check the progress here in your account.""".stripMargin
    } else {
      getApplicationState        shouldEqual "Application status: Application received"
      getApplicationConfirmation shouldEqual "Your application has been received.\nWe’ll email you about your application’s progress, or you can check this in your Application Centre."
    }
  }

  def confirmProvisionalOfferState(): Unit = {
    val status      = "Provisional offer"
    val welshStatus = "Cynnig dros dro"
    changeSystem("candidate")
    applicationCentrePageCheck()
    offerDecisionFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    if (v9RunInWelsh) {
      confirmStatusOnApplicationPage(welshStatus)
      getApplicationState        shouldEqual s"Statws cais: $welshStatus"
      getApplicationConfirmation shouldEqual
        """Llongyfarchiadau, hoffem wneud cynnig swydd dros dro i chi.
          |Cliciwch ar "Penderfyniad Cynnig" i dderbyn y cynnig hwn.
          |Yna byddwn yn cynnal rhai gwiriadau cyn cyflogi cyn i ni ystyried gwneud cynnig swydd ffurfiol i chi.
          |Peidiwch ag ymddiswyddo o'ch cyflogaeth bresennol nes eich bod wedi cael cynnig ffurfiol.
          |Gallwch weld unrhyw adborth a roddwyd trwy glicio ar y botwm "Adborth" .
          |Os nad oes gennych ddiddordeb yn y swydd hon mwyach, dylech dynnu eich cais yn ôl.""".stripMargin
    } else {
      confirmStatusOnApplicationPage(status)
      applicationForVacancyText  shouldEqual s"Application For $vacancyName"
      getApplicationState        shouldEqual s"Application status: $status"
      getApplicationConfirmation shouldEqual
        """Congratulations, we'd like to make you a provisional job offer.
          |Please click "Offer Decision" to accept this offer.
          |We'll then conduct some pre-employment checks before we consider making you a formal job offer.
          |Please do not resign from your current employment until you‘ve been made a formal offer.
          |You can see any feedback that's been given by clicking the "Feedback" button.
          |If you're no longer interested in this job please withdraw your application.""".stripMargin
    }
  }

  def weAreCheckingYourApplicationState(): Unit = {
    val status = "We are currently checking your application"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual
      """We're currently checking your details.
        |Your application will be progressed shortly if the details are correct, otherwise we'll send you an email advising you what to do next.""".stripMargin
  }

  def navigateToApplicationsPage(): Unit =
    waitForVisibilityOfElementByPath(applicationLinkPath).click()

  def candidateAcceptsOffer(): Unit = {
    confirmProvisionalOfferState()
    offerDecisionFunction().click()
    if (!v9RunInWelsh) offerDecisionFlow("Accept") else offerDecisionFlow("Derbyn")
    vXExtractTypeOfCandidate()
  }

  def v9ConfirmOfferAcceptedState(): Unit = {
    val status      = "Offer accepted"
    val welshStatus = "Cynnig wedi'i dderbyn"
    changeSystem("candidate")
    if (!v9RunInWelsh) {
      confirmStatusOnApplicationPage(status)
      applicationForVacancyText  shouldEqual s"Application For $vacancyName"
      getApplicationState        shouldEqual s"Application status: $status"
      getApplicationConfirmation shouldEqual
        """We're delighted that you have accepted our job offer.
          |As part of the onboarding process we require additional information.""".stripMargin
    } else {
      confirmStatusOnApplicationPage(welshStatus)
      getApplicationState        shouldEqual s"Statws cais: $welshStatus"
      getApplicationConfirmation shouldEqual
        """Rydym yn falch eich bod chi wedi derbyn ein cynnig swydd.
          |Fel rhan o'r broses gyflogi rydym angen gwybodaeth ychwanegol.""".stripMargin
    }
    applicationCentrePageCheck()
    pecStartFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
  }

  def confirmApplicationUpdateNoPecPn(): Unit = {
    val newStatus = "Application Update"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(newStatus)
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    feedbackFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $newStatus"
    getApplicationConfirmation shouldEqual
      """We're finalising all documentation regarding your application.
        |You'll be contacted shortly to advise what will happen next.""".stripMargin
  }

  def passedPecChecks(): Unit = {
    val newStatus = "Pre-employment checks complete"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(newStatus)
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $newStatus"
    getApplicationConfirmation shouldEqual
      """Congratulations you’ve passed our pre-employment checks.
        |You'll be contacted shortly to advise what will happen next.""".stripMargin
  }

  def applicationUpdatePassedPecChecks(): Unit = {
    val newStatus = "Application update"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(newStatus)
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $newStatus"
    getApplicationConfirmation shouldEqual
      """Congratulations you’ve passed our pre-employment checks.
        |
        |You'll be contacted shortly to advise what will happen next.""".stripMargin
  }

  def confirmApplicationUpdateNoPecNen(): Unit = {
    val newStatus = "Pre-employment checks"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(newStatus)
    applicationCentrePageCheck()
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $newStatus"
    getApplicationConfirmation shouldEqual
      """We are reviewing the outcomes of your pre-employment checks.
        |We will contact you as soon as a decision has been made. Please do not resign from your current position at this time.""".stripMargin
  }

  def confirmOfferAcceptedNoPecFunction(): Unit = {
    val newStatus = "Offer accepted"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(newStatus)
    applicationCentrePageCheck()
    feedbackFunction().isEnabled
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $newStatus"
    getApplicationConfirmation shouldEqual
      """We're delighted that you have accepted our job offer.
        |As part of the onboarding process we may require further information.
        |We will contact you with updates about next steps.""".stripMargin
  }

  def confirmApplicationUpdateState(): Unit = {
    val newStatus = "Application Update"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(newStatus)
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    feedbackFunction().isEnabled
//    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $newStatus"
    getApplicationConfirmation shouldEqual
      """We're finalising all documentation regarding your application.
        |You'll be contacted shortly to advise what will happen next.""".stripMargin
  }

  def confirmPecSubmissionState(): Unit = {
    val status = "Pre-employment checks"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual "Great news, you've accepted your provisional offer and your pre-employment checks are underway.\nWe are still checking:\nyour employment history, including any gaps\nwhether you have any convictions\n\n\nWe will send an email notification to you once all pre-employment checks are complete."
  }

  def confirmPecRtwOnlyCrcNoneNotApplicable(): Unit = {
    val status = "Pre-employment checks"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual "Great news, you've accepted your provisional offer and your pre-employment checks are underway.\nWe will send an email notification to you once all pre-employment checks are complete."
  }

  def confirmPecRtwOnlyState(): Unit = {
    val status = "Pre-employment checks"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual "Great news, you've accepted your provisional offer and your pre-employment checks are underway.\nWe are still checking:\nyour identity and right to work in the Civil Service\n\n\nWe will send an email notification to you once all pre-employment checks are complete."
  }

  def confirmPecRtwAndDbsAnyState(): Unit = {
    val status = "Pre-employment checks"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    advertDetailsFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual "Great news, you've accepted your provisional offer and your pre-employment checks are underway.\nWe are still checking:\nyour identity and right to work in the Civil Service\nwhether you have any convictions\n\n\nWe will send an email notification to you once all pre-employment checks are complete."
  }

  def confirmPecRtwOnlyStartCheckState(): Unit = {
    val status = "Confirm your identity"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    startCheckFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual "To complete the following check you will need:\n • an in date British or Irish passport, or an in date Irish passport card \n • to take a ‘selfie’ photograph of yourself\nStarting your ID check\nYou'll need access to a smartphone or tablet with a camera to complete the ID check. \nWhen you are ready, select the \"Start check\" button. You will be directed to the external service.\nNext steps\nWhen you've submitted your identity documents, you'll be sent an email when we receive the results back from the external service.\nYou can come back to this page to check the status of your application.\nIf you need help using the external service\nIf you are not able to use this external service for any reason contact ryan.hobbs@cabinetoffice.gov.uk\nWhat we will do with your data (opens in a new window)"
  }

  def confirmPecRtwOnlyAndDBSEnhancedStartCheck(): Unit = {
    val status = "Confirm your identity"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    startCheckFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual "To complete the following check you will need:\n • an in date British or Irish passport, or an in date Irish passport card \n • to take a ‘selfie’ photograph of yourself\nStarting your ID check\nYou'll need access to a smartphone or tablet with a camera to complete the ID check. \nWhen you are ready, select the \"Start check\" button. You will be directed to the external service.\nNext steps\nWhen you've submitted your identity documents, you'll be sent an email when we receive the results back from the external service.\nYou can come back to this page to check the status of your application.\nIf you need help using the external service\nIf you are not able to use this external service for any reason contact ryan.hobbs@cabinetoffice.gov.uk\nWhat we will do with your data (opens in a new window)"
  }

  def confirmTrustIdQrCode(): Unit = {
    startCheckFunction().click()
    waitForVisibilityOfElementByPath(
      ".//p[@class='sc-eqUAAy dPUdmr mb-0 text-center']"
    ).getText shouldEqual "Scan the QR with your mobile camera"
    waitForVisibilityOfElementByPath(".//img[@alt='QR code for scanning with your mobile device']").isDisplayed
    waitForVisibilityOfElementById("emailAddress").isDisplayed
  }

  def applicationBeingReviewedPreSiftState(): Unit = {
    val status = "Application being reviewed"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual
      """Your application is being reviewed.
        |If you are no longer interested in this job, you can withdraw your application at any time.""".stripMargin
    switchToOtherWindow
  }

  def applicationBeingReviewedState(): Unit = {
    val status = "Application being reviewed"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual """The selection panel are reviewing your application.
                                             |We'll email you updates on the progress of your application or you can check the progress here in your account.""".stripMargin
    switchToOtherWindow
  }

  def successfulAtSiftState(): Unit = {
    val status      = "Successful at Interview"
    val welshStatus = "Llwyddiannus yn y Cyfweliad"
    changeSystem("candidate")
    feedbackFunction().isEnabled
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    if (v9RunInWelsh) {
      confirmStatusOnApplicationPage(welshStatus)
      getApplicationState        shouldEqual s"Statws cais: $welshStatus"
      getApplicationConfirmation shouldEqual
        """Llongyfarchiadau rydych wedi bod yn llwyddiannus yn y sifft.
          |Byddwn mewn cysylltiad yn fuan gyda mwy o wybodaeth am y camau nesaf.""".stripMargin
    } else {
      confirmStatusOnApplicationPage(status)
      applicationForVacancyText  shouldEqual s"Application For $vacancyName"
      getApplicationState        shouldEqual s"Application status: $status"
      getApplicationConfirmation shouldEqual
        """Congratulations you have been successful at sift.
          |We will be in contact shortly with more information about the next steps.""".stripMargin
    }
    switchToOtherWindow
  }

  def invitedForInterviewState(): Unit = {
    val status     = vXInterviewNumber.head match {
      case "1" => "Invited for interview"
      case "2" => "Invited for second interview"
      case "3" => "Invited for third interview"
      case "4" => "Invited for fourth interview"
    }
    val inviteType = interviewTypeDetail() match {
      case "Telephone"  => s"for a ${interviewTypeDetail().toLowerCase} interview"
      case "Assessment" => s"for an ${interviewTypeDetail().toLowerCase}"
      case "Video"      => s"for a ${interviewTypeDetail().toLowerCase} interview"
      case "Interview"  => s"for an ${interviewTypeDetail().toLowerCase}"
    }
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    scheduleInterviewFunction().isEnabled
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    applicationForVacancyText shouldEqual s"Application For $vacancyName"
    getApplicationState shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual s"""Congratulations, we'd like to invite you $inviteType.
                                             |To book your interview slot click 'Schedule interview'.
                                             |To get your preferred time we recommend you book as early as possible.
                                             |If you're no longer interested in this job, please withdraw your application.""".stripMargin //TODO an issue with speech mark on I2 'Schedule interview"
  }

  def interviewSlotBookedState(): Unit = {
    val status          = vXInterviewNumber.head match {
      case "1" => "Interview slot booked"
      case "2" => "Second interview slot booked"
      case "3" => "Scheduled for third interview" //TODO different wording structure compared to I2
      case "4" => "Scheduled for fourth interview"
    }
    val appConfirmation = interviewTypeDetail() match {
      case "Telephone"  =>
        s"""Your telephone interview slot is booked and details are shown below:
                     |Date: $vXInterviewLongDate
                     |Time: ${vXSlotTwoStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}
                     |We will send details on how to access your telephone interview separately when they are available.
                     |Autotest - Instructions for $randomFirstName $randomLastName for interview ${vXInterviewNumber.head}
                     |If you're no longer interested in this job, please withdraw your application.""".stripMargin
      case "Assessment" =>
        s"""Your assessment slot is booked and details are shown below:
                     |Date: $vXInterviewLongDate
                     |Time: ${vXSlotTwoStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}
                     |Autotest - Instructions for $randomFirstName $randomLastName for interview ${vXInterviewNumber.head}
                     |If you're no longer interested in this job, please withdraw your application.""".stripMargin
      case "Video"      =>
        s"""Your video interview slot is booked and details are shown below:
                     |Date: $vXInterviewLongDate
                     |Time: ${vXSlotTwoStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}
                     |We will send details on how to access your video interview separately when they are available.
                     |Autotest - Instructions for $randomFirstName $randomLastName for interview ${vXInterviewNumber.head}
                     |If you're no longer interested in this job, please withdraw your application.""".stripMargin
      case "Interview"  =>
        s"""Your interview slot is booked and details are shown below:
                     |Date: $vXInterviewLongDate
                     |Time: ${vXSlotTwoStartTime.replaceAll("[A-Za-z ]", "").filterNot(_.isWhitespace)}
                     |Location: $vXInterviewLocation
                     |Please arrive at least twenty minutes before your interview and make sure you bring some form of picture ID, such as your driving licence or passport.
                     |Autotest - Instructions for $randomFirstName $randomLastName for interview ${vXInterviewNumber.head}
                     |If you're no longer interested in this job, please withdraw your application.""".stripMargin
    }
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    applicationForVacancyText shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual appConfirmation
  }

  def applicationBeingReviewedAfterInterviewState(): Unit = {
    val status = "Application being reviewed"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual
      s"""Thank you for attending your recent interview.
         |The selection panel are reviewing your application.
         |We'll email you updates on the progress of your application or you can check the progress here in your account.""".stripMargin
  }

  def applicationInReserveState(): Unit = {
    val status = "Application in reserve"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    feedbackFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    advertDetailsFunction().isEnabled
    applicationForVacancyText shouldEqual s"Application For $vacancyName"
    getApplicationState       shouldEqual s"Application status: $status"
    getApplicationConfirmation     should startWith(
      s"We've placed you on a reserve list until ${reserveExpiryDateMonths()}."
    )
  }

  def successfulAtInterviewState(): Unit = {
    val status = "Successful at Interview"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(status)
    applicationCentrePageCheck()
    feedbackFunction().isEnabled
    advertDetailsFunction().isEnabled
    withdrawApplicationFunction().isEnabled
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $status"
    getApplicationConfirmation shouldEqual
      s"""Congratulations you have been successful at interview.
         |We will be in contact shortly with more information about the next steps.""".stripMargin
    changeSystem("recruiter")
  }

  def confirmIdvtAwaitingResultsState(): Unit = {
    val newStatus = "Digital identity check awaiting results"
    changeSystem("candidate")
    confirmStatusOnApplicationPage(newStatus)
    applicationCentrePageCheck()
    !withdrawApplicationFunction().isDisplayed
    applicationForVacancyText  shouldEqual s"Application For $vacancyName"
    getApplicationState        shouldEqual s"Application status: $newStatus"
    getApplicationConfirmation shouldEqual
      """Thank you for submitting photographs of your identity documents.
        |These are now being reviewed and we are waiting for the results of the check from the external service.
        |We normally receive results within an hour but sometimes this may take up to a day.
        |We will inform you by email when we receive the results.
        |You can come back to this page to check your application’s progress at any time.""".stripMargin
  }

  def applicationStateAfterInterview(applicationDetails: ApplicationDetails): Unit =
    if (vXInterviewExpectedRounds.toInt == vXInterviewNumber.head.toInt) {
      if (interviewNumberDetail(applicationDetails) == "Progress") {
        successfulAtInterviewState()
      } else if (interviewNumberDetail(applicationDetails) == "Hold") {
        applicationInReserveState()
      }
    } else applicationBeingReviewedAfterInterviewState()

  def interviewNumberDetail(applicationDetails: ApplicationDetails): String =
    vXInterviewExpectedRounds.toInt match {
      case 1 =>
        if (vXInterviewOneOutcome.isEmpty) applicationDetails.interviewOneDetails.finalOutcome
        else vXInterviewOneOutcome
      case 2 => applicationDetails.interviewTwoDetails.finalOutcome
      case 3 => applicationDetails.interviewThreeDetails.finalOutcome
      case 4 => applicationDetails.interviewFourDetails.finalOutcome
    }

  def interviewTypeDetail(): String =
    vXInterviewNumber.head match {
      case "1" => vXInterviewOneType
      case "2" => vXInterviewTwoType
      case "3" => vXInterviewThreeType
      case "4" => vXInterviewFourType
    }
}
