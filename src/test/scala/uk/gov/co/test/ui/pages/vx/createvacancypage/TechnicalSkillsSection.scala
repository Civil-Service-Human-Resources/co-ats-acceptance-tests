package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class Skills(techSkill: String, description: String, techApplication: Boolean, techInterview: Boolean)

case class TechSkillsDetails(
  howManySkills: Int,
  techSkillsOne: Option[Skills] = None,
  techSkillsTwo: Option[Skills] = None,
  techSkillsThree: Option[Skills] = None,
  techSkillsFour: Option[Skills] = None,
  techSkillsFive: Option[Skills] = None,
  techSkillsSix: Option[Skills] = None,
  techSkillsSeven: Option[Skills] = None,
  techSkillsEight: Option[Skills] = None
)

object TechnicalSkillsSection extends VacancyBasePage {

  private lazy val techSkillsSectionId          = s"${formId}_section_60768_col_0"
  private lazy val howManyTechSkillsId          = s"select2-${formId}_datafield_60774_1_1-container"
  private lazy val techSkillsOneId              = s"${formId}_datafield_60779_1_1_en-GB"
  private lazy val techSkillsTwoId              = s"${formId}_datafield_60791_1_1_en-GB"
  private lazy val techSkillsThreeId            = s"${formId}_datafield_60803_1_1_en-GB"
  private lazy val techSkillsFourId             = s"${formId}_datafield_60815_1_1_en-GB"
  private lazy val techSkillsFiveId             = s"${formId}_datafield_60827_1_1_en-GB"
  private lazy val techSkillsSixId              = s"${formId}_datafield_60839_1_1_en-GB"
  private lazy val techSkillsSevenId            = s"${formId}_datafield_60874_1_1_en-GB"
  private lazy val techSkillsEightId            = s"${formId}_datafield_60886_1_1_en-GB"
  private lazy val techSkillsOneDescriptionId   = s"${formId}_datafield_60785_1_1_en-GB"
  private lazy val techSkillsTwoDescriptionId   = s"${formId}_datafield_60797_1_1_en-GB"
  private lazy val techSkillsThreeDescriptionId = s"${formId}_datafield_60809_1_1_en-GB"
  private lazy val techSkillsFourDescriptionId  = s"${formId}_datafield_60821_1_1_en-GB"
  private lazy val techSkillsFiveDescriptionId  = s"${formId}_datafield_60833_1_1_en-GB"
  private lazy val techSkillsSixDescriptionId   = s"${formId}_datafield_60845_1_1_en-GB"
  private lazy val techSkillsSevenDescriptionId = s"${formId}_datafield_60880_1_1_en-GB"
  private lazy val techSkillsEightDescriptionId = s"${formId}_datafield_60892_1_1_en-GB"
  private lazy val applicationOneId             = s"${formId}_datafield_65039_1_1_12683"
  private lazy val applicationTwoId             = s"${formId}_datafield_65043_1_1_12683"
  private lazy val applicationThreeId           = s"${formId}_datafield_65047_1_1_12683"
  private lazy val applicationFourId            = s"${formId}_datafield_65051_1_1_12683"
  private lazy val applicationFiveId            = s"${formId}_datafield_65055_1_1_12683"
  private lazy val applicationSixId             = s"${formId}_datafield_65059_1_1_12683"
  private lazy val applicationSevenId           = s"${formId}_datafield_65063_1_1_12683"
  private lazy val applicationEightId           = s"${formId}_datafield_65067_1_1_12683"
  private lazy val interviewOneId               = s"${formId}_datafield_65039_1_1_12683"
  private lazy val interviewTwoId               = s"${formId}_datafield_65043_1_1_12684"
  private lazy val interviewThreeId             = s"${formId}_datafield_65047_1_1_12684"
  private lazy val interviewFourId              = s"${formId}_datafield_65051_1_1_12684"
  private lazy val interviewFiveId              = s"${formId}_datafield_65055_1_1_12684"
  private lazy val interviewSixId               = s"${formId}_datafield_65059_1_1_12684"
  private lazy val interviewSevenId             = s"${formId}_datafield_65063_1_1_12684"
  private lazy val interviewEightId             = s"${formId}_datafield_65067_1_1_12684"

  def selectTechnicalSkills(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    if (successProfilesDetails.technicalSkills) {
      selectHowManyTechSkills(techSkills.map(_.howManySkills).get)
      techSkills.map(_.howManySkills).get match {
        case 1 =>
          selectTechSkillsOne(successProfilesDetails)
        case 2 =>
          selectTechSkillsOne(successProfilesDetails)
          selectTechSkillsTwo(successProfilesDetails)
        case 3 =>
          selectTechSkillsOne(successProfilesDetails)
          selectTechSkillsTwo(successProfilesDetails)
          selectTechSkillsThree(successProfilesDetails)
        case 4 =>
          selectTechSkillsOne(successProfilesDetails)
          selectTechSkillsTwo(successProfilesDetails)
          selectTechSkillsThree(successProfilesDetails)
          selectTechSkillsFour(successProfilesDetails)
        case 5 =>
          selectTechSkillsOne(successProfilesDetails)
          selectTechSkillsTwo(successProfilesDetails)
          selectTechSkillsThree(successProfilesDetails)
          selectTechSkillsFour(successProfilesDetails)
          selectTechSkillsFive(successProfilesDetails)
        case 6 =>
          selectTechSkillsOne(successProfilesDetails)
          selectTechSkillsTwo(successProfilesDetails)
          selectTechSkillsThree(successProfilesDetails)
          selectTechSkillsFour(successProfilesDetails)
          selectTechSkillsFive(successProfilesDetails)
          selectTechSkillsSix(successProfilesDetails)
        case 7 =>
          selectTechSkillsOne(successProfilesDetails)
          selectTechSkillsTwo(successProfilesDetails)
          selectTechSkillsThree(successProfilesDetails)
          selectTechSkillsFour(successProfilesDetails)
          selectTechSkillsFive(successProfilesDetails)
          selectTechSkillsSix(successProfilesDetails)
          selectTechSkillsSeven(successProfilesDetails)
        case 8 =>
          selectTechSkillsOne(successProfilesDetails)
          selectTechSkillsTwo(successProfilesDetails)
          selectTechSkillsThree(successProfilesDetails)
          selectTechSkillsFour(successProfilesDetails)
          selectTechSkillsFive(successProfilesDetails)
          selectTechSkillsSix(successProfilesDetails)
          selectTechSkillsSeven(successProfilesDetails)
          selectTechSkillsEight(successProfilesDetails)
      }
    }
  }

  private def selectHowManyTechSkills(howMany: Int): Unit = {
    scrollToElement(By.id(techSkillsSectionId))
    waitForVisibilityOfElementById(howManyTechSkillsId).click()
    selectOption(generalInput, howMany.toString)
  }

  private def selectTechSkillsOne(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    waitForVisibilityOfElementById(techSkillsOneId)
    selectOptionWithId(techSkillsOneId, techSkills.map(_.techSkillsOne.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsOneDescriptionId, techSkills.map(_.techSkillsOne.map(_.description).get).get)
    if (techSkills.map(_.techSkillsOne.map(_.techApplication).get).get) checkbox(applicationOneId).select()
    if (techSkills.map(_.techSkillsOne.map(_.techInterview).get).get) checkbox(interviewOneId).select()
  }

  private def selectTechSkillsTwo(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    selectOptionWithId(techSkillsTwoId, techSkills.map(_.techSkillsTwo.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsTwoDescriptionId, techSkills.map(_.techSkillsTwo.map(_.description).get).get)
    if (techSkills.map(_.techSkillsTwo.map(_.techApplication).get).get) checkbox(applicationTwoId).select()
    if (techSkills.map(_.techSkillsTwo.map(_.techInterview).get).get) checkbox(interviewTwoId).select()
  }

  private def selectTechSkillsThree(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    selectOptionWithId(techSkillsThreeId, techSkills.map(_.techSkillsThree.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsThreeDescriptionId, techSkills.map(_.techSkillsThree.map(_.description).get).get)
    if (techSkills.map(_.techSkillsThree.map(_.techApplication).get).get) checkbox(applicationThreeId).select()
    if (techSkills.map(_.techSkillsThree.map(_.techInterview).get).get) checkbox(interviewThreeId).select()
  }

  private def selectTechSkillsFour(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    selectOptionWithId(techSkillsFourId, techSkills.map(_.techSkillsFour.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsFourDescriptionId, techSkills.map(_.techSkillsFour.map(_.description).get).get)
    if (techSkills.map(_.techSkillsFour.map(_.techApplication).get).get) checkbox(applicationFourId).select()
    if (techSkills.map(_.techSkillsFour.map(_.techInterview).get).get) checkbox(interviewFourId).select()
  }

  private def selectTechSkillsFive(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    selectOptionWithId(techSkillsFiveId, techSkills.map(_.techSkillsFive.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsFiveDescriptionId, techSkills.map(_.techSkillsFive.map(_.description).get).get)
    if (techSkills.map(_.techSkillsFive.map(_.techApplication).get).get) checkbox(applicationFiveId).select()
    if (techSkills.map(_.techSkillsFive.map(_.techInterview).get).get) checkbox(interviewFiveId).select()
  }

  private def selectTechSkillsSix(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    selectOptionWithId(techSkillsSixId, techSkills.map(_.techSkillsSix.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsSixDescriptionId, techSkills.map(_.techSkillsSix.map(_.description).get).get)
    if (techSkills.map(_.techSkillsSix.map(_.techApplication).get).get) checkbox(applicationSixId).select()
    if (techSkills.map(_.techSkillsSix.map(_.techInterview).get).get) checkbox(interviewSixId).select()
  }

  private def selectTechSkillsSeven(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    selectOptionWithId(techSkillsSevenId, techSkills.map(_.techSkillsSeven.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsSevenDescriptionId, techSkills.map(_.techSkillsSeven.map(_.description).get).get)
    if (techSkills.map(_.techSkillsSeven.map(_.techApplication).get).get) checkbox(applicationSevenId).select()
    if (techSkills.map(_.techSkillsSeven.map(_.techInterview).get).get) checkbox(interviewSevenId).select()
  }

  private def selectTechSkillsEight(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val techSkills = successProfilesDetails.techSkillsSection
    selectOptionWithId(techSkillsEightId, techSkills.map(_.techSkillsEight.map(_.techSkill).get).get)
    selectOptionWithId(techSkillsEightDescriptionId, techSkills.map(_.techSkillsEight.map(_.description).get).get)
    if (techSkills.map(_.techSkillsEight.map(_.techApplication).get).get) checkbox(applicationEightId).select()
    if (techSkills.map(_.techSkillsEight.map(_.techInterview).get).get) checkbox(interviewEightId).select()
  }
}
