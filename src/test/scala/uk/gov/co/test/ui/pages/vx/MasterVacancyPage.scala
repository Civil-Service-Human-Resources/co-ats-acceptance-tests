package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class MasterVacancyDetails(
  template: String,
  vacancyTitle: String,
  closingDate: Int,
  displayWelsh: Boolean,
  department: String,
  businessArea: String,
  businessAreaDetail: String,
  typeOfRole: String,
  whichProfession: String,
  noOfJobs: String,
  approach: String,
  statementRequired: Boolean,
  statement: String,
  approval: Boolean,
  budgetaryAuthInfo: String,
  costCentre: String,
  reserveList: Boolean,
  reserveListLength: String,
  locationType: String,
  postcodes: String,
  cityOrTown: String,
  region: String,
  overseas: String,
  locationOverride: String,
  vacancyInNIR: Boolean,
  openOutsideNIR: Boolean,
  whichCommunityEncouraged: String,
  giveLocationPreference: Boolean,
  maxLocations: String,
  otherCityOrTown: String,
  contractType: String,
  workingPattern: String,
  jobGrade: String,
  equivalentGrade: String,
  currency: String,
  minimumSalary: Int,
  maximumSalary: Int,
  moreDetails: String,
  civilServicePension: Boolean,
  employerContribution: Int,
  jobSummary: String,
  jobDescription: String,
  personSpecification: String,
  offeredBenefits: String,
  selectionProcess: String,
  contactName: String,
  contactEmail: String,
  contactPhone: String,
  vacancyHolderName: String,
  vacancyHolderEmail: String,
  vacancyTeamEmail: String
)

object MasterVacancyPage extends VacancyBasePage {

  private lazy val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"
  private var formId: String          = ""

  private lazy val displayWelshPath               = ".//input[@name='datafield_179408_1_1']"
  private lazy val closingDateId                  = "edit_opp_form_pcd"
  private lazy val selectTemplatePath             = "//*[@id='select2-edit_opp_form_template_id-container']"
  private lazy val enterTemplatePath              = ".//input[@class='select2-search__field']"
  private lazy val newVacancyPath                 = ".//a[contains(@href,'recruiter/opportunities/vacancy/create')]"
  private lazy val vacancySectionPath             = "//*[@id='lm-vacancies']/h3/a"
  private lazy val extractFormClass               = "opp_form_bd"
  private lazy val businessAreaId                 = s"select2-${formId}_datafield_155221_1_1-container"
  private lazy val whichProfessionId              = s"select2-${formId}_datafield_155435_1_1-container"
  private lazy val noOfJobsId                     = s"${formId}_datafield_155332_1_1"
  private lazy val typeOfRoleId                   = s"select2-${formId}_datafield_155369_1_1-container"
  private lazy val typeOfRoleInput                = s".//*[@aria-describedby='$typeOfRoleId']"
  private lazy val welshRequiredCheck             = s"${formId}_datafield_179408_1_1"
  private lazy val businessAreaDetailId           = s"${formId}_datafield_155206_1_1_en-GB"
  private lazy val approachId                     = s"${formId}_field_154380_1"
  private lazy val statementId                    = s"${formId}_datafield_154373_1_1_en-GB"
  private lazy val prereleaseId                   = s"${formId}_datafield_154380_1_1_12648"
  private lazy val internalId                     = s"${formId}_datafield_154380_1_1_11773"
  private lazy val acrossGovernmentId             = s"${formId}_datafield_154380_1_1_12649"
  private lazy val acrossGovernmentYesStatementId = s"${formId}_datafield_154384_1_1_1"
  private lazy val acrossGovernmentNoStatementId  = s"${formId}_datafield_154384_1_1_2"
  private lazy val externalId                     = s"${formId}_datafield_154380_1_1_11774"
  private lazy val internalYesStatementId         = s"${formId}_datafield_154388_1_1_1"
  private lazy val internalNoStatementId          = s"${formId}_datafield_154388_1_1_2"
  private lazy val budgetaryInfoId                = s"${formId}_datafield_154500_1_1"
  private lazy val costCentreId                   = s"${formId}_datafield_154493_1_1"
  private lazy val approvalId                     = s"${formId}_field_154507_1"
  private lazy val approvalYesId                  = s"${formId}_datafield_154507_1_1_1"
  private lazy val approvalNoId                   = s"${formId}_datafield_154507_1_1_2"
  private lazy val reserveListId                  = s"${formId}_field_154633_1"
  private lazy val reserveListYesId               = s"${formId}_datafield_154633_1_1_1"
  private lazy val reserveListNoId                = s"${formId}_datafield_154633_1_1_2"
  private lazy val reserveListLengthId            = s"select2-${formId}_datafield_154637_1_1-container"
  private lazy val generalInput                   = "//input[@class='select2-search__field']"
  private lazy val cityOrTownInput                = s".//*[@aria-describedby='select2-${formId}_datafield_155622_1_1-container']"
  private lazy val otherCityOrTownInput           = s".//*[@aria-describedby='select2-${formId}_datafield_155836_1_1-container']"
  private lazy val locationTypeId                 = s"select2-${formId}_datafield_155639_1_1-container"
  private lazy val overseasId                     = s"select2-${formId}_datafield_155904_1_1-container"
  private lazy val regionInput                    = s".//*[@aria-describedby='select2-${formId}_datafield_155584_1_1-container']"
  private lazy val postcodeId                     = s"${formId}_datafield_155601_1_1"
  private lazy val northernIrelandId              = s"${formId}_datafield_155854_1_1_fieldset"
  private lazy val northernIrelandYesId           = s"${formId}_datafield_155854_1_1_1"
  private lazy val northernIrelandNoId            = s"${formId}_datafield_155854_1_1_2"
  private lazy val outsideNIRYesId                = s"${formId}_datafield_155922_1_1_1"
  private lazy val outsideNIRNoId                 = s"${formId}_datafield_155922_1_1_1"
  private lazy val protestantId                   = s"${formId}_datafield_155869_1_1_15462"
  private lazy val romanCatholicId                = s"${formId}_datafield_155869_1_1_15463"
  private lazy val allCommunitiesId               = s"${formId}_datafield_155869_1_1_17360"
  private lazy val locationOverrideInput          = s"${formId}_datafield_155654_1_1_en-GB"
  private lazy val locationPreferenceNoId         = s"${formId}_datafield_155799_1_1_2"
  private lazy val locationPreferenceYesId        = s"${formId}_datafield_155799_1_1_1"
  private lazy val maxLocationId                  = s"select2-${formId}_datafield_155818_1_1-container"
  private lazy val contractTypeId                 = s"select2-${formId}_datafield_154977_1_1-container"
  private lazy val currencyId                     = s"select2-${formId}_datafield_155065_1_1-container"
  private lazy val workingPatternId               = s"select2-${formId}_datafield_154969_1_1-container"
  private lazy val jobGradeId                     = s"select2-${formId}_datafield_154973_1_1-container"
  private lazy val contractTypeInput              = s".//*[@aria-describedby='$contractTypeId']"
  private lazy val workingPatternInput            = s".//*[@aria-describedby='$workingPatternId']"
  private lazy val jobGradeInput                  = s".//*[@aria-describedby='$jobGradeId']"
  private lazy val equivalentGradeId              = s"${formId}_datafield_154981_1_1_en-GB"
  private lazy val minimumSalaryId                = s"${formId}_datafield_155044_1_1"
  private lazy val maximumSalaryId                = s"${formId}_datafield_155051_1_1"
  private lazy val moreDetailsId                  = s"${formId}_datafield_155058_1_1_en-GB"
  private lazy val civilServiceId                 = s"${formId}_field_value_198564_1"
  private lazy val civilServicePensionYesId       = s"${formId}_datafield_198564_1_1_1"
  private lazy val civilServicePensionNoId        = s"${formId}_datafield_198564_1_1_2"
  private lazy val employerContributionInput      = s"${formId}_datafield_198577_1_1"
  private lazy val jobSummaryId                   = s"${formId}_datafield_51753_1_1_en-GB_ifr"
  private lazy val jobDescriptionId               = s"${formId}_field_value_51761_1"
  private lazy val personSpecsIframe              = s"${formId}_datafield_51767_1_1_en-GB_ifr"
  private lazy val offeredBenefitsIframe          = s"${formId}_datafield_62219_1_1_en-GB_ifr"
  private lazy val selectionProcessIframe         = s"${formId}_datafield_59678_1_1_en-GB_ifr"
  private lazy val jobSummaryPath                 = s".//body[@data-id='${formId}_datafield_51753_1_1_en-GB']"
  private lazy val jobDescriptionPath             = s".//body[@data-id='${formId}_datafield_51761_1_1_en-GB']"
  private lazy val personSpecsPath                = s".//body[@data-id='${formId}_datafield_51767_1_1_en-GB']"
  private lazy val offeredBenefitsPath            = s".//body[@data-id='${formId}_datafield_62219_1_1_en-GB']"
  private lazy val selectionProcessPath           = s".//body[@data-id='${formId}_datafield_59678_1_1_en-GB']"
  private lazy val jobSummaryIframe               = s"${formId}_datafield_51753_1_1_en-GB_ifr"
  private lazy val jobDescriptionIframe           = s"${formId}_datafield_51761_1_1_en-GB_ifr"
  private lazy val contactNameId                  = s"${formId}_field_value_59444_1"
  private lazy val contactEmailInput              = s"${formId}_datafield_59457_1_1"
  private lazy val vacancyHolderNameId            = s"${formId}_field_value_115926_1"
  private lazy val contactNameInput               = s"${formId}_datafield_59444_1_1"
  private lazy val contactPhoneInput              = s"${formId}_datafield_101571_1_1"
  private lazy val vacancyHolderNameInput         = s"${formId}_datafield_115926_1_1"
  private lazy val vacancyHolderEmailInput        = s"${formId}_datafield_115708_1_1"
  private lazy val vacancyTeamEmailInput          = s"${formId}_datafield_59450_1_1"

  private def displayWelshVersion(): WebElement = waitForVisibilityOfElementByPath(displayWelshPath)
  private def title(): TextField                = textField("title")
  private def closingDate(): TextField          = textField(closingDateId)
  private def templateSelect: WebElement        = waitForVisibilityOfElementByPath(selectTemplatePath)
  private def enterTemplate: WebElement         = waitForVisibilityOfElementByPath(enterTemplatePath)
  private def newVacancy: WebElement            = waitForVisibilityOfElementByPathLast(newVacancyPath)
  private def vacancySection: WebElement        = waitForVisibilityOfElementByPathLast(vacancySectionPath)

  private def selectTemplate(masterVacancyDetails: MasterVacancyDetails): Unit = {
    templateSelect.click()
    enterTemplate.sendKeys(masterVacancyDetails.template)
    enterTemplate.sendKeys(Keys.ENTER)
  }

  private def enterVacancyTitle(masterVacancyDetails: MasterVacancyDetails): Unit =
    title().value = masterVacancyDetails.vacancyTitle

  private def selectClosingDate(masterVacancyDetails: MasterVacancyDetails): Unit =
    closingDate().value = appClosingDate(masterVacancyDetails.closingDate)

  def createNewVacancy(): Unit = {
    if (newVacancy.getText == "Create New Vacancy") newVacancy.click()
    else {
      vacancySection.click()
      newVacancy.click()
    }
    eventually(onPage(createVacancyTitle))
  }

  private def appClosingDate(days: Int): String = {
    val formatter   = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val now         = LocalDate.now()
    val addDays     = now.plusDays(days)
    val closingDate = addDays.format(formatter)
    closingDate
  }

  private def extractFormId(): String = {
    waitForTemplateLoad()
    val formClass = driver.findElement(By.className(extractFormClass))
    formId = formClass.getAttribute("id")
    formId
  }

  private def waitForTemplateLoad(): Unit =
    displayWelshVersion()

  private val basicInfo: Seq[MasterVacancyDetails => Unit] = Seq(
    selectTemplate,
    enterVacancyTitle,
    selectClosingDate
  )

  def basicDetailsSection(masterVacancyDetails: MasterVacancyDetails): Unit = {
    basicInfo.foreach { f =>
      f(masterVacancyDetails)
    }
    extractFormId()
  }

  private def selectWelshVersion(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.displayWelsh) checkbox(welshRequiredCheck).select()

  private def selectBusinessArea(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(businessAreaId))
    waitForVisibilityOfElementById(businessAreaId).click()
    selectOption(generalInput, masterVacancyDetails.businessArea)
  }

  private def enterBusinessAreaDetail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val businessDetailsInput = waitForVisibilityOfElementById(businessAreaDetailId)
    businessDetailsInput.sendKeys(masterVacancyDetails.businessAreaDetail)
  }

  private def selectTypeOfRole(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(typeOfRoleId))
    selectOption(typeOfRoleInput, masterVacancyDetails.typeOfRole)
  }

  private def whichProfessionIsJob(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(whichProfessionId))
    waitForVisibilityOfElementById(whichProfessionId).click()
    selectOption(generalInput, masterVacancyDetails.whichProfession)
  }

  private def noOfJobsAvailable(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val noOfJobsInput = textField(noOfJobsId)
    noOfJobsInput.value = masterVacancyDetails.noOfJobs
  }

  private val jobInfo: Seq[MasterVacancyDetails => Unit] = Seq(
    selectWelshVersion,
    selectBusinessArea,
    enterBusinessAreaDetail,
    selectTypeOfRole,
    whichProfessionIsJob,
    noOfJobsAvailable
  )

  def jobInformationSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    jobInfo.foreach { f =>
      f(masterVacancyDetails)
    }

  private def eligibilityStatement(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val statement = waitForVisibilityOfElementById(statementId)
    statement.sendKeys(masterVacancyDetails.statement)
  }

  private def selectApproach(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(approachId))
    masterVacancyDetails.approach match {
      case "Pre-release"       => clickOnRadioButton(prereleaseId)
      case "Internal"          => clickOnRadioButton(internalId)
      case "Across government" => clickOnRadioButton(acrossGovernmentId)
      case "External"          => clickOnRadioButton(externalId)
      case _                   => throw new IllegalStateException("Please select valid 'Approach' option")
    }
  }

  private def selectStatementRequired(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (
      (masterVacancyDetails.approach == "Internal" || masterVacancyDetails.approach == "Across government") && masterVacancyDetails.statementRequired
    ) {
      masterVacancyDetails.approach match {
        case "Internal"          => clickOnRadioButton(internalYesStatementId)
        case "Across government" => clickOnRadioButton(acrossGovernmentYesStatementId)
      }
      eligibilityStatement(masterVacancyDetails)
    } else if (
      (masterVacancyDetails.approach == "Internal" || masterVacancyDetails.approach == "Across government") && !masterVacancyDetails.statementRequired
    ) {
      masterVacancyDetails.approach match {
        case "Internal"          => clickOnRadioButton(internalNoStatementId)
        case "Across government" => clickOnRadioButton(acrossGovernmentNoStatementId)
      }
    }

  private val approach: Seq[MasterVacancyDetails => Unit] = Seq(
    selectApproach,
    selectStatementRequired
  )

  def approachSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    approach.foreach { f =>
      f(masterVacancyDetails)
    }

  private def budgetaryInfo(info: String): Unit = {
    val field = waitForVisibilityOfElementById(budgetaryInfoId)
    field.sendKeys(info)
  }

  private def costCentre(centre: String): Unit = {
    val field = waitForVisibilityOfElementById(costCentreId)
    field.sendKeys(centre)
  }

  private def selectApproval(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(approvalId))
    if (masterVacancyDetails.approval) {
      clickOnRadioButton(approvalYesId)
      budgetaryInfo(masterVacancyDetails.budgetaryAuthInfo)
    } else {
      clickOnRadioButton(approvalNoId)
    }
    costCentre(masterVacancyDetails.costCentre)
  }

  private val approval: Seq[MasterVacancyDetails => Unit] = Seq(
    selectApproval
  )

  def approvalSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    approval.foreach { f =>
      f(masterVacancyDetails)
    }

  def selectReserveList(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(reserveListId))
    if (masterVacancyDetails.reserveList) {
      clickOnRadioButton(reserveListYesId)
      lengthOfReserveList(masterVacancyDetails.reserveListLength)
    } else {
      clickOnRadioButton(reserveListNoId)
    }
  }

  def lengthOfReserveList(length: String): Unit = {
    waitForVisibilityOfElementById(reserveListLengthId).click()
    action().moveToElement(waitForDropdownOption(length)).perform()
    waitForDropdownOption(length).click()
  }

  private val reserve: Seq[MasterVacancyDetails => Unit] = Seq(
    selectReserveList
  )

  def reserveListSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    reserve.foreach { f =>
      f(masterVacancyDetails)
    }

  def selectVacancyInNIR(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(northernIrelandId))
    if (masterVacancyDetails.vacancyInNIR) {
      clickOnRadioButton(northernIrelandYesId)
      selectVacancyOutsideNIR(masterVacancyDetails)
      selectWhichCommunity(masterVacancyDetails)
    } else {
      clickOnRadioButton(northernIrelandNoId)
    }
  }

  def selectVacancyOutsideNIR(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.openOutsideNIR) {
      clickOnRadioButton(outsideNIRYesId)
    } else {
      clickOnRadioButton(outsideNIRNoId)
    }

  def selectWhichCommunity(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.whichCommunityEncouraged match {
      case "Protestant"      => clickOnRadioButton(protestantId)
      case "Roman Catholic"  => clickOnRadioButton(romanCatholicId)
      case "All communities" => clickOnRadioButton(allCommunitiesId)
    }

  def locationType(locationType: String): Unit = {
    waitForVisibilityOfElementById(locationTypeId).click()
    action().moveToElement(waitForDropdownOption(locationType)).perform()
    waitForDropdownOption(locationType).click()
  }

  def enterPostcodes(postcodes: String): Unit = {
    val field = waitForVisibilityOfElementById(postcodeId)
    field.sendKeys(postcodes)
  }

  def chooseMaxLocations(maxLocation: String): Unit = {
    waitForVisibilityOfElementById(maxLocationId).click()
    action().moveToElement(waitForDropdownOption(maxLocation)).perform()
    waitForDropdownOption(maxLocation).click()
  }

  def waitForCityOrTownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[text()='$option ']")

  def selectCityOrTown(cityTown: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(cityOrTownInput)
    selectOption.sendKeys(cityTown)
    action().moveToElement(waitForCityOrTownOption(cityTown)).perform()
    waitForCityOrTownOption(cityTown).click()
  }

  def selectOtherCityOrTown(otherCityTown: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(otherCityOrTownInput)
    selectOption.sendKeys(otherCityTown)
    action().moveToElement(waitForCityOrTownOption(otherCityTown)).perform()
    waitForCityOrTownOption(otherCityTown).click()

    selectOption.sendKeys("Southampton")
    action().moveToElement(waitForCityOrTownOption("Southampton")).perform()
    waitForCityOrTownOption("Southampton").click()
  }

  def selectRegion(region: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(regionInput)
    selectOption.sendKeys(region)
    action().moveToElement(waitForDropdownOption(region)).perform()
    waitForDropdownOption(region).click()
  }

  def selectOverseas(country: String): Unit = {
    waitForVisibilityOfElementById(overseasId).click()
    selectOption(generalInput, country)
  }

  def locationOverride(overrideLocations: String): Unit =
    textField(locationOverrideInput).value = overrideLocations

  def selectLocationPreference(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.giveLocationPreference) {
      clickOnRadioButton(locationPreferenceYesId)
      chooseMaxLocations(masterVacancyDetails.maxLocations)
      selectOtherCityOrTown(masterVacancyDetails.otherCityOrTown)
    } else {
      clickOnRadioButton(locationPreferenceNoId)
    }

  def selectLocationType(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(locationTypeId))
    locationType(masterVacancyDetails.locationType)
    masterVacancyDetails.locationType match {
      case "Postcodes" => enterPostcodes(masterVacancyDetails.postcodes)
      case "Towns"     => selectCityOrTown(masterVacancyDetails.cityOrTown)
      case "Regions"   => selectRegion(masterVacancyDetails.region)
      case "Overseas"  => selectOverseas(masterVacancyDetails.overseas)
    }
    locationOverride(masterVacancyDetails.locationOverride)
  }

  private val locations: Seq[MasterVacancyDetails => Unit] = Seq(
    selectLocationType,
    selectVacancyInNIR,
    selectLocationPreference
  )

  def locationsSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    locations.foreach { f =>
      f(masterVacancyDetails)
    }

  private def selectContractType(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(contractTypeId))
    selectOption(contractTypeInput, masterVacancyDetails.contractType)
  }

  private def selectWorkingPattern(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(workingPatternId))
    selectOption(workingPatternInput, masterVacancyDetails.workingPattern)
  }

  private def selectJobGrade(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(jobGradeId))
    selectOption(jobGradeInput, masterVacancyDetails.jobGrade)
  }

  private def enterEquivalentGrade(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val equivalentGrade = textField(equivalentGradeId)
    equivalentGrade.value = masterVacancyDetails.equivalentGrade
  }

  def waitForDropdownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$option']")

  def selectCurrency(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(currencyId))
    waitForVisibilityOfElementById(currencyId).click()
    action().moveToElement(waitForDropdownOption(masterVacancyDetails.currency)).perform()
    waitForDropdownOption(masterVacancyDetails.currency).click()
  }

  private def enterMinimumSalary(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val minSalary = textField(minimumSalaryId)
    minSalary.value = masterVacancyDetails.minimumSalary.toString
  }

  private def enterMaximumSalary(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val maxSalary = textField(maximumSalaryId)
    maxSalary.value = masterVacancyDetails.maximumSalary.toString
  }

  private def enterMoreDetails(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val moreDetails = textField(moreDetailsId)
    moreDetails.value = masterVacancyDetails.moreDetails
  }

  def selectCivilServicePension(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(civilServiceId))
    if (masterVacancyDetails.civilServicePension) {
      clickOnRadioButton(civilServicePensionYesId)
      enterEmployerContribution(masterVacancyDetails.employerContribution)
    } else {
      clickOnRadioButton(civilServicePensionNoId)
    }
  }

  private def enterEmployerContribution(contribution: Int): Unit = {
    val con = textField(employerContributionInput)
    con.value = contribution.toString
  }

  private val contract: Seq[MasterVacancyDetails => Unit] = Seq(
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

  def contractDetailsSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    contract.foreach { f =>
      f(masterVacancyDetails)
    }

  private def switchBack(): Unit = driver.switchTo().defaultContent()

  private def enterJobSummary(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(jobSummaryId))
    val switchFrame = driver.switchTo().frame(jobSummaryIframe)
    val summaryArea = switchFrame.findElement(By.xpath(jobSummaryPath))
    summaryArea.sendKeys(masterVacancyDetails.jobSummary)
    switchBack()
  }

  private def enterJobDescription(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(jobDescriptionId))
    val switchFrame = driver.switchTo().frame(jobDescriptionIframe)
    val summaryArea = switchFrame.findElement(By.xpath(jobDescriptionPath))
    summaryArea.sendKeys(masterVacancyDetails.jobDescription)
    switchBack()
  }

  private def enterPersonSpecs(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(personSpecsIframe))
    val switchFrame = driver.switchTo().frame(personSpecsIframe)
    val summaryArea = switchFrame.findElement(By.xpath(personSpecsPath))
    summaryArea.sendKeys(masterVacancyDetails.personSpecification)
    switchBack()
  }

  private def enterOfferedBenefits(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(offeredBenefitsIframe))
    val switchFrame = driver.switchTo().frame(offeredBenefitsIframe)
    val summaryArea = switchFrame.findElement(By.xpath(offeredBenefitsPath))
    if (!summaryArea.getText.contains("Learning")) {
      summaryArea.sendKeys(masterVacancyDetails.offeredBenefits)
    }
    switchBack()
  }

  private def enterSelectionProcess(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(selectionProcessIframe))
    val switchFrame = driver.switchTo().frame(selectionProcessIframe)
    val summaryArea = switchFrame.findElement(By.xpath(selectionProcessPath))
    summaryArea.sendKeys(masterVacancyDetails.selectionProcess)
    switchBack()
  }

  private val advert: Seq[MasterVacancyDetails => Unit] = Seq(
    enterJobSummary,
    enterJobDescription,
    enterPersonSpecs,
    enterOfferedBenefits,
    enterSelectionProcess
  )

  def advertSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    advert.foreach { f =>
      f(masterVacancyDetails)
    }

  private def enterContactName(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(contactNameId))
    val name = textField(contactNameInput)
    name.value = masterVacancyDetails.contactName
  }

  private def enterContactEmail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val name = textField(contactEmailInput)
    name.value = masterVacancyDetails.contactEmail
  }

  private def enterContactPhone(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val name = textField(contactPhoneInput)
    name.value = masterVacancyDetails.contactPhone
  }

  private def enterVacancyHolderName(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(vacancyHolderNameId))
    val name = textField(vacancyHolderNameInput)
    name.value = masterVacancyDetails.vacancyHolderName
  }

  private def enterVacancyHolderEmail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val name = textField(vacancyHolderEmailInput)
    name.value = masterVacancyDetails.vacancyHolderEmail
  }

  private def enterVacancyTeamEmail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val teamEmailField = driver.findElement(By.id(vacancyTeamEmailInput))
    val teamEmailValue = teamEmailField.getAttribute("value")
    if (teamEmailValue.nonEmpty) {
      if (!getOs.contains("mac")) {
        teamEmailField.sendKeys(Keys.CONTROL, "a")
      } else {
        teamEmailField.sendKeys(Keys.COMMAND, "a")
      }
      teamEmailField.sendKeys(Keys.BACK_SPACE)
    }
    teamEmailField.sendKeys(masterVacancyDetails.vacancyTeamEmail)
  }

  private val contactInfo: Seq[MasterVacancyDetails => Unit] = Seq(
    enterContactName,
    enterContactEmail,
    enterContactPhone,
    enterVacancyHolderName,
    enterVacancyHolderEmail,
    enterVacancyTeamEmail
  )

  def contactDetailsSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    contactInfo.foreach { f =>
      f(masterVacancyDetails)
    }
}
