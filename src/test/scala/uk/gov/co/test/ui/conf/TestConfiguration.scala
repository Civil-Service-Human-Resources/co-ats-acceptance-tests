package uk.gov.co.test.ui.conf

import com.typesafe.config.{Config, ConfigFactory}

object TestConfiguration {
  val config: Config = ConfigFactory.load()

  def url(service: String): String = {
    val host = s"${environmentHost(service)}"
    s"$host${serviceRoute(service)}"
  }

  def environmentHost(serviceName: String): String = config.getString(s"services.$serviceName.host")
  def serviceRoute(serviceName: String): String    = config.getString(s"services.$serviceName.productionRoute")
  def readProperty(property: String): String = config.getString(property)
}
