package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.MasterVacancyDetails.vacancyId
import uk.gov.co.test.ui.data.test.reserve.RESERVE_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.reserveListFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.reserveExpiryList
import uk.gov.co.test.ui.pages.vx.createvacancypage.ReserveListSection.changeReserveListDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.ExternalPostingsTab.repostExternalPosting
import uk.gov.co.test.ui.pages.vx.vacancytabs.ReserveListsTab.{reserveListExpiryChecks, reserveListHistoryEmailChecks, reserveListHistoryProcessChecks}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class ReserveListSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks The Reserve List For Rejected Status") {
    Scenario("VX: Recruiter Checks 3 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 3 months for a vacancy")
      fillNewVacancyForm(RESERVE_VACANCY_DATA)
//      vacancyId = "10527"
      changeReserveListDetails("3 Months")
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_3_MONTHS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
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
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
    }

    Scenario("VX: Recruiter Checks 9 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 9 months for a vacancy")
      changeReserveListDetails("9 Months")
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_9_MONTHS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
    }

    Scenario("VX: Recruiter Checks 12 Months Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 12 months for a vacancy")
      changeReserveListDetails("12 Months", Some(false), None)
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_12_MONTHS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
    }

    Scenario("VX: Recruiter Checks 12 Months and 2 Weeks Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 12 months and 2 weeks for a vacancy")
      changeReserveListDetails("12 Months", Some(true), Some("2 weeks"))
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_12_MONTHS_2_WEEKS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
    }

    Scenario("VX: Recruiter Checks 12 Months and 4 Weeks Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 12 months and 4 weeks for a vacancy")
      changeReserveListDetails("12 Months", Some(true), Some("4 weeks"))
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_12_MONTHS_4_WEEKS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
    }

    Scenario("VX: Recruiter Checks 12 Months and 6 Weeks Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 12 months and 6 weeks for a vacancy")
      changeReserveListDetails("12 Months", Some(true), Some("6 weeks"))
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_12_MONTHS_6_WEEKS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
    }

    Scenario("VX: Recruiter Checks 12 Months and 8 Weeks Reserve List", RunInVX) {
      Given("a recruiter changes the reserve list to 12 months and 8 weeks for a vacancy")
      changeReserveListDetails("12 Months", Some(true), Some("8 weeks"))
      repostExternalPosting()

      When("candidate applies and is held in a reserve list position")
      fillNewCandidateDetails(MASTER_REGISTER_CANDIDATE_12_MONTHS_8_WEEKS)
      reserveListFlow()

      Then("the reserve offer expires after the reserve duration")
      reserveExpiryList()
      reserveListExpiryChecks()
      reserveListHistoryProcessChecks()
      reserveListHistoryEmailChecks()
    }
  }
}
