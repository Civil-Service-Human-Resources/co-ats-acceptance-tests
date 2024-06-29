package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.test.pec._
import uk.gov.co.test.ui.data.v9.applicants.{MASTER_REGISTER_CANDIDATE, REGISTER_CANDIDATE_PEC}
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.data.vx.vacancy.MASTER_VACANCY_DATA
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
import uk.gov.co.test.ui.tags.RunInVX

class PecVacancySpec extends BaseFeatureSpec {
  Feature("Candidate & Recruiter Complete The PEC Form") {
    Scenario("VX: A Candidate Completes The Candidate PEC Forms; Partial Application Process", RunInVX) {
      Given("candidate registers for new job application")
      fillNewVacancyForm(PEC_VACANCY_DATA)
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC)

      When("candidate completes the short & long forms")
      fillShortFormDetails(PEC_SHORT_FORM_DATA)
      fillLongFormDetails(PEC_LONG_FORM_DATA)

      And("the application is completed before pec form")
      PreSiftEvaluationFlow(PEC_APPLICATION_DATA)
      SiftEvaluationFlow(PEC_APPLICATION_DATA)
      completeAllInterviews(PEC_APPLICATION_DATA)
      moveAndAcceptOffer()

      Then("the candidate is able to fully complete the pec form")
      fillPecFormDetailsOnly(PEC_FORM_DATA)
    }

    Scenario("VX: A Candidate Completes The Candidate PEC Forms; Master Application Process", RunInVX) {
      Given("candidate registers for new job application")
      fillNewVacancyForm(MASTER_VACANCY_DATA)
//      extractAllVacancyDetails("10252")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      When("candidate completes the short & long forms")
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      fillLongFormDetails(MASTER_LONG_FORM_DATA)

      And("the application is completed before pec form")
      PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
      SiftEvaluationFlow(MASTER_APPLICATION_DATA)
      completeAllInterviews(MASTER_APPLICATION_DATA)
      moveAndAcceptOffer()

      Then("the candidate is able to fully complete the pec form")
      fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA)
    }
  }
}
