package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.vx.{DEFRA_APPLY_DATA, HMRC_APPLY_DATA, MASTER_VACANCY_DATA, RECRUITER}
import uk.gov.co.test.ui.flows.vx.MasterVacancyFlow.fillMasterVacancyForm
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.loginWithRecruiterDetails
import uk.gov.co.test.ui.pages.vx.NewVacancyPage.confirmAndActivateVacancy
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
      fillNewVacancyForm(HMRC_APPLY_DATA)

      Then("The hmrc apply only vacancy is successfully created and posted")
      eventually(confirmAndActivateVacancy())
    }
  }
}
