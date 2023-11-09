package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, Keys, WebElement}
import org.scalatest.concurrent.Eventually.eventually

import java.time.LocalDate
import java.time.format.DateTimeFormatter

//case class AbilitiesDetails(assessAbilities: String)
//
//case class Behaviours(chosenBehaviour: String, stageApplication: Boolean, stageInterview: Boolean)
//
//case class BehavioursDetails(
//  assessBehaviours: String,
//  howManyAssessed: Int,
//  behaviourOne: Option[Behaviours] = None,
//  behaviourTwo: Option[Behaviours] = None,
//  behaviourThree: Option[Behaviours] = None,
//  behaviourFour: Option[Behaviours] = None,
//  behaviourFive: Option[Behaviours] = None,
//  behaviourSix: Option[Behaviours] = None,
//  behaviourSeven: Option[Behaviours] = None,
//  behaviourEight: Option[Behaviours] = None
//)

//case class MandatoryRequirements(requirements: Boolean, requirementsInfo: String)

//case class ExperienceDetails(
//  provideCV: Boolean,
//  cvScoreRange: String,
//  cvJobHistory: Boolean,
//  cvQualifications: Boolean,
//  cvPreviousSkills: Boolean,
//  provideStatement: Boolean,
//  statementScoreRange: String,
//  statementWordLimit: Int,
//  statementGuidance: Boolean,
//  statementGuidanceText: String,
//  pastExperience: Boolean,
//  pastExperienceText: String,
//  licences: Option[MandatoryRequirements] = None,
//  memberships: Option[MandatoryRequirements] = None,
//  languages: Option[MandatoryRequirements] = None,
//  qualifications: Option[MandatoryRequirements] = None
//)

//case class MandatoryRequirements(requirements: Boolean, requirementsInfo: String)
//
//case class ExperienceDetails(
//  provideCV: Boolean,
//  cvScoreRange: String,
//  cvJobHistory: Boolean,
//  cvQualifications: Boolean,
//  cvPreviousSkills: Boolean,
//  provideStatement: Boolean,
//  statementScoreRange: String,
//  statementWordLimit: Int,
//  statementGuidance: Boolean,
//  statementGuidanceText: String,
//  pastExperience: Boolean,
//  pastExperienceText: String,
//  licences: Option[MandatoryRequirements] = None,
//  memberships: Option[MandatoryRequirements] = None,
//  languages: Option[MandatoryRequirements] = None,
//  qualifications: Option[MandatoryRequirements] = None
//)

case class MasterVacancyDetails(
  template: String,
  vacancyTitle: String,
  closingDate: Int,
  displayWelsh: Boolean,
  department: String,
  businessArea: String,
  businessAreaDetail: String,
  typeOfRole: String,
  whichProfession: String,
  noOfJobs: String,
  approach: String,
  statementRequired: Boolean,
  statement: String,
  approval: Boolean,
  budgetaryAuthInfo: String,
  costCentre: String,
  reserveList: Boolean,
  reserveListLength: String,
  locationType: String,
  postcodes: String,
  cityOrTown: String,
  region: String,
  overseas: String,
  locationOverride: String,
  vacancyInNIR: Boolean,
  openOutsideNIR: Boolean,
  whichCommunityEncouraged: String,
  giveLocationPreference: Boolean,
  maxLocations: String,
  otherCityOrTown: Vector[String],
  contractType: String,
  workingPattern: String,
  jobGrade: String,
  equivalentGrade: String,
  currency: String,
  minimumSalary: Int,
  maximumSalary: Int,
  moreDetails: String,
  civilServicePension: Boolean,
  employerContribution: Int,
  jobSummary: String,
  jobDescription: String,
  personSpecification: String,
  offeredBenefits: String,
  selectionProcess: String,
  contactName: String,
  contactEmail: String,
  contactPhone: String,
  vacancyHolderName: String,
  vacancyHolderEmail: String,
  vacancyTeamEmail: String,
  reservedStatus: Boolean,
  checkLevelRequired: String,
  whichProvider: String,
  vettingLevelRequired: String,
  medicalRequired: Boolean,
  expectedRounds: String,
  interviewOneType: String,
  interviewTwoType: String,
  interviewThreeType: String,
  interviewFourType: String,
  availableOffline: Boolean
//  abilities: Boolean,
//  behaviours: Boolean,
//  experience: Boolean,
//  strengths: Boolean,
//  technicalSkills: Boolean,
//  abilitiesSection: Option[AbilitiesDetails] = None,
//  behavioursSection: Option[BehavioursDetails] = None,
//  experienceSection: Option[ExperienceDetails] = None
)

object MasterVacancyPage extends VacancyBasePage {

  private lazy val createVacancyTitle = "Create New Vacancy : Civil Service Jobs - GOV.UK"
  private var formId: String          = ""

  private lazy val displayWelshPath               = ".//input[@name='datafield_179408_1_1']"
  private lazy val closingDateId                  = "edit_opp_form_pcd"
  private lazy val selectTemplatePath             = "//*[@id='select2-edit_opp_form_template_id-container']"
  private lazy val enterTemplatePath              = ".//input[@class='select2-search__field']"
  private lazy val newVacancyPath                 = ".//a[contains(@href,'recruiter/opportunities/vacancy/create')]"
  private lazy val vacancySectionPath             = "//*[@id='lm-vacancies']/h3/a"
  private lazy val extractFormClass               = "opp_form_bd"
  private lazy val businessAreaId                 = s"select2-${formId}_datafield_155221_1_1-container"
  private lazy val whichProfessionId              = s"select2-${formId}_datafield_155435_1_1-container"
  private lazy val noOfJobsId                     = s"${formId}_datafield_155332_1_1"
  private lazy val typeOfRoleId                   = s"select2-${formId}_datafield_155369_1_1-container"
  private lazy val typeOfRoleInput                = s".//*[@aria-describedby='$typeOfRoleId']"
  private lazy val welshRequiredCheck             = s"${formId}_datafield_179408_1_1"
  private lazy val businessAreaDetailId           = s"${formId}_datafield_155206_1_1_en-GB"
  private lazy val approachId                     = s"${formId}_field_154380_1"
  private lazy val statementId                    = s"${formId}_datafield_154373_1_1_en-GB"
  private lazy val prereleaseId                   = s"${formId}_datafield_154380_1_1_12648"
  private lazy val internalId                     = s"${formId}_datafield_154380_1_1_11773"
  private lazy val acrossGovernmentId             = s"${formId}_datafield_154380_1_1_12649"
  private lazy val acrossGovernmentYesStatementId = s"${formId}_datafield_154384_1_1_1"
  private lazy val acrossGovernmentNoStatementId  = s"${formId}_datafield_154384_1_1_2"
  private lazy val externalId                     = s"${formId}_datafield_154380_1_1_11774"
  private lazy val internalYesStatementId         = s"${formId}_datafield_154388_1_1_1"
  private lazy val internalNoStatementId          = s"${formId}_datafield_154388_1_1_2"
  private lazy val budgetaryInfoId                = s"${formId}_datafield_154500_1_1"
  private lazy val costCentreId                   = s"${formId}_datafield_154493_1_1"
  private lazy val approvalId                     = s"${formId}_field_154507_1"
  private lazy val approvalYesId                  = s"${formId}_datafield_154507_1_1_1"
  private lazy val approvalNoId                   = s"${formId}_datafield_154507_1_1_2"
  private lazy val reserveListId                  = s"${formId}_field_154633_1"
  private lazy val reserveListYesId               = s"${formId}_datafield_154633_1_1_1"
  private lazy val reserveListNoId                = s"${formId}_datafield_154633_1_1_2"
  private lazy val reserveListLengthId            = s"select2-${formId}_datafield_154637_1_1-container"
  private lazy val generalInput                   = "//input[@class='select2-search__field']"
  private lazy val cityOrTownInput                = s".//*[@aria-describedby='select2-${formId}_datafield_155622_1_1-container']"
  private lazy val otherCityOrTownInput           =
    s".//textarea[@aria-describedby='select2-${formId}_datafield_155836_1_1-container']"
  private lazy val locationTypeId                 = s"select2-${formId}_datafield_155639_1_1-container"
  private lazy val overseasId                     = s"select2-${formId}_datafield_155904_1_1-container"
  private lazy val regionInput                    = s".//*[@aria-describedby='select2-${formId}_datafield_155584_1_1-container']"
  private lazy val postcodeId                     = s"${formId}_datafield_155601_1_1"
  private lazy val northernIrelandId              = s"${formId}_datafield_155854_1_1_fieldset"
  private lazy val northernIrelandYesId           = s"${formId}_datafield_155854_1_1_1"
  private lazy val northernIrelandNoId            = s"${formId}_datafield_155854_1_1_2"
  private lazy val outsideNIRYesId                = s"${formId}_datafield_155922_1_1_1"
  private lazy val outsideNIRNoId                 = s"${formId}_datafield_155922_1_1_1"
  private lazy val protestantId                   = s"${formId}_datafield_155869_1_1_15462"
  private lazy val romanCatholicId                = s"${formId}_datafield_155869_1_1_15463"
  private lazy val allCommunitiesId               = s"${formId}_datafield_155869_1_1_17360"
  private lazy val locationOverrideInput          = s"${formId}_datafield_155654_1_1_en-GB"
  private lazy val locationPreferenceNoId         = s"${formId}_datafield_155799_1_1_2"
  private lazy val locationPreferenceYesId        = s"${formId}_datafield_155799_1_1_1"
  private lazy val maxLocationId                  = s"select2-${formId}_datafield_155818_1_1-container"
  private lazy val contractTypeId                 = s"select2-${formId}_datafield_154977_1_1-container"
  private lazy val currencyId                     = s"select2-${formId}_datafield_155065_1_1-container"
  private lazy val workingPatternId               = s"select2-${formId}_datafield_154969_1_1-container"
  private lazy val jobGradeId                     = s"select2-${formId}_datafield_154973_1_1-container"
  private lazy val contractTypeInput              = s".//*[@aria-describedby='$contractTypeId']"
  private lazy val workingPatternInput            = s".//*[@aria-describedby='$workingPatternId']"
  private lazy val jobGradeInput                  = s".//*[@aria-describedby='$jobGradeId']"
  private lazy val equivalentGradeId              = s"${formId}_datafield_154981_1_1_en-GB"
  private lazy val minimumSalaryId                = s"${formId}_datafield_155044_1_1"
  private lazy val maximumSalaryId                = s"${formId}_datafield_155051_1_1"
  private lazy val moreDetailsId                  = s"${formId}_datafield_155058_1_1_en-GB"
  private lazy val civilServiceId                 = s"${formId}_field_value_198564_1"
  private lazy val civilServicePensionYesId       = s"${formId}_datafield_198564_1_1_1"
  private lazy val civilServicePensionNoId        = s"${formId}_datafield_198564_1_1_2"
  private lazy val employerContributionInput      = s"${formId}_datafield_198577_1_1"
  private lazy val jobSummaryId                   = s"${formId}_datafield_51753_1_1_en-GB_ifr"
  private lazy val jobDescriptionId               = s"${formId}_field_value_51761_1"
  private lazy val personSpecsIframe              = s"${formId}_datafield_51767_1_1_en-GB_ifr"
  private lazy val offeredBenefitsIframe          = s"${formId}_datafield_62219_1_1_en-GB_ifr"
  private lazy val selectionProcessIframe         = s"${formId}_datafield_59678_1_1_en-GB_ifr"
  private lazy val jobSummaryPath                 = s".//body[@data-id='${formId}_datafield_51753_1_1_en-GB']"
  private lazy val jobDescriptionPath             = s".//body[@data-id='${formId}_datafield_51761_1_1_en-GB']"
  private lazy val personSpecsPath                = s".//body[@data-id='${formId}_datafield_51767_1_1_en-GB']"
  private lazy val offeredBenefitsPath            = s".//body[@data-id='${formId}_datafield_62219_1_1_en-GB']"
  private lazy val selectionProcessPath           = s".//body[@data-id='${formId}_datafield_59678_1_1_en-GB']"
  private lazy val jobSummaryIframe               = s"${formId}_datafield_51753_1_1_en-GB_ifr"
  private lazy val jobDescriptionIframe           = s"${formId}_datafield_51761_1_1_en-GB_ifr"
  private lazy val contactNameId                  = s"${formId}_field_value_59444_1"
  private lazy val contactEmailInput              = s"${formId}_datafield_59457_1_1"
  private lazy val vacancyHolderNameId            = s"${formId}_field_value_115926_1"
  private lazy val contactNameInput               = s"${formId}_datafield_59444_1_1"
  private lazy val contactPhoneInput              = s"${formId}_datafield_101571_1_1"
  private lazy val vacancyHolderNameInput         = s"${formId}_datafield_115926_1_1"
  private lazy val vacancyHolderEmailInput        = s"${formId}_datafield_115708_1_1"
  private lazy val vacancyTeamEmailInput          = s"${formId}_datafield_59450_1_1"
  private lazy val reservedStatusId               = s"${formId}_datafield_59601_1_1_fieldset"
  private lazy val reservedYesId                  = s"${formId}_datafield_59601_1_1_868"
  private lazy val reservedNoId                   = s"${formId}_datafield_59601_1_1_869"
  private lazy val basicCheckId                   = s"${formId}_datafield_59611_1_1_12650"
  private lazy val standardCheckId                = s"${formId}_datafield_59611_1_1_11340"
  private lazy val enhancedCheckId                = s"${formId}_datafield_59611_1_1_11341"
  private lazy val noCheckRequiredId              = s"${formId}_datafield_59611_1_1_15464"
  private lazy val dbsProviderId                  = s"${formId}_datafield_97307_1_1_15345"
  private lazy val disclosureScotlandProviderId   = s"${formId}_datafield_97307_1_1_15346"
  private lazy val accessNIProviderId             = s"${formId}_datafield_97307_1_1_15346"
  private lazy val vettingRequiredId              = s"${formId}_field_value_93637_1"
  private lazy val counterTerroristCheckId        = s"${formId}_datafield_93637_1_1_15342"
  private lazy val securityCheckId                = s"${formId}_datafield_93637_1_1_15343"
  private lazy val developedVettingId             = s"${formId}_datafield_93637_1_1_15344"
  private lazy val noVettingRequiredId            = s"${formId}_datafield_93637_1_1_15341"
  private lazy val medicalRequiredYesId           = s"${formId}_datafield_59608_1_1_1"
  private lazy val medicalRequiredNoId            = s"${formId}_datafield_59608_1_1_2"
  private lazy val noInterviewsId                 = s"${formId}_datafield_91703_1_1_15327"
  private lazy val oneInterviewId                 = s"${formId}_datafield_91703_1_1_15328"
  private lazy val twoInterviewId                 = s"${formId}_datafield_91703_1_1_15329"
  private lazy val threeInterviewId               = s"${formId}_datafield_91703_1_1_15330"
  private lazy val fourInterviewId                = s"${formId}_datafield_91703_1_1_15331"
  private lazy val availableOfflineYesId          = s"${formId}_datafield_125052_1_1_1"
  private lazy val availableOfflineNoId           = s"${formId}_datafield_125052_1_1_2"
  private lazy val assessmentOneId                = s"${formId}_datafield_125056_1_1_17756"
  private lazy val interviewOneId                 = s"${formId}_datafield_125056_1_1_17753"
  private lazy val telephoneOneId                 = s"${formId}_datafield_125056_1_1_17755"
  private lazy val videoOneId                     = s"${formId}_datafield_125056_1_1_17754"
  private lazy val assessmentTwoId                = s"${formId}_datafield_125060_1_1_17756"
  private lazy val interviewTwoId                 = s"${formId}_datafield_125060_1_1_17753"
  private lazy val telephoneTwoId                 = s"${formId}_datafield_125060_1_1_17755"
  private lazy val videoTwoId                     = s"${formId}_datafield_125060_1_1_17754"
  private lazy val assessmentThreeId              = s"${formId}_datafield_125063_1_1_17756"
  private lazy val interviewThreeId               = s"${formId}_datafield_125063_1_1_17753"
  private lazy val telephoneThreeId               = s"${formId}_datafield_125063_1_1_17755"
  private lazy val videoThreeId                   = s"${formId}_datafield_125063_1_1_17754"
  private lazy val assessmentFourId               = s"${formId}_datafield_125066_1_1_17756"
  private lazy val interviewFourId                = s"${formId}_datafield_125066_1_1_17753"
  private lazy val telephoneFourId                = s"${formId}_datafield_125066_1_1_17755"
  private lazy val videoFourId                    = s"${formId}_datafield_125066_1_1_17754"
  private lazy val abilitiesId                    = s"${formId}_datafield_154245_1_1_12685"
  private lazy val behavioursId                   = s"${formId}_datafield_154245_1_1_12686"
  private lazy val experienceId                   = s"${formId}_datafield_154245_1_1_12687"
  private lazy val strengthsId                    = s"${formId}_datafield_154245_1_1_12689"
  private lazy val technicalSkillsId              = s"${formId}_datafield_154245_1_1_12688"
  private lazy val abilitiesSectionId             = s"${formId}_section_76647_col_0"
  private lazy val assessAbilitiesId              = s"${formId}_label_130464_1"
  private lazy val behavioursSectionId            = s"${formId}_section_60310_col_0"
  private lazy val howManyBehavioursId            = s"select2-${formId}_datafield_60326_1_1-container"
  private lazy val successProfilesSectionId       = s"${formId}_section_154224_col_0"
  private lazy val assessBehavioursId             = s"${formId}_label_130493_1"
  private lazy val behavioursOneId                = s"select2-${formId}_datafield_60342_1_1-container"
  private lazy val behavioursTwoId                = s"select2-${formId}_datafield_60356_1_1-container"
  private lazy val behavioursThreeId              = s"select2-${formId}_datafield_60370_1_1-container"
  private lazy val behavioursFourId               = s"select2-${formId}_datafield_60384_1_1-container"
  private lazy val behavioursFiveId               = s"select2-${formId}_datafield_60398_1_1-container"
  private lazy val behavioursSixId                = s"select2-${formId}_datafield_60412_1_1-container"
  private lazy val behavioursSevenId              = s"select2-${formId}_datafield_60426_1_1-container"
  private lazy val behavioursEightId              = s"select2-${formId}_datafield_60440_1_1-container"
  private lazy val applicationOneId               = s"${formId}_datafield_60338_1_1_12683"
  private lazy val applicationTwoId               = s"${formId}_datafield_60352_1_1_12683"
  private lazy val applicationThreeId             = s"${formId}_datafield_60366_1_1_12683"
  private lazy val applicationFourId              = s"${formId}_datafield_60380_1_1_12683"
  private lazy val applicationFiveId              = s"${formId}_datafield_60394_1_1_12683"
  private lazy val applicationSixId               = s"${formId}_datafield_60408_1_1_12683"
  private lazy val applicationSevenId             = s"${formId}_datafield_60422_1_1_12683"
  private lazy val applicationEightId             = s"${formId}_datafield_60436_1_1_12683"
  private lazy val interviewsOneId                = s"${formId}_datafield_60338_1_1_12684"
  private lazy val interviewsTwoId                = s"${formId}_datafield_60352_1_1_12684"
  private lazy val interviewsThreeId              = s"${formId}_datafield_60366_1_1_12684"
  private lazy val interviewsFourId               = s"${formId}_datafield_60380_1_1_12684"
  private lazy val interviewFiveId                = s"${formId}_datafield_60394_1_1_12684"
  private lazy val interviewSixId                 = s"${formId}_datafield_60408_1_1_12684"
  private lazy val interviewSevenId               = s"${formId}_datafield_60422_1_1_12684"
  private lazy val interviewEightId               = s"${formId}_datafield_60436_1_1_12684"
  private lazy val provideCvYesId                 = s"${formId}_datafield_59983_1_1_1"
  private lazy val provideCvNoId                  = s"${formId}_datafield_59983_1_1_2"
  private lazy val cvScore0to7Id                  = s"${formId}_datafield_187853_1_1_50711"
  private lazy val cvScore0to100Id                = s"${formId}_datafield_187853_1_1_50712"
  private lazy val jobHistoryYesId                = s"${formId}_datafield_60080_1_1_1"
  private lazy val jobHistoryNoId                 = s"${formId}_datafield_60080_1_1_2"
  private lazy val qualificationDetailsYesId      = s"${formId}_datafield_60086_1_1_1"
  private lazy val qualificationDetailsNoId       = s"${formId}_datafield_60086_1_1_2"
  private lazy val previousSkillsYesId            = s"${formId}_datafield_60090_1_1_1"
  private lazy val previousSkillsNoId             = s"${formId}_datafield_60090_1_1_2"
  private lazy val personalStatementYesId         = s"${formId}_datafield_59992_1_1_1"
  private lazy val personalStatementNoId          = s"${formId}_datafield_59992_1_1_2"
  private lazy val statementScore0to7Id           = s"${formId}_datafield_187857_1_1_50711"
  private lazy val statementScore0to100Id         = s"${formId}_datafield_187857_1_1_50712"
  private lazy val statementWordLimitId           = s"select2-${formId}_datafield_72066_1_1-container"
  private lazy val guidanceTextYesId              = s"${formId}_datafield_59989_1_1_1"
  private lazy val guidanceTextNoId               = s"${formId}_datafield_59989_1_1_2"
  private lazy val guidanceTextInputId            = s"${formId}_datafield_60060_1_1_en-GB"
  private lazy val pastExperiencesYesId           = s"${formId}_datafield_60105_1_1_1"
  private lazy val pastExperiencesNoId            = s"${formId}_datafield_60105_1_1_2"
  private lazy val pastExperiencesInputId         = s"${formId}_datafield_116298_1_1_en-GB"
  private lazy val mandatoryLicencesYesId         = s"${formId}_datafield_60168_1_1_1"
  private lazy val mandatoryLicencesNoId          = s"${formId}_datafield_60168_1_1_2"
  private lazy val mandatoryLicencesInputId       = s"${formId}_datafield_60172_1_1_en-GB"
  private lazy val mandatoryMembershipsYesId      = s"${formId}_datafield_60185_1_1_1"
  private lazy val mandatoryMembershipsNoId       = s"${formId}_datafield_60185_1_1_2"
  private lazy val mandatoryMembershipsInputId    = s"${formId}_datafield_60179_1_1_en-GB"
  private lazy val mandatoryLanguagesYesId        = s"${formId}_datafield_60190_1_1_1"
  private lazy val mandatoryLanguagesNoId         = s"${formId}_datafield_60190_1_1_2"
  private lazy val mandatoryLanguagesInputId      = s"${formId}_datafield_60200_1_1_en-GB"
  private lazy val mandatoryQualificationsYesId   = s"${formId}_datafield_60215_1_1_1"
  private lazy val mandatoryQualificationsNoId    = s"${formId}_datafield_60215_1_1_2"
  private lazy val mandatoryQualificationsInputId = s"${formId}_datafield_60209_1_1_en-GB"

  private def displayWelshVersion(): WebElement = waitForVisibilityOfElementByPath(displayWelshPath)
  private def title(): TextField                = textField("title")
  private def closingDate(): TextField          = textField(closingDateId)
  private def templateSelect: WebElement        = waitForVisibilityOfElementByPath(selectTemplatePath)
  private def enterTemplate: WebElement         = waitForVisibilityOfElementByPath(enterTemplatePath)
  private def newVacancy: WebElement            = waitForVisibilityOfElementByPathLast(newVacancyPath)
  private def vacancySection: WebElement        = waitForVisibilityOfElementByPathLast(vacancySectionPath)

  private def selectTemplate(masterVacancyDetails: MasterVacancyDetails): Unit = {
    templateSelect.click()
    enterTemplate.sendKeys(masterVacancyDetails.template)
    enterTemplate.sendKeys(Keys.ENTER)
  }

  private def enterVacancyTitle(masterVacancyDetails: MasterVacancyDetails): Unit =
    title().value = masterVacancyDetails.vacancyTitle

  private def selectClosingDate(masterVacancyDetails: MasterVacancyDetails): Unit =
    closingDate().value = appClosingDate(masterVacancyDetails.closingDate)

  def createNewVacancy(): Unit = {
    if (newVacancy.getText == "Create New Vacancy") newVacancy.click()
    else {
      vacancySection.click()
      newVacancy.click()
    }
    eventually(onPage(createVacancyTitle))
  }

  private def appClosingDate(days: Int): String = {
    val formatter   = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val now         = LocalDate.now()
    val addDays     = now.plusDays(days)
    val closingDate = addDays.format(formatter)
    closingDate
  }

  private def extractFormId(): String = {
    waitForTemplateLoad()
    val formClass = driver.findElement(By.className(extractFormClass))
    formId = formClass.getAttribute("id")
    formId
  }

  private def waitForTemplateLoad(): Unit =
    displayWelshVersion()

  private val basicInfo: Seq[MasterVacancyDetails => Unit] = Seq(
    selectTemplate,
    enterVacancyTitle,
    selectClosingDate
  )

  def basicDetailsSection(masterVacancyDetails: MasterVacancyDetails): Unit = {
    basicInfo.foreach { f =>
      f(masterVacancyDetails)
    }
    extractFormId()
  }

  private def selectWelshVersion(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.displayWelsh) checkbox(welshRequiredCheck).select()

  private def selectBusinessArea(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(businessAreaId))
    waitForVisibilityOfElementById(businessAreaId).click()
    selectOption(generalInput, masterVacancyDetails.businessArea)
  }

  private def enterBusinessAreaDetail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val businessDetailsInput = waitForVisibilityOfElementById(businessAreaDetailId)
    businessDetailsInput.sendKeys(masterVacancyDetails.businessAreaDetail)
  }

  private def selectTypeOfRole(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(typeOfRoleId))
    selectOption(typeOfRoleInput, masterVacancyDetails.typeOfRole)
  }

  private def whichProfessionIsJob(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(whichProfessionId))
    waitForVisibilityOfElementById(whichProfessionId).click()
    selectOption(generalInput, masterVacancyDetails.whichProfession)
  }

  private def noOfJobsAvailable(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val noOfJobsInput = textField(noOfJobsId)
    noOfJobsInput.value = masterVacancyDetails.noOfJobs
  }

  private val jobInfo: Seq[MasterVacancyDetails => Unit] = Seq(
    selectWelshVersion,
    selectBusinessArea,
    enterBusinessAreaDetail,
    selectTypeOfRole,
    whichProfessionIsJob,
    noOfJobsAvailable
  )

  def jobInformationSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    jobInfo.foreach { f =>
      f(masterVacancyDetails)
    }

  private def eligibilityStatement(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val statement = waitForVisibilityOfElementById(statementId)
    statement.sendKeys(masterVacancyDetails.statement)
  }

  private def selectApproach(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(approachId))
    masterVacancyDetails.approach match {
      case "Pre-release"       => clickOnRadioButton(prereleaseId)
      case "Internal"          => clickOnRadioButton(internalId)
      case "Across government" => clickOnRadioButton(acrossGovernmentId)
      case "External"          => clickOnRadioButton(externalId)
      case _                   => throw new IllegalStateException("Please select valid 'Approach' option")
    }
  }

  private def selectStatementRequired(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (
      (masterVacancyDetails.approach == "Internal" || masterVacancyDetails.approach == "Across government") && masterVacancyDetails.statementRequired
    ) {
      masterVacancyDetails.approach match {
        case "Internal"          => clickOnRadioButton(internalYesStatementId)
        case "Across government" => clickOnRadioButton(acrossGovernmentYesStatementId)
      }
      eligibilityStatement(masterVacancyDetails)
    } else if (
      (masterVacancyDetails.approach == "Internal" || masterVacancyDetails.approach == "Across government") && !masterVacancyDetails.statementRequired
    ) {
      masterVacancyDetails.approach match {
        case "Internal"          => clickOnRadioButton(internalNoStatementId)
        case "Across government" => clickOnRadioButton(acrossGovernmentNoStatementId)
      }
    }

  private val approach: Seq[MasterVacancyDetails => Unit] = Seq(
    selectApproach,
    selectStatementRequired
  )

  def approachSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    approach.foreach { f =>
      f(masterVacancyDetails)
    }

  private def budgetaryInfo(info: String): Unit = {
    val field = waitForVisibilityOfElementById(budgetaryInfoId)
    field.sendKeys(info)
  }

  private def costCentre(centre: String): Unit = {
    val field = waitForVisibilityOfElementById(costCentreId)
    field.sendKeys(centre)
  }

  private def selectApproval(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(approvalId))
    if (masterVacancyDetails.approval) {
      clickOnRadioButton(approvalYesId)
      budgetaryInfo(masterVacancyDetails.budgetaryAuthInfo)
    } else {
      clickOnRadioButton(approvalNoId)
    }
    costCentre(masterVacancyDetails.costCentre)
  }

  private val approval: Seq[MasterVacancyDetails => Unit] = Seq(
    selectApproval
  )

  def approvalSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    approval.foreach { f =>
      f(masterVacancyDetails)
    }

  def selectReserveList(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(reserveListId))
    if (masterVacancyDetails.reserveList) {
      clickOnRadioButton(reserveListYesId)
      lengthOfReserveList(masterVacancyDetails.reserveListLength)
    } else {
      clickOnRadioButton(reserveListNoId)
    }
  }

  def lengthOfReserveList(length: String): Unit = {
    waitForVisibilityOfElementById(reserveListLengthId).click()
    action().moveToElement(waitForDropdownOption(length)).perform()
    waitForDropdownOption(length).click()
  }

  private val reserve: Seq[MasterVacancyDetails => Unit] = Seq(
    selectReserveList
  )

  def reserveListSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    reserve.foreach { f =>
      f(masterVacancyDetails)
    }

  def selectVacancyInNIR(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(northernIrelandId))
    if (masterVacancyDetails.vacancyInNIR) {
      clickOnRadioButton(northernIrelandYesId)
      selectVacancyOutsideNIR(masterVacancyDetails)
      selectWhichCommunity(masterVacancyDetails)
    } else {
      clickOnRadioButton(northernIrelandNoId)
    }
  }

  def selectVacancyOutsideNIR(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.openOutsideNIR) {
      clickOnRadioButton(outsideNIRYesId)
    } else {
      clickOnRadioButton(outsideNIRNoId)
    }

  def selectWhichCommunity(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.whichCommunityEncouraged match {
      case "Protestant"      => clickOnRadioButton(protestantId)
      case "Roman Catholic"  => clickOnRadioButton(romanCatholicId)
      case "All communities" => clickOnRadioButton(allCommunitiesId)
    }

  def locationType(locationType: String): Unit = {
    waitForVisibilityOfElementById(locationTypeId).click()
    action().moveToElement(waitForDropdownOption(locationType)).perform()
    waitForDropdownOption(locationType).click()
  }

  def enterPostcodes(postcodes: String): Unit = {
    val field = waitForVisibilityOfElementById(postcodeId)
    field.sendKeys(postcodes)
  }

  def chooseMaxLocations(maxLocation: String): Unit = {
    waitForVisibilityOfElementById(maxLocationId).click()
    action().moveToElement(waitForDropdownOption(maxLocation)).perform()
    waitForDropdownOption(maxLocation).click()
  }

  def waitForCityOrTownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[text()='$option ']")

  def selectCityOrTown(cityTown: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(cityOrTownInput)
    selectOption.sendKeys(cityTown)
    action().moveToElement(waitForCityOrTownOption(cityTown)).perform()
    waitForCityOrTownOption(cityTown).click()
  }

  def selectOtherCityOrTown(otherCityTown: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(otherCityOrTownInput)
    selectOption.sendKeys(otherCityTown)
    action().moveToElement(waitForCityOrTownOption(otherCityTown)).perform()
    waitForCityOrTownOption(otherCityTown).click()
  }

  def selectRegion(region: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(regionInput)
    selectOption.sendKeys(region)
    action().moveToElement(waitForDropdownOption(region)).perform()
    waitForDropdownOption(region).click()
  }

  def selectOverseas(country: String): Unit = {
    waitForVisibilityOfElementById(overseasId).click()
    selectOption(generalInput, country)
  }

  def locationOverride(overrideLocations: String): Unit =
    textField(locationOverrideInput).value = overrideLocations

  def selectLocationPreference(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.giveLocationPreference) {
      clickOnRadioButton(locationPreferenceYesId)
      chooseMaxLocations(masterVacancyDetails.maxLocations)
      for (cityOrTown <- masterVacancyDetails.otherCityOrTown)
        selectOtherCityOrTown(cityOrTown)
    } else {
      clickOnRadioButton(locationPreferenceNoId)
    }

  def selectLocationType(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(locationTypeId))
    locationType(masterVacancyDetails.locationType)
    masterVacancyDetails.locationType match {
      case "Postcodes" => enterPostcodes(masterVacancyDetails.postcodes)
      case "Towns"     => selectCityOrTown(masterVacancyDetails.cityOrTown)
      case "Regions"   => selectRegion(masterVacancyDetails.region)
      case "Overseas"  => selectOverseas(masterVacancyDetails.overseas)
    }
    locationOverride(masterVacancyDetails.locationOverride)
  }

  private val locations: Seq[MasterVacancyDetails => Unit] = Seq(
    selectLocationType,
    selectVacancyInNIR,
    selectLocationPreference
  )

  def locationsSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    locations.foreach { f =>
      f(masterVacancyDetails)
    }

  private def selectContractType(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(contractTypeId))
    selectOption(contractTypeInput, masterVacancyDetails.contractType)
  }

  private def selectWorkingPattern(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(workingPatternId))
    selectOption(workingPatternInput, masterVacancyDetails.workingPattern)
  }

  private def selectJobGrade(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(jobGradeId))
    selectOption(jobGradeInput, masterVacancyDetails.jobGrade)
  }

  private def enterEquivalentGrade(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val equivalentGrade = textField(equivalentGradeId)
    equivalentGrade.value = masterVacancyDetails.equivalentGrade
  }

  def selectCurrency(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(currencyId))
    waitForVisibilityOfElementById(currencyId).click()
    action().moveToElement(waitForDropdownOption(masterVacancyDetails.currency)).perform()
    waitForDropdownOption(masterVacancyDetails.currency).click()
  }

  private def enterMinimumSalary(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val minSalary = textField(minimumSalaryId)
    minSalary.value = masterVacancyDetails.minimumSalary.toString
  }

  private def enterMaximumSalary(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val maxSalary = textField(maximumSalaryId)
    maxSalary.value = masterVacancyDetails.maximumSalary.toString
  }

  private def enterMoreDetails(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val moreDetails = textField(moreDetailsId)
    moreDetails.value = masterVacancyDetails.moreDetails
  }

  def selectCivilServicePension(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(civilServiceId))
    if (masterVacancyDetails.civilServicePension) {
      clickOnRadioButton(civilServicePensionYesId)
      enterEmployerContribution(masterVacancyDetails.employerContribution)
    } else {
      clickOnRadioButton(civilServicePensionNoId)
    }
  }

  private def enterEmployerContribution(contribution: Int): Unit = {
    val con = textField(employerContributionInput)
    con.value = contribution.toString
  }

  private val contract: Seq[MasterVacancyDetails => Unit] = Seq(
    selectContractType,
    selectWorkingPattern,
    selectJobGrade,
    enterEquivalentGrade,
    selectCurrency,
    enterMinimumSalary,
    enterMaximumSalary,
    enterMoreDetails,
    selectCivilServicePension
  )

  def contractDetailsSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    contract.foreach { f =>
      f(masterVacancyDetails)
    }

  private def switchBack(): Unit = driver.switchTo().defaultContent()

  private def enterJobSummary(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(jobSummaryId))
    val switchFrame = driver.switchTo().frame(jobSummaryIframe)
    val summaryArea = switchFrame.findElement(By.xpath(jobSummaryPath))
    summaryArea.sendKeys(masterVacancyDetails.jobSummary)
    switchBack()
  }

  private def enterJobDescription(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(jobDescriptionId))
    val switchFrame = driver.switchTo().frame(jobDescriptionIframe)
    val summaryArea = switchFrame.findElement(By.xpath(jobDescriptionPath))
    summaryArea.sendKeys(masterVacancyDetails.jobDescription)
    switchBack()
  }

  private def enterPersonSpecs(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(personSpecsIframe))
    val switchFrame = driver.switchTo().frame(personSpecsIframe)
    val summaryArea = switchFrame.findElement(By.xpath(personSpecsPath))
    summaryArea.sendKeys(masterVacancyDetails.personSpecification)
    switchBack()
  }

  private def enterOfferedBenefits(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(offeredBenefitsIframe))
    val switchFrame = driver.switchTo().frame(offeredBenefitsIframe)
    val summaryArea = switchFrame.findElement(By.xpath(offeredBenefitsPath))
    if (!summaryArea.getText.contains("Learning")) {
      summaryArea.sendKeys(masterVacancyDetails.offeredBenefits)
    }
    switchBack()
  }

  private def enterSelectionProcess(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(selectionProcessIframe))
    val switchFrame = driver.switchTo().frame(selectionProcessIframe)
    val summaryArea = switchFrame.findElement(By.xpath(selectionProcessPath))
    summaryArea.sendKeys(masterVacancyDetails.selectionProcess)
    switchBack()
  }

  private val advert: Seq[MasterVacancyDetails => Unit] = Seq(
    enterJobSummary,
    enterJobDescription,
    enterPersonSpecs,
    enterOfferedBenefits,
    enterSelectionProcess
  )

  def advertSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    advert.foreach { f =>
      f(masterVacancyDetails)
    }

  private def enterContactName(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(contactNameId))
    val name = textField(contactNameInput)
    name.value = masterVacancyDetails.contactName
  }

  private def enterContactEmail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val name = textField(contactEmailInput)
    name.value = masterVacancyDetails.contactEmail
  }

  private def enterContactPhone(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val name = textField(contactPhoneInput)
    name.value = masterVacancyDetails.contactPhone
  }

  private def enterVacancyHolderName(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(vacancyHolderNameId))
    val name = textField(vacancyHolderNameInput)
    name.value = masterVacancyDetails.vacancyHolderName
  }

  private def enterVacancyHolderEmail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val name = textField(vacancyHolderEmailInput)
    name.value = masterVacancyDetails.vacancyHolderEmail
  }

  private def enterVacancyTeamEmail(masterVacancyDetails: MasterVacancyDetails): Unit = {
    val teamEmailField = driver.findElement(By.id(vacancyTeamEmailInput))
    val teamEmailValue = teamEmailField.getAttribute("value")
    if (teamEmailValue.nonEmpty) {
      if (!getOs.contains("mac")) {
        teamEmailField.sendKeys(Keys.CONTROL, "a")
      } else {
        teamEmailField.sendKeys(Keys.COMMAND, "a")
      }
      teamEmailField.sendKeys(Keys.BACK_SPACE)
    }
    teamEmailField.sendKeys(masterVacancyDetails.vacancyTeamEmail)
  }

  private val contactInfo: Seq[MasterVacancyDetails => Unit] = Seq(
    enterContactName,
    enterContactEmail,
    enterContactPhone,
    enterVacancyHolderName,
    enterVacancyHolderEmail,
    enterVacancyTeamEmail
  )

  def contactDetailsSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    contactInfo.foreach { f =>
      f(masterVacancyDetails)
    }

  private def selectCheckLevelRequired(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.checkLevelRequired match {
      case "Basic"    => clickOnRadioButton(basicCheckId)
      case "Standard" => clickOnRadioButton(standardCheckId)
      case "Enhanced" => clickOnRadioButton(enhancedCheckId)
      case "None"     => clickOnRadioButton(noCheckRequiredId)
    }

  private def checkWhichProvider(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.whichProvider match {
      case "Disclosure barring service (DBS)" => checkbox(dbsProviderId).select()
      case "Disclosure Scotland"              => checkbox(disclosureScotlandProviderId).select()
      case "Access NI"                        => checkbox(accessNIProviderId).select()
    }

  private def selectVettingLevelRequired(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(vettingRequiredId))
    masterVacancyDetails.vettingLevelRequired match {
      case "Counter terrorist check" => clickOnRadioButton(counterTerroristCheckId)
      case "Security check"          => clickOnRadioButton(securityCheckId)
      case "Developed vetting"       => clickOnRadioButton(developedVettingId)
      case "None"                    => clickOnRadioButton(noVettingRequiredId)
    }
  }

  private def selectReservedStatus(masterVacancyDetails: MasterVacancyDetails): Unit = {
    scrollToElement(By.id(reservedStatusId))
    if (masterVacancyDetails.reservedStatus) clickOnRadioButton(reservedYesId) else clickOnRadioButton(reservedNoId)
  }

  private def selectMedicalRequired(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.medicalRequired) clickOnRadioButton(medicalRequiredYesId)
    else clickOnRadioButton(medicalRequiredNoId)

  private val checkAndVetting: Seq[MasterVacancyDetails => Unit] = Seq(
    selectReservedStatus,
    selectCheckLevelRequired,
    checkWhichProvider,
    selectVettingLevelRequired,
    selectMedicalRequired
  )

  def checkVettingSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    checkAndVetting.foreach { f =>
      f(masterVacancyDetails)
    }

  private def selectInterviewRoundsExpected(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.expectedRounds match {
      case "No interviews" => clickOnRadioButton(noInterviewsId)
      case "1"             =>
        clickOnRadioButton(oneInterviewId)
        selectInterviewRoundOneType(masterVacancyDetails)
      case "2"             =>
        clickOnRadioButton(twoInterviewId)
        selectInterviewRoundOneType(masterVacancyDetails)
        selectInterviewRoundTwoType(masterVacancyDetails)
      case "3"             =>
        clickOnRadioButton(threeInterviewId)
        selectInterviewRoundOneType(masterVacancyDetails)
        selectInterviewRoundTwoType(masterVacancyDetails)
        selectInterviewRoundThreeType(masterVacancyDetails)
      case "4"             =>
        clickOnRadioButton(fourInterviewId)
        selectInterviewRoundOneType(masterVacancyDetails)
        selectInterviewRoundTwoType(masterVacancyDetails)
        selectInterviewRoundThreeType(masterVacancyDetails)
        selectInterviewRoundFourType(masterVacancyDetails)
    }

  private def selectInterviewRoundOneType(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.interviewOneType match {
      case "Assessment" => clickOnRadioButton(assessmentOneId)
      case "Interview"  => clickOnRadioButton(interviewOneId)
      case "Telephone"  => clickOnRadioButton(telephoneOneId)
      case "Video"      => clickOnRadioButton(videoOneId)
    }

  private def selectInterviewRoundTwoType(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.interviewTwoType match {
      case "Assessment" => clickOnRadioButton(assessmentTwoId)
      case "Interview"  => clickOnRadioButton(interviewTwoId)
      case "Telephone"  => clickOnRadioButton(telephoneTwoId)
      case "Video"      => clickOnRadioButton(videoTwoId)
    }

  private def selectInterviewRoundThreeType(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.interviewThreeType match {
      case "Assessment" => clickOnRadioButton(assessmentThreeId)
      case "Interview"  => clickOnRadioButton(interviewThreeId)
      case "Telephone"  => clickOnRadioButton(telephoneThreeId)
      case "Video"      => clickOnRadioButton(videoThreeId)
    }

  private def selectInterviewRoundFourType(masterVacancyDetails: MasterVacancyDetails): Unit =
    masterVacancyDetails.interviewFourType match {
      case "Assessment" => clickOnRadioButton(assessmentFourId)
      case "Interview"  => clickOnRadioButton(interviewFourId)
      case "Telephone"  => clickOnRadioButton(telephoneFourId)
      case "Video"      => clickOnRadioButton(videoFourId)
    }

  private def selectAvailableOffline(masterVacancyDetails: MasterVacancyDetails): Unit =
    if (masterVacancyDetails.availableOffline) clickOnRadioButton(availableOfflineYesId)
    else clickOnRadioButton(availableOfflineNoId)

  private val interviews: Seq[MasterVacancyDetails => Unit] = Seq(
    selectInterviewRoundsExpected,
    selectAvailableOffline
  )

  def interviewsSection(masterVacancyDetails: MasterVacancyDetails): Unit =
    interviews.foreach { f =>
      f(masterVacancyDetails)
    }

//  private def whichSuccessProfiles(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    if (masterVacancyDetails.abilities) {
//      checkbox(abilitiesId).select()
//      selectAbilitiesProfile(masterVacancyDetails)
//    }
//    if (masterVacancyDetails.behaviours) {
//      checkbox(behavioursId).select()
//      selectBehavioursProfile(masterVacancyDetails)
//    }
//    if (masterVacancyDetails.experience) {
//      checkbox(experienceId).select()
//      experiencesSection(masterVacancyDetails)
//    }
//    if (masterVacancyDetails.strengths) {
//      checkbox(strengthsId).select()
//    }
//    if (masterVacancyDetails.technicalSkills) {
//      checkbox(technicalSkillsId).select()
//    }
//  }
//
//  private val successProfiles: Seq[MasterVacancyDetails => Unit] = Seq(
//    whichSuccessProfiles
//  )
//
//  def successProfilesSection(masterVacancyDetails: MasterVacancyDetails): Unit =
//    successProfiles.foreach { f =>
//      f(masterVacancyDetails)
//    }
//
//  def selectAbilitiesProfile(masterVacancyDetails: MasterVacancyDetails): Unit =
//    if (masterVacancyDetails.abilities) {
//      scrollToElement(By.id(abilitiesSectionId))
//      getAssessSectionText(assessAbilitiesId) shouldBe masterVacancyDetails.abilitiesSection
//        .map(_.assessAbilities)
//        .get
//    }
//
//  def selectBehavioursProfile(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    scrollToElement(By.id(successProfilesSectionId))
//    val behaviour = masterVacancyDetails.behavioursSection
//    if (masterVacancyDetails.behaviours) {
//      checkbox(behavioursId).select()
//      getAssessSectionText(assessBehavioursId) shouldBe behaviour
//        .map(_.assessBehaviours)
//        .get
//      selectHowManyBehaviours(behaviour.map(_.howManyAssessed).get)
//      behaviour.map(_.howManyAssessed).get match {
//        case 1 =>
//          selectBehaviourOne(masterVacancyDetails)
//        case 2 =>
//          selectBehaviourOne(masterVacancyDetails)
//          selectBehaviourTwo(masterVacancyDetails)
//        case 3 =>
//          selectBehaviourOne(masterVacancyDetails)
//          selectBehaviourTwo(masterVacancyDetails)
//          selectBehaviourThree(masterVacancyDetails)
//        case 4 =>
//          selectBehaviourOne(masterVacancyDetails)
//          selectBehaviourTwo(masterVacancyDetails)
//          selectBehaviourThree(masterVacancyDetails)
//          selectBehaviourFour(masterVacancyDetails)
//        case 5 =>
//          selectBehaviourOne(masterVacancyDetails)
//          selectBehaviourTwo(masterVacancyDetails)
//          selectBehaviourThree(masterVacancyDetails)
//          selectBehaviourFour(masterVacancyDetails)
//          selectBehaviourFive(masterVacancyDetails)
//        case 6 =>
//          selectBehaviourOne(masterVacancyDetails)
//          selectBehaviourTwo(masterVacancyDetails)
//          selectBehaviourThree(masterVacancyDetails)
//          selectBehaviourFour(masterVacancyDetails)
//          selectBehaviourFive(masterVacancyDetails)
//          selectBehaviourSix(masterVacancyDetails)
//        case 7 =>
//          selectBehaviourOne(masterVacancyDetails)
//          selectBehaviourTwo(masterVacancyDetails)
//          selectBehaviourThree(masterVacancyDetails)
//          selectBehaviourFour(masterVacancyDetails)
//          selectBehaviourFive(masterVacancyDetails)
//          selectBehaviourSix(masterVacancyDetails)
//          selectBehaviourSeven(masterVacancyDetails)
//        case 8 =>
//          selectBehaviourOne(masterVacancyDetails)
//          selectBehaviourTwo(masterVacancyDetails)
//          selectBehaviourThree(masterVacancyDetails)
//          selectBehaviourFour(masterVacancyDetails)
//          selectBehaviourFive(masterVacancyDetails)
//          selectBehaviourSix(masterVacancyDetails)
//          selectBehaviourSeven(masterVacancyDetails)
//          selectBehaviourEight(masterVacancyDetails)
//      }
//    }
//  }
//
//  private def selectBehaviourOne(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursOneId))
//    waitForVisibilityOfElementById(behavioursOneId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourOne.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourOne.map(_.stageApplication).get).get) checkbox(applicationOneId).select()
//    if (behaviour.map(_.behaviourOne.map(_.stageInterview).get).get) checkbox(interviewsOneId).select()
//  }
//
//  private def selectBehaviourTwo(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursTwoId))
//    waitForVisibilityOfElementById(behavioursTwoId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourTwo.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourTwo.map(_.stageApplication).get).get) checkbox(applicationTwoId).select()
//    if (behaviour.map(_.behaviourTwo.map(_.stageInterview).get).get) checkbox(interviewsTwoId).select()
//  }
//
//  private def selectBehaviourThree(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursThreeId))
//    waitForVisibilityOfElementById(behavioursThreeId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourThree.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourThree.map(_.stageApplication).get).get) checkbox(applicationThreeId).select()
//    if (behaviour.map(_.behaviourThree.map(_.stageInterview).get).get) checkbox(interviewsThreeId).select()
//  }
//
//  private def selectBehaviourFour(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursFourId))
//    waitForVisibilityOfElementById(behavioursFourId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourFour.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourFour.map(_.stageApplication).get).get) checkbox(applicationFourId).select()
//    if (behaviour.map(_.behaviourFour.map(_.stageInterview).get).get) checkbox(interviewsFourId).select()
//  }
//
//  private def selectBehaviourFive(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursFiveId))
//    waitForVisibilityOfElementById(behavioursFiveId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourFive.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourFive.map(_.stageApplication).get).get) checkbox(applicationFiveId).select()
//    if (behaviour.map(_.behaviourFive.map(_.stageInterview).get).get) checkbox(interviewFiveId).select()
//  }
//
//  private def selectBehaviourSix(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursSixId))
//    waitForVisibilityOfElementById(behavioursSixId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourSix.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourSix.map(_.stageApplication).get).get) checkbox(applicationSixId).select()
//    if (behaviour.map(_.behaviourSix.map(_.stageInterview).get).get) checkbox(interviewSixId).select()
//  }
//
//  private def selectBehaviourSeven(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursSevenId))
//    waitForVisibilityOfElementById(behavioursSevenId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourSeven.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourSeven.map(_.stageApplication).get).get) checkbox(applicationSevenId).select()
//    if (behaviour.map(_.behaviourSeven.map(_.stageInterview).get).get) checkbox(interviewSevenId).select()
//  }
//
//  private def selectBehaviourEight(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val behaviour = masterVacancyDetails.behavioursSection
//    scrollToElement(By.id(behavioursEightId))
//    waitForVisibilityOfElementById(behavioursEightId).click()
//    selectOption(generalInput, behaviour.map(_.behaviourEight.map(_.chosenBehaviour).get).get)
//    if (behaviour.map(_.behaviourEight.map(_.stageApplication).get).get) checkbox(applicationEightId).select()
//    if (behaviour.map(_.behaviourEight.map(_.stageInterview).get).get) checkbox(interviewEightId).select()
//  }
//
//  private def selectHowManyBehaviours(howMany: Int): Unit = {
//    scrollToElement(By.id(behavioursSectionId))
//    waitForVisibilityOfElementById(howManyBehavioursId).click()
//    selectOption(generalInput, howMany.toString)
//  }
//
//  private def provideCV(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val cv = masterVacancyDetails.experienceSection
//    if (cv.map(_.provideCV).get) clickOnRadioButton(provideCvYesId) else clickOnRadioButton(provideCvNoId)
//  }
//
//  private def selectCVScoreRange(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val score = masterVacancyDetails.experienceSection
//    score.map(_.cvScoreRange).get match {
//      case "0 - 100" => clickOnRadioButton(cvScore0to100Id)
//      case "0 - 7"   => clickOnRadioButton(cvScore0to7Id)
//      case _         => throw new IllegalStateException("CV Score not correct")
//    }
//  }
//
//  private def selectJobHistory(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val history = masterVacancyDetails.experienceSection
//    if (history.map(_.cvJobHistory).get) clickOnRadioButton(jobHistoryYesId) else clickOnRadioButton(jobHistoryNoId)
//  }
//
//  private def selectQualificationDetails(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val qualifications = masterVacancyDetails.experienceSection
//    if (qualifications.map(_.cvQualifications).get) clickOnRadioButton(qualificationDetailsYesId)
//    else clickOnRadioButton(qualificationDetailsNoId)
//  }
//
//  private def selectPreviousSkills(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val qualifications = masterVacancyDetails.experienceSection
//    if (qualifications.map(_.cvPreviousSkills).get) clickOnRadioButton(previousSkillsYesId)
//    else clickOnRadioButton(previousSkillsNoId)
//  }
//
//  private def selectProvideStatement(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val statement = masterVacancyDetails.experienceSection
//    if (statement.map(_.provideStatement).get) {
//      clickOnRadioButton(personalStatementYesId)
//      statement.map(_.statementScoreRange).get match {
//        case "0 - 100" => clickOnRadioButton(statementScore0to100Id)
//        case "0 - 7"   => clickOnRadioButton(statementScore0to7Id)
//        case _         => throw new IllegalStateException("Personal Statement score not correct")
//      }
//      selectStatementWordLimit(masterVacancyDetails)
//    } else clickOnRadioButton(personalStatementNoId)
//  }
//
//  def selectStatementWordLimit(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val limit = masterVacancyDetails.experienceSection.map(_.statementWordLimit).get.toString
//    scrollToElement(By.id(statementWordLimitId))
//    waitForVisibilityOfElementById(statementWordLimitId).click()
//    action().moveToElement(waitForDropdownOption(limit)).perform()
//    waitForDropdownOption(limit).click()
//  }
//
//  private def selectStatementGuidanceText(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val guidance = masterVacancyDetails.experienceSection
//    if (guidance.map(_.statementGuidance).get) {
//      clickOnRadioButton(guidanceTextYesId)
//      enterGuidanceText(masterVacancyDetails)
//    } else clickOnRadioButton(guidanceTextNoId)
//  }
//
//  private def enterGuidanceText(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val text         = masterVacancyDetails.experienceSection
//    val guidanceText = waitForVisibilityOfElementById(guidanceTextInputId)
//    guidanceText.sendKeys(text.map(_.statementGuidanceText).get)
//  }
//
//  private def selectPastExperiences(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val pastExperience = masterVacancyDetails.experienceSection.map(_.pastExperience).get
//    if (pastExperience) {
//      clickOnRadioButton(pastExperiencesYesId)
//      enterPastExperience(masterVacancyDetails)
//    } else clickOnRadioButton(pastExperiencesNoId)
//  }
//
//  private def enterPastExperience(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val pastExperienceText = masterVacancyDetails.experienceSection.map(_.pastExperienceText).get
//    val pastExperience     = waitForVisibilityOfElementById(pastExperiencesInputId)
//    pastExperience.sendKeys(pastExperienceText)
//  }
//
//  private def selectMandatoryLicences(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val licences = masterVacancyDetails.experienceSection.map(_.licences.map(_.requirements).get).get
//    if (licences) {
//      clickOnRadioButton(mandatoryLicencesYesId)
//      enterLicenceRequirements(masterVacancyDetails)
//    } else clickOnRadioButton(mandatoryLicencesNoId)
//  }
//
//  private def enterLicenceRequirements(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val requirementInfo = masterVacancyDetails.experienceSection.map(_.licences.map(_.requirementsInfo).get).get
//    val requirement     = waitForVisibilityOfElementById(mandatoryLicencesInputId)
//    requirement.sendKeys(requirementInfo)
//  }
//
//  private def selectMandatoryMemberships(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val memberships = masterVacancyDetails.experienceSection.map(_.memberships.map(_.requirements).get).get
//    if (memberships) {
//      clickOnRadioButton(mandatoryMembershipsYesId)
//      enterMembershipsRequirements(masterVacancyDetails)
//    } else clickOnRadioButton(mandatoryMembershipsNoId)
//  }
//
//  private def enterMembershipsRequirements(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val requirementInfo = masterVacancyDetails.experienceSection.map(_.memberships.map(_.requirementsInfo).get).get
//    val requirement     = waitForVisibilityOfElementById(mandatoryMembershipsInputId)
//    requirement.sendKeys(requirementInfo)
//  }
//
//  private def selectMandatoryLanguages(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val languages = masterVacancyDetails.experienceSection.map(_.languages.map(_.requirements).get).get
//    if (languages) {
//      clickOnRadioButton(mandatoryLanguagesYesId)
//      enterLanguagesRequirements(masterVacancyDetails)
//    } else clickOnRadioButton(mandatoryLanguagesNoId)
//  }
//
//  private def enterLanguagesRequirements(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val requirementInfo = masterVacancyDetails.experienceSection.map(_.languages.map(_.requirementsInfo).get).get
//    val requirement     = waitForVisibilityOfElementById(mandatoryLanguagesInputId)
//    requirement.sendKeys(requirementInfo)
//  }
//
//  private def selectMandatoryQualifications(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val qualifications = masterVacancyDetails.experienceSection.map(_.qualifications.map(_.requirements).get).get
//    if (qualifications) {
//      clickOnRadioButton(mandatoryQualificationsYesId)
//      enterQualificationsRequirements(masterVacancyDetails)
//    } else clickOnRadioButton(mandatoryQualificationsNoId)
//  }
//
//  private def enterQualificationsRequirements(masterVacancyDetails: MasterVacancyDetails): Unit = {
//    val requirementInfo = masterVacancyDetails.experienceSection.map(_.qualifications.map(_.requirementsInfo).get).get
//    val requirement     = waitForVisibilityOfElementById(mandatoryQualificationsInputId)
//    requirement.sendKeys(requirementInfo)
//  }
//
//  private val experiences: Seq[MasterVacancyDetails => Unit] = Seq(
//    provideCV,
//    selectCVScoreRange,
//    selectJobHistory,
//    selectQualificationDetails,
//    selectPreviousSkills,
//    selectProvideStatement,
//    selectStatementGuidanceText,
//    selectPastExperiences,
//    selectMandatoryLicences,
//    selectMandatoryMemberships,
//    selectMandatoryLanguages,
//    selectMandatoryQualifications
//  )
//
//  def experiencesSection(masterVacancyDetails: MasterVacancyDetails): Unit =
//    experiences.foreach { f =>
//      f(masterVacancyDetails)
//    }
}
