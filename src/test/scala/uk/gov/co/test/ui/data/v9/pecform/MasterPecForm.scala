package uk.gov.co.test.ui.data.v9.pecform

import uk.gov.co.test.ui.pages.v9.pecform.{EmploymentHistoryDetails, YourDetails}

object MASTER_PEC_FORM_DATA
    extends PecFormDetails(
      MASTER_PEC_FORM_YOUR_DETAILS,
      MASTER_PEC_FORM_EMPLOYMENT_HISTORY
    )

object MASTER_PEC_FORM_YOUR_DETAILS
    extends YourDetails(
      "Mr",
      true,
      "JA123456D",
      "Autotest - Provide details on your nino application status",
      "01/01/1980",
      "Man",
      "Single",
      "10 Autotest street",
      addressLineTwo = Option("Testville"),
      "Test",
      "Test",
      "United Kingdom",
      "LE91BX",
      "00110000001"
    )

object MASTER_PEC_FORM_EMPLOYMENT_HISTORY
    extends EmploymentHistoryDetails(
      true,
      "Employer Test One",
      "01/01/2023",
      "01/12/2023",
      "Employer Test Two",
      "01/07/2021",
      "31/12/2022",
      "Employer Test Three",
      "01/01/2020",
      "01/06/2021"
    )
