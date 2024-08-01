package mx.ebc.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@groovy.transform.ToString
@Entity(name = "EMPLEADOS")
class Empleado {
  @Id
  String trab_id
  String paterno
  String materno
  String nombre
}
