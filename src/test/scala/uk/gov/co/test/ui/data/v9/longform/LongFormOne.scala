package uk.gov.co.test.ui.data.v9.longform

import uk.gov.co.test.ui.data.Characters.{valid250Characters, valid500Characters}
import uk.gov.co.test.ui.pages.v9.longform._
import uk.gov.co.test.ui.pages.vx.createvacancypage.LocationsSection.vXOtherLocations

object LONG_FORM_DATA_ONE
    extends LongFormDetails(
      LONG_FORM_EXPERIENCE_SKILLS_ONE,
      LONG_FORM_CV_ONE,
      LONG_FORM_PERSONAL_STATEMENT_ONE,
      LONG_FORM_BEHAVIOURS_ONE,
      LONG_FORM_TECHNICAL_SKILLS_ONE,
      LONG_FORM_UPLOAD_DOCUMENTS_ONE,
      LONG_FORM_PREFERENCES_ONE,
      LONG_FORM_ROLE_QUESTIONS_ONE,
      LONG_FORM_DECLARATION_ONE
    )

object LONG_FORM_EXPERIENCE_SKILLS_ONE
    extends ExperienceAndSkillsDetails(
      true,
      s"$valid250Characters"
    )

object LONG_FORM_CV_ONE
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

object LONG_FORM_PERSONAL_STATEMENT_ONE
    extends StatementDetails(
      s"$valid250Characters",
      true
    )

object LONG_FORM_BEHAVIOURS_ONE
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

object LONG_FORM_TECHNICAL_SKILLS_ONE
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

object LONG_FORM_UPLOAD_DOCUMENTS_ONE
    extends UploadDocumentsDetails(
      "Test-T&Cs.pdf"
    )

object LONG_FORM_PREFERENCES_ONE
    extends PreferencesDetails(
      s"${vXOtherLocations.head}",
      secondChoiceLocation = Option(s"${vXOtherLocations.tail.head}"),
      thirdChoiceLocation = Option(s"${vXOtherLocations.last}"),
      furtherLocationPreferences = Option("Autotest - Further location preferences (optional)")
    )

object LONG_FORM_ROLE_QUESTIONS_ONE
    extends RoleQuestionsDetails(
      s"$valid500Characters",
      s"$valid500Characters",
      s"$valid500Characters"
    )

object LONG_FORM_DECLARATION_ONE
    extends DeclarationDetails(
      true
    )
