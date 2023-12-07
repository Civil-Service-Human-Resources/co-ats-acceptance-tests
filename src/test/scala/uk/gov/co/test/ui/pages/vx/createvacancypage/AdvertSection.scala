package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class AdvertDetails(
  jobSummary: String,
  jobDescription: String,
  personSpecification: String,
  offeredBenefits: String,
  selectionProcess: String
)

object AdvertSection extends VacancyBasePage {

  def jobSummaryId           = s"${formId}_datafield_51753_1_1_en-GB_ifr"
  def jobDescriptionId       = s"${formId}_field_value_51761_1"
  def personSpecsIframe      = s"${formId}_datafield_51767_1_1_en-GB_ifr"
  def offeredBenefitsIframe  = s"${formId}_datafield_62219_1_1_en-GB_ifr"
  def selectionProcessIframe = s"${formId}_datafield_59678_1_1_en-GB_ifr"
  def jobSummaryPath         = s".//body[@data-id='${formId}_datafield_51753_1_1_en-GB']"
  def jobDescriptionPath     = s".//body[@data-id='${formId}_datafield_51761_1_1_en-GB']"
  def personSpecsPath        = s".//body[@data-id='${formId}_datafield_51767_1_1_en-GB']"
  def offeredBenefitsPath    = s".//body[@data-id='${formId}_datafield_62219_1_1_en-GB']"
  def selectionProcessPath   = s".//body[@data-id='${formId}_datafield_59678_1_1_en-GB']"
  def jobSummaryIframe       = s"${formId}_datafield_51753_1_1_en-GB_ifr"
  def jobDescriptionIframe   = s"${formId}_datafield_51761_1_1_en-GB_ifr"

  def switchBack(): Unit = driver.switchTo().defaultContent()

  private def enterJobSummary(advertDetails: AdvertDetails): Unit = {
    scrollToElement(By.id(jobSummaryId))
    val switchFrame = driver.switchTo().frame(jobSummaryIframe)
    val summaryArea = switchFrame.findElement(By.xpath(jobSummaryPath))
    summaryArea.sendKeys(advertDetails.jobSummary)
    switchBack()
  }

  private def enterJobDescription(advertDetails: AdvertDetails): Unit = {
    scrollToElement(By.id(jobDescriptionId))
    val switchFrame = driver.switchTo().frame(jobDescriptionIframe)
    val summaryArea = switchFrame.findElement(By.xpath(jobDescriptionPath))
    summaryArea.sendKeys(advertDetails.jobDescription)
    switchBack()
  }

  private def enterPersonSpecs(advertDetails: AdvertDetails): Unit = {
    scrollToElement(By.id(personSpecsIframe))
    val switchFrame = driver.switchTo().frame(personSpecsIframe)
    val summaryArea = switchFrame.findElement(By.xpath(personSpecsPath))
    summaryArea.sendKeys(advertDetails.personSpecification)
    switchBack()
  }

  private def enterOfferedBenefits(advertDetails: AdvertDetails): Unit = {
    scrollToElement(By.id(offeredBenefitsIframe))
    val switchFrame = driver.switchTo().frame(offeredBenefitsIframe)
    val summaryArea = switchFrame.findElement(By.xpath(offeredBenefitsPath))
    if (!summaryArea.getText.contains("Learning")) {
      summaryArea.sendKeys(advertDetails.offeredBenefits)
    }
    switchBack()
  }

  private def enterSelectionProcess(advertDetails: AdvertDetails): Unit = {
    scrollToElement(By.id(selectionProcessIframe))
    val switchFrame = driver.switchTo().frame(selectionProcessIframe)
    val summaryArea = switchFrame.findElement(By.xpath(selectionProcessPath))
    summaryArea.sendKeys(advertDetails.selectionProcess)
    switchBack()
  }

  private val advert: Seq[AdvertDetails => Unit] = Seq(
    enterJobSummary,
    enterJobDescription,
    enterPersonSpecs,
    enterOfferedBenefits,
    enterSelectionProcess
  )

  def advertSection(newVacancyDetails: NewVacancyDetails): Unit =
    advert.foreach { f =>
      f(newVacancyDetails.advertDetails)
    }

}
