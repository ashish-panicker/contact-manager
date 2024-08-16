package com.ust;

import java.util.LinkedList;
import java.util.List;

public class ContactRepository {

    private List<Contact> contacts = new LinkedList();

    private long generateId() {
        // TODO
    }

    public Contact save(Contact contact) {
        // TODO
    }

    public Contact findById(String id) throws ContactNotFoundException {
        // TODO
    }

    public List<Contact> findByPhoneNumber(String phoneNumber) throws ContactNotFoundException {
        // TODO
    }

    public List<Contact> findByName(String name) throws ContactNotFoundException {
        // TODO
    }

}
