
public class Node<T> implements Comparable<Node<T>> {
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	private int key;
	private int balance;
	private T value;

	public Node(T value, int index) {
		this.parent = null;
		this.left = null;
		this.right = null;
		this.balance = 0;
		this.key = index;
		this.value = value;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public int compareTo(Node<T> value) {
		return ((Comparable<T>) this.value).compareTo(value.getValue());
	}
	
	@SuppressWarnings("unchecked")
	public int compareValue(T value) {
		return  ((Comparable<T>) this.value).compareTo(value);
	}

	@Override
	public String toString() {
		return "[" + value  + "] (" + balance +")";
	}

	public boolean equalsValue(T value) {
		return this.compareValue(value) == 0;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
