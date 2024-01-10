package shoppingPriorityQueue;


public interface PriorityQueueInterface<T> {
	
	void enqueue(T element);
	T dequeue();
	int size();
	boolean isEmpty();
	T peek();

}
