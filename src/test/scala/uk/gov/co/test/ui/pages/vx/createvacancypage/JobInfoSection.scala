package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vXJobInfoDepartment
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

case class JobInfoDetails(
  displayWelsh: Boolean,
  department: String,
  businessArea: String,
  addWelshBusinessArea: Boolean,
  welshBusinessArea: String,
  businessAreaDetail: String,
  typeOfRole: List[String],
  whichProfession: String,
  noOfJobs: String
)

object JobInfoSection extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"

  def departmentId              = s"select2-${vacancyFormId}_datafield_155191_1_1-container"
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
    waitForVisibilityOfElementById(businessAreaId).click()
    val noOfListOptions = driver.findElements(By.xpath(listOptionsPath)).size()
    if (noOfListOptions < 3) {
      action().moveToElement(waitForDropdownOption(area)).perform()
      waitForDropdownOption(area).click()
    } else selectOption(generalInput, area)
  }

  private def enterBusinessAreaDetail(jobInfoDetails: JobInfoDetails): Unit = {
    val businessDetailsInput = waitForVisibilityOfElementById(businessAreaDetailId)
    businessDetailsInput.clear()
    businessDetailsInput.sendKeys(jobInfoDetails.businessAreaDetail)
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
    enterRoles(jobInfoDetails.typeOfRole, typeOfRoleId)
  }

  private def whichProfessionIsJob(jobInfoDetails: JobInfoDetails): Unit = {
    scrollToElement(By.id(whichProfessionId))
    waitForVisibilityOfElementById(whichProfessionId).click()
    selectOption(generalInput, jobInfoDetails.whichProfession)
  }

  private def noOfJobsAvailable(jobInfoDetails: JobInfoDetails): Unit = {
    val noOfJobsInput = textField(noOfJobsId)
    noOfJobsInput.value = jobInfoDetails.noOfJobs
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
