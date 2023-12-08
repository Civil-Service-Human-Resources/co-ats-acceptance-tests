package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.{REGISTER_CANDIDATE_ONE, REGISTER_CANDIDATE_PEC}
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.PEC_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx._
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.{fillShortFormDetails, fillShortFormDetailsOnly}
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmLongFormCompletion, confirmLongFormPECCompletion, confirmShortFormCompletion}
import uk.gov.co.test.ui.pages.vx.DashboardPage.activateAndPostVacancy
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.specs.TestData.pecTestData
import uk.gov.co.test.ui.tags.{RunInV9, RunInVX}

class pecVacancySpec extends BaseFeatureSpec {
  Feature("1: Candidate Offer Accepted - Initiate PEC Process") {
    Scenario("VX-1.1: An External/NDPD Candidate With A Provisional Offer, Wants To Progress Their Application", RunInVX) {
      Given("the candidate clicks on accept provisional offer")
      fillNewVacancyForm(PEC_VACANCY_DATA)
      activateAndPostVacancy()
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC)
      fillShortFormDetails(PEC_SHORT_FORM_DATA)
      confirmShortFormCompletion()
      fillLongFormDetails(MASTER_LONG_FORM_DATA)
      confirmLongFormCompletion()

      When("the candidate selects the option to begin pre-employment checks")

      Then("a pec form includes 'verifying your history' tab and and ability to add referee details")
    }

    Scenario("V9-A Candidate Completes Short And Long Forms", RunInV9) {
      Given("candidate registers and then completes the short form")
      pecTestData()
      fillNewCandidateDetails(REGISTER_CANDIDATE_ONE)

      When("candidate completes the long form")
      fillShortFormDetailsOnly(PEC_SHORT_FORM_DATA)
      confirmShortFormCompletion()
      fillLongFormDetails(MASTER_LONG_FORM_DATA)

      Then("candidate is taken to the next stage of application")
      confirmLongFormPECCompletion()
    }
  }
}
