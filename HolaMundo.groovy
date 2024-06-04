class HolaMundo {

  String nombre

  def saluda() {
    return "Hola " + this.nombre + " !!!"
  }

  static def main(args) {
    def obj = new HolaMundo()
    obj.setNombre("Juan - Paso 3")
    println(obj.saluda())
  }
}
