package uk.gov.co.test.ui.data.test.nameblind

import uk.gov.co.test.ui.data.Characters.{valid250Characters, valid500Characters, valid750Characters}
import uk.gov.co.test.ui.data.MasterVacancyDetails.vXOtherLocations
import uk.gov.co.test.ui.data.v9.longform.LongFormDetails
import uk.gov.co.test.ui.pages.v9.longform._

object NON_NAME_BLIND_LONG_FORM_DATA
    extends LongFormDetails(
      NON_NAME_BLIND_LONG_FORM_EXPERIENCE_SKILLS,
      NON_NAME_BLIND_LONG_FORM_CV,
      NON_NAME_BLIND_LONG_FORM_PERSONAL_STATEMENT,
      NON_NAME_BLIND_LONG_FORM_BEHAVIOURS,
      NON_NAME_BLIND_LONG_FORM_TECHNICAL_SKILLS,
      NON_NAME_BLIND_LONG_FORM_UPLOAD_DOCUMENTS,
      NON_NAME_BLIND_LONG_FORM_PREFERENCES,
      NON_NAME_BLIND_LONG_FORM_ROLE_QUESTIONS,
      NON_NAME_BLIND_LONG_FORM_DECLARATION
    )

object NON_NAME_BLIND_LONG_FORM_EXPERIENCE_SKILLS
    extends ExperienceAndSkillsDetails(
      true,
      s"$valid250Characters"
    )

object NON_NAME_BLIND_LONG_FORM_CV
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

object NON_NAME_BLIND_LONG_FORM_PERSONAL_STATEMENT
    extends StatementDetails(
      s"$valid250Characters",
      s"$valid500Characters",
      s"$valid750Characters",
      true
    )

object NON_NAME_BLIND_LONG_FORM_BEHAVIOURS
    extends BehavioursDetails(
      s"$valid250Characters"
    )

object NON_NAME_BLIND_LONG_FORM_TECHNICAL_SKILLS
    extends TechSkillsDetails(
      s"$valid250Characters"
    )

object NON_NAME_BLIND_LONG_FORM_UPLOAD_DOCUMENTS
    extends UploadDocumentsDetails(
      "Test-T&Cs.pdf"
    )

object NON_NAME_BLIND_LONG_FORM_PREFERENCES
    extends PreferencesDetails(
      s"${vXOtherLocations.head}",
      secondChoiceLocation = Option(s"${vXOtherLocations.tail.head}"),
      thirdChoiceLocation = Option(s"${vXOtherLocations.last}"),
      furtherLocationPreferences = Option("Autotest - Further location preferences (optional)")
    )

object NON_NAME_BLIND_LONG_FORM_ROLE_QUESTIONS
    extends RoleQuestionsDetails(
      s"$valid500Characters",
      s"$valid500Characters",
      s"$valid500Characters"
    )

object NON_NAME_BLIND_LONG_FORM_DECLARATION
    extends DeclarationDetails(
      true
    )
