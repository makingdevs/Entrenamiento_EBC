public class UsoPersona {
  private String algo;

  public void setAlgo(String algo){ this.algo = algo; }
  public String getAlgo(){ return this.algo; }

  public static void main(String[] args){
    Persona p = new Persona("Juan");
    p.setNombre("Juan");
    System.out.println(p);
  }
}
