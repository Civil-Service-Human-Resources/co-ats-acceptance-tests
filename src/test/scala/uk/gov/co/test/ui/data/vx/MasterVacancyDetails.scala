package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

object MasterVacancyDetails extends VacancyBasePage {

  //vx vacancy additionalQuestions section
  var vXAnyAdditionalQuestions = true
  var vXHowManyQuestions       = 3
  var vXQuestionOne            = "Autotest - Question 1"
  var vXQuestionTwo            = "Autotest - Question 2"
  var vXQuestionThree          = "Autotest - Question 3"

  //vx vacancy approach section
  var candidateApproach = "External"

  //vx vacancy basicDetails section
  var vacancyName                       = "HMRC - Technical Architect"
  var vacancyId                         = "9562"
  var vXApplicationLiveDate: String     = "22 December 2023"
  var vXApplicationLiveTime: String     = ""
  var vXApplicationClosingDate: String  = "31/01/2024"
  var vXAppConvertedClosingDate: String = ""
  var vXApplicationClosingTime: String  = ""
  var vXConvertedLiveDateTime           = ""
  var vXConvertedClosingDateTime        = ""

  //vx job information section
  var vXJobInfoDepartment = "HM Revenue and Customs"

  //vx vacancy behaviours section
  var vXHowManyBehaviours: Int                     = 8
//  var vXListOfChosenBehaviours = new ListBuffer[String]()
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

  //vx vacancy criteria section
  var vXCandidateInstructions: String     = "Autotest - Instructions for candidate"
  var vXUploadAttachmentRequired: Boolean = true
  var vXProbationIncomplete: Boolean      = true
  var vXPromotionApply: Boolean           = true
  var vXMisconductLive: Boolean           = true
  var vXPerformanceReview: Boolean        = true
  var vXAttendancePoor: Boolean           = true
  var vXNationalityRequirements: Boolean  = true
  var vXRightToRemainUK: Boolean          = true

  //vx vacancy experience section
  var vXGuidanceText: String             = "Autotest - Enter guidance text for the candidate"
  var vXStatementWordLimit: Int          = 250
  var vXLicencesMandatory: Boolean       = true
  var vXMembershipsMandatory: Boolean    = true
  var vXLanguagesMandatory: Boolean      = true
  var vXQualificationsMandatory: Boolean = true

  //vx vacancy location section
  var vXVacanciesInNIR                  = true
  var vXCommunitiesInNIR                = ""
  var vXGiveLocationPreference: Boolean = true
  var vXMaxLocations: String            = "3"
  var vXOtherLocations: Seq[String]     = List("London", "Southampton", "Manchester")

  //vx vacancy management section
  var vXGreatForVeterans: Boolean = true
  var vXGrsVacancy: Boolean       = true

  //vx vacancy success profiles section
  var vXAbilitiesRequired: Boolean   = true
  var vXBehavioursRequired: Boolean  = true
  var vXExperiencesRequired: Boolean = true
  var vXStrengthsRequired: Boolean   = true
  var vXTechSkillsRequired: Boolean  = true

  //vx vacancy technical skills section
  var vXHowManySkills: Int                              = 8
//  var vXListOfTechSkills            = new ListBuffer[String]()
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

  //vx vacancy tests section
  var vXAnyOnlineTests = false

  //candidate details
  var randomFirstName: String    = ""
  var randomLastName: String     = ""
  var preferredFirstName: String = ""
  var randomEmail: String        = ""
  var randomJobPosition: String  = ""

  //v9 short form technical skills
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

  //v9 short form eligibility page
  var civilServant: Boolean  = true
  var homeDepartment: String = "Attorney General's Office"

  //v9 short form personal info page
  var v9ReasonableAdjustments = true
  var v9AdjustmentsForTests   = true

  //v9 applications page
  var applicationId: String = "0"

  //v9 pec form employment history
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

  //vX calender schedule
  var vXSlotOneStartTime = ""
  var vXSlotOneFinishTime = ""
  var vXSlotTwoStartTime = ""
  var vXSlotTwoFinishTime = ""
  var vXInterviewRoom    = ""
  var vXInterviewID    = ""

  //vX interview schedule
  var vXInterviewExpectedRounds   = "4"
  var vXInterviewOneDate          = ""
  var vXInterviewLocation         = ""
  var vXInterviewScheduleTitle    = ""
  var vXInstructionsForCandidates = ""
  var vXInterviewOneType          = "Telephone"
  var vXInterviewTwoType          = "Assessment"
  var vXInterviewThreeType        = "Video"
  var vXInterviewFourType         = "Interview"

}
