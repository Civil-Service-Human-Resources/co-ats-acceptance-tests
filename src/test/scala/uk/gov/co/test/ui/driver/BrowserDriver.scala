package uk.gov.co.test.ui.driver

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.WebDriver
import uk.gov.co.test.ui.webdriver.SingletonDriver

trait BrowserDriver extends LazyLogging {
  logger.info(
    s"Instantiating Browser: ${sys.props.getOrElse("browser", "'browser' System property not set. This is required")}"
  )

  implicit lazy val driver: WebDriver = SingletonDriver.getInstance()
}
