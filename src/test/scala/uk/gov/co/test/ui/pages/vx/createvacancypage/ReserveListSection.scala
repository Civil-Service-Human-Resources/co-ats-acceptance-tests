package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class ReserveListDetails(
  reserveList: Boolean,
  reserveListLength: String
)

object ReserveListSection extends VacancyBasePage {

  private lazy val reserveListId       = s"${formId}_field_154633_1"
  private lazy val reserveListYesId    = s"${formId}_datafield_154633_1_1_1"
  private lazy val reserveListNoId     = s"${formId}_datafield_154633_1_1_2"
  private lazy val reserveListLengthId = s"select2-${formId}_datafield_154637_1_1-container"

  def selectReserveList(reserveListDetails: ReserveListDetails): Unit = {
    scrollToElement(By.id(reserveListId))
    if (reserveListDetails.reserveList) {
      clickOnRadioButton(reserveListYesId)
      lengthOfReserveList(reserveListDetails.reserveListLength)
    } else {
      clickOnRadioButton(reserveListNoId)
    }
  }

  def waitForDropdownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$option']")

  def lengthOfReserveList(length: String): Unit = {
    waitForVisibilityOfElementById(reserveListLengthId).click()
    action().moveToElement(waitForDropdownOption(length)).perform()
    waitForDropdownOption(length).click()
  }

  private val reserve: Seq[ReserveListDetails => Unit] = Seq(
    selectReserveList
  )

  def reserveListSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    reserve.foreach { f =>
      f(newVacancyDetails.reserveListDetails)
    }
}
