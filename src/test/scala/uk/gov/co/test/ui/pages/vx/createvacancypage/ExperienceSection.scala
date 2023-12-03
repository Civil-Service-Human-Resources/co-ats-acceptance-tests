package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

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

  private lazy val provideCvYesId                 = s"${formId}_datafield_59983_1_1_1"
  private lazy val provideCvNoId                  = s"${formId}_datafield_59983_1_1_2"
  private lazy val cvScore0to7Id                  = s"${formId}_datafield_187853_1_1_50711"
  private lazy val cvScore0to100Id                = s"${formId}_datafield_187853_1_1_50712"
  private lazy val jobHistoryYesId                = s"${formId}_datafield_60080_1_1_1"
  private lazy val jobHistoryNoId                 = s"${formId}_datafield_60080_1_1_2"
  private lazy val qualificationDetailsYesId      = s"${formId}_datafield_60086_1_1_1"
  private lazy val qualificationDetailsNoId       = s"${formId}_datafield_60086_1_1_2"
  private lazy val previousSkillsYesId            = s"${formId}_datafield_60090_1_1_1"
  private lazy val previousSkillsNoId             = s"${formId}_datafield_60090_1_1_2"
  private lazy val personalStatementYesId         = s"${formId}_datafield_59992_1_1_1"
  private lazy val personalStatementNoId          = s"${formId}_datafield_59992_1_1_2"
  private lazy val statementScore0to7Id           = s"${formId}_datafield_187857_1_1_50711"
  private lazy val statementScore0to100Id         = s"${formId}_datafield_187857_1_1_50712"
  private lazy val statementWordLimitId           = s"select2-${formId}_datafield_72066_1_1-container"
  private lazy val guidanceTextYesId              = s"${formId}_datafield_59989_1_1_1"
  private lazy val guidanceTextNoId               = s"${formId}_datafield_59989_1_1_2"
  private lazy val guidanceTextInputId            = s"${formId}_datafield_60060_1_1_en-GB"
  private lazy val pastExperiencesYesId           = s"${formId}_datafield_60105_1_1_1"
  private lazy val pastExperiencesNoId            = s"${formId}_datafield_60105_1_1_2"
  private lazy val pastExperiencesInputId         = s"${formId}_datafield_116298_1_1_en-GB"
  private lazy val mandatoryLicencesYesId         = s"${formId}_datafield_60168_1_1_1"
  private lazy val mandatoryLicencesNoId          = s"${formId}_datafield_60168_1_1_2"
  private lazy val mandatoryLicencesInputId       = s"${formId}_datafield_60172_1_1_en-GB"
  private lazy val mandatoryMembershipsYesId      = s"${formId}_datafield_60185_1_1_1"
  private lazy val mandatoryMembershipsNoId       = s"${formId}_datafield_60185_1_1_2"
  private lazy val mandatoryMembershipsInputId    = s"${formId}_datafield_60179_1_1_en-GB"
  private lazy val mandatoryLanguagesYesId        = s"${formId}_datafield_60190_1_1_1"
  private lazy val mandatoryLanguagesNoId         = s"${formId}_datafield_60190_1_1_2"
  private lazy val mandatoryLanguagesInputId      = s"${formId}_datafield_60200_1_1_en-GB"
  private lazy val mandatoryQualificationsYesId   = s"${formId}_datafield_60215_1_1_1"
  private lazy val mandatoryQualificationsNoId    = s"${formId}_datafield_60215_1_1_2"
  private lazy val mandatoryQualificationsInputId = s"${formId}_datafield_60209_1_1_en-GB"
  var licencesMandatory: String                   = ""
  var membershipsMandatory: String                = ""
  var languagesMandatory: String                  = ""
  var qualificationsMandatory: String             = ""
  var vXGuidanceText: String                      = ""

  private def provideCV(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val cv = successProfilesDetails.experienceSection
    if (cv.map(_.provideCV).get) clickOnRadioButton(provideCvYesId) else clickOnRadioButton(provideCvNoId)
  }

  private def selectCVScoreRange(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val score = successProfilesDetails.experienceSection
    score.map(_.cvScoreRange).get match {
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
    if (statement.map(_.provideStatement).get) {
      clickOnRadioButton(personalStatementYesId)
      statement.map(_.statementScoreRange).get match {
        case "0 - 100" => clickOnRadioButton(statementScore0to100Id)
        case "0 - 7"   => clickOnRadioButton(statementScore0to7Id)
        case _         => throw new IllegalStateException("Personal Statement score not correct")
      }
      selectStatementWordLimit(successProfilesDetails)
    } else clickOnRadioButton(personalStatementNoId)
  }

  private def selectStatementWordLimit(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val limit = successProfilesDetails.experienceSection.map(_.statementWordLimit).get.toString
    scrollToElement(By.id(statementWordLimitId))
    waitForVisibilityOfElementById(statementWordLimitId).click()
    action().moveToElement(waitForDropdownOption(limit)).perform()
    waitForDropdownOption(limit).click()
  }

  private def selectStatementGuidanceText(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val guidance = successProfilesDetails.experienceSection
    if (guidance.map(_.statementGuidance).get) {
      clickOnRadioButton(guidanceTextYesId)
      enterGuidanceText(successProfilesDetails)
    } else clickOnRadioButton(guidanceTextNoId)
  }

  private def enterGuidanceText(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val text         = successProfilesDetails.experienceSection
    vXGuidanceText = text.map(_.statementGuidanceText).get
    val guidanceText = waitForVisibilityOfElementById(guidanceTextInputId)
    guidanceText.sendKeys(vXGuidanceText)
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
    pastExperience.sendKeys(pastExperienceText)
  }

  private def selectMandatoryLicences(successProfilesDetails: SuccessProfilesDetails): Unit = {
    licencesMandatory = successProfilesDetails.experienceSection.map(_.licences.map(_.requirements).get).get.toString
    if (licencesMandatory.toBoolean) {
      clickOnRadioButton(mandatoryLicencesYesId)
      enterLicenceRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryLicencesNoId)
  }

  private def enterLicenceRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.licences.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryLicencesInputId)
    requirement.sendKeys(requirementInfo)
  }

  private def selectMandatoryMemberships(successProfilesDetails: SuccessProfilesDetails): Unit = {
    membershipsMandatory =
      successProfilesDetails.experienceSection.map(_.memberships.map(_.requirements).get).get.toString
    if (membershipsMandatory.toBoolean) {
      clickOnRadioButton(mandatoryMembershipsYesId)
      enterMembershipsRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryMembershipsNoId)
  }

  private def enterMembershipsRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.memberships.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryMembershipsInputId)
    requirement.sendKeys(requirementInfo)
  }

  private def selectMandatoryLanguages(successProfilesDetails: SuccessProfilesDetails): Unit = {
    languagesMandatory = successProfilesDetails.experienceSection.map(_.languages.map(_.requirements).get).get.toString
    if (languagesMandatory.toBoolean) {
      clickOnRadioButton(mandatoryLanguagesYesId)
      enterLanguagesRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryLanguagesNoId)
  }

  private def enterLanguagesRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.languages.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryLanguagesInputId)
    requirement.sendKeys(requirementInfo)
  }

  private def selectMandatoryQualifications(successProfilesDetails: SuccessProfilesDetails): Unit = {
    qualificationsMandatory =
      successProfilesDetails.experienceSection.map(_.qualifications.map(_.requirements).get).get.toString
    if (qualificationsMandatory.toBoolean) {
      clickOnRadioButton(mandatoryQualificationsYesId)
      enterQualificationsRequirements(successProfilesDetails)
    } else clickOnRadioButton(mandatoryQualificationsNoId)
  }

  private def enterQualificationsRequirements(successProfilesDetails: SuccessProfilesDetails): Unit = {
    val requirementInfo = successProfilesDetails.experienceSection.map(_.qualifications.map(_.requirementsInfo).get).get
    val requirement     = waitForVisibilityOfElementById(mandatoryQualificationsInputId)
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

  def experiencesRequired(successProfilesDetails: SuccessProfilesDetails): Unit =
    experiences.foreach { f =>
      f(successProfilesDetails)
    }

}
