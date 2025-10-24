package models;

import java.util.List;

public class Order {
    private String customerName;
    private List<Pizza> pizzas;

    public Order(String customerName, List<Pizza> pizzas) {
        this.customerName = customerName;
        this.pizzas = pizzas;
    }

    public double calculateTotal() {
        return pizzas.stream().mapToDouble(Pizza::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Customer: " + customerName + " | Total: ₹" + calculateTotal();
    }
}
