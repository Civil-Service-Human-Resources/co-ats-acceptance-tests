package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.ApproachSection.approachSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ApprovalSection.approvalSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.{basicDetailsSection, createNewVacancy}
import uk.gov.co.test.ui.pages.vx.createvacancypage.JobInfoSection.jobInformationSection
import uk.gov.co.test.ui.utils.NewVacancyDetails

object NewTemplateVacancyFlow extends VacancyBasePage {

  private val newVacancy: Seq[NewVacancyDetails => Unit] = Seq(
    basicDetailsSection,
    jobInformationSection,
    approachSection,
    approvalSection
  )

  def fillNewVacancyTemplatedForm(vacancy: NewVacancyDetails): Unit = {
    createNewVacancy()
    newVacancy.foreach { f =>
      f(vacancy)
    }
  }
}
