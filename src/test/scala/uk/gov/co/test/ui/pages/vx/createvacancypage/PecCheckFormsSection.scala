package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCandidateUploadIdentityDocs, vXDetailsForUploadIdentityDocs, vXManuallyCheckIdentityDocs, vXPecAdditionalCheck, vXPecBankruptcyCheck, vXPecCrc, vXPecEmploymentHistoryCheck, vXPecFraudCheck, vXPecGeneralInfo, vXPecHealthDisplayOptions, vXPecHealthRefCheck, vXPecIncludeAdditionalCheck, vXPecNameOfAdditionalCheck, vXPecNen, vXPecNsv, vXPecNsvDisplayOptions, vXPecOgdSecurityCheck, vXPecOverseasCheck, vXPecPensionsCheck, vXPecPn, vXPecPreviousCivilEmploymentCheck, vXPecReferenceCheck, vXPecSelfEmploymentCheck, vXPecUseDigitalOgdProcess, vXRtwChecks, vXUseOnlinePecForms, vXWhenRtwChecks, vXWhichIdentityChecks, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

case class PecCheckFormsDetails(
  rtwCheck: ListBuffer[String],
  whenCompleteRtwCheck: String,
  whichIdentityChecks: String,
  uploadIdentityDocs: Boolean,
  detailsOfIdentityDocs: String,
  manualIdentityDocCheck: Boolean,
  generalInfo: ListBuffer[String],
  referenceChecks: ListBuffer[String],
  bankruptcyChecks: ListBuffer[String],
  crcChecks: ListBuffer[String],
  nsvChecks: ListBuffer[String],
  nsvDisplayOptions: String,
  jobHistoryChecks: ListBuffer[String],
  healthRefChecks: ListBuffer[String],
  healthDisplayOptions: String,
  overseasCheck: ListBuffer[String],
  pensionsCheck: ListBuffer[String],
  previousCsJobCheck: ListBuffer[String],
  internalFraudCheck: ListBuffer[String],
  selfEmploymentCheck: ListBuffer[String],
  ogdTransferProcessCheck: Boolean,
  useOgdDigitalTransferProcess: Boolean,
  includeAdditionalCheck: Boolean,
  nameOfCheck: String,
  additionalCheck: ListBuffer[String],
  nenOnboarding: ListBuffer[String],
  nenHrEmail: String,
  pnOnboarding: ListBuffer[String],
  pnHrEmail: String
)

object PecCheckFormsSection extends VacancyBasePage {

  def rtwCheckInputId                  = s"select2-${vacancyFormId}_datafield_98824_1_1-container"
  def beforePecChecksId                = s"${vacancyFormId}_datafield_106424_1_1_17181"
  def sameTimeAsPecChecksId            = s"${vacancyFormId}_datafield_106424_1_1_17182"
  def generalInformationInputId        = s"select2-${vacancyFormId}_datafield_94582_1_1-container"
  def referenceCheckInputId            = s"select2-${vacancyFormId}_datafield_94578_1_1-container"
  def bankruptcyCheckInputId           = s"select2-${vacancyFormId}_datafield_87979_1_1-container"
  def crcInputId                       = s"select2-${vacancyFormId}_datafield_87982_1_1-container"
  def nsvInputId                       = s"select2-${vacancyFormId}_datafield_100822_1_1-container"
  def jobHistoryCheckInputId           = s"select2-${vacancyFormId}_datafield_87985_1_1-container"
  def healthRefCheckInputId            = s"select2-${vacancyFormId}_datafield_87988_1_1-container"
  def overseasCheckInputId             = s"select2-${vacancyFormId}_datafield_87975_1_1-container"
  def pensionsCheckInputId             = s"select2-${vacancyFormId}_datafield_87994_1_1-container"
  def previousCsJobCheckInputId        = s"select2-${vacancyFormId}_datafield_88000_1_1-container"
  def internalFraudCheckInputId        = s"select2-${vacancyFormId}_datafield_121741_1_1-container"
  def selfEmploymentCheckInputId       = s"select2-${vacancyFormId}_datafield_88003_1_1-container"
  def additionalCheckInputId           = s"select2-${vacancyFormId}_datafield_168766_1_1-container"
  def nenInputId                       = s"select2-${vacancyFormId}_datafield_87991_1_1-container"
  def pnInputId                        = s"select2-${vacancyFormId}_datafield_87997_1_1-container"
  def nameOfCheckInputId               = s"${vacancyFormId}_datafield_176558_1_1_en-GB"
  def ogdTransferProcessCheckYesId     = s"${vacancyFormId}_datafield_127230_1_1_1"
  def ogdTransferProcessCheckNoId      = s"${vacancyFormId}_datafield_127230_1_1_2"
  def ogdDigitalTransferProcessTextId  = s"${vacancyFormId}_field_que_206243_1"
  def ogdDigitalTransferProcessId      = s"${vacancyFormId}_datafield_206243_1_1_legend"
  def useOgdTransferProcessYesId       = s"${vacancyFormId}_datafield_206243_1_1_1"
  def useOgdTransferProcessNoId        = s"${vacancyFormId}_datafield_206243_1_1_2"
  def includeAdditionalCheckYesId      = s"${vacancyFormId}_datafield_168748_1_1_1"
  def includeAdditionalCheckNoId       = s"${vacancyFormId}_datafield_168748_1_1_2"
  def noIdentityChecksId               = s"${vacancyFormId}_datafield_184419_1_1_50074"
  def rtwOnlyId                        = s"${vacancyFormId}_datafield_184419_1_1_50075"
  def rtwAndCrcId                      = s"${vacancyFormId}_datafield_184419_1_1_50076"
  def uploadIdentityYesId              = s"${vacancyFormId}_datafield_159069_1_1_1"
  def uploadIdentityNoId               = s"${vacancyFormId}_datafield_159069_1_1_2"
  def nsvShowJobAndCandidateFormsId    = s"${vacancyFormId}_datafield_107075_1_1_17226"
  def healthShowJobAndCandidateFormsId = s"${vacancyFormId}_datafield_107079_1_1_17226"
  def nsvShowJobFormOnlyId             = s"${vacancyFormId}_datafield_107075_1_1_17225"
  def healthShowJobFormOnlyId          = s"${vacancyFormId}_datafield_107079_1_1_17225"
  def detailsIdentityDocsId            = s"${vacancyFormId}_datafield_159299_1_1_en-GB"
  def manualIdentityCheckYesId         = s"${vacancyFormId}_datafield_181577_1_1_1"
  def manualIdentityCheckNoId          = s"${vacancyFormId}_datafield_181577_1_1_2"
  def nenHrEmailId                     = s"${vacancyFormId}_datafield_141090_1_1"
  def pnHrEmailId                      = s"${vacancyFormId}_datafield_141267_1_1"

  private def selectWhenCompleteRtwCheck(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (!vXRtwChecks.contains("Not Applicable")) {
      vXWhenRtwChecks = pecCheckFormsDetails.whenCompleteRtwCheck
      vXWhenRtwChecks match {
        case "Before pre employment checks"              => clickOnRadioButton(beforePecChecksId)
        case "At the same time as pre employment checks" => clickOnRadioButton(sameTimeAsPecChecksId)
        case _                                           => throw new IllegalStateException("Please enter valid 'RTW Check' completion option")
      }
    } else vXWhenRtwChecks = ""

  private def selectWhichIdentityChecks(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    vXWhichIdentityChecks = pecCheckFormsDetails.whichIdentityChecks
    vXWhichIdentityChecks match {
      case "No digital checks"                       => clickOnRadioButton(noIdentityChecksId)
      case "Right to work only"                      => clickOnRadioButton(rtwOnlyId)
      case "Right to work and criminal record check" => clickOnRadioButton(rtwAndCrcId)
      case _                                         => throw new IllegalStateException("Please enter valid 'which identity checks' option")
    }
  }

  private def selectUploadIdentityDocs(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    vXCandidateUploadIdentityDocs = pecCheckFormsDetails.uploadIdentityDocs
    if (vXCandidateUploadIdentityDocs) {
      clickOnRadioButton(uploadIdentityYesId)
      vXDetailsForUploadIdentityDocs = pecCheckFormsDetails.detailsOfIdentityDocs
      enterValue(detailsIdentityDocsId, vXDetailsForUploadIdentityDocs)
      vXManuallyCheckIdentityDocs = pecCheckFormsDetails.manualIdentityDocCheck
      if (vXManuallyCheckIdentityDocs) clickOnRadioButton(manualIdentityCheckYesId)
      else clickOnRadioButton(manualIdentityCheckNoId)
    } else {
      clickOnRadioButton(uploadIdentityNoId)
      vXDetailsForUploadIdentityDocs = ""
      vXManuallyCheckIdentityDocs = false
    }
  }

  private def selectNsvDisplayOptions(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (!vXPecNsv.contains("Not Applicable")) {
      vXPecNsvDisplayOptions = pecCheckFormsDetails.nsvDisplayOptions
      vXPecNsvDisplayOptions match {
        case "Show recruiter and candidate forms" => clickOnRadioButton(nsvShowJobAndCandidateFormsId)
        case "Show recruiter form only"           => clickOnRadioButton(nsvShowJobFormOnlyId)
        case _                                    => throw new IllegalStateException("Please enter valid 'NSV Display' option")
      }
    }

  private def selectHealthDisplayOptions(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (!vXPecHealthRefCheck.contains("Not Applicable")) {
      vXPecHealthDisplayOptions = pecCheckFormsDetails.healthDisplayOptions
      vXPecHealthDisplayOptions match {
        case "Show recruiter and candidate forms" => clickOnRadioButton(healthShowJobAndCandidateFormsId)
        case "Show recruiter form only"           => clickOnRadioButton(healthShowJobFormOnlyId)
        case _                                    => throw new IllegalStateException("Please enter valid 'Health Display' option")
      }
    }

  private def enterHrEmail(hrEmailId: String, hrEmail: String, value: ListBuffer[String]): Unit =
    if (!driver.findElements(By.id(hrEmailId)).isEmpty) {
      if (value.contains("Not Applicable")) {
        val hrEmailField = waitForVisibilityOfElementById(hrEmailId)
        hrEmailField.clear()
      } else {
        val hrEmailField = waitForVisibilityOfElementById(hrEmailId)
        hrEmailField.clear()
        hrEmailField.sendKeys(hrEmail)
      }
    }

  private def selectOGDTransferProcessCheck(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    vXPecOgdSecurityCheck = pecCheckFormsDetails.ogdTransferProcessCheck
    if (vXPecOgdSecurityCheck) {
      clickOnRadioButton(ogdTransferProcessCheckYesId)
      selectOgdDigitalTransferProcess(pecCheckFormsDetails)
    } else clickOnRadioButton(ogdTransferProcessCheckNoId)
  }

  private def selectOgdDigitalTransferProcess(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    vXPecUseDigitalOgdProcess = pecCheckFormsDetails.useOgdDigitalTransferProcess
    val ogdDigitalDisplayed = driver.findElement(By.id(ogdDigitalTransferProcessTextId)).isDisplayed
    if (ogdDigitalDisplayed) {
      if (vXPecUseDigitalOgdProcess) clickOnRadioButton(useOgdTransferProcessYesId)
      else clickOnRadioButton(useOgdTransferProcessNoId)
    }
  }

  private def selectIncludeAdditionalCheck(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    vXPecIncludeAdditionalCheck = pecCheckFormsDetails.includeAdditionalCheck
    if (vXPecIncludeAdditionalCheck) {
      clickOnRadioButton(includeAdditionalCheckYesId)
      vXPecNameOfAdditionalCheck = pecCheckFormsDetails.nameOfCheck
      enterValue(nameOfCheckInputId, vXPecNameOfAdditionalCheck)
      vXPecAdditionalCheck = pecCheckFormsDetails.additionalCheck
      enterTypeRoles(vXPecAdditionalCheck, additionalCheckInputId)
    } else {
      clickOnRadioButton(includeAdditionalCheckNoId)
      vXPecNameOfAdditionalCheck = ""
      vXPecAdditionalCheck = ListBuffer("")
    }
  }

  private def pecCheckFormsFlow(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    vXRtwChecks = pecCheckFormsDetails.rtwCheck
    vXPecGeneralInfo = pecCheckFormsDetails.generalInfo
    vXPecReferenceCheck = pecCheckFormsDetails.referenceChecks
    vXPecBankruptcyCheck = pecCheckFormsDetails.bankruptcyChecks
    vXPecCrc = pecCheckFormsDetails.crcChecks
    vXPecNsv = pecCheckFormsDetails.nsvChecks
    vXPecEmploymentHistoryCheck = pecCheckFormsDetails.jobHistoryChecks
    vXPecHealthRefCheck = pecCheckFormsDetails.healthRefChecks
    vXPecOverseasCheck = pecCheckFormsDetails.overseasCheck
    vXPecPensionsCheck = pecCheckFormsDetails.pensionsCheck
    vXPecPreviousCivilEmploymentCheck = pecCheckFormsDetails.previousCsJobCheck
    vXPecFraudCheck = pecCheckFormsDetails.internalFraudCheck
    vXPecSelfEmploymentCheck = pecCheckFormsDetails.selfEmploymentCheck
    vXPecNen = pecCheckFormsDetails.nenOnboarding
    vXPecPn = pecCheckFormsDetails.pnOnboarding

    enterTypeRoles(vXRtwChecks, rtwCheckInputId)
    selectWhenCompleteRtwCheck(pecCheckFormsDetails)
    selectWhichIdentityChecks(pecCheckFormsDetails)
    selectUploadIdentityDocs(pecCheckFormsDetails)
    enterTypeRoles(vXPecGeneralInfo, generalInformationInputId)
    enterTypeRoles(vXPecReferenceCheck, referenceCheckInputId)
    enterTypeRoles(vXPecBankruptcyCheck, bankruptcyCheckInputId)
    enterTypeRoles(vXPecCrc, crcInputId)
    enterTypeRoles(vXPecNsv, nsvInputId)
    selectNsvDisplayOptions(pecCheckFormsDetails)
    enterTypeRoles(vXPecEmploymentHistoryCheck, jobHistoryCheckInputId)
    enterTypeRoles(vXPecHealthRefCheck, healthRefCheckInputId)
    selectHealthDisplayOptions(pecCheckFormsDetails)
    enterTypeRoles(vXPecOverseasCheck, overseasCheckInputId)
    enterTypeRoles(vXPecPensionsCheck, pensionsCheckInputId)
    enterTypeRoles(vXPecPreviousCivilEmploymentCheck, previousCsJobCheckInputId)
    enterTypeRoles(vXPecFraudCheck, internalFraudCheckInputId)
    enterTypeRoles(vXPecSelfEmploymentCheck, selfEmploymentCheckInputId)
    selectOGDTransferProcessCheck(pecCheckFormsDetails)
    selectIncludeAdditionalCheck(pecCheckFormsDetails)
    enterTypeRoles(vXPecNen, nenInputId)
    enterHrEmail(nenHrEmailId, pecCheckFormsDetails.nenHrEmail, vXPecNen)
    enterTypeRoles(vXPecPn, pnInputId)
    enterHrEmail(pnHrEmailId, pecCheckFormsDetails.pnHrEmail, vXPecPn)
  }

  private val pecCheckForms: Seq[PecCheckFormsDetails => Unit] = Seq(
    pecCheckFormsFlow
  )

  def pecCheckFormsSection(newVacancyDetails: NewVacancyDetails): Unit =
    if (vXUseOnlinePecForms) {
      pecCheckForms.foreach { f =>
        f(newVacancyDetails.pecCheckFormsDetails)
      }
    }

}
