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
import uk.gov.co.test.ui.flows.v9.LoginCandidateFlow.loginNewCandidate
import uk.gov.co.test.ui.pages.v9.SignInPage.signOut

import java.util
import java.util.UUID
import scala.jdk.CollectionConverters._
import scala.util.Random

case class PageNotFoundException(s: String) extends Exception(s)

trait BasePage extends Matchers with Page with WebBrowser with PatienceConfiguration {

  def currentWindows()(implicit driver: WebDriver): util.Set[String] = driver.getWindowHandles
  def firstWindowHandle()(implicit driver: WebDriver): String        = currentWindows.asScala.head
  def secondWindowHandle()(implicit driver: WebDriver): String       = currentWindows.asScala.tail.head
  def importFilesPath: String                                        = "/src/test/resource/import/"

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

  def waitForVisibilityOfStatusElementByPath(pathway: String)(implicit driver: WebDriver): WebElement = {
    val wait = new WebDriverWait(driver, 10, 200)
    wait.until(visibilityOfElementLocated(By.xpath(pathway)))
  }

  def checkForNewValuePath(statusPath: String, expectedStatus: String)(implicit driver: WebDriver): Unit = {
    val wait = new WebDriverWait(driver, 25, 500)
    try wait.until { (d: WebDriver) =>
      d.findElement(By.xpath(statusPath)).getText.endsWith(expectedStatus)
    } catch {
      case staleError: StaleElementReferenceException => println(staleError)
    }
  }

  def checkForNewValueId(valueId: String, expectedValue: String)(implicit driver: WebDriver): Unit = {
    val wait = new WebDriverWait(driver, 25, 500)
    try wait.until { (d: WebDriver) =>
      d.findElement(By.id(valueId)).getText.startsWith(expectedValue)
    } catch {
      case staleError: StaleElementReferenceException => println(staleError)
    }
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

  def waitForVisibilityOfElementAlertByPath()(implicit driver: WebDriver): Alert = {
    val wait = new WebDriverWait(driver, 30, 200)
    wait.until(ExpectedConditions.alertIsPresent())
  }

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
    val wait   = new WebDriverWait(webDriver, 10, 200)
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

  def radioClick(id: String)(implicit driver: WebDriver): Unit =
    driver.findElement(By.xpath(s".//*[@id='$id']")).click()

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
    selectOption.clear()
    selectOption.sendKeys(addOption)
    selectOption.sendKeys(Keys.ENTER)
  }

  def selectOptionFromList(inputField: String, addOption: String)(implicit driver: WebDriver): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(inputField)
    selectOption.sendKeys(addOption)
    selectOption.sendKeys(Keys.ENTER)
  }

  def selectOptionWithId(id: String, enterText: String)(implicit driver: WebDriver): Unit = {
    val selectOption = waitForVisibilityOfElementById(id)
    selectOption.clear()
    selectOption.sendKeys(enterText)
    selectOption.sendKeys(Keys.ENTER)
  }

  def find(by: By)(implicit driver: WebDriver): Any = driver.findElement(by)

  def findAll(by: By)(implicit driver: WebDriver): Any = driver.findElements(by)

  def openWindows(expectedNumberOfWindows: Int)(implicit driver: WebDriver): Boolean = {
    val wait = new WebDriverWait(driver, 10, 200)
    wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows))
  }

  def switchToOtherWindow()(implicit driver: WebDriver): Unit =
    if (driver.getWindowHandles.size() == 2) {
      if (driver.getWindowHandle.contains(secondWindowHandle)) {
        driver.switchTo().window(firstWindowHandle)
      } else if (driver.getWindowHandle.contains(firstWindowHandle)) {
        driver.switchTo().window(secondWindowHandle)
      }
    } else {
      openAndMoveToNewWindow()
    }

  def openNewTabWithJavascript()(implicit driver: WebDriver): AnyRef = {
    val jse: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
    jse.executeScript("window.open()")
  }

  def openAndMoveToNewWindow()(implicit driver: WebDriver): Unit = {
    openNewTabWithJavascript()
    for (chartWindow <- driver.getWindowHandles.asScala)
      driver.switchTo.window(chartWindow)
  }

  def refreshPage()(implicit driver: WebDriver): Unit =
    driver.navigate().refresh()

  def searchFunction(eleId: String)(implicit driver: WebDriver): util.List[WebElement] =
    driver.findElements(By.id(eleId))

  def attachDocuments(attachId: String, file: String)(implicit driver: WebDriver): Unit = {
    val getCurrentDirectory     = new java.io.File(".").getCanonicalPath
    val filePath                = getCurrentDirectory.concat(importFilesPath).concat(file)
    val fileElement: WebElement = id(attachId).findElement.get.underlying
    fileElement.sendKeys(filePath)
  }

  def changeSystem(system: String)(implicit driver: WebDriver): Unit = {
    if (!currentUrl.contains(system)) {
      switchToOtherWindow()
      if (currentUrl.contains("candidate") && !signOut().isDisplayed)
        loginNewCandidate()
    }
    refreshPage()
  }
}
