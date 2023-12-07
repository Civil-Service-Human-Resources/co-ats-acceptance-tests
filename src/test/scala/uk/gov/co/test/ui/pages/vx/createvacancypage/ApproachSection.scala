package uk.gov.co.test.ui.pages.vx.createvacancypage

import org.openqa.selenium.By
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class ApproachDetails(
  approach: String,
  statementRequired: Boolean,
  eligibilityStatement: String,
  addWelshStatement: Boolean,
  welshStatement: String,
  standardStatement: String
)

object ApproachSection extends VacancyBasePage {

  def approachId                     = s"${formId}_field_154380_1"
  def statementId                    = s"${formId}_datafield_154373_1_1_en-GB"
  def prereleaseId                   = s"${formId}_datafield_154380_1_1_12648"
  def internalId                     = s"${formId}_datafield_154380_1_1_11773"
  def acrossGovernmentId             = s"${formId}_datafield_154380_1_1_12649"
  def acrossGovernmentYesStatementId = s"${formId}_datafield_154384_1_1_1"
  def acrossGovernmentNoStatementId  = s"${formId}_datafield_154384_1_1_2"
  def externalId                     = s"${formId}_datafield_154380_1_1_11774"
  def internalYesStatementId         = s"${formId}_datafield_154388_1_1_1"
  def internalNoStatementId          = s"${formId}_datafield_154388_1_1_2"
  def addWelshTranslationId()        = "clicky_154373"
  def welshStatementInput            = "datafield_154373_1_1_cy"
  def updateWelshId()                = "lbledit_datafield_154373_1_1-update"
  var candidateApproach              = "External"

  private def eligibilityStatement(approachDetails: ApproachDetails): Unit = {
    val statement = waitForVisibilityOfElementById(statementId)
    statement.sendKeys(approachDetails.eligibilityStatement)
    enterWelshStatement(approachDetails)
  }

  private def standardEligibilityStatement(text: String): Boolean =
    waitForVisibilityOfElementByPath(s".//strong[text()='$text']").isDisplayed

  private def selectApproach(approachDetails: ApproachDetails): Unit = {
    scrollToElement(By.id(approachId))
    candidateApproach = approachDetails.approach
    candidateApproach match {
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
      standardEligibilityStatement(approachDetails.standardStatement)
    }

  private def enterWelshStatement(approachDetails: ApproachDetails): Unit =
    addWelshTranslation(
      approachDetails.addWelshStatement,
      addWelshTranslationId(),
      welshStatementInput,
      approachDetails.welshStatement,
      updateWelshId()
    )

  private val approach: Seq[ApproachDetails => Unit] = Seq(
    selectApproach,
    selectStatementRequired
  )

  def approachSection(newVacancyDetails: NewVacancyDetails): Unit =
    approach.foreach { f =>
      f(newVacancyDetails.approachDetails)
    }

}
