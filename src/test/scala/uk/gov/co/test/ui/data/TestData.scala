package uk.gov.co.test.ui.data

import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAnyAdditionalQuestions, vXAnyOnlineTests, vXAttachmentRequired, vXGiveLocationPreference, vXGreatForVeterans, vXGrsVacancy, vXLanguagesMandatory, vXLicencesMandatory, vXMembershipsMandatory, vXNoOfApplicationStage, vXQualificationsMandatory, vXRejectApplyingOnPromotion, vXRejectLiveMisconduct, vXRejectNoRightToRemain, vXRejectPoorAttendance, vXRejectPoorPerformance, vXRejectProbation, vXStatementWordLimit, vXVacanciesInNIR, vacancyId, vacancyName}
import uk.gov.co.test.ui.specs.BaseFeatureSpec

object TestData extends BaseFeatureSpec {

  def pecTestData(): Unit = {
    vacancyName = "AUTOA8PEC - Director"
    vacancyId = "9497"
    vXAnyAdditionalQuestions = false
    vXAttachmentRequired = false
    vXRejectProbation = false
    vXRejectApplyingOnPromotion = false
    vXRejectLiveMisconduct = false
    vXRejectPoorPerformance = false
    vXRejectPoorAttendance = false
    vXRejectNoRightToRemain = false
    vXAnyOnlineTests = false
    vXVacanciesInNIR = false
    vXGiveLocationPreference = false
    vXGrsVacancy = false
    vXStatementWordLimit = 750
    vXNoOfApplicationStage = 1
  }

  def setPecTestData(): Unit = {
    vacancyName = "HMRC - Technical Architect"
    vacancyId = "9562"
    vXAnyAdditionalQuestions = false
    vXAttachmentRequired = false
    vXRejectProbation = false
    vXRejectApplyingOnPromotion = false
    vXRejectLiveMisconduct = false
    vXRejectPoorPerformance = false
    vXRejectPoorAttendance = false
    vXRejectNoRightToRemain = false
    vXAnyOnlineTests = false
    vXVacanciesInNIR = false
    vXGiveLocationPreference = false
    vXGrsVacancy = true
    vXGreatForVeterans = false
    vXStatementWordLimit = 750
    vXNoOfApplicationStage = 1
    vXMembershipsMandatory = false
    vXLicencesMandatory = false
    vXLanguagesMandatory = false
    vXQualificationsMandatory = false
  }

}
