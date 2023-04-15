package WorldH;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantDriver {
    public static void main(String[] args) {
        // Create some menu items
        MenuItem appetizer1 = new Appetizer("Spring Rolls", "Crispy vegetarian rolls with sweet chili sauce", 5.99);
        MenuItem appetizer2 = new Appetizer("Mozzarella Sticks", "Fried mozzarella sticks with marinara sauce", 6.99);
        MenuItem entree1 = new Entree("Pasta Alfredo", "Fettuccine pasta with creamy Alfredo sauce", 12.99);
        MenuItem entree2 = new Entree("Grilled Salmon", "Grilled salmon fillet with lemon butter sauce", 16.99);
        MenuItem dessert1 = new Dessert("Chocolate Cake", "Rich chocolate cake with chocolate ganache", 6.99);
        MenuItem dessert2 = new Dessert("Cheesecake", "New York style cheesecake with strawberry topping", 7.99);

        // Add the menu items to the menu
        Menu menu = new Menu();
        menu.addMenuItem(appetizer1);
        menu.addMenuItem(appetizer2);
        menu.addMenuItem(entree1);
        menu.addMenuItem(entree2);
        menu.addMenuItem(dessert1);
        menu.addMenuItem(dessert2);

        // Create some orders
        Order order1 = new Order();
        order1.addItem(appetizer1);
        order1.addItem(entree1);
        order1.addItem(dessert1);

        Order order2 = new Order();
        order2.addItem(appetizer2);
        order2.addItem(entree2);

        // Create the restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.addOrder(order1);
        restaurant.addOrder(order2);
        
        placeOrder(restaurant);

        // Generate a report
        String report = restaurant.generateReport();
        System.out.println(report);
    }
    
    
    
    public static void placeOrder(Restaurant restaurant) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            // display the menu
            restaurant.generateMenu();
            System.out.println("Enter the name of the item you want to order (or 'done' to finish ordering):");
            String itemName = scanner.nextLine();

            // check if the customer is done ordering
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }

            // search for the item in the menu
            MenuItem item = restaurant.getMenu().searchForItem(itemName);
            if (item == null) {
                System.out.println("Item not found. Please try again.");
                continue;
            }

            // add the item to the order
            order.addItem(item);
        }

        // calculate the total price of the order
        double totalPrice = order.getTotalPrice();

        // print the receipt
        System.out.println("Receipt:");
        for (MenuItem item : order.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total price: $" + totalPrice);
    }

}
