class TaskStoreVectorImpl implements TaskStore {

	static Vector<Task> tasks = []

  void createTask(Task task){
		println "Creando tasks"
		tasks.add(task)
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
