package uk.gov.co.test.ui.data

import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

object MasterVacancyDetails extends VacancyBasePage {

  //vx VACANCY details
  var vXProfile             = ""
  var vacancyFormId         = ""
  var vXNoLongForm: Boolean = _

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
  var vXJobInfoDepartment          = ""
  var vXBusinessArea               = ""
  var vXBusinessAreaDetail         = ""
  var vXPositionIdentifier         = ""
  var vXTypeOfRole                 = new ListBuffer[String]()
  var vXProfession                 = ""
  var vXNoOfJobsAvailable          = ""
  var vXLineManagerDuties: Boolean = _

  //vx VACANCY approach
  var vXApproach        = ""
  var vXTypeOfCandidate = ""

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
  var vXVacanciesInNIR: Boolean            = _
  var vXCommunitiesInNIR                   = ""
  var vXAvailableOutsideInNI: Boolean      = _
  var vXGiveLocationPreference: Boolean    = _
  var vXMaxLocations: String               = ""
  var vXOtherLocations: ListBuffer[String] = ListBuffer("London", "Southampton", "Manchester")

  //vx VACANCY contract details TODO finish off
  var vXJobGrades                         = new ListBuffer[String]()
  var vXJobGradeEquivalent: String        = ""
  var vXSalaryMinimum: String             = ""
  var vXSalaryMaximum: String             = ""
  var vXSalaryMoreDetails: String         = ""
  var vXOfferCivilServicePension: Boolean = _

  //vx VACANCY advert TODO

  //vx VACANCY contact details
  var vXContactName: String        = ""
  var vXEmailForQuestions: String  = ""
  var vXVacancyHolderEmail: String = ""
  var vXVacancyHolderName: String  = ""
  var vXTeamEmail: String          = ""

  //vx VACANCY checking and vetting
  var vXNonReserved: Boolean     = _
  var vXCrcLevel: String         = ""
  var vXCrcCheckProvider: String = ""
  var vXVettingLevel: String     = ""
  var vXMedicalRequired: Boolean = _

  //vX VACANCY -interview schedule
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

  //vx VACANCY success profiles section
  var vXAbilitiesRequired: Boolean   = _
  var vXBehavioursRequired: Boolean  = _
  var vXExperiencesRequired: Boolean = _
  var vXStrengthsRequired: Boolean   = _
  var vXTechSkillsRequired: Boolean  = _

  //vx VACANCY abilities TODO

  //vx VACANCY experience
  var vXJobHistory: Boolean                 = _
  var vXFullQualification: Boolean          = _
  var vXProvideNameBlindCv: Boolean         = _
  var vXCvAttachment: Boolean               = _
  var vXCvScoreRange: String                = ""
  var vXPreviousExperiences: Boolean        = _
  var vXPersonalStatementNameBlind: Boolean = _
  var vXPersonalStatement: Boolean          = _
  var vXStatementScoreRange: String         = ""
  var vXStatementGuidance: Boolean          = _
  var vXStatementGuidanceText: String       = ""
  var vXStatementWordLimit: Int             = 250
  var vXDesirablePastExperience: Boolean    = _
  var vXSpecificPastExperience: String      = ""
  var vXLicencesMandatory: Boolean          = _
  var vXSpecificLicences: String            = ""
  var vXMembershipsMandatory: Boolean       = _
  var vXSpecificMemberships: String         = ""
  var vXLanguagesMandatory: Boolean         = _
  var vXSpecificLanguages: String           = ""
  var vXQualificationsMandatory: Boolean    = _
  var vXSpecificQualifications: String      = ""

  //vx VACANCY behaviours
  var vXHowManyBehaviours: Int                            = _
  var vXListOfChosenBehaviours: ListBuffer[String]        = ListBuffer()
  var vXBehaviourApplicationRequired: ListBuffer[Boolean] = ListBuffer()
  var vXBehaviourInterviewRequired: ListBuffer[Boolean]   = ListBuffer()

  //vx VACANCY technical skills
  var vXHowManySkills: Int                                   = _
  var vXListOfTechSkills: ListBuffer[String]                 = ListBuffer()
  var vXListOfTechSkillsDescription: ListBuffer[String]      = ListBuffer()
  var vXListOfSkillsApplicationRequired: ListBuffer[Boolean] = ListBuffer()
  var vXListOfSkillsInterviewRequired: ListBuffer[Boolean]   = ListBuffer()

  //vX strengths
  var vXHowManyStrengths: Int               = _
  var vXListOfStrengths: ListBuffer[String] = ListBuffer()

  //vx VACANCY online tests
  var vXAnyOnlineTests: Boolean     = _
  var vXWhenFullApplication: String = ""

  //vx VACANCY additional questions
  var vXAnyAdditionalQuestions: Option[Boolean] = _
  var vXHowManyQuestions: Int                   = _
  var vXQuestionOne                             = ""
  var vXQuestionTwo                             = ""
  var vXQuestionThree                           = ""

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
  var vXUseOnlinePecForms: Boolean       = _
  var vXNoPecOgdDigitalTransfer: Boolean = _
  var vXHavePecMailbox: Boolean          = _
  var vXPecMailbox                       = ""

  //vx VACANCY pre-employment check forms
  var vXRtwChecks                            = new ListBuffer[String]()
  var vXWhenRtwChecks                        = ""
  var vXWhichIdentityChecks                  = ""
  var vXCandidateUploadIdentityDocs: Boolean = _
  var vXDetailsForUploadIdentityDocs         = ""
  var vXManuallyCheckIdentityDocs: Boolean   = _
  var vXPecGeneralInfo                       = new ListBuffer[String]()
  var vXPecReferenceCheck                    = new ListBuffer[String]()
  var vXPecWorkplaceMisconductCheck          = new ListBuffer[String]()
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
  var vXPecOgdSecurityCheck: Boolean         = _
  var vXPecUseDigitalOgdProcess: Boolean     = false
  var vXPecIncludeAdditionalCheck: Boolean   = _
  var vXPecNameOfAdditionalCheck             = ""
  var vXPecAdditionalCheck                   = new ListBuffer[String]()
  var vXPecNen                               = new ListBuffer[String]()
  var vXPecHrEmailForNen                     = ""
  var vXPecPn                                = new ListBuffer[String]()
  var vXPecHrEmailForPn                      = ""

  //v9 candidate details
  var randomFirstName: String     = ""
  var randomLastName: String      = ""
  var randomPassword: String      = ""
  var preferredFirstName: String  = ""
  var randomEmail: String         = ""
  var randomJobPosition: String   = ""
  var preferredTeleNumber: String = ""

  //v9 SHORT FORM eligibility page
  var v9RunInWelsh: Boolean    = false
  var v9CivilServant: Boolean  = _
  var v9HomeDepartment: String = ""
//  var v9HomeDepartment: String = "Animal and Plant Health Agency"

  //v9 SHORT FORM personal info page
  var v9ReasonableAdjustments = false
  var v9AdjustmentsForTests   = false

  //v9 SHORT FORM applications page
  var applicationId: String = ""

  //v9 PEC FORM required
  var v9PecRequired: Boolean = _

  //v9 PEC FORM rtw
  var v9RtwBritishCitizen: Boolean       = _
  var v9RtwBritishIrishPassport: Boolean = _
  var v9EussStatus: String               = ""
  var v9BiometricResidenceCard: Boolean  = _

  //v9 PEC FORM digital identity checks
  var v9IdvtDataConsent: Boolean       = true
  var v9SmartphoneAccess: Boolean      = true
  var v9BiometricPassportOrId: Boolean = true
  var v9InDateDrivingLicence: Boolean  = true

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

}
