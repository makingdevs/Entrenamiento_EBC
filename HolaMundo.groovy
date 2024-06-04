public class HolaMundo {

  private String nombre;
  public String getNombre(){
    return this.nombre;
  }
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public String saluda() {
    return "Hola " + this.nombre + " !!!";
  }

  public static void main(String[] args) {
    HolaMundo obj = new HolaMundo();
    obj.setNombre("Juan");
    System.out.println(obj.saluda());
  }
}
