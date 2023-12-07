package uk.gov.co.test.ui.pages.v9.longform

import org.openqa.selenium.{By, WebElement}
import org.scalatest.concurrent.Eventually.eventually
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.CivilServiceJobsBasePage
import uk.gov.co.test.ui.pages.v9.shortform.ApplicationGuidancePage.formId

import scala.collection.mutable
import scala.jdk.CollectionConverters._

case class Qualification(
  typeOfQualification: String,
  otherQualification: Option[String] = None,
  subject: Option[String] = None,
  grade: Option[String] = None
)

case class CVDetails(
  employmentHistoryDetails: String,
  previousSkillsDetails: String,
  addQualifications: Option[Boolean] = None,
  howManyQualifications: Int,
  firstQualification: Option[Qualification] = None,
  secondQualification: Option[Qualification] = None,
  thirdQualification: Option[Qualification] = None,
  fourthQualification: Option[Qualification] = None,
  fifthQualification: Option[Qualification] = None,
  removeDetails: Boolean
)

object YourCVPage extends CivilServiceJobsBasePage {

  private lazy val yourCVTitle            = "Your CV - Civil Service Jobs - GOV.UK"
  private lazy val qualificationTablePath = ".//*[@class='table form_section form_table_layout ']/tbody"
  private lazy val qualificationRowsPath  = ".//tr[contains(@class, 'row form_section form_multi_section')]"
  private lazy val addRowsPath            = ".//*[@name='add_section_instance_22369']"
  private lazy val removeRowsPath         = ".//*[@name='remove_section_instance_22369']"
  def removedPersonalDetailsId            = s"${formId}_datafield_89045_1_1_15120_label"
  def employmentHistoryDetailsInputId     = s"${formId}_datafield_99856_1_1"
  def previousSkillsDetailsInputId        = s"${formId}_datafield_99863_1_1"
  def typeOfQualificationOneId            = s"${formId}_datafield_53854_1_1"
  def otherQualificationOneId             = s"${formId}_datafield_22379_1_1"
  def subjectOneId                        = s"${formId}_datafield_22372_1_1"
  def gradeOneId                          = s"${formId}_datafield_36911_1_1"
  def typeOfQualificationTwoId            = s"${formId}_datafield_53854_1_2"
  def otherQualificationTwoId             = s"${formId}_datafield_22379_1_2"
  def subjectTwoId                        = s"${formId}_datafield_22372_1_2"
  def gradeTwoId                          = s"${formId}_datafield_36911_1_2"
  def typeOfQualificationThreeId          = s"${formId}_datafield_53854_1_3"
  def otherQualificationThreeId           = s"${formId}_datafield_22379_1_3"
  def subjectThreeId                      = s"${formId}_datafield_22372_1_3"
  def gradeThreeId                        = s"${formId}_datafield_36911_1_3"
  def typeOfQualificationFourId           = s"${formId}_datafield_53854_1_4"
  def otherQualificationFourId            = s"${formId}_datafield_22379_1_4"
  def subjectFourId                       = s"${formId}_datafield_22372_1_4"
  def gradeFourId                         = s"${formId}_datafield_36911_1_4"
  def typeOfQualificationFiveId           = s"${formId}_datafield_53854_1_5"
  def otherQualificationFiveId            = s"${formId}_datafield_22379_1_5"
  def subjectFiveId                       = s"${formId}_datafield_22372_1_5"
  def gradeFiveId                         = s"${formId}_datafield_36911_1_5"

  private def yourCVPageCheck(): Unit =
    eventually(onPage(yourCVTitle))

  private def enterEmploymentHistory(cvDetails: CVDetails): Unit =
    enterDetails(employmentHistoryDetailsInputId, cvDetails.employmentHistoryDetails)

  private def enterPreviousSkills(cvDetails: CVDetails): Unit =
    enterDetails(previousSkillsDetailsInputId, cvDetails.previousSkillsDetails)

  private def selectTypeOfQualification(inputId: String, typeOfQualification: String): Unit =
    selectDropdownOption(inputId, typeOfQualification)

  private def enterOtherQualification(inputId: String, otherQualification: String): Unit =
    enterDetails(inputId, otherQualification)

  private def enterSubject(inputId: String, subject: String): Unit =
    enterDetails(inputId, subject)

  private def enterGrade(inputId: String, grade: String): Unit =
    enterDetails(inputId, grade)

  private def enterFirstQualification(cvDetails: CVDetails): Unit = {
    val first = cvDetails.firstQualification
    selectTypeOfQualification(typeOfQualificationOneId, first.map(_.typeOfQualification).get)
    enterOtherQualification(otherQualificationOneId, first.map(_.otherQualification.get).get)
    enterSubject(subjectOneId, first.map(_.subject.get).get)
    enterGrade(gradeOneId, first.map(_.grade.get).get)
  }

  private def enterSecondQualification(cvDetails: CVDetails): Unit = {
    val second = cvDetails.secondQualification
    selectTypeOfQualification(typeOfQualificationTwoId, second.map(_.typeOfQualification).get)
    enterOtherQualification(otherQualificationTwoId, second.map(_.otherQualification.get).get)
    enterSubject(subjectTwoId, second.map(_.subject.get).get)
    enterGrade(gradeTwoId, second.map(_.grade.get).get)
  }

  private def enterThirdQualification(cvDetails: CVDetails): Unit = {
    val third = cvDetails.thirdQualification
    selectTypeOfQualification(typeOfQualificationThreeId, third.map(_.typeOfQualification).get)
    enterOtherQualification(otherQualificationThreeId, third.map(_.otherQualification.get).get)
    enterSubject(subjectThreeId, third.map(_.subject.get).get)
    enterGrade(gradeThreeId, third.map(_.grade.get).get)
  }

  private def enterFourthQualification(cvDetails: CVDetails): Unit = {
    val fourth = cvDetails.fourthQualification
    selectTypeOfQualification(typeOfQualificationFourId, fourth.map(_.typeOfQualification).get)
    enterOtherQualification(otherQualificationFourId, fourth.map(_.otherQualification.get).get)
    enterSubject(subjectFourId, fourth.map(_.subject.get).get)
    enterGrade(gradeFourId, fourth.map(_.grade.get).get)
  }

  private def enterFifthQualification(cvDetails: CVDetails): Unit = {
    val fifth = cvDetails.fifthQualification
    selectTypeOfQualification(typeOfQualificationFiveId, fifth.map(_.typeOfQualification).get)
    enterOtherQualification(otherQualificationFiveId, fifth.map(_.otherQualification.get).get)
    enterSubject(subjectFiveId, fifth.map(_.subject.get).get)
    enterGrade(gradeFiveId, fifth.map(_.grade.get).get)
  }

  def tableArea(): WebElement =
    waitForVisibilityOfElement(By.xpath(qualificationTablePath))

  def summaryRows(): mutable.Buffer[WebElement] =
    tableArea().findElements(By.xpath(qualificationRowsPath)).asScala

  private def addRows(cvDetails: CVDetails): Unit =
    while (summaryRows().size != cvDetails.howManyQualifications) {
      val addRowInstance = waitForVisibilityOfElementByPath(addRowsPath)
      addRowInstance.click()
    }

  private def removeRows(cvDetails: CVDetails): Unit =
    while (summaryRows().size != cvDetails.howManyQualifications) {
      val removeRowInstance = waitForVisibilityOfElementByPath(removeRowsPath)
      removeRowInstance.click()
    }

  private def equateRows(cvDetails: CVDetails): Unit = {
    val rows = summaryRows().size
    if (cvDetails.howManyQualifications > rows) {
      addRows(cvDetails)
    } else if (cvDetails.howManyQualifications < rows) {
      removeRows(cvDetails)
    }
  }

  private def enterAllQualifications(cvDetails: CVDetails): Unit =
    if (cvDetails.addQualifications.get) {
      equateRows(cvDetails)
      cvDetails.howManyQualifications match {
        case 1 =>
          enterFirstQualification(cvDetails)
        case 2 =>
          enterFirstQualification(cvDetails)
          enterSecondQualification(cvDetails)
        case 3 =>
          enterFirstQualification(cvDetails)
          enterSecondQualification(cvDetails)
          enterThirdQualification(cvDetails)
        case 4 =>
          enterFirstQualification(cvDetails)
          enterSecondQualification(cvDetails)
          enterThirdQualification(cvDetails)
          enterFourthQualification(cvDetails)
        case 5 =>
          enterFirstQualification(cvDetails)
          enterSecondQualification(cvDetails)
          enterThirdQualification(cvDetails)
          enterFourthQualification(cvDetails)
          enterFifthQualification(cvDetails)
        case _ =>
          throw new IllegalStateException(
            s"Required qualifications of '${cvDetails.howManyQualifications}' is not supported. Update case statement!"
          )
      }
    }

  private def removedDetails(cvDetails: CVDetails): Unit =
    if (cvDetails.removeDetails) radioSelect(removedPersonalDetailsId)

  private val yourCV: Seq[CVDetails => Unit] = Seq(
    enterEmploymentHistory,
    enterPreviousSkills,
    enterAllQualifications,
    removedDetails
  )

  def yourCVPage(longFormDetails: LongFormDetails): Unit = {
    yourCVPageCheck()
    yourCV.foreach { f =>
      f(longFormDetails.cvDetails)
    }
    clickOn(pageContinue)
  }
}
