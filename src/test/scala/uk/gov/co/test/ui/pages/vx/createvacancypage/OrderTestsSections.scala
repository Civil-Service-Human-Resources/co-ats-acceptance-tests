package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class GroupATestsDetails(order: String, howMany: String, first: String, second: String, third: String)
case class GroupBTestsDetails(order: String, howMany: String, first: String, second: String)
case class GroupCTestsDetails(order: String, howMany: String, first: String, second: String)

object OrderTestsSections extends VacancyBasePage {

  private lazy val groupATestsSectionId = s"${formId}_section_129927_col_0"
  private lazy val groupATestsId        = s"select2-${formId}_datafield_137655_1_1-container"
  private lazy val groupATestsUseId     = s"select2-${formId}_datafield_129941_1_1-container"
  private lazy val groupAFirstTestId    = s"select2-${formId}_datafield_129945_1_1-container"
  private lazy val groupASecondTestId   = s"select2-${formId}_datafield_129949_1_1-container"
  private lazy val groupAThirdTestId    = s"select2-${formId}_datafield_129953_1_1-container"
  private lazy val groupBTestsId        = s"select2-${formId}_datafield_130234_1_1-container"
  private lazy val groupBTestsUseId     = s"select2-${formId}_datafield_137501_1_1-container"
  private lazy val groupBFirstTestId    = s"select2-${formId}_datafield_130187_1_1-container"
  private lazy val groupBSecondTestId   = s"select2-${formId}_datafield_130191_1_1-container"
  private lazy val groupCTestsId        = s"select2-${formId}_datafield_157866_1_1-container"
  private lazy val groupCTestsUseId     = s"select2-${formId}_datafield_157870_1_1-container"
  private lazy val groupCFirstTestId    = s"select2-${formId}_datafield_157607_1_1-container"
  private lazy val groupCSecondTestId   = s"select2-${formId}_datafield_157622_1_1-container"

  private def groupAOrdering(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    selectGroupATestsOrder(vacancyTestsDetails)
    if (vacancyTestsDetails.groupATests.map(_.order).get != "Not required") {
      selectGroupATestsUse(vacancyTestsDetails)
      vacancyTestsDetails.groupATests.map(_.howMany).get match {
        case "One"   => groupATestsSelection(vacancyTestsDetails, 1)
        case "Two"   => groupATestsSelection(vacancyTestsDetails, 2)
        case "Three" =>
          if (vacancyTestsDetails.testGrade != "Grade 6") {
            groupATestsSelection(vacancyTestsDetails, 3)
          } else {
            groupATestsSelection(vacancyTestsDetails, 2)
          }
      }
    }
  }

  private def selectGroupATestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    scrollToElement(By.id(groupATestsSectionId))
    val order = vacancyTestsDetails.groupATests.map(_.order).get
    waitForVisibilityOfElementById(groupATestsId).click()
    selectActionLocator(order)
  }

  private def selectGroupATestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupATests.map(_.howMany).get
    waitForVisibilityOfElementById(groupATestsUseId).click()
    if (vacancyTestsDetails.testGrade == "Grade 6" && vacancyTestsDetails.groupATests.map(_.howMany).get == "Three") {
      selectActionLocator("Two")
    } else selectActionLocator(use)
  }

  private def selectGroupAFirstTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val first = vacancyTestsDetails.groupATests.map(_.first).get
    waitForVisibilityOfElementById(groupAFirstTestId).click()
    selectActionLocator(first)
  }

  private def selectGroupASecondTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val second = vacancyTestsDetails.groupATests.map(_.second).get
    waitForVisibilityOfElementById(groupASecondTestId).click()
    selectActionLocator(second)
  }

  private def selectGroupAThirdTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val third = vacancyTestsDetails.groupATests.map(_.third).get
    waitForVisibilityOfElementById(groupAThirdTestId).click()
    selectActionLocator(third)
  }

  private val groupATests: Seq[VacancyTestsDetails => Unit] = Seq(
    selectGroupAFirstTest,
    selectGroupASecondTest,
    selectGroupAThirdTest
  )

  private def groupATestsSelection(vacancyTestsDetails: VacancyTestsDetails, take: Int): Unit =
    groupATests.take(take).foreach { f =>
      f(vacancyTestsDetails)
    }

  private def selectGroupBTestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val order = vacancyTestsDetails.groupBTests.map(_.order).get
    waitForVisibilityOfElementById(groupBTestsId).click()
    selectActionLocator(order)
  }

  private def selectGroupBTestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupBTests.map(_.howMany).get
    waitForVisibilityOfElementById(groupBTestsUseId).click()
    selectActionLocator(use)
  }

  private def selectGroupBFirstTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val first = vacancyTestsDetails.groupBTests.map(_.first).get
    waitForVisibilityOfElementById(groupBFirstTestId).click()
    selectActionLocator(first)
  }

  private def selectGroupBSecondTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val second = vacancyTestsDetails.groupBTests.map(_.second).get
    waitForVisibilityOfElementById(groupBSecondTestId).click()
    selectActionLocator(second)
  }

  private def selectGroupCTestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val order = vacancyTestsDetails.groupCTests.map(_.order).get
    waitForVisibilityOfElementById(groupCTestsId).click()
    selectActionLocator(order)
  }

  private def selectGroupCTestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupCTests.map(_.howMany).get
    waitForVisibilityOfElementById(groupCTestsUseId).click()
    selectActionLocator(use)
  }

  private def selectGroupCFirstTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val first = vacancyTestsDetails.groupCTests.map(_.first).get
    waitForVisibilityOfElementById(groupCFirstTestId).click()
    selectActionLocator(first)
  }

  private def selectGroupCSecondTest(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val second = vacancyTestsDetails.groupCTests.map(_.second).get
    waitForVisibilityOfElementById(groupCSecondTestId).click()
    selectActionLocator(second)
  }

  private val testOrdering: Seq[VacancyTestsDetails => Unit] = Seq(
    groupAOrdering
  )

  def testOrderingSection(vacancyTestsDetails: VacancyTestsDetails): Unit =
    testOrdering.foreach { f =>
      f(vacancyTestsDetails)
    }
}
