package uk.gov.co.test.ui.pages

import org.openqa.selenium._
import org.openqa.selenium.support.ui.ExpectedConditions.{elementToBeClickable, visibilityOfElementLocated}
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions, WebDriverWait}
import org.scalactic.source.Position
import org.scalatest.concurrent.Eventually.eventually
import org.scalatest.concurrent.PatienceConfiguration
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatestplus.selenium.{Page, WebBrowser}

import java.util.UUID
import scala.collection.JavaConverters._
import scala.util.Random

case class PageNotFoundException(s: String) extends Exception(s)

trait BasePage extends Matchers with Page with WebBrowser with PatienceConfiguration {
  override implicit val patienceConfig: PatienceConfig =
    PatienceConfig(timeout = scaled(Span(20, Seconds)), interval = scaled(Span(1000, Millis)))

  def onPage(pageTitle: String)(implicit webDriver: WebDriver): Unit =
    if (webDriver.getTitle != pageTitle)
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '${webDriver.getTitle}' page."
      )

  def waitForElementToBeClickableByPath(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 2, 200)
    wait.until(elementToBeClickable(By.xpath(pathway)))
  }

  def waitForVisibilityOfElementByPath(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 15, 200)
    wait.until(visibilityOfElementLocated(By.xpath(pathway)))

  }

  def waitForVisibilityOfElementByPathLast(pathway: String)(implicit webDriver: WebDriver): WebElement =
    eventually {
      webDriver.findElements(By.xpath(pathway)).asScala.last
    }

  def waitForElementClickableByPath(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 2, 200)
    wait.until(elementToBeClickable(By.xpath(pathway)))
  }

  def waitForElementClickableByTag(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 2, 200)
    wait.until(elementToBeClickable(By.tagName(pathway)))
  }

  def waitForVisibilityOfElementById(id: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 2, 200)
    wait.until(visibilityOfElementLocated(By.id(id)))
  }

  def waitForVisibilityOfElement(ele: By)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 2, 200)
    wait.until(visibilityOfElementLocated(ele))
  }

  def waitForElementToBeClickableByLink(optionName: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 2, 200)
    wait.until(visibilityOfElementLocated(By.linkText(optionName)))
  }

  def waitForElementToBeClickableByLabel(id: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 2, 200)
    //Wait for element to be clickable
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//label[@for='$id']")))
  }

  override def radioButton(id: String)(implicit driver: WebDriver, pos: Position): RadioButton = {
    waitForElementToBeClickableByLabel(id)
    val radioButton = super.radioButton(id)
    radioButton
  }

  def clickOnRadioButton(id: String)(implicit webDriver: WebDriver): Boolean = {
    val wait   = new WebDriverWait(webDriver, 2, 200)
    val lookup = By.id(id)
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//label[@for='$id']")))

    wait.until(new ExpectedCondition[Boolean]() {
      def apply(webDriver: WebDriver): Boolean = {
        val radio = webDriver.findElement(lookup)
        val rval  = radio.isSelected && radio.isEnabled
        if (!rval) radio.click()
        rval
      }
    })
  }

  def uuid4: String = UUID.randomUUID.toString

  def scrollToElement(webElement: By)(implicit webDriver: WebDriver): AnyRef = {
    val jse: JavascriptExecutor = webDriver.asInstanceOf[JavascriptExecutor]
    jse.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(webElement))
  }

  def selectDropdownOption(webElement: By)(implicit webDriver: WebDriver): AnyRef = {
    val jse: JavascriptExecutor = webDriver.asInstanceOf[JavascriptExecutor]
    jse.executeScript("arguments[0].click();", webDriver.findElement(webElement))
  }

  def randNumbers(howManyNos: Integer): String =
    Seq.fill(howManyNos)(Random.nextInt(9)).mkString

  def selectOption(enterText: String, addOption: String)(implicit driver: WebDriver): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(enterText)
    selectOption.sendKeys(addOption)
    selectOption.sendKeys(Keys.ENTER)
  }

}
