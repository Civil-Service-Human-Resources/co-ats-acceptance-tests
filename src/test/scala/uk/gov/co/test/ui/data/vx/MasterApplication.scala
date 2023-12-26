package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{randomFirstName, randomLastName, vacancyId}
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.contactEmailVxConfig
import uk.gov.co.test.ui.pages.vx.vacancytabs._
import uk.gov.co.test.ui.pages.vx.{CalenderScheduleDetails, InterviewScheduleDetails}

import java.time.LocalDate

case class Outcome(score: Int, comment: Option[String] = None)
case class AssessmentOutcome(name: String, score: Int, comment: Option[String] = None)

case class ApplicationDetails(
  historyDetails: HistoryDetails,
  preSiftDetails: PreSiftDetails,
  siftDetails: SiftDetails,
  interviewScheduleDetails: InterviewScheduleDetails,
  calenderScheduleDetails: CalenderScheduleDetails,
  interviewOneDetails: InterviewOneDetails
)

object APPLICATION_DATA
    extends ApplicationDetails(
      APPLICATION_EMPLOYMENT_HISTORY,
      APPLICATION_PRE_SIFT_EVALUATION,
      APPLICATION_SIFT_EVALUATION,
      APPLICATION_INTERVIEW_SCHEDULE,
      APPLICATION_CALENDER_SCHEDULE,
      APPLICATION_INTERVIEW_ONE_EVALUATION
    )

object APPLICATION_EMPLOYMENT_HISTORY
    extends HistoryDetails(
      false,
      historyCheckStarted = LocalDate.now(),
      "Test-T&Cs.pdf",
      true,
      true,
      true,
      dateCheckSentToGrs = LocalDate.now().minusDays(1),
      true,
      dateHistoryCheckReceived = LocalDate.now().minusDays(1),
      false,
      "Passed",
      dateCheckCompleted = LocalDate.now(),
      dateInfoRequested = LocalDate.now().minusDays(2),
      dateInfoReceived = LocalDate.now(),
      "Autotest - mandatory risk assessment comments",
      dateBF = LocalDate.now(),
      internalNotes = "Autotest - internal notes (optional)"
    )

object APPLICATION_PRE_SIFT_EVALUATION
    extends PreSiftDetails(
      "A",
      "Autotest - CV assessment comments",
      "B",
      "Autotest - Personal statement comments",
      "C",
      "Autotest - Pre-sift comments",
      "Progress",
      "Autotest - Overall comments"
    )

object APPLICATION_SIFT_EVALUATION
    extends SiftDetails(
      """Scoring guide:
        |Not demonstrated -No positive evidence and/or substantial negative evidence demonstrated
        |Minimal demonstration -Limited positive evidence and/or mainly negative evidence demonstrated
        |Moderate demonstration -Moderate positive evidence but some negative evidence demonstrated
        |Acceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern
        |Good demonstration - Substantial positive evidence of the competency or behaviour
        |Strong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level
        |Outstanding demonstration - The evidence provided wholly exceeds expectation at this level""".stripMargin,
      behaviourOne = Outcome(6, Some("Autotest - Changing and Improving - behaviour one comments")),
      behaviourTwo = Outcome(7, Some("Autotest - Changing and Improving - behaviour one comments")),
      behaviourThree = Outcome(7, Some("Autotest - Delivering at Pace - behaviour three comments")),
      behaviourFour = Outcome(7, Some("Autotest - Developing Self and Others - behaviour four comments")),
      behaviourFive = Outcome(7, Some("Autotest - Leadership - behaviour five comments")),
      behaviourSix = Outcome(6, Some("Autotest - Making Effective Decisions - behaviour six comments")),
      behaviourSeven = Outcome(6, Some("Autotest - Managing a Quality Service - behaviour seven comments")),
      behaviourEight = Outcome(7, Some("Autotest - Working Together - behaviour eight comments")),
      techSkillOne = Outcome(5, Some("Autotest - Tech Skill One - tech skill one  comments")),
      techSkillTwo = Outcome(7, Some("Autotest - Tech Skill Two - tech skill two comments")),
      techSkillThree = Outcome(7, Some("Autotest - Tech Skill Three - tech skill three comments")),
      techSkillFour = Outcome(7, Some("Autotest - Tech Skill Four - tech skill four comments")),
      techSkillFive = Outcome(6, Some("Autotest - Tech Skill Five - tech skill five comments")),
      techSkillSix = Outcome(7, Some("Autotest - Tech Skill Six - tech skill six comments")),
      techSkillSeven = Outcome(6, Some("Autotest - Tech Skill Seven - tech skill seven comments")),
      techSkillEight = Outcome(7, Some("Autotest - Tech Skill Eight - tech skill eight comments")),
      cvAssessment = Outcome(7, Some("Autotest - cv assessment comments")),
      personalStatement = Outcome(7, Some("Autotest - personal statement comments")),
      "Autotest - overall comments",
      "Progress",
      "Declaration\n\nBy submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant and the evaluation reflects the views of all the selection panel members."
    )

object APPLICATION_INTERVIEW_SCHEDULE
    extends InterviewScheduleDetails(
      false,
      Some("Copy From Template"),
      "",
      "",
      s"$vacancyId - Interview 1 for $randomFirstName $randomLastName",
      true,
      s"$vacancyId - Prawf awtomeiddio $randomFirstName $randomLastName",
      20,
      "Interview 1",
      false,
      s"$contactEmailVxConfig",
      s"Autotest - Internal notes for $randomFirstName $randomLastName",
      true,
      "Prawf awtomeiddio",
      s"Autotest - Instructions for $randomFirstName $randomLastName",
      true,
      "Prawf awtomeiddio",
      "HMRC Government Offices Great George Street",
      false,
      24,
      "Use System Default",
      "24 Hours",
      "Interview 1 - Invited",
      "Interview 1 - scheduled",
      false
    )

object APPLICATION_CALENDER_SCHEDULE
    extends CalenderScheduleDetails(
      "09:30",
      60,
      1,
      true,
      2,
      60,
      "HMRC George Street - Room 1",
      sendInterviewerICal = Some(false),
      None
    )

object APPLICATION_INTERVIEW_ONE_EVALUATION
    extends InterviewOneDetails(
      scoringGuide = """Scoring guide:
          |Not demonstrated - No positive evidence and/or substantial negative evidence demonstrated
          |Minimal demonstration - Limited positive evidence and/or mainly negative evidence demonstrated
          |Moderate demonstration - Moderate positive evidence but some negative evidence demonstrated
          |Acceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern
          |Good demonstration - Substantial positive evidence of the competency or behaviour
          |Strong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level
          |Outstanding demonstration - The evidence provided wholly exceeds expectation at this level""".stripMargin,
      behaviourOne = Outcome(6, Some("Autotest - Changing and Improving - behaviour one comments")),
      behaviourTwo = Outcome(7, Some("Autotest - Changing and Improving - behaviour one comments")),
      behaviourThree = Outcome(7, Some("Autotest - Delivering at Pace - behaviour three comments")),
      behaviourFour = Outcome(7, Some("Autotest - Developing Self and Others - behaviour four comments")),
      behaviourFive = Outcome(7, Some("Autotest - Leadership - behaviour five comments")),
      behaviourSix = Outcome(6, Some("Autotest - Making Effective Decisions - behaviour six comments")),
      behaviourSeven = Outcome(6, Some("Autotest - Managing a Quality Service - behaviour seven comments")),
      behaviourEight = Outcome(7, Some("Autotest - Working Together - behaviour eight comments")),
      techSkillOne = Outcome(5, Some("Autotest - Tech Skill One - tech skill one  comments")),
      techSkillTwo = Outcome(7, Some("Autotest - Tech Skill Two - tech skill two comments")),
      techSkillThree = Outcome(7, Some("Autotest - Tech Skill Three - tech skill three comments")),
      techSkillFour = Outcome(7, Some("Autotest - Tech Skill Four - tech skill four comments")),
      techSkillFive = Outcome(6, Some("Autotest - Tech Skill Five - tech skill five comments")),
      techSkillSix = Outcome(7, Some("Autotest - Tech Skill Six - tech skill six comments")),
      techSkillSeven = Outcome(6, Some("Autotest - Tech Skill Seven - tech skill seven comments")),
      techSkillEight = Outcome(7, Some("Autotest - Tech Skill Eight - tech skill eight comments")),
      strengthScoringGuide = """Scoring guide:
          |Please score the candidates using the following scoring guidelines:
          |Weakness - Lower engagement, lower capability, lower use
          |Learned Behaviour - Lower engagement, higher capability, some use
          |Potential Strength - Higher engagement, some capability, some use
          |Strength - higher engagement, higher capability, higher use""".stripMargin,
      strengthOne = Outcome(4, Some("Autotest - Adaptable - strength one comments")),
      strengthTwo = Outcome(4, Some("Autotest - Analytical - strength two comments")),
      strengthThree = Outcome(4, Some("Autotest - Improver  - strength three comments")),
      strengthFour = Outcome(4, Some("Autotest - Relationship Builder - strength four comments")),
      strengthFive = Outcome(4, Some("Autotest - Challenger - strength five comments")),
      strengthSix = Outcome(4, Some("Autotest - Change Agent - strength six comments")),
      strengthSeven = Outcome(4, Some("Autotest - Team Leader - strength seven comments")),
      strengthEight = Outcome(4, Some("Autotest - Service Focussed - strength eight comments")),
      additionalAssessments = "6",
      assessmentOne = AssessmentOutcome("Presentation", 6, Some("Autotest - Presentation - assessment one comments")),
      assessmentTwo =
        AssessmentOutcome("Physical ability", 5, Some("Autotest - Physical ability - assessment two comments")),
      assessmentThree = AssessmentOutcome(
        "Verbal comprehension",
        4,
        Some("Autotest - Verbal comprehension - assessment three comments")
      ),
      assessmentFour = AssessmentOutcome(
        "Workplace personality",
        6,
        Some("Autotest - Workplace personality - assessment four comments")
      ),
      assessmentFive =
        AssessmentOutcome("Role knowledge", 6, Some("Autotest - Role knowledge - assessment five comments")),
      assessmentSix =
        AssessmentOutcome("Cognitive ability", 3, Some("Autotest - Cognitive ability - assessment six comments")),
      experience = Outcome(6, Some("Autotest - Changing and Improving - behaviour one comments")),
      false,
      101,
      "Progress",
      s"Autotest - $randomFirstName $randomLastName overall performed very well!",
      "Test-T&Cs.pdf",
      declarationStatement = """Declaration
          |
          |By submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant and the evaluation reflects the views of all the selection panel members.""".stripMargin
    )
