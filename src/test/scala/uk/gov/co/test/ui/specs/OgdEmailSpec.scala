package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.MasterVacancyDetails.v9HomeDepartment
import uk.gov.co.test.ui.data.test.ogd.OGD_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.OgdFlow.ogdFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.confirmApplicationUpdateState
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.agreeStartDate
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.{ogdTransferEmailChecks, ogdTransferHistoryChecks, ogdTransferHistoryChecksNoEmail}
import uk.gov.co.test.ui.tags.RunInVX

class OgdEmailSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks Email Status For OGD Transfer") {
    Scenario("VX: Email Sent For OGD Transfer Department (Advert: CO; Home Dept: DEFRA)", RunInVX) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
//      fillNewVacancyForm(OGD_VACANCY_DATA)
      extractAllVacancyDetails("10047")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Department for Environment, Food and Rural Affairs"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("16")
      ogdTransferEmailChecks()
    }

    Scenario("VX: Email Not Sent For Non-OGD Department (Advert: CO; Home Dept: HMRC)", RunInVX) {
      Given("a vacancy is created with grs recruitment stage type set to menu")
      extractAllVacancyDetails("10047")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_HMRC)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "HM Revenue and Customs"
      ogdFlow()

      Then("the email is not sent for non-ogd departments")
      ogdTransferHistoryChecksNoEmail()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (WIP)", RunInVX) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
//      fillNewVacancyForm(OGD_VACANCY_DATA)
      extractAllVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Department for Environment, Food and Rural Affairs"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()
    }

    Scenario("VX: Email Not Sent For Non-OGD Department (WIP)", RunInVX) {
      Given("a vacancy is created with grs recruitment stage type set to menu")
      extractAllVacancyDetails("10047")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_HMRC)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "HM Revenue and Customs"
      ogdFlow()

      Then("the email is not sent for non-ogd departments")
      ogdTransferHistoryChecksNoEmail()
    }
  }
}
