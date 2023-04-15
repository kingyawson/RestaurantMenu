package WorldH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private Menu menu;
    private List<Order> orders;

    public Restaurant() {
        menu = new Menu();
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public double getTotalSales() {
        double total = 0.0;
        for (Order order : orders) {
            total += order.getTotalPrice();
        }
        return total;
    }
    
    
    public void generateMenu() {
        for (MenuItem item : menu.getAllItems()) {
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Category: " + item.getCategory());
            System.out.println();
        }
    }
    
    
    
    public Menu getMenu() {
        return this.menu;
    }


    
    
    
    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean done = false;
        while (!done) {
            System.out.print("Enter item name (or 'done' to finish order): ");
            String itemName = scanner.nextLine();
            if (itemName.equals("done")) {
                done = true;
            } else {
                MenuItem item = menu.searchForItem(itemName);
                if (item != null) {
                    order.addItem(item);
                    System.out.println("Added " + item.getName() + " to order.");
                } else {
                    System.out.println("Item not found.");
                }
            }
        }
        orders.add(order);
        System.out.println("Order placed!");
        System.out.println("Total: " + order.getTotalPrice());
        order.generateReceipt();
        scanner.close();
    }
    
    

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report:\n");

        sb.append("Menu:\n");
        for (MenuItem item : menu.getAllItems()) {
            sb.append(String.format("%s - %s - %.2f - %s\n", item.getName(), item.getDescription(), item.getPrice(), item.getCategory()));
        }

        sb.append("Orders:\n");
        for (Order order : orders) {
            sb.append(order.generateReceipt());
            sb.append("\n");
        }

        sb.append(String.format("Total Sales: %.2f", getTotalSales()));
        return sb.toString();
    }
}

