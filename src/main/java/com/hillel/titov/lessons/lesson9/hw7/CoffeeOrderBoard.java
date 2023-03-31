package com.hillel.titov.lessons.lesson9.hw7;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CoffeeOrderBoard {
    private PriorityQueue<Order> orders = new PriorityQueue<>(new Comparator<Order>() {
        @Override
        public int compare(Order order1, Order order2) {
            return order1.getOrderNumber() - order2.getOrderNumber();
        }
    });
    private int orderCounter = 0;

    public void add(String name) {
        orders.add(new Order(++orderCounter, name));
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order next = orders.poll();
            System.out.println(next);
        } else {
            System.out.println("No orders to be delivered");
        }

    }

    public void deliver(int number) {
        Order priority = null;
        for (Order order : orders) {
            if (order.getOrderNumber() == number) {
                priority = order;
                break;
            }
        }
        if (priority != null) {
            orders.remove(priority);
            System.out.println(priority);
        } else {
            System.out.println("This order doesn't exist");
        }
    }

    public void draw() {
        System.out.println("Num\t| Name");
        PriorityQueue<Order> copiedOrders = new PriorityQueue<>(orders);
        while (copiedOrders.peek() != null) {
            System.out.println(copiedOrders.poll());
        }
    }

}
