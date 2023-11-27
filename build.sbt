import sbt.ConnectionType.Tcp

lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    name := "co-ats-acceptance-tests",
    version := "0.1.0",
    scalaVersion := "2.13.8",
    scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
    parallelExecution in Test := false,
    libraryDependencies ++= Dependencies.test,
    testOptions in Test := Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
      Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/html-report"),
      Tests.Argument("-oD")
    )
  )

Global / serverConnectionType := Tcp // experimental
