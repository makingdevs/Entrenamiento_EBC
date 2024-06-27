import static org.junit.Assert.*
import org.junit.Test
import org.junit.Ignore
import org.junit.Before

class TaskManagerIntegrationTests {

  TaskManager taskManager

  @Before
  void setup(){
		TaskStore taskStore = new TaskStoreSimpleImpl()
		TaskStore taskStore2 = new TaskStoreVectorImpl()
    taskManager = new TaskManager(taskStore: taskStore2)
  }

  @Test
	@Ignore
  void aTaskManagerWithZeroTasks(){
    assertNotNull(taskManager)
    assertTrue(taskManager.howManyTasks() == 0)
  }

  @Test
  void aTaskManagerWithOneTasks(){
    assertNotNull(taskManager)
    taskManager.addTask(new Task())
    assertTrue(taskManager.howManyTasks() >= 1)
  }

  @Test
  void addATaskFromAString(){
    assertNotNull(taskManager)
    taskManager.addTask("new task")
    assertTrue(taskManager.howManyTasks() >= 1)
  }

  @Test
  void addATasksFromAList(){
    assertNotNull(taskManager)
    List<Task> tasksToAdd = new ArrayList<Task>()
    tasksToAdd.add(new Task(1, "new task"))
    tasksToAdd.add(new Task(2, "new task"))
    taskManager.addTask(tasksToAdd)
    assertTrue(taskManager.howManyTasks() >= 2)
  }

  @Test
  void addATasksFromAFile(){
    // TODO: Implements the feature
    assertTrue(true)
  }

  @Test
  void getATaskByIndex(){
    addATaskFromAString()
    Task task = taskManager.getTaskAt(1)
    assertNotNull(task)
  }

  @Test
  void findTaskByDescription(){
    addATaskFromAString()
    Task task = taskManager.findTask("new task")
    assertNotNull(task)
  }

  @Test
  void findAllTasksByDescription(){
    addATasksFromAList()
    List<Task> tasksFound = taskManager.findTasks("new task")
    assertTrue(tasksFound.size() == 2)
  }

}
