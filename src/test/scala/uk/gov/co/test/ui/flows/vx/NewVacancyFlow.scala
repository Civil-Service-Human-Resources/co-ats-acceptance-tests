package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.pages.vx.CreateNewVacancyPage.{approachSection, approvalSection, createNewVacancy, enterVacancyTitle, jobInformationSection, locationsSection, reserveListSection, selectClosingDate, selectTemplate}
import uk.gov.co.test.ui.pages.vx.{VacancyBasePage, VacancyDetails}

object NewVacancyFlow extends VacancyBasePage {

  private val newVacancy: Seq[VacancyDetails => Unit] = Seq(
    selectTemplate,
    enterVacancyTitle,
    selectClosingDate,
    jobInformationSection,
    approachSection,
    approvalSection,
    reserveListSection,
    locationsSection
  )

  def fillVacancyDetails(vacancy: VacancyDetails): Unit = {
    createNewVacancy()
    newVacancy.foreach { f =>
      f(vacancy)
    }
  }
}
