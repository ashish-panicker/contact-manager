package com.ust;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private long id;
    private String name = "";
    private Set<String> phoneNumbers = new HashSet();

    public Contact(long id, String name,
                   String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumbers.add(phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }
}
