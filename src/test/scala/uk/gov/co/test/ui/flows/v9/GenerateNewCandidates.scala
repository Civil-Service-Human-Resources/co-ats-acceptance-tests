package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.CreateAccountPage.{enterConfirmEmailLoop, enterConfirmPasswordLoop, enterEmailLoop, enterFirstNameLoop, enterLastNameLoop, enterPasswordLoop, navigateToCreateAccountPage, registerNewAccount, selectEmployeeTypeLoop, selectTermsAndConditionsLoop}

import java.io.{File, PrintWriter}
import java.nio.charset.{Charset, StandardCharsets}
import java.nio.file.{Files, Paths, StandardOpenOption}

object GenerateNewCandidates extends CivilServiceJobsBasePage {

  def createMultipleCandidates(candidatesRequired: Int = 1): Unit = {
    val utf8: Charset = StandardCharsets.UTF_8
    val file          = "candidates.txt"
    val writer        = new PrintWriter(new File(file))

    for (i <- 1 to candidatesRequired) {
      generateCandidateDetails() //use this for random names
//      generateCandidateDetailsIterator(i) //use this to iterate a sequence of similar names
      navigateToCreateAccountPage()
      enterFirstNameLoop(randomFirstName)
      enterLastNameLoop(randomLastName)
      enterEmailLoop(randomEmail)
      enterConfirmEmailLoop(randomEmail)
      enterPasswordLoop()
      enterConfirmPasswordLoop()
      selectEmployeeTypeLoop()
      selectTermsAndConditionsLoop()
      registerNewAccount()
      signOutProcess()

      def data: String =
        s"CANDIDATE NO.$i: NAME: $randomFirstName $randomLastName EMAIL: $randomEmail PASSWORD: $passwordCandidate"
      Files.write(Paths.get(file), s"$data\n".getBytes(utf8), StandardOpenOption.APPEND)
    }
  }
}
