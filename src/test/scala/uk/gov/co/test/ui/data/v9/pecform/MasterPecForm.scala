package uk.gov.co.test.ui.data.v9.pecform

import uk.gov.co.test.ui.pages.v9.pecform._
import uk.gov.co.test.ui.pages.vx.DashboardPage.v9RefereeEmail

object MASTER_PEC_FORM_DATA
    extends PecFormDetails(
      MASTER_PEC_FORM_YOUR_DETAILS,
      MASTER_PEC_RIGHT_TO_WORK,
      MASTER_PEC_FORM_EMPLOYMENT_HISTORY,
      MASTER_PEC_FORM_VERIFYING_HISTORY,
      MASTER_PEC_FORM_DECLARATION
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
      "1001 Autotest street",
      addressLineTwo = Option("Cheadle"),
      "Manchester",
      "Cheshire",
      "United Kingdom",
      "SK91BX",
      "00110000001"
    )

object MASTER_PEC_RIGHT_TO_WORK
    extends RtwDetails(
      "British citizen, Briton",
      "British citizen, Briton",
      false,
      "Egyptian",
      true,
      true,
      true,
      false,
      "I have settled status",
      "Autotest-certificate/application number",
      "Autotest-shareCode",
      true,
      "Autotest-statusCode",
      "Test-T&Cs.pdf",
      false,
      true,
      false
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

object MASTER_PEC_FORM_VERIFYING_HISTORY
    extends VerifyingHistoryDetails(
      true,
      "Autotest1 - relation to referee",
      "Employer",
      "Employer1 Test1",
      s"$v9RefereeEmail",
      "Academic",
      "Autotest2 - relation to referee",
      "Academic2 Test2",
      s"$v9RefereeEmail",
      "Other",
      "Autotest3 - relation to referee",
      "Other3 Test3",
      s"$v9RefereeEmail"
    )

object MASTER_PEC_FORM_DECLARATION
    extends DeclarationDetails(
      true
    )
