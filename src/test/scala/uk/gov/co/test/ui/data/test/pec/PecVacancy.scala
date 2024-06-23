package uk.gov.co.test.ui.data.test.pec

import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{contactEmailVxConfig, contactNameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

import scala.collection.mutable.ListBuffer

object PEC_VACANCY_DATA
    extends NewVacancyDetails(
      PEC_BASIC_DETAILS,
      PEC_JOB_INFORMATION,
      PEC_APPROACH,
      PEC_APPROVAL,
      PEC_RESERVE_LIST,
      PEC_LOCATIONS,
      PEC_CONTRACT_DETAILS,
      PEC_ADVERT,
      PEC_CONTACT_DETAILS,
      PEC_VETTING_DETAILS,
      PEC_INTERVIEWS_DETAILS,
      PEC_SUCCESS_PROFILES,
      PEC_VACANCY_TESTS,
      PEC_ADDITIONAL_QUESTIONS,
      PEC_CRITERIA,
      PEC_MANAGEMENT,
      PEC_ONLINE_PEC_CHECK_FORMS,
      PEC_PEC_CHECK_FORMS
    )

object PEC_BASIC_DETAILS
    extends BasicDetails(
      "DO NOT USE- Automation Test Template",
      s"PEC - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object PEC_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Ministry of Defence",
      "MOD - Air",
      true,
      "Prawf awtomeiddio",
      "Autotest - Business area detail",
      "Autotest - Position identifier",
      typeOfRole = ListBuffer(
        "Accountancy",
        "Analytical",
        "Audit",
        "Corporate Finance",
        "Engineering",
        "Tax Profession"
      ),
      "Other",
      "1",
      false
    )
object PEC_APPROACH
    extends ApproachDetails(
      "External",
      true,
      "Autotest - Eligibility statement",
      true,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )

object PEC_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)",
      "Test-T&Cs.pdf"
    )

object PEC_RESERVE_LIST
    extends ReserveListDetails(
      true,
      "12 Months",
      false,
      "6 Months"
    )

object PEC_LOCATIONS
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
      otherLocations = ListBuffer("London", "Southampton", "Manchester")
    )

object PEC_CONTRACT_DETAILS
  extends ContractDetails(
    List("Permanent", "Temporary", "Loan", "Secondment", "Returner"),
    "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
    true,
    "Prawf awtomeiddio",
    List("Full-time", "Part-time", "Compressed Hours", "Flexible working", "Homeworking"),
    ListBuffer("Senior Executive Officer"),
    "Grade 7",
    "GBP (£)",
    75000,
    95000,
    "Can agree on the higher bracket",
    true,
    18750
  )

object PEC_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object PEC_CONTACT_DETAILS
    extends ContactDetails(
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      "01000 000000",
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      s"$contactEmailVxConfig"
    )

object PEC_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Basic",
      "Disclosure barring service (DBS)",
      "Security check",
      true
    )

object PEC_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "2",
      "Interview",
      "Assessment",
      "Telephone",
      "Video",
      false
    )

object PEC_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      true,
      true,
      true,
      true,
      true,
      Some(PEC_ABILITIES),
      Some(PEC_BEHAVIOURS),
      Some(PEC_EXPERIENCES),
      Some(PEC_STRENGTHS),
      Some(PEC_TECH_SKILLS)
    )

object PEC_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object PEC_BEHAVIOURS
    extends BehavioursDetails(
      assessBehaviours = """The following online tests can be used to assess behaviours:
          |Civil Service Judgement Test
          |Civil Service Management Judgement Test""".stripMargin,
      8,
      behaviourOne =
        Some(Behaviours(chosenBehaviour = "Changing and Improving", stageApplication = false, stageInterview = true)),
      behaviourTwo = Some(
        Behaviours(chosenBehaviour = "Communicating and Influencing", stageApplication = true, stageInterview = true)
      ),
      behaviourThree =
        Some(Behaviours(chosenBehaviour = "Delivering at Pace", stageApplication = true, stageInterview = true)),
      behaviourFour = Some(
        Behaviours(chosenBehaviour = "Developing Self and Others", stageApplication = false, stageInterview = true)
      ),
      behaviourFive = Some(Behaviours(chosenBehaviour = "Leadership", stageApplication = true, stageInterview = true)),
      behaviourSix = Some(
        Behaviours(chosenBehaviour = "Making Effective Decisions", stageApplication = false, stageInterview = true)
      ),
      behaviourSeven = Some(
        Behaviours(chosenBehaviour = "Managing a Quality Service", stageApplication = true, stageInterview = true)
      ),
      behaviourEight = Some(
        Behaviours(chosenBehaviour = "Working Together", stageApplication = true, stageInterview = false)
      )
    )

object PEC_EXPERIENCES
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

object PEC_STRENGTHS
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

object PEC_TECH_SKILLS
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

object PEC_VACANCY_TESTS
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
      Some(PEC_RECRUITER_TESTS),
      Some(PEC_GROUP_A_TESTS),
      Some(PEC_GROUP_B_TESTS),
      Some(PEC_GROUP_C_TESTS)
    )

object PEC_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object PEC_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object PEC_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object PEC_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object PEC_ADDITIONAL_QUESTIONS
    extends AdditionalQuestionsDetails(
      true,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object PEC_CRITERIA
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

object PEC_MANAGEMENT
    extends ManagementDetails(
      true,
      true,
      "Other",
      true,
      assignTo = Option(s"$contactEmailVxConfig"),
      assignTo2 = Option(s"$contactEmailVxConfig"),
      true,
      "Business As Usual (BAU)",
      "Menu",
      true,
      true,
      linkToProject = Option(true),
      projectName = Option("Autotest - Project name"),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object PEC_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      true,
      s"$contactEmailVxConfig"
    )

object PEC_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Before pre employment checks",
      "Right to work and criminal record check",
      true,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      referenceChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      bankruptcyChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      crcChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nsvChecks = ListBuffer("Not Applicable"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      healthRefChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      overseasCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      pensionsCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      previousCsJobCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      internalFraudCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      selfEmploymentCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      true,
      true,
      true,
      "Autotest - Name of check",
      additionalCheck = ListBuffer("Not Applicable"),
      nenOnboarding = ListBuffer("External Candidates", "OGD Candidates", "NDPB Candidates"),
      s"$contactEmailVxConfig",
      pnOnboarding = ListBuffer("Internal Candidates"),
      s"$contactEmailVxConfig"
    )
