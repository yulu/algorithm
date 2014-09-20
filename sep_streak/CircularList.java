/*
 * Sep 17, cci 2.6
 */

public class CircularList {
	public static void main(String[] args) {
		Node c = new Node();
		Node tmp = new Node();
		for(int i = 0; i < 5; i++) {
			c.addToTail(i);

		}

		c.print();
	
		//get the node at middle	
		Node pt = c;
		for(int i = 0; i < 3; i++)
			pt = pt.next;

		tmp = pt;
		tmp.print();

		//put the tmp node at the end
		pt = c;

		while(pt.next != null) {
			pt = pt.next;
		}

		pt.next = tmp;


		System.out.println(getNode(c).value);
	}


	static class Node {
		int value;
		Node next;
		

		public Node() {
		
		}

		public Node(int v) {
			value = v;
		}

		public void addToHead(int v) {
			Node pt = this;
			Node newP = new Node(v);
		
			newP.next = this.next;
			this.next = newP;
		}

		public void addToTail(int v) {
			Node pt = this;
			while ( pt.next != null ) {
				pt = pt.next;
			}

			pt.next = new Node(v);
		}

		public void print() {
			Node pt = this.next;
			while ( pt != null ) {
				System.out.print(pt.value);
				pt = pt.next;
			}

			System.out.println();
		}
	}

	public static Node getNode(Node head) {
		Node pt = head.next;
		if(pt.next != null)
			pt = pt.next;
		else
 			return null;

		Node prev = head.next;
		while (pt.next != null) {
			//get the head to loop from head to prev to find dup
			Node tmp = head.next; 

			while (tmp != prev) {
				if (tmp == pt)
					return pt;
				tmp = tmp.next;
			}

			//check if the prev is pt, (point to itself)
			if(tmp == pt)
				return pt;
	
			prev = pt;
			pt = pt.next;
		}

		return null;
	}
}
