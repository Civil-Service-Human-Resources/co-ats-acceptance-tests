package uk.gov.co.test.ui.pages.v9

import org.openqa.selenium.{By, WebElement}

object ApplicationCentrePage extends CivilServiceJobsBasePage {

  val applicationCentreTitle = "Application Centre - Civil Service Jobs - GOV.UK"

  def advertDetailsFunction(): WebElement =
    driver.findElement(By.xpath(".//input[@value='Advert Details']"))

  def withdrawApplicationFunction(): WebElement =
    driver.findElement(By.xpath(".//input[@value='Advert Details']"))

  def helpWithSelectionText(): String =
    driver.findElement(By.tagName("b")).getText

}
