package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.BehavioursPage.behavioursPage
import uk.gov.co.test.ui.pages.v9.longform.DeclarationPage.{declarationPage, longFormSubmission}
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.experienceAndSkillsPage
import uk.gov.co.test.ui.pages.v9.longform.PersonalStatementPage.personalStatementPage
import uk.gov.co.test.ui.pages.v9.longform.PreferencesPage.preferencesPage
import uk.gov.co.test.ui.pages.v9.longform.RoleSpecificQuestionsPage.roleQuestionsPage
import uk.gov.co.test.ui.pages.v9.longform.TechnicalSkillsPage.techSkillsPage
import uk.gov.co.test.ui.pages.v9.longform.UploadDocumentsPage.uploadDocumentsPage
import uk.gov.co.test.ui.pages.v9.longform.YourCVPage.yourCVPage

object LongFormFlow extends CivilServiceJobsBasePage {

  private val longform: Seq[LongFormDetails => Unit] = Seq(
    experienceAndSkillsPage,
    yourCVPage,
    personalStatementPage,
    behavioursPage,
    techSkillsPage,
    uploadDocumentsPage,
    preferencesPage,
    roleQuestionsPage,
    declarationPage
  )

  def fillLongFormDetails(longFormDetails: LongFormDetails): Unit = {
    clickOn("submit_form")
    longform.foreach { f =>
      f(longFormDetails)
    }
    clickOn(longFormSubmission)
    println("Done!")
  }

}
