package mx.ebc.data

import spock.lang.Specification
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.*
import mx.ebc.config.DataConfig
import javax.sql.DataSource
import org.springframework.jdbc.core.JdbcTemplate

@ContextConfiguration(classes = [DataConfig])
class CampusRepositorySpec extends Specification {

  @Autowired
  CampusRepository campusRepository

  @Autowired
  ApplicationContext applicationContext

  @Autowired
  DataSource dataSource

  @Autowired
  JdbcTemplate jdbcTemplate

  void "should exist the bean 'CampusRepository' in spring"() {
    expect:
      applicationContext
      campusRepository
  }

  void "should exist the bean 'DataSource' in spring"() {
    expect:
      dataSource
  }

  void "should exist the bean 'JdbcTemplate' in spring"() {
    expect:
      jdbcTemplate
  }

}
