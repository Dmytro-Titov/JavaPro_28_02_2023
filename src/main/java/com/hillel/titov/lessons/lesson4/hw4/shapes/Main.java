package com.hillel.titov.lessons.lesson4.hw4.shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ShapeArea> shapes = new ArrayList<>();

        shapes.add(new Circle(2));
        shapes.add(new Triangle(3, 5));
        shapes.add(new Square(4.5));

        calculateSummaryArea(shapes);
    }

    public static void calculateSummaryArea(List<ShapeArea> shapes) {
        double summaryArea = 0.0;
        for (ShapeArea shape : shapes) {
            summaryArea += shape.area();
        }
        System.out.format("Summary area of shapes is %.2f\n", summaryArea);
    }
}
