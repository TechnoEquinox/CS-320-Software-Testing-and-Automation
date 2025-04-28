// Contact.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// March 23 2025
//
// This is the base contact class created in Module Three
// for Milestone One.


public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		// Validate the contact data 
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contactID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// Getters
	public String getContactID() { 
		return contactID; 
	}
	public String getFirstName() { 
		return firstName; 
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// Setters with data validation
	public void setFirstName(String firstName) {
	    if (firstName == null || firstName.length() > 10) {
	    	throw new IllegalArgumentException("Invalid first name");
	    }
	    
	    this.firstName = firstName;
	}

	public void setLastName(String lastName) {
	    if (lastName == null || lastName.length() > 10) {
	    	throw new IllegalArgumentException("Invalid last name");
	    }
	        
	    this.lastName = lastName;
	}

	public void setPhoneNumber(String phone) {
	    if (phone == null || phone.length() != 10) {
	    	throw new IllegalArgumentException("Invalid phone number");
	    }
	        
	    this.phone = phone;
	}

	public void setAddress(String address) {
	    if (address == null || address.length() > 30) {
	    	throw new IllegalArgumentException("Invalid address");
	    }
	        
	    this.address = address;
	}
}
