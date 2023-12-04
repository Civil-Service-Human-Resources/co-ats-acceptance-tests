package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

object MASTER_VACANCY_DATA
    extends NewVacancyDetails(
      MASTER_BASIC_DETAILS,
      MASTER_JOB_INFORMATION,
      MASTER_APPROACH,
      MASTER_APPROVAL,
      MASTER_RESERVE_LIST,
      MASTER_LOCATIONS,
      MASTER_CONTRACT_DETAILS,
      MASTER_ADVERT,
      MASTER_CONTACT_DETAILS,
      MASTER_VETTING_DETAILS,
      MASTER_INTERVIEWS_DETAILS,
      MASTER_SUCCESS_PROFILES,
      MASTER_VACANCY_TESTS,
      MASTER_ADDITIONAL_QUESTIONS,
      MASTER_CRITERIA,
      MASTER_MANAGEMENT,
      MASTER_ONLINE_PEC_CHECK_FORMS,
      MASTER_PEC_CHECK_FORMS
    )

object MASTER_BASIC_DETAILS
    extends BasicDetails(
      "Insolvency Service - Apply online",
      s"GCQACO - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object MASTER_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Insolvency Service",
      "Insolvency - Information and Technology Directorate",
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
      "3"
    )
object MASTER_APPROACH
    extends ApproachDetails(
      "External",
      true,
      "Autotest - Eligibility statement",
      true,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )
object MASTER_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)"
    )

object MASTER_RESERVE_LIST
    extends ReserveListDetails(
      true,
      "12 Months",
      false
    )

object MASTER_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "M1 4RJ",
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

object MASTER_CONTRACT_DETAILS
    extends ContractDetails(
      List("Permanent", "Temporary", "Loan", "Secondment", "Returner"),
      "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
      true,
      "Prawf awtomeiddio",
      List("Full-time", "Part-time", "Compressed Hours", "Flexible working", "Homeworking"),
      "Senior Executive Officer",
      "Grade 7",
      "GBP (£)",
      75000,
      95000,
      "Can agree on the higher bracket",
      true,
      18750
    )

object MASTER_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object MASTER_CONTACT_DETAILS
    extends ContactDetails(
      s"$nameVxConfig",
      s"$emailVxConfig",
      "01000 000000",
      s"$nameVxConfig",
      s"$emailVxConfig",
      s"$emailVxConfig"
    )

object MASTER_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Basic",
      "Disclosure barring service (DBS)",
      "Security check",
      true
    )

object MASTER_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "4",
      "Telephone",
      "Assessment",
      "Video",
      "Interview",
      true
    )

object MASTER_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      true,
      true,
      true,
      true,
      true,
      Some(MASTER_ABILITIES),
      Some(MASTER_BEHAVIOURS),
      Some(MASTER_EXPERIENCES),
      Some(MASTER_STRENGTHS),
      Some(MASTER_TECH_SKILLS)
    )

object MASTER_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object MASTER_BEHAVIOURS
    extends BehavioursDetails(
      assessBehaviours = """The following online tests can be used to assess behaviours:
          |Civil Service Judgement Test
          |Civil Service Management Judgement Test""".stripMargin,
      8,
      behaviourOne =
        Some(Behaviours(chosenBehaviour = "Changing and Improving", stageApplication = true, stageInterview = true)),
      behaviourTwo = Some(
        Behaviours(chosenBehaviour = "Communicating and Influencing", stageApplication = true, stageInterview = true)
      ),
      behaviourThree =
        Some(Behaviours(chosenBehaviour = "Delivering at Pace", stageApplication = true, stageInterview = true)),
      behaviourFour = Some(
        Behaviours(chosenBehaviour = "Developing Self and Others", stageApplication = true, stageInterview = true)
      ),
      behaviourFive = Some(Behaviours(chosenBehaviour = "Leadership", stageApplication = true, stageInterview = true)),
      behaviourSix = Some(
        Behaviours(chosenBehaviour = "Making Effective Decisions", stageApplication = true, stageInterview = true)
      ),
      behaviourSeven = Some(
        Behaviours(chosenBehaviour = "Managing a Quality Service", stageApplication = true, stageInterview = true)
      ),
      behaviourEight = Some(
        Behaviours(chosenBehaviour = "Working Together", stageApplication = true, stageInterview = true)
      )
    )

object MASTER_EXPERIENCES
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
      licences =
        Some(MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific licence requirements")),
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

object MASTER_STRENGTHS
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

object MASTER_TECH_SKILLS
    extends TechSkillsDetails(
      8,
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 1",
          description = "Autotest - technical skills 1 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 2",
          description = "Autotest - technical skills 2 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 3",
          description = "Autotest - technical skills 3 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 4",
          description = "Autotest - technical skills 4 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 5",
          description = "Autotest - technical skills 5 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 6",
          description = "Autotest - technical skills 6 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 7",
          description = "Autotest - technical skills 7 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 8",
          description = "Autotest - technical skills 8 description",
          techInterview = true,
          techApplication = true
        )
      )
    )

object MASTER_VACANCY_TESTS
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
      Some(MASTER_RECRUITER_TESTS),
      Some(MASTER_GROUP_A_TESTS),
      Some(MASTER_GROUP_B_TESTS),
      Some(MASTER_GROUP_C_TESTS)
    )

object MASTER_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object MASTER_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object MASTER_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object MASTER_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object MASTER_ADDITIONAL_QUESTIONS
    extends MoreQuestionsDetails(
      true,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object MASTER_CRITERIA
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

object MASTER_MANAGEMENT
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

object MASTER_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      s"$usernameVxConfig"
    )

object MASTER_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Before pre employment checks",
      "Right to work and criminal record check",
      true,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      referenceChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      bankruptcyChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      crcChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nsvChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      healthRefChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      overseasCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      pensionsCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      previousCsJobCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      internalFraudCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      selfEmploymentCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      true,
      true,
      "Autotest - Name of check",
      additionalCheck = List("Not Applicable"),
      nenOnboarding = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      pnOnboarding = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates")
    )
