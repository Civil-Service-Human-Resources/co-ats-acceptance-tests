package uk.gov.co.test.ui.data.test.ogd

import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{contactEmailVxConfig, contactNameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

import scala.collection.mutable.ListBuffer

object OGD_VACANCY_DATA
    extends NewVacancyDetails(
      OGD_BASIC_DETAILS,
      OGD_JOB_INFORMATION,
      OGD_APPROACH,
      OGD_APPROVAL,
      OGD_RESERVE_LIST,
      OGD_LOCATIONS,
      OGD_CONTRACT_DETAILS,
      OGD_ADVERT,
      OGD_CONTACT_DETAILS,
      OGD_VETTING_DETAILS,
      OGD_INTERVIEWS_DETAILS,
      OGD_SUCCESS_PROFILES,
      OGD_VACANCY_TESTS,
      OGD_ADDITIONAL_QUESTIONS,
      OGD_CRITERIA,
      OGD_MANAGEMENT,
      OGD_ONLINE_OGD_CHECK_FORMS,
      OGD_OGD_CHECK_FORMS
    )

object OGD_BASIC_DETAILS
    extends BasicDetails(
      "DO NOT USE- Automation Test Template",
      s"Automation: CRX827 - CO-OGD - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object OGD_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Cabinet Office",
      "CO - Central Digital & Data Office",
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
      "3",
      true
    )
object OGD_APPROACH
    extends ApproachDetails(
      "External",
      true,
      "Autotest - Eligibility statement",
      true,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )

object OGD_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)",
      "Test-T&Cs.pdf"
    )

object OGD_RESERVE_LIST
    extends ReserveListDetails(
      false,
      "12 Months",
      false,
      "6 Months"
    )

object OGD_LOCATIONS
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

object OGD_CONTRACT_DETAILS
    extends ContractDetails(
      List("Permanent"),
      "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
      true,
      "Prawf awtomeiddio",
      List("Full-time"),
      ListBuffer("Executive Officer"),
      "Grade 6",
      "GBP (£)",
      25000,
      95000,
      "Can agree on the higher bracket",
      false,
      18750
    )

object OGD_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object OGD_CONTACT_DETAILS
    extends ContactDetails(
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      "01000 000000",
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      s"$contactEmailVxConfig"
    )

object OGD_VETTING_DETAILS
    extends VettingDetails(
      false,
      "None",
      "Disclosure barring service (DBS)",
      true,
      true,
      true,
      true,
      "None",
      false
    )

object OGD_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "No interviews",
      "Interview",
      "Assessment",
      "Telephone",
      "Video",
      false
    )

object OGD_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      false,
      false,
      false,
      false,
      false,
      Some(OGD_ABILITIES),
      Some(OGD_BEHAVIOURS),
      Some(OGD_EXPERIENCES),
      Some(OGD_STRENGTHS),
      Some(OGD_TECH_SKILLS)
    )

object OGD_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object OGD_BEHAVIOURS
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

object OGD_EXPERIENCES
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

object OGD_STRENGTHS
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

object OGD_TECH_SKILLS
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

object OGD_VACANCY_TESTS
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
      Some(OGD_RECRUITER_TESTS),
      Some(OGD_GROUP_A_TESTS),
      Some(OGD_GROUP_B_TESTS),
      Some(OGD_GROUP_C_TESTS)
    )

object OGD_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object OGD_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object OGD_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object OGD_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object OGD_ADDITIONAL_QUESTIONS
    extends AdditionalQuestionsDetails(
      anyAdditionalQuestions = Some(false),
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object OGD_CRITERIA
    extends CriteriaDetails(
      campaignID = Some("Autotest - If this vacancy is linked to a campaign, enter the campaign ID (optional)"),
      probationIncomplete = false,
      promotionApply = false,
      misconductLive = false,
      performanceReview = false,
      attendancePoor = false,
      nationalityRequirements = false,
      rightToRemainUK = false,
      licencesNotHeld = false,
      membershipsNotHeld = false,
      languagesSkillsNotHeld = false,
      qualificationsHeld = false,
      preSiftRequired = false,
      uploadAttachment = false,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object OGD_MANAGEMENT
    extends ManagementDetails(
      false,
      false,
      "Other",
      false,
      assignTo = Option(s"$contactEmailVxConfig"),
      assignTo2 = Option(s"$contactEmailVxConfig"),
      true,
      "Business As Usual (BAU)",
      "BAU",
      false,
      false,
      linkToProject = Option(false),
      projectName = Option("Autotest - Project name"),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object OGD_ONLINE_OGD_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      false,
      s"$contactEmailVxConfig"
    )

object OGD_OGD_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = ListBuffer("Not Applicable"),
      "Before pre employment checks",
      "No digital checks",
      false,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo = ListBuffer("External Candidates"),
      referenceChecks = ListBuffer("Not Applicable"),
      bankruptcyChecks = ListBuffer("Not Applicable"),
      crcChecks = ListBuffer("External Candidates", "OGD Candidates"),
      nsvChecks = ListBuffer("External Candidates", "OGD Candidates"),
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
      true,
      false,
      "Autotest - Name of check",
      additionalCheck = ListBuffer("Not Applicable"),
      nenOnboarding = ListBuffer("Not Applicable"),
      s"$contactEmailVxConfig",
      pnOnboarding = ListBuffer("Not Applicable"),
      s"$contactEmailVxConfig"
    )
