/*
 * Sep 4
 */

public class Queue<Item> {
	private Item[] list;
	private int capacity;
	private int head, tail, size;

	public Queue(int c) {
		capacity = c;
		list = (Item[]) new Object[c];
		head = tail = size = 0;
	}
	
	public Boolean isEmpty() {
		return (size == 0);
	}

	public void enqueue(Item item) {
		size++;
		if (size > capacity) {
			size--;
			//throw exception
			System.err.println("Out of capacity");
		}

		list[tail] = item;
		tail = (++tail)%capacity;
	}

	public Item dequeue() {
		if(isEmpty())
			return null;

		Item item = list[head];
		head = (++head)%capacity;
		size--;
		return item;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>(100);

		for(int i = 0; i < 100; i++)
			queue.enqueue(i);

		while(!queue.isEmpty())
			System.out.println(queue.dequeue());

	}
}

	
