package uk.gov.co.test.ui.pages.vx.createvacancypage

import uk.gov.co.test.ui.data.vx.DefraApplyOnlyDetails
import uk.gov.co.test.ui.pages.vx.VacancyBasePage
import uk.gov.co.test.ui.pages.vx.createvacancypage.BasicDetailsSection.formId

case class InterviewsDetails(
  expectedRounds: String,
  interviewOneType: String,
  interviewTwoType: String,
  interviewThreeType: String,
  interviewFourType: String,
  availableOffline: Boolean
)

object InterviewsSection extends VacancyBasePage {

  private lazy val noInterviewsId        = s"${formId}_datafield_91703_1_1_15327"
  private lazy val oneInterviewId        = s"${formId}_datafield_91703_1_1_15328"
  private lazy val twoInterviewId        = s"${formId}_datafield_91703_1_1_15329"
  private lazy val threeInterviewId      = s"${formId}_datafield_91703_1_1_15330"
  private lazy val fourInterviewId       = s"${formId}_datafield_91703_1_1_15331"
  private lazy val availableOfflineYesId = s"${formId}_datafield_125052_1_1_1"
  private lazy val availableOfflineNoId  = s"${formId}_datafield_125052_1_1_2"
  private lazy val assessmentOneId       = s"${formId}_datafield_125056_1_1_17756"
  private lazy val interviewOneId        = s"${formId}_datafield_125056_1_1_17753"
  private lazy val telephoneOneId        = s"${formId}_datafield_125056_1_1_17755"
  private lazy val videoOneId            = s"${formId}_datafield_125056_1_1_17754"
  private lazy val assessmentTwoId       = s"${formId}_datafield_125060_1_1_17756"
  private lazy val interviewTwoId        = s"${formId}_datafield_125060_1_1_17753"
  private lazy val telephoneTwoId        = s"${formId}_datafield_125060_1_1_17755"
  private lazy val videoTwoId            = s"${formId}_datafield_125060_1_1_17754"
  private lazy val assessmentThreeId     = s"${formId}_datafield_125063_1_1_17756"
  private lazy val interviewThreeId      = s"${formId}_datafield_125063_1_1_17753"
  private lazy val telephoneThreeId      = s"${formId}_datafield_125063_1_1_17755"
  private lazy val videoThreeId          = s"${formId}_datafield_125063_1_1_17754"
  private lazy val assessmentFourId      = s"${formId}_datafield_125066_1_1_17756"
  private lazy val interviewFourId       = s"${formId}_datafield_125066_1_1_17753"
  private lazy val telephoneFourId       = s"${formId}_datafield_125066_1_1_17755"
  private lazy val videoFourId           = s"${formId}_datafield_125066_1_1_17754"

  def interviewsSection(newVacancyDetails: DefraApplyOnlyDetails): Unit = {
    val interviews = newVacancyDetails.interviewsDetails
    interviews.expectedRounds match {
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
