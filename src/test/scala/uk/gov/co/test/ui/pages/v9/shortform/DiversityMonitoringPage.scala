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
  ethnicity: String,
  religionOrBelief: String,
  householdEarnerDid: String,
  employeeOrSelfEmployed: String,
  typeOfSchoolAttended: String,
  postcode: Option[String] = None
)

object DiversityMonitoringPage extends CivilServiceJobsBasePage {

  private lazy val diversityMonitoringTitle          = "Diversity monitoring - Civil Service Jobs - GOV.UK"
  private lazy val haveDisabilityYesId               = s"${formId}_datafield_36491_1_1_729_label"
  private lazy val haveDisabilityNoId                = s"${formId}_datafield_36491_1_1_730_label"
  private lazy val haveDisabilityNotSayId            = s"${formId}_datafield_36491_1_1_731_label"
  private lazy val yourGenderManId                   = s"${formId}_datafield_12784_1_1_27_label"
  private lazy val yourGenderWomanId                 = s"${formId}_datafield_12784_1_1_28_label"
  private lazy val yourGenderSelfDescribeId          = s"${formId}_datafield_12784_1_1_29_label"
  private lazy val yourGenderNotSayId                = s"${formId}_datafield_12784_1_1_30_label"
  private lazy val sexualOrientationStraightId       = s"${formId}_datafield_35296_1_1_4012_label"
  private lazy val sexualOrientationGayId            = s"${formId}_datafield_35296_1_1_4016_label"
  private lazy val sexualOrientationBisexualId       = s"${formId}_datafield_35296_1_1_4015_label"
  private lazy val sexualOrientationSelfDescribeId   = s"${formId}_datafield_35296_1_1_4017_label"
  private lazy val sexualOrientationNotSayId         = s"${formId}_datafield_35296_1_1_15391_label"
  private lazy val currentAgeGroupId                 = s"${formId}_datafield_53438_1_1"
  private lazy val nationalIdentityEnglishId         = s"${formId}_datafield_54157_1_1_14549_label"
  private lazy val nationalIdentityWelshId           = s"${formId}_datafield_54157_1_1_14550_label"
  private lazy val nationalIdentityScottishId        = s"${formId}_datafield_54157_1_1_14551_label"
  private lazy val nationalIdentityNorthernIrishId   = s"${formId}_datafield_54157_1_1_14552_label"
  private lazy val nationalIdentityBritishId         = s"${formId}_datafield_54157_1_1_14553_label"
  private lazy val nationalIdentityOtherId           = s"${formId}_datafield_54157_1_1_14554_label"
  private lazy val nationalIdentityNotSayId          = s"${formId}_datafield_54157_1_1_14555_label"
  private lazy val ethnicGroupId                     = s"${formId}_datafield_53446_1_1"
  private lazy val ethnicityId                       = s"${formId}_datafield_35302_1_1"
  private lazy val religionOrBeliefId                = s"${formId}_datafield_53463_1_1"
  private lazy val householdEarnerDidOption1Id       = s"${formId}_datafield_178072_1_1_48007_label"
  private lazy val householdEarnerDidOption2Id       = s"${formId}_datafield_178072_1_1_48008_label"
  private lazy val householdEarnerDidOption3Id       = s"${formId}_datafield_178072_1_1_48009_label"
  private lazy val householdEarnerDidOption4Id       = s"${formId}_datafield_178072_1_1_48010_label"
  private lazy val householdEarnerDidOption5Id       = s"${formId}_datafield_178072_1_1_48011_label"
  private lazy val householdEarnerDidOption6Id       = s"${formId}_datafield_178072_1_1_48012_label"
  private lazy val householdEarnerDidOption7Id       = s"${formId}_datafield_178072_1_1_48013_label"
  private lazy val householdEarnerDidOption8Id       = s"${formId}_datafield_178072_1_1_48014_label"
  private lazy val householdEarnerDidOption9Id       = s"${formId}_datafield_178072_1_1_48015_label"
  private lazy val householdEarnerDidRetiredId       = s"${formId}_datafield_178072_1_1_48016_label"
  private lazy val householdEarnerDidNotApplicableId = s"${formId}_datafield_178072_1_1_48017_label"
  private lazy val householdEarnerDidDontKnowId      = s"${formId}_datafield_178072_1_1_48018_label"
  private lazy val householdEarnerDidNotSayId        = s"${formId}_datafield_178072_1_1_48019_label"

  private lazy val householdEarnerDidOption1 =
    "Modern professional occupations such as: teacher/lecturer, nurse, physiotherapist, social worker, welfare officer, artist, musician, police officer (sergeant or above), software designer"
  private lazy val householdEarnerDidOption2 =
    "Clerical and intermediate occupations such as: secretary, personal assistant, clerical worker, office clerk, call centre agent, nursing auxiliary, nursery nurse"
  private lazy val householdEarnerDidOption3 =
    "Senior managers and administrators usually responsible for planning, organising and co-ordinating work and for finance such as: finance manager, chief executive"
  private lazy val householdEarnerDidOption4 =
    "Technical and craft occupations such as: motor mechanic, fitter, inspector, plumber, printer, tool maker, electrician, gardener, train driver"
  private lazy val householdEarnerDidOption5 =
    "Semi-routine manual and service occupations such as: postal worker, machine operative, security guard, caretaker, farm worker, catering assistant, receptionist, sales assistant"
  private lazy val householdEarnerDidOption6 =
    "Routine manual and service occupations such as: HGV driver, van driver, cleaner, porter, packer, sewing machinist, messenger, labourer, waiter / waitress, bar staff"
  private lazy val householdEarnerDidOption7 =
    "Middle or junior managers such as: office manager, retail manager, bank manager, restaurant manager, warehouse manager, publican"
  private lazy val householdEarnerDidOption8 =
    "Traditional professional occupations such as: accountant, solicitor, medical practitioner, scientist, civil/mechanical engineer"
  private lazy val householdEarnerDidOption9 =
    "Long term unemployed (claimed Jobseeker's Allowance or earlier unemployment benefit for more than a year)"

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

  private def selectNationalIdentity(diversityDetails: DiversityDetails): Unit =
    diversityDetails.nationalIdentity match {
      case "English"                => radioSelect(nationalIdentityEnglishId)
      case "Welsh"                  => radioSelect(nationalIdentityWelshId)
      case "Scottish"               => radioSelect(nationalIdentityScottishId)
      case "Northern Irish"         => radioSelect(nationalIdentityNorthernIrishId)
      case "British"                => radioSelect(nationalIdentityBritishId)
      case "Other"                  => radioSelect(nationalIdentityOtherId)
      case "Prefer not to disclose" => radioSelect(nationalIdentityNotSayId)
    }

  private def selectEthnicGroup(diversityDetails: DiversityDetails): Unit =
    selectDropdownOption(ethnicGroupId, diversityDetails.ethnicGroup)

  private def selectEthnicity(diversityDetails: DiversityDetails): Unit =
    selectDropdownOption(ethnicityId, diversityDetails.ethnicity)

  private def selectReligionOrBelief(diversityDetails: DiversityDetails): Unit =
    selectDropdownOption(religionOrBeliefId, diversityDetails.religionOrBelief)

  private def selectHouseholdEarnerDid(diversityDetails: DiversityDetails): Unit =
    diversityDetails.householdEarnerDid match {
      case householdEarnerDidOption1 => radioSelect(householdEarnerDidOption1Id)
      case ""                        => radioSelect(nationalIdentityWelshId)
      case "Scottish"                => radioSelect(nationalIdentityScottishId)
      case "Northern Irish"          => radioSelect(nationalIdentityNorthernIrishId)
      case "British"                 => radioSelect(nationalIdentityBritishId)
      case "Other"                   => radioSelect(nationalIdentityOtherId)
      case "Prefer not to disclose"  => radioSelect(nationalIdentityNotSayId)
    }

  private val diversity: Seq[DiversityDetails => Unit] = Seq(
    selectConsiderToHaveDisability,
    selectYourGender,
    selectSexualOrientation,
    selectCurrentAgeGroup,
    selectNationalIdentity,
    selectEthnicGroup,
    selectEthnicity,
    selectReligionOrBelief,
    selectHouseholdEarnerDid
  )

  def diversityMonitoringPage(shortFormDetails: ShortFormDetails): Unit = {
    diversityMonitoringPageCheck()
    diversity.foreach { f =>
      f(shortFormDetails.diversityDetails)
    }
    clickOn(pageContinue)
  }
}
