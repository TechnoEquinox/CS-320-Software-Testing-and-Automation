// Appointment.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// April 6 2025
//
// This is the base appointment class used by
// the AppointmentService.java for Module Five.


import java.util.Date;

public class Appointment {
	
	// Appointment fields
	private final String appointmentID;
	private final Date appointmentDate;
	private final String description;
	
	public Appointment(String appointmentID, Date appointmentDate, String description) {
		// Validation
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointmentID");
		}
		
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		
		// After values have been validated, assign them
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	// Getters
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getDescription() {
		return description;
	}
}