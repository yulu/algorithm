/*
 * Sep 10, cci 2.1
 */
public class Duplications {

	public static void main(String[] args) {
		Node list = new Node(0);
		for(int i = 0; i < 10; i++) {
			list.appendToTail(i);
		}
		for(int i = 10; i > 0; i--) {
			list.appendToTail(i);
		}

		list.print();

		removeDup(list);
		list.print();
	}

	public static class Node {
		int i;
		Node next;
		
		public Node(int d){
			i = d;
		}

		public void appendToTail(int d) {
			Node end = new Node(d);
			Node pt = this;
			while(pt.next != null) {
				pt = pt.next;
			}
			pt.next = end;
		}

		public void print() {
			Node pt = this;
			while(pt != null) {
				System.out.print(pt.i);
				pt = pt.next;
			}
			System.out.println();
		}
	}

	public static void removeDup(Node head) {
		//start from the begining
		Node pt = head;
		Node prev = head;

		while( pt != null) {
			Node tmp = head;
			while (tmp != pt) {
				//if find duplications
				if(tmp.i == pt.i)
					break;
				tmp = tmp.next;
			}
			//if no dup is found
			if(tmp == pt) {
				prev = pt;
			}else{
			//if dup is found
				prev.next = pt.next;
			}	
			pt = pt.next;
		}
		
	}
}
