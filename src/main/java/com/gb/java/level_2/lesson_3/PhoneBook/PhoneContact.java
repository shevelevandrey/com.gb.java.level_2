package com.gb.java.level_2.lesson_3.PhoneBook;

import java.util.Objects;

public class PhoneContact implements Contact {
    private String name;
    private String phone;

    public PhoneContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneContact that = (PhoneContact) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    @Override
    public String toString() {
        return "PhoneContact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
