/*
 * Sep 10, cci 2.1
 */
public class Duplications {
	public static void main(String[] args) {

	}

	class Node {
		int i;
		Node next;
	}

	public static void removeDup(Node head) {
		Set tmp = new Set();
		//start from the begining
		Node pt = head;
		Node prev = head;
		tmp.add(head.i);

		while( pt != null) {
			//check dup
			if(tmp.contains(pt.next.i)) {
				prev.next = pt.next;	
			}else{
				prev = pt;
			}	
			pt = pt.next;
		}
		
	}
}
