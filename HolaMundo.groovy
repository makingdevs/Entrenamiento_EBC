class HolaMundo {

  String nombre

  def saluda() {
    "Hola " + this.nombre + " !!!"
  }

  static main(args) {
    def obj = new HolaMundo()
    obj.setNombre("Juan - Paso 4")
    println(obj.saluda())
  }
}
