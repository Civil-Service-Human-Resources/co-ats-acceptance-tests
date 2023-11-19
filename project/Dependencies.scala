import sbt._

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "org.scalatest"              %% "scalatest"       % "3.2.0"   % Test,
    "org.scalatestplus"          %% "selenium-3-141"  % "3.2.0.0" % Test,
    "com.typesafe.play"          %% "play-json"       % "2.7.4"   % Test,
    "com.vladsch.flexmark"        % "flexmark-all"    % "0.35.10" % Test,
    "org.pegdown"                 % "pegdown"         % "1.2.1"   % Test,
    "com.typesafe"                % "config"          % "1.3.2"   % Test,
    "commons-io"                  % "commons-io"      % "2.6"     % Test,
    "net.lightbody.bmp"           % "browsermob-core" % "2.1.5"   % Test,
    "com.typesafe.scala-logging" %% "scala-logging"   % "3.9.5"   % Test,
    "ch.qos.logback"              % "logback-classic" % "1.2.10"   % Test,
    "com.github.javafaker"        % "javafaker"       % "0.15"     % Test
  )

}
