package uk.gov.co.test.ui.data.v9

import uk.gov.co.test.ui.pages.v9.SignInPage.{preferredFirstName, randomEmail, randomFirstName, randomLastName}
import uk.gov.co.test.ui.pages.v9.shortform.{DiversityMonitoringDetails, EligibilityDetails, PersonalInfoDetails, ShortFormDetails}

case class ApplicationDetails(
  shortFormDetails: ShortFormDetails,
  eligibilityDetails: EligibilityDetails,
  personalInfoDetails: PersonalInfoDetails,
  diversityMonitoringDetails: DiversityMonitoringDetails
)
object CANDIDATE_APPLICATION_DATA
    extends ApplicationDetails(
      APPLICATION_SHORT_FORM,
      APPLICATION_ELIGIBILITY,
      APPLICATION_PERSONAL_INFO,
      APPLICATION_DIVERSITY_MONITORING
    )

object APPLICATION_SHORT_FORM
    extends ShortFormDetails(
      true
    )

object APPLICATION_ELIGIBILITY
    extends EligibilityDetails(
      true,
      "Attorney General's Office",
      true,
      true
    )

object APPLICATION_PERSONAL_INFO
    extends PersonalInfoDetails(
      s"$randomFirstName",
      s"$randomLastName",
      preferredFirstName = Option(s"$preferredFirstName"),
      "01620000000",
      secondaryNo = Option("07700000000"),
      s"$randomEmail",
      false,
      true,
      "Autotest - Provide details of what reasonable adjustments might help you"
    )

object APPLICATION_DIVERSITY_MONITORING
    extends DiversityMonitoringDetails(
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      "",
      postcode = Option("")
    )
