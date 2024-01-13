package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.{By, Keys, WebElement}
import uk.gov.co.test.ui.data.TestData.eventually
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.collection.mutable
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

object ExternalPostingsTab extends VacancyBasePage {

  private lazy val externalPostingsTabId   = "oppTabs_external_posting"
  private lazy val addButtonPath           = ".//*[@class='btn btn-default ajax']"
  private lazy val editButtonPath          = ".//*[@class='btn btn-default ']"
  private lazy val destinationId           = "select2-external_posting_form_destination_class_id-container"
  private lazy val postToCsJobsOptionPath  = ".//li[@title='Post to Civil Service Jobs']"
  private lazy val editPostDestinationPath = ".//a[text()='Edit']"
  private lazy val nextStep2PostingId      = "external_posting_form_form_submit"
  private lazy val nextStep3PostingId      = "external_posting_form_step3_form_submit"
  private lazy val nextCompletePostingId   = "external_posting_complete_form_submit"
  private lazy val destinationType         = "PostingDestination::ExternalVx"
  private lazy val postingSubHeaderPath    = ".//*[@id='externalpostings_container']/h2"
  private lazy val externalPostLiveDateId  = "external_posting_form_live_date"

  private def newPostingHeader: String = {
    val header = waitForVisibilityOfElementByPath(postingSubHeaderPath).getText
    header
  }

  private def selectExternalPostingsTab(): Unit = {
    val tab = waitForVisibilityOfElementById(externalPostingsTabId)
    tab.click()
  }

  private def addPosting(): Unit = {
    val add = waitForElementClickableByPath(addButtonPath)
    add.isEnabled
    add.click()
  }

  private def editPosting(): Unit = {
    waitForVisibilityOfElementByPath(".//tr[@tabindex='-1'][1]").click()
    val edit = waitForVisibilityOfElementByPath(editButtonPath)
    edit.isEnabled
    edit.click()
  }

  private def selectDestination(option: String = "Post to Civil Service Jobs"): Unit = {
    waitForVisibilityOfElementById(destinationId).click()
    action().moveToElement(waitForDropdownOption(option)).perform()
    waitForDropdownOption(option).click()
  }

  def tableArea(): WebElement =
    waitForVisibilityOfElement(By.xpath(".//*[@id='external_postings_dt']/tbody"))

  def summaryRows(): mutable.Buffer[WebElement] =
    tableArea().findElements(By.xpath(".//tr[@tabindex='-1'][1]")).asScala

  def firstRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[1]"))

  def secondRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[2]"))

  def thirdRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[3]"))

  def fourthRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[4]"))

  def fifthRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[5]"))

  def postingTableValues(): (String, String, String, String) = {
    var _destination: String        = ""
    var _postingLiveDate: String    = ""
    var _postingClosingDate: String = ""
    var _postingStatus: String      = ""
    val rows                        = summaryRows()
    breakable(
      for (row <- rows) {
        val q = firstRowItem(row)
        if (q.getText == destinationType) {
          _destination = secondRowItem(row).getText
          _postingLiveDate = thirdRowItem(row).getText
          _postingClosingDate = fourthRowItem(row).getText
          _postingStatus = fifthRowItem(row).getText
          break()
        }
      }
    )
    (_destination, _postingLiveDate, _postingClosingDate, _postingStatus)
  }

  def destinationValue(): String = {
    val (_destination, _, _, _) = postingTableValues()
    _destination
  }

  def postingLiveDateValue(): String = {
    val (_, _postingLiveDate, _, _) = postingTableValues()
    _postingLiveDate
  }

  def postingClosingDateValue(): String = {
    val (_, _, _postingClosingDate, _) = postingTableValues()
    _postingClosingDate
  }

  def postingStatusDateValue(): String = {
    val (_, _, _, _postingStatus) = postingTableValues()
    _postingStatus
  }

  private def confirmPostingDetails(): Unit = {
    destinationValue()       shouldEqual "Post to Civil Service Jobs"
//    postingLiveDateValue()    shouldEqual "22 November 2023 at 22:55:00 GMT"
//    postingClosingDateValue() shouldEqual "22 December 2023 at 22:55:00 GMT"
    postingStatusDateValue() shouldEqual "Online"
  }

  def addExternalPosting(): Unit = {
    selectExternalPostingsTab()
    addPosting()
    selectDestination()
    waitForVisibilityOfElementById(nextStep2PostingId).click()
    waitForVisibilityOfElementById(nextStep3PostingId).click()
    waitForVisibilityOfElementById(nextCompletePostingId).click()
    confirmPostingDetails()
  }

  def changeLiveDate(newLiveDate: String, status: String): Unit = {
    waitForVisibilityOfElementById(externalPostLiveDateId).clear()
    waitForVisibilityOfElementById(externalPostLiveDateId).sendKeys(newLiveDate)
    waitForVisibilityOfElementById(externalPostLiveDateId).sendKeys(Keys.ENTER)
    waitForVisibilityOfElementById(nextStep2PostingId).click()
    eventually(postingStatusDateValue() shouldEqual status)
  }

  def repostExternalPosting(): Unit = {
    val formatter     = DateTimeFormatter.ofPattern("dd/MM/uuuu")
    val todayDate     = LocalDate.now().format(formatter)
    val yesterdayDate = LocalDate.now().minusDays(1).format(formatter)
    selectExternalPostingsTab()
    editPosting()
    val liveDate      = waitForVisibilityOfElementById(externalPostLiveDateId).getAttribute("value")
    if (liveDate <= todayDate) {
      val tomorrowDate = LocalDate.now().plusDays(2).format(formatter)
      changeLiveDate(tomorrowDate, "Offline")
      editPosting()
      changeLiveDate(yesterdayDate, "Online")
    } else if (liveDate > todayDate) {
      changeLiveDate(yesterdayDate, "Online")
    }
  }
}
