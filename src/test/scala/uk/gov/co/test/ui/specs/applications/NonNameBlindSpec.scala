package uk.gov.co.test.ui.specs.applications

import org.scalatest.tagobjects.Retryable
import uk.gov.co.test.ui.data.test.nameblind.NON_NAME_BLIND_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_NAME_BLIND
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.fillFullApplicationDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.specs.BaseFeatureSpec

class NonNameBlindSpec extends BaseFeatureSpec {
  Feature("Recruiter & Candidate Complete Full Application Process For Non Name-Blind Vacancy") {
    Scenario("VX: All Forms; Master Application Process") {
      Given("new non name-blind vacancy is created and posted")
      fillNewVacancyForm(NON_NAME_BLIND_VACANCY_DATA)
//      extractAllVacancyDetails("10648")

      When("new candidate registers for new application")
      fillNewCandidateDetails(REGISTER_CANDIDATE_NAME_BLIND)

      Then("recruiter & new candidate complete the full application")
      fillFullApplicationDetails()
    }
  }
}
