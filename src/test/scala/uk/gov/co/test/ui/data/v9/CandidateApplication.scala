package uk.gov.co.test.ui.data.v9

import uk.gov.co.test.ui.pages.v9.SignInPage.{preferredFirstName, randomEmail, randomFirstName, randomLastName}
import uk.gov.co.test.ui.pages.v9.shortform._

case class ShortFormDetails(
  appGuidanceDetails: AppGuidanceDetails,
  eligibilityDetails: EligibilityDetails,
  personalInfoDetails: PersonalInfoDetails,
  diversityDetails: DiversityDetails,
  declarationDetails: DeclarationDetails
)

object CANDIDATE_SHORT_FORM_DATA
    extends ShortFormDetails(
      SHORT_FORM_APP_GUIDANCE,
      SHORT_FORM_ELIGIBILITY,
      SHORT_FORM_PERSONAL_INFO,
      SHORT_FORM_DIVERSITY_MONITORING,
      SHORT_FORM_DECLARATION
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
      "English",
      "White",
      ethnicity = Map(
        "White"                                       -> List(
          "English",
          "Welsh",
          "Scottish",
          "Northern Irish",
          "Irish",
          "Gypsy or Irish Traveller",
          "Any other White background"
        ),
        "Mixed / multiple ethnic groups"              -> List(
          "Mixed White and Asian",
          "Mixed White and Black African",
          "Mixed White and Black Caribbean",
          "Any other Mixed background"
        ),
        "Asian / Asian British"                       -> List(
          "Asian or Asian British - Bangladeshi",
          "Asian or Asian British - Indian",
          "Asian or Asian British - Pakistani",
          "Chinese",
          "Any other Asian background"
        ),
        "Black / African / Caribbean / Black British" -> List(
          "Black or Black British - African",
          "Black or Black British - Caribbean",
          "Any other Black background"
        ),
        "Other ethnic group"                          -> List(
          "Arab",
          "Other ethnic group"
        )
      ),
      "Auto tester",
      "Christian",
      "Technical",
      "Self-employed/freelancer without employees",
      "Independent or fee-paying school - no bursary",
      postcode = Option("SK8 1BX")
    )

object SHORT_FORM_DECLARATION
    extends DeclarationDetails(
      true
    )
