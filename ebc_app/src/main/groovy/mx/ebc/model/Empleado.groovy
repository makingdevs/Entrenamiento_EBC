package mx.ebc.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@groovy.transform.ToString
@Entity(name = "EMPLEADOSPRUEBA")
class Empleado {
  @Id
  String trab_id = new Date().time.toString()
  String paterno
  String materno
  String nombre
}
