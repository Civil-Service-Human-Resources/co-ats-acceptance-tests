package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.BehavioursPage.behavioursPage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.experienceAndSkillsPage
import uk.gov.co.test.ui.pages.v9.longform.PersonalStatementPage.personalStatementPage
import uk.gov.co.test.ui.pages.v9.longform.TechnicalSkillsPage.techSkillsPage
import uk.gov.co.test.ui.pages.v9.longform.YourCVPage.yourCVPage

object LongFormFlow extends CivilServiceJobsBasePage {

  private val longform: Seq[LongFormDetails => Unit] = Seq(
    experienceAndSkillsPage,
    yourCVPage,
    personalStatementPage,
    behavioursPage,
    techSkillsPage
  )

  def fillLongFormDetails(longFormDetails: LongFormDetails): Unit =
    longform.foreach { f =>
      f(longFormDetails)
    }
//    clickOn(shortFormSubmission)

  def fillLongFormDetailsOnly(longFormDetails: LongFormDetails): Unit = {
    clickOn("submit_form")
    longform.foreach { f =>
      f(longFormDetails)
    }
//    clickOn(shortFormSubmission)
  }

}
