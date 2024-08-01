package mx.ebc.data

import mx.ebc.config.DataJpaConfig
import mx.ebc.data.jpa.EmpleadoJPARepository
import mx.ebc.model.Empleado
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.annotation.Rollback

@ContextConfiguration(classes = [DataJpaConfig])
@Transactional
@Rollback(true)
class EmpleadoJpaRepositorySpec extends Specification {

  @Autowired
  EmpleadoJPARepository empleadoJPARepository

  static String id = ""

  void "should exist the bean 'EmpleadoRepository' in spring"() {
    expect:
      empleadoJPARepository
  }

  void "should create a new Employee"() {
    given:
      id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")

    when:
      Empleado empleadoCreado = empleadoJPARepository.save(e)

    then:
      empleadoCreado
  }

  void "should retrieve de number of employees"() {
    given:
      id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      Empleado empleadoCreado = empleadoJPARepository.save(e)

    expect:
      empleadoJPARepository.count()
  }

  void "should retrieve a List of Employees"() {
    given:
      id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      Empleado empleadoCreado = empleadoJPARepository.save(e)
    when:
      List<Empleado> empleados = empleadoJPARepository.findAll()

    then:
      empleados
      empleados*.trab_id
  }

  void "should retrieve one Employee"() {
    given:
      id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      Empleado empleadoCreado = empleadoJPARepository.save(e)

    when:
    Optional<Empleado> optionalEmpleado = empleadoJPARepository.findById(id)

    then:
    optionalEmpleado.get()
    optionalEmpleado.get().trab_id == id
    optionalEmpleado.get().nombre == "Juan"
  }

  void "should retrieve one Employee by 'Nombre'"() {
    given:
      id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      Empleado empleadoCreado = empleadoJPARepository.save(e)

    when:
    Optional<Empleado> optionalEmpleado = empleadoJPARepository.findByNombre("Juan")

    then:
    optionalEmpleado.get()
    optionalEmpleado.get().trab_id == id
    optionalEmpleado.get().paterno == "Reyes"
  }

  void "should retrieve one Employee by 'Nombre' and 'Paterno'"() {
    given:
      id = new Random().nextLong().toString()
      Empleado e = new Empleado(
        trab_id: id,
        nombre: "Juan",
        materno: "Zuniga",
        paterno: "Reyes")
      Empleado empleadoCreado = empleadoJPARepository.save(e)

    when:
    Optional<Empleado> optionalEmpleado = empleadoJPARepository.findByNombreAndPaterno("Juan", "Reyes")

    then:
    optionalEmpleado.get()
    optionalEmpleado.get().trab_id == id
    optionalEmpleado.get().materno == "Zuniga"
  }

}
