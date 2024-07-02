package mx.ebc.data

import mx.ebc.config.DataJpaConfig
import mx.ebc.data.jpa.EmpleadoJPARepository
import mx.ebc.model.Empleado
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [DataJpaConfig])
class EmpleadoJpaRepositorySpec extends Specification {

  @Autowired
  EmpleadoJPARepository empleadoJPARepository

  void "should exist the bean 'EmpleadoRepository' in spring"() {
    expect:
      empleadoJPARepository
  }

  void "should create a new Employee"() {
    given:
      Empleado e = new Empleado(
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")

    when:
      Empleado empleadoCreado = empleadoJPARepository.save(e)

    then:
      empleadoCreado
  }

  void "should retrieve de number of employees"() {
    expect:
      empleadoJPARepository.count()
  }

  void "should retrieve a List of Employees"() {
    when:
      List<Empleado> empleados = empleadoJPARepository.findAll()
      println empleados

    then:
      empleados
      empleados*.trab_id
  }

  void "should retrieve one Employee"() {
    given:
    String trabId = "1"

    when:
    Optional<Empleado> optionalEmpleado = empleadoJPARepository.findById(trabId)

    then:
    optionalEmpleado.get()
    optionalEmpleado.get().trab_id == "1"
    optionalEmpleado.get().nombre == "Reyna"
  }

}
