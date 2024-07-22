package uk.gov.co.test.ui.flows.v9

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9PecRequired, v9RtwBritishIrishPassport, vXCrcCheckProvider, vXCrcLevel, vXUseOnlinePecForms, vXVettingLevel, vXWhichIdentityChecks}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.ApplicationCentrePage.pecStartFunction
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
import uk.gov.co.test.ui.pages.v9.pecform.WorkplaceMisconductPage.workplaceMisconductPage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.yourDetailsPage

object PecFormFlow extends CivilServiceJobsBasePage {

  private val pecForm: Seq[PecFormDetails => Unit] = Seq(
    yourDetailsPage,
    rightToWorkPage,
    employmentHistoryPage,
    verifyingHistoryPage,
    workplaceMisconductPage,
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
    if (currentUrl.contains("recruiter")) changeSystem("candidate")
    if (
      vXUseOnlinePecForms && (
        v9PecRequired ||
          (vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) ||
          (vXVettingLevel != "None") ||
          (vXWhichIdentityChecks != "No digital checks" && v9RtwBritishIrishPassport)
      )
    ) {
      pecStartFunction().click()
      pecForm.foreach { f =>
        f(pecFormDetails)
      }
      clickOn(pecFormSubmission)
    }
  }
}
