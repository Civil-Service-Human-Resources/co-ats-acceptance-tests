package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecSelfEmploymentCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class SelfEmploymentDetails(
  selfEmploymentLast3Years: Boolean
)

object SelfEmploymentPage extends CivilServiceJobsBasePage {

  private lazy val selfEmploymentPageTitle = "Self Employment - Civil Service Jobs - GOV.UK"
  def selfEmploymentLast3YearsYesId        = s"${pecFormId}_datafield_182053_1_1_1_label"
  def selfEmploymentLast3YearsNoId         = s"${pecFormId}_datafield_182053_1_1_2_label"

  private def selfEmploymentPageCheck(): Unit =
    eventually(onPage(selfEmploymentPageTitle))

  private def selectSelfEmploymentLast3Years(selfEmploymentDetails: SelfEmploymentDetails): Unit =
    if (selfEmploymentDetails.selfEmploymentLast3Years) {
      radioSelect(selfEmploymentLast3YearsYesId)
    } else {
      radioSelect(selfEmploymentLast3YearsNoId)
    }

  private val selfEmployment: Seq[SelfEmploymentDetails => Unit] = Seq(
    selectSelfEmploymentLast3Years
  )

  def selfEmploymentPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecSelfEmploymentCheck.contains("Not Applicable") &&
      vXPecSelfEmploymentCheck.contains(s"$vXApproach Candidates")
    ) {
      selfEmploymentPageCheck()
      selfEmployment.foreach { f =>
        f(pecFormDetails.selfEmploymentDetails)
      }
      clickOn(pageContinue)
    }
}
