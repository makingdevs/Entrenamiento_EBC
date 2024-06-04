class HolaMundo {

  String nombre

  String saluda() {
    return "Hola " + this.nombre + " !!!"
  }

  static void main(String[] args) {
    HolaMundo obj = new HolaMundo()
    obj.setNombre("Juan - Paso 2")
    System.out.println(obj.saluda())
  }
}
