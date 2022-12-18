package org.example;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    //var declaration
    private ArrayList<Contact> contacts;    //list of contacts


    public ContactService(){
        contacts = new ArrayList<>();
    }

    //The contact service shall be able to add contacts with a unique ID.
    public void addContact(Contact contact) throws Exception {
        boolean exists = false;
        for(Contact c:contacts){
            if (c.getContactID().equals(contact.getContactID())) {
                exists = true;
                break;
            }
        }
        if (exists){
            throw new Exception("Contact with that ID already exists.");
        }else {
            contacts.add(contact);
        }
    }

//    The contact service shall be able to delete contacts per contact ID.
    public void deleteContact(String cID) throws Exception {
        Contact c = contactAtID(cID);
        contacts.remove(c);
    }

    //The contact service shall be able to update contact fields per contact ID.
    public void updateContactFirstName(String cID, String firstName)throws Exception{
        Contact c = contactAtID(cID);
        c.setFirstName(firstName);

    }

    public void updateContactLastName(String cID, String lastName)throws Exception{
        Contact c = contactAtID(cID);
        c.setLastName(lastName);
    }

    public void updateContactPhoneNumber(String cID, String phoneNumber)throws Exception{
        Contact c = contactAtID(cID);
        c.setPhoneNumber(phoneNumber);

    }

    public void updateContactAddress(String cID, String address) throws Exception{

        Contact c = contactAtID(cID);
        c.setAddress(address);
    }


    public Contact contactAtID(String cID) throws Exception{
        for (Contact contact : contacts) {
            if (cID.equals(contact.getContactID())) {
                return contact;
            }
        }
        throw new Exception("Contact ID does not exist");
    }

    public List<Contact> getList(){
        return contacts;
    }
}
