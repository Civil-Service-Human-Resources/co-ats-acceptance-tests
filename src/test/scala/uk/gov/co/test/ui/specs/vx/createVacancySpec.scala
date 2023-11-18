package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.vx.{DEFRA_APPLY_ONLY_DATA, MASTER_VACANCY_DATA, RECRUITER}
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow
import uk.gov.co.test.ui.flows.vx.MasterVacancyFlow.fillMasterVacancyForm
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.fillRecruiterDetails
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.navigateToCreateAccountPage
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class createVacancySpec extends BaseFeatureSpec {
  Feature("Recruiter Creates A Master Vacancy") {
    Scenario("A Recruiter Is Successful In Creating A New Templated Master Vacancy", RunInVX) {
      Given("a recruiter logs in vx config")
      val registeredRecruiter = RECRUITER
      fillRecruiterDetails(registeredRecruiter)

      When("a recruiter creates a templated master vacancy")
      val masterVacancy = MASTER_VACANCY_DATA
      fillMasterVacancyForm(masterVacancy)
      val newCandidate  = REGISTER_CANDIDATE
      navigateToCreateAccountPage()
      RegisterCandidateFlow.fillNewCandidateDetails(newCandidate)

      Then("the master vacancy is successfully created and posted")
    }

    Scenario("An External Recruiter Offer Acceptance Does Not Send An Email", RunInVX) {
      Given("a recruiter logs in vx config")
      val registeredRecruiter = RECRUITER
      fillRecruiterDetails(registeredRecruiter)

      When("a recruiter creates a grs vacancy (non-scs)")
      val grsVacancy   = DEFRA_APPLY_ONLY_DATA
      fillNewVacancyForm(grsVacancy)
      val newCandidate = REGISTER_CANDIDATE
      navigateToCreateAccountPage()
      RegisterCandidateFlow.fillNewCandidateDetails(newCandidate)

      Then("The vacancy is successfully created and posted")
    }
  }
}
