package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{applicationId, randomEmail, randomPassword, v9RunInWelsh, vacancyId}

import scala.collection.mutable
import scala.jdk.CollectionConverters._
import scala.util.control.Breaks.{break, breakable}

object ApplicationsPage extends CivilServiceJobsBasePage {

  val applicationsPageTitle    = "Applications - Civil Service Jobs - GOV.UK"
  val welshApplicationsPageTitle    = "Ceisiadau - Civil Service Jobs - GOV.UK"
  val applicationLinkPath      = ".//a[@title='Applications']"
  val welshApplicationLinkPath = ".//a[@title='Ceisiadau']"
  val applicationTableAreaPath = ".//*[@id='DataTables_Table_0']/tbody"

  def applicationsPageCheck(): Unit = {
    if (v9RunInWelsh) eventually(onPage(welshApplicationsPageTitle)) else eventually(onPage(applicationsPageTitle))
  }

  def navigateToApplicationsPage(): Unit = {
    if (v9RunInWelsh) waitForVisibilityOfElementByPath(welshApplicationLinkPath).click()
    else waitForVisibilityOfElementByPath(applicationLinkPath).click()
    applicationsPageCheck()
  }

  def tableArea(): WebElement =
    waitForVisibilityOfElement(By.xpath(applicationTableAreaPath))

  def summaryRows(): mutable.Buffer[WebElement] =
    tableArea().findElements(By.xpath("//tbody//tr")).asScala

  def referenceRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[1]"))

  def applicationIdRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[2]"))

  def titleRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[3]"))

  def statusRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[4]"))

  def departmentRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[5]"))

  def closingDateRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[6]"))

  def lastUpdateRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[7]"))

  def actionRowItem(rowItem: WebElement): WebElement =
    rowItem.findElement(By.xpath("td[8]//a[@class='subject']"))

  def applicationsValues(): (String, String, String, String, String, String, String, WebElement) = {
    var _reference: String        = ""
    var _applicationId: String    = ""
    var _title: String            = ""
    var _status: String           = ""
    var _department: String       = ""
    var _closingDate: String      = ""
    var _lastUpdate: String       = ""
    var _reviewUpdate: WebElement = null
    val rows                      = summaryRows()
    breakable(
      for (row <- rows) {
        val q = referenceRowItem(row)
        if (q.getText == vacancyId) {
          _reference = referenceRowItem(row).getText
          _applicationId = applicationIdRowItem(row).getText
          _title = titleRowItem(row).getText
          _status = statusRowItem(row).getText
          _department = departmentRowItem(row).getText
          _closingDate = closingDateRowItem(row).getText
          _lastUpdate = lastUpdateRowItem(row).getText
          _reviewUpdate = actionRowItem(row)
          break()
        }
      }
    )
    (_reference, _applicationId, _title, _status, _department, _closingDate, _lastUpdate, _reviewUpdate)
  }

  def referenceValue(): String = {
    val (_reference, _, _, _, _, _, _, _) = applicationsValues()
    _reference
  }

  def applicationIdValue(): String = {
    val (_, _applicationId, _, _, _, _, _, _) = applicationsValues()
    _applicationId
  }

  def titleValue(): String = {
    val (_, _, _title, _, _, _, _, _) = applicationsValues()
    _title
  }

  def statusValue(): String = {
    val (_, _, _, _status, _, _, _, _) = applicationsValues()
    _status
  }

  def departmentValue(): String = {
    val (_, _, _, _, _department, _, _, _) = applicationsValues()
    _department
  }

  def closingDateValue(): String = {
    val (_, _, _, _, _, _closingDate, _, _) = applicationsValues()
    _closingDate
  }

  def lastUpdateValue(): String = {
    val (_, _, _, _, _, _, _lastUpdate, _) = applicationsValues()
    _lastUpdate
  }

  def reviewUpdateValue(): WebElement = {
    val (_, _, _, _, _, _, _, _reviewUpdate) = applicationsValues()
    _reviewUpdate
  }

  def extractApplicationInfo(): Unit = {
    navigateToApplicationsPage()
    applicationId = applicationIdValue()
    println("===============================================")
    println(s"Candidate Email: $randomEmail")
    println(s"Candidate Password: $randomPassword")
    println(s"Vacancy ID: $vacancyId")
    println(s"Application ID: $applicationId")
    println("===============================================")
    if (v9RunInWelsh) statusValue() shouldEqual "Cais yn mynd yn ei flaen"
    else statusValue() shouldEqual "Application in progress"
    reviewUpdateValue().click()
  }

  def navigateToApplicationCentrePage(): Unit =
    if (driver.getTitle == applicationsPageTitle) {
      reviewUpdateValue().click()
    } else {
      navigateToApplicationsPage()
      if (v9RunInWelsh) eventually(statusValue() shouldEqual "Cais wedi'i dderbyn")
      else eventually(statusValue() shouldEqual "Application received")
      reviewUpdateValue().click()
    }

  def confirmStatusOnApplicationPage(currentStatus: String): Unit = {
    navigateToApplicationsPage()
    applicationsPageCheck()
    statusValue() shouldEqual currentStatus
    reviewUpdateValue().click()
  }

  def reviewUpdateOnApplicationPage(): Unit = {
    waitForVisibilityOfElementByPath(applicationLinkPath).click()
    applicationsPageCheck()
    reviewUpdateValue().click()
  }

}
