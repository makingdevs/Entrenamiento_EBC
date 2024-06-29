package mx.ebc.model

@groovy.transform.ToString
class Empleado{
  String trab_id = new Date().time.toString()
  String paterno
  String materno
  String nombre
}
