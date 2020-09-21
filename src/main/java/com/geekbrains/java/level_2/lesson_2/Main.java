package com.geekbrains.java.level_2.lesson_2;

import com.geekbrains.java.level_2.lesson_2.Exeptions.Numbers;

public class Main {
    public static void main(String[] args) {
        String[][] numbers = {
                {"5", "-10", "24", "0"},
                {"-21", "32", "1", "11"},
                {"18", "0", "-1", "2"},
                {"0", "-15", "19", "-18"}
        };

        System.out.printf("Сумма элементов массива равна: %s.", Numbers.calculate(numbers));
    }
}
