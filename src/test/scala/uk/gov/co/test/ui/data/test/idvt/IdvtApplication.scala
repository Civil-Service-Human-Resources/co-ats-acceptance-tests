package uk.gov.co.test.ui.data.test.idvt

import uk.gov.co.test.ui.data.vx.application.{ApplicationDetails, AssessmentOutcome, Outcome}
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.contactEmailVxConfig
import uk.gov.co.test.ui.pages.vx.DashboardPage.contactNameVxConfig
import uk.gov.co.test.ui.pages.vx.vacancytabs._
import uk.gov.co.test.ui.pages.vx.{CalenderScheduleDetails, InterviewScheduleDetails}

import java.time.LocalDate
import scala.collection.mutable.ListBuffer

object IDVT_APPLICATION_DATA
    extends ApplicationDetails(
      IDVT_APPLICATION_EMPLOYMENT_HISTORY,
      IDVT_APPLICATION_PRE_SIFT_EVALUATION,
      IDVT_APPLICATION_SIFT_EVALUATION,
      IDVT_APPLICATION_INTERVIEW_SCHEDULE,
      IDVT_APPLICATION_CALENDER_SCHEDULE,
      IDVT_APPLICATION_INTERVIEW_ONE_EVALUATION,
      IDVT_APPLICATION_INTERVIEW_TWO_EVALUATION,
      IDVT_APPLICATION_INTERVIEW_THREE_EVALUATION,
      IDVT_APPLICATION_INTERVIEW_FOUR_EVALUATION,
      IDVT_APPLICATION_OGD_SECURITY_CHECKS,
      IDVT_APPLICATION_POSTING_NOTICE,
      IDVT_APPLICATION_NEW_ENTRANT_NOTICE
    )

object IDVT_APPLICATION_EMPLOYMENT_HISTORY
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

object IDVT_APPLICATION_PRE_SIFT_EVALUATION
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

object IDVT_APPLICATION_SIFT_EVALUATION
    extends SiftDetails(
      """Scoring guide:
        |Not demonstrated -No positive evidence and/or substantial negative evidence demonstrated
        |Minimal demonstration -Limited positive evidence and/or mainly negative evidence demonstrated
        |Moderate demonstration -Moderate positive evidence but some negative evidence demonstrated
        |Acceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern
        |Good demonstration - Substantial positive evidence of the competency or behaviour
        |Strong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level
        |Outstanding demonstration - The evidence provided wholly exceeds expectation at this level""".stripMargin,
      behaviourOne = Outcome(6, Some("Autotest - behaviour one comments")),
      behaviourTwo = Outcome(7, Some("Autotest - behaviour two comments")),
      behaviourThree = Outcome(7, Some("Autotest - behaviour three comments")),
      behaviourFour = Outcome(7, Some("Autotest - behaviour four comments")),
      behaviourFive = Outcome(7, Some("Autotest - behaviour five comments")),
      behaviourSix = Outcome(6, Some("Autotest - behaviour six comments")),
      behaviourSeven = Outcome(6, Some("Autotest - behaviour seven comments")),
      behaviourEight = Outcome(7, Some("Autotest - behaviour eight comments")),
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

object IDVT_APPLICATION_INTERVIEW_SCHEDULE
    extends InterviewScheduleDetails(
      false,
      Some("Copy From Template"),
      "",
      "",
      true,
      20,
      "Interview %s",
      false,
      s"$contactEmailVxConfig",
      true,
      "Prawf awtomeiddio",
      true,
      "Prawf awtomeiddio",
      s"HMRC Government Offices Great George Street I%s",
      false,
      24,
      "Use System Default",
      "24 Hours",
      "Interview %s - Invited",
      "Interview %s - scheduled",
      false
    )

object IDVT_APPLICATION_CALENDER_SCHEDULE
    extends CalenderScheduleDetails(
      "09:00",
      60,
      1,
      true,
      2,
      60,
      s"HMRC George Street - Room %s",
      sendInterviewerICal = Some(false),
      None
    )

object IDVT_APPLICATION_INTERVIEW_ONE_EVALUATION
    extends InterviewOneDetails(
      scoringGuide = """Scoring guide:
          |Not demonstrated - No positive evidence and/or substantial negative evidence demonstrated
          |Minimal demonstration - Limited positive evidence and/or mainly negative evidence demonstrated
          |Moderate demonstration - Moderate positive evidence but some negative evidence demonstrated
          |Acceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern
          |Good demonstration - Substantial positive evidence of the competency or behaviour
          |Strong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level
          |Outstanding demonstration - The evidence provided wholly exceeds expectation at this level""".stripMargin,
      behaviourOne = Outcome(7, Some("Autotest - I1 - Changing and Improving - behaviour one comments")),
      behaviourTwo = Outcome(5, Some("Autotest - I1 - Changing and Improving - behaviour one comments")),
      behaviourThree = Outcome(6, Some("Autotest - I1 - Delivering at Pace - behaviour three comments")),
      behaviourFour = Outcome(7, Some("Autotest - I1 - Developing Self and Others - behaviour four comments")),
      behaviourFive = Outcome(7, Some("Autotest - I1 - Leadership - behaviour five comments")),
      behaviourSix = Outcome(6, Some("Autotest - I1 - Making Effective Decisions - behaviour six comments")),
      behaviourSeven = Outcome(7, Some("Autotest - I1 - Managing a Quality Service - behaviour seven comments")),
      behaviourEight = Outcome(7, Some("Autotest - I1 - Working Together - behaviour eight comments")),
      techSkillOne = Outcome(5, Some("Autotest - I1 - Tech Skill One - tech skill one  comments")),
      techSkillTwo = Outcome(7, Some("Autotest - I1 - Tech Skill Two - tech skill two comments")),
      techSkillThree = Outcome(6, Some("Autotest - I1 - Tech Skill Three - tech skill three comments")),
      techSkillFour = Outcome(7, Some("Autotest - I1 - Tech Skill Four - tech skill four comments")),
      techSkillFive = Outcome(6, Some("Autotest - I1 - Tech Skill Five - tech skill five comments")),
      techSkillSix = Outcome(7, Some("Autotest - I1 - Tech Skill Six - tech skill six comments")),
      techSkillSeven = Outcome(7, Some("Autotest - I1 - Tech Skill Seven - tech skill seven comments")),
      techSkillEight = Outcome(7, Some("Autotest - I1 - Tech Skill Eight - tech skill eight comments")),
      strengthScoringGuide = """Scoring guide:
          |Please score the candidates using the following scoring guidelines:
          |Weakness - Lower engagement, lower capability, lower use
          |Learned Behaviour - Lower engagement, higher capability, some use
          |Potential Strength - Higher engagement, some capability, some use
          |Strength - higher engagement, higher capability, higher use""".stripMargin,
      strengthOne = Outcome(3, Some("Autotest - I1 - Adaptable - strength one comments")),
      strengthTwo = Outcome(4, Some("Autotest - I1 - Analytical - strength two comments")),
      strengthThree = Outcome(4, Some("Autotest - I1 - Improver  - strength three comments")),
      strengthFour = Outcome(3, Some("Autotest - I1 - Relationship Builder - strength four comments")),
      strengthFive = Outcome(4, Some("Autotest - I1 - Challenger - strength five comments")),
      strengthSix = Outcome(4, Some("Autotest - I1 - Change Agent - strength six comments")),
      strengthSeven = Outcome(2, Some("Autotest - I1 - Team Leader - strength seven comments")),
      strengthEight = Outcome(4, Some("Autotest - I1 - Service Focussed - strength eight comments")),
      additionalAssessments = "6",
      assessmentOne =
        AssessmentOutcome("Presentation", 5, Some("Autotest - I1 - Presentation - assessment one comments")),
      assessmentTwo =
        AssessmentOutcome("Physical ability", 6, Some("Autotest - I1 - Physical ability - assessment two comments")),
      assessmentThree = AssessmentOutcome(
        "Verbal comprehension",
        6,
        Some("Autotest - I1 - Verbal comprehension - assessment three comments")
      ),
      assessmentFour = AssessmentOutcome(
        "Workplace personality",
        4,
        Some("Autotest - I1 - Workplace personality - assessment four comments")
      ),
      assessmentFive =
        AssessmentOutcome("Role knowledge", 4, Some("Autotest - I1 - Role knowledge - assessment five comments")),
      assessmentSix =
        AssessmentOutcome("Cognitive ability", 5, Some("Autotest - I1 - Cognitive ability - assessment six comments")),
      experience = Outcome(91, Some("Autotest - I1 - experience comments")),
      overrideScore = false,
      overallOverrideScore = 101,
      finalOutcome = "Progress",
      uploadDocs = "Test-T&Cs.pdf",
      declarationStatement = """Declaration
          |
          |By submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant and the evaluation reflects the views of all the selection panel members.""".stripMargin
    )

object IDVT_APPLICATION_INTERVIEW_TWO_EVALUATION
    extends InterviewTwoDetails(
      scoringGuide = """Scoring guide:
                     |Not demonstrated - No positive evidence and/or substantial negative evidence demonstrated
                     |Minimal demonstration - Limited positive evidence and/or mainly negative evidence demonstrated
                     |Moderate demonstration - Moderate positive evidence but some negative evidence demonstrated
                     |Acceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern
                     |Good demonstration - Substantial positive evidence of the competency or behaviour
                     |Strong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level
                     |Outstanding demonstration - The evidence provided wholly exceeds expectation at this level""".stripMargin,
      behaviourOne = Outcome(7, Some("Autotest - I2 - Changing and Improving - behaviour one comments")),
      behaviourTwo = Outcome(7, Some("Autotest - I2 - Changing and Improving - behaviour one comments")),
      behaviourThree = Outcome(7, Some("Autotest - I2 - Delivering at Pace - behaviour three comments")),
      behaviourFour = Outcome(7, Some("Autotest - I2 - Developing Self and Others - behaviour four comments")),
      behaviourFive = Outcome(7, Some("Autotest - I2 - Leadership - behaviour five comments")),
      behaviourSix = Outcome(7, Some("Autotest - I2 - Making Effective Decisions - behaviour six comments")),
      behaviourSeven = Outcome(7, Some("Autotest - I2 - Managing a Quality Service - behaviour seven comments")),
      behaviourEight = Outcome(7, Some("Autotest - I2 - Working Together - behaviour eight comments")),
      techSkillOne = Outcome(7, Some("Autotest - I2 - Tech Skill One - tech skill one  comments")),
      techSkillTwo = Outcome(7, Some("Autotest - I2 - Tech Skill Two - tech skill two comments")),
      techSkillThree = Outcome(7, Some("Autotest - I2 - Tech Skill Three - tech skill three comments")),
      techSkillFour = Outcome(7, Some("Autotest - I2 - Tech Skill Four - tech skill four comments")),
      techSkillFive = Outcome(7, Some("Autotest - I2 - Tech Skill Five - tech skill five comments")),
      techSkillSix = Outcome(7, Some("Autotest - I2 - Tech Skill Six - tech skill six comments")),
      techSkillSeven = Outcome(7, Some("Autotest - I2 - Tech Skill Seven - tech skill seven comments")),
      techSkillEight = Outcome(7, Some("Autotest - I2 - Tech Skill Eight - tech skill eight comments")),
      strengthScoringGuide = """Scoring guide:
                             |Please score the candidates using the following scoring guidelines:
                             |Weakness - Lower engagement, lower capability, lower use
                             |Learned Behaviour - Lower engagement, higher capability, some use
                             |Potential Strength - Higher engagement, some capability, some use
                             |Strength - higher engagement, higher capability, higher use""".stripMargin,
      strengthOne = Outcome(3, Some("Autotest - I2 - Adaptable - strength one comments")),
      strengthTwo = Outcome(4, Some("Autotest - I2 - Analytical - strength two comments")),
      strengthThree = Outcome(4, Some("Autotest - I2 - Improver  - strength three comments")),
      strengthFour = Outcome(4, Some("Autotest - I2 - Relationship Builder - strength four comments")),
      strengthFive = Outcome(3, Some("Autotest - I2 - Challenger - strength five comments")),
      strengthSix = Outcome(4, Some("Autotest - I2 - Change Agent - strength six comments")),
      strengthSeven = Outcome(4, Some("Autotest - I2 - Team Leader - strength seven comments")),
      strengthEight = Outcome(4, Some("Autotest - I2 - Service Focussed - strength eight comments")),
      additionalAssessments = "6",
      assessmentOne =
        AssessmentOutcome("Presentation", 7, Some("Autotest - I2 - Presentation - assessment one comments")),
      assessmentTwo =
        AssessmentOutcome("Physical ability", 7, Some("Autotest - I2 - Physical ability - assessment two comments")),
      assessmentThree = AssessmentOutcome(
        "Verbal comprehension",
        7,
        Some("Autotest - I2 - Verbal comprehension - assessment three comments")
      ),
      assessmentFour = AssessmentOutcome(
        "Workplace personality",
        7,
        Some("Autotest - I2 - Workplace personality - assessment four comments")
      ),
      assessmentFive =
        AssessmentOutcome("Role knowledge", 7, Some("Autotest - I2 - Role knowledge - assessment five comments")),
      assessmentSix =
        AssessmentOutcome("Cognitive ability", 6, Some("Autotest - I2 - Cognitive ability - assessment six comments")),
      experience = Outcome(92, Some("Autotest - I2 - experience comments")),
      false,
      102,
      "Progress",
      "Test-T&Cs.pdf",
      declarationStatement = """Declaration
                             |
                             |By submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant and the evaluation reflects the views of all the selection panel members.""".stripMargin
    )

object IDVT_APPLICATION_INTERVIEW_THREE_EVALUATION
    extends InterviewThreeDetails(
      scoringGuide = """Scoring guide:
                     |Not demonstrated - No positive evidence and/or substantial negative evidence demonstrated
                     |Minimal demonstration - Limited positive evidence and/or mainly negative evidence demonstrated
                     |Moderate demonstration - Moderate positive evidence but some negative evidence demonstrated
                     |Acceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern
                     |Good demonstration - Substantial positive evidence of the competency or behaviour
                     |Strong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level
                     |Outstanding demonstration - The evidence provided wholly exceeds expectation at this level""".stripMargin,
      behaviourOne = Outcome(7, Some("Autotest - I3 - Changing and Improving - behaviour one comments")),
      behaviourTwo = Outcome(7, Some("Autotest - I3 - Changing and Improving - behaviour one comments")),
      behaviourThree = Outcome(7, Some("Autotest - I3 - Delivering at Pace - behaviour three comments")),
      behaviourFour = Outcome(7, Some("Autotest - I3 - Developing Self and Others - behaviour four comments")),
      behaviourFive = Outcome(7, Some("Autotest - I3 - Leadership - behaviour five comments")),
      behaviourSix = Outcome(6, Some("Autotest - I3 - Making Effective Decisions - behaviour six comments")),
      behaviourSeven = Outcome(7, Some("Autotest - I3 - Managing a Quality Service - behaviour seven comments")),
      behaviourEight = Outcome(7, Some("Autotest - I3 - Working Together - behaviour eight comments")),
      techSkillOne = Outcome(6, Some("Autotest - I3 - Tech Skill One - tech skill one  comments")),
      techSkillTwo = Outcome(7, Some("Autotest - I3 - Tech Skill Two - tech skill two comments")),
      techSkillThree = Outcome(7, Some("Autotest - I3 - Tech Skill Three - tech skill three comments")),
      techSkillFour = Outcome(7, Some("Autotest - I3 - Tech Skill Four - tech skill four comments")),
      techSkillFive = Outcome(6, Some("Autotest - I3 - Tech Skill Five - tech skill five comments")),
      techSkillSix = Outcome(7, Some("Autotest - I3 - Tech Skill Six - tech skill six comments")),
      techSkillSeven = Outcome(7, Some("Autotest - I3 - Tech Skill Seven - tech skill seven comments")),
      techSkillEight = Outcome(7, Some("Autotest - I3 - Tech Skill Eight - tech skill eight comments")),
      strengthScoringGuide = """Scoring guide:
                             |Please score the candidates using the following scoring guidelines:
                             |Weakness - Lower engagement, lower capability, lower use
                             |Learned Behaviour - Lower engagement, higher capability, some use
                             |Potential Strength - Higher engagement, some capability, some use
                             |Strength - higher engagement, higher capability, higher use""".stripMargin,
      strengthOne = Outcome(3, Some("Autotest - I3 - Adaptable - strength one comments")),
      strengthTwo = Outcome(4, Some("Autotest - I3 - Analytical - strength two comments")),
      strengthThree = Outcome(4, Some("Autotest - I3 - Improver  - strength three comments")),
      strengthFour = Outcome(4, Some("Autotest - I3 - Relationship Builder - strength four comments")),
      strengthFive = Outcome(4, Some("Autotest - I3 - Challenger - strength five comments")),
      strengthSix = Outcome(4, Some("Autotest - I3 - Change Agent - strength six comments")),
      strengthSeven = Outcome(3, Some("Autotest - I3 - Team Leader - strength seven comments")),
      strengthEight = Outcome(4, Some("Autotest - I3 - Service Focussed - strength eight comments")),
      additionalAssessments = "6",
      assessmentOne =
        AssessmentOutcome("Presentation", 7, Some("Autotest - I3 - Presentation - assessment one comments")),
      assessmentTwo =
        AssessmentOutcome("Physical ability", 6, Some("Autotest - I3 - Physical ability - assessment two comments")),
      assessmentThree = AssessmentOutcome(
        "Verbal comprehension",
        7,
        Some("Autotest - I3 - Verbal comprehension - assessment three comments")
      ),
      assessmentFour = AssessmentOutcome(
        "Workplace personality",
        6,
        Some("Autotest - I3 - Workplace personality - assessment four comments")
      ),
      assessmentFive =
        AssessmentOutcome("Role knowledge", 6, Some("Autotest - I3 - Role knowledge - assessment five comments")),
      assessmentSix =
        AssessmentOutcome("Cognitive ability", 6, Some("Autotest - I3 - Cognitive ability - assessment six comments")),
      experience = Outcome(93, Some("Autotest - I3 - experience comments")),
      false,
      103,
      "Progress",
      "Test-T&Cs.pdf",
      declarationStatement = """Declaration
                             |
                             |By submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant and the evaluation reflects the views of all the selection panel members.""".stripMargin
    )

object IDVT_APPLICATION_INTERVIEW_FOUR_EVALUATION
    extends InterviewFourDetails(
      scoringGuide = """Scoring guide:
                     |Not demonstrated - No positive evidence and/or substantial negative evidence demonstrated
                     |Minimal demonstration - Limited positive evidence and/or mainly negative evidence demonstrated
                     |Moderate demonstration - Moderate positive evidence but some negative evidence demonstrated
                     |Acceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern
                     |Good demonstration - Substantial positive evidence of the competency or behaviour
                     |Strong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level
                     |Outstanding demonstration - The evidence provided wholly exceeds expectation at this level""".stripMargin,
      behaviourOne = Outcome(7, Some("Autotest - I4 - Changing and Improving - behaviour one comments")),
      behaviourTwo = Outcome(6, Some("Autotest - I4 - Changing and Improving - behaviour one comments")),
      behaviourThree = Outcome(7, Some("Autotest - I4 - Delivering at Pace - behaviour three comments")),
      behaviourFour = Outcome(7, Some("Autotest - I4 - Developing Self and Others - behaviour four comments")),
      behaviourFive = Outcome(6, Some("Autotest - I4 - Leadership - behaviour five comments")),
      behaviourSix = Outcome(6, Some("Autotest - I4 - Making Effective Decisions - behaviour six comments")),
      behaviourSeven = Outcome(7, Some("Autotest - I4 - Managing a Quality Service - behaviour seven comments")),
      behaviourEight = Outcome(6, Some("Autotest - I4 - Working Together - behaviour eight comments")),
      techSkillOne = Outcome(6, Some("Autotest - I4 - Tech Skill One - tech skill one  comments")),
      techSkillTwo = Outcome(7, Some("Autotest - I4 - Tech Skill Two - tech skill two comments")),
      techSkillThree = Outcome(7, Some("Autotest - I4 - Tech Skill Three - tech skill three comments")),
      techSkillFour = Outcome(6, Some("Autotest - I4 - Tech Skill Four - tech skill four comments")),
      techSkillFive = Outcome(6, Some("Autotest - I4 - Tech Skill Five - tech skill five comments")),
      techSkillSix = Outcome(6, Some("Autotest - I4 - Tech Skill Six - tech skill six comments")),
      techSkillSeven = Outcome(6, Some("Autotest - I4 - Tech Skill Seven - tech skill seven comments")),
      techSkillEight = Outcome(6, Some("Autotest - I4 - Tech Skill Eight - tech skill eight comments")),
      strengthScoringGuide = """Scoring guide:
                             |Please score the candidates using the following scoring guidelines:
                             |Weakness - Lower engagement, lower capability, lower use
                             |Learned Behaviour - Lower engagement, higher capability, some use
                             |Potential Strength - Higher engagement, some capability, some use
                             |Strength - higher engagement, higher capability, higher use""".stripMargin,
      strengthOne = Outcome(4, Some("Autotest - I4 - Adaptable - strength one comments")),
      strengthTwo = Outcome(4, Some("Autotest - I4 - Analytical - strength two comments")),
      strengthThree = Outcome(4, Some("Autotest - I4 - Improver  - strength three comments")),
      strengthFour = Outcome(4, Some("Autotest - I4 - Relationship Builder - strength four comments")),
      strengthFive = Outcome(4, Some("Autotest - I4 - Challenger - strength five comments")),
      strengthSix = Outcome(4, Some("Autotest - I4 - Change Agent - strength six comments")),
      strengthSeven = Outcome(4, Some("Autotest - I4 - Team Leader - strength seven comments")),
      strengthEight = Outcome(4, Some("Autotest - I4 - Service Focussed - strength eight comments")),
      "6",
      assessmentOne =
        AssessmentOutcome("Presentation", 7, Some("Autotest - I4 - Presentation - assessment one comments")),
      assessmentTwo =
        AssessmentOutcome("Physical ability", 6, Some("Autotest - I4 - Physical ability - assessment two comments")),
      assessmentThree = AssessmentOutcome(
        "Verbal comprehension",
        7,
        Some("Autotest - I4 - Verbal comprehension - assessment three comments")
      ),
      assessmentFour = AssessmentOutcome(
        "Workplace personality",
        7,
        Some("Autotest - I4 - Workplace personality - assessment four comments")
      ),
      assessmentFive =
        AssessmentOutcome("Role knowledge", 7, Some("Autotest - I4 - Role knowledge - assessment five comments")),
      assessmentSix =
        AssessmentOutcome("Cognitive ability", 6, Some("Autotest - I4 - Cognitive ability - assessment six comments")),
      experience = Outcome(94, Some("Autotest - I4 - experience comments")),
      false,
      104,
      "Progress",
      "Test-T&Cs.pdf",
      declarationStatement = """Declaration
                             |
                             |By submitting this form you are agreeing to and accepting that you have no conflict of interest with this applicant and the evaluation reflects the views of all the selection panel members.""".stripMargin
    )

object IDVT_APPLICATION_OGD_SECURITY_CHECKS
  extends OgdSecurityChecksDetails(
    true,
    true
  )

object IDVT_APPLICATION_POSTING_NOTICE
    extends PostingNoticeDetails(
      "1234",
      "autotest-sop org",
      "autotest-sop position",
      "autotest-business unit",
      "123456",
      "JA448800D",
      startDate = LocalDate.now(),
      "09:30",
      "Autotest address",
      true,
      "autotest - 2nd location",
      "Temporary",
      "The post is time limited and is being advertised as an apprenticeship for the advertised period. The fixed-term will end when the apprenticeship has completed.",
      "autotest - key responsibilities",
      contractEndDate = LocalDate.now(),
      "Level Transfer",
      workingPattern = ListBuffer("Annualised hours", "Full Time", "Part Time"),
      "40",
      "8",
      "8",
      "8",
      "8",
      "8",
      "0",
      "0",
      payZone = ListBuffer("London", "National"),
      "45000",
      true,
      negotiatedSalaryDate = LocalDate.now(),
      true,
      "autotest - allowances name and account",
      true,
      true,
      s"$contactNameVxConfig",
      "01520000000",
      s"$contactEmailVxConfig",
      "12345"
    )

object IDVT_APPLICATION_NEW_ENTRANT_NOTICE
    extends NewEntrantNoticeDetails(
      "1234",
      "autotest-sop org",
      "autotest-sop position",
      "autotest-business unit",
      "OGD",
      true,
      false,
      "Exception 1: Temporary appointments",
      LocalDate.now().plusDays(1),
      "09:30",
      "Autotest address",
      true,
      "autotest - 2nd location",
      "Fixed Term Appointment",
      true,
      "90%",
      "Up to 18",
      contractEndDate = LocalDate.now().plusMonths(3),
      "The post is permanent and requires temporary cover, for no more than 12 months,  whilst permanent recruitment activity has commenced and needs time to complete. The fixed-term will end when the permanent recruitment completes.",
      "autotest - key responsibilities",
      "Homeworking",
      "40",
      "8",
      "8",
      "8",
      "8",
      "8",
      "0",
      "0",
      payZone = ListBuffer("London", "National"),
      "55000",
      true,
      negotiatedSalaryDate = LocalDate.now().minusDays(2),
      true,
      "autotest - allowances name and account",
      true,
      true,
      LocalDate.now(),
      s"$contactNameVxConfig",
      "United Kingdom +44",
      "7711234123",
      s"$contactEmailVxConfig",
      "12345"
    )
