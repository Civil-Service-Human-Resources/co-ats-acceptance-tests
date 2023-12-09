package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class EmploymentHistoryDetails(
  employedWithin3Years: Boolean,
  firstEmployerName: String,
  firstEmployerFromDate: String,
  firstEmployerToDate: String,
  secondEmployerName: String,
  secondEmployerFromDate: String,
  secondEmployerToDate: String,
  thirdEmployerName: String,
  thirdEmployerFromDate: String,
  thirdEmployerToDate: String
)

object EmploymentHistoryPage extends CivilServiceJobsBasePage {

  private lazy val employmentHistoryPageTitle = "Employment History - Civil Service Jobs - GOV.UK"
  private lazy val addAnotherEmployerId       = ".//input[@value='Add Another Employer']"
  private lazy val removeEmployerId           = ".//input[@value='Remove Employer']"
  def employedWithin3YearsYesId               = s"${pecFormId}_datafield_123622_1_1_1_label"
  def employedWithin3YearsNoId                = s"${pecFormId}_datafield_123622_1_1_2_label"
  def firstEmployerNameId                     = s"${pecFormId}_datafield_121585_1_1"
  def firstFromDayId                          = s"${pecFormId}_datafield_121593_1_1--DAY"
  def firstFromMonthId                        = s"${pecFormId}_datafield_121593_1_1--MONTH"
  def firstFromYearId                         = s"${pecFormId}_datafield_121593_1_1--YEAR"
  def firstToDayId                            = s"${pecFormId}_datafield_121597_1_1--DAY"
  def firstToMonthId                          = s"${pecFormId}_datafield_121597_1_1--MONTH"
  def firstToYearId                           = s"${pecFormId}_datafield_121597_1_1--YEAR"
  def secondEmployerNameId                    = s"${pecFormId}_datafield_121585_1_2"
  def secondFromDayId                         = s"${pecFormId}_datafield_121593_1_2--DAY"
  def secondFromMonthId                       = s"${pecFormId}_datafield_121593_1_2--MONTH"
  def secondFromYearId                        = s"${pecFormId}_datafield_121593_1_2--YEAR"
  def secondToDayId                           = s"${pecFormId}_datafield_121597_1_2--DAY"
  def secondToMonthId                         = s"${pecFormId}_datafield_121597_1_2--MONTH"
  def secondToYearId                          = s"${pecFormId}_datafield_121597_1_2--YEAR"
  def thirdEmployerNameId                     = s"${pecFormId}_datafield_121585_1_3"
  def thirdFromDayId                          = s"${pecFormId}_datafield_121593_1_3--DAY"
  def thirdFromMonthId                        = s"${pecFormId}_datafield_121593_1_3--MONTH"
  def thirdFromYearId                         = s"${pecFormId}_datafield_121593_1_3--YEAR"
  def thirdToDayId                            = s"${pecFormId}_datafield_121597_1_3--DAY"
  def thirdToMonthId                          = s"${pecFormId}_datafield_121597_1_3--MONTH"
  def thirdToYearId                           = s"${pecFormId}_datafield_121597_1_3--YEAR"

  private def employmentHistoryPageCheck(): Unit =
    eventually(onPage(employmentHistoryPageTitle))

  private def selectEmployedWithin3Years(employmentHistoryDetails: EmploymentHistoryDetails): Unit =
    if (employmentHistoryDetails.employedWithin3Years) {
      radioSelect(employedWithin3YearsYesId)
      enterFirstEmployerDetails(employmentHistoryDetails)
      enterSecondEmployerDetails(employmentHistoryDetails)
      enterThirdEmployerDetails(employmentHistoryDetails)
    } else radioSelect(employedWithin3YearsNoId)

  private def enterFirstEmployerDetails(employmentHistoryDetails: EmploymentHistoryDetails): Unit = {
    enterDetails(firstEmployerNameId, employmentHistoryDetails.firstEmployerName)
    enterDate(employmentHistoryDetails.firstEmployerFromDate, firstFromDayId, firstFromMonthId, firstFromYearId)
    enterDate(employmentHistoryDetails.firstEmployerToDate, firstToDayId, firstToMonthId, firstToYearId)
  }

  private def enterSecondEmployerDetails(employmentHistoryDetails: EmploymentHistoryDetails): Unit = {
    waitForVisibilityOfElementByPath(addAnotherEmployerId).click()
    enterDetails(secondEmployerNameId, employmentHistoryDetails.secondEmployerName)
    enterDate(employmentHistoryDetails.secondEmployerFromDate, secondFromDayId, secondFromMonthId, secondFromYearId)
    enterDate(employmentHistoryDetails.secondEmployerToDate, secondToDayId, secondToMonthId, secondToYearId)
  }

  private def enterThirdEmployerDetails(employmentHistoryDetails: EmploymentHistoryDetails): Unit = {
    waitForVisibilityOfElementByPath(addAnotherEmployerId).click()
    enterDetails(thirdEmployerNameId, employmentHistoryDetails.thirdEmployerName)
    enterDate(employmentHistoryDetails.thirdEmployerFromDate, thirdFromDayId, thirdFromMonthId, thirdFromYearId)
    enterDate(employmentHistoryDetails.thirdEmployerToDate, thirdToDayId, thirdToMonthId, thirdToYearId)
  }

  private def enterDate(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (day, month, year) = splitDate(date)
    enterDate(dayId, day)
    enterDate(monthId, month)
    enterDate(yearId, year)
  }

  private val history: Seq[EmploymentHistoryDetails => Unit] = Seq(
    selectEmployedWithin3Years
  )

  def employmentHistoryPage(pecFormDetails: PecFormDetails): Unit = {
    employmentHistoryPageCheck()
    history.foreach { f =>
      f(pecFormDetails.employmentHistoryDetails)
    }
    clickOn(pageContinue)
  }
}
