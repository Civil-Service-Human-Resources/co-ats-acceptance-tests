package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig, usernameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

object MIN_VACANCY_DATA
    extends NewVacancyDetails(
      MIN_BASIC_DETAILS,
      MIN_JOB_INFORMATION,
      MIN_APPROACH,
      MIN_APPROVAL,
      MIN_RESERVE_LIST,
      MIN_LOCATIONS,
      MIN_CONTRACT_DETAILS,
      MIN_ADVERT,
      MIN_CONTACT_DETAILS,
      MIN_VETTING_DETAILS,
      MIN_INTERVIEWS_DETAILS,
      MIN_SUCCESS_PROFILES,
      MIN_VACANCY_TESTS,
      MIN_ADDITIONAL_QUESTIONS,
      MIN_CRITERIA,
      MIN_MANAGEMENT,
      MIN_ONLINE_PEC_CHECK_FORMS,
      MIN_PEC_CHECK_FORMS
    )

object MIN_BASIC_DETAILS
    extends BasicDetails(
      "Insolvency Service - Apply online",
      s"GCQACO - " + generateRandomJobPosition(),
      false,
      "Prawf awtomeiddio",
      32
    )
object MIN_JOB_INFORMATION
    extends JobInfoDetails(
      false,
      "Insolvency Service",
      "Insolvency - Finance, Commercial, Sustainability and Property ",
      false,
      "Prawf awtomeiddio",
      "Autotest - Business area detail",
      typeOfRole = List(
        "Accountancy"
      ),
      "Other",
      "1"
    )
object MIN_APPROACH
    extends ApproachDetails(
      "External",
      false,
      "Autotest - Eligibility statement",
      false,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )
object MIN_APPROVAL
    extends ApprovalDetails(
      false,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)"
    )

object MIN_RESERVE_LIST
    extends ReserveListDetails(
      false,
      "3 Months",
      false
    )

object MIN_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "SK1 3BX",
      "Manchester",
      "North West",
      "Germany",
      "Newcastle",
      false,
      false,
      "All communities",
      false,
      "1",
      otherLocations = List("London")
    )

object MIN_CONTRACT_DETAILS
    extends ContractDetails(
      List("Permanent"),
      "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
      false,
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

object MIN_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object MIN_CONTACT_DETAILS
    extends ContactDetails(
      s"$nameVxConfig",
      s"$emailVxConfig",
      "01000 000000",
      s"$nameVxConfig",
      s"$emailVxConfig",
      s"$emailVxConfig"
    )

object MIN_VETTING_DETAILS
    extends VettingDetails(
      false,
      "Basic",
      "Disclosure barring service (DBS)",
      "Security check",
      true
    )

object MIN_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "1",
      "Telephone",
      "Assessment",
      "Video",
      "Interview",
      true
    )

object MIN_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      false,
      false,
      false,
      false,
      false,
      Some(MIN_ABILITIES),
      Some(MIN_BEHAVIOURS),
      Some(MIN_EXPERIENCES),
      Some(MIN_STRENGTHS),
      Some(MIN_TECH_SKILLS)
    )

object MIN_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
      |Civil Service Numerical Test
      |Civil Service Verbal Test""".stripMargin
    )

object MIN_BEHAVIOURS
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

object MIN_EXPERIENCES
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

object MIN_STRENGTHS
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

object MIN_TECH_SKILLS
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

object MIN_VACANCY_TESTS
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
      Some(MIN_RECRUITER_TESTS),
      Some(MIN_GROUP_A_TESTS),
      Some(MIN_GROUP_B_TESTS),
      Some(MIN_GROUP_C_TESTS)
    )

object MIN_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object MIN_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object MIN_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object MIN_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object MIN_ADDITIONAL_QUESTIONS
    extends MoreQuestionsDetails(
      false,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object MIN_CRITERIA
    extends CriteriaDetails(
      campaignID = Some("Autotest - If this vacancy is linked to a campaign, enter the campaign ID (optional)"),
      probationIncomplete = false,
      promotionApply = false,
      misconductLive = false,
      performanceReview = false,
      attendancePoor = false,
      nationalityRequirements = true,
      rightToRemainUK = true,
      licencesNotHeld = false,
      membershipsNotHeld = false,
      languagesSkillsNotHeld = false,
      qualificationsHeld = false,
      preSiftRequired = true,
      uploadAttachment = false,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object MIN_MANAGEMENT
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

object MIN_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      s"$usernameVxConfig"
    )

object MIN_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = List("External Candidates", "OGD Candidates"),
      "Before pre employment checks",
      "Right to work and criminal record check",
      true,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo = List("External Candidates", "OGD Candidates"),
      referenceChecks = List("External Candidates", "OGD Candidates"),
      bankruptcyChecks = List("External Candidates", "OGD Candidates"),
      crcChecks = List("External Candidates", "OGD Candidates"),
      nsvChecks = List("External Candidates", "OGD Candidates"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = List("External Candidates", "OGD Candidates"),
      healthRefChecks = List("External Candidates", "OGD Candidates"),
      "Show recruiter and candidate forms",
      overseasCheck = List("External Candidates", "OGD Candidates"),
      pensionsCheck = List("External Candidates", "OGD Candidates"),
      previousCsJobCheck = List("External Candidates", "OGD Candidates"),
      internalFraudCheck = List("External Candidates", "OGD Candidates"),
      selfEmploymentCheck = List("External Candidates", "OGD Candidates"),
      true,
      false,
      "Autotest - Name of check",
      additionalCheck = List("Not Applicable"),
      nenOnboarding = List("External Candidates", "OGD Candidates"),
      pnOnboarding = List("External Candidates", "OGD Candidates")
    )
