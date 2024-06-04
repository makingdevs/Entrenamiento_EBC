import java.util.*;
import java.net.*;

public class Hola {

  public static void main(String[] args){
    Date d = new Date();
    System.out.println(d);
    try{
    URL url = new URL("https://makingdevs.com");
    System.out.println(url);
    } catch(Exception e) {
    }
  }
}
