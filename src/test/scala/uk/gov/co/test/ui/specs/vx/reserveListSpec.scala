package uk.gov.co.test.ui.specs.vx

import uk.gov.co.test.ui.data.v9.applicants.{MASTER_REGISTER_CANDIDATE_12_MONTHS, MASTER_REGISTER_CANDIDATE_3_MONTHS, MASTER_REGISTER_CANDIDATE_6_MONTHS}
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vacancyId, vacancyName}
import uk.gov.co.test.ui.flows.e2e.ReserveListFlow.reserveListFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.reserveExpiryList
import uk.gov.co.test.ui.pages.vx.createvacancypage.ReserveListSection.changeReserveListDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.ExternalPostingsTab.repostExternalPosting
import uk.gov.co.test.ui.pages.vx.vacancytabs.ReserveListsTab.{reserveExpiryListChecks, reserveListEmailChecks, reserveListHistoryChecks}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class reserveListSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks The Reserve List For Rejected Status") {
    vacancyId = "9574"
    vacancyName = "HMRC - Performance Analyst"

    Scenario("VX: Recruiter Checks 3 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 3 months for a vacancy")
      changeReserveListDetails("3 Months")
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_3_MONTHS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveExpiryListChecks()
      reserveListHistoryChecks()
      reserveListEmailChecks()
    }

    Scenario("VX: Recruiter Checks 6 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 6 months for a vacancy")
      changeReserveListDetails("6 Months")
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_6_MONTHS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveExpiryListChecks()
      reserveListHistoryChecks()
      reserveListEmailChecks()
    }

    Scenario("VX: Recruiter Checks 12 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 12 months for a vacancy")
      changeReserveListDetails("12 Months")
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_12_MONTHS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveExpiryListChecks()
      reserveListHistoryChecks()
      reserveListEmailChecks()
    }

//    Scenario("VX: Recruiter Checks 15 Months Reserve List", RunInVX) {
//      Given("a recruiter changes the reserve list to 15 months for a vacancy")
//      changeReserveListDetails("12 Months", Some(true), Some("3 Months"))
//      repostExternalPosting()
//
//      When("candidate applies and is held in a reserve list position")
//      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE)
//      reserveListFlow()
//
//      Then("the reserve offer expires after the reserve duration")
//      reserveExpiryList()
//      reserveExpiryListChecks()
//      reserveListHistoryChecks()
//      reserveListEmailChecks()
//    }
  }
}
