import org.example.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    protected String contactId, firstName, lastName, phoneNumber, address;
    protected String failContactId, failFirstName, failLastName, failPhoneNumberLong, failPhoneNumberShort, failAddress;

    @BeforeEach
    void setUp() {
        contactId = "masonutt10";
        firstName = "Mason";
        lastName = "Utt";
        phoneNumber = "1234567890";
        address = "250 R Rd, Manchester, NH 03106";

        failContactId = "masonmason111";
        failFirstName = "reallylongfirstname";
        failLastName = "reallylonglastname";
        failPhoneNumberLong = "01234567890123456789";
        failPhoneNumberShort = "123456789";
        failAddress = "2500 N River Rd, Mandchester, NH 03106";
    }

    @Test
    void contactTest() {
        Contact contact = new Contact();
        assertAll("empty constructor",
                ()
                        -> assertNotNull(contact.getContactID()),
                ()
                        -> assertNotNull(contact.getFirstName()),
                ()
                        -> assertNotNull(contact.getLastName()),
                ()
                        -> assertNotNull(contact.getPhoneNumber()),
                ()
                        -> assertNotNull(contact.getAddress()));
    }

    @Test
    void contactTestContact() {
        Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        assertAll("constructor all params",
                ()
                        -> assertEquals(contactId, contact.getContactID()),
                ()
                        -> assertEquals(firstName, contact.getFirstName()),
                ()
                        -> assertEquals(lastName, contact.getLastName()),
                ()
                        -> assertEquals(phoneNumber, contact.getPhoneNumber()),
                ()
                        -> assertEquals(address, contact.getAddress()));
    }

    @Test
    void setContactIdTest(){
        Contact contact = new Contact();
        contact.setContactID(contactId);
        assertAll("test set contact ID",
                ()
                        -> assertEquals(contactId, contact.getContactID()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setContactID(failContactId)),     //cant be longer than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setContactID(null)));             //cant be null

    }

    @Test
    void setFirstNameTest(){
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        assertAll("test set first name",
                ()
                        -> assertEquals(firstName, contact.getFirstName()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                            ->contact.setFirstName(failFirstName)),         //cant be longer than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setFirstName(null)));             //cant be null

    }

    @Test
    void setLastNameTest(){
        Contact contact = new Contact();
        contact.setLastName(lastName);
        assertAll("test set last name",
                ()
                        -> assertEquals(lastName, contact.getLastName()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setLastName(failLastName)),       //cant be longer than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setLastName(null)));              //cant be null

    }

    @Test
    void setPhoneNumberTest(){
        Contact contact = new Contact();
        contact.setPhoneNumber(phoneNumber);
        assertAll("test set phone number",
                ()
                        -> assertEquals(phoneNumber, contact.getPhoneNumber()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setPhoneNumber(failPhoneNumberLong)),     //cant be longer than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setPhoneNumber(failPhoneNumberShort)),    //cant be shorter than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setPhoneNumber(null)));                   //cant be null

    }

    @Test
    void setAddressTest(){
        Contact contact = new Contact();
        contact.setAddress(address);
        assertAll("test set address",
                ()
                        -> assertEquals(address, contact.getAddress()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setAddress(failAddress)),                 //cant be longer than 30
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->contact.setAddress(null)));                       //cant be null

    }



}
