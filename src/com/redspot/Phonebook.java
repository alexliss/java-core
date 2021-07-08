package com.redspot;

import java.util.HashMap;
import java.util.LinkedList;

public class Phonebook {
    private final HashMap<String, LinkedList<Long>> lastNameAndPhones = new HashMap<>();

    public Phonebook() {};

    public void add(String lastName, long phone) {
        LinkedList<Long> numbers = lastNameAndPhones.getOrDefault(lastName, new LinkedList<>());
        numbers.add(phone);
        lastNameAndPhones.put(lastName, numbers);
    }

    public LinkedList<Long> get(String lastName) {
        return lastNameAndPhones.get(lastName);
    }
}
