package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9BiometricPassportOrId, v9IdvtDataConsent, v9InDateDrivingLicence, v9RtwHoldPassport, v9SmartphoneAccess, vXCrcLevel, vXRtwChecks, vXWhichIdentityChecks}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class DigitalIdentityDetails(
  idvtInfo: String,
  idvtDataConsentQuestion: String,
  idvtDataConsent: Boolean,
  smartphoneAccessQuestion: String,
  smartphoneAccess: Boolean,
  biometricPassportOrIdQuestion: String,
  biometricPassportOrId: Boolean,
  inDateDrivingLicenceQuestion: String,
  inDateDrivingLicence: Boolean
)

object DigitalIdentityCheckPage extends CivilServiceJobsBasePage {

  private lazy val digitalIdentityCheckPageTitle = "Digital identity check - Civil Service Jobs - GOV.UK"
  def idvtTextId                                 = s"${pecFormId}_label_183544_1"
  def idvtDataConsentQuestionId                  = s"${pecFormId}_field_que_183548_1"
  def idvtDataConsentYesId                       = s"${pecFormId}_datafield_183548_1_1_1_label"
  def idvtDataConsentNoId                        = s"${pecFormId}_datafield_183548_1_1_2_label"
  def smartphoneAccessQuestionId                 = s"${pecFormId}_field_que_184480_1"
  def smartphoneAccessYesId                      = s"${pecFormId}_datafield_184480_1_1_1_label"
  def smartphoneAccessNoId                       = s"${pecFormId}_datafield_184480_1_1_2_label"
  def inDateDrivingLicenceQuestionId             = s"${pecFormId}_field_que_184486_1"
  def inDateDrivingLicenceYesId                  = s"${pecFormId}_datafield_184486_1_1_1_label"
  def inDateDrivingLicenceNoId                   = s"${pecFormId}_datafield_184486_1_1_2_label"
  def biometricPassportOrIdQuestionId            = s"${pecFormId}_field_que_184483_1"
  def biometricPassportOrIdYesId                 = s"${pecFormId}_datafield_184483_1_1_1_label"
  def biometricPassportOrIdNoId                  = s"${pecFormId}_datafield_184483_1_1_2_label"

  private def digitalIdentityPageCheck(): Unit =
    eventually(onPage(digitalIdentityCheckPageTitle))

  private def confirmHeaderAndInfo(digitalIdentityDetails: DigitalIdentityDetails): Unit = {
    waitForVisibilityOfElementByTag("h2").getText           should endWith("Digital identity check")
    waitForVisibilityOfElementById(idvtTextId).getText shouldEqual digitalIdentityDetails.idvtInfo
  }

  private def selectIdvtDataConsent(digitalIdentityDetails: DigitalIdentityDetails): Unit = {
    waitForVisibilityOfElementById(
      idvtDataConsentQuestionId
    ).getText shouldEqual digitalIdentityDetails.idvtDataConsentQuestion
    if (digitalIdentityDetails.idvtDataConsent && v9IdvtDataConsent) {
      radioSelect(idvtDataConsentYesId)
      selectSmartPhoneAccess(digitalIdentityDetails)
    } else radioSelect(idvtDataConsentNoId)
  }

  private def selectSmartPhoneAccess(digitalIdentityDetails: DigitalIdentityDetails): Unit = {
    waitForVisibilityOfElementById(
      smartphoneAccessQuestionId
    ).getText shouldEqual digitalIdentityDetails.smartphoneAccessQuestion
    if (digitalIdentityDetails.smartphoneAccess && v9SmartphoneAccess) {
      radioSelect(smartphoneAccessYesId)
      selectBiometricPassportOrId(digitalIdentityDetails)
      selectInDateDrivingLicence(digitalIdentityDetails)
    } else radioSelect(smartphoneAccessNoId)
  }

  private def selectBiometricPassportOrId(digitalIdentityDetails: DigitalIdentityDetails): Unit = {
    v9BiometricPassportOrId = digitalIdentityDetails.biometricPassportOrId
    if (vXCrcLevel != "None" && vXWhichIdentityChecks != "No digital checks" && vXWhichIdentityChecks == "Right to work and criminal record check") {
      waitForVisibilityOfElementById(
        biometricPassportOrIdQuestionId
      ).getText shouldEqual digitalIdentityDetails.biometricPassportOrIdQuestion
      if (v9BiometricPassportOrId) {
        radioSelect(biometricPassportOrIdYesId)
      } else radioSelect(biometricPassportOrIdNoId)
    }
  }

  private def selectInDateDrivingLicence(digitalIdentityDetails: DigitalIdentityDetails): Unit = {
    v9InDateDrivingLicence = digitalIdentityDetails.inDateDrivingLicence
    if (vXCrcLevel == "Standard" || vXCrcLevel == "Enhanced" && vXWhichIdentityChecks == "Right to work and criminal record check") {
      waitForVisibilityOfElementById(
        inDateDrivingLicenceQuestionId
      ).getText shouldEqual digitalIdentityDetails.inDateDrivingLicenceQuestion
      if (v9InDateDrivingLicence) {
        radioSelect(inDateDrivingLicenceYesId)
      } else radioSelect(inDateDrivingLicenceNoId)
    }
  }

  private val idvt: Seq[DigitalIdentityDetails => Unit] = Seq(
    confirmHeaderAndInfo,
    selectIdvtDataConsent
  )

  def digitalIdentityCheckPage(pecFormDetails: PecFormDetails): Unit =
    if (vXWhichIdentityChecks != "No digital checks") {
      digitalIdentityPageCheck()
      idvt.foreach { f =>
        f(pecFormDetails.digitalIdentityDetails)
      }
      clickOn(pageContinue)
    }
}
