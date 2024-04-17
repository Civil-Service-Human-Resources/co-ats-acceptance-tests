package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.{Seq, mutable}
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

object HistoryTab extends VacancyBasePage {

  val historyTabPath = ".//span[@class='main-label' and text() = 'History']"

  def reserveScheduleDetails(): String = {
    val reserveSchedulePath = s"(//*[@class='detail-grid-tl'])[1]"
    val scheduleDate        = waitForVisibilityOfElementByPath(reserveSchedulePath).getText
    scheduleDate
  }

  def reserveEmailDetails(position: String): String = {
    val reserveEmailDestinationPath = s"//table[@class='display email_information']/tbody/tr[$position]/td"
    val emailValue                  = waitForVisibilityOfElementByPath(reserveEmailDestinationPath).getText
    emailValue
  }

  def HistoryArea(): WebElement =
    xpath(s"//*[@class='day']").element.underlying

  def summaryRows(): mutable.Buffer[WebElement] =
    HistoryArea().findElements(By.className("time-object")).asScala

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
        if (d.getText.contains(category)) {
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

  def tableArea(): WebElement =
    waitForVisibilityOfElementByPath("//table[@class='display email_information']/tbody/tr[1]/td")

  def summaryEmailRows(): Seq[WebElement] =
    tableArea().findElements(By.xpath("/tbody")).asScala

  def firstEmailRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("/tr[1]/td"))

  def secondEmailRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("/tr[2]/td"))

  def thirdEmailRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("/tr[3]/td"))

  def fourthEmailRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("/tr[4]/td"))

  def fifthEmailRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("//..//..//..//span[@class='email_preview ']//tr[2]"))

  def historyEmailValues(templateId: String): (String, String, String, String) = {
    var _destination: String  = ""
    var _subject: String      = ""
    var _status: String       = ""
    var _emailPreview: String = ""
    val rows                  = summaryEmailRows()
    breakable(
      for (row <- rows) {
        val d = firstEmailRowItem(row)
        println(firstEmailRowItem(row).getText)
        if (d.getText == templateId) {
          _destination = secondEmailRowItem(row).getText
          _subject = thirdEmailRowItem(row).getText
          _status = fourthEmailRowItem(row).getText
          _emailPreview = fifthEmailRowItem(row).getText
          println(secondEmailRowItem(row).getText)
          println(thirdEmailRowItem(row).getText)
          println(fourthEmailRowItem(row).getText)
          println(fifthEmailRowItem(row).getText)
          break()
        }
      }
    )
    (_destination, _subject, _status, _emailPreview)
  }

  def emailChecks(i: String): Unit = {
    val subjectSummary = "(//*[@class='detail-grid-tl'])"
    val subject        = driver.findElement(By.xpath(s"$subjectSummary[$i]")).getText
    println(subject)
  }

  def emailHistoryChecks(): Unit = {
    waitForVisibilityOfElementByPath(historyTabPath).click()
    waitForVisibilityOfElementById("summary_tabs_history_tab").isDisplayed
//    waitForVisibilityOfElementByPath("//*[@class='ng-input']").sendKeys("Email")
//    waitForVisibilityOfElementByPath("//*[@class='ng-input']").sendKeys(Keys.ENTER)
    waitForVisibilityOfElementByPath("//*[@class='ng-input']").click()
    action().moveToElement(waitForDropdownHistoryOptionByText("a41f1fe7ade6-6")).perform()
    waitForDropdownHistoryOptionByText("a41f1fe7ade6-6").click()
    for (i <- 1 to 5) emailChecks(i.toString) should not be "Subject: Start Civil Service Employee Transfer Process"
  }
}
