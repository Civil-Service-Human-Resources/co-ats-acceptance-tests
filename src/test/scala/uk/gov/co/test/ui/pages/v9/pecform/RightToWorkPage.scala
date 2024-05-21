package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9EussStatus, v9RtwBritishCitizen, v9RtwHoldPassport, vXApproach, vXRtwChecks}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class RtwDetails(
  nationalityAtBirth: String,
  nationalityPresent: String,
  anyOtherNationality: Boolean,
  otherNationalityDetails: String,
  britishCitizen: Boolean,
  holdBritishPassport: Boolean,
  liveInUK: Boolean,
  euOrSwissCitizen: Boolean,
  eussStatus: String,
  applicationNo: String,
  eussShareCode: String,
  biometricResidenceCard: Boolean,
  viewAndProveStatusCode: String,
  proofOfNationalityDoc: String,
  areYouRefugee: Boolean,
  retainedNationality: Boolean,
  memberEUOrSwiss: Boolean
)

object RightToWorkPage extends CivilServiceJobsBasePage {

  private lazy val rightToWorkPageTitle = "Right to work - Civil Service Jobs - GOV.UK"
  def nationalityAtBirthId              = s"${pecFormId}_datafield_175585_1_1"
  def nationalityPresentId              = s"${pecFormId}_datafield_175603_1_1"
  def anyOtherNationalityYesId          = s"${pecFormId}_datafield_175621_1_1_1_label"
  def anyOtherNationalityNoId           = s"${pecFormId}_datafield_175621_1_1_2_label"
  def otherNationalityDetailsId         = s"${pecFormId}_datafield_175635_1_1"
  def britishCitizenYesId               = s"${pecFormId}_datafield_175678_1_1_1_label"
  def britishCitizenNoId                = s"${pecFormId}_datafield_175678_1_1_2_label"
  def holdBritishPassportYesId          = s"${pecFormId}_datafield_175877_1_1_1_label"
  def holdBritishPassportNoId           = s"${pecFormId}_datafield_175877_1_1_2_label"
  def liveInUKYesId                     = s"${pecFormId}_datafield_175692_1_1_1_label"
  def liveInUKNoId                      = s"${pecFormId}_datafield_175692_1_1_2_label"
  def euOrSwissCitizenYesId             = s"${pecFormId}_datafield_175710_1_1_1_label"
  def euOrSwissCitizenNoId              = s"${pecFormId}_datafield_175710_1_1_2_label"
  def eussStatusDidNotApplyId           = s"${pecFormId}_datafield_175746_1_1_42631_label"
  def eussStatusAppliedAwaitId          = s"${pecFormId}_datafield_175746_1_1_42632_label"
  def eussStatusSettledStatusId         = s"${pecFormId}_datafield_175746_1_1_42633_label"
  def eussStatusPreSettledStatusId      = s"${pecFormId}_datafield_175746_1_1_42634_label"
  def certApplicationNoId               = s"${pecFormId}_datafield_200499_1_1"
  def eussShareCodeId                   = s"${pecFormId}_datafield_175764_1_1"
  def biometricResidenceCardYesId       = s"${pecFormId}_datafield_175907_1_1_1_label"
  def biometricResidenceCardNoId        = s"${pecFormId}_datafield_175907_1_1_2_label"
  def viewAndProveStatusCodeId          = s"${pecFormId}_datafield_175911_1_1"
  def proofOfNationalityUploadId        = s"${pecFormId}_datafield_181785_1_1"
  def areYouRefugeeYesId                = s"${pecFormId}_datafield_175918_1_1_1_label"
  def areYouRefugeeNoId                 = s"${pecFormId}_datafield_175918_1_1_2_label"
  def retainedNationalityYesId          = s"${pecFormId}_datafield_175922_1_1_1_label"
  def retainedNationalityNoId           = s"${pecFormId}_datafield_175922_1_1_2_label"
  def memberOfEUOrSwissYesId            = s"${pecFormId}_datafield_175728_1_1_1_label"
  def memberOfEUOrSwissNoId             = s"${pecFormId}_datafield_175728_1_1_2_label"

  private def rtwPageCheck(): Unit =
    eventually(onPage(rightToWorkPageTitle))

  private def selectNationalityAtBirth(rtwDetails: RtwDetails): Unit =
    selectDropdownOption(nationalityAtBirthId, rtwDetails.nationalityAtBirth)

  private def selectPresentNationality(rtwDetails: RtwDetails): Unit =
    selectDropdownOption(nationalityPresentId, rtwDetails.nationalityPresent)

  private def uploadProofOfNationality(rtwDetails: RtwDetails): Unit =
    attachDocuments(proofOfNationalityUploadId, rtwDetails.proofOfNationalityDoc)

  private def selectAnyOtherCurrentNationality(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.anyOtherNationality) {
      radioSelect(anyOtherNationalityYesId)
      enterDetails(otherNationalityDetailsId, rtwDetails.otherNationalityDetails)
    } else {
      radioSelect(anyOtherNationalityNoId)
    }

  private def selectBiometricResidenceCard(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.biometricResidenceCard) {
      radioSelect(biometricResidenceCardYesId)
      enterDetails(viewAndProveStatusCodeId, rtwDetails.viewAndProveStatusCode)
      uploadProofOfNationality(rtwDetails)
      selectAreYouRefugee(rtwDetails)
    } else radioSelect(biometricResidenceCardNoId)

  private def selectAreYouRefugee(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.areYouRefugee) {
      radioSelect(areYouRefugeeYesId)
      selectRetainedNationality(rtwDetails)
    } else radioSelect(areYouRefugeeNoId)

  private def selectRetainedNationality(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.retainedNationality) radioSelect(retainedNationalityYesId)
    else radioSelect(retainedNationalityNoId)

  private def selectHoldBritishPassport(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.holdBritishPassport && v9RtwHoldPassport) radioSelect(holdBritishPassportYesId)
    else radioSelect(holdBritishPassportNoId)

  private def selectLiveInUK(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.liveInUK) radioSelect(liveInUKYesId)
    else radioSelect(liveInUKNoId)

  private def selectEuOrSwissCitizen(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.euOrSwissCitizen) {
      radioSelect(euOrSwissCitizenYesId)
      selectEussStatusFlow(rtwDetails)
    } else {
      radioSelect(euOrSwissCitizenNoId)
      selectMemberEuOrSwiss(rtwDetails)
    }

  private def selectMemberEuOrSwiss(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.memberEUOrSwiss) {
      radioSelect(memberOfEUOrSwissYesId)
      selectEussStatusFlow(rtwDetails)
    } else {
      radioSelect(memberOfEUOrSwissNoId)
      selectBiometricResidenceCard(rtwDetails)
    }

  private def selectAreYouBritishCitizen(rtwDetails: RtwDetails): Unit =
    if (rtwDetails.britishCitizen && v9RtwBritishCitizen) {
      radioSelect(britishCitizenYesId)
      selectHoldBritishPassport(rtwDetails)
    } else {
      v9RtwHoldPassport = false
      radioSelect(britishCitizenNoId)
      selectLiveInUK(rtwDetails)
      selectEuOrSwissCitizen(rtwDetails)
    }

  private def selectEussStatus(rtwDetails: RtwDetails): Unit =
    v9EussStatus match {
      case "What is your European Union Settlement Scheme (EUSS) status?"                 =>
        radioSelect(eussStatusDidNotApplyId)
        selectBiometricResidenceCard(rtwDetails)
      case "I have applied for the settlement scheme and await confirmation of my status" =>
        radioSelect(eussStatusAppliedAwaitId)
        enterDetails(certApplicationNoId, rtwDetails.applicationNo)
        selectBiometricResidenceCard(rtwDetails)
      case "I have settled status"                                                        =>
        radioSelect(eussStatusSettledStatusId)
        enterDetails(eussShareCodeId, rtwDetails.eussShareCode)
        uploadProofOfNationality(rtwDetails)
      case "I have pre-settled status"                                                    =>
        radioSelect(eussStatusPreSettledStatusId)
        enterDetails(eussShareCodeId, rtwDetails.eussShareCode)
        uploadProofOfNationality(rtwDetails)
    }

  private def selectEussStatusFlow(rtwDetails: RtwDetails): Unit =
    if (v9EussStatus.isEmpty) {
      v9EussStatus = rtwDetails.eussStatus
      selectEussStatus(rtwDetails)
    } else selectEussStatus(rtwDetails)

  private val rtw: Seq[RtwDetails => Unit] = Seq(
    selectNationalityAtBirth,
    selectPresentNationality,
    selectAnyOtherCurrentNationality,
    selectAreYouBritishCitizen
  )

  def rightToWorkPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXRtwChecks.contains("Not Applicable") &&
      vXRtwChecks.contains(s"$vXApproach Candidates")
    ) {
      rtwPageCheck()
      rtw.foreach { f =>
        f(pecFormDetails.rtwDetails)
      }
      clickOn(pageContinue)
    }
}
