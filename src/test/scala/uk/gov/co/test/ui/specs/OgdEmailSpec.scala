package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.MasterVacancyDetails.vacancyId
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.OgdFlow.ogdFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{provisionalOfferAccepted, reserveExpiryList}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.emailHistoryChecks
import uk.gov.co.test.ui.pages.vx.vacancytabs.ReserveListsTab.{reserveExpiryListChecks, reserveListEmailChecks, reserveListHistoryChecks}
import uk.gov.co.test.ui.tags.RunInVX

class OgdEmailSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks Email Status For OGD Transfer") {
    Scenario("VX: Recruiter Checks Email Sent For Menu-OGD", RunInVX) {
      Given("a vacancy is created with grs recruitment stage type set to menu")
      vacancyId = "9645"
      extractAllVacancyDetails(vacancyId)
//      fillNewVacancyForm(OGD_VACANCY_DATA)

      When("candidate selects ogd on offer")
      fillNewCandidateDetails(REGISTER_CANDIDATE_MENU_OGD)
      ogdFlow()

      Then("the reserve offer expires after the reserve duration")
      provisionalOfferAccepted()
      emailHistoryChecks()
//      reserveListEmailChecks()
    }
  }
}
