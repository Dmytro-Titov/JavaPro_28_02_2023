package com.hillel.titov.lessons.lesson3.hw3;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("yuLLia", "aUlLIY"));

    }

    public static boolean isAnagram(String firstWord, String secondWord) {

        if (isValidWord(firstWord) && isValidWord(secondWord) && hasEqualLength(firstWord, secondWord)) {

            firstWord = firstWord.toLowerCase();
            secondWord = secondWord.toLowerCase();

            StringBuilder firstWordBuilder = new StringBuilder(firstWord);
            StringBuilder secondWordBuilder = new StringBuilder(secondWord);

            for (int i = 0; i < firstWordBuilder.length(); i++) {
                char characterOfFirstWord = firstWordBuilder.charAt(i);
                for (int j = 0; j < secondWordBuilder.length(); j++) {
                    char characterOfSecondWord = secondWordBuilder.charAt(j);
                    if (characterOfFirstWord == characterOfSecondWord) {
                        secondWordBuilder.deleteCharAt(j);
                        break;
                    }
                }
            }
            return secondWordBuilder.isEmpty();
        }
        return false;
    }

    private static boolean isValidWord(String word) {
        return word != null && word.length() >= 1;
    }

    private static boolean hasEqualLength(String firstWord, String secondWord) {
        return firstWord.length() == secondWord.length();
    }

}
