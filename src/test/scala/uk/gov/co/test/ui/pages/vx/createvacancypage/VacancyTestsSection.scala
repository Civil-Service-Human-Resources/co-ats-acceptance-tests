package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId
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
  var anyOnlineTests                       = ""

  def vacancyTestsFlow(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    testsRequired(vacancyTestsDetails)
    anyOnlineTests = vacancyTestsDetails.testsRequired.toString
    if (vacancyTestsDetails.testsRequired) {
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
    if (vacancyTestsDetails.testsRequired) clickOnRadioButton(testsRequiredYesId)
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
