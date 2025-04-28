// AppointmentServiceTest.java
// Developer: Connor Bailey
// CS-320: Software Testing and Automation
// Professor Luo
// April 6 2025
//
// These are the JUnit tests for the 
// AppointmentService.java file for Module Five. 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

public class AppointmentServiceTest {
	
	private AppointmentService appointmentService;
	
	// Helper function to create a date in the future
	private Date getFutureDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 5);
		return cal.getTime();
	}
	
	@BeforeEach
	public void setUp() {
		appointmentService = new AppointmentService();
	}
	
	@Test
    public void testAddAppointmentSuccessfully() {
        Appointment appt = new Appointment("1234", getFutureDate(), "Eye check-up");
        appointmentService.addAppointment(appt);
        assertEquals(appt, appointmentService.getAppointment("1234"));
    }

    @Test
    public void testAddAppointmentWithDuplicateID() {
        Appointment appt1 = new Appointment("12345", getFutureDate(), "Checkup");
        Appointment appt2 = new Appointment("12345", getFutureDate(), "Follow-up");

        appointmentService.addAppointment(appt1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appt2);
        });

        assertEquals("appointmentID already exists", exception.getMessage());
    }

    @Test
    public void testDeleteAppointmentSuccessfully() {
        Appointment appt = new Appointment("123456", getFutureDate(), "Appointment description");
        appointmentService.addAppointment(appt);
        appointmentService.deleteAppointment("123456");

        assertNull(appointmentService.getAppointment("123456"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("797");
        });

        assertEquals("appointmentID not found", exception.getMessage());
    }
}