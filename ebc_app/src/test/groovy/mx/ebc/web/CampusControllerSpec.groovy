package mx.ebc.web

import spock.lang.Specification
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.*
import mx.ebc.config.DataConfig
import mx.ebc.config.ServiceConfig
import mx.ebc.config.WebConfig

@ContextConfiguration(classes = [DataConfig, ServiceConfig, WebConfig])
class CampusControllerSpec extends Specification {

  @Autowired
  CampusController campusController

  void "should exist the bean 'CampusController' in spring"() {
    expect:
      campusController
  }

}
