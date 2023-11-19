package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.pages.v9.shortform.PersonalInfoPage.enterPersonalInfo

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

  private lazy val diversityMonitoringTitle           = "Diversity monitoring - Civil Service Jobs - GOV.UK"
  private lazy val haveDisabilityYesId                = s"${formId}_datafield_36491_1_1_729_label"
  private lazy val haveDisabilityNoId                 = s"${formId}_datafield_36491_1_1_730_label"
  private lazy val haveDisabilityNotSayId             = s"${formId}_datafield_36491_1_1_731_label"
  private lazy val yourGenderManId                    = s"${formId}_datafield_12784_1_1_27_label"
  private lazy val yourGenderWomanId                  = s"${formId}_datafield_12784_1_1_28_label"
  private lazy val yourGenderSelfDescribeId           = s"${formId}_datafield_12784_1_1_29_label"
  private lazy val yourGenderNotSayId                 = s"${formId}_datafield_12784_1_1_30_label"
  private lazy val sexualOrientationStraightId        = s"${formId}_datafield_35296_1_1_4012_label"
  private lazy val sexualOrientationGayId             = s"${formId}_datafield_35296_1_1_4016_label"
  private lazy val sexualOrientationBisexualId        = s"${formId}_datafield_35296_1_1_4015_label"
  private lazy val sexualOrientationSelfDescribeId    = s"${formId}_datafield_35296_1_1_4017_label"
  private lazy val sexualOrientationNotSayId          = s"${formId}_datafield_35296_1_1_15391_label"
  private lazy val currentAgeGroupId                  = s"${formId}_datafield_53438_1_1"
  private lazy val nationalIdentityEnglishId          = s"${formId}_datafield_54157_1_1_14549_label"
  private lazy val nationalIdentityWelshId            = s"${formId}_datafield_54157_1_1_14550_label"
  private lazy val nationalIdentityScottishId         = s"${formId}_datafield_54157_1_1_14551_label"
  private lazy val nationalIdentityNorthernIrishId    = s"${formId}_datafield_54157_1_1_14552_label"
  private lazy val nationalIdentityBritishId          = s"${formId}_datafield_54157_1_1_14553_label"
  private lazy val nationalIdentityOtherId            = s"${formId}_datafield_54157_1_1_14554_label"
  private lazy val nationalIdentityNotSayId           = s"${formId}_datafield_54157_1_1_14555_label"
  private lazy val ethnicGroupId                      = s"${formId}_datafield_53446_1_1"
  private lazy val ethnicityId                        = s"${formId}_datafield_35302_1_1"
  private lazy val religionOrBeliefId                 = s"${formId}_datafield_53463_1_1"
  private lazy val earnerDidModernProfessionalId      = s"${formId}_datafield_178072_1_1_48007_label"
  private lazy val earnerDidClericalId                = s"${formId}_datafield_178072_1_1_48008_label"
  private lazy val earnerDidSeniorId                  = s"${formId}_datafield_178072_1_1_48009_label"
  private lazy val earnerDidTechnicalId               = s"${formId}_datafield_178072_1_1_48010_label"
  private lazy val earnerDidSemiRoutineManualId       = s"${formId}_datafield_178072_1_1_48011_label"
  private lazy val earnerDidRoutineManualId           = s"${formId}_datafield_178072_1_1_48012_label"
  private lazy val earnerDidJuniorId                  = s"${formId}_datafield_178072_1_1_48013_label"
  private lazy val earnerDidTraditionalProfessionalId = s"${formId}_datafield_178072_1_1_48014_label"
  private lazy val earnerDidLongTermUnemployedId      = s"${formId}_datafield_178072_1_1_48015_label"
  private lazy val earnerDidRetiredId                 = s"${formId}_datafield_178072_1_1_48016_label"
  private lazy val earnerDidNotApplicableId           = s"${formId}_datafield_178072_1_1_48017_label"
  private lazy val earnerDidDontKnowId                = s"${formId}_datafield_178072_1_1_48018_label"
  private lazy val earnerDidNotSayId                  = s"${formId}_datafield_178072_1_1_48019_label"
  private lazy val earnerEmploymentEmployeeId         = s"${formId}_datafield_178075_1_1_48020_label"
  private lazy val earnerEmploymentSelfEmployedId     = s"${formId}_datafield_178075_1_1_48021_label"
  private lazy val earnerEmploymentFreelancerId       = s"${formId}_datafield_178075_1_1_48022_label"
  private lazy val earnerEmploymentNotWorkingId       = s"${formId}_datafield_178075_1_1_48023_label"
  private lazy val earnerEmploymentNotApplicableId    = s"${formId}_datafield_178075_1_1_48024_label"
  private lazy val earnerEmploymentDontKnowId         = s"${formId}_datafield_178075_1_1_48025_label"
  private lazy val earnerEmploymentNotSayId           = s"${formId}_datafield_178075_1_1_48026_label"
  private lazy val schoolStateAcademicId              = s"${formId}_datafield_178114_1_1_48027_label"
  private lazy val schoolStateNonSelectiveId          = s"${formId}_datafield_178114_1_1_48028_label"
  private lazy val schoolStateIndependentId           = s"${formId}_datafield_178114_1_1_48029_label"
  private lazy val schoolStateIndependentNonBursaryId = s"${formId}_datafield_178114_1_1_48030_label"
  private lazy val schoolStateOutsideUKId             = s"${formId}_datafield_178114_1_1_48031_label"
  private lazy val schoolStateOtherId                 = s"${formId}_datafield_178114_1_1_48032_label"
  private lazy val schoolStateDontKnowId              = s"${formId}_datafield_178114_1_1_48033_label"
  private lazy val schoolStateNotSayId                = s"${formId}_datafield_178114_1_1_48034_label"
  private lazy val postcodeInputId                    = s"${formId}_datafield_165298_1_1"

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
      case "Modern Professional"      => radioSelect(earnerDidModernProfessionalId)
      case "Clerical"                 => radioSelect(earnerDidClericalId)
      case "Senior"                   => radioSelect(earnerDidSeniorId)
      case "Technical"                => radioSelect(earnerDidTechnicalId)
      case "Semi-Routine Manual"      => radioSelect(earnerDidSemiRoutineManualId)
      case "Routine Manual"           => radioSelect(earnerDidRoutineManualId)
      case "Junior"                   => radioSelect(earnerDidJuniorId)
      case "Traditional Professional" => radioSelect(earnerDidTraditionalProfessionalId)
      case "Long Term Unemployed"     => radioSelect(earnerDidLongTermUnemployedId)
      case "Retired"                  => radioSelect(earnerDidRetiredId)
      case "Not applicable"           => radioSelect(earnerDidNotApplicableId)
      case "Don't know"               => radioSelect(earnerDidDontKnowId)
      case "Prefer not to say"        => radioSelect(earnerDidNotSayId)
    }

  private def selectHouseholdEarnerTypeOfEmployed(diversityDetails: DiversityDetails): Unit =
    diversityDetails.employeeOrSelfEmployed match {
      case "Employee"                                   => radioSelect(earnerEmploymentEmployeeId)
      case "Self-employed with employees"               => radioSelect(earnerEmploymentSelfEmployedId)
      case "Self-employed/freelancer without employees" => radioSelect(earnerEmploymentFreelancerId)
      case "Not working"                                => radioSelect(earnerEmploymentNotWorkingId)
      case "Not applicable"                             => radioSelect(earnerEmploymentNotApplicableId)
      case "Don’t know"                                 => radioSelect(earnerEmploymentDontKnowId)
      case "Prefer not to say"                          => radioSelect(earnerEmploymentNotSayId)
    }

  private def selectTypeOfSchoolAttended(diversityDetails: DiversityDetails): Unit =
    diversityDetails.typeOfSchoolAttended match {
      case "State-run or state-funded school - selective on academic, faith or other grounds" =>
        radioSelect(schoolStateAcademicId)
      case "State-run or state-funded school - non-selective"                                 => radioSelect(schoolStateNonSelectiveId)
      case "Independent or fee-paying school - bursary"                                       => radioSelect(schoolStateIndependentId)
      case "Independent or fee-paying school - no bursary"                                    => radioSelect(schoolStateIndependentNonBursaryId)
      case "Attended school outside the UK"                                                   => radioSelect(schoolStateOutsideUKId)
      case "Other"                                                                            => radioSelect(schoolStateOtherId)
      case "Don’t know"                                                                       => radioSelect(schoolStateDontKnowId)
      case "Prefer not to say"                                                                => radioSelect(schoolStateNotSayId)
    }

  private def enterPostcode(diversityDetails: DiversityDetails): Unit =
    if (extractValue(postcodeInputId).isEmpty) {
      enterPersonalInfo(postcodeInputId, diversityDetails.postcode.get)
    } else extractValue(postcodeInputId) shouldEqual diversityDetails.postcode

  private val diversity: Seq[DiversityDetails => Unit]                = Seq(
    selectConsiderToHaveDisability,
    selectYourGender,
    selectSexualOrientation,
    selectCurrentAgeGroup,
    selectNationalIdentity,
    selectEthnicGroup,
    selectEthnicity,
    selectReligionOrBelief,
    selectHouseholdEarnerDid,
    selectHouseholdEarnerTypeOfEmployed,
    selectTypeOfSchoolAttended,
    enterPostcode
  )

  def diversityMonitoringPage(shortFormDetails: ShortFormDetails): Unit = {
    diversityMonitoringPageCheck()
    diversity.foreach { f =>
      f(shortFormDetails.diversityDetails)
    }
    clickOn(pageContinue)
  }
}
