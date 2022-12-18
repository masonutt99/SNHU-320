import org.example.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class AppointmentTest {
    protected String appointmentID, appointmentDescription;
    protected Date appointmentDate;

    protected String failAppointmentID, failAppointmentDescription;
    protected Date failAppointmentDate;

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    @BeforeEach
    void setUp() throws ParseException {
        appointmentID = "masonutt10";
        appointmentDescription = "Mason";
        appointmentDate = sdf.parse("12-31-2022");

        failAppointmentID = "masonmason111";
        failAppointmentDescription = "This description is really long so long in fact it is longer than fifty characters that is really long.";
        failAppointmentDate = sdf.parse("10-31-2022");
    }

    @Test
    void appointmentTest(){
        Appointment appointment = new Appointment();
        assertAll("empty constructor",
                ()
                        ->assertNotNull(appointment.getAppointmentID()),
                ()
                        ->assertNotNull(appointment.getAppointmentDate()),
                ()
                        ->assertNotNull(appointment.getAppointmentDescription())
                );
    }


    @Test
    void appointmentTest2(){
        Appointment appointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
        assertAll("empty constructor",
                ()
                        ->assertEquals(appointmentID, appointment.getAppointmentID()),
                ()
                        ->assertEquals(appointmentDate, appointment.getAppointmentDate()),
                ()
                        ->assertEquals(appointmentDescription, appointment.getAppointmentDescription())
        );
    }


    @Test
    void setAppointmentIDTest(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentID(appointmentID);
        assertAll("test setting appointment ID",
                ()
                        ->assertEquals(appointmentID, appointment.getAppointmentID()),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->appointment.setAppointmentID(failAppointmentID)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->appointment.setAppointmentID(null)));
    }


    @Test
    void setAppointmentDescriptionTest(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentDescription(appointmentDescription);
        assertAll("test setting appointment Description",
                ()
                        ->assertEquals(appointmentDescription, appointment.getAppointmentDescription()),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->appointment.setAppointmentDescription(failAppointmentDescription)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->appointment.setAppointmentDescription(null)));
    }


    @Test
    void setAppointmentDateTest(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDate);
        assertAll("test setting appointment Date",
                ()
                        ->assertEquals(appointmentDate, appointment.getAppointmentDate()),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->appointment.setAppointmentDate(failAppointmentDate)),  //Passed date
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->appointment.setAppointmentID(null)));
    }
}
