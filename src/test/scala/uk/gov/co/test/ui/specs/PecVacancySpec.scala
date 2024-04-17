package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.TestData.setPecTestData
import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_PEC
import uk.gov.co.test.ui.flows.e2e.FullPecFlow.completeFullPecFlow
import uk.gov.co.test.ui.flows.e2e.PecFlow.completePecFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class PecVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A PEC Master Vacancy; Candidate Completes Short & Long Forms") {
    Scenario("V9: A Recruiter Creates An Insolvency Apply Only Vacancy; Limited Application Process", RunInVX) {
      Given("candidate registers for new job application")
      setPecTestData()
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC)

      When("candidate completes the gors short, long & pec forms")
      completePecFlow()

      Then("the candidate is able to confirm insolvency short & long forms are completed")
      println("WIP...")
    }

    Scenario("VX: A Candidate Applies For The PEC Form; Full Application Process", RunInVX) {
      Given("candidate registers for new job application")
      extractAllVacancyDetails("9707")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC)

      When("candidate completes the gors short, long & pec forms")
      completeFullPecFlow()

      Then("the candidate is able to confirm insolvency short & long forms are completed")
      println("WIP...")
    }
  }
}
