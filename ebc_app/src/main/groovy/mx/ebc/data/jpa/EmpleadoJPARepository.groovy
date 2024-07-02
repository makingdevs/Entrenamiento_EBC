package mx.ebc.data

import mx.ebc.model.Empleado
import org.springframework.data.repository.CrudRepository

interface EmpleadoJPARepository extends CrudRepository<Empleado, String> {

}