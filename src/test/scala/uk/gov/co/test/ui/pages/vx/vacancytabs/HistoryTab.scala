package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

object HistoryTab extends VacancyBasePage {

  val historyTabPath = ".//span[@class='main-label' and text() = 'History']"

  def tableArea(): WebElement =
    waitForVisibilityOfElement(By.xpath("//*[@class='day']"))

  def summaryRows(): mutable.Buffer[WebElement] =
    tableArea().findElements(By.xpath("//*[@class='time-object']//*[@class='line']")).asScala

  def firstRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("//*[@class='category line-recruiter']"))

  def secondRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("//*[@class='detail']//*[@class='detail-grid-tl']"))

  def thirdRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("//*[@class='detail']//*[@class='detail-grid-tr']"))

  def historyValues(category: String): (String, WebElement) = {
    var _detail: String         = ""
    var _detailLink: WebElement = null
    val rows                    = summaryRows()
    breakable(
      for (row <- rows) {
        val d = firstRowItem(row)
        if (d.getText == category) {
          _detail = secondRowItem(row).getText
          _detailLink = thirdRowItem(row)
          break()
        }
      }
    )
    (_detail, _detailLink)
  }

  def categoryDetail(category: String): String = {
    val (_detail, _) = historyValues(category)
    _detail
  }

  def categoryDetailLink(category: String): WebElement = {
    val (_, _detailLink) = historyValues(category)
    _detailLink
  }

  def summaryEmailRows(): mutable.Buffer[WebElement] =
    tableArea().findElements(By.xpath("//*[@class='display email_information']//tr")).asScala

  def fourthRowEmailItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("/*[@class='display email_information']//tr[2]"))

  def fifthRowEmailItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("/*[@class='display email_information']//tr[3]"))

  def sixthRowEmailItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("/*[@class='display email_information']//tr[4]"))

  def seventhRowPreviewEmailItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("//*[@class='email_preview ']"))

  def historyEmailValues(category: String): (String, String, String, String) = {
    var _destination: String  = ""
    var _subject: String      = ""
    var _status: String       = ""
    var _emailPreview: String = ""
    val rows                  = summaryEmailRows()
    breakable(
      for (row <- rows) {
        val d = firstRowItem(row)
        if (d.getText == category) {
          _destination = fourthRowEmailItem(row).getText
          _subject = fifthRowEmailItem(row).getText
          _status = sixthRowEmailItem(row).getText
          _emailPreview = seventhRowPreviewEmailItem(row).getText
          break()
        }
      }
    )
    (_destination, _subject, _status, _emailPreview)
  }
}
