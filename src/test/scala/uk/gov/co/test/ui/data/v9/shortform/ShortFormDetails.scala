package uk.gov.co.test.ui.data.v9.shortform

import uk.gov.co.test.ui.pages.v9.shortform._

case class ShortFormDetails(
  appGuidanceDetails: AppGuidanceDetails,
  eligibilityDetails: EligibilityDetails,
  personalInfoDetails: PersonalInfoDetails,
  diversityDetails: DiversityDetails,
  declarationDetails: DeclarationDetails
)
