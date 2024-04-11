package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, WebDriver}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXBusinessAreaDetail, vXJobInfoDepartment, vXNoOfJobsAvailable, vXProfession, vXTypeOfRole, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

case class JobInfoDetails(
  displayWelsh: Boolean,
  department: String,
  businessArea: String,
  addWelshBusinessArea: Boolean,
  welshBusinessArea: String,
  businessAreaDetail: String,
  typeOfRole: ListBuffer[String],
  whichProfession: String,
  noOfJobs: String
)

object JobInfoSection extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"

  def departmentId                = s"select2-${vacancyFormId}_datafield_155191_1_1-container"
  def businessAreaId              = s"select2-${vacancyFormId}_datafield_155221_1_1-container"
  def whichProfessionId           = s"select2-${vacancyFormId}_datafield_155435_1_1-container"
  def noOfJobsId                  = s"${vacancyFormId}_datafield_155332_1_1"
  def typeOfRoleId                = s"select2-${vacancyFormId}_datafield_155369_1_1-container"
  def welshRequiredCheck          = s"${vacancyFormId}_datafield_179408_1_1"
  def businessAreaDetailId        = s"${vacancyFormId}_datafield_155206_1_1_en-GB"
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
    val area            = jobInfoDetails.businessArea
    scrollToElement(By.id(businessAreaId))
    val businessArea    = waitForVisibilityOfElementById(businessAreaId)
    businessArea.click()
    val wait            = new WebDriverWait(driver, 210, 3000)
    wait.until { (d: WebDriver) =>
      d.findElement(By.id(businessAreaId)).getAttribute("title").equals("Choose one...")
    }
    val noOfListOptions = driver.findElements(By.xpath(listOptionsPath)).size()
    if (noOfListOptions < 3) {
      action().moveToElement(waitForDropdownOption(area)).perform()
      waitForDropdownOption(area).click()
    } else selectOption(generalInput, area)
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

  private val jobInfo: Seq[JobInfoDetails => Unit] = Seq(
    selectWelshVersion,
    selectDepartment,
    selectBusinessArea,
    enterBusinessAreaDetail,
    selectTypeOfRole,
    whichProfessionIsJob,
    noOfJobsAvailable
  )

  def jobInformationSection(newVacancyDetails: NewVacancyDetails): Unit =
    jobInfo.foreach { f =>
      f(newVacancyDetails.jobInfoDetails)
    }
}
