package uk.gov.co.test.ui.data.v9.longform

import uk.gov.co.test.ui.data.Characters.{valid250Characters, valid500Characters}
import uk.gov.co.test.ui.pages.v9.longform._
import uk.gov.co.test.ui.pages.vx.createvacancypage.LocationsSection.vXOtherLocations

object MASTER_LONG_FORM_DATA
    extends LongFormDetails(
      MASTER_LONG_FORM_EXPERIENCE_SKILLS,
      MASTER_LONG_FORM_CV,
      MASTER_LONG_FORM_PERSONAL_STATEMENT,
      MASTER_LONG_FORM_BEHAVIOURS,
      MASTER_LONG_FORM_TECHNICAL_SKILLS,
      MASTER_LONG_FORM_UPLOAD_DOCUMENTS,
      MASTER_LONG_FORM_PREFERENCES,
      MASTER_LONG_FORM_ROLE_QUESTIONS,
      MASTER_LONG_FORM_DECLARATION
    )

object MASTER_LONG_FORM_EXPERIENCE_SKILLS
    extends ExperienceAndSkillsDetails(
      true,
      s"$valid250Characters"
    )

object MASTER_LONG_FORM_CV
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

object MASTER_LONG_FORM_PERSONAL_STATEMENT
    extends StatementDetails(
      s"$valid250Characters",
      true
    )

object MASTER_LONG_FORM_BEHAVIOURS
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

object MASTER_LONG_FORM_TECHNICAL_SKILLS
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

object MASTER_LONG_FORM_UPLOAD_DOCUMENTS
    extends UploadDocumentsDetails(
      "Test-T&Cs.pdf"
    )

object MASTER_LONG_FORM_PREFERENCES
    extends PreferencesDetails(
      s"${vXOtherLocations.head}",
      secondChoiceLocation = Option(s"${vXOtherLocations.tail.head}"),
      thirdChoiceLocation = Option(s"${vXOtherLocations.last}"),
      furtherLocationPreferences = Option("Autotest - Further location preferences (optional)")
    )

object MASTER_LONG_FORM_ROLE_QUESTIONS
    extends RoleQuestionsDetails(
      s"$valid500Characters",
      s"$valid500Characters",
      s"$valid500Characters"
    )

object MASTER_LONG_FORM_DECLARATION
    extends DeclarationDetails(
      true
    )
