package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId
import uk.gov.co.test.ui.utils.NewVacancyDetails

case class JobInfoDetails(
  displayWelsh: Boolean,
  department: String,
  businessArea: String,
  businessAreaDetail: String,
  typeOfRole: String,
  whichProfession: String,
  noOfJobs: String
)

object JobInfoSection extends VacancyBasePage {

  val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"

  private lazy val businessAreaId       = s"select2-${formId}_datafield_155221_1_1-container"
  private lazy val whichProfessionId    = s"select2-${formId}_datafield_155435_1_1-container"
  private lazy val noOfJobsId           = s"${formId}_datafield_155332_1_1"
  private lazy val generalInput         = "//input[@class='select2-search__field']"
  private lazy val typeOfRoleId         = s"select2-${formId}_datafield_155369_1_1-container"
  private lazy val typeOfRoleInput      = s".//*[@aria-describedby='$typeOfRoleId']"
  private lazy val welshRequiredCheck   = s"${formId}_datafield_179408_1_1"
  private lazy val businessAreaDetailId = s"${formId}_datafield_155206_1_1_en-GB"

  private def selectWelshVersion(jobInfoDetails: JobInfoDetails): Unit =
    if (jobInfoDetails.displayWelsh) checkbox(welshRequiredCheck).select()

  private def selectBusinessArea(jobInfoDetails: JobInfoDetails): Unit = {
    scrollToElement(By.id(businessAreaId))
    waitForVisibilityOfElementById(businessAreaId).click()
    selectOption(generalInput, jobInfoDetails.businessArea)
  }

  private def enterBusinessAreaDetail(jobInfoDetails: JobInfoDetails): Unit = {
    val businessDetailsInput = waitForVisibilityOfElementById(businessAreaDetailId)
    businessDetailsInput.sendKeys(jobInfoDetails.businessAreaDetail)
  }

  private def selectTypeOfRole(jobInfoDetails: JobInfoDetails): Unit = {
    scrollToElement(By.id(typeOfRoleId))
    selectOption(typeOfRoleInput, jobInfoDetails.typeOfRole)
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
