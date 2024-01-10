package shoppingPriorityQueue;
import java.util.*;

//for the sake of OOD, i have created a shopping experience interface
//to enforce the same functionality for all shopping experience programs

public interface ShoppingExperienceInterface {
	
	void displayInventory();
	void shopping(ArrayList<Shopper> customers);
	void checkout(ArrayList<Shopper> customers);
	
}
