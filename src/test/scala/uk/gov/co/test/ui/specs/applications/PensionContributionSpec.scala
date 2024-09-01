package uk.gov.co.test.ui.specs.applications

import uk.gov.co.test.ui.data.MasterVacancyDetails.v9RunInWelsh
import uk.gov.co.test.ui.data.v9.applicants._
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.pages.v9.ApplicationDetailsPage.{confirmSalaryAndBenefitSectionsInEnglish, confirmSalaryAndBenefitSectionsInWelsh}
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
        salaryMaximum = Some("28000"),
        salaryMoreDetails = Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_1)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Executive Officer"),
        "21490",
        Some("29000"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_2)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Administrative Officer"),
        "24490",
        Some("23000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_3)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Grade 7' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Grade 7"),
        "28490",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_4)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'SCS Pay Band 1' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("SCS Pay Band 1"),
        "25000",
        Some("27550"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_5)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Senior Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "26900",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_6)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "Industrial", "SCS Pay Band 1"),
        "29900",
        Some("33670"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_7)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Pension Contribution For 'Senior Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "0",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_8)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "33500",
        Some("35000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_9)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "39500",
        Some("39501"),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_10)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Zero Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some(""),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_11)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Salary Range; No Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("25000"),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_12)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("29000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_13)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Zero Range; Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Industrial", "SCS Pay Band 1"),
        "0",
        Some("0"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_14)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: High Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "105500",
        Some("125999"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_15)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Salary Range; No Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer", "Senior Executive Officer"),
        "125999",
        Some(""),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_16)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Same Salary Range; Pension Contribution For Multiple Grades", RunInVX) {
      Given("a recruiter changes the vacancy contract details")
      extractAllVacancyDetails("10733")
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "SCS Pay Band 1"),
        "126999",
        Some("126999"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("candidate applies and checks the pension contribution details")
      fillNewCandidateDetails(REGISTER_CANDIDATE_PENSION_17)
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }
  }
}
