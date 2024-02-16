package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9HomeDepartment, vacancyId}
import uk.gov.co.test.ui.data.test.ogd.OGD_LONG_FORM_DATA
import uk.gov.co.test.ui.data.test.redeployment.{NON_REDEPLOYMENT_VACANCY_DATA, REDEPLOYMENT_SHORT_FORM_DATA}
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.fillNewVacancyForm
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.tags.RunInVX

class RedeploymentSchemeSpec extends BaseFeatureSpec {
  Feature("Candidate To Be Considered Under The Redeployment Scheme") {
    Scenario("VX: Candidate Selects DESNZ Home Department For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      vacancyId = "9667"
      v9HomeDepartment = "Department for Energy Security & Net Zero"
      extractAllVacancyDetails(vacancyId)

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_1)

      Then("they are asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects DSIT Home Department For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Department for Science, Innovation and Technology"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_2)

      Then("they are asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects GEO Home Department For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Government Equalities Office"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_3)

      Then("they are asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects RS Home Department For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Revenue Scotland"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_4)

      Then("they are asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects SFC Home Department For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Scottish Fiscal Commission"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_5)

      Then("they are asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects TS Home Department For Redeployment Scheme", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Transport Scotland"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_6)

      Then("they are asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department - HMICFRS", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "His Majesty's Inspectorate of Constabulary and Fire & Rescue Services"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_7)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department - MRC", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Medical Research Council"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_8)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department - OSCR", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Office for the Scottish Charity Regulator"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_9)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department - RBGK", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Royal Botanic Gardens Kew"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_10)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department - MI6 - SIS", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "MI6 - Secret Intelligence Service"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_11)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department - UKRI", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "UK Research and Innovation"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_12)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department - VTS", RunInVX) {
      Given("a vacancy is included in the redeployment scheme")
      v9HomeDepartment = "Valuation Tribunal Service"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_13)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects DESNZ Home Department For Non-Eligible Vacancy", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      fillNewVacancyForm(NON_REDEPLOYMENT_VACANCY_DATA)
      v9HomeDepartment = "Department for Energy Security & Net Zero"
      extractAllVacancyDetails(vacancyId)

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_14)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects DSIT Home Department For Non-Eligible Vacancy", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Department for Science, Innovation and Technology"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_15)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects GEO Home Department For Non-Eligible Vacancy", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Government Equalities Office"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_16)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects RS Home Department For Non-Eligible Vacancy", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Revenue Scotland"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_17)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects SFC Home Department For Non-Eligible Vacancy", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Scottish Fiscal Commission"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_18)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects TS Home Department For Non-Eligible Vacancy", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Transport Scotland"

      When("a candidate selects an eligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_19)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario(
      "VX: Candidate Selects Non-Eligible Home Department With Vacancy Not Included In Scheme - HMICFRS",
      RunInVX
    ) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Department for Energy Security & Net Zero"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_20)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department With Vacancy Not Included In Scheme - MRC", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Medical Research Council"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_21)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department With Vacancy Not Included In Scheme - OSCR", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Office for the Scottish Charity Regulator"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_22)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department With Vacancy Not Included In Scheme - RBGK", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Royal Botanic Gardens Kew"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_23)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario(
      "VX: Candidate Selects Non-Eligible Home Department With Vacancy Not Included In Scheme - MI6 - SIS",
      RunInVX
    ) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "MI6 - Secret Intelligence Service"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_24)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department With Vacancy Not Included In Scheme - UKRI", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "UK Research and Innovation"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_25)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }

    Scenario("VX: Candidate Selects Non-Eligible Home Department With Vacancy Not Included In Scheme - VTS", RunInVX) {
      Given("a vacancy is not included in the redeployment scheme")
      v9HomeDepartment = "Valuation Tribunal Service"

      When("a candidate selects an ineligible home department")
      fillNewCandidateDetails(REGISTER_CANDIDATE_REDEPLOYMENT_SCHEME_26)

      Then("they are not asked if they meet the criteria to be considered under the redeployment scheme")
      fillShortFormDetails(REDEPLOYMENT_SHORT_FORM_DATA)
    }
  }
}
