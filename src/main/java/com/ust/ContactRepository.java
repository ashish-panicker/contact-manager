package com.ust;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ContactRepository {

    private List<Contact> contacts = new LinkedList<>();

    public long generateId() {
        long id = contacts.stream().map(Contact::getId).max(Long::compare).orElse(0L);
        return id + 1;
    }

    public Contact save(String name, String phoneNumber) {
        Optional<Contact> existingContactOpt = contacts.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
        if (existingContactOpt.isPresent()) {
            var existingContact = existingContactOpt.get();
            existingContact.setPhoneNumber(phoneNumber);
            return existingContact;
        }
        Contact contact = new Contact(generateId(), name, phoneNumber);
        contacts.add(contact);
        return contact;
    }

    public Contact findById(long id) throws ContactNotFoundException {
        return contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException("Contact with id " + id + " not found"));
    }

    public Contact findByPhoneNumber(String phoneNumber) throws ContactNotFoundException {
        return contacts.stream()
                .filter(c -> c.getPhoneNumbers().contains(phoneNumber))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    }

    public Contact findByName(String name) throws ContactNotFoundException {
        return contacts.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException("Contact not found"));
    }

}
