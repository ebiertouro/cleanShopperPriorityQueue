package shoppingPriorityQueue;
import java.util.*;

public class Shopper implements Comparable<Shopper>{
	private String name;
	private int itemsPurchased = 0;
	private double totalPurchaseValue = 0;
	private ArrayList<String> purchaseList = new ArrayList<String>();
	
	public Shopper(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	//we keep track of how many items were purchased and their names, although not used in this
	//program, to make our code reusable. we add the price of the purchased item to the total 
	//that our shopper has spent so far.
	public void addItem(String itemName, double price) {
		itemsPurchased++;
		totalPurchaseValue += price;
		purchaseList.add(itemName);
	}
	public int getItemsPurchased() {
		return itemsPurchased;
	}
	
	public ArrayList<String> getItemsPurchasedList(){
		return purchaseList;
	}
	public double getTotalPurchaseValue() {
		return totalPurchaseValue;
	}
	
	//we apply a coupon to decrease how much the shopper is spending
	public void applyCoupon(double discountPercentage) {
		totalPurchaseValue *= (1 - discountPercentage);
	}
	
	 @Override 
	 //we compare the total purchase value to get the shopper's priority
	 //if they have the same purchase value, we compare them alphabetically
	 public int compareTo(Shopper shopper1) {
		 if(this.totalPurchaseValue == shopper1.getTotalPurchaseValue()) {
			 if(this.name.compareTo(shopper1.name) < 0) {
				 return 1;
			 }
			 else
				 return -1;
		 }
		 if(this.totalPurchaseValue > shopper1.getTotalPurchaseValue())
			 return 1;
		 else if (this.totalPurchaseValue < shopper1.getTotalPurchaseValue())
			 return -1;
		 return 0;
		
	 }
}
