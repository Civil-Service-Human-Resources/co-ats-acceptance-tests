package uk.gov.co.test.ui.data.v9.longform

import uk.gov.co.test.ui.pages.v9.longform.{CVDetails, ExperienceAndSkillsDetails, StatementDetails}

case class LongFormDetails(
  experienceAndSkillsDetails: ExperienceAndSkillsDetails,
  cvDetails: CVDetails,
  statementDetails: StatementDetails
)
