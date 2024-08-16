package com.ust;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryTest {

    ContactRepository repository;
    Contact contact1, contact2;

    @BeforeEach
    void setUp() {
        repository = new ContactRepository();
        contact1 = new Contact();
        contact2 = new Contact();
    }

    @AfterEach
    void tearDown() {
        repository = null;
        contact1 = null;
        contact2 = null;
    }

    @Test
    @DisplayName("Test generateId")
    void testGenerateId() {
        long id = repository.generateId();
        assertEquals(1, id, "First id should be 1");
    }

    @Test
    @DisplayName("Create a new contact")
    void saveNewContact() {
        var contact = repository.save("Ashish", "1234567890");
        assertEquals("Ashish", contact.getName(), "Name should be Ashish");
        assertTrue(contact.getPhoneNumbers().contains("1234567890"),
                "Phone number should be 1234567890");
    }

    @Test
    @DisplayName("Update an existing contact with a new phone number")
    void updateExistingContact() {
        repository.save("Ashish", "1234567890");
        var updatedContact = repository.save("Ashish", "0987654321");

        // Check if the name is updated
        assertEquals("Ashish", updatedContact.getName(),
                "Name should be Ashish");

        // Check if the phone there are 2 phone numbers in the contact
        assertEquals(2, updatedContact.getPhoneNumbers().size(),
                "Phone numbers should be 2");

        // Check if both contact numbers are present
        assertTrue(updatedContact.getPhoneNumbers().contains("1234567890"),
                "Phone number should be 1234567890");
        assertTrue(updatedContact.getPhoneNumbers().contains("0987654321"),
                "Phone number should contain 0987654321");
    }

    @Nested
    class FindContact {
        @Test
        @DisplayName("Find contact by id")
        void findContactById() throws ContactNotFoundException {
            var contact = repository.save("Ashish", "1234567890");
            var foundContact = repository.findById(contact.getId());
            assertEquals(contact, foundContact, "Contact should be found");
        }

        @Test
        @DisplayName("Find contact by id throws exception")
        void findContactByIdThrowsException() {
            var ex = assertThrows(ContactNotFoundException.class, () -> {
                repository.findById(1);
            });
            assertEquals("Contact with id 1 not found", ex.getMessage(),
                    "Exception message should be 'Contact not found'");
        }

        @Test
        @DisplayName("Find contact by phone number")
        void findContactByPhoneNumber() throws ContactNotFoundException {
            var contact = repository.save("Ashish", "1234567890");
            var foundContact = repository.findByPhoneNumber("1234567890");
            assertEquals(contact, foundContact, "Contact should be found");
        }

        @Test
        @DisplayName("Find contact by phone number throws exception")
        void findContactByPhoneNumberThrowsException() {
            var ex = assertThrows(ContactNotFoundException.class, () -> {
                repository.findByPhoneNumber("1234567890");
            });
            assertEquals("Contact not found", ex.getMessage(),
                    "Exception message should be 'Contact not found'");
        }

        @Test
        @DisplayName("Find contact by name")
        void findContactByName() throws ContactNotFoundException {
            var contact = repository.save("Ashish", "1234567890");
            var foundContact = repository.findByName("Ashish");
            assertEquals(contact, foundContact, "Contact should be found");
        }

        @Test
        @DisplayName("Find contact by name throws exception")
        void findContactByNameThrowsException() {
            var ex = assertThrows(ContactNotFoundException.class, () -> {
                repository.findByName("Ashish");
            });
            assertEquals("Contact not found", ex.getMessage(),
                    "Exception message should be 'Contact not found'");
        }


    }

}