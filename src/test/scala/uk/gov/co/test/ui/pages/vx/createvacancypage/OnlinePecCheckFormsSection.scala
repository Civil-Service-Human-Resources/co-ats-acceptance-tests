package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

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
    if (onlinePecCheckFormsDetails.useOnlinePecCheckForms) {
      selectActionLocator("Yes")
      waitForVisibilityOfElementById(haveTeamMailboxId).click()
      if (onlinePecCheckFormsDetails.haveTeamMailbox) {
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
    pecTeamEmailField.sendKeys(pecCheckFormsDetails.pecCheckFormsTeamEmail)
  }

  private val onlinePecCheckForms: Seq[OnlinePecCheckFormsDetails => Unit] = Seq(
    enterOnlinePecFormsCheckFlow
  )

  def onlinePecCheckFormsSection(newVacancyDetails: NewVacancyDetails): Unit =
    onlinePecCheckForms.foreach { f =>
      f(newVacancyDetails.onlinePecCheckFormsDetails)
    }

}
