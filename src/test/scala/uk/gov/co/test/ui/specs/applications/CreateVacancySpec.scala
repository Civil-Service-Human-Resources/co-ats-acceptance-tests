package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.v9.applicants.MASTER_REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.vacancy.MASTER_VACANCY_DATA
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.specs.BaseFeatureSpec
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
  }
}
