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
  successProfilesDetails: SuccessProfilesDetails
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
      VACANCY_SUCCESS_PROFILES
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
      Vector("London", "Southampton", "Leicester")
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
      Some(VACANCY_EXPERIENCES)
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
      Some(MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific memberships requirements")),
      Some(MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific language requirements")),
      Some(MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific qualification requirements"))
    )
