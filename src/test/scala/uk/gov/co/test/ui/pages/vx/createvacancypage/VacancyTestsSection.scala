package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAnyOnlineTests, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.OrderTestsSections.testOrderingSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.RecruiterTestsSection.recruiterTestsSection

case class VacancyTestsDetails(
  testsRequired: Boolean,
  onlineOrOffline: String,
  testGrade: String,
  testName: Map[String, List[String]],
  useRecommendedOption: Boolean,
  additionalDetails: String,
  recruiterOptions: Option[RecruiterTestsDetails] = None,
  groupATests: Option[GroupATestsDetails] = None,
  groupBTests: Option[GroupBTestsDetails] = None,
  groupCTests: Option[GroupCTestsDetails] = None
)

object VacancyTestsSection extends VacancyBasePage {

  def onlineTestsSectionId    = s"${vacancyFormId}_section_129661_col_0"
  def testsRequiredYesId      = s"${vacancyFormId}_datafield_129689_1_1_1"
  def testsRequiredNoId       = s"${vacancyFormId}_datafield_129689_1_1_2"
  def onlineOrOfflineId       = s"select2-${vacancyFormId}_datafield_129674_1_1-container"
  def testGradeId             = s"select2-${vacancyFormId}_datafield_129685_1_1-container"
  def testNameInputPath       =
    s".//textarea[@aria-describedby='select2-${vacancyFormId}_datafield_129734_1_1-container']"
  def recommendedOptionsYesId = s"${vacancyFormId}_datafield_129748_1_1_1"
  def recommendedOptionsNoId  = s"${vacancyFormId}_datafield_129748_1_1_2"
  def additionalDetailId      = s"${vacancyFormId}_datafield_129763_1_1"

  def vacancyTestsFlow(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    testsRequired(vacancyTestsDetails)
    if (vXAnyOnlineTests) {
      selectOnlineOrOffline(vacancyTestsDetails)
      if (vacancyTestsDetails.onlineOrOffline == "Online Tests") {
        selectTestGrade(vacancyTestsDetails)
        selectOnlineTests(vacancyTestsDetails)
        selectRecommendedOption(vacancyTestsDetails)
        recruiterTestsSection(vacancyTestsDetails)
        testOrderingSection(
          vacancyTestsDetails
        ) //relies on what testGrade was selected and testNames from list - logic needs refactor
      }
    }
  }

  def testsRequired(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    scrollToElement(By.id(onlineTestsSectionId))
    vXAnyOnlineTests = vacancyTestsDetails.testsRequired
    if (vXAnyOnlineTests) clickOnRadioButton(testsRequiredYesId)
    else clickOnRadioButton(testsRequiredNoId)
  }

  def selectOnlineOrOffline(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    waitForVisibilityOfElementById(onlineOrOfflineId).click()
    action().moveToElement(waitForDropdownOption(vacancyTestsDetails.onlineOrOffline)).perform()
    waitForDropdownOption(vacancyTestsDetails.onlineOrOffline).click()
  }

  private def selectTestGrade(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    waitForVisibilityOfElementById(testGradeId).click()
    selectOption(generalInput, vacancyTestsDetails.testGrade)
  }

  def onlineTestSelection(testName: String): Unit = {
    val selectTest = waitForVisibilityOfElementByPath(testNameInputPath)
    selectTest.sendKeys(testName)
    selectTest.sendKeys(Keys.ENTER)
  }

  def selectRecommendedOption(vacancyTestsDetails: VacancyTestsDetails): Unit =
    if (vacancyTestsDetails.useRecommendedOption) {
      clickOnRadioButton(recommendedOptionsYesId)
    } else {
      clickOnRadioButton(recommendedOptionsNoId)
      selectOptionWithId(additionalDetailId, vacancyTestsDetails.additionalDetails)
    }

  def selectOnlineTests(vacancyTestsDetails: VacancyTestsDetails): Unit =
    for (test <- vacancyTestsDetails.testName(vacancyTestsDetails.testGrade))
      onlineTestSelection(test)

  private val onlineTests: Seq[VacancyTestsDetails => Unit] = Seq(
    vacancyTestsFlow
  )

  def vacancyTestsSection(newVacancyDetails: NewVacancyDetails): Unit =
    onlineTests.foreach { f =>
      f(newVacancyDetails.vacancyTestsDetails)
    }
}
