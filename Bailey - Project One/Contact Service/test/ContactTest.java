// ContactTest.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 23 2025
//
// This is the JUnit tests for Contact.java created in 
// Module Three for Milestone One.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	@Test
	// Validate a valid contact can be created and fetched
	public void testValidContactCreation() {
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
	    assertEquals("12345", contact.getContactID());
	    assertEquals("John", contact.getFirstName());
	    assertEquals("Doe", contact.getLastName());
	    assertEquals("1234567890", contact.getPhoneNumber());
	    assertEquals("123 Main St", contact.getAddress());
	}
	
	@Test
	// Validates that IllegalArgumentException is thrown when creating a contactID of null
	public void testNullContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Johnny", "Appleseed", "1234567890", "123 Main St");
		});
	}
	
	@Test
	// Validates that IllegalArgumentException is thrown when creating a contactID that is too long
	public void testContactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890001", "Johnny", "Appleseed", "1234567890", "123 Main St");
		});
	}
	
	@Test
	// Validates that IllegalArgumentException is thrown when a phone number is not 10 digits
	public void testInvalidPhoneNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Johnny", "Appleseed", "87778", "123 Main St");
		});
	}
	
	@Test
	//
	public void testUpdatingData() {
		Contact contact = new Contact("12345", "Johnny", "Appleseed", "1234567890", "123 Main St");
		contact.setFirstName("Jane");
		contact.setLastName("Smithy");
		contact.setPhoneNumber("0987654321");
		contact.setAddress("400 Water St");
		
		assertEquals("Jane", contact.getFirstName());
	    assertEquals("Smithy", contact.getLastName());
	    assertEquals("0987654321", contact.getPhoneNumber());
	    assertEquals("400 Water St", contact.getAddress());
	}
}





