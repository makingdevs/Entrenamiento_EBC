import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.List
import java.util.Vector

class TaskManager {

  TaskStore taskStore

  int howManyTasks() {
    taskStore.count()
  }

  void addTask(Task task) {
    taskStore.createTask(task)
  }

  void addTask(String description) {
    Task task = new Task(description: description)
    taskStore.createTask(task)
  }

  void addTask(List<Task> tasksToAdd) {
    for(Task task:tasksToAdd){
      taskStore.createTask(task)
    }
  }

  Task getTaskAt(int i) {
    taskStore.readTask(new Integer(i).longValue())
  }

  Task findTask(String description) {
    taskStore.findTask(description)
  }

  List<Task> findTasks(String description) {
    taskStore.findAllTasks(description)
  }
}
