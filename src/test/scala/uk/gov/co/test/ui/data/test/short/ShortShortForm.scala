package uk.gov.co.test.ui.data.test.short

import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.shortform._

object SHORT_SHORT_FORM_DATA
    extends ShortFormDetails(
      SHORT_SHORT_FORM_APP_GUIDANCE,
      SHORT_SHORT_FORM_ELIGIBILITY,
      SHORT_SHORT_FORM_PERSONAL_INFO,
      SHORT_SHORT_FORM_DIVERSITY_MONITORING,
      SHORT_SHORT_FORM_DECLARATION
    )

object SHORT_SHORT_FORM_APP_GUIDANCE
    extends AppGuidanceDetails(
      true
    )

object SHORT_SHORT_FORM_ELIGIBILITY
    extends EligibilityDetails(
      true,
      true,
      true,
      true,
      true,
      "Yes",
      "Yes"
    )

object SHORT_SHORT_FORM_PERSONAL_INFO
    extends PersonalInfoDetails(
      "01520000000",
      secondaryNo = Option("07770000000"),
      false,
      false, //reasonable adjustments set to false, requires logic at later date
      "Autotest - Provide details of what reasonable adjustments might help you",
      false, //reasonable adjustments for tests set to false, requires logic at later date
      "Autotest - reasonable adjustments to be able to complete online tests",
      "Yes",
      true,
      redeploymentScheme = Option(false)
    )

object SHORT_SHORT_FORM_DIVERSITY_MONITORING
    extends DiversityDetails(
      "No",
      "Man",
      "Prefer not to disclose",
      "35-39",
      "Welsh",
      "Asian / Asian British",
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
      "Auto tester2",
      "Muslim",
      "Traditional Professional",
      "Not working",
      "Attended school outside the UK",
      postcode = Option("SK8 1BX"),
      true,
      "Protestant"
    )

object SHORT_SHORT_FORM_DECLARATION
    extends DeclarationDetails(
      true
    )