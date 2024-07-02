package mx.ebc.data.jpa

import mx.ebc.model.Empleado
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface EmpleadoJPARepository extends CrudRepository<Empleado, String> {

}