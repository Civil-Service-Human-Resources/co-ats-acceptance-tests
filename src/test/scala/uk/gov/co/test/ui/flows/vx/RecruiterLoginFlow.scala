package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.conf.TestConfiguration
import uk.gov.co.test.ui.data.MasterVacancyDetails.vXProfile
import uk.gov.co.test.ui.data.vx.recruiters.RecruiterDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

object RecruiterLoginFlow extends VacancyBasePage {

  private val login: Seq[RecruiterDetails => Unit] = Seq(
    enterUsername,
    enterPassword
  )

  def loginWithRecruiterDetails(recruiterDetails: RecruiterDetails): Unit = {
    navigateToVxConfigLogin()
    if (currentUrl.startsWith(TestConfiguration.urlHost("vxconfig")) && !findUsernameField.isEmpty) {
      login.foreach { f =>
        f(recruiterDetails)
      }
    } else if (currentUrl.startsWith(TestConfiguration.urlHost("vxconfig")) && findUsernameField.isEmpty) {
      enterPassword(recruiterDetails)
    }
    vxLogin()
    vXProfile = waitForVisibilityOfElementByPath(
      ".//p[@class='ng-tns-c777076404-0 ng-trigger ng-trigger-basicFade ng-star-inserted']"
    ).getText
  }
}
