// AppointmentService.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// April 6 2025
//
// This is the AppointmentServices that manages
// appointments in memory with a Hash Map for Module Five.

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
	
	// in memory storage for appointments
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	// Add a new appointment with a unique appointmentID
	public void addAppointment(Appointment appointment) {
		if (appointments.containsKey(appointment.getAppointmentID())) {
			throw new IllegalArgumentException("appointmentID already exists");
		}
		
		appointments.put(appointment.getAppointmentID(), appointment);
	}
	
	// Delete an appointment by appointmentID
	public void deleteAppointment(String appointmentID) {
		if (!appointments.containsKey(appointmentID)) {
			throw new IllegalArgumentException("appointmentID not found");
		}
		
		appointments.remove(appointmentID);
	}
	
	// Get an appointment by appointmentID
	public Appointment getAppointment(String appointmentID) {
		return appointments.get(appointmentID);
	}
}