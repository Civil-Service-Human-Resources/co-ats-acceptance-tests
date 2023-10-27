package uk.gov.co.test.ui.utils

import scala.collection.JavaConverters._

object EnvironmentVariables extends App {

  val environmentVars = System.getenv().asScala
  for ((k,v) <- environmentVars) println(s"key: $k, value: $v")

  val properties = System.getProperties.asScala
  for ((k,v) <- properties) println(s"key: $k, value: $v")

}