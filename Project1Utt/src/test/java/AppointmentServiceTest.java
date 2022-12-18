import org.example.Appointment;
import org.example.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
//The appointment service shall be able to add appointments with a unique appointment ID.
//The appointment service shall be able to delete appointments per appointment ID.
public class AppointmentServiceTest {
    protected String appointmentID, appointmentDescription;
    protected Date appointmentDate;

    protected String appointmentID1, appointmentDescription1;
    protected Date appointmentDate1;

    protected String failAppointmentID, failAppointmentDescription;
    protected Date failAppointmentDate;

    protected String init;
    protected Date initDate;

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    @BeforeEach
    void setUp() throws ParseException {
        appointmentID = "masonutt10";
        appointmentDescription = "Mason";
        appointmentDate = sdf.parse("12-31-2022");


        appointmentID1 = "masonutt11";
        appointmentDescription1 = "Mason Utt";
        appointmentDate1 = sdf.parse("01-01-2023");


        failAppointmentID = "masonmason111";
        failAppointmentDescription = "This description is really long so long in fact it is longer than fifty characters that is really long.";
        failAppointmentDate = sdf.parse("10-31-2022");

        init = "init";
        initDate = sdf.parse("12-31-2023");
    }


    @Test
    void addAppointmentTest() throws Exception{
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = new Appointment();
        appointmentService.addAppointment(appointment);
        assertAll("tests adding an empty appointment to the list",
                ()
                        ->assertNotNull(appointmentService.getList().get(0).getAppointmentID()),
                ()
                        ->assertEquals(init, appointmentService.getList().get(0).getAppointmentID()),
                ()
                        ->assertEquals(initDate, appointmentService.getList().get(0).getAppointmentDate()),
                ()
                        ->assertEquals(init, appointmentService.getList().get(0).getAppointmentDescription())
                );
    }

    @Test
    void addAppointmentTest2() throws Exception{
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment1 = new Appointment(appointmentID, appointmentDate, appointmentDescription);
        Appointment appointment2 = new Appointment(appointmentID, appointmentDate1, appointmentDescription1);
        Appointment appointment3 = new Appointment(appointmentID1, appointmentDate1, appointmentDescription1);
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment3);
        assertAll("tests Adding full appointments to the list",
                ()
                        -> assertNotNull(appointmentService.getList().get(0).getAppointmentID()),
                ()
                        -> assertEquals(appointmentID, appointmentService.getList().get(0).getAppointmentID()),
                ()
                        -> assertEquals(appointmentDate, appointmentService.getList().get(0).getAppointmentDate()),
                ()
                        -> assertEquals(appointmentDescription, appointmentService.getList().get(0).getAppointmentDescription()),
                ()
                        -> assertThrows(Exception.class,
                        ()
                                -> appointmentService.addAppointment(appointment2)),      //cant add a appointmentID that already exists
                ()
                        -> assertNotNull(appointmentService.getList().get(1).getAppointmentID()),
                ()
                        -> assertEquals(appointmentID1, appointmentService.getList().get(1).getAppointmentID()),
                ()
                        -> assertEquals(appointmentDate1, appointmentService.getList().get(1).getAppointmentDate()),
                ()
                        -> assertEquals(appointmentDescription1, appointmentService.getList().get(1).getAppointmentDescription())
        );
    }


    @Test
    void deleteAppointmentTest() throws Exception{
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment1 = new Appointment(appointmentID, appointmentDate, appointmentDescription);
        Appointment appointment2 = new Appointment(appointmentID1, appointmentDate1, appointmentDescription1);
        Appointment appointment3 = new Appointment();
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);
        appointmentService.addAppointment(appointment3);
        appointmentService.deleteAppointment(appointmentID1);
        assertAll("tests deleting appointment from the list",
                ()
                        -> assertEquals(init, appointmentService.getList().get(1).getAppointmentID()),
                ()
                        -> assertEquals(initDate, appointmentService.getList().get(1).getAppointmentDate()),
                ()
                        -> assertEquals(init, appointmentService.getList().get(1).getAppointmentDescription())
        );
    }


    @Test
    void deleteAppointmentTestNoID() throws Exception {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
        appointmentService.addAppointment(appointment);
        assertAll("test deleting with bad contactID",
                ()
                        ->assertThrows(Exception.class,
                        ()
                                -> appointmentService.deleteAppointment(appointmentID1)));
    }

}
