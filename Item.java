package shoppingPriorityQueue;

public class Item {
	private int itemID;
	private double price;
	private String name;
	
	public Item(String name, double price, int itemID) {
		this.name = name;
		this.price = price;
		this.itemID = itemID;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getID() {
		return itemID;
	}
	
	@Override
	public String toString() {
		String itemDescription = "Name: " + name + ". Price: $" + price + ". Item ID: " + itemID;
		return itemDescription;
	}

}
