package uk.gov.co.test.ui.pages.vx.vacancytabs

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.v9EmployedWithin3Years
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.employmentHistoryBarId
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

object EmploymentHistoryTab extends VacancyBasePage {

  private lazy val employmentHistoryTabPath = ".//span[@class='main-label' and text() = 'Employment history form']"
  def everBeenEmployedId                    = s"${vacancyFormId}_label_146612_1"
  def employerNameId                        = s"${vacancyFormId}_label_146618_1"

  def completeVXEmploymentHistory(): Unit = {
    checkVacancyStatus("Pre Employment Checks")
    moveVacancyOnViaTopBar(employmentHistoryBarId, employmentHistoryTabPath)
    val anyEmployment3Years = if (v9EmployedWithin3Years) "Yes" else "No"
    waitForVisibilityOfElementById(everBeenEmployedId).getText should endWith(s"$anyEmployment3Years")
    waitForVisibilityOfElementById(employerNameId).getText     should endWith("Employer Test One")
  }

  def extractTabFormId(): String = {
    val formId = waitForVisibilityOfElementByPath(".//form[@class='form-horizontal']")
    vacancyFormId = formId.getAttribute("id")
    vacancyFormId
  }
}
