// Task.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 30 2025
//
// This is the base task class created in Module Four
// for Milestone Two.

public class Task {
	private final String taskID;
	private String name;
	private String description;
	
	public Task(String taskID, String name, String description) {
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.taskID = taskID;
		this.name = name;
		this.description = description;
	}
	
	// Getters
	public String getTaskID() {
		return taskID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Setters
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		this.name = name;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.description = description;
	}
}