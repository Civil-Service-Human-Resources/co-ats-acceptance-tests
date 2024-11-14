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
    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Assistant' Grade") {
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Executive Officer"),
        salaryMinimum = "21490",
        salaryMaximum = Some("29000"),
        salaryMoreDetails = Some(false),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Administrative Officer"),
        salaryMinimum = "24490",
        salaryMaximum = Some("23000"),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Grade 7' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Grade 7"),
        salaryMinimum = "28490",
        salaryMaximum = Some(""),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'SCS Pay Band 1' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("SCS Pay Band 1"),
        salaryMinimum = "25000",
        salaryMaximum = Some("27550"),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Senior Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer"),
        salaryMinimum = "26900",
        salaryMaximum = Some(""),
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

    Scenario("VX: Candidate Checks Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer", "Industrial", "SCS Pay Band 1"),
        salaryMinimum = "29900",
        salaryMaximum = Some("33670"),
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

    Scenario("VX: No Pension Contribution For 'Senior Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some(""),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "33500",
        salaryMaximum = Some("35000"),
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

    Scenario("VX: No Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "39500",
        salaryMaximum = Some("39501"),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Zero Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some(""),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Salary Range; No Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some("25000"),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Salary Range; Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some("29000"),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Zero Range; Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Industrial", "SCS Pay Band 1"),
        salaryMinimum = "0",
        salaryMaximum = Some("0"),
        salaryMoreDetails = Some(false),
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

    Scenario("VX: High Salary Range; Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "105500",
        salaryMaximum = Some("125999"),
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

    Scenario("VX: No Salary Range; No Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer", "Senior Executive Officer"),
        salaryMinimum = "125999",
        salaryMaximum = Some(""),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Same Salary Range; Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllApplyOnlyVacancyDetails(applyOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer", "SCS Pay Band 1"),
        salaryMinimum = "126999",
        salaryMaximum = Some("126999"),
        salaryMoreDetails = Some(false),
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
    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Assistant' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Administrative Assistant"),
        salaryMinimum = "22500",
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Executive Officer"),
        salaryMinimum = "21490",
        salaryMaximum = Some("29000"),
        salaryMoreDetails = Some(false),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Administrative Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Administrative Officer"),
        salaryMinimum = "24490",
        salaryMaximum = Some("23000"),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Grade 7' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Grade 7"),
        salaryMinimum = "28490",
        salaryMaximum = Some(""),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'SCS Pay Band 1' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("SCS Pay Band 1"),
        salaryMinimum = "25000",
        salaryMaximum = Some("27550"),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Senior Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer"),
        salaryMinimum = "26900",
        salaryMaximum = Some(""),
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

    Scenario("VX: Candidate Checks Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer", "Industrial", "SCS Pay Band 1"),
        salaryMinimum = "29900",
        salaryMaximum = Some("33670"),
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

    Scenario("VX: No Pension Contribution For 'Senior Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some(""),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Candidate Checks Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "33500",
        salaryMaximum = Some("35000"),
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

    Scenario("VX: No Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "39500",
        salaryMaximum = Some("39501"),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Zero Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some(""),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Salary Range; No Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some("25000"),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Salary Range; Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "0",
        salaryMaximum = Some("29000"),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Zero Range; Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Industrial", "SCS Pay Band 1"),
        salaryMinimum = "0",
        salaryMaximum = Some("0"),
        salaryMoreDetails = Some(false),
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

    Scenario("VX: High Salary Range; Pension Contribution For 'Higher Executive Officer' Grade") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer"),
        salaryMinimum = "105500",
        salaryMaximum = Some("125999"),
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

    Scenario("VX: No Salary Range; No Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Higher Executive Officer", "Senior Executive Officer"),
        salaryMinimum = "125999",
        salaryMaximum = Some(""),
        salaryMoreDetails = Some(true),
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

    Scenario("VX: Same Salary Range; Pension Contribution For Multiple Grades") {
      Given("a recruiter changes the vacancy contract details")
      extractAllAdvertOnlyVacancyDetails(advertOnlyVacancyId)
      changeSalaryAndOfferCSPensionDetails(
        jobGrades = ListBuffer("Senior Executive Officer", "SCS Pay Band 1"),
        salaryMinimum = "126999",
        salaryMaximum = Some("126999"),
        salaryMoreDetails = Some(false),
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
