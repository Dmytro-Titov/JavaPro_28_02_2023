package com.hillel.titov.lessons.lesson4.hw4.shapes;

public class Square implements ShapeArea {
    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return a * a;
    }
}
