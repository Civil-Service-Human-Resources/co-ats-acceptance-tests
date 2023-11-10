package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class OnlineTestsDetails(
  testsRequired: Boolean,
  onlineOrOffline: String,
  testGrade: String,
  testName: Vector[String],
  useRecommendedOption: Boolean,
  additionalDetails: String,
  recruiterOptions: Option[OnlineTestsDetails] = None
)

object OnlineTestsSection extends VacancyBasePage {

  private lazy val onlineTestsSectionId    = s"${formId}_section_129661_col_0"
  private lazy val testsRequiredYesId      = s"${formId}_datafield_129689_1_1_1"
  private lazy val testsRequiredNoId       = s"${formId}_datafield_129689_1_1_2"
  private lazy val onlineOrOfflineId       = s"select2-${formId}_datafield_129674_1_1-container"
  private lazy val testGradeId             = s"select2-${formId}_datafield_129685_1_1-container"
  private lazy val testNameInputPath       =
    s".//textarea[@aria-describedby='select2-${formId}_datafield_129734_1_1-container']"
  private lazy val recommendedOptionsYesId = s"${formId}_datafield_129748_1_1_1"
  private lazy val recommendedOptionsNoId  = s"${formId}_datafield_129748_1_1_2"
  private lazy val additionalDetailId      = s"${formId}_datafield_129763_1_1"

  def testsRequired(onlineTestsDetails: OnlineTestsDetails): Unit = {
    scrollToElement(By.id(onlineTestsSectionId))
    if (onlineTestsDetails.testsRequired) clickOnRadioButton(testsRequiredYesId)
    else clickOnRadioButton(testsRequiredNoId)
  }

  def selectOnlineOrOffline(onlineTestsDetails: OnlineTestsDetails): Unit = {
    waitForVisibilityOfElementById(onlineOrOfflineId).click()
    action().moveToElement(waitForDropdownOption(onlineTestsDetails.onlineOrOffline)).perform()
    waitForDropdownOption(onlineTestsDetails.onlineOrOffline).click()
  }

  private def selectTestGrade(onlineTestsDetails: OnlineTestsDetails): Unit = {
    waitForVisibilityOfElementById(testGradeId).click()
    selectOption(generalInput, onlineTestsDetails.testGrade)
  }

  def onlineTestSelection(testName: String): Unit = {
    val selectTest = waitForVisibilityOfElementByPath(testNameInputPath)
    selectTest.sendKeys(testName)
    selectTest.sendKeys(Keys.ENTER)
  }

  def selectRecommendedOption(onlineTestsDetails: OnlineTestsDetails): Unit =
    if (onlineTestsDetails.useRecommendedOption) {
      clickOnRadioButton(recommendedOptionsYesId)
    } else {
      clickOnRadioButton(recommendedOptionsNoId)
      selectOptionWithId(additionalDetailId, onlineTestsDetails.additionalDetails)
    }

  def selectOnlineTests(onlineTestsDetails: OnlineTestsDetails): Unit =
    for (test <- onlineTestsDetails.testName)
      onlineTestSelection(test)

  private val onlineTests: Seq[OnlineTestsDetails => Unit] = Seq(
    testsRequired,
    selectOnlineOrOffline,
    selectTestGrade,
    selectOnlineTests,
    selectRecommendedOption
  )

  def onlineTestsSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    onlineTests.foreach { f =>
      f(newVacancyDetails.onlineTestsDetails)
    }
}
