package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.{MASTER_REGISTER_CANDIDATE, REGISTER_CANDIDATE_INSOLVENCY}
import uk.gov.co.test.ui.data.v9.longform.{LONG_FORM_DATA_INSOLVENCY, MASTER_LONG_FORM_DATA}
import uk.gov.co.test.ui.data.v9.shortform.{MASTER_SHORT_FORM_DATA, SHORT_FORM_DATA_INSOLVENCY}
import uk.gov.co.test.ui.data.vx._
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmLongFormCompletion, confirmShortFormCompletion}
import uk.gov.co.test.ui.pages.vx.DashboardPage.{activateAndPostVacancy, searchForActiveVacancy}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class createVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A Master Vacancy") {
    Scenario("VX-A Recruiter Creates A Master Flow Apply Only Vacancy; Master Application Process", RunInVX) {
      Given("a recruiter logs in to vx config and creates & posts vacancy")
      fillNewVacancyForm(MASTER_VACANCY_DATA)
      activateAndPostVacancy()

      When("candidate registers for new job application")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)

      And("candidate completes the short form")
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      confirmShortFormCompletion()

      And("candidate completes the long form")
      fillLongFormDetails(MASTER_LONG_FORM_DATA)

      Then("the candidate is able to complete the application")
      confirmLongFormCompletion()
    }

    Scenario("VX-A Recruiter Creates A Insolvency Apply Only Vacancy; Full Application Process", RunInVX) {
      Given("a recruiter logs in to vx config and creates & posts vacancy")
      fillNewVacancyForm(INSOLVENCY_VACANCY_DATA)
      activateAndPostVacancy()

      When("candidate registers for new job application")
      fillNewCandidateDetails(REGISTER_CANDIDATE_INSOLVENCY)

      And("candidate completes the short form")
      fillShortFormDetails(SHORT_FORM_DATA_INSOLVENCY)
      confirmShortFormCompletion()

      And("candidate completes the long form")
      fillLongFormDetails(LONG_FORM_DATA_INSOLVENCY)

      Then("the candidate is able to complete the application")
      confirmLongFormCompletion()
    }

    Scenario("VX - A Recruiter Extracts Vacancy Details", RunInVX) {
      loginWithRecruiterDetails(RECRUITER)
      searchForActiveVacancy()
    }
  }
}
