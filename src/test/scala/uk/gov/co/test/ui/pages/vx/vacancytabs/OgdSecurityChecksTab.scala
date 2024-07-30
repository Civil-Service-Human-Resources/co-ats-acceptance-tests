package uk.gov.co.test.ui.pages.vx.vacancytabs

import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXCrcCheckProvider, vXCrcLevel, vXPecCrc, vXPecNsv, vXPecOgdSecurityCheck, vXTypeOfCandidate, vXVettingLevel, vacancyFormId}
import uk.gov.co.test.ui.data.vx.application.ApplicationDetails
import uk.gov.co.test.ui.pages.vx.ApplicationSummaryPage.{completeSecurityChecksFormBarId, launchFullPecAfterSecurityChecksBarId}
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class OgdSecurityChecksDetails(
  dbsCheck: Boolean,
  securityChecks: Boolean
)

object OgdSecurityChecksTab extends VacancyBasePage {

  private lazy val ogdSecurityChecksTabPath = ".//span[@class='main-label' and text() = 'OGD Security Checks']"
  def ogdSecurityChecksHeaderId             = s"${vacancyFormId}_label_124792_1"
  def ogdSecurityChecksInfoId               = s"${vacancyFormId}_section_124929_col_0"
  def dbsCheckConfirmYesId                  = s"${vacancyFormId}_datafield_127186_1_1_1"
  def dbsCheckConfirmNoId                   = s"${vacancyFormId}_datafield_127186_1_1_2"
  def securityChecksYesId                   = s"${vacancyFormId}_datafield_127190_1_1_1"
  def securityChecksNoId                    = s"${vacancyFormId}_datafield_127190_1_1_2"

  def enterOgdSecurityChecksForm(ogdSecurityChecksDetails: OgdSecurityChecksDetails): Unit = {
    println(s"1. vXTypeOfCandidate $vXTypeOfCandidate")
    println(s"2. vXPecNsv $vXPecNsv")
    println(s"3. vXPecCrc $vXPecCrc")
    println(s"4. vXCrcLevel $vXCrcLevel")
    println(s"5. vXCrcCheckProvider $vXCrcCheckProvider")
    println(s"6. vXPecOgdSecurityCheck $vXPecOgdSecurityCheck")

    checkVacancyStatus("Security checks required")
    moveVacancyOnViaTopBar(completeSecurityChecksFormBarId, ogdSecurityChecksTabPath)
    waitForVisibilityOfElementById(ogdSecurityChecksHeaderId).getText shouldEqual "OGD Security Checks"
    if (
      (vXPecCrc
        .contains(s"$vXTypeOfCandidate Candidates") && vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) &&
      (!vXPecNsv.contains(s"$vXTypeOfCandidate Candidates") || vXVettingLevel == "None")
    ) {
      waitForVisibilityOfElementById(
        ogdSecurityChecksInfoId
      ).getText shouldEqual s"This vacancy states OGD candidates should undertake the following checks:\n$vXCrcLevel - $vXCrcCheckProvider"
      selectDbsChecks(ogdSecurityChecksDetails)
    } else if (
      (vXPecCrc
        .contains(s"$vXTypeOfCandidate Candidates") && vXCrcLevel != "None" && vXCrcCheckProvider.contains("DBS")) &&
      (vXPecNsv.contains(s"$vXTypeOfCandidate Candidates") && vXVettingLevel != "None")
    ) {
      waitForVisibilityOfElementById(
        ogdSecurityChecksInfoId
      ).getText shouldEqual s"This vacancy states OGD candidates should undertake the following checks:\n$vXCrcLevel - $vXCrcCheckProvider\n$vXVettingLevel"
      selectDbsChecks(ogdSecurityChecksDetails)
      selectVettingChecks(ogdSecurityChecksDetails)
    } else if (
      (!vXPecCrc.contains(s"$vXTypeOfCandidate Candidates") || vXCrcLevel == "None") &&
      (vXPecNsv.contains(s"$vXTypeOfCandidate Candidates") && vXVettingLevel != "None")
    ) {
      waitForVisibilityOfElementById(
        ogdSecurityChecksInfoId
      ).getText shouldEqual s"This vacancy states OGD candidates should undertake the following checks:\n$vXVettingLevel"
      selectVettingChecks(ogdSecurityChecksDetails)
    }
  }

  private def selectDbsChecks(ogdSecurityChecksDetails: OgdSecurityChecksDetails): Unit =
    if (ogdSecurityChecksDetails.dbsCheck) clickOnRadioButton(dbsCheckConfirmYesId)
    else clickOnRadioButton(dbsCheckConfirmNoId)

  private def selectVettingChecks(ogdSecurityChecksDetails: OgdSecurityChecksDetails): Unit =
    if (ogdSecurityChecksDetails.securityChecks) clickOnRadioButton(securityChecksYesId)
    else clickOnRadioButton(securityChecksNoId)

  private val securityChecks: Seq[OgdSecurityChecksDetails => Unit] = Seq(
    enterOgdSecurityChecksForm
  )

  def ogdSecurityChecksFlow(applicationDetails: ApplicationDetails): Unit = {
    securityChecks.foreach { f =>
      f(applicationDetails.ogdSecurityChecksDetails)
    }
    clickOn(submitForm)
    if (waitForVisibilityOfElementById(launchFullPecAfterSecurityChecksBarId).isDisplayed)
      println("OGD security checks complete!")
  }
}
