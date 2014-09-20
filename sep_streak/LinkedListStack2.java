/*
 * Sep 20, cci 3.2 better solution
 * use a seperate stack to store the min values. If new min is pushed, update
 * the min stack by push this value to the min stack
 * if the top value on the min stack is popped out, pop the min stack as well
 */

public class LinkedListStack2<Item extends Comparable<Item> > {
	class Node {
		Item item;
		Node next;
		
		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node minHead;
	private Node head;

	public void push(Item item) {
		if (isEmpty()) {
			head = new Node(item, null);
			minHead = new Node(item, null);
		} else {
			if (item.compareTo(minPeek()) < 0)
				minPush(item);

			head = new Node(item, head);
		}
	}

	public Item pop() {
		if (isEmpty()) 
			return null;

		Item i = head.item;

		if(i.compareTo(minPeek()) == 0)
			minPop();

		head = head.next;

		return i;
	}

	public Item min() {
		return minPeek();
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public Item minPeek() {
		if (minHead == null)
			return null;
		return minHead.item;
	}

	public void minPush(Item item) {
		if (minHead == null)
			minHead = new Node(item, null);
		else
			minHead = new Node(item, minHead);
	}

	public Item minPop() {
		if (minHead == null)
			return null;

		Item i = minHead.item;
		minHead = minHead.next;
		return i;
	}

	public static void main(String[] args) {
		LinkedListStack2<Integer> s = new LinkedListStack2<Integer>();

		for(int i = 10; i > 0; i--) {
			s.push(i);
			System.out.print(i);
			System.out.print(" ");
			System.out.println(s.min());
		}

		for(int i =0; i < 10; i++) {
			System.out.print(s.min());
			System.out.print(" ");
			System.out.println(s.pop());
		}
	}			
}
