package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId
import uk.gov.co.test.ui.utils.NewVacancyDetails

case class ContractDetails(
  contractType: String,
  workingPattern: String,
  jobGrade: String,
  equivalentGrade: String,
  currency: String,
  minimumSalary: Int,
  maximumSalary: Int,
  moreDetails: String,
  civilServicePension: Boolean,
  employerContribution: Int
)

object ContractDetailsSection extends VacancyBasePage {

  private lazy val contractTypeId            = s"select2-${formId}_datafield_154977_1_1-container"
  private lazy val currencyId                = s"select2-${formId}_datafield_155065_1_1-container"
  private lazy val workingPatternId          = s"select2-${formId}_datafield_154969_1_1-container"
  private lazy val jobGradeId                = s"select2-${formId}_datafield_154973_1_1-container"
  private lazy val contractTypeInput         = s".//*[@aria-describedby='$contractTypeId']"
  private lazy val workingPatternInput       = s".//*[@aria-describedby='$workingPatternId']"
  private lazy val jobGradeInput             = s".//*[@aria-describedby='$jobGradeId']"
  private lazy val equivalentGradeId         = s"${formId}_datafield_154981_1_1_en-GB"
  private lazy val minimumSalaryId           = s"${formId}_datafield_155044_1_1"
  private lazy val maximumSalaryId           = s"${formId}_datafield_155051_1_1"
  private lazy val moreDetailsId             = s"${formId}_datafield_155058_1_1_en-GB"
  private lazy val civilServiceId            = s"${formId}_field_value_198564_1"
  private lazy val civilServicePensionYesId  = s"${formId}_datafield_198564_1_1_1"
  private lazy val civilServicePensionNoId   = s"${formId}_datafield_198564_1_1_2"
  private lazy val employerContributionInput = s"${formId}_datafield_198577_1_1"

  private def selectContractType(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(contractTypeId))
    selectOption(contractTypeInput, contractDetails.contractType)
  }

  private def selectWorkingPattern(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(workingPatternId))
    selectOption(workingPatternInput, contractDetails.workingPattern)
  }

  private def selectJobGrade(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(jobGradeId))
    selectOption(jobGradeInput, contractDetails.jobGrade)
  }
  private def enterEquivalentGrade(contractDetails: ContractDetails): Unit = {
    val equivalentGrade = textField(equivalentGradeId)
    equivalentGrade.value = contractDetails.equivalentGrade
  }

  def waitForDropdownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$option']")

  def selectCurrency(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(currencyId))
    waitForVisibilityOfElementById(currencyId).click()
    action().moveToElement(waitForDropdownOption(contractDetails.currency)).perform()
    waitForDropdownOption(contractDetails.currency).click()
  }

  private def enterMinimumSalary(contractDetails: ContractDetails): Unit = {
    val minSalary = textField(minimumSalaryId)
    minSalary.value = contractDetails.minimumSalary.toString
  }

  private def enterMaximumSalary(contractDetails: ContractDetails): Unit = {
    val maxSalary = textField(maximumSalaryId)
    maxSalary.value = contractDetails.maximumSalary.toString
  }

  private def enterMoreDetails(contractDetails: ContractDetails): Unit = {
    val moreDetails = textField(moreDetailsId)
    moreDetails.value = contractDetails.moreDetails
  }

  def selectCivilServicePension(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(civilServiceId))
    if (contractDetails.civilServicePension) {
      clickOnRadioButton(civilServicePensionYesId)
      enterEmployerContribution(contractDetails.employerContribution)
    } else {
      clickOnRadioButton(civilServicePensionNoId)
    }
  }

  private def enterEmployerContribution(contribution: Int): Unit = {
    val con = textField(employerContributionInput)
    con.value = contribution.toString
  }

  private val contractDetails: Seq[ContractDetails => Unit] = Seq(
    selectContractType,
    selectWorkingPattern,
    selectJobGrade,
    enterEquivalentGrade,
    selectCurrency,
    enterMinimumSalary,
    enterMaximumSalary,
    enterMoreDetails,
    selectCivilServicePension
  )

  def contractDetailsSection(newVacancyDetails: NewVacancyDetails): Unit =
    contractDetails.foreach { f =>
      f(newVacancyDetails.contractDetails)
    }
}
