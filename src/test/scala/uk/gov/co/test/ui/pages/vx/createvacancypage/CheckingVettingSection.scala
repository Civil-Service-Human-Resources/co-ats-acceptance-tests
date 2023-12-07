package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
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

  def reservedStatusId             = s"${formId}_datafield_59601_1_1_fieldset"
  def reservedYesId                = s"${formId}_datafield_59601_1_1_868"
  def reservedNoId                 = s"${formId}_datafield_59601_1_1_869"
  def basicCheckId                 = s"${formId}_datafield_59611_1_1_12650"
  def standardCheckId              = s"${formId}_datafield_59611_1_1_11340"
  def enhancedCheckId              = s"${formId}_datafield_59611_1_1_11341"
  def noCheckRequiredId            = s"${formId}_datafield_59611_1_1_15464"
  def dbsProviderId                = s"${formId}_datafield_97307_1_1_15345"
  def disclosureScotlandProviderId = s"${formId}_datafield_97307_1_1_15346"
  def accessNIProviderId           = s"${formId}_datafield_97307_1_1_15346"
  def vettingRequiredId            = s"${formId}_field_value_93637_1"
  def counterTerroristCheckId      = s"${formId}_datafield_93637_1_1_15342"
  def securityCheckId              = s"${formId}_datafield_93637_1_1_15343"
  def developedVettingId           = s"${formId}_datafield_93637_1_1_15344"
  def noVettingRequiredId          = s"${formId}_datafield_93637_1_1_15341"
  def medicalRequiredYesId         = s"${formId}_datafield_59608_1_1_1"
  def medicalRequiredNoId          = s"${formId}_datafield_59608_1_1_2"

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

  def checkVettingSection(newVacancyDetails: NewVacancyDetails): Unit =
    checkAndVetting.foreach { f =>
      f(newVacancyDetails.vettingDetails)
    }

}
