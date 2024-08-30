package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.v9.ApplicationDetailsPage.confirmSalaryAndBenefitSections
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.jobSearchToCheckPensionDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.createvacancypage.ContractDetailsSection.changeSalaryAndOfferCSPensionDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.ExternalPostingsTab.repostExternalPosting
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInVX

import scala.collection.mutable.ListBuffer

class PensionContributionSpec extends BaseFeatureSpec {
  Feature("Recruiter & Candidate Checks For Pension Contribution") {
    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Assistant' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Administrative Assistant"),
        "19490",
        Some("28000"),
        Some("test-salary more details"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_1)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Executive Officer"),
        "21490",
        Some("29000"),
        Some(""),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_2)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Administrative Officer"),
        "24490",
        Some("23000"),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_3)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Grade 7' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Grade 7"),
        "28490",
        Some(""),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_4)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'SCS Pay Band 1' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("SCS Pay Band 1"),
        "25000",
        Some("27550"),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_5)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Senior Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "26900",
        Some(""),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_6)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Candidate Checks Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "Industrial", "SCS Pay Band 1"),
        "29900",
        Some("33670"),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_7)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: No Pension Contribution For 'Senior Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "0",
        Some(""),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_8)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "33500",
        Some("35000"),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_9)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: No Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "39500",
        Some("39501"),
        Some("test salary more info"),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_10)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Zero Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some(""),
        Some("test salary more info"),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_11)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Salary Range; No Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("25000"),
        Some("test salary more info"),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_12)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("29000"),
        Some("test salary more info"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_13)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Zero Range; Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Industrial", "SCS Pay Band 1"),
        "0",
        Some("0"),
        Some(""),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_14)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: High Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "105500",
        Some("125999"),
        Some("higher salary test"),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_15)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: No Salary Range; No Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer", "Senior Executive Officer"),
        "125999",
        Some(""),
        Some("higher salary test"),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_16)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }

    Scenario("VX: Same Salary Range; Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "SCS Pay Band 1"),
        "126999",
        Some("126999"),
        Some(""),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_17)
      jobSearchToCheckPensionDetails()

      Then("the salary and benefit sections display pension contribution")
      confirmSalaryAndBenefitSections()
    }
  }
}
