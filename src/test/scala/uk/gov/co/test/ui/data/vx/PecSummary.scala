package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.pages.vx.vacancytabs.{HistoryDetails, Outcome, PreSiftDetails, SiftDetails}

import java.time.LocalDate

case class ApplicationSummaryDetails(
  historyDetails: HistoryDetails,
  preSiftDetails: PreSiftDetails,
  siftDetails: SiftDetails
)

object APPLICATION_SUMMARY_DATA
    extends ApplicationSummaryDetails(
      APPLICATION_EMPLOYMENT_HISTORY,
      APPLICATION_PRE_SIFT_EVALUATION,
      APPLICATION_SIFT_EVALUATION
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
