package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.MASTER_REGISTER_CANDIDATE
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vacancyId, vacancyName}
import uk.gov.co.test.ui.flows.e2e.FullPecFlow.completeFullPecFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.vx.createvacancypage.ReserveListSection.changeReserveListDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.ExternalPostingsTab.repostExternalPosting
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class reserveListSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks The Reserve List For Rejected Status") {
    vacancyId = "9574"
    vacancyName = "HMRC - Performance Analyst"

    Scenario("VX: Recruiter Checks 3 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 3 months")
      changeReserveListDetails("3 Months")
      repostExternalPosting()

      When("candidate registers application and is held in reserve offer")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      completeFullPecFlow()

      Then("the candidate is reserve offer expires after the reserve duration")
    }

    Scenario("VX: Recruiter Checks 6 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 3 months")
      changeReserveListDetails("6 Months")
      repostExternalPosting()

      When("candidate registers application and is held in reserve offer")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      completeFullPecFlow()

      Then("the candidate is reserve offer expires after the reserve duration")
    }

    Scenario("VX: Recruiter Checks 9 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 3 months")
      changeReserveListDetails("9 Months")
      repostExternalPosting()

      When("candidate registers application and is held in reserve offer")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      completeFullPecFlow()

      Then("the candidate is reserve offer expires after the reserve duration")
    }

    Scenario("VX: Recruiter Checks 12 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 12 months")
      changeReserveListDetails("12 Months")
      repostExternalPosting()

      When("candidate registers application and is held in reserve offer")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      completeFullPecFlow()

      Then("the candidate is reserve offer expires after the reserve duration")
    }

    Scenario("VX: Recruiter Checks Extended 15 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to an extended 15 months")
      changeReserveListDetails("12 Months", Some(true), Some("3 Months"))
      repostExternalPosting()

      When("candidate registers application and is held in reserve offer")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
      completeFullPecFlow()

      Then("the candidate is reserve offer expires after the reserve duration")
    }
  }
}
