package uk.gov.co.test.ui.data.v9.shortform

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.{preferredFirstName, randomEmail, randomFirstName, randomLastName}
import uk.gov.co.test.ui.pages.v9.shortform._

object SHORT_FORM_DATA_PEC
    extends ShortFormDetails(
      SHORT_FORM_APP_GUIDANCE_PEC,
      SHORT_FORM_ELIGIBILITY_PEC,
      SHORT_FORM_PERSONAL_INFO_PEC,
      SHORT_FORM_DIVERSITY_MONITORING_PEC,
      SHORT_FORM_DECLARATION_PEC
    )

object SHORT_FORM_APP_GUIDANCE_PEC
    extends AppGuidanceDetails(
      true
    )

object SHORT_FORM_ELIGIBILITY_PEC
    extends EligibilityDetails(
      false,
      "Attorney General's Office",
      true,
      true,
      true,
      true,
      "Yes",
      "Yes"
    )

object SHORT_FORM_PERSONAL_INFO_PEC
    extends PersonalInfoDetails(
      firstName = s"$randomFirstName",
      lastName = s"$randomLastName",
      preferredFirstName = Option(s"$preferredFirstName"),
      "01520000000",
      secondaryNo = Option("07770000000"),
      s"$randomEmail",
      false,
      false,
      "Autotest - Provide details of what reasonable adjustments might help you",
      false,
      "Autotest - reasonable adjustments to be able to complete online tests",
      "Yes",
      true,
      redeploymentScheme = Option(false)
    )

object SHORT_FORM_DIVERSITY_MONITORING_PEC
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

object SHORT_FORM_DECLARATION_PEC
    extends DeclarationDetails(
      true
    )
