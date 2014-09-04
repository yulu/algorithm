/**
 * Sep 4
 */

public class Stack<Item> {
	private Item[] list;
	private int size;
	private int length;

	public Stack() {
		size = 0;
		length = 2;
		list = (Item[])new Object[length];
	}

	public void push(Item item) {
		if( (++size) == length) {
			length *= 2;
			Item[] tempList = (Item[])new Object[length];
			for(int i = 0; i < size - 1; i++)
				tempList[i] = list[i];
			list = tempList;
		}

		list[size-1] = item;
	}

	public Item pop() {
		if (size == 0)
			return null;

		Item item = list[--size];

		if(size < length/4) {
			length /= 4;
			Item[] tempList = (Item[])new Object[length];
			for(int i = 0; i < size; i++)
				tempList[i] = list[i];
			list = tempList;
		}

		return item;
	}

	public Boolean isEmpty() {
		return (size == 0);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		for(int i = 0; i < 50; i++)
			stack.push(i);

		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
}
