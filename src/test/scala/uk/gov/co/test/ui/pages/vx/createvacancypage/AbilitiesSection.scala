package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class AbilitiesDetails(assessAbilities: String)

object AbilitiesSection extends VacancyBasePage {

  private lazy val abilitiesSectionId = s"${formId}_section_76647_col_0"
  private lazy val assessAbilitiesId  = s"${formId}_label_130464_1"

  def selectAbilitiesProfile(successProfilesDetails: SuccessProfilesDetails): Unit =
    if (successProfilesDetails.abilities) {
      scrollToElement(By.id(abilitiesSectionId))
      getAssessSectionText(assessAbilitiesId) shouldBe successProfilesDetails.abilitiesSection
        .map(_.assessAbilities)
        .get
    }
}
