package uk.gov.co.test.ui.data

import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

object MasterVacancyDetails extends VacancyBasePage {

  //vx VACANCY formId
  var vacancyFormId = ""

  //vx VACANCY additionalQuestions section
  var vXAnyAdditionalQuestions = true
  var vXHowManyQuestions       = 3
  var vXQuestionOne            = "Autotest - Question 1"
  var vXQuestionTwo            = "Autotest - Question 2"
  var vXQuestionThree          = "Autotest - Question 3"

  //vx VACANCY approach section
  var vXApproach = ""

  //vX VACANCY approval
  var vXBudgetaryApproval = true
  var vXCostCentre        = ""

  //vx VACANCY basicDetails section
  var vacancyName                       = ""
  var vacancyId                         = ""
  var vXApplicationLiveDate: String     = ""
  var vXApplicationLiveTime: String     = ""
  var vXApplicationClosingDate: String  = ""
  var vXAppConvertedClosingDate: String = ""
  var vXApplicationClosingTime: String  = ""
  var vXConvertedLiveDateTime           = ""
  var vXConvertedClosingDateTime        = ""

  //vX VACANCY reserve list
  var vXReserveListRequired    = true
  var vXReserveListLength      = ""
  var vXReserveExtendRequired  = false
  var vXReserveExtendLength    = ""
  var vXReserveListTotalLength = ""

  //vx VACANCY job information section
  var vXJobInfoDepartment  = ""
  var vXBusinessArea       = ""
  var vXBusinessAreaDetail = ""
  var vXTypeOfRole         = new ListBuffer[String]()
  var vXProfession         = ""
  var vXNoOfJobsAvailable  = ""

  //vx VACANCY behaviours section
  var vXHowManyBehaviours: Int                     = 8
  var vXListOfChosenBehaviours: ListBuffer[String] = ListBuffer(
    "Changing and Improving",
    "Communicating and Influencing",
    "Delivering at Pace",
    "Developing Self and Others",
    "Leadership",
    "Making Effective Decisions",
    "Managing a Quality Service",
    "Working Together"
  )

  //vx VACANCY criteria section
  var vXCandidateInstructions: String     = "Autotest - Instructions for candidate"
  var vXUploadAttachmentRequired: Boolean = true
  var vXProbationIncomplete: Boolean      = true
  var vXPromotionApply: Boolean           = true
  var vXMisconductLive: Boolean           = true
  var vXPerformanceReview: Boolean        = true
  var vXAttendancePoor: Boolean           = true
  var vXNationalityRequirements: Boolean  = true
  var vXRightToRemainUK: Boolean          = true

  //vx VACANCY experience section
  var vXJobHistory: Boolean              = false
  var vXFullQualification: Boolean       = false
  var vXPreviousExperiences: Boolean     = false
  var vXPersonalStatement: Boolean       = false
  var vXSpecifyGuidance: Boolean         = false
  var vXGuidanceText: String             = ""
  var vXDesirablePastExperience: Boolean = false
  var vXSpecificPastExperience: String   = ""
  var vXStatementWordLimit: Int          = 250
  var vXPreSiftRequired: Boolean         = true
  var vXLicencesMandatory: Boolean       = false
  var vXSpecificLicences: String         = ""
  var vXMembershipsMandatory: Boolean    = false
  var vXSpecificMemberships: String      = ""
  var vXLanguagesMandatory: Boolean      = false
  var vXSpecificLanguages: String        = ""
  var vXQualificationsMandatory: Boolean = false
  var vXSpecificQualifications: String   = ""

  //vx VACANCY location section
  var vXLocationType                    = ""
  var vXLocationDisplay                 = ""
  var vXVacanciesInNIR                  = true
  var vXCommunitiesInNIR                = ""
  var vXAvailableOutsideInNI            = false
  var vXGiveLocationPreference: Boolean = true
  var vXMaxLocations: String            = ""
  var vXOtherLocations                  = new ListBuffer[String]()

  //vx VACANCY management section
  var vXGreatForVeterans: Boolean = false
  var vXGrsVacancy: Boolean       = true

  //vx VACANCY success profiles section
  var vXAbilitiesRequired: Boolean   = _
  var vXBehavioursRequired: Boolean  = _
  var vXExperiencesRequired: Boolean = _
  var vXStrengthsRequired: Boolean   = _
  var vXTechSkillsRequired: Boolean  = _

  //vx VACANCY technical skills section
  var vXHowManySkills: Int                              = 8
  var vXListOfTechSkills: ListBuffer[String]            = ListBuffer(
    "Autotest - technical skills 1",
    "Autotest - technical skills 2",
    "Autotest - technical skills 3",
    "Autotest - technical skills 4",
    "Autotest - technical skills 5",
    "Autotest - technical skills 6",
    "Autotest - technical skills 7",
    "Autotest - technical skills 8"
  )
  var vXListOfTechSkillsDescription: ListBuffer[String] = ListBuffer(
    "Autotest - technical skills 1 description",
    "Autotest - technical skills 2 description",
    "Autotest - technical skills 3 description",
    "Autotest - technical skills 4 description",
    "Autotest - technical skills 5 description",
    "Autotest - technical skills 6 description",
    "Autotest - technical skills 7 description",
    "Autotest - technical skills 8 description"
  )
  var vXListOfApplicationStage                          = new ListBuffer[Boolean]()
  var vXNoOfApplicationStage: Int                       = 8

  //vX strengths
  var vXHowManyStrengths: Int               = 8
  var vXListOfStrengths: ListBuffer[String] = ListBuffer(
    "Adaptable",
    "Analytical",
    "Improver",
    "Relationship Builder",
    "Challenger",
    "Change Agent",
    "Team Leader",
    "Service Focussed"
  )

  //vx VACANCY tests section
  var vXAnyOnlineTests: Boolean = _

  //vx PEC FORM checks
  var vXRtwChecks: List[String] =
    List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates")
  var vXWhenRtwChecks           = "Before pre employment checks"

  //v9 candidate details
  var randomFirstName: String    = ""
  var randomLastName: String     = ""
  var preferredFirstName: String = ""
  var randomEmail: String        = ""
  var randomJobPosition: String  = ""

  //v9 SHORT FORM technical skills
  val sortedListOfTechSkills: Seq[String]            = List(
    "Autotest - technical skills 1",
    "Autotest - technical skills 2",
    "Autotest - technical skills 3",
    "Autotest - technical skills 4",
    "Autotest - technical skills 5",
    "Autotest - technical skills 6",
    "Autotest - technical skills 7",
    "Autotest - technical skills 8"
  )
  val sortedListOfTechSkillsDescription: Seq[String] = List(
    "Autotest - technical skills 1 description",
    "Autotest - technical skills 2 description",
    "Autotest - technical skills 3 description",
    "Autotest - technical skills 4 description",
    "Autotest - technical skills 5 description",
    "Autotest - technical skills 6 description",
    "Autotest - technical skills 7 description",
    "Autotest - technical skills 8 description"
  )

  //v9 SHORT FORM eligibility page
  var v9CivilServant: Boolean  = true
  var v9HomeDepartment: String = "Independent Parliamentary Standards Authority"

  //v9 SHORT FORM personal info page
  var v9ReasonableAdjustments = false
  var v9AdjustmentsForTests   = false

  //v9 SHORT FORM applications page
  var applicationId: String = ""

  //v9 PEC FORM employment history
  var v9EmployedWithin3Years   = true
  var v9FirstEmployerName      = ""
  var v9FirstEmployerFromDate  = ""
  var v9FirstEmployerToDate    = ""
  var v9SecondEmployerName     = ""
  var v9SecondEmployerFromDate = ""
  var v9SecondEmployerToDate   = ""
  var v9ThirdEmployerName      = ""
  var v9ThirdEmployerFromDate  = ""
  var v9ThirdEmployerToDate    = ""

  //vX APPLICATION calender schedule
  var vXSlotOneStartTime  = ""
  var vXSlotOneFinishTime = ""
  var vXSlotTwoStartTime  = ""
  var vXSlotTwoFinishTime = ""
  var vXInterviewRoom     = ""
  var vXInterviewID       = ""

  //vX APPLICATION -interview schedule
  var vXInterviewNumber: ListBuffer[String] = ListBuffer("")
  var vXInterviewExpectedRounds             = ""
  var vXInterviewOneType                    = ""
  var vXInterviewTwoType                    = ""
  var vXInterviewThreeType                  = ""
  var vXInterviewFourType                   = ""
  var vXInterviewDate                       = ""
  var vXInterviewLongDate                   = ""
  var vXInterviewShortDate                  = ""
  var vXInterviewLocation                   = ""
  var vXInterviewScheduleTitle              = ""
  var vXInstructionsForCandidates           = ""
  var vXInterviewOneOutcome                 = ""
  var vXInterviewTwoOutcome                 = ""
  var vXInterviewThreeOutcome               = ""
  var vXInterviewFourOutcome                = ""

}
