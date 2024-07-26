package uk.gov.co.test.ui.data.test.redeployment

import uk.gov.co.test.ui.data.v9.shortform.ShortFormDetails
import uk.gov.co.test.ui.pages.v9.shortform._

object REDEPLOYMENT_SHORT_FORM_DATA
    extends ShortFormDetails(
      REDEPLOYMENT_SHORT_FORM_APP_GUIDANCE,
      REDEPLOYMENT_SHORT_FORM_ELIGIBILITY,
      REDEPLOYMENT_SHORT_FORM_PERSONAL_INFO,
      REDEPLOYMENT_SHORT_FORM_DIVERSITY_MONITORING,
      REDEPLOYMENT_SHORT_FORM_DECLARATION
    )

object REDEPLOYMENT_SHORT_FORM_APP_GUIDANCE
    extends AppGuidanceDetails(
      true
    )

object REDEPLOYMENT_SHORT_FORM_ELIGIBILITY
    extends EligibilityDetails(
      true,
      true,
      true,
      true,
      true,
      "Yes",
      "Yes"
    )

object REDEPLOYMENT_SHORT_FORM_PERSONAL_INFO
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
      false,
      redeploymentDept = List(
        "Accountant in Bankruptcy",
        "Active Travel England",
        "Advisory, Conciliation and Arbitration Service",
        "Animal and Plant Health Agency",
        "Attorney General's Office",
        "Building Digital UK (BDUK)",
        "Cabinet Office",
        "Central Digital and Data Office",
        "Centre for Environment, Fisheries and Aquaculture Science",
        "Charity Commission",
        "Companies House",
        "Competition & Markets Authority",
        "Criminal Injuries Compensation Authority",
        "Crown Commercial Service",
        "Crown Office and Procurator Fiscal Service",
        "Crown Prosecution Service",
        "DE&S Deca",
        "Defence Science and Technology Laboratory",
        "Department for Business and Trade",
        "Department for Business, Energy & Industrial Strategy",
        "Department for Energy Security & New Zero",
        "Department for Culture, Media and Sport",
        "Department for Education",
        "Department for Energy Security & Net Zero",
        "Department for Environment, Food and Rural Affairs",
        "Department for Levelling Up, Housing and Communities",
        "Department for Science, Innovation and Technology",
        "Department for Transport",
        "Department for Work and Pensions",
        "Department of Health and Social Care",
        "Disclosure Scotland",
        "Driver and Vehicle Licensing Agency",
        "Driver and Vehicle Standards Agency",
        "Education and Skills Funding Agency",
        "Education Scotland",
        "ESTYN",
        "FCDO Services",
        "Food Standards Agency",
        "Food Standards Scotland",
        "Foreign, Commonwealth & Development Office",
        "Forestry and Land Scotland",
        "Forestry Commission",
        "Forestry Commission - Forest Research",
        "GCHQ",
        "Government Actuary's Department",
        "Government Commercial Function",
        "Government Digital Service",
        "Government Equalities Office",
        "Government Internal Audit Agency",
        "Government Legal Department",
        "Government Office for Science",
        "Government Operational Research Service",
        "Government Property Agency",
        "Government Statistical Service",
        "Health and Safety Executive",
        "HM Courts and Tribunals Service",
        "HM Crown Prosecution Service Inspectorate",
        "HM Land Registry",
        "HM Prison & Probation Service",
        "HM Revenue and Customs",
        "HM Treasury",
        "Home Office",
        "Insolvency Service",
        "Institute for Apprenticeships and Technical Education",
        "Intellectual Property Office",
        "Legal Aid Agency",
        "Maritime and Coastguard Agency",
        "Medicines and Healthcare Products Regulatory Agency",
        "Met Office",
        "Ministry of Defence",
        "Ministry of Justice",
        "National Crime Agency",
        "National Infrastructure Commission",
        "National Records of Scotland",
        "National Records of Scotland",
        "National Savings and Investments",
        "Northern Ireland Office",
        "Office for Budget Responsibility",
        "Office for National Statistics",
        "Office for Standards in Education, Children's Services and Skills",
        "Office of Qualifications and Examinations Regulation",
        "Office of Rail and Road",
        "Office of the Advocate General for Scotland",
        "Office of the Public Guardian",
        "Office of the Secretary of State for Scotland",
        "Office of the Secretary of State for Wales",
        "OFGEM",
        "Ofwat (Water Services Regulation Authority)",
        "Planning Inspectorate",
        "Queen Elizabeth II Conference Centre",
        "Registers of Scotland",
        "Revenue Scotland",
        "Rural Payments Agency",
        "Science and Advice for Scottish Agriculture",
        "Scottish Courts and Tribunals Service",
        "Scottish Fiscal Commission",
        "Scottish Forestry",
        "Scottish Government",
        "Scottish Prison Service",
        "Scottish Public Pensions Agency",
        "Serious Fraud Office",
        "Social Security Scotland",
        "Student Awards Agency",
        "The National Archives",
        "The Supreme Court of the United Kingdom",
        "Transport Scotland",
        "UK Debt Management Office",
        "UK Export Finance",
        "UK Hydrographic Office",
        "UK Space Agency",
        "UK Statistics Authority",
        "Valuation Office Agency",
        "Vehicle Certification Agency",
        "Veterinary Medicines Directorate",
        "Welsh Government",
        "Welsh Revenue Authority",
        "Wilton Park"
      )
    )

object REDEPLOYMENT_SHORT_FORM_DIVERSITY_MONITORING
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

object REDEPLOYMENT_SHORT_FORM_DECLARATION
    extends DeclarationDetails(
      true
    )
