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
  var vacancyName                       = "GCQACO - Consultant"
  var vacancyId                         = "9416"
  var vXApplicationLiveDate: String     = ""
  var vXApplicationLiveTime: String     = ""
  var vXApplicationClosingDate: String  = ""
  var vXAppConvertedClosingDate: String = ""
  var vXApplicationClosingTime: String  = ""
  var vXConvertedLiveDateTime           = ""
  var vXConvertedClosingDateTime        = ""

  //vx vacancy behaviours section
  var vXHowManyAssessed: Int   = 8
  var vXListOfChosenBehaviours = new ListBuffer[String]()

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
  var vXHowManySkills: Int          = 8
  var vXListOfTechSkills            = new ListBuffer[String]()
  var vXListOfTechSkillsDescription = new ListBuffer[String]()
  var vXListOfApplicationStage      = new ListBuffer[Boolean]()
  var vXNoOfApplicationStage: Int   = 8

  //vx vacancy tests section
  var vXAnyOnlineTests = true

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
  var civilServant: Boolean = true

  //v9 short form personal info page
  var v9ReasonableAdjustments = true
  var v9AdjustmentsForTests   = true

  //v9 applications page
  var applicationId: String = ""

}
