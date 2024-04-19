package uk.gov.co.test.ui.data

import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

object MasterVacancyDetails extends VacancyBasePage {

  //vx VACANCY formId
  var vacancyFormId = ""

  //vx VACANCY basic details
  var vacancyName                       = ""
  var vacancyId                         = ""
  var vXApplicationLiveDate: String     = ""
  var vXApplicationLiveTime: String     = ""
  var vXApplicationClosingDate: String  = ""
  var vXAppConvertedClosingDate: String = ""
  var vXApplicationClosingTime: String  = ""
  var vXConvertedLiveDateTime           = ""
  var vXConvertedClosingDateTime        = ""

  //vx VACANCY job information
  var vXJobInfoDepartment  = ""
  var vXBusinessArea       = ""
  var vXBusinessAreaDetail = ""
  var vXTypeOfRole         = new ListBuffer[String]()
  var vXProfession         = ""
  var vXNoOfJobsAvailable  = ""

  //vx VACANCY approach
  var vXApproach = ""

  //vX VACANCY approval
  var vXBudgetaryApproval = true
  var vXCostCentre        = ""

  //vX VACANCY reserve list
  var vXReserveListRequired: Boolean   = _
  var vXReserveListLength              = ""
  var vXReserveExtendRequired: Boolean = _
  var vXReserveExtendLength            = ""
  var vXReserveListTotalLength         = ""

  //vx VACANCY locations
  var vXLocationType                       = ""
  var vXLocationDisplay                    = ""
  var vXVacanciesInNIR                     = true
  var vXCommunitiesInNIR                   = ""
  var vXAvailableOutsideInNI               = false
  var vXGiveLocationPreference: Boolean    = true
  var vXMaxLocations: String               = ""
  var vXOtherLocations: ListBuffer[String] = ListBuffer("London", "Southampton", "Manchester")

  //vx VACANCY contract details TODO
  //vx VACANCY advert TODO
  //vx VACANCY contact details TODO
  //vx VACANCY checking and vetting TODO
  //vx VACANCY interviews TODO

  //vx VACANCY success profiles section
  var vXAbilitiesRequired: Boolean   = _
  var vXBehavioursRequired: Boolean  = _
  var vXExperiencesRequired: Boolean = _
  var vXStrengthsRequired: Boolean   = _
  var vXTechSkillsRequired: Boolean  = _

  //vx VACANCY abilities TODO

  //vx VACANCY experience
  var vXJobHistory: Boolean              = false
  var vXFullQualification: Boolean       = false
  var vXPreviousExperiences: Boolean     = false
  var vXPersonalStatement: Boolean       = false
  var vXSpecifyGuidance: Boolean         = false
  var vXGuidanceText: String             = ""
  var vXDesirablePastExperience: Boolean = false
  var vXSpecificPastExperience: String   = ""
  var vXStatementWordLimit: Int          = 250
  var vXLicencesMandatory: Boolean       = false
  var vXSpecificLicences: String         = ""
  var vXMembershipsMandatory: Boolean    = false
  var vXSpecificMemberships: String      = ""
  var vXLanguagesMandatory: Boolean      = false
  var vXSpecificLanguages: String        = ""
  var vXQualificationsMandatory: Boolean = false
  var vXSpecificQualifications: String   = ""

  //vx VACANCY behaviours
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

  //vx VACANCY technical skills
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

  //vx VACANCY online tests
  var vXAnyOnlineTests: Boolean = _

  //vx VACANCY additional questions
  var vXAnyAdditionalQuestions: Boolean = _
  var vXHowManyQuestions: Int           = _
  var vXQuestionOne                     = ""
  var vXQuestionTwo                     = ""
  var vXQuestionThree                   = ""

  //vx VACANCY eligibility and rejection criteria
  var vXRejectProbation: Boolean             = true
  var vXRejectApplyingOnPromotion: Boolean   = true
  var vXRejectLiveMisconduct: Boolean        = true
  var vXRejectPoorPerformance: Boolean       = true
  var vXRejectPoorAttendance: Boolean        = true
  var vXRejectNationalityReq: Boolean        = true
  var vXRejectNoRightToRemain: Boolean       = true
  var vXRejectLicencesNotHeld: Boolean       = true
  var vXRejectMembershipsNotHeld: Boolean    = true
  var vXRejectLanguagesNotHeld: Boolean      = true
  var vXRejectQualificationsNotHeld: Boolean = true
  var vXPreSiftRequired: Boolean             = true
  var vXAttachmentRequired: Boolean          = true
  var vXCandidateInstructions: String        = ""

  //vx VACANCY vacancy management
  var vXGreatForVeterans: Boolean = false
  var vXGrsVacancy: Boolean       = true

  //vx VACANCY online pre-employment check forms
  var vXUseOnlinePecForms: Boolean = _
  var vXHavePecMailbox: Boolean    = _
  var vXPecMailbox                 = ""

  //vx VACANCY pre-employment check forms
  var vXRtwChecks                            = new ListBuffer[String]()
  var vXWhenRtwChecks                        = ""
  var vXWhichIdentityChecks                  = ""
  var vXCandidateUploadIdentityDocs: Boolean = _
  var vXDetailsForUploadIdentityDocs         = ""
  var vXManuallyCheckIdentityDocs: Boolean   = _
  var vXPecGeneralInfo                       = new ListBuffer[String]()
  var vXPecReferenceCheck                    = new ListBuffer[String]()
  var vXPecBankruptcyCheck                   = new ListBuffer[String]()
  var vXPecCrc                               = new ListBuffer[String]()
  var vXPecNsv                               = new ListBuffer[String]()
  var vXPecNsvDisplayOptions                 = ""
  var vXPecEmploymentHistoryCheck            = new ListBuffer[String]()
  var vXPecHealthRefCheck                    = new ListBuffer[String]()
  var vXPecHealthDisplayOptions              = ""
  var vXPecOverseasCheck                     = new ListBuffer[String]()
  var vXPecPensionsCheck                     = new ListBuffer[String]()
  var vXPecPreviousCivilEmploymentCheck      = new ListBuffer[String]()
  var vXPecFraudCheck                        = new ListBuffer[String]()
  var vXPecSelfEmploymentCheck               = new ListBuffer[String]()
  var vXPecOgdCandidates: Boolean            = _
  var vXPecIncludeAdditionalCheck: Boolean   = _
  var vXPecNameOfAdditionalCheck             = ""
  var vXPecAdditionalCheck                   = new ListBuffer[String]()
  var vXPecNen                               = new ListBuffer[String]()
  var vXPecHrEmailForNen                     = ""
  var vXPecPn                                = new ListBuffer[String]()
  var vXPecHrEmailForPn                      = ""

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
  var v9EmployedWithin3Years: Boolean = _
  var v9FirstEmployerName             = ""
  var v9FirstEmployerFromDate         = ""
  var v9FirstEmployerToDate           = ""
  var v9SecondEmployerName            = ""
  var v9SecondEmployerFromDate        = ""
  var v9SecondEmployerToDate          = ""
  var v9ThirdEmployerName             = ""
  var v9ThirdEmployerFromDate         = ""
  var v9ThirdEmployerToDate           = ""

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
