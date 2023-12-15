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
      "Scoring guide:\nNot demonstrated -No positive evidence and/or substantial negative evidence demonstrated\nMinimal demonstration -Limited positive evidence and/or mainly negative evidence demonstrated\nModerate demonstration -Moderate positive evidence but some negative evidence demonstrated\nAcceptable demonstration - Adequate positive evidence and any negative evidence would not cause concern\nGood demonstration - Substantial positive evidence of the competency or behaviour\nStrong demonstration - Substantial positive evidence; includes some evidence of exceeding expectations at this level\nOutstanding demonstration - The evidence provided wholly exceeds expectation at this level",
      behaviourOne = Some(Outcome(6, "Autotest - Changing and Improving - behaviour one comments")),
      behaviourTwo = Some(Outcome(6, "Autotest - Communicating and Influencing - behaviour two comments")),
      behaviourThree = Some(Outcome(6, "Autotest - Delivering at Pace - behaviour three comments")),
      behaviourFour = Some(Outcome(6, "Autotest - Developing Self and Others - behaviour four comments")),
      behaviourFive = Some(Outcome(6, "Autotest - Leadership - behaviour five comments")),
      behaviourSix = Some(Outcome(6, "Autotest - Making Effective Decisions - behaviour six comments")),
      behaviourSeven = Some(Outcome(6, "Autotest - Managing a Quality Service - behaviour seven comments")),
      behaviourEight = Some(Outcome(6, "Autotest - Working Together - behaviour eight comments")),
      techSkillOne = Some(Outcome(7, "Autotest - Tech Skill One - tech skill one  comments"))
    )
