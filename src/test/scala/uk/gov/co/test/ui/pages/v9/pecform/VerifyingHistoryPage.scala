package uk.gov.co.test.ui.pages.v9.pecform

import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXApproach, vXPecEmploymentHistoryCheck}
import uk.gov.co.test.ui.data.v9.pecform.PecFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.pecform.YourDetailsPage.pecFormId

case class VerifyingHistoryDetails(
  firstEmployerOrAcademic: Boolean,
  firstOtherTypeOfReferee: String,
  firstRefereeType: String,
  firstRefereeFullName: String,
  firstRefereeEmail: String,
  secondTypeOfReferee: String,
  secondOtherTypeOfReferee: String,
  secondRefereeFullName: String,
  secondRefereeEmail: String,
  thirdTypeOfReferee: String,
  thirdOtherTypeOfReferee: String,
  thirdRefereeFullName: String,
  thirdRefereeEmail: String
)

object VerifyingHistoryPage extends CivilServiceJobsBasePage {

  private lazy val verifyingHistoryPageTitle = "Verifying your history - Civil Service Jobs - GOV.UK"
  def threeRefereesDetailsTextId             = s"${pecFormId}_label_201876_1"
  def instructionsTextId                     = s"${pecFormId}_label_201880_1"
  def firstRefereeTitleId                    = s"${pecFormId}_label_201918_1"
  def firstEmployerOrAcademicYesId           = s"${pecFormId}_datafield_201930_1_1_1_label"
  def firstEmployerOrAcademicNoId            = s"${pecFormId}_datafield_201930_1_1_2_label"
  def firstOtherTypeOfRefereeInputId         = s"${pecFormId}_datafield_201937_1_1"
  def firstRefereeEmployerId                 = s"${pecFormId}_datafield_201934_1_1_52511_label"
  def firstRefereeAcademicId                 = s"${pecFormId}_datafield_201934_1_1_52512_label"
  def firstRefereeFullNameId                 = s"${pecFormId}_datafield_201943_1_1"
  def firstRefereeEmailId                    = s"${pecFormId}_datafield_201950_1_1"
  def secondRefereeTitleId                   = s"${pecFormId}_label_201921_1"
  def secondRefereeEmployerId                = s"${pecFormId}_datafield_202011_1_1_52513_label"
  def secondRefereeAcademicId                = s"${pecFormId}_datafield_202011_1_1_52514_label"
  def secondRefereeOtherId                   = s"${pecFormId}_datafield_202011_1_1_52515_label"
  def secondOtherRefereeInputId              = s"${pecFormId}_datafield_204190_1_1"
  def secondRefereeFullNameId                = s"${pecFormId}_datafield_202014_1_1"
  def secondRefereeEmailId                   = s"${pecFormId}_datafield_202020_1_1"
  def thirdRefereeTitleId                    = s"${pecFormId}_label_201924_1"
  def thirdRefereeEmployerId                 = s"${pecFormId}_datafield_202027_1_1_52513_label"
  def thirdRefereeAcademicId                 = s"${pecFormId}_datafield_202027_1_1_52514_label"
  def thirdRefereeOtherId                    = s"${pecFormId}_datafield_202027_1_1_52515_label"
  def thirdOtherRefereeInputId               = s"${pecFormId}_datafield_204184_1_1"
  def thirdRefereeFullNameId                 = s"${pecFormId}_datafield_202031_1_1"
  def thirdRefereeEmailId                    = s"${pecFormId}_datafield_202037_1_1"

  private def verifyingHistoryPageCheck(): Unit =
    eventually(onPage(verifyingHistoryPageTitle))

  private def confirmThreeRefereeDetails(): Unit = {
    verifyingHistoryPageCheck()
    val threeRefereesRequiredText = waitForVisibilityOfElementById(threeRefereesDetailsTextId).getText
    threeRefereesRequiredText shouldEqual "We need the details of 3 referees who can confirm the information you’ve given us and what you have been doing during the last 3 years.\nYou should ask for their consent before supplying their details."
  }

  private def instructionsDetails(): Unit = {
    val instructionsText = waitForVisibilityOfElementById(instructionsTextId).getText
    instructionsText shouldEqual "Any employer or academic referee must be from within the last 3 years.\nAny other referee must have known you for more than 3 years.\nAll referees must not be:\nrelated to you by birth or marriage\nin a relationship with or live at the same address as you"
  }

  private def selectTypeOfReferee(
    refereeType: String,
    employerId: String,
    academicId: String,
    otherId: Option[String] = None,
    otherInput: Option[String] = None,
    otherType: Option[String] = None
  ): Unit =
    refereeType match {
      case "Employer" => radioSelect(employerId)
      case "Academic" => radioSelect(academicId)
      case "Other"    =>
        radioSelect(otherId.get)
        enterDetails(otherInput.get, otherType.get)
      case _          => throw new IllegalStateException("Valid referee needs to be stated")
    }

  private def enterRefereeFullName(nameInput: String, fullName: String): Unit =
    enterDetails(nameInput, fullName)

  private def enterRefereeEmail(emailInput: String, email: String): Unit =
    enterDetails(emailInput, email)

  private def enterFirstRefereeDetails(verifyingHistoryDetails: VerifyingHistoryDetails): Unit = {
    waitForVisibilityOfElementById(firstRefereeTitleId).getText shouldEqual "First referee"
    if (verifyingHistoryDetails.firstEmployerOrAcademic) {
      radioSelect(firstEmployerOrAcademicYesId)
    } else {
      radioSelect(firstEmployerOrAcademicNoId)
      enterDetails(firstOtherTypeOfRefereeInputId, verifyingHistoryDetails.firstOtherTypeOfReferee)
    }
    selectTypeOfReferee(verifyingHistoryDetails.firstRefereeType, firstRefereeEmployerId, firstRefereeAcademicId)
    enterRefereeFullName(firstRefereeFullNameId, verifyingHistoryDetails.firstRefereeFullName)
    enterRefereeEmail(firstRefereeEmailId, verifyingHistoryDetails.firstRefereeEmail)
  }

  private def enterSecondRefereeDetails(verifyingHistoryDetails: VerifyingHistoryDetails): Unit = {
    waitForVisibilityOfElementById(secondRefereeTitleId).getText shouldEqual "Second referee"
    selectTypeOfReferee(
      verifyingHistoryDetails.secondTypeOfReferee,
      secondRefereeEmployerId,
      secondRefereeAcademicId,
      Some(secondRefereeOtherId),
      Some(secondOtherRefereeInputId),
      Some(verifyingHistoryDetails.secondOtherTypeOfReferee)
    )
    enterRefereeFullName(secondRefereeFullNameId, verifyingHistoryDetails.secondRefereeFullName)
    enterRefereeEmail(secondRefereeEmailId, verifyingHistoryDetails.secondRefereeEmail)
  }

  private def enterThirdRefereeDetails(verifyingHistoryDetails: VerifyingHistoryDetails): Unit = {
    waitForVisibilityOfElementById(thirdRefereeTitleId).getText shouldEqual "Third referee"
    selectTypeOfReferee(
      verifyingHistoryDetails.thirdTypeOfReferee,
      thirdRefereeEmployerId,
      thirdRefereeAcademicId,
      Some(thirdRefereeOtherId),
      Some(thirdOtherRefereeInputId),
      Some(verifyingHistoryDetails.thirdOtherTypeOfReferee)
    )
    enterRefereeFullName(thirdRefereeFullNameId, verifyingHistoryDetails.thirdRefereeFullName)
    enterRefereeEmail(thirdRefereeEmailId, verifyingHistoryDetails.thirdRefereeEmail)
  }

  private val verifyingHistory: Seq[VerifyingHistoryDetails => Unit] = Seq(
    enterFirstRefereeDetails,
    enterSecondRefereeDetails,
    enterThirdRefereeDetails
  )

  def verifyingHistoryPage(pecFormDetails: PecFormDetails): Unit =
    if (
      !vXPecEmploymentHistoryCheck.contains("Not Applicable") &&
      vXPecEmploymentHistoryCheck.contains(s"$vXApproach Candidates")
    ) {
      confirmThreeRefereeDetails()
      instructionsDetails()
      verifyingHistory.foreach { f =>
        f(pecFormDetails.verifyingHistoryDetails)
      }
      clickOn(pageContinue)
    }
}
