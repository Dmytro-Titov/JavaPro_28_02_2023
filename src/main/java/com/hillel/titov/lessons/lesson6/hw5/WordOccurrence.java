package com.hillel.titov.lessons.lesson6.hw5;

public class WordOccurrence {
    private String name;
    private int occurrence;

    public WordOccurrence(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "\n{name: \""
                + name + "\", occurrence: "
                + occurrence +
                "}";
    }
}
