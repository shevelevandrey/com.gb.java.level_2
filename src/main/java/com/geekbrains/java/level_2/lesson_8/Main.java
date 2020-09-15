package com.geekbrains.java.level_2.lesson_8;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("Toyota");
        singlyLinkedList.add("Honda");
        singlyLinkedList.add("Subaru");
        singlyLinkedList.add("Mazda");

        System.out.println(singlyLinkedList);

        singlyLinkedList.remove("Subaru");

        System.out.println(singlyLinkedList);
    }
}
