package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

object VacancyDetailsPage extends VacancyBasePage {

  private lazy val dashboardPageTitle      = "Home : Civil Service Jobs - GOV.UK"
  private lazy val previewAdvertButtonPath = ".//a[@aria-label='Preview advert ']"
  private lazy val searchVacanciesPath     = ".//*[@class='textlabel' and text() = 'Search Vacancies']"
  private lazy val vacancyFormsPath        = ".//*[@class='main-label' and text()='Vacancy Forms']"
  private lazy val searchPath              = "selected_option"
  private lazy val searchInput             = "search_input"
  private lazy val matchingOption          = "matching_options"
  private lazy val matchedOption           = ".//li[@class='qs_option active']/a/span[1]"
  private lazy val searchForId             = "search_button"
  private lazy val appIdPath               = ".//*[@class='app_id']"
  private lazy val vacancyNamePath         = ".//span[@class='obj_name']"
  private lazy val checkLabelPath          = ".//input[@checked='checked']/following-sibling::label"
  def departmentId                         = s"select2-${vacancyFormId}_datafield_155191_1_1-container"
  def businessAreaId                       = s"select2-${vacancyFormId}_datafield_155221_1_1-container"
  def whichProfessionId                    = s"select2-${vacancyFormId}_datafield_155435_1_1-container"
  def noOfJobsId                           = s"${vacancyFormId}_datafield_155332_1_1"
  def typeOfRoleId                         = s"select2-${vacancyFormId}_datafield_155369_1_1-container"
  def welshRequiredCheck                   = s"${vacancyFormId}_datafield_179408_1_1"
  def businessAreaDetailId                 = s"${vacancyFormId}_datafield_155206_1_1_en-GB"
  def typeOfRoleInput                      = s".//*[@aria-describedby='$typeOfRoleId']"
  def listOptionsPath                      = ".//li[@role='option']"
  def approachId                           = s"${vacancyFormId}_datafield_154380_1_1_fieldset"
  def approachExternalId                   = s"${vacancyFormId}_datafield_154380_1_1_11774_label"
  def budgetaryApprovalId                  = s"${vacancyFormId}_datafield_154507_1_1_fieldset"
  def costCentreId                         = s"${vacancyFormId}_datafield_154493_1_1"
  def reserveListRequiredId                = s"${vacancyFormId}_datafield_154633_1_1_fieldset"
  def reserveExtendRequiredId                  = s"${vacancyFormId}_datafield_177141_1_1_fieldset"
  def reserveListLengthId                  = s"select2-${vacancyFormId}_datafield_154637_1_1-container"
  def reserveExtendLengthId                = s"select2-${vacancyFormId}_datafield_177145_1_1-container"
  def locationTypeId                       = s"select2-${vacancyFormId}_datafield_155639_1_1-container"
  def locationDisplayOverrideId            = s"${vacancyFormId}_datafield_155654_1_1_en-GB"
  def vacancyInNIId                        = s"${vacancyFormId}_datafield_155854_1_1_fieldset"
  def availableOutsideNIId                 = s"${vacancyFormId}_datafield_155922_1_1_fieldset"
  def whichCommunitiesApplyId              = s"${vacancyFormId}_field_value_155869_1"
  def locationPreferencesId                = s"${vacancyFormId}_field_value_155799_1"
  def maxLocationPreferenceId              = s"select2-${vacancyFormId}_datafield_155818_1_1-container"
  def locationsToChooseId                  = s"select2-${vacancyFormId}_datafield_155836_1_1-container"

  //vX job information
  var vacancyId               = ""
  var vacancyName             = ""
  var vacancyFormId           = ""
  var vXDepartment            = ""
  var vXBusinessArea          = ""
  var vXBusinessAreaDetail    = ""
  var vXTypeOfRole            = new ListBuffer[String]()
  var vXProfession            = ""
  var vXNoOfJobsAvailable     = ""
  //vX approach
  var vXApproach              = ""
  //vX approval
  var vXBudgetaryApproval     = true
  var vXCostCentre            = ""
  //vX reserve
  var vXReserveListRequired   = true
  var vXReserveListLength     = ""
  var vXReserveExtendRequired = false
  var vXReserveExtendLength   = ""
  //vX locations
  var vXLocationType          = ""
  var vXLocationDisplay       = ""
  var vXVacancyInNI           = false
  var vXAvailableOutsideInNI  = false
  var vXWhichCommunitiesApply = ""
  var vXLocationPreferences   = true
  var vXMaxLocationPreference = ""
  var vXLocationsToChoose     = new ListBuffer[String]()

  private def dashboardPageCheck(): Unit =
    eventually(onPage(dashboardPageTitle))

  def extractVacancyId(): String = {
    vacancyId = waitForVisibilityOfElementByPath(appIdPath).getText
    vacancyId
  }

  private def extractVacancyName(): String = {
    vacancyName = waitForVisibilityOfElementByPath(vacancyNamePath).getText
    vacancyName
  }

  def searchForVacancy(vacancyId: String): Unit = {
    dashboardPageCheck()
    waitForVisibilityOfElementById(searchPath).click()
    waitForVisibilityOfElementByPath(searchVacanciesPath).click()
    waitForVisibilityOfElementById(searchInput).sendKeys(vacancyId)
    matchCriteria("Exact Match")
    clickOn(searchForId)
    extractVacancyId()
    extractVacancyName()
    println(vacancyId)
    println(vacancyName)
  }

  def navigateToVacancyForms(): Unit = {
    waitForVisibilityOfElementByPath(vacancyFormsPath).click()
    waitForVisibilityOfElementByPath(previewAdvertButtonPath).isDisplayed
    extractTabFormId()
  }

  def extractTabFormId(): Unit = {
    val formId = waitForVisibilityOfElementByPath(".//form[@class='form-horizontal']")
    vacancyFormId = formId.getAttribute("id")
  }

  def matchCriteria(criteria: String): Unit =
    while (waitForVisibilityOfElementByPath(matchedOption).getText != criteria)
      clickOn(matchingOption)

  private def extractDepartment(): Unit = {
    vXDepartment = waitForVisibilityOfElementById(departmentId).getText
    println(vXDepartment)
  }

  private def extractBusinessArea(): Unit = {
    vXBusinessArea = waitForVisibilityOfElementById(businessAreaId).getText
    println(vXBusinessArea)
  }

  private def extractBusinessAreaDetail(): Unit = {
    vXBusinessAreaDetail = waitForVisibilityOfElementById(businessAreaDetailId).getText
    println(vXBusinessAreaDetail)
  }

  private def extractTypeOfRole(): Unit = {
    extractValues(typeOfRoleId, vXTypeOfRole)
    println(vXTypeOfRole)
  }

  def tableArea(id: String): WebElement =
    waitForVisibilityOfElement(By.id(id))

  def summaryItems(id: String): mutable.Buffer[WebElement] =
    tableArea(id).findElements(By.xpath(".//li[@class='select2-selection__choice']")).asScala

  def rolesItem(roleItem: WebElement): WebElement =
    roleItem.findElement(By.xpath(".//*[@class='select2-selection__choice__display']"))

  def extractValues(id: String, vXListItem: ListBuffer[String]): Unit = {
    val _values = summaryItems(id)
    for (howManyItem <- _values)
      vXListItem += rolesItem(howManyItem).getText
  }

  private def extractWhichProfession(): Unit = {
    vXProfession = waitForVisibilityOfElementById(whichProfessionId).getText
    println(vXProfession)
  }

  private def extractNoOfJobsAvailable(): Unit = {
    vXNoOfJobsAvailable = waitForVisibilityOfElementById(noOfJobsId).getAttribute("value")
    println(vXNoOfJobsAvailable)
  }

  private def extractApproach(): Unit = {
    val whichApproach = waitForVisibilityOfElementById(approachId).findElement(By.xpath(checkLabelPath))
    vXApproach = whichApproach.getText
    println(vXApproach)
  }

  private def extractBudgetaryApproval(): Unit = {
    val budget = waitForVisibilityOfElementById(budgetaryApprovalId).findElement(By.xpath(checkLabelPath))
    if (budget.getText == "Yes") {
      vXBudgetaryApproval = true
    } else vXBudgetaryApproval = false
    println(vXBudgetaryApproval)
  }

  private def extractCostCentre(): Unit = {
    vXCostCentre = waitForVisibilityOfElementById(costCentreId).getAttribute("value")
    println(vXCostCentre)
  }

  private def extractReserveListRequired(): Unit = {
    val reserve = waitForVisibilityOfElementById(reserveListRequiredId).findElement(By.xpath(checkLabelPath))
    if (reserve.getText == "Yes") {
      vXReserveListRequired = true
    } else vXReserveListRequired = false
    println(vXReserveListRequired)
  }

  private def extractReserveLength(): Unit =
    if (vXReserveListRequired) {
      vXReserveListLength = waitForVisibilityOfElementById(reserveListLengthId).getText
      println(vXReserveListLength)
    }

  private def extractReserveExtendRequired(): Unit =
    if (vXReserveListLength == "12 Months") {
      val extendRequired = waitForVisibilityOfElementById(reserveExtendRequiredId).findElement(By.xpath(checkLabelPath))
      if (extendRequired.getText == "Yes") {
        vXReserveExtendRequired = true
        extractReserveExtendLength()
      } else vXReserveExtendRequired = false
      println(vXReserveExtendRequired)
    }

  private def extractReserveExtendLength(): Unit =
    if (vXReserveExtendRequired) {
      vXReserveExtendLength = waitForVisibilityOfElementById(reserveExtendLengthId).getText
      println(vXReserveExtendLength)
    }

  private def extractLocationType(): Unit = {
    vXLocationType = waitForVisibilityOfElementById(locationTypeId).getText
    println(vXLocationType)
  }

  private def extractLocationDisplay(): Unit = {
    val display = waitForVisibilityOfElementById(locationDisplayOverrideId).getAttribute("value")
    vXLocationDisplay = display.split(",").mkString("List(", ", ", ")")
    println(vXLocationDisplay)
  }

  private def extractVacancyInNI(): Unit = {
    val inNI = waitForVisibilityOfElementById(vacancyInNIId).findElement(By.xpath(checkLabelPath))
    if (inNI.getText == "Yes") {
      vXVacancyInNI = true
    } else vXVacancyInNI = false
    println(vXVacancyInNI)
  }

  private def extractAvailableOutsideNI(): Unit = {
    val outsideNI = waitForVisibilityOfElementById(availableOutsideNIId).findElement(By.xpath(checkLabelPath))
    if (outsideNI.getText == "Yes") {
      vXAvailableOutsideInNI = true
    } else vXAvailableOutsideInNI = false
    println(vXAvailableOutsideInNI)
  }

  private def extractWhichCommunitiesApply(): Unit = {
    val communities = waitForVisibilityOfElementById(whichCommunitiesApplyId).findElement(By.xpath(checkLabelPath))
    vXWhichCommunitiesApply = communities.getText
    println(vXWhichCommunitiesApply)
  }

  private def extractGiveLocationPreferences(): Unit = {
    val preference = waitForVisibilityOfElementById(locationPreferencesId).findElement(By.xpath(checkLabelPath))
    if (preference.getText == "Yes") {
      vXLocationPreferences = true
    } else vXLocationPreferences = false
    println(vXLocationPreferences)
  }

  private def extractMaxLocationPreferences(): Unit = {
    vXMaxLocationPreference = waitForVisibilityOfElementById(maxLocationPreferenceId).getAttribute("title")
    println(vXMaxLocationPreference)
  }

  private def extractLocationsToChoose(): Unit = {
    extractValues(locationsToChooseId, vXLocationsToChoose)
    println(vXLocationsToChoose)
  }

  private def jobInformationDetails(): Unit = {
    extractDepartment()
    extractBusinessArea()
    extractBusinessAreaDetail()
    extractTypeOfRole()
    extractWhichProfession()
    extractNoOfJobsAvailable()
    extractBudgetaryApproval()
  }

  private def approvalsDetails(): Unit = {
    extractBudgetaryApproval()
    extractCostCentre()
  }

  def reserveList(): Unit = {
    extractReserveListRequired()
    extractReserveLength()
    extractReserveExtendRequired()
  }

  private def locations(): Unit = {
    extractLocationType()
    extractLocationDisplay()
    extractVacancyInNI()
    extractAvailableOutsideNI()
    extractWhichCommunitiesApply()
    extractGiveLocationPreferences()
    extractMaxLocationPreferences()
    extractLocationsToChoose()
  }

  def extractAllVacancyDetails(): Unit = {
    searchForVacancy("9564")
    navigateToVacancyForms()
    jobInformationDetails()
    extractApproach()
    approvalsDetails()
    reserveList()
    locations()
  }
}
