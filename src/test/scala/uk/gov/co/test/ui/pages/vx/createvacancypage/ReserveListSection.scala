package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXReserveExtendLength, vXReserveExtendRequired, vXReserveListLength, vXReserveListRequired, vXReserveListTotalLength, vacancyFormId, vacancyId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.{extractAllApplyOnlyVacancyDetails, navigateToVacancyForms, reserveList, searchForVacancy}
import uk.gov.co.test.ui.pages.vx.createvacancypage.ContractDetailsSection.waitForDataSaved

case class ReserveListDetails(
  reserveList: Boolean,
  reserveListLength: String,
  approvalToExtend: Boolean,
  extendLength: String
)

object ReserveListSection extends VacancyBasePage {

  def reserveListId                  = s"${vacancyFormId}_field_154633_1"
  def reserveListYesId               = s"${vacancyFormId}_datafield_154633_1_1_1"
  def reserveListNoId                = s"${vacancyFormId}_datafield_154633_1_1_2"
  def reserveListLengthId            = s"select2-${vacancyFormId}_datafield_154637_1_1-container"
  def approvalToExtendYesId          = s"${vacancyFormId}_datafield_177141_1_1_1"
  def approvalToExtendNoId           = s"${vacancyFormId}_datafield_177141_1_1_2"
  def extendLengthId                 = s"select2-${vacancyFormId}_datafield_205583_1_1-container"
  def approveForPublicationMessageId = s"${vacancyFormId}_label_72537_1"
  def dataSavedIconId                = ".//*[@class='msg_icon']"

  def selectReserveList(reserveListDetails: ReserveListDetails): Unit = {
    scrollToElement(By.id(reserveListId))
    vXReserveListRequired = reserveListDetails.reserveList
    if (vXReserveListRequired) {
      clickOnRadioButton(reserveListYesId)
      vXReserveListLength = reserveListDetails.reserveListLength
      lengthOfReserveList(vXReserveListLength)
      if (vXReserveListLength == "12 Months") {
        selectApprovalToExtend(reserveListDetails)
      }
    } else {
      clickOnRadioButton(reserveListNoId)
    }
  }

  def selectApprovalToExtend(reserveListDetails: ReserveListDetails): Unit = {
    vXReserveExtendRequired = reserveListDetails.approvalToExtend
    if (vXReserveExtendRequired) {
      clickOnRadioButton(approvalToExtendYesId)
      vXReserveExtendLength = reserveListDetails.extendLength
      extendLengthOfReserveList(vXReserveExtendLength)
    } else clickOnRadioButton(approvalToExtendNoId)
  }

  def lengthOfReserveList(length: String): Unit = {
    waitForVisibilityOfElementById(reserveListLengthId).click()
    action().moveToElement(waitForDropdownOption(length)).perform()
    waitForDropdownOption(length).click()
  }

  def extendLengthOfReserveList(extendLength: String): Unit = {
    waitForVisibilityOfElementById(extendLengthId).click()
    action().moveToElement(waitForDropdownOption(extendLength)).perform()
    waitForDropdownOption(extendLength).click()
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
    extendRequired: Option[Boolean] = None,
    extendLength: Option[String] = None
  ): Unit = {
    searchForVacancy(vacancyId)
    navigateToVacancyForms()
    reserveList()
    if (!vXReserveListRequired || vXReserveListLength != reserveLength || vXReserveListLength == "12 Months") {
      scrollToElement(By.id(reserveListId))
      clickOnRadioButton(reserveListYesId)
      lengthOfReserveList(reserveLength)
      if (reserveLength == "12 Months") {
        if (extendRequired.isDefined && extendRequired.get) {
          clickOnRadioButton(approvalToExtendYesId)
          waitForVisibilityOfElementById(extendLengthId).click()
          action().moveToElement(waitForDropdownOption(extendLength.getOrElse(""))).perform()
          waitForDropdownOption(extendLength.getOrElse("")).click()
        } else clickOnRadioButton(approvalToExtendNoId)
      }
      scrollToElement(By.id(submitForm))
      clickOn(submitForm)
      waitForVisibilityOfElementById(approveForPublicationMessageId).isDisplayed
      waitForDataSaved()
    }
    extractAllApplyOnlyVacancyDetails(vacancyId)
    totalReserveExpiryLength()
  }

  def totalReserveExpiryLength(): Unit =
    if (vXReserveExtendRequired) {
      vXReserveListTotalLength = s"$vXReserveListLength + $vXReserveExtendLength"
    } else { vXReserveListTotalLength = s"$vXReserveListLength" }
}
