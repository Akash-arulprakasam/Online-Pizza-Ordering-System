package services;

import models.Pizza;
import models.Order;
import java.util.*;
import java.io.*;

public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {
        orders.add(order);
        saveOrderToFile(order);
        System.out.println("✅ Order placed successfully!");
    }

    private void saveOrderToFile(Order order) {
        try (FileWriter writer = new FileWriter("data/orders.txt", true)) {
            writer.write(order.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }
}
