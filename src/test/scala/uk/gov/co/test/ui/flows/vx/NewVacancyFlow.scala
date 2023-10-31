package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.pages.vx.CreateNewVacancyPage.{createNewVacancy, enterVacancyTitle, selectBusinessArea, selectClosingDate, selectTemplate, selectTypeOfRole}
import uk.gov.co.test.ui.pages.vx.{VacancyBasePage, VacancyDetails}

object NewVacancyFlow extends VacancyBasePage {

  private val newVacancy: Seq[VacancyDetails => Unit] = Seq(
    selectTemplate,
    enterVacancyTitle,
    selectClosingDate,
    selectBusinessArea,
    selectTypeOfRole
  )

  def fillVacancyDetails(vacancy: VacancyDetails): Unit = {
    createNewVacancy()
    newVacancy.foreach { f =>
      f(vacancy)
    }
  }
}
