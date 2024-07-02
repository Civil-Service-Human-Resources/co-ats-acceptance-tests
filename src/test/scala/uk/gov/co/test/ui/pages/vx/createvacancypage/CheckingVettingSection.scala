package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCrcCheckProvider, vXCrcLevel, vXMedicalRequired, vXNonReserved, vXProfile, vXVettingLevel, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class VettingDetails(
  reservedStatus: Boolean,
  checkLevelRequired: String,
  whichProvider: String,
  workingWithAdults: Boolean,
  workingWithChildren: Boolean,
  workingWithAdultsOrChildren: Boolean,
  willApplicantBeVolunteer: Boolean,
  vettingLevelRequired: String,
  medicalRequired: Boolean
)

object CheckingVettingSection extends VacancyBasePage {

  def reservedStatusId                  = s"${vacancyFormId}_datafield_59601_1_1_fieldset"
  def reservedYesId                     = s"${vacancyFormId}_datafield_59601_1_1_868"
  def reservedNoId                      = s"${vacancyFormId}_datafield_59601_1_1_869"
  def basicCheckId                      = s"${vacancyFormId}_datafield_59611_1_1_12650"
  def standardCheckId                   = s"${vacancyFormId}_datafield_59611_1_1_11340"
  def enhancedCheckId                   = s"${vacancyFormId}_datafield_59611_1_1_11341"
  def noCheckRequiredId                 = s"${vacancyFormId}_datafield_59611_1_1_15464"
  def dbsProviderId                     = s"${vacancyFormId}_datafield_97307_1_1_15345"
  def disclosureScotlandProviderId      = s"${vacancyFormId}_datafield_97307_1_1_15346"
  def accessNIProviderId                = s"${vacancyFormId}_datafield_97307_1_1_15346"
  def vettingRequiredId                 = s"${vacancyFormId}_field_value_93637_1"
  def counterTerroristCheckId           = s"${vacancyFormId}_datafield_93637_1_1_15342"
  def securityCheckId                   = s"${vacancyFormId}_datafield_93637_1_1_15343"
  def developedVettingId                = s"${vacancyFormId}_datafield_93637_1_1_15344"
  def noVettingRequiredId               = s"${vacancyFormId}_datafield_93637_1_1_15341"
  def medicalRequiredYesId              = s"${vacancyFormId}_datafield_59608_1_1_1"
  def medicalRequiredNoId               = s"${vacancyFormId}_datafield_59608_1_1_2"
  def workingWithAdultsTextId           = s"${vacancyFormId}_field_que_185590_1"
  def workingWithAdultsYesId            = s"${vacancyFormId}_datafield_185590_1_1_1"
  def workingWithAdultsNoId             = s"${vacancyFormId}_datafield_185590_1_1_2"
  def workingWithChildrenTextId         = s"${vacancyFormId}_field_que_185593_1"
  def workingWithChildrenYesId          = s"${vacancyFormId}_datafield_185593_1_1_1"
  def workingWithChildrenNoId           = s"${vacancyFormId}_datafield_185593_1_1_2"
  def workingWithAdultsOrChildrenTextId = s"${vacancyFormId}_field_que_185596_1"
  def workingWithAdultsOrChildrenYesId  = s"${vacancyFormId}_datafield_185596_1_1_1"
  def workingWithAdultsOrChildrenNoId   = s"${vacancyFormId}_datafield_185596_1_1_2"
  def willApplicantBeVolunteerTextId    = s"${vacancyFormId}_field_que_185587_1"
  def willApplicantBeVolunteerYesId     = s"${vacancyFormId}_datafield_185587_1_1_1"
  def willApplicantBeVolunteerNoId      = s"${vacancyFormId}_datafield_185587_1_1_2"

  private def selectReservedStatus(vettingDetails: VettingDetails): Unit = {
    scrollToElement(By.id(reservedStatusId))
    vXNonReserved = vettingDetails.reservedStatus
    if (vXNonReserved) clickOnRadioButton(reservedYesId) else clickOnRadioButton(reservedNoId)
  }

  private def selectCheckLevelRequired(vettingDetails: VettingDetails): Unit = {
    vXCrcLevel = vettingDetails.checkLevelRequired
    vXCrcLevel match {
      case "Basic"    => clickOnRadioButton(basicCheckId)
      case "Standard" => clickOnRadioButton(standardCheckId)
      case "Enhanced" => clickOnRadioButton(enhancedCheckId)
      case "None"     => clickOnRadioButton(noCheckRequiredId)
    }
  }

  private def checkWhichProvider(vettingDetails: VettingDetails): Unit = {
    vXCrcCheckProvider = vettingDetails.whichProvider
    if (vXProfile != "Vacancy Holder 1") {
      vXCrcCheckProvider match {
        case "Disclosure barring service (DBS)" => checkbox(dbsProviderId).select()
        case "Disclosure Scotland"              => checkbox(disclosureScotlandProviderId).select()
        case "Access NI"                        => checkbox(accessNIProviderId).select()
      }
    }
  }

  private def selectDbsEnhancedChecksOnly(vettingDetails: VettingDetails): Unit =
    if (vXCrcLevel == "Enhanced" && vXCrcCheckProvider.contains("DBS")) {
      selectWorkingWithAdults(vettingDetails)
      selectWorkingWithChildren(vettingDetails)
      selectWorkingWithAdultsOrChildren(vettingDetails)
      selectWillApplicantBeVolunteer(vettingDetails)
    }

  private def selectWorkingWithAdults(vettingDetails: VettingDetails): Unit = {
    val workingWithAdultsQuestion = driver.findElement(By.id(workingWithAdultsTextId))
    if (workingWithAdultsQuestion.isDisplayed) {
      if (vettingDetails.workingWithAdults) clickOnRadioButton(workingWithAdultsYesId)
      else clickOnRadioButton(workingWithAdultsNoId)
    }
  }

  private def selectWorkingWithChildren(vettingDetails: VettingDetails): Unit = {
    val workingWithChildrenQuestion = driver.findElement(By.id(workingWithChildrenTextId))
    if (workingWithChildrenQuestion.isDisplayed) {
      if (vettingDetails.workingWithChildren) clickOnRadioButton(workingWithChildrenYesId)
      else clickOnRadioButton(workingWithChildrenNoId)
    }
  }

  private def selectWorkingWithAdultsOrChildren(vettingDetails: VettingDetails): Unit = {
    val workingWithAdultsOrChildrenQuestion = driver.findElement(By.id(workingWithAdultsOrChildrenTextId))
    if (workingWithAdultsOrChildrenQuestion.isDisplayed) {
      if (vettingDetails.workingWithAdultsOrChildren) clickOnRadioButton(workingWithAdultsOrChildrenYesId)
      else clickOnRadioButton(workingWithAdultsOrChildrenNoId)
    }
  }

  private def selectWillApplicantBeVolunteer(vettingDetails: VettingDetails): Unit = {
    val willApplicantBeVolunteerQuestion = driver.findElement(By.id(willApplicantBeVolunteerTextId))
    if (willApplicantBeVolunteerQuestion.isDisplayed) {
      if (vettingDetails.willApplicantBeVolunteer) clickOnRadioButton(willApplicantBeVolunteerYesId)
      else clickOnRadioButton(willApplicantBeVolunteerNoId)
    }
  }

  private def selectVettingLevelRequired(vettingDetails: VettingDetails): Unit = {
    scrollToElement(By.id(vettingRequiredId))
    vXVettingLevel = vettingDetails.vettingLevelRequired
    vXVettingLevel match {
      case "Counter terrorist check" => clickOnRadioButton(counterTerroristCheckId)
      case "Security check"          => clickOnRadioButton(securityCheckId)
      case "Developed vetting"       => clickOnRadioButton(developedVettingId)
      case "None"                    => clickOnRadioButton(noVettingRequiredId)
    }
  }

  private def selectMedicalRequired(vettingDetails: VettingDetails): Unit = {
    vXMedicalRequired = vettingDetails.medicalRequired
    if (vXMedicalRequired) clickOnRadioButton(medicalRequiredYesId)
    else clickOnRadioButton(medicalRequiredNoId)
  }

  private val checkAndVetting: Seq[VettingDetails => Unit] = Seq(
    selectReservedStatus,
    selectCheckLevelRequired,
    checkWhichProvider,
    selectDbsEnhancedChecksOnly,
    selectVettingLevelRequired,
    selectMedicalRequired
  )

  def checkVettingSection(newVacancyDetails: NewVacancyDetails): Unit =
    checkAndVetting.foreach { f =>
      f(newVacancyDetails.vettingDetails)
    }

}
