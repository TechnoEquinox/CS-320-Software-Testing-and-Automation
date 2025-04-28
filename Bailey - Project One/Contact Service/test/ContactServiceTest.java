// ContactServiceTest.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 23 2025
//
//

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	private ContactService service;
	private Contact sampleContact;
	
	@BeforeEach
	public void setUp() {
		service = new ContactService();
		sampleContact = new Contact("001", "Alice", "Smithy", "1234567890", "123 Oak Street");
		service.addContact(sampleContact);
	}
	
	@Test
	// Validates a new contact can be added through the service
	public void testAddContactSuccess() {
		Contact newContact = new Contact("002", "Bob", "Jones", "0987654321", "456 Water Street");
        service.addContact(newContact);
        // No exception means success
	}
	
	@Test
	// Validates the rejection of duplicate contactIDs
	public void testAddContactDuplicateID() {
		Contact duplicateContact = new Contact("001", "Charlie", "Brown", "1112223333", "789 Prospect Ave");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicateContact);
        });
	}
	
	@Test
	// Validates deleting a contact through the service
	public void testDeleteContactSuccess() {
		service.deleteContact("001");
		assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("001"); // now fails
        });
	}
	
	@Test
	// Validates updating the first name through the service
    public void testUpdateFirstName() {
        service.updateFirstName("001", "Alicia");
        assertEquals("Alicia", sampleContact.getFirstName());
    }

    @Test
    // Validates updating the last name through the service
    public void testUpdateLastName() {
        service.updateLastName("001", "Johnson");
        assertEquals("Johnson", sampleContact.getLastName());
    }

    @Test
    // Validates updating the phone number through the service
    public void testUpdatePhoneNumber() {
        service.updatePhoneNumber("001", "5555555555");
        assertEquals("5555555555", sampleContact.getPhoneNumber());
    }

    @Test
    // Validates updating the address through the service
    public void testUpdateAddress() {
        service.updateAddress("001", "987 Pine Lane");
        assertEquals("987 Pine Lane", sampleContact.getAddress());
    }

    @Test
    // Validates a contact that does not exist cannot be updated
    public void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhoneNumber("999", "0000000000");
        });
    }
}