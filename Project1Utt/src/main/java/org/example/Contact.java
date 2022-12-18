package org.example;

public class Contact {

    //SHALL NOT BE NULL
    private String contactID;   //no longer than 10 char
    private String firstName;   //no longer than 10 char
    private String lastName;    //no longer than 10 char
    private String phoneNumber; //exactly 10 digits
    private String address;     //no longer than 30 char


    private static final int IDLENGTH = 10;
    private static final int NAMELENGTH = 10;
    private static final int ADDRESSLENGTH = 30;
    private static final int PHONELENGTH = 10;

    public Contact(){
        this.contactID  = "Init";
        this.firstName = "Init";
        this.lastName = "Init";
        this.phoneNumber = "1234567890";
        this.address = "Init";
    }

    //constructor
    public Contact(String setContactID, String setfirstName, String setlastName, String phoneNumber, String address){
        setContactID(setContactID);
        setFirstName(setfirstName);
        setLastName(setlastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String setContactID) {
        if (setContactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be empty");
        }
        else if (setContactID.length()> IDLENGTH){
            throw new IllegalArgumentException("Contact ID cannot be longer than " + IDLENGTH + " chars");
        }
        else {
            this.contactID = setContactID;
        }
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        else if (firstName.length()>NAMELENGTH){
            throw new IllegalArgumentException("First name cannot be longer than " + NAMELENGTH + " chars");
        }
        else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        else if (lastName.length()>NAMELENGTH){
            throw new IllegalArgumentException("Last name cannot be longer than " + NAMELENGTH + " chars");
        }
        else {
            this.lastName = lastName;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        else if (phoneNumber.length()!=PHONELENGTH){
            throw new IllegalArgumentException("Phone number must be exactly " + PHONELENGTH + " digits");
        }
        else {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        else if (address.length()>ADDRESSLENGTH){
            throw new IllegalArgumentException("Address cannot be longer than " + ADDRESSLENGTH + " chars");
        }
        else {
            this.address = address;
        }
    }
}
