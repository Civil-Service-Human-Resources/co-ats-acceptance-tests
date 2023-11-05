package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, WebElement}
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

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
  otherCityOrTown: String
)

object LocationsSection extends VacancyBasePage {

  private lazy val generalInput            = "//input[@class='select2-search__field']"
  private lazy val cityOrTownInput         = s".//*[@aria-describedby='select2-${formId}_datafield_155622_1_1-container']"
  private lazy val otherCityOrTownInput    = s".//*[@aria-describedby='select2-${formId}_datafield_155836_1_1-container']"
  private lazy val locationTypeId          = s"select2-${formId}_datafield_155639_1_1-container"
  private lazy val overseasId              = s"select2-${formId}_datafield_155904_1_1-container"
  private lazy val regionInput             = s".//*[@aria-describedby='select2-${formId}_datafield_155584_1_1-container']"
  private lazy val postcodeId              = s"${formId}_datafield_155601_1_1"
  private lazy val northernIrelandId       = s"${formId}_datafield_155854_1_1_fieldset"
  private lazy val northernIrelandYesId    = s"${formId}_datafield_155854_1_1_1"
  private lazy val northernIrelandNoId     = s"${formId}_datafield_155854_1_1_2"
  private lazy val outsideNIRYesId         = s"${formId}_datafield_155922_1_1_1"
  private lazy val outsideNIRNoId          = s"${formId}_datafield_155922_1_1_1"
  private lazy val protestantId            = s"${formId}_datafield_155869_1_1_15462"
  private lazy val romanCatholicId         = s"${formId}_datafield_155869_1_1_15463"
  private lazy val allCommunitiesId        = s"${formId}_datafield_155869_1_1_17360"
  private lazy val locationOverrideInput   = s"${formId}_datafield_155654_1_1_en-GB"
  private lazy val locationPreferenceNoId  = s"${formId}_datafield_155799_1_1_2"
  private lazy val locationPreferenceYesId = s"${formId}_datafield_155799_1_1_1"
  private lazy val maxLocationId           = s"select2-${formId}_datafield_155818_1_1-container"

  def selectVacancyInNIR(locationsDetails: LocationsDetails): Unit = {
    scrollToElement(By.id(northernIrelandId))
    if (locationsDetails.vacancyInNIR) {
      clickOnRadioButton(northernIrelandYesId)
      selectVacancyOutsideNIR(locationsDetails)
      selectWhichCommunity(locationsDetails)
    } else {
      clickOnRadioButton(northernIrelandNoId)
    }
  }

  def selectVacancyOutsideNIR(locationsDetails: LocationsDetails): Unit =
    if (locationsDetails.openOutsideNIR) {
      clickOnRadioButton(outsideNIRYesId)
    } else {
      clickOnRadioButton(outsideNIRNoId)
    }

  def selectWhichCommunity(locationsDetails: LocationsDetails): Unit =
    locationsDetails.whichCommunityEncouraged match {
      case "Protestant"      => clickOnRadioButton(protestantId)
      case "Roman Catholic"  => clickOnRadioButton(romanCatholicId)
      case "All communities" => clickOnRadioButton(allCommunitiesId)
    }

  def waitForDropdownOption(option: String): WebElement =
    waitForVisibilityOfElementByPath(s".//li[@title='$option']")

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

    selectOption.sendKeys("Southampton")
    action().moveToElement(waitForCityOrTownOption("Southampton")).perform()
    waitForCityOrTownOption("Southampton").click()
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

  def selectLocationPreference(locationsDetails: LocationsDetails): Unit =
    if (locationsDetails.giveLocationPreference) {
      clickOnRadioButton(locationPreferenceYesId)
      chooseMaxLocations(locationsDetails.maxLocations)
      selectOtherCityOrTown(locationsDetails.otherCityOrTown)
    } else {
      clickOnRadioButton(locationPreferenceNoId)
    }

  def selectLocationType(locationsDetails: LocationsDetails): Unit = {
    scrollToElement(By.id(locationTypeId))
    locationType(locationsDetails.locationType)
    locationsDetails.locationType match {
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

  def locationsSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    locations.foreach { f =>
      f(newVacancyDetails.locationsDetails)
    }
}
