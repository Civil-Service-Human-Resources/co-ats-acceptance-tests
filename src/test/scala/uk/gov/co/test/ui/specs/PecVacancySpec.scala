package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.test.pec._
import uk.gov.co.test.ui.data.v9.applicants.REGISTER_CANDIDATE_PEC
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
import uk.gov.co.test.ui.tags.RunInVX

class PecVacancySpec extends BaseFeatureSpec {
  Feature("Candidate & Recruiter Complete The PEC Form") {
    Scenario("VX: A Candidate Completes The PEC Form; Full Application Process", RunInVX) {
      Given("candidate registers for new job application")
      fillNewVacancyForm(PEC_VACANCY_DATA)
      extractAllVacancyDetails("10205")
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
  }
}
