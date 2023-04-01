package com.hillel.titov.lessons.lesson9.hw7;

public class Order {
    private int orderNumber;
    private String name;

    public Order(int orderNumber, String name) {
        this.orderNumber = orderNumber;
        this.name = name;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return String.format("%d\t| %s", orderNumber, name);
    }
}
