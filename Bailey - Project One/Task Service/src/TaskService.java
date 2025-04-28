// TaskService.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 30 2025
//
// This is the TaskService that manages Tasks in memory.

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	private final Map<String, Task> tasks = new HashMap<>();
	
	// Add a new task to the HashMap
	public void addTask(Task task) {
		if (task == null || tasks.containsKey(task.getTaskID())) {
			throw new IllegalArgumentException("Task is null or taskID already exists.");
		}
		
		tasks.put(task.getTaskID(), task);
	}
	
	// Remove a task from the HashMap
	public void deleteTask(String taskID) {
		if (!tasks.containsKey(taskID)) {
			throw new IllegalArgumentException("TaskID does not exist.");
		}
		
		tasks.remove(taskID);
	}
	
	// Update an existing task name
	public void updateTaskName(String taskID, String name) {
		Task task = tasks.get(taskID);
		if (task == null) {
			throw new IllegalArgumentException("TaskID does not exist.");
		}
		
		task.setName(name);
	}
	
	// Update an existing task description
	public void updateTaskDescription(String taskID, String description) {
		Task task = tasks.get(taskID);
		if (task == null) {
			throw new IllegalArgumentException("TaskID does not exist.");
		}
		
		task.setDescription(description);
	}
}