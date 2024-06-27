package mx.ebc.data

import spock.lang.Specification
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.*

@ContextConfiguration(classes = DataConfig)
class CampusRepositorySpec extends Specification {

  @Autowired
  CampusRepository campusRepository


  void "should exist the bean in spring"() {
    expect:
      campusRepository
  }

}
