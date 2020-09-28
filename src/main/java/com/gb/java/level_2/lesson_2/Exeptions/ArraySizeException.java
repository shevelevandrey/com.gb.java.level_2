package com.gb.java.level_2.lesson_2.Exeptions;

public class ArraySizeException extends RuntimeException {
    public ArraySizeException(String message) {
        super(message);
    }

    public ArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
