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
    val groupAOrder = vacancyTestsDetails.groupATests.map(_.order).get
    val groupBOrder = vacancyTestsDetails.groupBTests.map(_.order).get
    val groupCOrder = vacancyTestsDetails.groupCTests.map(_.order).get
    if ((groupAOrder != groupBOrder) && (groupAOrder != groupCOrder)) {
      waitForVisibilityOfElementById(groupATestsId).click()
      selectActionLocator(groupAOrder)
    } else {
      throw new IllegalStateException("Group tests need to have unique order option!")
    }
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

  private def groupBOrdering(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    selectGroupBTestsOrder(vacancyTestsDetails)
    if (vacancyTestsDetails.groupBTests.map(_.order).get != "Not required") {
      selectGroupBTestsUse(vacancyTestsDetails)
      if (
        vacancyTestsDetails.testGrade == "Higher Executive Officer" ||
        vacancyTestsDetails.testGrade == "Executive Officer" ||
        vacancyTestsDetails.testGrade == "Senior Executive Officer"
      ) {
        vacancyTestsDetails.groupBTests.map(_.howMany).get match {
          case "One" => groupBTestsSelection(vacancyTestsDetails, 1)
          case "Two" => groupBTestsSelection(vacancyTestsDetails, 2)
        }
      }
      groupBTestsSelection(vacancyTestsDetails, 1)
    }
  }

  private def selectGroupBTestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val groupAOrder = vacancyTestsDetails.groupATests.map(_.order).get
    val groupBOrder = vacancyTestsDetails.groupBTests.map(_.order).get
    val groupCOrder = vacancyTestsDetails.groupCTests.map(_.order).get
    val order       = vacancyTestsDetails.groupBTests.map(_.order).get
    if ((groupBOrder != groupCOrder) && (groupBOrder != groupAOrder)) {
      waitForVisibilityOfElementById(groupBTestsId).click()
      selectActionLocator(order)
    } else { throw new IllegalStateException("Group tests need to have unique order option!") }
  }

  private def selectGroupBTestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupBTests.map(_.howMany).get
    waitForVisibilityOfElementById(groupBTestsUseId).click()
    if (
      vacancyTestsDetails.testGrade == "Higher Executive Officer" ||
      vacancyTestsDetails.testGrade == "Executive Officer" ||
      vacancyTestsDetails.testGrade == "Senior Executive Officer"
    ) {
      selectActionLocator(use)
    } else selectActionLocator("One")
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

  private val groupBTests: Seq[VacancyTestsDetails => Unit] = Seq(
    selectGroupBFirstTest,
    selectGroupBSecondTest
  )

  private def groupBTestsSelection(vacancyTestsDetails: VacancyTestsDetails, take: Int): Unit =
    groupBTests.take(take).foreach { f =>
      f(vacancyTestsDetails)
    }

  private def groupCOrdering(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    selectGroupCTestsOrder(vacancyTestsDetails)
    if (vacancyTestsDetails.groupCTests.map(_.order).get != "Not required") {
      selectGroupCTestsUse(vacancyTestsDetails)
      if (
        vacancyTestsDetails.testGrade == "Higher Executive Officer" ||
        vacancyTestsDetails.testGrade == "Executive Officer" ||
        vacancyTestsDetails.testGrade == "Senior Executive Officer"
      ) {
        vacancyTestsDetails.groupCTests.map(_.howMany).get match {
          case "One" => groupCTestsSelection(vacancyTestsDetails, 1)
          case "Two" => groupCTestsSelection(vacancyTestsDetails, 2)
          case _     => throw new IllegalStateException("Order value needs to be valid option!")
        }
      }
    }
  }

  private def selectGroupCTestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val order = vacancyTestsDetails.groupCTests.map(_.order).get
    waitForVisibilityOfElementById(groupCTestsId).click()
    if (
      vacancyTestsDetails.testGrade == "Grade 7 " ||
      vacancyTestsDetails.testGrade == "Grade 6" ||
      vacancyTestsDetails.testGrade == "Senior Executive Officer" ||
      vacancyTestsDetails.testGrade == "Higher Executive Officer"
    ) {
      selectActionLocator("Not required")
    } else {
      selectActionLocator(order)
    }
  }

  private def selectGroupCTestsUse(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val use = vacancyTestsDetails.groupCTests.map(_.howMany).get
    waitForVisibilityOfElementById(groupCTestsUseId).click()
    if (
      vacancyTestsDetails.testGrade == "Administrative Officer" ||
      vacancyTestsDetails.testGrade == "Executive Officer"
    ) {
      selectActionLocator(use)
    } else if (vacancyTestsDetails.testGrade == "Administrative Assistant") {
      selectActionLocator("One")
    }
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

  private val groupCTests: Seq[VacancyTestsDetails => Unit] = Seq(
    selectGroupCFirstTest,
    selectGroupCSecondTest
  )

  private def groupCTestsSelection(vacancyTestsDetails: VacancyTestsDetails, take: Int): Unit =
    groupCTests.take(take).foreach { f =>
      f(vacancyTestsDetails)
    }

  private val testOrdering: Seq[VacancyTestsDetails => Unit] = Seq(
    groupAOrdering,
    groupBOrdering,
    groupCOrdering
  )

  def testOrderingSection(vacancyTestsDetails: VacancyTestsDetails): Unit =
    testOrdering.foreach { f =>
      f(vacancyTestsDetails)
    }
}
