package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{applicationId, preferredFirstName, randomEmail, vXReserveExtendLength, vXReserveExtendRequired, vXReserveListLength, vXReserveListTotalLength, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.{historyTabPath, reserveEmailDetails, reserveScheduleDetails}

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ReserveListsTab extends VacancyBasePage {

  private lazy val reserveExpiryListTabPath    = ".//span[@class='main-label' and text() = 'Reserve List - Expiry Dates']"
  private lazy val reserveListLengthHeaderPath = "(//h4)[8]"
  private lazy val reserveExpiryListHeaderPath = "(//h4)[9]"
  private lazy val submitId                    = "submit_button"
  var reserveListFormId: String                = ""

  def currentReserveListLengthId       = s"${reserveListFormId}_label_121022_1"
  def currentReserveExtendListLengthId = s"${reserveListFormId}_label_176809_1"
  def reserveList3MonthsExpiryId       = s"${reserveListFormId}_field_121032_1"
  def reserveList6MonthsExpiryId       = s"${reserveListFormId}_field_121036_1"
  def reserveList9MonthsExpiryId       = s"${reserveListFormId}_field_121040_1"
  def reserveList12MonthsExpiryId      = s"${reserveListFormId}_field_121044_1"
  def reserveList15MonthsExpiryId      = s"${reserveListFormId}_field_176823_1"
  def reserveList18MonthsExpiryId      = s"${reserveListFormId}_field_176826_1"
  def reserveList21MonthsExpiryId      = s"${reserveListFormId}_field_176829_1"
  def reserveList24MonthsExpiryId      = s"${reserveListFormId}_field_176833_1"

  private def checkReserveHeader(fieldPath: String, expectedReserveHeader: String): Unit = {
    val header = waitForVisibilityOfElementByPath(fieldPath).getText
    header shouldEqual expectedReserveHeader
  }

  private def checkReserveValue(fieldId: String, expectedReserveValue: String): Unit = {
    scrollToElement(By.id(fieldId))
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
      "Reserve list expiry dates (auto-populated when the candidate first enters the Reserve List status)"
    )
    checkReserveValue(currentReserveListLengthId, s"Current reserve list length  \n$vXReserveListLength")
    if (vXReserveExtendRequired) {
      checkReserveValue(
        currentReserveExtendListLengthId,
        s"Length of reserve list extension (beyond 12 months)  \n$vXReserveExtendLength"
      )
    }
    checkReserveValue(reserveList3MonthsExpiryId, s"3 month expiry date\n  ${calculatedExpiryDates(3)}")
    checkReserveValue(reserveList6MonthsExpiryId, s"6 months expiry date\n  ${calculatedExpiryDates(6)}")
    checkReserveValue(reserveList12MonthsExpiryId, s"12 months expiry date\n  ${calculatedExpiryDates(12)}")
    checkReserveValue(reserveList15MonthsExpiryId, s"15 months expiry date\n  ${calculatedExpiryDates(15)}")
    checkReserveValue(reserveList18MonthsExpiryId, s"18 months expiry date\n  ${calculatedExpiryDates(18)}")
    checkReserveValue(reserveList21MonthsExpiryId, s"21 months expiry date\n  ${calculatedExpiryDates(21)}")
    checkReserveValue(reserveList24MonthsExpiryId, s"24 months expiry date\n  ${calculatedExpiryDates(24)}")
  }

  def reserveListHistoryChecks(): Unit = {
    waitForVisibilityOfElementByPath(historyTabPath).click()
    waitForVisibilityOfElementById("summary_tabs_history_tab").isDisplayed
    waitForVisibilityOfElementByPath(
      "(//*[@class='detail-grid-tl'])[3]"
    ).getText shouldEqual s"Subject: Application update - $vacancyName - $vacancyId"
    waitForVisibilityOfElementByPath("(//*[@class='detail-grid-tr'])[3]//a").click()
  }

  def reserveListEmailChecks(): Unit = {
    val scheduleDate = reserveScheduleDetails()
    val templateId   = reserveEmailDetails("1")
    val destination  = reserveEmailDetails("2")
    val subject      = reserveEmailDetails("3")
    val status       = reserveEmailDetails("4")
    val emailPreview = waitForVisibilityOfElementByPath("//*[@class='email_preview ']//tbody/tr[2]").getText
    scheduleDate      should startWith(s"Process rule scheduled for ${reserveExpiryDateReformatted()}")
    templateId   shouldEqual "220"
    destination  shouldEqual randomEmail
    subject      shouldEqual s"Application update - $vacancyName - $vacancyId"
    status       shouldEqual s"$randomEmail: Not sent yet"
    emailPreview shouldEqual
      s"""Dear $preferredFirstName,
         |$vacancyId - $vacancyName
         |Application ID number: $applicationId
         |You have reached the required standard, but we are unable to offer you a job immediately.
         |We have placed you on a reserve list from which future appointments may be made.
         |The reserve list for $vacancyName will expire on ${reserveExpiryDateMonths()} and if we are able to offer you a role before this date we will contact you again.
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

  private def calculatedExpiryDates(monthsToAdd: Int): String = {
    val formatter  = DateTimeFormatter.ofPattern("d MMMM yyyy")
    val expiry     = LocalDate.now().plusMonths(monthsToAdd)
    val expiryDate = expiry.format(formatter)
    expiryDate
  }

  def calculatedExpiryDateReformatted(monthsToAdd: Int): String = {
    val formatter  = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val expiry     = LocalDate.now().plusMonths(monthsToAdd).plusDays(1)
    val expiryDate = expiry.format(formatter)
    expiryDate
  }

  def reserveExpiryDateMonths(): String =
    vXReserveListTotalLength match {
      case "3 Months"  => calculatedExpiryDates(3)
      case "6 Months"  => calculatedExpiryDates(6)
      case "12 Months" => calculatedExpiryDates(12)
      case "15 Months" => calculatedExpiryDates(15)
      case "18 Months" => calculatedExpiryDates(18)
      case "21 Months" => calculatedExpiryDates(21)
      case "24 Months" => calculatedExpiryDates(24)
      case _           => throw new IllegalStateException("Invalid reserve period!")
    }

  def reserveExpiryDateReformatted(): String =
    vXReserveListTotalLength match {
      case "3 Months"  => calculatedExpiryDateReformatted(3)
      case "6 Months"  => calculatedExpiryDateReformatted(6)
      case "12 Months" => calculatedExpiryDateReformatted(12)
      case "15 Months" => calculatedExpiryDateReformatted(15)
      case "18 Months" => calculatedExpiryDateReformatted(18)
      case "21 Months" => calculatedExpiryDateReformatted(21)
      case "24 Months" => calculatedExpiryDateReformatted(24)
      case _           => throw new IllegalStateException("Invalid reserve period!")
    }
}
