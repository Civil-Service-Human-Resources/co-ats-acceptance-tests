package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.TestData.setPecTestData
import uk.gov.co.test.ui.data.v9.applicants.{MASTER_REGISTER_CANDIDATE, REGISTER_CANDIDATE_PEC}
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vacancyId
import uk.gov.co.test.ui.data.vx._
import uk.gov.co.test.ui.flows.e2e.FullPecFlow.completeFullPecFlow
import uk.gov.co.test.ui.flows.e2e.PecFlow.completePecFlow
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class CreateVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A Master Vacancy; Candidate Completes Short & Long Forms") {
    Scenario("VX: Recruiter Creates A Master Vacancy; Candidate Completes A Master Application Process", RunInVX) {
      Given("a recruiter creates & posts a new vacancy")
      fillNewVacancyForm(MASTER_VACANCY_DATA)

      When("candidate registers for new job application")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      Then("the candidate is able to confirm short & long forms are completed")
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      fillLongFormDetails(MASTER_LONG_FORM_DATA)
    }

    Scenario("V9: A Recruiter Creates A Insolvency Apply Only Vacancy; Limited Application Process", RunInVX) {
      Given("candidate registers for new job application")
      setPecTestData()
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC)

      When("candidate completes the gors short, long & pec forms")
      completePecFlow()

      Then("the candidate is able to confirm insolvency short & long forms are completed")
      println("WIP...")
    }

    Scenario("VX: A Candidate Applies And Completes The PEC Form; Full Application Process", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails(vacancyId)
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC)

      When("candidate completes the gors short, long & pec forms")
      completeFullPecFlow()

      Then("the candidate is able to confirm insolvency short & long forms are completed")
      println("WIP...")
    }
  }
}
