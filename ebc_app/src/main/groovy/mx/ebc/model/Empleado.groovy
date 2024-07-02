package mx.ebc.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@groovy.transform.ToString
@Entity
class Empleado{
  @Id
  String trab_id = new Date().time.toString()
  @Column
  String paterno
  @Column
  String materno
  @Column
  String nombre
}
