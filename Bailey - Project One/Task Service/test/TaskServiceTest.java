// TaskServiceTest.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 30 2025
//
// This is the JUnit tests for TaskService.java created in
// Module Four for Milestone Two.


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	private TaskService taskService;
	
	@BeforeEach
	public void setUp() {
		taskService = new TaskService();
	}
	
	@Test
	public void testAddValidTask() {
		Task task = new Task("001", "Task One", "This is task one.");
		assertDoesNotThrow(() -> taskService.addTask(task));
	}
	
	@Test
	public void testAddDuplicateTaskID() {
		Task task1 = new Task("001", "Task One", "This is task one.");
        Task task2 = new Task("001", "Task Two", "This is task two.");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
	}
	
	@Test
	public void testDeleteTask() {
		Task task = new Task("002", "Task Two", "Task will be deleted.");
        taskService.addTask(task);
        assertDoesNotThrow(() -> taskService.deleteTask("002"));
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("002"));
	}
	
	@Test
	public void testDeleteNonexistentTask() {
		assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask("999"));
	}
	
	@Test 
	public void testUpdateTaskName() {
		Task task = new Task("003", "Inital Name", "Inital Description");
        taskService.addTask(task);
        assertDoesNotThrow(() -> taskService.updateTaskName("003", "New Name"));
	}
	
	@Test
	public void testUpdateTaskDescription() {
		Task task = new Task("004", "Inital Name", "Inital Description.");
        taskService.addTask(task);
        assertDoesNotThrow(() -> taskService.updateTaskDescription("004", "New Description."));
    }
	
	@Test
	public void testUpdateNonexistentTask() {
		assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("888", "Task 888"));
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("888", "Task Description."));
	}
	
	@Test
	public void testUpdateTaskWithInvalidName() {
		Task task = new Task("005", "Inital Name", "Inital Description");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("005", null));
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskName("005", "This name is too long to be a valid task name."));
	}
	
	@Test
	public void testUpdateTaskWithInvalidDescription() {
		Task task = new Task("006", "Task #6", "This is a cool task.");
        taskService.addTask(task);
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("006", null));
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTaskDescription("006", "This description is way too long and goes beyond the 50 character maximum limit allowed."));
	}
}