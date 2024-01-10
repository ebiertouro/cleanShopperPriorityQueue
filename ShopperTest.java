package shoppingPriorityQueue;

import org.junit.jupiter.api.*;

class ShopperTest {
	
	
		PriorityQueue<Shopper> pq = new PriorityQueue<Shopper>();
		Shopper shopper = new Shopper("Betty");
		Shopper anotherShopper = new Shopper("Anne");

	@Test
	//test that it compares by name
	void test_compareWhenEqual() {
		shopper.addItem("item", 2.5);
		anotherShopper.addItem("anotherItem", 2.5);
		pq.enqueue(shopper);
		pq.enqueue(anotherShopper);
		Assertions.assertEquals(pq.dequeue(), anotherShopper);
	}

	@Test
	//test that it compares by totalPurchaseValue
	void test_compareWhenNotEqual() {
		shopper.addItem("item", 2.5);
		anotherShopper.addItem("anotherItem", 1);
		pq.enqueue(shopper);
		pq.enqueue(anotherShopper);
		Assertions.assertEquals(pq.dequeue(), shopper);
	}
	
	@Test
	void test_applyCoupon() {
		shopper.addItem(null, 100);
		shopper.applyCoupon(.2);
		Assertions.assertEquals(shopper.getTotalPurchaseValue(), 80);
	}
}
