import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;

public class TaskManager {

  public static void main(String[] args) throws IOException {
    Vector<String> tasks = new Vector<String>();
    System.out.println("Write a tasks list, ends with an empty task.");
    String task = "";
    do{
      BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
      System.out.print("To Do: ");
      task = in.readLine();
      if(!task.equals(""))
        tasks.add(task);
    }while(!task.equals(""));
    System.out.println("You have " + tasks.size() + " tasks");
    System.out.println("Those are here: ");
    for(String t:tasks){
      System.out.println("* " + t);
    }
  }
}
