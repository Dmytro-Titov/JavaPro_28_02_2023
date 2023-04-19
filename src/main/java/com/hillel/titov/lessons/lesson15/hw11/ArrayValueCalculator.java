package com.hillel.titov.lessons.lesson15.hw11;

public class ArrayValueCalculator {
    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] numbers = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            int sum = doCalc(numbers);
            System.out.println("Sum is " + sum);
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
    public static int doCalc(String[][] numbers) throws ArraySizeException, ArrayDataException {
        int result = 0;
        if (numbers.length != ARRAY_SIZE) {
            throw new ArraySizeException("Incompatible size of array");
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length != ARRAY_SIZE) {
                throw new ArraySizeException("Incompatible size of array");
            }
            for (int j = 0; j < numbers[i].length; j++) {
                try {
                    int number = Integer.parseInt(numbers[i][j]);
                    result += number;
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(String.format("Could not parse value at [%d][%d]", i, j));
                }
            }
        } return result;
    }
}
