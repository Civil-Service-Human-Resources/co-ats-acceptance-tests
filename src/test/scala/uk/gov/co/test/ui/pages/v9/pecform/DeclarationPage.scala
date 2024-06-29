package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXCrcCheckProvider, vXCrcLevel, vXPecCrc, vXPecEmploymentHistoryCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class DeclarationDetails(
  acceptPecFormTAndCs: Boolean,
  acceptDbsTermsOne: Boolean,
  acceptDbsTermsTwo: Boolean,
  acceptDbsTermsThree: Boolean,
  consentJobHistoryOne: Boolean,
  consentJobHistoryTwo: Boolean,
  consentJobHistoryThree: Boolean,
  consentFour: Boolean
)

object DeclarationPage extends CivilServiceJobsBasePage {

  private lazy val declarationTitle    = "Declaration - Civil Service Jobs - GOV.UK"
  def declarationTermsAndConditionsId  = s"${pecFormId}_datafield_22499_1_1_804_label"
  def dbsTermsOneTextId                = s"${pecFormId}_field_que_72275_1"
  def dbsTermsOneId                    = s"${pecFormId}_datafield_72275_1_1_15120_label"
  def dbsTermsTwoTextId                = s"${pecFormId}_field_que_89002_1"
  def dbsTermsTwoId                    = s"${pecFormId}_datafield_89002_1_1_15120_label"
  def dbsTermsThreeTextId              = s"${pecFormId}_field_que_89006_1"
  def dbsTermsThreeId                  = s"${pecFormId}_datafield_89006_1_1_15120_label"
  def generalPecTAndCsWithoutDbsTextId = s"${pecFormId}_label_96733_1"
  def generalPecTAndCsTextId           = s"${pecFormId}_label_96733_1"
  def generalPecTAndCsText2Id          = s"${pecFormId}_label_22496_1"
  def consentOneTextId                 = s"${pecFormId}_field_que_206010_1"
  def consentOneYesId                  = s"${pecFormId}_datafield_206010_1_1_1_label"
  def consentOneNoId                   = s"${pecFormId}_datafield_206010_1_1_2_label"
  def consentTwoTextId                 = s"${pecFormId}_field_que_206013_1"
  def consentTwoYesId                  = s"${pecFormId}_datafield_206013_1_1_1_label"
  def consentTwoNoId                   = s"${pecFormId}_datafield_206013_1_1_2_label"
  def consentThreeTextId               = s"${pecFormId}_field_que_206016_1"
  def consentThreeYesId                = s"${pecFormId}_datafield_206016_1_1_1_label"
  def consentThreeNoId                 = s"${pecFormId}_datafield_206016_1_1_2_label"
  def consentFourTextId                = s"${pecFormId}_field_que_206019_1"
  def consentFourYesId                 = s"${pecFormId}_datafield_206019_1_1_1_label"
  def consentFourNoId                  = s"${pecFormId}_datafield_206019_1_1_2_label"
  def pecDeclarationTAndCsId           = s"${pecFormId}_datafield_205986_1_1_804_label"
  val pecFormSubmission                = "submit_button"

  private def declarationPageCheck(): Unit =
    eventually(onPage(declarationTitle))

  private def acceptDbsTerms(declarationDetails: DeclarationDetails): Unit =
    if (
      vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS") && !vXPecCrc.contains("Not Applicable") && vXPecCrc
        .contains(s"$vXApproach Candidates")
    ) {
      waitForVisibilityOfElementById(
        dbsTermsOneTextId
      ).getText shouldEqual "I consent to the DBS providing an electronic result directly to the responsible organisation that has submitted my application. I understand that an electronic result contains a message that indicates either the certificate does not contain criminal record information or to await certificate which will indicate that my certificate contains criminal record information."
      waitForVisibilityOfElementById(
        dbsTermsTwoTextId
      ).getText shouldEqual "I have read the DBS Check Processing Privacy Policy (opens in a new window) and I understand how DBS will process my personal data"
      waitForVisibilityOfElementById(
        dbsTermsThreeTextId
      ).getText shouldEqual "I have provided complete and true information in support of the application and I understand that knowingly making a false statement for this purpose is a criminal offence."
      if (declarationDetails.acceptDbsTermsOne) radioSelect(dbsTermsOneId)
      if (declarationDetails.acceptDbsTermsTwo) radioSelect(dbsTermsTwoId)
      if (declarationDetails.acceptDbsTermsThree) radioSelect(dbsTermsThreeId)
    }

  private def consentTerms(declarationDetails: DeclarationDetails): Unit =
    if (
      !vXPecEmploymentHistoryCheck
        .contains("Not Applicable") && vXPecEmploymentHistoryCheck.contains(s"$vXApproach Candidates")
    ) {
      waitForVisibilityOfElementById(
        consentOneTextId
      ).getText shouldEqual "I consent to the recruiting organisation contacting HM Revenue and Customs (HMRC) to validate the employment history information I’ve given in this application"
      waitForVisibilityOfElementById(
        consentTwoTextId
      ).getText shouldEqual "I consent to HMRC disclosing employment history information about me from their Pay As You Earn (PAYE) database to the recruiting organisation to validate my employment history for this application only"
      waitForVisibilityOfElementById(
        consentThreeTextId
      ).getText shouldEqual "I understand my employment history, disclosed by HMRC to the recruiting organisation, may be shared onwards with the organisation I have applied to"
      if (declarationDetails.consentJobHistoryOne) radioSelect(consentOneYesId)
      if (declarationDetails.consentJobHistoryTwo) radioSelect(consentTwoYesId)
      if (declarationDetails.consentJobHistoryThree) radioSelect(consentThreeYesId)
      if (declarationDetails.consentFour) radioSelect(consentFourYesId)
    }

  private def acceptDeclarationTermsAndConditions(declarationDetails: DeclarationDetails): Unit =
    clickOn(pecDeclarationTAndCsId)

  private val declaration: Seq[DeclarationDetails => Unit] = Seq(
    acceptDbsTerms,
    consentTerms,
    acceptDeclarationTermsAndConditions
  )

  def declarationPage(pecFormDetails: PecFormDetails): Unit = {
    declarationPageCheck()
    declaration.foreach { f =>
      f(pecFormDetails.declarationDetails)
    }
  }
}
