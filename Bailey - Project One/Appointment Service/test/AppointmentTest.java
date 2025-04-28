// AppointmentTest.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// April 6 2025
//
// These are the JUnit tests for the 
// Appointment.java base class

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {
	
	// Helper function to create a date in the future
	private Date getFutureDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 5);
		return cal.getTime();
	}
	
	// Helper function to create a date in the past
	private Date getPastDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -5);
		return cal.getTime();
	}
	
	@Test
	public void testValidAppointmentCreation() {
		Date futureDate = getFutureDate();
		Appointment apt = new Appointment("12345", futureDate, "Test appointment");
		assertEquals("12345", apt.getAppointmentID());
        assertEquals(futureDate, apt.getAppointmentDate());
        assertEquals("Test appointment", apt.getDescription());
	}
	
	@Test
    public void testNullAppointmentID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(), "Valid description");
        });
        assertEquals("Invalid appointmentID", exception.getMessage());
    }

    @Test
    public void testLongAppointmentID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", getFutureDate(), "Valid description");
        });
        assertEquals("Invalid appointmentID", exception.getMessage());
    }

    @Test
    public void testNullAppointmentDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", null, "Valid description");
        });
        assertEquals("Invalid appointment date", exception.getMessage());
    }

    @Test
    public void testPastAppointmentDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", getPastDate(), "Valid description");
        });
        assertEquals("Invalid appointment date", exception.getMessage());
    }

    @Test
    public void testNullDescription() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", getFutureDate(), null);
        });
        assertEquals("Invalid appointment description", exception.getMessage());
    }

    @Test
    public void testLongDescription() {
        String longDescription = "This description is much longer than the allowed character limit! This description should be shorter.";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", getFutureDate(), longDescription);
        });
        assertEquals("Invalid appointment description", exception.getMessage());
    }
	
}