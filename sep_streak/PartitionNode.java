/*
 * Sep 12, cci 2.4
 * Can you use only one list instead of two??
 */
public class PartitionNode {
	public static void main(String[] args) {
		List input = new List();
		for(int i = 0; i < 10; i++)
			input.addToHead(i);

		input.print();

		List plist = partition(input, 5);
		plist.print();
	}

	private static List partition(List input, int x) {
			Node pt = input.head;
			List plist = new List();

			while (pt != null) {
				if (pt.value < x)
					plist.addToHead(pt.value);
				else
					plist.addToTail(pt.value);
				pt = pt.next;
			}

			return plist;
	}

	static class Node {
		int value;
		Node next;
		
		public Node(int v) {
			value = v;
		}
	}

	static class List {
		Node head;
		Node tail;

		public void addToHead(int v) {
			if(head != null) {
				Node n = new Node(v);
				n.next = head;
				head = n;
			} else {
				head = tail = new Node(v);
			}
		}

		public void addToTail(int v) {
			if(tail != null) {
				tail.next = new Node(v);
				tail = tail.next;
			}
			else
				head = tail = new Node(v);
		}

		public void print() {
			Node pt = head;
			while(pt != null) {
				System.out.print(pt.value);
				pt = pt.next;
			}
			System.out.println();
		}
	}

}	
