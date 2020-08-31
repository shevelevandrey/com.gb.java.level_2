package com.geekbrains.java.level_2.lesson_3.PhoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PhoneBook implements ContactBook {

    List<Contact> book;

    public PhoneBook() {
        this.book = new ArrayList<>();
    }

    public PhoneBook(List<Contact> book) {
        this.book = book;
    }

    @Override
    public void add(Contact contact) {
        book.add(contact);
    }

    @Override
    public List<Contact> get(String name) {
        List<Contact> filteredBook = new ArrayList<>();

        for (Contact contact : book) {
            if (contact.getName().contains(name)) {
                filteredBook.add(contact);
            }
        }

        return filteredBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(book, phoneBook.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}
