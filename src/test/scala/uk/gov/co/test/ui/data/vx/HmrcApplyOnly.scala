package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.vx.createvacancypage._

object HMRC_APPLY_DATA
    extends NewVacancyDetails(
      HMRC_APPLY_BASIC_DETAILS,
      HMRC_APPLY_JOB_INFORMATION,
      HMRC_APPLY_APPROACH,
      HMRC_APPLY_APPROVAL,
      HMRC_APPLY_RESERVE_LIST,
      HMRC_APPLY_LOCATIONS,
      HMRC_APPLY_CONTRACT_DETAILS,
      HMRC_APPLY_ADVERT,
      HMRC_APPLY_CONTACT_DETAILS,
      HMRC_APPLY_VETTING_DETAILS,
      HMRC_APPLY_INTERVIEWS_DETAILS,
      HMRC_APPLY_SUCCESS_PROFILES,
      HMRC_APPLY_HOLDER_TESTS,
      HMRC_APPLY_ADDITIONAL_QUESTIONS,
      HMRC_APPLY_CRITERIA,
      HMRC_APPLY_MANAGEMENT,
      HMRC_APPLY_ONLINE_PEC_CHECK_FORMS,
      HMRC_APPLY_PEC_CHECK_FORMS
    )

object HMRC_APPLY_BASIC_DETAILS
    extends BasicDetails(
      "HM Revenue and Customs - Apply online",
      "Quality Assurance Tester",
      32
    )
object HMRC_APPLY_JOB_INFORMATION
    extends JobInfoDetails(
      false,
      "HM Revenue and Customs",
      "HMRC - SOLS - Business Transformation",
      "Autotest - Business area detail",
      "Analytical",
      "Digital, Data and Technology Profession",
      "1"
    )
object HMRC_APPLY_APPROACH
    extends ApproachDetails(
      "External",
      false,
      "Autotest - Eligibility statement"
    )
object HMRC_APPLY_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre"
    )

object HMRC_APPLY_RESERVE_LIST
    extends ReserveListDetails(
      false,
      "6 Months"
    )

object HMRC_APPLY_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "SK1 3BX",
      "Manchester",
      "North West",
      "Germany",
      "Newcastle, Liverpool, Cardiff",
      false,
      true,
      "All communities",
      false,
      "2",
      otherCityOrTown = List("London", "Southampton")
    )

object HMRC_APPLY_CONTRACT_DETAILS
    extends ContractDetails(
      "Permanent",
      "Full-time",
      "Senior Executive Officer",
      "Grade 7",
      "GBP (£)",
      75000,
      95000,
      "Autotest - More details (optional)",
      true,
      18750
    )

object HMRC_APPLY_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object HMRC_APPLY_CONTACT_DETAILS
    extends ContactDetails(
      s"$nameVxConfig",
      s"$emailVxConfig",
      "01000 000000",
      s"$nameVxConfig",
      s"$emailVxConfig",
      s"$emailVxConfig"
    )

object HMRC_APPLY_VETTING_DETAILS
    extends VettingDetails(
      false,
      "Standard",
      "Disclosure barring service (DBS)",
      "None",
      false
    )

object HMRC_APPLY_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "1",
      "Video",
      "Assessment",
      "Video",
      "Interview",
      false
    )

object HMRC_APPLY_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      false,
      true,
      true,
      true,
      false,
      Some(HMRC_APPLY_ABILITIES),
      Some(HMRC_APPLY_BEHAVIOURS),
      Some(HMRC_APPLY_EXPERIENCES),
      Some(HMRC_APPLY_STRENGTHS),
      Some(HMRC_APPLY_TECH_SKILLS)
    )

object HMRC_APPLY_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object HMRC_APPLY_BEHAVIOURS
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

object HMRC_APPLY_EXPERIENCES
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
        MandatoryRequirements(requirements = false, requirementsInfo = "Autotest - Specific licence requirements")
      ),
      memberships = Some(
        MandatoryRequirements(requirements = false, requirementsInfo = "Autotest - Specific memberships requirements")
      ),
      languages = Some(
        MandatoryRequirements(requirements = false, requirementsInfo = "Autotest - Specific language requirements")
      ),
      qualifications = Some(
        MandatoryRequirements(requirements = false, requirementsInfo = "Autotest - Specific qualification requirements")
      )
    )

object HMRC_APPLY_STRENGTHS
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

object HMRC_APPLY_TECH_SKILLS
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

object HMRC_APPLY_HOLDER_TESTS
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
      Some(HMRC_APPLY_RECRUITER_TESTS),
      Some(HMRC_APPLY_GROUP_A_TESTS),
      Some(HMRC_APPLY_GROUP_B_TESTS),
      Some(HMRC_APPLY_GROUP_C_TESTS)
    )

object HMRC_APPLY_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object HMRC_APPLY_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object HMRC_APPLY_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object HMRC_APPLY_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object HMRC_APPLY_ADDITIONAL_QUESTIONS
    extends MoreQuestionsDetails(
      true,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object HMRC_APPLY_CRITERIA
    extends CriteriaDetails(
      campaignID = Some("Autotest - If this vacancy is linked to a campaign, enter the campaign ID (optional)"),
      probationIncomplete = false,
      promotionApply = false,
      misconductLive = true,
      performanceReview = true,
      attendancePoor = true,
      nationalityRequirements = true,
      rightToRemainUK = true,
      licencesNotHeld = true,
      membershipsNotHeld = true,
      languagesSkillsNotHeld = true,
      qualificationsHeld = true,
      preSiftRequired = false,
      uploadAttachment = true,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object HMRC_APPLY_MANAGEMENT
    extends ManagementDetails(
      true,
      true,
      "Level of security",
      false,
      assignTo = Option(s"$usernameVxConfig"),
      assignTo2 = Option(s"$usernameVxConfig"),
      "Business As Usual (BAU)",
      "Menu",
      true,
      true,
      linkToProject = Option(true),
      projectName = Option("Autotest - Project name"),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object HMRC_APPLY_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      s"$usernameVxConfig"
    )

object HMRC_APPLY_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = List("External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Before pre employment checks",
      "Right to work and criminal record check",
      true,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo = List("External Candidates", "OGD Candidates", "NDPB Candidates"),
      referenceChecks = List("External Candidates", "NDPB Candidates"),
      bankruptcyChecks = List("External Candidates", "NDPB Candidates"),
      crcChecks = List("External Candidates", "OGD Candidates", "NDPB Candidates"),
      nsvChecks = List("Not Applicable"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = List("External Candidates", "NDPB Candidates"),
      healthRefChecks = List("External Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      overseasCheck = List("External Candidates", "NDPB Candidates"),
      pensionsCheck = List("External Candidates"),
      previousCsJobCheck = List("External Candidates", "NDPB Candidates"),
      internalFraudCheck = List("External Candidates", "NDPB Candidates"),
      selfEmploymentCheck = List("External Candidates", "NDPB Candidates"),
      false,
      false,
      "Autotest - Name of check",
      additionalCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nenOnboarding = List("External Candidates", "OGD Candidates", "NDPB Candidates"),
      pnOnboarding = List("Not Applicable")
    )
