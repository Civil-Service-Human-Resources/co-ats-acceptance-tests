package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_HMRC
import uk.gov.co.test.ui.data.v9.longform.LONG_FORM_DATA_HMRC
import uk.gov.co.test.ui.data.v9.shortform.SHORT_FORM_DATA_HMRC
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vacancyId, vacancyName}
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Candidate Completes Short & Long Form Application Process") {
    Scenario("V9: A Candidate Completes Short And Long Forms", RunInV9) {
      Given("candidate registers a new account")
      extractAllVacancyDetails("9579")
      fillNewCandidateDetails(REGISTER_CANDIDATE_HMRC)

      When("candidate completes the short form")
      fillShortFormDetails(SHORT_FORM_DATA_HMRC, Some(vacancyName), Some(vacancyId))

      Then("candidate is able to confirm successful completion of forms")
      fillLongFormDetails(LONG_FORM_DATA_HMRC)
    }
  }
}
