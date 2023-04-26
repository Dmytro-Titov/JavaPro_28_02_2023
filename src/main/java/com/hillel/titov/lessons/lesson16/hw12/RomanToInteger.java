package com.hillel.titov.lessons.lesson16.hw12;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static final Map<Character, Integer> ROMAN_NUMERALS = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String romanNumber) {
        int result = 0;
        char[] romanNumbers = romanNumber.toCharArray();
        for (int i = romanNumbers.length - 1; i >= 0; i--) {
            if ((romanNumbers[i] == 'I' && result > 3) ||
                    (romanNumbers[i] == 'X' && result > 30) ||
                    (romanNumbers[i] == 'C' && result > 300)) {
                result -= ROMAN_NUMERALS.get(romanNumbers[i]);
            } else {
                result += ROMAN_NUMERALS.get(romanNumbers[i]);
            }
        }
        return result;
    }
}
