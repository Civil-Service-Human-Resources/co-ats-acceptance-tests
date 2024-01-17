package uk.gov.co.test.ui.utils

// Super-hack. Use local mutable state to ensure hooks are only executed once per suite run
object OncePerSuiteRun {
  var hooks: Set[String] = Set()

  def register(key: String, callback: () => Unit): Unit =
    if (!hooks.contains(key)) {
      callback()
      hooks += key
    }
}
