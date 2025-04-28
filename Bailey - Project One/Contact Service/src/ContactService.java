// ContactService.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 23 2025
//
// This is the service that handles Contact data in memory,
// created in Module Three for Milestone One.

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// Add a new contact
	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Invalid or duplicate contact");
		}
		
		contacts.put(contact.getContactID(), contact);
	}
	
	// Delete a contact
	public void deleteContact(String contactID) {
		if (!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("ContactID not found");
		}
		
		contacts.remove(contactID);
	}
	
	// Update first name
	public void updateFirstName(String contactID, String newFirstName) {
		Contact contact = contacts.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		
		contact.setFirstName(newFirstName);
	}
	
	// Update last name
	public void updateLastName(String contactID, String newLastName) {
		Contact contact = contacts.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		
		contact.setLastName(newLastName);
	}
	
	// Update phone number
	public void updatePhoneNumber(String contactID, String newPhoneNumber) {
		Contact contact = contacts.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		
		contact.setPhoneNumber(newPhoneNumber);
	}
	
	// Update address
	public void updateAddress(String contactID, String newAddress) {
		Contact contact = contacts.get(contactID);
		if (contact == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		
		contact.setAddress(newAddress);
	}
}