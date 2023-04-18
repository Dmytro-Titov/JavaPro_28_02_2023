package com.hillel.titov.lessons.lesson12;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final String SELECTED_PRODUCT = "Book";
    public static final int SELECTED_YEAR = 2023;
    public static final double LIMIT_COST = 75.0;

    public static List<Product> getAllProducts(List<Product> products) {
        return products.stream()
                .filter(product -> SELECTED_PRODUCT.equals(product.getType()))
                .filter(product -> product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getAllProductsWithDiscount(List<Product> products) {
        return products.stream()
                .filter(product -> SELECTED_PRODUCT.equals(product.getType()))
                .filter(Product::isDiscount)
                .map(product ->
                {
                    product.setPrice(product.getPrice() * 0.9);
                    return product;
                })
                .collect(Collectors.toList());
    }

    public static Product getTheCheapestProduct(List<Product> products) {
        return products.stream()
                .filter(product -> SELECTED_PRODUCT.equals(product.getType()))
                .map(product ->
                {
                    if (product.isDiscount()) {
                        product.setPrice(product.getPrice() * 0.9);
                    }
                    return product;
                })
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException(String.format("Product %s is not found", SELECTED_PRODUCT)));
    }

    public static List<Product> getThreeLastProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .map(product ->
                {
                    if (product.isDiscount()) {
                        product.setPrice(product.getPrice() * 0.9);
                    }
                    return product;
                })
                .collect(Collectors.toList());
    }

    public static double getTotalCost(List<Product> products) {
        return products.stream()
                .filter(product -> product.getDate().getYear() == SELECTED_YEAR)
                .filter(product -> SELECTED_PRODUCT.equals(product.getType()))
                .map(product ->
                {
                    if (product.isDiscount()) {
                        product.setPrice(product.getPrice() * 0.9);
                    }
                    return product;
                })
                .filter(product -> product.getPrice() <= LIMIT_COST)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> transformProductsIntoMap(List<Product> products) {
        return products.stream()
                .collect(Collectors.toMap(Product::getType, value ->
                        {
                            ArrayList<Product> productValues = new ArrayList<>();
                            productValues.add(value);
                            return productValues;
                        },
                        (oldProduct, newProduct) ->
                        {
                            oldProduct.addAll(newProduct);
                            return oldProduct;
                        }));
    }
}
