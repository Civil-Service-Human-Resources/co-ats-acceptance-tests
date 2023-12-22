package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vXInterviewExpectedRounds
import uk.gov.co.test.ui.data.vx.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.vacancyFormId

case class InterviewsDetails(
  expectedRounds: String,
  interviewOneType: String,
  interviewTwoType: String,
  interviewThreeType: String,
  interviewFourType: String,
  availableOffline: Boolean
)

object InterviewsSection extends VacancyBasePage {

  def noInterviewsId        = s"${vacancyFormId}_datafield_91703_1_1_15327"
  def oneInterviewId        = s"${vacancyFormId}_datafield_91703_1_1_15328"
  def twoInterviewId        = s"${vacancyFormId}_datafield_91703_1_1_15329"
  def threeInterviewId      = s"${vacancyFormId}_datafield_91703_1_1_15330"
  def fourInterviewId       = s"${vacancyFormId}_datafield_91703_1_1_15331"
  def availableOfflineYesId = s"${vacancyFormId}_datafield_125052_1_1_1"
  def availableOfflineNoId  = s"${vacancyFormId}_datafield_125052_1_1_2"
  def assessmentOneId       = s"${vacancyFormId}_datafield_125056_1_1_17756"
  def interviewOneId        = s"${vacancyFormId}_datafield_125056_1_1_17753"
  def telephoneOneId        = s"${vacancyFormId}_datafield_125056_1_1_17755"
  def videoOneId            = s"${vacancyFormId}_datafield_125056_1_1_17754"
  def assessmentTwoId       = s"${vacancyFormId}_datafield_125060_1_1_17756"
  def interviewTwoId        = s"${vacancyFormId}_datafield_125060_1_1_17753"
  def telephoneTwoId        = s"${vacancyFormId}_datafield_125060_1_1_17755"
  def videoTwoId            = s"${vacancyFormId}_datafield_125060_1_1_17754"
  def assessmentThreeId     = s"${vacancyFormId}_datafield_125063_1_1_17756"
  def interviewThreeId      = s"${vacancyFormId}_datafield_125063_1_1_17753"
  def telephoneThreeId      = s"${vacancyFormId}_datafield_125063_1_1_17755"
  def videoThreeId          = s"${vacancyFormId}_datafield_125063_1_1_17754"
  def assessmentFourId      = s"${vacancyFormId}_datafield_125066_1_1_17756"
  def interviewFourId       = s"${vacancyFormId}_datafield_125066_1_1_17753"
  def telephoneFourId       = s"${vacancyFormId}_datafield_125066_1_1_17755"
  def videoFourId           = s"${vacancyFormId}_datafield_125066_1_1_17754"

  def interviewsSection(newVacancyDetails: NewVacancyDetails): Unit = {
    val interviews = newVacancyDetails.interviewsDetails
    vXInterviewExpectedRounds = interviews.expectedRounds
    vXInterviewExpectedRounds match {
      case "No interviews" => clickOnRadioButton(noInterviewsId)
      case "1"             =>
        clickOnRadioButton(oneInterviewId)
        interviewsTypes(interviews, 1)
      case "2"             =>
        clickOnRadioButton(twoInterviewId)
        interviewsTypes(interviews, 2)
      case "3"             =>
        clickOnRadioButton(threeInterviewId)
        interviewsTypes(interviews, 3)
      case "4"             =>
        clickOnRadioButton(fourInterviewId)
        interviewsTypes(interviews, 4)
    }
    selectAvailableOffline(interviews)
  }

  private def selectInterviewRoundOneType(interviewsDetails: InterviewsDetails): Unit =
    interviewsDetails.interviewOneType match {
      case "Assessment" => clickOnRadioButton(assessmentOneId)
      case "Interview"  => clickOnRadioButton(interviewOneId)
      case "Telephone"  => clickOnRadioButton(telephoneOneId)
      case "Video"      => clickOnRadioButton(videoOneId)
    }

  private def selectInterviewRoundTwoType(interviewsDetails: InterviewsDetails): Unit =
    interviewsDetails.interviewTwoType match {
      case "Assessment" => clickOnRadioButton(assessmentTwoId)
      case "Interview"  => clickOnRadioButton(interviewTwoId)
      case "Telephone"  => clickOnRadioButton(telephoneTwoId)
      case "Video"      => clickOnRadioButton(videoTwoId)
    }

  private def selectInterviewRoundThreeType(interviewsDetails: InterviewsDetails): Unit =
    interviewsDetails.interviewThreeType match {
      case "Assessment" => clickOnRadioButton(assessmentThreeId)
      case "Interview"  => clickOnRadioButton(interviewThreeId)
      case "Telephone"  => clickOnRadioButton(telephoneThreeId)
      case "Video"      => clickOnRadioButton(videoThreeId)
    }

  private def selectInterviewRoundFourType(interviewsDetails: InterviewsDetails): Unit =
    interviewsDetails.interviewFourType match {
      case "Assessment" => clickOnRadioButton(assessmentFourId)
      case "Interview"  => clickOnRadioButton(interviewFourId)
      case "Telephone"  => clickOnRadioButton(telephoneFourId)
      case "Video"      => clickOnRadioButton(videoFourId)
    }

  private def selectAvailableOffline(interviewsDetails: InterviewsDetails): Unit =
    if (interviewsDetails.availableOffline) clickOnRadioButton(availableOfflineYesId)
    else clickOnRadioButton(availableOfflineNoId)

  private val interviews: Seq[InterviewsDetails => Unit] = Seq(
    selectInterviewRoundOneType,
    selectInterviewRoundTwoType,
    selectInterviewRoundThreeType,
    selectInterviewRoundFourType
  )

  private def interviewsTypes(interviewsDetails: InterviewsDetails, interviewTypes: Int): Unit =
    interviews.take(interviewTypes).foreach { f =>
      f(interviewsDetails)
    }

}
