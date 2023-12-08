package uk.gov.co.test.ui.specs

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXAnyAdditionalQuestions, vXAnyOnlineTests, vXAttendancePoor, vXGiveLocationPreference, vXGrsVacancy, vXMisconductLive, vXNoOfApplicationStage, vXPerformanceReview, vXProbationIncomplete, vXPromotionApply, vXRightToRemainUK, vXStatementWordLimit, vXUploadAttachmentRequired, vXVacanciesInNIR, vacancyId, vacancyName}

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

}
