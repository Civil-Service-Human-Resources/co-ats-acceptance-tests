package uk.gov.co.test.ui.pages.v9

import uk.gov.co.test.ui.data.MasterVacancyDetails.{v9BiometricPassportOrId, v9EussStatus, v9IdvtDataConsent, v9InDateDrivingLicence, v9RtwBritishCitizen, v9RtwHoldPassport, v9SmartphoneAccess}

object ApplicationDetailsPage extends CivilServiceJobsBasePage {

  private def rtw(): Unit = {
    v9RtwBritishCitizen = true
    v9RtwHoldPassport = true
    v9EussStatus = ""

  }

  private def idvt(): Unit = {
    v9IdvtDataConsent = true
    v9SmartphoneAccess = true
    v9BiometricPassportOrId = true
    v9InDateDrivingLicence = true
  }

  def resetApplicationDetails(): Unit = {
    rtw()
    idvt()
  }
}
