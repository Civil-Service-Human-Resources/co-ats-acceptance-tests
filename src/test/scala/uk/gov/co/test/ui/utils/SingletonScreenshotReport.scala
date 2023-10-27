package uk.gov.co.test.ui.utils

import org.apache.commons.io.FileUtils
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}

import java.io.{File, IOException}
import scala.collection.mutable.ListBuffer

object SingletonScreenshotReport extends ScreenshotsReport

case class Screenshot(testName: String, pageUrl: String, filePath: String)

class ScreenshotsReport {
  private val SCREENSHOTS_DIR = "target/screenshots"
  private val screenshots     = new ListBuffer[Screenshot]()

  def takeScreenshot(driver: WebDriver, testName: String): Unit = {
    val pageUrl  =
      try driver.getCurrentUrl
      catch { case e: Exception => "unknown" }
    val filePath = s"${testName.replaceAll("\\s+", "_")}.png"
    screenshots += Screenshot(testName, pageUrl, filePath)
    try {
      val srcFile: File = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
      FileUtils.copyFile(srcFile, new File(s"$SCREENSHOTS_DIR/$filePath"))
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

  def publishReport(): Unit = {
    def image(src: String): String = s"""<img src="./$src" width="50%" style="border: solid 1px black;"/>"""
    val body: String               = if (screenshots.isEmpty) {
      "<div>No screenshots taken during test run</div>"
    } else {
      screenshots
        .map(s => s"""<h2>${s.testName}</h2><div><div>Browser at URL: ${s.pageUrl}</div>${image(s.filePath)}</div>""")
        .mkString("\n")
    }
    val html                       = s"<html><body><h1>Screenshots</h1>$body</body></html>"
    FileUtils.write(new File(s"$SCREENSHOTS_DIR/index.html"), html, "UTF-8")
  }

  def clearReportDirectory(): Unit = {
    val file = new File(SCREENSHOTS_DIR)
    if (file.isDirectory)
      Option(file.listFiles).map(_.toList).getOrElse(Nil).foreach(_.delete)
  }
}
