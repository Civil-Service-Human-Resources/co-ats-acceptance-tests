package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig}
import uk.gov.co.test.ui.pages.vx.createvacancypage._

case class DefraApplyOnlyDetails(
  basicDetails: BasicDetails,
  jobInfoDetails: JobInfoDetails,
  approachDetails: ApproachDetails,
  approvalDetails: ApprovalDetails,
  reserveListDetails: ReserveListDetails,
  locationsDetails: LocationsDetails,
  contractDetails: ContractDetails,
  advertDetails: AdvertDetails,
  contactDetails: ContactDetails,
  vettingDetails: VettingDetails,
  interviewsDetails: InterviewsDetails,
  successProfilesDetails: SuccessProfilesDetails,
  vacancyTestsDetails: VacancyTestsDetails,
  moreQuestionsDetails: MoreQuestionsDetails
)
object DEFRA_APPLY_ONLY_DATA
    extends DefraApplyOnlyDetails(
      VACANCY_BASIC_DETAILS,
      VACANCY_JOB_INFORMATION,
      VACANCY_APPROACH,
      VACANCY_APPROVAL,
      VACANCY_RESERVE_LIST,
      VACANCY_LOCATIONS,
      VACANCY_CONTRACT_DETAILS,
      VACANCY_ADVERT,
      VACANCY_CONTACT_DETAILS,
      VACANCY_VETTING_DETAILS,
      VACANCY_INTERVIEWS_DETAILS,
      VACANCY_SUCCESS_PROFILES,
      VACANCY_HOLDER_TESTS,
      VACANCY_ADDITIONAL_QUESTIONS
    )

object VACANCY_BASIC_DETAILS
    extends BasicDetails(
      "Department for Environment, Food and Rural Affairs - Apply online",
      "GCQA OGD DEFRA (CORE)",
      32
    )
object VACANCY_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "Department for Environment, Food and Rural Affairs - Apply online",
      "DEFRA - COO - Commercial",
      "Autotest - Business area detail",
      "Analytical",
      "Other",
      "1"
    )
object VACANCY_APPROACH
    extends ApproachDetails(
      "Internal",
      true,
      "Autotest - Eligibility statement"
    )
object VACANCY_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre"
    )

object VACANCY_RESERVE_LIST
    extends ReserveListDetails(
      true,
      "6 Months"
    )

object VACANCY_LOCATIONS
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
      otherCityOrTown = Vector("London", "Southampton", "Leicester")
    )

object VACANCY_CONTRACT_DETAILS
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

object VACANCY_ADVERT
    extends AdvertDetails(
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details"
    )

object VACANCY_CONTACT_DETAILS
    extends ContactDetails(
      s"$nameVxConfig",
      s"$emailVxConfig",
      "01000 000000",
      s"$nameVxConfig",
      s"$emailVxConfig",
      s"$emailVxConfig"
    )

object VACANCY_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Basic",
      "Disclosure barring service (DBS)",
      "Security check",
      true
    )

object VACANCY_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "4",
      "Telephone",
      "Assessment",
      "Video",
      "Interview",
      true
    )

object VACANCY_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      true,
      true,
      true,
      true,
      true,
      Some(VACANCY_ABILITIES),
      Some(VACANCY_BEHAVIOURS),
      Some(VACANCY_EXPERIENCES),
      Some(VACANCY_STRENGTHS),
      Some(VACANCY_TECH_SKILLS)
    )

object VACANCY_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object VACANCY_BEHAVIOURS
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

object VACANCY_EXPERIENCES
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

object VACANCY_STRENGTHS
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

object VACANCY_TECH_SKILLS
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

object VACANCY_HOLDER_TESTS
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
      Some(VACANCY_RECRUITER_TESTS),
      Some(VACANCY_GROUP_A_TESTS),
      Some(VACANCY_GROUP_B_TESTS),
      Some(VACANCY_GROUP_C_TESTS)
    )

object VACANCY_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "Before the tests",
      "Auto-progress after each test",
      true,
      3,
      true,
      "Autotest - Online test instructions"
    )

object VACANCY_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test"
    )

object VACANCY_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test"
    )

object VACANCY_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test"
    )

object VACANCY_ADDITIONAL_QUESTIONS
    extends MoreQuestionsDetails(
      true,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )
