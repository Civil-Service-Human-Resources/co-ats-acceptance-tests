package uk.gov.co.test.ui.data.vx

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{emailVxConfig, nameVxConfig}
import uk.gov.co.test.ui.pages.vx.MasterVacancyDetails

case class MasterVacancy(masterVacancy: MasterVacancy)

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
      Vector("London", "Southampton"), //otherCityOrTown
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
      true,
      true,
      true,
      true,
      true,
      true,
      assessAbilities = """The following online tests can be used to assess abilities:
          |Civil Service Numerical Test
          |Civil Service Verbal Test""".stripMargin,
      assessBehaviours = """The following online tests can be used to assess behaviours:
          |Civil Service Judgement Test
          |Civil Service Management Judgement Test""".stripMargin,
      8,
      "Changing and Improving",
      true,
      true,
      "Communicating and Influencing",
      true,
      true,
      "Delivering at Pace",
      true,
      true,
      "Developing Self and Others",
      true,
      true,
      "Leadership",
      true,
      true,
      "Making Effective Decisions",
      true,
      true,
      "Managing a Quality Service",
      true,
      true,
      "Working Together",
      true,
      true,
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
      true,
      "Autotest - Specific licence requirements",
      true,
      "Autotest - Specific memberships requirements",
      true,
      "Autotest - Specific language requirements",
      true,
      "Autotest - Specific qualification requirements",
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
