package com.ust;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactTest {

    @Test
    @DisplayName("Create a contact using the constructor")
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
        assertEquals(0, contact.getId());
        assertEquals("", contact.getName());
        assertTrue(contact.getPhoneNumbers().isEmpty());
    }
}