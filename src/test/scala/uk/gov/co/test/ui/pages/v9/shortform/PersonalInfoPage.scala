package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ApplicationDetails
import uk.gov.co.test.ui.pages.v9.CSJobsBasePage
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
  reasonableAdjustmentsDetails: String
)

object PersonalInfoPage extends CSJobsBasePage {

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

  def enterPersonalInfo(inputId: String, text: String): Unit = {
    val enterOption = waitForVisibilityOfElementById(inputId)
    enterOption.sendKeys(text)
  }

  private def personalInfoPageCheck(): Unit =
    eventually(onPage(personalInfoTitle))

  private def enterFirstName(personalInfoDetails: PersonalInfoDetails): Unit = {
    personalInfoPageCheck()
    if (waitForVisibilityOfElementById(firstNameInputId).getText.isEmpty) {
      enterPersonalInfo(firstNameInputId, personalInfoDetails.firstName)
    } else {
      waitForVisibilityOfElementById(firstNameInputId).getText shouldEqual s"$randomFirstName"
    }
  }

  private def enterLastName(personalInfoDetails: PersonalInfoDetails): Unit =
    if (waitForVisibilityOfElementById(lastNameInputId).getText.isEmpty) {
      enterPersonalInfo(lastNameInputId, personalInfoDetails.lastName)
    } else {
      waitForVisibilityOfElementById(lastNameInputId).getText shouldEqual s"$randomLastName"
    }

  private def enterPreferredFirstName(personalInfoDetails: PersonalInfoDetails): Unit =
    if (waitForVisibilityOfElementById(preferredFirstNameInputId).getText.isEmpty) {
      enterPersonalInfo(preferredFirstNameInputId, personalInfoDetails.preferredFirstName.get)
    }

  private def enterEmail(personalInfoDetails: PersonalInfoDetails): Unit =
    if (waitForVisibilityOfElementById(emailInputId).getText.isEmpty) {
      enterPersonalInfo(emailInputId, personalInfoDetails.email)
    } else {
      waitForVisibilityOfElementById(
        emailInputId
      ).getText shouldEqual s"$randomFirstName.$randomLastName@ats_example.com"
    }

  private def enterPreferredTeleNo(personalInfoDetails: PersonalInfoDetails): Unit =
    if (waitForVisibilityOfElementById(preferredTeleNoInputId).getText.isEmpty)
      enterPersonalInfo(preferredTeleNoInputId, personalInfoDetails.preferredTeleNo)

  private def selectApplyDCS(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.applyDCS) radioSelect(applyDCSYesId)
    else radioSelect(applyDCSNoId)

  private def selectReasonableAdjustments(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.reasonableAdjustments) {
      radioSelect(reasonableAdjustmentYesId)
      enterPersonalInfo(reasonableAdjustmentDetailsInputId, personalInfoDetails.reasonableAdjustmentsDetails)
    } else radioSelect(reasonableAdjustmentNoId)

  private val personalInfo: Seq[PersonalInfoDetails => Unit] = Seq(
    enterFirstName,
    enterLastName,
    enterPreferredFirstName,
    enterEmail,
    enterPreferredTeleNo,
    selectApplyDCS,
    selectReasonableAdjustments
  )

  def personalInfoPage(applicationDetails: ApplicationDetails): Unit = {
    personalInfo.foreach { f =>
      f(applicationDetails.personalInfoDetails)
    }
    clickOn(pageContinue)
  }
}
