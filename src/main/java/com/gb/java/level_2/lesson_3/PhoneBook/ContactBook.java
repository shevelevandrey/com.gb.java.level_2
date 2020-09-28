package com.gb.java.level_2.lesson_3.PhoneBook;

import java.util.List;

public interface ContactBook {
    void add(Contact contact);
    List<Contact> get(String name);
}
