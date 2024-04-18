package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXHavePecMailbox, vXPecMailbox, vXUseOnlinePecForms, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class OnlinePecCheckFormsDetails(
  useOnlinePecCheckForms: Boolean,
  haveTeamMailbox: Boolean,
  pecCheckFormsTeamEmail: String
)

object OnlinePecCheckFormsSection extends VacancyBasePage {

  def onlinePecCheckFormsSectionId = s"${vacancyFormId}_section_154278_col_0"
  def useOnlinePecCheckFormsId     = s"select2-${vacancyFormId}_datafield_154299_1_1-container"
  def haveTeamMailboxId            = s"select2-${vacancyFormId}_datafield_154310_1_1-container"
  def pecFormsTeamEmailInputId     = s"${vacancyFormId}_datafield_154303_1_1"

  private def enterOnlinePecFormsCheckFlow(onlinePecCheckFormsDetails: OnlinePecCheckFormsDetails): Unit = {
    scrollToElement(By.id(onlinePecCheckFormsSectionId))
    waitForVisibilityOfElementById(useOnlinePecCheckFormsId).click()
    vXUseOnlinePecForms = onlinePecCheckFormsDetails.useOnlinePecCheckForms
    if (vXUseOnlinePecForms) {
      selectActionLocator("Yes")
      waitForVisibilityOfElementById(haveTeamMailboxId).click()
      vXHavePecMailbox = onlinePecCheckFormsDetails.haveTeamMailbox
      if (vXHavePecMailbox) {
        selectActionLocator("Yes")
        enterOnlinePecCheckFormsTeamEmail(onlinePecCheckFormsDetails)
      } else selectActionLocator("No")
    } else selectActionLocator("No")
  }

  private def enterOnlinePecCheckFormsTeamEmail(pecCheckFormsDetails: OnlinePecCheckFormsDetails): Unit = {
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
    vXPecMailbox = pecCheckFormsDetails.pecCheckFormsTeamEmail
    pecTeamEmailField.sendKeys(vXPecMailbox)
  }

  private val onlinePecCheckForms: Seq[OnlinePecCheckFormsDetails => Unit] = Seq(
    enterOnlinePecFormsCheckFlow
  )

  def onlinePecCheckFormsSection(newVacancyDetails: NewVacancyDetails): Unit =
    onlinePecCheckForms.foreach { f =>
      f(newVacancyDetails.onlinePecCheckFormsDetails)
    }

}
