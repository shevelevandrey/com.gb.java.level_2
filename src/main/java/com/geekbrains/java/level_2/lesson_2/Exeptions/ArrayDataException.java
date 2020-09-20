package com.geekbrains.java.level_2.lesson_2.Exeptions;

public class ArrayDataException extends RuntimeException {
    public ArrayDataException(String message) {
        super(message);
    }

    public ArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
