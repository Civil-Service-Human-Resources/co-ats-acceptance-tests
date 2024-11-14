package uk.gov.co.test.ui.specs

import org.scalatest.tagobjects.Retryable
import uk.gov.co.test.ui.data.test.csjt.CSJT_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.fillFullApplicationDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.weAreCheckingYourApplicationState
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllApplyOnlyVacancyDetails

class CSJTSpec extends BaseFeatureSpec {
  Feature("Candidate Completes CS Numerical Tests Online") {
    Scenario("VX: Recruiter Creates A Master Vacancy With One CSNT Online") {
      Given("a recruiter creates & posts a new vacancy with csnt")
      fillNewVacancyForm(CSJT_VACANCY_DATA)
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      When("candidate registers for new job application with csjt required")
      fillFullApplicationDetails()

      Then("the candidate is able to complete the csjt")
      println("Done!")
    }

    Scenario("VX: All Forms; Master Application Process fot DAC TEST CANDIDATES") {
      Given("new vacancy is created and posted")
//      fillNewVacancyForm(MASTER_VACANCY_DATA)
      extractAllApplyOnlyVacancyDetails("10358")

      When("recruiter & new candidate complete the full application")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      fillFullApplicationDetails()

      Then("the candidate is notified of application checks")
      weAreCheckingYourApplicationState()
    }
  }
}
