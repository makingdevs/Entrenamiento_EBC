class HolaMundo {

  String nombre

  def saluda() { "Hola ${nombre} !!!" }

  static main(args) {
    def obj = new HolaMundo(nombre: "EBC")
    println obj.saluda()
    obj.setNombre("Juan - Paso 6")
    println obj.saluda()
    obj.nombre = "MakingDevs"
    println obj.saluda()
    obj["nombre"] = "Hola Inmundo"
    println obj.saluda()
    println obj.nombre
  }
}
