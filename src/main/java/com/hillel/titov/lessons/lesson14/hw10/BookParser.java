package com.hillel.titov.lessons.lesson14.hw10;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookParser {
    private static boolean isExist;
    private static String bookName;
    private static Map<String, Integer> allWordsAndOccurrences = new HashMap<>();
    private static Map<String, Integer> tenMostPopularWordsAndOccurrences;
    static int uniqueWordsCount;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a book name:");
        bookName = scanner.nextLine();

        while (!isExist) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src" + File.separator + "main" + File.separator + "java" + File.separator + bookName + ".txt"))) {
                isExist = true;
                readFromReader(bufferedReader);
            } catch (IOException e) {
                System.out.println("Book is not found. Try again:");
                bookName = scanner.nextLine();
            } catch (BookReadingException e) {
                System.err.println(e.getMessage());
            }
        }
        countTenMostPopularWords();
        calculateUniqueWords();
        try {
            writeStatistic();
        } catch (WriteStatisticException e) {
            System.err.println(e.getMessage());
        }
        printStatistic();
    }

    public static void readFromReader(BufferedReader reader) throws BookReadingException {
        try {
            while (reader.ready()) {
                String lineFromReader = reader.readLine();
                String[] wordsFromReader = lineFromReader.split("[\\p{Punct}\\s]+");
                for (String word : wordsFromReader) {
                    word = word.toLowerCase();
                    if (allWordsAndOccurrences.containsKey(word)) {
                        allWordsAndOccurrences.put(word, allWordsAndOccurrences.get(word) + 1);
                    } else {
                        allWordsAndOccurrences.put(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new BookReadingException("Cannot read from " + bookName);
        }
    }

    public static void countTenMostPopularWords() {
        tenMostPopularWordsAndOccurrences = allWordsAndOccurrences.entrySet().stream()
                .filter(pair -> pair.getKey().length() > 2)
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldKey, newKey) -> oldKey, LinkedHashMap::new));
    }

    public static void calculateUniqueWords() {
        uniqueWordsCount = new HashSet<>(allWordsAndOccurrences.keySet()).size();
    }

    public static void writeStatistic() throws WriteStatisticException {
        try (PrintWriter printWriter = new PrintWriter("src" + File.separator + "main" + File.separator + "java" + File.separator + bookName + "_statistic.txt")) {
            for (Map.Entry<String, Integer> entry : tenMostPopularWordsAndOccurrences.entrySet()) {
                printWriter.println(entry.getKey() + " -> " + entry.getValue());
            }
            printWriter.println(uniqueWordsCount);
        } catch (IOException e) {
            throw new WriteStatisticException("Cannot write statistics of " + bookName);
        }
    }

    public static void printStatistic() {
        for (Map.Entry<String, Integer> entry : tenMostPopularWordsAndOccurrences.entrySet()) {
            System.out.format("%s -> %d\n", entry.getKey(), entry.getValue());
        }
        System.out.format("There are %d unique words in the %s book\n", uniqueWordsCount, bookName);
        System.out.println();
    }
}



