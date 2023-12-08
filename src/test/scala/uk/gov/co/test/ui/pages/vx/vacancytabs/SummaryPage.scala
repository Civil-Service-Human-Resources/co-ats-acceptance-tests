package uk.gov.co.test.ui.pages.vx.vacancytabs

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vacancyName

object SummaryPage extends VacancyBasePage {

  val saveVacancyId                 = "edit_opp_form_form_create"
  private lazy val isActivePath     = "//*[@id='details_form_is_active']/span"
  private lazy val editVacancy      = "//*[@class='ajax_form_edit btn btn-default btn-sm']"
  private lazy val previewAdvert    = ".//a[@aria-label='Preview advert Details Summary']"
  private lazy val activateVacancy  = "details_form_is_active"
  private lazy val submitEditedForm = "details_form_form_submit"
  private lazy val addTranslationId = "details_form_title_button"
  private lazy val vacancyTitleId   = "details_form_title"
  private lazy val vacancyTitle     = ".//*[@class='obj_name']"
  private lazy val alertMessagePath = ".//*[@class='cn']"

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
      confirmFormEdit() shouldEqual s"Vacancy Details Saved : $vacancyName"
    }

  def confirmAndActivateVacancy(): Unit = {
    eventually(onPage(newVacancyPageTitle()))
    setVacancyToActive()
  }

  def confirmFormEdit(): String = {
    val alert = waitForVisibilityOfElementByPath(alertMessagePath).getText
    alert
  }

}
