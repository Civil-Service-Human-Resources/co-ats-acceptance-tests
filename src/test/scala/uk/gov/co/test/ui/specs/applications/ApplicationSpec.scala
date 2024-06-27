package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.test.full._
import uk.gov.co.test.ui.data.v9.applicants.{MASTER_REGISTER_CANDIDATE, REGISTER_CANDIDATE}
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.completeAllInterviews
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.moveAndAcceptOffer
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.{RunInV9, RunInVX}

class ApplicationSpec extends BaseFeatureSpec {
  Feature("Candidate Completes Short & Long Form Application Process") {
    Scenario("VX: A Candidate Completes Short And Long Forms", RunInV9) {
      Given("candidate registers a new account")
      extractAllVacancyDetails("9831")
      fillNewCandidateDetails(REGISTER_CANDIDATE)

      When("candidate completes the short form")
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)

      Then("candidate is able to confirm successful completion of forms")
      fillLongFormDetails(MASTER_LONG_FORM_DATA)
    }

    Scenario("VX: Full Application Process", RunInVX) {
      Given("candidate registers for new job application")
      fillNewVacancyForm(FULL_VACANCY_DATA)
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      When("candidate completes the short & long forms")
      fillShortFormDetails(FULL_SHORT_FORM_DATA)
      fillLongFormDetails(FULL_LONG_FORM_DATA)

      And("the application is completed before pec form")
      PreSiftEvaluationFlow(FULL_APPLICATION_DATA)
      SiftEvaluationFlow(FULL_APPLICATION_DATA)
      completeAllInterviews(FULL_APPLICATION_DATA)
      moveAndAcceptOffer()

      Then("the candidate is able to fully complete the pec form")
      fillPecFormDetailsOnly(FULL_PEC_FORM_DATA)
    }
  }
}
