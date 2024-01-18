package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.data.MasterVacancyDetails.{sortedListOfTechSkills, sortedListOfTechSkillsDescription, vXListOfTechSkills, vXListOfTechSkillsDescription, vXNoOfApplicationStage, vXTechSkillsRequired}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.longFormId

case class TechSkillsDetails(
  techSkillOne: String,
  techSkillTwo: String,
  techSkillThree: String,
  techSkillFour: String,
  techSkillFive: String,
  techSkillSix: String,
  techSkillSeven: String,
  techSkillEight: String
)

object TechnicalSkillsPage extends CivilServiceJobsBasePage {

  private lazy val techSkillsPageTitle           = "Technical skills - Civil Service Jobs - GOV.UK"
  private lazy val v9HowManyTechSkillsFieldsPath = ".//*[@data-type='LARGETEXT']"
  def techSkillOneHeaderId                       = s"${longFormId}_label_201673_1"
  def techSkillTwoHeaderId                       = s"${longFormId}_label_201679_1"
  def techSkillThreeHeaderId                     = s"${longFormId}_label_201683_1"
  def techSkillFourHeaderId                      = s"${longFormId}_label_201686_1"
  def techSkillFiveHeaderId                      = s"${longFormId}_label_201690_1"
  def techSkillSixHeaderId                       = s"${longFormId}_label_201694_1"
  def techSkillSevenHeaderId                     = s"${longFormId}_label_201697_1"
  def techSkillEightHeaderId                     = s"${longFormId}_label_201700_1"
  def techSkillOneInputId                        = s"${longFormId}_datafield_64783_1_1"
  def techSkillTwoInputId                        = s"${longFormId}_datafield_64789_1_1"
  def techSkillThreeInputId                      = s"${longFormId}_datafield_124457_1_1"
  def techSkillFourInputId                       = s"${longFormId}_datafield_64801_1_1"
  def techSkillFiveInputId                       = s"${longFormId}_datafield_64807_1_1"
  def techSkillSixInputId                        = s"${longFormId}_datafield_64813_1_1"
  def techSkillSevenInputId                      = s"${longFormId}_datafield_64819_1_1"
  def techSkillEightInputId                      = s"${longFormId}_datafield_64825_1_1"

  private def techSkillsPageCheck(): Unit =
    eventually(onPage(techSkillsPageTitle))

  private def howManyTechSkillsRequired(): Unit = {
    techSkillsPageCheck()
    val techSkillsInputs = driver.findElements(By.xpath(v9HowManyTechSkillsFieldsPath))
    techSkillsInputs.size() shouldEqual vXNoOfApplicationStage
  }

  private def enterTechSkillOne(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoOne = waitForVisibilityOfElementById(techSkillOneHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoOne shouldEqual s"${sortedListOfTechSkills.head}\nDescription: ${sortedListOfTechSkillsDescription.head}"
    } else testInfoOne shouldEqual s"${vXListOfTechSkills.head}\nDescription: ${vXListOfTechSkillsDescription.head}"
    enterDetails(techSkillOneInputId, techSkillsDetails.techSkillOne)
  }

  private def enterTechSkillTwo(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoTwo = waitForVisibilityOfElementById(techSkillTwoHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoTwo shouldEqual s"${sortedListOfTechSkills(1)}\nDescription: ${sortedListOfTechSkillsDescription(1)}"
    } else testInfoTwo shouldEqual s"${vXListOfTechSkills(1)}\nDescription: ${vXListOfTechSkillsDescription(1)}"
    enterDetails(techSkillTwoInputId, techSkillsDetails.techSkillTwo)
  }

  private def enterTechSkillThree(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoThree = waitForVisibilityOfElementById(techSkillThreeHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoThree shouldEqual s"${sortedListOfTechSkills(2)}\nDescription: ${sortedListOfTechSkillsDescription(2)}"
    } else testInfoThree shouldEqual s"${vXListOfTechSkills(2)}\nDescription: ${vXListOfTechSkillsDescription(2)}"
    enterDetails(techSkillThreeInputId, techSkillsDetails.techSkillThree)
  }

  private def enterTechSkillFour(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoFour = waitForVisibilityOfElementById(techSkillFourHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoFour shouldEqual s"${sortedListOfTechSkills(3)}\nDescription: ${sortedListOfTechSkillsDescription(3)}"
    } else testInfoFour shouldEqual s"${vXListOfTechSkills(3)}\nDescription: ${vXListOfTechSkillsDescription(3)}"
    enterDetails(techSkillFourInputId, techSkillsDetails.techSkillFour)
  }

  private def enterTechSkillFive(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoFive = waitForVisibilityOfElementById(techSkillFiveHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoFive shouldEqual s"${sortedListOfTechSkills(4)}\nDescription: ${sortedListOfTechSkillsDescription(4)}"
    } else testInfoFive shouldEqual s"${vXListOfTechSkills(4)}\nDescription: ${vXListOfTechSkillsDescription(4)}"
    enterDetails(techSkillFiveInputId, techSkillsDetails.techSkillFive)
  }

  private def enterTechSkillSix(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoSix = waitForVisibilityOfElementById(techSkillSixHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoSix shouldEqual s"${sortedListOfTechSkills(5)}\nDescription: ${sortedListOfTechSkillsDescription(5)}"
    } else testInfoSix shouldEqual s"${vXListOfTechSkills(5)}\nDescription: ${vXListOfTechSkillsDescription(5)}"
    enterDetails(techSkillSixInputId, techSkillsDetails.techSkillSix)
  }

  //TODO Cosmetic issue requires Oleeo to fix and align with other fields
  private def enterTechSkillSeven(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoSeven = waitForVisibilityOfElementById(techSkillSevenHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoSeven shouldEqual s"${sortedListOfTechSkills(6)}\nDescription:${sortedListOfTechSkillsDescription(6)}"
    } else testInfoSeven shouldEqual s"${vXListOfTechSkills(6)}\nDescription:${vXListOfTechSkillsDescription(6)}"
    enterDetails(techSkillSevenInputId, techSkillsDetails.techSkillSeven)
  }

  //TODO Cosmetic issue requires Oleeo to fix and align with other fields
  private def enterTechSkillEight(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoEight = waitForVisibilityOfElementById(techSkillEightHeaderId).getText
    if (vXListOfTechSkills.isEmpty) {
      testInfoEight shouldEqual s"${sortedListOfTechSkills(7)}\nDescription:${sortedListOfTechSkillsDescription(7)}"
    } else testInfoEight shouldEqual s"${vXListOfTechSkills(7)}\nDescription:${vXListOfTechSkillsDescription(7)}"
    enterDetails(techSkillEightInputId, techSkillsDetails.techSkillEight)
  }

  private val skills: Seq[TechSkillsDetails => Unit] = Seq(
    enterTechSkillOne,
    enterTechSkillTwo,
    enterTechSkillThree,
    enterTechSkillFour,
    enterTechSkillFive,
    enterTechSkillSix,
    enterTechSkillSeven,
    enterTechSkillEight
  )

  def techSkillsPage(longFormDetails: LongFormDetails): Unit =
    if (vXTechSkillsRequired) {
      howManyTechSkillsRequired()
      skills.take(vXNoOfApplicationStage).foreach { f =>
        f(longFormDetails.techSkillsDetails)
      }
      clickOn(pageContinue)
    }
}
