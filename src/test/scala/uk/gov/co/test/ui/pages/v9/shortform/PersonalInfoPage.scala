package uk.gov.co.test.ui.pages.v9.shortform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{preferredFirstName, preferredTeleNumber, randomEmail, randomFirstName, randomLastName, v9AdjustmentsForTests, v9CivilServant, v9HomeDepartment, v9ReasonableAdjustments, vXAnyOnlineTests, vXGreatForVeterans, vXJobInfoDepartment}
import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.shortFormId

case class PersonalInfoDetails(
  preferredTeleNo: String,
  secondaryNo: Option[String] = None,
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
  def firstNameInputId                     = s"${shortFormId}_datafield_11625_1_1"
  def lastNameInputId                      = s"${shortFormId}_datafield_11628_1_1"
  def preferredFirstNameInputId            = s"${shortFormId}_datafield_21495_1_1"
  def preferredTeleNoInputId               = s"${shortFormId}_datafield_11643_1_1"
  def secondaryNoInputId                   = s"${shortFormId}_datafield_11657_1_1"
  def emailInputId                         = s"${shortFormId}_datafield_11631_1_1"
  def applyDCSYesId                        = s"${shortFormId}_datafield_98109_1_1_1_label"
  def applyDCSNoId                         = s"${shortFormId}_datafield_98109_1_1_2_label"
  def reasonableAdjustmentYesId            = s"${shortFormId}_datafield_15904_1_1_1_label"
  def reasonableAdjustmentNoId             = s"${shortFormId}_datafield_15904_1_1_2_label"
  def reasonableAdjustmentDetailsInputId   = s"${shortFormId}_datafield_174746_1_1"
  def redeploymentSchemeId                 = s"${shortFormId}_datafield_175270_1_1_fieldset"
  def redeploymentSchemeYesId              = s"${shortFormId}_datafield_175270_1_1_1_label"
  def redeploymentSchemeNoId               = s"${shortFormId}_datafield_175270_1_1_2_label"
  def reasonableAdjustmentsForTestsYesId   = s"${shortFormId}_datafield_110850_1_1_1_label"
  def reasonableAdjustmentsForTestsNoId    = s"${shortFormId}_datafield_110850_1_1_2_label"
  def reasonableAdjustmentsForTestsInputId = s"${shortFormId}_datafield_174773_1_1"
  def areYouAVeteranYesId                  = s"${shortFormId}_datafield_138183_1_1_729_label"
  def areYouAVeteranNoId                   = s"${shortFormId}_datafield_138183_1_1_730_label"
  def areYouAVeteranNoNotSayId             = s"${shortFormId}_datafield_138183_1_1_731_label"
  def veteranInitiativeYesId               = s"${shortFormId}_datafield_138179_1_1_1_label"
  def veteranInitiativeNoId                = s"${shortFormId}_datafield_138179_1_1_2_label"

  private def personalInfoPageCheck(): Unit =
    eventually(onPage(personalInfoTitle))

  private def enterFirstName(personalInfoDetails: PersonalInfoDetails): Unit = {
    personalInfoPageCheck()
    if (extractValue(firstNameInputId).isEmpty) {
      enterDetails(firstNameInputId, randomFirstName)
    } else extractValue(firstNameInputId) shouldEqual randomFirstName
  }

  private def enterLastName(personalInfoDetails: PersonalInfoDetails): Unit           =
    if (extractValue(lastNameInputId).isEmpty) {
      enterDetails(lastNameInputId, randomLastName)
    } else extractValue(lastNameInputId) shouldEqual randomLastName

  private def enterPreferredFirstName(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(preferredFirstNameInputId).isEmpty) {
      enterDetails(preferredFirstNameInputId, preferredFirstName)
    } else extractValue(preferredFirstNameInputId) shouldEqual preferredFirstName

  private def enterEmail(personalInfoDetails: PersonalInfoDetails): Unit              =
    if (extractValue(emailInputId).isEmpty) {
      enterDetails(emailInputId, randomEmail)
    } else extractValue(emailInputId) shouldEqual randomEmail

  private def enterPreferredTeleNo(personalInfoDetails: PersonalInfoDetails): Unit = {
    scrollToElement(By.id(preferredTeleNoInputId))
    if (extractValue(preferredTeleNoInputId).isEmpty) {
      preferredTeleNumber = personalInfoDetails.preferredTeleNo
      enterDetails(preferredTeleNoInputId, preferredTeleNumber)
    } else extractValue(preferredTeleNoInputId) shouldEqual preferredTeleNumber
  }

  private def enterSecondaryContactNo(personalInfoDetails: PersonalInfoDetails): Unit =
    if (extractValue(secondaryNoInputId).isEmpty)
      enterDetails(secondaryNoInputId, personalInfoDetails.secondaryNo.get)

  private def selectApplyDCS(personalInfoDetails: PersonalInfoDetails): Unit =
    if (personalInfoDetails.applyDCS) radioSelect(applyDCSYesId)
    else radioSelect(applyDCSNoId)

  private def selectReasonableAdjustments(personalInfoDetails: PersonalInfoDetails): Unit = {
    v9ReasonableAdjustments = personalInfoDetails.reasonableAdjustments
    if (v9ReasonableAdjustments) {
      radioSelect(reasonableAdjustmentYesId)
      enterDetails(reasonableAdjustmentDetailsInputId, personalInfoDetails.reasonableAdjustmentsDetails)
    } else radioSelect(reasonableAdjustmentNoId)
  }

  private def selectReasonableAdjustmentsForTests(personalInfoDetails: PersonalInfoDetails): Unit =
    if (vXAnyOnlineTests) {
      v9AdjustmentsForTests = personalInfoDetails.reasonableAdjustmentsForTests
      if (v9AdjustmentsForTests) {
        radioSelect(reasonableAdjustmentsForTestsYesId)
        enterDetails(
          reasonableAdjustmentsForTestsInputId,
          personalInfoDetails.reasonableAdjustmentsForTestsDetails
        )
      } else radioSelect(reasonableAdjustmentsForTestsNoId)
    }

  private def selectAreYouVeteran(personalInfoDetails: PersonalInfoDetails): Unit =
    if (vXGreatForVeterans && !v9CivilServant) {
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
    if (v9CivilServant
        &&
        (vXJobInfoDepartment == "Department for Energy Security & Net Zero" ||
        vXJobInfoDepartment == "Department for Science, Innovation and Technology" ||
//        vXJobInfoDepartment == "Department for Environment, Food and Rural Affairs" ||
        vXJobInfoDepartment == "Government Equalities Office" ||
        vXJobInfoDepartment == "Revenue Scotland" ||
        vXJobInfoDepartment == "Scottish Fiscal Commission" ||
        vXJobInfoDepartment == "Cabinet Office" ||
        vXJobInfoDepartment == "Transport Scotland")
        &&
        (v9HomeDepartment == "Department for Energy Security & Net Zero" ||
        v9HomeDepartment == "Department for Science, Innovation and Technology" ||
        v9HomeDepartment == "Department for Environment, Food and Rural Affairs" ||
        v9HomeDepartment == "Government Equalities Office" ||
        v9HomeDepartment == "Revenue Scotland" ||
        v9HomeDepartment == "Scottish Fiscal Commission" ||
        v9HomeDepartment == "Ministry of Defence" ||
        v9HomeDepartment == "Government Commercial Function" ||
        v9HomeDepartment == "Central Digital and Data Office" ||
        v9HomeDepartment == "Government Digital Services" ||
        v9HomeDepartment == "Government Property Agency" ||
        v9HomeDepartment == "Veterinary Medicines Directorate" ||
        v9HomeDepartment == "Rural Payments Agency" ||
        v9HomeDepartment == "Health and Safety Executive" ||
        v9HomeDepartment == "Department for Work and Pensions" ||
        v9HomeDepartment == "UK Hydrographic Office" ||
        v9HomeDepartment == "Animal and Plant Health Agency" ||
        v9HomeDepartment == "Transport Scotland")
    ) {
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
    selectReasonableAdjustmentsForTests,
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
