package uk.gov.co.test.ui.utils

import uk.gov.co.test.ui.pages.v9.CandidateDetails

//case class CandidateData(candidateDetails: CandidateDetails)

object REGISTERED_CANDIDATE
    extends CandidateDetails("Tony", "Ferguson", "tony.ferguson@example.com", "qwertygh123", true, true)
object REGISTER_CANDIDATE
    extends CandidateDetails("Paul", "Jones", "paul.jones@example.com", "qwertygh123", false, true)
