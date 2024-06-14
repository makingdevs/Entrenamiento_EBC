@groovy.transform.TupleConstructor
@groovy.transform.EqualsAndHashCode
@groovy.transform.ToString(includeNames=true)
class Persona {
  String nombre
  String apellidoPaterno
  String apellidoMaterno
  Date fechaDeNacimiento
  String sexo // Tipos fijos
  Integer estatura
  String nacionalidad
  Float peso

  Direccion direccion
  List<Telefono> telefonos

}
