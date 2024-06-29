package mx.ebc.data

import spock.lang.Specification
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.*
import mx.ebc.config.DataConfig

@ContextConfiguration(classes = [DataConfig])
class CampusRepositorySpec extends Specification {

  @Autowired
  CampusRepository campusRepository

  @Autowired
  ApplicationContext applicationContext

  void "should exist the bean 'CampusRepository' in spring"() {
    expect:
      applicationContext
      campusRepository
  }

}
