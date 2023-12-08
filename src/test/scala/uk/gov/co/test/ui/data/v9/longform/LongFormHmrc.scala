package uk.gov.co.test.ui.data.v9.longform

import uk.gov.co.test.ui.data.Characters.{valid250Characters, valid500Characters}
import uk.gov.co.test.ui.pages.v9.longform._
import uk.gov.co.test.ui.data.vx.MasterVacancyDetails.vXOtherLocations

object LONG_FORM_DATA_HMRC
    extends LongFormDetails(
      LONG_FORM_EXPERIENCE_SKILLS_HMRC,
      LONG_FORM_CV_HMRC,
      LONG_FORM_PERSONAL_STATEMENT_HMRC,
      LONG_FORM_BEHAVIOURS_HMRC,
      LONG_FORM_TECHNICAL_SKILLS_HMRC,
      LONG_FORM_UPLOAD_DOCUMENTS_HMRC,
      LONG_FORM_PREFERENCES_HMRC,
      LONG_FORM_ROLE_QUESTIONS_HMRC,
      LONG_FORM_DECLARATION_HMRC
    )

object LONG_FORM_EXPERIENCE_SKILLS_HMRC
    extends ExperienceAndSkillsDetails(
      true,
      s"$valid250Characters"
    )

object LONG_FORM_CV_HMRC
    extends CVDetails(
      s"$valid250Characters",
      s"$valid250Characters",
      addQualifications = Option(true),
      5,
      firstQualification = Option(
        Qualification(
          typeOfQualification = "GCSE/O Level",
          otherQualification = Some("GCSE"),
          subject = Some("English"),
          grade = Some("8")
        )
      ),
      secondQualification = Option(
        Qualification(
          typeOfQualification = "GCSE/O Level",
          otherQualification = Some("GCSE"),
          subject = Some("Mathematics"),
          grade = Some("9")
        )
      ),
      thirdQualification = Option(
        Qualification(
          typeOfQualification = "A level",
          otherQualification = Some("AS"),
          subject = Some("Economics"),
          grade = Some("A")
        )
      ),
      fourthQualification = Option(
        Qualification(
          typeOfQualification = "Degree",
          otherQualification = Some("Econometrics"),
          subject = Some("Economics"),
          grade = Some("1:1")
        )
      ),
      fifthQualification = Option(
        Qualification(
          typeOfQualification = "Masters",
          otherQualification = Some("Algorithms"),
          subject = Some("Artificial Intelligence"),
          grade = Some("Distinction")
        )
      ),
      true
    )

object LONG_FORM_PERSONAL_STATEMENT_HMRC
    extends StatementDetails(
      s"$valid250Characters",
      true
    )

object LONG_FORM_BEHAVIOURS_HMRC
    extends BehavioursDetails(
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters"
    )

object LONG_FORM_TECHNICAL_SKILLS_HMRC
    extends TechSkillsDetails(
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters",
      s"$valid250Characters"
    )

object LONG_FORM_UPLOAD_DOCUMENTS_HMRC
    extends UploadDocumentsDetails(
      "Test-T&Cs.pdf"
    )

object LONG_FORM_PREFERENCES_HMRC
    extends PreferencesDetails(
      s"${vXOtherLocations.head}",
      secondChoiceLocation = Option(s"${vXOtherLocations.tail.head}"),
      thirdChoiceLocation = Option(s"${vXOtherLocations.last}"),
      furtherLocationPreferences = Option("Autotest - Further location preferences (optional)")
    )

object LONG_FORM_ROLE_QUESTIONS_HMRC
    extends RoleQuestionsDetails(
      s"$valid500Characters",
      s"$valid500Characters",
      s"$valid500Characters"
    )

object LONG_FORM_DECLARATION_HMRC
    extends DeclarationDetails(
      true
    )
