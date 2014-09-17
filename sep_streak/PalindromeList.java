public class PalindromeList {
	public static void main(String[] args) {
		Node list = new Node();
		list.addToTail(1);
		list.addToTail(2);
		list.addToTail(3);
		list.addToTail(3);
		list.addToTail(2);
		list.addToTail(1);	
		list = list.next;

		list.print();
		
		System.out.println(isPalindrome(list));
		
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
			Node pt = this;
			while ( pt != null ) {
				System.out.print(pt.value);
				pt = pt.next;
			}

			System.out.println();
		}
	}

	public static boolean isPalindrome(Node node) {
		Node r = Reverse(node);
		Node pt1 = r;
		Node pt2 = node;	
		
		while (pt1 != null && pt2 != null) {
			if(pt1.value != pt2.value)
				return false;
			pt1=pt1.next;
			pt2=pt2.next;
		}

		return true;
	}

	private static Node Reverse(Node node) {
		Node pt = node;
		Node r = null;
		Node tmp = null;

		while ( pt != null) {
			tmp = pt.next;
			pt.next = r;
			r = pt;
			pt = tmp;
		}

		return r;
	}
}
