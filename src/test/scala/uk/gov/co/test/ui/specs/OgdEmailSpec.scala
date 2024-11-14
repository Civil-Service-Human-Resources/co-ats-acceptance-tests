package uk.gov.co.test.ui.specs

import org.scalatest.tagobjects.Retryable
import uk.gov.co.test.ui.data.MasterVacancyDetails.v9HomeDepartment
import uk.gov.co.test.ui.data.test.ogd.OGD_VACANCY_DATA
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.e2e.FullApplicationFlow.ogdFlow
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{acceptsOfferAgain, acceptsOfferAgainStaffTransfers}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllApplyOnlyVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.{emailHistoryChecks, ogdTransferEmailChecks, ogdTransferHistoryChecks, ogdTransferHistoryChecksNoEmail, setBackToProvisionalOfferOnline}

class OgdEmailSpec extends BaseFeatureSpec {
  Feature("Recruiter Checks Email Status For OGD Transfer") {
    Scenario("VX: Email Sent For OGD Transfer Department (Advert: CO; Home Dept: DEFRA)") {
      Given("a vacancy is created with grs recruitment stage type set to bau")
//      fillNewVacancyForm(OGD_VACANCY_DATA)
      extractAllApplyOnlyVacancyDetails("10047")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "Department for Environment, Food and Rural Affairs"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("16")
      ogdTransferEmailChecks()
    }

    Scenario("VX: Email Not Sent For Non-OGD Department (Advert: CO; Home Dept: HMRC)") {
      Given("a vacancy is created with grs recruitment stage type set to menu")
      extractAllApplyOnlyVacancyDetails("10047")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_HMRC)

      When("candidate selects ogd on offer")
      v9HomeDepartment = "HM Revenue and Customs"
      ogdFlow()

      Then("the email is not sent for non-ogd departments")
      ogdTransferHistoryChecksNoEmail()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (DEFRA)") {
      Given("a vacancy is created with grs recruitment stage type set to bau")
//      fillNewVacancyForm(OGD_VACANCY_DATA)
      extractAllApplyOnlyVacancyDetails("10053")
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

    Scenario("VX: Email Sent For OGD Transfer Department (DWP)") {
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
      acceptsOfferAgainStaffTransfers()
      emailHistoryChecks()
    }

    Scenario("VX: Email Sent For OGD Transfer Department (HSE)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (RPA)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (VMD)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (GPA)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (GDS)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (CDDO)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (GCF)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (CEFAS)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (MOD)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (UKHO)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (APHA)") {
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

    Scenario("VX: Email Sent For OGD Transfer Department (FCDO)") {
      Given("a vacancy is created with grs recruitment stage type set to bau")
//      extractAllApplyOnlyVacancyDetails("10053")
      extractAllApplyOnlyVacancyDetails("10832")
      fillNewCandidateDetails(REGISTER_CANDIDATE_OGD_DEFRA)

      When("candidate selects ogd on offer")
//      v9HomeDepartment = "Foreign, Commonwealth & Development Office"
      v9HomeDepartment = "Department for Environment, Food and Rural Affairs"
      ogdFlow()

      Then("the email is sent for ogd transfer departments")
      ogdTransferHistoryChecks("6")
      ogdTransferEmailChecks()

      And("the email is not sent again for another offer acceptance")
      setBackToProvisionalOfferOnline()
      acceptsOfferAgainStaffTransfers()
      emailHistoryChecks()
    }
  }
}
