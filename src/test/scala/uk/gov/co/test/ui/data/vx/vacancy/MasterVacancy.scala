package uk.gov.co.test.ui.data.vx.vacancy

import uk.gov.co.test.ui.flows.vx.NewVacancyFlow.{contactEmailVxConfig, contactNameVxConfig}
import uk.gov.co.test.ui.pages.v9.SignInPage.generateRandomJobPosition
import uk.gov.co.test.ui.pages.vx.createvacancypage._

import scala.collection.mutable.ListBuffer

object MASTER_VACANCY_DATA
    extends NewVacancyDetails(
      MASTER_BASIC_DETAILS,
      MASTER_JOB_INFORMATION,
      MASTER_APPROACH,
      MASTER_APPROVAL,
      MASTER_RESERVE_LIST,
      MASTER_LOCATIONS,
      MASTER_CONTRACT_DETAILS,
      MASTER_ADVERT,
      MASTER_CONTACT_DETAILS,
      MASTER_VETTING_DETAILS,
      MASTER_INTERVIEWS_DETAILS,
      MASTER_SUCCESS_PROFILES,
      MASTER_VACANCY_TESTS,
      MASTER_ADDITIONAL_QUESTIONS,
      MASTER_CRITERIA,
      MASTER_MANAGEMENT,
      MASTER_ONLINE_PEC_CHECK_FORMS,
      MASTER_PEC_CHECK_FORMS
    )

object MASTER_BASIC_DETAILS
    extends BasicDetails(
      "DO NOT USE- Automation Test Template",
      s"HMRC - " + generateRandomJobPosition(),
      true,
      "Prawf awtomeiddio",
      32
    )
object MASTER_JOB_INFORMATION
    extends JobInfoDetails(
      true,
      "HM Revenue and Customs",
      "HMRC - CCG - Strategy",
      true,
      "Prawf awtomeiddio",
      "Autotest - Business area detail",
      typeOfRole = ListBuffer(
        "Accountancy",
        "Analytical",
        "Audit",
        "Corporate Finance",
        "Engineering",
        "Tax Profession"
      ),
      "Other",
      "3"
    )
object MASTER_APPROACH
    extends ApproachDetails(
      "External",
      true,
      "Autotest - Eligibility statement",
      true,
      "Prawf awtomeiddio",
      "This vacancy is open to employees who already hold the substantive grade for the post and were appointed to the Civil Service on merit following a fair and open competition; or were appointed to a permanent Civil Service post through an exception in the Civil Service Commissioners’ rules."
    )
object MASTER_APPROVAL
    extends ApprovalDetails(
      true,
      "Autotest - budgetary authorisation info",
      "Autotest - Cost centre (optional)",
      "Test-T&Cs.pdf"
    )

object MASTER_RESERVE_LIST
    extends ReserveListDetails(
      true,
      "12 Months",
      false,
      "6 Months"
    )

object MASTER_LOCATIONS
    extends LocationsDetails(
      "Postcodes",
      "M1 4RJ",
      "Manchester",
      "North West",
      "Germany",
      "Newcastle, Liverpool, Cardiff",
      true,
      true,
      "All communities",
      true,
      "3",
      otherLocations = ListBuffer("London", "Southampton", "Manchester")
    )

object MASTER_CONTRACT_DETAILS
    extends ContractDetails(
      List("Permanent", "Temporary", "Loan", "Secondment", "Returner"),
      "Autotest - Maximum characters: 255. Any text over this limit will not show on the advert.",
      true,
      "Prawf awtomeiddio",
      List("Full-time", "Part-time", "Compressed Hours", "Flexible working", "Homeworking"),
      "Senior Executive Officer",
      "Grade 7",
      "GBP (£)",
      75000,
      95000,
      "Can agree on the higher bracket",
      true,
      18750
    )

object MASTER_ADVERT
    extends AdvertDetails(
      "Autotest - Have you got experience logging antiques, artwork, and artefacts?  \n\nDo you care about building conservation?  \n\nAre you comfortable leading on Heritage open days? \n\nThis is unique, but if you’ve answered yes, then maybe you should think about the position of Heritage Lead with HMRC. \n\nWe are looking for someone to join our Estates team in Liverpool as our Heritage Lead. We need someone who will protect the integrity of listed features and ensure maintenance and proposed changes are delivered in accordance with the conservation management plan.\n\nAlthough this role is within HMRC, this role means you’ll build relationships with, and work alongside local Council Heritage Officers, you’ll be working with Historic England, and you’ll be leading on Heritage Open days. The open days are unique in that they raise the profile of HMRC, but they also demonstrate our conservation credentials and where we work.\n\nSee what it’s like to work at HMRC: find out more about us or ask our colleagues a question. Questions relating to an individual application must be emailed as detailed later in this advert.",
      "Autotest - Our Heritage Lead interacts with a breadth of individuals across the business and externally, these can include projects teams within HMRC, external suppliers, Health and Safety Managers and Council Officers. \n\nWe are looking for you to be a key decision maker within our estate team, not only able to identify any risks but also manage any mitigating actions to resolve them. We also ask you to contribute to the planning and delivery of any targets and objectives in order to meet HMRC estates targets and priorities that ensure the preservation of heritage features. \n\nCustomer Service is at the heart of everything we do. You’ll be collaborating with the other parts of our Estates team as well as the Local Council to ensure we are providing a seamless service to our customers. The service we provide also relies on our supplier performance, and you’ll be assessing their performance against the agreed KPI’s and Conservation Management Plan. We want you to ensure SMART development and compliance of current and future FM service delivery plans in relation to heritage commitments.",
      "Autotest - As our Heritage Lead, some of your responsibilities will include: \n\nProvide a proactive local interface with hard and soft FM suppliers and landlords in relation to Heritage requirements.\nMaintain a comprehensive log of antiques, art works and artefacts ensuring items are cleaned and maintained appropriately.\nAssure hard and soft FM supplier and landlord performance meets Conservation Management Plan requirements.\nGather data and produce detailed proposals for changes required due to Health & Safety that impact Heritage features.\nChair meetings and negotiate changes with Council Heritage Officer.\nAct as SPOC for HMRC with Council Heritage Officer, HMRC Suppliers and Contractors with respect to Estates heritage issues.\nReview Minor New Works to ensure they are delivered in accordance with Conservation Management Plan.\nReview projects to ensure they are delivered in accordance with Conservation Management Plan. \nCollate and inform appropriate management information to enable the effective management of Conservation obligations.\nIdentify, mitigate and manage customer service and risks to heritage features.\nDemonstrate HMRC’s commitment to Heritage through robust planning and assurance.\nApply contract incentives and sanctions within delegation and make recommendations to the Area Head of Facilities Management.\n\nThe post holder may be required to take an active leadership role to support the wider Workplace Operations team in Liverpool and locations within the Liverpool Region, and carry out tasks relevant towards the day to day running of the Estate, and any other task directed by Head of Estate. \n\nEssential Criteria\n\nClear demonstration of building management skills in both meeting customer needs and managing supplier relationships.\nDemonstration of strong customer relationship management and customer service ethos.\nUnderstanding key performance related schedules within contracts including assurance of KPIs/SLA’s.\n\nDesirable Criteria \n\nExperience of working in a heritage environment.\nExperience of applications for listed buildings and those within a conservation area.\nIWFM Certificate Level 4 or equivalent is desirable (or a commitment to complete this within 24 months of take up duty).",
      "Autotest - Learning and development tailored to your role\nAn environment with flexible working options\nA culture encouraging inclusion and diversity\nA Civil Service pension with an average employer contribution of 27%\n\nFind more about HMRC benefits in 'Your little extras and big benefits handbook' for further information or visit Thinking of joining the Civil Service.",
      "Autotest - How to Apply\n\nAs part of the application process you will be asked to complete a CV and 500-word Personal Statement.\n\nFurther details around what this will entail are listed on the application form.\n\nYour CV will be used for information only and will not be scored.\n\nYour Personal Statement should be used to describe how your skills and experience would be suitable for the advertised role, making reference to the essential criteria and person specification outlined in the advert.\n\nThe sift will be carried out against the Personal Statement, with the successful candidates being invited to interview.\n\nDuring the panel interview, your experience will be assessed and you will be asked behaviour-based questions to explore in detail what you are capable of. You will also be asked strength-based questions to explore what you enjoy and your motivations relevant to the job role.\n\nA Technical presentation will be required on GPP Professional technical expertise.\n\nWe reserve the right to raise the score required at any stage of the process in order to manage numbers.\n\nInterview dates to be confirmed.\n\nA reserve list may be held for a period of up to 12 months from which further appointments may be made for the same or similar roles – if this applies to you, we’ll let you know via your Civil Service Jobs account.\n\nEligibility\n\nTo check that you are eligible to apply, review this eligibility information\n\nDue to operational needs, these posts are full-time; however applicants who need to work a more flexible arrangement are welcome to apply. We can’t guarantee that we can meet all requests to work flexibly, as agreement will be subject to business ability to accommodate, and any request to work a more flexible arrangement should be made prior to your acceptance of the provisional offer.\n\nImportant information for existing HMRC contractual homeworkers\n\nPlease note that this role is unsuitable for contractual homeworkers due to the nature and/or requirements of the role.\n\nReasonable Adjustments \n\nWe want to make sure no one is put at a disadvantage during our recruitment process because of a disability, condition, or impairment. To assist you with this, we will reduce or remove any barriers where possible and provide additional support where appropriate. \n\nIf you need a reasonable adjustment or a change to be made so that you can make your application, review this information on reasonable adjustments, and contact hmrcrecruitment.grs@cabinetoffice.gov.uk as soon as possible.\n\nDiversity and Inclusion\n\nAt HMRC we are committed to creating a great place to work for all our colleagues and creating an inclusive and respectful environment that reflects the diversity of the society we serve.\n\nDiverse perspectives and experiences are critical to our success and we welcome applications from all people from all backgrounds with the experience and skills needed to perform this role. We’re committed to creating a great place to work for all our colleagues here at HMRC. We want everyone to feel valued and supported to achieve their potential at HMRC.\n\nFor more information on how we make this happen, review this information on our culture and values\n\nApplications received from candidates with a criminal record are considered fairly in accordance with the DBS Code of Practice and the Recruitment of ex-offenders Policy.\n\nWe welcome applications from those who need to work a more flexible arrangement and will agree to requests where possible after considering operational and customer service needs. We can’t guarantee that we can meet all requests to work flexibly, as agreement will be subject to business ability to accommodate, and any request to work a more flexible arrangement should be made prior to your acceptance of the provisional offer.\n\nCustomer facing roles in HMRC require the ability to converse at ease with members of the public and provide advice in accurate spoken English and/or Welsh where required. Where this is an essential requirement, this will be tested as part of the selection process. \n\nThe Civil Service runs a Disability Confident Scheme (DCS) for candidates with disabilities who meet the minimum selection criteria.\n\nThe Civil Service also offers a Redeployment Interview Scheme to civil servants who are at risk of redundancy, and who meet the minimum requirements for the advertised vacancy. \n\nLocations \n\nHMRC has a presence in every region of the UK. For more information on where you might be working, review this information on our locations.\n\nSecurity Update\n\nFor more information on the level of security checks we will carry out, review this information on security checks\n\nPlease note: in addition to the standard pre-employment checks for appointment into the Civil Service, all candidates must also obtain National Security Vetting at Security Check (SC) clearance level for this vacancy. You will normally need to meet the minimum UK residency period as determined by the level of vetting being undertaken, which for SC is 5 years UK residency prior to your vetting application. If you have any questions about this residency requirement, please speak to the vacancy holder for this post.\n\nFurther Information\n\nThe Civil Service values honesty and integrity and expects all candidates to abide by these principles. The evidence you provide in your application must relate to your own experiences.\n\nAny instances of plagiarism or other forms of cheating will be investigated and, if proven, the relevant application/s will be withdrawn from the process. \n\nDuplicate applications for the same vacancy will also be withdrawn.\n\nTransferring into HMRC from Civil Service If you are currently working for an ‘Other Government Department’ (OGD) and would like to consider the impact on your pay when joining HMRC, please see the attached document \"Combined T&C and OGD Pay English”, found at the bottom of this advert. Further information on staff transfers can be found on gov.uk\n\nProblems during the application process \n\nIf you experience accessibility problems with any attachments on this advert, please contact the email address in the 'Contact point for applicants' section. \n\nIf you think you’ve made a mistake on a short application form (e.g. you’ve ticked the incorrect eligibility box), please contact hmrcrecruitment.grs@cabinetoffice.gov.uk at least two working days before the vacancy closes. After this, we won’t be able to reopen your application.   \n\nPlease use the subject line to insert appropriate wording e.g. Please re-open my application - 330023 & vacancy closing date 20/12/23. Please note that we cannot amend or re-open your application if you have submitted your full application in the interests of fair and open recruitment.\n\nFor reasonable adjustments queries or requests, please see details within reasonable adjustments section above."
    )

object MASTER_CONTACT_DETAILS
    extends ContactDetails(
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      "01000 000000",
      s"$contactNameVxConfig",
      s"$contactEmailVxConfig",
      s"$contactEmailVxConfig"
    )

object MASTER_VETTING_DETAILS
    extends VettingDetails(
      true,
      "Basic",
      "Disclosure barring service (DBS)",
      "Security check",
      true
    )

object MASTER_INTERVIEWS_DETAILS
    extends InterviewsDetails(
      "4",
      "Telephone",
      "Assessment",
      "Video",
      "Interview",
      false
    )

object MASTER_SUCCESS_PROFILES
    extends SuccessProfilesDetails(
      true,
      true,
      true,
      true,
      true,
      Some(MASTER_ABILITIES),
      Some(MASTER_BEHAVIOURS),
      Some(MASTER_EXPERIENCES),
      Some(MASTER_STRENGTHS),
      Some(MASTER_TECH_SKILLS)
    )

object MASTER_ABILITIES
    extends AbilitiesDetails(
      """The following online tests can be used to assess abilities:
                           |Civil Service Numerical Test
                           |Civil Service Verbal Test""".stripMargin
    )

object MASTER_BEHAVIOURS
    extends BehavioursDetails(
      assessBehaviours = """The following online tests can be used to assess behaviours:
          |Civil Service Judgement Test
          |Civil Service Management Judgement Test""".stripMargin,
      8,
      behaviourOne =
        Some(Behaviours(chosenBehaviour = "Changing and Improving", stageApplication = true, stageInterview = true)),
      behaviourTwo = Some(
        Behaviours(chosenBehaviour = "Communicating and Influencing", stageApplication = true, stageInterview = true)
      ),
      behaviourThree =
        Some(Behaviours(chosenBehaviour = "Delivering at Pace", stageApplication = true, stageInterview = true)),
      behaviourFour = Some(
        Behaviours(chosenBehaviour = "Developing Self and Others", stageApplication = true, stageInterview = true)
      ),
      behaviourFive = Some(Behaviours(chosenBehaviour = "Leadership", stageApplication = true, stageInterview = true)),
      behaviourSix = Some(
        Behaviours(chosenBehaviour = "Making Effective Decisions", stageApplication = true, stageInterview = true)
      ),
      behaviourSeven = Some(
        Behaviours(chosenBehaviour = "Managing a Quality Service", stageApplication = true, stageInterview = true)
      ),
      behaviourEight = Some(
        Behaviours(chosenBehaviour = "Working Together", stageApplication = true, stageInterview = true)
      )
    )

object MASTER_EXPERIENCES
    extends ExperienceDetails(
      true,
      "0 - 100",
      true,
      true,
      true,
      true,
      "0 - 7",
      250,
      true,
      "Autotest - Enter guidance text for the candidate",
      true,
      "Autotest - Specific past experience/skills",
      licences =
        Some(MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific licence requirements")),
      memberships = Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific memberships requirements")
      ),
      languages = Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific language requirements")
      ),
      qualifications = Some(
        MandatoryRequirements(requirements = true, requirementsInfo = "Autotest - Specific qualification requirements")
      )
    )

object MASTER_STRENGTHS
    extends StrengthsDetails(
      8,
      "Adaptable",
      "Analytical",
      "Improver",
      "Relationship Builder",
      "Challenger",
      "Change Agent",
      "Team Leader",
      "Service Focussed"
    )

object MASTER_TECH_SKILLS
    extends TechSkillsDetails(
      8,
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 1",
          description = "Autotest - technical skills 1 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 2",
          description = "Autotest - technical skills 2 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 3",
          description = "Autotest - technical skills 3 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 4",
          description = "Autotest - technical skills 4 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 5",
          description = "Autotest - technical skills 5 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 6",
          description = "Autotest - technical skills 6 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 7",
          description = "Autotest - technical skills 7 description",
          techInterview = true,
          techApplication = true
        )
      ),
      Some(
        TechSkills(
          techSkill = "Autotest - technical skills 8",
          description = "Autotest - technical skills 8 description",
          techInterview = true,
          techApplication = true
        )
      )
    )

object MASTER_VACANCY_TESTS
    extends VacancyTestsDetails(
      true, //only part on master vacancy set to false!
      "Online Tests",
      "Executive Officer",
      testName = Map(
        "Administrative Assistant" -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Work Strengths Test",
          "Customer Service Skills Test"
        ),
        "Administrative Officer"   -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Work Strengths Test",
          "Casework Skills Test",
          "Customer Service Skills Test"
        ),
        "Executive Officer"        -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Management Judgement Test",
          "Civil Service Work Strengths Test",
          "Casework Skills Test",
          "Customer Service Skills Test"
        ),
        "Higher Executive Officer" -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Management Judgement Test",
          "Civil Service Work Strengths Test"
        ),
        "Senior Executive Officer" -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Management Judgement Test",
          "Civil Service Work Strengths Test"
        ),
        "Grade 7 "                 -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Judgement Test",
          "Civil Service Work Strengths Test"
        ),
        "Grade 6"                  -> List(
          "Civil Service Numerical Test",
          "Civil Service Verbal Test",
          "Civil Service Work Strengths Test"
        )
      ),
      true,
      "Autotest - Additional details for the recruitment team",
      Some(MASTER_RECRUITER_TESTS),
      Some(MASTER_GROUP_A_TESTS),
      Some(MASTER_GROUP_B_TESTS),
      Some(MASTER_GROUP_C_TESTS)
    )

object MASTER_RECRUITER_TESTS
    extends RecruiterTestsDetails(
      "After the tests",
      "Auto-progress after each test",
      true,
      true,
      "Autotest - Online test instructions"
    )

object MASTER_GROUP_A_TESTS
    extends GroupATestsDetails(
      "First",
      "Three",
      "Civil Service Numerical Test",
      "Civil Service Verbal Test",
      "New Civil Service Judgement Test",
      7
    )

object MASTER_GROUP_B_TESTS
    extends GroupBTestsDetails(
      "Second",
      "Two",
      "Civil Service Work Strengths Test",
      "Civil Service Management Judgement Test",
      5
    )

object MASTER_GROUP_C_TESTS
    extends GroupCTestsDetails(
      "Third",
      "Two",
      "Customer Service Skills Test",
      "Casework Skills Test",
      3
    )

object MASTER_ADDITIONAL_QUESTIONS
    extends AdditionalQuestionsDetails(
      true,
      3,
      "Autotest - Question 1",
      "Autotest - Question 2",
      "Autotest - Question 3"
    )

object MASTER_CRITERIA
    extends CriteriaDetails(
      campaignID = Some("Autotest - If this vacancy is linked to a campaign, enter the campaign ID (optional)"),
      probationIncomplete = true,
      promotionApply = true,
      misconductLive = true,
      performanceReview = true,
      attendancePoor = true,
      nationalityRequirements = true,
      rightToRemainUK = true,
      licencesNotHeld = true,
      membershipsNotHeld = true,
      languagesSkillsNotHeld = true,
      qualificationsHeld = true,
      preSiftRequired = true,
      uploadAttachment = true,
      candidateInstructions = "Autotest - Instructions for candidate"
    )

object MASTER_MANAGEMENT
    extends ManagementDetails(
      true,
      false,
      "Other",
      true,
      assignTo = Option(s"$contactEmailVxConfig"),
      assignTo2 = Option(s"$contactEmailVxConfig"),
      true,
      "Business As Usual (BAU)",
      "Menu",
      true,
      true,
      linkToProject = Option(true),
      projectName = Option("Autotest - Project name"),
      deptComplaintsProcess = Option("Autotest - Your department's complaints process"),
      vacancyComments = Option("Autotest - Comments on this vacancy")
    )

object MASTER_ONLINE_PEC_CHECK_FORMS
    extends OnlinePecCheckFormsDetails(
      true,
      true,
      s"$contactEmailVxConfig"
    )

object MASTER_PEC_CHECK_FORMS
    extends PecCheckFormsDetails(
      rtwCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Before pre employment checks",
      "Right to work and criminal record check",
      true,
      "Autotest - Details of the identity documents the candidate needs to provide",
      false,
      generalInfo = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      referenceChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      bankruptcyChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      crcChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      nsvChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      jobHistoryChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      healthRefChecks = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      "Show recruiter and candidate forms",
      overseasCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      pensionsCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      previousCsJobCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      internalFraudCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      selfEmploymentCheck = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      true,
      true,
      "Autotest - Name of check",
      additionalCheck = List("Not Applicable"),
      nenOnboarding = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      s"$contactEmailVxConfig",
      pnOnboarding = List("Internal Candidates", "External Candidates", "OGD Candidates", "NDPB Candidates"),
      s"$contactEmailVxConfig"
    )
