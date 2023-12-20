package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

case class AbilitiesDetails(assessAbilities: String)

object AbilitiesSection extends VacancyBasePage {

  def abilitiesSectionId = s"${vacancyFormId}_section_76647_col_0"
  def assessAbilitiesId  = s"${vacancyFormId}_label_130464_1"

  def selectAbilitiesProfile(successProfilesDetails: SuccessProfilesDetails): Unit =
    if (successProfilesDetails.abilities) {
      scrollToElement(By.id(abilitiesSectionId))
      getAssessSectionText(assessAbilitiesId) shouldBe successProfilesDetails.abilitiesSection
        .map(_.assessAbilities)
        .get
    }
}
