package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class OnlinePecCheckFormsDetails(
  useOnlinePecCheckForms: Boolean,
  haveTeamMailbox: Boolean,
  pecCheckFormsTeamEmail: String
)

object OnlinePecCheckFormsSection extends VacancyBasePage {

  private lazy val onlinePecCheckFormsSectionId = s"${formId}_section_154278_col_0"
  private lazy val useOnlinePecCheckFormsId     = s"select2-${formId}_datafield_154299_1_1-container"
  private lazy val haveTeamMailboxId            = s"select2-${formId}_datafield_154310_1_1-container"
  private lazy val pecFormsTeamEmailInputId     = s"${formId}_datafield_154303_1_1"

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
