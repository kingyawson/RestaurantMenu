package WorldH;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }
    
    public List<MenuItem> getItems() {
        return items;
    }


    public double getTotalPrice() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    
    

    public String generateReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("Receipt:\n");
        for (MenuItem item : items) {
            sb.append(String.format("%s - %s - %.2f\n", item.getName(), item.getDescription(), item.getPrice()));
        }
        sb.append(String.format("Total: %.2f", getTotalPrice()));
        return sb.toString();
    }
}
