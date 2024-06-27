package uk.gov.co.test.ui.pages.vx.vacancytabs

import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCrcCheckProvider, vXCrcLevel, vacancyFormId}
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{completeSecurityChecksFormBarId, firstDayArrangementsAfterNenBarId, inviteCandidateToCompletePecForm, launchFullPecAfterSecurityChecksBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.vacancytabs.NewEntrantNoticeTab.waitForVisibilityOfElementById

case class OgdSecurityChecksDetails(
  basicDbsCheck: Boolean,
  securityChecks: Boolean
)

object OgdSecurityChecksTab extends VacancyBasePage {

  private lazy val ogdSecurityChecksTabPath = ".//span[@class='main-label' and text() = 'OGD Security Checks']"
  def ogdSecurityChecksHeaderId             = s"${vacancyFormId}_label_124792_1"
  def ogdSecurityChecksInfoId               = s"${vacancyFormId}_section_124929_col_0"
  def basicDbsCheckConfirmYesId             = s"${vacancyFormId}_datafield_127186_1_1_1"
  def basicDbsCheckConfirmNoId              = s"${vacancyFormId}_datafield_127186_1_1_2"
  def securityChecksYesId                   = s"${vacancyFormId}_datafield_127190_1_1_1"
  def securityChecksNoId                    = s"${vacancyFormId}_datafield_127190_1_1_2"

  def enterOgdSecurityChecksForm(): Unit = {
    checkVacancyStatus("Security checks required")
    moveVacancyOnViaTopBar(completeSecurityChecksFormBarId, ogdSecurityChecksTabPath)
    waitForVisibilityOfElementById(ogdSecurityChecksHeaderId).getText shouldEqual "OGD Security Checks"
    waitForVisibilityOfElementById(
      ogdSecurityChecksInfoId
    ).getText                                                         shouldEqual s"This vacancy states OGD candidates should undertake the following checks:\n$vXCrcLevel - $vXCrcCheckProvider\nSecurity check"
  }

  private def selectBasicDbsChecks(ogdSecurityChecksDetails: OgdSecurityChecksDetails): Unit =
    if (ogdSecurityChecksDetails.basicDbsCheck) clickOnRadioButton(basicDbsCheckConfirmYesId)
    else clickOnRadioButton(basicDbsCheckConfirmNoId)

  private def selectSecurityChecks(ogdSecurityChecksDetails: OgdSecurityChecksDetails): Unit =
    if (ogdSecurityChecksDetails.securityChecks) clickOnRadioButton(securityChecksYesId)
    else clickOnRadioButton(securityChecksNoId)

  private val securityChecks: Seq[OgdSecurityChecksDetails => Unit] = Seq(
    selectBasicDbsChecks,
    selectSecurityChecks
  )

  def ogdSecurityChecksFlow(applicationDetails: ApplicationDetails): Unit = {
    enterOgdSecurityChecksForm()
    securityChecks.foreach { f =>
      f(applicationDetails.ogdSecurityChecksDetails)
    }
    clickOn(submitForm)
    if (waitForVisibilityOfElementById(launchFullPecAfterSecurityChecksBarId).isDisplayed) println("OGD security checks complete!")
  }
}
