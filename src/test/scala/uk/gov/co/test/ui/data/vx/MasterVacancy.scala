package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig}
import uk.gov.co.test.ui.pages.vx.MasterVacancyDetails

case class MasterVacancy(masterVacancy: MasterVacancy)
//case class AbilitiesDetails(abilitiesDetails: AbilitiesDetails)
//case class BehavioursDetails(behavioursDetails: BehavioursDetails)
//case class Behaviours(behaviours: Behaviours)

object MASTER_VACANCY_DATA
    extends MasterVacancyDetails(
      "Department for Environment, Food and Rural Affairs - Apply online",
      "GCQA OGD DEFRA (CORE)",
      32,
      true,
      "Department for Environment, Food and Rural Affairs - Apply online",
      "DEFRA - COO - Commercial",
      "Autotest - Business area detail",
      "Analytical",
      "Other",
      "1",
      "Internal",
      true,
      "Autotest - Eligibility statement",
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre",
      true,
      "6 Months",
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
      Vector("London", "Southampton", "Leicester"), //otherCityOrTown
      "Permanent",
      "Full-time",
      "Senior Executive Officer",
      "Grade 7",
      "GBP (£)",
      75000,
      95000,
      "Can agree on the higher bracket",
      true,
      18750,
      "Autotest - Job summary",
      "Autotest - Job description",
      "Autotest - Person specification",
      "• Learning and development tailored to your role\n• An environment with flexible working options\n• A culture encouraging inclusion and diversity\n• A Civil Service pension",
      "Autotest - Selection process details",
      s"$nameVxConfig",
      s"$emailVxConfig",
      "01000 000000",
      s"$nameVxConfig",
      s"$emailVxConfig",
      s"$emailVxConfig",
      true,
      "Basic",
      "Disclosure barring service (DBS)",
      "Security check",
      true,
      "4",
      "Telephone",
      "Assessment",
      "Video",
      "Interview",
      true
//      true,
//      true,
//      true,
//      true,
//      true,
//      Some(AbilitiesDetails(
//        """The following online tests can be used to assess abilities:
//          |Civil Service Numerical Test
//          |Civil Service Verbal Test""".stripMargin)),
//      Some(
//        BehavioursDetails(
//          """The following online tests can be used to assess behaviours:
//            |Civil Service Judgement Test
//            |Civil Service Management Judgement Test""".stripMargin,
//          8,
//          Some(Behaviours("Changing and Improving", stageApplication = true, stageInterview = true)),
//          Some(Behaviours("Communicating and Influencing", stageApplication = true, stageInterview = true)),
//          Some(Behaviours("Delivering at Pace", stageApplication = true, stageInterview = true)),
//          Some(Behaviours("Developing Self and Others", stageApplication = true, stageInterview = true)),
//          Some(Behaviours("Leadership", stageApplication = true, stageInterview = true)),
//          Some(Behaviours("Making Effective Decisions", stageApplication = true, stageInterview = true)),
//          Some(Behaviours("Managing a Quality Service", stageApplication = true, stageInterview = true)),
//          Some(Behaviours("Working Together", stageApplication = true, stageInterview = true))
//        )
//      ),
//      Some(VACANCY_EXPERIENCES)
    )

//object VACANCY_EXPERIENCES
//  extends ExperienceDetails(
//    true,
//    "0 - 100",
//    true,
//    true,
//    true,
//    true,
//    "0 - 7",
//    250,
//    true,
//    "Autotest - Enter guidance text for the candidate",
//    true,
//    "Autotest - Specific past experience/skills",
//    Some(MandatoryRequirements(requirements = true, "Autotest - Specific licence requirements")),
//    Some(MandatoryRequirements(requirements = true, "Autotest - Specific memberships requirements")),
//    Some(MandatoryRequirements(requirements = true, "Autotest - Specific language requirements")),
//    Some(MandatoryRequirements(requirements = true, "Autotest - Specific qualification requirements"))
//  )
