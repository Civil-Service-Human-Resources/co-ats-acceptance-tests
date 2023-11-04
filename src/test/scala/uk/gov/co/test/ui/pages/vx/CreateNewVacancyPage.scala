package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class VacancyDetails(
  template: String,
  vacancyTitle: String,
  addDaysForClosingDate: Long,
  businessArea: String,
  typeOfRole: String,
  profession: String,
  noOfJobs: String,
  approach: String,
  statementRequired: Boolean,
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
  vacancyInNI: Boolean,
  giveLocationPreference: Boolean,
  contractType: String,
  workingPattern: String,
  jobGrade: String,
  currency: String,
  minSalary: Int,
  offerPension: Boolean,
  jobSummary: String,
  jobDescription: String,
  personSpec: String,
  selectionProcess: String,
  nameOfVacancyContact: String,
  emailOfVacancyContact: String,
  vacancyHolderName: String,
  vacancyHolderEmail: String,
  recruiterEmail: String
)

object CreateNewVacancyPage extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"
  var formId: String     = ""

  private lazy val businessAreaId      = s"select2-${formId}_datafield_155221_1_1-container"
  private lazy val whichProfessionId   = s"select2-${formId}_datafield_155435_1_1-container"
  private lazy val noOfJobsId          = s"${formId}_datafield_155332_1_1"
  private lazy val generalInput        = "//input[@class='select2-search__field']"
  private lazy val typeOfRoleId        = s"select2-${formId}_datafield_155369_1_1-container"
  private lazy val typeOfRoleInput     = s".//*[@aria-describedby='$typeOfRoleId']"
  private lazy val cityOrTownInput     = s".//*[@aria-describedby='select2-${formId}_datafield_155622_1_1-container']"
  private lazy val approachId          = s"${formId}_field_154380_1"
  private lazy val approvalId          = s"${formId}_field_154507_1"
  private lazy val reserveListId       = s"${formId}_field_154633_1"
  private lazy val reserveListLengthId = s"select2-${formId}_datafield_154637_1_1-container"
  private lazy val locationTypeId      = s"select2-${formId}_datafield_155639_1_1-container"
  private lazy val reserveLengthsId    = s".//ul[@id='select2-${formId}_datafield_154637_1_1-results']"
  private lazy val overseasId          = s"select2-${formId}_datafield_155904_1_1-container"
  private lazy val regionInput         = s".//*[@aria-describedby='select2-${formId}_datafield_155584_1_1-container']"

  def extractFormId(): String = {
    val formClass = driver.findElement(By.className("opp_form_bd"))
    formId = formClass.getAttribute("id")
    formId
  }

  def noOfJobsInput(): TextField = textField(noOfJobsId)

  def businessAreaList(ele: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$ele']")

  def displayWelshVersion(): WebElement =
    waitForVisibilityOfElementByPath(".//input[@name='datafield_179408_1_1']")

  def title(): TextField       = textField("title")
  def closingDate(): TextField = textField("edit_opp_form_pcd")
  def eligibilityStatement(): Unit = {
    val statement = waitForVisibilityOfElementById(s"${formId}_datafield_154373_1_1_en-GB")
    statement.sendKeys("Autotest")
  }

  def templateSelect: WebElement = waitForVisibilityOfElementByPath(
    "//*[@id='select2-edit_opp_form_template_id-container']"
  )
  def enterTemplate: WebElement  = waitForVisibilityOfElementByPath(".//input[@class='select2-search__field']")
  def newVacancy: WebElement     = waitForVisibilityOfElementByPathLast(
    ".//a[contains(@href,'recruiter/opportunities/vacancy/create')]"
  )
  def vacancySection: WebElement = waitForVisibilityOfElementByPathLast("//*[@id='lm-vacancies']/h3/a")

  def selectTemplate(vacancy: VacancyDetails): Unit = {
    templateSelect.click()
    enterTemplate.sendKeys(vacancy.template)
    enterTemplate.sendKeys(Keys.ENTER)
  }

  def enterVacancyTitle(vacancyDetails: VacancyDetails): Unit =
    title().value = vacancyDetails.vacancyTitle

  def selectClosingDate(vacancyDetails: VacancyDetails): Unit =
    closingDate().value = appClosingDate(vacancyDetails)

  def createNewVacancy(): Unit = {
    if (newVacancy.getText == "Create New Vacancy") newVacancy.click()
    else {
      vacancySection.click()
      newVacancy.click()
    }
    eventually(onPage(createVacancyTitle))
  }

  def appClosingDate(vacancyDetails: VacancyDetails): String = {
    val formatter   = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val now         = LocalDate.now()
    val addDays     = now.plusDays(vacancyDetails.addDaysForClosingDate)
    val closingDate = addDays.format(formatter)
    closingDate
  }

  def waitForTemplateLoad(): Unit = {
    displayWelshVersion()
    extractFormId()
  }

  def selectBusinessArea(vacancyDetails: VacancyDetails): Unit = {
    waitForTemplateLoad()
    scrollToElement(By.id(businessAreaId))
    waitForVisibilityOfElementById(businessAreaId).click()
    selectOption(generalInput, vacancyDetails.businessArea)
  }

  def selectTypeOfRole(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(typeOfRoleId))
    selectOption(typeOfRoleInput, vacancyDetails.typeOfRole)
  }

  def whichProfessionIsJob(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(whichProfessionId))
    waitForVisibilityOfElementById(whichProfessionId).click()
    selectOption(generalInput, vacancyDetails.profession)
  }

  def noOfJobsAvailable(vacancyDetails: VacancyDetails): Unit =
    noOfJobsInput().value = vacancyDetails.noOfJobs

  def budgetaryInfo(info: String): Unit = {
    val field = waitForVisibilityOfElementById(s"${formId}_datafield_154500_1_1")
    field.sendKeys(info)
  }

  def costCentre(centre: String): Unit = {
    val field = waitForVisibilityOfElementById(s"${formId}_datafield_154493_1_1")
    field.sendKeys(centre)
  }

  def selectApproach(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(approachId))
    vacancyDetails.approach match {
      case "Pre-release"       => clickOnRadioButton(s"${formId}_datafield_154380_1_1_12648")
      case "Internal"          => clickOnRadioButton(s"${formId}_datafield_154380_1_1_11773")
      case "Across government" => clickOnRadioButton(s"${formId}_datafield_154380_1_1_12649")
      case "External"          => clickOnRadioButton(s"${formId}_datafield_154380_1_1_11774")
      case _                   => throw new IllegalStateException("Please select valid 'Approach' option")
    }
  }

  private def selectStatementRequired(vacancyDetails: VacancyDetails): Unit =
    if (
      (vacancyDetails.approach == "Internal" || vacancyDetails.approach == "Across government") && vacancyDetails.statementRequired
    ) {
      vacancyDetails.approach match {
        case "Internal"          => clickOnRadioButton(s"${formId}_datafield_154388_1_1_1")
        case "Across government" => clickOnRadioButton(s"${formId}_datafield_154384_1_1_1")
      }
      eligibilityStatement()
    } else if (
      (vacancyDetails.approach == "Internal" || vacancyDetails.approach == "Across government") && !vacancyDetails.statementRequired
    ) {
      vacancyDetails.approach match {
        case "Internal"          => clickOnRadioButton(s"${formId}_datafield_154388_1_1_2")
        case "Across government" => clickOnRadioButton(s"${formId}_datafield_154384_1_1_2")
      }
    }

  def selectApproval(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(approvalId))
    if (vacancyDetails.approval) {
      clickOnRadioButton(s"${formId}_datafield_154507_1_1_1")
      budgetaryInfo(vacancyDetails.budgetaryAuthInfo)
    } else {
      clickOnRadioButton(s"${formId}_datafield_154507_1_1_2")
    }
    costCentre(vacancyDetails.costCentre)
  }

  def selectReserveList(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(reserveListId))
    if (vacancyDetails.reserveList) {
      clickOnRadioButton(s"${formId}_datafield_154633_1_1_1")
      lengthOfReserveList(vacancyDetails.reserveListLength)
    } else {
      clickOnRadioButton(s"${formId}_datafield_154633_1_1_2")
    }
  }

  def waitForDropdownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$option']")

  def lengthOfReserveList(length: String): Unit = {
    waitForVisibilityOfElementById(reserveListLengthId).click()
    action().moveToElement(waitForDropdownOption(length)).perform()
    waitForDropdownOption(length).click()
  }

  def locationType(locationType: String): Unit = {
    waitForVisibilityOfElementById(locationTypeId).click()
    action().moveToElement(waitForDropdownOption(locationType)).perform()
    waitForDropdownOption(locationType).click()
  }

  def selectLocationType(vacancyDetails: VacancyDetails): Unit = {
    scrollToElement(By.id(locationTypeId))
    locationType(vacancyDetails.locationType)
    vacancyDetails.locationType match {
      case "Postcodes" => enterPostcodes(vacancyDetails.postcodes)
      case "Towns"     => selectCityOrTown(vacancyDetails.cityOrTown)
      case "Regions"   => selectRegion(vacancyDetails.region)
      case "Overseas"  => selectOverseas(vacancyDetails.overseas)
    }
  }

  def enterPostcodes(postcode: String): Unit = {
    val field = waitForVisibilityOfElementById(s"${formId}_datafield_155601_1_1")
    field.sendKeys(postcode)
  }

  def waitForCityOrTownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[text()='$option ']")

  def waitForRegionOption(region: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[text()='$region']")

  def selectCityOrTown(cityTown: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(cityOrTownInput)
    selectOption.sendKeys(cityTown)
    action().moveToElement(waitForCityOrTownOption(cityTown)).perform()
    waitForCityOrTownOption(cityTown).click()
  }

  def selectRegion(region: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(regionInput)
    selectOption.sendKeys(region)
    action().moveToElement(waitForRegionOption(region)).perform()
    waitForRegionOption(region).click()
  }

  def selectOverseas(country: String): Unit = {
    waitForVisibilityOfElementById(overseasId).click()
    selectOption(generalInput, country)
  }

  def jobInformationSection(vacancyDetails: VacancyDetails): Unit = {
    selectBusinessArea(vacancyDetails)
    selectTypeOfRole(vacancyDetails)
    whichProfessionIsJob(vacancyDetails)
    noOfJobsAvailable(vacancyDetails)
  }

  def approachSection(vacancyDetails: VacancyDetails): Unit = {
    selectApproach(vacancyDetails)
    selectStatementRequired(vacancyDetails)
  }

  def approvalSection(vacancyDetails: VacancyDetails): Unit =
    selectApproval(vacancyDetails)

  def reserveListSection(vacancyDetails: VacancyDetails): Unit =
    selectReserveList(vacancyDetails)

  def locationsSection(vacancyDetails: VacancyDetails): Unit = {
    selectLocationType(vacancyDetails)
    println("Done!")
  }
}
