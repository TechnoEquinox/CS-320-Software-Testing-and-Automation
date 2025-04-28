// Task.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 30 2025
//
// This is the JUnit tests for Task.java created in 
// Module Four for Milestone Two.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
	
	@Test
	// Validates creating a new valid task
	public void testValidTaskCreation() {
		Task task = new Task("1234567890", "First Task", "This is a valid task description.");
        assertEquals("1234567890", task.getTaskID());
        assertEquals("First Task", task.getName());
        assertEquals("This is a valid task description.", task.getDescription());
	}
	
	@Test
	// Validates taskID length
	public void testTaskIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Valid description.");
        });
	}
	
	@Test
	// Validates taskID being null
	public void testTaskIDNull() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Valid description.");
        });
	}
	
	@Test
	// Validates the task name length
	public void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "This name is way too long!", "Valid description.");
        });
	}
	
	@Test 
	// Validates task name being null
	public void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", null, "Valid description.");
        });
	}
	
	@Test
	// Validates description length
	public void testDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", "This description is more than 50 characters which exceeds the maximum length of a description.");
		});
	}
	
	@Test
	// Validates description being null
	public void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", null);
        });
	}
	
	@Test
	// Validates valid updating of name
	public void testSetNameValid() {
		Task task = new Task("001", "Initial Name", "Inital Description");
        task.setName("Updated Name");
        assertEquals("Updated Name", task.getName());
	}
	
	@Test
	// Validates rejection of updating name with a name that is too long
	public void testSetNameTooLong() {
		Task task = new Task("001", "Initial Name", "Inital Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName("John Jacob Jingleheimer Schmidt");
        });
	}
	
	@Test
	// Validates name cannot be set to null
    public void testSetNameNull() {
        Task task = new Task("001", "Initial Name", "Inital Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    // Validates updating the description with another valid description
    public void testSetDescriptionValid() {
        Task task = new Task("002", "Initial Name", "Inital Description");
        task.setDescription("Updated description.");
        assertEquals("Updated description.", task.getDescription());
    }

    @Test
    // Validates rejecting a description that is too long
    public void testSetDescriptionTooLong() {
        Task task = new Task("002", "Initial Name", "Inital Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is more than 50 characters which exceeds the maximum length of a description.");
        });
    }

    @Test
    // Validates rejecting a description of null
    public void testSetDescriptionNull() {
        Task task = new Task("002", "Initial Name", "Inital Description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}