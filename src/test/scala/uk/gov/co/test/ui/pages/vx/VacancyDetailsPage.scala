package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAbilitiesRequired, vXAnyAdditionalQuestions, vXAnyOnlineTests, vXApplicationClosingDate, vXApplicationLiveDate, vXApproach, vXAttachmentRequired, vXAvailableOutsideInNI, vXBehaviourApplicationRequired, vXBehaviourInterviewRequired, vXBehavioursRequired, vXBudgetaryApproval, vXBusinessArea, vXBusinessAreaDetail, vXCandidateInstructions, vXCandidateUploadIdentityDocs, vXCommunitiesInNIR, vXContactName, vXCostCentre, vXCrcCheckProvider, vXCrcLevel, vXDesirablePastExperience, vXDetailsForUploadIdentityDocs, vXEmailForQuestions, vXExperiencesRequired, vXFullQualification, vXGiveLocationPreference, vXGreatForVeterans, vXGuidanceText, vXHavePecMailbox, vXHowManyBehaviours, vXHowManyQuestions, vXHowManySkills, vXInterviewExpectedRounds, vXInterviewFourType, vXInterviewNumber, vXInterviewOneType, vXInterviewThreeType, vXInterviewTwoType, vXJobGradeEquivalent, vXJobGrades, vXJobHistory, vXJobInfoDepartment, vXLanguagesMandatory, vXLicencesMandatory, vXListOfChosenBehaviours, vXListOfSkillsApplicationRequired, vXListOfSkillsInterviewRequired, vXListOfTechSkills, vXListOfTechSkillsDescription, vXLocationDisplay, vXLocationType, vXManuallyCheckIdentityDocs, vXMaxLocations, vXMedicalRequired, vXMembershipsMandatory, vXNoOfJobsAvailable, vXNoPecOgdTransfer, vXNonReserved, vXOtherLocations, vXPecAdditionalCheck, vXPecBankruptcyCheck, vXPecCrc, vXPecEmploymentHistoryCheck, vXPecFraudCheck, vXPecGeneralInfo, vXPecHealthDisplayOptions, vXPecHealthRefCheck, vXPecHrEmailForNen, vXPecHrEmailForPn, vXPecIncludeAdditionalCheck, vXPecMailbox, vXPecNameOfAdditionalCheck, vXPecNen, vXPecNsv, vXPecNsvDisplayOptions, vXPecOgdSecurityCheck, vXPecOverseasCheck, vXPecPensionsCheck, vXPecPn, vXPecPreviousCivilEmploymentCheck, vXPecReferenceCheck, vXPecSelfEmploymentCheck, vXPecUseOgdProcess, vXPersonalStatement, vXPreSiftRequired, vXPreviousExperiences, vXProfession, vXProfile, vXQualificationsMandatory, vXQuestionOne, vXQuestionThree, vXQuestionTwo, vXRejectApplyingOnPromotion, vXRejectLanguagesNotHeld, vXRejectLicencesNotHeld, vXRejectLiveMisconduct, vXRejectMembershipsNotHeld, vXRejectNationalityReq, vXRejectNoRightToRemain, vXRejectPoorAttendance, vXRejectPoorPerformance, vXRejectProbation, vXRejectQualificationsNotHeld, vXReserveExtendLength, vXReserveExtendRequired, vXReserveListLength, vXReserveListRequired, vXRtwChecks, vXSpecificLanguages, vXSpecificLicences, vXSpecificMemberships, vXSpecificPastExperience, vXSpecificQualifications, vXSpecifyGuidance, vXStatementWordLimit, vXStrengthsRequired, vXTeamEmail, vXTechSkillsRequired, vXTypeOfRole, vXUseOnlinePecForms, vXVacanciesInNIR, vXVacancyHolderEmail, vXVacancyHolderName, vXVettingLevel, vXWhenRtwChecks, vXWhichIdentityChecks, vacancyFormId, vacancyId, vacancyName}
import uk.gov.co.test.ui.pages.v9.ApplicationDetailsPage.resetApplicationDetails
import uk.gov.co.test.ui.pages.vx.vacancytabs.SummaryTab.{vacancyActive, vacancyClosingDateId, vacancyLiveDateId}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

object VacancyDetailsPage extends VacancyBasePage {

  private lazy val dashboardPageTitle      = "Home : Civil Service Jobs - GOV.UK"
  private lazy val previewAdvertButtonPath = ".//a[@aria-label='Preview advert ']"
  private lazy val searchVacanciesPath     = ".//*[@class='textlabel' and text() = 'Search Vacancies']"
  private lazy val vacancyFormsPath        = ".//*[@class='main-label' and text()='Vacancy Forms']"
  private lazy val searchPath              = "selected_option"
  private lazy val searchInput             = "search_input"
  private lazy val matchingOption          = "matching_options"
  private lazy val matchedOption           = ".//li[@class='qs_option active']/a/span[1]"
  private lazy val searchForId             = "search_button"
  private lazy val appIdPath               = ".//*[@class='app_id']"
  private lazy val vacancyNamePath         = ".//span[@class='obj_name']"
  private lazy val checkLabelPath          = ".//input[@checked='checked']/following-sibling::label[1]"

  def departmentId                      = s"select2-${vacancyFormId}_datafield_155191_1_1-container"
  def businessAreaId                    = s"select2-${vacancyFormId}_datafield_155221_1_1-container"
  def whichProfessionId                 = s"select2-${vacancyFormId}_datafield_155435_1_1-container"
  def noOfJobsId                        = s"${vacancyFormId}_datafield_155332_1_1"
  def typeOfRoleId                      = s"select2-${vacancyFormId}_datafield_155369_1_1-container"
  def welshRequiredCheck                = s"${vacancyFormId}_datafield_179408_1_1"
  def businessAreaDetailId              = s"${vacancyFormId}_datafield_155206_1_1_en-GB"
  def typeOfRoleInput                   = s".//*[@aria-describedby='$typeOfRoleId']"
  def listOptionsPath                   = ".//li[@role='option']"
  def approachId                        = s"${vacancyFormId}_datafield_154380_1_1_fieldset"
  def approachExternalId                = s"${vacancyFormId}_datafield_154380_1_1_11774_label"
  def budgetaryApprovalId               = s"${vacancyFormId}_datafield_154507_1_1_fieldset"
  def costCentreId                      = s"${vacancyFormId}_datafield_154493_1_1"
  def reserveListRequiredId             = s"${vacancyFormId}_datafield_154633_1_1_fieldset"
  def reserveExtendRequiredId           = s"${vacancyFormId}_datafield_177141_1_1_fieldset"
  def reserveListLengthId               = s"select2-${vacancyFormId}_datafield_154637_1_1-container"
  def reserveOldExtendLengthId          = s"select2-${vacancyFormId}_datafield_177145_1_1-container"
  def reserveNewExtendLengthId          = s"select2-${vacancyFormId}_datafield_205583_1_1-container"
  def locationTypeId                    = s"select2-${vacancyFormId}_datafield_155639_1_1-container"
  def locationDisplayOverrideId         = s"${vacancyFormId}_datafield_155654_1_1_en-GB"
  def vacancyInNIId                     = s"${vacancyFormId}_datafield_155854_1_1_fieldset"
  def availableOutsideNIId              = s"${vacancyFormId}_datafield_155922_1_1_fieldset"
  def whichCommunitiesApplyId           = s"${vacancyFormId}_field_value_155869_1"
  def locationPreferencesId             = s"${vacancyFormId}_field_value_155799_1"
  def maxLocationPreferenceId           = s"select2-${vacancyFormId}_datafield_155818_1_1-container"
  def locationsToChooseId               = s"select2-${vacancyFormId}_datafield_155836_1_1-container"
  def interviewRoundsId                 = s"${vacancyFormId}_datafield_91703_1_1_fieldset"
  def interviewOneId                    = s"${vacancyFormId}_datafield_125056_1_1_fieldset"
  def interviewTwoId                    = s"${vacancyFormId}_datafield_125060_1_1_fieldset"
  def interviewThreeId                  = s"${vacancyFormId}_datafield_125063_1_1_fieldset"
  def interviewFourId                   = s"${vacancyFormId}_datafield_125066_1_1_fieldset"
  def interviewOfflineId                = s"${vacancyFormId}_datafield_125052_1_1_fieldset"
  def jobHistoryId                      = s"${vacancyFormId}_datafield_60080_1_1_fieldset"
  def fullQualificationsId              = s"${vacancyFormId}_datafield_60086_1_1_fieldset"
  def previousExperiencesId             = s"${vacancyFormId}_datafield_60090_1_1_fieldset"
  def personalStatementId               = s"${vacancyFormId}_datafield_59992_1_1_fieldset"
  def personalStatementWordLimitId      = s"select2-${vacancyFormId}_datafield_72066_1_1-container"
  def specifyGuidanceId                 = s"${vacancyFormId}_datafield_59989_1_1_fieldset"
  def guidanceTextId                    = s"${vacancyFormId}_datafield_60060_1_1_en-GB"
  def desirablePastExperienceId         = s"${vacancyFormId}_datafield_60105_1_1_fieldset"
  def specificDesirablePastExperienceId = s"${vacancyFormId}_datafield_116298_1_1_en-GB"
  def licencesMandatoryId               = s"${vacancyFormId}_datafield_60168_1_1_fieldset"
  def specificLicencesId                = s"${vacancyFormId}_datafield_60172_1_1_en-GB"
  def membershipsMandatoryId            = s"${vacancyFormId}_datafield_60185_1_1_fieldset"
  def specificMembershipsId             = s"${vacancyFormId}_datafield_60179_1_1_en-GB"
  def languagesMandatoryId              = s"${vacancyFormId}_datafield_60190_1_1_fieldset"
  def specificLanguagesId               = s"${vacancyFormId}_datafield_60200_1_1_en-GB"
  def qualificationsMandatoryId         = s"${vacancyFormId}_datafield_60215_1_1_fieldset"
  def specificQualificationsId          = s"${vacancyFormId}_datafield_60209_1_1_en-GB"
  def greatForVeteransId                = s"${vacancyFormId}_datafield_138150_1_1_fieldset"
  def abilitiesId                       = s"${vacancyFormId}_datafield_154245_1_1_12685"
  def behavioursId                      = s"${vacancyFormId}_datafield_154245_1_1_12686"
  def howManyBehavioursId               = s"select2-${vacancyFormId}_datafield_60326_1_1-container"
  def behaviourOneNameId                = s"select2-${vacancyFormId}_datafield_60342_1_1-container"
  def behaviourOneApplicationId         = s"${vacancyFormId}_datafield_60338_1_1_12683"
  def behaviourOneInterviewId           = s"${vacancyFormId}_datafield_60338_1_1_12684"
  def behaviourTwoNameId                = s"select2-${vacancyFormId}_datafield_60356_1_1-container"
  def behaviourTwoApplicationId         = s"${vacancyFormId}_datafield_60352_1_1_12683"
  def behaviourTwoInterviewId           = s"${vacancyFormId}_datafield_60352_1_1_12684"
  def behaviourThreeNameId              = s"select2-${vacancyFormId}_datafield_60370_1_1-container"
  def behaviourThreeApplicationId       = s"${vacancyFormId}_datafield_60366_1_1_12683"
  def behaviourThreeInterviewId         = s"${vacancyFormId}_datafield_60366_1_1_12684"
  def behaviourFourNameId               = s"select2-${vacancyFormId}_datafield_60384_1_1-container"
  def behaviourFourApplicationId        = s"${vacancyFormId}_datafield_60380_1_1_12683"
  def behaviourFourInterviewId          = s"${vacancyFormId}_datafield_60380_1_1_12684"
  def behaviourFiveNameId               = s"select2-${vacancyFormId}_datafield_60398_1_1-container"
  def behaviourFiveApplicationId        = s"${vacancyFormId}_datafield_60394_1_1_12683"
  def behaviourFiveInterviewId          = s"${vacancyFormId}_datafield_60394_1_1_12684"
  def behaviourSixNameId                = s"select2-${vacancyFormId}_datafield_60412_1_1-container"
  def behaviourSixApplicationId         = s"${vacancyFormId}_datafield_60408_1_1_12683"
  def behaviourSixInterviewId           = s"${vacancyFormId}_datafield_60408_1_1_12684"
  def behaviourSevenNameId              = s"select2-${vacancyFormId}_datafield_60426_1_1-container"
  def behaviourSevenApplicationId       = s"${vacancyFormId}_datafield_60422_1_1_12683"
  def behaviourSevenInterviewId         = s"${vacancyFormId}_datafield_60422_1_1_12684"
  def behaviourEightNameId              = s"select2-${vacancyFormId}_datafield_60440_1_1-container"
  def behaviourEightApplicationId       = s"${vacancyFormId}_datafield_60436_1_1_12683"
  def behaviourEightInterviewId         = s"${vacancyFormId}_datafield_60436_1_1_12684"
  def experienceId                      = s"${vacancyFormId}_datafield_154245_1_1_12687"
  def strengthsId                       = s"${vacancyFormId}_datafield_154245_1_1_12689"
  def technicalSkillsId                 = s"${vacancyFormId}_datafield_154245_1_1_12688"
  def howManySkillsId                   = s"select2-${vacancyFormId}_datafield_60774_1_1-container"
  def techSkillsOneNameId               = s"${vacancyFormId}_datafield_60779_1_1_en-GB"
  def techSkillsOneDescriptionId        = s"${vacancyFormId}_datafield_60785_1_1_en-GB"
  def techSkillsOneApplicationId        = s"${vacancyFormId}_datafield_65039_1_1_12683"
  def techSkillsOneInterviewId          = s"${vacancyFormId}_datafield_65039_1_1_12684"
  def techSkillsTwoNameId               = s"${vacancyFormId}_datafield_60791_1_1_en-GB"
  def techSkillsTwoDescriptionId        = s"${vacancyFormId}_datafield_60797_1_1_en-GB"
  def techSkillsTwoApplicationId        = s"${vacancyFormId}_datafield_65043_1_1_12683"
  def techSkillsTwoInterviewId          = s"${vacancyFormId}_datafield_65043_1_1_12684"
  def techSkillsThreeNameId             = s"${vacancyFormId}_datafield_60803_1_1_en-GB"
  def techSkillsThreeDescriptionId      = s"${vacancyFormId}_datafield_60809_1_1_en-GB"
  def techSkillsThreeApplicationId      = s"${vacancyFormId}_datafield_65047_1_1_12683"
  def techSkillsThreeInterviewId        = s"${vacancyFormId}_datafield_65047_1_1_12684"
  def techSkillsFourNameId              = s"${vacancyFormId}_datafield_60815_1_1_en-GB"
  def techSkillsFourDescriptionId       = s"${vacancyFormId}_datafield_60821_1_1_en-GB"
  def techSkillsFourApplicationId       = s"${vacancyFormId}_datafield_65051_1_1_12683"
  def techSkillsFourInterviewId         = s"${vacancyFormId}_datafield_65051_1_1_12684"
  def techSkillsFiveNameId              = s"${vacancyFormId}_datafield_60827_1_1_en-GB"
  def techSkillsFiveDescriptionId       = s"${vacancyFormId}_datafield_60833_1_1_en-GB"
  def techSkillsFiveApplicationId       = s"${vacancyFormId}_datafield_65055_1_1_12683"
  def techSkillsFiveInterviewId         = s"${vacancyFormId}_datafield_65055_1_1_12684"
  def techSkillsSixNameId               = s"${vacancyFormId}_datafield_60839_1_1_en-GB"
  def techSkillsSixDescriptionId        = s"${vacancyFormId}_datafield_60845_1_1_en-GB"
  def techSkillsSixApplicationId        = s"${vacancyFormId}_datafield_65059_1_1_12683"
  def techSkillsSixInterviewId          = s"${vacancyFormId}_datafield_65059_1_1_12684"
  def techSkillsSevenNameId             = s"${vacancyFormId}_datafield_60874_1_1_en-GB"
  def techSkillsSevenDescriptionId      = s"${vacancyFormId}_datafield_60880_1_1_en-GB"
  def techSkillsSevenApplicationId      = s"${vacancyFormId}_datafield_65063_1_1_12683"
  def techSkillsSevenInterviewId        = s"${vacancyFormId}_datafield_65063_1_1_12684"
  def techSkillsEightNameId             = s"${vacancyFormId}_datafield_60886_1_1_en-GB"
  def techSkillsEightDescriptionId      = s"${vacancyFormId}_datafield_60892_1_1_en-GB"
  def techSkillsEightApplicationId      = s"${vacancyFormId}_datafield_65067_1_1_12683"
  def techSkillsEightInterviewId        = s"${vacancyFormId}_datafield_65067_1_1_12684"
  def onlineTestsId                     = s"${vacancyFormId}_datafield_129689_1_1_fieldset"
  def rejectProbationId                 = s"${vacancyFormId}_datafield_61145_1_1_fieldset"
  def rejectApplyingOnPromotionId       = s"${vacancyFormId}_datafield_61177_1_1_fieldset"
  def rejectLiveMisconductId            = s"${vacancyFormId}_datafield_61149_1_1_fieldset"
  def rejectPoorPerformanceId           = s"${vacancyFormId}_datafield_61185_1_1_fieldset"
  def rejectPoorAttendanceId            = s"${vacancyFormId}_datafield_61181_1_1_fieldset"
  def rejectNationalityReqId            = s"${vacancyFormId}_datafield_61153_1_1_fieldset"
  def rejectNoRTRId                     = s"${vacancyFormId}_datafield_61193_1_1_fieldset"
  def rejectLicencesNotHeldId           = s"${vacancyFormId}_datafield_61161_1_1_fieldset"
  def rejectMembershipsNotHeldId        = s"${vacancyFormId}_datafield_61165_1_1_fieldset"
  def rejectLanguagesNotHeldId          = s"${vacancyFormId}_datafield_61169_1_1_fieldset"
  def rejectQualificationsNotHeldId     = s"${vacancyFormId}_datafield_61157_1_1_fieldset"
  def rejectPreSiftRequiredId           = s"${vacancyFormId}_datafield_62541_1_1_fieldset"
  def rejectAttachmentRequiredId        = s"${vacancyFormId}_datafield_61333_1_1_fieldset"
  def instructionsForCandidateId        = s"${vacancyFormId}_datafield_61355_1_1_en-GB"
  def additionalQuestionsId             = s"${vacancyFormId}_datafield_56152_1_1_fieldset"
  def howManyQuestionsId                = s"${vacancyFormId}_datafield_56156_1_1_fieldset"
  def questionOneId                     = s"${vacancyFormId}_datafield_56159_1_1_en-GB"
  def questionOTwoId                    = s"${vacancyFormId}_datafield_56165_1_1_en-GB"
  def questionThreeId                   = s"${vacancyFormId}_datafield_56171_1_1_en-GB"
  def useOnlinePecFormId                = s"select2-${vacancyFormId}_datafield_154299_1_1-container"
  def havePecMailboxId                  = s"select2-${vacancyFormId}_datafield_154310_1_1-container"
  def pecMailboxId                      = s"${vacancyFormId}_datafield_154303_1_1"
  def pecRtwCheckId                     = s"select2-${vacancyFormId}_datafield_98824_1_1-container"
  def jobGradeId                        = s"select2-${vacancyFormId}_datafield_154973_1_1-container"
  def jobGradeEquivalentId              = s"${vacancyFormId}_datafield_154981_1_1_en-GB"
  def vacancyHolderNameId               = s"${vacancyFormId}_datafield_115926_1_1"
  def contactNameId                     = s"${vacancyFormId}_datafield_59444_1_1"
  def emailForQuestionsId               = s"${vacancyFormId}_datafield_59457_1_1"
  def vacancyHolderEmailId              = s"${vacancyFormId}_datafield_115708_1_1"
  def teamEmailId                       = s"${vacancyFormId}_datafield_59450_1_1"
  def pecWhenRtwId                      = s"${vacancyFormId}_datafield_106424_1_1_fieldset"
  def pecWhichIdentityId                = s"${vacancyFormId}_datafield_184419_1_1_fieldset"
  def pecUploadIdentityDocsId           = s"${vacancyFormId}_datafield_159069_1_1_fieldset"
  def pecDetailsOfUploadId              = s"${vacancyFormId}_datafield_159299_1_1_en-GB"
  def pecManuallyUploadId               = s"${vacancyFormId}_datafield_181577_1_1_fieldset"
  def pecGeneralInfoId                  = s"select2-${vacancyFormId}_datafield_94582_1_1-container"
  def pecReferenceCheckId               = s"select2-${vacancyFormId}_datafield_94578_1_1-container"
  def pecBankruptcyCheckId              = s"select2-${vacancyFormId}_datafield_87979_1_1-container"
  def pecCrcId                          = s"select2-${vacancyFormId}_datafield_87982_1_1-container"
  def pecNsvId                          = s"select2-${vacancyFormId}_datafield_100822_1_1-container"
  def pecNsvDisplayOptionsId            = s"${vacancyFormId}_datafield_107075_1_1_fieldset"
  def pecEmploymentHistoryCheckId       = s"select2-${vacancyFormId}_datafield_87985_1_1-container"
  def pecHealthRefCheckId               = s"select2-${vacancyFormId}_datafield_87988_1_1-container"
  def pecHealthDisplayOptionsId         = s"${vacancyFormId}_datafield_107079_1_1_fieldset"
  def pecOverseasCheckId                = s"select2-${vacancyFormId}_datafield_87975_1_1-container"
  def pecPensionsCheckId                = s"select2-${vacancyFormId}_datafield_87994_1_1-container"
  def pecPreviousCivilJobCheckId        = s"select2-${vacancyFormId}_datafield_88000_1_1-container"
  def pecFraudCheckId                   = s"select2-${vacancyFormId}_datafield_121741_1_1-container"
  def pecSelfEmploymentCheckId          = s"select2-${vacancyFormId}_datafield_88003_1_1-container"
  def pecOgdTransferProcessId           = s"${vacancyFormId}_datafield_127230_1_1_fieldset"
  def pecUseOgdTransferProcessId        = s"${vacancyFormId}_datafield_206243_1_1_fieldset"
  def pecIncludeAdditionalCheckId       = s"${vacancyFormId}_datafield_168748_1_1_fieldset"
  def pecNameOfAdditionalCheckId        = s"${vacancyFormId}_datafield_176558_1_1_en-GB"
  def pecAdditionalCheckId              = s"select2-${vacancyFormId}_datafield_168766_1_1-container"
  def pecNenId                          = s"select2-${vacancyFormId}_datafield_87991_1_1-container"
  def pecNenHrEmailId                   = s"${vacancyFormId}_datafield_141090_1_1"
  def pecPnId                           = s"select2-${vacancyFormId}_datafield_87997_1_1-container"
  def pecPnHrEmailId                    = s"${vacancyFormId}_datafield_141267_1_1"
  def reservedStatusId                  = s"${vacancyFormId}_datafield_59601_1_1_fieldset"
  def crcLevelId                        = s"${vacancyFormId}_datafield_59611_1_1_fieldset"
  def crcCheckProviderId                = s"${vacancyFormId}_datafield_97307_1_1_fieldset"
  def vettingLevelId                    = s"${vacancyFormId}_field_value_93637_1"
  def medicalRequiredId                 = s"${vacancyFormId}_field_value_59608_1"
  def ogdTransferId                     = s"select2-${vacancyFormId}_datafield_201092_1_1-container"

  private def dashboardPageCheck(): Unit =
    eventually(onPage(dashboardPageTitle))

  def extractVacancyId(): String = {
    vacancyId = waitForVisibilityOfElementByPath(appIdPath).getText
    println(s"Vacancy ID: $vacancyId")
    vacancyId
  }

  private def extractVacancyName(): String = {
    vacancyName = waitForVisibilityOfElementByPath(vacancyNamePath).getText
    vacancyName
  }

  private def extractBooleanValue(): Unit = {
    val veterans = waitForVisibilityOfElementById(greatForVeteransId).findElement(By.xpath(checkLabelPath))
    if (veterans.getText == "Yes") {
      vXGreatForVeterans = true
    } else vXGreatForVeterans = false
  }

  def searchForVacancy(vacancyId: String): Unit = {
    waitForVisibilityOfElementById(searchPath).click()
    waitForVisibilityOfElementByPath(searchVacanciesPath).click()
    waitForVisibilityOfElementById(searchInput).sendKeys(vacancyId)
    matchCriteria("Exact Match")
    clickOn(searchForId)
    extractVacancyId()
    extractVacancyName()
    extractVacancySummary()
  }

  def extractVacancySummary(): Unit =
    if (vacancyActive() == "Is Active: Set to TRUE") {
      val liveDate    = waitForVisibilityOfElementById(vacancyLiveDateId).getText.replaceAll(""" at.*""", "")
      val closingDate = waitForVisibilityOfElementById(vacancyClosingDateId).getText.replaceAll(""" at.*""", "")
      vXApplicationLiveDate = liveDate
      vXApplicationClosingDate = closingDate
    } else println("Vacancy is inactive!")

  def navigateToVacancyForms(): Unit = {
    waitForVisibilityOfElementByPath(vacancyFormsPath).click()
    waitForVisibilityOfElementByPath(previewAdvertButtonPath).isDisplayed
    extractTabFormId()
  }

  def extractTabFormId(): Unit = {
    val formId = waitForVisibilityOfElementByPath(".//form[@class='form-horizontal']")
    vacancyFormId = formId.getAttribute("id")
  }

  def matchCriteria(criteria: String): Unit =
    while (waitForVisibilityOfElementByPath(matchedOption).getText != criteria)
      clickOn(matchingOption)

  private def extractDepartment(): Unit =
    vXJobInfoDepartment = waitForVisibilityOfElementById(departmentId).getText

  private def extractBusinessArea(): Unit =
    vXBusinessArea = waitForVisibilityOfElementById(businessAreaId).getText

  private def extractBusinessAreaDetail(): Unit =
    vXBusinessAreaDetail = waitForVisibilityOfElementById(businessAreaDetailId).getText

  private def extractTypeOfRole(): Unit = {
    vXTypeOfRole.clear()
    extractValues(typeOfRoleId, vXTypeOfRole)
  }

  def tableArea(id: String): WebElement =
    waitForVisibilityOfElement(By.id(id))

  def summaryItems(id: String): mutable.Buffer[WebElement] =
    tableArea(id).findElements(By.xpath(".//li[@class='select2-selection__choice']")).asScala

  def rolesItem(roleItem: WebElement): WebElement =
    roleItem.findElement(By.xpath(".//*[@class='select2-selection__choice__display']"))

  def extractValues(id: String, vXListItem: ListBuffer[String]): Unit = {
    val _values = summaryItems(id)
    for (howManyItem <- _values)
      vXListItem += rolesItem(howManyItem).getText
  }

  private def extractWhichProfession(): Unit =
    vXProfession = waitForVisibilityOfElementById(whichProfessionId).getText

  private def extractNoOfJobsAvailable(): Unit =
    vXNoOfJobsAvailable = waitForVisibilityOfElementById(noOfJobsId).getAttribute("value")

  private def extractApproach(): Unit = {
    val whichApproach = waitForVisibilityOfElementById(approachId).findElement(By.xpath(checkLabelPath))
    vXApproach = whichApproach.getText
  }

  private def extractBudgetaryApproval(): Unit = {
    val budget = waitForVisibilityOfElementById(budgetaryApprovalId).findElement(By.xpath(checkLabelPath))
    if (budget.getText == "Yes") {
      vXBudgetaryApproval = true
    } else vXBudgetaryApproval = false
  }

  private def extractCostCentre(): Unit =
    vXCostCentre = waitForVisibilityOfElementById(costCentreId).getAttribute("value")

  private def extractReserveListRequired(): Unit = {
    val reserve = waitForVisibilityOfElementById(reserveListRequiredId).findElement(By.xpath(checkLabelPath))
    if (reserve.getText == "Yes") {
      vXReserveListRequired = true
      extractReserveLength()
      extractReserveExtendRequired()
    } else {
      vXReserveListRequired = false
      vXReserveListLength = ""
      vXReserveExtendRequired = false
      vXReserveExtendLength = ""
    }
  }

  private def extractReserveLength(): Unit =
    vXReserveListLength = waitForVisibilityOfElementById(reserveListLengthId).getText

  private def extractReserveExtendRequired(): Unit =
    if (vXReserveListLength == "12 Months") {
      val extendRequired = waitForVisibilityOfElementById(reserveExtendRequiredId).findElement(By.xpath(checkLabelPath))
      if (extendRequired.isDisplayed && extendRequired.getText == "Yes") {
        vXReserveExtendRequired = true
        extractReserveExtendLength()
      } else {
        vXReserveExtendRequired = false
        vXReserveExtendLength = ""
      }
    } else {
      vXReserveExtendRequired = false
      vXReserveExtendLength = ""
    }

  private def extractReserveExtendLength(): Unit =
    vXReserveExtendLength = waitForVisibilityOfElementById(reserveNewExtendLengthId).getText

  private def extractLocationType(): Unit =
    vXLocationType = waitForVisibilityOfElementById(locationTypeId).getText

  private def extractLocationDisplay(): Unit =
    if (vXLocationType == "Postcodes" || vXLocationType == "Towns" || vXLocationType == "Overseas") {
      val display = waitForVisibilityOfElementById(locationDisplayOverrideId).getAttribute("value")
      vXLocationDisplay = display.split(",").mkString("List(", ", ", ")")
    }

  private def extractVacancyInNI(): Unit = {
    val inNI = waitForVisibilityOfElementById(vacancyInNIId).findElement(By.xpath(checkLabelPath))
    if (inNI.getText == "Yes") {
      vXVacanciesInNIR = true
      extractAvailableOutsideNI()
      extractWhichCommunitiesApply()
    } else vXVacanciesInNIR = false
  }

  private def extractAvailableOutsideNI(): Unit = {
    val outsideNI = waitForVisibilityOfElementById(availableOutsideNIId).findElement(By.xpath(checkLabelPath))
    if (outsideNI.getText == "Yes") {
      vXAvailableOutsideInNI = true
    } else vXAvailableOutsideInNI = false
  }

  private def extractWhichCommunitiesApply(): Unit = {
    val communities = waitForVisibilityOfElementById(whichCommunitiesApplyId).findElement(By.xpath(checkLabelPath))
    vXCommunitiesInNIR = communities.getText
  }

  private def extractGiveLocationPreferences(): Unit = {
    val preference = waitForVisibilityOfElementById(locationPreferencesId).findElement(By.xpath(checkLabelPath))
    if (preference.getText == "Yes") {
      vXGiveLocationPreference = true
      extractMaxLocationPreferences()
      extractLocationsToChoose()
    } else vXGiveLocationPreference = false
  }

  private def extractMaxLocationPreferences(): Unit =
    vXMaxLocations = waitForVisibilityOfElementById(maxLocationPreferenceId).getAttribute("title")

  private def extractLocationsToChoose(): Unit = {
    vXOtherLocations.clear()
    extractValues(locationsToChooseId, vXOtherLocations)
  }

  private def extractJobGrades(): Unit = {
    vXJobGrades.clear()
    extractValues(jobGradeId, vXJobGrades)
  }

  private def extractJobGradeEquivalent(): Unit =
    vXJobGradeEquivalent = waitForVisibilityOfElementById(jobGradeEquivalentId).getAttribute("value")

  private def extractContactName(): Unit =
    vXContactName = waitForVisibilityOfElementById(contactNameId).getAttribute("value")

  private def extractEmailForCandidateQuestions(): Unit =
    vXEmailForQuestions = waitForVisibilityOfElementById(emailForQuestionsId).getAttribute("value")

  private def extractVacancyHolderName(): Unit =
    vXVacancyHolderName = waitForVisibilityOfElementById(vacancyHolderNameId).getAttribute("value")

  private def extractVacancyHolderEmail(): Unit =
    vXVacancyHolderEmail = waitForVisibilityOfElementById(vacancyHolderEmailId).getAttribute("value")

  private def extractTeamEmail(): Unit =
    if (vXProfile != "Vacancy Holder 1") {
      vXTeamEmail = waitForVisibilityOfElementById(teamEmailId).getAttribute("value")
    }

  private def extractReservedStatus(): Unit = {
    val status = waitForVisibilityOfElementById(reservedStatusId).findElement(By.xpath(checkLabelPath))
    if (status.getText == "Non Reserved") {
      vXNonReserved = true
    } else vXNonReserved = false
  }

  private def extractCrcLevel(): Unit =
    vXCrcLevel = waitForVisibilityOfElementById(crcLevelId).findElement(By.xpath(checkLabelPath)).getText

  private def extractCrcCheckProvider(): Unit =
    if (vXProfile != "Vacancy Holder 1") {
      if (vXCrcLevel != "None") {
        vXCrcCheckProvider =
          waitForVisibilityOfElementById(crcCheckProviderId).findElement(By.xpath(checkLabelPath)).getText
        if (vXCrcCheckProvider.contains("DBS")) vXCrcCheckProvider = "DBS"
      } else vXCrcCheckProvider = ""
    }

  private def extractVettingLevel(): Unit =
    vXVettingLevel = waitForVisibilityOfElementById(vettingLevelId).findElement(By.xpath(checkLabelPath)).getText

  private def extractMedicalRequired(): Unit = {
    val medical = waitForVisibilityOfElementById(medicalRequiredId).findElement(By.xpath(checkLabelPath))
    if (medical.getText == "Yes") {
      vXMedicalRequired = true
    } else vXMedicalRequired = false
  }

  private def extractInterviewRounds(): Unit = {
    val expectedRounds = waitForVisibilityOfElementById(interviewRoundsId).findElement(By.xpath(checkLabelPath))
    vXInterviewExpectedRounds = expectedRounds.getText
  }

  private def extractInterviewType(): Unit = {
    def interviewType(fieldId: String): WebElement =
      waitForVisibilityOfElementById(fieldId).findElement(By.xpath(checkLabelPath))
    if (vXInterviewExpectedRounds != "No interviews") {
      vXInterviewNumber.clear()
      vXInterviewExpectedRounds.toInt match {
        case 1 =>
          vXInterviewOneType = interviewType(interviewOneId).getText
          vXInterviewNumber = ListBuffer("1")
        case 2 =>
          vXInterviewOneType = interviewType(interviewOneId).getText
          vXInterviewTwoType = interviewType(interviewTwoId).getText
          vXInterviewNumber = ListBuffer("1", "2")
        case 3 =>
          vXInterviewOneType = interviewType(interviewOneId).getText
          vXInterviewTwoType = interviewType(interviewTwoId).getText
          vXInterviewThreeType = interviewType(interviewThreeId).getText
          vXInterviewNumber = ListBuffer("1", "2", "3")
        case 4 =>
          vXInterviewOneType = interviewType(interviewOneId).getText
          vXInterviewTwoType = interviewType(interviewTwoId).getText
          vXInterviewThreeType = interviewType(interviewThreeId).getText
          vXInterviewFourType = interviewType(interviewFourId).getText
          vXInterviewNumber = ListBuffer("1", "2", "3", "4")
      }
    }
  }

  private def extractGreatForVeterans(): Unit = {
    val veterans = waitForVisibilityOfElementById(greatForVeteransId).findElement(By.xpath(checkLabelPath))
    if (veterans != null && veterans.getText == "Yes") {
      vXGreatForVeterans = true
    } else vXGreatForVeterans = false
  }

  private def extractJobHistory(): Unit = {
    val history = waitForVisibilityOfElementById(jobHistoryId).findElement(By.xpath(checkLabelPath))
    if (history.getText == "Yes") {
      vXJobHistory = true
    } else vXJobHistory = false
  }

  private def extractFullQualificationDetails(): Unit = {
    val fullQualifications = waitForVisibilityOfElementById(fullQualificationsId).findElement(By.xpath(checkLabelPath))
    if (fullQualifications.getText == "Yes") {
      vXFullQualification = true
    } else vXFullQualification = false
  }

  private def extractPreviousExperiences(): Unit = {
    val previous = waitForVisibilityOfElementById(previousExperiencesId).findElement(By.xpath(checkLabelPath))
    if (previous.getText == "Yes") {
      vXPreviousExperiences = true
    } else vXPreviousExperiences = false
  }

  private def extractPersonalStatement(): Unit = {
    val statement = waitForVisibilityOfElementById(personalStatementId).findElement(By.xpath(checkLabelPath))
    if (statement.getText == "Yes") {
      vXPersonalStatement = true
      extractStatementWordLimit()
      extractSpecifyGuidance()
    } else vXPersonalStatement = false
  }

  private def extractStatementWordLimit(): Unit =
    vXStatementWordLimit = waitForVisibilityOfElementById(personalStatementWordLimitId).getText.toInt

  private def extractSpecifyGuidance(): Unit = {
    val specify = waitForVisibilityOfElementById(specifyGuidanceId).findElement(By.xpath(checkLabelPath))
    if (specify.getText == "Yes") {
      vXSpecifyGuidance = true
      extractGuidanceText()
    } else {
      vXSpecifyGuidance = false
      vXGuidanceText = ""
    }
  }

  private def extractGuidanceText(): Unit =
    vXGuidanceText = waitForVisibilityOfElementById(guidanceTextId).getText

  private def extractDesirablePastExperience(): Unit = {
    val desirablePast = waitForVisibilityOfElementById(desirablePastExperienceId).findElement(By.xpath(checkLabelPath))
    if (desirablePast.getText == "Yes") {
      vXDesirablePastExperience = true
      extractSpecificPastExperience()
    } else vXDesirablePastExperience = false
  }

  private def extractSpecificPastExperience(): Unit =
    vXSpecificPastExperience = waitForVisibilityOfElementById(specificDesirablePastExperienceId).getText

  private def extractLicencesMandatory(): Unit = {
    val licences = waitForVisibilityOfElementById(licencesMandatoryId).findElement(By.xpath(checkLabelPath))
    if (licences.getText == "Yes") {
      vXLicencesMandatory = true
      extractSpecificLanguages()
    } else vXLicencesMandatory = false
  }

  private def extractSpecificLanguages(): Unit =
    vXSpecificLicences = waitForVisibilityOfElementById(specificLicencesId).getText

  private def extractMembershipsMandatory(): Unit = {
    val memberships = waitForVisibilityOfElementById(membershipsMandatoryId).findElement(By.xpath(checkLabelPath))
    if (memberships.getText == "Yes") {
      vXMembershipsMandatory = true
      extractMembershipsLanguages()
    } else vXMembershipsMandatory = false
  }

  private def extractMembershipsLanguages(): Unit =
    vXSpecificMemberships = waitForVisibilityOfElementById(specificMembershipsId).getText

  private def extractLanguagesMandatory(): Unit = {
    val languages = waitForVisibilityOfElementById(languagesMandatoryId).findElement(By.xpath(checkLabelPath))
    if (languages.getText == "Yes") {
      vXLanguagesMandatory = true
      extractLanguagesLanguages()
    } else vXLanguagesMandatory = false
  }

  private def extractLanguagesLanguages(): Unit =
    vXSpecificLanguages = waitForVisibilityOfElementById(specificLanguagesId).getText

  private def extractQualificationsMandatory(): Unit = {
    val qualifications = waitForVisibilityOfElementById(qualificationsMandatoryId).findElement(By.xpath(checkLabelPath))
    if (qualifications.getText == "Yes") {
      vXQualificationsMandatory = true
      extractSpecificQualifications()
    } else vXQualificationsMandatory = false
  }

  private def extractSpecificQualifications(): Unit =
    vXSpecificQualifications = waitForVisibilityOfElementById(specificQualificationsId).getText

  private def extractAbilities(): Unit = {
    val abilities = waitForVisibilityOfElementById(abilitiesId).getAttribute("checked")
    if (abilities != null) {
      vXAbilitiesRequired = true
    } else vXAbilitiesRequired = false
  }

  private def extractBehaviours(): Unit = {
    val behaviours = waitForVisibilityOfElementById(behavioursId).getAttribute("checked")
    if (behaviours != null) {
      vXBehavioursRequired = true
      extractHowManyBehaviours()
      extractAssessedBehaviours()
    } else vXBehavioursRequired = false
  }

  private def extractHowManyBehaviours(): Unit =
    vXHowManyBehaviours = waitForVisibilityOfElementById(howManyBehavioursId).getText.toInt

  private def extractBehaviourName(behaviourNameId: String): Unit = {
    val name = waitForVisibilityOfElementById(behaviourNameId).getAttribute("title")
    vXListOfChosenBehaviours += name
  }

  private def extractBehaviourApplication(behaviourApplicationId: String): Unit = {
    val application = waitForVisibilityOfElementById(behaviourApplicationId).getAttribute("checked")
    if (application != null) {
      vXBehaviourApplicationRequired += true
    } else vXBehaviourApplicationRequired += false
  }

  private def extractBehaviourInterview(behaviourInterviewId: String): Unit = {
    val interview = waitForVisibilityOfElementById(behaviourInterviewId).getAttribute("checked")
    if (interview != null) {
      vXBehaviourInterviewRequired += true
    } else vXBehaviourInterviewRequired += false
  }

  private def extractBehaviourValues(
    behaviourNameId: String,
    behaviourApplicationId: String,
    behaviourInterviewId: String
  ): Unit = {
    extractBehaviourName(behaviourNameId)
    extractBehaviourApplication(behaviourApplicationId)
    extractBehaviourInterview(behaviourInterviewId)
  }

  private def extractBehaviourOne(): Unit =
    extractBehaviourValues(behaviourOneNameId, behaviourOneApplicationId, behaviourOneInterviewId)

  private def extractBehaviourTwo(): Unit =
    extractBehaviourValues(behaviourTwoNameId, behaviourTwoApplicationId, behaviourTwoInterviewId)

  private def extractBehaviourThree(): Unit =
    extractBehaviourValues(behaviourThreeNameId, behaviourThreeApplicationId, behaviourThreeInterviewId)

  private def extractBehaviourFour(): Unit =
    extractBehaviourValues(behaviourFourNameId, behaviourFourApplicationId, behaviourFourInterviewId)

  private def extractBehaviourFive(): Unit =
    extractBehaviourValues(behaviourFiveNameId, behaviourFiveApplicationId, behaviourFiveInterviewId)

  private def extractBehaviourSix(): Unit =
    extractBehaviourValues(behaviourSixNameId, behaviourSixApplicationId, behaviourSixInterviewId)

  private def extractBehaviourSeven(): Unit =
    extractBehaviourValues(behaviourSevenNameId, behaviourSevenApplicationId, behaviourSevenInterviewId)

  private def extractBehaviourEight(): Unit =
    extractBehaviourValues(behaviourEightNameId, behaviourEightApplicationId, behaviourEightInterviewId)

  private def extractAssessedBehaviours(): Unit = {
    vXListOfChosenBehaviours.clear()
    vXBehaviourApplicationRequired.clear()
    vXBehaviourInterviewRequired.clear()
    vXHowManyBehaviours match {
      case 1 =>
        extractBehaviourOne()
      case 2 =>
        extractBehaviourOne()
        extractBehaviourTwo()
      case 3 =>
        extractBehaviourOne()
        extractBehaviourTwo()
        extractBehaviourThree()
      case 4 =>
        extractBehaviourOne()
        extractBehaviourTwo()
        extractBehaviourThree()
        extractBehaviourFour()
      case 5 =>
        extractBehaviourOne()
        extractBehaviourTwo()
        extractBehaviourThree()
        extractBehaviourFour()
        extractBehaviourFive()
      case 6 =>
        extractBehaviourOne()
        extractBehaviourTwo()
        extractBehaviourThree()
        extractBehaviourFour()
        extractBehaviourFive()
        extractBehaviourSix()
      case 7 =>
        extractBehaviourOne()
        extractBehaviourTwo()
        extractBehaviourThree()
        extractBehaviourFour()
        extractBehaviourFive()
        extractBehaviourSix()
        extractBehaviourSeven()
      case 8 =>
        extractBehaviourOne()
        extractBehaviourTwo()
        extractBehaviourThree()
        extractBehaviourFour()
        extractBehaviourFive()
        extractBehaviourSix()
        extractBehaviourSeven()
        extractBehaviourEight()
    }
  }

  private def extractExperience(): Unit = {
    val experience = waitForVisibilityOfElementById(experienceId).getAttribute("checked")
    if (experience != null) {
      vXExperiencesRequired = true
      extractExperienceSection()
    } else vXExperiencesRequired = false
  }

  private def extractStrengths(): Unit = {
    val strengths = waitForVisibilityOfElementById(strengthsId).getAttribute("checked")
    if (strengths != null) {
      vXStrengthsRequired = true
    } else vXStrengthsRequired = false
  }

  private def extractTechnicalSkills(): Unit = {
    val skills = waitForVisibilityOfElementById(technicalSkillsId).getAttribute("checked")
    if (skills != null) {
      vXTechSkillsRequired = true
      extractHowManyTechSkills()
      extractAssessedTechSkills()
    } else vXTechSkillsRequired = false
    println(vXTechSkillsRequired)
    println(vXListOfTechSkills)
    println(vXListOfTechSkillsDescription)
    println(vXListOfSkillsApplicationRequired)
    println(vXListOfSkillsInterviewRequired)
  }

  private def extractHowManyTechSkills(): Unit =
    vXHowManySkills = waitForVisibilityOfElementById(howManySkillsId).getText.toInt

  private def extractSkillsName(skillsNameId: String): Unit = {
    val skill = waitForVisibilityOfElementById(skillsNameId).getText
    vXListOfTechSkills += skill
  }

  private def extractTechSkillsDescription(skillsDescriptionId: String): Unit = {
    val description = waitForVisibilityOfElementById(skillsDescriptionId).getText
    vXListOfTechSkillsDescription += description
  }

  private def extractTechSkillsApplication(skillsApplicationId: String): Unit = {
    val application = waitForVisibilityOfElementById(skillsApplicationId).getAttribute("checked")
    if (application != null) {
      vXListOfSkillsApplicationRequired += true
    } else vXListOfSkillsApplicationRequired += false
  }

  private def extractTechSkillsInterview(skillsInterviewId: String): Unit = {
    val interview = waitForVisibilityOfElementById(skillsInterviewId).getAttribute("checked")
    if (interview != null) {
      vXListOfSkillsInterviewRequired += true
    } else vXListOfSkillsInterviewRequired += false
  }

  private def extractTechSkillsValues(
    skillsNameId: String,
    skillsDescriptionId: String,
    skillsApplicationId: String,
    skillsInterviewId: String
  ): Unit = {
    extractSkillsName(skillsNameId)
    extractTechSkillsDescription(skillsDescriptionId)
    extractTechSkillsApplication(skillsApplicationId)
    extractTechSkillsInterview(skillsInterviewId)
  }

  private def extractTechSkillOne(): Unit =
    extractTechSkillsValues(
      techSkillsOneNameId,
      techSkillsOneDescriptionId,
      techSkillsOneApplicationId,
      techSkillsOneInterviewId
    )

  private def extractTechSkillTwo(): Unit =
    extractTechSkillsValues(
      techSkillsTwoNameId,
      techSkillsTwoDescriptionId,
      techSkillsTwoApplicationId,
      techSkillsTwoInterviewId
    )

  private def extractTechSkillThree(): Unit =
    extractTechSkillsValues(
      techSkillsThreeNameId,
      techSkillsThreeDescriptionId,
      techSkillsThreeApplicationId,
      techSkillsThreeInterviewId
    )

  private def extractTechSkillFour(): Unit =
    extractTechSkillsValues(
      techSkillsFourNameId,
      techSkillsFourDescriptionId,
      techSkillsFourApplicationId,
      techSkillsFourInterviewId
    )

  private def extractTechSkillFive(): Unit =
    extractTechSkillsValues(
      techSkillsFiveNameId,
      techSkillsFiveDescriptionId,
      techSkillsFiveApplicationId,
      techSkillsFiveInterviewId
    )

  private def extractTechSkillSix(): Unit =
    extractTechSkillsValues(
      techSkillsSixNameId,
      techSkillsSixDescriptionId,
      techSkillsSixApplicationId,
      techSkillsSixInterviewId
    )

  private def extractTechSkillSeven(): Unit =
    extractTechSkillsValues(
      techSkillsSevenNameId,
      techSkillsSevenDescriptionId,
      techSkillsSevenApplicationId,
      techSkillsSevenInterviewId
    )

  private def extractTechSkillEight(): Unit =
    extractTechSkillsValues(
      techSkillsEightNameId,
      techSkillsEightDescriptionId,
      techSkillsEightApplicationId,
      techSkillsEightInterviewId
    )

  private def extractAssessedTechSkills(): Unit = {
    vXListOfTechSkills.clear()
    vXListOfTechSkillsDescription.clear()
    vXListOfSkillsApplicationRequired.clear()
    vXListOfSkillsInterviewRequired.clear()
    vXHowManySkills match {
      case 1 =>
        extractTechSkillOne()
      case 2 =>
        extractTechSkillOne()
        extractTechSkillTwo()
      case 3 =>
        extractTechSkillOne()
        extractTechSkillTwo()
        extractTechSkillThree()
      case 4 =>
        extractTechSkillOne()
        extractTechSkillTwo()
        extractTechSkillThree()
        extractTechSkillFour()
      case 5 =>
        extractTechSkillOne()
        extractTechSkillTwo()
        extractTechSkillThree()
        extractTechSkillFour()
        extractTechSkillFive()
      case 6 =>
        extractTechSkillOne()
        extractTechSkillTwo()
        extractTechSkillThree()
        extractTechSkillFour()
        extractTechSkillFive()
        extractTechSkillSix()
      case 7 =>
        extractTechSkillOne()
        extractTechSkillTwo()
        extractTechSkillThree()
        extractTechSkillFour()
        extractTechSkillFive()
        extractTechSkillSix()
        extractTechSkillSeven()
      case 8 =>
        extractTechSkillOne()
        extractTechSkillTwo()
        extractTechSkillThree()
        extractTechSkillFour()
        extractTechSkillFive()
        extractTechSkillSix()
        extractTechSkillSeven()
        extractTechSkillEight()
    }
  }

  private def extractRejectProbation(): Unit = {
    val reject = waitForVisibilityOfElementById(rejectProbationId).findElement(By.xpath(checkLabelPath))
    if (reject.getText == "Yes") {
      vXRejectProbation = true
    } else vXRejectProbation = false
  }

  private def extractApplyingOnPromotion(): Unit = {
    val reject = waitForVisibilityOfElementById(rejectApplyingOnPromotionId).findElement(By.xpath(checkLabelPath))
    if (reject.getText == "Yes") {
      vXRejectApplyingOnPromotion = true
    } else vXRejectApplyingOnPromotion = false
  }

  private def extractRejectLiveMisconduct(): Unit = {
    val reject = waitForVisibilityOfElementById(rejectLiveMisconductId).findElement(By.xpath(checkLabelPath))
    if (reject.getText == "Yes") {
      vXRejectLiveMisconduct = true
    } else vXRejectLiveMisconduct = false
  }

  private def extractRejectPoorPerformance(): Unit = {
    val reject = waitForVisibilityOfElementById(rejectPoorPerformanceId).findElement(By.xpath(checkLabelPath))
    if (reject.getText == "Yes") {
      vXRejectPoorPerformance = true
    } else vXRejectPoorPerformance = false
  }

  private def extractRejectPoorAttendance(): Unit = {
    val reject = waitForVisibilityOfElementById(rejectPoorAttendanceId).findElement(By.xpath(checkLabelPath))
    if (reject.getText == "Yes") {
      vXRejectPoorAttendance = true
    } else vXRejectPoorAttendance = false
  }

  private def extractRejectNationalityReq(): Unit = {
    val reject = waitForVisibilityOfElementById(rejectNationalityReqId).findElement(By.xpath(checkLabelPath))
    if (reject.getText == "Yes") {
      vXRejectNationalityReq = true
    } else vXRejectNationalityReq = false
  }

  private def extractRejectNoRTR(): Unit = {
    val reject = waitForVisibilityOfElementById(rejectNoRTRId).findElement(By.xpath(checkLabelPath))
    if (reject.getText == "Yes") {
      vXRejectNoRightToRemain = true
    } else vXRejectNoRightToRemain = false
  }

  private def extractRejectLicencesNotHeld(): Unit =
    if (vXLicencesMandatory && vXExperiencesRequired) {
      val reject = waitForVisibilityOfElementById(rejectLicencesNotHeldId).findElement(By.xpath(checkLabelPath))
      if (reject.getText == "Yes") {
        vXRejectLicencesNotHeld = true
      } else vXRejectLicencesNotHeld = false
    }

  private def extractRejectMembershipsNotHeld(): Unit =
    if (vXMembershipsMandatory && vXExperiencesRequired) {
      val reject = waitForVisibilityOfElementById(rejectMembershipsNotHeldId).findElement(By.xpath(checkLabelPath))
      if (reject.getText == "Yes") {
        vXRejectMembershipsNotHeld = true
      } else vXRejectMembershipsNotHeld = false
    }

  private def extractRejectLanguagesNotHeld(): Unit =
    if (vXLanguagesMandatory && vXExperiencesRequired) {
      val reject = waitForVisibilityOfElementById(rejectLanguagesNotHeldId).findElement(By.xpath(checkLabelPath))
      if (reject.getText == "Yes") {
        vXRejectLanguagesNotHeld = true
      } else vXRejectLanguagesNotHeld = false
    }

  private def extractRejectQualificationsNotHeld(): Unit =
    if (vXQualificationsMandatory && vXExperiencesRequired) {
      val reject = waitForVisibilityOfElementById(rejectQualificationsNotHeldId).findElement(By.xpath(checkLabelPath))
      if (reject.getText == "Yes") {
        vXRejectQualificationsNotHeld = true
      } else vXRejectQualificationsNotHeld = false
    }

  private def extractPreSiftRequired(): Unit = {
    val preSift = waitForVisibilityOfElementById(rejectPreSiftRequiredId).findElement(By.xpath(checkLabelPath))
    if (preSift.getText == "Yes") {
      vXPreSiftRequired = true
    } else vXPreSiftRequired = false
  }

  private def extractAttachmentRequired(): Unit = {
    val upload = waitForVisibilityOfElementById(rejectAttachmentRequiredId).findElement(By.xpath(checkLabelPath))
    if (upload.getText == "Yes") {
      vXAttachmentRequired = true
      vXCandidateInstructions = waitForVisibilityOfElementById(instructionsForCandidateId).getAttribute("value")
    } else vXAttachmentRequired = false
  }

  private def extractOnlineTests(): Unit = {
    val tests = waitForVisibilityOfElementById(onlineTestsId).findElement(By.xpath(checkLabelPath))
    if (tests.getText == "Yes") {
      vXAnyOnlineTests = true
    } else vXAnyOnlineTests = false
  }

  private def extractAdditionalQuestions(): Unit = {
    val questions = waitForVisibilityOfElementById(additionalQuestionsId).findElement(By.xpath(checkLabelPath))
    if (questions.getText == "Yes") {
      vXAnyAdditionalQuestions = true
      extractHowManyQuestions()
    } else {
      vXAnyAdditionalQuestions = false
      vXHowManyQuestions = 0
    }
  }

  private def extractHowManyQuestions(): Unit = {
    val howMany = waitForVisibilityOfElementById(howManyQuestionsId).findElement(By.xpath(checkLabelPath))
    vXHowManyQuestions = howMany.getText.toInt
    vXHowManyQuestions match {
      case 1 =>
        vXQuestionOne = waitForVisibilityOfElementById(questionOneId).getText
      case 2 =>
        vXQuestionOne = waitForVisibilityOfElementById(questionOneId).getText
        vXQuestionTwo = waitForVisibilityOfElementById(questionOTwoId).getText
      case 3 =>
        vXQuestionOne = waitForVisibilityOfElementById(questionOneId).getText
        vXQuestionTwo = waitForVisibilityOfElementById(questionOTwoId).getText
        vXQuestionThree = waitForVisibilityOfElementById(questionThreeId).getText
    }
  }

  private def extractOnlinePecCheckForms(): Unit = {
    val useOnlinePecForm = waitForVisibilityOfElementById(useOnlinePecFormId).getAttribute("title")
    useOnlinePecForm match {
      case "Yes" =>
        vXUseOnlinePecForms = true
        vXNoPecOgdTransfer = false
        val havePecMailbox = waitForVisibilityOfElementById(havePecMailboxId).getAttribute("title")
        havePecMailbox match {
          case "Yes" =>
            vXHavePecMailbox = true
            vXPecMailbox = waitForVisibilityOfElementById(pecMailboxId).getAttribute("value")
          case "No"  =>
            vXHavePecMailbox = false
            vXPecMailbox = ""
        }
      case "No"  =>
        vXUseOnlinePecForms = false
        vXHavePecMailbox = false
        vXPecMailbox = ""
        extractOgdTransfer()
    }
  }

  private def extractOgdTransfer(): Unit = {
    val ogdTransfer = waitForVisibilityOfElementById(ogdTransferId).getAttribute("title")
    if (ogdTransfer == "Yes") {
      vXNoPecOgdTransfer = true
    } else vXNoPecOgdTransfer = false
  }

  private def extractRtwCandidateTypes(): Unit = {
    vXRtwChecks.clear()
    extractValues(pecRtwCheckId, vXRtwChecks)
    if (!vXRtwChecks.equals(ListBuffer("Not Applicable"))) {
      extractWhenRtwCheck()
    } else vXWhenRtwChecks = ""
  }

  private def extractWhenRtwCheck(): Unit = {
    val whenRtw = waitForVisibilityOfElementById(pecWhenRtwId).findElement(By.xpath(checkLabelPath))
    vXWhenRtwChecks = whenRtw.getText
  }

  private def extractWhichIdentityCheck(): Unit = {
    val whichIdentity = waitForVisibilityOfElementById(pecWhichIdentityId).findElement(By.xpath(checkLabelPath))
    vXWhichIdentityChecks = whichIdentity.getText
  }

  private def extractDigitalIdentityChecks(): Unit = {
    extractWhichIdentityCheck()
    val uploadDocs = waitForVisibilityOfElementById(pecUploadIdentityDocsId).findElement(By.xpath(checkLabelPath))
    if (uploadDocs.getText == "Yes") {
      vXCandidateUploadIdentityDocs = true
      extractDetailsOfUpload()
      extractManuallyUploadDocs()
    } else {
      vXCandidateUploadIdentityDocs = false
      vXDetailsForUploadIdentityDocs = ""
      vXManuallyCheckIdentityDocs = false
    }
  }

  private def extractDetailsOfUpload(): Unit =
    vXDetailsForUploadIdentityDocs = waitForVisibilityOfElementById(pecDetailsOfUploadId).getText

  private def extractManuallyUploadDocs(): Unit = {
    val manuallyUpload = waitForVisibilityOfElementById(pecManuallyUploadId).findElement(By.xpath(checkLabelPath))
    if (manuallyUpload.getText == "Yes") {
      vXManuallyCheckIdentityDocs = true
    } else vXManuallyCheckIdentityDocs = false
  }

  private def extractGeneralInfoTypes(): Unit = {
    vXPecGeneralInfo.clear()
    extractValues(pecGeneralInfoId, vXPecGeneralInfo)
  }

  private def extractReferenceCheckTypes(): Unit = {
    vXPecReferenceCheck.clear()
    extractValues(pecReferenceCheckId, vXPecReferenceCheck)
  }

  private def extractBankruptcyCheckTypes(): Unit = {
    vXPecBankruptcyCheck.clear()
    extractValues(pecBankruptcyCheckId, vXPecBankruptcyCheck)
  }

  private def extractCrcTypes(): Unit = {
    vXPecCrc.clear()
    extractValues(pecCrcId, vXPecCrc)
  }

  private def extractNsvTypes(): Unit = {
    vXPecNsv.clear()
    extractValues(pecNsvId, vXPecNsv)
    if (!vXPecNsv.equals(ListBuffer("Not Applicable"))) {
      extractNsvDisplayOptions()
    } else vXPecNsvDisplayOptions = ""
  }

  private def extractNsvDisplayOptions(): Unit = {
    val displayOptions = waitForVisibilityOfElementById(pecNsvDisplayOptionsId).findElement(By.xpath(checkLabelPath))
    vXPecNsvDisplayOptions = displayOptions.getText
  }

  private def extractEmploymentHistoryCheckTypes(): Unit = {
    vXPecEmploymentHistoryCheck.clear()
    extractValues(pecEmploymentHistoryCheckId, vXPecEmploymentHistoryCheck)
  }

  private def extractHealthCheckTypes(): Unit = {
    vXPecHealthRefCheck.clear()
    extractValues(pecHealthRefCheckId, vXPecHealthRefCheck)
    if (!vXPecHealthRefCheck.equals(ListBuffer("Not Applicable"))) {
      extractHealthDisplayOptions()
    } else vXPecHealthDisplayOptions = ""
  }

  private def extractHealthDisplayOptions(): Unit = {
    val displayOptions = waitForVisibilityOfElementById(pecHealthDisplayOptionsId).findElement(By.xpath(checkLabelPath))
    vXPecHealthDisplayOptions = displayOptions.getText
  }

  private def extractOverseasCheckTypes(): Unit = {
    vXPecOverseasCheck.clear()
    extractValues(pecOverseasCheckId, vXPecOverseasCheck)
  }

  private def extractPensionsCheckTypes(): Unit = {
    vXPecPensionsCheck.clear()
    extractValues(pecPensionsCheckId, vXPecPensionsCheck)
  }

  private def extractPreviousCivilEmploymentCheckTypes(): Unit = {
    vXPecPreviousCivilEmploymentCheck.clear()
    extractValues(pecPreviousCivilJobCheckId, vXPecPreviousCivilEmploymentCheck)
  }

  private def extractFraudCheckTypes(): Unit = {
    vXPecFraudCheck.clear()
    extractValues(pecFraudCheckId, vXPecFraudCheck)
  }

  private def extractSelfEmploymentCheckTypes(): Unit = {
    vXPecSelfEmploymentCheck.clear()
    extractValues(pecSelfEmploymentCheckId, vXPecSelfEmploymentCheck)
  }

  private def extractOgdSecurityProcess(): Unit = {
    val ogdSecurity = waitForVisibilityOfElementById(pecOgdTransferProcessId).findElement(By.xpath(checkLabelPath))
    if (ogdSecurity.getText == "Yes") {
      vXPecOgdSecurityCheck = true
      extractUseOgdTransferProcess()
    } else vXPecOgdSecurityCheck = false
  }

  private def extractUseOgdTransferProcess(): Unit = {
    val ogdTransfer = waitForVisibilityOfElementById(pecUseOgdTransferProcessId).findElement(By.xpath(checkLabelPath))
    if (ogdTransfer.getText == "Yes") {
      vXPecUseOgdProcess = true
    } else vXPecUseOgdProcess = false
  }

  private def extractIncludeAdditionalCheck(): Unit = {
    val additionalCheck =
      waitForVisibilityOfElementById(pecIncludeAdditionalCheckId).findElement(By.xpath(checkLabelPath))
    if (additionalCheck.getText == "Yes") {
      vXPecIncludeAdditionalCheck = true
      extractNameOfAdditionalCheck()
      extractAdditionalCheckTypes()
    } else {
      vXPecIncludeAdditionalCheck = false
      vXPecNameOfAdditionalCheck = ""
      vXPecAdditionalCheck = ListBuffer("")
    }
  }

  private def extractNameOfAdditionalCheck(): Unit =
    vXPecNameOfAdditionalCheck = waitForVisibilityOfElementById(pecNameOfAdditionalCheckId).getAttribute("value")

  private def extractAdditionalCheckTypes(): Unit = {
    vXPecAdditionalCheck.clear()
    extractValues(pecAdditionalCheckId, vXPecAdditionalCheck)
  }

  private def extractNenTypes(): Unit = {
    vXPecNen.clear()
    extractValues(pecNenId, vXPecNen)
  }

  private def extractNenHrEmail(): Unit =
    if (!vXPecNen.contains("Not Applicable")) {
      vXPecHrEmailForNen = waitForVisibilityOfElementById(pecNenHrEmailId).getAttribute("value")
    }

  private def extractPnTypes(): Unit = {
    vXPecPn.clear()
    extractValues(pecPnId, vXPecPn)
  }

  private def extractPnHrEmail(): Unit =
    if (!vXPecPn.contains("Not Applicable")) {
      vXPecHrEmailForPn = waitForVisibilityOfElementById(pecPnHrEmailId).getAttribute("value")
    }

  private def jobInformationDetails(): Unit = {
    extractDepartment()
    extractBusinessArea()
    extractBusinessAreaDetail()
    extractTypeOfRole()
    extractWhichProfession()
    extractNoOfJobsAvailable()
  }

  private def approach(): Unit =
    extractApproach()

  private def approval(): Unit = {
    extractBudgetaryApproval()
    extractCostCentre()
  }

  def reserveList(): Unit =
    extractReserveListRequired()

  private def locations(): Unit = {
    extractLocationType()
    extractLocationDisplay()
    extractVacancyInNI()
    extractGiveLocationPreferences()
  }

  private def contractDetails(): Unit = {
    extractJobGrades()
    extractJobGradeEquivalent()
  }

  private def contactDetails(): Unit = {
    extractContactName()
    extractEmailForCandidateQuestions()
    extractVacancyHolderName()
    extractVacancyHolderEmail()
    extractTeamEmail()
  }

  private def checkingAndVetting(): Unit = {
    extractReservedStatus()
    extractCrcLevel()
    extractCrcCheckProvider()
    extractVettingLevel()
    extractMedicalRequired()
  }

  private def interviews(): Unit = {
    extractInterviewRounds()
    extractInterviewType()
  }

  private def extractExperienceSection(): Unit = {
    extractJobHistory()
    extractFullQualificationDetails()
    extractPreviousExperiences()
    extractPersonalStatement()
    extractDesirablePastExperience()
    extractLicencesMandatory()
    extractMembershipsMandatory()
    extractLanguagesMandatory()
    extractQualificationsMandatory()
  }

  private def successProfiles(): Unit = {
    extractAbilities()
    extractExperience()
    extractBehaviours()
    extractTechnicalSkills()
    extractStrengths()
  }

  private def onlineTests(): Unit =
    extractOnlineTests()

  private def additionalQuestions(): Unit =
    extractAdditionalQuestions()

  private def eligibilityAndRejectionCriteria(): Unit = {
    //internal or across government campaigns
    extractRejectProbation()
    extractApplyingOnPromotion()
    extractRejectLiveMisconduct()
    extractRejectPoorPerformance()
    extractRejectPoorAttendance()
    //all campaigns
    extractRejectNationalityReq()
    extractRejectNoRTR()
    extractRejectLicencesNotHeld()
    extractRejectMembershipsNotHeld()
    extractRejectLanguagesNotHeld()
    extractRejectQualificationsNotHeld()
    extractPreSiftRequired()
    extractAttachmentRequired()
  }

  private def vacancyManagement(): Unit =
    extractGreatForVeterans()

  private def onlinePreEmploymentCheckForms(): Unit =
    extractOnlinePecCheckForms()

  private def preEmploymentCheckForms(): Unit =
    if (vXUseOnlinePecForms) {
      extractRtwCandidateTypes()
      extractDigitalIdentityChecks()
      extractGeneralInfoTypes()
      extractReferenceCheckTypes()
      extractBankruptcyCheckTypes()
      extractCrcTypes()
      extractNsvTypes()
      extractEmploymentHistoryCheckTypes()
      extractHealthCheckTypes()
      extractOverseasCheckTypes()
      extractPensionsCheckTypes()
      extractPreviousCivilEmploymentCheckTypes()
      extractFraudCheckTypes()
      extractSelfEmploymentCheckTypes()
      extractOgdSecurityProcess()
      extractIncludeAdditionalCheck()
      extractNenTypes()
      extractNenHrEmail()
      extractPnTypes()
      extractPnHrEmail()
    }

  def extractAllVacancyDetails(vacancyToExtract: String): Unit = {
    resetApplicationDetails()
    searchForVacancy(vacancyToExtract)
    navigateToVacancyForms()
    jobInformationDetails()
    approach()
    approval()
    reserveList()
    locations()
    contractDetails() //TODO not all things covered
//    theAdvert() TODO
    contactDetails()
    checkingAndVetting()
    interviews()
    successProfiles()
    onlineTests()
    additionalQuestions()
    eligibilityAndRejectionCriteria()
    vacancyManagement()
    onlinePreEmploymentCheckForms()
    preEmploymentCheckForms()
  }
}
