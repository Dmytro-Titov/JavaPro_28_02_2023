package com.hillel.titov.lessons.lesson12;

import java.time.LocalDateTime;

public class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDateTime date;
    private int id;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public Product(String type, double price, boolean discount, LocalDateTime date) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public Product(String type, double price, boolean discount, LocalDateTime date, int id) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.date = date;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
