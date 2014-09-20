/*
 * Sep 20, cci 3.2 pop, push, min in constant time
 * hint: do not use golable min, instead use local min
 * the head is associated with its own min. 
 */

public class LinkedListStack<Item extends Comparable<Item> > {
	class Node {
		Item item;
		Node next;
		Item min;

		public Node() {
		
		}

		public Node(Item item, Item min) {
			this.item = item;
			this.min = min;
		}

		public Node(Item item, Item min, Node next) {
			this.item = item;
			this.min = min;
			this.next = next;
		}
	}

	private Node head;
	
	public void push(Item item) {
		if (isEmpty()) {
			head = new Node(item, item);
		} else {
			if (item.compareTo(head.min) < 0)
				head = new Node(item, item, head);
			else
				head = new Node(item, head.min, head);
		}
	}

	public Item pop() {
		if (isEmpty()) 
			return null;

		Item i = head.item;
		head = head.next;
		
		return i;
	}

	public Item min() {
		return head.min;
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	public static void main(String[] args) {
		LinkedListStack<Integer> s = new LinkedListStack<Integer>();
		for (int i = 10; i > 0; i--) {
			s.push(i);
			System.out.print(i);
			System.out.print(" ");
			System.out.println(s.min());
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(s.min());
			System.out.print(" ");
			System.out.println(s.pop());
		}
	}
}
			
