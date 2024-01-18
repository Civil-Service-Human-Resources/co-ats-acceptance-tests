package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXAvailableOutsideInNI, vXCommunitiesInNIR, vXGiveLocationPreference, vXLocationType, vXMaxLocations, vXOtherLocations, vXVacanciesInNIR, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

case class LocationsDetails(
  locationType: String,
  postcodes: String,
  cityOrTown: String,
  region: String,
  overseas: String,
  locationOverride: String,
  vacancyInNIR: Boolean,
  openOutsideNIR: Boolean,
  whichCommunityEncouraged: String,
  giveLocationPreference: Boolean,
  maxLocations: String,
  otherLocations: ListBuffer[String]
)

object LocationsSection extends VacancyBasePage {

  def cityOrTownInput         = s".//*[@aria-describedby='select2-${vacancyFormId}_datafield_155622_1_1-container']"
  def otherCityOrTownInput    =
    s".//textarea[@aria-describedby='select2-${vacancyFormId}_datafield_155836_1_1-container']"
  def locationTypeId          = s"select2-${vacancyFormId}_datafield_155639_1_1-container"
  def overseasId              = s"select2-${vacancyFormId}_datafield_155904_1_1-container"
  def regionInput             = s".//*[@aria-describedby='select2-${vacancyFormId}_datafield_155584_1_1-container']"
  def postcodeId              = s"${vacancyFormId}_datafield_155601_1_1"
  def northernIrelandId       = s"${vacancyFormId}_datafield_155854_1_1_fieldset"
  def northernIrelandYesId    = s"${vacancyFormId}_datafield_155854_1_1_1"
  def northernIrelandNoId     = s"${vacancyFormId}_datafield_155854_1_1_2"
  def outsideNIRYesId         = s"${vacancyFormId}_datafield_155922_1_1_1"
  def outsideNIRNoId          = s"${vacancyFormId}_datafield_155922_1_1_1"
  def protestantId            = s"${vacancyFormId}_datafield_155869_1_1_15462"
  def romanCatholicId         = s"${vacancyFormId}_datafield_155869_1_1_15463"
  def allCommunitiesId        = s"${vacancyFormId}_datafield_155869_1_1_17360"
  def locationOverrideInput   = s"${vacancyFormId}_datafield_155654_1_1_en-GB"
  def locationPreferenceNoId  = s"${vacancyFormId}_datafield_155799_1_1_2"
  def locationPreferenceYesId = s"${vacancyFormId}_datafield_155799_1_1_1"
  def maxLocationId           = s"select2-${vacancyFormId}_datafield_155818_1_1-container"

  def selectVacancyInNIR(locationsDetails: LocationsDetails): Unit = {
    scrollToElement(By.id(northernIrelandId))
    vXVacanciesInNIR = locationsDetails.vacancyInNIR
    if (vXVacanciesInNIR) {
      clickOnRadioButton(northernIrelandYesId)
      selectVacancyOutsideNIR(locationsDetails)
      selectWhichCommunity(locationsDetails)
    } else {
      clickOnRadioButton(northernIrelandNoId)
    }
  }

  def selectVacancyOutsideNIR(locationsDetails: LocationsDetails): Unit = {
    vXAvailableOutsideInNI = locationsDetails.openOutsideNIR
    if (vXAvailableOutsideInNI) {
      clickOnRadioButton(outsideNIRYesId)
    } else {
      clickOnRadioButton(outsideNIRNoId)
    }
  }

  def selectWhichCommunity(locationsDetails: LocationsDetails): Unit = {
    vXCommunitiesInNIR = locationsDetails.whichCommunityEncouraged
    vXCommunitiesInNIR match {
      case "Protestant"      => clickOnRadioButton(protestantId)
      case "Roman Catholic"  => clickOnRadioButton(romanCatholicId)
      case "All communities" => clickOnRadioButton(allCommunitiesId)
    }
  }

  def locationType(locationType: String): Unit = {
    waitForVisibilityOfElementById(locationTypeId).click()
    action().moveToElement(waitForDropdownOption(locationType)).perform()
    waitForDropdownOption(locationType).click()
  }

  def enterPostcodes(postcodes: String): Unit = {
    val field = waitForVisibilityOfElementById(postcodeId)
    field.sendKeys(postcodes)
  }

  def chooseMaxLocations(maxLocation: String): Unit = {
    waitForVisibilityOfElementById(maxLocationId).click()
    action().moveToElement(waitForDropdownOption(maxLocation)).perform()
    waitForDropdownOption(maxLocation).click()
  }

  def waitForCityOrTownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[text()='$option ']")

  def selectCityOrTown(cityTown: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(cityOrTownInput)
    selectOption.sendKeys(cityTown)
    action().moveToElement(waitForCityOrTownOption(cityTown)).perform()
    waitForCityOrTownOption(cityTown).click()
  }

  def selectOtherCityOrTown(otherCityTown: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(otherCityOrTownInput)
    selectOption.sendKeys(otherCityTown)
    action().moveToElement(waitForCityOrTownOption(otherCityTown)).perform()
    waitForCityOrTownOption(otherCityTown).click()
  }

  def selectRegion(region: String): Unit = {
    val selectOption = waitForVisibilityOfElementByPath(regionInput)
    selectOption.sendKeys(region)
    action().moveToElement(waitForDropdownOption(region)).perform()
    waitForDropdownOption(region).click()
  }

  def selectOverseas(country: String): Unit = {
    waitForVisibilityOfElementById(overseasId).click()
    selectOption(generalInput, country)
  }

  def locationOverride(overrideLocations: String): Unit =
    textField(locationOverrideInput).value = overrideLocations

  def selectLocationPreference(locationsDetails: LocationsDetails): Unit = {
    vXGiveLocationPreference = locationsDetails.giveLocationPreference
    vXMaxLocations = locationsDetails.maxLocations
    vXOtherLocations = locationsDetails.otherLocations
    if (vXGiveLocationPreference) {
      clickOnRadioButton(locationPreferenceYesId)
      chooseMaxLocations(vXMaxLocations)
      for (cityOrTown <- vXOtherLocations)
        selectOtherCityOrTown(cityOrTown)
    } else {
      clickOnRadioButton(locationPreferenceNoId)
    }
  }

  def selectLocationType(locationsDetails: LocationsDetails): Unit = {
    scrollToElement(By.id(locationTypeId))
    vXLocationType = locationsDetails.locationType
    locationType(vXLocationType)
    vXLocationType match {
      case "Postcodes" => enterPostcodes(locationsDetails.postcodes)
      case "Towns"     => selectCityOrTown(locationsDetails.cityOrTown)
      case "Regions"   => selectRegion(locationsDetails.region)
      case "Overseas"  => selectOverseas(locationsDetails.overseas)
    }
    locationOverride(locationsDetails.locationOverride)
  }

  private val locations: Seq[LocationsDetails => Unit] = Seq(
    selectLocationType,
    selectVacancyInNIR,
    selectLocationPreference
  )

  def locationsSection(newVacancyDetails: NewVacancyDetails): Unit =
    locations.foreach { f =>
      f(newVacancyDetails.locationsDetails)
    }
}
