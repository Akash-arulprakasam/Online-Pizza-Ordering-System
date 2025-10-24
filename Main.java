import models.Pizza;
import models.Order;
import services.MenuService;
import services.OrderService;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        List<Pizza> cart = new ArrayList<>();

        System.out.println("🍕 Welcome to Java Pizza Ordering System!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        int choice;

        do {
            System.out.println("\n========= MAIN MENU =========");
            System.out.println("1. View Pizza Menu");
            System.out.println("2. Add Pizza to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    menuService.displayMenu();
                    break;

                case 2:
                    menuService.displayMenu();
                    System.out.print("Enter Pizza ID to add: ");
                    int id = sc.nextInt();
                    Pizza selected = menuService.getPizzaById(id);
                    if (selected != null) {
                        cart.add(selected);
                        System.out.println(selected.getName() + " added to cart!");
                    } else {
                        System.out.println("❌ Invalid pizza ID!");
                    }
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        System.out.println("🛒 Cart is empty!");
                    } else {
                        System.out.println("🛒 Your Cart:");
                        cart.forEach(p -> System.out.println("- " + p));
                    }
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("⚠️ No items in cart to checkout!");
                    } else {
                        Order order = new Order(name, cart);
                        orderService.placeOrder(order);
                        System.out.println(order);
                        cart.clear(); // empty the cart after order
                    }
                    break;

                case 5:
                    System.out.println("👋 Thank you for visiting! Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
