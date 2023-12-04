package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.pages.vx.createvacancypage.SuccessProfilesSection.techSkillsRequired
import uk.gov.co.test.ui.pages.vx.createvacancypage.TechnicalSkillsSection.{howManySkills, listOfTechSkills, listOfTechSkillsDescription}

import scala.collection.mutable

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

  private lazy val techSkillsPageTitle                                 = "Technical skills - Civil Service Jobs - GOV.UK"
  private lazy val v9HowManyTechSkillsFieldsPath                       = ".//*[@data-type='LARGETEXT']"
  private lazy val techSkillOneHeaderId                                = s"${formId}_label_201673_1"
  private lazy val techSkillTwoHeaderId                                = s"${formId}_label_201679_1"
  private lazy val techSkillThreeHeaderId                              = s"${formId}_label_201683_1"
  private lazy val techSkillFourHeaderId                               = s"${formId}_label_201686_1"
  private lazy val techSkillFiveHeaderId                               = s"${formId}_label_201690_1"
  private lazy val techSkillSixHeaderId                                = s"${formId}_label_201694_1"
  private lazy val techSkillSevenHeaderId                              = s"${formId}_label_201697_1"
  private lazy val techSkillEightHeaderId                              = s"${formId}_label_201700_1"
  def techSkillOneInputId                                              = s"${formId}_datafield_64783_1_1"
  def techSkillTwoInputId                                              = s"${formId}_datafield_64789_1_1"
  def techSkillThreeInputId                                            = s"${formId}_datafield_124457_1_1"
  def techSkillFourInputId                                             = s"${formId}_datafield_64801_1_1"
  def techSkillFiveInputId                                             = s"${formId}_datafield_64807_1_1"
  def techSkillSixInputId                                              = s"${formId}_datafield_64813_1_1"
  def techSkillSevenInputId                                            = s"${formId}_datafield_64819_1_1"
  def techSkillEightInputId                                            = s"${formId}_datafield_64825_1_1"
  private lazy val newListOfTechSkills: mutable.Seq[String]            = listOfTechSkills
  private lazy val newListOfTechSkillsDescription: mutable.Seq[String] = listOfTechSkillsDescription

//  var listOfTechSkills: mutable.Seq[String]            = ListBuffer(
//    "Autotest - technical skills 1",
//    "Autotest - technical skills 2",
//    "Autotest - technical skills 4",
//    "Autotest - technical skills 5",
//    "Autotest - technical skills 6",
//    "Autotest - technical skills 7",
//    "Autotest - technical skills 8"
//  )
//  var listOfTechSkillsDescription: mutable.Seq[String] = ListBuffer(
//    "Autotest - technical skills 1 description",
//    "Autotest - technical skills 2 description",
//    "Autotest - technical skills 3 description",
//    "Autotest - technical skills 4 description",
//    "Autotest - technical skills 5 description",
//    "Autotest - technical skills 6 description",
//    "Autotest - technical skills 7 description",
//    "Autotest - technical skills 8 description"
//  )

  private def techSkillsPageCheck(): Unit =
    eventually(onPage(techSkillsPageTitle))

  private def howManyTechSkillsRequired(): Unit = {
    techSkillsPageCheck()
    val techSkillsInputs = driver.findElements(By.xpath(v9HowManyTechSkillsFieldsPath))
    techSkillsInputs.size() shouldEqual howManySkills.toInt
//    techSkillsInputs.size() shouldEqual 8 // TODO remove once section completed
  }

  private def enterTechSkillOne(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoOne = waitForVisibilityOfElementById(techSkillOneHeaderId).getText
    testInfoOne shouldEqual s"${newListOfTechSkills.head}\nDescription: ${newListOfTechSkillsDescription.head}"
    enterDetails(techSkillOneInputId, techSkillsDetails.techSkillOne)
  }

  private def enterTechSkillTwo(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoTwo = waitForVisibilityOfElementById(techSkillTwoHeaderId).getText
    testInfoTwo shouldEqual s"${newListOfTechSkills(1)}\nDescription: ${newListOfTechSkillsDescription(1)}"
    enterDetails(techSkillTwoInputId, techSkillsDetails.techSkillTwo)
  }

  private def enterTechSkillThree(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoThree = waitForVisibilityOfElementById(techSkillThreeHeaderId).getText
    testInfoThree shouldEqual s"${newListOfTechSkills(2)}\nDescription: ${newListOfTechSkillsDescription(2)}"
    enterDetails(techSkillThreeInputId, techSkillsDetails.techSkillThree)
  }

  private def enterTechSkillFour(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoFour = waitForVisibilityOfElementById(techSkillFourHeaderId).getText
    testInfoFour shouldEqual s"${newListOfTechSkills(3)}\nDescription: ${newListOfTechSkillsDescription(3)}"
    enterDetails(techSkillFourInputId, techSkillsDetails.techSkillFour)
  }

  private def enterTechSkillFive(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoFive = waitForVisibilityOfElementById(techSkillFiveHeaderId).getText
    testInfoFive shouldEqual s"${newListOfTechSkills(4)}\nDescription: ${newListOfTechSkillsDescription(4)}"
    enterDetails(techSkillFiveInputId, techSkillsDetails.techSkillFive)
  }

  private def enterTechSkillSix(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoSix = waitForVisibilityOfElementById(techSkillSixHeaderId).getText
    testInfoSix shouldEqual s"${newListOfTechSkills(5)}\nDescription: ${newListOfTechSkillsDescription(5)}"
    enterDetails(techSkillSixInputId, techSkillsDetails.techSkillSix)
  }

  //TODO Cosmetic issue requires Oleeo to fix and align with other fields
  private def enterTechSkillSeven(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoSeven = waitForVisibilityOfElementById(techSkillSevenHeaderId).getText
    testInfoSeven shouldEqual s"${newListOfTechSkills(6)}\nDescription:${newListOfTechSkillsDescription(6)}"
    enterDetails(techSkillSevenInputId, techSkillsDetails.techSkillSeven)
  }

  //TODO Cosmetic issue requires Oleeo to fix and align with other fields
  private def enterTechSkillEight(techSkillsDetails: TechSkillsDetails): Unit = {
    val testInfoEight = waitForVisibilityOfElementById(techSkillEightHeaderId).getText
    testInfoEight shouldEqual s"${newListOfTechSkills(7)}\nDescription:${newListOfTechSkillsDescription(7)}"
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
    if (techSkillsRequired.toBoolean) {
      howManyTechSkillsRequired()
      skills.take(howManySkills.toInt).foreach { f =>
        f(longFormDetails.techSkillsDetails)
      }
      clickOn(pageContinue)
    }
}
