package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{vXGiveLocationPreference, vXMaxLocations, vXOtherLocations}

case class PreferencesDetails(
  firstChoiceLocation: String,
  secondChoiceLocation: Option[String] = None,
  thirdChoiceLocation: Option[String] = None,
  furtherLocationPreferences: Option[String] = None
)

object PreferencesPage extends CivilServiceJobsBasePage {

  private lazy val preferencesPageTitle       = "Preferences - Civil Service Jobs - GOV.UK"
  private lazy val errorSameLocationsSelected = "You cannot select the same location more than once"
  def vXMaxLocationsAllowed: Int              = vXMaxLocations.toInt
  def firstLocationId                         = s"${formId}_datafield_53467_1_1"
  def secondLocationId                        = s"${formId}_datafield_53470_1_1"
  def thirdLocationId                         = s"${formId}_datafield_53473_1_1"
  def furtherPreferredLocationsId             = s"${formId}_datafield_35884_1_1"
  def availableFirstLocationsPath             = s".//select[@id='$firstLocationId']/option[@title]"
  def availableSecondLocationsPath            = s".//select[@id='$secondLocationId']/option[@title]"
  def availableThirdLocationsPath             = s".//select[@id='$thirdLocationId']/option[@title]"
  def errorSelectingLocationId                = s"${formId}_label_74449_1"

  private def preferencesPageCheck(): Unit =
    eventually(onPage(preferencesPageTitle))

  private def confirmAvailableLocations(locationsPath: String): Unit = {
    val v9LocationOptions = driver.findElements(By.xpath(locationsPath)).size()
    if (v9LocationOptions >= vXMaxLocationsAllowed) {
      v9LocationOptions shouldEqual vXOtherLocations.length
    } else
      throw new IllegalStateException(
        s"$v9LocationOptions locations available on the list when $vXMaxLocationsAllowed is minimum stated on the master vacancy!"
      )
  }

  private def selectFirstPreferredLocation(preferencesDetails: PreferencesDetails): Unit = {
    confirmAvailableLocations(availableFirstLocationsPath)
    selectDropdownOption(firstLocationId, preferencesDetails.firstChoiceLocation)
  }

  private def selectSecondPreferredLocation(preferencesDetails: PreferencesDetails): Unit = {
    confirmAvailableLocations(availableSecondLocationsPath)
    selectDropdownOption(secondLocationId, preferencesDetails.secondChoiceLocation.get)
  }

  private def selectThirdPreferredLocation(preferencesDetails: PreferencesDetails): Unit = {
    confirmAvailableLocations(availableThirdLocationsPath)
    selectDropdownOption(thirdLocationId, preferencesDetails.thirdChoiceLocation.get)
  }

  private def errorTestingSameLocationsSelected(preferencesDetails: PreferencesDetails): Unit = {
    selectDropdownOption(firstLocationId, preferencesDetails.firstChoiceLocation)
    selectDropdownOption(secondLocationId, preferencesDetails.firstChoiceLocation)
    waitForVisibilityOfElementById(errorSelectingLocationId).getText shouldEqual errorSameLocationsSelected
  }

  private def enterOtherPreferredLocations(preferencesDetails: PreferencesDetails): Unit =
    enterDetails(furtherPreferredLocationsId, preferencesDetails.furtherLocationPreferences.get)

  private val preferences: Seq[PreferencesDetails => Unit] = Seq(
    selectFirstPreferredLocation,
    selectSecondPreferredLocation,
    selectThirdPreferredLocation
  )

  def preferencesPage(longFormDetails: LongFormDetails): Unit =
    if (vXGiveLocationPreference) {
      preferencesPageCheck()
      preferences.take(vXMaxLocationsAllowed).foreach { f =>
        f(longFormDetails.preferencesDetails)
      }
      enterOtherPreferredLocations(longFormDetails.preferencesDetails)
      clickOn(pageContinue)
    }
}
