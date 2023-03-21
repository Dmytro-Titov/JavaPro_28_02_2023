package com.hillel.titov.lessons.lesson6.hw5;

import java.util.*;

public class Methods {

    public static void countOccurrence(List<String> list, String word) {
        int count = 0;
        for (String s : list) {
            if (s.equals(word)) {
                count++;
            }
        }
        System.out.format("The list contains %d instance(s) of the word \"%s\"\n", count, word);
    }

    public static <T> List<T> toList(T[] array) {
        List<T> result = new ArrayList<>();
        Collections.addAll(result, array);
        return result;
    }

    public static List<Integer> findUnique(List<Integer> list) {
        Set<Integer> uniqueNumbers = new HashSet<>(list);
        list.clear();
        list.addAll(uniqueNumbers);
        return list;
    }

    public static void calcOccurrence(List<String> list) {
        Map<String, Integer> words = addOccurrences(list);
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.format("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }


    public static List<WordOccurrence> findOccurrence(List<String> list) {
        Map<String, Integer> words = addOccurrences(list);
        List<WordOccurrence> wordOccurrences = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            wordOccurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        return wordOccurrences;
    }

    // The method below contains duplicate code and belongs to methods above only
    private static Map<String, Integer> addOccurrences(List<String> list) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : list) {
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }
        return words;
    }
}
