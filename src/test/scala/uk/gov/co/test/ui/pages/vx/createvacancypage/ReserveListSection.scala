package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class ReserveListDetails(
  reserveList: Boolean,
  reserveListLength: String,
  approvalToExtend: Boolean
)

object ReserveListSection extends VacancyBasePage {

  def reserveListId         = s"${formId}_field_154633_1"
  def reserveListYesId      = s"${formId}_datafield_154633_1_1_1"
  def reserveListNoId       = s"${formId}_datafield_154633_1_1_2"
  def reserveListLengthId   = s"select2-${formId}_datafield_154637_1_1-container"
  def approvalToExtendYesId = s"${formId}_datafield_177141_1_1_1"
  def approvalToExtendNoId  = s"${formId}_datafield_177141_1_1_2"

  def selectReserveList(reserveListDetails: ReserveListDetails): Unit = {
    scrollToElement(By.id(reserveListId))
    if (reserveListDetails.reserveList) {
      clickOnRadioButton(reserveListYesId)
      lengthOfReserveList(reserveListDetails.reserveListLength)
      if (reserveListDetails.reserveListLength == "12 Months") {
        selectApprovalToExtend(reserveListDetails)
      }
    } else {
      clickOnRadioButton(reserveListNoId)
    }
  }

  def selectApprovalToExtend(reserveListDetails: ReserveListDetails): Unit =
    if (reserveListDetails.approvalToExtend) clickOnRadioButton(approvalToExtendYesId)
    else clickOnRadioButton(approvalToExtendNoId)

  def lengthOfReserveList(length: String): Unit = {
    waitForVisibilityOfElementById(reserveListLengthId).click()
    action().moveToElement(waitForDropdownOption(length)).perform()
    waitForDropdownOption(length).click()
  }

  private val reserve: Seq[ReserveListDetails => Unit] = Seq(
    selectReserveList
  )

  def reserveListSection(newVacancyDetails: NewVacancyDetails): Unit =
    reserve.foreach { f =>
      f(newVacancyDetails.reserveListDetails)
    }
}
