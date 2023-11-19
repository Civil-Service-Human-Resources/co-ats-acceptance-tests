package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId

case class EligibilityDetails(
  currentCivilServant: Boolean,
  homeDepartment: String,
  nationalityReqMet: Boolean,
  rightToRemain: Boolean
)

object EligibilityPage extends CivilServiceJobsBasePage {

  private lazy val eligibilityTitle = "Eligibility - Civil Service Jobs - GOV.UK"
  def currentCivilServantYesId      = s"${formId}_datafield_87767_1_1_1_label"
  def currentCivilServantNoId       = s"${formId}_datafield_87767_1_1_2_label"
  def homeDepartmentSelectId        = s"${formId}_datafield_177937_1_1"
  def nationalityReqMetYesId        = s"${formId}_datafield_44636_1_1_1_label"
  def nationalityReqMetNoId         = s"${formId}_datafield_44636_1_1_2_label"
  def rightToRemainYesId            = s"${formId}_datafield_44639_1_1_1_label"
  def rightToRemainNoId             = s"${formId}_datafield_44639_1_1_2_label"
  var civilServant: String          = ""

  private def isCivilServant(eligibilityDetails: EligibilityDetails): String = {
    val value = eligibilityDetails.currentCivilServant
    value.toString
  }

  private def eligibilityPageCheck(): Unit =
    eventually(onPage(eligibilityTitle))

  private def currentCivilServantOrCSCEmployed(eligibilityDetails: EligibilityDetails): Unit = {
    eligibilityPageCheck()
    if (eligibilityDetails.currentCivilServant) {
      radioSelect(currentCivilServantYesId)
      selectDropdownOption(homeDepartmentSelectId, eligibilityDetails.homeDepartment)
    } else radioSelect(currentCivilServantNoId)
  }

  private def selectNationalityReqMet(eligibilityDetails: EligibilityDetails): Unit =
    if (eligibilityDetails.nationalityReqMet) radioSelect(nationalityReqMetYesId)
    else radioSelect(nationalityReqMetNoId)

  private def selectRightToRemain(eligibilityDetails: EligibilityDetails): Unit =
    if (eligibilityDetails.rightToRemain) radioSelect(rightToRemainYesId)
    else radioSelect(rightToRemainNoId)

  private val eligibility: Seq[EligibilityDetails => Unit] = Seq(
    currentCivilServantOrCSCEmployed,
    selectNationalityReqMet,
    selectRightToRemain
  )

  def eligibilityPage(shortFormDetails: ShortFormDetails): Unit = {
    eligibility.foreach { f =>
      f(shortFormDetails.eligibilityDetails)
    }
    civilServant = isCivilServant(shortFormDetails.eligibilityDetails)
    clickOn(pageContinue)
  }
}
