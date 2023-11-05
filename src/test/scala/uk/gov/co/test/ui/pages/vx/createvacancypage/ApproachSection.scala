package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class ApproachDetails(
  approach: String,
  statementRequired: Boolean,
  statement: String
)

object ApproachSection extends VacancyBasePage {

  private lazy val approachId                     = s"${formId}_field_154380_1"
  private lazy val statementId                    = s"${formId}_datafield_154373_1_1_en-GB"
  private lazy val prereleaseId                   = s"${formId}_datafield_154380_1_1_12648"
  private lazy val internalId                     = s"${formId}_datafield_154380_1_1_11773"
  private lazy val acrossGovernmentId             = s"${formId}_datafield_154380_1_1_12649"
  private lazy val acrossGovernmentYesStatementId = s"${formId}_datafield_154384_1_1_1"
  private lazy val acrossGovernmentNoStatementId  = s"${formId}_datafield_154384_1_1_2"
  private lazy val externalId                     = s"${formId}_datafield_154380_1_1_11774"
  private lazy val internalYesStatementId         = s"${formId}_datafield_154388_1_1_1"
  private lazy val internalNoStatementId          = s"${formId}_datafield_154388_1_1_2"

  private def eligibilityStatement(approachDetails: ApproachDetails): Unit = {
    val statement = waitForVisibilityOfElementById(statementId)
    statement.sendKeys(approachDetails.statement)
  }

  private def selectApproach(approachDetails: ApproachDetails): Unit = {
    scrollToElement(By.id(approachId))
    approachDetails.approach match {
      case "Pre-release"       => clickOnRadioButton(prereleaseId)
      case "Internal"          => clickOnRadioButton(internalId)
      case "Across government" => clickOnRadioButton(acrossGovernmentId)
      case "External"          => clickOnRadioButton(externalId)
      case _                   => throw new IllegalStateException("Please select valid 'Approach' option")
    }
  }

  private def selectStatementRequired(approachDetails: ApproachDetails): Unit =
    if (
      (approachDetails.approach == "Internal" || approachDetails.approach == "Across government") && approachDetails.statementRequired
    ) {
      approachDetails.approach match {
        case "Internal"          => clickOnRadioButton(internalYesStatementId)
        case "Across government" => clickOnRadioButton(acrossGovernmentYesStatementId)
      }
      eligibilityStatement(approachDetails)
    } else if (
      (approachDetails.approach == "Internal" || approachDetails.approach == "Across government") && !approachDetails.statementRequired
    ) {
      approachDetails.approach match {
        case "Internal"          => clickOnRadioButton(internalNoStatementId)
        case "Across government" => clickOnRadioButton(acrossGovernmentNoStatementId)
      }
    }

  private val approach: Seq[ApproachDetails => Unit] = Seq(
    selectApproach,
    selectStatementRequired
  )

  def approachSection(newVacancyDetails: DefraApplyOnlyDetails): Unit =
    approach.foreach { f =>
      f(newVacancyDetails.approachDetails)
    }

}
