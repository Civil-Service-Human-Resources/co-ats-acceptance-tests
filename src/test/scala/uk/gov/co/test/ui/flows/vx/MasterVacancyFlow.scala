package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.pages.vx.MasterVacancyPage.{advertSection, approachSection, approvalSection, basicDetailsSection, contactDetailsSection, contractDetailsSection, createNewVacancy, jobInformationSection, locationsSection, reserveListSection}
import uk.gov.co.test.ui.pages.vx.{MasterVacancyDetails, VacancyBasePage}

object MasterVacancyFlow extends VacancyBasePage {

  private val masterVacancy: Seq[MasterVacancyDetails => Unit] = Seq(
    basicDetailsSection,
    jobInformationSection,
    approachSection,
    approvalSection,
    reserveListSection,
    locationsSection,
    contractDetailsSection,
    advertSection,
    contactDetailsSection
  )

  def fillMasterVacancyForm(masterVacancyFlow: MasterVacancyDetails): Unit = {
    createNewVacancy()
    masterVacancy.foreach { f =>
      f(masterVacancyFlow)
    }
  }
}
