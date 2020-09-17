package com.geekbrains.java.level_2.lesson_8;

import com.geekbrains.java.level_2.lesson_8.LinkedList.GeekbrainsIterator;
import com.geekbrains.java.level_2.lesson_8.LinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Toyota");
        singlyLinkedList.add("Honda");
        singlyLinkedList.add("Subaru");
        singlyLinkedList.add("Mazda");
        singlyLinkedList.add("Nissan");
        singlyLinkedList.add("Mitsubishi");

        System.out.println("---");
        System.out.println(singlyLinkedList);

        singlyLinkedList.remove("Toyota");
        singlyLinkedList.remove("Honda");

        System.out.println(singlyLinkedList);

        System.out.println("---");

        GeekbrainsIterator iterator = singlyLinkedList.getIterator();
        iterator.toFirst();
        System.out.printf("First node value = \"%s\"%n", iterator.getCurrent().getVal());

        iterator.byEnd();
        System.out.printf("Last node value = \"%s\"%n", iterator.getCurrent().getVal());

        System.out.println("---");

        iterator.toFirst();
        do {
            System.out.printf("Current node value = \"%s\"%n", iterator.getCurrent().getVal());
        } while (iterator.next());

        System.out.println("---");

        iterator.byEnd();
        do {
            System.out.printf("Current node value = \"%s\"%n", iterator.getCurrent().getVal());
        } while (iterator.prev());
    }
}
