package uk.gov.co.test.ui.pages.v9.shortform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.pages.v9.shortform.EligibilityPage.civilServant
import uk.gov.co.test.ui.pages.vx.createvacancypage.ManagementSection.greatForVeterans
import uk.gov.co.test.ui.pages.vx.createvacancypage.VacancyTestsSection.anyOnlineTests

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
  reasonableAdjustmentsForTests: Boolean,
  reasonableAdjustmentsForTestsDetails: String,
  areYouAVeteran: String,
  veteranInitiative: Boolean,
  redeploymentScheme: Option[Boolean] = None
)

object PersonalInfoPage extends CivilServiceJobsBasePage {

  def personalInfoTitle                    = "Personal information - Civil Service Jobs - GOV.UK"
  def firstNameInputId                     = s"${formId}_datafield_11625_1_1"
  def lastNameInputId                      = s"${formId}_datafield_11628_1_1"
  def preferredFirstNameInputId            = s"${formId}_datafield_21495_1_1"
  def preferredTeleNoInputId               = s"${formId}_datafield_11643_1_1"
  def secondaryNoInputId                   = s"${formId}_datafield_11657_1_1"
  def emailInputId                         = s"${formId}_datafield_11631_1_1"
  def applyDCSYesId                        = s"${formId}_datafield_98109_1_1_1_label"
  def applyDCSNoId                         = s"${formId}_datafield_98109_1_1_2_label"
  def reasonableAdjustmentYesId            = s"${formId}_datafield_15904_1_1_1_label"
  def reasonableAdjustmentNoId             = s"${formId}_datafield_15904_1_1_2_label"
  def reasonableAdjustmentDetailsInputId   = s"${formId}_datafield_174746_1_1"
  def redeploymentSchemeId                 = s"${formId}_datafield_175270_1_1_fieldset"
  def redeploymentSchemeYesId              = s"${formId}_datafield_175270_1_1_1_label"
  def redeploymentSchemeNoId               = s"${formId}_datafield_175270_1_1_2_label"
  def reasonableAdjustmentsForTestsYesId   = s"${formId}_datafield_110850_1_1_1_label"
  def reasonableAdjustmentsForTestsNoId    = s"${formId}_datafield_110850_1_1_2_label"
  def reasonableAdjustmentsForTestsInputId = s"${formId}_datafield_174773_1_1"
  def areYouAVeteranYesId                  = s"${formId}_datafield_138183_1_1_729_label"
  def areYouAVeteranNoId                   = s"${formId}_datafield_138183_1_1_730_label"
  def areYouAVeteranNoNotSayId             = s"${formId}_datafield_138183_1_1_731_label"
  def veteranInitiativeYesId               = s"${formId}_datafield_138179_1_1_1_label"
  def veteranInitiativeNoId                = s"${formId}_datafield_138179_1_1_2_label"

  private def personalInfoPageCheck(): Unit =
    eventually(onPage(personalInfoTitle))

  private def enterFirstName(personalInfoDetails: PersonalInfoDetails): Unit = {
    personalInfoPageCheck()
    if (extractValue(firstNameInputId).isEmpty) {
      enterDetails(firstNameInputId, personalInfoDetails.firstName)
    } else extractValue(firstNameInputId) shouldEqual personalInfoDetails.firstName
  }

  private def enterLastName(personalInfoDetails: PersonalInfoDetails): Unit           =
    if (extractValue(lastNameInputId).isEmpty) {
      enterDetails(lastNameInputId, personalInfoDetails.lastName)
    } else extractValue(lastNameInputId) shouldEqual personalInfoDetails.lastName

  private def enterPreferredFirstName(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(preferredFirstNameInputId).isEmpty) {
      enterDetails(preferredFirstNameInputId, personalInfoDetails.preferredFirstName.get)
    } else extractValue(preferredFirstNameInputId) shouldEqual personalInfoDetails.preferredFirstName

  private def enterEmail(personalInfoDetails: PersonalInfoDetails): Unit              =
    if (extractValue(emailInputId).isEmpty) {
      enterDetails(emailInputId, personalInfoDetails.email)
    } else extractValue(emailInputId) shouldEqual personalInfoDetails.email

  private def enterPreferredTeleNo(personalInfoDetails: PersonalInfoDetails): Unit = {
    scrollToElement(By.id(preferredTeleNoInputId))
    if (extractValue(preferredTeleNoInputId).isEmpty) {
      enterDetails(preferredTeleNoInputId, personalInfoDetails.preferredTeleNo)
    } else extractValue(preferredTeleNoInputId) shouldEqual personalInfoDetails.preferredTeleNo
  }

  private def enterSecondaryContactNo(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(secondaryNoInputId).isEmpty)
      enterDetails(secondaryNoInputId, personalInfoDetails.secondaryNo.get)

  private def selectApplyDCS(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.applyDCS) radioSelect(applyDCSYesId)
    else radioSelect(applyDCSNoId)

  private def selectReasonableAdjustments(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.reasonableAdjustments) {
      radioSelect(reasonableAdjustmentYesId)
      enterDetails(reasonableAdjustmentDetailsInputId, personalInfoDetails.reasonableAdjustmentsDetails)
      if (anyOnlineTests == "" || anyOnlineTests.toBoolean) { // TODO requires refactor
        if (personalInfoDetails.reasonableAdjustmentsForTests) {
          radioSelect(reasonableAdjustmentsForTestsYesId)
          enterDetails(
            reasonableAdjustmentsForTestsInputId,
            personalInfoDetails.reasonableAdjustmentsForTestsDetails
          )
        } else radioSelect(reasonableAdjustmentsForTestsNoId)
      }
    } else radioSelect(reasonableAdjustmentNoId)

  private def selectAreYouVeteran(personalInfoDetails: PersonalInfoDetails): Unit =
    if (greatForVeterans) {
      personalInfoDetails.areYouAVeteran match {
        case "Yes"                    =>
          radioSelect(areYouAVeteranYesId)
          if (personalInfoDetails.veteranInitiative) radioSelect(veteranInitiativeYesId)
          else radioSelect(veteranInitiativeNoId)
        case "No"                     => radioSelect(areYouAVeteranNoId)
        case "Prefer not to disclose" => radioSelect(areYouAVeteranNoNotSayId)
        case _                        => throw new IllegalStateException("Valid select option needs to be stated")
      }
    }

  private def enterRedeploymentScheme(personalInfoDetails: PersonalInfoDetails): Unit =
    if (civilServant) {
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
    enterRedeploymentScheme,
    selectAreYouVeteran
  )

  def personalInfoPage(shortFormDetails: ShortFormDetails): Unit = {
    personalInfo.foreach { f =>
      f(shortFormDetails.personalInfoDetails)
    }
    clickOn(pageContinue)
  }
}
