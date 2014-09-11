/*
 * sep 11, cci 2.3
 */

public class DeleteNode {
	public static void main(String[] args) {
		Node list = new Node(0);
		Node del = null; //node to delete

		for(int i = 1; i < 10; i++) {
			Node node = new Node(i);
			Node pt = list;
			while (pt.next != null)
				pt = pt.next;
			pt.next = node;
	
			if(i == 5)
				del = node;
		}

		list.print();
		list.delete(del);
		list.print();
	}

	static class Node {
		int value;
		Node next;

		public Node(int v) {
			value = v;
		}

		public void addToTail(int v) {
			Node node = new Node(v);
			Node pt = this;
			while (pt != null) 
				pt = pt.next;

			pt.next = node;
		}

		public void delete(Node node) {
			Node pt = this;
			Node prev = this;
			while(pt != null) {
				if(pt == node) 
					prev.next = pt.next;
				else
					prev = pt;
				pt = pt.next;
			}
		}	

		public void print() {
			Node pt = this;
			while (pt != null){
				System.out.print(pt.value);
				pt = pt.next;
			}
			System.out.println();
		}
	}

	
}	
