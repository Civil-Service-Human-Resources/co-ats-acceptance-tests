package uk.gov.co.test.ui.data.vx

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
      "Crown Prosecution Service - Apply online",
      s"AUTOA8PEC - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object PEC_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Crown Prosecution Service",
      "Other",
      true,
      "Prawf awtomeiddio",
      "",
      typeOfRole = List(
        "Accountancy"
      ),
      "Other",
      "1"
    )
object PEC_APPROACH
    extends ApproachDetails(
      "External",
      false,
      "Autotest - Eligibility statement",
      false,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )
object PEC_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "",
      "Test-T&Cs.pdf"
    )

object PEC_RESERVE_LIST
    extends ReserveListDetails(
      false,
      "12 Months",
      false
    )

object PEC_LOCATIONS
    extends LocationsDetails(
      "Towns",
      "M1 4RJ",
      "Cardiff",
      "North West",
      "Germany",
      "",
      false,
      true,
      "All communities",
      false,
      "3",
      otherLocations = ListBuffer("London", "Southampton", "Manchester")
    )

object PEC_CONTRACT_DETAILS
    extends ContractDetails(
      List("Permanent"),
      "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
      true,
      "Prawf awtomeiddio",
      List("Full-time"),
      "Administrative Officer",
      "",
      "GBP (£)",
      25000,
      10000,
      "",
      false,
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
      "Standard",
      "Disclosure barring service (DBS)",
      "None",
      false
    )

object PEC_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "1",
      "Video",
      "Assessment",
      "Telephone",
      "Interview",
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

object PEC_EXPERIENCES
    extends ExperienceDetails(
      true,
      "0 - 7",
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

object PEC_STRENGTHS
    extends StrengthsDetails(
      8,
      "Adaptable",
      "Analytical",
      "Authentic",
      "Catalyst",
      "Challenger",
      "Change Agent",
      "Confident",
      "Focussed"
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
          techApplication = false
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 3",
          description = "Autotest - technical skills 3 description",
          techInterview = true,
          techApplication = false
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 4",
          description = "Autotest - technical skills 4 description",
          techInterview = true,
          techApplication = false
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 5",
          description = "Autotest - technical skills 5 description",
          techInterview = true,
          techApplication = false
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 6",
          description = "Autotest - technical skills 6 description",
          techInterview = true,
          techApplication = false
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 7",
          description = "Autotest - technical skills 7 description",
          techInterview = true,
          techApplication = false
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 8",
          description = "Autotest - technical skills 8 description",
          techInterview = true,
          techApplication = false
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
      false,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object PEC_CRITERIA
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

object PEC_MANAGEMENT
    extends ManagementDetails(
      true,
      true,
      "Other",
      false,
      assignTo = Option(s"$contactEmailVxConfig"),
      assignTo2 = Option(s"$contactEmailVxConfig"),
      false,
      "Business As Usual (BAU)",
      "Menu",
      true,
      true,
      linkToProject = Option(false),
      projectName = Option(""),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object PEC_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      false,
      s"$contactEmailVxConfig"
    )

object PEC_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck =
        List("Not Applicable", "Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
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
      false,
      true,
      "Autotest - Name of check",
      additionalCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nenOnboarding = List("Not Applicable"),
      s"$contactEmailVxConfig",
      pnOnboarding = List("Not Applicable"),
      s"$contactEmailVxConfig"
    )
