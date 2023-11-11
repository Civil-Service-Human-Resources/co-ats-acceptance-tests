package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId
import uk.gov.co.test.ui.pages.vx.createvacancypage.RecruiterTestsSection.recruiterTestsSection

case class GroupATestsDetails(order: String, howMany: String, first: String, second: String, third: String)
case class GroupBTestsDetails(order: String, howMany: String, first: String, second: String)
case class GroupCTestsDetails(order: String, howMany: String, first: String, second: String)

case class VacancyTestsDetails(
  testsRequired: Boolean,
  onlineOrOffline: String,
  testGrade: String,
  testName: Vector[String],
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
  private lazy val groupATestsSectionId    = s"${formId}_section_129927_col_0"
  private lazy val groupATestsId           = s"select2-${formId}_datafield_137655_1_1-container"
  private lazy val groupATestsUseId        = s"select2-${formId}_datafield_129941_1_1-container"
  private lazy val groupAFirstTestId       = s"select2-${formId}_datafield_129945_1_1-container"
  private lazy val groupASecondTestId      = s"select2-${formId}_datafield_129949_1_1-container"
  private lazy val groupAThirdTestId       = s"select2-${formId}_datafield_129953_1_1-container"
  private lazy val groupBTestsId           = s"select2-${formId}_datafield_130234_1_1-container"
  private lazy val groupBTestsUseId        = s"select2-${formId}_datafield_137501_1_1-container"
  private lazy val groupBFirstTestId       = s"select2-${formId}_datafield_130187_1_1-container"
  private lazy val groupBSecondTestId      = s"select2-${formId}_datafield_130191_1_1-container"
  private lazy val groupCTestsId           = s"select2-${formId}_datafield_157866_1_1-container"
  private lazy val groupCTestsUseId        = s"select2-${formId}_datafield_157870_1_1-container"
  private lazy val groupCFirstTestId       = s"select2-${formId}_datafield_157607_1_1-container"
  private lazy val groupCSecondTestId      = s"select2-${formId}_datafield_157622_1_1-container"

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
    for (test <- vacancyTestsDetails.testName)
      onlineTestSelection(test)

  def selectGroupATestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    scrollToElement(By.id(groupATestsSectionId))
    val order = vacancyTestsDetails.groupATests.map(_.order).get
    waitForVisibilityOfElementById(groupATestsId).click()
    action().moveToElement(waitForDropdownOption(order)).perform()
    waitForDropdownOption(order).click()
  }

  def selectGroupATestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupATests.map(_.howMany).get
    waitForVisibilityOfElementById(groupATestsUseId).click()
    action().moveToElement(waitForDropdownOption(use)).perform()
    waitForDropdownOption(use).click()
  }

  def selectGroupAFirstTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val first = vacancyTestsDetails.groupATests.map(_.first).get
    waitForVisibilityOfElementById(groupAFirstTestId).click()
    action().moveToElement(waitForDropdownOption(first)).perform()
    waitForDropdownOption(first).click()
  }

  def selectGroupASecondTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val second = vacancyTestsDetails.groupATests.map(_.second).get
    waitForVisibilityOfElementById(groupASecondTestId).click()
    action().moveToElement(waitForDropdownOption(second)).perform()
    waitForDropdownOption(second).click()
  }

  def selectGroupAThirdTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val third = vacancyTestsDetails.groupATests.map(_.third).get
    waitForVisibilityOfElementById(groupAThirdTestId).click()
    action().moveToElement(waitForDropdownOption(third)).perform()
    waitForDropdownOption(third).click()
  }

  def selectGroupBTestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val order = vacancyTestsDetails.groupBTests.map(_.order).get
    waitForVisibilityOfElementById(groupBTestsId).click()
    action().moveToElement(waitForDropdownOption(order)).perform()
    waitForDropdownOption(order).click()
  }

  def selectGroupBTestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupBTests.map(_.howMany).get
    waitForVisibilityOfElementById(groupBTestsUseId).click()
    action().moveToElement(waitForDropdownOption(use)).perform()
    waitForDropdownOption(use).click()
  }

  def selectGroupBFirstTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val first = vacancyTestsDetails.groupBTests.map(_.first).get
    waitForVisibilityOfElementById(groupBFirstTestId).click()
    action().moveToElement(waitForDropdownOption(first)).perform()
    waitForDropdownOption(first).click()
  }

  def selectGroupBSecondTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val second = vacancyTestsDetails.groupBTests.map(_.second).get
    waitForVisibilityOfElementById(groupBSecondTestId).click()
    action().moveToElement(waitForDropdownOption(second)).perform()
    waitForDropdownOption(second).click()
  }

  def selectGroupCTestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val order = vacancyTestsDetails.groupCTests.map(_.order).get
    waitForVisibilityOfElementById(groupCTestsId).click()
    action().moveToElement(waitForDropdownOption(order)).perform()
    waitForDropdownOption(order).click()
  }

  def selectGroupCTestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupCTests.map(_.howMany).get
    waitForVisibilityOfElementById(groupCTestsUseId).click()
    action().moveToElement(waitForDropdownOption(use)).perform()
    waitForDropdownOption(use).click()
  }

  def selectGroupCFirstTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val first = vacancyTestsDetails.groupCTests.map(_.first).get
    waitForVisibilityOfElementById(groupCFirstTestId).click()
    action().moveToElement(waitForDropdownOption(first)).perform()
    waitForDropdownOption(first).click()
  }

  def selectGroupCSecondTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val second = vacancyTestsDetails.groupCTests.map(_.second).get
    waitForVisibilityOfElementById(groupCSecondTestId).click()
    action().moveToElement(waitForDropdownOption(second)).perform()
    waitForDropdownOption(second).click()
  }

  private val testOrdering: Seq[VacancyTestsDetails => Unit] = Seq(
    selectGroupATestsOrder,
    selectGroupATestsUse,
    selectGroupAFirstTest,
    selectGroupASecondTest,
    selectGroupAThirdTest,
    selectGroupBTestsOrder,
    selectGroupBTestsUse,
    selectGroupBFirstTest,
    selectGroupBSecondTest,
    selectGroupCTestsOrder,
    selectGroupCTestsUse,
    selectGroupCFirstTest,
    selectGroupCSecondTest
  )

  def testOrderingSection(vacancyTestsDetails: VacancyTestsDetails): Unit =
    testOrdering.foreach { f =>
      f(vacancyTestsDetails)
    }

  private val onlineTests: Seq[VacancyTestsDetails => Unit] = Seq(
    testsRequired,
    selectOnlineOrOffline,
    selectTestGrade,
    selectOnlineTests,
    selectRecommendedOption,
    recruiterTestsSection,
    testOrderingSection
  )

  def vacancyTestsSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    onlineTests.foreach { f =>
      f(newVacancyDetails.vacancyTestsDetails)
    }
}
