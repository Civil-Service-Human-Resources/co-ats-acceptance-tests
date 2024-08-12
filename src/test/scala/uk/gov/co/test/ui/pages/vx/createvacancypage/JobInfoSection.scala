package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9HomeDepartment, vXBusinessArea, vXBusinessAreaDetail, vXJobInfoDepartment, vXLineManagerDuties, vXNoOfJobsAvailable, vXPositionIdentifier, vXProfession, vXTypeOfRole, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.templateSelect

import scala.collection.mutable.ListBuffer

case class JobInfoDetails(
  displayWelsh: Boolean,
  department: String,
  businessArea: String,
  addWelshBusinessArea: Boolean,
  welshBusinessArea: String,
  businessAreaDetail: String,
  positionIdentifier: String,
  typeOfRole: ListBuffer[String],
  whichProfession: String,
  noOfJobs: String,
  lineManagerDuties: Boolean
)

object JobInfoSection extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"

  def departmentId                = s"select2-${vacancyFormId}_datafield_155191_1_1-container"
  def businessAreaId              = s"select2-${vacancyFormId}_datafield_155221_1_1-container"
  def whichProfessionId           = s"select2-${vacancyFormId}_datafield_155435_1_1-container"
  def noOfJobsId                  = s"${vacancyFormId}_datafield_155332_1_1"
  def typeOfRoleId                = s"select2-${vacancyFormId}_datafield_155369_1_1-container"
  def welshRequiredCheck          = s"${vacancyFormId}_datafield_179408_1_1"
  def positionIdentifierId        = s"${vacancyFormId}_datafield_155449_1_1"
  def businessAreaDetailId        = s"${vacancyFormId}_datafield_155206_1_1_en-GB"
  def lineManagerDutiesId         = s"${vacancyFormId}_datafield_206297_1_1_fieldset"
  def lineManagerDutiesYesId      = s"${vacancyFormId}_datafield_206297_1_1_1"
  def lineManagerDutiesNoId       = s"${vacancyFormId}_datafield_206297_1_1_2"
  def typeOfRoleInput             = s".//*[@aria-describedby='$typeOfRoleId']"
  def listOptionsPath             = ".//li[@role='option']"
  def addWelshBusinessAreaId()    = "clicky_155206"
  def welshBusinessAreaInput      = "datafield_155206_1_1_cy"
  def updateWelshBusinessAreaId() = "lbledit_datafield_155206_1_1-update"

  private def selectWelshVersion(jobInfoDetails: JobInfoDetails): Unit =
    if (jobInfoDetails.displayWelsh) checkbox(welshRequiredCheck).select()

  private def selectDepartment(jobInfoDetails: JobInfoDetails): Unit = {
    vXJobInfoDepartment = jobInfoDetails.department
    waitForVisibilityOfElementById(departmentId).click()
    selectOption(generalInput, vXJobInfoDepartment)
  }

  private def selectBusinessArea(jobInfoDetails: JobInfoDetails): Unit = {
    v9HomeDepartment = ""
    vXBusinessArea = jobInfoDetails.businessArea
    scrollToElement(By.id(businessAreaId))
    val businessArea = waitForVisibilityOfElementById(businessAreaId)
    businessArea.click()
    if (vXJobInfoDepartment != "HM Revenue and Customs") {
      if (templateSelect.getText == "DO NOT USE- Automation Test Template") {
        val wait            = new WebDriverWait(driver, 210, 3000)
        wait.until { (d: WebDriver) =>
          d.findElement(By.id(businessAreaId)).getAttribute("title").equals("Choose one...")
        }
        val noOfListOptions = driver.findElements(By.xpath(listOptionsPath)).size()
        if (noOfListOptions < 3) {
          action().moveToElement(waitForDropdownOption(vXBusinessArea)).perform()
          waitForDropdownOption(vXBusinessArea).click()
        } else selectOption(generalInput, vXBusinessArea)
      } else {
        Thread.sleep(5000)
        selectOption(generalInput, vXBusinessArea)
      }
    } else selectOption(generalInput, vXBusinessArea)
  }

  private def enterBusinessAreaDetail(jobInfoDetails: JobInfoDetails): Unit = {
    val businessDetailsInput = waitForVisibilityOfElementById(businessAreaDetailId)
    businessDetailsInput.clear()
    vXBusinessAreaDetail = jobInfoDetails.businessAreaDetail
    businessDetailsInput.sendKeys(vXBusinessAreaDetail)
    addWelshTranslation(
      jobInfoDetails.addWelshBusinessArea,
      addWelshBusinessAreaId(),
      welshBusinessAreaInput,
      jobInfoDetails.welshBusinessArea,
      updateWelshBusinessAreaId()
    )
  }

  private def positionIdentifier(jobInfoDetails: JobInfoDetails): Unit =
    if (
      vXJobInfoDepartment == "Ministry of Defence" ||
      vXJobInfoDepartment == "Office for National Statistics" ||
      vXJobInfoDepartment == "UK Statistics Authority" ||
      vXJobInfoDepartment == "Government Statistical Service"
    ) {
      val positionIdentifier = textField(positionIdentifierId)
      vXPositionIdentifier = jobInfoDetails.positionIdentifier
      positionIdentifier.value = vXPositionIdentifier
    }

  private def selectTypeOfRole(jobInfoDetails: JobInfoDetails): Unit = {
    scrollToElement(By.id(typeOfRoleId))
    vXTypeOfRole = jobInfoDetails.typeOfRole
    enterTypeRoles(jobInfoDetails.typeOfRole, typeOfRoleId)
  }

  private def whichProfessionIsJob(jobInfoDetails: JobInfoDetails): Unit = {
    scrollToElement(By.id(whichProfessionId))
    vXProfession = jobInfoDetails.whichProfession
    waitForVisibilityOfElementById(whichProfessionId).click()
    selectOption(generalInput, vXProfession)
  }

  private def noOfJobsAvailable(jobInfoDetails: JobInfoDetails): Unit = {
    val noOfJobsInput = textField(noOfJobsId)
    vXNoOfJobsAvailable = jobInfoDetails.noOfJobs
    noOfJobsInput.value = vXNoOfJobsAvailable
  }

  def selectLineManagerDuties(jobInfoDetails: JobInfoDetails): Unit = {
    vXLineManagerDuties = jobInfoDetails.lineManagerDuties
    if (vXLineManagerDuties) {
      clickOnRadioButton(lineManagerDutiesYesId)
    } else clickOnRadioButton(lineManagerDutiesNoId)
  }

  private val jobInfo: Seq[JobInfoDetails => Unit] = Seq(
    selectWelshVersion,
    selectDepartment,
    selectBusinessArea,
    enterBusinessAreaDetail,
    positionIdentifier,
    selectTypeOfRole,
    whichProfessionIsJob,
    noOfJobsAvailable,
    selectLineManagerDuties
  )

  def jobInformationSection(newVacancyDetails: NewVacancyDetails): Unit =
    jobInfo.foreach { f =>
      f(newVacancyDetails.jobInfoDetails)
    }
}
