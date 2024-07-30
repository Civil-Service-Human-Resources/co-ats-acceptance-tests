package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecOverseasCheck, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class OverseasDetails(
  residedQuestion: String,
  residedOutside: Boolean,
  employeeAccountInfo: String,
  countriesVisitedInfo: String,
  countryVisited: String,
  visitedDateFrom: String,
  visitedDateTo: String,
  reasonForTravel: String,
  residedOutsideEmployed: Boolean,
  employersName: String,
  employersEmail: String,
  employersPhone: String,
  employedDateFrom: String,
  employedDateTo: String,
  contactOverseasEmployer: Boolean,
  reasonNoContactEmployer: String,
  residedOutsideStudying: Boolean,
  instituteName: String,
  instituteEmail: String,
  institutePhone: String,
  studyingDateFrom: String,
  studyingDateTo: String,
  contactOverseasInstitute: Boolean,
  reasonNoContactInstitute: String,
  residedOutsideTravelling: Boolean,
  travellersName: String,
  travellersEmail: String,
  travellersPhone: String,
  travelledDateFrom: String,
  travelledDateTo: String,
  contactOverseasTraveller: Boolean,
  reasonNoContactTraveller: String
)

object OverseasPage extends CivilServiceJobsBasePage {

  private lazy val overseasPageTitle = "Overseas - Civil Service Jobs - GOV.UK"
  def overseasResidedOutsideUKId     = ".//span[@class='hform_lbl_text']"
  def residedOutsideUKYesId          = s"${pecFormId}_datafield_77611_1_1_1_label"
  def residedOutsideUKNoId           = s"${pecFormId}_datafield_77611_1_1_2_label"
  def employeeAccountInfoId          = s"${pecFormId}_label_77620_1"
  def countriesVisitedInfoId         = s"${pecFormId}_label_123920_1"
  def countryVisitedId               = s"${pecFormId}_datafield_124199_1_1"
  def visitedDateFromDayId           = s"${pecFormId}_datafield_86867_1_1--DAY"
  def visitedDateFromMonthId         = s"${pecFormId}_datafield_86867_1_1--MONTH"
  def visitedDateFromYearId          = s"${pecFormId}_datafield_86867_1_1--YEAR"
  def visitedDateToDayId             = s"${pecFormId}_datafield_86863_1_1--DAY"
  def visitedDateToMonthId           = s"${pecFormId}_datafield_86863_1_1--MONTH"
  def visitedDateToYearId            = s"${pecFormId}_datafield_86863_1_1--YEAR"
  def reasonForTravelId              = s"${pecFormId}_datafield_96240_1_1"
  def addAnotherInstanceId()         = ".//input[@value='Add another instance']"
  def residedOutsideEmployedYesId    = s"${pecFormId}_datafield_77615_1_1_1_label"
  def residedOutsideEmployedNoId     = s"${pecFormId}_datafield_77615_1_1_2_label"
  def employersNameId                = s"${pecFormId}_datafield_77664_1_1"
  def employersEmailId               = s"${pecFormId}_datafield_77671_1_1"
  def employersPhoneId               = s"${pecFormId}_datafield_77678_1_1"
  def employedDateFromDayId          = s"${pecFormId}_datafield_122067_1_1--DAY"
  def employedDateFromMonthId        = s"${pecFormId}_datafield_122067_1_1--MONTH"
  def employedDateFromYearId         = s"${pecFormId}_datafield_122067_1_1--YEAR"
  def employedDateToDayId            = s"${pecFormId}_datafield_122071_1_1--DAY"
  def employedDateToMonthId          = s"${pecFormId}_datafield_122071_1_1--MONTH"
  def employedDateToYearId           = s"${pecFormId}_datafield_122071_1_1--YEAR"
  def contactOverseasEmployerYesId   = s"${pecFormId}_datafield_174581_1_1_1_label"
  def contactOverseasEmployerNoId    = s"${pecFormId}_datafield_174581_1_1_2_label"
  def reasonNoContactEmployerId      = s"${pecFormId}_datafield_174585_1_1"
  def residedOutsideStudyingYesId    = s"${pecFormId}_datafield_77685_1_1_1_label"
  def residedOutsideStudyingNoId     = s"${pecFormId}_datafield_77685_1_1_2_label"
  def instituteNameId                = s"${pecFormId}_datafield_77761_1_1"
  def instituteEmailId               = s"${pecFormId}_datafield_77768_1_1"
  def institutePhoneId               = s"${pecFormId}_datafield_77775_1_1"
  def studyingDateFromDayId          = s"${pecFormId}_datafield_122074_1_1--DAY"
  def studyingDateFromMonthId        = s"${pecFormId}_datafield_122074_1_1--MONTH"
  def studyingDateFromYearId         = s"${pecFormId}_datafield_122074_1_1--YEAR"
  def studyingDateToDayId            = s"${pecFormId}_datafield_122078_1_1--DAY"
  def studyingDateToMonthId          = s"${pecFormId}_datafield_122078_1_1--MONTH"
  def studyingDateToYearId           = s"${pecFormId}_datafield_122078_1_1--YEAR"
  def contactOverseasInstituteYesId  = s"${pecFormId}_datafield_174592_1_1_1_label"
  def contactOverseasInstituterNoId  = s"${pecFormId}_datafield_174592_1_1_2_label"
  def reasonNoContactInstituteId     = s"${pecFormId}_datafield_174596_1_1"
  def residedOutsideTravellingYesId  = s"${pecFormId}_datafield_77782_1_1_1_label"
  def residedOutsideTravellingNoId   = s"${pecFormId}_datafield_77782_1_1_2_label"
  def travellersNameId               = s"${pecFormId}_datafield_77833_1_1"
  def travellersEmailId              = s"${pecFormId}_datafield_77840_1_1"
  def travellersPhoneId              = s"${pecFormId}_datafield_77847_1_1"
  def travelledDateFromDayId         = s"${pecFormId}_datafield_122082_1_1--DAY"
  def travelledDateFromMonthId       = s"${pecFormId}_datafield_122082_1_1--MONTH"
  def travelledDateFromYearId        = s"${pecFormId}_datafield_122082_1_1--YEAR"
  def travelledDateToDayId           = s"${pecFormId}_datafield_122086_1_1--DAY"
  def travelledDateToMonthId         = s"${pecFormId}_datafield_122086_1_1--MONTH"
  def travelledDateToYearId          = s"${pecFormId}_datafield_122086_1_1--YEAR"
  def contactTravellerYesId          = s"${pecFormId}_datafield_174603_1_1_1_label"
  def contactTravellerNoId           = s"${pecFormId}_datafield_174603_1_1_2_label"
  def reasonNoContactTravellerId     = s"${pecFormId}_datafield_174607_1_1"

  private def overseasPageCheck(overseasDetails: OverseasDetails): Unit =
    eventually(onPage(overseasPageTitle))

  private def residedOutsideQuestionText(overseasDetails: OverseasDetails): Unit =
    waitForVisibilityOfElementByPath(overseasResidedOutsideUKId).getText shouldEqual overseasDetails.residedQuestion

  private def residedOutsideInfoText(overseasDetails: OverseasDetails): Unit = {
    waitForVisibilityOfElementById(employeeAccountInfoId).getText  shouldEqual overseasDetails.employeeAccountInfo
    waitForVisibilityOfElementById(countriesVisitedInfoId).getText shouldEqual overseasDetails.countriesVisitedInfo
  }

  private def enterCountryVisited(overseasDetails: OverseasDetails): Unit =
    enterDetails(countryVisitedId, overseasDetails.countryVisited)

  private def enterDate(date: String, dayId: String, monthId: String, yearId: String): Unit = {
    val (day, month, year) = splitDate(date)
    enterDate(dayId, day)
    enterDate(monthId, month)
    enterDate(yearId, year)
  }

  private def enterVisitedDateFrom(overseasDetails: OverseasDetails): Unit =
    enterDate(overseasDetails.visitedDateFrom, visitedDateFromDayId, visitedDateFromMonthId, visitedDateFromYearId)

  private def enterVisitedDateTo(overseasDetails: OverseasDetails): Unit =
    enterDate(overseasDetails.visitedDateTo, visitedDateToDayId, visitedDateToMonthId, visitedDateToYearId)

  private def enterReasonForTravel(overseasDetails: OverseasDetails): Unit =
    enterDetails(reasonForTravelId, overseasDetails.reasonForTravel)

  private def residedOutsideFlow(overseasDetails: OverseasDetails): Unit = {
    residedOutsideQuestionText(overseasDetails)
    if (overseasDetails.residedOutside) {
      radioSelect(residedOutsideUKYesId)
      residedOutsideInfoText(overseasDetails)
      enterCountryVisited(overseasDetails)
      enterVisitedDateFrom(overseasDetails)
      enterVisitedDateTo(overseasDetails)
      enterReasonForTravel(overseasDetails)
      selectResidedOutsideEmployed(overseasDetails)
      selectResidedOutsideStudying(overseasDetails)
      selectResidedOutsideTravelling(overseasDetails)
    } else radioSelect(residedOutsideUKNoId)
  }

  private def enterEmployersName(overseasDetails: OverseasDetails): Unit =
    enterDetails(employersNameId, overseasDetails.employersName)

  private def enterEmployersEmail(overseasDetails: OverseasDetails): Unit =
    enterDetails(employersEmailId, overseasDetails.employersEmail)

  private def enterEmployersPhone(overseasDetails: OverseasDetails): Unit =
    enterDetails(employersPhoneId, overseasDetails.employersPhone)

  private def enterEmployedDateFrom(overseasDetails: OverseasDetails): Unit =
    enterDate(overseasDetails.employedDateFrom, employedDateFromDayId, employedDateFromMonthId, employedDateFromYearId)

  private def enterEmployedDateTo(overseasDetails: OverseasDetails): Unit =
    enterDate(overseasDetails.employedDateTo, employedDateToDayId, employedDateToMonthId, employedDateToYearId)

  private def enterReasonNoContactEmployer(overseasDetails: OverseasDetails): Unit =
    enterDetails(reasonNoContactEmployerId, overseasDetails.reasonNoContactEmployer)

  private def selectContactOverseasEmployer(overseasDetails: OverseasDetails): Unit =
    if (overseasDetails.contactOverseasEmployer) {
      radioSelect(contactOverseasEmployerYesId)
    } else {
      radioSelect(contactOverseasEmployerNoId)
      enterReasonNoContactEmployer(overseasDetails)
    }

  private def selectResidedOutsideEmployed(overseasDetails: OverseasDetails): Unit =
    if (overseasDetails.residedOutsideEmployed) {
      radioSelect(residedOutsideEmployedYesId)
      enterEmployersName(overseasDetails)
      enterEmployersEmail(overseasDetails)
      enterEmployersPhone(overseasDetails)
      enterEmployedDateFrom(overseasDetails)
      enterEmployedDateTo(overseasDetails)
      selectContactOverseasEmployer(overseasDetails)
    } else radioSelect(residedOutsideEmployedNoId)

  private def enterInstituteName(overseasDetails: OverseasDetails): Unit =
    enterDetails(instituteNameId, overseasDetails.instituteName)

  private def enterInstituteEmail(overseasDetails: OverseasDetails): Unit =
    enterDetails(instituteEmailId, overseasDetails.instituteEmail)

  private def enterInstitutePhone(overseasDetails: OverseasDetails): Unit =
    enterDetails(institutePhoneId, overseasDetails.institutePhone)

  private def enterStudyingDateFrom(overseasDetails: OverseasDetails): Unit =
    enterDate(overseasDetails.studyingDateFrom, studyingDateFromDayId, studyingDateFromMonthId, studyingDateFromYearId)

  private def enterStudyingDateTo(overseasDetails: OverseasDetails): Unit =
    enterDate(overseasDetails.studyingDateTo, studyingDateToDayId, studyingDateToMonthId, studyingDateToYearId)

  private def enterReasonNoContactInstitute(overseasDetails: OverseasDetails): Unit =
    enterDetails(reasonNoContactInstituteId, overseasDetails.reasonNoContactInstitute)

  private def selectContactOverseasInstitute(overseasDetails: OverseasDetails): Unit =
    if (overseasDetails.contactOverseasInstitute) {
      radioSelect(contactOverseasInstituteYesId)
    } else {
      radioSelect(contactOverseasInstituterNoId)
      enterReasonNoContactInstitute(overseasDetails)
    }

  private def selectResidedOutsideStudying(overseasDetails: OverseasDetails): Unit =
    if (overseasDetails.residedOutsideStudying) {
      radioSelect(residedOutsideStudyingYesId)
      enterInstituteName(overseasDetails)
      enterInstituteEmail(overseasDetails)
      enterInstitutePhone(overseasDetails)
      enterStudyingDateFrom(overseasDetails)
      enterStudyingDateTo(overseasDetails)
      selectContactOverseasInstitute(overseasDetails)
    } else radioSelect(residedOutsideStudyingNoId)

  private def enterTravellersName(overseasDetails: OverseasDetails): Unit =
    enterDetails(travellersNameId, overseasDetails.travellersName)

  private def enterTravellersEmail(overseasDetails: OverseasDetails): Unit =
    enterDetails(travellersEmailId, overseasDetails.travellersEmail)

  private def enterTravellersPhone(overseasDetails: OverseasDetails): Unit =
    enterDetails(travellersPhoneId, overseasDetails.travellersPhone)

  private def enterTravelledDateFrom(overseasDetails: OverseasDetails): Unit =
    enterDate(
      overseasDetails.travelledDateFrom,
      travelledDateFromDayId,
      travelledDateFromMonthId,
      travelledDateFromYearId
    )

  private def enterTravelledDateTo(overseasDetails: OverseasDetails): Unit =
    enterDate(overseasDetails.travelledDateTo, travelledDateToDayId, travelledDateToMonthId, travelledDateToYearId)

  private def enterReasonNoContactTraveller(overseasDetails: OverseasDetails): Unit =
    enterDetails(reasonNoContactTravellerId, overseasDetails.reasonNoContactTraveller)

  private def selectContactOverseasTraveller(overseasDetails: OverseasDetails): Unit =
    if (overseasDetails.contactOverseasTraveller) {
      radioSelect(contactTravellerYesId)
    } else {
      radioSelect(contactTravellerNoId)
      enterReasonNoContactTraveller(overseasDetails)
    }

  private def selectResidedOutsideTravelling(overseasDetails: OverseasDetails): Unit =
    if (overseasDetails.residedOutsideTravelling) {
      radioSelect(residedOutsideTravellingYesId)
      enterTravellersName(overseasDetails)
      enterTravellersEmail(overseasDetails)
      enterTravellersPhone(overseasDetails)
      enterTravelledDateFrom(overseasDetails)
      enterTravelledDateTo(overseasDetails)
      selectContactOverseasTraveller(overseasDetails)
    } else radioSelect(residedOutsideTravellingNoId)

  private val overseas: Seq[OverseasDetails => Unit] = Seq(
    overseasPageCheck,
    residedOutsideFlow
  )

  def overseasPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecOverseasCheck.contains("Not Applicable") &&
      vXPecOverseasCheck.contains(s"$vXTypeOfCandidate Candidates")
    ) {
      overseas.foreach { f =>
        f(pecFormDetails.overseasDetails)
      }
      clickOn(pageContinue)
    }
}
