package uk.gov.co.test.ui.webdriver

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.{Capabilities, MutableCapabilities, WebDriver}

object SingletonDriver extends Driver

class Driver extends LazyLogging {
  private var instanceOption: Option[WebDriver] = None

  /*
   * Returns a WebDriver instance if already instantiated.  If no WebDriver instance is available, then one is instantiated
   * based on the value of the 'browser' system property.   Consumers of this method may also wish to provide their own 'customOptions'
   * rather than rely on the default browser options in this library.  Custom options will override the default options in this
   * library.
   */
  def getInstance(customOptions: Option[MutableCapabilities] = None): WebDriver = {
    if (instanceOption.isDefined && instanceOption.get.asInstanceOf[RemoteWebDriver].getSessionId == null)
      instanceOption = None

    instanceOption getOrElse initialiseBrowser(customOptions)
  }

  private def initialiseBrowser(customOptions: Option[MutableCapabilities]): WebDriver = {
    val browser: Option[String] = sys.props.get("browser").map(_.toLowerCase)
    val driver                  = new BrowserFactory().createBrowser(browser, customOptions)
    instanceOption = Some(driver)
    logDriverCapabilities(driver)
    driver
  }

  /*
   * Closes the browser and clears instanceOption
   */
  def closeInstance(): Unit =
    instanceOption foreach { instance =>
      instance.quit()
      instanceOption = None
    }

  private def logDriverCapabilities(driver: WebDriver): Unit = {
    val capabilities: Capabilities = driver.asInstanceOf[RemoteWebDriver].getCapabilities
    val browserType                = capabilities.getBrowserName
    logger.info(s"Browser Name: $browserType")
    logger.info(s"Browser Version: ${capabilities.getVersion}")

    browserType match {
      case "chrome"  => logger.info(s"Driver Version: ${capabilities.getCapability("chrome")}")
      case "firefox" => logger.info(s"Driver Version: ${capabilities.getCapability("moz:geckodriverVersion")}")
      case _         => logger.info(s"Browser Capabilities: $capabilities")
    }
  }
}
