package uk.gov.co.test.ui.flows.vx

import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
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
import uk.gov.co.test.ui.pages.vx.createvacancypage.MoreQuestionsSection.additionalQuestionsSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.ReserveListSection.reserveListSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.SuccessProfilesSection.successProfilesSection
import uk.gov.co.test.ui.pages.vx.createvacancypage.VacancyTestsSection.vacancyTestsSection

object NewVacancyFlow extends VacancyBasePage {

  private val defraVacancy: Seq[DefraApplyOnlyDetails => Unit] = Seq(
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
    criteriaSection
  )

  def fillNewVacancyForm(vacancy: DefraApplyOnlyDetails): Unit = {
    createNewVacancy()
    defraVacancy.foreach { f =>
      f(vacancy)
    }
    println("Done!")
  }
}
