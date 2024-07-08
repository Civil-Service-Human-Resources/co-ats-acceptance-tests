package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomEmail, randomFirstName, randomLastName, randomPassword}
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.{completeAllInterviews, interviewInvited}
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.{enterConfirmDacPasswordLoop, enterConfirmEmailLoop, enterDacPasswordLoop, enterEmailLoop, enterFirstNameLoop, enterLastNameLoop, navigateToCreateAccountPage, registerNewAccount, selectEmployeeTypeLoop, selectTermsAndConditionsLoop}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.progressApplicationToOffer
import uk.gov.co.test.ui.pages.vx.DashboardPage.switchToV9Test
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

import java.io.{File, PrintWriter}
import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.{Files, Paths, StandardOpenOption}

object DacAudit24TestCandidates extends CivilServiceJobsBasePage {

  def createDacTestCandidates(vacancy: String, candidatesRequired: Int = 1): Unit = {
    val utf8: Charset = StandardCharsets.UTF_8
    val file          = "dac.txt"
    val writer        = new PrintWriter(new File(file))

    for (i <- 1 to candidatesRequired) {
      extractAllVacancyDetails(vacancy)
      if (currentUrl.startsWith(TestConfiguration.urlHost("vxconfig"))) switchToV9Test()
      //application flow
      generateTestCandidateDetails() //use this for random names
      navigateToCreateAccountPage()
      enterFirstNameLoop(randomFirstName)
      enterLastNameLoop(randomLastName)
      enterEmailLoop(randomEmail)
      enterConfirmEmailLoop(randomEmail)
      enterDacPasswordLoop(randomPassword)
      enterConfirmDacPasswordLoop(randomPassword)
      selectEmployeeTypeLoop()
      selectTermsAndConditionsLoop()
      registerNewAccount()

      //application flow
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      fillLongFormDetails(MASTER_LONG_FORM_DATA)
      PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
      SiftEvaluationFlow(MASTER_APPLICATION_DATA)
      interviewInvited(MASTER_APPLICATION_DATA)

      //sign out
      changeSystem("candidate")
      signOutProcess()
      changeSystem("recruiter")

      //print details to text file
      def data: String =
        s"CANDIDATE NO.$i: EMAIL: $randomEmail PASSWORD: $randomPassword"
      Files.write(Paths.get(file), s"$data\n".getBytes(utf8), StandardOpenOption.APPEND)
    }
  }

  def createDacTestCandidatesThree(vacancy: String, candidatesRequired: Int = 1): Unit = {
    val utf8: Charset = StandardCharsets.UTF_8
    val file = "dac.txt"
    val writer = new PrintWriter(new File(file))

    for (i <- 1 to candidatesRequired) {
      extractAllVacancyDetails(vacancy)
      if (currentUrl.startsWith(TestConfiguration.urlHost("vxconfig"))) switchToV9Test()
      //application flow
      generateTestCandidateDetails() //use this for random names
      navigateToCreateAccountPage()
      enterFirstNameLoop(randomFirstName)
      enterLastNameLoop(randomLastName)
      enterEmailLoop(randomEmail)
      enterConfirmEmailLoop(randomEmail)
      enterDacPasswordLoop(randomPassword)
      enterConfirmDacPasswordLoop(randomPassword)
      selectEmployeeTypeLoop()
      selectTermsAndConditionsLoop()
      registerNewAccount()

      //application flow
      fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      fillLongFormDetails(MASTER_LONG_FORM_DATA)
      PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
      SiftEvaluationFlow(MASTER_APPLICATION_DATA)
      completeAllInterviews(MASTER_APPLICATION_DATA)
      progressApplicationToOffer()

      //sign out
      changeSystem("candidate")
      signOutProcess()
      changeSystem("recruiter")

      //print details to text file
      def data: String =
        s"CANDIDATE NO.$i: EMAIL: $randomEmail PASSWORD: $randomPassword"

      Files.write(Paths.get(file), s"$data\n".getBytes(utf8), StandardOpenOption.APPEND)
    }
  }
}
