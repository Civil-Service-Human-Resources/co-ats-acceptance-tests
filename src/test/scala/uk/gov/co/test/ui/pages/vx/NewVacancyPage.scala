package uk.gov.co.test.ui.pages.vx

import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyName

object NewVacancyPage extends VacancyBasePage {

  val saveVacancyId    = "edit_opp_form_form_create"
  val isActivePath     = "//*[@id='details_form_is_active']/span"
  val editVacancy      = "//*[@class='ajax_form_edit btn btn-default btn-sm']"
  val activateVacancy  = "details_form_is_active"
  val submitEditedForm = "details_form_form_submit"
  var vacancyId        = ""

  private def newVacancyPageTitle(vacancyName: String): String = {
    val pageTitle = s"$vacancyName : Civil Service Jobs - GOV.UK"
    pageTitle
  }

  private def newVacancyAppId(): String = {
    vacancyId = waitForVisibilityOfElementByPath(".//*[@class='app_id']").getText
    vacancyId
  }

  private def newVacancyName(): String = {
    val vacancyName = waitForVisibilityOfElementByPath(".//*[@class='obj_name']").getText
    vacancyName
  }

  private def vacancyActive(): String = {
    val active = waitForVisibilityOfElementByPath(isActivePath).getAttribute("aria-label")
    active
  }

  private def setVacancyToActive(): Unit = {
    newVacancyAppId()
    println(vacancyId)
    if (vacancyActive() == "Set to FALSE") {
      waitForElementClickableByPath(editVacancy).click()
      if (waitForVisibilityOfElementById(activateVacancy).isEnabled) {
        checkbox(activateVacancy).select()
      }
      clickOn(submitEditedForm)
    }
  }

  def confirmAndActivateVacancy(): Unit = {
    onPage(newVacancyPageTitle(vacancyName))
    setVacancyToActive()
  }

}
