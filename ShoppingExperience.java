package shoppingPriorityQueue;
import java.util.*;

public class ShoppingExperience implements ShoppingExperienceInterface{
	
	private Store store;
	
	public ShoppingExperience(Store store) {
		this.store = store;
	}
	
	public void displayInventory() {
		//call the store's methods to display items, calculate total value, and display it
		System.out.println(store.displayItems());
		System.out.printf("Total retail value for " + store.getName() 
		+ ": $%.2f\n\n", store.getRetailValue());
		
	}
	
	public void shopping(ArrayList<Shopper> customers) {
		/*we randomly generate the number of items which the shopper buys as
		 * numItems, the itemID (which item she wants) as id, and how many of that
		 * item as quantity. to ensure that no shopper chooses the same item twice
		 * (for example: 3 bars of BF, 2 bars of PC, and 1 bar of BF) I created an array
		 * in which each index is incremented when that item is chosen. The random generator is
		 * only accepted if that index is 0 (it has never been chosen by that shopper yet)
		 * i then pass the item to the store, which passes it to the shopper
		*/
	Random random = new Random();
	System.out.println("\nEach woman shall now commence her shopping experience.\n");
	
	for (Shopper shopper: customers) {
		int numItems = random.nextInt(0, 5);
		int[] ensureItemIsNotRepeated = {0, 0, 0, 0, 0};
		System.out.println(shopper.getName() + " has purchased: ");
		for (int ind = 0; ind <= numItems; ind++) {
				purchase(ensureItemIsNotRepeated, shopper);
		}
		
		System.out.printf(shopper.getName() + " has spent a total of $%.2f\n\n", 
				shopper.getTotalPurchaseValue());
	}}
	
	public void purchase(int[] noRepeats, Shopper shopper) {
		Random random = new Random();
		int itemIDChoice = random.nextInt(0, 5);
		while(noRepeats[itemIDChoice] != 0) {
			itemIDChoice = random.nextInt(0, 5);
		}
		int InventoryID = itemIDChoice;
		noRepeats[InventoryID]++;
		//no customer can purchase more than 10 bars of each soap (the store has 100 bars of each)
		//to ensure that our store does not get depleted.
	int quantity = random.nextInt(1, 11);
	System.out.println(quantity + " bars of " + store.peekItemName(InventoryID));
		for (int j = 0; j < quantity; j++) {
				store.purchaseItem(InventoryID, shopper);
		}
	
	}
	
	
	public void checkout(ArrayList<Shopper> customers) {
		double discount = .2;
		double cutOff = 350;
		PriorityQueue<Shopper> checkoutq = new PriorityQueue<Shopper>();
	System.out.println(store.getName() + " is excited to begin our coupon program!\n"
+ "Customers who spend more than $350 will recieve a " + (discount*100) + "% discount at checkout.\n");
		
	for (Shopper s: customers) {
		//if the shopper qualifies, the discount is passed to her applyCoupon method
		//then we enqueues them into the priority queue
		if (s.getTotalPurchaseValue() > cutOff)
			s.applyCoupon(discount);
		checkoutq.enqueue(s);
	}
	
	//we dequeue and print each shopper according to her purchase value
	if(checkoutq.isEmpty()) {
		System.out.println("No shoppers have come to checkout today.");
	}
	while(!checkoutq.isEmpty()) {
		Shopper s = checkoutq.dequeue();
		System.out.printf(s.getName() + " has purchased " + s.getItemsPurchased() 
		+ " items and has spent a total of $%.2f\n", s.getTotalPurchaseValue());
	}
	}
}
