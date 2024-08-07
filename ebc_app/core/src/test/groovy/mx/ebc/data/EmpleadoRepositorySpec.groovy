package mx.ebc.data

import spock.lang.Specification
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.*
import mx.ebc.config.DataConfig
import javax.sql.DataSource
import org.springframework.jdbc.core.JdbcTemplate
import mx.ebc.model.Empleado
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@ContextConfiguration(classes = [DataConfig])
@Transactional
@Rollback(true)
class EmpleadoRepositorySpec extends Specification {

  @Autowired
  EmpleadoRepository empleadoRepository

  @Autowired
  ApplicationContext applicationContext

  @Autowired
  DataSource dataSource

  @Autowired
  JdbcTemplate jdbcTemplate

  @Autowired
  AllTermsSP allTermsSP

  void "should exist the bean 'EmpleadoRepository' in spring"() {
    expect:
      applicationContext
      empleadoRepository
  }

  void "should exist the bean 'DataSource' in spring"() {
    expect:
      dataSource
  }

  void "should exist the bean 'JdbcTemplate' in spring"() {
    expect:
      jdbcTemplate
  }

  void "should create a new Employee"() {
    given:
      String id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")

    when:
      int result = empleadoRepository.createEmpleado(e)

    then:
      result
  }

  void "should retrieve de number of employees"() {
    given:
      String id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      empleadoRepository.createEmpleado(e)
    expect:
      empleadoRepository.countEmpleados()
  }

  void "should retrieve a List of Employees"() {
    given:
      String id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      empleadoRepository.createEmpleado(e)
    when:
      List<Empleado> empleados = empleadoRepository.listEmpleados()
      println empleados

    then:
      empleados
      empleados*.trab_id
  }

  void "should retrieve one Employee"() {
    given:
      String id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      empleadoRepository.createEmpleado(e)

    when:
    Empleado empleado = empleadoRepository.findEmpleadoById(id)

    then:
    empleado
    empleado.trab_id == id
    empleado.nombre == "Juan"
  }

  void "should retrieve a term codes"() {
    when:
      List termCode = allTermsSP.execute("202420")

    then:
      termCode[0].term_code == "202420"
      termCode[0].term_desc == "202420 Lic Feb-Jun 24"
  }
}
