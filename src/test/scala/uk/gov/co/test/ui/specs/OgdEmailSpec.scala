package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.MasterVacancyDetails.v9HomeDepartment
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.OgdFlow.ogdFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.{ogdTransferEmailChecks, ogdTransferHistoryChecks, ogdTransferHistoryChecksNoEmail}
import uk.gov.co.test.ui.tags.RunInVX

class OgdEmailSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks Email Status For OGD Transfer") {
    Scenario("VX: Email Sent For OGD Transfer Department", RunInVX) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
//      fillNewVacancyForm(OGD_VACANCY_DATA)
      extractAllVacancyDetails("10047")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Department for Environment, Food and Rural Affairs"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks()
      ogdTransferEmailChecks()
    }

    Scenario("VX: Email Not Sent For Non-OGD Department", RunInVX) {
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
