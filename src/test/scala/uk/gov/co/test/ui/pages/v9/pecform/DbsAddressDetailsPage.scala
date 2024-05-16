package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCrcCheckProvider, vXCrcLevel}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class DbsAddressDetails(
  addressLineOne: String,
  addressLineTwo: Option[String] = None,
  townOrCity: String,
  county: String,
  country: String,
  postcode: String,
  addressDateFrom: String
)

object DbsAddressDetailsPage extends CivilServiceJobsBasePage {

  private lazy val dbsAddressDetailsPageTitle = "DBS - Address Details - Civil Service Jobs - GOV.UK"
  def addressLineOneId                        = s"${pecFormId}_datafield_55115_1_1"
  def addressLineTwoId                        = s"${pecFormId}_datafield_55121_1_1"
  def townOrCityId                            = s"${pecFormId}_datafield_55127_1_1"
  def countyId                                = s"${pecFormId}_datafield_55133_1_1"
  def countryId                               = s"${pecFormId}_datafield_55139_1_1"
  def postcodeId                              = s"${pecFormId}_datafield_55142_1_1"
  def dateFromDayId                           = s"${pecFormId}_datafield_64529_1_1--DAY"
  def dateFromMonthId                         = s"${pecFormId}_datafield_64529_1_1--MONTH"
  def dateFromYearId                          = s"${pecFormId}_datafield_64529_1_1--YEAR"

  private def dbsAddressDetailsPageCheck(): Unit =
    eventually(onPage(dbsAddressDetailsPageTitle))

  private def enterDate(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (day, month, year) = splitDate(date)
    enterDate(dayId, day)
    enterDate(monthId, month)
    enterDate(yearId, year)
  }

  private def enterAddressDetails(dbsAddressDetails: DbsAddressDetails): Unit = {
    enterDetails(addressLineOneId, dbsAddressDetails.addressLineOne)
    enterDetails(addressLineTwoId, dbsAddressDetails.addressLineTwo.get)
    enterDetails(townOrCityId, dbsAddressDetails.townOrCity)
    enterDetails(countyId, dbsAddressDetails.county)
    selectDropdownOption(countryId, dbsAddressDetails.country)
    enterDetails(postcodeId, dbsAddressDetails.postcode)
    enterDate(
      dbsAddressDetails.addressDateFrom,
      dateFromDayId,
      dateFromMonthId,
      dateFromYearId
    )
  }

  private val addressDetails: Seq[DbsAddressDetails => Unit] = Seq(
    enterAddressDetails
  )

  def dbsAddressDetailsPage(pecFormDetails: PecFormDetails): Unit =
    if (vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) {
      dbsAddressDetailsPageCheck()
      addressDetails.foreach { f =>
        f(pecFormDetails.dbsAddressDetails)
      }
      clickOn(pageContinue)
    }
}
