package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

import scala.collection.mutable.ListBuffer

case class TechSkills(techSkill: String, description: String, techApplication: Boolean, techInterview: Boolean)

case class TechSkillsDetails(
  howManySkills: Int,
  techSkillsOne: Option[TechSkills] = None,
  techSkillsTwo: Option[TechSkills] = None,
  techSkillsThree: Option[TechSkills] = None,
  techSkillsFour: Option[TechSkills] = None,
  techSkillsFive: Option[TechSkills] = None,
  techSkillsSix: Option[TechSkills] = None,
  techSkillsSeven: Option[TechSkills] = None,
  techSkillsEight: Option[TechSkills] = None
)

object TechnicalSkillsSection extends VacancyBasePage {

  def techSkillsSectionId          = s"${formId}_section_60768_col_0"
  def howManyTechSkillsId          = s"select2-${formId}_datafield_60774_1_1-container"
  def techSkillsOneId              = s"${formId}_datafield_60779_1_1_en-GB"
  def techSkillsTwoId              = s"${formId}_datafield_60791_1_1_en-GB"
  def techSkillsThreeId            = s"${formId}_datafield_60803_1_1_en-GB"
  def techSkillsFourId             = s"${formId}_datafield_60815_1_1_en-GB"
  def techSkillsFiveId             = s"${formId}_datafield_60827_1_1_en-GB"
  def techSkillsSixId              = s"${formId}_datafield_60839_1_1_en-GB"
  def techSkillsSevenId            = s"${formId}_datafield_60874_1_1_en-GB"
  def techSkillsEightId            = s"${formId}_datafield_60886_1_1_en-GB"
  def techSkillsOneDescriptionId   = s"${formId}_datafield_60785_1_1_en-GB"
  def techSkillsTwoDescriptionId   = s"${formId}_datafield_60797_1_1_en-GB"
  def techSkillsThreeDescriptionId = s"${formId}_datafield_60809_1_1_en-GB"
  def techSkillsFourDescriptionId  = s"${formId}_datafield_60821_1_1_en-GB"
  def techSkillsFiveDescriptionId  = s"${formId}_datafield_60833_1_1_en-GB"
  def techSkillsSixDescriptionId   = s"${formId}_datafield_60845_1_1_en-GB"
  def techSkillsSevenDescriptionId = s"${formId}_datafield_60880_1_1_en-GB"
  def techSkillsEightDescriptionId = s"${formId}_datafield_60892_1_1_en-GB"
  def applicationOneId             = s"${formId}_datafield_65039_1_1_12683"
  def applicationTwoId             = s"${formId}_datafield_65043_1_1_12683"
  def applicationThreeId           = s"${formId}_datafield_65047_1_1_12683"
  def applicationFourId            = s"${formId}_datafield_65051_1_1_12683"
  def applicationFiveId            = s"${formId}_datafield_65055_1_1_12683"
  def applicationSixId             = s"${formId}_datafield_65059_1_1_12683"
  def applicationSevenId           = s"${formId}_datafield_65063_1_1_12683"
  def applicationEightId           = s"${formId}_datafield_65067_1_1_12683"
  def interviewOneId               = s"${formId}_datafield_65039_1_1_12683"
  def interviewTwoId               = s"${formId}_datafield_65043_1_1_12684"
  def interviewThreeId             = s"${formId}_datafield_65047_1_1_12684"
  def interviewFourId              = s"${formId}_datafield_65051_1_1_12684"
  def interviewFiveId              = s"${formId}_datafield_65055_1_1_12684"
  def interviewSixId               = s"${formId}_datafield_65059_1_1_12684"
  def interviewSevenId             = s"${formId}_datafield_65063_1_1_12684"
  def interviewEightId             = s"${formId}_datafield_65067_1_1_12684"
  var howManySkills: Int           = 8
  var listOfTechSkills             = new ListBuffer[String]()
  var listOfTechSkillsDescription  = new ListBuffer[String]()

  def selectTechnicalSkills(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    if (successProfilesDetails.technicalSkills) {
      howManySkills = techSkills.map(_.howManySkills).get
      selectHowManyTechSkills(howManySkills)
      howManySkills match {
        case 1 => techSkillsRequired(successProfilesDetails, 1)
        case 2 => techSkillsRequired(successProfilesDetails, 2)
        case 3 => techSkillsRequired(successProfilesDetails, 3)
        case 4 => techSkillsRequired(successProfilesDetails, 4)
        case 5 => techSkillsRequired(successProfilesDetails, 5)
        case 6 => techSkillsRequired(successProfilesDetails, 6)
        case 7 => techSkillsRequired(successProfilesDetails, 7)
        case 8 => techSkillsRequired(successProfilesDetails, 8)
      }
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
    val skill            = techSkills.map(_.techSkillsOne.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsOne.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsOneId, skill)
    selectOptionWithId(techSkillsOneDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsOne.map(_.techApplication).get).get) checkbox(applicationOneId).select()
    if (techSkills.map(_.techSkillsOne.map(_.techInterview).get).get) checkbox(interviewOneId).select()
  }

  private def selectTechSkillsTwo(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsTwo.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsTwo.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsTwoId, skill)
    selectOptionWithId(techSkillsTwoDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsTwo.map(_.techApplication).get).get) checkbox(applicationTwoId).select()
    if (techSkills.map(_.techSkillsTwo.map(_.techInterview).get).get) checkbox(interviewTwoId).select()
  }

  private def selectTechSkillsThree(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsThree.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsThree.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsThreeId, skill)
    selectOptionWithId(techSkillsThreeDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsThree.map(_.techApplication).get).get) checkbox(applicationThreeId).select()
    if (techSkills.map(_.techSkillsThree.map(_.techInterview).get).get) checkbox(interviewThreeId).select()
  }

  private def selectTechSkillsFour(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsFour.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsFour.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsFourId, skill)
    selectOptionWithId(techSkillsFourDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsFour.map(_.techApplication).get).get) checkbox(applicationFourId).select()
    if (techSkills.map(_.techSkillsFour.map(_.techInterview).get).get) checkbox(interviewFourId).select()
  }

  private def selectTechSkillsFive(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsFive.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsFive.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsFiveId, skill)
    selectOptionWithId(techSkillsFiveDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsFive.map(_.techApplication).get).get) checkbox(applicationFiveId).select()
    if (techSkills.map(_.techSkillsFive.map(_.techInterview).get).get) checkbox(interviewFiveId).select()
  }

  private def selectTechSkillsSix(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsSix.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsSix.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsSixId, skill)
    selectOptionWithId(techSkillsSixDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsSix.map(_.techApplication).get).get) checkbox(applicationSixId).select()
    if (techSkills.map(_.techSkillsSix.map(_.techInterview).get).get) checkbox(interviewSixId).select()
  }

  private def selectTechSkillsSeven(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsSeven.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsSeven.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsSevenId, skill)
    selectOptionWithId(techSkillsSevenDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsSeven.map(_.techApplication).get).get) checkbox(applicationSevenId).select()
    if (techSkills.map(_.techSkillsSeven.map(_.techInterview).get).get) checkbox(interviewSevenId).select()
  }

  private def selectTechSkillsEight(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills       = successProfilesDetails.techSkillsSection
    val skill            = techSkills.map(_.techSkillsEight.map(_.techSkill).get).get
    val skillDescription = techSkills.map(_.techSkillsEight.map(_.description).get).get
    listOfTechSkills += skill
    listOfTechSkillsDescription += skillDescription
    selectOptionWithId(techSkillsEightId, skill)
    selectOptionWithId(techSkillsEightDescriptionId, skillDescription)
    if (techSkills.map(_.techSkillsEight.map(_.techApplication).get).get) checkbox(applicationEightId).select()
    if (techSkills.map(_.techSkillsEight.map(_.techInterview).get).get) checkbox(interviewEightId).select()
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

  private def techSkillsRequired(successProfilesDetails: SuccessProfilesDetails, take: Int): Unit =
    techSkills.take(take).foreach { f =>
      f(successProfilesDetails)
    }
}
