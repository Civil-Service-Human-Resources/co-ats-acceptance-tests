package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{contactEmailVxConfig, contactNameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

object INSOLVENCY_VACANCY_DATA
    extends NewVacancyDetails(
      INSOLVENCY_BASIC_DETAILS,
      INSOLVENCY_JOB_INFORMATION,
      INSOLVENCY_APPROACH,
      INSOLVENCY_APPROVAL,
      INSOLVENCY_RESERVE_LIST,
      INSOLVENCY_LOCATIONS,
      INSOLVENCY_CONTRACT_DETAILS,
      INSOLVENCY_ADVERT,
      INSOLVENCY_CONTACT_DETAILS,
      INSOLVENCY_VETTING_DETAILS,
      INSOLVENCY_INTERVIEWS_DETAILS,
      INSOLVENCY_SUCCESS_PROFILES,
      INSOLVENCY_VACANCY_TESTS,
      INSOLVENCY_ADDITIONAL_QUESTIONS,
      INSOLVENCY_CRITERIA,
      INSOLVENCY_MANAGEMENT,
      INSOLVENCY_ONLINE_PEC_CHECK_FORMS,
      INSOLVENCY_PEC_CHECK_FORMS
    )

object INSOLVENCY_BASIC_DETAILS
    extends BasicDetails(
      "Insolvency Service - Apply online",
      s"AUTOCO - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object INSOLVENCY_JOB_INFORMATION
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
      "5"
    )
object INSOLVENCY_APPROACH
    extends ApproachDetails(
      "External",
      true,
      "Autotest - Eligibility statement",
      true,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )
object INSOLVENCY_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)"
    )

object INSOLVENCY_RESERVE_LIST
    extends ReserveListDetails(
      false,
      "12 Months",
      false
    )

object INSOLVENCY_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "M1 4RJ",
      "Manchester",
      "North West",
      "Germany",
      "Newcastle, Liverpool, Cardiff",
      false,
      true,
      "All communities",
      false,
      "3",
      otherLocations = List("London", "Southampton", "Manchester")
    )

object INSOLVENCY_CONTRACT_DETAILS
    extends ContractDetails(
      List("Permanent"),
      "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
      true,
      "Prawf awtomeiddio",
      List("Full-time"),
      "Executive Officer",
      "Grade 7",
      "GBP (£)",
      25000,
      95000,
      "Can agree on the higher bracket",
      false,
      18750
    )

object INSOLVENCY_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object INSOLVENCY_CONTACT_DETAILS
    extends ContactDetails(
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      "01000 000000",
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      s"$contactEmailVxConfig"
    )

object INSOLVENCY_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Standard",
      "Disclosure barring service (DBS)",
      "None",
      false
    )

object INSOLVENCY_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "No interviews",
      "Video",
      "Assessment",
      "Telephone",
      "Interview",
      false
    )

object INSOLVENCY_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      false,
      false,
      false,
      false,
      false,
      Some(INSOLVENCY_ABILITIES),
      Some(INSOLVENCY_BEHAVIOURS),
      Some(INSOLVENCY_EXPERIENCES),
      Some(INSOLVENCY_STRENGTHS),
      Some(INSOLVENCY_TECH_SKILLS)
    )

object INSOLVENCY_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object INSOLVENCY_BEHAVIOURS
    extends BehavioursDetails(
      assessBehaviours = """The following online tests can be used to assess behaviours:
          |Civil Service Judgement Test
          |Civil Service Management Judgement Test""".stripMargin,
      8,
      behaviourOne =
        Some(Behaviours(chosenBehaviour = "Changing and Improving", stageApplication = true, stageInterview = false)),
      behaviourTwo = Some(
        Behaviours(chosenBehaviour = "Communicating and Influencing", stageApplication = true, stageInterview = false)
      ),
      behaviourThree =
        Some(Behaviours(chosenBehaviour = "Delivering at Pace", stageApplication = true, stageInterview = true)),
      behaviourFour = Some(
        Behaviours(chosenBehaviour = "Developing Self and Others", stageApplication = true, stageInterview = true)
      ),
      behaviourFive = Some(Behaviours(chosenBehaviour = "Leadership", stageApplication = true, stageInterview = true)),
      behaviourSix = Some(
        Behaviours(chosenBehaviour = "Making Effective Decisions", stageApplication = true, stageInterview = false)
      ),
      behaviourSeven = Some(
        Behaviours(chosenBehaviour = "Managing a Quality Service", stageApplication = true, stageInterview = true)
      ),
      behaviourEight = Some(
        Behaviours(chosenBehaviour = "Working Together", stageApplication = true, stageInterview = true)
      )
    )

object INSOLVENCY_EXPERIENCES
    extends ExperienceDetails(
      true,
      "0 - 7",
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

object INSOLVENCY_STRENGTHS
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

object INSOLVENCY_TECH_SKILLS
    extends TechSkillsDetails(
      8,
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 1",
          description = "Autotest - technical skills 1 description",
          techInterview = false,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 2",
          description = "Autotest - technical skills 2 description",
          techInterview = false,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 3",
          description = "Autotest - technical skills 3 description",
          techInterview = false,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 4",
          description = "Autotest - technical skills 4 description",
          techInterview = false,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 5",
          description = "Autotest - technical skills 5 description",
          techInterview = false,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 6",
          description = "Autotest - technical skills 6 description",
          techInterview = false,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 7",
          description = "Autotest - technical skills 7 description",
          techInterview = false,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 8",
          description = "Autotest - technical skills 8 description",
          techInterview = false,
          techApplication = true
        )
      )
    )

object INSOLVENCY_VACANCY_TESTS
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
      Some(INSOLVENCY_RECRUITER_TESTS),
      Some(INSOLVENCY_GROUP_A_TESTS),
      Some(INSOLVENCY_GROUP_B_TESTS),
      Some(INSOLVENCY_GROUP_C_TESTS)
    )

object INSOLVENCY_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object INSOLVENCY_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object INSOLVENCY_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object INSOLVENCY_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object INSOLVENCY_ADDITIONAL_QUESTIONS
    extends AdditionalQuestionsDetails(
      false,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object INSOLVENCY_CRITERIA
    extends CriteriaDetails(
      campaignID = Some("Autotest - If this vacancy is linked to a campaign, enter the campaign ID (optional)"),
      probationIncomplete = false,
      promotionApply = false,
      misconductLive = false,
      performanceReview = false,
      attendancePoor = false,
      nationalityRequirements = true,
      rightToRemainUK = false,
      licencesNotHeld = false,
      membershipsNotHeld = false,
      languagesSkillsNotHeld = false,
      qualificationsHeld = false,
      preSiftRequired = false,
      uploadAttachment = false,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object INSOLVENCY_MANAGEMENT
    extends ManagementDetails(
      false,
      false,
      "Other",
      false,
      assignTo = Option(s"$contactEmailVxConfig"),
      assignTo2 = Option(s"$contactEmailVxConfig"),
      true,
      "Business As Usual (BAU)",
      "Menu",
      false,
      false,
      linkToProject = Option(false),
      projectName = Option("Autotest - Project name"),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object INSOLVENCY_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      false,
      s"$contactEmailVxConfig"
    )

object INSOLVENCY_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = List("Not Applicable"),
      "Before pre employment checks",
      "No digital checks",
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
      pensionsCheck = List("Not Applicable"),
      previousCsJobCheck = List("Not Applicable"),
      internalFraudCheck = List("Not Applicable"),
      selfEmploymentCheck = List("Not Applicable"),
      false,
      false,
      "Autotest - Name of check",
      additionalCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nenOnboarding = List("Not Applicable"),
      pnOnboarding = List("Not Applicable")
    )
