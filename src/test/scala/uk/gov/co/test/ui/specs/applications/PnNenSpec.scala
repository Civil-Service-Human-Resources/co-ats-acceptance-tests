package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9HomeDepartment, vXJobInfoDepartment}
import uk.gov.co.test.ui.data.test.pnnen.{PN_NEN_APPLICATION_DATA, PN_NEN_LONG_FORM_DATA, PN_NEN_SHORT_FORM_DATA, PN_NEN_VACANCY_DATA}
import uk.gov.co.test.ui.data.v9.applicants.{REGISTER_CANDIDATE_NEN_DEFRA, REGISTER_CANDIDATE_PN_DEFRA}
import uk.gov.co.test.ui.flows.e2e.NenPnFlow.nenPnFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmApplicationUpdateState, passedPecChecks}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{onboardingNenComplete, postingNoticeCompleted}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.NewEntrantNoticeTab.newEntrantNoticeFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.PostingNoticeTab.postingNoticeFlow
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class PnNenSpec extends BaseFeatureSpec {
  Feature("Recruiter Completes The PN Form") {
    Scenario("VX: A Recruiter Completes The PN Form (DEFRA)", RunInVX) {
      Given("candidate registers for new job application")
//      fillNewVacancyForm(PN_NEN_VACANCY_DATA)
      extractAllVacancyDetails("10279")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PN_DEFRA)

      When("internal candidate completes all forms until pn form")
      v9HomeDepartment = vXJobInfoDepartment
      nenPnFlow(PN_NEN_SHORT_FORM_DATA, PN_NEN_LONG_FORM_DATA, PN_NEN_APPLICATION_DATA)

      Then("the candidate is able to fully complete the posting notice form")
      postingNoticeFlow(PN_NEN_APPLICATION_DATA)
      postingNoticeCompleted()
      confirmApplicationUpdateState()
    }

    Scenario("VX: A Recruiter Completes The NEN Form (DEFRA)", RunInVX) {
      Given("candidate registers for new job application")
//      fillNewVacancyForm(PN_NEN_VACANCY_DATA)
      extractAllVacancyDetails("10279")
      fillNewCandidateDetails(REGISTER_CANDIDATE_NEN_DEFRA)

      When("ndpb candidate completes all forms until nen form")
      v9HomeDepartment = "Independent Parliamentary Standards Authority"
      nenPnFlow(PN_NEN_SHORT_FORM_DATA, PN_NEN_LONG_FORM_DATA, PN_NEN_APPLICATION_DATA)

      Then("the candidate is able to fully complete the new entrant notice form")
      newEntrantNoticeFlow(PN_NEN_APPLICATION_DATA)
      onboardingNenComplete()
      passedPecChecks()
    }
  }
}
