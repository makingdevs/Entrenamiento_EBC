@groovy.transform.ToString
class Persona implements Comparable {
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

  int compareTo(Object object) {
    // -x this es menor
    // 0 this es igual
    // +x this es mayor
    this.estatura - object.estatura
  }
}
