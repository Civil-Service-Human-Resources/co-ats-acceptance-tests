package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class PecCheckFormsDetails(
  usePecCheckForms: Boolean,
  haveTeamMailbox: Boolean,
  pecCheckFormsTeamEmail: String
)

object PecCheckFormsSection extends VacancyBasePage {

  private lazy val pecCheckFormsSectionId   = s"${formId}_section_154278_col_0"
  private lazy val usePecCheckFormsId       = s"select2-${formId}_datafield_154299_1_1-container"
  private lazy val haveTeamMailboxId        = s"select2-${formId}_datafield_154310_1_1-container"
  private lazy val pecFormsTeamEmailInputId = s"${formId}_datafield_154303_1_1"

  private def enterPecFormsCheckFlow(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    scrollToElement(By.id(pecCheckFormsSectionId))
    waitForVisibilityOfElementById(usePecCheckFormsId).click()
    if (pecCheckFormsDetails.usePecCheckForms) {
      selectActionLocator("Yes")
      waitForVisibilityOfElementById(haveTeamMailboxId).click()
      if (pecCheckFormsDetails.haveTeamMailbox) {
        selectActionLocator("Yes")
        enterPecCheckFormsTeamEmail(pecCheckFormsDetails)
      } else selectActionLocator("No")
    } else selectActionLocator("No")
  }

  private def enterPecCheckFormsTeamEmail(pecCheckFormsDetails: PecCheckFormsDetails): Unit = {
    val pecTeamEmailField = waitForVisibilityOfElementById(pecFormsTeamEmailInputId)
    val pecTeamEmailValue = pecTeamEmailField.getAttribute("value")
    if (pecTeamEmailValue.nonEmpty) {
      if (!getOs.contains("mac")) {
        pecTeamEmailField.sendKeys(Keys.CONTROL, "a")
      } else {
        pecTeamEmailField.sendKeys(Keys.COMMAND, "a")
      }
      pecTeamEmailField.sendKeys(Keys.BACK_SPACE)
    }
    pecTeamEmailField.sendKeys(pecCheckFormsDetails.pecCheckFormsTeamEmail)
  }

  private val pecCheckForms: Seq[PecCheckFormsDetails => Unit] = Seq(
    enterPecFormsCheckFlow
  )

  def pecCheckFormsSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    pecCheckForms.foreach { f =>
      f(newVacancyDetails.pecCheckFormsDetails)
    }

}
