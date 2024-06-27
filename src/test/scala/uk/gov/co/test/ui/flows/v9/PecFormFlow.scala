package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9RtwHoldPassport, vXApproach, vXCandidateUploadIdentityDocs, vXCrcCheckProvider, vXCrcLevel, vXPecBankruptcyCheck, vXPecEmploymentHistoryCheck, vXPecHealthRefCheck, vXPecOverseasCheck, vXPecPensionsCheck, vXPecPreviousCivilEmploymentCheck, vXPecSelfEmploymentCheck, vXRtwChecks, vXUseOnlinePecForms, vXWhichIdentityChecks}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.{confirmOfferAcceptedState, pecStartFunction}
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.BankruptcyDetailsPage.bankruptcyDetailsPage
import uk.gov.co.test.ui.pages.v9.pecform.DbsAddressDetailsPage.dbsAddressDetailsPage
import uk.gov.co.test.ui.pages.v9.pecform.DbsPersonalInfoPage.dbsPersonalInfoPage
import uk.gov.co.test.ui.pages.v9.pecform.DeclarationPage.{declarationPage, pecFormSubmission}
import uk.gov.co.test.ui.pages.v9.pecform.DigitalIdentityCheckPage.digitalIdentityCheckPage
import uk.gov.co.test.ui.pages.v9.pecform.EmploymentHistoryPage.employmentHistoryPage
import uk.gov.co.test.ui.pages.v9.pecform.HealthDeclarationPage.healthDeclarationPage
import uk.gov.co.test.ui.pages.v9.pecform.NationalSecurityVettingPage.nationalSecurityVettingPage
import uk.gov.co.test.ui.pages.v9.pecform.OverseasPage.overseasPage
import uk.gov.co.test.ui.pages.v9.pecform.PensionQuestionnairePage.pensionQuestionnairePage
import uk.gov.co.test.ui.pages.v9.pecform.PreviousCSEmploymentPage.previousCSEmploymentPage
import uk.gov.co.test.ui.pages.v9.pecform.RightToWorkPage.rightToWorkPage
import uk.gov.co.test.ui.pages.v9.pecform.SelfEmploymentPage.selfEmploymentPage
import uk.gov.co.test.ui.pages.v9.pecform.UploadIdentityDocsPage.uploadIdentityDocPage
import uk.gov.co.test.ui.pages.v9.pecform.VerifyingHistoryPage.verifyingHistoryPage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.yourDetailsPage

object PecFormFlow extends CivilServiceJobsBasePage {

  private val pecForm: Seq[PecFormDetails => Unit] = Seq(
    yourDetailsPage,
    rightToWorkPage,
    employmentHistoryPage,
    verifyingHistoryPage,
    pensionQuestionnairePage,
    overseasPage,
    bankruptcyDetailsPage, //TODO full logic required
    healthDeclarationPage, //TODO full logic required
    selfEmploymentPage, //TODO full logic required
    previousCSEmploymentPage, //TODO full logic required
    nationalSecurityVettingPage,
    uploadIdentityDocPage,
    dbsPersonalInfoPage,
    dbsAddressDetailsPage,
    digitalIdentityCheckPage,
    declarationPage
  )

  def fillPecFormDetailsOnly(pecFormDetails: PecFormDetails): Unit = {
//    if (currentUrl.contains("recruiter")) changeSystem("candidate")
    confirmOfferAcceptedState()
    if (
      vXUseOnlinePecForms && ((!vXRtwChecks
        .contains("Not Applicable") && vXRtwChecks.contains(s"$vXApproach Candidates")) ||
        (!vXPecEmploymentHistoryCheck
          .contains("Not Applicable") && vXPecEmploymentHistoryCheck.contains(s"$vXApproach Candidates")) ||
        (!vXPecPensionsCheck.contains("Not Applicable") && vXPecPensionsCheck.contains(s"$vXApproach Candidates")) ||
        (!vXPecOverseasCheck.contains("Not Applicable") && vXPecOverseasCheck.contains(s"$vXApproach Candidates")) ||
        (!vXPecBankruptcyCheck
          .contains("Not Applicable") && vXPecBankruptcyCheck.contains(s"$vXApproach Candidates")) ||
        (!vXPecHealthRefCheck.contains("Not Applicable") && vXPecHealthRefCheck.contains(s"$vXApproach Candidates")) ||
        (!vXPecPreviousCivilEmploymentCheck
          .contains("Not Applicable") && vXPecPreviousCivilEmploymentCheck.contains(s"$vXApproach Candidates")) ||
        (!vXPecSelfEmploymentCheck
          .contains("Not Applicable") && vXPecSelfEmploymentCheck.contains(s"$vXApproach Candidates")) ||
        vXCandidateUploadIdentityDocs ||
        (vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) ||
        (vXWhichIdentityChecks != "No digital checks" && v9RtwHoldPassport))
    ) {
      pecStartFunction().click()
      pecForm.foreach { f =>
        f(pecFormDetails)
      }
      clickOn(pecFormSubmission)
    }
  }
}
