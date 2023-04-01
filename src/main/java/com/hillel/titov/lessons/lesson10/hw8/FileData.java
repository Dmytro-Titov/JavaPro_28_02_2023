package com.hillel.titov.lessons.lesson10.hw8;

public class FileData {
    private String name;
    private int byteSize;
    private String path;

    public FileData(String name, int byteSize, String path) {
        if (byteSize <= 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.byteSize = byteSize;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public int getByteSize() {
        return byteSize;
    }

    public String getPath() {
        return path;
    }
}
