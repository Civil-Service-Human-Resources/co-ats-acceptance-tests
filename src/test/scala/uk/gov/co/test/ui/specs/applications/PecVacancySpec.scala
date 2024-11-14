package uk.gov.co.test.ui.specs.applications

import org.scalatest.tagobjects.Retryable
import uk.gov.co.test.ui.data.MasterVacancyDetails.v9RunInWelsh
import uk.gov.co.test.ui.data.test.pec._
import uk.gov.co.test.ui.data.v9.applicants.{REGISTER_CANDIDATE_PEC_1, REGISTER_CANDIDATE_PEC_2}
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.fillFullApplicationDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.weAreCheckingYourApplicationState
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllApplyOnlyVacancyDetails
import uk.gov.co.test.ui.specs.BaseFeatureSpec

class PecVacancySpec extends BaseFeatureSpec {
  Feature("Candidate & Recruiter Complete The PEC Form") {
    Scenario("VX: A Candidate Completes The Candidate PEC Forms; Partial Application Process") {
      Given("candidate registers for new job application")
//      fillNewVacancyForm(PEC_VACANCY_DATA)
      extractAllApplyOnlyVacancyDetails("10192")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC_1)

      When("candidate completes all forms")
      fillFullApplicationDetails()

      Then("the candidate is able to fully complete the pec form")
      weAreCheckingYourApplicationState()
    }
  }

  Feature("Candidate & Recruiter Complete The Workplace Misconduct Section") {
    Scenario("VX: A Candidate Completes The Candidate PEC Forms With Workplace Misconduct Section") {
      Given("candidate registers for new job application")
      extractAllApplyOnlyVacancyDetails("10818")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PEC_2)

      When("candidate completes all forms")
      v9RunInWelsh = true
//      v9HomeDepartment = vXJobInfoDepartment //Internal
//      v9HomeDepartment =  "Swyddfa Gartref"// Internal Welsh
//      v9HomeDepartment = "Animal and Plant Health Agency" //OGD
//      v9HomeDepartment = "Asiantaeth Iechyd Anifeiliaid a Phlanhigion" //OGD Welsh
//      v9HomeDepartment = "UK Research and Innovation" //NPDB
//      v9HomeDepartment = "Ymchwil ac Arloesi y DU" //NPDB Welsh
//      v9HomeDepartment = "National History Museum"
      fillFullApplicationDetails()

      Then("the candidate is able to fully complete the pec form")
      weAreCheckingYourApplicationState()
    }
  }
}
