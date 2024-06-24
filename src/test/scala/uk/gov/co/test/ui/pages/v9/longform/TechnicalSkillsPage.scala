package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXHowManySkills, vXListOfSkillsApplicationRequired, vXListOfTechSkills, vXListOfTechSkillsDescription, vXTechSkillsRequired}
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.longform.DiversityMonitoringPage.longFormId

case class TechSkillsDetails(
  techSkillText: String
)

object TechnicalSkillsPage extends CivilServiceJobsBasePage {

  private lazy val techSkillsPageTitle           = "Technical skills - Civil Service Jobs - GOV.UK"
  private lazy val v9HowManyTechSkillsFieldsPath = ".//*[@data-type='LARGETEXT']"
  def techSkillInfoId                            = s"${longFormId}_label_64970_1"
  def techSkillOneHeaderId                       = s"${longFormId}_label_201673_1"
  def techSkillTwoHeaderId                       = s"${longFormId}_label_201679_1"
  def techSkillThreeHeaderId                     = s"${longFormId}_label_201683_1"
  def techSkillFourHeaderId                      = s"${longFormId}_label_201686_1"
  def techSkillFiveHeaderId                      = s"${longFormId}_label_201690_1"
  def techSkillSixHeaderId                       = s"${longFormId}_label_201694_1"
  def techSkillSevenHeaderId                     = s"${longFormId}_label_201697_1"
  def techSkillEightHeaderId                     = s"${longFormId}_label_201700_1"
  def techSkillOneInputId                        = s"${longFormId}_datafield_64783_1_1"
  def techSkillOneWordLimitId                    = s"${longFormId}_datafield_64783_1_1_counter_node"
  def techSkillTwoWordLimitId                    = s"${longFormId}_datafield_64789_1_1_counter_node"
  def techSkillThreeWordLimitId                  = s"${longFormId}_datafield_124457_1_1_counter_node"
  def techSkillFourWordLimitId                   = s"${longFormId}_datafield_64801_1_1_counter_node"
  def techSkillFiveWordLimitId                   = s"${longFormId}_datafield_64807_1_1_counter_node"
  def techSkillSixWordLimitId                    = s"${longFormId}_datafield_64813_1_1_counter_node"
  def techSkillSevenWordLimitId                  = s"${longFormId}_datafield_64819_1_1_counter_node"
  def techSkillEightWordLimitId                  = s"${longFormId}_datafield_64825_1_1_counter_node"
  def techSkillTwoInputId                        = s"${longFormId}_datafield_64789_1_1"
  def techSkillThreeInputId                      = s"${longFormId}_datafield_124457_1_1"
  def techSkillFourInputId                       = s"${longFormId}_datafield_64801_1_1"
  def techSkillFiveInputId                       = s"${longFormId}_datafield_64807_1_1"
  def techSkillSixInputId                        = s"${longFormId}_datafield_64813_1_1"
  def techSkillSevenInputId                      = s"${longFormId}_datafield_64819_1_1"
  def techSkillEightInputId                      = s"${longFormId}_datafield_64825_1_1"

  private def techSkillsPageCheck(): Unit = {
    eventually(onPage(techSkillsPageTitle))
    waitForVisibilityOfElementById(
      techSkillInfoId
    ).getText shouldEqual s"Provide statements on your skills and experience regarding each stated technical skill.\nStructure your example as Situation, Task, Action and Result\nFind out about Success Profiles and Technical Skills (opens in a new window)\nEach answer should not exceed 250 words."
  }

  private def howManyTechSkillsRequired(): Unit = {
    techSkillsPageCheck()
    val techSkillsInputs       = driver.findElements(By.xpath(v9HowManyTechSkillsFieldsPath))
    val howManyTechSkillsShown = vXListOfSkillsApplicationRequired.groupBy(identity).view.mapValues(_.size)(true)
    techSkillsInputs.size() shouldEqual howManyTechSkillsShown
  }

  private def checkAndEnterTechSkillOne(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.headOption.get}\n\nDescription: ${vXListOfTechSkillsDescription.headOption.get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.headOption.get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.headOption.get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillOneHeaderId).getText
      if (vXListOfTechSkillsDescription.headOption.get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillOneInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillOneWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private def checkAndEnterTechSkillTwo(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.lift(1).get}\n\nDescription: ${vXListOfTechSkillsDescription.lift(1).get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.lift(1).get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.lift(1).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillTwoHeaderId).getText
      if (vXListOfTechSkillsDescription.lift(1).get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillTwoInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillTwoWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private def checkAndEnterTechSkillThree(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.lift(2).get}\n\nDescription: ${vXListOfTechSkillsDescription.lift(2).get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.lift(2).get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.lift(2).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillThreeHeaderId).getText
      if (vXListOfTechSkillsDescription.lift(2).get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillThreeInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillThreeWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private def checkAndEnterTechSkillFour(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.lift(3).get}\n\nDescription: ${vXListOfTechSkillsDescription.lift(3).get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.lift(3).get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.lift(3).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillFourHeaderId).getText
      if (vXListOfTechSkillsDescription.lift(3).get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillFourInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillFourWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private def checkAndEnterTechSkillFive(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.lift(4).get}\n\nDescription: ${vXListOfTechSkillsDescription.lift(4).get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.lift(4).get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.lift(4).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillFiveHeaderId).getText
      if (vXListOfTechSkillsDescription.lift(4).get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillFiveInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillFiveWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private def checkAndEnterTechSkillSix(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.lift(5).get}\n\nDescription: ${vXListOfTechSkillsDescription.lift(5).get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.lift(5).get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.lift(5).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillSixHeaderId).getText
      if (vXListOfTechSkillsDescription.lift(5).get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillSixInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillSixWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private def checkAndEnterTechSkillSeven(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.lift(6).get}\n\nDescription: ${vXListOfTechSkillsDescription.lift(6).get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.lift(6).get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.lift(6).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillSevenHeaderId).getText
      if (vXListOfTechSkillsDescription.lift(6).get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillSevenInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillSevenWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private def checkAndEnterTechSkillEight(techSkillsDetails: TechSkillsDetails): Unit = {
    val expectedHeader                   =
      s"${vXListOfTechSkills.lift(7).get}\n\nDescription: ${vXListOfTechSkillsDescription.lift(7).get}"
    val expectedHeaderWithoutDescription = s"${vXListOfTechSkills.lift(7).get}"
    val applicationRequired              = vXListOfSkillsApplicationRequired.lift(7).get
    if (applicationRequired) {
      val actualHeader = waitForVisibilityOfElementById(techSkillEightHeaderId).getText
      if (vXListOfTechSkillsDescription.lift(7).get.isEmpty)
        expectedHeaderWithoutDescription shouldEqual actualHeader
      else expectedHeader                shouldEqual actualHeader
      enterDetails(techSkillEightInputId, techSkillsDetails.techSkillText)
      checkForTotalValueId(techSkillEightWordLimitId, "Maximum Word Count 250 of  250 words")
    }
  }

  private val skills: Seq[TechSkillsDetails => Unit] = Seq(
    checkAndEnterTechSkillOne,
    checkAndEnterTechSkillTwo,
    checkAndEnterTechSkillThree,
    checkAndEnterTechSkillFour,
    checkAndEnterTechSkillFive,
    checkAndEnterTechSkillSix,
    checkAndEnterTechSkillSeven,
    checkAndEnterTechSkillEight
  )

  def techSkillsPage(longFormDetails: LongFormDetails): Unit =
    if (vXTechSkillsRequired) {
      howManyTechSkillsRequired()
      skills.take(vXHowManySkills).foreach { f =>
        f(longFormDetails.techSkillsDetails)
      }
      clickOn(pageContinue)
    }
}
