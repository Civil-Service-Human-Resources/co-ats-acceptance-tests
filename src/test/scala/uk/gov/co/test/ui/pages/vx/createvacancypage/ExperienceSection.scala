package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCvScoreRange, vXLanguagesMandatory, vXLicencesMandatory, vXMembershipsMandatory, vXPersonalStatement, vXQualificationsMandatory, vXStatementGuidance, vXStatementGuidanceText, vXStatementScoreRange, vXStatementWordLimit, vacancyFormId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class MandatoryRequirements(requirements: Boolean, requirementsInfo: String)

case class ExperienceDetails(
  provideCV: Boolean,
  cvScoreRange: String,
  cvJobHistory: Boolean,
  cvQualifications: Boolean,
  cvPreviousSkills: Boolean,
  provideStatement: Boolean,
  statementScoreRange: String,
  statementWordLimit: Int,
  statementGuidance: Boolean,
  statementGuidanceText: String,
  pastExperience: Boolean,
  pastExperienceText: String,
  licences: Option[MandatoryRequirements] = None,
  memberships: Option[MandatoryRequirements] = None,
  languages: Option[MandatoryRequirements] = None,
  qualifications: Option[MandatoryRequirements] = None
)

object ExperienceSection extends VacancyBasePage {

  def provideCvYesId                 = s"${vacancyFormId}_datafield_59983_1_1_1"
  def provideCvNoId                  = s"${vacancyFormId}_datafield_59983_1_1_2"
  def cvScore0to7Id                  = s"${vacancyFormId}_datafield_187853_1_1_50711"
  def cvScore0to100Id                = s"${vacancyFormId}_datafield_187853_1_1_50712"
  def jobHistoryYesId                = s"${vacancyFormId}_datafield_60080_1_1_1"
  def jobHistoryNoId                 = s"${vacancyFormId}_datafield_60080_1_1_2"
  def qualificationDetailsYesId      = s"${vacancyFormId}_datafield_60086_1_1_1"
  def qualificationDetailsNoId       = s"${vacancyFormId}_datafield_60086_1_1_2"
  def previousSkillsYesId            = s"${vacancyFormId}_datafield_60090_1_1_1"
  def previousSkillsNoId             = s"${vacancyFormId}_datafield_60090_1_1_2"
  def personalStatementYesId         = s"${vacancyFormId}_datafield_59992_1_1_1"
  def personalStatementNoId          = s"${vacancyFormId}_datafield_59992_1_1_2"
  def statementScore0to7Id           = s"${vacancyFormId}_datafield_187857_1_1_50711"
  def statementScore0to100Id         = s"${vacancyFormId}_datafield_187857_1_1_50712"
  def statementWordLimitId           = s"select2-${vacancyFormId}_datafield_72066_1_1-container"
  def guidanceTextYesId              = s"${vacancyFormId}_datafield_59989_1_1_1"
  def guidanceTextNoId               = s"${vacancyFormId}_datafield_59989_1_1_2"
  def guidanceTextInputId            = s"${vacancyFormId}_datafield_60060_1_1_en-GB"
  def pastExperiencesYesId           = s"${vacancyFormId}_datafield_60105_1_1_1"
  def pastExperiencesNoId            = s"${vacancyFormId}_datafield_60105_1_1_2"
  def pastExperiencesInputId         = s"${vacancyFormId}_datafield_116298_1_1_en-GB"
  def mandatoryLicencesYesId         = s"${vacancyFormId}_datafield_60168_1_1_1"
  def mandatoryLicencesNoId          = s"${vacancyFormId}_datafield_60168_1_1_2"
  def mandatoryLicencesInputId       = s"${vacancyFormId}_datafield_60172_1_1_en-GB"
  def mandatoryMembershipsYesId      = s"${vacancyFormId}_datafield_60185_1_1_1"
  def mandatoryMembershipsNoId       = s"${vacancyFormId}_datafield_60185_1_1_2"
  def mandatoryMembershipsInputId    = s"${vacancyFormId}_datafield_60179_1_1_en-GB"
  def mandatoryLanguagesYesId        = s"${vacancyFormId}_datafield_60190_1_1_1"
  def mandatoryLanguagesNoId         = s"${vacancyFormId}_datafield_60190_1_1_2"
  def mandatoryLanguagesInputId      = s"${vacancyFormId}_datafield_60200_1_1_en-GB"
  def mandatoryQualificationsYesId   = s"${vacancyFormId}_datafield_60215_1_1_1"
  def mandatoryQualificationsNoId    = s"${vacancyFormId}_datafield_60215_1_1_2"
  def mandatoryQualificationsInputId = s"${vacancyFormId}_datafield_60209_1_1_en-GB"

  private def provideCV(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val cv = successProfilesDetails.experienceSection
    if (cv.map(_.provideCV).get) clickOnRadioButton(provideCvYesId) else clickOnRadioButton(provideCvNoId)
  }

  private def selectCVScoreRange(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXCvScoreRange = successProfilesDetails.experienceSection.map(_.cvScoreRange).get
    vXCvScoreRange match {
      case "0 - 100" => clickOnRadioButton(cvScore0to100Id)
      case "0 - 7"   => clickOnRadioButton(cvScore0to7Id)
      case _         => throw new IllegalStateException("CV Score not correct")
    }
  }

  private def selectJobHistory(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val history = successProfilesDetails.experienceSection
    if (history.map(_.cvJobHistory).get) clickOnRadioButton(jobHistoryYesId) else clickOnRadioButton(jobHistoryNoId)
  }

  private def selectQualificationDetails(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val qualifications = successProfilesDetails.experienceSection
    if (qualifications.map(_.cvQualifications).get) clickOnRadioButton(qualificationDetailsYesId)
    else clickOnRadioButton(qualificationDetailsNoId)
  }

  private def selectPreviousSkills(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val qualifications = successProfilesDetails.experienceSection
    if (qualifications.map(_.cvPreviousSkills).get) clickOnRadioButton(previousSkillsYesId)
    else clickOnRadioButton(previousSkillsNoId)
  }

  private def selectProvideStatement(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val statement = successProfilesDetails.experienceSection
    vXPersonalStatement = statement.map(_.provideStatement).get
    if (vXPersonalStatement) {
      clickOnRadioButton(personalStatementYesId)
      vXStatementScoreRange = statement.map(_.statementScoreRange).get
      vXStatementScoreRange match {
        case "0 - 100" => clickOnRadioButton(statementScore0to100Id)
        case "0 - 7"   => clickOnRadioButton(statementScore0to7Id)
        case _         => throw new IllegalStateException("Personal Statement score not correct")
      }
      selectStatementWordLimit(successProfilesDetails)
    } else clickOnRadioButton(personalStatementNoId)
  }

  private def selectStatementWordLimit(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXStatementWordLimit = successProfilesDetails.experienceSection.map(_.statementWordLimit).get
    val limit = vXStatementWordLimit.toString
    scrollToElement(By.id(statementWordLimitId))
    waitForVisibilityOfElementById(statementWordLimitId).click()
    action().moveToElement(waitForDropdownOption(limit)).perform()
    waitForDropdownOption(limit).click()
  }

  private def selectStatementGuidanceText(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val guidance = successProfilesDetails.experienceSection
    vXStatementGuidance = guidance.map(_.statementGuidance).get
    if (vXStatementGuidance) {
      clickOnRadioButton(guidanceTextYesId)
      enterGuidanceText(successProfilesDetails)
    } else clickOnRadioButton(guidanceTextNoId)
  }

  private def enterGuidanceText(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val text         = successProfilesDetails.experienceSection
    vXStatementGuidanceText = text.map(_.statementGuidanceText).get
    val guidanceText = waitForVisibilityOfElementById(guidanceTextInputId)
    guidanceText.clear()
    guidanceText.sendKeys(vXStatementGuidanceText)
  }

  private def selectPastExperiences(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val pastExperience = successProfilesDetails.experienceSection.map(_.pastExperience).get
    if (pastExperience) {
      clickOnRadioButton(pastExperiencesYesId)
      enterPastExperience(successProfilesDetails)
    } else clickOnRadioButton(pastExperiencesNoId)
  }

  private def enterPastExperience(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val pastExperienceText = successProfilesDetails.experienceSection.map(_.pastExperienceText).get
    val pastExperience     = waitForVisibilityOfElementById(pastExperiencesInputId)
    pastExperience.clear()
    pastExperience.sendKeys(pastExperienceText)
  }

  private def selectMandatoryLicences(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXLicencesMandatory = successProfilesDetails.experienceSection.map(_.licences.map(_.requirements).get).get
    if (vXLicencesMandatory) {
      clickOnRadioButton(mandatoryLicencesYesId)
      enterLicenceRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryLicencesNoId)
  }

  private def enterLicenceRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.licences.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryLicencesInputId)
    requirement.clear()
    requirement.sendKeys(requirementInfo)
  }

  private def selectMandatoryMemberships(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXMembershipsMandatory = successProfilesDetails.experienceSection.map(_.memberships.map(_.requirements).get).get
    if (vXMembershipsMandatory) {
      clickOnRadioButton(mandatoryMembershipsYesId)
      enterMembershipsRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryMembershipsNoId)
  }

  private def enterMembershipsRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.memberships.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryMembershipsInputId)
    requirement.clear()
    requirement.sendKeys(requirementInfo)
  }

  private def selectMandatoryLanguages(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXLanguagesMandatory = successProfilesDetails.experienceSection.map(_.languages.map(_.requirements).get).get
    if (vXLanguagesMandatory) {
      clickOnRadioButton(mandatoryLanguagesYesId)
      enterLanguagesRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryLanguagesNoId)
  }

  private def enterLanguagesRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.languages.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryLanguagesInputId)
    requirement.clear()
    requirement.sendKeys(requirementInfo)
  }

  private def selectMandatoryQualifications(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXQualificationsMandatory =
      successProfilesDetails.experienceSection.map(_.qualifications.map(_.requirements).get).get
    if (vXQualificationsMandatory) {
      clickOnRadioButton(mandatoryQualificationsYesId)
      enterQualificationsRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryQualificationsNoId)
  }

  private def enterQualificationsRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.qualifications.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryQualificationsInputId)
    requirement.clear()
    requirement.sendKeys(requirementInfo)
  }

  private val experiences: Seq[SuccessProfilesDetails => Unit] = Seq(
    provideCV,
    selectCVScoreRange,
    selectJobHistory,
    selectQualificationDetails,
    selectPreviousSkills,
    selectProvideStatement,
    selectStatementGuidanceText,
    selectPastExperiences,
    selectMandatoryLicences,
    selectMandatoryMemberships,
    selectMandatoryLanguages,
    selectMandatoryQualifications
  )

  def selectExperiencesRequired(successProfilesDetails: SuccessProfilesDetails): Unit =
    experiences.foreach { f =>
      f(successProfilesDetails)
    }

}
