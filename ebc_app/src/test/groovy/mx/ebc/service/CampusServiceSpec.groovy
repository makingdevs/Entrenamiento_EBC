package mx.ebc.service

import mx.ebc.config.DataJpaConfig
import spock.lang.Specification
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.*
import mx.ebc.config.ServiceConfig

@ContextConfiguration(classes = [DataJpaConfig, ServiceConfig])
class CampusServiceSpec extends Specification {

  @Autowired
  CampusService campusService

  void "should exist the bean 'CampusService' in spring"() {
    expect:
      campusService
  }

}
