package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vacancyId
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.{extractTabFormId, navigateToVacancyForms, reserveList, searchForVacancy, vXReserveListLength, vXReserveListRequired}
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.{extractFormId, vacancyFormId}

case class ReserveListDetails(
  reserveList: Boolean,
  reserveListLength: String,
  approvalToExtend: Boolean
)

object ReserveListSection extends VacancyBasePage {

  def reserveListId         = s"${vacancyFormId}_field_154633_1"
  def reserveListYesId      = s"${vacancyFormId}_datafield_154633_1_1_1"
  def reserveListNoId       = s"${vacancyFormId}_datafield_154633_1_1_2"
  def reserveListLengthId   = s"select2-${vacancyFormId}_datafield_154637_1_1-container"
  def approvalToExtendYesId = s"${vacancyFormId}_datafield_177141_1_1_1"
  def approvalToExtendNoId  = s"${vacancyFormId}_datafield_177141_1_1_2"
  def extendLengthId        = s"select2-${vacancyFormId}_datafield_177145_1_1-container"

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

  def changeReserveListDetails(
    reserveLength: String,
    approvalToExtend: Option[Boolean] = None,
    extendLength: Option[String] = None
  ): Unit = {
    searchForVacancy(vacancyId)
    navigateToVacancyForms()
    val formId = waitForVisibilityOfElementByPath(".//form[@class='form-horizontal']")
    vacancyFormId = formId.getAttribute("id")
    reserveList()
    if (!vXReserveListRequired || vXReserveListLength != reserveLength) {
      scrollToElement(By.id(reserveListId))
      clickOnRadioButton(reserveListYesId)
      lengthOfReserveList(reserveLength)
      if (reserveLength == "12 Months") {
        if (approvalToExtend.get) {
          clickOnRadioButton(approvalToExtendYesId)
          waitForVisibilityOfElementById(reserveListLengthId).click()
          action().moveToElement(waitForDropdownOption(extendLength.get)).perform()
          waitForDropdownOption(extendLength.get).click()
        } else clickOnRadioButton(approvalToExtendNoId)
      }
      scrollToElement(By.id(submitForm))
      clickOn(submitForm)
    }
  }
}
