package com.hillel.titov.lessons.lesson4.hw4.shapes;

public class Triangle implements ShapeArea {
    private double h;
    private double a;

    public Triangle(double h, double a) {
        this.h = h;
        this.a = a;
    }

    @Override
    public double area() {
        return 0.5 * a * h;
    }
}
