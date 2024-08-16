package com.ust;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Contact model tests")
class ContactTest {

    @Nested
    @DisplayName("Constructor tests")
    @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
    class ConstructorTests {
        @Test
        @DisplayName("Create a contact using the 3 arg constructor")
        void createContact() {
            // Given
            Contact contact = new Contact(1, "John Doe", "1234567890");
            // Then
            assertEquals(1, contact.getId());
            assertEquals("John Doe", contact.getName());
            assertTrue(contact.getPhoneNumbers().contains("1234567890"));
        }
        @Test
        @DisplayName("Create a contact using the empty constructor")
        void createContactEmptyConstructor() {
            // Given
            Contact contact = new Contact();
            // Then
            assertAll("Contact",
                    () -> assertEquals(0, contact.getId()),
                    () -> assertEquals("", contact.getName()),
                    () -> assertTrue(contact.getPhoneNumbers().isEmpty())
            );
        }
    }
}