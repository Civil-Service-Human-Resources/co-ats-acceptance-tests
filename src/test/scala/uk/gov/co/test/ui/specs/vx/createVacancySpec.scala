package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.MAIN_REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.v9.shortform.MAIN_CANDIDATE_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx._
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.MasterVacancyFlow.fillMasterVacancyForm
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.vx.DashboardPage.{activateAndPostVacancy, confirmShortFormCompletion}
import uk.gov.co.test.ui.pages.vx.vacancytabs.SummaryPage.confirmAndActivateVacancy
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class createVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A Master Vacancy") {
    Scenario("A Recruiter Is Successful In Creating A New Templated Master Vacancy", RunInVX) {
      Given("a recruiter logs in vx config")
      loginWithRecruiterDetails(RECRUITER)

      When("a recruiter creates a templated master vacancy")
      fillMasterVacancyForm(MASTER_VACANCY_DATA)

      Then("the master vacancy is successfully created and posted")
      eventually(confirmAndActivateVacancy())
    }

    Scenario("A Recruiter Creates A Full Flow Apply Only Templated Vacancy And Completes Application Process", RunInVX) {
      Given("a recruiter logs in to vx config and creates & posts vacancy")
      fillNewVacancyForm(MAIN_VACANCY_DATA)
      activateAndPostVacancy()

      When("candidate applies & completes the short & pec forms")
      fillNewCandidateDetails(MAIN_REGISTER_CANDIDATE)
      fillShortFormDetails(MAIN_CANDIDATE_SHORT_FORM_DATA)

      Then("the candidate is able to submit and complete the application")
      confirmShortFormCompletion()
    }
  }
}
