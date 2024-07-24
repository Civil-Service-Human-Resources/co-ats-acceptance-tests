package uk.gov.co.test.ui.data.test.pnnen

import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomFirstName, randomLastName}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.pecform._
import uk.gov.co.test.ui.pages.vx.DashboardPage.v9RefereeEmail

import java.time.LocalDate

object PN_NEN_PEC_FORM_DATA
    extends PecFormDetails(
      PN_NEN_PEC_FORM_YOUR_DETAILS,
      PN_NEN_PEC_RIGHT_TO_WORK,
      PN_NEN_PEC_FORM_EMPLOYMENT_HISTORY,
      PN_NEN_PEC_FORM_VERIFYING_HISTORY,
      PN_NEN_PEC_FORM_WORKPLACE_MISCONDUCT,
      PN_NEN_PEC_FORM_PENSION_QUESTIONNAIRE,
      PN_NEN_PEC_FORM_OVERSEAS,
      PN_NEN_PEC_FORM_BANKRUPTCY_DETAILS,
      PN_NEN_PEC_FORM_HEALTH_DECLARATION,
      PN_NEN_PEC_FORM_SELF_EMPLOYMENT,
      PN_NEN_PEC_FORM_PREVIOUS_CS_EMPLOYMENT,
      PN_NEN_PEC_FORM_NATIONAL_SECURITY_VETTING,
      PN_NEN_PEC_FORM_UPLOAD_IDENTITY_DOCS,
      PN_NEN_PEC_FORM_DBS_PERSONAL_INFO,
      PN_NEN_PEC_FORM_DBS_ADDRESS_DETAILS,
      PN_NEN_PEC_FORM_DIGITAL_IDENTITY_CHECK,
      PN_NEN_PEC_FORM_DECLARATION
    )

object PN_NEN_PEC_FORM_YOUR_DETAILS
    extends YourDetails(
      "Mr",
      true,
      "JA123456D",
      "Autotest - Provide details on your nino application status",
      "01/01/1980",
      "Man",
      "Single",
      "01/12/2020",
      "Modernised",
      true,
      "SEO",
      "1001 Autotest street",
      addressLineTwo = Option("Cheadle"),
      "Manchester",
      "Cheshire",
      "United Kingdom",
      "SK91BX",
      "00110000001"
    )

object PN_NEN_PEC_FORM_UPLOAD_IDENTITY_DOCS
    extends IdentityDocDetails(
      "Test-T&Cs.pdf"
    )

object PN_NEN_PEC_RIGHT_TO_WORK
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

object PN_NEN_PEC_FORM_DBS_PERSONAL_INFO
    extends DbsPersonalInfoDetails(
      "Mr",
      "Marie",
      false,
      "TestMiddleName",
      "Jallow",
      "Jallow",
      "03/11/1975",
      false,
      "Croydon",
      "United Kingdom",
      "+7752999000",
      "Female",
      true,
      "JA112233D",
      true,
      "533324428",
      "United Kingdom",
      "03/11/1975",
      "28/09/2015",
      true,
      "JALLO761035M99TS",
      "03/11/1975",
      "Photo",
      "28/09/2015",
      "United Kingdom",
      false,
      "TestProfileId",
      false,
      true,
      false
    )

object PN_NEN_PEC_FORM_DBS_ADDRESS_DETAILS
    extends DbsAddressDetails(
      "40 Cromwell Road",
      Some(""),
      "Ely",
      "Cambridgeshire",
      "United Kingdom",
      "CB6 1AS",
      "03/11/1975"
    )

object PN_NEN_PEC_FORM_DIGITAL_IDENTITY_CHECK
    extends DigitalIdentityDetails(
      "As part of checking your right to work in the UK, we would like to process your biometric data for digital identity validation. We will ask for your passport or passport card, and a photo of your face.\n\nIf you consent to this processing, we will share your personal data with our checking provider TrustID and their supply chain. Please see our privacy notice (opens in new window) for more detail.\n\nIf you choose not to consent, you will need to present your original ID documents in person.",
      "I consent to my data being processed for digital identity checks",
      true,
      "Do you have access to a smartphone or tablet with a camera?",
      true,
      "Do you have an in-date biometric passport or biometric ID card?",
      true,
      "Do you have an in-date photocard driving licence?",
      true
    )

object PN_NEN_PEC_FORM_EMPLOYMENT_HISTORY
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

object PN_NEN_PEC_FORM_VERIFYING_HISTORY
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

object PN_NEN_PEC_FORM_WORKPLACE_MISCONDUCT
    extends MisconductDetails(
      true,
      "Autotest - name, address & email of employer for claim of misconduct against candidate",
      true,
      "Autotest - name, address & email of employer for currently under investigation of candidate",
      true
    )

object PN_NEN_PEC_FORM_PENSION_QUESTIONNAIRE
  extends PensionDetails(
    "Your answers will allow us to work out which of the Civil Service Pension schemes you can join.",
    "Have you ever been a member of public service pension scheme?\nAnswer this question with your latest period of pension scheme membership. Public services employers include the Civil Service, judiciary workers, teachers, members of the armed forces, fire and rescue services, the police, health service workers and local government employees.\n*By-analogy schemes are almost identical to the main Civil Service arrangements, but may have slightly different terms or rules.",
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

object PN_NEN_PEC_FORM_OVERSEAS
    extends OverseasDetails(
      "Have you resided outside the UK within the past 3 years for 6 months or more?",
      true,
      "Where it is not possible to carry out meaningful checks in the UK because of a lack of UK residence, prospective employees are required to give a reasonable account of any significant periods of time living abroad.",
      "Please provide a list of all countries you have visited with date and reasons for travel.",
      "Canada",
      "01/01/2020",
      "28/02/2021",
      "Adventure junkie!",
      true,
      "Autotest - employer's name",
      "autotest.employers.email@example.com",
      "01100000000",
      "01/07/2022",
      "31/07/2022",
      false,
      "Autotest - Provide details about why we cannot contact your overseas employer",
      true,
      "Autotest - institute name",
      "autotest.institute.email@example.com",
      "01100000001",
      "01/07/2021",
      "31/12/2023",
      false,
      "Autotest - Provide details about why we cannot contact your fellow UK traveller",
      true,
      "Autotest - fellow traveller's name",
      "autotest.traveller.email@example.com",
      "01100000003",
      "01/02/2020",
      "22/05/2020",
      false,
      "Autotest - Provide details about why we cannot contact your fellow UK traveller"
    )

object PN_NEN_PEC_FORM_BANKRUPTCY_DETAILS
    extends BankruptcyDetails(
      false,
      "Autotest - bankruptcy status",
      false,
      "Autotest - insolvency status",
      false,
      "Autotest - details about the receiving order in effect on your property",
      false,
      "Autotest - details on any penalties imposed in relation to late filing on your tax affairs within the last 5 years"
    )

object PN_NEN_PEC_FORM_HEALTH_DECLARATION
    extends HealthDeclarationDetails(
      true,
      "Autotest - any adjustments details",
      true,
      "Autotest - health issues details",
      true,
      "Autotest - conditions affecting job advert details",
      true,
      "Autotest - ongoing investigations details",
      true,
      "Autotest - current health issues that may affect new role details",
      true,
      "Autotest - health related absence details",
      true,
      "Autotest - discuss any health related issues details"
    )

object PN_NEN_PEC_FORM_SELF_EMPLOYMENT
    extends SelfEmploymentDetails(
      true,
      employmentStartDate = LocalDate.now().minusYears(3),
      employmentEndDate = LocalDate.now().minusMonths(3),
      "Autotest - name of business",
      "Autotest - type of business",
      true,
      "Autotest - details about why the accounts are not closed",
      false,
      "Autotest - details of the status of these accounts",
      true,
      "Alliance & Roberts",
      "Mr Automation",
      "07700123123",
      emailOfSolicitorOrAccountant = s"$v9RefereeEmail",
      true,
      "Test-T&Cs.pdf",
      true,
      "1234567890",
      true,
      true,
      "Autotest - details about the self-employment you intend to keep after you start your Civil Service role",
      true,
      "Autotest - how your self-employment could cause a conflict of interest with your Civil Service role"
    )

object PN_NEN_PEC_FORM_PREVIOUS_CS_EMPLOYMENT
    extends PreviousCSEmploymentDetails(
      false
    )

object PN_NEN_PEC_FORM_NATIONAL_SECURITY_VETTING
    extends NsvDetails(
      s"$randomLastName",
      anyOtherSurname = Some(s"$randomLastName"),
      anyOtherSurnameTwo = Some(s"$randomLastName"),
      anyOtherForename = Some(s"$randomFirstName"),
      anyOtherForenameTwo = Some(s"$randomFirstName"),
      "Ely",
      "United Kingdom",
      true,
      "IMMINOTTELL",
      "40 Cromwell Road",
      addressLineTwo = Some("Heald Place"),
      "Ely",
      "CB6 1AS",
      "Cambridgeshire",
      "United Kingdom",
      "03/11/1975",
      false,
      true,
      "MI6",
      "007",
      "31/07/1980",
      serviceEndDate = Some("01/09/2000"),
      "Contractor",
      true,
      "Enhanced Developed Vetting",
      "01/01/1990",
      "31/12/1996",
      "NSVS",
      securityClearanceInfo = Some(value = "Autotest - security clearance details")
    )

object PN_NEN_PEC_FORM_DECLARATION
    extends DeclarationDetails(
      true, true, true, true, true, true, true, true
    )
