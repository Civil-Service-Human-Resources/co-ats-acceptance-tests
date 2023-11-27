package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class PecCheckFormsDetails(
  rtwCheck: List[String],
  whenCompleteRtwCheck: String,
  whichIdentityChecks: String,
  uploadIdentityDocs: Boolean,
  detailsOfIdentityDocs: String,
  manualIdentityDocCheck: Boolean,
  generalInfo: List[String],
  referenceChecks: List[String],
  bankruptcyChecks: List[String],
  crcChecks: List[String],
  nsvChecks: List[String],
  nsvDisplayOptions: String,
  jobHistoryChecks: List[String],
  healthRefChecks: List[String],
  healthDisplayOptions: String,
  overseasCheck: List[String],
  pensionsCheck: List[String],
  previousCsJobCheck: List[String],
  internalFraudCheck: List[String],
  selfEmploymentCheck: List[String],
  ogdTransferProcessCheck: Boolean,
  includeAdditionalCheck: Boolean,
  nameOfCheck: String,
  additionalCheck: List[String],
  nenOnboarding: List[String],
  pnOnboarding: List[String]
)

object PecCheckFormsSection extends VacancyBasePage {

  private lazy val rtwCheckInputId                  = s"select2-${formId}_datafield_98824_1_1-container"
  private lazy val beforePecChecksId                = s"${formId}_datafield_106424_1_1_17181"
  private lazy val sameTimeAsPecChecksId            = s"${formId}_datafield_106424_1_1_17182"
  private lazy val generalInformationInputId        = s"select2-${formId}_datafield_94582_1_1-container"
  private lazy val referenceCheckInputId            = s"select2-${formId}_datafield_94578_1_1-container"
  private lazy val bankruptcyCheckInputId           = s"select2-${formId}_datafield_87979_1_1-container"
  private lazy val crcInputId                       = s"select2-${formId}_datafield_87982_1_1-container"
  private lazy val nsvInputId                       = s"select2-${formId}_datafield_100822_1_1-container"
  private lazy val jobHistoryCheckInputId           = s"select2-${formId}_datafield_87985_1_1-container"
  private lazy val healthRefCheckInputId            = s"select2-${formId}_datafield_87988_1_1-container"
  private lazy val overseasCheckInputId             = s"select2-${formId}_datafield_87975_1_1-container"
  private lazy val pensionsCheckInputId             = s"select2-${formId}_datafield_87994_1_1-container"
  private lazy val previousCsJobCheckInputId        = s"select2-${formId}_datafield_88000_1_1-container"
  private lazy val internalFraudCheckInputId        = s"select2-${formId}_datafield_121741_1_1-container"
  private lazy val selfEmploymentCheckInputId       = s"select2-${formId}_datafield_88003_1_1-container"
  private lazy val additionalCheckInputId           = s"select2-${formId}_datafield_168766_1_1-container"
  private lazy val nenInputId                       = s"select2-${formId}_datafield_87991_1_1-container"
  private lazy val pnInputId                        = s"select2-${formId}_datafield_87997_1_1-container"
  private lazy val nameOfCheckInputId               = s"${formId}_datafield_176558_1_1_en-GB"
  private lazy val ogdTransferProcessCheckYesId     = s"${formId}_datafield_127230_1_1_1"
  private lazy val ogdTransferProcessCheckNoId      = s"${formId}_datafield_127230_1_1_2"
  private lazy val includeAdditionalCheckYesId      = s"${formId}_datafield_168748_1_1_1"
  private lazy val includeAdditionalCheckNoId       = s"${formId}_datafield_168748_1_1_2"
  private lazy val noIdentityChecksId               = s"${formId}_datafield_184419_1_1_50074"
  private lazy val rtwOnlyId                        = s"${formId}_datafield_184419_1_1_50075"
  private lazy val rtwAndCrcId                      = s"${formId}_datafield_184419_1_1_50076"
  private lazy val uploadIdentityYesId              = s"${formId}_datafield_159069_1_1_1"
  private lazy val uploadIdentityNoId               = s"${formId}_datafield_159069_1_1_2"
  private lazy val nsvShowJobAndCandidateFormsId    = s"${formId}_datafield_107075_1_1_17226"
  private lazy val healthShowJobAndCandidateFormsId = s"${formId}_datafield_107079_1_1_17226"
  private lazy val nsvShowJobFormOnlyId             = s"${formId}_datafield_107075_1_1_17225"
  private lazy val healthShowJobFormOnlyId          = s"${formId}_datafield_107079_1_1_17225"
  private lazy val detailsIdentityDocsId            = s"${formId}_datafield_159299_1_1_en-GB"
  private lazy val manualIdentityCheckYesId         = s"${formId}_datafield_181577_1_1_1"
  private lazy val manualIdentityCheckNoId          = s"${formId}_datafield_181577_1_1_2"

  private def selectWhenCompleteRtwCheck(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    pecCheckFormsDetails.whenCompleteRtwCheck match {
      case "Before pre employment checks"              => clickOnRadioButton(beforePecChecksId)
      case "At the same time as pre employment checks" => clickOnRadioButton(sameTimeAsPecChecksId)
      case _                                           => throw new IllegalStateException("Please enter valid 'RTW Check' completion option")
    }

  private def selectWhichIdentityChecks(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    pecCheckFormsDetails.whichIdentityChecks match {
      case "No digital checks"                       => clickOnRadioButton(noIdentityChecksId)
      case "Right to work only"                      => clickOnRadioButton(rtwOnlyId)
      case "Right to work and criminal record check" => clickOnRadioButton(rtwAndCrcId)
      case _                                         => throw new IllegalStateException("Please enter valid 'which identity checks' option")
    }

  private def selectUploadIdentityDocs(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (pecCheckFormsDetails.uploadIdentityDocs) {
      clickOnRadioButton(uploadIdentityYesId)
      enterText(detailsIdentityDocsId, pecCheckFormsDetails.detailsOfIdentityDocs)
      if (pecCheckFormsDetails.manualIdentityDocCheck) clickOnRadioButton(manualIdentityCheckYesId)
      else clickOnRadioButton(manualIdentityCheckNoId)
    } else clickOnRadioButton(uploadIdentityNoId)

  private def selectNsvDisplayOptions(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (!pecCheckFormsDetails.nsvChecks.forall(Set("Not Applicable").contains(_))) {
      pecCheckFormsDetails.nsvDisplayOptions match {
        case "Show recruiter and candidate forms" => clickOnRadioButton(nsvShowJobAndCandidateFormsId)
        case "Show recruiter form only"           => clickOnRadioButton(nsvShowJobFormOnlyId)
        case _                                    => throw new IllegalStateException("Please enter valid 'NSV Display' option")
      }
    }

  private def selectHealthDisplayOptions(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (!pecCheckFormsDetails.healthRefChecks.forall(Set("Not Applicable").contains(_))) {
      pecCheckFormsDetails.healthDisplayOptions match {
        case "Show recruiter and candidate forms" => clickOnRadioButton(healthShowJobAndCandidateFormsId)
        case "Show recruiter form only"           => clickOnRadioButton(healthShowJobFormOnlyId)
        case _                                    => throw new IllegalStateException("Please enter valid 'Health Display' option")
      }
    }

  private def selectOGDTransferProcessCheck(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (pecCheckFormsDetails.ogdTransferProcessCheck) clickOnRadioButton(ogdTransferProcessCheckYesId)
    else clickOnRadioButton(ogdTransferProcessCheckNoId)

  private def selectIncludeAdditionalCheck(pecCheckFormsDetails: PecCheckFormsDetails): Unit =
    if (pecCheckFormsDetails.includeAdditionalCheck) {
      clickOnRadioButton(includeAdditionalCheckYesId)
      enterText(nameOfCheckInputId, pecCheckFormsDetails.nameOfCheck)
      enterRoles(pecCheckFormsDetails.additionalCheck, additionalCheckInputId)
    } else clickOnRadioButton(includeAdditionalCheckNoId)

  private def pecCheckFormsFlow(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    enterRoles(pecCheckFormsDetails.rtwCheck, rtwCheckInputId)
    selectWhenCompleteRtwCheck(pecCheckFormsDetails)
    selectWhichIdentityChecks(pecCheckFormsDetails)
    selectUploadIdentityDocs(pecCheckFormsDetails)
    enterRoles(pecCheckFormsDetails.generalInfo, generalInformationInputId)
    enterRoles(pecCheckFormsDetails.referenceChecks, referenceCheckInputId)
    enterRoles(pecCheckFormsDetails.bankruptcyChecks, bankruptcyCheckInputId)
    enterRoles(pecCheckFormsDetails.crcChecks, crcInputId)
    enterRoles(pecCheckFormsDetails.nsvChecks, nsvInputId)
    selectNsvDisplayOptions(pecCheckFormsDetails)
    enterRoles(pecCheckFormsDetails.jobHistoryChecks, jobHistoryCheckInputId)
    enterRoles(pecCheckFormsDetails.healthRefChecks, healthRefCheckInputId)
    selectHealthDisplayOptions(pecCheckFormsDetails)
    enterRoles(pecCheckFormsDetails.overseasCheck, overseasCheckInputId)
    enterRoles(pecCheckFormsDetails.pensionsCheck, pensionsCheckInputId)
    enterRoles(pecCheckFormsDetails.previousCsJobCheck, previousCsJobCheckInputId)
    enterRoles(pecCheckFormsDetails.internalFraudCheck, internalFraudCheckInputId)
    enterRoles(pecCheckFormsDetails.selfEmploymentCheck, selfEmploymentCheckInputId)
    selectOGDTransferProcessCheck(pecCheckFormsDetails)
    selectIncludeAdditionalCheck(pecCheckFormsDetails)
    enterRoles(pecCheckFormsDetails.nenOnboarding, nenInputId)
    enterRoles(pecCheckFormsDetails.pnOnboarding, pnInputId)
  }

  private val pecCheckForms: Seq[PecCheckFormsDetails => Unit] = Seq(
    pecCheckFormsFlow
  )

  def pecCheckFormsSection(newVacancyDetails: NewVacancyDetails): Unit =
    pecCheckForms.foreach { f =>
      f(newVacancyDetails.pecCheckFormsDetails)
    }

}
