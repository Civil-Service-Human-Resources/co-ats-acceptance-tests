package uk.gov.co.test.ui.pages.v9.shortform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.ApplicationDetails
import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.enterText
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

  private def personalInfoPageCheck(): Unit =
    eventually(onPage(personalInfoTitle))

  private def enterPersonalInformation(personalInfoDetails: PersonalInfoDetails): Unit = {
    personalInfoPageCheck()
    waitForVisibilityOfElementById(firstNameInputId).getText shouldEqual s"$randomFirstName"
    waitForVisibilityOfElementById(lastNameInputId).getText  shouldEqual s"$randomLastName"
    waitForVisibilityOfElementById(emailInputId).getText     shouldEqual s"$randomFirstName.$randomLastName@ats_example.com"
    if (waitForVisibilityOfElementById(preferredTeleNoInputId).getText.isEmpty)
      enterText(preferredTeleNoInputId, personalInfoDetails.preferredTeleNo)
  }

  private def selectApplyDCS(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.applyDCS) radioSelect(applyDCSYesId)
    else radioSelect(applyDCSNoId)

  private def selectReasonableAdjustments(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.reasonableAdjustments) {
      radioSelect(reasonableAdjustmentYesId)
      enterText(reasonableAdjustmentDetailsInputId, personalInfoDetails.reasonableAdjustmentsDetails)
    } else radioSelect(reasonableAdjustmentNoId)

  private val personalInfo: Seq[PersonalInfoDetails => Unit] = Seq(
    enterPersonalInformation,
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
