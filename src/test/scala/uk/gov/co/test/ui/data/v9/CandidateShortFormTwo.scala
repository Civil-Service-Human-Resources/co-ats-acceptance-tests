package uk.gov.co.test.ui.data.v9

import uk.gov.co.test.ui.pages.v9.SignInPage.{preferredFirstName, randomEmail, randomFirstName, randomLastName}
import uk.gov.co.test.ui.pages.v9.shortform._

//case class ShortFormDetails(
//  appGuidanceDetails: AppGuidanceDetails,
//  eligibilityDetails: EligibilityDetails,
//  personalInfoDetails: PersonalInfoDetails,
//  diversityDetails: DiversityDetails,
//  declarationDetails: DeclarationDetails
//)

object CANDIDATE_SHORT_FORM_DATA_2
    extends ShortFormDetails(
      SHORT_FORM_APP_GUIDANCE_2,
      SHORT_FORM_ELIGIBILITY_2,
      SHORT_FORM_PERSONAL_INFO_2,
      SHORT_FORM_DIVERSITY_MONITORING_2,
      SHORT_FORM_DECLARATION_2
    )

object SHORT_FORM_APP_GUIDANCE_2
    extends AppGuidanceDetails(
      true
    )

object SHORT_FORM_ELIGIBILITY_2
    extends EligibilityDetails(
      false,
      "Attorney General's Office",
      true,
      true
    )

object SHORT_FORM_PERSONAL_INFO_2
    extends PersonalInfoDetails(
      firstName = s"$randomFirstName",
      lastName = s"$randomLastName",
      preferredFirstName = Option(s"$preferredFirstName"),
      "01520000000",
      secondaryNo = Option("07770000000"),
      s"$randomEmail",
      false,
      true,
      "Autotest - Provide details of what reasonable adjustments might help you",
      redeploymentScheme = Option(false)
    )

object SHORT_FORM_DIVERSITY_MONITORING_2
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
      postcode = Option("SK8 1BX")
    )

object SHORT_FORM_DECLARATION_2
    extends DeclarationDetails(
      true
    )
