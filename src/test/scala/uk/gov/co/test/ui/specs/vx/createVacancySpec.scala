package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.MAIN_REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx._
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.{fillShortFormDetails, fillShortFormDetailsOnly}
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.confirmShortFormCompletion
import uk.gov.co.test.ui.pages.vx.DashboardPage.{activateAndPostVacancy, searchForActiveVacancy}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class createVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A Master Vacancy") {
    Scenario("A Recruiter Creates A Full Flow Apply Only Vacancy; Full Application Process", RunInVX) {
      Given("a recruiter logs in to vx config and creates & posts vacancy")
      fillNewVacancyForm(MASTER_VACANCY_DATA)
      activateAndPostVacancy()

      When("candidate registers for new job application")
      fillNewCandidateDetails(MAIN_REGISTER_CANDIDATE)

      And("candidate completes the short form")
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      confirmShortFormCompletion()

      And("candidate completes the long form")
      fillLongFormDetailsOnly(MASTER_LONG_FORM_DATA)

      Then("the candidate is able to complete the application")

    }

    Scenario("A Recruiter Creates A Minimum Flow Apply Only Vacancy; Full Application Process", RunInVX) {
      Given("a recruiter logs in to vx config and creates & posts vacancy")
      fillNewVacancyForm(MIN_VACANCY_DATA)
      activateAndPostVacancy()

      When("candidate applies & completes the short, long & pec forms")
      fillNewCandidateDetails(MAIN_REGISTER_CANDIDATE)
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)

      Then("the candidate is able to submit and complete the application")
      confirmShortFormCompletion()
    }

    Scenario("A Candidate Completes Short And Long Forms", RunInVX) {
      Given("candidate registers and then completes the short form")
      fillNewCandidateDetails(MAIN_REGISTER_CANDIDATE)
      fillShortFormDetailsOnly(MASTER_SHORT_FORM_DATA)
      confirmShortFormCompletion()

      When("candidate completes the long form")
      fillLongFormDetailsOnly(MASTER_LONG_FORM_DATA)

      Then("candidate is taken to the next stage of application")

    }

    Scenario("A Recruiter Extracts Vacancy Details", RunInVX) {
      loginWithRecruiterDetails(RECRUITER)
      searchForActiveVacancy()
    }
  }
}
