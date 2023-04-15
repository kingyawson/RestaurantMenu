package WorldH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Menu {
	
	    private List<MenuItem> items;

	    public Menu() {
	        items = new ArrayList<>();
	    }

	    public void addItem(MenuItem item) {
	        items.add(item);
	    }
	    
	    public void addMenuItem(MenuItem item) {
	        items.add(item);
	    }
	    
	    public List<MenuItem> getAllItems() {
	        return items;
	    }


	    public void removeItem(MenuItem item) {
	        items.remove(item);
	    }
	    
	    public MenuItem searchForItem(String name) {
	        for (MenuItem item : items) {
	            if (item.getName().equals(name)) {
	                return item;
	            }
	        }
	        return null; // item not found
	    }
	    

	    public List<MenuItem> searchItems(String keyword) {
	        List<MenuItem> result = new ArrayList<>();
	        for (MenuItem item : items) {
	            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
	                result.add(item);
	            }
	        }
	        return result;
	    }

	    public Map<String, List<MenuItem>> getMenuByCategory() {
	        Map<String, List<MenuItem>> menuByCategory = new HashMap<>();
	        for (MenuItem item : items) {
	            String category = item.getCategory();
	            List<MenuItem> itemsInCategory = menuByCategory.getOrDefault(category, new ArrayList<>());
	            itemsInCategory.add(item);
	            menuByCategory.put(category, itemsInCategory);
	        }
	        return menuByCategory;
	    }

		


}
