package com.gb.java.level_2.lesson_2.Exeptions;

public class Numbers {
    private static final int sizeArray = 4;

    public static int calculate(String[][] numbers) {
        int sum = 0;

        if (numbers.length != sizeArray) {
            throw new ArraySizeException(String.format("Длина массива не равна %s.", sizeArray));
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length != sizeArray) {
                throw new ArraySizeException(String.format("Длина вложенного массива, с индексом %s, не равна %s.", i, sizeArray));
            }

            for (int j = 0; j < numbers[i].length; j++) {
                try {
                    sum += Integer.parseInt(numbers[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(String.format("Значение: \"%s\", в ячейке: [%s][%s] - не соответствует числовому формату.", numbers[i][j], i, j), e);
                }
            }
        }

        return sum;
    }
}
