package shoppingPriorityQueue;

import org.junit.jupiter.api.*;

class StoreTest {
	Store store;
	Shopper shopper;
	
	@BeforeEach
	void instantiateStore() {
		store = new Store();
		store.makeItem("A", 10);
		store.makeItem("B", 20);
		shopper = new Shopper("S");
	}

	@Test
	void test_itemCount() {
		Assertions.assertEquals(store.getItemCount(), 2);
	}
	
	@Test
	void test_RetailValue() {
		Assertions.assertEquals(store.getRetailValue(), 3000);
	}
	
	@Test
	void test_purchaseItemAddsToShopper() {
		store.purchaseItem(0, shopper);
		Assertions.assertEquals(shopper.getItemsPurchased(), 1);
		
	}

	@Test
	void test_purchaseItemSubtractsFromTotal() {
		store.purchaseItem(0, shopper);
		Assertions.assertEquals(store.getRetailValue(), 2990);
	}
}
