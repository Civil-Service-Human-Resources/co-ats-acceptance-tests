package uk.gov.co.test.ui.data.test.idvt

import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{contactEmailVxConfig, contactNameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

import scala.collection.mutable.ListBuffer

object IDVT_VACANCY_DATA
    extends NewVacancyDetails(
      IDVT_BASIC_DETAILS,
      IDVT_JOB_INFORMATION,
      IDVT_APPROACH,
      IDVT_APPROVAL,
      IDVT_RESERVE_LIST,
      IDVT_LOCATIONS,
      IDVT_CONTRACT_DETAILS,
      IDVT_ADVERT,
      IDVT_CONTACT_DETAILS,
      IDVT_VETTING_DETAILS,
      IDVT_INTERVIEWS_DETAILS,
      IDVT_SUCCESS_PROFILES,
      IDVT_VACANCY_TESTS,
      IDVT_ADDITIONAL_QUESTIONS,
      IDVT_CRITERIA,
      IDVT_MANAGEMENT,
      IDVT_ONLINE_PEC_CHECK_FORMS,
      IDVT_PEC_CHECK_FORMS
    )

object IDVT_BASIC_DETAILS
    extends BasicDetails(
      "DO NOT USE- Automation Test Template",
      s"Automation: IDVT Regression-CO - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object IDVT_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Cabinet Office",
      "CO - Central Digital & Data Office",
      true,
      "Prawf awtomeiddio",
      "Autotest - Business area detail",
      "Autotest - Position identifier",
      typeOfRole = ListBuffer(
        "Accountancy"
      ),
      "Other",
      "1",
      false
    )
object IDVT_APPROACH
    extends ApproachDetails(
      "External",
      false,
      "Autotest - Eligibility statement",
      false,
      "Prawf awtomeiddio",
      "Autotest - standard statement"
    )

object IDVT_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)",
      "Test-T&Cs.pdf"
    )

object IDVT_RESERVE_LIST
    extends ReserveListDetails(
      false,
      "12 Months",
      false,
      "6 Months"
    )

object IDVT_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "M1 4RJ",
      "Manchester",
      "North West",
      "Germany",
      "Newcastle, Liverpool, Cardiff",
      false,
      false,
      "All communities",
      false,
      "3",
      otherLocations = ListBuffer("London", "Southampton", "Manchester")
    )

object IDVT_CONTRACT_DETAILS
    extends ContractDetails(
      List("Permanent"),
      "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
      true,
      "Prawf awtomeiddio",
      List("Full-time"),
      ListBuffer("Executive Officer"),
      "Grade 7",
      "GBP (£)",
      25000,
      95000,
      "Can agree on the higher bracket",
      true,
      18750
    )

object IDVT_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object IDVT_CONTACT_DETAILS
    extends ContactDetails(
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      "01000 000000",
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      s"$contactEmailVxConfig"
    )

object IDVT_VETTING_DETAILS
    extends VettingDetails(
      true,
      "None",
      "Disclosure barring service (DBS)",
      true,
      true,
      true,
      true,
      "None",
      false
    )

object IDVT_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "No interviews",
      "Interview",
      "Assessment",
      "Telephone",
      "Video",
      false
    )

object IDVT_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      false,
      false,
      false,
      false,
      false,
      Some(IDVT_ABILITIES),
      Some(IDVT_BEHAVIOURS),
      Some(IDVT_EXPERIENCES),
      Some(IDVT_STRENGTHS),
      Some(IDVT_TECH_SKILLS)
    )

object IDVT_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object IDVT_BEHAVIOURS
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

object IDVT_EXPERIENCES
    extends ExperienceDetails(
      false,
      "0 - 100",
      false,
      false,
      false,
      false,
      "0 - 7",
      500,
      false,
      "Autotest - Enter guidance text for the candidate",
      false,
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

object IDVT_STRENGTHS
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

object IDVT_TECH_SKILLS
    extends TechSkillsDetails(
      8,
      TechSkill(
        skillName = "Autotest - technical skills 1",
        skillDescription = Some("Autotest - technical skills 1 description"),
        applicationRequired = true,
        interviewRequired = true
      ),
      TechSkill(
        skillName = "Autotest - technical skills 2",
        skillDescription = Some("Autotest - technical skills 2 description"),
        applicationRequired = true,
        interviewRequired = true
      ),
      TechSkill(
        skillName = "Autotest - technical skills 3",
        skillDescription = Some("Autotest - technical skills 3 description"),
        applicationRequired = true,
        interviewRequired = true
      ),
      TechSkill(
        skillName = "Autotest - technical skills 4",
        skillDescription = Some("Autotest - technical skills 4 description"),
        applicationRequired = true,
        interviewRequired = true
      ),
      TechSkill(
        skillName = "Autotest - technical skills 5",
        skillDescription = Some("Autotest - technical skills 5 description"),
        applicationRequired = true,
        interviewRequired = true
      ),
      TechSkill(
        skillName = "Autotest - technical skills 6",
        skillDescription = Some("Autotest - technical skills 6 description"),
        applicationRequired = true,
        interviewRequired = true
      ),
      TechSkill(
        skillName = "Autotest - technical skills 7",
        skillDescription = Some("Autotest - technical skills 7 description"),
        applicationRequired = true,
        interviewRequired = true
      ),
      TechSkill(
        skillName = "Autotest - technical skills 8",
        skillDescription = Some("Autotest - technical skills 8 description"),
        applicationRequired = true,
        interviewRequired = true
      )
    )

object IDVT_VACANCY_TESTS
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
      Some(IDVT_RECRUITER_TESTS),
      Some(IDVT_GROUP_A_TESTS),
      Some(IDVT_GROUP_B_TESTS),
      Some(IDVT_GROUP_C_TESTS)
    )

object IDVT_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object IDVT_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object IDVT_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object IDVT_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object IDVT_ADDITIONAL_QUESTIONS
    extends AdditionalQuestionsDetails(
      anyAdditionalQuestions = Some(false),
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object IDVT_CRITERIA
    extends CriteriaDetails(
      campaignID = None,
      probationIncomplete = true,
      promotionApply = true,
      misconductLive = true,
      performanceReview = true,
      attendancePoor = true,
      nationalityRequirements = true,
      rightToRemainUK = true,
      licencesNotHeld = false,
      membershipsNotHeld = false,
      languagesSkillsNotHeld = false,
      qualificationsHeld = false,
      preSiftRequired = false,
      uploadAttachment = false,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object IDVT_MANAGEMENT
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
      true,
      true,
      linkToProject = Option(false),
      projectName = Option("Autotest - Project name"),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object IDVT_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      false,
      true,
      s"$contactEmailVxConfig"
    )

object IDVT_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Before pre employment checks",
      "Right to work only",
      true,
      "Autotest - Passport",
      false,
      generalInfo = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      referenceChecks = ListBuffer("Not Applicable"),
      workplaceMisconductCheck =
        ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      bankruptcyChecks = ListBuffer("Not Applicable"),
      crcChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nsvChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = ListBuffer("Not Applicable"),
      healthRefChecks = ListBuffer("Not Applicable"),
      "Show recruiter and candidate forms",
      overseasCheck = ListBuffer("Not Applicable"),
      pensionsCheck = ListBuffer("Not Applicable"),
      previousCsJobCheck = ListBuffer("Not Applicable"),
      internalFraudCheck = ListBuffer("Not Applicable"),
      selfEmploymentCheck = ListBuffer("Not Applicable"),
      true,
      false,
      false,
      "Autotest - Name of check",
      additionalCheck = ListBuffer("Not Applicable"),
      nenOnboarding = ListBuffer("External Candidates", "OGD Candidates", "NDPB Candidates"),
      s"$contactEmailVxConfig",
      pnOnboarding = ListBuffer("Internal Candidates"),
      s"$contactEmailVxConfig"
    )
