package uk.gov.co.test.ui.specs.v9

import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_ONE
import uk.gov.co.test.ui.data.v9.longform.LONG_FORM_DATA_HMRC
import uk.gov.co.test.ui.data.v9.shortform.SHORT_FORM_DATA_HMRC
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetailsOnly
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmLongFormCompletion, confirmShortFormCompletion}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Candidate Login To Civil Service Jobs") {
    Scenario("V9 - A Candidate Completes Short And Long Forms", RunInV9) {
      Given("candidate registers and then completes the short form")
      fillNewCandidateDetails(REGISTER_CANDIDATE_ONE)
      fillShortFormDetailsOnly(SHORT_FORM_DATA_HMRC)
      confirmShortFormCompletion()

      When("candidate completes the long form")
      fillLongFormDetails(LONG_FORM_DATA_HMRC)

      Then("candidate is taken to the next stage of application")
      confirmLongFormCompletion()
    }
  }
}
