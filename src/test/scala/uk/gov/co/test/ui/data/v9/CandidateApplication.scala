package uk.gov.co.test.ui.data.v9

import uk.gov.co.test.ui.pages.v9.SignInPage.{preferredFirstName, randomEmail, randomFirstName, randomLastName}
import uk.gov.co.test.ui.pages.v9.shortform.{AppGuidanceDetails, DiversityDetails, EligibilityDetails, PersonalInfoDetails}

case class ShortFormDetails(
  appGuidanceDetails: AppGuidanceDetails,
  eligibilityDetails: EligibilityDetails,
  personalInfoDetails: PersonalInfoDetails,
  diversityDetails: DiversityDetails
)

object CANDIDATE_SHORT_FORM_DATA
    extends ShortFormDetails(
      SHORT_FORM_APP_GUIDANCE,
      SHORT_FORM_ELIGIBILITY,
      SHORT_FORM_PERSONAL_INFO,
      SHORT_FORM_DIVERSITY_MONITORING
    )

object SHORT_FORM_APP_GUIDANCE
    extends AppGuidanceDetails(
      true
    )

object SHORT_FORM_ELIGIBILITY
    extends EligibilityDetails(
      true,
      "Attorney General's Office",
      true,
      true
    )

object SHORT_FORM_PERSONAL_INFO
    extends PersonalInfoDetails(
      s"$randomFirstName",
      s"$randomLastName",
      preferredFirstName = Option(s"$preferredFirstName"),
      "01620000000",
      secondaryNo = Option("07700000000"),
      s"$randomEmail",
      false,
      true,
      "Autotest - Provide details of what reasonable adjustments might help you",
      redeploymentScheme = Option(false)
    )

object SHORT_FORM_DIVERSITY_MONITORING
    extends DiversityDetails(
      "No",
      "Man",
      "Heterosexual or straight",
      "Prefer not to disclose",
      "",
      "",
      "",
      "",
      "",
      "",
      postcode = Option("")
    )
