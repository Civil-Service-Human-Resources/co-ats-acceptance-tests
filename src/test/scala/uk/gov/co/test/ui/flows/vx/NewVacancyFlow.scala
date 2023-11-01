package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.pages.vx.CreateNewVacancyPage.{createNewVacancy, enterVacancyTitle, noOfJobsAvailable, selectApproach, selectBusinessArea, selectClosingDate, selectTemplate, selectTypeOfRole, whichProfessionIsJob}
import uk.gov.co.test.ui.pages.vx.{VacancyBasePage, VacancyDetails}

object NewVacancyFlow extends VacancyBasePage {

  private val newVacancy: Seq[VacancyDetails => Unit] = Seq(
    selectTemplate,
    enterVacancyTitle,
    selectClosingDate,
    selectBusinessArea,
    selectTypeOfRole,
    whichProfessionIsJob,
    noOfJobsAvailable,
    selectApproach
  )

  def fillVacancyDetails(vacancy: VacancyDetails): Unit = {
    createNewVacancy()
    newVacancy.foreach { f =>
      f(vacancy)
    }
  }
}
