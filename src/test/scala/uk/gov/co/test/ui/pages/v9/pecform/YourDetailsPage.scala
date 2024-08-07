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
  ninoApplicationState: String,
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
  def titleId                                = s"${pecFormId}_datafield_114326_1_1"
  def firstNamePath                          = s"//*[@id='${pecFormId}_label_86431_1']/div/p"
  def lastNamePath                           = s"//*[@id='${pecFormId}_label_86442_1']/div/p"
  def ninoYesId                              = s"${pecFormId}_datafield_100924_1_1_1_label"
  def ninoNoId                               = s"${pecFormId}_datafield_100924_1_1_2_label"
  def ninoYesInputId                         = s"${pecFormId}_datafield_76705_1_1"
  def ninoNoInputId                          = s"${pecFormId}_datafield_100928_1_1"
  def provideNinoApplicationTextPath         = s"//*[@id='${pecFormId}_field_que_100928_1']/span[1]/p"
  def dobDayId                               = s"${pecFormId}_datafield_76711_1_1--DAY"
  def dobMonthId                             = s"${pecFormId}_datafield_76711_1_1--MONTH"
  def dobYearId                              = s"${pecFormId}_datafield_76711_1_1--YEAR"
  def genderId                               = s"${pecFormId}_datafield_141013_1_1"
  def maritalStatusNotSayId                  = s"${pecFormId}_datafield_76771_1_1_15183_label"
  def maritalStatusMarriedId                 = s"${pecFormId}_datafield_76771_1_1_15181_label"
  def maritalStatusSingleId                  = s"${pecFormId}_datafield_76771_1_1_15182_label"

  def homeOfficeStartCSDayId     = s"${pecFormId}_datafield_166540_1_1--DAY"
  def homeOfficeStartCSMonthId   = s"${pecFormId}_datafield_166540_1_1--MONTH"
  def homeOfficeStartCSYearId    = s"${pecFormId}_datafield_166540_1_1--YEAR"
  def homeOfficeModernisedId     = s"${pecFormId}_datafield_166544_1_1_45080_label"
  def homeOfficePreModernisedId  = s"${pecFormId}_datafield_166544_1_1_45081_label"
  def homeOfficeOnPromotionYesId = s"${pecFormId}_datafield_166536_1_1_1_label"
  def homeOfficeOnPromotionNoId  = s"${pecFormId}_datafield_166536_1_1_2_label"
  def homeOfficeCurrentGradeId   = s"${pecFormId}_datafield_166548_1_1"
  def homeOfficeWhichOrgId       = s"${pecFormId}_datafield_166552_1_1"

  def addressLineOneId  = s"${pecFormId}_datafield_76789_1_1"
  def addressLineTwoId  = s"${pecFormId}_datafield_76795_1_1"
  def cityTownId        = s"${pecFormId}_datafield_76779_1_1"
  def countyId          = s"${pecFormId}_datafield_76807_1_1"
  def countryId         = s"${pecFormId}_datafield_123207_1_1"
  def postcodeId        = s"${pecFormId}_datafield_76801_1_1"
  def preferredTeleNoId = s"${pecFormId}_datafield_76821_1_1"
  var pecFormId         = ""

  private def yourDetailsPageCheck(): Unit =
    if (v9RunInWelsh) eventually(onPage(welshYourDetailsPageTitle))
    else eventually(onPage(yourDetailsPageTitle))

  private def extractAppFormId(): String = {
    val formClass = driver.findElement(By.xpath(formIdPath))
    pecFormId = formClass.getAttribute("id")
    pecFormId
  }

  private def selectCandidateTitle(yourDetails: YourDetails): Unit = {
    selectDropdownOption(titleId, yourDetails.candidateTitle)
    confirmNames()
  }

  private def confirmNames(): Unit = {
    waitForVisibilityOfElementByPath(firstNamePath).getText shouldEqual randomFirstName
    waitForVisibilityOfElementByPath(lastNamePath).getText  shouldEqual randomLastName
  }

  private def selectNino(yourDetails: YourDetails): Unit =
    if (yourDetails.haveNino) {
      radioSelect(ninoYesId)
      enterDetails(ninoYesInputId, yourDetails.nino)
    } else {
      radioSelect(ninoNoId)
      enterDetails(ninoNoInputId, yourDetails.ninoApplicationState)
      val ninoApplication = waitForVisibilityOfElementByPath(provideNinoApplicationTextPath)
      ninoApplication.getText.contains("Apply for a National Insurance number (opens in a new window)")
      ninoApplication.getAttribute("href").endsWith("www.gov.uk/apply-national-insurance-number")
    }

  private def enterDob(yourDetails: YourDetails): Unit = {
    val (day, month, year) = splitDate(yourDetails.dob)
    enterDate(dobDayId, day)
    enterDate(dobMonthId, month)
    enterDate(dobYearId, year)
  }

  private def selectGender(yourDetails: YourDetails): Unit =
    if (v9RunInWelsh) selectDropdownOption(genderId, "Dyn")
    else selectDropdownOption(genderId, yourDetails.gender)

  private def selectMaritalStatus(yourDetails: YourDetails): Unit =
    yourDetails.maritalStatus match {
      case "Prefer not to say" => radioSelect(maritalStatusNotSayId)
      case "Married"           => radioSelect(maritalStatusMarriedId)
      case "Single"            => radioSelect(maritalStatusSingleId)
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
    enterDetails(addressLineOneId, yourDetails.addressLineOne)
    enterDetails(addressLineTwoId, yourDetails.addressLineTwo.get)
    enterDetails(cityTownId, yourDetails.cityOrTown)
    enterDetails(countyId, yourDetails.county)
    if (v9RunInWelsh) selectDropdownOption(countryId, "Y Deyrnas Unedig")
    else selectDropdownOption(countryId, yourDetails.country)
    enterDetails(postcodeId, yourDetails.postcode)
  }

  private def enterPreferredTelephoneNo(yourDetails: YourDetails): Unit =
    enterDetails(preferredTeleNoId, yourDetails.preferredTeleNo)

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
