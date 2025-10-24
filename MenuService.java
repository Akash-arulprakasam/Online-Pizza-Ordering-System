package services;

import models.Pizza;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<Pizza> menu = new ArrayList<>();

    public MenuService() {
        menu.add(new Pizza(1, "Margherita", 199));
        menu.add(new Pizza(2, "Farmhouse", 249));
        menu.add(new Pizza(3, "Peppy Paneer", 279));
    }

    public List<Pizza> getMenu() {
        return menu;
    }

    public void displayMenu() {
        System.out.println("---- PIZZA MENU ----");
        for (Pizza p : menu) {
            System.out.println(p);
        }
    }

    public Pizza getPizzaById(int id) {
        for (Pizza p : menu) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
