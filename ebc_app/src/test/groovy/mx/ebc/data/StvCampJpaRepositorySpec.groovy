package mx.ebc.data

import mx.ebc.config.DataJpaConfig
import mx.ebc.data.jpa.EmpleadoJPARepository
import mx.ebc.data.jpa.StvCampJPARepository
import mx.ebc.model.Empleado
import mx.ebc.model.StvCamp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [DataJpaConfig])
class StvCampJpaRepositorySpec extends Specification {

  @Autowired
  StvCampJPARepository stvCampJpaRepository

  void "should exist the bean 'EmpleadoRepository' in spring"() {
    expect:
      stvCampJpaRepository
  }

  void "should retrieve a List of StvCamp"() {
    when:
      List<StvCamp> stvCampList = stvCampJpaRepository.findAll()
      println "*"*100
      println stvCampList
      println "*"*100

    then:
      stvCampList
      stvCampList*.stvcampDesc
  }

}
