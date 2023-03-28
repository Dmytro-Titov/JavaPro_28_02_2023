package com.hillel.titov.lessons.lesson8.hw6;

import java.util.*;

public class ThreeTasks {

    public static boolean isPalindrome(String textLine) {
        char[] textChars = textLine.toLowerCase().toCharArray();
        List<Character> alphanumericChars = new ArrayList<>();

        for (char textChar : textChars) {
            if (Character.isLetterOrDigit(textChar)) {
                alphanumericChars.add(textChar);
            }
        }
        if (alphanumericChars.size() < 1) {
            return true;
        }
        for (int i = 0; i <= alphanumericChars.size() / 2; i++) {
            Character charFromStart = alphanumericChars.get(i);
            Character charFromEnd = alphanumericChars.get(alphanumericChars.size() - 1 - i);
            if (!charFromStart.equals(charFromEnd)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsDuplicate(int[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            uniqueNumbers.add(number);
        }
        return numbers.length != uniqueNumbers.size();
    }

    public static int[] findTwoIndexesThatSumUpTarget(int[] numbers, int targetSumNumber) {
        int[] twoIndices = new int[]{-1, -1};
        for (int i = 0; i < numbers.length - 1; i++) {
            int firstNumber = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int secondNumber = numbers[j];
                if (firstNumber + secondNumber == targetSumNumber) {
                    twoIndices[0] = i;
                    twoIndices[1] = j;
                    return twoIndices;
                }
            }
        }
        return twoIndices;
    }
}
