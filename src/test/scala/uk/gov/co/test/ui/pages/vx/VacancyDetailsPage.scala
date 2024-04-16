package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAbilitiesRequired, vXAnyAdditionalQuestions, vXAnyOnlineTests, vXApplicationClosingDate, vXApplicationLiveDate, vXApproach, vXAttachmentRequired, vXAvailableOutsideInNI, vXBehavioursRequired, vXBudgetaryApproval, vXBusinessArea, vXBusinessAreaDetail, vXCandidateInstructions, vXCommunitiesInNIR, vXCostCentre, vXDesirablePastExperience, vXExperiencesRequired, vXFullQualification, vXGiveLocationPreference, vXGreatForVeterans, vXGuidanceText, vXHowManyQuestions, vXInterviewExpectedRounds, vXInterviewFourType, vXInterviewNumber, vXInterviewOneType, vXInterviewThreeType, vXInterviewTwoType, vXJobHistory, vXJobInfoDepartment, vXLanguagesMandatory, vXLicencesMandatory, vXLocationDisplay, vXLocationType, vXMaxLocations, vXMembershipsMandatory, vXNoOfJobsAvailable, vXOtherLocations, vXPersonalStatement, vXPreSiftRequired, vXPreviousExperiences, vXProfession, vXQualificationsMandatory, vXQuestionOne, vXQuestionThree, vXQuestionTwo, vXRejectApplyingOnPromotion, vXRejectLanguagesNotHeld, vXRejectLicencesNotHeld, vXRejectLiveMisconduct, vXRejectMembershipsNotHeld, vXRejectNationalityReq, vXRejectNoRightToRemain, vXRejectPoorAttendance, vXRejectPoorPerformance, vXRejectProbation, vXRejectQualificationsNotHeld, vXReserveExtendLength, vXReserveExtendRequired, vXReserveListLength, vXReserveListRequired, vXSpecificLanguages, vXSpecificLicences, vXSpecificMemberships, vXSpecificPastExperience, vXSpecificQualifications, vXSpecifyGuidance, vXStatementWordLimit, vXStrengthsRequired, vXTechSkillsRequired, vXTypeOfRole, vXVacanciesInNIR, vacancyFormId, vacancyId, vacancyName}
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
  def reserveExtendLengthId             = s"select2-${vacancyFormId}_datafield_177145_1_1-container"
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
  def experienceId                      = s"${vacancyFormId}_datafield_154245_1_1_12687"
  def strengthsId                       = s"${vacancyFormId}_datafield_154245_1_1_12689"
  def technicalSkillsId                 = s"${vacancyFormId}_datafield_154245_1_1_12688"
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

  private def dashboardPageCheck(): Unit =
    eventually(onPage(dashboardPageTitle))

  def extractVacancyId(): String = {
    vacancyId = waitForVisibilityOfElementByPath(appIdPath).getText
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
    vXReserveExtendLength = waitForVisibilityOfElementById(reserveExtendLengthId).getText

  private def extractLocationType(): Unit =
    vXLocationType = waitForVisibilityOfElementById(locationTypeId).getText

  private def extractLocationDisplay(): Unit = {
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
    } else vXSpecifyGuidance = false
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
    } else vXBehavioursRequired = false
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
    } else vXTechSkillsRequired = false
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
    } else vXAnyAdditionalQuestions = false
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

  private def additionalQuestions(): Unit = {
    extractAdditionalQuestions()
    extractHowManyQuestions()
  }

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

  def extractAllVacancyDetails(vacancyToExtract: String): Unit = {
    searchForVacancy(vacancyToExtract)
    navigateToVacancyForms()
    jobInformationDetails()
    approach()
    approval()
    reserveList()
    locations()
//    contractDetails() TODO
//    theAdvert() TODO
//    contactDetails() TODO
//    checkingAndVetting() TODO
    interviews()
    successProfiles()
    onlineTests()
    additionalQuestions()
    eligibilityAndRejectionCriteria()
    vacancyManagement()
//    onlinePreEmploymentCheckForms() TODO
//    preEmploymentCheckForms() TODO
  }
}
