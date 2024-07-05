package mx.ebc.data.jpa

import mx.ebc.model.Empleado
import org.springframework.data.repository.CrudRepository

interface EmpleadoJPARepository extends CrudRepository<Empleado, String> {
    Optional<Empleado> findByNombre(String nombre)
    Optional<Empleado> findByNombreAndPaterno(String nombre, String paterno)
}