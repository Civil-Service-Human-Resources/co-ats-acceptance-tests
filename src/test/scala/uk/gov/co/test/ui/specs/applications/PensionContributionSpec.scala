package uk.gov.co.test.ui.specs.applications

import org.scalatest.tagobjects.Retryable
import uk.gov.co.test.ui.pages.v9.ApplicationDetailsPage.{confirmSalaryAndBenefitSectionsInEnglish, confirmSalaryAndBenefitSectionsInWelsh}
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.jobSearchToCheckPensionDetails
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.{extractAllAdvertOnlyVacancyDetails, extractAllApplyOnlyVacancyDetails}
import uk.gov.co.test.ui.pages.vx.createvacancypage.ContractDetailsSection.changeSalaryAndOfferCSPensionDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.ExternalPostingsTab.repostExternalPosting
import uk.gov.co.test.ui.specs.BaseFeatureSpec

import scala.collection.mutable.ListBuffer

class PensionContributionSpec extends BaseFeatureSpec {
  val applyOnlyVacancyId  = "10733"
  val advertOnlyVacancyId = "10738"
  Feature("Pension Contribution Checks For Apply Only Vacancy") {
    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Assistant' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Administrative Assistant"),
        "19450",
        salaryMaximum = Some("28500"),
        salaryMoreDetails = Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Executive Officer"),
        "21490",
        Some("29000"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Administrative Officer"),
        "24490",
        Some("23000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Grade 7' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Grade 7"),
        "28490",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'SCS Pay Band 1' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("SCS Pay Band 1"),
        "25000",
        Some("27550"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Senior Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "26900",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "Industrial", "SCS Pay Band 1"),
        "29900",
        Some("33670"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Pension Contribution For 'Senior Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "0",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "33500",
        Some("35000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "39500",
        Some("39501"),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Zero Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some(""),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Salary Range; No Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("25000"),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("29000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Zero Range; Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Industrial", "SCS Pay Band 1"),
        "0",
        Some("0"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: High Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "105500",
        Some("125999"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Salary Range; No Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer", "Senior Executive Officer"),
        "125999",
        Some(""),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Same Salary Range; Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "SCS Pay Band 1"),
        "126999",
        Some("126999"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }
  }

  Feature("Pension Contribution Checks For Advert Only Vacancy") {
    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Assistant' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Administrative Assistant"),
        "22500",
        salaryMaximum = Some("23200"),
        salaryMoreDetails = Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Executive Officer"),
        "21490",
        Some("29000"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Administrative Officer"),
        "24490",
        Some("23000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Grade 7' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Grade 7"),
        "28490",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'SCS Pay Band 1' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("SCS Pay Band 1"),
        "25000",
        Some("27550"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Senior Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "26900",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "Industrial", "SCS Pay Band 1"),
        "29900",
        Some("33670"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Pension Contribution For 'Senior Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer"),
        "0",
        Some(""),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Candidate Checks Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "33500",
        Some("35000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "39500",
        Some("39501"),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Zero Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some(""),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Salary Range; No Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("25000"),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "0",
        Some("29000"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Zero Range; Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Industrial", "SCS Pay Band 1"),
        "0",
        Some("0"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: High Salary Range; Pension Contribution For 'Higher Executive Officer' Grade", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer"),
        "105500",
        Some("125999"),
        Some(true),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: No Salary Range; No Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Higher Executive Officer", "Senior Executive Officer"),
        "125999",
        Some(""),
        Some(true),
        offerCSPension = false
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays no pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }

    Scenario("VX: Same Salary Range; Pension Contribution For Multiple Grades", Retryable) {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        ListBuffer("Senior Executive Officer", "SCS Pay Band 1"),
        "126999",
        Some("126999"),
        Some(false),
        offerCSPension = true
      )
      repostExternalPosting()

      When("vacancy details are displayed pre-apply")
      jobSearchToCheckPensionDetails()

      Then("in english - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInEnglish()

      And("in welsh - sections displays pension contribution")
      confirmSalaryAndBenefitSectionsInWelsh()
    }
  }
}
