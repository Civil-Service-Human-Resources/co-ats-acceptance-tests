package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXJobGradeEquivalent, vXJobGrades, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

case class ContractDetails(
  contractType: List[String],
  employmentLengthDetails: String,
  addWelshEmploymentLength: Boolean,
  welshEmploymentLengthText: String,
  workingPattern: List[String],
  jobGrade: ListBuffer[String],
  equivalentGrade: String,
  currency: String,
  minimumSalary: Int,
  maximumSalary: Int,
  moreDetails: String,
  civilServicePension: Boolean,
  employerContribution: Int
)

object ContractDetailsSection extends VacancyBasePage {

  def contractDetailsSectionId     = s"${vacancyFormId}_section_154771_col_0"
  def currencyId                   = s"select2-${vacancyFormId}_datafield_155065_1_1-container"
  def workingPatternId             = s"select2-${vacancyFormId}_datafield_154969_1_1-container"
  def jobGradeId                   = s"select2-${vacancyFormId}_datafield_154973_1_1-container"
  def contractTypeId               = s"select2-${vacancyFormId}_datafield_154977_1_1-container"
  def lengthOfEmploymentInput      = s"${vacancyFormId}_datafield_154962_1_1_en-GB"
  def addWelshEmploymentLengthId() = "clicky_154962"
  def welshEmploymentLengthInput   = "datafield_154962_1_1_cy"
  def updateWelshLengthId()        = "lbledit_datafield_154962_1_1-update"
  def jobGradeInput                = s".//*[@aria-describedby='$jobGradeId']"
  def equivalentGradeId            = s"${vacancyFormId}_datafield_154981_1_1_en-GB"
  def minimumSalaryId              = s"${vacancyFormId}_datafield_155044_1_1"
  def maximumSalaryId              = s"${vacancyFormId}_datafield_155051_1_1"
  def moreDetailsId                = s"${vacancyFormId}_datafield_155058_1_1_en-GB"
  def civilServiceId               = s"${vacancyFormId}_field_value_198564_1"
  def civilServicePensionYesId     = s"${vacancyFormId}_datafield_198564_1_1_1"
  def civilServicePensionNoId      = s"${vacancyFormId}_datafield_198564_1_1_2"
  def employerContributionInput    = s"${vacancyFormId}_datafield_198577_1_1"

  private def selectContractType(contractDetails: ContractDetails): Unit = {
    val typeRequiresLength: Seq[String] = List("Temporary", "Fixed Term Appointment", "Loan", "Secondment")
    scrollToElement(By.id(contractDetailsSectionId))
    val contractType                    = contractDetails.contractType
    enterRoles(contractType, contractTypeId)
    if (contractType.intersect(typeRequiresLength).nonEmpty) {
      val length = waitForVisibilityOfElementById(lengthOfEmploymentInput)
      length.clear()
      length.sendKeys(contractDetails.employmentLengthDetails)
      addWelshTranslation(
        contractDetails.addWelshEmploymentLength,
        addWelshEmploymentLengthId(),
        welshEmploymentLengthInput,
        contractDetails.welshEmploymentLengthText,
        updateWelshLengthId()
      )
    }
  }

  private def selectWorkingPattern(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(workingPatternId))
    enterRoles(contractDetails.workingPattern, workingPatternId)
  }

  private def selectJobGrade(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(jobGradeId))
    vXJobGrades = contractDetails.jobGrade
    enterTypeRoles(vXJobGrades, jobGradeInput)
  }
  private def enterEquivalentGrade(contractDetails: ContractDetails): Unit = {
    vXJobGradeEquivalent = contractDetails.equivalentGrade
    val equivalentGrade = textField(equivalentGradeId)
    equivalentGrade.value = vXJobGradeEquivalent
  }

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
