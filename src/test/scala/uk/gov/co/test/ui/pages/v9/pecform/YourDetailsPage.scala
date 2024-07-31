package uk.gov.co.test.ui.pages.v9.pecform

import org.openqa.selenium.By
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{randomFirstName, randomLastName, v9CivilServant, v9HomeDepartment, v9RunInWelsh, vXJobInfoDepartment, vXTypeOfCandidate}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage

case class YourDetails(
  candidateTitle: String,
  haveNino: Boolean,
  nino: String,
  ninoApplicationStatus: String,
  dob: String,
  gender: String,
  maritalStatus: String,
  homeOfficeStartCS: String,
  homeOfficeEmployedUnder: String,
  homeOfficeOnPromotion: Boolean,
  homeOfficeCurrentGrade: String,
  addressLineOne: String,
  addressLineTwo: Option[String] = None,
  cityOrTown: String,
  county: String,
  country: String,
  postcode: String,
  preferredTeleNo: String
)

object YourDetailsPage extends CivilServiceJobsBasePage {

  private lazy val yourDetailsPageTitle      = "Your Details - Civil Service Jobs - GOV.UK"
  private lazy val welshYourDetailsPageTitle = "Eich manylion - Civil Service Jobs - GOV.UK"
  private lazy val formIdPath                = ".//form[@enctype='multipart/form-data']"
  def titleHeaderId                          = s"${pecFormId}_field_que_114326_1"
  def titleId                                = s"${pecFormId}_datafield_114326_1_1"
  def firstNameHeaderId                      = s"${pecFormId}_label_86431_1"
  def firstNamePath                          = s"//*[@id='$firstNameHeaderId']/div/p"
  def lastNameHeaderId                       = s"${pecFormId}_label_86442_1"
  def lastNamePath                           = s"//*[@id='$lastNameHeaderId']/div/p"
  def ninoHeaderId                           = s"${pecFormId}_field_que_100924_1"
  def ninoYesHeaderId                        = s"${pecFormId}_field_que_76705_1"
  def ninoYesId                              = s"${pecFormId}_datafield_100924_1_1_1_label"
  def ninoNoHeaderId                         = s"${pecFormId}_field_que_100928_1"
  def ninoNoId                               = s"${pecFormId}_datafield_100924_1_1_2_label"
  def ninoYesInputId                         = s"${pecFormId}_datafield_76705_1_1"
  def ninoNoInputId                          = s"${pecFormId}_datafield_100928_1_1"
  def provideNinoApplicationTextPath         = s"//*[@id='${pecFormId}_field_que_100928_1']/span[1]/p"
  def dobHeaderId                            = s"${pecFormId}_field_que_76711_1"
  def dobDayId                               = s"${pecFormId}_datafield_76711_1_1--DAY"
  def dobMonthId                             = s"${pecFormId}_datafield_76711_1_1--MONTH"
  def dobYearId                              = s"${pecFormId}_datafield_76711_1_1--YEAR"
  def genderHeaderId                         = s"${pecFormId}_field_que_141013_1"
  def genderId                               = s"${pecFormId}_datafield_141013_1_1"
  def maritalStatusHeaderId                  = s"${pecFormId}_field_que_76771_1"
  def maritalStatusNotSayId                  = s"${pecFormId}_datafield_76771_1_1_15183_label"
  def maritalStatusMarriedId                 = s"${pecFormId}_datafield_76771_1_1_15181_label"
  def maritalStatusSingleId                  = s"${pecFormId}_datafield_76771_1_1_15182_label"
  def homeOfficeStartCSDayId                 = s"${pecFormId}_datafield_166540_1_1--DAY"
  def homeOfficeStartCSMonthId               = s"${pecFormId}_datafield_166540_1_1--MONTH"
  def homeOfficeStartCSYearId                = s"${pecFormId}_datafield_166540_1_1--YEAR"
  def homeOfficeModernisedId                 = s"${pecFormId}_datafield_166544_1_1_45080_label"
  def homeOfficePreModernisedId              = s"${pecFormId}_datafield_166544_1_1_45081_label"
  def homeOfficeOnPromotionYesId             = s"${pecFormId}_datafield_166536_1_1_1_label"
  def homeOfficeOnPromotionNoId              = s"${pecFormId}_datafield_166536_1_1_2_label"
  def homeOfficeCurrentGradeId               = s"${pecFormId}_datafield_166548_1_1"
  def homeOfficeWhichOrgId                   = s"${pecFormId}_datafield_166552_1_1"
  def homeAddressHeaderId                    = s"${pecFormId}_label_168686_1"
  def homeAddressSubHeaderPath               = "//span[@style='color: #6f777b;']"
  def addressLineOneHeaderId                 = s"${pecFormId}_field_que_76789_1"
  def addressLineTwoHeaderId                 = s"${pecFormId}_field_que_76795_1"
  def cityOrTownHeaderId                     = s"${pecFormId}_field_que_76779_1"
  def countyHeaderId                         = s"${pecFormId}_field_que_76807_1"
  def countryHeaderId                        = s"${pecFormId}_field_que_123207_1"
  def postcodeHeaderId                       = s"${pecFormId}_field_que_76801_1"
  def addressLineOneId                       = s"${pecFormId}_datafield_76789_1_1"
  def addressLineTwoId                       = s"${pecFormId}_datafield_76795_1_1"
  def cityTownId                             = s"${pecFormId}_datafield_76779_1_1"
  def countyId                               = s"${pecFormId}_datafield_76807_1_1"
  def countryId                              = s"${pecFormId}_datafield_123207_1_1"
  def postcodeId                             = s"${pecFormId}_datafield_76801_1_1"
  def preferredTeleNoHeaderId                = s"${pecFormId}_field_que_76821_1"
  def wordStylePath               = ".//p[@style='font-weight:bold;color:black;']"
  def preferredTeleNoId                      = s"${pecFormId}_datafield_76821_1_1"
  def boldBlackTextStyle                     = "font-weight:bold;color:black;"
  var pecFormId                              = ""

  private def yourDetailsPageCheck(): Unit =
    if (!v9RunInWelsh) eventually(onPage(yourDetailsPageTitle))
    else eventually(onPage(welshYourDetailsPageTitle))

  private def extractAppFormId(): String = {
    val formClass = driver.findElement(By.xpath(formIdPath))
    pecFormId = formClass.getAttribute("id")
    pecFormId
  }

  private def selectCandidateTitle(yourDetails: YourDetails): Unit = {
    if (!v9RunInWelsh) {
      waitForVisibilityOfElementById(titleHeaderId).getText shouldEqual "Title"
      selectDropdownOption(titleId, yourDetails.candidateTitle)
    } else {}
    confirmNames()
  }

  private def confirmNames(): Unit = {
    if (!v9RunInWelsh) {
      waitForVisibilityOfElementById(firstNameHeaderId).getText startsWith "First name:"
      waitForVisibilityOfElementById(firstNameHeaderId).getText startsWith "Last name:"
    }
    waitForVisibilityOfElementByPath(firstNamePath).getText shouldEqual randomFirstName
    waitForVisibilityOfElementByPath(lastNamePath).getText  shouldEqual randomLastName
  }


  private def selectNino(yourDetails: YourDetails): Unit = {
    val ninoHeader = waitForVisibilityOfElementById(ninoHeaderId).getText
    if (yourDetails.haveNino) {
      radioSelect(ninoYesId)
      enterDetails(ninoYesInputId, yourDetails.nino)
      if (!v9RunInWelsh) {
        ninoHeader shouldEqual "Do you have a National Insurance number?"
        waitForVisibilityOfElementById(ninoYesHeaderId).findElement(By.xpath(wordStylePath)).getText shouldEqual "National insurance number"
        waitForVisibilityOfElementById(ninoYesHeaderId).getText should endWith("It's on your National Insurance Card, Benefit letter, payslip or P60. For example, 'QQ123456C'.")
      } else {
        ninoHeader shouldEqual ""
        waitForVisibilityOfElementById(ninoYesHeaderId).findElement(By.xpath(wordStylePath)).getText shouldEqual ""
        waitForVisibilityOfElementById(ninoYesHeaderId).getText should endWith("")
      }
    } else {
      radioSelect(ninoNoId)
      enterDetails(ninoNoInputId, yourDetails.ninoApplicationStatus)
      val noNinoDetails = waitForVisibilityOfElementById(ninoNoHeaderId)
      noNinoDetails.findElement(By.xpath(".//a")).getAttribute("href").endsWith("www.gov.uk/apply-national-insurance-number")
      if (!v9RunInWelsh) {
        ninoHeader shouldEqual "Do you have a National Insurance number?"
        noNinoDetails.findElement(By.xpath(wordStylePath)).getText shouldEqual "Provide details on your national insurance number application status"
        waitForVisibilityOfElementById(ninoNoHeaderId).getText should endWith("""If you have not yet applied for a national insurance number, you will need to begin an application to get one. Apply for a National Insurance number (opens in a new window)""".stripMargin)
      } else {
        ninoHeader shouldEqual ""
        waitForVisibilityOfElementById(ninoNoHeaderId).findElement(By.xpath(wordStylePath)).getText shouldEqual ""
        waitForVisibilityOfElementById(ninoNoHeaderId).getText should endWith("")
      }
    }
  }



  private def enterDob(yourDetails: YourDetails): Unit = {
    val dobHeader          = waitForVisibilityOfElementById(dobHeaderId).getText
    if (!v9RunInWelsh) {
      dobHeader shouldEqual "Date of birth"
    } else dobHeader shouldEqual ""
    val (day, month, year) = splitDate(yourDetails.dob)
    enterDate(dobDayId, day)
    enterDate(dobMonthId, month)
    enterDate(dobYearId, year)
  }

  private def selectGender(yourDetails: YourDetails): Unit = {
    val genderHeader = waitForVisibilityOfElementById(genderHeaderId).getText
    if (!v9RunInWelsh) {
      genderHeader shouldEqual "Gender"
      selectDropdownOption(genderId, yourDetails.gender)
    } else {
      genderHeader shouldEqual ""
      selectDropdownOption(genderId, "Dyn")
    }
  }

  private def selectMaritalStatus(yourDetails: YourDetails): Unit = {
    val maritalStatusHeader = waitForVisibilityOfElementById(maritalStatusHeaderId).getText
    if (!v9RunInWelsh) {
      maritalStatusHeader shouldEqual "Marital status"
      yourDetails.maritalStatus match {
        case "Prefer not to say" => radioSelect(maritalStatusNotSayId)
        case "Married"           => radioSelect(maritalStatusMarriedId)
        case "Single"            => radioSelect(maritalStatusSingleId)
      }
    } else {
      maritalStatusHeader shouldEqual ""
      yourDetails.maritalStatus match {
        case "Prefer not to say" => radioSelect(maritalStatusNotSayId)
        case "Married"           => radioSelect(maritalStatusMarriedId)
        case "Single"            => radioSelect(maritalStatusSingleId)
      }
    }
  }

  private def completeHomeOfficeOgdQuestions(yourDetails: YourDetails): Unit =
    if (v9CivilServant && vXJobInfoDepartment == "Home Office" && vXTypeOfCandidate == "OGD") {
      enterHomeOfficeStartCS(yourDetails)
      selectHomeOfficeEmployedUnder(yourDetails)
      selectHomeOfficeOnPromotion(yourDetails)
      selectHomeOfficeCurrentGrade(yourDetails)
      selectHomeOfficeWhichOrg(yourDetails)
    }

  private def enterHomeOfficeStartCS(yourDetails: YourDetails): Unit = {
    val (day, month, year) = splitDate(yourDetails.homeOfficeStartCS)
    enterDate(homeOfficeStartCSDayId, day)
    enterDate(homeOfficeStartCSMonthId, month)
    enterDate(homeOfficeStartCSYearId, year)
  }

  private def selectHomeOfficeEmployedUnder(yourDetails: YourDetails): Unit =
    yourDetails.homeOfficeEmployedUnder match {
      case "Modernised"     => radioSelect(homeOfficeModernisedId)
      case "Pre-modernised" => radioSelect(homeOfficePreModernisedId)
    }

  private def selectHomeOfficeOnPromotion(yourDetails: YourDetails): Unit =
    if (yourDetails.homeOfficeOnPromotion) radioSelect(homeOfficeOnPromotionYesId)
    else radioSelect(homeOfficeOnPromotionNoId)

  private def selectHomeOfficeCurrentGrade(yourDetails: YourDetails): Unit =
    selectDropdownOption(homeOfficeCurrentGradeId, yourDetails.homeOfficeCurrentGrade)

  private def selectHomeOfficeWhichOrg(yourDetails: YourDetails): Unit =
    selectDropdownOption(homeOfficeWhichOrgId, v9HomeDepartment)

  private def enterHomeAddress(yourDetails: YourDetails): Unit = {
    val homeAddressHeader    =
      waitForVisibilityOfElementById(homeAddressHeaderId).findElement(By.tagName("strong"))
    val homeAddressSubHeader = homeAddressHeader.findElement(By.xpath(homeAddressSubHeaderPath)).getText
    val addressLineOneHeader = waitForVisibilityOfElementById(addressLineOneHeaderId).getText
    val addressLineTwoHeader = waitForVisibilityOfElementById(addressLineTwoHeaderId).getText
    val cityOrTownHeader     = waitForVisibilityOfElementById(cityOrTownHeaderId).getText
    val countyHeader         = waitForVisibilityOfElementById(countyHeaderId).getText
    val countryHeader        = waitForVisibilityOfElementById(countryHeaderId).getText
    if (!v9RunInWelsh) {
      homeAddressHeader.getText shouldEqual "What is your home address?"
      homeAddressSubHeader      shouldEqual "This must be your current personal address, and not your employer’s address."
      addressLineOneHeader      shouldEqual "Address line 1"
      addressLineTwoHeader      shouldEqual "Address line 2 (Optional)"
      cityOrTownHeader          shouldEqual "City/Town"
      countyHeader              shouldEqual "County"
      countryHeader             shouldEqual "Country"
      selectDropdownOption(countryId, yourDetails.country)
    } else {
      homeAddressHeader.getText shouldEqual ""
      homeAddressSubHeader      shouldEqual ""
      addressLineOneHeader      shouldEqual ""
      addressLineTwoHeader      shouldEqual ""
      cityOrTownHeader          shouldEqual ""
      countyHeader              shouldEqual ""
      countryHeader             shouldEqual ""
      selectDropdownOption(countryId, "Y Deyrnas Unedig")
    }
    enterDetails(addressLineOneId, yourDetails.addressLineOne)
    enterDetails(addressLineTwoId, yourDetails.addressLineTwo.get)
    enterDetails(cityTownId, yourDetails.cityOrTown)
    enterDetails(countyId, yourDetails.county)
    enterPostcode(yourDetails)
  }

  private def enterPostcode(yourDetails: YourDetails): Unit =
    if (yourDetails.country == "United Kingdom") {
      val postcodeHeader = waitForVisibilityOfElementById(postcodeHeaderId).getText
      if (!v9RunInWelsh) {
        postcodeHeader shouldEqual "Postcode"
      } else {
        postcodeHeader shouldEqual ""
      }
      enterDetails(postcodeId, yourDetails.postcode)
    }

  private def enterPreferredTelephoneNo(yourDetails: YourDetails): Unit = {
    val preferredTeleHeader     = waitForVisibilityOfElementById(preferredTeleNoHeaderId)
    val preferredTeleMainHeader = preferredTeleHeader.findElement(By.xpath(wordStylePath)).getText
    if (!v9RunInWelsh) {
      preferredTeleMainHeader shouldEqual "Preferred telephone number"
      preferredTeleHeader.getText  should endWith(
        """For example, 01632 960 001, 07700 900 982 or +44 808 157 0192
          |
          |For numbers outside of the UK, include the country code.""".stripMargin
      )
    } else {
      preferredTeleMainHeader shouldEqual ""
      preferredTeleHeader.getText  should endWith("""""".stripMargin)
    }
    enterDetails(preferredTeleNoId, yourDetails.preferredTeleNo)
  }

  private val yourDetails: Seq[YourDetails => Unit] = Seq(
    selectCandidateTitle,
    selectNino,
    enterDob,
    selectGender,
    selectMaritalStatus,
    completeHomeOfficeOgdQuestions,
    enterHomeAddress,
    enterPreferredTelephoneNo
  )

  def yourDetailsPage(pecFormDetails: PecFormDetails): Unit = {
    yourDetailsPageCheck()
    extractAppFormId()
    yourDetails.foreach { f =>
      f(pecFormDetails.yourDetails)
    }
    clickOn(pageContinue)
  }
}
