package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId

case class DiversityDetails(
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

object DiversityMonitoringPage extends CivilServiceJobsBasePage {

  private lazy val diversityMonitoringTitle        = "Diversity monitoring - Civil Service Jobs - GOV.UK"
  private lazy val haveDisabilityYesId             = s"${formId}_datafield_36491_1_1_729_label"
  private lazy val haveDisabilityNoId              = s"${formId}_datafield_36491_1_1_730_label"
  private lazy val haveDisabilityNotSayId          = s"${formId}_datafield_36491_1_1_731_label"
  private lazy val yourGenderManId                 = s"${formId}_datafield_12784_1_1_27_label"
  private lazy val yourGenderWomanId               = s"${formId}_datafield_12784_1_1_28_label"
  private lazy val yourGenderSelfDescribeId        = s"${formId}_datafield_12784_1_1_29_label"
  private lazy val yourGenderNotSayId              = s"${formId}_datafield_12784_1_1_30_label"
  private lazy val sexualOrientationStraightId     = s"${formId}_datafield_35296_1_1_4012_label"
  private lazy val sexualOrientationGayId          = s"${formId}_datafield_35296_1_1_4016_label"
  private lazy val sexualOrientationBisexualId     = s"${formId}_datafield_35296_1_1_4015_label"
  private lazy val sexualOrientationSelfDescribeId = s"${formId}_datafield_35296_1_1_4017_label"
  private lazy val sexualOrientationNotSayId       = s"${formId}_datafield_35296_1_1_15391_label"
  private lazy val currentAgeGroupId               = s"${formId}_datafield_53438_1_1"

  private def diversityMonitoringPageCheck(): Unit =
    eventually(onPage(diversityMonitoringTitle))

  private def selectConsiderToHaveDisability(diversityDetails: DiversityDetails): Unit =
    diversityDetails.haveDisability match {
      case "Yes"                    => radioSelect(haveDisabilityYesId)
      case "No"                     => radioSelect(haveDisabilityNoId)
      case "Prefer not to disclose" => radioSelect(haveDisabilityNotSayId)
    }

  private def selectYourGender(diversityDetails: DiversityDetails): Unit =
    diversityDetails.yourGender match {
      case "Man"                     => radioSelect(yourGenderManId)
      case "Woman"                   => radioSelect(yourGenderWomanId)
      case "Prefer to self-describe" => radioSelect(yourGenderSelfDescribeId)
      case "Prefer not to disclose"  => radioSelect(yourGenderNotSayId)
    }

  private def selectSexualOrientation(diversityDetails: DiversityDetails): Unit =
    diversityDetails.sexualOrientation match {
      case "Heterosexual or straight" => radioSelect(sexualOrientationStraightId)
      case "Gay or lesbian"           => radioSelect(sexualOrientationGayId)
      case "Bisexual"                 => radioSelect(sexualOrientationBisexualId)
      case "Prefer to self-describe"  => radioSelect(sexualOrientationSelfDescribeId)
      case "Prefer not to disclose"   => radioSelect(sexualOrientationNotSayId)
    }

  private def selectCurrentAgeGroup(diversityDetails: DiversityDetails): Unit =
    selectDropdownOption(currentAgeGroupId, diversityDetails.currentAgeGroup)

  private val diversity: Seq[DiversityDetails => Unit] = Seq(
    selectConsiderToHaveDisability,
    selectYourGender,
    selectSexualOrientation,
    selectCurrentAgeGroup
  )

  def diversityMonitoringPage(shortFormDetails: ShortFormDetails): Unit = {
    diversityMonitoringPageCheck()
    diversity.foreach { f =>
      f(shortFormDetails.diversityDetails)
    }
    clickOn(pageContinue)
  }
}
