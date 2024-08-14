package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9EmployedWithin3Years, v9FirstEmployerFromDate, v9FirstEmployerName, v9FirstEmployerToDate, v9SecondEmployerFromDate, v9SecondEmployerName, v9SecondEmployerToDate, v9ThirdEmployerFromDate, v9ThirdEmployerName, v9ThirdEmployerToDate, vXApproach, vXPecEmploymentHistoryCheck, vXTypeOfCandidate}
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

  private lazy val employmentHistoryPageTitle = "Employment history - Civil Service Jobs - GOV.UK"
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

  private def selectEmployedWithin3Years(employmentHistoryDetails: EmploymentHistoryDetails): Unit = {
    v9EmployedWithin3Years = employmentHistoryDetails.employedWithin3Years
    if (v9EmployedWithin3Years) {
      radioSelect(employedWithin3YearsYesId)
      enterFirstEmployerDetails(employmentHistoryDetails)
      enterSecondEmployerDetails(employmentHistoryDetails)
      enterThirdEmployerDetails(employmentHistoryDetails)
    } else radioSelect(employedWithin3YearsNoId)
  }

  private def enterFirstEmployerDetails(employmentHistoryDetails: EmploymentHistoryDetails): Unit = {
    v9FirstEmployerName = employmentHistoryDetails.firstEmployerName
    v9FirstEmployerFromDate = employmentHistoryDetails.firstEmployerFromDate
    v9FirstEmployerToDate = employmentHistoryDetails.firstEmployerToDate
    enterDetails(firstEmployerNameId, v9FirstEmployerName)
    enterDate(v9FirstEmployerFromDate, firstFromDayId, firstFromMonthId, firstFromYearId)
    enterDate(v9FirstEmployerToDate, firstToDayId, firstToMonthId, firstToYearId)
  }

  private def enterSecondEmployerDetails(employmentHistoryDetails: EmploymentHistoryDetails): Unit = {
    v9SecondEmployerName = employmentHistoryDetails.secondEmployerName
    v9SecondEmployerFromDate = employmentHistoryDetails.secondEmployerFromDate
    v9SecondEmployerToDate = employmentHistoryDetails.secondEmployerToDate
    waitForVisibilityOfElementByPath(addAnotherEmployerId).click()
    enterDetails(secondEmployerNameId, v9SecondEmployerName)
    enterDate(v9SecondEmployerFromDate, secondFromDayId, secondFromMonthId, secondFromYearId)
    enterDate(v9SecondEmployerToDate, secondToDayId, secondToMonthId, secondToYearId)
  }

  private def enterThirdEmployerDetails(employmentHistoryDetails: EmploymentHistoryDetails): Unit = {
    v9ThirdEmployerName = employmentHistoryDetails.thirdEmployerName
    v9ThirdEmployerFromDate = employmentHistoryDetails.thirdEmployerFromDate
    v9ThirdEmployerToDate = employmentHistoryDetails.thirdEmployerToDate
    waitForVisibilityOfElementByPath(addAnotherEmployerId).click()
    enterDetails(thirdEmployerNameId, v9ThirdEmployerName)
    enterDate(v9ThirdEmployerFromDate, thirdFromDayId, thirdFromMonthId, thirdFromYearId)
    enterDate(v9ThirdEmployerToDate, thirdToDayId, thirdToMonthId, thirdToYearId)
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

  def employmentHistoryPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecEmploymentHistoryCheck.contains("Not Applicable") &&
      vXPecEmploymentHistoryCheck.contains(s"$vXTypeOfCandidate Candidates")
    ) {
      employmentHistoryPageCheck()
      history.foreach { f =>
        f(pecFormDetails.employmentHistoryDetails)
      }
      clickOn(pageContinue)
    }
}
