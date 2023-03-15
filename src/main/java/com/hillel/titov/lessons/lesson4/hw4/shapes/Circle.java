package com.hillel.titov.lessons.lesson4.hw4.shapes;

public class Circle implements ShapeArea{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }
}
