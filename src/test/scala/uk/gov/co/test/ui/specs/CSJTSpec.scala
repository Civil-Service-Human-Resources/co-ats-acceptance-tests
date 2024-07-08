package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.test.csjt.CSJT_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.data.vx.vacancy.MASTER_VACANCY_DATA
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.fillFullApplicationDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.weAreCheckingYourApplicationState
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class CSJTSpec extends BaseFeatureSpec {
  Feature("Candidate Completes CS Numerical Tests Online") {
    Scenario("VX: Recruiter Creates A Master Vacancy With One CSNT Online", RunInVX) {
      Given("a recruiter creates & posts a new vacancy with csnt")
      fillNewVacancyForm(CSJT_VACANCY_DATA)
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      When("candidate registers for new job application with csjt required")
      fillFullApplicationDetails(
        MASTER_SHORT_FORM_DATA,
        MASTER_LONG_FORM_DATA,
        MASTER_APPLICATION_DATA,
        MASTER_PEC_FORM_DATA
      )

      Then("the candidate is able to complete the csjt")
      println("Done!")
    }

    Scenario("VX: All Forms; Master Application Process fot DAC TEST CANDIDATES", RunInVX) {
      Given("new vacancy is created and posted")
//      fillNewVacancyForm(MASTER_VACANCY_DATA)
      extractAllVacancyDetails("10348")

      When("recruiter & new candidate complete the full application")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      fillFullApplicationDetails(
        MASTER_SHORT_FORM_DATA,
        MASTER_LONG_FORM_DATA,
        MASTER_APPLICATION_DATA,
        MASTER_PEC_FORM_DATA
      )

      Then("the candidate is notified of application checks")
      weAreCheckingYourApplicationState()
    }
  }
}
