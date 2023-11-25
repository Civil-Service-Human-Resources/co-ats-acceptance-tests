package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.vx.createvacancypage._

object MAIN_VACANCY_DATA
    extends NewVacancyDetails(
      MAIN_BASIC_DETAILS,
      MAIN_JOB_INFORMATION,
      MAIN_APPROACH,
      MAIN_APPROVAL,
      MAIN_RESERVE_LIST,
      MAIN_LOCATIONS,
      MAIN_CONTRACT_DETAILS,
      MAIN_ADVERT,
      MAIN_CONTACT_DETAILS,
      MAIN_VETTING_DETAILS,
      MAIN_INTERVIEWS_DETAILS,
      MAIN_SUCCESS_PROFILES,
      MAIN_HOLDER_TESTS,
      MAIN_ADDITIONAL_QUESTIONS,
      MAIN_CRITERIA,
      MAIN_MANAGEMENT,
      MAIN_ONLINE_PEC_CHECK_FORMS,
      MAIN_PEC_CHECK_FORMS
    )

object MAIN_BASIC_DETAILS
    extends BasicDetails(
      "Department for Environment, Food and Rural Affairs - Apply online",
      "GCQACO - DEFRA Senior Research Analyst",
      true,
      "Prawf awtomeiddio",
      32
    )
object MAIN_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Department for Environment, Food and Rural Affairs - Apply online",
      "DEFRA - COO - Commercial",
      true,
      "Prawf awtomeiddio",
      "Autotest - Business area detail",
      typeOfRole = List(
        "Accountancy",
        "Analytical",
        "Audit",
        "Corporate Finance",
        "Engineering",
        "Tax Profession"
      ),
      "Other",
      "1"
    )
object MAIN_APPROACH
    extends ApproachDetails(
      "External",
      true,
      "Autotest - Eligibility statement",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )
object MAIN_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre"
    )

object MAIN_RESERVE_LIST
    extends ReserveListDetails(
      true,
      "3 Months",
      false
    )

object MAIN_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "SK1 3BX",
      "Manchester",
      "North West",
      "Germany",
      "Newcastle, Liverpool, Cardiff",
      true,
      true,
      "All communities",
      true,
      "2",
      otherLocations = List("London", "Southampton")
    )

object MAIN_CONTRACT_DETAILS
    extends ContractDetails(
      "Permanent",
      "Full-time",
      "Senior Executive Officer",
      "Grade 7",
      "GBP (£)",
      75000,
      95000,
      "Can agree on the higher bracket",
      true,
      18750
    )

object MAIN_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object MAIN_CONTACT_DETAILS
    extends ContactDetails(
      s"$nameVxConfig",
      s"$emailVxConfig",
      "01000 000000",
      s"$nameVxConfig",
      s"$emailVxConfig",
      s"$emailVxConfig"
    )

object MAIN_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Basic",
      "Disclosure barring service (DBS)",
      "Security check",
      true
    )

object MAIN_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "4",
      "Telephone",
      "Assessment",
      "Video",
      "Interview",
      true
    )

object MAIN_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      true,
      true,
      true,
      true,
      true,
      Some(MAIN_ABILITIES),
      Some(MAIN_BEHAVIOURS),
      Some(MAIN_EXPERIENCES),
      Some(MAIN_STRENGTHS),
      Some(MAIN_TECH_SKILLS)
    )

object MAIN_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object MAIN_BEHAVIOURS
    extends BehavioursDetails(
      """The following online tests can be used to assess behaviours:
    |Civil Service Judgement Test
    |Civil Service Management Judgement Test""".stripMargin,
      8,
      Some(Behaviours(chosenBehaviour = "Changing and Improving", stageApplication = true, stageInterview = true)),
      Some(
        Behaviours(chosenBehaviour = "Communicating and Influencing", stageApplication = true, stageInterview = true)
      ),
      Some(Behaviours(chosenBehaviour = "Delivering at Pace", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Developing Self and Others", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Leadership", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Making Effective Decisions", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Managing a Quality Service", stageApplication = true, stageInterview = true)),
      Some(Behaviours(chosenBehaviour = "Working Together", stageApplication = true, stageInterview = true))
    )

object MAIN_EXPERIENCES
    extends ExperienceDetails(
      true,
      "0 - 100",
      true,
      true,
      true,
      true,
      "0 - 7",
      250,
      true,
      "Autotest - Enter guidance text for the candidate",
      true,
      "Autotest - Specific past experience/skills",
      Some(MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific licence requirements")),
      Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific memberships requirements")
      ),
      Some(MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific language requirements")),
      Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific qualification requirements")
      )
    )

object MAIN_STRENGTHS
    extends StrengthsDetails(
      8,
      "Adaptable",
      "Analytical",
      "Improver",
      "Relationship Builder",
      "Challenger",
      "Change Agent",
      "Team Leader",
      "Service Focussed"
    )

object MAIN_TECH_SKILLS
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

object MAIN_HOLDER_TESTS
    extends VacancyTestsDetails(
      true,
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
      Some(MAIN_RECRUITER_TESTS),
      Some(MAIN_GROUP_A_TESTS),
      Some(MAIN_GROUP_B_TESTS),
      Some(MAIN_GROUP_C_TESTS)
    )

object MAIN_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object MAIN_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object MAIN_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object MAIN_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object MAIN_ADDITIONAL_QUESTIONS
    extends MoreQuestionsDetails(
      true,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object MAIN_CRITERIA
    extends CriteriaDetails(
      campaignID = Some("Autotest - If this vacancy is linked to a campaign, enter the campaign ID (optional)"),
      probationIncomplete = true,
      promotionApply = true,
      misconductLive = true,
      performanceReview = true,
      attendancePoor = true,
      nationalityRequirements = true,
      rightToRemainUK = true,
      licencesNotHeld = true,
      membershipsNotHeld = true,
      languagesSkillsNotHeld = true,
      qualificationsHeld = true,
      preSiftRequired = true,
      uploadAttachment = true,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object MAIN_MANAGEMENT
    extends ManagementDetails(
      true,
      false,
      "Other",
      true,
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

object MAIN_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      s"$usernameVxConfig"
    )

object MAIN_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Before pre employment checks",
      "Right to work and criminal record check",
      true,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      referenceChecks =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      bankruptcyChecks =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      crcChecks =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nsvChecks =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      jobHistoryChecks =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      healthRefChecks =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      overseasCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      pensionsCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      previousCsJobCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      internalFraudCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      selfEmploymentCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      true,
      true,
      "Autotest - Name of check",
      additionalCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nenOnboarding =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      pnOnboarding =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates")
    )
