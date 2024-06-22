package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.MasterVacancyDetails.{vXInterviewExpectedRounds, vXInterviewFourType, vXInterviewNumber, vXInterviewOneType, vXInterviewThreeType, vXInterviewTwoType, vXProfile, vacancyFormId}
import uk.gov.co.test.ui.data.vx.vacancy.NewVacancyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage

import scala.collection.mutable.ListBuffer

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
    if (vXInterviewExpectedRounds == "No interviews") {
      clickOnRadioButton(noInterviewsId)
    } else {
      vXInterviewExpectedRounds.toInt match {
        case 1 =>
          clickOnRadioButton(oneInterviewId)
          vXInterviewNumber = ListBuffer("1")
        case 2 =>
          clickOnRadioButton(twoInterviewId)
          vXInterviewNumber = ListBuffer("1", "2")
        case 3 =>
          clickOnRadioButton(threeInterviewId)
          vXInterviewNumber = ListBuffer("1", "2", "3")
        case 4 =>
          clickOnRadioButton(fourInterviewId)
          vXInterviewNumber = ListBuffer("1", "2", "3", "4")
      }
      interviewsTypes(interviews, vXInterviewExpectedRounds.toInt)
    }
    selectAvailableOffline(interviews)
  }

  private def selectInterviewRoundOneType(interviewsDetails: InterviewsDetails): Unit = {
    vXInterviewOneType = interviewsDetails.interviewOneType
    vXInterviewOneType match {
      case "Assessment" => clickOnRadioButton(assessmentOneId)
      case "Interview"  => clickOnRadioButton(interviewOneId)
      case "Telephone"  => clickOnRadioButton(telephoneOneId)
      case "Video"      => clickOnRadioButton(videoOneId)
    }
  }

  private def selectInterviewRoundTwoType(interviewsDetails: InterviewsDetails): Unit = {
    vXInterviewTwoType = interviewsDetails.interviewTwoType
    vXInterviewTwoType match {
      case "Assessment" => clickOnRadioButton(assessmentTwoId)
      case "Interview"  => clickOnRadioButton(interviewTwoId)
      case "Telephone"  => clickOnRadioButton(telephoneTwoId)
      case "Video"      => clickOnRadioButton(videoTwoId)
    }
  }

  private def selectInterviewRoundThreeType(interviewsDetails: InterviewsDetails): Unit = {
    vXInterviewThreeType = interviewsDetails.interviewThreeType
    vXInterviewThreeType match {
      case "Assessment" => clickOnRadioButton(assessmentThreeId)
      case "Interview"  => clickOnRadioButton(interviewThreeId)
      case "Telephone"  => clickOnRadioButton(telephoneThreeId)
      case "Video"      => clickOnRadioButton(videoThreeId)
    }
  }

  private def selectInterviewRoundFourType(interviewsDetails: InterviewsDetails): Unit = {
    vXInterviewFourType = interviewsDetails.interviewFourType
    vXInterviewFourType match {
      case "Assessment" => clickOnRadioButton(assessmentFourId)
      case "Interview"  => clickOnRadioButton(interviewFourId)
      case "Telephone"  => clickOnRadioButton(telephoneFourId)
      case "Video"      => clickOnRadioButton(videoFourId)
    }
  }

  private def selectAvailableOffline(interviewsDetails: InterviewsDetails): Unit = {
    if (vXProfile != "Vacancy Holder 1") {
      if (interviewsDetails.availableOffline) clickOnRadioButton(availableOfflineYesId)
      else clickOnRadioButton(availableOfflineNoId)
    }
  }

  private val interviews: Seq[InterviewsDetails => Unit] = Seq(
    selectInterviewRoundOneType,
    selectInterviewRoundTwoType,
    selectInterviewRoundThreeType,
    selectInterviewRoundFourType
  )

  private def interviewsTypes(interviewsDetails: InterviewsDetails, noOfInterviews: Int): Unit =
    interviews.take(noOfInterviews).foreach { f =>
      f(interviewsDetails)
    }
}
