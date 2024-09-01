package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9BiometricPassportOrId, v9BiometricResidenceCard, v9EussStatus, v9IdvtDataConsent, v9InDateDrivingLicence, v9RtwBritishCitizen, v9RtwBritishIrishPassport, v9RunInWelsh, v9SmartphoneAccess, vXOfferCivilServicePension, vXSalaryMaximum, vXSalaryMinimum, vXSalaryMoreDetails, vacancyName}
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{changeToEnglish, changeToWelsh}

import java.text.NumberFormat

object ApplicationDetailsPage extends CivilServiceJobsBasePage {

  val applicationsDetailsTitle         = s"$vacancyName - Civil Service Jobs - GOV.UK"
  val formatter: NumberFormat          = java.text.NumberFormat.getIntegerInstance
  val salaryPath                       = ".//*[contains(text(), 'Salary')]//..//*[@class='vac_display_field_value']"
  val welshSalaryPath                  = ".//*[contains(text(), 'Cyflog')]//..//*[@class='vac_display_field_value']"
  val salaryMoreDetailsPath            = "(//*[@class='vac_display_field_value'])[3]"
  val pensionContributionRatePath      = "//div[starts-with(., 'A ')]"
  val welshPensionContributionRatePath = "//*[contains(text(), 'chyfraniad cyflogwr o 28.97%')]"
  val benefitsSectionId                = "section_link_benefits"
  val benefitsPensionTextPath          = "//div[starts-with(., 'Alongside your salary of')]"
  val welshBenefitsPensionTextPath     = "//div[starts-with(., 'Ochr yn ochr ')]"

  private def rtw(): Unit = {
    v9RtwBritishCitizen = true
    v9RtwBritishIrishPassport = true
    v9EussStatus = ""
    v9BiometricResidenceCard = false
  }

  private def idvt(): Unit = {
    v9IdvtDataConsent = true
    v9SmartphoneAccess = true
    v9BiometricPassportOrId = true
    v9InDateDrivingLicence = true
  }

  def resetApplicationDetails(): Unit = {
    rtw()
    idvt()
  }

  private def waitForVacancyUpdate(pathToFind: String, valueToFind: String): Unit = {
    val wait = new WebDriverWait(driver, 210, 5000)
    wait.until { (d: WebDriver) =>
      driver.navigate().refresh()
      d.findElement(By.xpath(pathToFind)).getText.equals(valueToFind)
    }
  }

  def confirmSalaryDetails(): Unit = {
    val formattedSalaryMin = formatter.format(vXSalaryMinimum.toInt)
    if (vXSalaryMaximum != "" && vXSalaryMaximum != "0") {
      val formattedSalaryMax = formatter.format(vXSalaryMaximum.toInt)
      waitForVacancyUpdate(
        if (!v9RunInWelsh) salaryPath else welshSalaryPath,
        s"£$formattedSalaryMin - £$formattedSalaryMax"
      )
    } else {
      waitForVacancyUpdate(if (!v9RunInWelsh) salaryPath else welshSalaryPath, s"£$formattedSalaryMin")
    }
  }

  def confirmSalaryMoreDetails(): Unit =
    if (vXSalaryMoreDetails != "") {
      if (!v9RunInWelsh) {
        waitForVacancyUpdate(salaryMoreDetailsPath, s"$vXSalaryMoreDetails")
      } else waitForVacancyUpdate(salaryMoreDetailsPath, "Awtomatiaeth - mwy o fanylion am gyflog")
    }

  def confirmPensionContributionRate(): Unit =
    if (vXOfferCivilServicePension && vXSalaryMinimum != "0") {
      val pensionRate          = waitForVisibilityOfElementByPath(
        if (!v9RunInWelsh) pensionContributionRatePath else welshPensionContributionRatePath
      )
      val civilServiceLinkText = pensionRate.findElement(By.tagName("a"))
      val civilServiceLink     = civilServiceLinkText.getAttribute("href")
      if (!v9RunInWelsh) {
        pensionRate.getText          shouldEqual "A Civil Service Pension with an employer contribution of 28.97%"
        civilServiceLinkText.getText shouldEqual "Civil Service Pension"
        civilServiceLink             shouldEqual "https://www.civilservicepensionscheme.org.uk/joining-the-pension-scheme/benefits-of-the-pension-scheme/"
      } else {
        pensionRate.getText          shouldEqual "Pensiwn y Gwasanaeth Sifil gyda chyfraniad cyflogwr o 28.97%"
        civilServiceLinkText.getText shouldEqual "Pensiwn y Gwasanaeth Sifil"
        civilServiceLink             shouldEqual "https://www.civilservicepensionscheme.org.uk/joining-the-pension-scheme/benefits-of-the-pension-scheme/"
      }
    } else {
      val checkForPensionInfo = driver.findElements(
        By.xpath(if (!v9RunInWelsh) pensionContributionRatePath else welshPensionContributionRatePath)
      )
      checkForPensionInfo shouldBe empty
    }

  def confirmBenefitsSectionText(): Unit =
    if (vXOfferCivilServicePension && vXSalaryMinimum != "0") {
      val formattedSalaryMin                  = formatter.format(vXSalaryMinimum.toInt)
      def multiply(m: Int)(n: Double): Double = m * n
      val employeeContribution                = multiply(vXSalaryMinimum.toInt)(0.2897)
      val benefitsSectionText                 = waitForVisibilityOfElementByPath(
        if (!v9RunInWelsh) benefitsPensionTextPath else welshBenefitsPensionTextPath
      )
      val benefitsLinkText                    = benefitsSectionText.findElement(By.tagName("a"))
      val benefitsPensionLink                 = benefitsLinkText.getAttribute("href")
      if (!v9RunInWelsh) {
        benefitsSectionText.getText shouldEqual
          s"""Alongside your salary of £$formattedSalaryMin, Ofwat (Water Services Regulation Authority) contributes £${formatter
            .format(
              employeeContribution.toInt
            )} towards you being a member of the Civil Service Defined Benefit Pension scheme. Find out what benefits a Civil Service Pension provides.""".stripMargin
        benefitsLinkText.getText    shouldEqual "Find out what benefits a Civil Service Pension provides."
        benefitsPensionLink         shouldEqual "https://www.civilservicepensionscheme.org.uk/joining-the-pension-scheme/benefits-of-the-pension-scheme/"
      } else {
        benefitsSectionText.getText shouldEqual
          s"""Ochr yn ochr â'ch cyflog o £$formattedSalaryMin, mae Ofwat (Awdurdod Rheoleiddio Gwasanaethau Dŵr) yn cyfrannu £${formatter
            .format(
              employeeContribution.toInt
            )} tuag at fod yn aelod o'r Cynllun Pensiwn Buddion wedi'i Ddiffinio'r Gwasanaeth Sifil. Darganfyddwch pa fuddion y mae'r Pensiwn y Gwasanaeth Sifil yn eu darparu.""".stripMargin
        benefitsLinkText.getText    shouldEqual "Darganfyddwch pa fuddion y mae'r Pensiwn y Gwasanaeth Sifil yn eu darparu."
        benefitsPensionLink         shouldEqual "https://www.civilservicepensionscheme.org.uk/joining-the-pension-scheme/benefits-of-the-pension-scheme/"
      }
    } else {
      val benefitsPensionInfo =
        driver.findElements(By.xpath(if (!v9RunInWelsh) benefitsPensionTextPath else welshBenefitsPensionTextPath))
      benefitsPensionInfo shouldBe empty
    }

  def confirmSalaryAndBenefitSectionsInEnglish(): Unit = {
    confirmSalaryDetails()
    confirmSalaryMoreDetails()
    confirmPensionContributionRate()
    confirmBenefitsSectionText()
  }

  def confirmSalaryAndBenefitSectionsInWelsh(): Unit = {
    v9RunInWelsh = true
    waitForVisibilityOfElementByPath(changeToWelsh).click()
    confirmSalaryDetails()
    confirmSalaryMoreDetails()
    confirmPensionContributionRate()
    confirmBenefitsSectionText()
    waitForVisibilityOfElementByPath(changeToEnglish).click()
    v9RunInWelsh = false
  }
}
