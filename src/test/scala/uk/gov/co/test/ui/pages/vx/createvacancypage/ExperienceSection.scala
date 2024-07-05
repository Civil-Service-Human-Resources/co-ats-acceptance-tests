package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCvAttachment, vXCvScoreRange, vXDesirablePastExperience, vXFullQualification, vXJobHistory, vXLanguagesMandatory, vXLicencesMandatory, vXMembershipsMandatory, vXPersonalStatement, vXPersonalStatementNameBlind, vXPreviousExperiences, vXProvideNameBlindCv, vXQualificationsMandatory, vXSpecificLanguages, vXSpecificLicences, vXSpecificMemberships, vXSpecificPastExperience, vXSpecificQualifications, vXStatementGuidance, vXStatementGuidanceText, vXStatementScoreRange, vXStatementWordLimit, vacancyFormId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class MandatoryRequirements(requirements: Boolean, requirementsInfo: String)

case class ExperienceDetails(
  provideNameBlindCv: Boolean,
  cvAttachment: Boolean,
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

  def provideNameBlindCvYesId          = s"${vacancyFormId}_datafield_59983_1_1_1"
  def provideNameBlindCvNoId           = s"${vacancyFormId}_datafield_59983_1_1_2"
  def cvAttachmentTextId               = s"${vacancyFormId}_field_que_59980_1"
  def provideNameBlindCvTextId         = s"${vacancyFormId}_field_que_59983_1"
  def cvAttachmentYesId                = s"${vacancyFormId}_datafield_59980_1_1_1"
  def cvAttachmentNoId                 = s"${vacancyFormId}_datafield_59980_1_1_2"
  def cvScore0to7Id                    = s"${vacancyFormId}_datafield_187853_1_1_50711"
  def cvScore0to100Id                  = s"${vacancyFormId}_datafield_187853_1_1_50712"
  def jobHistoryYesId                  = s"${vacancyFormId}_datafield_60080_1_1_1"
  def jobHistoryNoId                   = s"${vacancyFormId}_datafield_60080_1_1_2"
  def qualificationDetailsYesId        = s"${vacancyFormId}_datafield_60086_1_1_1"
  def qualificationDetailsNoId         = s"${vacancyFormId}_datafield_60086_1_1_2"
  def previousSkillsYesId              = s"${vacancyFormId}_datafield_60090_1_1_1"
  def previousSkillsNoId               = s"${vacancyFormId}_datafield_60090_1_1_2"
  def personalStatementTextId          = s"${vacancyFormId}_field_que_59986_1"
  def personalStatementYesId           = s"${vacancyFormId}_datafield_59986_1_1_1"
  def personalStatementNoId            = s"${vacancyFormId}_datafield_59986_1_1_2"
  def personalStatementNameBlindTextId = s"${vacancyFormId}_field_que_59992_1"
  def personalStatementNameBlindYesId  = s"${vacancyFormId}_datafield_59992_1_1_1"
  def personalStatementNameBlindNoId   = s"${vacancyFormId}_datafield_59992_1_1_2"
  def statementScore0to7Id             = s"${vacancyFormId}_datafield_187857_1_1_50711"
  def statementScore0to100Id           = s"${vacancyFormId}_datafield_187857_1_1_50712"
  def statementWordLimitId             = s"select2-${vacancyFormId}_datafield_72066_1_1-container"
  def guidanceTextYesId                = s"${vacancyFormId}_datafield_59989_1_1_1"
  def guidanceTextNoId                 = s"${vacancyFormId}_datafield_59989_1_1_2"
  def guidanceTextInputId              = s"${vacancyFormId}_datafield_60060_1_1_en-GB"
  def pastExperiencesYesId             = s"${vacancyFormId}_datafield_60105_1_1_1"
  def pastExperiencesNoId              = s"${vacancyFormId}_datafield_60105_1_1_2"
  def pastExperiencesInputId           = s"${vacancyFormId}_datafield_116298_1_1_en-GB"
  def mandatoryLicencesYesId           = s"${vacancyFormId}_datafield_60168_1_1_1"
  def mandatoryLicencesNoId            = s"${vacancyFormId}_datafield_60168_1_1_2"
  def mandatoryLicencesInputId         = s"${vacancyFormId}_datafield_60172_1_1_en-GB"
  def mandatoryMembershipsYesId        = s"${vacancyFormId}_datafield_60185_1_1_1"
  def mandatoryMembershipsNoId         = s"${vacancyFormId}_datafield_60185_1_1_2"
  def mandatoryMembershipsInputId      = s"${vacancyFormId}_datafield_60179_1_1_en-GB"
  def mandatoryLanguagesYesId          = s"${vacancyFormId}_datafield_60190_1_1_1"
  def mandatoryLanguagesNoId           = s"${vacancyFormId}_datafield_60190_1_1_2"
  def mandatoryLanguagesInputId        = s"${vacancyFormId}_datafield_60200_1_1_en-GB"
  def mandatoryQualificationsYesId     = s"${vacancyFormId}_datafield_60215_1_1_1"
  def mandatoryQualificationsNoId      = s"${vacancyFormId}_datafield_60215_1_1_2"
  def mandatoryQualificationsInputId   = s"${vacancyFormId}_datafield_60209_1_1_en-GB"

//  private def provideCV(successProfilesDetails: SuccessProfilesDetails): Unit = {
//    val cv = successProfilesDetails.experienceSection
//    vXProvideNameBlindCv = cv.map(_.provideNameBlindCv).get
//    if (vXProvideNameBlindCv) clickOnRadioButton(provideNameBlindCvYesId)
//    else clickOnRadioButton(provideNameBlindCvNoId)
//  }

  private def selectRequestCv(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val cv           = successProfilesDetails.experienceSection
    vXProvideNameBlindCv = cv.map(_.provideNameBlindCv).get
    vXCvAttachment = cv.map(_.cvAttachment).get
    vXJobHistory = false
    vXFullQualification = false
    vXPreviousExperiences = false
//    val provideNameBlindCv = driver.findElements(By.id(provideNameBlindCvTextId))
    val cvAttachment = driver.findElements(By.id(cvAttachmentTextId))
    if (!cvAttachment.isEmpty) {
      vXProvideNameBlindCv = (_: Boolean)
      if (vXCvAttachment) {
        clickOnRadioButton(cvAttachmentYesId)
        selectCVScoreRange(successProfilesDetails)
      } else {
        clickOnRadioButton(cvAttachmentNoId)
      }
    } else {
      vXCvAttachment = (_: Boolean)
      if (vXProvideNameBlindCv) {
        clickOnRadioButton(provideNameBlindCvYesId)
        selectCVScoreRange(successProfilesDetails)
        selectJobHistory(successProfilesDetails)
        selectQualificationDetails(successProfilesDetails)
        selectPreviousSkills(successProfilesDetails)
      } else {
        clickOnRadioButton(provideNameBlindCvNoId)
      }
    }
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
    vXJobHistory = history.map(_.cvJobHistory).get
    if (vXJobHistory) clickOnRadioButton(jobHistoryYesId) else clickOnRadioButton(jobHistoryNoId)
  }

  private def selectQualificationDetails(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val qualifications = successProfilesDetails.experienceSection
    vXFullQualification = qualifications.map(_.cvQualifications).get
    if (vXFullQualification) clickOnRadioButton(qualificationDetailsYesId)
    else clickOnRadioButton(qualificationDetailsNoId)
  }

  private def selectPreviousSkills(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val qualifications = successProfilesDetails.experienceSection
    vXPreviousExperiences = qualifications.map(_.cvPreviousSkills).get
    if (vXPreviousExperiences) clickOnRadioButton(previousSkillsYesId)
    else clickOnRadioButton(previousSkillsNoId)
  }

  private def selectProvideStatement(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val statement = successProfilesDetails.experienceSection
    vXPersonalStatementNameBlind = statement.map(_.provideStatement).get
    vXPersonalStatement = statement.map(_.provideStatement).get

    val personalStatementNameBlind = driver.findElements(By.id(personalStatementNameBlindTextId))
//    val personalStatement          = driver.findElements(By.id(personalStatementTextId))

    if (!personalStatementNameBlind.isEmpty) {
      vXPersonalStatement = (_: Boolean)
      if (vXPersonalStatementNameBlind) {
        clickOnRadioButton(personalStatementNameBlindYesId)
        selectStatementNameBlindScoreRange(successProfilesDetails)
        selectStatementWordLimit(successProfilesDetails)
        selectStatementGuidanceText(successProfilesDetails)
      } else clickOnRadioButton(personalStatementNameBlindNoId)
    } else {
      vXPersonalStatementNameBlind = (_: Boolean)
      if (vXPersonalStatement) {
        clickOnRadioButton(personalStatementYesId)
        selectStatementNameBlindScoreRange(successProfilesDetails)
        selectStatementGuidanceText(successProfilesDetails)
      } else clickOnRadioButton(personalStatementNoId)
    }
  }

  private def selectStatementNameBlindScoreRange(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val statement = successProfilesDetails.experienceSection
    vXStatementScoreRange = statement.map(_.statementScoreRange).get
    vXStatementScoreRange match {
      case "0 - 100" => clickOnRadioButton(statementScore0to100Id)
      case "0 - 7"   => clickOnRadioButton(statementScore0to7Id)
      case _         => throw new IllegalStateException("Personal Statement score not correct")
    }
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
    vXDesirablePastExperience = successProfilesDetails.experienceSection.map(_.pastExperience).get
    if (vXDesirablePastExperience) {
      clickOnRadioButton(pastExperiencesYesId)
      enterPastExperience(successProfilesDetails)
    } else clickOnRadioButton(pastExperiencesNoId)
  }

  private def enterPastExperience(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXSpecificPastExperience = successProfilesDetails.experienceSection.map(_.pastExperienceText).get
    val pastExperience = waitForVisibilityOfElementById(pastExperiencesInputId)
    pastExperience.clear()
    pastExperience.sendKeys(vXSpecificPastExperience)
  }

  private def selectMandatoryLicences(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXLicencesMandatory = successProfilesDetails.experienceSection.map(_.licences.map(_.requirements).get).get
    if (vXLicencesMandatory) {
      clickOnRadioButton(mandatoryLicencesYesId)
      enterLicenceRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryLicencesNoId)
  }

  private def enterLicenceRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXSpecificLicences = successProfilesDetails.experienceSection.map(_.licences.map(_.requirementsInfo).get).get
    val requirement = waitForVisibilityOfElementById(mandatoryLicencesInputId)
    requirement.clear()
    requirement.sendKeys(vXSpecificLicences)
  }

  private def selectMandatoryMemberships(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXMembershipsMandatory = successProfilesDetails.experienceSection.map(_.memberships.map(_.requirements).get).get
    if (vXMembershipsMandatory) {
      clickOnRadioButton(mandatoryMembershipsYesId)
      enterMembershipsRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryMembershipsNoId)
  }

  private def enterMembershipsRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXSpecificMemberships = successProfilesDetails.experienceSection.map(_.memberships.map(_.requirementsInfo).get).get
    val requirement = waitForVisibilityOfElementById(mandatoryMembershipsInputId)
    requirement.clear()
    requirement.sendKeys(vXSpecificMemberships)
  }

  private def selectMandatoryLanguages(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXLanguagesMandatory = successProfilesDetails.experienceSection.map(_.languages.map(_.requirements).get).get
    if (vXLanguagesMandatory) {
      clickOnRadioButton(mandatoryLanguagesYesId)
      enterLanguagesRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryLanguagesNoId)
  }

  private def enterLanguagesRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    vXSpecificLanguages = successProfilesDetails.experienceSection.map(_.languages.map(_.requirementsInfo).get).get
    val requirement = waitForVisibilityOfElementById(mandatoryLanguagesInputId)
    requirement.clear()
    requirement.sendKeys(vXSpecificLanguages)
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
    vXSpecificQualifications =
      successProfilesDetails.experienceSection.map(_.qualifications.map(_.requirementsInfo).get).get
    val requirement = waitForVisibilityOfElementById(mandatoryQualificationsInputId)
    requirement.clear()
    requirement.sendKeys(vXSpecificQualifications)
  }

  private val experiences: Seq[SuccessProfilesDetails => Unit] = Seq(
    selectRequestCv,
    selectProvideStatement,
    selectPastExperiences,
    selectMandatoryLicences,
    selectMandatoryMemberships,
    selectMandatoryLanguages,
    selectMandatoryQualifications
  )

  def selectExperiences(successProfilesDetails: SuccessProfilesDetails): Unit =
    experiences.foreach { f =>
      f(successProfilesDetails)
    }

}
