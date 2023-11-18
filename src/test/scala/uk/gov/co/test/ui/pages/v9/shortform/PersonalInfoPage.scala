package uk.gov.co.test.ui.pages.v9.shortform

import org.openqa.selenium.{By, Keys}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId

case class PersonalInfoDetails(
  firstName: String,
  lastName: String,
  preferredFirstName: Option[String] = None,
  preferredTeleNo: String,
  secondaryNo: Option[String] = None,
  email: String,
  applyDCS: Boolean,
  reasonableAdjustments: Boolean,
  reasonableAdjustmentsDetails: String,
  redeploymentScheme: Option[Boolean] = None
)

object PersonalInfoPage extends CivilServiceJobsBasePage {

  private lazy val personalInfoTitle                  = "Personal information - Civil Service Jobs - GOV.UK"
  private lazy val firstNameInputId                   = s"${formId}_datafield_11625_1_1"
  private lazy val lastNameInputId                    = s"${formId}_datafield_11628_1_1"
  private lazy val preferredFirstNameInputId          = s"${formId}_datafield_21495_1_1"
  private lazy val preferredTeleNoInputId             = s"${formId}_datafield_11643_1_1"
  private lazy val secondaryNoInputId                 = s"${formId}_datafield_11657_1_1"
  private lazy val emailInputId                       = s"${formId}_datafield_11631_1_1"
  private lazy val applyDCSYesId                      = s"${formId}_datafield_98109_1_1_1_label"
  private lazy val applyDCSNoId                       = s"${formId}_datafield_98109_1_1_2_label"
  private lazy val reasonableAdjustmentYesId          = s"${formId}_datafield_15904_1_1_1_label"
  private lazy val reasonableAdjustmentNoId           = s"${formId}_datafield_15904_1_1_2_label"
  private lazy val reasonableAdjustmentDetailsInputId = s"${formId}_datafield_174746_1_1"
  private lazy val redeploymentSchemeId               = s"${formId}_datafield_175270_1_1_fieldset"
  private lazy val redeploymentSchemeYesId            = s"${formId}_datafield_175270_1_1_1_label"
  private lazy val redeploymentSchemeNoId             = s"${formId}_datafield_175270_1_1_2_label"

  def enterPersonalInfo(inputId: String, text: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
    enterOption.sendKeys(text)
    enterOption.sendKeys(Keys.TAB)
  }

  private def personalInfoPageCheck(): Unit =
    eventually(onPage(personalInfoTitle))

  private def enterFirstName(personalInfoDetails: PersonalInfoDetails): Unit = {
    personalInfoPageCheck()
    if (extractValue(firstNameInputId).isEmpty) {
      enterPersonalInfo(firstNameInputId, personalInfoDetails.firstName)
    } else extractValue(firstNameInputId) shouldEqual personalInfoDetails.firstName
  }

  private def enterLastName(personalInfoDetails: PersonalInfoDetails): Unit           =
    if (extractValue(lastNameInputId).isEmpty) {
      enterPersonalInfo(lastNameInputId, personalInfoDetails.lastName)
    } else extractValue(lastNameInputId) shouldEqual personalInfoDetails.lastName

  private def enterPreferredFirstName(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(preferredFirstNameInputId).isEmpty) {
      enterPersonalInfo(preferredFirstNameInputId, personalInfoDetails.preferredFirstName.get)
    } else extractValue(preferredFirstNameInputId) shouldEqual personalInfoDetails.preferredFirstName

  private def enterEmail(personalInfoDetails: PersonalInfoDetails): Unit              =
    if (extractValue(emailInputId).isEmpty) {
      enterPersonalInfo(emailInputId, personalInfoDetails.email)
    } else extractValue(emailInputId) shouldEqual personalInfoDetails.email

  private def enterPreferredTeleNo(personalInfoDetails: PersonalInfoDetails): Unit = {
    scrollToElement(By.id(preferredTeleNoInputId))
    if (extractValue(preferredTeleNoInputId).isEmpty) {
      enterPersonalInfo(preferredTeleNoInputId, personalInfoDetails.preferredTeleNo)
    } else extractValue(preferredTeleNoInputId) shouldEqual personalInfoDetails.preferredTeleNo
  }

  private def enterSecondaryContactNo(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(secondaryNoInputId).isEmpty)
      enterPersonalInfo(secondaryNoInputId, personalInfoDetails.secondaryNo.get)

  private def selectApplyDCS(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.applyDCS) radioSelect(applyDCSYesId)
    else radioSelect(applyDCSNoId)

  private def selectReasonableAdjustments(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.reasonableAdjustments) {
      radioSelect(reasonableAdjustmentYesId)
      enterPersonalInfo(reasonableAdjustmentDetailsInputId, personalInfoDetails.reasonableAdjustmentsDetails)
    } else radioSelect(reasonableAdjustmentNoId)

  private def enterRedeploymentScheme(personalInfoDetails: PersonalInfoDetails): Unit = {
    scrollToElement(By.id(redeploymentSchemeId))
    if (personalInfoDetails.redeploymentScheme.get) radioSelect(redeploymentSchemeYesId)
    else radioSelect(redeploymentSchemeNoId)
  }

  private val personalInfo: Seq[PersonalInfoDetails => Unit] = Seq(
    enterFirstName,
    enterLastName,
    enterPreferredFirstName,
    enterPreferredTeleNo,
    enterSecondaryContactNo,
    enterEmail,
    selectApplyDCS,
    selectReasonableAdjustments,
    enterRedeploymentScheme
  )

  def personalInfoPage(shortFormDetails: ShortFormDetails): Unit = {
    personalInfo.foreach { f =>
      f(shortFormDetails.personalInfoDetails)
    }
    clickOn(pageContinue)
  }
}
