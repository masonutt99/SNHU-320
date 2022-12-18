import org.example.Contact;
import org.example.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    protected String contactID, firstName, lastName, phoneNumber, address;
    protected String contactID1, firstName1, lastName1, phoneNumber1, address1;
    protected String init, initPhone;
    protected String failContactId, failFirstName, failLastName, failPhoneNumberLong, failPhoneNumberShort, failAddress;

    @BeforeEach
    void setUp() {
        contactID = "masonutt10";
        firstName = "Mason";
        lastName = "Utt";
        phoneNumber = "1234567890";
        address = "250 R Rd, Manchester, NH 03106";

        contactID1 = "masonutt11";
        firstName1 = "Madison";
        lastName1 = "Rodgers";
        phoneNumber1 = "8128810217";
        address1 = "606 W 3rd, Bicknell, IN 47591";

        init= "Init";
        initPhone = "1234567890";

        failContactId = "masonmason111";
        failFirstName = "reallylongfirstname";
        failLastName = "reallylonglastname";
        failPhoneNumberLong = "01234567890123456789";
        failPhoneNumberShort = "123456789";
        failAddress = "2500 N River Rd, Mandchester, NH 03106";
    }

    @Test
    void addContactTest() throws Exception {                                //adds a single contact
        ContactService contactService = new ContactService();
        Contact contact = new Contact();
        contactService.addContact(contact);
        assertAll("tests Adding empty contact to the list",
                ()
                        -> assertNotNull(contactService.getList().get(0).getContactID()),
                ()
                        -> assertEquals(init, contactService.getList().get(0).getContactID()),
                ()
                        -> assertEquals(init, contactService.getList().get(0).getFirstName()),
                ()
                        -> assertEquals(init, contactService.getList().get(0).getLastName()),
                ()
                        -> assertEquals(initPhone, contactService.getList().get(0).getPhoneNumber()),
                ()
                        -> assertEquals(init, contactService.getList().get(0).getAddress()));
    }

    @Test
    void addFilledContactTest() throws Exception {          //adds contacts
        ContactService contactService = new ContactService();
        Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        Contact contact1 = new Contact(contactID, firstName1, lastName1, phoneNumber1, address1);
        Contact contact2 = new Contact(contactID1, firstName1, lastName1, phoneNumber1, address1);
        contactService.addContact(contact);
        contactService.addContact(contact2);
        assertAll("tests Adding full contact to the list",
                ()
                        -> assertNotNull(contactService.getList().get(0).getContactID()),
                ()
                        -> assertEquals(contactID, contactService.getList().get(0).getContactID()),
                ()
                        -> assertEquals(firstName, contactService.getList().get(0).getFirstName()),
                ()
                        -> assertEquals(lastName, contactService.getList().get(0).getLastName()),
                ()
                        -> assertEquals(phoneNumber, contactService.getList().get(0).getPhoneNumber()),
                ()
                        -> assertEquals(address, contactService.getList().get(0).getAddress()),
                ()
                        -> assertThrows(Exception.class,
                        ()
                                -> contactService.addContact(contact1)),      //cant add a contactID that already exists
                ()
                        -> assertNotNull(contactService.getList().get(1).getContactID()),
                ()
                        -> assertEquals(contactID1, contactService.getList().get(1).getContactID()),
                ()
                        -> assertEquals(firstName1, contactService.getList().get(1).getFirstName()),
                ()
                        -> assertEquals(lastName1, contactService.getList().get(1).getLastName()),
                ()
                        -> assertEquals(phoneNumber1, contactService.getList().get(1).getPhoneNumber()),
                ()
                        -> assertEquals(address1, contactService.getList().get(1).getAddress()));
    }

    @Test
    void deleteContactTest() throws Exception {
        ContactService contactService = new ContactService();
        Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        Contact contact1 = new Contact(contactID1, firstName1, lastName1, phoneNumber1, address1);
        Contact contact2 = new Contact();
        contactService.addContact(contact);
        contactService.addContact(contact1);
        contactService.addContact(contact2);
        contactService.deleteContact(contactID1);
        assertAll("tests deleting contact from the list",
                ()
                        -> assertEquals(init, contactService.getList().get(1).getContactID()),
                ()
                        -> assertEquals(init, contactService.getList().get(1).getFirstName()),
                ()
                        -> assertEquals(init, contactService.getList().get(1).getLastName()),
                ()
                        -> assertEquals(initPhone, contactService.getList().get(1).getPhoneNumber()),
                ()
                        -> assertEquals(init, contactService.getList().get(1).getAddress()));
    }
    @Test
    void deleteContactTestNoID() throws Exception {
        ContactService contactService = new ContactService();
        Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        contactService.addContact(contact);
        assertAll("test deleting with bad contactID",
                ()
                        ->assertThrows(Exception.class,
                        ()
                                -> contactService.deleteContact(contactID1)));
    }

    @Test
    void updateContactFirstNameTest() throws Exception {
        ContactService contactService = new ContactService();
        Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        contactService.addContact(contact);
        contactService.updateContactFirstName(contactID, firstName1);
        assertAll("test updating first name",
                ()
                        ->assertEquals(firstName1, contactService.getList().get(0).getFirstName()),
                ()
                        ->assertThrows(Exception.class,
                        ()
                                ->contactService.updateContactFirstName(contactID1, firstName1)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->contactService.updateContactFirstName(contactID, null)));
    }

    @Test
    void updateContactLastNameTest() throws Exception {
        ContactService contactService = new ContactService();
        Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        contactService.addContact(contact);
        contactService.updateContactLastName(contactID, lastName1);
        assertAll("test updating last name",
                ()
                        ->assertEquals(lastName1, contactService.getList().get(0).getLastName()),
                ()
                        ->assertThrows(Exception.class,
                        ()
                                ->contactService.updateContactFirstName(contactID1, lastName1)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->contactService.updateContactLastName(contactID, null)));
    }

    @Test
    void updateContactPhoneNumberTest() throws Exception {
        ContactService contactService = new ContactService();
        Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        contactService.addContact(contact);
        contactService.updateContactPhoneNumber(contactID, phoneNumber1);
        assertAll("test updating phone number",
                ()
                        ->assertEquals(phoneNumber1, contactService.getList().get(0).getPhoneNumber()),
                ()
                        ->assertThrows(Exception.class,
                        ()
                                ->contactService.updateContactPhoneNumber(contactID1, phoneNumber1)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->contactService.updateContactPhoneNumber(contactID, null)));
    }

    @Test
    void updateContactAddressTest() throws Exception {
        ContactService contactService = new ContactService();
        Contact contact = new Contact(contactID, firstName, lastName, phoneNumber, address);
        contactService.addContact(contact);
        contactService.updateContactAddress(contactID, address1);
        assertAll("test updating address",
                ()
                        ->assertEquals(address1, contactService.getList().get(0).getAddress()),
                ()
                        ->assertThrows(Exception.class,
                        ()
                                ->contactService.updateContactAddress(contactID1, address1)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->contactService.updateContactAddress(contactID, null)));
    }

}
