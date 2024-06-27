public class TaskStoreSimpleImpl implements TaskStore {

	static List tasks = []

  void createTask(Task task){
		tasks << task
	}
  Task readTask(Long pk){
		tasks.find { t -> t.id == pk }
  }
  Task findTask(String description){
		tasks.find { t -> t.description == description }
  }
  List<Task> findAllTasks(String description){
		tasks.findAll { t -> t.description == description }
  }
  int count(){
		tasks.size()
  }
}
