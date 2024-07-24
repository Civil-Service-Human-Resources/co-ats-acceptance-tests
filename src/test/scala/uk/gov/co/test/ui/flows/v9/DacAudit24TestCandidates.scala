package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomEmail, randomFirstName, randomLastName, randomPassword}
import uk.gov.co.test.ui.data.test.idvt.IDVT_PEC_FORM_DATA
import uk.gov.co.test.ui.data.v9.longform.MASTER_LONG_FORM_DATA
import uk.gov.co.test.ui.data.v9.shortform.MASTER_SHORT_FORM_DATA
import uk.gov.co.test.ui.data.vx.application.MASTER_APPLICATION_DATA
import uk.gov.co.test.ui.flows.e2e.InterviewFlow.{completeAllInterviews, interviewInvited}
import uk.gov.co.test.ui.flows.v9.LongFormFlow.fillLongFormDetails
import uk.gov.co.test.ui.flows.v9.PecFormFlow.fillPecFormDetailsOnly
import uk.gov.co.test.ui.flows.v9.ShortFormFlow.fillShortFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationsPage.confirmStatusOnApplicationPage
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.{enterConfirmDacPasswordLoop, enterConfirmEmailLoop, enterDacPasswordLoop, enterEmailLoop, enterFirstNameLoop, enterLastNameLoop, navigateToCreateAccountPage, registerNewAccount, selectEmployeeTypeLoop, selectTermsAndConditionsLoop}
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{invitedToDigitalIdentityCheck, moveAndAcceptOffer, progressApplicationToOffer, selectedForOffer}
import uk.gov.co.test.ui.pages.vx.DashboardPage.switchToV9Test
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.extractAllVacancyDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.PreSiftEvaluationTab.PreSiftEvaluationFlow
import uk.gov.co.test.ui.pages.vx.vacancytabs.SiftEvaluationTab.SiftEvaluationFlow

import java.io.{File, PrintWriter}
import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.{Files, Paths, StandardOpenOption}
import scala.reflect.io.Directory

object DacAudit24TestCandidates extends CivilServiceJobsBasePage {

  implicit class ListOps[A](list: List[A]) {
    def getRandomElement: Option[A] = list match {
      case Nil => None
      case _   => list.lift(scala.util.Random.nextInt(list.size))
    }
  }

  def createDacTestCandidates(requestNumber: Int, vacancy: String, candidatesRequired: Int = 1): Unit = {
    val utf8: Charset = StandardCharsets.UTF_8
    val file          = "dac.txt"
    val writer        = new PrintWriter(new File(file))
    val vacancies     = List("10348", "10349", "10350", "10416", "10417")

    for (i <- 1 to candidatesRequired) {
      if (requestNumber == 1 || requestNumber == 5) extractAllVacancyDetails(vacancies.getRandomElement.get)
      else extractAllVacancyDetails(vacancy)

      if (currentUrl.startsWith(TestConfiguration.urlHost("vxconfig"))) switchToV9Test()
      //application flow
      generateTestCandidateDetails(i) //use this for random names
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
      if (requestNumber == 1) {
        fillShortFormDetails(MASTER_SHORT_FORM_DATA)
      } else if (requestNumber == 2 || requestNumber == 3) {
        fillShortFormDetails(MASTER_SHORT_FORM_DATA)
        fillLongFormDetails(MASTER_LONG_FORM_DATA)
        PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
        SiftEvaluationFlow(MASTER_APPLICATION_DATA)
        interviewInvited(MASTER_APPLICATION_DATA)
      } else if (requestNumber == 4) {
        fillShortFormDetails(MASTER_SHORT_FORM_DATA)
        fillLongFormDetails(MASTER_LONG_FORM_DATA)
        PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
        SiftEvaluationFlow(MASTER_APPLICATION_DATA)
        completeAllInterviews(MASTER_APPLICATION_DATA)
        progressApplicationToOffer()
      } else if (requestNumber == 5) {
        fillShortFormDetails(MASTER_SHORT_FORM_DATA)
        fillLongFormDetails(MASTER_LONG_FORM_DATA)
        PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
        SiftEvaluationFlow(MASTER_APPLICATION_DATA)
        completeAllInterviews(MASTER_APPLICATION_DATA)
        moveAndAcceptOffer()
        fillPecFormDetailsOnly(IDVT_PEC_FORM_DATA)
        confirmStatusOnApplicationPage("Confirm your identity")
        invitedToDigitalIdentityCheck()
      } else if (requestNumber == 6 || requestNumber == 7) {
        fillShortFormDetails(MASTER_SHORT_FORM_DATA)
        fillLongFormDetails(MASTER_LONG_FORM_DATA)
        PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
        SiftEvaluationFlow(MASTER_APPLICATION_DATA)
        completeAllInterviews(MASTER_APPLICATION_DATA)
        selectedForOffer()
      } else {
        fillShortFormDetails(MASTER_SHORT_FORM_DATA)
        fillLongFormDetails(MASTER_LONG_FORM_DATA)
        PreSiftEvaluationFlow(MASTER_APPLICATION_DATA)
        SiftEvaluationFlow(MASTER_APPLICATION_DATA)
        completeAllInterviews(MASTER_APPLICATION_DATA)
        moveAndAcceptOffer()
        fillPecFormDetailsOnly(IDVT_PEC_FORM_DATA)
      }

      //sign out
      changeSystem("candidate")
      signOutProcess()
      changeSystem("recruiter")

      //print details to text file
      def data: String =
        s"REQUEST $requestNumber - CANDIDATE NO.$i: EMAIL: $randomEmail PASSWORD: $randomPassword"

      Files.write(Paths.get(file), s"$data\n".getBytes(utf8), StandardOpenOption.APPEND)
    }
  }
}
