import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;

public class TaskManager {

  private TaskStore taskStore = new TaskStore();

  public int howManyTasks() {
    return taskStore.count();
  }

  public void addTask(Task task) {
    taskStore.createTask(task);
  }

  public void addTask(String description) {
    Task task = new Task();
    // Nothing with description
    taskStore.createTask(task);
  }

  public void addTask(List<Task> tasksToAdd) {
    for(Task task:tasksToAdd){
      taskStore.createTask(task);
    }
  }

  public Task getTaskAt(int i) {
    return taskStore.readTask(new Integer(i).longValue());
  }

  public Task findTask(String description) {
    return taskStore.findTask(description);
  }

  public List<Task> findTasks(String description) {
    return taskStore.findAllTasks(description);
  }
}
