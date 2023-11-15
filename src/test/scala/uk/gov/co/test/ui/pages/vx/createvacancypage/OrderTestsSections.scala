package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class GroupATestsDetails(
  order: String,
  howMany: String,
  first: String,
  second: String,
  third: String,
  deadline: Int
)
case class GroupBTestsDetails(order: String, howMany: String, first: String, second: String, deadline: Int)
case class GroupCTestsDetails(order: String, howMany: String, first: String, second: String, deadline: Int)

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

  private lazy val groupAFirstCSNTDayId     = s"${formId}_datafield_129983_1_1--DAY"
  private lazy val groupAFirstCSNTMonthId   = s"${formId}_datafield_129983_1_1--MONTH"
  private lazy val groupAFirstCSNTYearId    = s"${formId}_datafield_129983_1_1--YEAR"
  private lazy val groupASecondCSVTDayId    = s"${formId}_datafield_129969_1_1--DAY"
  private lazy val groupASecondCSVTMonthId  = s"${formId}_datafield_129969_1_1--MONTH"
  private lazy val groupASecondCSVTYearId   = s"${formId}_datafield_129969_1_1--YEAR"
  private lazy val groupAThirdNCSJTDayId    = s"${formId}_datafield_129976_1_1--DAY"
  private lazy val groupAThirdNCSJTMonthId  = s"${formId}_datafield_129976_1_1--MONTH"
  private lazy val groupAThirdNCSJTYearId   = s"${formId}_datafield_129976_1_1--YEAR"
  private lazy val groupBFirstCSWSTDayId    = s"${formId}_datafield_130199_1_1--DAY"
  private lazy val groupBFirstCSWSTMonthId  = s"${formId}_datafield_130199_1_1--MONTH"
  private lazy val groupBFirstCSWSTYearId   = s"${formId}_datafield_130199_1_1--YEAR"
  private lazy val groupBSecondCSMJTDayId   = s"${formId}_datafield_130206_1_1--DAY"
  private lazy val groupBSecondCSMJTMonthId = s"${formId}_datafield_130206_1_1--MONTH"
  private lazy val groupBSecondCSMJTYearId  = s"${formId}_datafield_130206_1_1--YEAR"
  private lazy val groupCFirstCSSTDayId     = s"${formId}_datafield_157611_1_1--DAY"
  private lazy val groupCFirstCSSTMonthId   = s"${formId}_datafield_157611_1_1--MONTH"
  private lazy val groupCFirstCSSTYearId    = s"${formId}_datafield_157611_1_1--YEAR"
  private lazy val groupCSecondCSTDayId     = s"${formId}_datafield_157626_1_1--DAY"
  private lazy val groupCSecondCSTMonthId   = s"${formId}_datafield_157626_1_1--MONTH"
  private lazy val groupCSecondCSTYearId    = s"${formId}_datafield_157626_1_1--YEAR"

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
      enterGroupADeadline(vacancyTestsDetails)
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

  private def enterGroupADeadline(vacancyTestsDetails: VacancyTestsDetails): Unit =
    if (!vacancyTestsDetails.recruiterOptions.map(_.sameDeadlineAllTests).get) {
      val groupADeadline = groupTestsDeadlineDate(vacancyTestsDetails.groupATests.map(_.deadline).get)
      vacancyTestsDetails.groupATests.map(_.howMany).get match {
        case "One"   =>
          enterTestDeadline(groupADeadline, groupAFirstCSNTDayId, groupAFirstCSNTMonthId, groupAFirstCSNTYearId)
        case "Two"   =>
          enterTestDeadline(groupADeadline, groupAFirstCSNTDayId, groupAFirstCSNTMonthId, groupAFirstCSNTYearId)
          enterTestDeadline(groupADeadline, groupASecondCSVTDayId, groupASecondCSVTMonthId, groupASecondCSVTYearId)
        case "Three" =>
          if (vacancyTestsDetails.testGrade != "Grade 6") {
            enterTestDeadline(groupADeadline, groupAFirstCSNTDayId, groupAFirstCSNTMonthId, groupAFirstCSNTYearId)
            enterTestDeadline(groupADeadline, groupASecondCSVTDayId, groupASecondCSVTMonthId, groupASecondCSVTYearId)
            enterTestDeadline(groupADeadline, groupAThirdNCSJTDayId, groupAThirdNCSJTMonthId, groupAThirdNCSJTYearId)
          } else {
            enterTestDeadline(groupADeadline, groupAFirstCSNTDayId, groupAFirstCSNTMonthId, groupAFirstCSNTYearId)
            enterTestDeadline(groupADeadline, groupASecondCSVTDayId, groupASecondCSVTMonthId, groupASecondCSVTYearId)
          }
      }
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
        enterGroupBDeadline(vacancyTestsDetails)
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

  private def enterGroupBDeadline(vacancyTestsDetails: VacancyTestsDetails): Unit =
    if (!vacancyTestsDetails.recruiterOptions.map(_.sameDeadlineAllTests).get) {
      val groupBDeadline = groupTestsDeadlineDate(vacancyTestsDetails.groupBTests.map(_.deadline).get)
      vacancyTestsDetails.groupBTests.map(_.howMany).get match {
        case "One" =>
          enterTestDeadline(groupBDeadline, groupBFirstCSWSTDayId, groupBFirstCSWSTMonthId, groupBFirstCSWSTYearId)
        case "Two" =>
          enterTestDeadline(groupBDeadline, groupBFirstCSWSTDayId, groupBFirstCSWSTMonthId, groupBFirstCSWSTYearId)
          enterTestDeadline(groupBDeadline, groupBSecondCSMJTDayId, groupBSecondCSMJTMonthId, groupBSecondCSMJTYearId)
      }
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
        vacancyTestsDetails.testGrade == "Administrative Officer" ||
        vacancyTestsDetails.testGrade == "Administrative Assistant" ||
        vacancyTestsDetails.testGrade == "Executive Officer"
      ) {
        vacancyTestsDetails.groupCTests.map(_.howMany).get match {
          case "One"                                                                =>
            groupCTestsSelection(vacancyTestsDetails, 1)
          case "Two" if vacancyTestsDetails.testGrade == "Administrative Assistant" =>
            groupCTestsSelection(vacancyTestsDetails, 1) //override on data
          case "Two"                                                                =>
            groupCTestsSelection(vacancyTestsDetails, 2)
          case _                                                                    =>
            throw new IllegalStateException("Order value needs to be valid option!")
        }
        enterGroupCDeadline(vacancyTestsDetails)
      }
    }
  }

  private def selectGroupCTestsOrder(vacancyTestsDetails: VacancyTestsDetails): Unit = {
    val groupAOrder = vacancyTestsDetails.groupATests.map(_.order).get
    val groupBOrder = vacancyTestsDetails.groupBTests.map(_.order).get
    val groupCOrder = vacancyTestsDetails.groupCTests.map(_.order).get
    val order       = vacancyTestsDetails.groupCTests.map(_.order).get
    waitForVisibilityOfElementById(groupCTestsId).click()
    if (
      vacancyTestsDetails.testGrade == "Grade 7 " ||
      vacancyTestsDetails.testGrade == "Grade 6" ||
      vacancyTestsDetails.testGrade == "Senior Executive Officer" ||
      vacancyTestsDetails.testGrade == "Higher Executive Officer"
    ) {
      selectActionLocator("Not required") //override on data
    } else {
      if ((groupCOrder != groupAOrder) && (groupCOrder != groupBOrder)) {
        selectActionLocator(order)
      } else {
        throw new IllegalStateException("Group tests need to have unique order option!")
      }
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
      selectActionLocator("One") //override on data
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

  private def enterGroupCDeadline(vacancyTestsDetails: VacancyTestsDetails): Unit =
    if (!vacancyTestsDetails.recruiterOptions.map(_.sameDeadlineAllTests).get) {
      val groupCDeadline = groupTestsDeadlineDate(vacancyTestsDetails.groupCTests.map(_.deadline).get)
      vacancyTestsDetails.groupCTests.map(_.howMany).get match {
        case "One"                                                                =>
          enterTestDeadline(groupCDeadline, groupCFirstCSSTDayId, groupCFirstCSSTMonthId, groupCFirstCSSTYearId)
        case "Two" if vacancyTestsDetails.testGrade == "Administrative Assistant" =>
          enterTestDeadline(groupCDeadline, groupCFirstCSSTDayId, groupCFirstCSSTMonthId, groupCFirstCSSTYearId)
        case "Two"                                                                =>
          enterTestDeadline(groupCDeadline, groupCFirstCSSTDayId, groupCFirstCSSTMonthId, groupCFirstCSSTYearId)
          enterTestDeadline(groupCDeadline, groupCSecondCSTDayId, groupCSecondCSTMonthId, groupCSecondCSTYearId)
      }
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