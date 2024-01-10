package shoppingPriorityQueue;
import java.util.*;

public class Store {
	
	private String name;
	private String category;
	private int itemCount = 0;
	private double retailValue = 0;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private int quantityOfEachItem = 100;

	public Store(String name, String category){
		this.name = name;
		this.category = category;
	}
	
	public Store() {
		name = "The General Store";
		category = "General";
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}
	
	public String displayWelcomeMessage() {
		String welcomeMessage = "Welcome to " + name + ", the finest " + category
				+ " store! Enjoy your shopping experience, and have a lovely day.";
		return welcomeMessage;
	}
	
	//our store instantiates and stores items, giving each one an id number according to itemCount
	public void makeItem(String name, double price) {
		itemCount++;
		Item item = new Item(name, price, itemCount);
		retailValue += (item.getPrice()* quantityOfEachItem);
		itemList.add(item);	
	}
	
	public int getItemCount() {
		return itemCount;
	}
	
	//we subtract the item from the store and add it to the shoppers addItem method
	public void purchaseItem(int index, Shopper shopper) {
		Item item = itemList.get(index);
		shopper.addItem(item.getName(), item.getPrice());
		retailValue -= item.getPrice();
	}
	
	//display an inventory of all items in the store
	public StringBuilder displayItems() {
		StringBuilder inventory = new StringBuilder("Inventory: \n");
		for(Item item: itemList) {
			inventory.append(item + "\n");
		}
		return inventory;
	}
	
	public Item peekItemToString(int index) {
		return itemList.get(index);
	}
	
	public String peekItemName(int index) {
		return itemList.get(index).getName();
	}
	
	public double getRetailValue() {
		return retailValue;
	}
	
	@Override
	public String toString() {
		String storeDescription = "Store: " + name + " . Category: " + category;
		return storeDescription;
	}
}
