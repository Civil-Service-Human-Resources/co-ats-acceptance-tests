package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9BiometricPassportOrId, v9BiometricResidenceCard, v9EussStatus, v9IdvtDataConsent, v9InDateDrivingLicence, v9RtwBritishCitizen, v9RtwBritishIrishPassport, v9SmartphoneAccess, vXOfferCivilServicePension, vXSalaryMaximum, vXSalaryMinimum, vXSalaryMoreDetails, vacancyName}

import java.text.NumberFormat

object ApplicationDetailsPage extends CivilServiceJobsBasePage {

  val applicationsDetailsTitle    = s"$vacancyName - Civil Service Jobs - GOV.UK"
  val formatter: NumberFormat     = java.text.NumberFormat.getIntegerInstance
  val salaryPath                  = ".//*[contains(text(), 'Salary')]//..//*[@class='vac_display_field_value']"
  val salaryMoreDetailsPath       = "(//*[@class='vac_display_field_value'])[3]"
  val pensionContributionRatePath = "//div[starts-with(., 'A ')]"
  val benefitsSectionId           = "section_link_benefits"
  val benefitsPensionTextPath     = "//div[starts-with(., 'Alongside your salary of')]"

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
      waitForVacancyUpdate(salaryPath, s"£$formattedSalaryMin - £$formattedSalaryMax")
    } else {
      waitForVacancyUpdate(salaryPath, s"£$formattedSalaryMin")
    }
  }

  def confirmSalaryMoreDetails(): Unit =
    if (vXSalaryMoreDetails != "") {
      val salaryMoreDetails = waitForVisibilityOfElementByPath(salaryMoreDetailsPath).getText
      salaryMoreDetails shouldEqual s"$vXSalaryMoreDetails"
    }

  def confirmPensionContributionRate(): Unit =
    if (vXOfferCivilServicePension && vXSalaryMinimum != "0") {
      val pensionRate          = waitForVisibilityOfElementByPath(pensionContributionRatePath)
      val civilServiceLinkText = pensionRate.findElement(By.tagName("a"))
      val civilServiceLink     = civilServiceLinkText.getAttribute("href")
      pensionRate.getText          shouldEqual "A Civil Service Pension with an employer contribution of 28.97%"
      civilServiceLinkText.getText shouldEqual "Civil Service Pension"
      civilServiceLink             shouldEqual "https://www.civilservicepensionscheme.org.uk/joining-the-pension-scheme/benefits-of-the-pension-scheme/"
    } else {
      val checkForPensionInfo = driver.findElements(By.xpath(pensionContributionRatePath))
      checkForPensionInfo shouldBe empty
    }

  def confirmBenefitsSectionText(): Unit =
    if (vXOfferCivilServicePension && vXSalaryMinimum != "0") {
      val formattedSalaryMin                  = formatter.format(vXSalaryMinimum.toInt)
      def multiply(m: Int)(n: Double): Double = m * n
      val employeeContribution                = multiply(vXSalaryMinimum.toInt)(0.2897)
      val benefitsSectionText                 = waitForVisibilityOfElementByPath(benefitsPensionTextPath)
      val benefitsLinkText                    = benefitsSectionText.findElement(By.tagName("a"))
      val benefitsPensionLink                 = benefitsLinkText.getAttribute("href")
      benefitsSectionText.getText shouldEqual
        s"""Alongside your salary of £$formattedSalaryMin, Ofwat (Water Services Regulation Authority) contributes £${formatter
          .format(
            employeeContribution.toInt
          )} towards you being a member of the Civil Service Defined Benefit Pension scheme. Find out what benefits a Civil Service Pension provides.""".stripMargin
      benefitsLinkText.getText    shouldEqual "Find out what benefits a Civil Service Pension provides."
      benefitsPensionLink         shouldEqual "https://www.civilservicepensionscheme.org.uk/joining-the-pension-scheme/benefits-of-the-pension-scheme/"
    } else {
      val benefitsPensionInfo = driver.findElements(By.xpath(benefitsPensionTextPath))
      benefitsPensionInfo shouldBe empty
    }

  def confirmSalaryAndBenefitSections(): Unit = {
    confirmSalaryDetails()
    confirmSalaryMoreDetails()
    confirmPensionContributionRate()
    confirmBenefitsSectionText()
  }
}
