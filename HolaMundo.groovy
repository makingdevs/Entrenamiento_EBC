class HolaMundo {

  private String nombre
  String getNombre(){
    return this.nombre
  }
  void setNombre(String nombre){
    this.nombre = nombre
  }
  String saluda() {
    return "Hola " + this.nombre + " !!!"
  }

  static void main(String[] args) {
    HolaMundo obj = new HolaMundo()
    obj.setNombre("Juan - Paso 1")
    System.out.println(obj.saluda())
  }
}
