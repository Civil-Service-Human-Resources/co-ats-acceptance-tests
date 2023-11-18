package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CSJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId

case class DiversityMonitoringDetails(
  haveDisability: String,
  yourGender: String,
  sexualOrientation: String,
  currentAgeGroup: String,
  nationalIdentity: String,
  ethnicGroup: String,
  religionOrBelief: String,
  householdEarnerDid: String,
  employeeOrSelfEmployed: String,
  typeOfSchoolAttended: String,
  postcode: Option[String] = None
)

object DiversityMonitoringPage extends CSJobsBasePage {

  private lazy val diversityMonitoringTitle = "Diversity monitoring - Civil Service Jobs - GOV.UK"
  private lazy val firstNameInputId         = s"${formId}_datafield_11625_1_1"

  private def diversityMonitoringPageCheck(): Unit =
    eventually(onPage(diversityMonitoringTitle))

  private def enterPersonalInformation(diversityMonitoringDetails: DiversityMonitoringDetails): Unit =
    diversityMonitoringPageCheck()
//    waitForVisibilityOfElementById(firstNameInputId).getText shouldEqual s"$randomFirstName"

//  private def selectApplyDCS(personalInfoDetails: PersonalInfoDetails): Unit =
  //    if (personalInfoDetails.applyDCS) radioSelect(applyDCSYesId)
  //    else radioSelect(applyDCSNoId)

  private val diversity: Seq[DiversityMonitoringDetails => Unit] = Seq(
    enterPersonalInformation
  )

  def diversityMonitoringPage(shortFormDetails: ShortFormDetails): Unit = {
    diversity.foreach { f =>
      f(shortFormDetails.diversityMonitoringDetails)
    }
    clickOn(pageContinue)
  }
}
