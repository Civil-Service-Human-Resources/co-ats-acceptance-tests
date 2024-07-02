package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAnyOnlineTests, vacancyId}
import uk.gov.co.test.ui.data.test.csjt.CSJT_VACANCY_DATA
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class CSJTSpec extends BaseFeatureSpec {
  Feature("Candidate Completes CS Judgement Tests Online") {
    Scenario("VX: Recruiter Creates A Master Vacancy With One CSJT Online", RunInVX) {
      Given("a recruiter creates & posts a new vacancy with csjt")
      fillNewVacancyForm(CSJT_VACANCY_DATA)

      When("candidate registers for new job application with csjt required")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      fillLongFormDetails(MASTER_LONG_FORM_DATA)

      Then("the candidate is able to complete the csjt")
      println("Done!")
    }

    Scenario("VX: Candidate Applies For Vacancy With One CSJT Online", RunInVX) {
      Given("vacancy details are extracted and values set")
      vacancyId = "9604"
      vXAnyOnlineTests = true
      extractAllVacancyDetails(vacancyId)

      When("candidate registers for new job application with csjt required")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      fillLongFormDetails(MASTER_LONG_FORM_DATA)

      Then("the candidate is able to complete the csjt")
    }
  }
}
