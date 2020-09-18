package com.geekbrains.java.level_2.lesson_8.LinkedList;

public interface GeekbrainsIterator {
    boolean next();
    boolean prev();
    Node getCurrent();
    void toFirst();
    void byEnd();
}
