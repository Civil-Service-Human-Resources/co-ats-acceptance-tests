package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class VettingDetails(
  reservedStatus: Boolean,
  checkLevelRequired: String,
  whichProvider: String,
  vettingLevelRequired: String,
  medicalRequired: Boolean
)

object CheckingVettingSection extends VacancyBasePage {

  private lazy val reservedStatusId             = s"${formId}_datafield_59601_1_1_fieldset"
  private lazy val reservedYesId                = s"${formId}_datafield_59601_1_1_868"
  private lazy val reservedNoId                 = s"${formId}_datafield_59601_1_1_869"
  private lazy val basicCheckId                 = s"${formId}_datafield_59611_1_1_12650"
  private lazy val standardCheckId              = s"${formId}_datafield_59611_1_1_11340"
  private lazy val enhancedCheckId              = s"${formId}_datafield_59611_1_1_11341"
  private lazy val noCheckRequiredId            = s"${formId}_datafield_59611_1_1_15464"
  private lazy val dbsProviderId                = s"${formId}_datafield_97307_1_1_15345"
  private lazy val disclosureScotlandProviderId = s"${formId}_datafield_97307_1_1_15346"
  private lazy val accessNIProviderId           = s"${formId}_datafield_97307_1_1_15346"
  private lazy val vettingRequiredId            = s"${formId}_field_value_93637_1"
  private lazy val counterTerroristCheckId      = s"${formId}_datafield_93637_1_1_15342"
  private lazy val securityCheckId              = s"${formId}_datafield_93637_1_1_15343"
  private lazy val developedVettingId           = s"${formId}_datafield_93637_1_1_15344"
  private lazy val noVettingRequiredId          = s"${formId}_datafield_93637_1_1_15341"
  private lazy val medicalRequiredYesId         = s"${formId}_datafield_59608_1_1_1"
  private lazy val medicalRequiredNoId          = s"${formId}_datafield_59608_1_1_2"

  private def selectCheckLevelRequired(vettingDetails: VettingDetails): Unit =
    vettingDetails.checkLevelRequired match {
      case "Basic"    => clickOnRadioButton(basicCheckId)
      case "Standard" => clickOnRadioButton(standardCheckId)
      case "Enhanced" => clickOnRadioButton(enhancedCheckId)
      case "None"     => clickOnRadioButton(noCheckRequiredId)
    }

  private def checkWhichProvider(vettingDetails: VettingDetails): Unit =
    vettingDetails.whichProvider match {
      case "Disclosure barring service (DBS)" => checkbox(dbsProviderId).select()
      case "Disclosure Scotland"              => checkbox(disclosureScotlandProviderId).select()
      case "Access NI"                        => checkbox(accessNIProviderId).select()
    }

  private def selectVettingLevelRequired(vettingDetails: VettingDetails): Unit = {
    scrollToElement(By.id(vettingRequiredId))
    vettingDetails.vettingLevelRequired match {
      case "Counter terrorist check" => clickOnRadioButton(counterTerroristCheckId)
      case "Security check"          => clickOnRadioButton(securityCheckId)
      case "Developed vetting"       => clickOnRadioButton(developedVettingId)
      case "None"                    => clickOnRadioButton(noVettingRequiredId)
    }
  }

  private def selectReservedStatus(vettingDetails: VettingDetails): Unit = {
    scrollToElement(By.id(reservedStatusId))
    if (vettingDetails.reservedStatus) clickOnRadioButton(reservedYesId) else clickOnRadioButton(reservedNoId)
  }

  private def selectMedicalRequired(vettingDetails: VettingDetails): Unit =
    if (vettingDetails.medicalRequired) clickOnRadioButton(medicalRequiredYesId)
    else clickOnRadioButton(medicalRequiredNoId)

  private val checkAndVetting: Seq[VettingDetails => Unit] = Seq(
    selectReservedStatus,
    selectCheckLevelRequired,
    checkWhichProvider,
    selectVettingLevelRequired,
    selectMedicalRequired
  )

  def checkVettingSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    checkAndVetting.foreach { f =>
      f(newVacancyDetails.vettingDetails)
    }

}
