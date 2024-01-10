package shoppingPriorityQueue;
import java.util.*;

public class ClientCode {
	public static void main(String[] args) {
		
		//instantiate a store, items, and shoppers, then pass them to the Shopping Experience
		Store store = new Store("The Scentarium", "soap");
		ArrayList<Shopper> customers = new ArrayList<Shopper>();
		ShoppingExperience shop = new ShoppingExperience(store);
		
		store.makeItem("Black Forest", 17.85);
		store.makeItem("Flower Burst", 12.69);
		store.makeItem("Desert Clay", 21.27);
		store.makeItem("Perfect Clean", 10.99);
		store.makeItem("Ocean Mist", 30.55);
		
		System.out.println(store.displayWelcomeMessage() + "\n");
		shop.displayInventory();
		
		Shopper herzka = new Shopper("Yenny Herzka");
		Shopper karfunkle = new Shopper("Rennee Karfunkle");
		Shopper zyskind = new Shopper("Estee Zyskind");
		Shopper freshwater = new Shopper("Avigail Freshwater");
		Shopper rechnitz = new Shopper("Tamar Rechnitz");
		
		customers.add(herzka);
		customers.add(karfunkle);
		customers.add(zyskind);
		customers.add(freshwater);
		customers.add(rechnitz);
		
		System.out.println("These are the wealthy women who are shopping in " 
		+ store.getName() + " today.\n");
		for (Shopper shopper: customers) {
			System.out.println(shopper.getName());
		}
		shop.shopping(customers);
		shop.checkout(customers);
		System.out.println("\nThank you for shopping in " + store.getName() + ", and be sure "
				+ "to recommend us as the finest " + store.getCategory() + " store. Have a nice day!");
	}

		
}
