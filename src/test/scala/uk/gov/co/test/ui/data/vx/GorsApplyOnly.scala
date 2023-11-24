package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.vx.createvacancypage._

object GORS_DATA
    extends NewVacancyDetails(
      GORS_BASIC_DETAILS,
      GORS_JOB_INFORMATION,
      GORS_APPROACH,
      GORS_APPROVAL,
      GORS_RESERVE_LIST,
      GORS_LOCATIONS,
      GORS_CONTRACT_DETAILS,
      GORS_ADVERT,
      GORS_CONTACT_DETAILS,
      GORS_VETTING_DETAILS,
      GORS_INTERVIEWS_DETAILS,
      GORS_SUCCESS_PROFILES,
      GORS_HOLDER_TESTS,
      GORS_ADDITIONAL_QUESTIONS,
      GORS_CRITERIA,
      GORS_MANAGEMENT,
      GORS_ONLINE_PEC_CHECK_FORMS,
      GORS_PEC_CHECK_FORMS
    )

object GORS_BASIC_DETAILS
    extends BasicDetails(
      "Government Operational Research Service - Apply Online",
      "GCQACO - Operational Research Analyst",
      32
    )
object GORS_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Government Operational Research Service",
      "GORS",
      "Autotest - Business area detail",
      "Accountancy",
      "Other",
      "1"
    )
object GORS_APPROACH
    extends ApproachDetails(
      "External",
      false,
      "Autotest - Eligibility statement"
    )
object GORS_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre"
    )

object GORS_RESERVE_LIST
    extends ReserveListDetails(
      false,
      "12 Months"
    )

object GORS_LOCATIONS
    extends LocationsDetails(
      "Towns",
      "SK1 3BX",
      "Cardiff",
      "North West",
      "Germany",
      "Newcastle, Liverpool",
      false,
      true,
      "All communities",
      false,
      "2",
      otherCityOrTown = List("London", "Southampton")
    )

object GORS_CONTRACT_DETAILS
    extends ContractDetails(
      "Permanent",
      "Full-time",
      "Administrative Officer",
      "Grade 7",
      "GBP (£)",
      75000,
      95000,
      "Autotest - More details (optional)",
      false,
      18750
    )

object GORS_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object GORS_CONTACT_DETAILS
    extends ContactDetails(
      s"$nameVxConfig",
      s"$emailVxConfig",
      "01000 000000",
      s"$nameVxConfig",
      s"$emailVxConfig",
      s"$emailVxConfig"
    )

object GORS_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Standard",
      "Disclosure barring service (DBS)",
      "None",
      false
    )

object GORS_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "No interviews",
      "Video",
      "Assessment",
      "Video",
      "Interview",
      false
    )

object GORS_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      false,
      false,
      false,
      false,
      false,
      Some(GORS_ABILITIES),
      Some(GORS_BEHAVIOURS),
      Some(GORS_EXPERIENCES),
      Some(GORS_STRENGTHS),
      Some(GORS_TECH_SKILLS)
    )

object GORS_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object GORS_BEHAVIOURS
    extends BehavioursDetails(
      """The following online tests can be used to assess behaviours:
    |Civil Service Judgement Test
    |Civil Service Management Judgement Test""".stripMargin,
      3,
      Some(
        Behaviours(chosenBehaviour = "Communicating and Influencing", stageApplication = false, stageInterview = true)
      ),
      Some(Behaviours(chosenBehaviour = "Managing a Quality Service", stageApplication = false, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Working Together", stageApplication = false, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Changing and Improving", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Delivering at Pace", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Developing Self and Others", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Leadership", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Making Effective Decisions", stageApplication = true, stageInterview = true))
    )

object GORS_EXPERIENCES
    extends ExperienceDetails(
      true,
      "0 - 100",
      true,
      true,
      true,
      true,
      "0 - 7",
      500,
      true,
      "Autotest - Enter guidance text for the candidate",
      true,
      "Autotest - Specific past experience/skills",
      licences = Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific licence requirements")
      ),
      memberships = Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific memberships requirements")
      ),
      languages = Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific language requirements")
      ),
      qualifications = Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific qualification requirements")
      )
    )

object GORS_STRENGTHS
    extends StrengthsDetails(
      3,
      "Problem Solver",
      "Relationship Builder",
      "Organiser",
      "Analytical",
      "Improver",
      "Challenger",
      "Change Agent",
      "Team Leader"
    )

object GORS_TECH_SKILLS
    extends TechSkillsDetails(
      8,
      Some(
        Skills(
          techSkill = "Autotest - technical skills 1",
          description = "Autotest - technical skills 1 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        Skills(
          techSkill = "Autotest - technical skills 2",
          description = "Autotest - technical skills 2 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        Skills(
          techSkill = "Autotest - technical skills 3",
          description = "Autotest - technical skills 3 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        Skills(
          techSkill = "Autotest - technical skills 4",
          description = "Autotest - technical skills 4 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        Skills(
          techSkill = "Autotest - technical skills 5",
          description = "Autotest - technical skills 5 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        Skills(
          techSkill = "Autotest - technical skills 6",
          description = "Autotest - technical skills 6 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        Skills(
          techSkill = "Autotest - technical skills 7",
          description = "Autotest - technical skills 7 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        Skills(
          techSkill = "Autotest - technical skills 8",
          description = "Autotest - technical skills 8 description",
          techInterview = true,
          techApplication = true
        )
      )
    )

object GORS_HOLDER_TESTS
    extends VacancyTestsDetails(
      false,
      "Online Tests",
      "Executive Officer",
      testName = Map(
        "Administrative Assistant" -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Work Strengths Test",
          "Customer Service Skills Test"
        ),
        "Administrative Officer"   -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Work Strengths Test",
          "Casework Skills Test",
          "Customer Service Skills Test"
        ),
        "Executive Officer"        -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Management Judgement Test",
          "Civil Service Work Strengths Test",
          "Casework Skills Test",
          "Customer Service Skills Test"
        ),
        "Higher Executive Officer" -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Management Judgement Test",
          "Civil Service Work Strengths Test"
        ),
        "Senior Executive Officer" -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Management Judgement Test",
          "Civil Service Work Strengths Test"
        ),
        "Grade 7 "                 -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Work Strengths Test"
        ),
        "Grade 6"                  -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Work Strengths Test"
        )
      ),
      false,
      "Autotest - Additional details for the recruitment team",
      Some(GORS_RECRUITER_TESTS),
      Some(GORS_GROUP_A_TESTS),
      Some(GORS_GROUP_B_TESTS),
      Some(GORS_GROUP_C_TESTS)
    )

object GORS_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object GORS_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object GORS_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object GORS_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object GORS_ADDITIONAL_QUESTIONS
    extends MoreQuestionsDetails(
      false,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object GORS_CRITERIA
    extends CriteriaDetails(
      campaignID = Some("Autotest - If this vacancy is linked to a campaign, enter the campaign ID (optional)"),
      probationIncomplete = false,
      promotionApply = false,
      misconductLive = false,
      performanceReview = false,
      attendancePoor = false,
      nationalityRequirements = true,
      rightToRemainUK = false,
      licencesNotHeld = true,
      membershipsNotHeld = true,
      languagesSkillsNotHeld = true,
      qualificationsHeld = true,
      preSiftRequired = false,
      uploadAttachment = false,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object GORS_MANAGEMENT
    extends ManagementDetails(
      false,
      false,
      "Other",
      false,
      assignTo = Option(s"$usernameVxConfig"),
      assignTo2 = Option(s"$usernameVxConfig"),
      "Business As Usual (BAU)",
      "Menu",
      false,
      false,
      linkToProject = Option(true),
      projectName = Option("Autotest - Project name"),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object GORS_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      false,
      s"$usernameVxConfig"
    )

object GORS_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = List("External Candidates", "OGD Candidates", "NDPB Candidates"),
      "At the same time as pre employment checks",
      "Right to work and criminal record check",
      false,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo = List("Not Applicable"),
      referenceChecks = List("External Candidates", "NDPB Candidates"),
      bankruptcyChecks = List("Not Applicable"),
      crcChecks = List("Not Applicable"),
      nsvChecks = List("Not Applicable"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = List("External Candidates", "NDPB Candidates"),
      healthRefChecks = List("Not Applicable"),
      "Show recruiter and candidate forms",
      overseasCheck = List("Not Applicable"),
      pensionsCheck = List("External Candidates"),
      previousCsJobCheck = List("Not Applicable"),
      internalFraudCheck = List("Not Applicable"),
      selfEmploymentCheck = List("Not Applicable"),
      false,
      false,
      "Autotest - Name of check",
      additionalCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nenOnboarding = List("Not Applicable"),
      pnOnboarding = List("Not Applicable")
    )
