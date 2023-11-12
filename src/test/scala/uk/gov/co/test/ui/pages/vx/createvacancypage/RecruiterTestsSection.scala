package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.{applicationClosingDate, formId}

case class RecruiterTestsDetails(
  whenDeadline: String,
  progressionOption: String,
  sameDeadlineAllTests: Boolean,
  deadline: Int,
  additionalInstructionsRequired: Boolean,
  additionalInstructions: String
)

object RecruiterTestsSection extends VacancyBasePage {

  private lazy val recruiterTestsSectionId     = s"${formId}_section_129814_col_0"
  private lazy val candidateDeadlineId         = s"select2-${formId}_datafield_129839_1_1-container"
  private lazy val progressionOptionsId        = s"select2-${formId}_datafield_129854_1_1-container"
  private lazy val sameDeadlineAllTestsId      = s"select2-${formId}_datafield_129843_1_1-container"
  private lazy val additionalInstructionsId    = s"select2-${formId}_datafield_129828_1_1-container"
  private lazy val additionalInstructionsInput = s"${formId}_datafield_129832_1_1_en-GB"
  private lazy val deadlineDayId               = s"${formId}_datafield_129847_1_1--DAY"
  private lazy val deadlineMonthId             = s"${formId}_datafield_129847_1_1--MONTH"
  private lazy val deadlineYearId              = s"${formId}_datafield_129847_1_1--YEAR"
  var _day: String                             = ""
  var _month: String                           = ""
  var _year: String                            = ""

  def validateUrl(): Unit = {
    scrollToElement(By.id(recruiterTestsSectionId))
    val recruiterGuidanceLink        = waitForElementToBeClickableByLink(
      "Guidance for recruiters using online tests (opens in a new window)"
    )
    val adjustmentGuideLink          = waitForElementToBeClickableByLink(
      "Online tests reasonable adjustment guide (opens in a new window)"
    )
    val optionsAddingTestsLink       = waitForElementToBeClickableByLink(
      "Options for adding tests to a vacancy (opens in a new window)"
    )
    val viewGRSRecommendedStrategies = waitForElementToBeClickableByLink(
      "View the GRS-recommended strategies for ordering tests (opens in a new window)"
    )
    recruiterGuidanceLink.getAttribute("href")             should startWith(
      "https://static.civilservicejobs.service.gov.uk/company/csr/docs"
    )
    adjustmentGuideLink.getAttribute("href")               should startWith(
      "https://static.civilservicejobs.service.gov.uk/company/csr/docs"
    )
    optionsAddingTestsLink.getAttribute("href")       shouldEqual
      "https://www.gov.uk/guidance/managing-online-tests-vx#adding-tests-to-a-vacancy"
    viewGRSRecommendedStrategies.getAttribute("href") shouldEqual
      "https://www.gov.uk/guidance/managing-online-tests-vx#setting-the-order-of-the-tests"
  }

  def selectCandidateDeadline(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val deadline = vacancyTestsDetails.recruiterOptions.map(_.whenDeadline).get
    validateUrl()
    waitForVisibilityOfElementById(candidateDeadlineId).click()
    action().moveToElement(waitForDropdownOption(deadline)).perform()
    waitForDropdownOption(deadline).click()
  }

  def selectProgressionOptions(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val progression = vacancyTestsDetails.recruiterOptions.map(_.progressionOption).get
    waitForVisibilityOfElementById(progressionOptionsId).click()
    action().moveToElement(waitForDropdownOption(progression)).perform()
    waitForDropdownOption(progression).click()
  }

  def selectSameDeadlineAllTests(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val sameDeadline = vacancyTestsDetails.recruiterOptions.map(_.sameDeadlineAllTests).get
    waitForVisibilityOfElementById(sameDeadlineAllTestsId).click()
    if (sameDeadline) {
      action().moveToElement(waitForDropdownOption("Yes")).perform()
      waitForDropdownOption("Yes").click()
      enterTestDeadline()
    } else {
      action().moveToElement(waitForDropdownOption("No")).perform()
      waitForDropdownOption("No").click()
    }
  }

  def splitAppClosingDate(): (String, String, String) = {
    val date  = applicationClosingDate
    val parts = date.split("/")
    _day = parts(0)
    _month = parts(1)
    _year = parts(2)
    (_day, _month, _year)
  }

  def enterDate(id: String, value: String): Unit = {
    val dateValue = new Select(waitForVisibilityOfElementById(id))
    dateValue.selectByValue(value)
  }

  def enterTestDeadline(): Unit = {
    splitAppClosingDate()
    enterDate(deadlineDayId, _day)
    enterDate(deadlineMonthId, _month)
    enterDate(deadlineYearId, _year)
  }

  def selectAdditionalInstructions(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val instructions = vacancyTestsDetails.recruiterOptions
    waitForVisibilityOfElementById(additionalInstructionsId).click()
    if (instructions.map(_.additionalInstructionsRequired).get) {
      action().moveToElement(waitForDropdownOption("Yes")).perform()
      waitForDropdownOption("Yes").click()
      selectOptionWithId(additionalInstructionsInput, instructions.map(_.additionalInstructions).get)
    } else {
      action().moveToElement(waitForDropdownOption("No")).perform()
      waitForDropdownOption("No").click()
    }
  }

  private val recruiterTests: Seq[VacancyTestsDetails => Unit] = Seq(
    selectCandidateDeadline,
    selectProgressionOptions,
    selectSameDeadlineAllTests,
    selectAdditionalInstructions
  )

  def recruiterTestsSection(vacancyTestsDetails: VacancyTestsDetails): Unit =
    recruiterTests.foreach { f =>
      f(vacancyTestsDetails)
    }
}
