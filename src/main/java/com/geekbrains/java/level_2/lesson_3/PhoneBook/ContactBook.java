package com.geekbrains.java.level_2.lesson_3.PhoneBook;

import java.util.List;
import java.util.Map;

public interface ContactBook {
    void add(Contact contact);
    List<Contact> get(String name);
}
