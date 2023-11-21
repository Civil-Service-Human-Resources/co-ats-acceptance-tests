package uk.gov.co.test.ui.pages.vx

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyName

object NewVacancyPage extends VacancyBasePage {

  val saveVacancyId    = "edit_opp_form_form_create"
  val isActivePath     = "//*[@id='details_form_is_active']/span"
  val editVacancy      = "//*[@class='ajax_form_edit btn btn-default btn-sm']"
  val previewAdvert    = ".//a[@aria-label='Preview advert Details Summary']"
  val activateVacancy  = "details_form_is_active"
  val submitEditedForm = "details_form_form_submit"
  val addTranslationId = "details_form_title_button"
  val vacancyTitleId   = "details_form_title"
  val vacancyTitle     = ".//*[@class='obj_name']"
  val alertMessagePath = ".//*[@class='cn']"
  val alertMessage     = s"Vacancy Details Saved : $vacancyName"

  private def newVacancyPageTitle(): String = {
    val pageTitle = s"$vacancyName : Civil Service Jobs - GOV.UK"
    pageTitle
  }

  private def vacancyActive(): String = {
    val active = waitForVisibilityOfElementByPath(isActivePath).getAttribute("aria-label")
    active
  }

  private def setVacancyToActive(): Unit =
    if (vacancyActive() == "Set to FALSE") {
      waitForElementClickableByPath(editVacancy).click()
      if (waitForVisibilityOfElementByPath(previewAdvert).isDisplayed) {
        val editForm = waitForVisibilityOfElementById(activateVacancy)
        if (!editForm.isSelected) {
          waitForVisibilityOfElementById(addTranslationId).isDisplayed
          checkbox(activateVacancy).select()
        }
      }
      scrollToElement(By.id(submitEditedForm))
      waitForVisibilityOfElementById(submitEditedForm).click()
    }

  def confirmAndActivateVacancy(): Unit = {
    eventually(onPage(newVacancyPageTitle()))
    setVacancyToActive()
    confirmFormEdit() shouldEqual alertMessage
  }

  def confirmFormEdit(): String = {
    val alert = waitForVisibilityOfElementByPath(alertMessagePath).getText
    alert
  }

}
