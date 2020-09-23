package com.geekbrains.java.level_2.lesson_5.Concurrent;

import java.util.Arrays;

public class ArrayCalc {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] array = new float[SIZE];

    public void doOne() {
        long start = System.currentTimeMillis();
        Arrays.fill(array, 1);

        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long end = System.currentTimeMillis() - start;
        System.out.printf("Method \"%s\", took time: %s;%n%n", new Object(){}.getClass().getEnclosingMethod().getName(), end);
    }

    public void doTwo() {
        long start = System.currentTimeMillis();

        Arrays.fill(array, 1);

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        System.arraycopy(array, 0, arr1, 0, HALF);
        System.arraycopy(array, HALF, arr2, 0, HALF);

        Thread t1 = getThreadHandler(arr1);
        Thread t2 = getThreadHandler(arr2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            System.arraycopy(arr1, 0, array, 0, HALF);
            System.arraycopy(arr2, 0, array, HALF, HALF);

            long end = System.currentTimeMillis() - start;
            System.out.printf("Method \"%s\", took time: %s;%n%n", new Object(){}.getClass().getEnclosingMethod().getName(), end);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Thread getThreadHandler(float[] arr) {
        return new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is starting.");

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            System.out.println(threadName + " is end.");
        });
    }

}
