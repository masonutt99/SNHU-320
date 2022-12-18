package org.example;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private ArrayList<Appointment> appointments; //list of appointments

    public AppointmentService(){
        appointments = new ArrayList<>();
    }


    //The appointment service shall be able to add appointments with a unique ID.
    public void addAppointment(Appointment appointment) throws Exception {
        boolean exists = false;
        for(Appointment a:appointments){
            if (a.getAppointmentID().equals(appointment.getAppointmentID())) {
                exists = true;
                break;
            }
        }
        if (exists){
            throw new Exception("Appointment with that ID already exists.");
        }else {
            appointments.add(appointment);
        }
    }


    //The appointment service shall be able to delete appointments with a unique ID.
    public void deleteAppointment(String appointmentID) throws Exception {
        Appointment appointment = appointmentAtID(appointmentID);
        appointments.remove(appointment);
    }


    public Appointment appointmentAtID(String aID) throws Exception{
        for (Appointment appointment : appointments) {
            if (aID.equals(appointment.getAppointmentID())) {
                return appointment;
            }
        }
        throw new Exception("Appointment ID does not exist");
    }

    public List<Appointment> getList(){
        return appointments;
    }




}
