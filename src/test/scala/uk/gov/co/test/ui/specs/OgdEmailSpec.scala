package uk.gov.co.test.ui.specs

import org.scalatest.tagobjects.Retryable
import uk.gov.co.test.ui.data.MasterVacancyDetails.v9HomeDepartment
import uk.gov.co.test.ui.data.test.ogd.OGD_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.ogdFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.acceptsOfferAgain
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllApplyOnlyVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.{emailHistoryChecks, ogdTransferEmailChecks, ogdTransferHistoryChecks, setBackToProvisionalOfferOnline}

class OgdEmailSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks Email Status For OGD Transfer") {
//    Scenario("VX: Email Sent For OGD Transfer Department (Advert: CO; Home Dept: DEFRA)", Retryable) {
//      Given("a vacancy is created with grs recruitment stage type set to bau")
////      fillNewVacancyForm(OGD_VACANCY_DATA)
//      extractAllVacancyDetails("10047")
//      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)
//
//      When("candidate selects ogd on offer")
//      v9HomeDepartment = "Department for Environment, Food and Rural Affairs"
//      ogdFlow()
//
//      Then("the email is sent for ogd transfer departments")
//      ogdTransferHistoryChecks("16")
//      ogdTransferEmailChecks()
//    }
//
//    Scenario("VX: Email Not Sent For Non-OGD Department (Advert: CO; Home Dept: HMRC)", Retryable) {
//      Given("a vacancy is created with grs recruitment stage type set to menu")
//      extractAllVacancyDetails("10047")
//      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_HMRC)
//
//      When("candidate selects ogd on offer")
//      v9HomeDepartment = "HM Revenue and Customs"
//      ogdFlow()
//
//      Then("the email is not sent for non-ogd departments")
//      ogdTransferHistoryChecksNoEmail()
//    }

    Scenario("VX: Email Sent For OGD Transfer Department (DEFRA)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      fillNewVacancyForm(OGD_VACANCY_DATA)
//      extractAllVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Office for Environmental Protection"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (DWP)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Department for Work and Pensions"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (HSE)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Health and Safety Executive"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (RPA)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Rural Payments Agency"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (VMD)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Veterinary Medicines Directorate"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (GPA)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Government Property Agency"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (GDS)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Government Digital Services"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (CDDO)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Central Digital and Data Office"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (GCF)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Government Commercial Function"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (CEFAS)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10047")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Centre for Environment, Fisheries and Aquaculture Science"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("16")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (MOD)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Ministry of Defence"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (UKHO)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "UK Hydrographic Office"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (APHA)", Retryable) {
      Given("a vacancy is created with grs recruitment stage type set to bau")
      extractAllApplyOnlyVacancyDetails("10053")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Animal and Plant Health Agency"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgain()
      emailHistoryChecks()
    }
  }
}
