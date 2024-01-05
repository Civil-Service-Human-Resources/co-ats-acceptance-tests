package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{applicationId, preferredFirstName, randomEmail}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.VacancyDetailsPage.{vXReserveListLength, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.{categoryDetail, categoryDetailLink, historyEmailValues, historyTabPath}

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ReserveListsTab extends VacancyBasePage {

  private lazy val reserveExpiryListTabPath    = ".//span[@class='main-label' and text() = 'Reserve List - Expiry Dates']"
  private lazy val reserveListLengthHeaderPath = "(//h4)[8]"
  private lazy val reserveExpiryListHeaderPath = "(//h4)[9]"
  private lazy val submitId                    = "submit_button"
  def currentReserveListLengthId               = s"${reserveListFormId}_label_121022_1"
  def reserveList3MonthsExpiryId               = s"${reserveListFormId}_field_121032_1"
  def reserveList6MonthsExpiryId               = s"${reserveListFormId}_field_121036_1"
  def reserveList9MonthsExpiryId               = s"${reserveListFormId}_field_121040_1"
  def reserveList12MonthsExpiryId              = s"${reserveListFormId}_field_121044_1"
  def reserveList15MonthsExpiryId              = s"${reserveListFormId}_field_176823_1"
  def reserveList18MonthsExpiryId              = s"${reserveListFormId}_field_176826_1"
  def reserveList21MonthsExpiryId              = s"${reserveListFormId}_field_176829_1"
  def reserveList24MonthsExpiryId              = s"${reserveListFormId}_field_176833_1"
  var reserveListFormId: String                = ""

  private def checkReserveHeader(fieldPath: String, expectedReserveHeader: String): Unit = {
    val header = waitForVisibilityOfElementByPath(fieldPath).getText
    header shouldEqual expectedReserveHeader
  }

  private def checkReserveValue(fieldId: String, expectedReserveValue: String): Unit = {
    val expiry = waitForVisibilityOfElementById(fieldId).getText
    expiry shouldEqual expectedReserveValue
  }

  private def selectReserveExpiryListTab(): Unit = {
    waitForVisibilityOfElementByPath(reserveExpiryListTabPath).click()
    extractTabFormId()
  }

  def reserveExpiryListChecks(): Unit = {
    selectReserveExpiryListTab()
    checkReserveHeader(reserveListLengthHeaderPath, "Reserve list length")
    checkReserveHeader(
      reserveExpiryListHeaderPath,
      "Reserve list expiry dates (auto-populated when candidate enters Reserve List status)"
    )
    checkReserveValue(currentReserveListLengthId, s"Current reserve list length  \n$vXReserveListLength")
    checkReserveValue(
      reserveList3MonthsExpiryId,
      s"""3 month expiry date
                                                     |  ${reserveExpiryDateDays(1)}""".stripMargin
    )
    checkReserveValue(
      reserveList6MonthsExpiryId,
      s"""6 months expiry date
                                                     |  ${reserveExpiryDateDays(2)}""".stripMargin
    )
    checkReserveValue(
      reserveList12MonthsExpiryId,
      s"""12 months expiry date
                                                      |  ${reserveExpiryDateDays(4)}""".stripMargin
    )
    checkReserveValue(
      reserveList15MonthsExpiryId,
      s"""15 months expiry date
                                                      |  ${reserveExpiryDateDays(5)}""".stripMargin
    )
    checkReserveValue(
      reserveList18MonthsExpiryId,
      s"""18 months expiry date
                                                      |  ${reserveExpiryDateDays(6)}""".stripMargin
    )
    checkReserveValue(
      reserveList21MonthsExpiryId,
      s"""21 months expiry date
                                                      |  ${reserveExpiryDateDays(7)}""".stripMargin
    )
    checkReserveValue(
      reserveList24MonthsExpiryId,
      s"""24 months expiry date
                                                      |  ${reserveExpiryDateDays(8)}""".stripMargin
    )
  }

  def reserveListHistoryChecks(): Unit = {
    waitForVisibilityOfElementByPath(historyTabPath).click()
    waitForVisibilityOfElementById("summary_tabs_history_tab").isDisplayed
    categoryDetail("Email") shouldEqual s"Subject: Application update - $vacancyName - $vacancyId"
    categoryDetailLink("Email").click()
  }

  def reserveListEmailChecks(): Unit = {
    val (_destination, _subject, _status, _emailPreview) = historyEmailValues("Email")
    _destination  shouldEqual randomEmail
    _subject      shouldEqual s"Subject: Application update - $vacancyName - $vacancyId"
    _status       shouldEqual s"$randomEmail: Not sent yet"
    _emailPreview shouldEqual
      s"""Dear $preferredFirstName,
         |$vacancyId - $vacancyName
         |Application ID number: $applicationId
         |You have reached the required standard, but we are unable to offer you a job immediately.
         |We have placed you on a reserve list from which future appointments may be made.
         |The reserve list for $vacancyName will expire on ${reserveExpiryDateDays(1)} and if we are able to offer you a role before this date we will contact you again.
         |Please let us know if you would like us to remove you from the reserve list at any time.
         |Kind Regards,
         |
         |HM Revenue and Customs Recruitment Team""".stripMargin
  }

  private def extractTabFormId(): String = {
    val formClass = driver.findElement(By.xpath(".//form[@class='form-horizontal']"))
    reserveListFormId = formClass.getAttribute("id")
    reserveListFormId
  }

  private def reserveExpiryDate(monthsToAdd: Int): String = {
    val formatter  = DateTimeFormatter.ofPattern("d MMMM yyyy")
    val expiry     = LocalDate.now().plusMonths(monthsToAdd)
    val expiryDate = expiry.format(formatter)
    expiryDate
  }

  //test purposes
  def reserveExpiryDateDays(days: Int): String = {
    val formatter  = DateTimeFormatter.ofPattern("d MMMM yyyy")
    val expiry     = LocalDate.now().plusDays(days)
    val expiryDate = expiry.format(formatter)
    expiryDate
  }
}
