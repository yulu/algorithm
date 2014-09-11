/*
 * Sep 11 cci 2.2
 */

public class KToLast {
	public static void main(String[] args) {
		Node list = new Node(0);

		for(int i = 0; i < 10; i++) 
			list.addToTail(i);

		list.print();
		
		System.out.println(GetKth(list, 5).value); 
	}

	static class Node {
		int value;
		Node next;

		public Node(int v){
			value = v;
		}

		public void addToTail(int v) {
			Node node = new Node(v);
			Node pt = this;
			while (pt.next != null) {
				pt = pt.next;
			}
			pt.next = node;
		}

		public void print() {
			Node pt = this;
			while(pt != null) {
				System.out.print(pt.value);
				pt = pt.next;
			}
			System.out.println();
		}
	}

	private static int Count(Node head) {
		int c = 0;
		Node pt = head;
		while( pt != null) {
			c++;
			pt = pt.next;
		}

		return c;
	}

	private static Node GetKth(Node head, int k) {
		int s = Count(head) - k;
		if(s < 0)
			return null;
		int c = 0;
		Node pt = head;
		while((c++) != s)
			pt = pt.next;

		return pt;
	}
}
