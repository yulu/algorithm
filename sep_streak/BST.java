/**
 * Sep 3 2014
 */

public class BST<Item extends Comparable<Item> > {
	private Node root;
	
	private class Node {
		Node left;
		Node right;
		Item item;
		public Node(Item item) {
			this.item = item;
		}

	}

	//put node
	public void put(Item item) {
		root = put(item, root);
	}

	//put node recursively
	private Node put(Item item, Node x) {
		if (x == null)
			return new Node(item);

		int cmp = item.compareTo(x.item);
		if     (cmp < 0) x.left = put(item, x.left);
		else if(cmp > 0) x.right = put(item, x.right);
		else 		 x.item = item;
	
		return x;
	}

	//deletion
	public void delete(Item item) {
		root = delete(item, root);
	}

	//Hibbard deletion
	private Node delete(Item item, Node x) {
		if (x == null)
			return null;
		
		int cmp = item.compareTo(x.item);
		if	(cmp < 0) x.left = delete(item, x.left);
		else if	(cmp > 0) x.right = delete(item, x.right);
		else {
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}

		return x;
	}

	//min 
	private Node min(Node x) {
		Node t = x;
		while(t.left != null)
			t = t.left;

		return t;	
	}

	//delete min recursively
	private Node deleteMin(Node x) {
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		return x;
	}

	public void print() {
		printInorder(root);
	}

	//traverse
	private void printInorder (Node x) {
		if (x == null)
			return;
		System.out.println(x.item);
		printInorder(x.left);
		printInorder(x.right);
	}

	/*
	 * test program
	 */
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		for(int i = 0; i < 10; i++ ) {
			bst.put(10+i);
			bst.put(i);
		}
		bst.print();
		bst.delete(5);
		bst.print();
	}
}	
