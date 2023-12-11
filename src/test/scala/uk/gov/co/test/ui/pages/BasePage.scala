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
import scala.jdk.CollectionConverters._
import scala.util.Random

case class PageNotFoundException(s: String) extends Exception(s)

trait BasePage extends Matchers with Page with WebBrowser with PatienceConfiguration {

  var firstWindowHandle: String  = ""
  var secondWindowHandle: String = ""

  override implicit val patienceConfig: PatienceConfig =
    PatienceConfig(timeout = scaled(Span(30, Seconds)), interval = scaled(Span(1000, Millis)))

  def onPage(pageTitle: String)(implicit webDriver: WebDriver): Unit =
    if (webDriver.getTitle != pageTitle)
      throw PageNotFoundException(
        s"Expected '$pageTitle' page, but found '${webDriver.getTitle}' page."
      )

  def pageElement(path: String)(implicit driver: WebDriver): WebElement =
    driver.findElement(By.xpath(path))

  def waitForElementToBeClickableByPath(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(elementToBeClickable(By.xpath(pathway)))
  }

  def waitForVisibilityOfElementByPath(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(visibilityOfElementLocated(By.xpath(pathway)))

  }

  def waitForVisibilityOfElementByPathLast(pathway: String)(implicit webDriver: WebDriver): WebElement =
    eventually {
      webDriver.findElements(By.xpath(pathway)).asScala.last
    }

  def waitForElementClickableByPath(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(elementToBeClickable(By.xpath(pathway)))
  }

  def waitForElementClickableByTag(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(elementToBeClickable(By.tagName(pathway)))
  }

  def waitForVisibilityOfElementByTag(tag: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(visibilityOfElementLocated(By.tagName(tag)))
  }

  def waitForVisibilityOfElementById(id: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(visibilityOfElementLocated(By.id(id)))
  }

  "#collapse_panel > span.main_status.summary-collapse"

  def waitForVisibilityOfElement(ele: By)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(visibilityOfElementLocated(ele))
  }

  def waitForVisibilityOfElementCss(ele: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(visibilityOfElementLocated(By.cssSelector(ele)))
  }

  def waitForElementToBeClickableByLink(optionName: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(visibilityOfElementLocated(By.linkText(optionName)))
  }

  def waitForElementToBeClickableByLabel(id: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 30, 200)
    //Wait for element to be clickable
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s"//label[@for='$id']")))
  }

  override def radioButton(id: String)(implicit driver: WebDriver, pos: Position): RadioButton = {
    waitForElementToBeClickableByLabel(id)
    val radioButton = super.radioButton(id)
    radioButton
  }

  def radioSelect(id: String)(implicit driver: WebDriver): Unit =
    waitForVisibilityOfElementById(id).click()

  def clickOnRadioButton(id: String)(implicit webDriver: WebDriver): Boolean = {
    val wait   = new WebDriverWait(webDriver, 30, 200)
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

  def selectOption(inputField: String, addOption: String)(implicit driver: WebDriver): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(inputField)
    selectOption.sendKeys(addOption)
    selectOption.sendKeys(Keys.ENTER)
  }

  def selectOptionWithId(id: String, enterText: String)(implicit driver: WebDriver): Unit = {
    val selectOption = waitForVisibilityOfElementById(id)
    selectOption.sendKeys(enterText)
    selectOption.sendKeys(Keys.ENTER)
  }

  def find(by: By)(implicit driver: WebDriver): Any = driver.findElement(by)

  def findAll(by: By)(implicit driver: WebDriver): Any = driver.findElements(by)

  def openWindows(expectedNumberOfWindows: Int)(implicit driver: WebDriver): Boolean = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows))
  }

  def openNewWindow()(implicit driver: WebDriver): Unit = {
    //    openWindows(2)
    for (chartWindow <- driver.getWindowHandles.asScala) {
      driver.switchTo.window(chartWindow)
    }
    println(driver.getWindowHandles)
  }

  def openNewTabWithJavascript()(implicit driver: WebDriver): AnyRef = {
    val jse: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
    jse.executeScript("window.open()")
  }

  def openAndSaveWindows()(implicit driver: WebDriver): Unit = {
    openNewTabWithJavascript()
    openNewWindow()
  }

  def switchBackToWindow(windowName: String)(implicit driver: WebDriver): WebDriver =
    driver.switchTo().window(windowName)

  def switchToFirstWindow()(implicit driver: WebDriver): Unit = {
    switchBackToWindow(firstWindowHandle)
    refreshPage()
  }

  def switchToSecondWindow()(implicit driver: WebDriver): Unit = {
    switchBackToWindow(secondWindowHandle)
    refreshPage()
  }

  def refreshPage()(implicit driver: WebDriver): Unit =
    driver.navigate().refresh()

}
