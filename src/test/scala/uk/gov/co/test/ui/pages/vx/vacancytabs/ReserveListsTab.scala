package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{applicationId, preferredFirstName, randomEmail, vXJobInfoDepartment, vXReserveExtendLength, vXReserveExtendRequired, vXReserveListLength, vXReserveListTotalLength, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.vacancytabs.HistoryTab.{historyTabPath, reserveEmailDetails, reserveScheduleDetails}

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object ReserveListsTab extends VacancyBasePage {

  var reserveListFormId: String                   = ""
  private lazy val reserveExpiryListTabPath       = ".//span[@class='main-label' and text() = 'Reserve List - Expiry Dates']"
  private lazy val reserveListLengthHeaderPath    = "(//h4)[7]"
  private lazy val reserveExpiryListHeaderPath    = "(//h4)[8]"
  private lazy val reserveListLengthSubHeaderPath = "(//*[@class='form_row form_label hform_label'])[2]"
  private lazy val historySectionId               = "summary_tabs_history_tab"
  private lazy val reserveExpiryScheduledDatePath      = "(//*[@class='detail-grid-tl'])[1]"
  private lazy val reserveListExpiryEmail         = "(//*[@class='detail-grid-tl'])[3]"
  private lazy val reserveListExpiryEmailSeeMore  = "(//*[@class='detail-grid-tr'])[3]//a"
  private lazy val reserveListExpiryEmailPreview  = "//*[@class='email_preview ']//tbody/tr[2]"
  def currentReserveListLengthId                  = s"${reserveListFormId}_label_121022_1"
  def currentReserveExtendListLengthId            = s"${reserveListFormId}_label_205614_1"
  def reserveList3MonthsExpiryId                  = s"${reserveListFormId}_field_121032_1"
  def reserveList6MonthsExpiryId                  = s"${reserveListFormId}_field_121036_1"
  def reserveList9MonthsExpiryId                  = s"${reserveListFormId}_field_121040_1"
  def reserveList12MonthsExpiryId                 = s"${reserveListFormId}_field_121044_1"
  def reserveList15MonthsExpiryId                 = s"${reserveListFormId}_field_176823_1"
  def reserveList18MonthsExpiryId                 = s"${reserveListFormId}_field_176826_1"
  def reserveList21MonthsExpiryId                 = s"${reserveListFormId}_field_176829_1"
  def reserveList24MonthsExpiryId                 = s"${reserveListFormId}_field_176833_1"
  def reserveList12MonthsAnd2WeeksExpiryId        = s"${reserveListFormId}_field_205651_1"
  def reserveList12MonthsAnd4WeeksExpiryId        = s"${reserveListFormId}_field_205654_1"
  def reserveList12MonthsAnd6WeeksExpiryId        = s"${reserveListFormId}_field_205657_1"
  def reserveList12MonthsAnd8WeeksExpiryId        = s"${reserveListFormId}_field_205660_1"

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

  def reserveListExpiryChecks(): Unit = {
    selectReserveExpiryListTab()
    checkReserveHeader(reserveListLengthHeaderPath, "Reserve list length")
    checkReserveHeader(
      reserveListLengthSubHeaderPath,
      "To extend the reserve list please update the vacancy form (max length 12 months)"
    )
    checkReserveHeader(
      reserveExpiryListHeaderPath,
      "Reserve list expiry dates (auto-populated when the candidate first enters the Reserve List status)"
    )
    checkReserveValue(currentReserveListLengthId, s"Current reserve list length  \n$vXReserveListLength")
    if (vXReserveExtendRequired) {
      checkReserveValue(
        currentReserveExtendListLengthId,
        s"Length of reserve list extension (beyond 12 months)  \n$vXReserveExtendLength "
      )
    }
    checkReserveValue(reserveList3MonthsExpiryId, s"3 months expiry date  \n${calculatedExpiryDates(3)}")
    checkReserveValue(reserveList6MonthsExpiryId, s"6 months expiry date  \n${calculatedExpiryDates(6)}")
    checkReserveValue(reserveList9MonthsExpiryId, s"9 months expiry date  \n${calculatedExpiryDates(9)}")
    checkReserveValue(reserveList12MonthsExpiryId, s"12 months expiry date  \n${calculatedExpiryDates(12)}")
    if (vXReserveExtendRequired) {
      checkReserveValue(
        reserveList12MonthsAnd2WeeksExpiryId,
        s"12 months and 2 weeks expiry date  \n${calculatedExpiryDates(12, weeksToAdd = Some(2))}"
      )
      checkReserveValue(
        reserveList12MonthsAnd4WeeksExpiryId,
        s"12 months and 4 weeks expiry date  \n${calculatedExpiryDates(12, weeksToAdd = Some(4))}"
      )
      checkReserveValue(
        reserveList12MonthsAnd6WeeksExpiryId,
        s"12 months and 6 weeks expiry date  \n${calculatedExpiryDates(12, Some(6))}"
      )
      checkReserveValue(
        reserveList12MonthsAnd8WeeksExpiryId,
        s"12 months and 8 weeks expiry date  \n${calculatedExpiryDates(12, weeksToAdd = Some(8))}"
      )
    }
  }

  def reserveListHistoryProcessChecks(): Unit = {
    waitForVisibilityOfElementByPath(historyTabPath).click()
    waitForVisibilityOfElementById(historySectionId).isDisplayed
    val scheduleDate = reserveScheduleDetails()
    val scheduledFor = waitForVisibilityOfElementByPath(reserveExpiryScheduledDatePath).getText
    if (vXReserveExtendRequired) {
      scheduleDate should startWith(
        s"Process rule: Scheduled move - ${vXReserveListLength.toLowerCase} and $vXReserveExtendLength expiry date"
      )
    } else {
      scheduleDate should startWith(s"Process rule: Scheduled move - ${vXReserveListLength.toLowerCase} expiry date")
    }
    scheduledFor should include(s"${reserveExpiryDateReformatted()}")
  }

  def reserveListHistoryEmailChecks(): Unit = {
    waitForVisibilityOfElementByPath(
      reserveListExpiryEmail
    ).getText shouldEqual s"Subject: Application update - $vacancyName - $vacancyId"
    waitForVisibilityOfElementByPath(reserveListExpiryEmailSeeMore).click()
    val templateId   = reserveEmailDetails("1")
    val destination  = reserveEmailDetails("2")
    val subject      = reserveEmailDetails("3")
    val status       = reserveEmailDetails("4")
    val emailPreview = waitForVisibilityOfElementByPath(reserveListExpiryEmailPreview).getText
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
         |$vXJobInfoDepartment Recruitment Team""".stripMargin
  }

  private def extractTabFormId(): String = {
    val formClass = driver.findElement(By.xpath(".//form[@class='form-horizontal']"))
    reserveListFormId = formClass.getAttribute("id")
    reserveListFormId
  }

  private def calculatedExpiryDates(monthsToAdd: Int, weeksToAdd: Option[Int] = None): String = {
    val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
    if (weeksToAdd.isEmpty) {
      val expiry     = LocalDate.now().plusMonths(monthsToAdd)
      val expiryDate = expiry.format(formatter)
      expiryDate
    } else {
      val expiry     = LocalDate.now().plusMonths(monthsToAdd).plusWeeks(weeksToAdd.get)
      val expiryDate = expiry.format(formatter)
      expiryDate
    }
  }

  def calculatedExpiryDateReformatted(monthsToAdd: Int, weeksToAdd: Option[Int] = None): String = {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    if (weeksToAdd.isEmpty) {
      val expiry     = LocalDate.now().plusMonths(monthsToAdd).plusDays(1)
      val expiryDate = expiry.format(formatter)
      expiryDate
    } else {
      val expiry     = LocalDate.now().plusMonths(monthsToAdd).plusWeeks(weeksToAdd.get).plusDays(1)
      val expiryDate = expiry.format(formatter)
      expiryDate
    }
  }

  def reserveExpiryDateMonths(): String =
    vXReserveListTotalLength match {
      case "3 Months"            => calculatedExpiryDates(3)
      case "6 Months"            => calculatedExpiryDates(6)
      case "9 Months"            => calculatedExpiryDates(9)
      case "12 Months"           => calculatedExpiryDates(12)
      case "12 Months + 2 weeks" => calculatedExpiryDates(12, weeksToAdd = Some(2))
      case "12 Months + 4 weeks" => calculatedExpiryDates(12, weeksToAdd = Some(4))
      case "12 Months + 6 weeks" => calculatedExpiryDates(12, weeksToAdd = Some(6))
      case "12 Months + 8 weeks" => calculatedExpiryDates(12, weeksToAdd = Some(8))
      case _                     => throw new IllegalStateException("Invalid reserve period!")
    }

  def reserveExpiryDateReformatted(): String =
    vXReserveListTotalLength match {
      case "3 Months"            => calculatedExpiryDateReformatted(3)
      case "6 Months"            => calculatedExpiryDateReformatted(6)
      case "9 Months"            => calculatedExpiryDateReformatted(9)
      case "12 Months"           => calculatedExpiryDateReformatted(12)
      case "12 Months + 2 weeks" => calculatedExpiryDateReformatted(12, weeksToAdd = Some(2))
      case "12 Months + 4 weeks" => calculatedExpiryDateReformatted(12, weeksToAdd = Some(4))
      case "12 Months + 6 weeks" => calculatedExpiryDateReformatted(12, weeksToAdd = Some(6))
      case "12 Months + 8 weeks" => calculatedExpiryDateReformatted(12, weeksToAdd = Some(8))
      case _                     => throw new IllegalStateException("Invalid reserve period!")
    }
}
