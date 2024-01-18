package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.AdditionalQuestionsSection.additionalQuestionsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.AdvertSection.advertSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ApproachSection.approachSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ApprovalSection.approvalSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.{basicDetailsSection, createNewVacancy}
import uk.gov.co.test.ui.pages.vx.createvacancypage.CheckingVettingSection.checkVettingSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ContactDetailsSection.contactDetailsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ContractDetailsSection.contractDetailsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.CriteriaSection.criteriaSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.InterviewsSection.interviewsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.JobInfoSection.jobInformationSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.LocationsSection.locationsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ManagementSection.managementSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.OnlinePecCheckFormsSection.onlinePecCheckFormsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.PecCheckFormsSection.pecCheckFormsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ReserveListSection.reserveListSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.SuccessProfilesSection.successProfilesSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.VacancyTestsSection.vacancyTestsSection
import uk.gov.co.test.ui.pages.vx.vacancytabs.SummaryTab.saveVacancyId

object NewVacancyFlow extends VacancyBasePage {

  private val newVacancy: Seq[NewVacancyDetails => Unit] = Seq(
    basicDetailsSection,
    jobInformationSection,
    approachSection,
    approvalSection,
    reserveListSection,
    locationsSection,
    contractDetailsSection,
    advertSection,
    contactDetailsSection,
    checkVettingSection,
    interviewsSection,
    successProfilesSection,
    vacancyTestsSection,
    additionalQuestionsSection,
    criteriaSection,
    managementSection,
    onlinePecCheckFormsSection,
    pecCheckFormsSection
  )

  def fillNewVacancyForm(vacancy: NewVacancyDetails): Unit = {
    createNewVacancy()
    newVacancy.foreach { f =>
      f(vacancy)
    }
    clickOn(saveVacancyId)
    activateAndPostVacancy()
  }
}
