package shoppingPriorityQueue;

public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>{

	private Node root;
    private int size;

    private class Node {
        T value;
        Node left, right;

        public Node(T value) {
            this.value = value;
        }
    }

    public PriorityQueue() {
        this.root = null;
        this.size = 0;
    }

    public void enqueue(T element) {
        root = insert(root, element);
        size++;
    }
    
    public int size() {
    	return size;
    }
    
    public T peek() {
    	if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
    	return root.value;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T highestPriority = root.value;
        root = deleteRoot(root);
        size--;
        return highestPriority;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node insert(Node node, T element) {
        if (node == null) {
            return new Node(element);
        }

        // Insert at the next available position in the tree
        // we do not worry if the child is less than or greater than 
        // for left and right sides, for this reason we alternate for insertion
        if (size % 2 == 0) {
            node.left = insert(node.left, element);
        } else {
            node.right = insert(node.right, element);
        }

        // Heapify by moving the larger child to the top
        if (node.left != null && node.left.value.compareTo(node.value) > 0) {
            node = rotateRight(node);
        } else if (node.right != null && node.right.value.compareTo(node.value) > 0) {
            node = rotateLeft(node);
        }

        return node;
    }

    private Node deleteRoot(Node node) {
        if (node.left == null && node.right == null) {
            return null;
        }

        // Swap with the larger child and delete recursively
        if (node.left != null && node.right != null) {
            if (node.left.value.compareTo(node.right.value) > 0) {
                node = rotateRight(node);
                node.right = deleteRoot(node.right);
            } else {
                node = rotateLeft(node);
                node.left = deleteRoot(node.left);
            }
        } else if (node.left != null) {
            node = rotateRight(node);
            node.right = deleteRoot(node.right);
        } else {
            node = rotateLeft(node);
            node.left = deleteRoot(node.left);
        }

        return node;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;

	}

}
