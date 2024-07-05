package uk.gov.co.test.ui.data.test.nameblind

import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{contactEmailVxConfig, contactNameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

import scala.collection.mutable.ListBuffer

object NON_NAME_BLIND_VACANCY_DATA
    extends NewVacancyDetails(
      NON_NAME_BLIND_BASIC_DETAILS,
      NON_NAME_BLIND_JOB_INFORMATION,
      NON_NAME_BLIND_APPROACH,
      NON_NAME_BLIND_APPROVAL,
      NON_NAME_BLIND_RESERVE_LIST,
      NON_NAME_BLIND_LOCATIONS,
      NON_NAME_BLIND_CONTRACT_DETAILS,
      NON_NAME_BLIND_ADVERT,
      NON_NAME_BLIND_CONTACT_DETAILS,
      NON_NAME_BLIND_VETTING_DETAILS,
      NON_NAME_BLIND_INTERVIEWS_DETAILS,
      NON_NAME_BLIND_SUCCESS_PROFILES,
      NON_NAME_BLIND_VACANCY_TESTS,
      NON_NAME_BLIND_ADDITIONAL_QUESTIONS,
      NON_NAME_BLIND_CRITERIA,
      NON_NAME_BLIND_MANAGEMENT,
      NON_NAME_BLIND_ONLINE_NON_NAME_BLIND_CHECK_FORMS,
      NON_NAME_BLIND_NON_NAME_BLIND_CHECK_FORMS
    )

object NON_NAME_BLIND_BASIC_DETAILS
    extends BasicDetails(
      "Government Commercial Function - Apply Online",
      s"Automation: GCF-Non Name-Blind - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object NON_NAME_BLIND_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Government Commercial Function",
      "GCF - Cabinet Office",
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
object NON_NAME_BLIND_APPROACH
    extends ApproachDetails(
      "External",
      true,
      "Autotest - Eligibility statement",
      true,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )

object NON_NAME_BLIND_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)",
      "Test-T&Cs.pdf"
    )

object NON_NAME_BLIND_RESERVE_LIST
    extends ReserveListDetails(
      true,
      "12 Months",
      false,
      "6 Months"
    )

object NON_NAME_BLIND_LOCATIONS
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

object NON_NAME_BLIND_CONTRACT_DETAILS
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

object NON_NAME_BLIND_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object NON_NAME_BLIND_CONTACT_DETAILS
    extends ContactDetails(
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      "01000 000000",
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      s"$contactEmailVxConfig"
    )

object NON_NAME_BLIND_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Enhanced",
      "Disclosure barring service (DBS)",
      true,
      true,
      true,
      true,
      "Security check",
      true
    )

object NON_NAME_BLIND_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "2",
      "Interview",
      "Assessment",
      "Telephone",
      "Video",
      false
    )

object NON_NAME_BLIND_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      true,
      true,
      true,
      true,
      true,
      Some(NON_NAME_BLIND_ABILITIES),
      Some(NON_NAME_BLIND_BEHAVIOURS),
      Some(NON_NAME_BLIND_EXPERIENCES),
      Some(NON_NAME_BLIND_STRENGTHS),
      Some(NON_NAME_BLIND_TECH_SKILLS)
    )

object NON_NAME_BLIND_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object NON_NAME_BLIND_BEHAVIOURS
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

object NON_NAME_BLIND_EXPERIENCES
    extends ExperienceDetails(
      true,
      true,
      "0 - 100",
      true,
      true,
      true,
      true,
      "0 - 7",
      750,
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

object NON_NAME_BLIND_STRENGTHS
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

object NON_NAME_BLIND_TECH_SKILLS
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

object NON_NAME_BLIND_VACANCY_TESTS
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
      Some(NON_NAME_BLIND_RECRUITER_TESTS),
      Some(NON_NAME_BLIND_GROUP_A_TESTS),
      Some(NON_NAME_BLIND_GROUP_B_TESTS),
      Some(NON_NAME_BLIND_GROUP_C_TESTS)
    )

object NON_NAME_BLIND_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object NON_NAME_BLIND_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object NON_NAME_BLIND_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object NON_NAME_BLIND_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object NON_NAME_BLIND_ADDITIONAL_QUESTIONS
    extends AdditionalQuestionsDetails(
      anyAdditionalQuestions = Some(true),
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object NON_NAME_BLIND_CRITERIA
    extends CriteriaDetails(
      campaignID = None,
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

object NON_NAME_BLIND_MANAGEMENT
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

object NON_NAME_BLIND_ONLINE_NON_NAME_BLIND_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      true,
      s"$contactEmailVxConfig"
    )

object NON_NAME_BLIND_NON_NAME_BLIND_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Before pre employment checks",
      "Right to work and criminal record check",
      true,
      "Autotest - Passport",
      false,
      generalInfo = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      referenceChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      bankruptcyChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      crcChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nsvChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      healthRefChecks = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      overseasCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      pensionsCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      previousCsJobCheck =
        ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      internalFraudCheck =
        ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      selfEmploymentCheck =
        ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      true,
      false,
      true,
      "Autotest - name of additional check",
      additionalCheck = ListBuffer("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nenOnboarding = ListBuffer("External Candidates", "OGD Candidates", "NDPB Candidates"),
      s"$contactEmailVxConfig",
      pnOnboarding = ListBuffer("Internal Candidates"),
      s"$contactEmailVxConfig"
    )
