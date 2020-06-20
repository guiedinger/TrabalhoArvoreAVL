import java.util.ArrayList;

public class AVLTree<T> {
	private Node<T> root;
	
	public void printTree() {
		System.out.println(this.printTree(0, this.root));
	}
	
	private String printTree(int level, Node<T> node) {
		String print = node.toString() + "\n";
		
		for (int i = 0; i < level; i++) {
			print += "\t";
		}
		
		if (node.getLeft() != null) {
			print += "LEFT: " + this.printTree(level + 1, node.getLeft());
		} else {
			print += "LEFT: NULL";
		}
		
		print += "\n";
		
		for (int i = 0; i < level; i++) {
			print += "\t";
		}
		
		if (node.getRight() != null) {
			print += "RIGHT: " + this.printTree(level + 1, node.getRight());
		} else {
			print += "RIGHT: NULL";
		}
		
		print += "\n";
		
		return print;
	}
	
	public int search(T value) {
		Node<T> searched = this.search(value, this.root);
		if (searched == null) return -1;
		return searched.getKey();
	}
	
	private Node<T> search(T value, Node<T> node) {
		if (value == null || node == null) {
			return null;
		}
		
		if (node.equalsValue(value)) {
			return node;
		} else if(node.compareValue(value) > 0) {
			return search(value, node.getLeft());
		} else {
			return search(value, node.getRight());
		}
	}
	
	public ArrayList<Integer> searchInterval(T inferiorLimit, T upperLimit) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		searchInterval(indexes, this.root, inferiorLimit, upperLimit);
		return indexes;
	}

	private void searchInterval(ArrayList<Integer> indexes, Node<T> currentNode, T inferiorLimit, T upperLimit) {
		if (currentNode == null) {
			return;
		}
		int inferiorCompare = currentNode.compareValue(inferiorLimit);
		int upperCompare = currentNode.compareValue(upperLimit);
		
		if (inferiorCompare > 0 && upperCompare < 0) {
			indexes.add(currentNode.getKey());
			searchInterval(indexes, currentNode.getLeft(), inferiorLimit, upperLimit);			
			searchInterval(indexes, currentNode.getRight(), inferiorLimit, upperLimit);
		} else if(upperCompare >= 0) {
			searchInterval(indexes, currentNode.getLeft(), inferiorLimit, upperLimit);	
		} else if(inferiorCompare == 0) {
			searchInterval(indexes, currentNode.getRight(), inferiorLimit, upperLimit);
		}
		
		if (inferiorCompare == 0 || upperCompare == 0) {
			indexes.add(currentNode.getKey());
		}
	}

	
	public void insert(T value, int index) {
		Node<T>n = new Node<T>(value, index);
		insertAVL(this.root, n);
	}

	public void insertAVL(Node<T>toCompare, Node<T>toInsert) {

		if (toCompare == null) {
			this.root = toInsert;

		} else {
			int compareToValue = toInsert.compareTo(toCompare);
			if (compareToValue < 0) {

				if (toCompare.getLeft() == null) {
					toCompare.setLeft(toInsert);
					toInsert.setParent(toCompare);
					verifyBalance(toCompare);

				} else {
					insertAVL(toCompare.getLeft(), toInsert);
				}

			} else if (compareToValue > 0) {

				if (toCompare.getRight() == null) {
					toCompare.setRight(toInsert);
					toInsert.setParent(toCompare);
					verifyBalance(toCompare);

				} else {
					insertAVL(toCompare.getRight(), toInsert);
				}

			} else {
				// The node already exists
			}
		}
	}

	public void verifyBalance(Node<T>current) {
		setBalance(current);
		int balance = current.getBalance();

		if (balance == -2) {

			if (height(current.getLeft().getLeft()) >= height(current.getLeft().getRight())) {
				current = rightRotation(current);

			} else {
				current = doubleRightRotation(current);
			}

		} else if (balance == 2) {

			if (height(current.getRight().getRight()) >= height(current.getRight().getLeft())) {
				current = leftRotation(current);

			} else {
				current = doubleLeftRotation(current);
			}
		}

		if (current.getParent() != null) {
			verifyBalance(current.getParent());
		} else {
			this.root = current;
		}
	}

	public Node<T>leftRotation(Node<T>initial) {

		Node<T>right = initial.getRight();
		right.setParent(initial.getParent());

		initial.setRight(right.getLeft());

		if (initial.getRight() != null) {
			initial.getRight().setParent(initial);
		}

		right.setLeft(initial);
		initial.setParent(right);

		if (right.getParent() != null) {

			if (right.getParent().getRight() == initial) {
				right.getParent().setRight(right);
			
			} else if (right.getParent().getLeft() == initial) {
				right.getParent().setLeft(right);
			}
		}

		setBalance(initial);
		setBalance(right);

		return right;
	}

	public Node<T>rightRotation(Node<T>initial) {

		Node<T>left = initial.getLeft();
		left.setParent(initial.getParent());

		initial.setLeft(left.getRight());

		if (initial.getLeft() != null) {
			initial.getLeft().setParent(initial);
		}

		left.setRight(initial);
		initial.setParent(left);

		if (left.getParent() != null) {

			if (left.getParent().getRight() == initial) {
				left.getParent().setRight(left);
			
			} else if (left.getParent().getLeft() == initial) {
				left.getParent().setLeft(left);
			}
		}

		setBalance(initial);
		setBalance(left);

		return left;
	}

	public Node<T>doubleRightRotation(Node<T>initial) {
		initial.setLeft(leftRotation(initial.getLeft()));
		return rightRotation(initial);
	}

	public Node<T>doubleLeftRotation(Node<T>initial) {
		initial.setRight(rightRotation(initial.getRight()));
		return leftRotation(initial);
	}

	private int height(Node<T>current) {
		if (current == null) {
			return -1;
		}

		if (current.getLeft() == null && current.getRight() == null) {
			return 0;
		
		} else if (current.getLeft() == null) {
			return 1 + height(current.getRight());
		
		} else if (current.getRight() == null) {
			return 1 + height(current.getLeft());
		
		} else {
			return 1 + Math.max(height(current.getLeft()), height(current.getRight()));
		}
	}

	private void setBalance(Node<T>no) {
		no.setBalance(height(no.getRight()) - height(no.getLeft()));
	}

}
