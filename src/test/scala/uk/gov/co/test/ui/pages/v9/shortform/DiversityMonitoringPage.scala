package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9RunInWelsh, vXVacanciesInNIR}
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.shortFormId

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
  postcode: Option[String] = None,
  applyingInNIR: Boolean,
  communityInNIR: String
)

object DiversityMonitoringPage extends CivilServiceJobsBasePage {

  def diversityMonitoringTitle           = "Diversity monitoring - Civil Service Jobs - GOV.UK"
  def welshDiversityMonitoringTitle      = "Monitro Amrywiaeth - Civil Service Jobs - GOV.UK"
  def haveDisabilityYesId                = s"${shortFormId}_datafield_36491_1_1_729_label"
  def haveDisabilityNoId                 = s"${shortFormId}_datafield_36491_1_1_730_label"
  def haveDisabilityNotSayId             = s"${shortFormId}_datafield_36491_1_1_731_label"
  def yourGenderManId                    = s"${shortFormId}_datafield_12784_1_1_27_label"
  def yourGenderWomanId                  = s"${shortFormId}_datafield_12784_1_1_28_label"
  def yourGenderSelfDescribeId           = s"${shortFormId}_datafield_12784_1_1_29_label"
  def yourGenderNotSayId                 = s"${shortFormId}_datafield_12784_1_1_30_label"
  def sexualOrientationStraightId        = s"${shortFormId}_datafield_35296_1_1_4012_label"
  def sexualOrientationGayId             = s"${shortFormId}_datafield_35296_1_1_4016_label"
  def sexualOrientationBisexualId        = s"${shortFormId}_datafield_35296_1_1_4015_label"
  def sexualOrientationSelfDescribeId    = s"${shortFormId}_datafield_35296_1_1_4017_label"
  def sexualOrientationNotSayId          = s"${shortFormId}_datafield_35296_1_1_15391_label"
  def currentAgeGroupId                  = s"${shortFormId}_datafield_53438_1_1"
  def nationalIdentityEnglishId          = s"${shortFormId}_datafield_54157_1_1_14549_label"
  def nationalIdentityWelshId            = s"${shortFormId}_datafield_54157_1_1_14550_label"
  def nationalIdentityScottishId         = s"${shortFormId}_datafield_54157_1_1_14551_label"
  def nationalIdentityNorthernIrishId    = s"${shortFormId}_datafield_54157_1_1_14552_label"
  def nationalIdentityBritishId          = s"${shortFormId}_datafield_54157_1_1_14553_label"
  def nationalIdentityOtherId            = s"${shortFormId}_datafield_54157_1_1_14554_label"
  def nationalIdentityNotSayId           = s"${shortFormId}_datafield_54157_1_1_14555_label"
  def ethnicGroupId                      = s"${shortFormId}_datafield_53446_1_1"
  def ethnicityId                        = s"${shortFormId}_datafield_35302_1_1"
  def religionOrBeliefId                 = s"${shortFormId}_datafield_53463_1_1"
  def earnerDidModernProfessionalId      = s"${shortFormId}_datafield_178072_1_1_48007_label"
  def earnerDidClericalId                = s"${shortFormId}_datafield_178072_1_1_48008_label"
  def earnerDidSeniorId                  = s"${shortFormId}_datafield_178072_1_1_48009_label"
  def earnerDidTechnicalId               = s"${shortFormId}_datafield_178072_1_1_48010_label"
  def earnerDidSemiRoutineManualId       = s"${shortFormId}_datafield_178072_1_1_48011_label"
  def earnerDidRoutineManualId           = s"${shortFormId}_datafield_178072_1_1_48012_label"
  def earnerDidJuniorId                  = s"${shortFormId}_datafield_178072_1_1_48013_label"
  def earnerDidTraditionalProfessionalId = s"${shortFormId}_datafield_178072_1_1_48014_label"
  def earnerDidLongTermUnemployedId      = s"${shortFormId}_datafield_178072_1_1_48015_label"
  def earnerDidRetiredId                 = s"${shortFormId}_datafield_178072_1_1_48016_label"
  def earnerDidNotApplicableId           = s"${shortFormId}_datafield_178072_1_1_48017_label"
  def earnerDidDontKnowId                = s"${shortFormId}_datafield_178072_1_1_48018_label"
  def earnerDidNotSayId                  = s"${shortFormId}_datafield_178072_1_1_48019_label"
  def earnerEmploymentEmployeeId         = s"${shortFormId}_datafield_178075_1_1_48020_label"
  def earnerEmploymentSelfEmployedId     = s"${shortFormId}_datafield_178075_1_1_48021_label"
  def earnerEmploymentFreelancerId       = s"${shortFormId}_datafield_178075_1_1_48022_label"
  def earnerEmploymentNotWorkingId       = s"${shortFormId}_datafield_178075_1_1_48023_label"
  def earnerEmploymentNotApplicableId    = s"${shortFormId}_datafield_178075_1_1_48024_label"
  def earnerEmploymentDontKnowId         = s"${shortFormId}_datafield_178075_1_1_48025_label"
  def earnerEmploymentNotSayId           = s"${shortFormId}_datafield_178075_1_1_48026_label"
  def schoolStateAcademicId              = s"${shortFormId}_datafield_178114_1_1_48027_label"
  def schoolStateNonSelectiveId          = s"${shortFormId}_datafield_178114_1_1_48028_label"
  def schoolStateIndependentId           = s"${shortFormId}_datafield_178114_1_1_48029_label"
  def schoolStateIndependentNonBursaryId = s"${shortFormId}_datafield_178114_1_1_48030_label"
  def schoolStateOutsideUKId             = s"${shortFormId}_datafield_178114_1_1_48031_label"
  def schoolStateOtherId                 = s"${shortFormId}_datafield_178114_1_1_48032_label"
  def schoolStateDontKnowId              = s"${shortFormId}_datafield_178114_1_1_48033_label"
  def schoolStateNotSayId                = s"${shortFormId}_datafield_178114_1_1_48034_label"
  def postcodeInputId                    = s"${shortFormId}_datafield_165298_1_1"
  def otherEthnicityInputId              = s"${shortFormId}_datafield_35261_1_1"
  def vacancyInNIRYesId                  = s"${shortFormId}_datafield_145466_1_1_1_label"
  def vacancyInNIRNoId                   = s"${shortFormId}_datafield_145466_1_1_2_label"
  def protestantCommunityId              = s"${shortFormId}_datafield_22678_1_1_801_label"
  def romanCatholicCommunityId           = s"${shortFormId}_datafield_22678_1_1_802_label"
  def notProtestantOrRomanCatholicId     = s"${shortFormId}_datafield_22678_1_1_803_label"

  private def diversityMonitoringPageCheck(): Unit =
    if (v9RunInWelsh) eventually(onPage(welshDiversityMonitoringTitle))
    else eventually(onPage(diversityMonitoringTitle))

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
    if (v9RunInWelsh) selectDropdownOption(ethnicGroupId, "Asiaidd / Asiaidd Prydeinig")
    else selectDropdownOption(ethnicGroupId, diversityDetails.ethnicGroup)

  private def selectEthnicity(diversityDetails: DiversityDetails): Unit = {
    val ethnic = diversityDetails.ethnicity(diversityDetails.ethnicGroup).tail.head
    if (v9RunInWelsh) selectDropdownOption(ethnicityId, "Asiaidd neu Asiaidd Prydeinig - Bangladeshaidd")
    else selectDropdownOption(ethnicityId, ethnic)
    if (
      ethnic == "Other ethnic group" || ethnic == "Any other White background" || ethnic == "Any other Mixed background" ||
      ethnic == "Any other Asian background" || ethnic == "Any other Black background"
    ) {
      enterDetails(otherEthnicityInputId, diversityDetails.otherEthnicity)
    }
  }

  private def selectReligionOrBelief(diversityDetails: DiversityDetails): Unit =
    if (v9RunInWelsh) selectDropdownOption(religionOrBeliefId, "Mwslim")
    else selectDropdownOption(religionOrBeliefId, diversityDetails.religionOrBelief)

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

  private def enterPostcode(diversityDetails: DiversityDetails): Unit       =
    if (extractValue(postcodeInputId).isEmpty) {
      enterDetails(postcodeInputId, diversityDetails.postcode.get)
    } else extractValue(postcodeInputId) shouldEqual diversityDetails.postcode

  private def selectApplyingInNIR(diversityDetails: DiversityDetails): Unit =
    if (vXVacanciesInNIR) {
      if (diversityDetails.applyingInNIR) {
        radioSelect(vacancyInNIRYesId)
        diversityDetails.communityInNIR match {
          case "Protestant"                       => radioSelect(protestantCommunityId)
          case "Roman Catholic"                   => radioSelect(romanCatholicCommunityId)
          case "Not Protestant or Roman Catholic" => radioSelect(notProtestantOrRomanCatholicId)
        }
      } else radioSelect(vacancyInNIRNoId)
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
    selectHouseholdEarnerDid,
    selectHouseholdEarnerTypeOfEmployed,
    selectTypeOfSchoolAttended,
    enterPostcode,
    selectApplyingInNIR
  )

  def diversityMonitoringPage(shortFormDetails: ShortFormDetails): Unit = {
    diversityMonitoringPageCheck()
    diversity.foreach { f =>
      f(shortFormDetails.diversityDetails)
    }
    clickOn(pageContinue)
  }
}
