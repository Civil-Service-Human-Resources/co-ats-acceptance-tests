package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.{MASTER_REGISTER_CANDIDATE, REGISTER_CANDIDATE_INSOLVENCY}
import uk.gov.co.test.ui.data.v9.longform.{LONG_FORM_DATA_INSOLVENCY, MASTER_LONG_FORM_DATA}
import uk.gov.co.test.ui.data.v9.pecform.MASTER_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.{MASTER_SHORT_FORM_DATA, SHORT_FORM_DATA_INSOLVENCY}
import uk.gov.co.test.ui.data.vx._
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{candidateAcceptsOffer, confirmLongFormCompletion, confirmOfferAccepted, confirmShortFormCompletion, confirmShortFormCompletionNoLongForm}
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.extractApplicationId
import uk.gov.co.test.ui.pages.v9.ProvisionalOfferPage.offerDecisionFlow
import uk.gov.co.test.ui.pages.v9.shortform.EligibilityDetails
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{navigateToApplicationSummary, progressApplicationToOffer}
import uk.gov.co.test.ui.pages.vx.DashboardPage.{activateAndPostVacancy, searchForActiveVacancy, switchToCandidateApplication}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.specs.TestData.pec2TestData
import uk.gov.co.test.ui.tags.RunInVX

class createVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A Master Vacancy; Candidate Completes Short & Long Forms") {
    Scenario("VX: Recruiter Creates A Master Vacancy; Candidate Completes A Master Application Process", RunInVX) {
      Given("a recruiter creates & posts a new vacancy")
      fillNewVacancyForm(MASTER_VACANCY_DATA)
      activateAndPostVacancy()

      When("candidate registers for new job application")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      And("candidate completes the short form")
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      confirmShortFormCompletion()

      And("candidate completes the long form")
      fillLongFormDetails(MASTER_LONG_FORM_DATA)

      Then("the candidate is able to confirm short & long forms are completed")
      confirmLongFormCompletion()
    }

    Scenario("VX: A Recruiter Creates A Insolvency Apply Only Vacancy; Full Application Process", RunInVX) {
      Given("a recruiter creates & posts an insolvency apply only vacancy")
      fillNewVacancyForm(INSOLVENCY_VACANCY_DATA)
      activateAndPostVacancy()

      When("candidate registers for new job application")
      fillNewCandidateDetails(REGISTER_CANDIDATE_INSOLVENCY)

      And("candidate completes the insolvency short form")
      fillShortFormDetails(SHORT_FORM_DATA_INSOLVENCY)
      confirmShortFormCompletion()

      And("candidate completes the insolvency long form")
      fillLongFormDetails(LONG_FORM_DATA_INSOLVENCY)

      Then("the candidate is able to confirm insolvency short & long forms are completed")
      confirmLongFormCompletion()
    }

    Scenario("V9: A Recruiter Creates A Insolvency Apply Only Vacancy; Limited Application Process", RunInVX) {
      Given("candidate registers for new job application")
      pec2TestData()
      fillNewCandidateDetails(REGISTER_CANDIDATE_INSOLVENCY)

      When("candidate completes the gors short form")
      fillShortFormDetails(SHORT_FORM_DATA_INSOLVENCY)
      confirmShortFormCompletionNoLongForm()
      extractApplicationId()

      And("candidate completes the insolvency pec form")
      navigateToApplicationSummary()
      progressApplicationToOffer()
      candidateAcceptsOffer()
      offerDecisionFlow("Accept")
      confirmOfferAccepted()
      fillPecFormDetailsOnly(MASTER_PEC_FORM_DATA)
      println("So far done!")

      Then("the candidate is able to confirm insolvency short & long forms are completed")

    }

    Scenario("VX: A Recruiter Extracts Vacancy Details", RunInVX) {
      loginWithRecruiterDetails(RECRUITER)
      searchForActiveVacancy()
    }
  }
}
