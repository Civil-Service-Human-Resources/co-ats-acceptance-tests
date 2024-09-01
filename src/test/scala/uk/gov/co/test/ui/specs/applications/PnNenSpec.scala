package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9HomeDepartment, vXJobInfoDepartment, vacancyId}
import uk.gov.co.test.ui.data.test.pnnen.PN_NEN_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants.{REGISTER_CANDIDATE_NEN_DEFRA, REGISTER_CANDIDATE_PN_DEFRA}
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.nenPnFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmApplicationUpdateState, passedPecChecks}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{onboardingNenComplete, postingNoticeCompleted}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllApplyOnlyVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.NewEntrantNoticeTab.newEntrantNoticeFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.PostingNoticeTab.postingNoticeFlow
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class PnNenSpec extends BaseFeatureSpec {
  Feature("Recruiter Completes The PN/NEN Forms") {
    Scenario("VX: A Recruiter Completes The NEN Form (DEFRA)", RunInVX) {
      Given("candidate registers for new job application")
      fillNewVacancyForm(PN_NEN_VACANCY_DATA)
//      extractAllVacancyDetails("10650")
      fillNewCandidateDetails(REGISTER_CANDIDATE_NEN_DEFRA)

      When("external candidate completes all forms until nen form")
      nenPnFlow()

      Then("the candidate is able to fully complete the new entrant notice form")
      newEntrantNoticeFlow(MASTER_APPLICATION_DATA)
      onboardingNenComplete()
      passedPecChecks()
    }

    Scenario("VX: A Recruiter Completes The PN Form (DEFRA)", RunInVX) {
      Given("candidate registers for new job application")
      extractAllApplyOnlyVacancyDetails(vacancyId)
      fillNewCandidateDetails(REGISTER_CANDIDATE_PN_DEFRA)

      When("internal candidate completes all forms until pn form")
      v9HomeDepartment = vXJobInfoDepartment
      nenPnFlow()

      Then("the candidate is able to fully complete the posting notice form")
      postingNoticeFlow(MASTER_APPLICATION_DATA)
      postingNoticeCompleted()
      confirmApplicationUpdateState()
    }
  }
}
