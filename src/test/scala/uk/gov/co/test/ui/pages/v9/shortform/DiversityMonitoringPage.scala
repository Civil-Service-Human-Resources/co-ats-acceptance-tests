package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
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
  ethnicity: Map[String, List[String]],
  otherEthnicity: String,
  religionOrBelief: String,
  householdEarnerDid: String,
  employeeOrSelfEmployed: String,
  typeOfSchoolAttended: String,
  postcode: Option[String] = None
)

object DiversityMonitoringPage extends CivilServiceJobsBasePage {

  def diversityMonitoringTitle           = "Diversity monitoring - Civil Service Jobs - GOV.UK"
  def haveDisabilityYesId                = s"${formId}_datafield_36491_1_1_729_label"
  def haveDisabilityNoId                 = s"${formId}_datafield_36491_1_1_730_label"
  def haveDisabilityNotSayId             = s"${formId}_datafield_36491_1_1_731_label"
  def yourGenderManId                    = s"${formId}_datafield_12784_1_1_27_label"
  def yourGenderWomanId                  = s"${formId}_datafield_12784_1_1_28_label"
  def yourGenderSelfDescribeId           = s"${formId}_datafield_12784_1_1_29_label"
  def yourGenderNotSayId                 = s"${formId}_datafield_12784_1_1_30_label"
  def sexualOrientationStraightId        = s"${formId}_datafield_35296_1_1_4012_label"
  def sexualOrientationGayId             = s"${formId}_datafield_35296_1_1_4016_label"
  def sexualOrientationBisexualId        = s"${formId}_datafield_35296_1_1_4015_label"
  def sexualOrientationSelfDescribeId    = s"${formId}_datafield_35296_1_1_4017_label"
  def sexualOrientationNotSayId          = s"${formId}_datafield_35296_1_1_15391_label"
  def currentAgeGroupId                  = s"${formId}_datafield_53438_1_1"
  def nationalIdentityEnglishId          = s"${formId}_datafield_54157_1_1_14549_label"
  def nationalIdentityWelshId            = s"${formId}_datafield_54157_1_1_14550_label"
  def nationalIdentityScottishId         = s"${formId}_datafield_54157_1_1_14551_label"
  def nationalIdentityNorthernIrishId    = s"${formId}_datafield_54157_1_1_14552_label"
  def nationalIdentityBritishId          = s"${formId}_datafield_54157_1_1_14553_label"
  def nationalIdentityOtherId            = s"${formId}_datafield_54157_1_1_14554_label"
  def nationalIdentityNotSayId           = s"${formId}_datafield_54157_1_1_14555_label"
  def ethnicGroupId                      = s"${formId}_datafield_53446_1_1"
  def ethnicityId                        = s"${formId}_datafield_35302_1_1"
  def religionOrBeliefId                 = s"${formId}_datafield_53463_1_1"
  def earnerDidModernProfessionalId      = s"${formId}_datafield_178072_1_1_48007_label"
  def earnerDidClericalId                = s"${formId}_datafield_178072_1_1_48008_label"
  def earnerDidSeniorId                  = s"${formId}_datafield_178072_1_1_48009_label"
  def earnerDidTechnicalId               = s"${formId}_datafield_178072_1_1_48010_label"
  def earnerDidSemiRoutineManualId       = s"${formId}_datafield_178072_1_1_48011_label"
  def earnerDidRoutineManualId           = s"${formId}_datafield_178072_1_1_48012_label"
  def earnerDidJuniorId                  = s"${formId}_datafield_178072_1_1_48013_label"
  def earnerDidTraditionalProfessionalId = s"${formId}_datafield_178072_1_1_48014_label"
  def earnerDidLongTermUnemployedId      = s"${formId}_datafield_178072_1_1_48015_label"
  def earnerDidRetiredId                 = s"${formId}_datafield_178072_1_1_48016_label"
  def earnerDidNotApplicableId           = s"${formId}_datafield_178072_1_1_48017_label"
  def earnerDidDontKnowId                = s"${formId}_datafield_178072_1_1_48018_label"
  def earnerDidNotSayId                  = s"${formId}_datafield_178072_1_1_48019_label"
  def earnerEmploymentEmployeeId         = s"${formId}_datafield_178075_1_1_48020_label"
  def earnerEmploymentSelfEmployedId     = s"${formId}_datafield_178075_1_1_48021_label"
  def earnerEmploymentFreelancerId       = s"${formId}_datafield_178075_1_1_48022_label"
  def earnerEmploymentNotWorkingId       = s"${formId}_datafield_178075_1_1_48023_label"
  def earnerEmploymentNotApplicableId    = s"${formId}_datafield_178075_1_1_48024_label"
  def earnerEmploymentDontKnowId         = s"${formId}_datafield_178075_1_1_48025_label"
  def earnerEmploymentNotSayId           = s"${formId}_datafield_178075_1_1_48026_label"
  def schoolStateAcademicId              = s"${formId}_datafield_178114_1_1_48027_label"
  def schoolStateNonSelectiveId          = s"${formId}_datafield_178114_1_1_48028_label"
  def schoolStateIndependentId           = s"${formId}_datafield_178114_1_1_48029_label"
  def schoolStateIndependentNonBursaryId = s"${formId}_datafield_178114_1_1_48030_label"
  def schoolStateOutsideUKId             = s"${formId}_datafield_178114_1_1_48031_label"
  def schoolStateOtherId                 = s"${formId}_datafield_178114_1_1_48032_label"
  def schoolStateDontKnowId              = s"${formId}_datafield_178114_1_1_48033_label"
  def schoolStateNotSayId                = s"${formId}_datafield_178114_1_1_48034_label"
  def postcodeInputId                    = s"${formId}_datafield_165298_1_1"
  def otherEthnicityInputId              = s"${formId}_datafield_35261_1_1"

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

  private def selectEthnicity(diversityDetails: DiversityDetails): Unit = {
    val ethnic = diversityDetails.ethnicity(diversityDetails.ethnicGroup).tail.head
    selectDropdownOption(ethnicityId, ethnic)
    if (
      ethnic == "Other ethnic group" || ethnic == "Any other White background" || ethnic == "Any other Mixed background" ||
      ethnic == "Any other Asian background" || ethnic == "Any other Black background"
    ) {
      enterPersonalInfo(otherEthnicityInputId, diversityDetails.otherEthnicity)
    }
  }

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
