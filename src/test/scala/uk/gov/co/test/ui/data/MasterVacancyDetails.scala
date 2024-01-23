package uk.gov.co.test.ui.data

import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

object MasterVacancyDetails extends VacancyBasePage {

  //vx VACANCY formId
  var vacancyFormId = ""

  //vx VACANCY additionalQuestions section
  var vXAnyAdditionalQuestions = false
  var vXHowManyQuestions       = 0
  var vXQuestionOne            = ""
  var vXQuestionTwo            = ""
  var vXQuestionThree          = ""

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
  var vXHowManyBehaviours: Int                     = 0
  var vXListOfChosenBehaviours: ListBuffer[String] = ListBuffer("")

  //vx VACANCY criteria section
  var vXCandidateInstructions: String     = ""
  var vXPreSiftRequired: Boolean          = false
  var vXUploadAttachmentRequired: Boolean = false
  var vXProbationIncomplete: Boolean      = false
  var vXPromotionApply: Boolean           = false
  var vXMisconductLive: Boolean           = false
  var vXPerformanceReview: Boolean        = false
  var vXAttendancePoor: Boolean           = false
  var vXNationalityRequirements: Boolean  = true
  var vXRightToRemainUK: Boolean          = true

  //vx VACANCY experience section
  var vXGuidanceText: String             = ""
  var vXStatementWordLimit: Int          = 250
  var vXLicencesMandatory: Boolean       = false
  var vXMembershipsMandatory: Boolean    = false
  var vXLanguagesMandatory: Boolean      = false
  var vXQualificationsMandatory: Boolean = false

  //vx VACANCY location section
  var vXLocationType                    = ""
  var vXLocationDisplay                 = ""
  var vXVacanciesInNIR                  = true
  var vXCommunitiesInNIR                = ""
  var vXAvailableOutsideInNI            = false
  var vXGiveLocationPreference: Boolean = false
  var vXMaxLocations: String            = ""
  var vXOtherLocations: ListBuffer[String] = ListBuffer("London", "Southampton", "Manchester")

  //vx VACANCY management section
  var vXGreatForVeterans: Boolean = false
  var vXGrsVacancy: Boolean       = true

  //vx VACANCY success profiles section
  var vXAbilitiesRequired: Boolean   = false
  var vXBehavioursRequired: Boolean  = false
  var vXExperiencesRequired: Boolean = false
  var vXStrengthsRequired: Boolean   = false
  var vXTechSkillsRequired: Boolean  = false

  //vx VACANCY technical skills section
  var vXHowManySkills: Int                              = 0
  var vXListOfTechSkills: ListBuffer[String]            = ListBuffer("")
  var vXListOfTechSkillsDescription: ListBuffer[String] = ListBuffer("")
  var vXListOfApplicationStage                          = new ListBuffer[Boolean]()
  var vXNoOfApplicationStage: Int                       = 0

  //vX strengths
  var vXHowManyStrengths: Int               = 0
  var vXListOfStrengths: ListBuffer[String] = ListBuffer("")

  //vx VACANCY tests section
  var vXAnyOnlineTests = false

  //vx PEC FORM checks
  var vXRtwChecks: List[String] = List("")
  var vXWhenRtwChecks           = ""

  //v9 candidate details
  var randomFirstName: String    = ""
  var randomLastName: String     = ""
  var preferredFirstName: String = ""
  var randomEmail: String        = ""
  var randomJobPosition: String  = ""

  //v9 SHORT FORM technical skills
  val sortedListOfTechSkills: Seq[String]            = List("")
  val sortedListOfTechSkillsDescription: Seq[String] = List("")

  //v9 SHORT FORM eligibility page
  var civilServant: Boolean  = true
  var homeDepartment: String = "Attorney General's Office"

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
