package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.MasterVacancyDetails.vacancyId
import uk.gov.co.test.ui.data.v9.applicants.MASTER_REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Candidate Completes Short & Long Form Application Process") {
    Scenario("VX: A Candidate Completes Short And Long Forms", RunInV9) {
      Given("candidate registers a new account")
      vacancyId = "9831"
      extractAllVacancyDetails(vacancyId)
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      When("candidate completes the short form")
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)

      Then("candidate is able to confirm successful completion of forms")
      fillLongFormDetails(MASTER_LONG_FORM_DATA)
    }
  }
}
