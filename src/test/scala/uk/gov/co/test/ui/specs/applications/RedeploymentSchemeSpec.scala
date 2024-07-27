package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.{checkForNoRedeploymentScheme, checkForRedeploymentScheme}
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

class RedeploymentSchemeSpec extends BaseFeatureSpec {
  Feature("Candidate To Be Considered Under The Redeployment Scheme") {
    Scenario("VX: Candidate Selects Home Departments Eligible For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      extractAllVacancyDetails("9667")

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_1)

      Then("candidate is asked about the redeployment scheme")
      checkForRedeploymentScheme(MASTER_SHORT_FORM_DATA, vacancyInScheme = true)
    }

    Scenario("VX: Candidate Selects Home Departments Ineligible For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      extractAllVacancyDetails("9667")

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_2)

      Then("candidate is not asked about the redeployment scheme")
      checkForNoRedeploymentScheme(MASTER_SHORT_FORM_DATA)
    }

    Scenario("VX: Vacancy Does Not Meet Criteria For Redeployment Scheme", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
//      fillNewVacancyForm(NON_REDEPLOYMENT_VACANCY_DATA)
      extractAllVacancyDetails("10443")

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_3)

      Then("candidate is not asked about the redeployment scheme")
      checkForRedeploymentScheme(MASTER_SHORT_FORM_DATA, vacancyInScheme = false)
    }

    Scenario("VX: Vacancy & Home Department Do Not Meet Criteria For Redeployment Scheme", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      extractAllVacancyDetails("10443")

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_4)

      Then("candidate is not asked about the redeployment scheme")
      checkForNoRedeploymentScheme(MASTER_SHORT_FORM_DATA)
    }
  }
}
