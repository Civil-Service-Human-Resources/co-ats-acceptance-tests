package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.{By, Keys}
import uk.gov.co.test.ui.data.MasterVacancyDetails.vacancyFormId
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

case class ContactDetails(
  contactName: String,
  contactEmail: String,
  contactPhone: String,
  vacancyHolderName: String,
  vacancyHolderEmail: String,
  vacancyTeamEmail: String
)

object ContactDetailsSection extends VacancyBasePage {

  def contactNameId           = s"${vacancyFormId}_field_value_59444_1"
  def contactEmailInput       = s"${vacancyFormId}_datafield_59457_1_1"
  def vacancyHolderNameId     = s"${vacancyFormId}_field_value_115926_1"
  def contactNameInput        = s"${vacancyFormId}_datafield_59444_1_1"
  def contactPhoneInput       = s"${vacancyFormId}_datafield_101571_1_1"
  def vacancyHolderNameInput  = s"${vacancyFormId}_datafield_115926_1_1"
  def vacancyHolderEmailInput = s"${vacancyFormId}_datafield_115708_1_1"
  def vacancyTeamEmailInput   = s"${vacancyFormId}_datafield_59450_1_1"

  private def enterContactName(contactDetails: ContactDetails): Unit = {
    scrollToElement(By.id(contactNameId))
    val name = textField(contactNameInput)
    name.value = contactDetails.contactName
  }

  private def enterContactEmail(contactDetails: ContactDetails): Unit = {
    val name = textField(contactEmailInput)
    name.value = contactDetails.contactEmail
  }

  private def enterContactPhone(contactDetails: ContactDetails): Unit = {
    val name = textField(contactPhoneInput)
    name.value = contactDetails.contactPhone
  }

  private def enterVacancyHolderName(contactDetails: ContactDetails): Unit = {
    scrollToElement(By.id(vacancyHolderNameId))
    val name = textField(vacancyHolderNameInput)
    name.value = contactDetails.vacancyHolderName
  }

  private def enterVacancyHolderEmail(contactDetails: ContactDetails): Unit = {
    val name = textField(vacancyHolderEmailInput)
    name.value = contactDetails.vacancyHolderEmail
  }

  private def enterVacancyTeamEmail(contactDetails: ContactDetails): Unit = {
    val teamEmailField = driver.findElement(By.id(vacancyTeamEmailInput))
    val teamEmailValue = teamEmailField.getAttribute("value")
    if (teamEmailValue.nonEmpty) {
      if (!getOs.contains("mac")) {
        teamEmailField.sendKeys(Keys.CONTROL, "a")
      } else {
        teamEmailField.sendKeys(Keys.COMMAND, "a")
      }
      teamEmailField.sendKeys(Keys.BACK_SPACE)
    }
    teamEmailField.sendKeys(contactDetails.vacancyTeamEmail)
  }

  private val contactInfo: Seq[ContactDetails => Unit] = Seq(
    enterContactName,
    enterContactEmail,
    enterContactPhone,
    enterVacancyHolderName,
    enterVacancyHolderEmail,
    enterVacancyTeamEmail
  )

  def contactDetailsSection(newVacancyDetails: NewVacancyDetails): Unit =
    contactInfo.foreach { f =>
      f(newVacancyDetails.contactDetails)
    }

}
