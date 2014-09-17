/*
 * Sep 12, cci 2.5
 */

public class SummationNode {

	public static void main(String[] args) {
		Node list1 = new Node();
		list1.addToTail(1);
		list1.addToTail(7);
		list1.addToTail(9);
		list1.print();

		Node list2 = new Node();
		list2.addToTail(8);
		list2.addToTail(4);
		list2.addToTail(6);
		list2.print();

		Node s = Sum(list1, list2);
		s.print();
		
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

	private static Node Sum(Node s1, Node s2) {
		Node pt1 = s1.next;
		Node pt2 = s2.next;
		Node sum = new Node();
		int r = 0; //remining digit from the previous

		while (pt1 != null || pt2 != null || r != 0) {
			int d1 = 0;
			int d2 = 0;

			if (pt1 != null) {
				d1 = pt1.value;
				pt1 = pt1.next;
			}
			if (pt2 != null) {
				d2 = pt2.value;
				pt2 = pt2.next;
			}
			
			int d3 = (d1+d2+r)%10;
			r = (d1+d2+r)/10;

			sum.addToTail(d3);

		}
	
		return sum;
	}
/*
	private static Node Sum2(Node s1, Node s2) {
		//find the length of the two list
		
		//make them equal length by adding 0s in front of the shorter one

		//recursive add the nodes

		//check the leading digit

		//remove the tail node
		

	}
*/
	private static Node SumDigit(Node head1, Node head2) {
		if (head1 == null && head2 == null)
			return new Node();

		Node h=SumDigit(head1.next, head2.next);
		int d = head1.value + head2.value + h.value/10;
		h.value = h.value%10;
		h.addToHead(d);

		return h;
	}

	private static int findLength(Node n) {
		Node pt = n.next;
		int c = 0;
		while(pt.next != null) {
			pt = pt.next;
			c++;
		}

		return c;
	}

			
}
