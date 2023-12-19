package uk.gov.co.test.ui.pages.vx.vacancytabs

import uk.gov.co.test.ui.data.vx.ApplicationSummaryDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

case class InterviewOneDetails(
)

object ScheduleOnlineInterviewPage extends VacancyBasePage {

  private lazy val offlineInterviewPageTitle =
    "Generate Communication : Schedule offline interview : Civil Service Jobs - GOV.UK"
  def siftEvaluationHeaderId                 = s"${vacancyFormId}_label_153018_1"

  private val interview: Seq[SiftDetails => Unit] = Seq(
  )

  def InterviewOneFlow(applicationSummaryDetails: ApplicationSummaryDetails): Unit = {
    interview.foreach { f =>
      f(applicationSummaryDetails)
    }
    clickOn(submitForm)
    println("Done")
  }
}
