package uk.gov.co.test.ui.webdriver

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions}
import org.openqa.selenium.remote.{DesiredCapabilities, LocalFileDetector, RemoteWebDriver}
import org.openqa.selenium.{MutableCapabilities, WebDriver}

import java.net.URL
import scala.collection.JavaConverters._

class BrowserFactory extends LazyLogging {

  private val defaultSeleniumHubUrl: String                    = "http://localhost:4444/wd/hub"
  private val enableProxyForLocalhostRequestsInFirefox: String = "network.proxy.allow_hijacking_localhost"

  /*
   * Returns a specific WebDriver instance based on the value of the browserType String and the customOptions passed to the
   * function.  An exception is thrown if the browserType string value is not set or not recognised.  If customOptions are
   * passed to this function they will override the default settings in this library.
   */
  def createBrowser(browserType: Option[String], customOptions: Option[MutableCapabilities]): WebDriver =
    browserType match {
      case Some("chrome")          => chromeInstance(chromeOptions(customOptions))
      case Some("firefox")         => firefoxInstance(firefoxOptions(customOptions))
      case Some("remote-chrome")   => remoteWebdriverInstance(chromeOptions(customOptions))
      case Some("remote-firefox")  => remoteWebdriverInstance(firefoxOptions(customOptions))
      case Some("browserstack")    => browserStackInstance()
      case Some("headless-chrome") => headlessChromeInstance(chromeOptions(customOptions))
      case Some(browser)           =>
        throw BrowserCreationException(
          s"'browser' property '$browser' not supported by " +
            s"the webdriver-factory library."
        )
      case None                    =>
        throw BrowserCreationException("'browser' property is not set, this is required to instantiate a Browser")
    }

  private def chromeInstance(options: ChromeOptions): WebDriver =
    new ChromeDriver(options)

  private def headlessChromeInstance(options: ChromeOptions): WebDriver = {
    options.addArguments("headless")
    new ChromeDriver(options)
  }

  /*
   * Silences Firefox's logging when running locally with driver binary.  Ensure that the browser starts maximised.
   */
  private def firefoxInstance(options: FirefoxOptions): WebDriver = {
    System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null")
    val driver = new FirefoxDriver(options)
    driver.manage().window().maximize()
    driver
  }

  private def remoteWebdriverInstance(options: MutableCapabilities): WebDriver = {
    val driver: RemoteWebDriver = new RemoteWebDriver(new URL(defaultSeleniumHubUrl), options)
    driver.setFileDetector(new LocalFileDetector)
    driver
  }

  private[webdriver] def chromeOptions(customOptions: Option[MutableCapabilities]): ChromeOptions =
    customOptions match {
      case Some(options) =>
        val userOptions = options.asInstanceOf[ChromeOptions]
        userOptions
      case None          =>
        val defaultOptions = new ChromeOptions()
        defaultOptions.addArguments("start-maximized")
        // `--use-cmd-decoder` and `--use-gl` are added as a workaround for slow test duration in chrome 85 and higher (PBD-822)
        // Can be reverted once the issue is fixed in the future versions of Chrome.
        defaultOptions.addArguments("--use-cmd-decoder=validating")
        defaultOptions.addArguments("--use-gl=desktop")
        defaultOptions.addArguments("--disable-gpu")
        defaultOptions.addArguments("--disable-extensions")
        defaultOptions.addArguments("--no-sandbox")
        defaultOptions.addArguments("--disable-dev-shm-usage")
        defaultOptions.addArguments("--incognito")

        defaultOptions.setExperimentalOption("excludeSwitches", List("enable-automation").asJava)
//        defaultOptions.setExperimentalOption("useAutomationExtension", false)
        defaultOptions
    }

  private[webdriver] def firefoxOptions(customOptions: Option[MutableCapabilities]): FirefoxOptions =
    customOptions match {
      case Some(options) =>
        val userOptions = options.asInstanceOf[FirefoxOptions]
        userOptions
      case None          =>
        val defaultOptions = new FirefoxOptions()
        defaultOptions.setAcceptInsecureCerts(true)
        defaultOptions.addPreference(enableProxyForLocalhostRequestsInFirefox, true)
        defaultOptions
    }

  /*
   * The tests can be ran using browserstack with different capabilities passed from the command line. e.g -Dbrowserstack.version="firefox" and this allows a flexibility to test using different configs to override the default browserstack values.
   * An exception will be thrown if username or key is not passed.
   */
  def browserStackInstance(): WebDriver = {
    val username           = sys.props.getOrElse(
      "browserstack.username",
      throw new Exception("browserstack.username is required. Enter a valid username")
    )
    val automateKey        =
      sys.props.getOrElse("browserstack.key", throw new Exception("browserstack.key is required. Enter a valid key"))
    val browserStackHubUrl = s"http://$username:$automateKey@hub.browserstack.com/wd/hub"

    val desiredCaps = new DesiredCapabilities()
    desiredCaps.setCapability("browserstack.debug", "true")
    desiredCaps.setCapability("browserstack.local", "true")

    val properties: Map[String, String] =
      sys.props.toMap[String, String].filter(key => key._1.startsWith("browserstack") && key._2 != "")

    properties.map(x => (x._1.replace("browserstack.", ""), x._2.replace("_", " ")))
    properties
      .foreach(x => desiredCaps.setCapability(x._1.replace("browserstack.", ""), x._2.replace("_", " ")))

    new RemoteWebDriver(new URL(browserStackHubUrl), desiredCaps)
  }
}
case class BrowserCreationException(message: String) extends RuntimeException(message)
