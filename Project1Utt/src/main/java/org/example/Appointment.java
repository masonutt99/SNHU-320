package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {

    private String appointmentID;
    private Date appointmentDate;
    private String appointmentDescription;


    private static final int ID_LENGTH = 10;
    private static final int DESCRIPTION_LENGTH = 50;

    String initDateString = "12-31-2023";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
    Date initDate;

    {
        try {
            initDate = simpleDateFormat.parse(initDateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public Appointment(){
        this.appointmentID = "init";
        this.appointmentDate = initDate;
        this.appointmentDescription = "init";
    }


    public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription){
        setAppointmentID(appointmentID);
        setAppointmentDate(appointmentDate);
        setAppointmentDescription(appointmentDescription);
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID cannot be empty");
        }
        else if (appointmentID.length()> ID_LENGTH){
            throw new IllegalArgumentException("Appointment ID cannot be longer than " + ID_LENGTH + " chars");
        }
        else {
            this.appointmentID = appointmentID;
        }
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        Date now = new Date();
        if (appointmentDate == null){
            throw new IllegalArgumentException("Appointment Date cannot be empty");
        } else if (appointmentDate.before(now)) {
            throw new IllegalArgumentException("Appointment Date cannot be in the past");
        }else {
            this.appointmentDate = appointmentDate;
        }
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        if (appointmentDescription == null) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        else if (appointmentDescription.length()> DESCRIPTION_LENGTH){
            throw new IllegalArgumentException("Description cannot be longer than " + DESCRIPTION_LENGTH + " chars");
        }
        else {
            this.appointmentDescription = appointmentDescription;
        }
    }
}
