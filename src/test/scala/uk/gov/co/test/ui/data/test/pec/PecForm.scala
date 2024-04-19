package uk.gov.co.test.ui.data.test.pec

import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.pecform._
import uk.gov.co.test.ui.pages.vx.DashboardPage.v9RefereeEmail

object PEC_FORM_DATA
    extends PecFormDetails(
      PEC_FORM_YOUR_DETAILS,
      PEC_RIGHT_TO_WORK,
      PEC_FORM_EMPLOYMENT_HISTORY,
      PEC_FORM_VERIFYING_HISTORY,
      PEC_FORM_PENSION_QUESTIONNAIRE,
      PEC_FORM_DECLARATION
    )

object PEC_FORM_YOUR_DETAILS
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

object PEC_RIGHT_TO_WORK
    extends RtwDetails(
      "British citizen, Briton",
      "British citizen, Briton",
      true,
      "Egyptian",
      false,
      true,
      true,
      false,
      "I have applied for the settlement scheme and await confirmation of my status",
      "Autotest-certificate/application number",
      "Autotest-shareCode",
      true,
      "Autotest- 'View and Prove' code",
      "Test-T&Cs.pdf",
      true,
      true,
      true
    )

object PEC_FORM_EMPLOYMENT_HISTORY
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

object PEC_FORM_VERIFYING_HISTORY
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

object PEC_FORM_PENSION_QUESTIONNAIRE
    extends PensionDetails(
      "Your answers will allow us to work out which of the Civil Service Pension schemes you can join.",
      "Have you ever been a member of public service pension scheme?\nAnswer this question with your latest period of pension scheme membership. Public services employers include the Civil Service, judiciary workers, teachers, members of the armed forces, fire and rescue services, the police, health service workers and local government employees. *By-analogy schemes are almost identical to the main Civil Service arrangements, but may have slightly different terms or rules.",
      "Civil Service Pension arrangements",
      "HMRC",
      "Classic plus",
      "01/06/2021",
      "Resigned with more than 2 years service - You built up pension rights; you may have received a preserved pension",
      false,
      false,
      true,
      "Autotest - pension transfer details",
      "Autotest - name of employer of latest pension",
      "Autotest - pension scheme member of",
      "Autotest - pension normal pension age",
      "1234",
      "01/06/2018",
      "31/12/2020",
      true,
      paymentReceived = Option(true),
      transferToOtherPension = Option(true),
      schemeTransferredTo = Option("Autotest - what scheme did you transfer your pension to?"),
      true,
      "31/07/2020",
      true,
      false
    )

object PEC_FORM_DECLARATION
    extends DeclarationDetails(
      true
    )
