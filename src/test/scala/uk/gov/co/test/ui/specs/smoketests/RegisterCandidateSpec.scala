package uk.gov.co.test.ui.specs.smoketests

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9HomeDepartment, v9RtwBritishIrishPassport}
import uk.gov.co.test.ui.data.v9.applicants.{REGISTERED_CANDIDATE, REGISTER_CANDIDATE}
import uk.gov.co.test.ui.flows.v9.DacAudit24TestCandidates.{createDacTestCandidateEight, createDacTestCandidatesFive, createDacTestCandidatesFour, createDacTestCandidatesSixAndSeven, createDacTestCandidatesTwoAndThree}
import uk.gov.co.test.ui.flows.v9.GenerateNewCandidates.createMultipleCandidates
import uk.gov.co.test.ui.flows.v9.RegisterCandidateFlow.fillNewCandidateDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.applicationCentrePageTitle
import uk.gov.co.test.ui.pages.v9.SearchJobsPage.{accountCreatedSuccess1, accountCreatedSuccess2, accountCreatedSuccessMessage1, accountCreatedSuccessMessage2, candidateDisplayName, navigateToSignInOrCreateAccount}
import uk.gov.co.test.ui.pages.v9.SignInPage.{candidateFullName, candidateSignIn, editAccountDetails, onPage}
import uk.gov.co.test.ui.specs.BaseFeatureSpec
import uk.gov.co.test.ui.tags.RunInV9

class RegisterCandidateSpec extends BaseFeatureSpec {
  Feature("Registration Of Candidates On Civil Service Jobs") {
    Scenario("V9: A Registered Candidate Logs In To Civil Service Jobs", RunInV9) {
      Given("A registered candidate navigates to the sign in page")
      navigateToSignInOrCreateAccount()

      When("The candidate signs into their cs jobs account")
      candidateSignIn(REGISTERED_CANDIDATE)

      Then("The candidate is able to see their account")
      candidateDisplayName() shouldEqual candidateFullName(REGISTERED_CANDIDATE)
    }

    Scenario("V9: A Candidate Creates An Account On Civil Service Jobs", RunInV9) {
      Given("candidate newly registers their details")
      fillNewCandidateDetails(REGISTER_CANDIDATE)

      When("candidate confirms the account has been created")
      accountCreatedSuccess1() shouldEqual accountCreatedSuccessMessage1
      accountCreatedSuccess2() shouldEqual accountCreatedSuccessMessage2
      candidateDisplayName()   shouldEqual candidateFullName(REGISTER_CANDIDATE)

      Then("the candidate navigates to the edit account details page")
      editAccountDetails().click()
      onPage(applicationCentrePageTitle)
    }

    Scenario("V9: Create Multiple Candidate Accounts", RunInV9) {
      createMultipleCandidates(5)
    }

    Scenario("VX: Create DAC Candidate Accounts for Request Two", RunInV9) {
      createDacTestCandidatesTwoAndThree("9794", 20)
    }

    Scenario("VX: Create DAC Candidate Accounts for Request Three", RunInV9) {
      createDacTestCandidatesTwoAndThree("9795", 20)
    }

    Scenario("VX: Create DAC Candidate Accounts for Request Four", RunInV9) {
      v9HomeDepartment = "UK Research and Innovation" //NPDB
      createDacTestCandidatesFour("9793", 20)
    }

    Scenario("VX: Create DAC Candidate Accounts for Request Five", RunInV9) {
      v9HomeDepartment = "UK Research and Innovation" //NPDB
      createDacTestCandidatesFive(List("9793", "9794", "9795", "9796", "9797"), 20)
    }

    Scenario("VX: Create DAC Candidate Accounts for Request Six", RunInV9) {
      v9HomeDepartment = "Animal and Plant Health Agency" //OGD
      createDacTestCandidatesSixAndSeven("10349", 10)
    }

    Scenario("VX: Create DAC Candidate Accounts for Request Seven", RunInV9) {
      v9HomeDepartment = "UK Research and Innovation" //NPDB
      createDacTestCandidatesSixAndSeven("9795", 10)
    }

    Scenario("VX: Create DAC Candidate Accounts for Request Eight", RunInV9) {
      v9HomeDepartment = "UK Research and Innovation" //NPDB
      v9RtwBritishIrishPassport = false
      createDacTestCandidateEight("9795", 9)
    }
  }
}
