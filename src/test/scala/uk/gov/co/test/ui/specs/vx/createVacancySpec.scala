package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.{REGISTER_CANDIDATE_1, REGISTER_CANDIDATE_3}
import uk.gov.co.test.ui.data.v9.shortform.{CANDIDATE_SHORT_FORM_DATA_1, CANDIDATE_SHORT_FORM_DATA_3}
import uk.gov.co.test.ui.data.vx._
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.MasterVacancyFlow.fillMasterVacancyForm
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{advertDetailsFunction, applicationCentreTitle, helpWithSelectionText, withdrawApplicationFunction}
import uk.gov.co.test.ui.pages.v9.SignInPage.onPage
import uk.gov.co.test.ui.pages.vx.DashboardPage.searchOn
import uk.gov.co.test.ui.pages.vx.tabs.ExternalPostingsPage.addExternalPosting
import uk.gov.co.test.ui.pages.vx.tabs.SummaryPage.confirmAndActivateVacancy
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class createVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A New Vacancy") {
    Scenario("A Recruiter Is Successful In Creating A New Templated Master Vacancy", RunInVX) {
      Given("a recruiter logs in vx config")
      loginWithRecruiterDetails(RECRUITER)

      When("a recruiter creates a templated master vacancy")
      fillMasterVacancyForm(MASTER_VACANCY_DATA)

      Then("the master vacancy is successfully created and posted")
      eventually(confirmAndActivateVacancy())
    }

    Scenario("A Recruiter Creates a DEFRA Apply Only Templated Vacancy", RunInVX) {
      Given("a recruiter logs in to vx config")
      loginWithRecruiterDetails(RECRUITER)

      When("a recruiter creates a defra apply only vacancy")
      fillNewVacancyForm(DEFRA_APPLY_DATA)

      Then("The defra apply only vacancy is successfully created and posted")
      eventually(confirmAndActivateVacancy())
    }

    Scenario("A Recruiter Creates an HMRC Apply Only Templated Vacancy", RunInVX) {
      Given("a recruiter logs in to vx config")
      loginWithRecruiterDetails(RECRUITER)

      When("a recruiter creates a hmrc apply only vacancy")
      fillNewVacancyForm(HMRC_DATA)
      searchOn()
      confirmAndActivateVacancy()
      addExternalPosting()

      Then("The hmrc apply only vacancy is successfully created and posted")
      confirmAndActivateVacancy()
    }

    Scenario("A Recruiter Posts A Vacancy Live And Applicant Application Process (partial e2e)", RunInVX) {
      Given("a recruiter logs in to vx config and creates vacancy")
      loginWithRecruiterDetails(RECRUITER)
      searchOn()
      confirmAndActivateVacancy()
      addExternalPosting()

      When("candidate applies for the role")
      fillNewCandidateDetails(REGISTER_CANDIDATE_1)
      fillShortFormDetails(CANDIDATE_SHORT_FORM_DATA_1)

      Then("the candidate is able to see their short form submitted")
      eventually(onPage(applicationCentreTitle))
      advertDetailsFunction().isDisplayed
      withdrawApplicationFunction().isDisplayed
      helpWithSelectionText() shouldEqual "Help with selection process"
    }

    Scenario("A Recruiter Creates an HMRC Apply Only Templated Vacancy And Application Process (e2e)", RunInVX) {
      Given("a recruiter logs in to vx config and creates vacancy")
      loginWithRecruiterDetails(RECRUITER)
      fillNewVacancyForm(HMRC_DATA)
      searchOn()
      confirmAndActivateVacancy()
      addExternalPosting()

      When("candidate applies for the role")
      fillNewCandidateDetails(REGISTER_CANDIDATE_1)
      fillShortFormDetails(CANDIDATE_SHORT_FORM_DATA_1)

      Then("the candidate is able to see their short form submitted")
      eventually(onPage(applicationCentreTitle))
      advertDetailsFunction().isDisplayed
      withdrawApplicationFunction().isDisplayed
      helpWithSelectionText() shouldEqual "Help with selection process"
    }

    Scenario("A Recruiter Creates an Insolvency Apply Only Templated Vacancy And Application Process (e2e)", RunInVX) {
      Given("a recruiter logs in to vx config and creates vacancy")
      loginWithRecruiterDetails(RECRUITER)
      fillNewVacancyForm(INSOLVENCY_DATA)
      searchOn()
      confirmAndActivateVacancy()
      addExternalPosting()

      When("candidate applies for the role")
      fillNewCandidateDetails(REGISTER_CANDIDATE_3)
      fillShortFormDetails(CANDIDATE_SHORT_FORM_DATA_3)

      Then("the candidate is able to see their short form submitted")
      eventually(onPage(applicationCentreTitle))
      advertDetailsFunction().isDisplayed
      withdrawApplicationFunction().isDisplayed
      helpWithSelectionText() shouldEqual "Help with selection process"
    }
  }
}
