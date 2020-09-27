package com.geekbrains.java.level_2.lesson_6;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> new GUI("127.0.0.1", 18443, 18444)).start();
        new Thread(() -> new GUI("127.0.0.1", 18444, 18443)).start();
    }
}
