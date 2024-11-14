package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import org.scalatest.TestData
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9RunInWelsh, vXJobGradeEquivalent, vXJobGrades, vacancyFormId, vacancyId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.{VacancyBasePage, VacancyDetailsPage}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.{extractAllApplyOnlyVacancyDetails, navigateToVacancyForms, searchForVacancy}
import uk.gov.co.test.ui.pages.vx.createvacancypage.ReserveListSection.approveForPublicationMessageId

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

  def contractDetailsSectionId               = s"${vacancyFormId}_section_154771_col_0"
  def currencyId                             = s"select2-${vacancyFormId}_datafield_155065_1_1-container"
  def workingPatternId                       = s"select2-${vacancyFormId}_datafield_154969_1_1-container"
  def jobGradeId                             = s"select2-${vacancyFormId}_datafield_154973_1_1-container"
  def contractTypeId                         = s"select2-${vacancyFormId}_datafield_154977_1_1-container"
  def lengthOfEmploymentInput                = s"${vacancyFormId}_datafield_154962_1_1_en-GB"
  def addWelshEmploymentLengthId()           = "clicky_154962"
  def welshEmploymentLengthInput             = "datafield_154962_1_1_cy"
  def updateWelshLengthId()                  = "lbledit_datafield_154962_1_1-update"
  def equivalentGradeId                      = s"${vacancyFormId}_datafield_154981_1_1_en-GB"
  def scsAssignmentDurationId                = s"select2-${vacancyFormId}_datafield_179266_1_1-container"
  def reasonForAssignmentDurationId          = s"select2-${vacancyFormId}_datafield_179270_1_1-container"
  def minimumSalaryId                        = s"${vacancyFormId}_datafield_155044_1_1"
  def maximumSalaryId                        = s"${vacancyFormId}_datafield_155051_1_1"
  def moreDetailsId                          = s"${vacancyFormId}_datafield_155058_1_1_en-GB"
  def civilServiceId                         = s"${vacancyFormId}_field_value_198564_1"
  def civilServicePensionYesId               = s"${vacancyFormId}_datafield_198564_1_1_1"
  def civilServicePensionNoId                = s"${vacancyFormId}_datafield_198564_1_1_2"
  def employerContributionInput              = s"${vacancyFormId}_datafield_198577_1_1"
  def welshAddTranslationSalaryMoreDetailsId = "clicky_155058"
  def welshSalaryMoreDetailsId               = "datafield_155058_1_1_cy"
  def updateWelshSalaryMoreDetailsId         = "lbledit_datafield_155058_1_1-update"

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
    enterTypeRoles(vXJobGrades, jobGradeId)
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

  def scsAssignmentDuration(duration: String): Unit = {
    scrollToElement(By.id(scsAssignmentDurationId))
    waitForVisibilityOfElementById(scsAssignmentDurationId).click()
    selectOption(generalInput, duration)
  }

  def reasonForAssignmentDuration(reason: String): Unit = {
    waitForVisibilityOfElementById(reasonForAssignmentDurationId).click()
    action().moveToElement(waitForDropdownOption(reason)).perform()
    waitForDropdownOption(reason).click()
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
    val moreDetails = waitForVisibilityOfElementById(moreDetailsId)
    moreDetails.sendKeys(contractDetails.moreDetails)
  }

  def selectCivilServicePension(contractDetails: ContractDetails): Unit = {
    scrollToElement(By.id(civilServiceId))
    if (contractDetails.civilServicePension) {
      clickOnRadioButton(civilServicePensionYesId)
    } else {
      clickOnRadioButton(civilServicePensionNoId)
    }
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

  private def changeSalaryMinimum(salaryMinimum: String): Unit = {
    textField(minimumSalaryId).clear()
    textField(minimumSalaryId).value = salaryMinimum
  }

  private def changeSalaryMaximum(salaryMaximum: Option[String] = None): Unit =
    if (salaryMaximum.isDefined) {
      textField(maximumSalaryId).clear()
      textField(maximumSalaryId).value = salaryMaximum.get
    } else {
      textField(maximumSalaryId).clear()
    }

//  private def changeSalaryMoreDetails(salaryMoreDetails: Option[String] = None): Unit =
//    if (salaryMoreDetails.isDefined) {
//      textField(moreDetailsId).clear()
//      textField(moreDetailsId).value = salaryMoreDetails.get
//    } else {
//      textField(moreDetailsId).clear()
//    }

  private def changeSalaryMoreDetails(salaryMoreDetails: Option[Boolean] = None): Unit =
    if (salaryMoreDetails.get) {
      textField(moreDetailsId).clear()
      textField(moreDetailsId).value = "Autotest - salary more details"
      addWelshTranslation(
        addWelsh = true,
        welshAddTranslationSalaryMoreDetailsId,
        welshSalaryMoreDetailsId,
        "Awtomatiaeth - mwy o fanylion am gyflog",
        updateWelshSalaryMoreDetailsId
      )
    } else {
      textField(moreDetailsId).clear()
    }

  def changeSalaryAndOfferCSPensionDetails(
    jobGrades: ListBuffer[String],
    salaryMinimum: String,
    salaryMaximum: Option[String] = None,
    salaryMoreDetails: Option[Boolean] = None,
    offerCSPension: Boolean
  ): Unit = {
    searchForVacancy(vacancyId)
    navigateToVacancyForms()
    enterTypeRoles(jobGrades, jobGradeId)
    if (jobGrades.contains("SCS Pay Band 1")) {
      scsAssignmentDuration("six months")
      reasonForAssignmentDuration("Sourcing scarce skills")
    }
    changeSalaryMinimum(salaryMinimum)
    changeSalaryMaximum(salaryMaximum)
    changeSalaryMoreDetails(salaryMoreDetails)
    if (offerCSPension) clickOnRadioButton(civilServicePensionYesId) else clickOnRadioButton(civilServicePensionNoId)
    scrollToElement(By.id(submitForm))
    clickOn(submitForm)
    waitForVisibilityOfElementById(approveForPublicationMessageId).isDisplayed
    waitForDataSaved()
    searchForVacancy(vacancyId)
    navigateToVacancyForms()
    VacancyDetailsPage.contractDetails()
  }
}
