package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow
import uk.gov.co.test.ui.flows.vx.NewTemplateVacancyFlow.fillNewVacancyTemplatedForm
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillVacancyDetails
import uk.gov.co.test.ui.flows.vx.RecruiterLoginFlow.fillRecruiterDetails
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.navigateToCreateAccountPage
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX
import uk.gov.co.test.ui.utils.{GRS_VACANCY, VACANCY_DATA, RECRUITERS, REGISTER_CANDIDATE}

class ogdProcessSpec extends BaseFeatureSpec {
  Feature("Email Not Sent For External Recruiter") {
    Scenario("An External Recruiter Offer Acceptance Does Not Send An Email1", RunInVX) {
      Given("a recruiter creates a grs vacancy (non-scs)")
      val registeredRecruiter = RECRUITERS
      fillRecruiterDetails(registeredRecruiter)
      val grsVacancy          = GRS_VACANCY
      fillVacancyDetails(grsVacancy)

      When("The recruiter creates a new vacancy")
      val newCandidate = REGISTER_CANDIDATE
      navigateToCreateAccountPage()
      RegisterCandidateFlow.fillCandidateDetails(newCandidate)

      Then("The vacancy is successfully created and posted")
    }

    Scenario("An External Recruiter Offer Acceptance Does Not Send An Email2", RunInVX) {
      Given("a recruiter creates a grs vacancy (non-scs)")
      val registeredRecruiter = RECRUITERS
      fillRecruiterDetails(registeredRecruiter)
      val grsVacancy          = VACANCY_DATA
      fillNewVacancyTemplatedForm(grsVacancy)

      When("The recruiter creates a new vacancy")
      val newCandidate = REGISTER_CANDIDATE
      navigateToCreateAccountPage()
      RegisterCandidateFlow.fillCandidateDetails(newCandidate)

      Then("The vacancy is successfully created and posted")
    }
  }
}
