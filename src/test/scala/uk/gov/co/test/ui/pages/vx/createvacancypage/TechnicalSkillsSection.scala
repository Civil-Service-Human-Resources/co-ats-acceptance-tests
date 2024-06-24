package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXHowManySkills, vXListOfSkillsApplicationRequired, vXListOfSkillsInterviewRequired, vXListOfTechSkills, vXListOfTechSkillsDescription, vXTechSkillsRequired, vacancyFormId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class TechSkill(
  skillName: String,
  skillDescription: Option[String] = None,
  applicationRequired: Boolean,
  interviewRequired: Boolean
)

case class TechSkillsDetails(
  howManySkills: Int,
  techSkillsOne: TechSkill,
  techSkillsTwo: TechSkill,
  techSkillsThree: TechSkill,
  techSkillsFour: TechSkill,
  techSkillsFive: TechSkill,
  techSkillsSix: TechSkill,
  techSkillsSeven: TechSkill,
  techSkillsEight: TechSkill
)

object TechnicalSkillsSection extends VacancyBasePage {

  def techSkillsSectionId          = s"${vacancyFormId}_section_60768_col_0"
  def howManyTechSkillsId          = s"select2-${vacancyFormId}_datafield_60774_1_1-container"
  def techSkillsOneId              = s"${vacancyFormId}_datafield_60779_1_1_en-GB"
  def techSkillsTwoId              = s"${vacancyFormId}_datafield_60791_1_1_en-GB"
  def techSkillsThreeId            = s"${vacancyFormId}_datafield_60803_1_1_en-GB"
  def techSkillsFourId             = s"${vacancyFormId}_datafield_60815_1_1_en-GB"
  def techSkillsFiveId             = s"${vacancyFormId}_datafield_60827_1_1_en-GB"
  def techSkillsSixId              = s"${vacancyFormId}_datafield_60839_1_1_en-GB"
  def techSkillsSevenId            = s"${vacancyFormId}_datafield_60874_1_1_en-GB"
  def techSkillsEightId            = s"${vacancyFormId}_datafield_60886_1_1_en-GB"
  def techSkillsOneDescriptionId   = s"${vacancyFormId}_datafield_60785_1_1_en-GB"
  def techSkillsTwoDescriptionId   = s"${vacancyFormId}_datafield_60797_1_1_en-GB"
  def techSkillsThreeDescriptionId = s"${vacancyFormId}_datafield_60809_1_1_en-GB"
  def techSkillsFourDescriptionId  = s"${vacancyFormId}_datafield_60821_1_1_en-GB"
  def techSkillsFiveDescriptionId  = s"${vacancyFormId}_datafield_60833_1_1_en-GB"
  def techSkillsSixDescriptionId   = s"${vacancyFormId}_datafield_60845_1_1_en-GB"
  def techSkillsSevenDescriptionId = s"${vacancyFormId}_datafield_60880_1_1_en-GB"
  def techSkillsEightDescriptionId = s"${vacancyFormId}_datafield_60892_1_1_en-GB"
  def applicationOneId             = s"${vacancyFormId}_datafield_65039_1_1_12683"
  def applicationTwoId             = s"${vacancyFormId}_datafield_65043_1_1_12683"
  def applicationThreeId           = s"${vacancyFormId}_datafield_65047_1_1_12683"
  def applicationFourId            = s"${vacancyFormId}_datafield_65051_1_1_12683"
  def applicationFiveId            = s"${vacancyFormId}_datafield_65055_1_1_12683"
  def applicationSixId             = s"${vacancyFormId}_datafield_65059_1_1_12683"
  def applicationSevenId           = s"${vacancyFormId}_datafield_65063_1_1_12683"
  def applicationEightId           = s"${vacancyFormId}_datafield_65067_1_1_12683"
  def interviewOneId               = s"${vacancyFormId}_datafield_65039_1_1_12684"
  def interviewTwoId               = s"${vacancyFormId}_datafield_65043_1_1_12684"
  def interviewThreeId             = s"${vacancyFormId}_datafield_65047_1_1_12684"
  def interviewFourId              = s"${vacancyFormId}_datafield_65051_1_1_12684"
  def interviewFiveId              = s"${vacancyFormId}_datafield_65055_1_1_12684"
  def interviewSixId               = s"${vacancyFormId}_datafield_65059_1_1_12684"
  def interviewSevenId             = s"${vacancyFormId}_datafield_65063_1_1_12684"
  def interviewEightId             = s"${vacancyFormId}_datafield_65067_1_1_12684"

  def selectTechnicalSkills(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    if (vXTechSkillsRequired) {
      vXListOfTechSkills.clear()
      vXListOfTechSkillsDescription.clear()
      vXListOfSkillsApplicationRequired.clear()
      vXListOfSkillsInterviewRequired.clear()
      vXHowManySkills = techSkills.map(_.howManySkills).get
      selectHowManyTechSkills(vXHowManySkills)
      techSkillsRequired(successProfilesDetails)
    }
  }

  private def selectHowManyTechSkills(howMany: Int): Unit = {
    scrollToElement(By.id(techSkillsSectionId))
    waitForVisibilityOfElementById(howManyTechSkillsId).click()
    selectOption(generalInput, howMany.toString)
  }

  private def selectTechSkillsOne(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    waitForVisibilityOfElementById(techSkillsOneId)
    val skill            = techSkills.map(_.techSkillsOne.skillName).get
    val skillDescription = techSkills.map(_.techSkillsOne.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsOne.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsOne.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsOneId, skill)
    selectOptionWithId(techSkillsOneDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationOneId).select()
    if (interviewStage) checkbox(interviewOneId).select()
  }

  private def selectTechSkillsTwo(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsTwo.skillName).get
    val skillDescription = techSkills.map(_.techSkillsTwo.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsTwo.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsTwo.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsTwoId, skill)
    selectOptionWithId(techSkillsTwoDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationTwoId).select()
    if (interviewStage) checkbox(interviewTwoId).select()
  }

  private def selectTechSkillsThree(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsThree.skillName).get
    val skillDescription = techSkills.map(_.techSkillsThree.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsThree.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsThree.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsThreeId, skill)
    selectOptionWithId(techSkillsThreeDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationThreeId).select()
    if (interviewStage) checkbox(interviewThreeId).select()
  }

  private def selectTechSkillsFour(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsFour.skillName).get
    val skillDescription = techSkills.map(_.techSkillsFour.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsFour.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsFour.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsFourId, skill)
    selectOptionWithId(techSkillsFourDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationFourId).select()
    if (interviewStage) checkbox(interviewFourId).select()
  }

  private def selectTechSkillsFive(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsFive.skillName).get
    val skillDescription = techSkills.map(_.techSkillsFive.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsFive.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsFive.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsFiveId, skill)
    selectOptionWithId(techSkillsFiveDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationFiveId).select()
    if (interviewStage) checkbox(interviewFiveId).select()
  }

  private def selectTechSkillsSix(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsSix.skillName).get
    val skillDescription = techSkills.map(_.techSkillsSix.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsSix.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsSix.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsSixId, skill)
    selectOptionWithId(techSkillsSixDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationSixId).select()
    if (interviewStage) checkbox(interviewSixId).select()
  }

  private def selectTechSkillsSeven(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsSeven.skillName).get
    val skillDescription = techSkills.map(_.techSkillsSeven.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsSeven.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsSeven.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsSevenId, skill)
    selectOptionWithId(techSkillsSevenDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationSevenId).select()
    if (interviewStage) checkbox(interviewSevenId).select()
  }

  private def selectTechSkillsEight(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsEight.skillName).get
    val skillDescription = techSkills.map(_.techSkillsEight.skillDescription.get).get
    val applicationStage = techSkills.map(_.techSkillsEight.applicationRequired).get
    val interviewStage   = techSkills.map(_.techSkillsEight.interviewRequired).get
    vXListOfTechSkills += skill
    vXListOfTechSkillsDescription += skillDescription
    vXListOfSkillsApplicationRequired += applicationStage
    vXListOfSkillsInterviewRequired += interviewStage
    selectOptionWithId(techSkillsEightId, skill)
    selectOptionWithId(techSkillsEightDescriptionId, skillDescription)
    if (applicationStage) checkbox(applicationEightId).select()
    if (interviewStage) checkbox(interviewEightId).select()
  }

  private val techSkills: Seq[SuccessProfilesDetails => Unit] = Seq(
    selectTechSkillsOne,
    selectTechSkillsTwo,
    selectTechSkillsThree,
    selectTechSkillsFour,
    selectTechSkillsFive,
    selectTechSkillsSix,
    selectTechSkillsSeven,
    selectTechSkillsEight
  )

  private def techSkillsRequired(successProfilesDetails: SuccessProfilesDetails): Unit = {
    techSkills.take(vXHowManySkills).foreach { f =>
      f(successProfilesDetails)
    }
    println(vXListOfTechSkills)
    println(vXListOfTechSkillsDescription)
    println(vXListOfSkillsApplicationRequired)
    println(vXListOfSkillsInterviewRequired)
    println("Done tech skills")
  }
}
