package uk.gov.co.test.ui.data

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXAnyAdditionalQuestions, vXAnyOnlineTests, vXAttendancePoor, vXGiveLocationPreference, vXGreatForVeterans, vXGrsVacancy, vXLanguagesMandatory, vXLicencesMandatory, vXMembershipsMandatory, vXMisconductLive, vXNoOfApplicationStage, vXPerformanceReview, vXProbationIncomplete, vXPromotionApply, vXQualificationsMandatory, vXRightToRemainUK, vXStatementWordLimit, vXUploadAttachmentRequired, vXVacanciesInNIR, vacancyId, vacancyName}
import uk.gov.co.test.ui.specs.BaseFeatureSpec

object TestData extends BaseFeatureSpec {

  def pecTestData(): Unit = {
    vacancyName = "AUTOA8PEC - Director"
    vacancyId = "9497"
    vXAnyAdditionalQuestions = false
    vXUploadAttachmentRequired = false
    vXProbationIncomplete = false
    vXPromotionApply = false
    vXMisconductLive = false
    vXPerformanceReview = false
    vXAttendancePoor = false
    vXRightToRemainUK = false
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
    vXUploadAttachmentRequired = false
    vXProbationIncomplete = false
    vXPromotionApply = false
    vXMisconductLive = false
    vXPerformanceReview = false
    vXAttendancePoor = false
    vXRightToRemainUK = false
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
