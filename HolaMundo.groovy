class HolaMundo {

  String nombre

  def saluda() { "Hola ${nombre} !!!" }

  static main(args) {
    def obj = new HolaMundo()
    obj.setNombre("Juan - Paso 5")
    println(obj.saluda())
  }
}
