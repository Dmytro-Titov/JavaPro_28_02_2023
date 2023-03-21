package com.hillel.titov.lessons.lesson6.hw5;

import java.util.*;

public class Methods {

    public static void countOccurrence(List<String> words, String entryWord) {
        int count = 0;
        for (String word : words) {
            if (word.equals(entryWord)) {
                count++;
            }
        }
        System.out.format("The list contains %d instance(s) of the word \"%s\"\n", count, entryWord);
    }

    public static <T> List<T> toList(T[] dataForConversion) {
        List<T> convertedData = new ArrayList<>();
        for (T item : dataForConversion) {
            convertedData.add(item);
        }
        return convertedData;
    }

    public static List<Integer> findUnique(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        return uniqueNumbers;
    }

    public static void calcOccurrence(List<String> words) {
        List<String> uniqueWords = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String wordFromList = words.get(i);
            int count = 0;
            for (int j = 0; j < words.size(); j++) {
                if (wordFromList.equals(words.get(j))) {
                    count++;
                }
            }
            if (!uniqueWords.contains(wordFromList)) {
                uniqueWords.add(wordFromList);
                System.out.format("%s: %d\n", wordFromList, count);
            }
        }
    }


    public static List<WordOccurrence> findOccurrence(List<String> words) {
        List<String> uniqueWords = new ArrayList<>();
        List<WordOccurrence> wordOccurrences = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String wordFromList = words.get(i);
            int count = 0;
            for (int j = 0; j < words.size(); j++) {
                if (wordFromList.equals(words.get(j))) {
                    count++;
                }
            }
            if (!uniqueWords.contains(wordFromList)) {
                uniqueWords.add(wordFromList);
                wordOccurrences.add(new WordOccurrence(wordFromList, count));
            }
        }
        return wordOccurrences;
    }
}
